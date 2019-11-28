package com.knowledge.mnlin.shellchange.pages.information

import android.graphics.drawable.LevelListDrawable
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.knowledge.mnlin.page.core.PRouter
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.sdialog.utils.dOnClick
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.adapters.ViewPagerAdapter
import com.knowledge.mnlin.shellchange.beans.MoreBean
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import com.knowledge.mnlin.shellchange.pages.other.NewsDetailPage
import com.knowledge.mnlin.shellchange.views.FitSrcImageView
import kotlinx.android.synthetic.main.item_page_more.view.*
import kotlinx.android.synthetic.main.page_information_recommend.view.*

/**
 * function :
 *
 * Created on 2019/11/21  0:32
 * @author mnlin
 */
@InjectPageLayoutRes(layoutResId = R.layout.page_information_recommend)
class InformationRecommendPage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            val bannerPaddingHor = dispatchGetDimen(R.dimen.view_padding_margin_8dp)
            val bannerPaddingTop = dispatchGetDimen(R.dimen.view_padding_margin_4dp)
            val eve = dispatchGetDimen(R.dimen.float_action_tab_elevation_9dp).toFloat()
            vp_recommend_banner.adapter = ViewPagerAdapter(listOf(
                FitSrcImageView(context).also {
                    it.elevation = eve
                    it.setImageResource(R.drawable.picture_person_banner_default)
                    it.setPadding(bannerPaddingHor, bannerPaddingTop, bannerPaddingHor, 0)
                },
                FitSrcImageView(context).also {
                    it.elevation = eve
                    it.setImageResource(R.drawable.picture_person_banner_default)
                    it.setPadding(bannerPaddingHor, bannerPaddingTop, bannerPaddingHor, 0)
                },
                FitSrcImageView(context).also {
                    it.elevation = eve
                    it.setImageResource(R.drawable.picture_person_banner_default)
                    it.setPadding(bannerPaddingHor, bannerPaddingTop, bannerPaddingHor, 0)
                }
            ))
            vp_recommend_banner.addOnPageChangeListener(object :
                ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    iv_recommend_banner_dot.drawable.also {
                        if (it is LevelListDrawable) {
                            it.level = position
                        }
                    }
                }
            })

            listOf(
                in_main_0 to MoreBean(
                    imageResId = R.drawable.picture_more_test_0,
                    title = "金色财经 | 区块链进入真实房地产 带来哪些生活改变？",
                    readAmount = 324
                ),
                in_main_1 to MoreBean(
                    imageResId = R.drawable.picture_more_test_1,
                    title = "朴薪观察 | 加密衍生品: 市场的本身是否还是一个市场？",
                    readAmount = 4523
                ),
                in_main_2 to MoreBean(
                    imageResId = R.drawable.picture_more_test_2,
                    title = "朴薪荐读 | USDT追赶的新秀 稳定币路在何方？",
                    readAmount = 54
                ),
                in_main_3 to MoreBean(
                    imageResId = R.drawable.picture_more_test_3,
                    title = "激励测试网 | 为区块链发现更多长期玩家",
                    readAmount = 6
                ),
                in_main_4 to MoreBean(
                    imageResId = R.drawable.picture_more_test_4,
                    title = "中国产经新闻 | 向民生领域延伸“区块链+”在路上",
                    readAmount = 0
                ),
                in_main_5 to MoreBean(
                    imageResId = R.drawable.picture_more_test_5,
                    title = "严防搭区块链“便车”炒作 多地监督围剿加密交易所",
                    readAmount = 345346
                ),
                in_main_6 to MoreBean(
                    imageResId = R.drawable.picture_more_test_6,
                    title = "金色观察丨区块链进入真实房地产 为你带来哪些生活改变？",
                    readAmount = 5
                ),
                in_main_7 to MoreBean(
                    imageResId = R.drawable.picture_more_test_7,
                    title = "本周区块链资产总市值比上周下跌4.46%",
                    readAmount = 76575
                )
            ).mapIndexed { index, pair ->
                // bind view
                pair.second.imageResId?.also {
                    pair.first.iv_item_picture.setImageResource(it)
                }
                pair.first.tv_item_title.text = pair.second.title
                pair.first.tv_item_read.text = "${pair.second.readAmount}"

                //setup top
                if (index in 0 until 3) {
                    pair.first.tv_setup_top.visibility = View.VISIBLE
                }

                //
                pair.first.dOnClick {
                    PRouter.build(NewsDetailPage()).navigation()
                }
            }
        }
    }
}