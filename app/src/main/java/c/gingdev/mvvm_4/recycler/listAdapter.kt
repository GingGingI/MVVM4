package c.gingdev.mvvm_4.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.mvvm_4.vm.ListViewModel

/**
 * itemVM을 가지고있는 BasicListViewModel을 정의한 ListViewModel을 받아옴,
 * LayoutRes랑 ListItem의 Layout에있는 variable의 name 정보를 가져옴
 *
 * init에서는 ListVM의 itemVM을 담고있는 List에 Observer를 할당하여 변화를 감지. 리스트 추가, 삭제
 */

abstract class listAdapter<VM: ListViewModel, BINDING: ViewDataBinding>(
    private val listViewModel: VM?,
    @LayoutRes private val layoutRes: Int,
    private val bindingVariableId: Int? = null)
    : RecyclerView.Adapter<listHolder<BINDING>>() {

    init {
        listViewModel!!.list.addOnListChangedCallback(
            object: ObservableList.OnListChangedCallback<ObservableList<ViewModel>>() {
            override fun onChanged(sender: ObservableList<ViewModel>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeRemoved(sender: ObservableList<ViewModel>?, positionStart: Int, itemCount: Int) {
                onItemRangeRemoved(sender, positionStart, itemCount)
            }

            override fun onItemRangeMoved(
                sender: ObservableList<ViewModel>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onItemRangeInserted(sender: ObservableList<ViewModel>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeInserted(positionStart,itemCount)
            }

            override fun onItemRangeChanged(sender: ObservableList<ViewModel>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeChanged(positionStart, itemCount)
            }

        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listHolder<BINDING> =
        object: listHolder<BINDING>(
            layoutResId = layoutRes,
            parent = parent,
            bindingVariableId = bindingVariableId){}

    override fun getItemCount(): Int
            = listViewModel?.list?.size ?: 0

    override fun onBindViewHolder(holder: listHolder<BINDING>, position: Int) {
        holder.bind(listViewModel!!.list[position])

        holder.itemView.setOnClickListener {
            listViewModel.list[position].name.set("앙 눌렸띠")
        }
    }
}