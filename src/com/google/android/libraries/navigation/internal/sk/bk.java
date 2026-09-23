package com.google.android.libraries.navigation.internal.sk;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bk extends com.google.android.libraries.navigation.internal.zn.i {
    final /* synthetic */ ZipFile a;
    final /* synthetic */ ZipEntry b;

    public bk(ZipFile zipFile, ZipEntry zipEntry) {
        this.a = zipFile;
        this.b = zipEntry;
    }

    @Override // com.google.android.libraries.navigation.internal.zn.i
    public final InputStream a() throws IOException {
        InputStream inputStream = this.a.getInputStream(this.b);
        if (inputStream != null) {
            return inputStream;
        }
        throw new IOException("Error creating input stream from bundle");
    }
}
