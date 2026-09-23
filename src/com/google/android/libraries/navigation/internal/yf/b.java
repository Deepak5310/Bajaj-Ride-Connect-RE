package com.google.android.libraries.navigation.internal.yf;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements a {
    protected Uri a(Uri uri) throws IOException {
        throw null;
    }

    protected abstract a b();

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public /* synthetic */ File c(Uri uri) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public InputStream d(Uri uri) throws IOException {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public boolean f(Uri uri) throws IOException {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final void g(Uri uri, Uri uri2) throws IOException {
        b().g(a(uri), a(uri2));
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final OutputStream j(Uri uri) throws IOException {
        return b().j(a(uri));
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final void k(Uri uri) throws IOException {
        b().k(a(uri));
    }
}
