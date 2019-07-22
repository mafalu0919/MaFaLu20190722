package com.bawei.mafalu20190722.data.net;

import android.widget.EditText;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *@Auther:mfl
 *@Date: 2019/7/22
 *@Time:9:35
 *@Description:
 * */public interface ApiService {
    //添加收获地址
    @FormUrlEncoded
     @POST("small/user/verify/v1/addReceiveAddress")
    Observable<ResponseBody> addReceiveAddress(@Header("userId") String userId, @Header("sessionId")String sessionId
     , @Field("realName") String realName, @Field("phone") String phone, @Field("address") String address
     , @Field("zipCode") String zipCode);
    //查询收获地址
    @GET("small/user/verify/v1/receiveAddressList")
    Observable<ResponseBody> receiveAddressList(@Header("userId") String userId,@Header("sessionId")String sessionId);

    //创建订单
    @FormUrlEncoded
    @POST("small/order/verify/v1/createOrder")
    Observable<ResponseBody>createOrder(@Header("userId") String userId, @Header("sessionId")String sessionId
    , @Field("orderInfo") String orderInfo, @Field("totalPrice") String totalPrice, @Field("addressId") String addressId);
    //查询订单
    @GET("small/order/verify/v1/findOrderListByStatus")
 Observable<ResponseBody> queryOrder(@Header("userId") String userId, @Header("sessionId")String sessionId
    , @Query("status") String status,@Query("page") String page,@Query("count")String count);
 }
