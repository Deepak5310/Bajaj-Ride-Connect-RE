package com.google.android.libraries.navigation.internal.hh;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class x extends ObjectInputStream {
    private final i a;

    public x(InputStream inputStream, i iVar) throws IOException {
        super(inputStream);
        this.a = iVar;
    }

    final void a() {
        enableResolveObject(true);
    }

    @Override // java.io.ObjectInputStream
    protected final Object resolveObject(Object obj) throws IOException {
        b bVar;
        return (!(obj instanceof w) || (bVar = ((w) obj).a) == null) ? obj : this.a.a(bVar);
    }
}
