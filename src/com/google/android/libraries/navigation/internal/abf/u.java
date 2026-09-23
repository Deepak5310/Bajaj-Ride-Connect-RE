package com.google.android.libraries.navigation.internal.abf;

import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    public static final u a = new u();

    private u() {
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.android.libraries.navigation.internal.ael.cy, java.lang.Object] */
    public final cy a(dg dgVar, DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        InputStream cVar = new c(dataInputStream, Math.abs(i));
        if (i < 0) {
            cVar = new GZIPInputStream(cVar);
        }
        try {
            return dgVar.e(cVar);
        } finally {
            cVar.close();
        }
    }

    public final void b(OutputStream outputStream, cy cyVar) throws IOException {
        new DataOutputStream(outputStream).writeInt(cyVar.p());
        cyVar.l(outputStream);
    }
}
