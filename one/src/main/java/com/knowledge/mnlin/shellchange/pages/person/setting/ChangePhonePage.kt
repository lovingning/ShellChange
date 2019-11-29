package com.knowledge.mnlin.shellchange.pages.person.setting

import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.utils.dOnClick
import com.knowledge.mnlin.shellchange.utils.doAfterTextChanged
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import kotlinx.android.synthetic.main.page_change_phone.view.*

/**************************************
 * function :
 *
 * Created on 2019/11/27  0:56
 * @author mnlin
 **************************************/
@InjectPageLayoutRes(layoutResId = R.layout.page_change_phone)
class ChangePhonePage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {

            iv_enter.isEnabled = false
            listOf(iv_enter, iv_close).dOnClick { index, item ->
                onBackPressed()
            }

            listOf(
                et_phone_old,
                et_password,
                et_phone_new,
                et_sms
            ).doAfterTextChanged { it, _ ->
                iv_enter.isEnabled = it.all {
                    it.text?.isNotEmpty() ?: false
                }
            }
        }
    }
}