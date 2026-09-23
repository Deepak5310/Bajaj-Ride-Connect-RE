package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.EnumSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eo implements Serializable {
    private static final long serialVersionUID = 0;
    final EnumSet a;

    public eo(EnumSet enumSet) {
        this.a = enumSet;
    }

    Object readResolve() {
        return new ep(this.a.clone());
    }
}
