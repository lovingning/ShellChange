package com.knowledge.mnlin.shellchange.pages.person.setting

import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.utils.dOnClick
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import kotlinx.android.synthetic.main.page_change_head.view.*

/**************************************
 * function :
 *
 * Created on 2019/11/27  0:37
 * @author mnlin
 **************************************/
@InjectPageLayoutRes(layoutResId = R.layout.page_change_head)
class ChangeHeadPage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            listOf(
                tv_take_photo,
                tv_select_picture,
                tv_browsing,
                tv_cancel
            ).dOnClick { index, item ->
                onBackPressed()
            }
        }
    }
}