package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw extends ax {
    private static final long serialVersionUID = 0;
    transient int c;

    public aw() {
        super(new cc(12));
        bs.d(3, "expectedValuesPerKey");
        this.c = 3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.c = 3;
        int i = objectInputStream.readInt();
        r(new cc());
        mg.c(this, objectInputStream, i);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        mg.e(this, objectOutputStream);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.j, com.google.android.libraries.navigation.internal.yz.ae
    public final /* bridge */ /* synthetic */ Collection a() {
        return new ArrayList(this.c);
    }
}
