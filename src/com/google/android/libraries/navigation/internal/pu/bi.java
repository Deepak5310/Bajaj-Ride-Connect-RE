package com.google.android.libraries.navigation.internal.pu;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public bi(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        final Context context = (Context) this.a.a();
        br brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.pu.bb
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                float f;
                Context context2 = context;
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MapSingletonsModule.shouldEnableCopyrights");
                try {
                    float f2 = context2.getResources().getDisplayMetrics().densityDpi;
                    DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                    if (Math.abs(displayMetrics.xdpi - f2) / f2 > 0.25d || Math.abs(displayMetrics.ydpi - f2) / f2 > 0.25d) {
                        f = f2;
                    } else {
                        f2 = displayMetrics.xdpi;
                        f = displayMetrics.ydpi;
                    }
                    float f3 = displayMetrics.widthPixels / f2;
                    float f4 = displayMetrics.heightPixels / f;
                    boolean z = (f3 * f3) + (f4 * f4) >= 49.0f;
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    return Boolean.valueOf(z);
                } catch (Throwable th) {
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        });
        com.google.android.libraries.navigation.internal.afr.j.d(brVarA);
        return brVarA;
    }
}
