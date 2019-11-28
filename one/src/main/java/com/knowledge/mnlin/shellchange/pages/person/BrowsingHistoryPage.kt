package com.knowledge.mnlin.shellchange.pages.person

import com.knowledge.mnlin.page.core.PRouter
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.bases.RecordPageImpl
import com.knowledge.mnlin.shellchange.beans.BrowsingHistoryBean
import com.knowledge.mnlin.shellchange.pages.other.NewsDetailPage
import com.linktech.gft.base.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.layout_simple_text_view.view.*

/**************************************
 * function :
 *
 * Created on 2019/11/24  17:52
 * @author mnlin
 **************************************/
@InjectPageLayoutRes(layoutResId = R.layout.page_browsing_history)
open class BrowsingHistoryPage : RecordPageImpl<BrowsingHistoryBean>() {
    private lateinit var mDatas: MutableList<BrowsingHistoryBean>
    private lateinit var mAdapter: BaseRecyclerViewAdapter<BrowsingHistoryBean>

    override fun onPagePreCreate() {
        super.onPagePreCreate()

        mDatas = mutableListOf(
            BrowsingHistoryBean(title = "金色观察丨区块链进入真实房地产 为你带来哪些生活改变？"),
            BrowsingHistoryBean(title = "区块链将熨平经济周期？这个脑洞开得有点大"),
            BrowsingHistoryBean(title = "合约特别版：现在 要不要抄底看这里"),
            BrowsingHistoryBean(title = "以太坊2.0：如何变身“世界的超级计算机"),
            BrowsingHistoryBean(title = "阴跌不止 走势毫无新意"),
            BrowsingHistoryBean(title = "投机炒作、违法发币、骗局不断 借区块链炒作行骗需警惕"),
            BrowsingHistoryBean(title = "中国区块链在全球舆论场筑造了一座高峰")
        )

        mAdapter = BaseRecyclerViewAdapter(
            dataResources = mDatas,
            layoutResId = R.layout.layout_simple_text_view,
            listener = { _, index ->
                PRouter.build(NewsDetailPage())
                    .withParam("urls", mDatas[index].linkUrl)
                    .navigation()
            }
        ) {
            tv_simple_text_view.text = it.title
        }.also {
            setAdapter(it)
        }
    }


    override fun onPageViewInject() {
        super.onPageViewInject()
        addItemDividerDecoration()

        contentView.apply {
            setPageTitle( "浏览历史")
        }
    }

    override fun onRefreshData() {
        if (mDatas.size > 0) {
            mAdapter.removeWithAnimation(0)
        }

        if (mDatas.size == 0) {
            setRefreshEnable(false)
        }

        setRefreshAnimation(false)
    }
}