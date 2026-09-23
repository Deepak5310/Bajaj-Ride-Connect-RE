package com.google.android.libraries.navigation.internal.yf;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface a {
    File c(Uri uri) throws IOException;

    InputStream d(Uri uri) throws IOException;

    String e();

    boolean f(Uri uri) throws IOException;

    void g(Uri uri, Uri uri2) throws IOException;

    OutputStream j(Uri uri) throws IOException;

    void k(Uri uri) throws IOException;
}
