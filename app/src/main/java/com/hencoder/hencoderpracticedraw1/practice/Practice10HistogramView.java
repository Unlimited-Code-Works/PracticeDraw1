package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private static int RECT_SKIP_DISTANCE = 15;
    private static int RECT_LONG = 80;
    private static int TEXT_SKIP_DISTANCE = 100;

    private static String[] texts = { "Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    private static int[] highs = { 0, 20, 20, 200, 300, 350, 280 };

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.drawLine(150, 50, 150, 450, paint);
        canvas.drawLine(150, 450, 900, 450, paint);

        paint.setTextSize(24);
        int textStartX = 180;
        int textStartY = 480;
        for (String s: texts) {
            canvas.drawText(s, textStartX, textStartY, paint);
            textStartX += TEXT_SKIP_DISTANCE;
        }

        paint.setColor(Color.GREEN);
        int rectStartX = 170;
        int rectStartY = 450;
        for (int high: highs) {
            canvas.drawRect(rectStartX, rectStartY - high, rectStartX + RECT_LONG, rectStartY, paint);
            rectStartX += RECT_LONG + RECT_SKIP_DISTANCE;
        }


    }
}
