package cn.sxh.logisticsdemo.ui;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import cn.sxh.logisticsdemo.R;

public class LoginActivity extends AppCompatActivity implements GLSurfaceView.Renderer{

    private TextView mTextView;
    private GLSurfaceView.Renderer renderer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI() {
        mTextView = (TextView) findViewById(R.id.tv);
        initOpenGl();
    }

    private void initOpenGl() {
        GLSurfaceView glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(renderer);
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        //抗抖动
        gl10.glDisable(GL10.GL_DITHER);
        //系统对透视的修正
        gl10.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_FASTEST);
        gl10.glClearColor(0,0,0,0);
        //设置阴影的平滑模式
        gl10.glShadeModel(GL10.GL_SMOOTH);
        //启用深度测试
        gl10.glEnable(GL10.GL_ALPHA_TEST);
        //设置深度测试的类型
        gl10.glDepthFunc(GL10.GL_LEQUAL);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        gl10.glViewport(0,0,width,height);
        gl10.glMatrixMode(GL10.GL_PROJECTION);
        gl10.glLoadIdentity();
        float ratio = width/height;
        gl10.glFrustumf(-ratio,ratio,-1,1,1,10);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        gl10.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
    }
}
