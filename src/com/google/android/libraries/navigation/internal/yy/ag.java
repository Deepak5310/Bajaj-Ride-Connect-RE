package com.google.android.libraries.navigation.internal.yy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag extends am implements Serializable, m {
    private static final long serialVersionUID = 1;
    transient m a;

    public ag(bi biVar) {
        super(biVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = d().c(this.k);
    }

    private Object readResolve() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.aa
    public final Object ak(Object obj) {
        return ((aj) this.a).c(obj);
    }
}
