package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h implements Serializable, di {
    private static final long serialVersionUID = -4940583368468432370L;

    protected h() {
    }

    public /* synthetic */ Object a(long j, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.function.LongFunction
    public final /* synthetic */ Object apply(long j) {
        return aO(j);
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    public /* synthetic */ Object b(long j) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean c(long j) {
        throw null;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        throw new NoSuchMethodError();
    }

    public /* synthetic */ boolean containsKey(Object obj) {
        throw null;
    }

    public /* synthetic */ Object get(Object obj) {
        return dh.a(this, obj);
    }

    public /* synthetic */ int size() {
        return -1;
    }
}
