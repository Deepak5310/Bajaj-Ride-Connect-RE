package com.google.android.libraries.navigation.internal.abh;

import android.os.RemoteException;
import android.util.Pair;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StrokeStyle;
import com.google.android.gms.maps.model.StyleSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fz extends com.google.android.libraries.navigation.internal.lz.u implements fl {
    private static final PolylineOptions b = new PolylineOptions();
    private static final com.google.android.libraries.navigation.internal.lo.l c = new com.google.android.libraries.navigation.internal.lo.n(null);
    private static final AtomicInteger d = new AtomicInteger(0);
    private final List A;
    private final List B;
    public fy a;
    private final String e;
    private final fm f;
    private final z g;
    private final ht h;
    private final com.google.android.libraries.navigation.internal.abf.z i;
    private final List j;
    private final List k;
    private final List l;
    private final List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f123n;
    private as o;
    private as p;
    private int q;
    private final hm r;
    private PatternItem[] s;
    private boolean t;
    private float u;
    private boolean v;
    private boolean w;
    private com.google.android.libraries.navigation.internal.lo.l x;
    private final List y;
    private final List z;

    public fz(PolylineOptions polylineOptions, fm fmVar, z zVar, ht htVar, com.google.android.libraries.navigation.internal.abf.z zVar2) {
        com.google.android.libraries.navigation.internal.abf.s.k(polylineOptions, "PolylineOptions cannot be null.");
        com.google.android.libraries.navigation.internal.abf.s.k(fmVar, "overlayManager cannot be null.");
        this.f = fmVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "bitmapManager cannot be null.");
        this.g = zVar;
        com.google.android.libraries.navigation.internal.abf.s.k(htVar, "UsageLog cannot be null.");
        this.h = htVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar2, "ThreadChecker cannot be null.");
        this.i = zVar2;
        this.e = String.format(Locale.ENGLISH, "pl%d", Integer.valueOf(d.getAndIncrement()));
        this.x = c;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        boolean z = false;
        this.f123n = false;
        com.google.android.libraries.navigation.internal.abf.s.a(polylineOptions.getWidth() >= 0.0f, "line width is negative");
        as asVarB = as.b(polylineOptions.getStartCap(), zVar);
        this.o = asVarB;
        if (!Cap.b(asVarB.a())) {
            com.google.android.libraries.navigation.internal.abf.p.c(String.format("Skipping unrecognized %s cap type for %s, drawing TYPE_BUTT instead.", ViewProps.START, "Polyline"));
        }
        as asVarB2 = as.b(polylineOptions.getEndCap(), zVar);
        this.p = asVarB2;
        if (!Cap.b(asVarB2.a())) {
            com.google.android.libraries.navigation.internal.abf.p.c(String.format("Skipping unrecognized %s cap type for %s, drawing TYPE_BUTT instead.", ViewProps.END, "Polyline"));
        }
        int jointType = polylineOptions.getJointType();
        this.q = jointType;
        if (!JointType.a(jointType)) {
            com.google.android.libraries.navigation.internal.abf.p.c(String.format("Unrecognized JointType value [%s] in %s, drawing DEFAULT JointType instead.", Integer.valueOf(jointType), "Polyline"));
        }
        this.s = PatternItem.b(polylineOptions.getPattern());
        this.u = polylineOptions.getZIndex();
        this.v = polylineOptions.isGeodesic();
        this.w = polylineOptions.isClickable();
        StrokeStyle.Builder builderColorBuilder = StrokeStyle.colorBuilder(polylineOptions.getColor());
        builderColorBuilder.d = polylineOptions.isVisible();
        builderColorBuilder.a = polylineOptions.getWidth();
        this.r = new hm(builderColorBuilder.build(), zVar);
        arrayList.addAll(polylineOptions.getPoints());
        this.y = new ArrayList();
        this.A = new ArrayList();
        this.z = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.B = arrayList2;
        arrayList2.addAll(polylineOptions.a());
        R();
        int color = polylineOptions.getColor();
        PolylineOptions polylineOptions2 = b;
        if (color != polylineOptions2.getColor()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_COLOR);
        }
        if (polylineOptions.getWidth() != polylineOptions2.getWidth()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_WIDTH);
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(polylineOptions.getStartCap(), polylineOptions2.getStartCap())) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_START_CAP);
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(polylineOptions.getEndCap(), polylineOptions2.getEndCap())) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_END_CAP);
        }
        if (polylineOptions.getJointType() != polylineOptions2.getJointType()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_JOINT_TYPE);
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(polylineOptions.getPattern(), polylineOptions2.getPattern())) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_PATTERN);
        }
        if (polylineOptions.isGeodesic() != polylineOptions2.isGeodesic()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_GEODESIC);
        }
        if (polylineOptions.isVisible() != polylineOptions2.isVisible()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_VISIBILITY);
        }
        if (polylineOptions.getZIndex() != polylineOptions2.getZIndex()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_Z_INDEX);
        }
        if (polylineOptions.isClickable() != polylineOptions2.isClickable()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_CLICKABILITY);
        }
        if (polylineOptions.a().isEmpty()) {
            return;
        }
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SPANS);
        boolean z2 = false;
        boolean z3 = false;
        for (StyleSpan styleSpan : polylineOptions.a()) {
            Pair pairA = styleSpan.getStyle().a();
            if (!z && !((Integer) pairA.first).equals(pairA.second)) {
                this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SPANS_GRADIENT);
                z = true;
            }
            if (!z2 && styleSpan.getSegments() != Math.floor(styleSpan.getSegments())) {
                this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SPANS_FRACTIONAL);
                z2 = true;
            }
            if (!z3 && styleSpan.getStyle().getStamp() != null) {
                this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SPANS_STAMP);
                z3 = true;
            }
        }
    }

    private final synchronized Pair P(double d2, double d3, int i) {
        double d4;
        int i2;
        d4 = d2 + d3;
        try {
            if (d4 < 0.9999999999d) {
                T(i, d4);
            } else {
                if (d4 < 1.0000000001d) {
                    i++;
                    S(i);
                } else {
                    if (d3 != 0.0d) {
                        i++;
                        d2 -= 1.0d - d3;
                        S(i);
                        d3 = 0.0d;
                    }
                    int i3 = 0;
                    while (true) {
                        i2 = (int) d2;
                        if (i3 >= i2 || i >= this.j.size() - 1) {
                            break;
                        }
                        i++;
                        S(i);
                        i3++;
                    }
                    if (i != this.j.size() - 1) {
                        double d5 = d2 - ((double) i2);
                        if (d5 > 1.0E-10d) {
                            T(i, d5);
                            d4 = d5;
                        }
                    } else {
                        d4 = d3;
                    }
                }
                d4 = 0.0d;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new Pair(Integer.valueOf(i), Double.valueOf(d4));
    }

    private static void Q(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            gw gwVar = ((hm) it2.next()).b;
            if (gwVar != null) {
                gwVar.c.c(gwVar.d);
            }
        }
    }

    private final synchronized void R() {
        this.y.clear();
        this.A.clear();
        this.k.clear();
        this.l.clear();
        if (this.B.isEmpty()) {
            this.k.addAll(this.j);
            this.l.addAll(this.j);
            return;
        }
        S(0);
        int iIntValue = 0;
        double dDoubleValue = 0.0d;
        for (int i = 0; i < this.B.size(); i++) {
            StyleSpan styleSpan = (StyleSpan) this.B.get(i);
            this.A.add(new hm(styleSpan.getStyle(), this.g));
            if (i == this.B.size() - 1) {
                while (true) {
                    iIntValue++;
                    if (iIntValue >= this.j.size()) {
                        break;
                    } else {
                        S(iIntValue);
                    }
                }
            } else {
                Pair pairP = P(styleSpan.getSegments(), dDoubleValue, iIntValue);
                iIntValue = ((Integer) pairP.first).intValue();
                dDoubleValue = ((Double) pairP.second).doubleValue();
                if (iIntValue == this.j.size() - 1) {
                    break;
                }
                this.y.add(Integer.valueOf(this.k.size() - 1));
            }
        }
    }

    private final synchronized void S(int i) {
        this.k.add((LatLng) this.j.get(i));
        this.l.add((LatLng) this.j.get(i));
    }

    private final synchronized void T(int i, double d2) {
        LatLng latLng = (LatLng) this.j.get(i);
        LatLng latLng2 = (LatLng) this.j.get(i + 1);
        com.google.android.libraries.navigation.internal.abj.c cVarB = com.google.android.libraries.navigation.internal.abj.c.b(latLng.latitude, latLng.longitude);
        com.google.android.libraries.navigation.internal.abj.c cVarB2 = com.google.android.libraries.navigation.internal.abj.c.b(latLng2.latitude, latLng2.longitude);
        int i2 = cVarB.a;
        int i3 = cVarB2.a;
        if (Math.abs(i2 - i3) > 536870912) {
            if (i2 < i3) {
                cVarB.a = i2 + 1073741824;
            } else {
                cVarB2.a = i3 + 1073741824;
            }
        }
        List list = this.k;
        float f = (float) d2;
        com.google.android.libraries.navigation.internal.abj.c cVar = new com.google.android.libraries.navigation.internal.abj.c();
        int i4 = cVarB2.a;
        int i5 = cVarB.a;
        cVar.a = ((int) ((i4 - i5) * f)) + i5;
        int i6 = cVarB2.b;
        int i7 = cVarB.b;
        cVar.b = ((int) (f * (i6 - i7))) + i7;
        list.add(cVar.a());
        this.l.add(bw.e(latLng, latLng2, d2));
    }

    private final void U(int i) {
        synchronized (this) {
            if (this.t) {
                return;
            }
            fy fyVar = this.a;
            if (fyVar != null) {
                fyVar.b(i);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final boolean A(com.google.android.libraries.navigation.internal.lz.v vVar) {
        return equals(vVar);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final synchronized boolean B() {
        this.i.a();
        return N();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final synchronized boolean C() {
        this.i.a();
        return this.v;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final boolean D() {
        return J().e();
    }

    public final synchronized float E() {
        return this.u;
    }

    public final synchronized int F() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fl
    public final void G() {
        synchronized (this) {
            if (this.t) {
                return;
            }
            this.x = c;
            this.t = true;
            this.o.d();
            this.p.d();
            Q(this.A);
            fy fyVar = this.a;
            if (fyVar != null) {
                fyVar.c();
            }
        }
    }

    public final synchronized as H() {
        return this.p;
    }

    public final synchronized as I() {
        return this.o;
    }

    public final synchronized hm J() {
        this.i.a();
        if (this.A.size() == 1) {
            return (hm) com.google.android.libraries.navigation.internal.yz.gs.e(this.A);
        }
        return this.r;
    }

    public final synchronized List K() {
        if (this.A.isEmpty()) {
            return Arrays.asList(this.r);
        }
        return new ArrayList(this.A);
    }

    public final synchronized void L(List list, List list2) {
        com.google.android.libraries.navigation.internal.abf.s.k(list, "Null outputPoints");
        com.google.android.libraries.navigation.internal.abf.s.k(list2, "Null outputLineBreaks");
        list.clear();
        list2.clear();
        if (this.v && !this.f123n) {
            ArrayList arrayList = new ArrayList();
            bw.g(this.l, this.m, arrayList);
            this.z.clear();
            Iterator it2 = this.y.iterator();
            while (it2.hasNext()) {
                this.z.add((Integer) arrayList.get(((Integer) it2.next()).intValue()));
            }
            this.f123n = true;
        }
        list.addAll(this.v ? this.m : this.k);
        list2.addAll(this.v ? this.z : this.y);
    }

    public final void M() {
        this.i.a();
        fm fmVar = this.f;
        com.google.android.libraries.navigation.internal.ly.br brVar = fmVar.e;
        if (brVar == null) {
            fmVar.f.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_CLICK_WITHOUT_LISTENER);
            return;
        }
        try {
            ((com.google.android.gms.maps.n) brVar).a.onPolylineClick(new Polyline(this));
            fmVar.f.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_CLICK_WITH_LISTENER);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final synchronized boolean N() {
        return this.w;
    }

    public final synchronized PatternItem[] O() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final synchronized float a() {
        return J().a();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final synchronized float b() {
        this.i.a();
        return E();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final synchronized int c() {
        return J().b();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final int d() {
        this.i.a();
        return F();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final int e() {
        return hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final com.google.android.libraries.navigation.internal.lo.l f() {
        this.i.a();
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final Cap g() {
        this.i.a();
        return H().a;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final Cap h() {
        this.i.a();
        return I().a;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final String i() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final List j() {
        this.i.a();
        PatternItem[] patternItemArrO = O();
        if (patternItemArrO == null) {
            return null;
        }
        return new ArrayList(Arrays.asList(patternItemArrO));
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final synchronized List k() {
        this.i.a();
        return new ArrayList(this.j);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final synchronized List l() {
        this.i.a();
        return new ArrayList(this.B);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void m() {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_REMOVE);
        G();
        this.f.b(this);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void n(boolean z) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_CLICKABILITY);
        synchronized (this) {
            this.w = z;
        }
        U(12);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void o(int i) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_COLOR);
        synchronized (this) {
            this.r.a.b(i);
        }
        U(4);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void p(Cap cap) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_END_CAP);
        com.google.android.libraries.navigation.internal.abf.s.k(cap, "clientEndCap");
        synchronized (this) {
            this.p.d();
            this.p = as.b(cap, this.g);
        }
        if (!Cap.b(cap.a)) {
            com.google.android.libraries.navigation.internal.abf.p.c(String.format("Skipping unrecognized %s cap type for %s, drawing TYPE_BUTT instead.", ViewProps.END, "Polyline"));
        }
        U(9);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void q(boolean z) {
        boolean z2;
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_GEODESIC);
        synchronized (this) {
            if (this.v != z) {
                this.v = z;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            U(0);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void r(int i) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_JOINT_TYPE);
        synchronized (this) {
            this.q = i;
        }
        if (!JointType.a(i)) {
            com.google.android.libraries.navigation.internal.abf.p.c(String.format("Unrecognized JointType value [%s] in %s, drawing DEFAULT JointType instead.", Integer.valueOf(i), "Polyline"));
        }
        U(10);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void s(List list) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_PATTERN);
        synchronized (this) {
            this.s = PatternItem.b(list);
        }
        U(11);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void t(List list) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SET_POINTS);
        synchronized (this) {
            this.j.clear();
            this.j.addAll(list);
            R();
            this.f123n = false;
        }
        U(0);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void u(List list) {
        int i;
        this.i.a();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this) {
            arrayList.addAll(this.B);
            arrayList2.addAll(this.A);
            this.B.clear();
            hm hmVarJ = J();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                StyleSpan styleSpan = (StyleSpan) it2.next();
                List list2 = this.B;
                StrokeStyle.Builder builder = new StrokeStyle.Builder(styleSpan.getStyle());
                builder.a = hmVarJ.a();
                builder.d = hmVarJ.e();
                list2.add(new StyleSpan(builder.build(), styleSpan.getSegments()));
            }
            R();
            this.f123n = false;
        }
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SPANS_CHANGED);
        if (arrayList.size() != list.size()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SPANS_COUNT_CHANGED);
        } else {
            boolean z = false;
            boolean z2 = false;
            for (i = 0; i < list.size(); i++) {
                StyleSpan styleSpan2 = (StyleSpan) arrayList.get(i);
                StyleSpan styleSpan3 = (StyleSpan) list.get(i);
                if (!z && !styleSpan2.getStyle().a().equals(styleSpan3.getStyle().a())) {
                    this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SPANS_COLOR_CHANGED);
                    z = true;
                }
                if (!z2 && Math.abs(styleSpan2.getSegments() - styleSpan3.getSegments()) > 1.0E-10d) {
                    this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SPANS_SEGMENTS_CHANGED);
                    z2 = true;
                }
            }
        }
        U(13);
        Q(arrayList2);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void v(Cap cap) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_START_CAP);
        com.google.android.libraries.navigation.internal.abf.s.k(cap, "clientStartCap");
        synchronized (this) {
            this.o.d();
            this.o = as.b(cap, this.g);
        }
        if (!Cap.b(cap.a)) {
            com.google.android.libraries.navigation.internal.abf.p.c(String.format("Skipping unrecognized %s cap type for %s, drawing TYPE_BUTT instead.", ViewProps.START, "Polyline"));
        }
        U(8);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void w(com.google.android.libraries.navigation.internal.lo.l lVar) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_SET_TAG);
        this.x = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void x(boolean z) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_VISIBILITY);
        synchronized (this) {
            this.r.c(z);
            for (int i = 0; i < this.A.size(); i++) {
                ((hm) this.A.get(i)).c(z);
            }
        }
        U(6);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void y(float f) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_WIDTH);
        com.google.android.libraries.navigation.internal.abf.s.a(f >= 0.0f, "line width is negative");
        synchronized (this) {
            this.r.d(f);
            for (int i = 0; i < this.A.size(); i++) {
                ((hm) this.A.get(i)).d(f);
            }
        }
        U(3);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.v
    public final void z(float f) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYLINE_Z_INDEX);
        synchronized (this) {
            this.u = f;
        }
        U(7);
    }
}
