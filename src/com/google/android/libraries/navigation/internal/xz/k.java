package com.google.android.libraries.navigation.internal.xz;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.zn.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.google.android.libraries.navigation.internal.yf.a {
    public k() {
        new com.google.android.libraries.navigation.internal.yb.c();
    }

    public k(byte[] bArr) {
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final File c(Uri uri) throws IOException {
        return j.a(uri);
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final InputStream d(Uri uri) throws IOException {
        File fileA = j.a(uri);
        return new com.google.android.libraries.navigation.internal.yc.a(new FileInputStream(fileA), fileA);
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final String e() {
        return "file";
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final boolean f(Uri uri) throws IOException {
        return j.a(uri).exists();
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final void g(Uri uri, Uri uri2) throws IOException {
        File fileA = j.a(uri);
        File fileA2 = j.a(uri2);
        r.a(fileA2);
        if (!fileA.renameTo(fileA2)) {
            throw new IOException(String.format("%s could not be renamed to %s", uri, uri2));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final OutputStream j(Uri uri) throws IOException {
        File fileA = j.a(uri);
        r.a(fileA);
        return new com.google.android.libraries.navigation.internal.yc.b(new FileOutputStream(fileA), fileA);
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final void k(Uri uri) throws IOException {
        File fileA = j.a(uri);
        if (fileA.isDirectory()) {
            throw new FileNotFoundException(String.format("%s is a directory", uri));
        }
        if (fileA.delete()) {
            return;
        }
        if (!fileA.exists()) {
            throw new FileNotFoundException(String.format("%s does not exist", uri));
        }
        throw new IOException(String.format("%s could not be deleted", uri));
    }
}
