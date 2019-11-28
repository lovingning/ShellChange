package com.knowledge.mnlin.shellchange.pages.person

import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl

/**************************************
 * function :
 *
 * Created on 2019/11/26  0:51
 * @author mnlin
 **************************************/
@InjectPageLayoutRes(layoutResId = R.layout.page_about_us)
class AboutUsPage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()
        setPageTitle("关于我们")

        contentView.apply {

        }
    }
}