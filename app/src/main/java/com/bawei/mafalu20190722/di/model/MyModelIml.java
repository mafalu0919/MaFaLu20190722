package com.bawei.mafalu20190722.di.model;

import com.bawei.mafalu20190722.data.net.ApiService;
import com.bawei.mafalu20190722.data.net.Content;
import com.bawei.mafalu20190722.di.contract.MyContract;

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
 *@Time:10:55
 *@Description:
 * */public class MyModelIml implements MyContract.MyModel {
    @Override
    public void myRequest(String status, String page, String count, final MyCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Content.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiService.class)
                .queryOrder("6911","15637647853126911",status,page,count)
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
                            callBack.myResult(string);
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
