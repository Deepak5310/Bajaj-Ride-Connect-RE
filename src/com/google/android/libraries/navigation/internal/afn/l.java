package com.google.android.libraries.navigation.internal.afn;

import android.graphics.Paint;
import org.xml.sax.Attributes;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l {
    public Paint a;
    public Paint b;
    public final float c;
    public float d;
    public String e;
    public boolean f;
    public int g;

    public l(m mVar, Attributes attributes) {
        this.a = null;
        this.b = null;
        this.g = 0;
        Float fValueOf = Float.valueOf(0.0f);
        this.c = mVar.a("x", attributes, fValueOf).floatValue();
        this.d = mVar.a("y", attributes, fValueOf).floatValue();
        this.e = null;
        this.f = true;
        k kVar = new k(attributes);
        if (mVar.b(kVar, mVar.s)) {
            Paint paint = new Paint(mVar.h);
            this.b = paint;
            mVar.d(attributes, paint);
        }
        if (mVar.c(kVar)) {
            Paint paint2 = new Paint(mVar.d);
            this.a = paint2;
            mVar.d(attributes, paint2);
        }
        String strD = o.d("alignment-baseline", attributes);
        if ("middle".equals(strD)) {
            this.g = 1;
        } else if ("top".equals(strD)) {
            this.g = 2;
        }
    }
}
