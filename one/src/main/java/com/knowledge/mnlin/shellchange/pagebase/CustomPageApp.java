package com.knowledge.mnlin.shellchange.pagebase;

import com.knowledge.mnlin.page.PageApp;
import com.knowledge.mnlin.page.configs.PageConfigs;

/**
 * Created on 2019/11/20  0:51
 * function :
 *
 * @author mnlin
 */
public class CustomPageApp extends PageApp {
    @Override
    public void onCreate() {
        super.onCreate();

        PageConfigs.sDefaultPageTransDuration = 250;
    }
}
