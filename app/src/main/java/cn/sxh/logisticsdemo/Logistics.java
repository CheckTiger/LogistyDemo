package cn.sxh.logisticsdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @auther snowTiger
 * @mail SnowTigerSong@gmail.com
 * @time 2017/4/11 22:17
 */

public class Logistics extends LinearLayout {

    private static final int GRAVITY_LEFT = 2;
    private static final int GRAVITY_RIGHT = 4;
    private static final int GRAVITY_MIDDLE = 0;
    private static final int GRAVITY_TOP = 1;
    private static final int GRAVITY_BOTTOM = 3;

    private Bitmap mIcon;
    private int lineMarginSide;
    private int lineDynamicDimen;

    private int lineStrkeWidth;
    private int lineColor;

    private int pointSize;
    private int pointColor;

    private Paint linePaint;
    private Paint pointPaint;

    private int firstX;
    private int firstY;

    private int lastX;
    private int lastY;

    private int curOrientation = VERTICAL;

    private int lineGravity = GRAVITY_LEFT;

    private Context mContext;
    public Logistics(Context context) {
        super(context);
    }

    public Logistics(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Logistics(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
