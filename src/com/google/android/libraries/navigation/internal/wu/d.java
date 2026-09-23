package com.google.android.libraries.navigation.internal.wu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.aac.d {
    Object a;
    Runnable b = null;

    public d(Object obj, Runnable runnable) {
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    public final String ao() {
        Object obj = this.a;
        return obj == null ? "" : obj.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    public final boolean ap(Throwable th) {
        return super.ap(th);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        this.a = null;
        this.b = null;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    public final boolean d(Object obj) {
        return super.d(obj);
    }
}
