package raj.outlet_form.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import raj.outlet_form.databinding.FragmentSecondBinding
import raj.outlet_form.databinding.LayoutBottomSheetBinding
import raj.outlet_form.utilities.BottomClickCallbacks
import raj.outlet_form.utilities.FragmentUtil
import raj.outlet_form.utilities.InjectorUtils
import raj.outlet_form.utilities.UserClickCallbacks


class FragmentSecond : Fragment(),UserClickCallbacks, BottomClickCallbacks
{

    override fun onBottomItemClick(view: String, value: String) {
        Log.d("method onBottomItemClick", " :: "+ view+ " :: "+ value)

        bottomSheetDialog.dismiss()
        adapter!!.notifyDataSetChanged()
        viewModel.setDropDownValue(value,view)
    }


    override fun onUserClick(viewtitle :CharSequence) {
        getBottomlist(viewtitle.toString())
        showBottomSheet(viewtitle.toString())
    }

    internal lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    internal lateinit var bottomSheetDialog: BottomSheetDialog
    lateinit var layoutBottomSheetBinding : LayoutBottomSheetBinding

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var injector: InjectorUtils
    private lateinit var list: List<Element>
    private lateinit var Optionlist: List<String>
    var adapter :AdapterRecyclerViewImpl? = null
    var bottom_adapter :BottomAdapter? = null

    lateinit var mInflator : LayoutInflater
    lateinit var mcontext :Context


    companion object {
        public const val TAG = "fragment second"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.let { ViewModelProviders.of(it).get(MainViewModel::class.java) }!!
    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        Log.d("method second ----------------------", " ====================")

        mcontext =  container!!.context
        mInflator = inflater
        binding = DataBindingUtil.inflate<ViewDataBinding>(inflater,
            raj.outlet_form.R.layout.fragment_second, container, false) as FragmentSecondBinding
        binding.state = UiState.Loading
        bottom_adapter = BottomAdapter(viewModel,this)
        getList()
        adapter?.update(list)
        binding.buttonFrame.setOnClickListener{ getNextPage() }
        return binding.root
    }


    fun showBottomSheet(viewname:String)
    {
        layoutBottomSheetBinding =
                DataBindingUtil.inflate(mInflator, raj.outlet_form.R.layout.layout_bottom_sheet, null, false)

        layoutBottomSheetBinding.sheetlist.adapter = bottom_adapter
        bottom_adapter!!.update(Optionlist, viewname)
        val layoutManager = LinearLayoutManager(activity!!.baseContext)
        layoutBottomSheetBinding.sheetlist.layoutManager = layoutManager
        bottomSheetDialog = BottomSheetDialog(mcontext)
        bottomSheetDialog.setContentView(layoutBottomSheetBinding.root)
        bottomSheetBehavior = BottomSheetBehavior.from(layoutBottomSheetBinding.root.parent as View)
        bottomSheetBehavior.setBottomSheetCallback(bottomSheetCallback)
        bottomSheetBehavior.peekHeight = 1000
        bottomSheetDialog.show()

    }

    internal var bottomSheetCallback: BottomSheetBehavior.BottomSheetCallback =
        object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED ->
                        //textPrompt2.setText("COLLAPSED");
                        Log.d(TAG, "onStateChanged: ")
                    BottomSheetBehavior.STATE_DRAGGING -> Log.d(TAG, "onStateChanged: ")
                    BottomSheetBehavior.STATE_EXPANDED -> Log.d(TAG, "onStateChanged: ")
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        Log.d(TAG, "onStateChanged: ")
                        bottomSheetDialog.dismiss()
                    }
                    BottomSheetBehavior.STATE_SETTLING -> Log.d(TAG, "onStateChanged: ")
                    else -> Log.d(TAG, "onStateChanged: ")
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("method invock", ": onAttach")

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    fun getBottomlist(viewtitle : String)
    {
        Optionlist = viewModel.getBottomList(viewtitle).value!!
    }


    fun getList()
    {
       adapter = AdapterRecyclerViewImpl(viewModel,this)
        list = viewModel.getAllWords(2).value!!
        val layoutManager = LinearLayoutManager(activity)
        binding.list.adapter = adapter
        binding.list.layoutManager = layoutManager
        binding.state = UiState.Data
    }

    fun getNextPage()
    {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        var fragmentOne = FragmentUtil.getFragmentByTagName(fragmentManager, "third")
        if (fragmentOne == null) {
            fragmentOne = FragmentThird()
        }

        fragmentTransaction?.replace(raj.outlet_form.R.id.fragment_back_stack_frame_layout, fragmentOne, "third")
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
        FragmentUtil.printActivityFragmentList(fragmentManager)
    }

    override fun onResume() {
        super.onResume()

    }


}