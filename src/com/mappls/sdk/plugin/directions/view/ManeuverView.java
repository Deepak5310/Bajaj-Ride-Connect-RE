package com.mappls.sdk.plugin.directions.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.mappls.sdk.plugin.directions.R;

/* JADX INFO: loaded from: classes4.dex */
public class ManeuverView extends View {
    private String drivingSide;
    private String maneuverModifier;
    private String maneuverType;
    private Pair<String, String> maneuverTypeAndModifier;
    private int primaryColor;
    private float roundaboutAngle;
    private int secondaryColor;
    private PointF size;

    public ManeuverView(Context context) {
        super(context);
        this.maneuverType = null;
        this.maneuverModifier = null;
        this.roundaboutAngle = 180.0f;
        this.maneuverTypeAndModifier = new Pair<>(null, null);
        this.drivingSide = "left";
    }

    private String checkArriveManeuverModifier(String str, String str2) {
        if (str != null && str.equalsIgnoreCase("arrive") && str2 != null) {
            if (str2.contains("right")) {
                return "right";
            }
            if (str2.contains("left")) {
                return "left";
            }
            if (str2.contains("uturn") || str2.contains("straight")) {
                return null;
            }
        }
        return str2;
    }

    private String checkManeuverModifier(String str, String str2) {
        if (str.contentEquals("arrive") || str2 == null) {
            return str;
        }
        return null;
    }

    private boolean checkManeuverTypeWithNullModifier(String str) {
        if (!b.e.contains(str)) {
            return false;
        }
        this.maneuverTypeAndModifier = new Pair<>(str, null);
        invalidate();
        return true;
    }

    private void initializeColorFrom(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ManeuverView);
        this.primaryColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ManeuverView_maneuverViewPrimaryColor, ContextCompat.getColor(getContext(), R.color.white));
        this.secondaryColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ManeuverView_maneuverViewSecondaryColor, ContextCompat.getColor(getContext(), R.color.darkGrey));
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean isNewTypeOrModifier(String str, String str2) {
        return (TextUtils.equals(this.maneuverType, str) && TextUtils.equals(this.maneuverModifier, str2)) ? false : true;
    }

    private void updateRoundaboutAngle(float f) {
        this.roundaboutAngle = b.a(f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            c.i(canvas, this.primaryColor, this.size);
        } else {
            if (this.maneuverType == null) {
                return;
            }
            a aVar = (a) b.b.get(this.maneuverTypeAndModifier);
            if (aVar != null) {
                aVar.a(canvas, Integer.valueOf(this.primaryColor), Integer.valueOf(this.secondaryColor), this.size, Float.valueOf(this.roundaboutAngle));
            }
            setScaleX(b.a(this.maneuverType, this.maneuverModifier, this.drivingSide) ? -1.0f : 1.0f);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setLayerType(1, null);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.size == null) {
            this.size = new PointF(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setDrivingSide(String str) {
        if (str != null) {
            this.drivingSide = str;
        }
    }

    public void setManeuverTypeAndModifier(String str, String str2) {
        if (str != null && (str.equalsIgnoreCase("roundabout") || str.equalsIgnoreCase("rotary"))) {
            str2 = "left";
        }
        if (isNewTypeOrModifier(str, str2)) {
            this.maneuverType = str;
            this.maneuverModifier = str2;
            if (checkManeuverTypeWithNullModifier(str)) {
                return;
            }
            String strCheckManeuverModifier = checkManeuverModifier(str, str2);
            this.maneuverTypeAndModifier = new Pair<>(strCheckManeuverModifier, checkArriveManeuverModifier(strCheckManeuverModifier, str2));
            invalidate();
        }
    }

    public void setPrimaryColor(int i) {
        this.primaryColor = i;
        invalidate();
    }

    public void setRoundaboutAngle(float f) {
        if (!b.d.contains(this.maneuverType) || this.roundaboutAngle == f) {
            return;
        }
        updateRoundaboutAngle(f);
        invalidate();
    }

    public void setSecondaryColor(int i) {
        this.secondaryColor = i;
        invalidate();
    }

    public ManeuverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maneuverType = null;
        this.maneuverModifier = null;
        this.roundaboutAngle = 180.0f;
        this.maneuverTypeAndModifier = new Pair<>(null, null);
        this.drivingSide = "left";
        initializeColorFrom(attributeSet);
    }

    public ManeuverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maneuverType = null;
        this.maneuverModifier = null;
        this.roundaboutAngle = 180.0f;
        this.maneuverTypeAndModifier = new Pair<>(null, null);
        this.drivingSide = "left";
        initializeColorFrom(attributeSet);
    }
}
