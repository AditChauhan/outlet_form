package raj.outlet_form

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import raj.outlet_form.databinding.ActivityMainBinding
import raj.outlet_form.ui.AdapterRecyclerViewImpl
import raj.outlet_form.ui.Element
import raj.outlet_form.ui.Fragmentfirst
import raj.outlet_form.ui.MainViewModel
import raj.outlet_form.utilities.FragmentUtil
import raj.outlet_form.utilities.InjectorUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var injector: InjectorUtils
    private lateinit var list: List<Element>
    var adapter :AdapterRecyclerViewImpl? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Get FragmentManager and FragmentTransaction object.

//
//        binding = (R.layout.activity_main).let { layout -> DataBindingUtil.setContentView(this, layout) }
//        binding.state = UiState.Loading
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        getList()


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Create FragmentOne instance.
        val fragmentOne = Fragmentfirst()
        // Add fragment one with tag name.
        fragmentTransaction.replace(R.id.fragment_back_stack_frame_layout, fragmentOne, "first")
        fragmentTransaction.commit()
        FragmentUtil.printActivityFragmentList(fragmentManager);



    }
    fun getList()
    {
//        adapter = binding.root.list
       // list = viewModel.getAllWords().value!!
    }

    override fun onResume() {
        super.onResume()
        //list.add(textElement3)

//        adapter?.update(list)
//        val layoutManager = LinearLayoutManager(this)
//        binding.list.adapter = adapter
//        binding.list.layoutManager = layoutManager
//        binding.state = UiState.Data
    }

//    fun  setupListClick() {
//        viewModel.selected.observe(this, object : Observer<Element>{
//            override fun onChanged(t: Element?) {
//
//                Toast.makeText(
//                    this@MainActivity,
//                    "You selected a " + t!!.title,
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            }
//
//
//        })
//    }


}