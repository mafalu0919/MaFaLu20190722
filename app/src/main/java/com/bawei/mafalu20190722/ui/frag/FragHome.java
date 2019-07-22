package com.bawei.mafalu20190722.ui.frag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.mafalu20190722.R;
import com.bawei.mafalu20190722.data.beans.CreateBean;
import com.bawei.mafalu20190722.data.beans.HomeQueryBean;
import com.bawei.mafalu20190722.di.contract.HomeContract;
import com.bawei.mafalu20190722.di.presenter.HomePresenterIml;
import com.bawei.mafalu20190722.ui.activity.BaseFrag;
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
 *@Description:首页
 * */public class FragHome extends BaseFrag<HomeContract.HomeView, HomePresenterIml<HomeContract.HomeView>> implements HomeContract.HomeView {
    @BindView(R.id.realName)
    EditText realName;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.zipCode)
    EditText zipCode;
    @BindView(R.id.add)
    Button add;
    Unbinder unbinder;
    @BindView(R.id.addressId)
    EditText addressId;
    @BindView(R.id.totalPrice)
    EditText totalPrice;
    @BindView(R.id.orderInfo)
    EditText orderInfo;
    @BindView(R.id.create)
    Button create;
    private int id;

    //添加收获地址
    @Override
    public void homeData(String string) {
        Toast.makeText(getContext(), "" + string, Toast.LENGTH_SHORT).show();
    }

    //查询收货地址
    @Override
    public void queryAddress(String string) {
        Gson gson = new Gson();
        HomeQueryBean homeQueryBean = gson.fromJson(string, HomeQueryBean.class);
        List<HomeQueryBean.ResultBean> result = homeQueryBean.getResult();
        for (int i = 0; i <result.size() ; i++) {
            id = result.get(i).getId();
        }
       ; addressId.setText(id+"");
    }
    //创建订单
    @Override
    public void createOrder(String string) {
        Toast.makeText(getContext(), ""+string, Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();
        CreateBean createBean = gson.fromJson(string, CreateBean.class);
        if(createBean.getStatus()=="0000"){
            startActivity(new Intent(getContext(),FragMy.class));
        }

    }

    @Override
    protected int getLayput() {
        return R.layout.homeitem;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected HomePresenterIml<HomeContract.HomeView> content() {
        return new HomePresenterIml<>();
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


    @OnClick({R.id.add, R.id.create})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                String name = realName.getText().toString();
                String phoneCode = phone.getText().toString();
                String addres = address.getText().toString();
                String code = zipCode.getText().toString();
                pres.homeAddressData(name, phoneCode, addres, code);
                pres.homeQueryAddress();
                break;
            case R.id.create:
                String order = orderInfo.getText().toString();
                String price = totalPrice.getText().toString();
                String id = addressId.getText().toString();

                pres.createOrder(order,price,id);
                break;
        }
    }
}
