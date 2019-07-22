package com.bawei.mafalu20190722.di.presenter;

import java.lang.ref.WeakReference;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:9:19
 *@Description:P层基类
 * */public class BasePresenter<V> {

    private WeakReference<V> weakReference;

    public void attacth(V v){
        weakReference = new WeakReference<>(v);
     }
     public V getView(){
         return weakReference.get();
     }
     public void deacth(){
         weakReference.clear();

     }}
