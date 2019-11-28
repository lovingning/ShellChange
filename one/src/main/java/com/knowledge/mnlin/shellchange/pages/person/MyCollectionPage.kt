package com.knowledge.mnlin.shellchange.pages.person

/**
 * function :
 *
 * Created on 2019/11/24  20:28
 * @author mnlin
 */
class MyCollectionPage : BrowsingHistoryPage() {
    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            setPageTitle("我的收藏")
        }
    }
}