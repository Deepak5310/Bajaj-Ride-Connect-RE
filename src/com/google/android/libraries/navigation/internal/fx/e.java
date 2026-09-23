package com.google.android.libraries.navigation.internal.fx;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.libraries.navigation.internal.hx.l;
import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bf;
import com.google.android.libraries.navigation.internal.yx.bj;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e {
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fx.e");
    public final String a;
    public final String b;
    final Executor c;
    private final Context e;
    private boolean f = false;
    private final String g = "com.google.android.gms";
    private final String h = "com.google.android.gms.maps.auth.ApiTokenService";

    public e(Context context, String str, String str2, Executor executor) {
        this.e = context;
        this.a = str;
        this.b = str2;
        this.c = l.a(executor);
    }

    public final void a() {
        String strF;
        if (this.f) {
            return;
        }
        String strB = j.b(this.e.getPackageManager(), this.b);
        if (strB == null) {
            strF = null;
        } else {
            ah ahVar = new ah(":");
            ar.b(true, "The length may not be less than 1");
            strF = ahVar.f(new bj(new bf()).g(strB.toUpperCase(Locale.US)));
        }
        com.google.android.libraries.navigation.internal.gz.f.b("Authorization failure.\nIn the Google Developer Console (https://console.developers.google.com)\nEnsure that the \"Google Maps Android API\" is enabled.\nEnsure that the following Android Key exists:\n\tAPI Key: " + this.a + "\n\tAndroid Application (<cert_fingerprint>;<package_name>): " + strF + ";" + this.b);
        this.f = true;
    }

    final void b(ServiceConnection serviceConnection) {
        this.e.unbindService(serviceConnection);
    }

    public final void c(f fVar) {
        ar.r(fVar, "callback");
        if (this.e.bindService(new Intent().setClassName(this.g, this.h), new c(this, fVar), 1)) {
            return;
        }
        com.google.android.libraries.navigation.internal.gz.f.b("Google Play services is not present on this device.");
        this.c.execute(new d(fVar));
    }
}
