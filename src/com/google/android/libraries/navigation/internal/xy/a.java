package com.google.android.libraries.navigation.internal.xy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.yc.c {
    private final List a;

    public a(InputStream inputStream, List list) {
        super(inputStream);
        this.a = list;
        com.google.android.libraries.navigation.internal.yc.f.a(true, "Input was null", new Object[0]);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            try {
                ((com.google.android.libraries.navigation.internal.yf.c) it2.next()).close();
            } catch (Throwable unused) {
            }
        }
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = this.in.read();
        if (i != -1) {
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.yf.c) it2.next()).a();
            }
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.yc.c, java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i = this.in.read(bArr);
        if (i != -1) {
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.yf.c) it2.next()).a();
            }
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.in.read(bArr, i, i2);
        if (i3 != -1) {
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.yf.c) it2.next()).a();
            }
        }
        return i3;
    }
}
