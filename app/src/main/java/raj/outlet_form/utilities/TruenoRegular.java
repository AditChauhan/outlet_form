package raj.outlet_form.utilities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class TruenoRegular extends android.support.v7.widget.AppCompatTextView {


    public TruenoRegular(Context context) {
        super(context);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "truenorg.otf");
        this.setTypeface(face);
    }

    public TruenoRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "truenorg.otf");
        this.setTypeface(face);
    }

    public TruenoRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "truenorg.otf");
        this.setTypeface(face);
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);


    }

}