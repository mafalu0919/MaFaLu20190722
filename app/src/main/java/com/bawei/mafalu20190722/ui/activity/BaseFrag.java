package com.bawei.mafalu20190722.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.mafalu20190722.di.presenter.BasePresenter;
import com.bawei.mafalu20190722.di.presenter.HomePresenterIml;

import butterknife.ButterKnife;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:9:21
 *@Description:
 * */public abstract class BaseFrag<V,P extends BasePresenter<V>> extends Fragment {

    public P pres;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), getLayput(), null);
        ButterKnife.bind(inflate);
        return inflate;
    }

    protected abstract int getLayput();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pres = content();
        initData();
    }

    protected abstract void initData();

    protected abstract P content();

    @Override
    public void onResume() {
        super.onResume();
        if(null!=pres){
            pres.attacth((V) this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null!=pres){
            pres.deacth();
        }
    }
}
