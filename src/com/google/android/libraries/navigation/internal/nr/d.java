package com.google.android.libraries.navigation.internal.nr;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aag.j;
import com.google.android.libraries.navigation.internal.lc.ah;
import com.google.android.libraries.navigation.internal.lc.ai;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import org.chromium.net.CronetProvider;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.impl.JavaCronetProvider;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements j {
    private final Context a;
    private final Context b;
    private final boolean c;
    private final com.google.android.libraries.navigation.internal.im.a d;

    public d(Context context, Context context2, an anVar, an anVar2) {
        this.a = context;
        this.b = context2;
        this.d = (com.google.android.libraries.navigation.internal.im.a) anVar.f();
        this.c = ((Boolean) anVar2.e(false)).booleanValue();
    }

    private final ExperimentalCronetEngine.Builder b() {
        JavaCronetProvider javaCronetProvider = new JavaCronetProvider(this.b);
        boolean z = false;
        if (javaCronetProvider.getName().equals(CronetProvider.PROVIDER_NAME_FALLBACK) && javaCronetProvider.isEnabled()) {
            z = true;
        }
        ar.l(z, "Fallback CronetEngine provider not found");
        return (ExperimentalCronetEngine.Builder) javaCronetProvider.createBuilder();
    }

    private final void c(int i) {
        com.google.android.libraries.navigation.internal.im.a aVar = this.d;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aag.j
    public final ExperimentalCronetEngine.Builder a() {
        if (this.c) {
            return b();
        }
        for (CronetProvider cronetProvider : CronetProvider.getAllProviders(this.b)) {
            try {
                if (cronetProvider.isEnabled()) {
                    return (ExperimentalCronetEngine.Builder) cronetProvider.createBuilder();
                }
                continue;
            } catch (LinkageError | RuntimeException e) {
                Throwable cause = e.getCause();
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 799)).p("Exception trying to create ExperimentalCronetEngine.Builder");
                if (e instanceof UnsatisfiedLinkError) {
                    c(1);
                } else if (e instanceof VerifyError) {
                    c(3);
                } else if (e instanceof LinkageError) {
                    c(4);
                } else if (cause instanceof ah) {
                    c(7);
                } else {
                    if (cause instanceof ai) {
                        com.google.android.libraries.navigation.internal.lc.h hVar = com.google.android.libraries.navigation.internal.lc.h.a;
                        throw null;
                    }
                    c(2);
                }
            }
        }
        return b();
    }
}
