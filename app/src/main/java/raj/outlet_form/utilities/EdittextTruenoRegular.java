package raj.outlet_form.utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class EdittextTruenoRegular extends android.support.v7.widget.AppCompatEditText {

	 public EdittextTruenoRegular(Context context) {
		 super(context);
		 mTextFont(context);
	 }

	 public EdittextTruenoRegular(Context context, AttributeSet attrs) {
		 super(context, attrs);
		 mTextFont(context);
	 }

	 public EdittextTruenoRegular(Context context, AttributeSet attrs, int defStyleAttr) {
		 super(context, attrs, defStyleAttr);
		 mTextFont(context);
	 }
	 private void mTextFont(Context context) {
		 Typeface face = Typeface.createFromAsset(context.getAssets(), "truenorg.otf");
		 this.setTypeface(face);
	 }
 }
