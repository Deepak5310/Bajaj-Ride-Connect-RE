package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends i {
    private final File a;

    public q(File file) {
        ar.q(file);
        this.a = file;
    }

    @Override // com.google.android.libraries.navigation.internal.zn.i
    public final /* bridge */ /* synthetic */ InputStream a() throws IOException {
        throw null;
    }

    public final FileInputStream b() throws IOException {
        return new FileInputStream(this.a);
    }

    public final String toString() {
        return "Files.asByteSource(" + String.valueOf(this.a) + ")";
    }
}
