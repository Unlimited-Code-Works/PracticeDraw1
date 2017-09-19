package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerWidth = canvas.getWidth() / 2;
        int centerHeight = canvas.getHeight() / 2;
        int redis = centerHeight / 2 + 20;

        RectF rf = new RectF(centerWidth - redis, centerHeight - redis, centerWidth + redis, centerHeight + redis);
        RectF rfRed = new RectF(centerWidth - redis - 10, centerHeight - redis - 10,
                centerWidth + redis - 10, centerHeight + redis - 10);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        Paint paint = new Paint();

        // 1. blue one
        paint.setColor(Color.parseColor("#1E90FF"));
        canvas.drawArc(rf, 75, 100, true, paint);
        // 2. green one
        paint.setColor(Color.parseColor("#2E8B57"));
        canvas.drawArc(rf, 33, 40, true, paint);
        // 3. gray one
        paint.setColor(Color.parseColor("#708090"));
        canvas.drawArc(rf, 21, 10, true, paint);
        // 4. purple
        paint.setColor(Color.parseColor("#6A5ACD"));
        canvas.drawArc(rf, 2, 19, true, paint);
        // 5. yellow one
        paint.setColor(Color.parseColor("#FFD700"));
        canvas.drawArc(rf, 0, -60, true, paint);
        // 6. red one
        paint.setColor(Color.RED);
        canvas.drawArc(rfRed, -60, - 120, true, paint);

        // Lines
        Paint paintLine = new Paint();
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(4);
        paintLine.setColor(Color.WHITE);

        Path path = new Path();
        path.moveTo(centerWidth - 0.66f * redis, centerHeight + 0.66f * redis);
        path.rLineTo(-20, 20);
        path.rLineTo(-100, 0);
        canvas.drawPath(path, paintLine);

        // 饼图
        paintLine.setTextSize(48);
        canvas.drawText("饼图", centerWidth, centerHeight + redis + 50, paintLine);

    }
}
