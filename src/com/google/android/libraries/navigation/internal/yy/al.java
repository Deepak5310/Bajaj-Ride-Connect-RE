package com.google.android.libraries.navigation.internal.yy;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class al implements Serializable, b {
    private static final long serialVersionUID = 1;
    final bi a;

    public al(bi biVar) {
        this.a = biVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use ManualSerializationProxy");
    }

    @Override // com.google.android.libraries.navigation.internal.yy.b
    public final Object b(Object obj, Callable callable) throws ExecutionException {
        return this.a.c(obj, new ak(callable));
    }

    Object writeReplace() {
        return new am(this.a);
    }
}
