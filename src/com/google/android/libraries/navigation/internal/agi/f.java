package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f implements Serializable, cw {
    private static final long serialVersionUID = -4940583368468432370L;
    public long a;

    protected f() {
    }

    public long a() {
        return this.a;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function andThen(Function function) {
        throw new NoSuchMethodError();
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    @Override // java.util.function.ToLongFunction
    public final /* synthetic */ long applyAsLong(Object obj) {
        return q(obj);
    }

    public /* synthetic */ long b(Object obj, long j) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ long c(Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean containsKey(Object obj) {
        throw null;
    }

    public /* synthetic */ Long d(Object obj) {
        return cv.a(this, obj);
    }

    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    public /* synthetic */ int size() {
        return -1;
    }
}
