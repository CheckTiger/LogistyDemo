package cn.sxh.logisticsdemo.APInterface;

import cn.sxh.logisticsdemo.UserBean;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @auther snowTiger
 * @mail SnowTigerSong@gmail.com
 * @time 2017/4/13 20:43
 */

public interface API_Interface {
    @FormUrlEncoded
    @POST("register_customer")
    Call<UserBean> register(@Field("phone")String phone, @Field("pwd")String pwd);
}
