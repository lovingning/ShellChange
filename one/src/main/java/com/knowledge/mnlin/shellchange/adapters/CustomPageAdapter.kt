package com.knowledge.mnlin.shellchange.adapters

import com.knowledge.mnlin.page.adapters.PageAdapter
import com.knowledge.mnlin.page.interfaces.Page

/**
 * function :
 *
 * Created on 2019/11/21  0:43
 * @author mnlin
 */
open class CustomPageAdapter<T : Page>(pages: List<T>?, var titles: List<String>) :
    PageAdapter<T>(pages) {
    open override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}