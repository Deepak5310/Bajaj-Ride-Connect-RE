package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.drew.metadata.mov.metadata.QuickTimeMetadataDirectory;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.FeatureLayerOptions;
import com.google.android.gms.maps.model.FeatureType;
import com.google.android.gms.maps.model.FollowMyLocationOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapColorScheme;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.BuildConfig;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cm extends com.google.android.libraries.navigation.internal.ly.j implements com.google.android.libraries.navigation.internal.ly.cp, cs {
    private static final String w = "cm";
    private final da A;
    private final fm B;
    private final Cdo C;
    private final ec D;
    private final View E;
    private final fv F;
    private final Context G;
    private final id H;
    private final boolean I;
    private final CameraPosition J;
    private final cy K;
    private final m M;
    private final dw N;
    private final bo P;
    private final ea Q;
    private com.google.android.libraries.navigation.internal.ly.cp S;
    private cl T;
    private boolean W;
    private boolean X;
    private boolean Y;
    public final ac a;
    private ArrayList aa;
    private boolean ab;
    private final bl ac;
    private final com.google.android.libraries.navigation.internal.abm.aj ag;
    public final ed b;
    public final fo d;
    public final fe e;
    public final ie f;
    public final aa g;
    public final com.google.android.libraries.navigation.internal.abf.z h;
    public final ht i;
    public final gv j;
    public final Executor k;
    public final boolean l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f115n;
    public boolean o;
    public boolean q;
    public Float r;
    public Float s;
    public LatLngBounds t;
    public com.google.android.libraries.navigation.internal.ly.v u;
    public final bv v;
    private final af x;
    private final z y;
    private final ez z;
    private final ce af = new ce(this);
    public volatile boolean c = false;
    private int R = 1;

    @MapColorScheme
    public int m = 0;
    private fk U = fk.a;
    private fi V = fi.a;
    public boolean p = true;
    private boolean Z = false;
    private boolean ad = false;
    private final com.google.android.libraries.navigation.internal.ly.v ae = new ch(this);
    private final at L = null;
    private final bm O = null;

    public cm(m mVar, View view, ed edVar, z zVar, ez ezVar, Cdo cdo, fe feVar, fo foVar, fm fmVar, ac acVar, af afVar, ie ieVar, aa aaVar, ec ecVar, com.google.android.libraries.navigation.internal.abf.z zVar2, ht htVar, fv fvVar, com.google.android.libraries.navigation.internal.abm.aj ajVar, gv gvVar, da daVar, Executor executor, Context context, id idVar, boolean z, boolean z2, CameraPosition cameraPosition, cy cyVar, at atVar, bv bvVar, bl blVar, dw dwVar, bm bmVar, bo boVar, ea eaVar) {
        this.M = mVar;
        this.E = view;
        this.b = edVar;
        this.y = zVar;
        this.z = ezVar;
        this.C = cdo;
        this.e = feVar;
        this.d = foVar;
        this.B = fmVar;
        this.a = acVar;
        this.x = afVar;
        this.f = ieVar;
        this.g = aaVar;
        this.D = ecVar;
        this.h = zVar2;
        this.i = htVar;
        this.F = fvVar;
        this.ag = ajVar;
        this.j = gvVar;
        this.A = daVar;
        this.k = executor;
        this.G = context;
        this.H = idVar;
        this.l = z;
        this.I = z2;
        this.J = cameraPosition;
        this.K = cyVar;
        this.v = bvVar;
        this.ac = blVar;
        this.N = dwVar;
        this.P = boVar;
        this.Q = eaVar;
    }

    public static cm ax(GoogleMapOptions googleMapOptions, boolean z, be beVar, m mVar) {
        return ay(googleMapOptions, z, beVar, mVar, co.a, mVar.h);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0177  */
    public static cm ay(GoogleMapOptions googleMapOptions, boolean z, be beVar, m mVar, cn cnVar, gh ghVar) {
        boolean z2;
        boolean z3;
        String str;
        d dVar;
        cm cmVar;
        boolean z4;
        boolean z5;
        try {
            com.google.android.libraries.navigation.internal.abf.s.k(googleMapOptions, "GoogleMapOptions");
            com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
            com.google.android.libraries.navigation.internal.abf.s.k(mVar, "AppEnvironment");
            com.google.android.libraries.navigation.internal.abf.s.k(ghVar, "RendererFactory");
            Context context = beVar.a;
            com.google.android.libraries.navigation.internal.yx.br brVar = mVar.a.b;
            id idVar = mVar.b;
            gu guVar = mVar.f;
            ExecutorService executorService = mVar.k;
            ea eaVar = new ea(new com.google.android.libraries.navigation.internal.mk.b());
            boolean z6 = googleMapOptions.getLiteMode() != null && googleMapOptions.getLiteMode().booleanValue();
            com.google.android.libraries.navigation.internal.afu.d.o();
            if (com.google.android.libraries.navigation.internal.afu.p.a.a().b()) {
                com.google.android.libraries.navigation.internal.abf.p.f(w, 5);
                z3 = true;
                z2 = true;
            } else {
                z2 = z6;
                z3 = false;
            }
            if (z2) {
                str = "L";
            } else {
                str = "P";
                com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.ly.ct.a, 4);
            }
            String str2 = str;
            ht htVarB = ht.b(context, idVar, str2, mVar.m, eaVar);
            if (z3) {
                htVarB.c(com.google.android.libraries.navigation.internal.abx.b.MAP_FALLBACK_LITE_MODE);
            }
            final fv fvVar = new fv(mVar.j, guVar, executorService, fv.a, idVar, context, mVar.l);
            if (fvVar.c.a() != null) {
                fvVar.h = fvVar.f.f().toEpochMilli();
                if (com.google.android.libraries.navigation.internal.afu.ae.c()) {
                    fvVar.e.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.fr
                        @Override // java.lang.Runnable
                        public final void run() {
                            fv fvVar2 = fvVar;
                            synchronized (fvVar2.j) {
                                if (fvVar2.o == 1) {
                                    fvVar2.k = fvVar2.h;
                                    SharedPreferences sharedPreferences = fvVar2.b.getSharedPreferences("com.google.maps.api.android.lib6.ul.PREFERENCES_FILE", 0);
                                    if (sharedPreferences.getBoolean("isCachedStartupMarker", false)) {
                                        fvVar2.o = 2;
                                    } else {
                                        fvVar2.o = 3;
                                        sharedPreferences.edit().putBoolean("isCachedStartupMarker", true).commit();
                                    }
                                }
                            }
                        }
                    });
                }
            }
            com.google.android.libraries.navigation.internal.wd.f fVarB = mVar.l.b(com.google.android.libraries.navigation.internal.abx.b.MAP_READY, eaVar.a());
            com.google.android.libraries.navigation.internal.wd.f fVarB2 = mVar.l.b(com.google.android.libraries.navigation.internal.abx.b.STYLED_MAP_READY, eaVar.a());
            com.google.android.libraries.navigation.internal.wd.f fVarB3 = com.google.android.libraries.navigation.internal.afu.d.f() ? mVar.l.b(com.google.android.libraries.navigation.internal.abx.b.MAP_TILE_LOAD, eaVar.a()) : null;
            dd.a(beVar, mVar);
            ie ieVar = new ie(beVar, str2, com.google.android.libraries.navigation.internal.abf.e.a, !com.google.android.libraries.navigation.internal.abf.e.b);
            by byVar = new by(beVar, htVarB);
            int i = el.f;
            Context contextI = beVar.i();
            el elVar = new el(new LinearLayout(contextI), new ImageView(contextI), new ImageView(contextI), beVar, byVar, z2);
            cy cyVar = new cy(htVarB);
            aa aaVar = new aa(beVar, elVar);
            bl blVar = new bl(beVar);
            z zVar = new z(beVar);
            ec ecVar = new ec(com.google.android.libraries.navigation.internal.abf.ah.a());
            if (googleMapOptions.getAmbientEnabled() == null || !googleMapOptions.getAmbientEnabled().booleanValue()) {
                dVar = null;
            } else {
                int i2 = d.b;
                if (com.google.android.libraries.navigation.internal.abf.e.b || com.google.android.libraries.navigation.internal.abf.e.c) {
                    dVar = new d(new c(context));
                } else {
                    dVar = null;
                }
            }
            if (dVar != null) {
                htVarB.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_AMBIENT_STYLING);
            }
            boolean z7 = googleMapOptions.getUseViewLifecycleInFragment() != null && googleMapOptions.getUseViewLifecycleInFragment().booleanValue();
            Executors.newScheduledThreadPool(10, com.google.android.libraries.navigation.internal.abf.ah.f("gmi"));
            af afVar = new af();
            String mapId = googleMapOptions.getMapId();
            ed edVarA = ghVar.a(str2, beVar, mVar, mapId != null ? mapId : "", googleMapOptions.getBackgroundColor(), googleMapOptions.getMapColorScheme(), ieVar.a, aaVar, z, ieVar.b, ecVar, byVar, htVarB, fvVar, com.google.android.libraries.navigation.internal.abf.e.b, dVar, afVar, com.google.android.libraries.navigation.internal.abf.e.f, cyVar, blVar, z3);
            com.google.android.libraries.navigation.internal.afu.v.c();
            dw dwVar = new dw(!com.google.android.libraries.navigation.internal.yx.aq.c(mapId) ? 3 : 2, null);
            if (com.google.android.libraries.navigation.internal.yx.aq.c(mapId)) {
                dwVar.c = "Capabilities unavailable without a Map ID.";
            }
            View viewB = edVarA.b();
            if ((viewB instanceof SurfaceView) && googleMapOptions.getZOrderOnTop() != null) {
                ((SurfaceView) viewB).setZOrderOnTop(googleMapOptions.getZOrderOnTop().booleanValue());
            }
            viewB.setContentDescription(beVar.n(com.google.android.gms.maps.am.d));
            ac acVarC = edVarA.c();
            CameraPosition camera = googleMapOptions.getCamera() != null ? googleMapOptions.getCamera() : ac.a;
            ey eyVarF = edVarA.f();
            com.google.android.libraries.navigation.internal.abf.z zVar2 = com.google.android.libraries.navigation.internal.abf.z.a;
            LinearLayout linearLayout = new LinearLayout(beVar.a);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundDrawable(beVar.l(com.google.android.gms.maps.al.t));
            Context contextI2 = beVar.i();
            float fC = beVar.c() * 14.0f;
            TextView textView = new TextView(contextI2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            textView.setLayoutParams(layoutParams);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setMaxLines(1);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setTextSize(0, fC);
            textView.setTypeface(null, 1);
            TextView textView2 = new TextView(contextI2);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setMaxLines(1);
            textView2.setTextColor(-7829368);
            textView2.setTextSize(0, fC);
            cz czVar = new cz(contextI2, textView, textView2);
            czVar.addView(textView);
            czVar.addView(textView2);
            czVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            czVar.setOrientation(1);
            da daVar = new da(zVar2, linearLayout, czVar);
            final ez ezVar = new ez(eyVarF, daVar, zVar, com.google.android.libraries.navigation.internal.abf.z.a, htVarB, aaVar.j, edVarA, acVarC);
            dwVar.c(ezVar);
            try {
                if (ezVar.j) {
                    ezVar.j = false;
                    for (final es esVar : ezVar.b.keySet()) {
                        com.google.android.libraries.navigation.internal.abf.ah.a().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.ew
                            @Override // java.lang.Runnable
                            public final void run() {
                                ezVar.d(esVar, 1);
                            }
                        });
                    }
                }
                final bo boVar = new bo(dwVar, edVarA, htVarB, guVar, mapId);
                dwVar.c(boVar);
                mVar.i.f(boVar.hashCode(), new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.cb
                    @Override // java.lang.Runnable
                    public final void run() {
                        boVar.a();
                    }
                });
                acVarC.f(ezVar);
                fo foVarH = edVarA.h();
                fm fmVar = new fm(com.google.android.libraries.navigation.internal.abf.z.a, htVarB);
                Cdo cdoD = cnVar.d(context, idVar);
                fg fgVarG = edVarA.g();
                bq bqVarD = edVarA.d();
                fe feVarF = cnVar.f(beVar, acVarC, aaVar.h, fgVarG, cdoD, htVarB, brVar, bqVarD);
                bv bvVarC = cnVar.c(afVar, edVarA.c(), bqVarD, feVarF);
                edVarA.y(bvVarC);
                com.google.android.libraries.navigation.internal.abm.aj ajVarS = edVarA.S();
                gv gvVarI = edVarA.i();
                com.google.android.libraries.navigation.internal.afu.d.s();
                ck ckVar = new ck(fvVar, fVarB, elVar, mVar, fVarB2, fVarB3, edVarA);
                synchronized (ecVar) {
                    try {
                        ecVar.d = ckVar;
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                }
                ecVar.a();
                FrameLayout frameLayout = new FrameLayout(beVar.i());
                frameLayout.addView(viewB);
                frameLayout.addView(ieVar.a);
                frameLayout.addView(aaVar.f);
                frameLayout.addView(blVar.a);
                frameLayout.setTag("GoogleMapView");
                edVarA.J(new cg(ezVar, edVarA));
                cm cmVar2 = new cm(mVar, frameLayout, edVarA, zVar, ezVar, cdoD, feVarF, foVarH, fmVar, acVarC, afVar, ieVar, aaVar, ecVar, com.google.android.libraries.navigation.internal.abf.z.a, htVarB, fvVar, ajVarS, gvVarI, daVar, com.google.android.libraries.navigation.internal.abf.ah.a(), context, idVar, z2, z7, camera, cyVar, null, bvVarC, blVar, dwVar, null, boVar, eaVar);
                if (googleMapOptions.getCompassEnabled() != null) {
                    cmVar = cmVar2;
                    cmVar.aO(googleMapOptions.getCompassEnabled().booleanValue());
                    z4 = true;
                } else {
                    cmVar = cmVar2;
                    z4 = true;
                    cmVar.bj(!com.google.android.libraries.navigation.internal.abf.e.b);
                }
                if (com.google.android.libraries.navigation.internal.abf.e.b) {
                    z5 = false;
                    cmVar.p = false;
                } else {
                    z5 = false;
                }
                if (!cmVar.l) {
                    cmVar.bi(z4);
                    cmVar.bm(com.google.android.libraries.navigation.internal.abf.e.b ^ z4);
                }
                if (googleMapOptions.getZoomControlsEnabled() != null) {
                    cmVar.aZ(googleMapOptions.getZoomControlsEnabled().booleanValue());
                } else {
                    cmVar.bf(z5);
                }
                if (googleMapOptions.getMapType() != -1) {
                    cmVar.G(googleMapOptions.getMapType());
                }
                if (googleMapOptions.getMapColorScheme() != 0) {
                    cmVar.F(googleMapOptions.getMapColorScheme());
                }
                boolean z8 = cmVar.l ^ z4;
                if (googleMapOptions.getZoomGesturesEnabled() != null) {
                    cmVar.ba(googleMapOptions.getZoomGesturesEnabled().booleanValue());
                } else {
                    cmVar.aE(z8);
                }
                if (googleMapOptions.getScrollGesturesEnabled() != null) {
                    cmVar.aW(googleMapOptions.getScrollGesturesEnabled().booleanValue());
                } else {
                    cmVar.aC(z8);
                }
                if (googleMapOptions.getScrollGesturesEnabledDuringRotateOrZoom() != null) {
                    cmVar.aX(googleMapOptions.getScrollGesturesEnabledDuringRotateOrZoom().booleanValue());
                } else {
                    cmVar.be(z8);
                }
                if (googleMapOptions.getTiltGesturesEnabled() != null) {
                    cmVar.aY(googleMapOptions.getTiltGesturesEnabled().booleanValue());
                } else {
                    cmVar.aD(z8);
                }
                if (googleMapOptions.getRotateGesturesEnabled() != null) {
                    cmVar.aV(googleMapOptions.getRotateGesturesEnabled().booleanValue());
                } else {
                    cmVar.aB(z8);
                }
                if (googleMapOptions.getMapToolbarEnabled() != null) {
                    cmVar.aQ(googleMapOptions.getMapToolbarEnabled().booleanValue());
                } else if (com.google.android.libraries.navigation.internal.abf.e.b) {
                    cmVar.bd(z5);
                } else if (cmVar.l) {
                    cmVar.bd(z4);
                } else {
                    cmVar.bd(z4);
                }
                cmVar.aA(z4);
                if (googleMapOptions.getMinZoomPreference() != null) {
                    cmVar.I(googleMapOptions.getMinZoomPreference().floatValue());
                }
                if (googleMapOptions.getMaxZoomPreference() != null) {
                    cmVar.H(googleMapOptions.getMaxZoomPreference().floatValue());
                }
                if (googleMapOptions.getLatLngBoundsForCameraTarget() != null) {
                    cmVar.E(googleMapOptions.getLatLngBoundsForCameraTarget());
                }
                boolean z9 = (googleMapOptions.getMapId() == null || googleMapOptions.getMapId().isEmpty()) ? z5 : z4;
                cmVar.ab = z9;
                if (z9) {
                    cmVar.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_MAPID);
                }
                cmVar.ac.a.setVisibility(8);
                cmVar.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_CREATED);
                if (cmVar.l) {
                    cmVar.M.c.b(com.google.android.libraries.navigation.internal.afm.d.BASE_MAP_CREATE_STATIC, googleMapOptions.getMapId(), cmVar.Q);
                } else {
                    com.google.android.libraries.navigation.internal.afu.v.c();
                    cmVar.M.c.b(!cmVar.ab ? com.google.android.libraries.navigation.internal.afm.d.BASE_MAP_CREATE_DYNAMIC : com.google.android.libraries.navigation.internal.afm.d.PREMIUM_MAP_LOAD, googleMapOptions.getMapId(), cmVar.Q);
                }
                com.google.android.libraries.navigation.internal.afu.d.s();
                return cmVar;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (Throwable th3) {
            bi.c(th3);
            if (th3 instanceof RuntimeException) {
                throw ((RuntimeException) th3);
            }
            if (th3 instanceof Error) {
                throw ((Error) th3);
            }
            throw new RuntimeException(th3);
        }
    }

    private final void bd(boolean z) {
        el elVar = this.g.j;
        if (z == elVar.b) {
            return;
        }
        elVar.b = z;
        if (!z) {
            elVar.a.setVisibility(8);
        }
        elVar.d();
        if (z) {
            this.a.f(elVar);
        } else {
            this.a.o(elVar);
        }
    }

    private final void be(boolean z) {
        this.b.v(z);
    }

    private final void bf(boolean z) {
        boolean z2 = z & (!this.l);
        if (this.f115n != z2) {
            this.f115n = z2;
            Cif cif = this.g.g;
            if (z2) {
                cl clVar = new cl(this.a, cif);
                this.T = clVar;
                clVar.a(h());
                this.a.f(this.T);
                cif.d = this.af;
            } else {
                cif.d = null;
                this.a.o(this.T);
                this.T = null;
            }
            cif.c.setVisibility(true != z2 ? 8 : 0);
        }
    }

    private final void bg() {
        this.M.a();
        this.C.c();
        this.b.o();
    }

    private final void bh() {
        this.M.b();
        this.b.p();
        this.C.d();
    }

    private final void bi(boolean z) {
        this.Y = this.b.P(z);
    }

    private final void bj(boolean z) {
        boolean z2;
        if (this.o == z) {
            return;
        }
        this.o = z;
        aa aaVar = this.g;
        ac acVar = this.a;
        av avVar = aaVar.k;
        CameraPosition cameraPositionC = acVar.c();
        avVar.d = z;
        if (z) {
            avVar.setVisibility(4);
            avVar.a(cameraPositionC);
            avVar.setOnClickListener(new cj(this));
            this.a.f(avVar);
            z2 = true;
        } else {
            avVar.clearAnimation();
            avVar.setVisibility(8);
            this.a.o(avVar);
            avVar.setOnClickListener(null);
            z2 = false;
        }
        this.V.a(z2);
    }

    private final void bk(LatLngBounds latLngBounds) {
        if (com.google.android.libraries.navigation.internal.abf.r.a(this.t, latLngBounds)) {
            return;
        }
        if (am()) {
            com.google.android.libraries.navigation.internal.abf.p.a(6, "Can not set LatLng bounds when camera is in follow mode. Use GoogleMap.moveCamera or GoogleMap.animateCamera to exit follow mode.", new Object[0]);
        } else {
            this.b.z(latLngBounds);
            this.t = latLngBounds;
        }
    }

    private final void bl(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i = 0;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (i2 < 0) {
            i2 = 0;
        }
        Integer numValueOf2 = Integer.valueOf(i2);
        if (i3 < 0) {
            i3 = 0;
        }
        Integer numValueOf3 = Integer.valueOf(i3);
        if (i4 < 0) {
            i4 = 0;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(numValueOf, numValueOf2, numValueOf3, Integer.valueOf(i4)));
        if (com.google.android.libraries.navigation.internal.abf.r.a(this.aa, arrayList)) {
            return;
        }
        this.aa = arrayList;
        this.a.r(i, i2, i3, i4);
        this.g.f.setPadding(i, i2, i3, i4);
        this.f.a.setPadding(i, i2, i3, i4);
        this.U.a(i, i2, i3, i4);
    }

    private final boolean bm(boolean z) {
        int i = this.R;
        boolean z2 = i == 0 || i == 1;
        this.X = z;
        boolean zQ = this.b.Q(z && z2);
        this.q = zQ;
        df dfVar = this.g.i;
        dn dnVar = dfVar.a;
        if (zQ) {
            if (this.p) {
                dfVar.b.setVisibility(0);
            }
            dnVar.d(this.ag);
            this.K.c = dnVar;
        } else {
            dfVar.b.setVisibility(8);
            dnVar.d(null);
            this.K.c = null;
        }
        return this.X;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void A() {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_ZOOM_DEVELOPER_RESET);
            this.b.s();
            this.r = null;
            this.s = null;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void B(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_SET_BUILDINGS_ENABLED : com.google.android.libraries.navigation.internal.abx.b.MAP_SET_BUILDINGS_DISABLED);
            bi(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void C(String str) {
        try {
            this.h.a();
            this.b.b().setContentDescription(str);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void D(com.google.android.libraries.navigation.internal.ly.m mVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MARKER_SET_INFO_CONTENTS_ADAPTER);
            da daVar = this.A;
            daVar.a.a();
            daVar.b = mVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void E(LatLngBounds latLngBounds) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_LAT_LNG_DEVELOPER_CLAMP);
            bk(latLngBounds);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void F(@MapColorScheme int i) {
        try {
            this.h.a();
            this.m = i;
            this.b.A(i);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void G(int i) {
        int i2;
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_MAP_TYPE);
            if (i == 1) {
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_MAP_TYPE_NORMAL);
            } else if (i == 2) {
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_MAP_TYPE_SATELLITE);
            } else if (i == 3) {
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_MAP_TYPE_TERRAIN);
            } else if (i != 4) {
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_MAP_TYPE_NONE);
            } else {
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_MAP_TYPE_HYBRID);
            }
            this.b.C(i);
            ie ieVar = this.f;
            TextView textView = ieVar.b;
            int i3 = 8;
            if (ieVar.c && i != 0) {
                i3 = 0;
            }
            textView.setVisibility(i3);
            this.R = i;
            this.f.a(bb());
            if (an()) {
                bm(true);
            }
            if (!an() || (i2 = this.R) == 0 || i2 == 1) {
                return;
            }
            com.google.android.libraries.navigation.internal.abf.p.a(5, "Deprecation warning: Indoor is no longer supported on satellite, hybrid and terrain map types. isIndoorEnabled() continues to return the value that has been set via setIndoorEnabled(). By default, setIndoorEnabled is 'true'.", new Object[0]);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void H(float f) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_ZOOM_DEVELOPER_MAXIMUM);
            aR(f);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void I(float f) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_ZOOM_DEVELOPER_MINIMUM);
            aS(f);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void J(boolean z) {
        try {
            this.h.a();
            if (!z) {
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_MY_LOCATION_DISABLED);
                this.e.b();
                return;
            }
            if (this.e.j() && this.H != null) {
                PackageManager packageManager = this.G.getPackageManager();
                String packageName = this.G.getPackageName();
                if (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName) != 0 && packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageName) != 0) {
                    throw new SecurityException("my location requires permission ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION");
                }
            }
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_MY_LOCATION_ENABLED);
            this.e.c();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void K(com.google.android.libraries.navigation.internal.ly.u uVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_CAMERA_CHANGE_LISTENER);
            this.a.q(uVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void L(com.google.android.libraries.navigation.internal.ly.x xVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_CAMERA_IDLE_LISTENER);
            if (this.l) {
                com.google.android.libraries.navigation.internal.abf.p.e("setOnCameraIdleListener");
            } else {
                this.x.b(xVar);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void M(com.google.android.libraries.navigation.internal.ly.z zVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_CAMERA_MOVE_CANCELED_LISTENER);
            if (this.l) {
                com.google.android.libraries.navigation.internal.abf.p.e("setOnCameraMoveCanceledListener");
            } else {
                this.x.c(zVar);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void N(com.google.android.libraries.navigation.internal.ly.ab abVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_CAMERA_MOVE_LISTENER);
            if (this.l) {
                com.google.android.libraries.navigation.internal.abf.p.e("setOnCameraMoveListener");
            } else {
                this.x.d(abVar);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void O(com.google.android.libraries.navigation.internal.ly.ad adVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_CAMERA_MOVE_STARTED_LISTENER);
            if (this.l) {
                com.google.android.libraries.navigation.internal.abf.p.e("setOnCameraMoveStartedListener");
            } else {
                this.x.e(adVar);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void P(com.google.android.libraries.navigation.internal.ly.af afVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_CIRCLE_CLICK_LISTENER);
            this.B.c(afVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void Q(com.google.android.libraries.navigation.internal.ly.v vVar) {
        this.h.a();
        this.u = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void R(com.google.android.libraries.navigation.internal.ly.ah ahVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_GROUND_OVERLAY_CLICK_LISTENER);
            if (this.l) {
                com.google.android.libraries.navigation.internal.abf.p.b("Ground overlays");
            }
            this.B.d(ahVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void S(com.google.android.libraries.navigation.internal.ly.aj ajVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_INDOOR_LISTENER);
            this.K.d = ajVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void T(com.google.android.libraries.navigation.internal.ly.al alVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_BUBBLE_CLICK_LISTENER);
            this.z.k(alVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void U(com.google.android.libraries.navigation.internal.ly.an anVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_BUBBLE_CLOSE_LISTENER);
            this.z.l(anVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void V(com.google.android.libraries.navigation.internal.ly.ap apVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_BUBBLE_LONG_CLICK_LISTENER);
            this.z.m(apVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void W(com.google.android.libraries.navigation.internal.ly.av avVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MAP_CLICK_LISTENER);
            this.b.G(avVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void X(com.google.android.libraries.navigation.internal.ly.ax axVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MAP_IDLE_LISTENER);
            ec ecVar = this.D;
            synchronized (ecVar) {
                ecVar.c = axVar;
            }
            ecVar.a();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void Y(com.google.android.libraries.navigation.internal.ly.az azVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MAP_LONG_CLICK_LISTENER);
            this.b.H(azVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void Z(com.google.android.libraries.navigation.internal.ly.bd bdVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MARKER_CLICK_LISTENER);
            this.z.i(bdVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final float a() {
        try {
            this.h.a();
            ac acVar = this.a;
            return acVar.a(acVar.c().target);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    public final void aA(boolean z) {
        boolean z2 = this.l;
        fe feVar = this.e;
        boolean z3 = z & (!z2);
        if (feVar.g == z3) {
            return;
        }
        feVar.g = z3;
        feVar.h();
    }

    public final void aB(boolean z) {
        this.b.t(z);
    }

    public final void aC(boolean z) {
        this.b.u(z);
    }

    public final void aD(boolean z) {
        this.b.w(z);
    }

    public final void aE(boolean z) {
        this.b.x(z);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aF() {
        try {
            this.h.a();
            if (com.google.android.libraries.navigation.internal.abf.e.c) {
                this.b.U();
            }
            if (this.m == 2) {
                this.b.A(2);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aG(Bundle bundle) {
        CameraPosition cameraPosition;
        Bundle bundle2;
        com.google.android.libraries.navigation.internal.ly.v vVar;
        try {
            if (com.google.android.libraries.navigation.internal.afu.ae.c()) {
                final fv fvVar = this.F;
                final long epochMilli = fvVar.f.f().toEpochMilli();
                fvVar.e.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.fu
                    @Override // java.lang.Runnable
                    public final void run() {
                        fv fvVar2 = fvVar;
                        com.google.android.libraries.navigation.internal.wd.g gVar = fvVar2.j;
                        long j = epochMilli;
                        synchronized (gVar) {
                            if (fvVar2.o == 1) {
                                fvVar2.k = j;
                                fvVar2.o = 4;
                            }
                        }
                    }
                });
            }
            this.c = false;
            Bundle bundleA = com.google.android.libraries.navigation.internal.ly.cq.a(bundle);
            if (bundleA != null) {
                cameraPosition = (CameraPosition) bundleA.getParcelable("camera");
                bundle2 = bundleA.getBundle("indoor_state");
                bk((LatLngBounds) bundleA.getParcelable("lat_lng_bounds"));
                com.google.android.libraries.navigation.internal.afu.d.a.a().J();
                bj(bundleA.getBoolean("compass_enabled", true));
                ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("paddings");
                if (integerArrayList != null && integerArrayList.size() == 4) {
                    bl(integerArrayList.get(0).intValue(), integerArrayList.get(1).intValue(), integerArrayList.get(2).intValue(), integerArrayList.get(3).intValue());
                }
                if (bundleA.containsKey("min_zoom_preference")) {
                    aS(bundleA.getFloat("min_zoom_preference"));
                }
                if (bundleA.containsKey("max_zoom_preference")) {
                    aR(bundleA.getFloat("max_zoom_preference"));
                }
            } else {
                cameraPosition = null;
                bundle2 = null;
            }
            if (cameraPosition == null) {
                cameraPosition = this.J;
            }
            this.a.i(cameraPosition, 0);
            if (bundle2 != null && this.ag != null) {
                HashMap map = new HashMap();
                for (String str : bundle2.keySet()) {
                    map.put(str, Integer.valueOf(bundle2.getInt(str)));
                }
                this.ag.a.g(map);
            }
            bv bvVar = this.v;
            if (bvVar != null) {
                com.google.android.libraries.navigation.internal.ly.v vVar2 = this.ae;
                bs bsVar = bvVar.e;
                bsVar.b = vVar2;
                if (bsVar.a.g() && (vVar = bsVar.b) != null) {
                    try {
                        vVar.a();
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
            }
            if (com.google.android.libraries.navigation.internal.afu.ae.c()) {
                final fv fvVar2 = this.F;
                final long epochMilli2 = fvVar2.f.f().toEpochMilli() - fvVar2.k;
                fvVar2.e.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.ft
                    @Override // java.lang.Runnable
                    public final void run() {
                        fv fvVar3 = fvVar2;
                        synchronized (fvVar3.j) {
                            if (fvVar3.o != 1) {
                                if (!fvVar3.l) {
                                    int i = fvVar3.o;
                                    int i2 = i - 1;
                                    if (i == 0) {
                                        throw null;
                                    }
                                    long j = epochMilli2;
                                    if (i2 == 1) {
                                        fvVar3.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_COLD_START_WITH_CACHES_TO_INITIAL_DISPLAY, (int) j);
                                    } else if (i2 == 2) {
                                        fvVar3.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_COLD_START_WITHOUT_CACHES_TO_INITIAL_DISPLAY, (int) j);
                                    } else if (i2 == 3) {
                                        fvVar3.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_WARM_START_TO_INITIAL_DISPLAY, (int) j);
                                    } else if (i2 == 4) {
                                        fvVar3.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_HOT_START_TO_INITIAL_DISPLAY, (int) j);
                                    }
                                    fvVar3.l = true;
                                }
                                fvVar3.a();
                            }
                        }
                    }
                });
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aH() {
        try {
            this.c = true;
            this.e.b();
            this.a.q(null);
            af afVar = this.x;
            afVar.e(null);
            afVar.d(null);
            afVar.c(null);
            afVar.b(null);
            afVar.k.clear();
            this.B.c(null);
            this.B.d(null);
            this.B.f(null);
            this.B.e(null);
            this.z.i(null);
            this.z.j(null);
            this.z.k(null);
            this.z.m(null);
            this.z.l(null);
            z(this.z);
            this.b.G(null);
            this.b.H(null);
            this.b.I(null);
            this.K.d = null;
            fe feVar = this.e;
            feVar.h = null;
            feVar.i = null;
            feVar.g(null);
            aa aaVar = this.g;
            aaVar.k.setOnClickListener(null);
            aaVar.h.a(null);
            aaVar.g.d = null;
            this.a.n();
            this.b.m();
            bo boVar = this.P;
            if (boVar != null) {
                this.M.i.c(boVar.hashCode());
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aI() {
        try {
            this.b.n();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aJ() {
        try {
            if (this.ad) {
                return;
            }
            bg();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aK() {
        try {
            if (this.ad) {
                return;
            }
            bh();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aL(Bundle bundle) {
        try {
            Bundle bundleB = com.google.android.libraries.navigation.internal.ly.cq.b(bundle);
            bundleB.putParcelable("camera", this.a.c());
            com.google.android.libraries.navigation.internal.abm.aj ajVar = this.ag;
            if (ajVar != null) {
                Map mapC = ajVar.a.c();
                Bundle bundle2 = new Bundle();
                for (Map.Entry entry : mapC.entrySet()) {
                    bundle2.putInt((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                }
                bundleB.putBundle("indoor_state", bundle2);
            }
            bundleB.putParcelable("lat_lng_bounds", this.t);
            bundleB.putIntegerArrayList("paddings", this.aa);
            bundleB.putBoolean("compass_enabled", this.o);
            Float f = this.r;
            if (f != null) {
                bundleB.putFloat("min_zoom_preference", f.floatValue());
            }
            Float f2 = this.s;
            if (f2 != null) {
                bundleB.putFloat("max_zoom_preference", f2.floatValue());
            }
            com.google.android.libraries.navigation.internal.ly.cq.e(bundle, bundleB);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aM() {
        try {
            if (com.google.android.libraries.navigation.internal.afu.ae.c()) {
                final fv fvVar = this.F;
                final long epochMilli = fvVar.f.f().toEpochMilli();
                fvVar.e.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.fp
                    @Override // java.lang.Runnable
                    public final void run() {
                        fv fvVar2 = fvVar;
                        com.google.android.libraries.navigation.internal.wd.g gVar = fvVar2.j;
                        long j = epochMilli;
                        synchronized (gVar) {
                            if (fvVar2.o == 1) {
                                fvVar2.k = j;
                                fvVar2.o = 5;
                            }
                        }
                    }
                });
            }
            this.ad = true;
            bh();
            this.b.q();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final void aN() {
        try {
            if (this.ad) {
                this.ad = false;
                bg();
            }
            this.b.r();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aO(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_COMPASS : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_COMPASS);
            bj(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aP() {
        try {
            this.h.a();
            if (this.R == 3) {
                if (aw().K()) {
                    this.b.A(1);
                } else {
                    this.b.A(0);
                }
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aQ(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_MAP_TOOLBAR : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_MAP_TOOLBAR);
            if (!com.google.android.libraries.navigation.internal.abf.e.b) {
                bd(z);
            } else if (z) {
                com.google.android.libraries.navigation.internal.abf.p.a(4, "The toolbar cannot be enabled on this device.", new Object[0]);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aR(float f) {
        if (am()) {
            com.google.android.libraries.navigation.internal.abf.p.a(6, "Can not set zoom preference when camera is in follow mode. Use GoogleMap.moveCamera or GoogleMap.animateCamera to exit follow mode.", new Object[0]);
        } else {
            this.b.D(f);
            this.s = Float.valueOf(f);
        }
    }

    public final void aS(float f) {
        if (am()) {
            com.google.android.libraries.navigation.internal.abf.p.a(6, "Can not set zoom preference when camera is in follow mode. Use GoogleMap.moveCamera or GoogleMap.animateCamera to exit follow mode.", new Object[0]);
        } else {
            this.b.E(f);
            this.r = Float.valueOf(f);
        }
    }

    public final void aT(fi fiVar) {
        this.h.a();
        if (fiVar == null) {
            this.V = fi.a;
        } else {
            this.V = fiVar;
        }
    }

    public final void aU(fk fkVar) {
        try {
            this.h.a();
            if (fkVar == null) {
                this.U = fk.a;
            } else {
                this.U = fkVar;
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aV(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_ROTATE : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_ROTATE);
            aB(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aW(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_SCROLL : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_SCROLL);
            aC(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aX(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_SCROLL_DURING_ROTATE_OR_ZOOM : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_SCROLL_DURING_ROTATE_OR_ZOOM);
            be(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aY(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_TILT : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_TILT);
            aD(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void aZ(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_ZOOM_CONTROLS : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_ZOOM_CONTROLS);
            bf(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void aa(com.google.android.libraries.navigation.internal.ly.bf bfVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MARKER_DRAG_LISTENER);
            this.z.j(bfVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void ab(com.google.android.libraries.navigation.internal.ly.bh bhVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MY_LOCATION_BUTTON_CLICK_LISTENER);
            this.e.i = bhVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    @Deprecated
    public final void ac(com.google.android.libraries.navigation.internal.ly.bj bjVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MY_LOCATION_CHANGE_LISTENER);
            this.e.h = bjVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void ad(com.google.android.libraries.navigation.internal.ly.bl blVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MY_LOCATION_CLICK_LISTENER);
            this.e.g(blVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void ae(com.google.android.libraries.navigation.internal.ly.bn bnVar) {
        try {
            this.h.a();
            this.b.I(bnVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void af(com.google.android.libraries.navigation.internal.ly.bp bpVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_POLYGON_CLICK_LISTENER);
            this.B.e(bpVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void ag(com.google.android.libraries.navigation.internal.ly.br brVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_POLYLINE_CLICK_LISTENER);
            this.B.f(brVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void ah(int i, int i2, int i3, int i4) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_VISIBLE_REGION);
            bl(i, i2, i3, i4);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void ai(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_SET_TRAFFIC_ENABLED : com.google.android.libraries.navigation.internal.abx.b.MAP_SET_TRAFFIC_DISABLED);
            this.W = this.b.R(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void aj(final com.google.android.libraries.navigation.internal.ly.ch chVar, com.google.android.libraries.navigation.internal.lo.l lVar) {
        Object objB;
        if (lVar != null) {
            try {
                objB = com.google.android.libraries.navigation.internal.lo.n.b(lVar);
            } catch (Throwable th) {
                bi.a(th);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof Error)) {
                    throw new RuntimeException(th);
                }
                throw ((Error) th);
            }
        } else {
            objB = null;
        }
        final Bitmap bitmap = (Bitmap) objB;
        this.i.c(bitmap == null ? com.google.android.libraries.navigation.internal.abx.b.MAP_SNAPSHOT : com.google.android.libraries.navigation.internal.abx.b.MAP_SNAPSHOT_ALLOCATED_BITMAP);
        Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.bz
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j.c(bitmap, chVar);
            }
        };
        ExecutorService executorService = com.google.android.libraries.navigation.internal.abf.ah.a;
        new Thread(runnable, "androidmapsapi-".concat("Snapshot")).start();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void ak() {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_STOP_ANIMATION);
            this.a.s();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final boolean al() {
        try {
            this.h.a();
            return this.Y;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final boolean am() {
        this.h.a();
        return this.v.b();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final boolean an() {
        try {
            this.h.a();
            return this.X;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final boolean ao() {
        try {
            this.h.a();
            return this.e.f;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final boolean ap() {
        try {
            this.h.a();
            return this.W;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final boolean aq(boolean z) {
        int i;
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_INDOOR : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_INDOOR);
            if (z && (i = this.R) != 0 && i != 1) {
                com.google.android.libraries.navigation.internal.abf.p.a(5, "Deprecation warning: Indoor is no longer supported on satellite, hybrid and terrain map types. isIndoorEnabled() continues to return the value that has been set via setIndoorEnabled(). By default, setIndoorEnabled is 'true'.", new Object[0]);
            }
            return bm(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:306:0x058a A[Catch: JSONException -> 0x05b6, IllegalArgumentException -> 0x05c4, ej -> 0x05eb, all -> 0x060e, TRY_LEAVE, TryCatch #2 {JSONException -> 0x05b6, blocks: (B:15:0x003c, B:16:0x0042, B:18:0x0048, B:304:0x0584, B:306:0x058a, B:22:0x0053, B:25:0x0074, B:177:0x0331, B:178:0x034a, B:179:0x0359, B:140:0x023f, B:141:0x0245, B:142:0x024d, B:143:0x0255, B:144:0x025d, B:145:0x0265, B:146:0x026d, B:147:0x0275, B:148:0x027b, B:149:0x0283, B:150:0x028b, B:151:0x0293, B:152:0x029b, B:153:0x02a3, B:154:0x02ab, B:155:0x02b1, B:156:0x02b9, B:157:0x02c1, B:158:0x02c9, B:159:0x02d1, B:160:0x02d6, B:161:0x02dd, B:162:0x02e4, B:163:0x02eb, B:164:0x02f2, B:165:0x02f9, B:166:0x02fe, B:167:0x0303, B:168:0x0308, B:169:0x030d, B:170:0x0312, B:171:0x0317, B:172:0x031c, B:173:0x0321, B:174:0x0326, B:175:0x032b, B:180:0x035a, B:182:0x0366, B:225:0x03f8, B:227:0x03fe, B:228:0x0408, B:229:0x0417, B:230:0x0418, B:301:0x0577, B:303:0x057d, B:234:0x042b, B:236:0x0431, B:299:0x0566, B:239:0x043d, B:241:0x0443, B:243:0x0449, B:282:0x04da, B:284:0x04e0, B:286:0x04e6, B:288:0x04fa, B:290:0x0502, B:292:0x050a, B:294:0x0512, B:295:0x0537, B:296:0x0555, B:297:0x0556, B:298:0x0565, B:300:0x0571), top: B:337:0x003c }] */
    /* JADX WARN: Code duplicated, block: B:350:0x058f A[SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final boolean ar(MapStyleOptions mapStyleOptions) {
        String string;
        JSONArray jSONArray;
        String string2;
        Iterator<String> itKeys;
        String str;
        String string3;
        int i;
        String str2;
        int i2;
        Integer numValueOf;
        try {
            this.h.a();
            int i3 = 5;
            int i4 = 0;
            if (this.ab) {
                com.google.android.libraries.navigation.internal.abf.p.a(5, "Map style can't be used for maps with a mapId", new Object[0]);
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_STYLE_WITH_MAP_ID);
                return false;
            }
            int i5 = 1;
            if (mapStyleOptions == null) {
                this.Z = false;
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_STYLE_NULL);
                string = null;
            } else {
                try {
                    String str3 = mapStyleOptions.a;
                    if (com.google.android.libraries.navigation.internal.abf.x.a(str3)) {
                        throw new IllegalArgumentException("JSON parsing error");
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    try {
                        JSONArray jSONArray2 = new JSONArray(str3);
                        int i6 = 0;
                        while (i6 < jSONArray2.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i6);
                            if (jSONObjectOptJSONObject == null) {
                                jSONArray = jSONArray2;
                            } else {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                String strOptString = jSONObjectOptJSONObject.optString("featureType");
                                if (!com.google.android.libraries.navigation.internal.abf.x.a(strOptString)) {
                                    String lowerCase = strOptString.toLowerCase(Locale.getDefault());
                                    switch (lowerCase.hashCode()) {
                                        case -1682541355:
                                            i2 = !lowerCase.equals("landscape.man_made.building") ? -1 : 30;
                                            break;
                                        case -1599092746:
                                            i2 = !lowerCase.equals("transit.station.airport") ? -1 : 26;
                                            break;
                                        case -1505418170:
                                            i2 = !lowerCase.equals("road.highway.controlled_access") ? -1 : 18;
                                            break;
                                        case -1194651664:
                                            i2 = !lowerCase.equals("administrative.province") ? -1 : 3;
                                            break;
                                        case -1133118147:
                                            i2 = !lowerCase.equals("landscape.natural.terrain") ? -1 : 34;
                                            break;
                                        case -1097682670:
                                            i2 = !lowerCase.equals("road.arterial") ? -1 : 19;
                                            break;
                                        case -1067059757:
                                            i2 = !lowerCase.equals("transit") ? -1 : 21;
                                            break;
                                        case -1031736595:
                                            i2 = !lowerCase.equals("poi.medical") ? -1 : 11;
                                            break;
                                        case -180405499:
                                            i2 = !lowerCase.equals("transit.station.ferry") ? -1 : 27;
                                            break;
                                        case -157230378:
                                            i2 = !lowerCase.equals("administrative.country") ? -1 : 2;
                                            break;
                                        case -134269141:
                                            i2 = !lowerCase.equals("transit.station.bus") ? -1 : 25;
                                            break;
                                        case 96673:
                                            i2 = !lowerCase.equals("all") ? -1 : i4;
                                            break;
                                        case 111178:
                                            i2 = !lowerCase.equals(GeoCodingCriteria.POD_POINT_OF_INTEREST) ? -1 : 7;
                                            break;
                                        case 3505952:
                                            i2 = !lowerCase.equals("road") ? -1 : 16;
                                            break;
                                        case 112903447:
                                            i2 = !lowerCase.equals("water") ? -1 : 35;
                                            break;
                                        case 133081159:
                                            i2 = !lowerCase.equals("transit.station.rail") ? -1 : 24;
                                            break;
                                        case 250467976:
                                            i2 = !lowerCase.equals("landscape.man_made.business_corridor") ? -1 : 31;
                                            break;
                                        case 275318680:
                                            i2 = !lowerCase.equals("poi.school") ? -1 : 10;
                                            break;
                                        case 406898958:
                                            i2 = !lowerCase.equals("poi.park") ? -1 : 15;
                                            break;
                                        case 442327069:
                                            i2 = !lowerCase.equals("administrative.land_parcel") ? -1 : 6;
                                            break;
                                        case 684338196:
                                            i2 = !lowerCase.equals("poi.sports_complex") ? -1 : 14;
                                            break;
                                        case 794909067:
                                            i2 = !lowerCase.equals("poi.attraction") ? -1 : 12;
                                            break;
                                        case 886349615:
                                            i2 = !lowerCase.equals("transit.line") ? -1 : 22;
                                            break;
                                        case 1017964746:
                                            i2 = !lowerCase.equals("poi.place_of_worship") ? -1 : 13;
                                            break;
                                        case 1097815061:
                                            i2 = !lowerCase.equals("poi.government") ? -1 : 9;
                                            break;
                                        case 1239794868:
                                            i2 = !lowerCase.equals("landscape.natural.landcover") ? -1 : 33;
                                            break;
                                        case 1255702830:
                                            i2 = !lowerCase.equals("administrative") ? -1 : i5;
                                            break;
                                        case 1353986038:
                                            i2 = !lowerCase.equals("landscape.natural") ? -1 : 32;
                                            break;
                                        case 1383809709:
                                            i2 = !lowerCase.equals("landscape.man_made") ? -1 : 29;
                                            break;
                                        case 1430647483:
                                            i2 = !lowerCase.equals("landscape") ? -1 : 28;
                                            break;
                                        case 1474027839:
                                            i2 = !lowerCase.equals("road.highway") ? -1 : 17;
                                            break;
                                        case 1693639203:
                                            i2 = !lowerCase.equals("administrative.locality") ? -1 : 4;
                                            break;
                                        case 1708944334:
                                            i2 = !lowerCase.equals("administrative.neighborhood") ? -1 : i3;
                                            break;
                                        case 1833333533:
                                            i2 = !lowerCase.equals("road.local") ? -1 : 20;
                                            break;
                                        case 2003469337:
                                            i2 = !lowerCase.equals("transit.station") ? -1 : 23;
                                            break;
                                        case 2129785572:
                                            i2 = !lowerCase.equals("poi.business") ? -1 : 8;
                                            break;
                                        default:
                                            i2 = -1;
                                            break;
                                    }
                                    switch (i2) {
                                        case 0:
                                            numValueOf = Integer.valueOf(i4);
                                            break;
                                        case 1:
                                            numValueOf = Integer.valueOf(i5);
                                            break;
                                        case 2:
                                            numValueOf = 17;
                                            break;
                                        case 3:
                                            numValueOf = 18;
                                            break;
                                        case 4:
                                            numValueOf = 19;
                                            break;
                                        case 5:
                                            numValueOf = 20;
                                            break;
                                        case 6:
                                            numValueOf = 21;
                                            break;
                                        case 7:
                                            numValueOf = 2;
                                            break;
                                        case 8:
                                            numValueOf = 33;
                                            break;
                                        case 9:
                                            numValueOf = 34;
                                            break;
                                        case 10:
                                            numValueOf = 35;
                                            break;
                                        case 11:
                                            numValueOf = 36;
                                            break;
                                        case 12:
                                            numValueOf = 37;
                                            break;
                                        case 13:
                                            numValueOf = 38;
                                            break;
                                        case 14:
                                            numValueOf = 39;
                                            break;
                                        case 15:
                                            numValueOf = 40;
                                            break;
                                        case 16:
                                            numValueOf = 3;
                                            break;
                                        case 17:
                                            numValueOf = 49;
                                            break;
                                        case 18:
                                            numValueOf = 785;
                                            break;
                                        case 19:
                                            numValueOf = 50;
                                            break;
                                        case 20:
                                            numValueOf = 51;
                                            break;
                                        case 21:
                                            numValueOf = 4;
                                            break;
                                        case 22:
                                            numValueOf = 65;
                                            break;
                                        case 23:
                                            numValueOf = 66;
                                            break;
                                        case 24:
                                            numValueOf = Integer.valueOf(PhotoshopDirectory.TAG_VERSION);
                                            break;
                                        case 25:
                                            numValueOf = Integer.valueOf(PhotoshopDirectory.TAG_EXIF_DATA_1);
                                            break;
                                        case 26:
                                            numValueOf = Integer.valueOf(PhotoshopDirectory.TAG_EXIF_DATA_3);
                                            break;
                                        case 27:
                                            numValueOf = Integer.valueOf(PhotoshopDirectory.TAG_XMP_DATA);
                                            break;
                                        case 28:
                                            numValueOf = Integer.valueOf(i3);
                                            break;
                                        case 29:
                                            numValueOf = 81;
                                            break;
                                        case 30:
                                            numValueOf = Integer.valueOf(QuickTimeMetadataDirectory.TAG_YEAR);
                                            break;
                                        case 31:
                                            numValueOf = 1299;
                                            break;
                                        case 32:
                                            numValueOf = 82;
                                            break;
                                        case 33:
                                            numValueOf = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagPictureModeSaturation);
                                            break;
                                        case 34:
                                            numValueOf = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagPictureModeHue);
                                            break;
                                        case 35:
                                            numValueOf = 6;
                                            break;
                                        default:
                                            numValueOf = null;
                                            break;
                                    }
                                    if (numValueOf == null) {
                                        throw new ej("Unknown feature type: ".concat(String.valueOf(strOptString)));
                                    }
                                    ek.a(stringBuffer2, "s.t:" + numValueOf.intValue(), "|");
                                }
                                String strOptString2 = jSONObjectOptJSONObject.optString("elementType");
                                if (!com.google.android.libraries.navigation.internal.abf.x.a(strOptString2)) {
                                    String lowerCase2 = strOptString2.toLowerCase(Locale.getDefault());
                                    switch (lowerCase2.hashCode()) {
                                        case -2097308289:
                                            i = !lowerCase2.equals("geometry.fill") ? -1 : 3;
                                            break;
                                        case -1936384395:
                                            i = !lowerCase2.equals("labels.text.fill") ? -1 : 8;
                                            break;
                                        case -1110417409:
                                            i = !lowerCase2.equals("labels") ? -1 : 4;
                                            break;
                                        case -791081164:
                                            i = !lowerCase2.equals("geometry.stroke") ? -1 : 2;
                                            break;
                                        case -762041686:
                                            i = !lowerCase2.equals("labels.text.stroke") ? -1 : 7;
                                            break;
                                        case 96673:
                                            i = !lowerCase2.equals("all") ? -1 : i4;
                                            break;
                                        case 913325320:
                                            i = !lowerCase2.equals("labels.icon") ? -1 : i3;
                                            break;
                                        case 913655228:
                                            i = !lowerCase2.equals("labels.text") ? -1 : 6;
                                            break;
                                        case 1846020210:
                                            i = !lowerCase2.equals("geometry") ? -1 : i5;
                                            break;
                                        default:
                                            i = -1;
                                            break;
                                    }
                                    switch (i) {
                                        case 0:
                                            str2 = "";
                                            break;
                                        case 1:
                                            str2 = "g";
                                            break;
                                        case 2:
                                            str2 = "g.s";
                                            break;
                                        case 3:
                                            str2 = "g.f";
                                            break;
                                        case 4:
                                            str2 = "l";
                                            break;
                                        case 5:
                                            str2 = "l.i";
                                            break;
                                        case 6:
                                            str2 = "l.t";
                                            break;
                                        case 7:
                                            str2 = "l.t.s";
                                            break;
                                        case 8:
                                            str2 = "l.t.f";
                                            break;
                                        default:
                                            str2 = null;
                                            break;
                                    }
                                    if (str2 == null) {
                                        throw new ej("Unknown element type: ".concat(String.valueOf(strOptString2)));
                                    }
                                    if (!str2.isEmpty()) {
                                        ek.a(stringBuffer2, "s.e:".concat(str2), "|");
                                    }
                                }
                                JSONArray jSONArray3 = jSONObjectOptJSONObject.getJSONArray("stylers");
                                StringBuffer stringBuffer3 = new StringBuffer();
                                if (jSONArray3 == null) {
                                    jSONArray = jSONArray2;
                                    string2 = null;
                                } else {
                                    int i7 = i4;
                                    while (i7 < jSONArray3.length()) {
                                        JSONObject jSONObjectOptJSONObject2 = jSONArray3.optJSONObject(i7);
                                        if (jSONObjectOptJSONObject2 != null && (itKeys = jSONObjectOptJSONObject2.keys()) != null) {
                                            while (itKeys.hasNext()) {
                                                String next = itKeys.next();
                                                String strOptString3 = jSONObjectOptJSONObject2.optString(next);
                                                JSONArray jSONArray4 = jSONArray2;
                                                switch (next.toLowerCase(Locale.getDefault())) {
                                                    case "hue":
                                                        str = "h";
                                                        break;
                                                    case "saturation":
                                                        str = "s";
                                                        break;
                                                    case "lightness":
                                                        str = "l";
                                                        break;
                                                    case "gamma":
                                                        str = "g";
                                                        break;
                                                    case "invert_lightness":
                                                        str = "il";
                                                        break;
                                                    case "visibility":
                                                        str = "v";
                                                        break;
                                                    case "color":
                                                        str = "c";
                                                        break;
                                                    case "weight":
                                                        str = "w";
                                                        break;
                                                    default:
                                                        str = null;
                                                        break;
                                                }
                                                if (com.google.android.libraries.navigation.internal.abf.x.a(str)) {
                                                    throw new ej("Unknown styler key: ".concat(String.valueOf(next)));
                                                }
                                                if (!com.google.android.libraries.navigation.internal.abf.x.a(strOptString3)) {
                                                    JSONArray jSONArray5 = jSONArray3;
                                                    String lowerCase3 = strOptString3.trim().toLowerCase(Locale.getDefault());
                                                    if (!lowerCase3.isEmpty() && !lowerCase3.equals("{}") && !lowerCase3.equals(BuildConfig.TRAVIS) && !lowerCase3.equals("false")) {
                                                        ek.a(stringBuffer3, "p." + str + ":" + strOptString3, "|");
                                                        jSONArray2 = jSONArray4;
                                                        jSONArray3 = jSONArray5;
                                                    }
                                                }
                                                throw new ej("Empty or null style value for " + next + ": " + strOptString3);
                                            }
                                        }
                                        i7++;
                                        jSONArray2 = jSONArray2;
                                        jSONArray3 = jSONArray3;
                                    }
                                    jSONArray = jSONArray2;
                                    string2 = stringBuffer3.toString();
                                }
                                if (!com.google.android.libraries.navigation.internal.abf.x.a(string2)) {
                                    ek.a(stringBuffer2, string2, "|");
                                    string3 = stringBuffer2.toString();
                                }
                                if (!com.google.android.libraries.navigation.internal.abf.x.a(string3)) {
                                    ek.a(stringBuffer, string3, ",");
                                }
                                i6++;
                                jSONArray2 = jSONArray;
                                i3 = 5;
                                i4 = 0;
                                i5 = 1;
                            }
                            string3 = null;
                            if (!com.google.android.libraries.navigation.internal.abf.x.a(string3)) {
                                ek.a(stringBuffer, string3, ",");
                            }
                            i6++;
                            jSONArray2 = jSONArray;
                            i3 = 5;
                            i4 = 0;
                            i5 = 1;
                        }
                        string = stringBuffer.toString();
                        this.Z = true;
                        this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_STYLE);
                    } catch (JSONException e) {
                        throw new IllegalArgumentException("JSON parsing error", e);
                    }
                } catch (ej e2) {
                    com.google.android.libraries.navigation.internal.abf.p.c("InvalidStyleException: " + e2.getMessage());
                    this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_STYLE_INVALID_STYLE);
                    return false;
                } catch (IllegalArgumentException e3) {
                    com.google.android.libraries.navigation.internal.abf.p.c("Map style parsing failed: " + String.valueOf(e3.getCause()));
                    this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_STYLE_ILLEGAL_ARGUMENT);
                    return false;
                }
            }
            this.b.B(string);
            this.f.a(bb());
            return true;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cp
    public final void as(boolean z) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cp
    public final void at(boolean z) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cp
    public final boolean au() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final View av() {
        try {
            return this.E;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    public final com.google.android.libraries.navigation.internal.oa.k aw() {
        this.h.a();
        return this.b.e().d();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    /* JADX INFO: renamed from: az, reason: merged with bridge method [inline-methods] */
    public final dw m() {
        try {
            this.h.a();
            dw dwVar = this.N;
            boolean z = dwVar.a;
            boolean z2 = dwVar.a;
            String str = dwVar.c;
            String strConcat = "For capability in capabilities, log:\n\"AdvancedMarkers: false".concat(!com.google.android.libraries.navigation.internal.yx.aq.c(str) ? ": ".concat(String.valueOf(str)) : "\n");
            boolean z3 = dwVar.b;
            com.google.android.libraries.navigation.internal.abf.p.a(3, strConcat + "\"Data-driven styling: false", new Object[0]);
            return this.N;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final float b() {
        try {
            this.h.a();
            return this.a.b();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    public final void ba(boolean z) {
        try {
            this.h.a();
            this.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_ZOOM : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_ZOOM);
            aE(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    final boolean bb() {
        com.google.android.libraries.navigation.internal.afu.d.s();
        int i = this.R;
        if (i == 4 || i == 2) {
            return true;
        }
        return this.Z && i == 1;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cs
    public final boolean bc() {
        try {
            return this.I;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    @MapColorScheme
    public final int c() {
        try {
            this.h.a();
            return this.m;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final int d() {
        try {
            this.h.a();
            return this.R;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    @Deprecated
    public final Location e() {
        try {
            this.h.a();
            fe feVar = this.e;
            com.google.android.libraries.navigation.internal.abf.t.b(feVar.f, "MyLocation layer not enabled");
            return feVar.e;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final com.google.android.libraries.navigation.internal.ly.cf f() {
        try {
            this.h.a();
            return new gb(this.i, this.a.e());
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final com.google.android.libraries.navigation.internal.ly.cp g() {
        try {
            this.h.a();
            if (this.S == null) {
                this.S = new ci(this);
            }
            return this.S;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final CameraPosition h() {
        try {
            this.h.a();
            return this.a.c();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final com.google.android.libraries.navigation.internal.lz.d i(CircleOptions circleOptions) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ADD_CIRCLE);
            au auVar = new au(circleOptions, this.B, this.i, this.h);
            auVar.a = this.d.f(auVar);
            this.B.a(auVar);
            return auVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.lz.f j(FeatureLayerOptions featureLayerOptions) throws RemoteException {
        try {
            this.h.a();
            bo boVar = this.P;
            String featureType = featureLayerOptions.getFeatureType();
            if (com.google.android.libraries.navigation.internal.afu.d.a.a().f() && featureType.equals(FeatureType.DATASET)) {
                featureType = featureLayerOptions.getDatasetId();
            }
            if (!boVar.a.containsKey(featureType)) {
                boVar.a.put(featureType, new bn(featureLayerOptions, boVar.d, boVar.c, boVar.b, boVar.e));
            }
            return (bn) boVar.a.get(featureType);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final com.google.android.libraries.navigation.internal.lz.h k(GroundOverlayOptions groundOverlayOptions) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ADD_GROUND_OVERLAY);
            cr crVar = new cr(groundOverlayOptions, this.B, this.y, this.i, this.h);
            crVar.b = this.d.e(crVar);
            this.B.a(crVar);
            return crVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.lz.j l() throws RemoteException {
        com.google.android.libraries.navigation.internal.abm.ag agVarC;
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.INDOOR_GET_FOCUSED_BUILDING);
            com.google.android.libraries.navigation.internal.abm.aj ajVar = this.ag;
            if (ajVar == null || (agVarC = ajVar.c()) == null) {
                return null;
            }
            return new ct(this.ag, agVarC, this.i);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final com.google.android.libraries.navigation.internal.lz.p n(MarkerOptions markerOptions) {
        try {
            com.google.android.libraries.navigation.internal.wd.g gVar = this.M.l;
            this.h.a();
            if (markerOptions.c == 1) {
                com.google.android.libraries.navigation.internal.afu.ae.d();
                this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ADD_ADVANCED_MARKER);
                es esVarC = this.z.c(markerOptions);
                com.google.android.libraries.navigation.internal.afu.ae.d();
                return esVarC;
            }
            com.google.android.libraries.navigation.internal.afu.ae.d();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ADD_MARKER);
            es esVarC2 = this.z.c(markerOptions);
            com.google.android.libraries.navigation.internal.afu.ae.d();
            return esVarC2;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final com.google.android.libraries.navigation.internal.lz.t o(PolygonOptions polygonOptions) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ADD_POLYGON);
            final fx fxVar = new fx(polygonOptions, this.B, this.i, this.h);
            if (com.google.android.libraries.navigation.internal.abf.r.a(this.b.j(), "P")) {
                this.B.a(fxVar);
                ExecutorService executorService = com.google.android.libraries.navigation.internal.abf.ah.a;
                com.google.android.libraries.navigation.internal.abf.ah.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.cd
                    @Override // java.lang.Runnable
                    public final void run() {
                        cm cmVar = this.a;
                        fo foVar = cmVar.d;
                        final fx fxVar2 = fxVar;
                        final fn fnVarG = foVar.g(fxVar2);
                        fxVar2.a = fnVarG;
                        cmVar.k.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.ca
                            @Override // java.lang.Runnable
                            public final void run() {
                                fnVarG.b(fxVar2.b);
                            }
                        });
                    }
                });
            } else {
                fxVar.a = this.d.g(fxVar);
                this.B.a(fxVar);
            }
            return fxVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final com.google.android.libraries.navigation.internal.lz.v p(PolylineOptions polylineOptions) {
        try {
            this.h.a();
            if (com.google.android.libraries.navigation.internal.afu.d.a.a().c()) {
                com.google.android.libraries.navigation.internal.abf.t.c(polylineOptions, "PolylineOptions is null.");
                Iterator<LatLng> it2 = polylineOptions.getPoints().iterator();
                while (it2.hasNext()) {
                    com.google.android.libraries.navigation.internal.abf.t.c(it2.next(), "Developer error message cannot be null.");
                }
            }
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ADD_POLYLINE);
            fz fzVar = new fz(polylineOptions, this.B, this.y, this.i, this.h);
            fzVar.a = this.d.h(fzVar);
            this.B.a(fzVar);
            return fzVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final com.google.android.libraries.navigation.internal.lz.z q(TileOverlayOptions tileOverlayOptions) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ADD_TILE_OVERLAY);
            ho hoVar = new ho(tileOverlayOptions, this.B, this.i, this.h);
            hoVar.b = this.d.i(hoVar);
            this.B.a(hoVar);
            return hoVar;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void r(com.google.android.libraries.navigation.internal.ly.at atVar) {
        try {
            this.h.a();
            m().c(atVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void s(com.google.android.libraries.navigation.internal.lo.l lVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ANIMATE_CAMERA);
            this.a.t((ab) com.google.android.libraries.navigation.internal.lo.n.b(lVar), -1, null, this.i);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void t(com.google.android.libraries.navigation.internal.lo.l lVar, com.google.android.libraries.navigation.internal.ly.g gVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ANIMATE_CAMERA_WITH_CALLBACK);
            this.a.t((ab) com.google.android.libraries.navigation.internal.lo.n.b(lVar), -1, gVar, this.i);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void u(com.google.android.libraries.navigation.internal.lo.l lVar, int i, com.google.android.libraries.navigation.internal.ly.g gVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_ANIMATE_CAMERA_WITH_CALLBACK_AND_CUSTOM_DURATION);
            ab abVar = (ab) com.google.android.libraries.navigation.internal.lo.n.b(lVar);
            com.google.android.libraries.navigation.internal.abf.s.a(i > 0, "durationMs must be positive");
            this.a.t(abVar, i, gVar, this.i);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void v() {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_CLEAR);
            ez ezVar = this.z;
            ezVar.e.a();
            Iterator it2 = ezVar.b.keySet().iterator();
            while (it2.hasNext()) {
                ((es) it2.next()).T();
            }
            ezVar.b.clear();
            ezVar.d.clear();
            fm fmVar = this.B;
            Iterator it3 = fmVar.a.iterator();
            while (it3.hasNext()) {
                ((fl) it3.next()).G();
            }
            fmVar.a.clear();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void w(com.google.android.libraries.navigation.internal.afl.fd fdVar, FollowMyLocationOptions followMyLocationOptions) {
        this.h.a();
        com.google.android.libraries.navigation.internal.abf.s.k(this.v, "FollowMyLocationManager method is null.");
        this.v.a(fdVar, followMyLocationOptions);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void x(final com.google.android.libraries.navigation.internal.ly.bb bbVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_SET_ON_MAP_READY_CALLBACK);
            this.k.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.cc
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.libraries.navigation.internal.ly.bb bbVar2 = bbVar;
                    cm cmVar = this.a;
                    if (cmVar.c) {
                        return;
                    }
                    try {
                        bbVar2.a(cmVar);
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
            });
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void y(com.google.android.libraries.navigation.internal.lo.l lVar) {
        try {
            this.h.a();
            this.i.c(com.google.android.libraries.navigation.internal.abx.b.MAP_MOVE_CAMERA);
            this.a.t((ab) com.google.android.libraries.navigation.internal.lo.n.b(lVar), 0, null, this.i);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.k
    public final void z(com.google.android.libraries.navigation.internal.ly.at atVar) {
        try {
            this.h.a();
            m().d.remove(atVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }
}
