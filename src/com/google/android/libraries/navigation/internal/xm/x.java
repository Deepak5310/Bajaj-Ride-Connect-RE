package com.google.android.libraries.navigation.internal.xm;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.gm.an;
import com.google.android.libraries.navigation.internal.ho.bd;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements com.google.android.libraries.navigation.internal.gn.m {
    private final CronetEngine a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final Executor c;
    private final m d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final br f;

    public x(CronetEngine cronetEngine, com.google.android.libraries.navigation.internal.mj.a aVar, Executor executor, m mVar, com.google.android.libraries.navigation.internal.agl.a aVar2, Context context) {
        br brVarA;
        this.a = cronetEngine;
        this.b = aVar;
        this.c = executor;
        this.d = mVar;
        this.e = aVar2;
        try {
            final Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xm.u
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return bundle.getString("com.google.android.libraries.navigation.service.usage_server_url_override");
                }
            });
        } catch (PackageManager.NameNotFoundException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2021)).p("Couldn't find NavSDK usage server override key from manifest.");
            brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xm.v
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return "";
                }
            });
        } catch (NullPointerException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2022)).p("Couldn't load metadata config values.");
            brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xm.v
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return "";
                }
            });
        }
        this.f = brVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.gn.m
    public final com.google.android.libraries.navigation.internal.gn.l a(cy cyVar, an anVar, com.google.android.libraries.navigation.internal.gh.d dVar) {
        String str = (String) this.f.a();
        w wVar = w.PROD;
        if (!wVar.e.equals(str)) {
            wVar = w.STAGING;
            if (!wVar.e.equals(str)) {
                wVar = w.AUTOPUSH;
                if (!wVar.e.equals(str)) {
                    wVar = w.EMPTY;
                }
            }
        }
        String str2 = wVar.f;
        if (str2.isEmpty()) {
            str2 = ((bd) this.e).a().c;
        }
        if (str2.isEmpty()) {
            str2 = w.PROD.f;
        }
        return new t(cyVar, str2, this.a, anVar, this.d, this.b, this.c);
    }
}
