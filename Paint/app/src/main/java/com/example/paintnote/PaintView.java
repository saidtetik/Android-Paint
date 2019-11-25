package com.example.paintnote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PaintView extends View {
    Paint paint;
    Path path;
    int color;
    int stroke;
    private Map<Path, Integer> colorsMap = new HashMap<>();
    private Map <Path,Integer> strokeWidth = new HashMap<>();
    private ArrayList<Path> paths = new ArrayList<>();



    public PaintView(Context context){
        super(context);
        init();

    }
    public PaintView(Context context, AttributeSet attrs){
        super(context,attrs);
        init();

    }

    public void init(){
        paint = new Paint();
        path = new Path();
        color = Color.BLACK;
        stroke = 5;
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(stroke);


    }
    public void clear(){
        paths = new ArrayList<>();
        strokeWidth = new HashMap<>();
        colorsMap = new HashMap<>();


       invalidate();

    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(!paths.isEmpty()){
        for (Path p: paths) {
            paint.setStrokeWidth(strokeWidth.get(p));
            paint.setColor(colorsMap.get(p));
            canvas.drawPath(p,paint);
        }

            paint.setStrokeWidth(stroke);
            paint.setColor(color);
        }

        canvas.drawPath(path,paint);
        invalidate();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                paths.add(path);
                colorsMap.put(path,paint.getColor());
                strokeWidth.put(path,(int)paint.getStrokeWidth());
                path = new Path();
                invalidate();
                break;
            default:
                break;


        }


        return true;
    }
}
