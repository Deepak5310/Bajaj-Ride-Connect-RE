package com.google.android.libraries.navigation.internal.yg;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final /* synthetic */ String a(String str) {
        return str;
    }

    public static final String b() {
        return "compress";
    }

    public static final InputStream c(InputStream inputStream) throws IOException {
        return new InflaterInputStream(inputStream);
    }

    public static final OutputStream d(OutputStream outputStream) throws IOException {
        return new DeflaterOutputStream(outputStream);
    }
}
