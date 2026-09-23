package com.google.android.libraries.navigation.internal.xt;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.StrictMode;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs {
    public static final com.google.android.libraries.navigation.internal.xo.aj a = new com.google.android.libraries.navigation.internal.xo.aj();
    public final com.google.android.libraries.navigation.internal.xo.y b;
    public final Uri c;
    public final String d;
    private final String e = "";

    public bs(com.google.android.libraries.navigation.internal.xo.y yVar, String str, String str2) {
        this.b = yVar;
        this.d = str;
        Context context = yVar.d;
        Pattern pattern = com.google.android.libraries.navigation.internal.xz.g.a;
        com.google.android.libraries.navigation.internal.xz.f fVar = new com.google.android.libraries.navigation.internal.xz.f(context);
        fVar.b("phenotype");
        fVar.c(RemoteSettings.FORWARD_SLASH_STRING + str + ".pb");
        this.c = fVar.a();
    }

    public static /* synthetic */ void c(bs bsVar, bu buVar) {
        com.google.android.libraries.navigation.internal.ya.a aVar = new com.google.android.libraries.navigation.internal.ya.a();
        try {
            com.google.android.libraries.navigation.internal.xy.f fVarC = bsVar.b.c();
            Uri uri = bsVar.c;
            com.google.android.libraries.navigation.internal.ye.e eVar = new com.google.android.libraries.navigation.internal.ye.e(buVar);
            eVar.a = new com.google.android.libraries.navigation.internal.ya.a[]{aVar};
        } catch (IOException | RuntimeException e) {
            com.google.android.libraries.navigation.internal.xo.aj.b(Level.WARNING, bsVar.b.d(), e, "Failed to update snapshot for %s flags may be stale.", bsVar.d);
        }
    }

    public final bp a() {
        int i;
        bl blVarB = this.b.f.b();
        String staticPackageName = this.d;
        com.google.android.libraries.navigation.internal.aae.b androidBacking = com.google.android.libraries.navigation.internal.aae.b.PROCESS_STABLE;
        int iIndexOf = staticPackageName.indexOf("#");
        if (iIndexOf >= 0) {
            staticPackageName = staticPackageName.substring(0, iIndexOf);
        } else if (staticPackageName.contains("@")) {
            throw new IllegalArgumentException("Invalid package name: ".concat(String.valueOf(staticPackageName)));
        }
        Intrinsics.checkNotNullParameter(androidBacking, "androidBacking");
        Intrinsics.checkNotNullParameter(staticPackageName, "staticPackageName");
        if (!blVarB.f) {
            i = com.google.android.libraries.navigation.internal.xp.c.m;
        } else if (!blVarB.a(androidBacking)) {
            i = com.google.android.libraries.navigation.internal.xp.c.b;
        } else if (blVarB.a.A()) {
            i = com.google.android.libraries.navigation.internal.xp.c.c;
        } else if (blVarB.d.isEmpty() || blVarB.d.contains(staticPackageName)) {
            i = blVarB.e.contains(staticPackageName) ? com.google.android.libraries.navigation.internal.xp.c.e : 0;
        } else {
            i = com.google.android.libraries.navigation.internal.xp.c.d;
        }
        if (i != 0) {
            return new f(null, new bq(i));
        }
        try {
            String str = blVarB.c;
            if (str.isEmpty()) {
                com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) this.b.g.a();
                if (!anVar.g()) {
                    a.a(Level.WARNING, this.b.d(), "Unable to get GMS application info, using defaults.", new Object[0]);
                    return new f(com.google.android.libraries.navigation.internal.xs.k.a, new bq(com.google.android.libraries.navigation.internal.xp.d.b, com.google.android.libraries.navigation.internal.xp.c.f));
                }
                str = ((ApplicationInfo) anVar.c()).dataDir;
            }
            String str2 = str + File.separator + blVarB.b;
            com.google.android.libraries.navigation.internal.xs.j jVar = new com.google.android.libraries.navigation.internal.xs.j(blVarB.a, this.d, this.e);
            Uri uriBuild = new Uri.Builder().scheme("file").appendEncodedPath(File.separator + str2 + File.separator + new File(((String) jVar.b.a()) + RemoteSettings.FORWARD_SLASH_STRING + ((String) jVar.c.a()) + ".pb").toString()).build();
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
            try {
                try {
                    try {
                        return new f((com.google.android.libraries.navigation.internal.xs.k) this.b.c().b(uriBuild, new bo()), new bq(com.google.android.libraries.navigation.internal.xp.d.d, com.google.android.libraries.navigation.internal.xp.c.a));
                    } finally {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
                    com.google.android.libraries.navigation.internal.xo.aj.b(Level.SEVERE, this.b.d(), e, "Failed to parse snapshot from shared storage for %s", this.d);
                    f fVar = new f(null, new bq(com.google.android.libraries.navigation.internal.xp.c.h));
                    StrictMode.setThreadPolicy(threadPolicy);
                    return fVar;
                }
            } catch (FileNotFoundException unused) {
                a.a(Level.INFO, this.b.d(), "Shared storage file not found for %s", this.d);
                f fVar2 = new f(null, new bq(com.google.android.libraries.navigation.internal.xp.c.g));
                StrictMode.setThreadPolicy(threadPolicy);
                return fVar2;
            }
        } catch (Exception e2) {
            com.google.android.libraries.navigation.internal.xo.aj.b(Level.WARNING, this.b.d(), e2, "Failed to read shared file for %s", this.d);
            return new f(com.google.android.libraries.navigation.internal.xs.k.a, new bq(com.google.android.libraries.navigation.internal.xp.d.b, com.google.android.libraries.navigation.internal.xp.c.i));
        }
    }

    final boolean b() {
        return this.b.f.b().a(com.google.android.libraries.navigation.internal.aae.b.PROCESS_STABLE);
    }
}
