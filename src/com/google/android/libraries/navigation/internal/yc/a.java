package com.google.android.libraries.navigation.internal.yc;

import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends c implements com.google.android.libraries.navigation.internal.yb.a {
    private final File a;

    public a(FileInputStream fileInputStream, File file) {
        super(fileInputStream);
        this.a = file;
    }

    @Override // com.google.android.libraries.navigation.internal.yb.a
    public final File a() {
        return this.a;
    }
}
