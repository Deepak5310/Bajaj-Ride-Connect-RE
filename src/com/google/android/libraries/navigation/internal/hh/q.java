package com.google.android.libraries.navigation.internal.hh;

import android.content.Context;
import androidx.core.util.AtomicFile;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class q {
    public final String a;
    public final AtomicInteger b = new AtomicInteger();
    private final Context c;
    private final n d;
    private File e;
    private File f;
    private File g;
    private final dg h;

    public q(dg dgVar, Context context, n nVar, String str) {
        this.c = context;
        this.d = nVar;
        this.a = str;
        this.h = dgVar;
    }

    public static File b(Context context, n nVar) {
        return nVar == n.CACHE_FILE ? context.getCacheDir() : context.getFilesDir();
    }

    private static long d(byte[] bArr) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ProtoFileHelper.bytesToChecksum");
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.put(bArr, 0, 8);
            byteBufferAllocate.flip();
            long j = byteBufferAllocate.getLong();
            if (dVarB != null) {
                Trace.endSection();
            }
            return j;
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

    private final File e() {
        if (this.g == null) {
            ar.q(this.c);
            ar.q(this.d);
            this.g = new File(b(this.c, this.d), String.valueOf(this.a).concat(".adler32"));
        }
        return this.g;
    }

    private final File f() {
        if (this.f == null) {
            ar.q(this.c);
            ar.q(this.d);
            Context context = this.c;
            n nVar = this.d;
            this.f = new File(b(context, nVar), this.a);
        }
        return this.f;
    }

    private final File g() {
        if (this.e == null) {
            ar.q(this.c);
            ar.q(this.d);
            this.e = new File(b(this.c, this.d), String.valueOf(this.a).concat(".cs"));
        }
        return this.e;
    }

    private final synchronized boolean h(cy cyVar, int i) throws IOException {
        FileOutputStream fileOutputStream;
        if (i != this.b.get()) {
            return false;
        }
        AtomicFile atomicFile = null;
        FileOutputStream fileOutputStreamStartWrite = null;
        try {
            byte[] bArrM = cyVar.m();
            Adler32 adler32 = new Adler32();
            adler32.update(bArrM, 0, bArrM.length);
            AtomicFile atomicFile2 = new AtomicFile(g());
            try {
                fileOutputStreamStartWrite = atomicFile2.startWrite();
                long value = adler32.getValue();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                byteBufferAllocate.putLong(0, value);
                byteBufferAllocate.flip();
                fileOutputStreamStartWrite.write(byteBufferAllocate.array());
                fileOutputStreamStartWrite.write(bArrM);
                atomicFile2.finishWrite(fileOutputStreamStartWrite);
                j(f());
                j(e());
                return true;
            } catch (IOException | SecurityException e) {
                e = e;
                fileOutputStream = fileOutputStreamStartWrite;
                atomicFile = atomicFile2;
                if (atomicFile != null && fileOutputStream != null) {
                    atomicFile.failWrite(fileOutputStream);
                }
                throw e;
            }
        } catch (IOException | SecurityException e2) {
            e = e2;
            fileOutputStream = null;
        }
    }

    private static byte[] i(File file) throws IOException {
        return new AtomicFile(file).readFully();
    }

    private static void j(File file) {
        if (file.exists()) {
            new AtomicFile(file).delete();
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0075 A[Catch: all -> 0x017e, PHI: r2
      0x0075: PHI (r2v28 com.google.android.libraries.navigation.internal.hh.p) = 
      (r2v6 com.google.android.libraries.navigation.internal.hh.p)
      (r2v11 com.google.android.libraries.navigation.internal.hh.p)
      (r2v33 com.google.android.libraries.navigation.internal.hh.p)
     binds: [B:84:0x011d, B:75:0x0104, B:30:0x0073] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #11 {all -> 0x017e, blocks: (B:4:0x0007, B:31:0x0075, B:86:0x0121, B:88:0x0127, B:89:0x012e, B:90:0x013f, B:93:0x0155, B:104:0x017d, B:103:0x017a, B:5:0x000d, B:7:0x001e, B:13:0x0035, B:22:0x0064, B:38:0x0084, B:37:0x0081, B:39:0x0085, B:41:0x008f, B:51:0x00b5, B:60:0x00e4, B:82:0x0112, B:81:0x010f, B:83:0x0113, B:34:0x007c, B:8:0x0028, B:9:0x002c, B:11:0x002f, B:15:0x0039, B:17:0x004f, B:20:0x0059, B:27:0x006c, B:78:0x010a, B:42:0x009d, B:43:0x00a1, B:46:0x00a8, B:47:0x00ac, B:49:0x00af, B:53:0x00b9, B:55:0x00cf, B:58:0x00d9, B:63:0x00ea, B:66:0x00f1, B:72:0x00fd, B:100:0x0175), top: B:134:0x0007, outer: #3, inners: #7, #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0127 A[Catch: all -> 0x017e, TryCatch #11 {all -> 0x017e, blocks: (B:4:0x0007, B:31:0x0075, B:86:0x0121, B:88:0x0127, B:89:0x012e, B:90:0x013f, B:93:0x0155, B:104:0x017d, B:103:0x017a, B:5:0x000d, B:7:0x001e, B:13:0x0035, B:22:0x0064, B:38:0x0084, B:37:0x0081, B:39:0x0085, B:41:0x008f, B:51:0x00b5, B:60:0x00e4, B:82:0x0112, B:81:0x010f, B:83:0x0113, B:34:0x007c, B:8:0x0028, B:9:0x002c, B:11:0x002f, B:15:0x0039, B:17:0x004f, B:20:0x0059, B:27:0x006c, B:78:0x010a, B:42:0x009d, B:43:0x00a1, B:46:0x00a8, B:47:0x00ac, B:49:0x00af, B:53:0x00b9, B:55:0x00cf, B:58:0x00d9, B:63:0x00ea, B:66:0x00f1, B:72:0x00fd, B:100:0x0175), top: B:134:0x0007, outer: #3, inners: #7, #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x012e A[Catch: all -> 0x017e, TRY_LEAVE, TryCatch #11 {all -> 0x017e, blocks: (B:4:0x0007, B:31:0x0075, B:86:0x0121, B:88:0x0127, B:89:0x012e, B:90:0x013f, B:93:0x0155, B:104:0x017d, B:103:0x017a, B:5:0x000d, B:7:0x001e, B:13:0x0035, B:22:0x0064, B:38:0x0084, B:37:0x0081, B:39:0x0085, B:41:0x008f, B:51:0x00b5, B:60:0x00e4, B:82:0x0112, B:81:0x010f, B:83:0x0113, B:34:0x007c, B:8:0x0028, B:9:0x002c, B:11:0x002f, B:15:0x0039, B:17:0x004f, B:20:0x0059, B:27:0x006c, B:78:0x010a, B:42:0x009d, B:43:0x00a1, B:46:0x00a8, B:47:0x00ac, B:49:0x00af, B:53:0x00b9, B:55:0x00cf, B:58:0x00d9, B:63:0x00ea, B:66:0x00f1, B:72:0x00fd, B:100:0x0175), top: B:134:0x0007, outer: #3, inners: #7, #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x016d A[Catch: all -> 0x018a, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:95:0x016d, B:111:0x0189, B:110:0x0186, B:107:0x0181, B:4:0x0007, B:31:0x0075, B:86:0x0121, B:88:0x0127, B:89:0x012e, B:90:0x013f, B:93:0x0155, B:104:0x017d, B:103:0x017a), top: B:121:0x0001, inners: #1, #11 }] */
    public final synchronized p a() {
        p pVarB;
        ByteBuffer byteBuffer;
        p pVarB2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ProtoFileHelper.loadSavedProtoFromFileInternal");
        try {
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("ProtoFileHelper.readBytesFromFile");
            try {
                if (g().exists()) {
                    File fileG = g();
                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("ProtoFileHelper.readBytesFromFileV2");
                    try {
                        try {
                            byte[] bArrI = i(fileG);
                            int length = bArrI.length;
                            if (length < 8) {
                                pVarB = p.b(4, null);
                                if (dVarB3 != null) {
                                    Trace.endSection();
                                }
                            } else {
                                long jD = d(bArrI);
                                Adler32 adler32 = new Adler32();
                                int i = length - 8;
                                adler32.update(bArrI, 8, i);
                                if (adler32.getValue() != jD) {
                                    adler32.getValue();
                                    pVarB = p.b(4, null);
                                    if (dVarB3 != null) {
                                        Trace.endSection();
                                    }
                                } else {
                                    p pVar = new p(ByteBuffer.wrap(bArrI, 8, i), true, 1);
                                    if (dVarB3 != null) {
                                        Trace.endSection();
                                    }
                                    pVarB = pVar;
                                }
                            }
                        } catch (Throwable th) {
                            if (dVarB3 != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e) {
                        pVarB = p.b(9, e);
                        if (dVarB3 != null) {
                        }
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                        byteBuffer = (ByteBuffer) pVarB.a;
                        if (byteBuffer == null) {
                            pVarB2 = p.b(pVarB.c, null);
                        } else {
                            try {
                                pVarB2 = new p(this.h.j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), com.google.android.libraries.navigation.internal.ael.ar.b()), pVarB.b, pVarB.c);
                            } catch (cc e2) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(646)).s("readProtoLiteFromFile failed: %s", this.a);
                                pVarB2 = p.b(6, e2);
                            }
                        }
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                        return pVarB2;
                    }
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    byteBuffer = (ByteBuffer) pVarB.a;
                    if (byteBuffer == null) {
                        pVarB2 = p.b(pVarB.c, null);
                    } else {
                        pVarB2 = new p(this.h.j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), com.google.android.libraries.navigation.internal.ael.ar.b()), pVarB.b, pVarB.c);
                    }
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                } else if (f().exists()) {
                    File fileF = f();
                    File fileE = e();
                    com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("ProtoFileHelper.readBytesFromFileV1");
                    try {
                        try {
                            byte[] bArrI2 = i(fileF);
                            if (fileE.exists()) {
                                try {
                                    byte[] bArrI3 = i(fileE);
                                    if (bArrI3.length != 8) {
                                        pVarB = p.b(5, null);
                                        if (dVarB4 != null) {
                                            Trace.endSection();
                                        }
                                    } else {
                                        long jD2 = d(bArrI3);
                                        Adler32 adler33 = new Adler32();
                                        adler33.update(bArrI2, 0, bArrI2.length);
                                        if (adler33.getValue() != jD2) {
                                            adler33.getValue();
                                            pVarB = p.b(4, null);
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                        } else {
                                            p pVar2 = new p(ByteBuffer.wrap(bArrI2), true, 8);
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                            pVarB = pVar2;
                                        }
                                    }
                                } catch (IOException e3) {
                                    pVarB = p.b(5, e3);
                                    if (dVarB4 != null) {
                                    }
                                    if (dVarB2 != null) {
                                        Trace.endSection();
                                    }
                                    byteBuffer = (ByteBuffer) pVarB.a;
                                    if (byteBuffer == null) {
                                        pVarB2 = p.b(pVarB.c, null);
                                    } else {
                                        pVarB2 = new p(this.h.j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), com.google.android.libraries.navigation.internal.ael.ar.b()), pVarB.b, pVarB.c);
                                    }
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                    return pVarB2;
                                }
                                if (dVarB2 != null) {
                                    Trace.endSection();
                                }
                                byteBuffer = (ByteBuffer) pVarB.a;
                                if (byteBuffer == null) {
                                    pVarB2 = p.b(pVarB.c, null);
                                } else {
                                    pVarB2 = new p(this.h.j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), com.google.android.libraries.navigation.internal.ael.ar.b()), pVarB.b, pVarB.c);
                                }
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            } else {
                                pVarB = p.b(10, null);
                                if (dVarB4 != null) {
                                    Trace.endSection();
                                }
                                if (dVarB2 != null) {
                                    Trace.endSection();
                                }
                                byteBuffer = (ByteBuffer) pVarB.a;
                                if (byteBuffer == null) {
                                    pVarB2 = p.b(pVarB.c, null);
                                } else {
                                    pVarB2 = new p(this.h.j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), com.google.android.libraries.navigation.internal.ael.ar.b()), pVarB.b, pVarB.c);
                                }
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            }
                        } catch (Throwable th3) {
                            if (dVarB4 != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (IOException e4) {
                        pVarB = p.b(9, e4);
                        if (dVarB4 != null) {
                        }
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                        byteBuffer = (ByteBuffer) pVarB.a;
                        if (byteBuffer == null) {
                            pVarB2 = p.b(pVarB.c, null);
                        } else {
                            pVarB2 = new p(this.h.j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), com.google.android.libraries.navigation.internal.ael.ar.b()), pVarB.b, pVarB.c);
                        }
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                        return pVarB2;
                    }
                } else {
                    pVarB = p.b(7, new FileNotFoundException());
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    byteBuffer = (ByteBuffer) pVarB.a;
                    if (byteBuffer == null) {
                        pVarB2 = p.b(pVarB.c, null);
                    } else {
                        pVarB2 = new p(this.h.j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), com.google.android.libraries.navigation.internal.ael.ar.b()), pVarB.b, pVarB.c);
                    }
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                }
            } catch (Throwable th5) {
                if (dVarB2 != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (Throwable th7) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                }
            }
            throw th7;
        }
        throw th;
        return pVarB2;
    }

    public final synchronized boolean c(cy cyVar, int i) {
        if (i != this.b.get()) {
            return false;
        }
        try {
            return h(cyVar, i);
        } catch (IOException | SecurityException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 651)).p("writeProtoLiteToFile failed to write proto:");
            return false;
        }
    }
}
