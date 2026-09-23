package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f implements Serializable, bx {
    private static final long serialVersionUID = -4940583368468432370L;
    public long a;

    protected f() {
    }

    public long a() {
        return this.a;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function andThen(Function function) {
        bv.a();
        return null;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    @Override // java.util.function.LongUnaryOperator
    public final /* synthetic */ long applyAsLong(long j) {
        return t(j);
    }

    public /* synthetic */ long b(long j, long j2) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ long c(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        bv.a();
        return null;
    }

    public /* synthetic */ boolean containsKey(Object obj) {
        throw null;
    }

    public /* synthetic */ Long d(Object obj) {
        return bw.a(this, obj);
    }

    public /* synthetic */ boolean e(long j) {
        throw null;
    }

    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    public /* synthetic */ int size() {
        return -1;
    }
}
