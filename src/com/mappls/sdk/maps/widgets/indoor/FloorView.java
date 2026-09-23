package com.mappls.sdk.maps.widgets.indoor;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.henninghall.date_picker.props.TextColorProp;
import com.mappls.sdk.maps.R;

/* JADX INFO: loaded from: classes4.dex */
public class FloorView extends FrameLayout {
    private View animationView;
    private ObjectAnimator colorAnim;
    private Floor floor;
    private ColorStateList oldTvColors;
    private ObjectAnimator scale;
    private TextView textView;

    public FloorView(Context context, Floor floor) {
        super(context);
        this.floor = floor;
        initialize(context);
    }

    private void initialize(Context context) {
        View view = new View(context);
        this.animationView = view;
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ContextCompat.getColor(context, R.color.mappls_maps_blue_indoor));
        this.animationView.setBackground(gradientDrawable);
        this.animationView.setVisibility(4);
        addView(this.animationView);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextAppearance(context, R.style.mappls_maps_layer_radio_button);
        this.oldTvColors = this.textView.getTextColors();
        this.textView.setText(this.floor.getName());
        this.textView.setGravity(17);
        this.textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.textView);
    }

    public Floor getFloor() {
        return this.floor;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        ObjectAnimator objectAnimator = this.colorAnim;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        if (z) {
            this.animationView.setVisibility(0);
            this.textView.setTextColor(Color.parseColor("#4A90E2"));
        } else {
            this.animationView.setVisibility(4);
            this.textView.setTextColor(this.oldTvColors);
        }
        this.scale = null;
        this.colorAnim = null;
    }

    public void setLoading() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.animationView, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
        this.scale = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(500L);
        this.scale.start();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.textView, TextColorProp.name, this.oldTvColors.getDefaultColor(), -1);
        this.colorAnim = objectAnimatorOfInt;
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        this.colorAnim.setDuration(500L);
        this.colorAnim.start();
        this.animationView.setVisibility(0);
    }
}
