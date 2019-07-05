package c.gingdev.mvvm_4.vm

import androidx.databinding.ObservableArrayList

interface BasicListViewModel<ITEM> {
    var list: ObservableArrayList<ITEM>

    fun addItem(item: ITEM)
}