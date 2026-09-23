package com.google.android.libraries.navigation.internal.abf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends ThreadLocal {
    final /* synthetic */ int a;

    public ac(int i) {
        this.a = i;
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return new float[this.a];
    }
}
