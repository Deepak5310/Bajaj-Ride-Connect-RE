package com.google.android.libraries.navigation.internal.yy;

import com.google.android.libraries.navigation.internal.aac.cj;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aj extends al implements m {
    private static final long serialVersionUID = 1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(h hVar, j jVar) {
        super(new bi(hVar, jVar));
        com.google.android.libraries.navigation.internal.yx.ar.q(jVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use LoadingSerializationProxy");
    }

    @Override // com.google.android.libraries.navigation.internal.yx.aa
    public final Object ak(Object obj) {
        return c(obj);
    }

    public final Object c(Object obj) {
        try {
            bi biVar = this.a;
            return biVar.c(obj, biVar.s);
        } catch (ExecutionException e) {
            throw new cj(e.getCause());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yy.al
    Object writeReplace() {
        return new ag(this.a);
    }
}
