package com.google.android.libraries.navigation.internal.abl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.ak;
import com.google.android.gms.maps.al;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapColorScheme;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abf.ah;
import com.google.android.libraries.navigation.internal.abh.bc;
import com.google.android.libraries.navigation.internal.abh.be;
import com.google.android.libraries.navigation.internal.abh.bj;
import com.google.android.libraries.navigation.internal.abh.bq;
import com.google.android.libraries.navigation.internal.abh.bv;
import com.google.android.libraries.navigation.internal.abh.bw;
import com.google.android.libraries.navigation.internal.abh.by;
import com.google.android.libraries.navigation.internal.abh.cp;
import com.google.android.libraries.navigation.internal.abh.ec;
import com.google.android.libraries.navigation.internal.abh.ed;
import com.google.android.libraries.navigation.internal.abh.ef;
import com.google.android.libraries.navigation.internal.abh.el;
import com.google.android.libraries.navigation.internal.abh.es;
import com.google.android.libraries.navigation.internal.abh.ey;
import com.google.android.libraries.navigation.internal.abh.fg;
import com.google.android.libraries.navigation.internal.abh.fo;
import com.google.android.libraries.navigation.internal.abh.gu;
import com.google.android.libraries.navigation.internal.abh.gv;
import com.google.android.libraries.navigation.internal.abh.id;
import com.google.android.libraries.navigation.internal.abm.aj;
import com.google.android.libraries.navigation.internal.ly.av;
import com.google.android.libraries.navigation.internal.ly.az;
import com.google.android.libraries.navigation.internal.ly.bn;
import com.google.android.libraries.navigation.internal.ly.bt;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends View implements ed {
    public final o a;
    public s b;
    public final i c;
    public aa d;
    public com.google.android.libraries.navigation.internal.abi.d e;
    public az f;
    public final be g;
    public cp h;
    public final gu i;
    private final k j;
    private final j k;
    private av l;
    private final by m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final el f132n;
    private final ad o;
    private bt p;
    private final id q;

    public l(be beVar, bc bcVar, View view, com.google.android.libraries.navigation.internal.abh.aa aaVar, by byVar, ec ecVar, TextView textView, id idVar, gu guVar, com.google.android.libraries.navigation.internal.abh.d dVar) {
        super(beVar.a);
        this.g = beVar;
        this.a = new o(this, beVar);
        Handler handler = new Handler(Looper.getMainLooper());
        k kVar = new k(this, beVar.b());
        this.j = kVar;
        this.f132n = aaVar.j;
        W(0, 0);
        j jVar = new j(this, beVar);
        this.k = jVar;
        this.c = new i(jVar, textView, bcVar.a(), kVar, Calendar.getInstance(), com.google.android.libraries.navigation.internal.abf.e.a, ecVar, guVar, dVar, (String) bcVar.c.a(), idVar, ah.b(handler));
        this.m = byVar;
        this.o = new ad(this, view, aaVar.f, ah.b(handler), idVar);
        this.q = idVar;
        this.i = guVar;
        this.l = null;
        this.f = null;
    }

    private final void W(int i, int i2) {
        Display display;
        int i3 = 1;
        if (i > 0 && i2 > 0 && (display = getDisplay()) != null) {
            Point point = new Point();
            display.getRealSize(point);
            if (i > point.x || i2 > point.y) {
                i3 = 0;
            }
        }
        setLayerType(i3, null);
    }

    private static final void X() {
        com.google.android.libraries.navigation.internal.afu.d.o();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void A(@MapColorScheme int i) {
        com.google.android.libraries.navigation.internal.abf.p.e("setMapColorScheme");
        X();
        throw new UnsupportedOperationException("setMapColorScheme not supported in Lite mode.");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void B(String str) {
        i iVar = this.c;
        iVar.f = str;
        iVar.b();
        iVar.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void C(int i) {
        i iVar = this.c;
        iVar.e = i;
        iVar.b();
        iVar.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void D(float f) {
        com.google.android.libraries.navigation.internal.abf.p.e("setMaxZoomPreference");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void E(float f) {
        com.google.android.libraries.navigation.internal.abf.p.e("setMinZoomPreference");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void F(String str, Set set) {
        com.google.android.libraries.navigation.internal.abf.p.e("setOnFeatureClickListener");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void G(av avVar) {
        this.l = avVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void H(az azVar) {
        this.f = azVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void I(bn bnVar) {
        com.google.android.libraries.navigation.internal.abf.p.e("setPoiClickListener");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void J(bt btVar) {
        this.p = btVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean K() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean L() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean M() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean N() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean O() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean P(boolean z) {
        if (!z) {
            return false;
        }
        com.google.android.libraries.navigation.internal.abf.p.b("Buildings");
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean Q(boolean z) {
        if (!z) {
            return false;
        }
        com.google.android.libraries.navigation.internal.abf.p.e("Indoor");
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean R(boolean z) {
        if (!z) {
            return false;
        }
        com.google.android.libraries.navigation.internal.abf.p.e("Traffic");
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final aj S() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void T(bj bjVar) {
        com.google.android.libraries.navigation.internal.abf.p.e("setDdsRestyler");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void U() {
        X();
        throw new UnsupportedOperationException("getCarStyling is not supported in Lite Mode");
    }

    public final boolean V(MotionEvent motionEvent) {
        Point point;
        if (this.d == null) {
            return false;
        }
        if (this.l != null) {
            if (motionEvent != null) {
                point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            } else {
                Rect rect = new Rect();
                getDrawingRect(rect);
                point = new Point(rect.centerX(), rect.centerY());
            }
            try {
                this.l.a(this.d.b(point));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            if (com.google.android.libraries.navigation.internal.abf.e.b) {
                return true;
            }
            this.m.a(this.d.e, this.b.a(), this.b.p());
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    @MapColorScheme
    public final int a() {
        com.google.android.libraries.navigation.internal.abf.p.e("getMapColorScheme");
        X();
        throw new UnsupportedOperationException("getMapColorScheme not supported in Lite mode.");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final View b() {
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final com.google.android.libraries.navigation.internal.abh.ac c() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final bq d() {
        com.google.android.libraries.navigation.internal.abf.p.e("getFollowMyLocationController");
        throw new UnsupportedOperationException("getFollowMyLocationController not supported in Lite mode.");
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.h.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final ef e() {
        com.google.android.libraries.navigation.internal.abf.p.e("getMapRendererEnvironment");
        throw new UnsupportedOperationException("getMapRendererEnvironment not supported in Lite mode.");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final ey f() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final fg g() {
        return this.a;
    }

    @Override // android.view.View
    public final Resources getResources() {
        be beVar = this.g;
        return beVar == null ? super.getResources() : beVar.j();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final fo h() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final gv i() {
        return this.o;
    }

    @Override // android.view.View
    public final boolean isClickable() {
        ViewGroup viewGroup = getParent() == null ? null : (ViewGroup) getParent().getParent();
        if (viewGroup != null) {
            return viewGroup.isClickable();
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final String j() {
        return "L";
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void k(String str) {
        com.google.android.libraries.navigation.internal.abf.p.e("disableMap");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void l() {
        com.google.android.libraries.navigation.internal.abf.p.e("enableMap");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void m() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void n() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void o() {
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        this.c.a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Location location;
        Bitmap bitmap;
        super.onDraw(canvas);
        j jVar = this.k;
        int width = getWidth();
        int height = getHeight();
        if (jVar.c != null) {
            canvas.drawBitmap(jVar.c, (width - jVar.c.getWidth()) / 2.0f, (height - jVar.c.getHeight()) / 2.0f, new Paint());
        } else {
            Paint paint = new Paint();
            int iE = jVar.b.e(ak.h);
            int width2 = canvas.getWidth();
            int height2 = canvas.getHeight();
            paint.setARGB(50, 128, 128, 128);
            int i = iE / 2;
            int i2 = 0;
            for (int i3 = i; i3 < width2; i3 += iE) {
                paint.setStrokeWidth((i2 + 7) % 8 == 0 ? 2.0f : 1.0f);
                float f = i3;
                canvas.drawLine(f, 0.0f, f, height2, paint);
                i2++;
            }
            int i4 = 0;
            while (i < height2) {
                paint.setStrokeWidth((i4 + 7) % 8 == 0 ? 2.0f : 1.0f);
                float f2 = i;
                canvas.drawLine(0.0f, f2, width2, f2, paint);
                i4++;
                i += iE;
            }
        }
        aa aaVar = jVar.d;
        this.d = aaVar;
        if (aaVar != null) {
            s sVar = this.b;
            synchronized (sVar.a) {
                Collections.sort(sVar.a, sVar.j);
                Iterator it2 = sVar.a.iterator();
                while (it2.hasNext()) {
                    ((ab) it2.next()).e(canvas, aaVar);
                }
            }
            synchronized (sVar.b) {
                Collections.sort(sVar.b, sVar.k);
                for (n nVar : sVar.b) {
                    Bitmap bitmapO = nVar.a.O();
                    float fH = nVar.a.H() * bitmapO.getWidth();
                    float fI = nVar.a.I() * bitmapO.getHeight();
                    Point pointA = aaVar.a(nVar.a.Q());
                    int i5 = (int) fH;
                    int i6 = (int) fI;
                    nVar.c = new Point(pointA.x - i5, pointA.y - i6);
                    nVar.d = new Point(pointA.x + (bitmapO.getWidth() - i5), pointA.y + (bitmapO.getHeight() - i6));
                    if (nVar.a.F()) {
                        nVar.b.setAlpha((int) (nVar.a.G() * 255.0f));
                        canvas.drawBitmap(bitmapO, nVar.c.x, nVar.c.y, nVar.b);
                    }
                }
            }
            sVar.c.clear();
            Rect rect = new Rect(0, 0, aaVar.f, aaVar.g);
            synchronized (sVar.b) {
                for (n nVar2 : sVar.b) {
                    if (Rect.intersects(rect, nVar2.c())) {
                        sVar.c.add(nVar2);
                    }
                }
            }
            o oVar = this.a;
            aa aaVar2 = this.d;
            if (!oVar.b || (location = oVar.d) == null) {
                oVar.h = null;
            } else {
                LatLng latLng = new LatLng(location.getLatitude(), oVar.d.getLongitude());
                oVar.h = aaVar2.a(latLng);
                if (oVar.d.hasAccuracy()) {
                    int i7 = oVar.h.y - aaVar2.a(new LatLng(latLng.latitude + bw.i(oVar.d.getAccuracy()), latLng.longitude)).y;
                    oVar.c.setStyle(Paint.Style.STROKE);
                    oVar.c.setStrokeWidth(2.0f);
                    oVar.c.setColor(oVar.a.d(com.google.android.gms.maps.aj.b));
                    float f3 = i7;
                    canvas.drawCircle(oVar.h.x, oVar.h.y, f3, oVar.c);
                    oVar.c.setStyle(Paint.Style.FILL);
                    oVar.c.setColor(oVar.a.d(com.google.android.gms.maps.aj.a));
                    canvas.drawCircle(oVar.h.x, oVar.h.y, f3, oVar.c);
                    oVar.c.reset();
                }
                Matrix matrix = new Matrix();
                if (oVar.d.hasBearing()) {
                    matrix.setRotate(oVar.d.getBearing());
                    if (oVar.f == null) {
                        oVar.f = oVar.a.k(al.m);
                    }
                    bitmap = oVar.f;
                } else {
                    if (oVar.e == null) {
                        oVar.e = oVar.a.k(al.a);
                    }
                    bitmap = oVar.e;
                }
                com.google.android.libraries.navigation.internal.abf.s.j(bitmap);
                matrix.preTranslate(-(bitmap.getWidth() / 2), -(bitmap.getHeight() / 2));
                float fA = oVar.a.a(ak.i);
                matrix.postScale(fA / bitmap.getWidth(), fA / bitmap.getHeight());
                oVar.i = fA / 2.0f;
                matrix.postTranslate(oVar.h.x, oVar.h.y);
                canvas.drawBitmap(bitmap, matrix, oVar.c);
            }
            s sVar2 = this.b;
            es esVar = sVar2.e;
            if (esVar != null) {
                Bitmap bitmapO2 = esVar.O();
                Rect rectP = esVar.P();
                Bitmap bitmapA = esVar.b.g.a(esVar, canvas.getWidth(), canvas.getHeight());
                if (bitmapA != null) {
                    sVar2.h = bitmapA.getWidth();
                    sVar2.i = bitmapA.getHeight();
                    esVar.e.a();
                    float fJ = esVar.J();
                    esVar.e.a();
                    float fK = esVar.K();
                    Paint paint2 = new Paint();
                    sVar2.f = (rectP.left + (fJ * bitmapO2.getWidth())) - (sVar2.h / 2.0f);
                    float height3 = (rectP.top + (fK * bitmapO2.getHeight())) - sVar2.i;
                    sVar2.g = height3;
                    canvas.drawBitmap(bitmapA, sVar2.f, height3, paint2);
                }
            }
        }
        cp cpVar = this.h;
        cpVar.invalidateRoot();
        if (cpVar.a != null) {
            for (int i8 = 0; i8 < cpVar.a.size(); i8++) {
                cpVar.invalidateVirtualView(i8);
            }
        }
        boolean zP = this.b.p();
        es esVarA = this.b.a();
        if (esVarA != null) {
            this.f132n.e(true, esVarA, false);
        } else if (zP) {
            this.f132n.c();
        } else {
            this.f132n.e(false, null, false);
        }
        bt btVar = this.p;
        if (btVar != null) {
            try {
                btVar.a();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        W(i, i2);
        super.onSizeChanged(i, i2, i3, i4);
        this.c.b();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isClickable()) {
            return false;
        }
        this.e.e(motionEvent);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void p() {
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return V(null);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void q() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void r() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void s() {
        com.google.android.libraries.navigation.internal.abf.p.e("resetMinMaxZoomPreference");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void t(boolean z) {
        if (z) {
            com.google.android.libraries.navigation.internal.abf.p.b("Map gestures");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void u(boolean z) {
        if (z) {
            com.google.android.libraries.navigation.internal.abf.p.b("Map gestures");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void v(boolean z) {
        if (z) {
            com.google.android.libraries.navigation.internal.abf.p.b("Map gestures");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void w(boolean z) {
        if (z) {
            com.google.android.libraries.navigation.internal.abf.p.b("Map gestures");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void x(boolean z) {
        if (z) {
            com.google.android.libraries.navigation.internal.abf.p.b("Map gestures");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void y(bv bvVar) {
        throw new UnsupportedOperationException("setFollowMyLocationManager not supported in Lite mode.");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void z(LatLngBounds latLngBounds) {
        com.google.android.libraries.navigation.internal.abf.p.e("setLatLngBoundsForCameraTarget");
    }
}
