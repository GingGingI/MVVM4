package c.gingdev.mvvm_4.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Binding을 Generic으로 가져옮 (예: ActivityMainBinding)
 * LayoutRes 와 BindingId를 받아옴 (예: item_layout의 variable의 name)
 *
 * 받아온 Binding을 holder에서 생성한 itemView에 지정
 * bind에서 ListVM에있는 itemVM을 itemView의 variable에 할당.
 */

abstract class listHolder<BINDING: ViewDataBinding>(
    @LayoutRes layoutResId: Int,
    parent: ViewGroup,
    val bindingVariableId: Int?)
    :RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)) {
    protected val binding: BINDING = DataBindingUtil.bind(itemView)!!

    fun bind(vm: Any?) {
        bindingVariableId?.let {
            binding.setVariable(it, vm)
        }
    }
}