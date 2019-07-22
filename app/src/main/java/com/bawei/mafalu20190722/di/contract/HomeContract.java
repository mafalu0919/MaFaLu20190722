package com.bawei.mafalu20190722.di.contract;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:9:16
 *@Description:首页契约类
 * */public interface HomeContract {
    /**
     * V
     */
    public interface HomeView{
        public void homeData(String string);

        public void queryAddress(String string);

        public void createOrder(String string);
    }
    /**
     * P
     */
    public interface HomePresenter<HomeView>{
        public void attacth(HomeView homeView);
        public void deacth();
    }
    /**
     * M
     */
    public interface HomeModel{

        public void homeRequest(String realName, String phone, String address, String zipCode, HomeCallBack callBack);
        public interface HomeCallBack{
            public void homeResult(String string);
        }


        public interface HomeQueryCallBack{
            public void homeResult(String string);
        }
        public void homeQueryRequest(HomeQueryCallBack queryCallBack);

        public interface CreateOrderCallBack{
            public void homeResult(String string);
        }
        public void createOrder(String orderInfo, String totalPrice, String addressId, CreateOrderCallBack createOrderCallBack);
    }
}
