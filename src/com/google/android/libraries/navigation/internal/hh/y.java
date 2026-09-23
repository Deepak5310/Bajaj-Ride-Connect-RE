package com.google.android.libraries.navigation.internal.hh;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y extends ObjectOutputStream {
    private final i a;

    public y(OutputStream outputStream, i iVar) throws IOException {
        super(outputStream);
        this.a = iVar;
    }

    final void a() {
        enableReplaceObject(true);
    }

    @Override // java.io.ObjectOutputStream
    protected final Object replaceObject(Object obj) throws IOException {
        if (obj instanceof w) {
            w wVar = (w) obj;
            this.a.d(wVar);
            wVar.c(this.a);
        }
        return obj;
    }
}
