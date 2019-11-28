package com.knowledge.mnlin.shellchange.bases

import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import com.linktech.gft.base.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.layout_common_none_data.view.*
import kotlinx.android.synthetic.main.page_browsing_history.view.*

/**
 * function :
 *
 * Created on 2019/11/24  18:56
 * @author mnlin
 */
abstract class RecordPageImpl<BEAN> : CustomPageImpl() {
    private var mAdapter: BaseRecyclerViewAdapter<BEAN>? = null

    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            rv_mores.also {
                it.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                it.adapter = mAdapter
                it.itemAnimator = DefaultItemAnimator().also {
                    it.addDuration = 200
                    it.removeDuration = 200
                }
            }

            srl_more.setOnRefreshListener {
                onRefreshData()
            }
        }
    }

    protected fun addItemDividerDecoration() {
        if (contentViewHasInject()) {
            contentView.rv_mores.addItemDecoration(
                DividerItemDecoration(
                    contentView.context,
                    LinearLayoutManager.VERTICAL
                ).also {
                    it.setDrawable(dispatchGetDrawable(R.drawable.shape_recycler_decoration_item))
                })
        }
    }

    protected fun setAdapter(adapter: BaseRecyclerViewAdapter<BEAN>) {
        mAdapter = adapter
        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                if (contentView.ll_common_none_data != null) {
                    contentView.ll_common_none_data.visibility =
                        if (adapter.dataResources.size == 0) View.VISIBLE else View.GONE
                }
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                onChanged()
            }

            override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                onChanged()
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                onChanged()
            }

            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                onChanged()
            }
        })

        if (contentViewHasInject()) {
            contentView.rv_mores.adapter = mAdapter
        }
    }

    abstract fun onRefreshData()

    fun setRefreshAnimation(open: Boolean) {
        contentView.srl_more.isRefreshing = open
    }

    fun setRefreshEnable(enable: Boolean) {
        contentView.srl_more.isEnabled = enable
    }
}