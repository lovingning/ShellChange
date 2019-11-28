package com.knowledge.mnlin.shellchange.pagebase;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.BarUtils;
import com.knowledge.mnlin.page.core.PageParent;

/**
 * Created on 2019/11/20  0:50
 * function :
 *
 * @author mnlin
 */
public class CustomPageParent extends PageParent {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set status-bar text color
        BarUtils.setStatusBarLightMode(this, true);


    }
}
