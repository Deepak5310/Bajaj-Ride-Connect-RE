package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c implements Serializable, as {
    private static final long serialVersionUID = -4940583368468432370L;

    protected c() {
    }

    public /* synthetic */ Object a(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.function.IntFunction
    public final /* synthetic */ Object apply(int i) {
        return p(i);
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    public /* synthetic */ Object b(int i) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean c(int i) {
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
        return ar.a(this, obj);
    }

    public /* synthetic */ int size() {
        return -1;
    }
}
