package com.knowledge.mnlin.shellchange.pages.information

import com.knowledge.mnlin.page.core.PRouter
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.utils.dOnClick
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import com.knowledge.mnlin.shellchange.pages.other.NewsDetailPage
import kotlinx.android.synthetic.main.layout_common_none_data.view.*

/**
 * function :
 *
 * Created on 2019/11/21  0:32
 * @author mnlin
 */
@InjectPageLayoutRes(layoutResId = R.layout.page_information_item)
class InformationItemPage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            ll_common_none_data.dOnClick {
                PRouter.build(NewsDetailPage())
                    .withParam("urls","https://www.baidu.com/")
                    .navigation()
            }
        }
    }
}