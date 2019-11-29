package com.knowledge.mnlin.shellchange.pages.person.setting

import com.knowledge.mnlin.page.core.PRouter
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.utils.onPerformSelf
import com.knowledge.mnlin.shellchange.utils.toast
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import kotlinx.android.synthetic.main.page_setting.view.*

/**************************************
 * function :
 *
 * Created on 2019/11/25  23:50
 * @author mnlin
 **************************************/
@InjectPageLayoutRes(layoutResId = R.layout.page_setting)
class SettingPage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            setPageTitle("设置")

            arrayOf(
                lmv_head,
                lmv_phone,
                lmv_wx,
                lmv_qq,
                lmv_password
            ).mapIndexed { index, item ->
                item.onPerformSelf {
                    when (index) {
                        0 -> PRouter.build(ChangeHeadPage()).navigation()
                        1 -> PRouter.build(ChangePhonePage()).navigation()
                        2 -> TODO()
                        3 -> TODO()
                        4 -> PRouter.build(ChangePasswordPage()).navigation()
                        else -> TODO()
                    }
                }
            }
        }
    }

    private fun TODO() {
        toast("暂未开放")
    }
}