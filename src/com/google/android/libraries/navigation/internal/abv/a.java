package com.google.android.libraries.navigation.internal.abv;

import java.io.ByteArrayInputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final String a = "a";
    public static final a b = new a();

    private a() {
    }

    public static b a(byte[] bArr) {
        return new b(new InflaterInputStream(new ByteArrayInputStream(bArr)));
    }
}
