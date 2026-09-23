package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ab implements Serializable, jp {
    private static final long serialVersionUID = -4940583368468432370L;

    protected ab() {
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return com.google.android.libraries.navigation.internal.agc.c.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* synthetic */ boolean containsKey(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agc.d
    public /* synthetic */ int size() {
        return -1;
    }
}
