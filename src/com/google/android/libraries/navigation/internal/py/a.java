package com.google.android.libraries.navigation.internal.py;

import android.graphics.RectF;
import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.bz;
import com.google.android.libraries.geo.mapcore.internal.model.m;
import com.google.android.libraries.navigation.internal.adg.b;
import com.google.android.libraries.navigation.internal.adg.io;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.rq.g;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    private static final j l = j.e("com.google.android.libraries.navigation.internal.py.a");
    public final ai a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public b g;
    public float h;
    public float i;
    public RectF j;
    public com.google.android.libraries.navigation.internal.qa.a k = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
    private final boolean m;

    public a(float f, float f2, float f3, float f4, b bVar, ai aiVar, float f5, boolean z) {
        this.a = aiVar;
        this.c = f;
        this.d = f2;
        this.e = f3 / 2.0f;
        this.f = f4 / 2.0f;
        this.b = f5;
        this.j = b(aiVar, bVar, f5);
        this.m = z;
        j(bVar);
        this.g = bVar;
        this.h = h(this.j);
        this.i = g(this.j);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static RectF b(ai aiVar, b bVar, float f) {
        float f2;
        bz bzVar = aiVar.s;
        float f3 = 0.0f;
        if (bzVar == null) {
            ((h) l.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1015)).p("Styles for GLCalloutLabels should have a TextBoxStyle.");
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        m mVar = (m) bzVar;
        float f4 = mVar.g;
        float fS = bzVar.s() + f4;
        float f5 = mVar.h;
        float fQ = bzVar.q() + f5;
        float fT = f4 + bzVar.t();
        float fR = f5 + bzVar.r();
        switch (bVar) {
            case CENTER:
                f3 = fS;
                break;
            case LEFT:
                f2 = fT + mVar.i;
                fT = f2;
                f3 = fS;
                break;
            case RIGHT:
                f3 = fS + mVar.i;
                break;
            case TOP:
                fR += mVar.i;
                f3 = fS;
                break;
            case TOP_LEFT:
                float f6 = mVar.k;
                f2 = fT + f6;
                fR = f6 + fR;
                fT = f2;
                f3 = fS;
                break;
            case TOP_RIGHT:
                float f7 = mVar.k;
                f3 = fS + f7;
                fR = f7 + fR;
                break;
            case BOTTOM:
                fQ += mVar.i;
                f3 = fS;
                break;
            case BOTTOM_LEFT:
                float f8 = mVar.k;
                f2 = fT + f8;
                fQ = f8 + fQ;
                fT = f2;
                f3 = fS;
                break;
            case BOTTOM_RIGHT:
                float f9 = mVar.k;
                f3 = fS + f9;
                fQ = f9 + fQ;
                break;
            default:
                fT = 0.0f;
                fR = 0.0f;
                fQ = 0.0f;
                break;
        }
        return new RectF(g.a(f, f3), g.a(f, fQ), g.a(f, fT), g.a(f, fR));
    }

    private final float g(RectF rectF) {
        return this.d + rectF.top + rectF.bottom;
    }

    private final float h(RectF rectF) {
        return ((((this.c + rectF.left) + rectF.right) + a(this.a)) - this.e) - this.f;
    }

    private final int i(float f) {
        return Math.round(this.b * f);
    }

    public final float a(ai aiVar) {
        if (aiVar != null && aiVar.p() && ((m) aiVar.s).f68n == io.PILL) {
            return this.d;
        }
        return 0.0f;
    }

    public final void c(b bVar) {
        j(bVar);
        if (bVar != this.g) {
            this.g = bVar;
            RectF rectFB = b(this.a, bVar, this.b);
            this.j = rectFB;
            this.h = h(rectFB);
            this.i = g(this.j);
        }
    }

    public final void d(float f, float f2, float f3, b bVar, RectF rectF, com.google.android.libraries.navigation.internal.qa.a aVar) {
        ay ayVar = new ay();
        f(f, f2, f3, bVar, rectF, ayVar);
        float fH = h(rectF);
        float fG = g(rectF);
        float f4 = ayVar.b;
        float f5 = (fH / 2.0f) * f3;
        float f6 = ayVar.c;
        float f7 = (fG / 2.0f) * f3;
        aVar.d(f4 - f5, f6 - f7, f4 + f5, f6 + f7);
    }

    public final void e(float f, float f2, com.google.android.libraries.navigation.internal.qa.a aVar) {
        d(f, f2, 1.0f, this.g, this.j, aVar);
    }

    public final void f(float f, float f2, float f3, b bVar, RectF rectF, ay ayVar) {
        float fI;
        float f4;
        float fI2;
        float f5;
        float fI3;
        float fI4;
        float f6;
        float fH = h(rectF);
        float fG = g(rectF);
        float fI5 = 0.0f;
        if (this.a.p()) {
            ai aiVar = this.a;
            int iOrdinal = bVar.ordinal();
            bz bzVar = aiVar.s;
            switch (iOrdinal) {
                case 1:
                    fI = i(bzVar.t());
                    f4 = fH / 2.0f;
                    fI2 = (i(bzVar.r()) - i(bzVar.q())) / 2.0f;
                    f6 = fI - f4;
                    float f7 = fI2;
                    fI5 = f6;
                    fI4 = f7;
                    break;
                case 2:
                    f5 = fH / 2.0f;
                    fI3 = i(bzVar.s());
                    fI2 = (i(bzVar.r()) - i(bzVar.q())) / 2.0f;
                    f6 = f5 - fI3;
                    float f8 = fI2;
                    fI5 = f6;
                    fI4 = f8;
                    break;
                case 3:
                    fI5 = (i(bzVar.t()) - i(bzVar.s())) / 2.0f;
                    fI4 = i(bzVar.r()) - (fG / 2.0f);
                    break;
                case 4:
                    fI = i(bzVar.t());
                    f4 = fH / 2.0f;
                    fI2 = i(bzVar.r()) - (fG / 2.0f);
                    f6 = fI - f4;
                    float f9 = fI2;
                    fI5 = f6;
                    fI4 = f9;
                    break;
                case 5:
                    f5 = fH / 2.0f;
                    fI3 = i(bzVar.s());
                    fI2 = i(bzVar.r()) - (fG / 2.0f);
                    f6 = f5 - fI3;
                    float f10 = fI2;
                    fI5 = f6;
                    fI4 = f10;
                    break;
                case 6:
                    fI5 = (i(bzVar.t()) - i(bzVar.s())) / 2.0f;
                    fI4 = (fG / 2.0f) - i(bzVar.q());
                    break;
                case 7:
                    fI = i(bzVar.t());
                    f4 = fH / 2.0f;
                    fI2 = (fG / 2.0f) - i(bzVar.q());
                    f6 = fI - f4;
                    float f11 = fI2;
                    fI5 = f6;
                    fI4 = f11;
                    break;
                case 8:
                    f5 = fH / 2.0f;
                    fI3 = i(bzVar.s());
                    fI2 = (fG / 2.0f) - i(bzVar.q());
                    f6 = f5 - fI3;
                    float f12 = fI2;
                    fI5 = f6;
                    fI4 = f12;
                    break;
            }
            ayVar.q(fI5, fI4);
            ayVar.p(f3);
            ayVar.i(f, f2);
        }
        ((h) l.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1016)).p("Styles for CalloutGeometries should have a TextBoxStyle.");
        fI4 = 0.0f;
        ayVar.q(fI5, fI4);
        ayVar.p(f3);
        ayVar.i(f, f2);
    }

    private final void j(b bVar) {
        if (this.m) {
            ai aiVar = this.a;
            if (((aiVar == null || !aiVar.p()) ? mb.a : fy.o(((m) this.a.s).m)).contains(bVar)) {
                return;
            }
            ((h) l.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1017)).p("The requested anchor position is not supported.");
        }
    }
}
