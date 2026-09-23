package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bm extends c implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final Object a;

    protected bm(Object obj) {
        this.a = obj;
    }

    public final Object clone() {
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        return Objects.equals(this.a, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bk
    public final int o(Object obj) {
        Objects.equals(this.a, obj);
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 1;
    }
}
