package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.libraries.navigation.internal.abh.fn;
import com.google.android.libraries.navigation.internal.abh.fw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements fn, ab {
    private final fw a;
    private final s b;
    private final w c;
    private List d;
    private List e;
    private final List f;
    private final List g;

    public x(fw fwVar, s sVar) {
        w wVar = w.a;
        com.google.android.libraries.navigation.internal.abf.s.k(fwVar, "poly");
        this.a = fwVar;
        this.b = sVar;
        sVar.j(this);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        com.google.android.libraries.navigation.internal.abf.s.k(wVar, "polyUtils");
        this.c = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abl.ab
    public final float a() {
        return this.a.z();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fn
    public final void b(Set set) {
        this.b.m();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fn
    public final void c(int i) {
        this.b.m();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fn
    public final void d() {
        this.b.n(this);
    }

    @Override // com.google.android.libraries.navigation.internal.abl.ab
    public final void e(Canvas canvas, aa aaVar) {
        if (this.a.J()) {
            Path path = new Path();
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.a.E(this.f);
            this.c.a(this.f, aaVar, this.d, path);
            this.a.D(this.g);
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                this.c.a((List) it2.next(), aaVar, this.e, path);
            }
            int iA = this.a.A();
            Paint paint = (Paint) w.b.get();
            com.google.android.libraries.navigation.internal.abf.s.k(canvas, "canvas");
            com.google.android.libraries.navigation.internal.abf.s.k(paint, "paint");
            if (!path.isEmpty() && Color.alpha(iA) != 0) {
                path.setFillType(Path.FillType.EVEN_ODD);
                paint.reset();
                paint.setAntiAlias(true);
                paint.setColor(iA);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawPath(path, paint);
            }
            fw fwVar = this.a;
            int iB = fwVar.B();
            float fY = fwVar.y();
            int iC = fwVar.C();
            PatternItem[] patternItemArrK = fwVar.K();
            if (patternItemArrK == null) {
                this.c.c(canvas, path, iB, fY, iC);
            } else {
                this.c.b(canvas, path, patternItemArrK, iB, iC, fY);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abl.ab
    public final boolean f(float f, float f2) {
        if (!this.a.H()) {
            return false;
        }
        List list = this.d;
        List list2 = this.e;
        com.google.android.libraries.navigation.internal.abf.s.k(list, "outlinesCanvasXY");
        com.google.android.libraries.navigation.internal.abf.s.k(list2, "holesCanvasXY");
        com.google.android.libraries.navigation.internal.abj.c cVar = new com.google.android.libraries.navigation.internal.abj.c((int) f, (int) f2);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (((com.google.android.libraries.navigation.internal.abj.d) it2.next()).j(cVar)) {
                Iterator it3 = list2.iterator();
                do {
                    if (it3.hasNext()) {
                    }
                    this.a.F();
                    return true;
                } while (!((com.google.android.libraries.navigation.internal.abj.d) it3.next()).j(cVar));
            }
        }
        if (!this.c.f(f, f2, this.d)) {
            return false;
        }
        this.a.F();
        return true;
    }
}
