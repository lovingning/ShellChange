package com.knowledge.mnlin.shellchange.pages.other

import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.knowledge.mnlin.page_annotation.annotations.InjectPageLayoutRes
import com.knowledge.mnlin.shellchange.utils.dOnClick
import com.knowledge.mnlin.shellchange.utils.empty
import com.knowledge.mnlin.shellchange.utils.toast
import com.knowledge.mnlin.shellchange.R
import com.knowledge.mnlin.shellchange.pagebase.CustomPageImpl
import kotlinx.android.synthetic.main.page_news_detail.view.*

/**
 * function :
 *
 * Created on 2019/11/22  0:27
 * @author mnlin
 */
@InjectPageLayoutRes(layoutResId = R.layout.page_news_detail)
class NewsDetailPage : CustomPageImpl() {
    override fun onPageViewInject() {
        super.onPageViewInject()

        contentView.apply {
            wv_news.initSetting()
            wv_news.setBackgroundColor(dispatchGetColor(R.color.skin_scaffold_deep_background_color))

            iv_back.dOnClick {
                super.onBackPressed()
            }

            iv_agree.dOnClick {
                iv_agree.isSelected = !iv_agree.isSelected

                toast(if (iv_agree.isSelected) "star" else "cancel")
            }

            iv_collect.dOnClick {
                iv_collect.isSelected = !iv_collect.isSelected

                toast(if (iv_collect.isSelected) "collect" else "cancel")
            }

            iv_share.dOnClick {
                toast("share")
            }
        }
    }

    override fun onPageActive() {
        super.onPageActive()

        contentView.wv_news
            .loadUrl(
                intentBundle?.get("url")?.toString()
                    ?: "file:///android_asset/html/temp.html",
                mapOf("Content-Type" to "text/html;charset=UTF-8")
            )
            .empty("file:///android_asset/")
            .empty("web_url") {
                mapOf("Content-Type" to "text/html;charset=UTF-8")
            }
    }


    override fun onBackPressed(): Boolean {
        return contentView.wv_news.let {
            if (it.canGoBack()) {
                it.goBack()
                true
            } else {
                super.onBackPressed()
            }
        }
    }
}

/**
 * init the webview's setting for user
 */
private fun <T : WebView> T.initSetting() {
    settings?.apply {
        setAppCacheEnabled(true)
        domStorageEnabled = true
        databaseEnabled = true
        javaScriptEnabled = true
        setSupportZoom(true)
        builtInZoomControls = true
        displayZoomControls = false
        useWideViewPort = true
        loadWithOverviewMode = true
        layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        javaScriptCanOpenWindowsAutomatically = true
        loadWithOverviewMode = true
        cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        defaultTextEncodingName = "UTF-8"
        setSupportZoom(true)
        textSize = WebSettings.TextSize.NORMAL
    }

    webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}