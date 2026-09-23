package com.google.android.libraries.navigation.internal.rq;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    private static final byte[] a = {0};

    public static byte[] a(byte[] bArr, int i) throws IOException {
        Deflater deflater = new Deflater();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr, 0, i);
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } finally {
            deflater.end();
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, i);
        try {
            try {
                byte[] bArr2 = new byte[i2];
                inflater.inflate(bArr2);
                inflater.end();
                return bArr2;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static void c(byte[] bArr, int i, e eVar) throws DataFormatException {
        Inflater inflater = new Inflater(true);
        try {
            inflater.setInput(bArr, 0, i);
            eVar.d(i * 4);
            int iInflate = inflater.inflate(eVar.e(), 0, eVar.a());
            boolean z = false;
            while (!inflater.finished()) {
                int iA = eVar.a();
                eVar.d(iA + iA);
                int iInflate2 = inflater.inflate(eVar.e(), iInflate, eVar.a() - iInflate);
                if (iInflate2 == 0) {
                    if (!inflater.needsInput() || z) {
                        break;
                    }
                    inflater.setInput(a);
                    z = true;
                    iInflate2 = 0;
                }
                iInflate += iInflate2;
            }
            eVar.d(iInflate);
        } finally {
            inflater.end();
        }
    }
}
