package raj.outlet_form.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import raj.outlet_form.databinding.FragmentSecondBinding
import raj.outlet_form.utilities.FragmentUtil
import raj.outlet_form.utilities.InjectorUtils




class FragmentSecond : Fragment()
{

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var injector: InjectorUtils
    private lateinit var list: List<Element>
    var adapter :AdapterRecyclerViewImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.let { ViewModelProviders.of(it).get(MainViewModel::class.java) }!!

    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        //val retView = inflater.inflate(raj.outlet_form.R.layout.fragment_first, container, false)
        Log.d("method invock", ": onCreateView")
        binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, raj.outlet_form.R.layout.fragment_second, container, false) as FragmentSecondBinding
        binding.state = UiState.Loading
        getList()
        adapter?.update(list)

        binding.buttonFrame.setOnClickListener{

            getNextPage()

        }


        return binding.root
    }




    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("method invock", ": onAttach")

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    fun getList()
    {

        adapter = viewModel.getAdapter()
        list = viewModel.getAllWords(2).value!!


        val layoutManager = LinearLayoutManager(activity)
        binding.list.adapter = adapter
        binding.list.layoutManager = layoutManager
        binding.state = UiState.Data


    }

    fun getNextPage()
    {
        val fragmentTransaction = fragmentManager?.beginTransaction()

        var fragmentOne = FragmentUtil.getFragmentByTagName(fragmentManager, "first")

        // Because fragment two has been popup from the back stack, so it must be null.
        if (fragmentOne == null) {
            fragmentOne = Fragmentfirst()


        }
        // Replace fragment one with fragment two, the second fragment tag name is "Fragment Two".
        // This action will remove Fragment one and add Fragment two.
        fragmentTransaction?.replace(raj.outlet_form.R.id.fragment_back_stack_frame_layout, fragmentOne, "first")

        // Add fragment one in back stack.So it will not be destroyed. Press back menu can pop it up from the stack.
        fragmentTransaction?.addToBackStack(null)

        fragmentTransaction?.commit()

        FragmentUtil.printActivityFragmentList(fragmentManager)
    }

    override fun onResume() {
        super.onResume()

    }
}