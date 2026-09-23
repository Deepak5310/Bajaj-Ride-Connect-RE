package com.google.android.libraries.navigation.environment;

import android.app.Application;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class NavApiEnvironmentManager {
    public static boolean a = true;
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.environment.NavApiEnvironmentManager");

    private NavApiEnvironmentManager() {
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.libraries.navigation.environment.am, com.google.android.libraries.navigation.internal.ru.c] */
    public static am getOrCreate(Application application) {
        if (!com.google.android.libraries.navigation.internal.ru.e.b()) {
            ay ayVar = new ay(application);
            synchronized (com.google.android.libraries.navigation.internal.ru.e.a) {
                com.google.android.libraries.navigation.internal.yx.ar.l(com.google.android.libraries.navigation.internal.ru.e.b == null, "Environment has already been configured.");
                com.google.android.libraries.navigation.internal.ru.e.b = ayVar;
            }
        }
        return com.google.android.libraries.navigation.internal.ru.e.a();
    }
}
