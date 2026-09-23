package com.google.android.apps.gmm.base.views.squeezedlabel;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.libraries.navigation.internal.ad.b;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.mx.w;
import com.google.android.libraries.navigation.internal.nc.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class SqueezedLabelView extends AppCompatTextView {
    public static final /* synthetic */ int b = 0;
    public float a;
    private float c;
    private float d;
    private int e;
    private float f;
    private int g;

    public SqueezedLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
        this.c = 0.7f;
        float fApplyDimension = TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics());
        this.d = fApplyDimension;
        this.a = 1.0f;
        setTextSize(0, fApplyDimension);
    }

    public static w a(dd ddVar) {
        return ch.d(b.DESIRED_TEXT_SIZE, ddVar);
    }

    public static w b(ap apVar) {
        return ch.e(b.DESIRED_TEXT_SIZE, apVar);
    }

    public static w c(ap apVar) {
        return ch.e(b.MIN_TEXT_SIZE, apVar);
    }

    private final void e() {
        this.f = -1.0f;
        this.g = -1;
    }

    public final void d(int i) {
        this.g = i;
        float textSize = getTextSize();
        float f = this.d;
        if (textSize != f) {
            super.setTextSize(0, f);
        }
        if (getTextScaleX() != 1.0f) {
            super.setTextScaleX(1.0f);
        }
        CharSequence text = getText();
        if (getTransformationMethod() != null) {
            text = getTransformationMethod().getTransformation(text, this);
        }
        float desiredWidth = Layout.getDesiredWidth(text, getPaint());
        this.f = desiredWidth;
        float f2 = i;
        if (desiredWidth > f2) {
            super.setTextScaleX(Math.max(this.c, (f2 / desiredWidth) - 0.01f));
            float desiredWidth2 = Layout.getDesiredWidth(text, getPaint());
            while (desiredWidth2 > f2) {
                float fMax = (int) Math.max(this.a, (f2 / desiredWidth2) * getTextSize());
                super.setTextSize(0, fMax);
                if (fMax == this.a) {
                    return;
                } else {
                    desiredWidth2 = Layout.getDesiredWidth(text, getPaint());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.e;
        if (i3 > 0 && mode != 0 && size > i3) {
            i = View.MeasureSpec.makeMeasureSpec(i3, mode);
            size = i3;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        if (mode == 0) {
            d(Integer.MAX_VALUE);
        } else if (this.f < 0.0f || this.g != paddingLeft) {
            d(paddingLeft);
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    protected final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        e();
        requestLayout();
        invalidate();
    }

    public final void setDesiredTextSize(float f) {
        float fMax = Math.max(1.0f, f);
        if (fMax != this.d) {
            this.d = fMax;
            e();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.TextView
    public final void setMaxWidth(int i) {
        if (i != this.e) {
            this.e = i;
            e();
        }
    }

    public final void setMinScaleX(float f) {
        float fMax = Math.max(0.0f, Math.min(1.0f, f));
        if (fMax != this.c) {
            this.c = fMax;
            e();
            requestLayout();
            invalidate();
        }
    }

    public final void setMinTextSize(float f) {
        float fMax = Math.max(1.0f, f);
        if (fMax != this.a) {
            this.a = fMax;
            e();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        setDesiredTextSize(getTextSize());
    }

    @Override // android.widget.TextView
    public final void setTextScaleX(float f) {
        super.setTextScaleX(f);
        e();
    }

    @Override // android.widget.TextView
    public final void setTextSize(float f) {
        super.setTextSize(f);
        e();
    }
}
