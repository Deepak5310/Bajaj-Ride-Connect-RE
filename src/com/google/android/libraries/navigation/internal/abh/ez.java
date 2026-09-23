package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.yz.ke;
import com.google.android.libraries.navigation.internal.yz.kf;
import com.google.android.libraries.navigation.internal.yz.kg;
import com.google.android.libraries.navigation.internal.yz.kn;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ez implements com.google.android.libraries.navigation.internal.ly.u, com.google.android.libraries.navigation.internal.ly.at {
    public static final String a = "ez";
    public final com.google.android.libraries.navigation.internal.abf.z e;
    public com.google.android.libraries.navigation.internal.ly.bf f;
    public final da g;
    public final el h;
    public final ed i;
    public boolean j;
    private final z l;
    private final ht m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ey f119n;
    private com.google.android.libraries.navigation.internal.ly.bd o;
    private com.google.android.libraries.navigation.internal.ly.al p;
    private com.google.android.libraries.navigation.internal.ly.ap q;
    private com.google.android.libraries.navigation.internal.ly.an r;
    private final ac s;
    private int k = 0;
    public final Map b = new ConcurrentHashMap();
    public final Map c = new ConcurrentHashMap();
    public final Map d = new ConcurrentHashMap();

    public ez(ey eyVar, da daVar, z zVar, com.google.android.libraries.navigation.internal.abf.z zVar2, ht htVar, el elVar, ed edVar, ac acVar) {
        com.google.android.libraries.navigation.internal.yz.bs.d(8, "expectedKeys");
        ke keVar = new ke();
        com.google.android.libraries.navigation.internal.yz.bs.d(2, "expectedValuesPerKey");
        new kn(new kg(keVar).a.a(), new kf());
        this.j = true;
        this.f119n = eyVar;
        this.g = daVar;
        this.l = zVar;
        this.e = zVar2;
        this.m = htVar;
        this.h = elVar;
        this.i = edVar;
        this.s = acVar;
        this.o = null;
        this.f = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }

    private final void r() {
        TreeSet treeSet = new TreeSet(new Comparator() { // from class: com.google.android.libraries.navigation.internal.abh.et
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                es esVar = (es) obj;
                es esVar2 = (es) obj2;
                return esVar.c() == esVar2.c() ? Long.compare(esVar.g, esVar2.g) : Float.compare(esVar.c(), esVar2.c());
            }
        });
        treeSet.addAll(this.d.keySet());
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            View view = (View) this.d.get((es) it2.next());
            if (view != null) {
                view.bringToFront();
            }
        }
    }

    private static final Point s(ga gaVar, es esVar) {
        return gaVar.a(esVar.g());
    }

    @Override // com.google.android.libraries.navigation.internal.ly.u
    public final void a(CameraPosition cameraPosition) throws RemoteException {
        View view;
        for (Map.Entry entry : this.d.entrySet()) {
            es esVar = (es) entry.getKey();
            if (esVar.N() == 1 && (view = (View) entry.getValue()) != null) {
                Point pointS = s(this.s.e(), esVar);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                float fH = esVar.H() * view.getMeasuredWidth();
                float fI = esVar.I() * view.getMeasuredHeight();
                int i = (int) fH;
                layoutParams.leftMargin = pointS.x - i;
                int i2 = (int) fI;
                layoutParams.topMargin = pointS.y - i2;
                view.setLayoutParams(layoutParams);
                view.setAlpha(esVar.G());
                float fL = esVar.L();
                if (fL != 0.0f) {
                    view.setPivotX(i);
                    view.setPivotY(i2);
                    view.setRotation(fL);
                }
            }
        }
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            p((es) it2.next());
        }
    }

    final er b(es esVar) {
        er erVar = (er) this.b.get(esVar);
        if (erVar != null) {
            return erVar;
        }
        com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
        return null;
    }

    public final es c(MarkerOptions markerOptions) {
        this.e.a();
        com.google.android.libraries.navigation.internal.abf.t.a(markerOptions.getPosition() != null, "latlng cannot be null - a position is required.");
        es esVar = new es(String.format(Locale.getDefault(), "m%d", Integer.valueOf(this.k)), markerOptions, this, this.l, this.e, this.m);
        esVar.g = SystemClock.elapsedRealtimeNanos();
        this.k++;
        Objects.equals(this.i.j(), "P");
        com.google.android.libraries.navigation.internal.afu.d.r();
        er erVarB = this.f119n.b(esVar);
        esVar.f = erVarB;
        erVarB.d();
        this.b.put(esVar, erVarB);
        if (esVar.N() == 1) {
            o(esVar);
            r();
        }
        return esVar;
    }

    public final void d(es esVar, int i) {
        com.google.android.libraries.navigation.internal.afu.d.r();
        er erVarB = b(esVar);
        if (erVarB != null) {
            erVarB.h(i);
        } else {
            com.google.android.libraries.navigation.internal.afu.d.r();
        }
        if (esVar.Y()) {
            return;
        }
        if (esVar.N() == 1) {
            if (i == 11) {
                r();
            }
            o(esVar);
        }
        if (this.c.containsKey(esVar)) {
            p(esVar);
        }
    }

    public final void e(es esVar) {
        ((er) this.b.get(esVar)).e();
        View view = (View) this.c.get(esVar);
        if (view != null) {
            view.setVisibility(0);
            p(esVar);
        }
        com.google.android.libraries.navigation.internal.ly.bf bfVar = this.f;
        if (bfVar != null) {
            try {
                ((com.google.android.gms.maps.a) bfVar).a.onMarkerDragEnd(new Marker(esVar));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        if (this.d.get(esVar) != null) {
            r();
        }
    }

    public final void f(es esVar) {
        this.e.a();
        if (this.p == null) {
            this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_INFO_WINDOW_CLICK_WITHOUT_LISTENER);
            return;
        }
        this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_INFO_WINDOW_CLICK_WITH_LISTENER);
        try {
            ((com.google.android.gms.maps.b) this.p).a.onInfoWindowClick(new Marker(esVar));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void g(es esVar) {
        View view;
        if (this.j && (view = (View) this.c.get(esVar)) != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
            this.c.remove(esVar);
        }
        if (this.r == null) {
            this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_INFO_WINDOW_CLOSE_WITHOUT_LISTENER);
            return;
        }
        this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_INFO_WINDOW_CLOSE_WITH_LISTENER);
        try {
            ((com.google.android.gms.maps.d) this.r).a.onInfoWindowClose(new Marker(esVar));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void h(es esVar) {
        if (this.q == null) {
            this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_INFO_WINDOW_LONG_CLICK_WITHOUT_LISTENER);
            return;
        }
        this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_INFO_WINDOW_LONG_CLICK_WITH_LISTENER);
        try {
            ((com.google.android.gms.maps.c) this.q).a.onInfoWindowLongClick(new Marker(esVar));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void i(com.google.android.libraries.navigation.internal.ly.bd bdVar) {
        this.e.a();
        this.o = bdVar;
    }

    public final void j(com.google.android.libraries.navigation.internal.ly.bf bfVar) {
        this.e.a();
        this.f = bfVar;
    }

    public final void k(com.google.android.libraries.navigation.internal.ly.al alVar) {
        this.e.a();
        this.p = alVar;
    }

    public final void l(com.google.android.libraries.navigation.internal.ly.an anVar) {
        this.e.a();
        this.r = anVar;
    }

    public final void m(com.google.android.libraries.navigation.internal.ly.ap apVar) {
        this.e.a();
        this.q = apVar;
    }

    public final void n(es esVar, boolean z) {
        er erVarB = b(esVar);
        if (erVarB != null) {
            erVarB.j(z);
        }
    }

    final void o(es esVar) {
        ViewParent parent = this.i.b().getParent();
        if (!(parent instanceof FrameLayout)) {
            throw new IllegalStateException("Map container must be a FrameLayout for native view markers to work");
        }
        FrameLayout frameLayout = (FrameLayout) parent;
        View view = (View) com.google.android.libraries.navigation.internal.lo.n.b(esVar.e());
        FrameLayout exVar = (FrameLayout) this.d.get(esVar);
        if (view == null || esVar.Y() || !esVar.F() || !this.j) {
            if (exVar != null) {
                exVar.removeAllViews();
                frameLayout.removeView(exVar);
                this.d.remove(esVar);
                return;
            }
            return;
        }
        if (exVar == null) {
            exVar = new ex(view.getContext());
            exVar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            exVar.addView(view);
        } else if (exVar.getChildCount() > 0 && exVar.getChildAt(0) != view) {
            exVar.removeAllViews();
            exVar.addView(view);
        }
        view.setImportantForAccessibility(4);
        Point pointS = s(this.s.e(), esVar);
        exVar.measure(View.MeasureSpec.makeMeasureSpec(frameLayout.getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(frameLayout.getMeasuredHeight(), Integer.MIN_VALUE));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(exVar.getMeasuredWidth(), exVar.getMeasuredHeight());
        float fH = esVar.H() * exVar.getMeasuredWidth();
        float fI = esVar.I() * exVar.getMeasuredHeight();
        int i = (int) fH;
        layoutParams.leftMargin = pointS.x - i;
        int i2 = (int) fI;
        layoutParams.topMargin = pointS.y - i2;
        if (exVar.getParent() == null) {
            frameLayout.addView(exVar, layoutParams);
        } else {
            exVar.setLayoutParams(layoutParams);
        }
        exVar.setAlpha(esVar.G());
        float fL = esVar.L();
        if (fL != 0.0f) {
            exVar.setPivotX(i);
            exVar.setPivotY(i2);
            exVar.setRotation(fL);
        }
        this.d.put(esVar, exVar);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
    /* JADX WARN: Code duplicated, block: B:32:0x009d  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:37:0x0134  */
    /* JADX WARN: Code duplicated, block: B:40:0x014f  */
    public final boolean p(final es esVar) {
        View view;
        int height;
        int width;
        Point pointS;
        FrameLayout.LayoutParams layoutParams;
        double radians;
        int iSin;
        int i;
        if (this.j) {
            ViewParent parent = this.i.b().getParent();
            if (!(parent instanceof FrameLayout)) {
                throw new IllegalStateException("Map container must be a FrameLayout for native view markers to work");
            }
            FrameLayout frameLayout = (FrameLayout) parent;
            if (this.d.isEmpty()) {
                Iterator it2 = this.c.values().iterator();
                while (it2.hasNext()) {
                    frameLayout.removeView((View) it2.next());
                }
                this.c.clear();
                return false;
            }
            View view2 = (View) this.c.get(esVar);
            View viewB = this.g.b(esVar);
            if (view2 != null) {
                boolean z = esVar.Y() || !esVar.F() || viewB == null;
                if (z || view2 != viewB) {
                    frameLayout.removeView(view2);
                    this.c.remove(esVar);
                    if (!z) {
                        if (viewB != null) {
                            viewB.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.abh.eu
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    this.a.f(esVar);
                                }
                            });
                            viewB.setLongClickable(true);
                            viewB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.google.android.libraries.navigation.internal.abh.ev
                                @Override // android.view.View.OnLongClickListener
                                public final boolean onLongClick(View view3) {
                                    this.a.h(esVar);
                                    return true;
                                }
                            });
                            this.c.clear();
                            this.c.put(esVar, viewB);
                            view = (View) this.d.get(esVar);
                            if (view != null) {
                                height = view.getMeasuredHeight();
                                width = view.getMeasuredWidth();
                            } else {
                                Bitmap bitmapO = esVar.O();
                                height = bitmapO.getHeight();
                                width = bitmapO.getWidth();
                            }
                            pointS = s(this.s.e(), esVar);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            double d = width;
                            int iH = pointS.x - ((int) ((((double) esVar.H()) - 0.5d) * d));
                            float f = height;
                            int I = pointS.y - ((int) (esVar.I() * f));
                            double dJ = esVar.J();
                            float fK = f * esVar.K();
                            radians = Math.toRadians(esVar.L());
                            iSin = I + ((int) fK);
                            i = iH + ((int) ((dJ - 0.5d) * d));
                            if (radians != 0.0d) {
                                double dCos = ((double) (i - pointS.x)) * Math.cos(radians);
                                double dSin = ((double) (iSin - pointS.y)) * Math.sin(radians);
                                double d2 = pointS.x;
                                iSin = (int) ((((double) (i - pointS.x)) * Math.sin(radians)) + (((double) (iSin - pointS.y)) * Math.cos(radians)) + ((double) pointS.y));
                                i = (int) ((dCos - dSin) + d2);
                            }
                            layoutParams.leftMargin = i - (viewB.getMeasuredWidth() / 2);
                            layoutParams.topMargin = iSin - viewB.getMeasuredHeight();
                            viewB.setLayoutParams(layoutParams);
                            if (viewB.getParent() == null) {
                                frameLayout.addView(viewB, layoutParams);
                            }
                            viewB.bringToFront();
                            return true;
                        }
                    }
                } else if (viewB != null) {
                    viewB.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.abh.eu
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            this.a.f(esVar);
                        }
                    });
                    viewB.setLongClickable(true);
                    viewB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.google.android.libraries.navigation.internal.abh.ev
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view3) {
                            this.a.h(esVar);
                            return true;
                        }
                    });
                    this.c.clear();
                    this.c.put(esVar, viewB);
                    view = (View) this.d.get(esVar);
                    if (view != null) {
                        height = view.getMeasuredHeight();
                        width = view.getMeasuredWidth();
                    } else {
                        Bitmap bitmapO2 = esVar.O();
                        height = bitmapO2.getHeight();
                        width = bitmapO2.getWidth();
                    }
                    pointS = s(this.s.e(), esVar);
                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    double d3 = width;
                    int iH2 = pointS.x - ((int) ((((double) esVar.H()) - 0.5d) * d3));
                    float f2 = height;
                    int I2 = pointS.y - ((int) (esVar.I() * f2));
                    double dJ2 = esVar.J();
                    float fK2 = f2 * esVar.K();
                    radians = Math.toRadians(esVar.L());
                    iSin = I2 + ((int) fK2);
                    i = iH2 + ((int) ((dJ2 - 0.5d) * d3));
                    if (radians != 0.0d) {
                        double dCos2 = ((double) (i - pointS.x)) * Math.cos(radians);
                        double dSin2 = ((double) (iSin - pointS.y)) * Math.sin(radians);
                        double d4 = pointS.x;
                        iSin = (int) ((((double) (i - pointS.x)) * Math.sin(radians)) + (((double) (iSin - pointS.y)) * Math.cos(radians)) + ((double) pointS.y));
                        i = (int) ((dCos2 - dSin2) + d4);
                    }
                    layoutParams.leftMargin = i - (viewB.getMeasuredWidth() / 2);
                    layoutParams.topMargin = iSin - viewB.getMeasuredHeight();
                    viewB.setLayoutParams(layoutParams);
                    if (viewB.getParent() == null) {
                        frameLayout.addView(viewB, layoutParams);
                    }
                    viewB.bringToFront();
                    return true;
                }
            } else if (viewB != null) {
                viewB.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.abh.eu
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.a.f(esVar);
                    }
                });
                viewB.setLongClickable(true);
                viewB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.google.android.libraries.navigation.internal.abh.ev
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view3) {
                        this.a.h(esVar);
                        return true;
                    }
                });
                this.c.clear();
                this.c.put(esVar, viewB);
                view = (View) this.d.get(esVar);
                if (view != null) {
                    height = view.getMeasuredHeight();
                    width = view.getMeasuredWidth();
                } else {
                    Bitmap bitmapO3 = esVar.O();
                    height = bitmapO3.getHeight();
                    width = bitmapO3.getWidth();
                }
                pointS = s(this.s.e(), esVar);
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                double d5 = width;
                int iH3 = pointS.x - ((int) ((((double) esVar.H()) - 0.5d) * d5));
                float f3 = height;
                int I3 = pointS.y - ((int) (esVar.I() * f3));
                double dJ3 = esVar.J();
                float fK3 = f3 * esVar.K();
                radians = Math.toRadians(esVar.L());
                iSin = I3 + ((int) fK3);
                i = iH3 + ((int) ((dJ3 - 0.5d) * d5));
                if (radians != 0.0d) {
                    double dCos3 = ((double) (i - pointS.x)) * Math.cos(radians);
                    double dSin3 = ((double) (iSin - pointS.y)) * Math.sin(radians);
                    double d6 = pointS.x;
                    iSin = (int) ((((double) (i - pointS.x)) * Math.sin(radians)) + (((double) (iSin - pointS.y)) * Math.cos(radians)) + ((double) pointS.y));
                    i = (int) ((dCos3 - dSin3) + d6);
                }
                layoutParams.leftMargin = i - (viewB.getMeasuredWidth() / 2);
                layoutParams.topMargin = iSin - viewB.getMeasuredHeight();
                viewB.setLayoutParams(layoutParams);
                if (viewB.getParent() == null) {
                    frameLayout.addView(viewB, layoutParams);
                }
                viewB.bringToFront();
                return true;
            }
        }
        return false;
    }

    public final boolean q(es esVar) {
        String strR;
        this.e.a();
        com.google.android.libraries.navigation.internal.ly.bd bdVar = this.o;
        if (bdVar != null) {
            try {
                if (((com.google.android.gms.maps.z) bdVar).a.onMarkerClick(new Marker(esVar))) {
                    this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_CLICK_WITH_INTERRUPTING_LISTENER);
                    return true;
                }
                this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_CLICK_WITH_LISTENER);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            if (com.google.android.libraries.navigation.internal.afu.y.c()) {
                View viewB = this.i.b();
                int i = cp.b;
                if (com.google.android.libraries.navigation.internal.abf.x.a(esVar.j())) {
                    strR = !com.google.android.libraries.navigation.internal.abf.x.a(esVar.R()) ? esVar.R() : "";
                } else {
                    strR = cp.a(esVar);
                }
                viewB.announceForAccessibility(strR);
            }
            this.m.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_CLICK_WITHOUT_LISTENER);
        }
        com.google.android.libraries.navigation.internal.afu.d.p();
        if (!esVar.j) {
            esVar.e.a();
            esVar.d.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_SHOW_INFO_BUBBLE);
            esVar.b.n(esVar, false);
        }
        el elVar = this.h;
        boolean z = this.f119n.c().size() > 1;
        if (!elVar.d) {
            elVar.e(true, esVar, z);
        }
        return false;
    }
}
