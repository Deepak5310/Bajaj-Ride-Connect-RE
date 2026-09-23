package com.google.android.libraries.navigation.internal.ly;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.libraries.navigation.internal.abh.dx;
import com.google.android.libraries.navigation.internal.abh.dy;
import com.google.android.libraries.navigation.internal.abh.en;
import com.google.android.libraries.navigation.internal.abh.gx;
import com.google.android.libraries.navigation.internal.abh.gy;
import com.google.android.libraries.navigation.internal.abh.hh;
import com.google.android.libraries.navigation.internal.abh.id;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c extends h {
    private final b a;
    private boolean b;
    private id c;
    private com.google.android.libraries.navigation.internal.abh.m d;
    private Resources e;
    private final boolean f;

    public c() {
        b bVar = b.a;
        this.f = true;
        this.a = bVar;
        this.b = false;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    private final Resources h(Context context) {
        return ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 3 ? context.getResources() : this.e;
    }

    private final com.google.android.libraries.navigation.internal.abh.m i(com.google.android.libraries.navigation.internal.abh.be beVar) {
        try {
            com.google.android.libraries.navigation.internal.abf.p.a(4, "Google Play services package version: " + beVar.a.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode, new Object[0]);
            if (this.d == null) {
                Context context = beVar.a;
                id idVar = this.c;
                ct ctVar = ct.b;
                com.google.android.libraries.navigation.internal.wx.b bVar = new com.google.android.libraries.navigation.internal.wx.b(context);
                com.google.android.libraries.navigation.internal.abh.i iVar = com.google.android.libraries.navigation.internal.abh.i.a;
                ExecutorService executorService = com.google.android.libraries.navigation.internal.abf.ah.a;
                this.d = com.google.android.libraries.navigation.internal.abh.m.c(context, idVar, ctVar, iVar, null, bVar);
            }
            return this.d;
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.i
    public final e a() {
        return new com.google.android.libraries.navigation.internal.abh.ar();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.i
    public final q b(com.google.android.libraries.navigation.internal.lo.l lVar) {
        com.google.android.libraries.navigation.internal.abf.s.d(this.b, "CreatorImpl not initialized properly.");
        Activity activity = (Activity) com.google.android.libraries.navigation.internal.lo.n.b(lVar);
        com.google.android.libraries.navigation.internal.abh.be beVar = new com.google.android.libraries.navigation.internal.abh.be(activity, h(activity));
        return new dy(new dx(beVar.p(), beVar, i(beVar)), beVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.i
    public final s c(com.google.android.libraries.navigation.internal.lo.l lVar, GoogleMapOptions googleMapOptions) {
        com.google.android.libraries.navigation.internal.abf.s.d(this.b, "CreatorImpl not initialized properly.");
        Context context = (Context) com.google.android.libraries.navigation.internal.lo.n.b(lVar);
        com.google.android.libraries.navigation.internal.abh.be beVar = new com.google.android.libraries.navigation.internal.abh.be(context, h(context));
        return new en(googleMapOptions, beVar, i(beVar));
    }

    @Override // com.google.android.libraries.navigation.internal.ly.i
    public final cl d(com.google.android.libraries.navigation.internal.lo.l lVar) {
        com.google.android.libraries.navigation.internal.abf.s.d(this.b, "CreatorImpl not initialized properly.");
        com.google.android.libraries.navigation.internal.abh.be beVar = new com.google.android.libraries.navigation.internal.abh.be((Activity) com.google.android.libraries.navigation.internal.lo.n.b(lVar), this.e);
        return new gy(new gx(beVar.p(), beVar, i(beVar)), beVar, Build.VERSION.SDK_INT);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.i
    public final cn e(com.google.android.libraries.navigation.internal.lo.l lVar, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        com.google.android.libraries.navigation.internal.abf.s.d(this.b, "CreatorImpl not initialized properly.");
        com.google.android.libraries.navigation.internal.abh.be beVar = new com.google.android.libraries.navigation.internal.abh.be((Context) com.google.android.libraries.navigation.internal.lo.n.b(lVar), this.e);
        return new hh(streetViewPanoramaOptions, beVar, i(beVar));
    }

    @Override // com.google.android.libraries.navigation.internal.ly.i
    public final com.google.android.libraries.navigation.internal.lz.b f() {
        return new com.google.android.libraries.navigation.internal.abh.n();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.i
    public final void g(com.google.android.libraries.navigation.internal.lo.l lVar, int i) {
        com.google.android.libraries.navigation.internal.abf.p.a(4, com.google.android.libraries.navigation.internal.b.b.b(0, "Google Play services client version: "), new Object[0]);
        this.e = (Resources) com.google.android.libraries.navigation.internal.lo.n.b(lVar);
        this.c = new id(0);
        MapsInitializer.a(this);
        this.b = true;
    }
}
