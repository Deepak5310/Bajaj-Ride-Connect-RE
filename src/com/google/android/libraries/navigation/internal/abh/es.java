package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class es extends com.google.android.libraries.navigation.internal.lz.o {
    private static final MarkerOptions l = new MarkerOptions();
    private static final com.google.android.libraries.navigation.internal.lo.l m = new com.google.android.libraries.navigation.internal.lo.n(null);
    private int A;
    private String B;
    public final String a;
    public final ez b;
    public final z c;
    public final ht d;
    public final com.google.android.libraries.navigation.internal.abf.z e;
    public er f;
    public x h;
    public View i;
    public boolean j;
    public int k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LatLng f118n;
    private float o;
    private float p;
    private float q;
    private boolean r;
    private float s;
    private boolean t;
    private boolean u;
    private String v;
    private String w;
    private float x;
    private float y;
    private float z;
    long g = 0;
    private com.google.android.libraries.navigation.internal.lo.l C = m;

    public es(String str, MarkerOptions markerOptions, ez ezVar, z zVar, com.google.android.libraries.navigation.internal.abf.z zVar2, ht htVar) {
        this.A = 0;
        this.a = str;
        this.b = ezVar;
        this.c = zVar;
        this.d = htVar;
        this.e = zVar2;
        LatLng position = markerOptions.getPosition();
        com.google.android.libraries.navigation.internal.abf.t.c(position, "latlng cannot be null - a position is required.");
        this.f118n = position;
        this.o = markerOptions.getZIndex();
        BitmapDescriptor icon = markerOptions.getIcon();
        if (icon == null) {
            this.h = x.b();
        } else {
            x xVar = (x) com.google.android.libraries.navigation.internal.lo.n.b(icon.a);
            this.h = xVar;
            if ((xVar instanceof u) && (markerOptions.c != 1 || !ezVar.j)) {
                this.h = x.b();
            }
        }
        zVar.b(this.h);
        this.p = markerOptions.getAnchorU();
        this.q = markerOptions.getAnchorV();
        this.r = markerOptions.isFlat();
        this.s = markerOptions.getRotation();
        this.z = markerOptions.getAlpha();
        this.v = markerOptions.getTitle();
        this.w = markerOptions.getSnippet();
        this.t = markerOptions.isDraggable();
        this.u = markerOptions.isVisible();
        this.x = markerOptions.getInfoWindowAnchorU();
        this.y = markerOptions.getInfoWindowAnchorV();
        this.k = markerOptions.getCollisionBehavior();
        this.A = markerOptions.c;
        if (ezVar.j) {
            View view = markerOptions.b;
            this.i = view;
            if (view != null) {
                x xVar2 = this.h;
                if (xVar2 != null) {
                    zVar.c(xVar2);
                }
                w wVar = new w(1, 1);
                this.h = wVar;
                zVar.b(wVar);
                this.i.getViewTreeObserver().addOnGlobalLayoutListener(new ep(this));
                if (!this.u) {
                    this.i.setVisibility(8);
                }
            }
        }
        this.B = markerOptions.getContentDescription();
        float anchorU = markerOptions.getAnchorU();
        MarkerOptions markerOptions2 = l;
        if (anchorU != markerOptions2.getAnchorU() || markerOptions.getAnchorV() != markerOptions2.getAnchorV()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_ANCHOR);
        }
        if (markerOptions.getInfoWindowAnchorU() != markerOptions2.getInfoWindowAnchorU() || markerOptions.getInfoWindowAnchorV() != markerOptions2.getInfoWindowAnchorV()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_INFO_WINDOW_ANCHOR);
        }
        if (markerOptions.getIcon() != markerOptions2.getIcon()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_ICON);
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(markerOptions.getTitle(), markerOptions2.getTitle())) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_TITLE);
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(markerOptions.getSnippet(), markerOptions2.getSnippet())) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_SNIPPET);
        }
        if (markerOptions.isDraggable() != markerOptions2.isDraggable()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_DRAGGABLE);
        }
        if (markerOptions.isVisible() != markerOptions2.isVisible()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_VISIBILITY);
        }
        if (markerOptions.isFlat() != markerOptions2.isFlat()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_FLAT);
        }
        if (markerOptions.getRotation() != markerOptions2.getRotation()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_ROTATION);
        }
        if (markerOptions.getAlpha() != markerOptions2.getAlpha()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_ALPHA);
        }
        if (markerOptions.getZIndex() != markerOptions2.getZIndex()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_Z_INDEX);
        }
        if (markerOptions.getCollisionBehavior() != markerOptions2.getCollisionBehavior()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_COLLISION_BEHAVIOR);
        }
        if (com.google.android.libraries.navigation.internal.afu.y.c() && !com.google.android.libraries.navigation.internal.abf.r.a(markerOptions.getContentDescription(), markerOptions2.getContentDescription())) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_CONTENT_DESCRIPTION);
        }
        if (markerOptions.b != null) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.ADVANCED_MARKER_ICON_VIEW);
        }
        ab();
    }

    private final void ab() {
        x xVar = this.h;
        if (xVar instanceof u) {
            u uVar = (u) xVar;
            if (uVar.a.getGlyph().getGlyphColor() != -5041134) {
                this.d.c(com.google.android.libraries.navigation.internal.abx.b.ADVANCED_MARKER_CUSTOMIZED_GLYPH_COLOR);
            }
            if (uVar.a.getGlyph().getBitmapDescriptor() != null) {
                this.d.c(com.google.android.libraries.navigation.internal.abx.b.ADVANCED_MARKER_CUSTOMIZED_GLYPH_IMAGE);
            }
            if (uVar.a.getGlyph().getText() != null) {
                this.d.c(com.google.android.libraries.navigation.internal.abx.b.ADVANCED_MARKER_CUSTOMIZED_GLYPH_TEXT);
            }
            if (uVar.a.getBorderColor() != -3857889) {
                this.d.c(com.google.android.libraries.navigation.internal.abx.b.ADVANCED_MARKER_CUSTOMIZED_BORDER_COLOR);
            }
            if (uVar.a.getBackgroundColor() != -1424587) {
                this.d.c(com.google.android.libraries.navigation.internal.abx.b.ADVANCED_MARKER_CUSTOMIZED_BACKGROUND_COLOR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ac(int i) {
        if (this.j) {
            return;
        }
        this.b.d(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void A() {
        com.google.android.libraries.navigation.internal.afu.d.p();
        if (this.j) {
            return;
        }
        this.e.a();
        this.d.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_SHOW_INFO_BUBBLE);
        this.b.n(this, true);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final boolean B(com.google.android.libraries.navigation.internal.lz.p pVar) {
        return equals(pVar);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final boolean C() {
        this.e.a();
        return W();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final boolean D() {
        this.e.a();
        return X();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final boolean E() {
        this.e.a();
        if (this.j) {
            return false;
        }
        ez ezVar = this.b;
        er erVarB = ezVar.b(this);
        com.google.android.libraries.navigation.internal.afu.d.p();
        com.google.android.libraries.navigation.internal.afu.d.r();
        return erVarB.k() || ezVar.c.containsKey(this);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final boolean F() {
        this.e.a();
        return Z();
    }

    public final synchronized float G() {
        return this.z;
    }

    public final synchronized float H() {
        return this.p;
    }

    public final synchronized float I() {
        return this.q;
    }

    public final synchronized float J() {
        return this.x;
    }

    public final synchronized float K() {
        return this.y;
    }

    public final synchronized float L() {
        return this.s;
    }

    public final synchronized float M() {
        return this.o;
    }

    public final int N() {
        this.e.a();
        return this.A;
    }

    public final synchronized Bitmap O() {
        return this.c.a(this.h);
    }

    public final Rect P() {
        return this.f.c();
    }

    public final synchronized LatLng Q() {
        return this.f118n;
    }

    public final String R() {
        this.e.a();
        return this.B;
    }

    public final synchronized String S() {
        return this.v;
    }

    final void T() {
        if (this.j) {
            return;
        }
        if (E()) {
            k();
        }
        this.C = m;
        synchronized (this) {
            this.j = true;
            this.c.c(this.h);
        }
        ez ezVar = this.b;
        el elVar = ezVar.h;
        if (!elVar.d && elVar.e == this) {
            elVar.c();
        }
        View view = (View) ezVar.d.get(this);
        if (view != null) {
            ViewParent parent = ezVar.i.b().getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(view);
                if (ezVar.c.containsKey(this)) {
                    viewGroup.removeView((View) ezVar.c.get(this));
                }
            }
            ezVar.d.remove(this);
        }
        com.google.android.libraries.navigation.internal.afu.d.r();
        er erVar = (er) ezVar.b.get(this);
        if (erVar == null) {
            com.google.android.libraries.navigation.internal.abf.p.f(ez.a, 6);
        } else {
            erVar.i();
            ezVar.b.remove(this);
        }
    }

    public final void U(LatLng latLng) {
        V(latLng);
        ac(0);
    }

    public final synchronized void V(LatLng latLng) {
        this.f118n = latLng;
    }

    public final synchronized boolean W() {
        return this.t;
    }

    public final synchronized boolean X() {
        return this.r;
    }

    public final synchronized boolean Y() {
        return this.j;
    }

    public final synchronized boolean Z() {
        View view = this.i;
        if (view != null) {
            return view.getVisibility() == 0;
        }
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final float a() {
        this.e.a();
        return G();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final float b() {
        this.e.a();
        return L();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final float c() {
        this.e.a();
        return M();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final int d() {
        return hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final synchronized com.google.android.libraries.navigation.internal.lo.l e() {
        this.e.a();
        return new com.google.android.libraries.navigation.internal.lo.n(this.i);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final com.google.android.libraries.navigation.internal.lo.l f() {
        this.e.a();
        return this.C;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final LatLng g() {
        this.e.a();
        return Q();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final String h() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final String i() {
        this.e.a();
        return this.w;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final String j() {
        this.e.a();
        return S();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void k() {
        com.google.android.libraries.navigation.internal.afu.d.p();
        if (this.j || !E()) {
            return;
        }
        this.e.a();
        this.d.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_HIDE_INFO_BUBBLE);
        er erVarB = this.b.b(this);
        if (erVarB != null) {
            erVarB.g();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void l() {
        this.e.a();
        if (this.A == 1) {
            this.d.c(com.google.android.libraries.navigation.internal.abx.b.ADVANCED_MARKER_REMOVE);
            T();
        } else {
            this.d.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_REMOVE);
            T();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void m(float f) {
        this.e.a();
        synchronized (this) {
            if (this.z == f) {
                return;
            }
            this.z = f;
            ac(10);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void n(float f, float f2) {
        this.e.a();
        synchronized (this) {
            if (this.p == f && this.q == f2) {
                return;
            }
            this.p = f;
            this.q = f2;
            ac(2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void o(boolean z) {
        this.e.a();
        synchronized (this) {
            if (this.t == z) {
                return;
            }
            this.t = z;
            ac(5);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void p(boolean z) {
        this.e.a();
        synchronized (this) {
            if (this.r == z) {
                return;
            }
            this.r = z;
            ac(3);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void q(com.google.android.libraries.navigation.internal.lo.l lVar) {
        this.e.a();
        synchronized (this) {
            this.c.c(this.h);
            if (lVar == null) {
                this.h = x.b();
            } else {
                x xVar = (x) com.google.android.libraries.navigation.internal.lo.n.b(lVar);
                this.h = xVar;
                if (xVar instanceof u) {
                    if (this.A == 1 && this.b.j) {
                        ab();
                    } else {
                        this.h = x.b();
                    }
                }
            }
            this.c.b(this.h);
        }
        ac(1);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final synchronized void r(com.google.android.libraries.navigation.internal.lo.l lVar) {
        this.e.a();
        if (this.b.j) {
            x xVar = this.h;
            if (xVar != null) {
                this.c.c(xVar);
            }
            View view = (View) com.google.android.libraries.navigation.internal.lo.n.b(lVar);
            this.i = view;
            if (view == null) {
                this.h = x.b();
            } else {
                this.d.c(com.google.android.libraries.navigation.internal.abx.b.ADVANCED_MARKER_ICON_VIEW);
                this.h = new w(1, 1);
                this.i.getViewTreeObserver().addOnGlobalLayoutListener(new eq(this));
            }
            this.c.b(this.h);
            ac(1);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void s(float f, float f2) {
        this.e.a();
        synchronized (this) {
            if (this.x == f && this.y == f2) {
                return;
            }
            this.x = f;
            this.y = f2;
            ac(9);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void t(LatLng latLng) {
        this.e.a();
        this.d.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_SET_POSITION);
        U(latLng);
    }

    public final String toString() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void u(float f) {
        this.e.a();
        synchronized (this) {
            if (this.s == f) {
                return;
            }
            this.s = f;
            ac(4);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void v(String str) {
        this.e.a();
        this.w = str;
        ac(8);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void w(com.google.android.libraries.navigation.internal.lo.l lVar) {
        this.e.a();
        this.d.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_SET_TAG);
        this.C = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void x(String str) {
        this.e.a();
        synchronized (this) {
            this.v = str;
        }
        ac(7);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void y(boolean z) {
        this.e.a();
        synchronized (this) {
            if (this.u == z) {
                return;
            }
            this.u = z;
            View view = this.i;
            if (view != null) {
                view.setVisibility(true != z ? 8 : 0);
            }
            ac(6);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.p
    public final void z(float f) {
        this.e.a();
        this.d.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_Z_INDEX);
        synchronized (this) {
            if (this.o == f) {
                return;
            }
            this.o = f;
            ac(11);
        }
    }
}
