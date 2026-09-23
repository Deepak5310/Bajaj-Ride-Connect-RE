package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends g {
    private static final long serialVersionUID = 0;

    public d(Map map, g gVar) {
        super(map, gVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.b = (g) Objects.requireNonNull(objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.g
    public final Object a(Object obj) {
        return this.b.b(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.g
    public final Object b(Object obj) {
        return this.b.a(obj);
    }

    Object readResolve() {
        return this.b.d();
    }
}
