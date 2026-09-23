package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.ed;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cr {
    public final co a;
    public final bb b;
    public final bg c;
    public final Context d;
    public final com.google.android.libraries.navigation.internal.yz.az e = ed.g();

    public cr(Context context, co coVar, bb bbVar, bg bgVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(context);
        this.d = context;
        com.google.android.libraries.navigation.internal.yx.ar.q(coVar);
        this.a = coVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(bbVar);
        this.b = bbVar;
        this.c = bgVar;
    }

    /* JADX WARN: Code duplicated, block: B:105:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    final ck a(bt btVar, ViewGroup viewGroup, boolean z, boolean z2, com.google.android.libraries.navigation.internal.mx.j jVar) throws Throwable {
        Throwable th;
        AutoCloseable autoCloseableB;
        com.google.android.libraries.navigation.internal.mx.g gVarA;
        com.google.android.libraries.navigation.internal.mx.g gVar;
        cd cdVarD = ce.d();
        try {
            cd cdVarA = ce.a("VHF.create ", btVar.getClass());
            try {
                try {
                    bb bbVar = this.b;
                    if (btVar instanceof com.google.android.libraries.navigation.internal.yt.e) {
                        autoCloseableB = com.google.android.libraries.navigation.internal.yt.d.b("CurvularInflater.inflate ", ((com.google.android.libraries.navigation.internal.yt.e) btVar).b());
                    } else {
                        Class<?> cls = btVar.getClass();
                        if (com.google.android.libraries.navigation.internal.yr.aw.d(com.google.android.libraries.navigation.internal.yr.ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS)) {
                            autoCloseableB = com.google.android.libraries.navigation.internal.yt.d.e("CurvularInflater.inflate ".concat(String.valueOf(cls.getName())));
                        } else {
                            autoCloseableB = Trace.isEnabled() ? com.google.android.libraries.navigation.internal.yt.f.b("CurvularInflater.inflate ".concat(String.valueOf(cls.getSimpleName()))) : com.google.android.libraries.navigation.internal.yt.d.a;
                        }
                    }
                    AutoCloseable autoCloseable = autoCloseableB;
                    try {
                        cd cdVarA2 = ce.a("layout.create ", btVar.getClass());
                        try {
                            bg bgVar = bbVar.a;
                            synchronized (bgVar.c) {
                                gVarA = bgVar.b.a(btVar);
                            }
                            if (gVarA == null) {
                                gVarA = btVar.a();
                            }
                            synchronized (bgVar.c) {
                                com.google.android.libraries.navigation.internal.mx.g gVarA2 = bgVar.b.a(btVar);
                                if (gVarA2 == null) {
                                    bgVar.b.a.put(btVar, gVarA);
                                    gVar = gVarA;
                                } else {
                                    gVar = gVarA2;
                                }
                            }
                            if (cdVarA2 != null) {
                                Trace.endSection();
                            }
                            ck ckVarA = bbVar.a(btVar, gVar, viewGroup, z, null, null, z2, jVar);
                            autoCloseable.close();
                            if (cdVarA != null) {
                                Trace.endSection();
                            }
                            if (cdVarD != null) {
                                Trace.endSection();
                            }
                            return ckVarA;
                        } catch (Throwable th2) {
                            if (cdVarA2 == null) {
                                throw th2;
                            }
                            try {
                                Trace.endSection();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                            th = th;
                            th = th;
                            if (cdVarD != null) {
                                throw th;
                            }
                            try {
                                Trace.endSection();
                                throw th;
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            autoCloseable.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    if (cdVarA == null) {
                        throw th7;
                    }
                    try {
                        Trace.endSection();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                th = th;
                if (cdVarD != null) {
                    throw th;
                }
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    @Deprecated
    public final void b(View view) {
        this.c.a(view);
    }

    public final cq c(bt btVar, ViewGroup viewGroup) {
        return d(btVar, viewGroup, true);
    }

    public final cq d(bt btVar, ViewGroup viewGroup, boolean z) {
        cq cqVarE = e(btVar, viewGroup, z);
        cd cdVarD = ce.d();
        if (cqVarE != null) {
            if (cdVarD != null) {
                Trace.endSection();
            }
            return cqVarE;
        }
        try {
            ck ckVarA = a(btVar, viewGroup, z, true, null);
            cq cqVar = new cq(ckVarA);
            ckVarA.f(cqVar);
            if (cdVarD != null) {
                Trace.endSection();
            }
            return cqVar;
        } catch (Throwable th) {
            if (cdVarD != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final cq e(bt btVar, ViewGroup viewGroup, boolean z) {
        cq cqVar;
        bg bgVar = this.c;
        synchronized (bgVar.c) {
            List listC = bgVar.a.c(btVar);
            cqVar = listC.isEmpty() ? null : (cq) listC.remove(listC.size() - 1);
        }
        if (cqVar != null) {
            this.a.c(viewGroup, cqVar.a(), z);
        }
        return cqVar;
    }
}
