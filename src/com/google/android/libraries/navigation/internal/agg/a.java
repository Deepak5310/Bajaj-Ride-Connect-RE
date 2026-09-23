package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements Serializable, u {
    private static final long serialVersionUID = -4940583368468432370L;

    protected a() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.u
    public /* synthetic */ int a(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function andThen(Function function) {
        s.a();
        return null;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    @Override // java.util.function.IntUnaryOperator
    public final /* synthetic */ int applyAsInt(int i) {
        return s(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.u
    public /* synthetic */ int b(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.u
    public /* synthetic */ Integer c(Object obj) {
        return t.a(this, obj);
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        s.a();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* synthetic */ boolean containsKey(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.u
    public /* synthetic */ boolean d(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* synthetic */ int size() {
        return -1;
    }
}
