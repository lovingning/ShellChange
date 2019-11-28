package com.knowledge.mnlin.shellchange.pagebase;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.blankj.utilcode.util.BarUtils;
import com.knowledge.mnlin.page.core.PageImpl;
import com.knowledge.mnlin.page.interfaces.PageLifeCycle;
import com.knowledge.mnlin.shellchange.R;

/**
 * Created on 2019/11/20  0:50
 * function :
 *
 * @author mnlin
 */
public abstract class CustomPageImpl extends PageImpl {
    @Override
    public void onPageViewInject() {
        super.onPageViewInject();

        View fitStatusBar = getContentView().findViewById(R.id.iv_tool_bar_fit_status_bar);
        if (fitStatusBar != null) {
            getContentView().post(() -> fitStatusBar.setMinimumHeight(BarUtils.getStatusBarHeight()));
        }

        View backView = getContentView().findViewById(R.id.iv_common_tool_bar_back);
        if (backView != null) {
            backView.setOnClickListener(v -> onBackPressed());
        }
    }

    @Override
    public void onPageAttachToParent() {
        super.onPageAttachToParent();

        setMaskDrawable(new ColorDrawable(dispatchGetColor(R.color.skin_dialog_background_color)));
    }

    protected boolean contentViewHasInject() {
        return getCurrentGradation() >= PageLifeCycle.PAGE_GRADATION_VIEW_INJECT;
    }

    protected boolean setPageTitle(@Nullable CharSequence title) {
        if (contentViewHasInject()) {
            TextView titleView = getContentView().findViewById(R.id.tv_common_tool_bar_title);
            if (titleView != null) {
                titleView.setText(title);
                return true;
            }
        }
        return false;
    }

    /**
     * 获取drawable
     */
    protected String dispatchGetString(@StringRes int resId, Object... formatArgs) {
        return getSingleActivity().getResources().getString(resId, formatArgs);
    }

    /**
     * 获取drawable
     */
    protected Drawable dispatchGetDrawable(@DrawableRes int resId) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getSingleActivity().getDrawable(resId);
        } else {
            return getSingleActivity().getResources().getDrawable(resId);
        }
    }


    /**
     * 获取颜色值
     */
    protected int dispatchGetColor(@ColorRes int resId) {
        if (Build.VERSION.SDK_INT < 23) {
            return getSingleActivity().getResources().getColor(resId);
        } else {
            return getSingleActivity().getResources().getColor(resId, null);
        }
    }

    /**
     * 获取颜色值
     */
    protected int dispatchGetDimen(@DimenRes int resId) {
        return getSingleActivity().getResources().getDimensionPixelSize(resId);
    }

    /**
     * 获取stateList
     */
    protected ColorStateList dispatchGetColorStateList(@ColorRes int resId) {
        if (Build.VERSION.SDK_INT < 23) {
            return getSingleActivity().getResources().getColorStateList(resId);
        } else {
            return getSingleActivity().getResources().getColorStateList(resId, null);
        }
    }

    /**
     * 获取系统属性中某个值
     */
    protected int getThemeColorAttribute(int styleRes, int colorId) {
        int protectedColor = dispatchGetColor(R.color.transparent);
        int[] attrsArray = {colorId};
        TypedArray typedArray = getSingleActivity().obtainStyledAttributes(styleRes, attrsArray);
        int color = typedArray.getColor(0, protectedColor);

        typedArray.recycle();
        return color;
    }
}
