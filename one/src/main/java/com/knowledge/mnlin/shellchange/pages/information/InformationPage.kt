package com.knowledge.mnlin.shellchange.pages.information

import android.animation.ObjectAnimator
import android.util.TypedValue
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.knowledge.mnlin.page.adapters.PageAdapter
import com.knowledge.mnlin.page.core.PRouter
import com.knowledge.mnlin.page.interfaces.Page
import com.knowledge.mnlin.page.utils._TODO_PAGE_
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.utils.empty
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import kotlinx.android.synthetic.main.page_information.view.*

private const val DURATION_TEXT_SIZE_CHANGE = 500L

/**
 * function :
 *
 * Created on 2019/11/20  1:02
 * @author mnlin
 */
@InjectPageLayoutRes(layoutResId = R.layout.page_information)
class InformationPage : CustomPageImpl() {
    private lateinit var mAdapter: PageAdapter<Page>
    private lateinit var mPages: List<Page>
    private var mTitles: List<String> = listOf(
        "推荐",
        "行情",
        "专栏",
        "产业",
        "政策",
        "技术"
    )
    private var mTabViews: MutableList<TextView> = mutableListOf()

    private var mLastPosition = -1

    override fun onPagePreCreate() {
        super.onPagePreCreate()

        mPages = listOf(
            InformationRecommendPage(),
            InformationItemPage(),
            InformationItemPage(),
            InformationItemPage(),
            InformationItemPage(),
            InformationItemPage()
        )

        mAdapter = PageAdapter(mPages)
    }

    override fun onPageViewInject() {
        super.onPageViewInject()

        @Suppress("INACCESSIBLE_TYPE")
        contentView.apply {
            iv_text.empty {
                PRouter.build(_TODO_PAGE_()).navigation()
            }

            vp_pager.adapter = mAdapter
            tl_tab.setupWithViewPager(vp_pager)

            // animator to target text-size
            val setTabTextSize = { tv: TextView, selected: Boolean ->
                val targetSize = dispatchGetDimen(
                    if (selected) R.dimen.text_size_20sp else R.dimen.text_size_normal_14sp
                )

                val currentSize = tv.textSize

                ObjectAnimator.ofFloat(0F, 1F)
                    .setDuration(DURATION_TEXT_SIZE_CHANGE)
                    .also {
                        it.addUpdateListener {
                            if (it.animatedValue is Float) {
                                tv.setTextSize(
                                    TypedValue.COMPLEX_UNIT_PX,
                                    currentSize + (targetSize - currentSize) * it.animatedValue as Float
                                )
                            }
                        }
                        it.start()
                    }
            }

            // add custom tab-view
            for (index in 0 until tl_tab.tabCount) {
                TextView(context).also {
                    it.text = mTitles[index]
                    setTabTextSize(it, index == 0)

                    mTabViews.add(index, it)
                    tl_tab.getTabAt(index)?.customView = it
                }
            }

            // change logic when page changed
            vp_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    // change tab-text size
                    if (mLastPosition != -1) {
                        setTabTextSize(mTabViews[mLastPosition], false)
                    }
                    setTabTextSize(mTabViews[position], true)

                    mLastPosition = position

                    // to appear page
                    mPages[position].onPageReResume()
                }
            })
        }
    }
}