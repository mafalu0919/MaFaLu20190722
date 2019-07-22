package com.bawei.mafalu20190722.di.model;

import com.bawei.mafalu20190722.data.net.ApiService;
import com.bawei.mafalu20190722.data.net.Content;
import com.bawei.mafalu20190722.di.contract.HomeContract;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:9:34
 *@Description:首页M层实现类
 * */public class HomeModelIml implements HomeContract.HomeModel {
    @Override
    public void homeRequest(String realName, String phone, String address, String zipCode, final HomeCallBack callBack) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Content.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiService.class)
                .addReceiveAddress("6911","15637647853126911",realName,phone,address,zipCode)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            callBack.homeResult(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void homeQueryRequest(final HomeQueryCallBack queryCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Content.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiService.class)
                .receiveAddressList("6911","15637647853126911")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                           queryCallBack.homeResult(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void createOrder(String orderInfo, String totalPrice, String addressId, final CreateOrderCallBack createOrderCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Content.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiService.class)
                .createOrder("6911","15637647853126911",orderInfo,totalPrice,addressId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                           createOrderCallBack.homeResult(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
