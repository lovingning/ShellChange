package com.knowledge.mnlin.shellchange.bases;


import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.knowledge.mnlin.linemenuview.LineMenuListener;
import com.knowledge.mnlin.linemenuview.LineMenuView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * Created on 2018/1/2
 * function : recyclerView 的视图存储器
 *
 * @author LinkTech
 */

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, LineMenuListener {
    public Context context;
    private OnViewClickListener listener;

    @Nullable
    private Integer tag;

    public BaseRecyclerViewHolder(View itemView) {
        this(itemView, null);
    }

    public BaseRecyclerViewHolder(View itemView, OnViewClickListener listener) {
        super(itemView);
        context = itemView.getContext();
        this.listener = listener;
        if (listener != null) {
            if (itemView instanceof LineMenuView) {
                //如果是 LineMenuView ,则设置其他监听方式
                ((LineMenuView) itemView).setOnClickListener((LineMenuListener) this);
            } else {
                itemView.setOnClickListener(this);
            }
        }
    }

    @Override
    public final void onClick(View v) {
        if (listener != null && getCurrentPosition() >= 0) {
            listener.onViewClick(v, tag != null ? tag : getCurrentPosition());
        }
    }

    /**
     * 获取当前位置
     */
    public int getCurrentPosition() {
        return getAdapterPosition();
    }

    /**
     * 设置监听器,默认在主动设置非空监听的情况下,才会有监听事件
     */
    protected void setOnViewClickListener(OnViewClickListener listener) {
        if (listener != null) {
            this.listener = listener;
            itemView.setOnClickListener(this);
        }
    }

    @Override
    public void performSelf(@NotNull LineMenuView lmv) {
        listener.onViewClick(lmv, tag != null ? tag : getCurrentPosition());
    }

    public <T extends Integer> BaseRecyclerViewHolder setTag(@Nullable T tag) {
        this.tag = tag;
        return this;
    }

    /**
     * 自定义view点击事件
     */
    public interface OnViewClickListener {
        /**
         * @param v        被点击的view
         * @param position 所在的position
         */
        void onViewClick(View v, int position);
    }
}
