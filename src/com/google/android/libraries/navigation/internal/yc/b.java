package com.google.android.libraries.navigation.internal.yc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends d implements com.google.android.libraries.navigation.internal.yb.a {
    private final FileOutputStream a;
    private final File b;

    public b(FileOutputStream fileOutputStream, File file) {
        super(fileOutputStream);
        this.a = fileOutputStream;
        this.b = file;
    }

    @Override // com.google.android.libraries.navigation.internal.yb.a
    public final File a() {
        return this.b;
    }

    public final void b() throws IOException {
        this.a.getFD().sync();
    }
}
