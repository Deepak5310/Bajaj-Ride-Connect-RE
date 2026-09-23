package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x implements Serializable, ht {
    private static final long serialVersionUID = -4940583368468432370L;

    protected x() {
    }

    public /* synthetic */ int a(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function andThen(Function function) {
        throw new NoSuchMethodError();
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    @Override // java.util.function.ToIntFunction
    public final /* synthetic */ int applyAsInt(Object obj) {
        return o(obj);
    }

    public /* synthetic */ int b(Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Integer c(Object obj) {
        return hs.a(this, obj);
    }

    public /* synthetic */ boolean containsKey(Object obj) {
        throw null;
    }

    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    public /* synthetic */ int size() {
        return -1;
    }
}
