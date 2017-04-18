package cn.sxh.logisticsdemo.weiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import cn.sxh.logisticsdemo.R;

/**
 * @auther snowTiger
 * @mail SnowTigerSong@gmail.com
 * @time 2017/4/11 22:17
 */

public class Logistics extends LinearLayout {
    /**
     * 内部元素摆放的定义
     */
    private static final int GRAVITY_LEFT = 2;
    private static final int GRAVITY_RIGHT = 4;
    private static final int GRAVITY_MIDDLE = 0;
    private static final int GRAVITY_TOP = 1;
    private static final int GRAVITY_BOTTOM = 3;
    /**
     * 图片
     */
    private Bitmap mIcon;
    /**
     * 线本身的属性
     */
    private int lineMarginSide;
    private int lineDynamicDimen;
    /**
     * 线的边框属性元素
     */
    private int lineStrokeWidth;
    private int lineColor;
    /**
     * 点的属性元素
     */
    private int pointSize;
    private int pointColor;
    /**
     * 线的画笔
     */
    private Paint linePaint;
    /**
     * 点的画笔
     */
    private Paint pointPaint;
    /**
     * 第一个点的位置
     */
    private int firstX;
    private int firstY;
    /**
     * 最后一个图的位置
     */
    private int lastX;
    private int lastY;
    /**
     * 默认垂直
     */
    private int curOrientation = VERTICAL;
    /**
     * 默认左边垂直
     */
    private int lineGravity = GRAVITY_LEFT;

    private Context mContext;

    //开关
    private boolean drawLine = true;

    private int rootLeft;
    private int rootMiddle;
    private int rootRight;
    private int rootTop;
    private int rootBottom;
    //参照点
    private int sideRelative;

    public Logistics(Context context) {
        super(context);
    }

    public Logistics(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Logistics(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.UnderLineLinearLayout);
        lineMarginSide = a.getDimensionPixelOffset(R.styleable.UnderLineLinearLayout_line_margin_side,10);
        lineDynamicDimen = a.getDimensionPixelOffset(R.styleable.UnderLineLinearLayout_line_dynamic_dimen,0);
        lineStrokeWidth = a.getDimensionPixelOffset(R.styleable.UnderLineLinearLayout_line_stroke_width, 2);
        lineColor = a.getColor(R.styleable.UnderLineLinearLayout_line_v_color, 0xff3dd1a5);
        pointSize = a.getDimensionPixelSize(R.styleable.UnderLineLinearLayout_point_size, 8);
        pointColor = a.getColor(R.styleable.UnderLineLinearLayout_point_color, 0xff3dd1a5);
        lineGravity = a.getInt(R.styleable.UnderLineLinearLayout_line_gravity, GRAVITY_LEFT);

        int iconRes = a.getResourceId(R.styleable.UnderLineLinearLayout_icon_src,R.drawable.point);
        Drawable temp = context.getResources().getDrawable(iconRes);
        if (drawableToBitmap(temp) != null) {
            mIcon = drawableToBitmap(temp);
        }
        curOrientation = getOrientation();
        a.recycle();
        setWillNotDraw(false);
        initView(context);
    }

    /**
     * drawable资源转化为Bitmap资源
     * @param temp
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable temp) {
        Bitmap bitmap = Bitmap.createBitmap(
                temp.getIntrinsicWidth(),
                temp.getIntrinsicHeight(),
                temp.getOpacity()!= PixelFormat.OPAQUE? Bitmap.Config.ARGB_8888: Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        temp.setBounds(0,0,temp.getIntrinsicWidth(),temp.getIntrinsicHeight());
        temp.draw(canvas);
        return bitmap;
    }

    /**
     * 初始化
     * @param context
     */
    private void initView(Context context) {
        this.mContext = context;

        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setDither(true);
        linePaint.setColor(lineColor);
        linePaint.setStrokeWidth(lineStrokeWidth);
        linePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        pointPaint = new Paint();
        pointPaint.setAntiAlias(true);
        pointPaint.setDither(true);
        pointPaint.setColor(pointColor);
        pointPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        calculateSideRelative();
        if (drawLine) {
            drawTimeLine(canvas);
        }
    }

    private void calculateSideRelative() {
        rootLeft = getLeft();
        rootTop = getTop();
        rootRight = getRight();
        rootBottom = getBottom();
        if (curOrientation == VERTICAL) rootMiddle = (rootLeft + rootRight) >> 1;
        if (curOrientation == HORIZONTAL) rootMiddle = (rootTop + rootBottom) >> 1;

    }

    private void drawTimeLine(Canvas canvas) {

    }

}
