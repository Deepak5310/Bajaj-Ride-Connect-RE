package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cy extends g {
    private static final long serialVersionUID = 0;
    transient Class c;
    transient Class d;

    public cy(Class cls, Class cls2) {
        super(new EnumMap(cls), new EnumMap(cls2));
        this.c = cls;
        this.d = cls2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.c = (Class) Objects.requireNonNull(objectInputStream.readObject());
        this.d = (Class) Objects.requireNonNull(objectInputStream.readObject());
        i(new EnumMap(this.c), new EnumMap(this.d));
        mg.b(this, objectInputStream, objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.c);
        objectOutputStream.writeObject(this.d);
        mg.d(this, objectOutputStream);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.g
    public final /* synthetic */ Object a(Object obj) {
        Enum r1 = (Enum) obj;
        com.google.android.libraries.navigation.internal.yx.ar.q(r1);
        return r1;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.g
    public final /* synthetic */ Object b(Object obj) {
        Enum r1 = (Enum) obj;
        com.google.android.libraries.navigation.internal.yx.ar.q(r1);
        return r1;
    }
}
