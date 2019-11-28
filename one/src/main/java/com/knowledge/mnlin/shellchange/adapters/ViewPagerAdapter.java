package com.knowledge.mnlin.shellchange.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * Created on 2019/11/28  23:54
 * function :
 *
 * @author mnlin
 */
public class ViewPagerAdapter<T extends View> extends PagerAdapter {
    private List<T> pages;

    public ViewPagerAdapter(List<T> pages) {
        this.pages = pages;
    }

    public int getCount() {
        return this.pages.size();
    }

    public List<T> getDatas() {
        return this.pages;
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        T item = pages.get(position);
        container.addView(item);
        return item;
    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((T) object);
    }

    @Nullable
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
