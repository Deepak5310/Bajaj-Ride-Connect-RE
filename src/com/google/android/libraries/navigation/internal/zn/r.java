package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r {
    public static void a(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException("Unable to create parent directories of ".concat(file.toString()));
        }
    }

    public static byte[] b(File file) throws Throwable {
        q qVar = new q(file);
        n nVar = new n(n.a);
        try {
            FileInputStream fileInputStreamB = qVar.b();
            nVar.b(fileInputStreamB);
            long size = fileInputStreamB.getChannel().size();
            int i = k.a;
            ar.e(size >= 0, "expectedSize (%s) must be non-negative", size);
            if (size > 2147483639) {
                throw new OutOfMemoryError(size + " bytes is too large to fit in a byte array");
            }
            int i2 = (int) size;
            byte[] bArrC = new byte[i2];
            int i3 = i2;
            while (i3 > 0) {
                int i4 = i2 - i3;
                int i5 = fileInputStreamB.read(bArrC, i4, i3);
                if (i5 == -1) {
                    bArrC = Arrays.copyOf(bArrC, i4);
                    nVar.close();
                    return bArrC;
                }
                i3 -= i5;
            }
            int i6 = fileInputStreamB.read();
            if (i6 != -1) {
                ArrayDeque arrayDeque = new ArrayDeque(22);
                arrayDeque.add(bArrC);
                arrayDeque.add(new byte[]{(byte) i6});
                bArrC = k.c(fileInputStreamB, arrayDeque, i2 + 1);
            }
            nVar.close();
            return bArrC;
        } catch (Throwable th) {
            try {
                throw nVar.a(th);
            } catch (Throwable th2) {
                nVar.close();
                throw th2;
            }
        }
    }
}
