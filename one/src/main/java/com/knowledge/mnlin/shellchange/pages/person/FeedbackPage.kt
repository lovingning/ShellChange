package com.knowledge.mnlin.shellchange.pages.person

import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.utils.dOnClick
import com.knowledge.mnlin.shellchange.utils.toast
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import kotlinx.android.synthetic.main.page_feedback.view.*

/**************************************
 * function :
 *
 * Created on 2019/11/26  0:46
 * @author mnlin
 **************************************/
@InjectPageLayoutRes(layoutResId = R.layout.page_feedback)
class FeedbackPage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()
        setPageTitle("意见反馈")

        contentView.apply {
            tv_submit.dOnClick {
                toast("提交成功")
                onBackPressed()
            }
        }
    }
}