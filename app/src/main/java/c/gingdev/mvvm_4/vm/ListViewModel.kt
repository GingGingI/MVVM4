package c.gingdev.mvvm_4.vm

import android.util.Log
import kotlin.random.Random

/**
 * ListView의 ViewModel
 */

class ListViewModel : BasicListViewModel<ItemViewModel> by BasicListViewModelImpl() {
    fun addListItem() {
        addItem(ItemViewModel(RandomName(), "hello"))
//        testLog()
    }

    private fun RandomName(): String {
        return when(Random.nextInt(5)) {
            0 -> {
               "1"
            }
            1 -> {
                "2"
            }
            3 -> {
                "3"
            }
            4 -> {
                "4"
            }
            else -> {
                "5"
            }
        }
    }

    private fun testLog() {
        Log.e("item","added - ${list.last().name.get()}, ${list.last().content.get()}")
        Log.i("List", "[")
        list.forEach {itemViewModel -> Log.i("List", "${itemViewModel.name.get()}, ${itemViewModel.content.get()}") }
        Log.i("List", "]")
    }
}