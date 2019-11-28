package com.knowledge.mnlin.shellchange.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * Created on 2018/7/27  16:23
 * function : fit src width-height
 *
 * @author mnlin
 */
public class FitSrcImageView extends AppCompatImageView {
    public FitSrcImageView(Context context) {
        this(context, null);
    }

    public FitSrcImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FitSrcImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Drawable drawable = getDrawable();
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight != 0 && intrinsicWidth != 0) {
                int width = getMeasuredWidth();
                int height = ((int) (1.00 * width / intrinsicWidth * intrinsicHeight));
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
            }
        }
    }
}
