package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ee extends ef {
    private static final long serialVersionUID = 0;
    transient int c;

    public ee() {
        super(new cc(12));
        this.c = 2;
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        this.c = 2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.c = 2;
        int i = objectInputStream.readInt();
        r(new cc(12));
        mg.c(this, objectInputStream, i);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        mg.e(this, objectOutputStream);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.at, com.google.android.libraries.navigation.internal.yz.ae
    public final /* bridge */ /* synthetic */ Collection a() {
        return new ce(this.c);
    }
}
