package com.ufo.stickitemdecoration;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 日期:2018/3/9
 * <p>
 * 作者:xudiwei
 * <p>
 * 描述:
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
    private List<DataBean> mList;

    public Adapter(Context context, List<DataBean> list) {
        this.mList = list;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);

        return new MyHolder(item);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        MyHolder viewHolder = (MyHolder) holder;
        viewHolder.mTextView.setText(mList.get(position).getData());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_item);
        }
    }
}
