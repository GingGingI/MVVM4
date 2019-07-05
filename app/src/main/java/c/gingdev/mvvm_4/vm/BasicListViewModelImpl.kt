package c.gingdev.mvvm_4.vm

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel

/**
 * Listholder를 재사용하기위해 미리 지정해둔 ViewModel
 */

class BasicListViewModelImpl<ITEM: ViewModel>: ViewModel(), BasicListViewModel<ITEM> {
    override var list = ObservableArrayList<ITEM>()

    override fun addItem(item: ITEM) {
        list.add(item)
    }
}