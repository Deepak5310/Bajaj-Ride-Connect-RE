package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fg implements Serializable {
    private static final long serialVersionUID = 0;
    final fd a;

    public fg(fd fdVar) {
        this.a = fdVar;
    }

    Object readResolve() {
        return this.a.keySet();
    }
}
