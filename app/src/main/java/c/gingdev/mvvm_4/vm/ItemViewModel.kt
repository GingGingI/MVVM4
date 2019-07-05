package c.gingdev.mvvm_4.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * itemView의 ViewModel
 */

class ItemViewModel(name: String, content: String) : ViewModel() {
    val name = ObservableField<String>()
    val content = ObservableField<String>()

    init {
        this.name.set(name)
        this.content.set(content)
    }
}