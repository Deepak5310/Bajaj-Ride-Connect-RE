package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements Serializable, am {
    private static final long serialVersionUID = -4940583368468432370L;

    protected a() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.am
    public /* synthetic */ float a(Object obj, float f) {
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

    @Override // java.util.function.ToDoubleFunction
    public final /* synthetic */ double applyAsDouble(Object obj) {
        return o(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.am
    public /* synthetic */ float b(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.am
    public /* synthetic */ Float c(Object obj) {
        return al.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* synthetic */ boolean containsKey(Object obj) {
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
