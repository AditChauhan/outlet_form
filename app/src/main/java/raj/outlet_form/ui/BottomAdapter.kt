package raj.outlet_form.ui

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import raj.outlet_form.R
import raj.outlet_form.databinding.BottomSheetItemBinding
import raj.outlet_form.utilities.BottomClickCallbacks


class BottomAdapter(viewModel:MainViewModel,bottomClickCallbacks : BottomClickCallbacks) : RecyclerView.Adapter<BottomAdapter.MyViewHolder>() {

    private var layoutInflater: LayoutInflater? = null
    lateinit var bottom_item_list: List<String>

    private  var viewModels :  MainViewModel = viewModel

    var bottomClickCallbacks: BottomClickCallbacks =  bottomClickCallbacks

    lateinit var viewname : String

    inner class MyViewHolder(internal var itemBinding: BottomSheetItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val binding =
            DataBindingUtil.inflate<BottomSheetItemBinding>(layoutInflater!!, R.layout.bottom_sheet_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.position = position
        holder.itemBinding.viewName = viewname
        holder.itemBinding.viewModel = viewModels

        holder.itemBinding.itemName =  bottom_item_list.get(position)
        holder.itemBinding.root.setOnClickListener {

            bottomClickCallbacks.onBottomItemClick(viewname,bottom_item_list.get(position))
        }
    }

    override fun getItemCount(): Int {
        return bottom_item_list.size
    }
    fun update(bottomitem : List<String>,name : String)
    {

        viewname = name
        bottom_item_list = bottomitem
    }

}
