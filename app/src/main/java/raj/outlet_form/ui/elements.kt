package raj.outlet_form.ui

import android.databinding.ViewDataBinding
import android.graphics.Color
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import raj.outlet_form.R
import raj.outlet_form.data.Field
import raj.outlet_form.databinding.ElementDropdownBinding
import raj.outlet_form.databinding.ElementHeadingBinding
import raj.outlet_form.databinding.ElementTextBinding

abstract class Element(val field: Field, @LayoutRes open val layoutId: Int) {
    var title: CharSequence = TextUtils.concat(
        SpannableString(field?.mandatory.let {
            if (it) "*" else ""
        }).also { it.setSpan(ForegroundColorSpan(Color.RED), 0, it.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE) },
        field.title
    )

    abstract fun updateBinding(binding: ViewDataBinding,viewModel: MainViewModel, pos: Int )

}


class TextElement(field: Field) : Element(field, R.layout.element_text) {
    override fun updateBinding(binding: ViewDataBinding,viewModel: MainViewModel,pos: Int) {
        binding as ElementTextBinding
        binding.element = this
        binding.viewModel = viewModel
        binding.position = pos


    }
}


 class EditDropElement(field: Field) : Element(field, R.layout.element_dropdown) {
    override fun updateBinding(binding: ViewDataBinding,viewModel: MainViewModel,pos: Int) {
        binding as ElementDropdownBinding
        binding.element = this
        binding.viewModel = viewModel
        binding.position = pos
    }
}

class HeadingElement(val heading: CharSequence) : Element(Field(heading, false, null), R.layout.element_heading),
    RecyclerViewItemClickListener {
    override fun onRecyclerViewItemClicked(activity: AppCompatActivity) {
        Toast.makeText(activity, heading, Toast.LENGTH_LONG).show()
    }

    override fun updateBinding(binding: ViewDataBinding,viewModel: MainViewModel,pos: Int) {
        binding as ElementHeadingBinding
        binding.element = this
        binding.viewModel = viewModel
        binding.position = pos
    }
}