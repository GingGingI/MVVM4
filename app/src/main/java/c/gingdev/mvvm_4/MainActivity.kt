package c.gingdev.mvvm_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import c.gingdev.mvvm_4.databinding.ActivityMainBinding
import c.gingdev.mvvm_4.databinding.ListItemBinding
import c.gingdev.mvvm_4.recycler.listAdapter
import c.gingdev.mvvm_4.vm.ListViewModel

/**
 *
 * MainActivity 에서 Binding 지정후 ListViewModel 넣고
 * 어뎁터에다가 해당 ListViewModel을 넣음.
 *
 */

class MainActivity : AppCompatActivity() {

    private val listVM = ListViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.run {
            model = listVM

            val adapter: listAdapter<ListViewModel, ListItemBinding> =
                    object: listAdapter<ListViewModel, ListItemBinding>(
                        listViewModel = this.model,
                        layoutRes = R.layout.list_item,
                        bindingVariableId = BR.item) {}

            lifecycleOwner = this@MainActivity
            recycler.adapter = adapter
        }
    }
}
