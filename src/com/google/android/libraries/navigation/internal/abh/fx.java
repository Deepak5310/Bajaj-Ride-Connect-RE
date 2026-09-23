package com.google.android.libraries.navigation.internal.abh;

import android.os.RemoteException;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.maps.android.data.kml.KmlPolygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fx extends com.google.android.libraries.navigation.internal.lz.s implements fl, fw {
    private static final PolygonOptions c = new PolygonOptions();
    private static final com.google.android.libraries.navigation.internal.lo.l d = new com.google.android.libraries.navigation.internal.lo.n(null);
    private static final AtomicInteger e = new AtomicInteger(0);
    public fn a;
    public final Set b = new HashSet();
    private final String f;
    private final fm g;
    private final ht h;
    private final com.google.android.libraries.navigation.internal.abf.z i;
    private final List j;
    private final List k;
    private boolean l;
    private final List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f122n;
    private boolean o;
    private int p;
    private int q;
    private PatternItem[] r;
    private int s;
    private float t;
    private float u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private com.google.android.libraries.navigation.internal.lo.l z;

    public fx(PolygonOptions polygonOptions, fm fmVar, ht htVar, com.google.android.libraries.navigation.internal.abf.z zVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(polygonOptions, "PolygonOptions cannot be null.");
        com.google.android.libraries.navigation.internal.abf.s.k(fmVar, "OverlayManager cannot be null.");
        this.g = fmVar;
        com.google.android.libraries.navigation.internal.abf.s.k(htVar, "UsageLog cannot be null.");
        this.h = htVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "ThreadChecker cannot be null.");
        this.i = zVar;
        this.f = String.format(Locale.getDefault(), "pg%d", Integer.valueOf(e.getAndIncrement()));
        this.z = d;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.k = new ArrayList();
        this.l = false;
        this.m = new ArrayList();
        this.f122n = new ArrayList();
        this.o = false;
        com.google.android.libraries.navigation.internal.abf.s.a(polygonOptions.getStrokeWidth() >= 0.0f, "stroke width is negative");
        this.t = polygonOptions.getStrokeWidth();
        this.p = polygonOptions.getStrokeColor();
        int strokeJointType = polygonOptions.getStrokeJointType();
        this.q = strokeJointType;
        if (!JointType.a(strokeJointType)) {
            com.google.android.libraries.navigation.internal.abf.p.c(String.format("Unrecognized JointType value [%s] in %s, drawing DEFAULT JointType instead.", Integer.valueOf(strokeJointType), KmlPolygon.GEOMETRY_TYPE));
        }
        this.r = PatternItem.b(polygonOptions.getStrokePattern());
        this.s = polygonOptions.getFillColor();
        this.u = polygonOptions.getZIndex();
        this.w = polygonOptions.isVisible();
        this.v = polygonOptions.isGeodesic();
        this.x = polygonOptions.isClickable();
        arrayList.addAll(polygonOptions.getPoints());
        L(arrayList);
        Iterator<List<LatLng>> it2 = polygonOptions.getHoles().iterator();
        while (it2.hasNext()) {
            ArrayList arrayList2 = new ArrayList(it2.next());
            L(arrayList2);
            this.m.add(arrayList2);
        }
        int strokeColor = polygonOptions.getStrokeColor();
        PolygonOptions polygonOptions2 = c;
        if (strokeColor != polygonOptions2.getStrokeColor()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_STROKE_COLOR);
        }
        if (polygonOptions.getStrokeWidth() != polygonOptions2.getStrokeWidth()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_WIDTH);
        }
        if (polygonOptions.getFillColor() != polygonOptions2.getFillColor()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_FILL_COLOR);
        }
        if (polygonOptions.getStrokeJointType() != polygonOptions2.getStrokeJointType()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_STROKE_JOINT_TYPE);
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(polygonOptions.getStrokePattern(), polygonOptions2.getStrokePattern())) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_STROKE_PATTERN);
        }
        if (polygonOptions.isGeodesic() != polygonOptions2.isGeodesic()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_GEODESIC);
        }
        if (polygonOptions.isVisible() != polygonOptions2.isVisible()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_VISIBILITY);
        }
        if (polygonOptions.getZIndex() != polygonOptions2.getZIndex()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_Z_INDEX);
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(polygonOptions.getHoles(), polygonOptions2.getHoles())) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_HOLES);
        }
        if (polygonOptions.isClickable() != polygonOptions2.isClickable()) {
            this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_CLICKABILITY);
        }
    }

    private static void L(List list) {
        com.google.android.libraries.navigation.internal.abf.s.k(list, "Null points");
        com.google.android.libraries.navigation.internal.abf.t.a(!list.isEmpty(), "List<LatLng> cannot be empty.");
        if (((LatLng) list.get(0)).equals(list.get(list.size() - 1))) {
            return;
        }
        list.add((LatLng) list.get(0));
    }

    private static void M(List list, int i) {
        com.google.android.libraries.navigation.internal.abf.s.k(list, "Null holes");
        com.google.android.libraries.navigation.internal.abf.s.a(i >= 0, "Negative newNumHoles");
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 >= list.size()) {
                list.add(new ArrayList());
            } else if (list.get(i2) == null) {
                list.set(i2, new ArrayList());
            }
        }
        list.subList(i, list.size()).clear();
    }

    private final void N(int i) {
        synchronized (this) {
            if (this.y) {
                return;
            }
            this.i.a();
            fn fnVar = this.a;
            if (fnVar != null) {
                fnVar.c(i);
            } else {
                this.b.add(Integer.valueOf(i));
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized int A() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized int B() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized int C() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized void D(List list) {
        com.google.android.libraries.navigation.internal.abf.s.k(list, "Null outputHoles");
        if (this.v && !this.o) {
            M(this.f122n, this.m.size());
            for (int i = 0; i < this.m.size(); i++) {
                bw.g((List) this.m.get(i), (List) this.f122n.get(i), new ArrayList());
            }
            this.o = true;
        }
        List list2 = this.v ? this.f122n : this.m;
        M(list, list2.size());
        for (int i2 = 0; i2 < list2.size(); i2++) {
            List list3 = (List) list.get(i2);
            list3.clear();
            list3.addAll((Collection) list2.get(i2));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized void E(List list) {
        com.google.android.libraries.navigation.internal.abf.s.k(list, "Null outputOutline");
        if (this.v && !this.l) {
            bw.g(this.j, this.k, new ArrayList());
            this.l = true;
        }
        list.clear();
        list.addAll(this.v ? this.k : this.j);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final void F() {
        this.i.a();
        fm fmVar = this.g;
        com.google.android.libraries.navigation.internal.ly.bp bpVar = fmVar.d;
        if (bpVar == null) {
            fmVar.f.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_CLICK_WITHOUT_LISTENER);
            return;
        }
        try {
            ((com.google.android.gms.maps.m) bpVar).a.onPolygonClick(new Polygon(this));
            fmVar.f.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_CLICK_WITH_LISTENER);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fl
    public final void G() {
        synchronized (this) {
            if (this.y) {
                return;
            }
            this.z = d;
            this.y = true;
            fn fnVar = this.a;
            if (fnVar != null) {
                fnVar.d();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized boolean H() {
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final boolean I() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized boolean J() {
        return this.w;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized PatternItem[] K() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final boolean V(com.google.android.libraries.navigation.internal.lz.t tVar) {
        return equals(tVar);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized boolean W() {
        this.i.a();
        return H();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized boolean X() {
        this.i.a();
        return this.v;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized boolean Y() {
        this.i.a();
        return J();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized float a() {
        this.i.a();
        return y();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized float b() {
        this.i.a();
        return z();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized int c() {
        this.i.a();
        return A();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized int d() {
        this.i.a();
        return B();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final int e() {
        this.i.a();
        return C();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final int f() {
        return hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final com.google.android.libraries.navigation.internal.lo.l g() {
        this.i.a();
        return this.z;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final String h() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized List i() {
        ArrayList arrayList;
        this.i.a();
        arrayList = new ArrayList(this.m.size());
        Iterator it2 = this.m.iterator();
        while (it2.hasNext()) {
            arrayList.add(new ArrayList((List) it2.next()));
        }
        return arrayList;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final synchronized List j() {
        this.i.a();
        return new ArrayList(this.j);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final List k() {
        this.i.a();
        PatternItem[] patternItemArrK = K();
        if (patternItemArrK == null) {
            return null;
        }
        return new ArrayList(Arrays.asList(patternItemArrK));
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void l() {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_REMOVE);
        G();
        this.g.b(this);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void m(boolean z) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_CLICKABILITY);
        synchronized (this) {
            this.x = z;
        }
        N(12);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void n(int i) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_FILL_COLOR);
        synchronized (this) {
            this.s = i;
        }
        N(5);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void o(boolean z) {
        boolean z2;
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_GEODESIC);
        synchronized (this) {
            if (this.v != z) {
                this.v = z;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            N(1);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void p(List list) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_HOLES);
        synchronized (this) {
            M(this.m, list.size());
            for (int i = 0; i < list.size(); i++) {
                List list2 = (List) this.m.get(i);
                list2.clear();
                list2.addAll((List) list.get(i));
                L(list2);
            }
            this.o = false;
        }
        N(2);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void q(List list) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_SET_POINTS);
        synchronized (this) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    if (this.j.isEmpty()) {
                        break;
                    } else {
                        return;
                    }
                }
                double d2 = ((LatLng) it2.next()).latitude;
                if ((d2 <= 0.0d && d2 > -90.0d) || (d2 > 0.0d && d2 < 90.0d)) {
                    break;
                    break;
                }
            }
            this.j.clear();
            this.j.addAll(list);
            L(this.j);
            this.l = false;
            N(0);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void r(int i) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_STROKE_COLOR);
        synchronized (this) {
            this.p = i;
        }
        N(4);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void s(int i) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_STROKE_JOINT_TYPE);
        synchronized (this) {
            this.q = i;
        }
        if (!JointType.a(i)) {
            com.google.android.libraries.navigation.internal.abf.p.c(String.format("Unrecognized JointType value [%s] in %s, drawing DEFAULT JointType instead.", Integer.valueOf(i), KmlPolygon.GEOMETRY_TYPE));
        }
        N(10);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void t(List list) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_STROKE_PATTERN);
        synchronized (this) {
            this.r = PatternItem.b(list);
        }
        N(11);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void u(float f) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_WIDTH);
        com.google.android.libraries.navigation.internal.abf.s.a(f >= 0.0f, "stroke width is negative");
        synchronized (this) {
            this.t = f;
        }
        N(3);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void v(com.google.android.libraries.navigation.internal.lo.l lVar) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_SET_TAG);
        this.z = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void w(boolean z) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_VISIBILITY);
        synchronized (this) {
            this.w = z;
        }
        N(6);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.t
    public final void x(float f) {
        this.i.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.POLYGON_Z_INDEX);
        synchronized (this) {
            this.u = f;
        }
        N(7);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized float y() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized float z() {
        return this.u;
    }
}
