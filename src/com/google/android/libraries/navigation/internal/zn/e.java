package com.google.android.libraries.navigation.internal.zn;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends OutputStream {
    int a = 0;
    int b = 0;
    int c = 0;
    final /* synthetic */ Writer d;
    final /* synthetic */ f e;

    public e(f fVar, Writer writer) {
        this.d = writer;
        this.e = fVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.b;
        if (i > 0) {
            int i2 = this.a;
            a aVar = this.e.b;
            this.d.write(aVar.a((i2 << (aVar.c - i)) & aVar.b));
            this.c++;
            if (this.e.c != null) {
                while (true) {
                    int i3 = this.c;
                    f fVar = this.e;
                    if (i3 % fVar.b.d == 0) {
                        break;
                    }
                    Writer writer = this.d;
                    fVar.c.charValue();
                    writer.write(61);
                    this.c++;
                }
            }
        }
        this.d.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.d.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.a = (i & 255) | (this.a << 8);
        int i2 = this.b + 8;
        while (true) {
            this.b = i2;
            int i3 = this.b;
            a aVar = this.e.b;
            int i4 = aVar.c;
            if (i3 < i4) {
                return;
            }
            this.d.write(aVar.a((this.a >> (i3 - i4)) & aVar.b));
            this.c++;
            i2 = this.b - this.e.b.c;
        }
    }
}
