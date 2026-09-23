package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Bitmap;
import android.view.View;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.abh.id;
import com.google.android.libraries.navigation.internal.po.fk;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eb extends com.google.android.libraries.navigation.internal.abh.a {
    private final com.google.android.libraries.navigation.internal.oa.k c;

    public eb(View view, View view2, View view3, Executor executor, id idVar, com.google.android.libraries.navigation.internal.oa.k kVar) {
        super(view, view2, executor, idVar);
        this.c = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.a
    protected final void d(Bitmap bitmap, com.google.android.libraries.navigation.internal.ly.ch chVar) {
        com.google.android.libraries.geo.mapcore.renderer.ca caVar = ((fk) this.c.b()).j.j;
        ea eaVar = new ea(this, bitmap, chVar);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GlSnapshotter.getSnapshotAsync");
        try {
            synchronized (caVar) {
                if (caVar.c) {
                    eaVar.a(null);
                } else {
                    caVar.a.add(eaVar);
                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("GlSnapshotter.getSnapshotAsync.requestRedraw");
                    try {
                        caVar.b.run();
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                    } catch (Throwable th) {
                        if (dVarB2 != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th3) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }
}
