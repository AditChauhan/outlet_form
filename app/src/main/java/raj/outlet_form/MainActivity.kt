package raj.outlet_form

import android.app.LauncherActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import raj.outlet_form.data.Field
import raj.outlet_form.data.Quote
import raj.outlet_form.databinding.ActivityMainBinding
import raj.outlet_form.ui.*
import raj.outlet_form.utilities.InjectorUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var injector: InjectorUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = (R.layout.activity_main).let { layout -> DataBindingUtil.setContentView(this, layout) }
        binding.state = UiState.Loading
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        val headingElement = HeadingElement("Beat Info")
        val textElement = TextElement(Field("Outlet Name", true, null))
        val list: MutableList<Element> = ArrayList()
        list.add(headingElement)
        list.add(textElement)

        val adapter = AdapterRecyclerViewImpl(this)
        adapter.update(list)
        val layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter
        binding.list.layoutManager = layoutManager
        binding.state = UiState.Data
    }
}