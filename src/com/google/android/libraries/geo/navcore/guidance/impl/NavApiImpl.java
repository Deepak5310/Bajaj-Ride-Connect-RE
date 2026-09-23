package com.google.android.libraries.geo.navcore.guidance.impl;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.yx.cb;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class NavApiImpl implements com.google.android.libraries.navigation.internal.rw.q, x {
    private final Executor b;
    public bj a = com.google.android.libraries.navigation.internal.aac.az.g(new IllegalStateException("NavApiImpl not initialized"));
    private final com.google.android.libraries.navigation.internal.vm.e c = new com.google.android.libraries.navigation.internal.vm.e();

    public NavApiImpl(Executor executor) {
        this.b = com.google.android.libraries.navigation.internal.hx.l.a(executor);
    }

    public static native boolean nativeInitClass();

    @Override // com.google.android.libraries.navigation.internal.rw.q
    public final void a(com.google.android.libraries.navigation.internal.rw.o oVar, Executor executor) {
        this.c.c(oVar, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.rw.q
    public final void b(com.google.android.libraries.navigation.internal.rw.o oVar) {
        this.c.b(oVar);
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.x
    public final void c(final com.google.android.libraries.navigation.internal.tj.o oVar) {
        final boolean z = oVar.a().m() <= 2;
        this.c.a(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.af
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                com.google.android.libraries.navigation.internal.rw.o oVar2 = (com.google.android.libraries.navigation.internal.rw.o) obj;
                if (oVar2 instanceof com.google.android.libraries.navigation.internal.rw.m) {
                    ((com.google.android.libraries.navigation.internal.rw.m) oVar2).a(oVar);
                }
            }
        });
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.x
    public final void d(final com.google.android.libraries.navigation.internal.tj.o oVar, final com.google.android.libraries.navigation.internal.db.r rVar) {
        this.c.a(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.ac
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                com.google.android.libraries.navigation.internal.rw.o oVar2 = (com.google.android.libraries.navigation.internal.rw.o) obj;
                if (oVar2 instanceof com.google.android.libraries.navigation.internal.rw.r) {
                    com.google.android.libraries.navigation.internal.rw.r rVar2 = (com.google.android.libraries.navigation.internal.rw.r) oVar2;
                    rVar2.j(oVar, rVar);
                }
            }
        });
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.x
    public final void e(final com.google.android.libraries.navigation.internal.tj.o oVar, final boolean z) {
        this.c.a(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.aj
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                com.google.android.libraries.navigation.internal.rw.o oVar2 = (com.google.android.libraries.navigation.internal.rw.o) obj;
                if (oVar2 instanceof com.google.android.libraries.navigation.internal.rw.x) {
                    com.google.android.libraries.navigation.internal.rw.x xVar = (com.google.android.libraries.navigation.internal.rw.x) oVar2;
                    xVar.c(oVar, z);
                }
            }
        });
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.x
    public final void f(final com.google.android.libraries.navigation.internal.tj.o oVar) {
        this.c.a(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.ah
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                com.google.android.libraries.navigation.internal.rw.o oVar2 = (com.google.android.libraries.navigation.internal.rw.o) obj;
                if (oVar2 instanceof com.google.android.libraries.navigation.internal.rw.y) {
                    ((com.google.android.libraries.navigation.internal.rw.y) oVar2).d(oVar);
                }
            }
        });
    }

    protected final void finalize() {
        final bj bjVarI = i();
        bjVarI.l(new Runnable() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.ai
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.google.android.libraries.navigation.internal.aac.az.n(bjVarI);
                } catch (ExecutionException e) {
                    throw new cb(e);
                }
            }
        }, this.b);
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.x
    public final synchronized void g(final j jVar) {
        final com.google.android.libraries.navigation.internal.yu.a aVarC = com.google.android.libraries.navigation.internal.yu.a.b(this.a).c(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.ag
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                Long l = (Long) obj;
                if (l.longValue() == 0) {
                    return null;
                }
                this.a.nativeTriggerEvent(l.longValue(), jVar.m());
                return null;
            }
        }, this.b);
        aVarC.l(new Runnable() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.ad
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.google.android.libraries.navigation.internal.aac.az.n(aVarC);
                } catch (ExecutionException e) {
                    throw new IllegalStateException("Failed to post event", e);
                }
            }
        }, this.b);
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.x
    public final void h(final com.google.android.libraries.navigation.internal.tj.o oVar, final int i, final boolean z) {
        this.c.a(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.z
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                com.google.android.libraries.navigation.internal.rw.o oVar2 = (com.google.android.libraries.navigation.internal.rw.o) obj;
                if (oVar2 instanceof com.google.android.libraries.navigation.internal.rw.aa) {
                    boolean z2 = z;
                    com.google.android.libraries.navigation.internal.rw.aa aaVar = (com.google.android.libraries.navigation.internal.rw.aa) oVar2;
                    aaVar.av(oVar, i, z2);
                }
            }
        });
    }

    public final synchronized bj i() {
        return com.google.android.libraries.navigation.internal.yu.a.b(this.a).c(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.aa
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                NavApiImpl navApiImpl = this.a;
                Long l = (Long) obj;
                synchronized (navApiImpl) {
                    navApiImpl.a = com.google.android.libraries.navigation.internal.aac.az.h(0L);
                }
                if (l.longValue() == 0) {
                    return null;
                }
                navApiImpl.nativeUnsubscribeAndFree(l.longValue());
                return null;
            }
        }, this.b);
    }

    public native long nativeAllocateAndSubscribe(long j);

    public native void nativeTriggerEvent(long j, byte[] bArr);

    public native void nativeUnsubscribeAndFree(long j);

    void receiveEvent(byte[] bArr) {
        try {
            bi biVarV = bi.v(j.a, bArr, 0, bArr.length, com.google.android.libraries.navigation.internal.ael.ar.b());
            bi.I(biVarV);
            final j jVar = (j) biVarV;
            this.c.a(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.ab
                @Override // com.google.android.libraries.navigation.internal.yx.ax
                public final void a(Object obj) {
                    int i;
                    j jVar2 = jVar;
                    com.google.android.libraries.navigation.internal.rw.o oVar = (com.google.android.libraries.navigation.internal.rw.o) obj;
                    switch (jVar2.b) {
                        case 0:
                            i = i.j;
                            break;
                        case 1:
                            i = i.a;
                            break;
                        case 2:
                            i = i.b;
                            break;
                        case 3:
                            i = i.c;
                            break;
                        case 4:
                            i = i.d;
                            break;
                        case 5:
                            i = i.e;
                            break;
                        case 6:
                            i = i.f;
                            break;
                        case 7:
                            i = i.g;
                            break;
                        case 8:
                            i = i.h;
                            break;
                        case 9:
                            i = i.i;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                    if (i == 0) {
                        throw null;
                    }
                    int i2 = 1;
                    int i3 = i - 1;
                    if (i3 == 0) {
                        if (oVar instanceof com.google.android.libraries.navigation.internal.rw.s) {
                            if ((jVar2.b == 1 ? (s) jVar2.c : s.a).c == null) {
                                al alVar = al.a;
                            }
                            ((com.google.android.libraries.navigation.internal.rw.s) oVar).a();
                            return;
                        }
                        return;
                    }
                    if (i3 == 1) {
                        if (oVar instanceof com.google.android.libraries.navigation.internal.rw.s) {
                            int iA = v.a((jVar2.b == 2 ? (w) jVar2.c : w.a).c);
                            if (iA == 0) {
                                iA = v.a;
                            }
                            if (iA == 0) {
                                throw null;
                            }
                            ((com.google.android.libraries.navigation.internal.rw.s) oVar).b();
                            return;
                        }
                        return;
                    }
                    if (i3 != 2) {
                        if (i3 == 3 && (oVar instanceof com.google.android.libraries.navigation.internal.rw.v)) {
                            int iA2 = as.a((jVar2.b == 4 ? (at) jVar2.c : at.a).c);
                            if (iA2 == 0) {
                                iA2 = as.a;
                            }
                            if (iA2 == 0) {
                                throw null;
                            }
                            ((com.google.android.libraries.navigation.internal.rw.v) oVar).a();
                            return;
                        }
                        return;
                    }
                    if (oVar instanceof com.google.android.libraries.navigation.internal.rw.w) {
                        int iA3 = ao.a((jVar2.b == 3 ? (ap) jVar2.c : ap.a).c);
                        if (iA3 == 0) {
                            iA3 = ao.a;
                        }
                        int i4 = iA3 - 1;
                        if (iA3 == 0) {
                            throw null;
                        }
                        if (i4 != 0) {
                            if (i4 == 1) {
                                i2 = 2;
                            } else if (i4 == 3) {
                                i2 = 3;
                            } else if (i4 == 4) {
                                i2 = 4;
                            }
                        }
                        ((com.google.android.libraries.navigation.internal.rw.w) oVar).b(i2);
                    }
                }
            });
        } catch (cc unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1399)).p("Invalid protobuf received from JNI");
        }
    }
}
