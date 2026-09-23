package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class im extends ia {
    private static final long serialVersionUID = 3;

    public im(in inVar, in inVar2, com.google.android.libraries.navigation.internal.yx.y yVar, com.google.android.libraries.navigation.internal.yx.y yVar2, int i, ConcurrentMap concurrentMap) {
        super(inVar, inVar2, yVar, i, concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        hy hyVar = new hy();
        int i2 = hyVar.b;
        com.google.android.libraries.navigation.internal.yx.ar.m(i2 == -1, "initial capacity was already set to %s", i2);
        com.google.android.libraries.navigation.internal.yx.ar.a(i >= 0);
        hyVar.b = i;
        hyVar.g(this.a);
        hyVar.h(this.b);
        com.google.android.libraries.navigation.internal.yx.y yVar = hyVar.f;
        com.google.android.libraries.navigation.internal.yx.ar.o(yVar == null, "key equivalence was already set to %s", yVar);
        com.google.android.libraries.navigation.internal.yx.y yVar2 = this.c;
        com.google.android.libraries.navigation.internal.yx.ar.q(yVar2);
        hyVar.f = yVar2;
        hyVar.a = true;
        int i3 = hyVar.c;
        com.google.android.libraries.navigation.internal.yx.ar.m(i3 == -1, "concurrency level was already set to %s", i3);
        int i4 = this.d;
        com.google.android.libraries.navigation.internal.yx.ar.a(i4 > 0);
        hyVar.c = i4;
        this.e = hyVar.f();
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                this.e.put(object, objectInputStream.readObject());
            }
        }
    }

    private Object readResolve() {
        return this.e;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.e.size());
        for (Map.Entry entry : this.e.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
        objectOutputStream.writeObject(null);
    }
}
