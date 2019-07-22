package com.bawei.mafalu20190722.di.presenter;

import com.bawei.mafalu20190722.di.model.HomeModelIml;
import com.bawei.mafalu20190722.di.contract.HomeContract;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:9:20
 *@Description:
 * */public class HomePresenterIml<V extends HomeContract.HomeView> extends BasePresenter<V> {

    private final HomeModelIml homeModelIml;

    public HomePresenterIml() {
        homeModelIml = new HomeModelIml();
    }
    public void homeAddressData(String realName, String phone, String address, String zipCode){
        homeModelIml.homeRequest(realName,phone,address,zipCode,new HomeContract.HomeModel.HomeCallBack() {
            @Override
            public void homeResult(String string) {
                getView().homeData(string);
            }
        });
    }
    public void homeQueryAddress(){
        homeModelIml.homeQueryRequest(new HomeContract.HomeModel.HomeQueryCallBack() {
            @Override
            public void homeResult(String string) {
               getView().queryAddress(string);
            }
        });
    }

    public void createOrder(String orderInfo, String totalPrice, String addressId){
        homeModelIml.createOrder(orderInfo,totalPrice,addressId,new HomeContract.HomeModel.CreateOrderCallBack() {
            @Override
            public void homeResult(String string) {
                getView().createOrder(string);
            }
        });
    }
}
