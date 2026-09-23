package com.google.android.libraries.navigation.internal.yx;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bv implements Serializable, br {
    private static final long serialVersionUID = 0;
    public final Object a;

    public bv(Object obj) {
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final Object a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bv) {
            return am.a(this.a, ((bv) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + String.valueOf(this.a) + ")";
    }
}
