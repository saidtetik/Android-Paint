package com.example.paintnote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import android.view.MotionEvent;
import android.view.View;


public class PaintView extends View {
    Paint paint = new Paint();
    Path path = new Path();

    public PaintView(Context context){
        super(context);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;
            default:
                break;

        }
        postInvalidate();
        return true;
    }
}
