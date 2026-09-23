package com.google.android.libraries.navigation.internal.oa;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.km.v;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.pb.p;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.zp.n;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c implements com.google.android.libraries.navigation.internal.ob.f {
    private static final com.google.android.libraries.navigation.internal.zb.j j = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.oa.c");
    public final br a;
    public final com.google.android.libraries.navigation.internal.ob.i b;
    public final com.google.android.libraries.navigation.internal.kl.b c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public Boolean e;
    public final com.google.android.libraries.navigation.internal.fu.a f;
    public final af g;
    public final Executor i;
    private final com.google.android.libraries.navigation.internal.agl.a k;
    public float h = -1.0f;
    private final com.google.android.libraries.navigation.internal.afo.a l = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.oa.b
        @Override // com.google.android.libraries.navigation.internal.yx.br
        public final Object a() {
            int iC;
            r rVar;
            final c cVar = this.a;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("CameraPositionManagerImpl.getInitialCameraPositionImpl");
            try {
                com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
                com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
                com.google.android.libraries.navigation.internal.ob.i iVar = cVar.b;
                if (iVar != null) {
                    iC = iVar.c(aVar);
                } else {
                    cVar.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.oa.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            c cVar2 = cVar;
                            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("CameraPositionManagerImpl.logUe3DefaultCameraPosition");
                            try {
                                af afVar = cVar2.g;
                                com.google.android.libraries.navigation.internal.kd.d dVar2 = new com.google.android.libraries.navigation.internal.kd.d();
                                dVar2.b(n.B);
                                afVar.n(dVar2.a());
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
                    });
                    aVar.b(p.a(cVar.f.b()));
                    iC = 1;
                }
                cVar.e = Boolean.valueOf(iC != 3);
                if (iC == 1) {
                    cVar.h = 15.0f;
                } else {
                    cVar.h = aVar.c;
                }
                if (cVar.c != null) {
                    v vVar = v.AUTO_PAN_MODE_ENABLED;
                }
                com.google.android.libraries.navigation.internal.ob.i iVar2 = cVar.b;
                if (iVar2 != null) {
                    iVar2.a();
                }
                if (Boolean.TRUE.equals(cVar.e) && (rVar = (r) cVar.a.a()) != null) {
                    ((com.google.android.libraries.navigation.internal.qd.k) cVar.d.a()).j();
                    aVar.e(x.z(rVar));
                    aVar.c = cVar.b(cVar.h);
                }
                ((com.google.android.libraries.navigation.internal.qd.k) cVar.d.a()).l();
                com.google.android.libraries.navigation.internal.pd.d dVarA = aVar.a();
                if (dVarB != null) {
                    Trace.endSection();
                }
                return dVarA;
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

    public c(br brVar, com.google.android.libraries.navigation.internal.ob.i iVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.fu.a aVar3, af afVar, Executor executor) {
        this.a = brVar;
        this.b = iVar;
        this.c = bVar;
        this.d = aVar;
        this.k = aVar2;
        this.f = aVar3;
        this.g = afVar;
        this.i = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.f
    public final float a() {
        this.l.a();
        return b(this.h);
    }

    public final float b(float f) {
        float f2 = ((qj) this.k.a()).j;
        if (f2 >= 0.0f) {
            f = f2;
        }
        return Math.min(21.0f, Math.max(2.0f, f));
    }

    @Override // com.google.android.libraries.navigation.internal.ob.f
    public final com.google.android.libraries.navigation.internal.pd.d c() {
        return (com.google.android.libraries.navigation.internal.pd.d) this.l.a();
    }

    @Override // com.google.android.libraries.navigation.internal.ob.f
    public final void d(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.f
    public final boolean e() {
        Boolean bool = this.e;
        if (bool != null) {
            return bool.booleanValue();
        }
        ((com.google.android.libraries.navigation.internal.zb.h) j.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 805)).p("Attempted to access lastTrackingLocationState before value is initialized from storage");
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.f
    public final void f(com.google.android.libraries.navigation.internal.pd.a aVar, r rVar) {
        aVar.e(x.z(rVar));
        aVar.c = a();
    }
}
