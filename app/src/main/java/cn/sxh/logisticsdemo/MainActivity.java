package cn.sxh.logisticsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.sxh.logisticsdemo.APInterface.API_Interface;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    EditText editText;
    Button button;
    String mPhone;
    private String pwd ="e10adc3949ba59abbe56e057f20f883e";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        editText = (EditText) findViewById(R.id.et);
        button = (Button) findViewById(R.id.btn);
        initListener();
    }

    private void initListener() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPhone = editText.getText().toString().trim();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG,"点击方法开始执行了------>>>>>>"+"注册");
                if (mPhone == null) {
                    return;
                } else {
                    initNet();
                }
            }
        });
    }

    private void initNet() {
        Call<UserBean> registerCall = UtilNet.getApi_interface().register(mPhone,pwd);
        registerCall.enqueue(new Callback<UserBean>() {
                @Override
                public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                    UserBean result = response.body();
                    Log.e(TAG,"是否注册成功----->>>>>"+result.isSuccess());
                    Log.e(TAG,"注册成功时间----->>>>>"+result.getTime());
                    Log.e(TAG,"是否注册成功原因----->>>>>"+result.getReason());
                    Toast.makeText(MainActivity.this, result.getReason(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<UserBean> call, Throwable t) {
                    Log.e(TAG,"错误原因----->>>>>>"+t.getMessage());
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }
}
