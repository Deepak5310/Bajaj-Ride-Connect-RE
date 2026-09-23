package com.google.android.libraries.navigation.environment;

import android.content.Context;
import android.os.Build;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.libraries.navigation.internal.afl.fv;
import com.google.maps.api.android.lib6.common.apiexception.ApiExpectedException;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static b a;
    private static final ThreadLocal b = new ThreadLocal();
    private final com.google.android.libraries.navigation.internal.hn.r c;
    private final Context d;
    private final com.google.android.libraries.navigation.internal.afo.a e;
    private File f = null;
    private File g = null;

    public b(Context context, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.d = context;
        this.e = aVar;
        this.c = rVar;
    }

    public static void c(Throwable th) {
        b bVar = a;
        if (bVar != null) {
            if (((fv) bVar.c.b()).e) {
                ThreadLocal threadLocal = b;
                if (th == ((Throwable) threadLocal.get())) {
                    return;
                } else {
                    threadLocal.set(th);
                }
            }
            if (th instanceof ApiExpectedException) {
                bVar.d(th);
                com.google.android.libraries.navigation.internal.nx.d.d(bVar.b(), "_google_maps_sdk_developer_exception_");
            } else {
                bVar.d(th);
                try {
                    ((com.google.android.libraries.navigation.internal.jy.af) bVar.e.a()).o(th);
                } catch (Throwable unused) {
                }
                com.google.android.libraries.navigation.internal.nx.a.a(bVar.d);
                com.google.android.libraries.navigation.internal.nx.d.e(bVar.a());
            }
        }
    }

    private final void d(Throwable th) {
        DropBoxManager dropBoxManager = (DropBoxManager) this.d.getSystemService("dropbox");
        if (dropBoxManager == null || !dropBoxManager.isTagEnabled("system_app_crash")) {
            return;
        }
        StringBuilder sb = new StringBuilder(1024);
        long j = 0;
        for (String str : "6.1.0".split("\\.")) {
            j = (j * 100) + ((long) Integer.parseInt(str));
        }
        String strValueOf = String.valueOf(j);
        sb.append("Process: ");
        sb.append(this.d.getPackageName());
        sb.append("\nPackage: com.google.android.libraries.navigation v");
        sb.append(strValueOf);
        sb.append(" (6.1.0)\nBuild: ");
        sb.append(Build.FINGERPRINT);
        sb.append("\n\n");
        sb.append(Log.getStackTraceString(th));
        dropBoxManager.addText("system_app_crash", sb.toString());
    }

    public final String a() {
        String absolutePath;
        synchronized (this) {
            if (this.f == null) {
                File file = new File(this.d.getFilesDir(), "nav_crash_breadcrumb");
                this.f = file;
                file.mkdir();
            }
            absolutePath = this.f.getAbsolutePath();
        }
        return absolutePath;
    }

    public final String b() {
        String absolutePath;
        synchronized (this) {
            if (this.g == null) {
                File file = new File(this.d.getFilesDir(), "nav_expected_exception_breadcrumb");
                this.g = file;
                file.mkdir();
            }
            absolutePath = this.g.getAbsolutePath();
        }
        return absolutePath;
    }
}
