package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fv extends ar implements Serializable {
    public static final fv a;
    public static final fv b;
    private final transient ev c;

    static {
        int i = ev.d;
        a = new fv(lv.a);
        b = new fv(ev.q(lr.a));
    }

    public fv(ev evVar) {
        this.c = evVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ar, com.google.android.libraries.navigation.internal.yz.lu
    @Deprecated
    public final void a(lr lrVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ar
    @Deprecated
    public final void c(lr lrVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lu
    public final /* bridge */ /* synthetic */ Set e() {
        if (this.c.isEmpty()) {
            return mb.a;
        }
        ev evVar = this.c;
        lr lrVar = lr.a;
        return new mc(evVar, lq.a);
    }

    Object writeReplace() {
        return new fu(this.c);
    }
}
