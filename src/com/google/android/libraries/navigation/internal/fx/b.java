package com.google.android.libraries.navigation.internal.fx;

import android.content.ServiceConnection;
import android.os.Bundle;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.lx.b a;
    final /* synthetic */ ServiceConnection b;
    final /* synthetic */ c c;
    final /* synthetic */ f d;

    public b(c cVar, com.google.android.libraries.navigation.internal.lx.b bVar, f fVar, ServiceConnection serviceConnection) {
        this.a = bVar;
        this.d = fVar;
        this.b = serviceConnection;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.c.a;
        ServiceConnection serviceConnection = this.b;
        f fVar = this.d;
        com.google.android.libraries.navigation.internal.lx.b bVar = this.a;
        try {
            try {
                Bundle bundle = new Bundle(3);
                bundle.putString("PACKAGE_NAME", eVar.b);
                bundle.putString("API_KEY", eVar.a);
                bundle.putBoolean("M4B", false);
                bundle.putInt("CLIENT_TYPE", 5);
                Bundle bundleE = bVar.e(bundle);
                short s = bundleE.getShort("ERROR_CODE", (short) -1);
                if (s == -1) {
                    String string = bundleE.getString("API_TOKEN");
                    if (string != null) {
                        fVar.c(string, bundleE.getLong("VALIDITY_DURATION"));
                    } else {
                        fVar.a((short) 7);
                    }
                } else if (s == 1 || s == 2 || s == 3 || s == 4 || s != 5) {
                    eVar.a();
                    fVar.a(s);
                } else {
                    fVar.b();
                }
            } catch (Exception unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(546)).p("Exception when sending the token request.");
                fVar.b();
            }
        } finally {
            eVar.b(serviceConnection);
        }
    }
}
