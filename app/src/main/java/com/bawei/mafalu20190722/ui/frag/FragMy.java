package com.bawei.mafalu20190722.ui.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bawei.mafalu20190722.R;
import com.bawei.mafalu20190722.data.beans.OrderBean;
import com.bawei.mafalu20190722.di.contract.MyContract;
import com.bawei.mafalu20190722.di.presenter.MyPresenterIml;
import com.bawei.mafalu20190722.ui.activity.BaseFrag;
import com.bawei.mafalu20190722.ui.adapter.OrderAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:9:15
 *@Description:我的
 * */public class FragMy extends BaseFrag<MyContract.MyView, MyPresenterIml<MyContract.MyView>> implements MyContract.MyView {
    @BindView(R.id.all)
    Button all;
    @BindView(R.id.fu)
    Button fu;
    @BindView(R.id.fa)
    Button fa;
    @BindView(R.id.shou)
    Button shou;
    @BindView(R.id.ping)
    Button ping;
    Unbinder unbinder;
    @BindView(R.id.outRecyler)
    RecyclerView outRecyler;
    private String status = "0";
    private String page = "1";
    private String count = "5";

    @Override
    public void myData(String string) {
        Gson gson = new Gson();
        OrderBean orderBean = gson.fromJson(string, OrderBean.class);
        List<OrderBean.OrderListBean> orderList = orderBean.getOrderList();
        outRecyler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        OrderAdapter orderAdapter = new OrderAdapter(R.layout.fuitem, orderList);
        outRecyler.setAdapter(orderAdapter);
    }

    @Override
    protected int getLayput() {
        return R.layout.myitem;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MyPresenterIml<MyContract.MyView> content() {
        return new MyPresenterIml<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.all, R.id.fu, R.id.fa, R.id.shou, R.id.ping})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.all:
                pres.queryOrder(status, page, count);
                break;
            case R.id.fu:
                break;
            case R.id.fa:
                break;
            case R.id.shou:
                break;
            case R.id.ping:
                break;
        }
    }
}
