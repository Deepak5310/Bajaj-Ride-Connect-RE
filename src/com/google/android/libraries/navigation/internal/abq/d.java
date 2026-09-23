package com.google.android.libraries.navigation.internal.abq;

import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abw.k;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final double a;
    public boolean b;
    public String c;
    public float d;
    public float e;
    public int f;
    public int g;
    public boolean h;
    public int i;
    public int j;
    public double k;
    public int l;

    public d() {
        s.h(90.0d, "maxFovYDeg");
        this.a = 90.0d;
        this.l = Integer.MAX_VALUE;
        this.b = false;
        this.c = null;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = 0;
        this.j = 0;
        this.k = 0.0d;
    }

    public final void a() {
        int iMin;
        if (this.b && this.h) {
            double d = (((double) this.f) / 180.0d) / (((double) this.j) / this.k);
            if (d == 0.0d) {
                iMin = Integer.MAX_VALUE;
            } else {
                iMin = Math.min(this.g, Math.max(0, (int) (Math.log(d) / k.a)) + 2);
            }
            this.l = iMin;
        }
    }

    public final String toString() {
        aj ajVarE = aj.f(this).a("maxFovYDeg", 90.0d).e("hasPanoData", this.b);
        ajVarE.g("panoId", this.c);
        return ajVarE.b("minTiltVisibleDeg", this.d).b("maxTiltVisibleDeg", this.e).c("originalImageHeightPx", this.f).c("originalImageMaxTileZoom", this.g).e("hasViewData", this.h).c("viewWidthPx", this.i).c("viewHeightPx", this.j).a("unzoomedFovYDeg", this.k).c("currMaxZoomLevel", this.l).toString();
    }
}
