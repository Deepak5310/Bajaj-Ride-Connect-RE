package com.google.android.libraries.navigation.internal.gn;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.at;
import com.google.android.libraries.navigation.internal.afl.bd;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.fw.ab;
import com.google.android.libraries.navigation.internal.yx.am;
import j$.time.Duration;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g {
    public final com.google.android.libraries.navigation.internal.gg.k a;
    final /* synthetic */ i b;
    private final dg c;

    public g(i iVar, com.google.android.libraries.navigation.internal.gg.k kVar, dg dgVar) {
        this.b = iVar;
        this.a = kVar;
        this.c = dgVar;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00f3 A[Catch: all -> 0x01d3, TryCatch #1 {all -> 0x01d3, blocks: (B:3:0x000a, B:5:0x000e, B:9:0x0030, B:12:0x0064, B:15:0x006b, B:20:0x009e, B:22:0x00a3, B:24:0x00ac, B:26:0x00c3, B:46:0x00e7, B:53:0x00fb, B:55:0x0107, B:56:0x0116, B:57:0x011f, B:47:0x00ea, B:48:0x00ed, B:49:0x00f0, B:50:0x00f3, B:51:0x00f6, B:52:0x00f9, B:58:0x0120, B:60:0x013a, B:62:0x0149, B:63:0x0155, B:67:0x0178, B:68:0x017f, B:69:0x0180, B:70:0x018d, B:71:0x018e, B:72:0x0195, B:81:0x01b6, B:80:0x01b3, B:82:0x01b7, B:83:0x01be, B:90:0x01ca, B:89:0x01c7, B:6:0x0027, B:8:0x002b, B:91:0x01cb, B:92:0x01d2, B:77:0x01ae, B:86:0x01c2, B:16:0x0071, B:18:0x007d, B:73:0x0196, B:74:0x01aa, B:10:0x0040), top: B:105:0x000a, outer: #2, inners: #0, #3, #5, #6 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f6 A[Catch: all -> 0x01d3, TryCatch #1 {all -> 0x01d3, blocks: (B:3:0x000a, B:5:0x000e, B:9:0x0030, B:12:0x0064, B:15:0x006b, B:20:0x009e, B:22:0x00a3, B:24:0x00ac, B:26:0x00c3, B:46:0x00e7, B:53:0x00fb, B:55:0x0107, B:56:0x0116, B:57:0x011f, B:47:0x00ea, B:48:0x00ed, B:49:0x00f0, B:50:0x00f3, B:51:0x00f6, B:52:0x00f9, B:58:0x0120, B:60:0x013a, B:62:0x0149, B:63:0x0155, B:67:0x0178, B:68:0x017f, B:69:0x0180, B:70:0x018d, B:71:0x018e, B:72:0x0195, B:81:0x01b6, B:80:0x01b3, B:82:0x01b7, B:83:0x01be, B:90:0x01ca, B:89:0x01c7, B:6:0x0027, B:8:0x002b, B:91:0x01cb, B:92:0x01d2, B:77:0x01ae, B:86:0x01c2, B:16:0x0071, B:18:0x007d, B:73:0x0196, B:74:0x01aa, B:10:0x0040), top: B:105:0x000a, outer: #2, inners: #0, #3, #5, #6 }] */
    final cy a(h hVar) throws IOException, com.google.android.libraries.navigation.internal.gg.p {
        ByteBuffer byteBufferAllocate;
        com.google.android.libraries.navigation.internal.gg.o oVar;
        try {
            com.google.android.libraries.navigation.internal.nw.d dVarC = com.google.android.libraries.navigation.internal.nw.e.c("GmmServerResponseReader readResponseBody ", this.b.i);
            try {
                ByteArrayOutputStream byteArrayOutputStream = hVar.b;
                if (byteArrayOutputStream != null) {
                    byteBufferAllocate = ByteBuffer.allocate(byteArrayOutputStream.size());
                    byteBufferAllocate.put(ByteBuffer.wrap(hVar.b.toByteArray()));
                    byteBufferAllocate.flip();
                } else {
                    ByteBuffer byteBuffer = hVar.a;
                    if (byteBuffer == null) {
                        throw new NullPointerException("Neither the ByteBuffer nor the ByteArrayOutputStreamis non-null!");
                    }
                    byteBuffer.flip();
                    byteBufferAllocate = hVar.a;
                }
                int iPosition = byteBufferAllocate.position();
                com.google.android.libraries.navigation.internal.fw.n nVar = this.b.e;
                int i = ab.a;
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("RequestUtil.readResponseHeader");
                try {
                    nVar.c(byteBufferAllocate.position());
                    int iA = ab.a(byteBufferAllocate);
                    long jPosition = ((long) byteBufferAllocate.position()) - nVar.d;
                    nVar.f = jPosition;
                    nVar.a.a += jPosition;
                    nVar.c.a();
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    if (iA != 24) {
                        throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.f);
                    }
                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("AsyncGmmServerProtocolRpc.readClientPropertiesResponse");
                    try {
                        if (bd.b(ab.a(byteBufferAllocate)) != bd.CLIENT_PROPERTIES_2_REQUEST) {
                            this.b.e.b(byteBufferAllocate.position() - iPosition);
                            throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.g);
                        }
                        at atVarF = ((com.google.android.libraries.navigation.internal.il.a) this.b.d.a()).f(byteBufferAllocate, this.b.j);
                        this.b.e.b(byteBufferAllocate.position() - iPosition);
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                        if (atVarF == null) {
                            throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.g);
                        }
                        if (atVarF.g.size() != 2) {
                            throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.c.d("Wrong number of status in ClientProperties"));
                        }
                        this.a.x = Duration.ofMillis(atVarF.h);
                        int i2 = ((com.google.android.libraries.navigation.internal.aej.b) atVarF.g.get(1)).c;
                        if (i2 == 0) {
                            this.b.e.c(byteBufferAllocate.position());
                            bd bdVarB = bd.b(ab.a(byteBufferAllocate));
                            i iVar = this.b;
                            if (bdVarB != iVar.i) {
                                throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.g);
                            }
                            iVar.g.g();
                            cy cyVarB = ab.b(byteBufferAllocate, this.c);
                            if (cyVarB instanceof mf) {
                            }
                            this.b.e.b(byteBufferAllocate.position());
                            this.a.d(Duration.ofMillis(this.b.f.a()));
                            if (dVarC != null) {
                                Trace.endSection();
                            }
                            return cyVarB;
                        }
                        if (i2 == 1) {
                            oVar = com.google.android.libraries.navigation.internal.gg.o.d;
                        } else if (i2 == 7) {
                            oVar = com.google.android.libraries.navigation.internal.gg.o.f438n;
                        } else if (i2 == 9 || i2 == 11) {
                            oVar = com.google.android.libraries.navigation.internal.gg.o.h;
                        } else if (i2 == 16) {
                            oVar = com.google.android.libraries.navigation.internal.gg.o.f438n;
                        } else if (i2 == 3) {
                            oVar = com.google.android.libraries.navigation.internal.gg.o.h;
                        } else if (i2 == 4) {
                            oVar = com.google.android.libraries.navigation.internal.gg.o.j;
                        } else if (i2 != 5) {
                            oVar = (i2 == 13 || i2 == 14) ? com.google.android.libraries.navigation.internal.gg.o.j : com.google.android.libraries.navigation.internal.gg.o.a;
                        } else {
                            oVar = com.google.android.libraries.navigation.internal.gg.o.m;
                        }
                        Integer num = oVar.s;
                        Integer numValueOf = Integer.valueOf(i2);
                        if (!am.a(num, numValueOf)) {
                            oVar = new com.google.android.libraries.navigation.internal.gg.o(oVar.p, oVar.q, oVar.r, numValueOf, oVar.t);
                        }
                        throw new com.google.android.libraries.navigation.internal.gg.p(oVar.d("Found individual request error status in ClientProperties."));
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
            } catch (Throwable th5) {
                if (dVarC != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (BufferUnderflowException e) {
            throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.c.c(e));
        }
        throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.c.c(e));
    }
}
