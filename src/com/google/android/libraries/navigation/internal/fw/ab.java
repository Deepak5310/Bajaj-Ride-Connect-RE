package com.google.android.libraries.navigation.internal.fw;

import android.content.Context;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.bd;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    public static final /* synthetic */ int a = 0;
    private static final ar b = ar.b();

    public static int a(ByteBuffer byteBuffer) {
        return (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00d9  */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.google.android.libraries.navigation.internal.ael.cy, java.lang.Object] */
    public static cy b(ByteBuffer byteBuffer, dg dgVar) throws IOException {
        byte[] bArr;
        byte[] bArrB;
        int i;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("RequestUtil.readResponse");
        try {
            ar arVar = b;
            int i2 = byteBuffer.getInt();
            if (i2 < 0) {
                int iAbs = Math.abs(i2);
                byte[] bArr2 = new byte[iAbs];
                byteBuffer.get(bArr2);
                int i3 = iAbs < 4 ? 0 : ((bArr2[iAbs - 1] & 255) << 24) + ((bArr2[iAbs - 2] & 255) << 16) + ((bArr2[iAbs - 3] & 255) << 8) + (bArr2[iAbs - 4] & 255);
                try {
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr2, 0, iAbs), Math.min(Math.max(i3, iAbs) + 10, 8192));
                    try {
                        if (i3 <= 10000000) {
                            bArrB = new byte[i3];
                            int i4 = 0;
                            while (i4 < i3 && (i = gZIPInputStream.read(bArrB, i4, i3 - i4)) != -1) {
                                i4 += i;
                            }
                            if (i4 < i3) {
                                bArrB = Arrays.copyOf(bArrB, i4);
                            } else {
                                int i5 = gZIPInputStream.read();
                                if (i5 != -1) {
                                    boolean z = true;
                                    byte[][] bArr3 = {bArrB, new byte[]{(byte) i5}, com.google.android.libraries.navigation.internal.zn.k.b(gZIPInputStream)};
                                    long length = 0;
                                    for (int i6 = 0; i6 < 3; i6++) {
                                        length += (long) bArr3[i6].length;
                                    }
                                    int i7 = (int) length;
                                    if (length != i7) {
                                        z = false;
                                    }
                                    com.google.android.libraries.navigation.internal.yx.ar.e(z, "the total number of elements (%s) in the arrays must fit in an int", length);
                                    bArr = new byte[i7];
                                    int i8 = 0;
                                    for (int i9 = 0; i9 < 3; i9++) {
                                        byte[] bArr4 = bArr3[i9];
                                        int length2 = bArr4.length;
                                        System.arraycopy(bArr4, 0, bArr, i8, length2);
                                        i8 += length2;
                                    }
                                    gZIPInputStream.close();
                                }
                            }
                        } else {
                            bArrB = com.google.android.libraries.navigation.internal.zn.k.b(gZIPInputStream);
                        }
                        gZIPInputStream.close();
                        ?? I = dgVar.i(bArrB, arVar);
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                        return I;
                    } catch (Throwable th) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            bArr = new byte[i2];
            byteBuffer.get(bArr);
            bArrB = bArr;
            ?? I2 = dgVar.i(bArrB, arVar);
            if (dVarB != null) {
                Trace.endSection();
            }
            return I2;
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

    public static String c(Context context, com.google.android.libraries.navigation.internal.jb.c cVar) {
        String strB = com.google.android.libraries.navigation.internal.jd.a.b(cVar);
        return context.getPackageName() + ',' + com.google.android.libraries.navigation.internal.jd.a.a(context) + ',' + cVar.a().toString() + ',' + strB + ',' + com.google.android.libraries.navigation.internal.jb.b.b();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004b A[Catch: all -> 0x0062, TryCatch #1 {all -> 0x0062, blocks: (B:3:0x0011, B:5:0x001f, B:7:0x002c, B:9:0x0035, B:18:0x0051, B:16:0x004a, B:15:0x0047, B:17:0x004b, B:6:0x0029, B:12:0x0042), top: B:32:0x0011, inners: #0, #2 }] */
    public static void d(cy cyVar, final bd bdVar, DataOutputStream dataOutputStream, n nVar) throws IOException {
        nVar.c(dataOutputStream.size());
        com.google.android.libraries.navigation.internal.nw.d dVarA = com.google.android.libraries.navigation.internal.nw.e.a(new com.google.android.libraries.navigation.internal.nw.c() { // from class: com.google.android.libraries.navigation.internal.fw.aa
            @Override // com.google.android.libraries.navigation.internal.nw.c
            public final com.google.android.libraries.navigation.internal.xn.a a() {
                int i = ab.a;
                return com.google.android.libraries.navigation.internal.xn.a.f("writeRequest ", bdVar);
            }
        });
        try {
            dataOutputStream.writeShort(bdVar.jm);
            byte[] bArrM = cyVar.m();
            int length = bArrM.length;
            if (length > 250) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArrM);
                    gZIPOutputStream.close();
                    if (byteArrayOutputStream.size() < length) {
                        dataOutputStream.writeInt(-byteArrayOutputStream.size());
                        byteArrayOutputStream.writeTo(dataOutputStream);
                    } else {
                        dataOutputStream.writeInt(length);
                        dataOutputStream.write(bArrM);
                    }
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                dataOutputStream.writeInt(length);
                dataOutputStream.write(bArrM);
            }
            h hVar = h.MESSAGELITE_COMPRESSED;
            if (dVarA != null) {
                Trace.endSection();
            }
            nVar.a(dataOutputStream.size(), hVar.f);
        } catch (Throwable th3) {
            if (dVarA != null) {
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
