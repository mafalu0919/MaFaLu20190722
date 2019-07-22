package com.bawei.mafalu20190722.di.contract;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:10:51
 *@Description:契约类
 * */public interface MyContract {
     //V
    public interface MyView{
        public void myData(String string);
     }
     //P
    public interface MyPresenter<MyView>{
        public void attacth(MyView myView);
        public void deacth();
     }
     //M
    public interface MyModel{
        public void myRequest(String status, String page, String count, MyCallBack callBack);
        public interface MyCallBack{
            public void myResult(String string);
        }
     }
}
