package raj.outlet_form.ui

import android.app.LauncherActivity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import raj.outlet_form.R


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


class AdapterRecyclerViewImpl(val activity: AppCompatActivity) : AdapterRecyclerView() {

    private var list: List<Element> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        return list[position].layoutId
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun updateBinding(binding: ViewDataBinding, pos: Int) {
        list[pos].updateBinding(binding)
        if (list[pos] is RecyclerViewItemClickListener)
            binding.root.setOnClickListener {
                (list[pos] as RecyclerViewItemClickListener).onRecyclerViewItemClicked(activity)
            }
    }

    fun update(list: List<Element>) {
        this.list = list
        notifyDataSetChanged()
    }
}
