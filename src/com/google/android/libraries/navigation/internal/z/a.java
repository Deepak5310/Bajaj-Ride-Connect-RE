package com.google.android.libraries.navigation.internal.z;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import com.google.android.libraries.navigation.internal.af.e;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.j;
import com.google.android.libraries.navigation.internal.nc.p;
import com.google.android.libraries.navigation.internal.nc.x;
import com.google.android.libraries.navigation.internal.nc.y;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class a {

    @Deprecated
    public static final ah a;

    @Deprecated
    public static final ah b;

    @Deprecated
    public static final ah c;

    @Deprecated
    public static final ah d;

    @Deprecated
    public static final ah e;

    @Deprecated
    public static final ah f;

    @Deprecated
    public static final ah g;

    @Deprecated
    public static final ah h;
    private static final ap i = com.google.android.libraries.navigation.internal.nc.a.f(0.8d);
    private static final ap j;
    private static final ap k;

    static {
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(4);
        j = aVarG;
        com.google.android.libraries.navigation.internal.nc.a aVarF = com.google.android.libraries.navigation.internal.nc.a.f(2.5d);
        k = aVarF;
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.k, 0, com.google.android.libraries.navigation.internal.m.b.a);
        a = com.google.android.libraries.navigation.internal.m.b.c(i(), null, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.k, 0, com.google.android.libraries.navigation.internal.m.b.b);
        com.google.android.libraries.navigation.internal.m.b.c(i(), null, com.google.android.libraries.navigation.internal.m.b.c);
        com.google.android.libraries.navigation.internal.m.b.c(h(), null, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.c(h(), null, com.google.android.libraries.navigation.internal.m.b.c);
        com.google.android.libraries.navigation.internal.m.b.c(f(), e.a(com.google.android.libraries.navigation.internal.f.b.o, com.google.android.libraries.navigation.internal.v.a.B), com.google.android.libraries.navigation.internal.m.b.c);
        com.google.android.libraries.navigation.internal.m.b.c(e.a(com.google.android.libraries.navigation.internal.f.b.y, com.google.android.libraries.navigation.internal.v.a.s), null, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.c(g(), null, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.A, com.google.android.libraries.navigation.internal.f.b.F, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.c(f(), h(), com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.s, 0, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.s, 0, com.google.android.libraries.navigation.internal.m.b.b);
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.s, com.google.android.libraries.navigation.internal.f.b.E, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.B, com.google.android.libraries.navigation.internal.f.b.A, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.c(g(), com.google.android.libraries.navigation.internal.w.b.b(), com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.A, com.google.android.libraries.navigation.internal.f.b.s, com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.c(f(), e.a(com.google.android.libraries.navigation.internal.f.b.s, com.google.android.libraries.navigation.internal.v.a.j), com.google.android.libraries.navigation.internal.m.b.a);
        com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.A, com.google.android.libraries.navigation.internal.f.b.F, com.google.android.libraries.navigation.internal.m.b.e);
        b = com.google.android.libraries.navigation.internal.m.b.c(f(), h(), com.google.android.libraries.navigation.internal.m.b.e);
        com.google.android.libraries.navigation.internal.m.b.c(e.a(com.google.android.libraries.navigation.internal.f.b.A, com.google.android.libraries.navigation.internal.v.a.a), h(), com.google.android.libraries.navigation.internal.m.b.e);
        c = k(com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.A, com.google.android.libraries.navigation.internal.f.b.F, com.google.android.libraries.navigation.internal.m.b.e), j.f(com.google.android.libraries.navigation.internal.f.b.i), aVarF);
        d = k(com.google.android.libraries.navigation.internal.m.b.c(f(), h(), com.google.android.libraries.navigation.internal.m.b.e), e.a(com.google.android.libraries.navigation.internal.f.b.i, com.google.android.libraries.navigation.internal.f.b.j), aVarF);
        e = k(com.google.android.libraries.navigation.internal.m.b.c(f(), e.a(com.google.android.libraries.navigation.internal.f.b.F, com.google.android.libraries.navigation.internal.f.b.E), com.google.android.libraries.navigation.internal.m.b.e), e.a(com.google.android.libraries.navigation.internal.f.b.i, com.google.android.libraries.navigation.internal.f.b.u), aVarG);
        f = k(com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.s, com.google.android.libraries.navigation.internal.f.b.E, com.google.android.libraries.navigation.internal.m.b.e), j.f(com.google.android.libraries.navigation.internal.f.b.u), aVarG);
        g = k(com.google.android.libraries.navigation.internal.m.b.b(com.google.android.libraries.navigation.internal.f.b.r, com.google.android.libraries.navigation.internal.f.b.D, com.google.android.libraries.navigation.internal.m.b.e), j.f(com.google.android.libraries.navigation.internal.f.b.u), aVarG);
        h = com.google.android.libraries.navigation.internal.m.b.c(e.a(com.google.android.libraries.navigation.internal.f.b.w, com.google.android.libraries.navigation.internal.v.a.r), e.a(com.google.android.libraries.navigation.internal.f.b.v, com.google.android.libraries.navigation.internal.v.a.C), com.google.android.libraries.navigation.internal.m.b.e);
    }

    @Deprecated
    public static ah a(ap apVar, x xVar) {
        return j(com.google.android.libraries.navigation.internal.ae.b.c(xVar, xVar, com.google.android.libraries.navigation.internal.nc.a.g(0), apVar), j.f(com.google.android.libraries.navigation.internal.f.b.i), apVar, k);
    }

    @Deprecated
    public static ah b(ap apVar, x xVar) {
        return j(com.google.android.libraries.navigation.internal.ae.b.c(xVar, xVar, com.google.android.libraries.navigation.internal.nc.a.g(0), apVar), j.f(com.google.android.libraries.navigation.internal.f.b.u), apVar, j);
    }

    @Deprecated
    public static ah c(ap apVar) {
        return j(com.google.android.libraries.navigation.internal.ae.b.c(j.f(com.google.android.libraries.navigation.internal.f.b.E), j.f(com.google.android.libraries.navigation.internal.f.b.E), com.google.android.libraries.navigation.internal.nc.a.g(0), apVar), j.f(com.google.android.libraries.navigation.internal.f.b.u), apVar, j);
    }

    @Deprecated
    public static ah d(ap apVar) {
        return j(com.google.android.libraries.navigation.internal.ae.b.c(j.f(com.google.android.libraries.navigation.internal.f.b.F), j.f(com.google.android.libraries.navigation.internal.f.b.F), com.google.android.libraries.navigation.internal.nc.a.g(0), apVar), j.f(com.google.android.libraries.navigation.internal.f.b.i), apVar, k);
    }

    @Deprecated
    public static void e(Context context, Paint paint, x xVar, ap apVar) {
        paint.setColor(xVar.b(context));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(p.b(i, Float.valueOf(2.0f)).a(context));
        paint.setShadowLayer(apVar.e(context), 0.0f, 0.0f, paint.getColor());
    }

    private static final com.google.android.libraries.navigation.internal.af.a f() {
        return e.a(com.google.android.libraries.navigation.internal.f.b.A, com.google.android.libraries.navigation.internal.v.a.y);
    }

    private static final com.google.android.libraries.navigation.internal.af.a g() {
        return e.a(com.google.android.libraries.navigation.internal.f.b.B, com.google.android.libraries.navigation.internal.v.a.y);
    }

    private static final com.google.android.libraries.navigation.internal.af.a h() {
        return e.a(com.google.android.libraries.navigation.internal.f.b.F, com.google.android.libraries.navigation.internal.v.a.C);
    }

    private static final x i() {
        return y.a(e.b(com.google.android.libraries.navigation.internal.w.a.b(), com.google.android.libraries.navigation.internal.w.a.r()), 0.06f);
    }

    @Deprecated
    private static ah j(final ah ahVar, final x xVar, final ap apVar, final ap apVar2) {
        return new ah(new Object[]{ahVar, xVar, apVar}) { // from class: com.google.android.libraries.navigation.internal.z.a.2
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                ah ahVar2 = a.a;
                float[] fArr = new float[8];
                Arrays.fill(fArr, apVar.a(context));
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
                a.e(context, shapeDrawable.getPaint(), xVar, apVar2);
                return new LayerDrawable(new Drawable[]{shapeDrawable, ahVar.a(context)});
            }
        };
    }

    @Deprecated
    private static ah k(final ah ahVar, final x xVar, final ap apVar) {
        return new ah(new Object[]{ahVar, xVar, apVar}) { // from class: com.google.android.libraries.navigation.internal.z.a.1
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                ah ahVar2 = a.a;
                ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                a.e(context, shapeDrawable.getPaint(), xVar, apVar);
                return new LayerDrawable(new Drawable[]{new b(shapeDrawable, com.google.android.libraries.navigation.internal.nc.a.g(4).d(context)), ahVar.a(context)});
            }
        };
    }
}
