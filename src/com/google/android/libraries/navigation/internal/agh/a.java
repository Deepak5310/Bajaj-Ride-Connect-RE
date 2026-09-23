package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements Serializable, al {
    private static final long serialVersionUID = -4940583368468432370L;
    public double a;

    protected a() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.al
    public double a() {
        return this.a;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function andThen(Function function) {
        aj.a();
        return null;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    @Override // java.util.function.LongToDoubleFunction
    public final /* synthetic */ double applyAsDouble(long j) {
        return t(j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.al
    public /* synthetic */ double b(long j, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.al
    public /* synthetic */ double c(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        aj.a();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* synthetic */ boolean containsKey(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.al
    public /* synthetic */ Double d(Object obj) {
        return ak.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.al
    public /* synthetic */ boolean e(long j) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* synthetic */ int size() {
        return -1;
    }
}
