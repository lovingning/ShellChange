package com.knowledge.mnlin.shellchange.pages

import androidx.viewpager.widget.ViewPager
import com.knowledge.mnlin.page.adapters.PageAdapter
import com.knowledge.mnlin.page.core.PageImpl
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.page_annotation.annotations.PageEnterPoint
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import com.knowledge.mnlin.shellchange.pages.information.InformationPage
import com.knowledge.mnlin.shellchange.pages.more.MorePage
import com.knowledge.mnlin.shellchange.pages.person.PersonPage
import kotlinx.android.synthetic.main.page_enter_point.view.*

/**
 * function :
 *
 * Created on 2019/11/19  0:28
 * @author mnlin
 */
@PageEnterPoint
@InjectPageLayoutRes(layoutResId = R.layout.page_enter_point)
class EnterPoint : PageImpl() {
    private lateinit var mAdapter: PageAdapter<CustomPageImpl>
    private lateinit var mPages: List<CustomPageImpl>

    override fun onPagePreCreate() {
        super.onPagePreCreate()

        mPages = listOf(
            InformationPage(),
            MorePage(),
            PersonPage()
        )

        mAdapter = PageAdapter(mPages)
    }

    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            vp_pager.adapter = mAdapter

            bv_navigation.itemIconTintList = null
            bv_navigation.setOnNavigationItemSelectedListener {
                if (vp_pager.currentItem != it.order) {
                    vp_pager.setCurrentItem(it.order, true)
                }
                true
            }

            vp_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    // reflect bottom
                    bv_navigation.selectedItemId = arrayOf(
                        R.id.action_information,
                        R.id.action_more,
                        R.id.action_person
                    )[position]


                    // to appear page
                    mPages[position].onPageReResume()
                }
            })
        }
    }
}