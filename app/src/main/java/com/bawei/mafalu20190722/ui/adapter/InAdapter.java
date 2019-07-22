package com.bawei.mafalu20190722.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bawei.mafalu20190722.R;
import com.bawei.mafalu20190722.data.beans.OrderBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:11:42
 *@Description:
 * */public class InAdapter extends BaseQuickAdapter<OrderBean.OrderListBean.DetailListBean, BaseViewHolder> {
    public InAdapter(int layoutResId, @Nullable List<OrderBean.OrderListBean.DetailListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean.OrderListBean.DetailListBean item) {
        helper.setText(R.id.name,item.getCommodityName());
        ImageView img=helper.getView(R.id.img);
        Glide.with(mContext).load(item.getCommodityPic()).into(img);
    }
}
