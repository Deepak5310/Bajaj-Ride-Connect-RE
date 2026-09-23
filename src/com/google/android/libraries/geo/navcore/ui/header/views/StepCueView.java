package com.google.android.libraries.geo.navcore.ui.header.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.apps.gmm.base.views.squeezedlabel.SqueezedLabelView;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Collection;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class StepCueView extends LinearLayout implements com.google.android.libraries.navigation.internal.qz.g {
    private final SqueezedLabelView a;
    private final SqueezedLabelView b;
    private bq c;
    private com.google.android.libraries.navigation.internal.up.g d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private float j;
    private boolean k;
    private int l;
    private float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f89n;
    private float o;
    private com.google.android.libraries.navigation.internal.up.e p;
    private k q;

    public StepCueView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = k.SHOW_ALWAYS;
        LayoutInflater.from(context).inflate(com.google.android.libraries.navigation.internal.dw.e.e, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        SqueezedLabelView squeezedLabelView = (SqueezedLabelView) findViewById(com.google.android.libraries.navigation.internal.dw.d.s);
        this.a = squeezedLabelView;
        SqueezedLabelView squeezedLabelView2 = (SqueezedLabelView) findViewById(com.google.android.libraries.navigation.internal.dw.d.t);
        this.b = squeezedLabelView2;
        squeezedLabelView.setMaxLines(2);
        squeezedLabelView2.setSingleLine();
        squeezedLabelView.setLayoutDirection(3);
        squeezedLabelView2.setLayoutDirection(3);
        this.e = true;
    }

    private final ev c(SqueezedLabelView squeezedLabelView, float f, int i, int i2, Collection collection, int i3, boolean z) {
        TextPaint textPaint = new TextPaint(squeezedLabelView.getPaint());
        textPaint.setTextScaleX(1.0f);
        textPaint.setTextSize(f);
        com.google.android.libraries.navigation.internal.up.a aVar = new com.google.android.libraries.navigation.internal.up.a(getContext(), collection.size(), i, i2, z, textPaint, this.k, this.l, this.m, this.f89n, this.o, 0, null, null);
        this.d.e(collection, i3, true, this, aVar);
        return aVar.d();
    }

    private final void d() {
        this.a.setVisibility(8);
        this.b.setVisibility(8);
    }

    private final void e() {
        int i;
        if (this.f) {
            i = 3;
        } else {
            i = this.e ? 1 : 2;
        }
        if (this.c != null) {
            this.p = com.google.android.libraries.navigation.internal.up.g.f(getContext(), this.c, i);
        } else {
            int i2 = ev.d;
            this.p = new com.google.android.libraries.navigation.internal.up.e(lv.a, lv.a, 0, 0);
        }
    }

    private static void f(SqueezedLabelView squeezedLabelView, CharSequence charSequence, float f) {
        squeezedLabelView.setText(charSequence);
        squeezedLabelView.setDesiredTextSize(f);
    }

    private final void g() {
        setBaselineAlignedChildIndex(1);
        this.a.setVisibility(0);
        this.b.setVisibility(0);
    }

    private final void h() {
        setBaselineAlignedChildIndex(0);
        this.a.setVisibility(0);
        this.b.setVisibility(8);
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
        if (kVar.p()) {
            post(new j(this));
        }
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.up.e eVar = this.p;
        boolean z = eVar != null;
        boolean z2 = z && eVar.b.isEmpty();
        if (this.c == null || !z || (!z2 ? this.q != k.SHOW_IF_NO_SECONDARY_CUES_PRESENT : this.q != k.SHOW_IF_SECONDARY_CUES_PRESENT)) {
            d();
        } else if (this.p.a.isEmpty()) {
            h();
            this.a.setDesiredTextSize(this.e ? this.g : this.h);
            CharSequence charSequenceB = this.c.p;
            if (this.k) {
                Pattern pattern = com.google.android.libraries.navigation.internal.hf.n.a;
                getResources();
                com.google.android.libraries.navigation.internal.hf.m mVar = new com.google.android.libraries.navigation.internal.hf.m(charSequenceB);
                mVar.g();
                charSequenceB = mVar.b();
            }
            this.a.setText(charSequenceB);
        } else if (this.p.b.isEmpty()) {
            float width = getWidth() * this.j;
            float f = (this.e && this.p.a.size() == 1) ? this.g : this.h;
            int i = (int) width;
            SqueezedLabelView squeezedLabelView = this.a;
            int i2 = true != this.e ? 1 : 2;
            com.google.android.libraries.navigation.internal.up.e eVar2 = this.p;
            ev evVarC = c(squeezedLabelView, f, i2, i, eVar2.a, eVar2.c, true);
            int size = evVarC.size();
            if (size == 0) {
                d();
            } else if (size == 1) {
                f(this.a, (CharSequence) evVarC.get(0), f);
                h();
            } else if (size == 2) {
                f(this.a, (CharSequence) evVarC.get(0), f);
                f(this.b, (CharSequence) evVarC.get(1), f);
                g();
            }
        } else if (this.e) {
            float width2 = getWidth() * this.j;
            SqueezedLabelView squeezedLabelView2 = this.a;
            float f2 = this.g;
            com.google.android.libraries.navigation.internal.up.e eVar3 = this.p;
            int i3 = (int) width2;
            CharSequence charSequence = (CharSequence) gs.c(c(squeezedLabelView2, f2, 1, i3, eVar3.a, eVar3.c, true), "");
            SqueezedLabelView squeezedLabelView3 = this.b;
            float f3 = this.i;
            com.google.android.libraries.navigation.internal.up.e eVar4 = this.p;
            CharSequence charSequence2 = (CharSequence) gs.c(c(squeezedLabelView3, f3, 1, i3, eVar4.b, eVar4.d, true), "");
            f(this.a, charSequence, this.g);
            f(this.b, charSequence2, this.i);
            g();
        } else {
            float width3 = (getWidth() / 2.0f) * this.j;
            SqueezedLabelView squeezedLabelView4 = this.a;
            float f4 = this.h;
            com.google.android.libraries.navigation.internal.up.e eVar5 = this.p;
            int i4 = (int) width3;
            CharSequence charSequence3 = (CharSequence) gs.c(c(squeezedLabelView4, f4, 1, i4, eVar5.a, eVar5.c, false), "");
            SqueezedLabelView squeezedLabelView5 = this.a;
            float f5 = this.h;
            com.google.android.libraries.navigation.internal.up.e eVar6 = this.p;
            f(this.a, TextUtils.concat(charSequence3, StringUtils.SPACE, (CharSequence) gs.c(c(squeezedLabelView5, f5, 1, i4, eVar6.b, eVar6.d, true), "")), this.h);
            h();
        }
        if (this.e && this.b.getVisibility() == 8) {
            this.a.setMaxLines(2);
        } else {
            this.a.setMaxLines(1);
        }
        this.a.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            b();
        }
    }

    public final void setAllowTwoLines(boolean z) {
        this.e = z;
        e();
        b();
    }

    public final void setFirstRowTextSize(ap apVar) {
        if (apVar != null) {
            int iE = apVar.e(getContext());
            this.g = iE;
            if (this.h > iE) {
                this.h = iE;
            }
            SqueezedLabelView squeezedLabelView = this.a;
            float f = iE;
            if (squeezedLabelView.a > f) {
                squeezedLabelView.setMinTextSize(f);
            }
            SqueezedLabelView squeezedLabelView2 = this.b;
            float f2 = squeezedLabelView2.a;
            float f3 = this.g;
            if (f2 > f3) {
                squeezedLabelView2.setMinTextSize(f3);
            }
        }
    }

    public final void setIncludeFontPadding(Boolean bool) {
        this.a.setIncludeFontPadding(bool.booleanValue());
        this.b.setIncludeFontPadding(bool.booleanValue());
    }

    public final void setProperties(l lVar) {
        if (lVar == null) {
            this.c = null;
        } else {
            this.c = lVar.a;
            this.d = lVar.b;
        }
        e();
        b();
    }

    public final void setSecondRowTextSize(ap apVar) {
        if (apVar != null) {
            this.i = apVar.e(getContext());
            e();
            b();
        }
    }

    public final void setSecondaryTextColor(ColorStateList colorStateList) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(0);
        if (colorStateList == null || colorStateList.equals(colorStateListValueOf)) {
            return;
        }
        this.l = colorStateList.getDefaultColor();
    }

    public final void setShowSingleCue(boolean z) {
        this.f = z;
        e();
        b();
    }

    public final void setStepCueShowingPolicy(k kVar) {
        this.q = kVar;
        e();
        b();
    }

    public final void setStyle(m mVar) {
        int iE = mVar.a.e(getContext());
        int iE2 = mVar.b.e(getContext());
        int iE3 = mVar.c.e(getContext());
        int iE4 = mVar.d.e(getContext());
        float f = mVar.e;
        boolean z = mVar.f;
        int iB = mVar.g.b(getContext());
        float f2 = mVar.h;
        float f3 = mVar.i;
        float f4 = mVar.j;
        Typeface typeface = mVar.k;
        int i = mVar.l;
        int iE5 = mVar.m.e(getContext());
        this.g = iE;
        this.h = iE2;
        float f5 = iE3;
        this.a.setMinTextSize(f5);
        this.b.setMinTextSize(f5);
        this.i = iE4;
        this.j = 1.5f;
        this.a.setMinScaleX(0.6666667f);
        this.b.setMinScaleX(0.6666667f);
        this.k = true;
        this.l = iB;
        this.m = 0.6f;
        this.f89n = 0.6f;
        this.o = 0.75f;
        this.a.setTypeface(typeface);
        this.b.setTypeface(typeface);
        this.a.setTextAlignment(5);
        this.b.setTextAlignment(5);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
        marginLayoutParams.topMargin = iE5;
        this.b.setLayoutParams(marginLayoutParams);
        b();
    }

    public final void setTextColor(ColorStateList colorStateList) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(0);
        if (colorStateList == null || colorStateList.equals(colorStateListValueOf)) {
            return;
        }
        this.a.setTextColor(colorStateList);
        this.b.setTextColor(colorStateList);
    }

    public final void setTypeface(Typeface typeface) {
        this.a.setTypeface(typeface);
        this.b.setTypeface(typeface);
    }
}
