package com.google.android.libraries.navigation.internal.abh;

import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hk implements ge {
    public static final String a = "hk";
    public final com.google.android.libraries.navigation.internal.yx.br b;
    public final com.google.android.libraries.navigation.internal.abf.z c;
    public final CopyOnWriteArrayList d;
    public boolean e;
    public boolean f;
    public String g;
    public String h;
    private final Executor i;

    public hk(com.google.android.libraries.navigation.internal.yx.br brVar) {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        com.google.android.libraries.navigation.internal.abf.z zVar = com.google.android.libraries.navigation.internal.abf.z.a;
        com.google.android.libraries.navigation.internal.abf.s.k(brVar, "drd");
        this.b = brVar;
        this.i = executorA;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "uiThreadChecker");
        this.c = zVar;
        this.d = new CopyOnWriteArrayList();
        this.e = false;
        this.f = false;
        this.g = "";
        this.h = "";
    }

    public final void a() {
        this.c.a();
        com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
        if (this.e || this.f) {
            for (hc hcVar : this.d) {
                String str = this.g;
                String str2 = this.h;
                hcVar.b.a();
                if (!hcVar.h) {
                    hcVar.h = true;
                    hcVar.i = str;
                    com.google.android.libraries.navigation.internal.abf.p.c(str);
                    hcVar.f.a(str2);
                    hcVar.E();
                    ((View) hcVar.a).setVisibility(4);
                    hcVar.c.a.setVisibility(4);
                    hcVar.f.a.setVisibility(0);
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ge
    public final void c(final boolean z, final boolean z2, final String str, final String str2) {
        com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.hj
            /* JADX WARN: Code duplicated, block: B:8:0x002f  */
            @Override // java.lang.Runnable
            public final void run() {
                String strConcat;
                hk hkVar = this.a;
                hkVar.c.a();
                com.google.android.libraries.navigation.internal.abf.p.f(hk.a, 4);
                boolean z3 = z;
                hkVar.e = z3;
                boolean z4 = z2;
                hkVar.f = z4;
                if (z3) {
                    if (z4) {
                        hkVar.g = "The Google Maps SDK for Android Street View service has been disabled for this application. This might be because of an incorrectly configured project, or an invalid API key. See the Google API console: https://console.developers.google.com, and information about Obtaining an API key: https://developers.google.com/maps/documentation/android-sdk/signup.";
                        hkVar.h = "Map disabled because Quota status is BLOCKED";
                    } else {
                        hkVar.g = "The number of requests has exceeded the usage limits for the Google Maps SDK for Android Street View service.";
                        hkVar.h = "Map disabled because Quota is EXCEEDED";
                    }
                } else if (z4) {
                    hkVar.g = "The Google Maps SDK for Android Street View service has been disabled for this application. This might be because of an incorrectly configured project, or an invalid API key. See the Google API console: https://console.developers.google.com, and information about Obtaining an API key: https://developers.google.com/maps/documentation/android-sdk/signup.";
                    hkVar.h = "Map disabled because Quota status is BLOCKED";
                } else {
                    hkVar.g = "";
                    hkVar.h = "";
                }
                String str3 = str;
                if (str3 != null) {
                    hkVar.h = str3;
                }
                String str4 = str2;
                if (str4 != null) {
                    hkVar.g = str4;
                }
                String strA = com.google.android.libraries.navigation.internal.abf.y.b.a("debug.mapview.quota", "");
                String str5 = String.format("ADB[%s]=%s => ", "debug.mapview.quota", strA);
                if ("blocked".equalsIgnoreCase(strA)) {
                    hkVar.e = false;
                    hkVar.f = true;
                    hkVar.g = String.valueOf(str5).concat("The Google Maps SDK for Android Street View service has been disabled for this application. This might be because of an incorrectly configured project, or an invalid API key. See the Google API console: https://console.developers.google.com, and information about Obtaining an API key: https://developers.google.com/maps/documentation/android-sdk/signup.");
                    hkVar.h = String.valueOf(str5).concat("Map disabled because Quota status is BLOCKED");
                } else {
                    if ("exceeded".equalsIgnoreCase(strA)) {
                        hkVar.e = true;
                        hkVar.f = false;
                        hkVar.g = String.valueOf(str5).concat("The number of requests has exceeded the usage limits for the Google Maps SDK for Android Street View service.");
                        strConcat = String.valueOf(str5).concat("Map disabled because Quota is EXCEEDED");
                    } else if ("ok".equalsIgnoreCase(strA)) {
                        hkVar.e = false;
                        hkVar.f = false;
                        hkVar.g = "";
                        strConcat = hkVar.g;
                    }
                    hkVar.h = strConcat;
                }
                if (hkVar.f) {
                    ((com.google.android.libraries.navigation.internal.abg.q) hkVar.b.a()).v();
                }
                hkVar.a();
            }
        });
    }
}
