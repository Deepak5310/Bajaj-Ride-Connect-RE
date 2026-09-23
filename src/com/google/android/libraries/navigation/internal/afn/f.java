package com.google.android.libraries.navigation.internal.afn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private InputStream a;
    private ByteArrayOutputStream b;

    public f(InputStream inputStream) {
        this.a = inputStream;
        try {
            this.b = new ByteArrayOutputStream();
            byte[] bArr = new byte[256];
            while (true) {
                int i = this.a.read(bArr);
                if (i == -1) {
                    this.b.flush();
                    return;
                }
                this.b.write(bArr, 0, i);
            }
        } catch (IOException e) {
            System.out.println("IOException in CopyInputStream");
            System.out.println(e.toString());
        }
    }

    public final ByteArrayInputStream a() {
        return new ByteArrayInputStream(this.b.toByteArray());
    }
}
