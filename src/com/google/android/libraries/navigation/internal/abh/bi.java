package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.os.Build;
import android.os.DropBoxManager;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.maps.api.android.lib6.common.apiexception.ApiExpectedException;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi {
    public static final /* synthetic */ int b = 0;
    private static final ThreadLocal c = new ThreadLocal();
    static volatile Context a = null;

    public static void a(Throwable th) {
        b(a, th, null, bh.a);
    }

    static void b(Context context, Throwable th, com.google.android.libraries.navigation.internal.abf.ah ahVar, bh bhVar) {
        long j;
        if (context == null) {
            com.google.android.libraries.navigation.internal.abf.p.f("CrashUtils", 6);
            return;
        }
        if (com.google.android.libraries.navigation.internal.afu.a.a.a().b()) {
            ThreadLocal threadLocal = c;
            Throwable th2 = (Throwable) threadLocal.get();
            if (th == th2) {
                return;
            }
            if (th2 != null && th.getCause() == th2) {
                return;
            } else {
                threadLocal.set(th);
            }
        }
        com.google.android.libraries.navigation.internal.afu.ae.e();
        if (th instanceof ApiExpectedException) {
            com.google.android.libraries.navigation.internal.afu.s.a.a().b();
            if (!com.google.android.libraries.navigation.internal.afu.s.a.a().a()) {
                com.google.android.libraries.navigation.internal.abf.p.f("CrashUtils", 6);
                return;
            }
        }
        com.google.android.libraries.navigation.internal.nx.d.e(context.getFilesDir().getAbsolutePath());
        com.google.android.libraries.navigation.internal.nx.a.b((int) com.google.android.libraries.navigation.internal.afu.a.b());
        com.google.android.libraries.navigation.internal.nx.a.a(context);
        if (th instanceof SecurityException) {
            com.google.android.libraries.navigation.internal.abf.p.f("CrashUtils", 6);
            return;
        }
        if (th instanceof RuntimeRemoteException) {
            com.google.android.libraries.navigation.internal.abf.p.f("CrashUtils", 6);
            return;
        }
        if (ahVar != null && Looper.getMainLooper() != Looper.myLooper()) {
            com.google.android.libraries.navigation.internal.abf.p.f("CrashUtils", 6);
            return;
        }
        com.google.android.libraries.navigation.internal.abf.p.f("CrashUtils", 6);
        if (bhVar.b == null) {
            bhVar.b = (DropBoxManager) context.getApplicationContext().getSystemService("dropbox");
        }
        DropBoxManager dropBoxManager = bhVar.b;
        if (dropBoxManager == null || !dropBoxManager.isTagEnabled("system_app_crash")) {
            return;
        }
        DropBoxManager dropBoxManager2 = bhVar.b;
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.US;
        String packageName = context.getPackageName();
        try {
            Iterator it2 = com.google.android.libraries.navigation.internal.yx.bj.b(ClassUtils.PACKAGE_SEPARATOR_CHAR).g("6.1.0").iterator();
            j = 0;
            while (it2.hasNext()) {
                j = (j * 100) + ((long) Integer.parseInt((String) it2.next()));
            }
        } catch (NumberFormatException unused) {
            j = -1;
        }
        sb.append(String.format(locale, "Process: %s\nPackage: %s v%d (%s)\nBuild: %s\n\n%s", packageName, "com.google.android.libraries.navigation", Long.valueOf(j), "6.1.0", Build.FINGERPRINT, Log.getStackTraceString(th)));
        dropBoxManager2.addText("system_app_crash", sb.toString());
    }

    public static void c(Throwable th) {
        com.google.android.libraries.navigation.internal.abf.p.f("CrashUtils", 6);
        b(a, th, com.google.android.libraries.navigation.internal.abf.ah.c, bh.a);
    }
}
