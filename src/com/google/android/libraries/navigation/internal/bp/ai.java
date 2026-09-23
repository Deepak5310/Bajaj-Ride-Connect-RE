package com.google.android.libraries.navigation.internal.bp;

import android.content.Context;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.ael.dr;
import com.google.android.libraries.navigation.internal.ael.ee;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.no;
import j$.time.Instant;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai implements Serializable {
    public static final fy a = fy.u(com.google.android.libraries.navigation.internal.ady.al.DRIVE, com.google.android.libraries.navigation.internal.ady.al.BICYCLE, com.google.android.libraries.navigation.internal.ady.al.WALK, com.google.android.libraries.navigation.internal.ady.al.TRANSIT, com.google.android.libraries.navigation.internal.ady.al.TAXI, com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER, new com.google.android.libraries.navigation.internal.ady.al[0]);
    private static final long serialVersionUID = 451564227077576556L;
    public transient af b;
    public final fd c;
    public final com.google.android.libraries.navigation.internal.ady.al d;
    public final ev e;
    public final ev f;
    public final com.google.android.libraries.navigation.internal.hc.a g;
    public final com.google.android.libraries.navigation.internal.hc.a h;
    public final Instant i;
    public final com.google.android.libraries.navigation.internal.hc.a j;
    public final Instant k;
    public final int l;
    public final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private transient ev f351n;

    public ai(ah ahVar) {
        af afVar = ahVar.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(afVar);
        this.b = afVar;
        this.c = fd.j(ahVar.b);
        com.google.android.libraries.navigation.internal.ady.al alVar = ahVar.c;
        com.google.android.libraries.navigation.internal.yx.ar.q(alVar);
        this.d = alVar;
        ev evVar = ahVar.d;
        com.google.android.libraries.navigation.internal.yx.ar.q(evVar);
        this.e = ev.o(evVar);
        ev evVar2 = ahVar.e;
        this.f = evVar2 != null ? ev.o(evVar2) : lv.a;
        com.google.android.libraries.navigation.internal.hc.a aVar = ahVar.f;
        this.g = aVar == null ? new com.google.android.libraries.navigation.internal.hc.a(lr.a) : aVar;
        com.google.android.libraries.navigation.internal.hc.a aVar2 = ahVar.g;
        this.h = aVar2 == null ? new com.google.android.libraries.navigation.internal.hc.a(com.google.android.libraries.navigation.internal.afl.bz.a) : aVar2;
        this.i = ahVar.h;
        this.j = ahVar.i;
        this.k = ahVar.j;
        this.l = ahVar.k;
        this.m = ahVar.l;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        com.google.android.libraries.navigation.internal.ael.bi biVar;
        objectInputStream.defaultReadObject();
        mf mfVar = mf.a;
        com.google.android.libraries.navigation.internal.ael.ar arVar = com.google.android.libraries.navigation.internal.ael.ar.a;
        di diVar = di.a;
        com.google.android.libraries.navigation.internal.ael.ar arVar2 = com.google.android.libraries.navigation.internal.ael.ar.a;
        try {
            int i = objectInputStream.read();
            if (i == -1) {
                biVar = null;
            } else {
                int i2 = com.google.android.libraries.navigation.internal.ael.ac.g;
                if ((i & 128) != 0) {
                    i &= 127;
                    int i3 = 7;
                    while (true) {
                        if (i3 < 32) {
                            int i4 = objectInputStream.read();
                            if (i4 == -1) {
                                throw new com.google.android.libraries.navigation.internal.ael.cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                            }
                            i |= (i4 & 127) << i3;
                            if ((i4 & 128) == 0) {
                                break;
                            } else {
                                i3 += 7;
                            }
                        } else {
                            while (true) {
                                if (i3 >= 64) {
                                    throw new com.google.android.libraries.navigation.internal.ael.cc("CodedInputStream encountered a malformed varint.");
                                }
                                int i5 = objectInputStream.read();
                                if (i5 == -1) {
                                    throw new com.google.android.libraries.navigation.internal.ael.cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                }
                                if ((i5 & 128) == 0) {
                                    break;
                                } else {
                                    i3 += 7;
                                }
                            }
                        }
                    }
                }
                com.google.android.libraries.navigation.internal.ael.ac acVarJ = com.google.android.libraries.navigation.internal.ael.ac.J(new com.google.android.libraries.navigation.internal.ael.a(objectInputStream, i));
                com.google.android.libraries.navigation.internal.ael.bi biVarU = mfVar.u();
                try {
                    dr drVarB = di.a.b(biVarU);
                    drVarB.h(biVarU, com.google.android.libraries.navigation.internal.ael.ad.p(acVarJ), arVar2);
                    drVarB.f(biVarU);
                    acVarJ.z(0);
                    biVar = biVarU;
                } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
                    if (!e.a) {
                        throw e;
                    }
                    throw new com.google.android.libraries.navigation.internal.ael.cc(e);
                } catch (ee e2) {
                    throw e2.a();
                } catch (IOException e3) {
                    if (!(e3.getCause() instanceof com.google.android.libraries.navigation.internal.ael.cc)) {
                        throw new com.google.android.libraries.navigation.internal.ael.cc(e3);
                    }
                    throw ((com.google.android.libraries.navigation.internal.ael.cc) e3.getCause());
                } catch (RuntimeException e4) {
                    if (!(e4.getCause() instanceof com.google.android.libraries.navigation.internal.ael.cc)) {
                        throw e4;
                    }
                    throw ((com.google.android.libraries.navigation.internal.ael.cc) e4.getCause());
                }
            }
            com.google.android.libraries.navigation.internal.ael.bi.I(biVar);
            this.b = new af((mf) biVar);
        } catch (com.google.android.libraries.navigation.internal.ael.cc e5) {
            if (!e5.a) {
                throw e5;
            }
            throw new com.google.android.libraries.navigation.internal.ael.cc(e5);
        } catch (IOException e6) {
            throw new com.google.android.libraries.navigation.internal.ael.cc(e6);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        mf mfVar = this.b.a;
        int iP = mfVar.p();
        com.google.android.libraries.navigation.internal.ael.ah ahVar = new com.google.android.libraries.navigation.internal.ael.ah(objectOutputStream, com.google.android.libraries.navigation.internal.ael.ai.N(com.google.android.libraries.navigation.internal.ael.ai.W(iP) + iP));
        ahVar.w(iP);
        mfVar.aJ(ahVar);
        ahVar.aw();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final bg a(int i, Context context) {
        no it2 = ((ev) d(context)).iterator();
        while (it2.hasNext()) {
            bg bgVar = (bg) it2.next();
            if (bgVar.f == i) {
                return bgVar;
            }
        }
        return null;
    }

    public final com.google.android.libraries.navigation.internal.afl.bz b() {
        return (com.google.android.libraries.navigation.internal.afl.bz) this.h.d((dg) com.google.android.libraries.navigation.internal.afl.bz.a.aH(7, null), com.google.android.libraries.navigation.internal.afl.bz.a);
    }

    public final lr c() {
        return (lr) this.g.d((dg) lr.a.aH(7, null), lr.a);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005e A[Catch: all -> 0x00a0, PHI: r15
      0x005e: PHI (r15v2 com.google.android.libraries.navigation.internal.bp.bg) = 
      (r15v1 com.google.android.libraries.navigation.internal.bp.bg)
      (r15v0 com.google.android.libraries.navigation.internal.bp.bg)
     binds: [B:30:0x007d, B:26:0x005c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00a0, blocks: (B:4:0x0003, B:6:0x0007, B:12:0x001e, B:16:0x002b, B:33:0x0082, B:19:0x0034, B:21:0x003a, B:23:0x003f, B:27:0x005e, B:43:0x0095, B:42:0x0092, B:44:0x0096, B:45:0x009c, B:38:0x008c, B:24:0x0045, B:29:0x0062), top: B:53:0x0003, inners: #0, #2 }] */
    public final synchronized List d(Context context) {
        try {
            if (this.f351n == null) {
                int iC = this.b.c();
                int i = ev.d;
                eq eqVar = new eq();
                int i2 = 0;
                while (i2 < iC) {
                    boolean z = true;
                    com.google.android.libraries.navigation.internal.yx.ar.a(i2 >= 0);
                    if (i2 >= this.b.c()) {
                        z = false;
                    }
                    com.google.android.libraries.navigation.internal.yx.ar.a(z);
                    bg bgVar = null;
                    if (this.b != null) {
                        Instant instant = this.m ? this.i : bg.b;
                        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsStorageItem.createRouteDescription()");
                        try {
                            bd bdVarAd = bg.ad(this.b, this.i, instant, i2, context, 0, this.e, this.f, false, c());
                            if (bdVarAd != null) {
                                bdVarAd.b = (String) this.c.getOrDefault(Integer.valueOf(i2), UUID.randomUUID().toString());
                                bgVar = new bg(bdVarAd);
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            } else if (dVarB != null) {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            if (dVarB == null) {
                                throw th;
                            }
                            try {
                                Trace.endSection();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    }
                    if (bgVar != null) {
                        eqVar.h(bgVar);
                    }
                    i2++;
                }
                this.f351n = eqVar.g();
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return this.f351n;
    }
}
