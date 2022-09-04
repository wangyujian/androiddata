package com.example.yujan.android_data.layout_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomDrawableView extends View {
    private ShapeDrawable drawable;

    public CustomDrawableView(Context context) {
        super(context);
    }

    public CustomDrawableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int x = 10;
        int y = 10;
        int width = 50;
        int height = 50;
        setContentDescription("CustomDrawableView");

        drawable = new ShapeDrawable(new OvalShape());
        // If the color isn't set, the shape uses black as the default.
        drawable.getPaint().setColor(0xff74AC23);
        // If the bounds aren't set, the shape can't be drawn.
        drawable.setBounds(x, y, x + width, y + height);
    }

    protected void onDraw(Canvas canvas) {
        drawable.draw(canvas);
    }
}
