package com.knowledge.mnlin.shellchange.beans

import androidx.annotation.DrawableRes

/**************************************
 * function : more-page and more-inner-page beans
 *
 * Created on 2019/11/23  0:01
 * @author mnlin
 **************************************/

/**
 * function : news
 *
 * Created on 2019/11/23  0:02
 * @author mnlin
 */
data class MoreBean(
    var imageUrl: Int? = null,
    @DrawableRes
    var imageResId: Int? = null,
    var title: String? = null,
    var readAmount: Int = 0,
    var linkUrl: String? = null
) : Cloneable {
    @Throws(CloneNotSupportedException::class)
    public override fun clone(): MoreBean {
        return MoreBean(
            imageUrl = imageUrl,
            imageResId = imageResId,
            title = title,
            readAmount = readAmount,
            linkUrl = linkUrl
        )
    }
}

