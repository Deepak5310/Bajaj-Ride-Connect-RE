package com.google.android.libraries.navigation.internal.abe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.libraries.navigation.internal.abf.ah;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.s;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.google.android.libraries.navigation.internal.abg.d implements h {
    public static final String a = "c";
    public final String b;
    public final String c;
    private final Context m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f110n;

    public c(Context context, String str, String str2) {
        super(context, ah.d("atsc"));
        this.f110n = false;
        this.m = context;
        this.b = str;
        this.c = str2;
    }

    private final void e() {
        String str;
        if (this.f110n) {
            return;
        }
        p.c("Authorization failure.  Please see https://developers.google.com/maps/documentation/android-sdk/start for how to correctly set up the map.");
        String strA = com.google.android.libraries.navigation.internal.abf.d.a(this.m.getPackageManager(), this.c);
        if (strA == null) {
            str = null;
        } else {
            String strB = com.google.android.libraries.navigation.internal.yx.c.b(strA);
            int length = strB.length();
            String strConcat = "";
            for (int i = 0; i < length; i++) {
                strConcat = strConcat + strB.charAt(i);
                if (i > 0 && i % 2 == 1 && i < length - 1) {
                    strConcat = strConcat.concat(":");
                }
            }
            str = strConcat;
        }
        p.c("In the Google Developer Console (https://console.developers.google.com)\nEnsure that the \"Maps SDK for Android\" is enabled.\nEnsure that the following Android Key exists:\n\tAPI Key: " + this.b + "\n\tAndroid Application (<cert_fingerprint>;<package_name>): " + str + ";" + this.c);
        this.f110n = true;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.d
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.auth.IApiTokenService");
        return iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lx.b ? (com.google.android.libraries.navigation.internal.lx.b) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lx.a(iBinder);
    }

    @Override // com.google.android.libraries.navigation.internal.abe.h
    public final void b(g gVar) {
        boolean zBindService;
        com.google.android.libraries.navigation.internal.abg.b bVar = new com.google.android.libraries.navigation.internal.abg.b(new b(this, gVar));
        synchronized (this.j) {
            int i = this.l;
            if (i != 1) {
                if (i == 2) {
                    this.g.add(bVar);
                    return;
                } else if (i == 3) {
                    this.f.execute(bVar);
                    return;
                } else {
                    if (i != 4) {
                        throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(i, "Unknown state: "));
                    }
                    p.f(com.google.android.libraries.navigation.internal.abg.d.d, 3);
                    return;
                }
            }
            Intent className = new Intent().setClassName(this.h, this.i);
            synchronized (this.j) {
                s.d(this.l == 1, "Binding has already been attempted");
                this.l = 2;
                zBindService = this.e.bindService(className, this.j, 1);
                if (!zBindService) {
                    p.f(com.google.android.libraries.navigation.internal.abg.d.d, 6);
                    this.l = 4;
                }
            }
            if (zBindService) {
                this.g.add(bVar);
            }
        }
    }

    final void c(Bundle bundle, g gVar) {
        short s = bundle.getShort("ERROR_CODE", (short) -1);
        if (s == -1) {
            String string = bundle.getString("API_TOKEN");
            if (string == null) {
                gVar.h();
                return;
            }
            long j = bundle.getLong("VALIDITY_DURATION");
            p.f(a, 4);
            f fVar = (f) gVar;
            fVar.h = -1L;
            long jCurrentTimeMillis = System.currentTimeMillis() + j;
            fVar.e(string, jCurrentTimeMillis, j);
            fVar.i.c(fVar.g, string, jCurrentTimeMillis);
            return;
        }
        if (s == 1) {
            e();
            gVar.h();
            return;
        }
        if (s == 2) {
            e();
            gVar.h();
            return;
        }
        if (s == 3) {
            e();
            gVar.h();
        } else if (s == 4) {
            e();
            gVar.h();
        } else if (s != 5) {
            e();
            gVar.h();
        } else {
            p.f(a, 6);
            ((f) gVar).d();
        }
    }
}
