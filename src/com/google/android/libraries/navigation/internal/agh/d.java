package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d implements Serializable, ax {
    private static final long serialVersionUID = -4940583368468432370L;

    protected d() {
    }

    public /* synthetic */ int a(long j, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function andThen(Function function) {
        av.a();
        return null;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    @Override // java.util.function.LongToIntFunction
    public final /* synthetic */ int applyAsInt(long j) {
        return s(j);
    }

    public /* synthetic */ int b(long j) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Integer c(Object obj) {
        return aw.a(this, obj);
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        av.a();
        return null;
    }

    public /* synthetic */ boolean containsKey(Object obj) {
        throw null;
    }

    public /* synthetic */ boolean d(long j) {
        throw null;
    }

    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    public /* synthetic */ int size() {
        return -1;
    }
}
