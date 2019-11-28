package com.knowledge.mnlin.shellchange.pages.more

import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.knowledge.mnlin.page.core.PRouter
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.beans.MoreBean
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import com.knowledge.mnlin.shellchange.pages.other.NewsDetailPage
import com.linktech.gft.base.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_page_more.view.*
import kotlinx.android.synthetic.main.layout_common_none_data.view.*
import kotlinx.android.synthetic.main.page_more.view.*

/**
 * function :
 *
 * Created on 2019/11/22  1:37
 * @author mnlin
 */
@InjectPageLayoutRes(layoutResId = R.layout.page_more)
class MorePage : CustomPageImpl() {
    private var mDatas: MutableList<MoreBean> = mutableListOf()
    private var mAdapter: BaseRecyclerViewAdapter<MoreBean>

    init {
        mDatas.addAll(
            listOf(
                MoreBean(
                    imageResId = R.drawable.picture_more_test_0,
                    title = "金色财经 | 区块链进入真实房地产 带来哪些生活改变？",
                    readAmount = 324
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_1,
                    title = "朴薪观察 | 加密衍生品: 市场的本身是否还是一个市场？",
                    readAmount = 4523
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_2,
                    title = "朴薪荐读 | USDT追赶的新秀 稳定币路在何方？",
                    readAmount = 54
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_3,
                    title = "激励测试网 | 为区块链发现更多长期玩家",
                    readAmount = 6
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_4,
                    title = "中国产经新闻 | 向民生领域延伸“区块链+”在路上",
                    readAmount = 0
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_5,
                    title = "严防搭区块链“便车”炒作 多地监督围剿加密交易所",
                    readAmount = 345346
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_6,
                    title = "金色观察丨区块链进入真实房地产 为你带来哪些生活改变？",
                    readAmount = 5
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_7,
                    title = "本周区块链资产总市值比上周下跌4.46%",
                    readAmount = 76575
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_0,
                    title = "金色财经 | 区块链进入真实房地产 带来哪些生活改变？",
                    readAmount = 324
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_1,
                    title = "朴薪观察 | 加密衍生品: 市场的本身是否还是一个市场？",
                    readAmount = 4523
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_2,
                    title = "朴薪荐读 | USDT追赶的新秀 稳定币路在何方？",
                    readAmount = 54
                ),
                MoreBean(
                    imageResId = R.drawable.picture_more_test_3,
                    title = "激励测试网 | 为区块链发现更多长期玩家",
                    readAmount = 6
                )
            )
        )

        mAdapter = BaseRecyclerViewAdapter(
            dataResources = mDatas,
            layoutResId = R.layout.item_page_more,
            listener = { _, _ ->
                PRouter.build(NewsDetailPage())
                    .withParam("key", "value")
                    .navigation()
            }
        ) {
            // bind view
            it.imageResId?.also {
                iv_item_picture.setImageResource(it)
            }
            tv_item_title.text = it.title
            tv_item_read.text = "${it.readAmount}"
        }
    }

    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            ll_common_none_data.visibility = if (mDatas.size == 0) View.VISIBLE else View.GONE

            rv_mores.also {
                it.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                it.adapter = mAdapter
                it.itemAnimator = DefaultItemAnimator().also {
                    it.addDuration = 200
                    it.removeDuration = 200
                }
            }

            srl_more.setOnRefreshListener {
                mDatas.reverse()

                if (mDatas.size > 0) {
                    mAdapter.removeWithAnimation(0)
                }

                if (mDatas.size == 0) {
                    srl_more.isEnabled = false
                }

                ll_common_none_data.visibility = if (mDatas.size == 0) View.VISIBLE else View.GONE

                srl_more.isRefreshing = false
            }
        }
    }
}