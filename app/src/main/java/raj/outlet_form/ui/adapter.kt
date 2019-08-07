package raj.outlet_form.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import raj.outlet_form.utilities.UserClickCallbacks


class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

abstract class AdapterRecyclerView : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(p0.context), p1, p0, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        updateBinding(p0.binding, p1)
    }

    abstract override fun getItemViewType(position: Int): Int

    abstract override fun getItemCount(): Int

    abstract fun updateBinding(binding: ViewDataBinding, pos: Int)

}


class AdapterRecyclerViewImpl(val viewModel: MainViewModel,userClickCallbacks: UserClickCallbacks) : AdapterRecyclerView() {

    private var list: List<Element> = ArrayList()
    private  var viewModels :  MainViewModel = viewModel
    var clickCallbacks: UserClickCallbacks =  userClickCallbacks



    override fun getItemViewType(position: Int): Int {
        return list[position].layoutId
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun updateBinding(binding: ViewDataBinding, pos: Int) {
        list[pos].updateBinding(binding,viewModels,pos,clickCallbacks)
        Log.d("updateBinding", "::: " + (binding.root).tag )
       if (list[pos] is EditDropElement)
       {binding.root. setOnClickListener {
           Log.d("binding root", ":clicked ")
           clickCallbacks.onUserClick(list[pos].title.toString())
       }
        }

    }


    fun update(list: List<Element>) {
        this.list = list
        notifyDataSetChanged()
    }
}
