package com.google.android.libraries.navigation.internal.xy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends com.google.android.libraries.navigation.internal.yc.d {
    public static final /* synthetic */ int a = 0;
    private final List b;

    public b(OutputStream outputStream, List list) {
        super(outputStream);
        this.b = list;
        com.google.android.libraries.navigation.internal.yc.f.a(true, "Output was null", new Object[0]);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            try {
                ((com.google.android.libraries.navigation.internal.yf.d) it2.next()).close();
            } catch (Throwable unused) {
            }
        }
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        this.out.write(i);
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.yf.d) it2.next()).a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yc.d, java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        for (com.google.android.libraries.navigation.internal.yf.d dVar : this.b) {
            int length = bArr.length;
            dVar.a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yc.d, java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.yf.d) it2.next()).a();
        }
    }
}
