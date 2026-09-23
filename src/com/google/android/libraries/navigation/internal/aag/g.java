package com.google.android.libraries.navigation.internal.aag;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.libraries.navigation.internal.afr.p;
import com.google.android.libraries.navigation.internal.yr.aw;
import com.google.android.libraries.navigation.internal.yr.ax;
import com.google.android.libraries.navigation.internal.yr.w;
import com.google.android.libraries.navigation.internal.yx.an;
import java.io.File;
import java.util.Set;
import org.chromium.net.ExperimentalCronetEngine;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.agl.a i;

    public g(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) this.a.a();
        Object obj = ((com.google.android.libraries.navigation.internal.afr.g) this.c).a;
        Set setA = ((p) this.b).a();
        Set set = (Set) obj;
        an anVar = (an) this.d.a();
        an anVar2 = (an) ((com.google.android.libraries.navigation.internal.afr.g) this.e).a;
        an anVar3 = (an) ((com.google.android.libraries.navigation.internal.afr.g) this.i).a;
        w wVarB = aw.b("CronetConfigurationModule#provideCronetEngine", ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        com.google.android.libraries.navigation.internal.agl.a aVar = this.g;
        com.google.android.libraries.navigation.internal.agl.a aVar2 = this.f;
        com.google.android.libraries.navigation.internal.agl.a aVar3 = this.h;
        try {
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                try {
                    ExperimentalCronetEngine.Builder builderA = d.a(context, setA, set, anVar, anVar2, aVar2);
                    StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
                    if (anVar.g()) {
                        i iVar = (i) anVar.c();
                        if (iVar.g()) {
                            File file = new File(context.getCacheDir(), iVar.f());
                            file.mkdirs();
                            if (file.isDirectory()) {
                                builderA.setStoragePath(file.getAbsolutePath());
                                builderA.enableHttpCache(2, iVar.a());
                            }
                        } else if (iVar.f() != null && ((Boolean) anVar3.e(false)).booleanValue()) {
                            File file2 = new File(context.getCacheDir(), iVar.f());
                            file2.mkdirs();
                            if (file2.isDirectory()) {
                                builderA.setStoragePath(file2.getAbsolutePath());
                            }
                        }
                        d.d(anVar, builderA);
                    }
                    d.b(anVar, builderA);
                    ExperimentalCronetEngine experimentalCronetEngineBuild = builderA.build();
                    d.c(anVar, experimentalCronetEngineBuild, aVar, aVar3);
                    StrictMode.setThreadPolicy(threadPolicy);
                    wVarB.close();
                    com.google.android.libraries.navigation.internal.afr.j.d(experimentalCronetEngineBuild);
                    return experimentalCronetEngineBuild;
                } catch (IllegalStateException e) {
                    if (anVar.g()) {
                    }
                    throw e;
                }
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicy);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                wVarB.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
