package com.knowledge.mnlin.shellchange.pages.person

import com.knowledge.mnlin.page.core.PRouter
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.utils.dOnClick
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import com.knowledge.mnlin.shellchange.pages.person.setting.SettingPage
import kotlinx.android.synthetic.main.page_person.view.*

/**
 * function :
 *
 * Created on 2019/11/22  0:27
 * @author mnlin
 */
@InjectPageLayoutRes(layoutResId = R.layout.page_person)
class PersonPage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            iv_head.dOnClick {

            }

            listOf(
                iv_head to SettingPage(),
                tv_head_text to SettingPage(),
                tv_browsing_history to BrowsingHistoryPage(),
                tv_my_collect to MyCollectionPage(),
                tv_settings to SettingPage(),
                tv_feedback to FeedbackPage(),
                tv_about_us to AboutUsPage()
            ).map {
                it.first.dOnClick {
                    PRouter.build(it.second).navigation()
                }
            }
        }
    }
}
