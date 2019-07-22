package com.bawei.mafalu20190722.di.presenter;

import com.bawei.mafalu20190722.di.contract.MyContract;
import com.bawei.mafalu20190722.di.model.MyModelIml;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:10:53
 *@Description:
 * */public class MyPresenterIml<V extends MyContract.MyView> extends BasePresenter<V> {

    private final MyModelIml myModelIml;

    public MyPresenterIml() {
        myModelIml = new MyModelIml();
    }
    public void queryOrder(String status, String page, String count){
        myModelIml.myRequest(status,page,count,new MyContract.MyModel.MyCallBack() {
            @Override
            public void myResult(String string) {
                getView().myData(string);
            }
        });
    }
}
