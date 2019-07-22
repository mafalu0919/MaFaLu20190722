package com.bawei.mafalu20190722.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.mafalu20190722.R;
import com.bawei.mafalu20190722.data.beans.OrderBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:11:20
 *@Description:
 * */public class OrderAdapter extends BaseQuickAdapter<OrderBean.OrderListBean, BaseViewHolder> {
    public OrderAdapter(int layoutResId, @Nullable List<OrderBean.OrderListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean.OrderListBean item) {
        helper.setText(R.id.ding,item.getOrderId());
        List<OrderBean.OrderListBean.DetailListBean> detailList = item.getDetailList();
        RecyclerView inRecyler=helper.getView(R.id.inRecyley);
        inRecyler.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        inRecyler.setAdapter(new InAdapter(R.layout.initem,detailList));

    }
}
