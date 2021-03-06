package cn.sxh.logisticsdemo.Net;

import cn.sxh.logisticsdemo.APInterface.API_Interface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther snowTiger
 * @mail SnowTigerSong@gmail.com
 * @time 2017/4/13 22:06
 */

public class UtilNet {
    /**
     * 初始化Retrofit 配置相关的参数
     * @return
     */
    public static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_PUBLIC_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    /**
     * 返回我们定义的api接口对象
     * @return
     */
    public static API_Interface getApi_interface(){
        API_Interface apiInterface = UtilNet.getRetrofit().create(API_Interface.class);
        return apiInterface;
    }
}
