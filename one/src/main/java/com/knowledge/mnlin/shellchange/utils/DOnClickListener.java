package com.knowledge.mnlin.shellchange.utils;

import android.view.View;

/**
 * Created on 2019/4/3  15:31
 * function : 防颤抖 view 点击事件
 *
 * @author mnlin
 */
public abstract class DOnClickListener implements View.OnClickListener {
    private static volatile boolean enabled = true;

    private static final Runnable ENABLE_AGAIN = () -> enabled = true;

    @Override
    public synchronized final void onClick(View v) {
        if (enabled) {
            enabled = false;
            v.post(ENABLE_AGAIN);
            doClick(v);
        }
    }

    public abstract void doClick(View v);
}
