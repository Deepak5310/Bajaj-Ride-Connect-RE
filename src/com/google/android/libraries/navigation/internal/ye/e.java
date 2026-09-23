package com.google.android.libraries.navigation.internal.ye;

import android.net.Uri;
import android.os.Process;
import com.google.android.libraries.navigation.internal.ael.cy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.google.android.libraries.navigation.internal.xy.e {
    public com.google.android.libraries.navigation.internal.ya.a[] a;
    private final cy b;

    public e(cy cyVar) {
        this.b = cyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xy.e
    public final /* bridge */ /* synthetic */ Object a(com.google.android.libraries.navigation.internal.xy.d dVar) throws IOException {
        String str = ".mobstore_tmp-" + Process.myPid() + "-" + Thread.currentThread().getId() + "-" + System.currentTimeMillis() + "-" + d.a.getAndIncrement();
        Uri uri = dVar.e;
        Uri uriBuild = uri.buildUpon().path(String.valueOf(uri.getPath()).concat(str)).build();
        List listA = dVar.a(dVar.a.j(uriBuild));
        com.google.android.libraries.navigation.internal.ya.a[] aVarArr = this.a;
        if (aVarArr != null) {
            aVarArr[0].b(listA);
        }
        try {
            OutputStream outputStream = (OutputStream) listA.get(0);
            try {
                this.b.l(outputStream);
                com.google.android.libraries.navigation.internal.ya.a[] aVarArr2 = this.a;
                if (aVarArr2 != null) {
                    aVarArr2[0].a();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                dVar.a.g(uriBuild, dVar.e);
                return null;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            try {
                dVar.a.k(uriBuild);
            } catch (FileNotFoundException unused) {
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            throw new IOException(e);
        }
    }
}
