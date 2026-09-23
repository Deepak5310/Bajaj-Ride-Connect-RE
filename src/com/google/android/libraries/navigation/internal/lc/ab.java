package com.google.android.libraries.navigation.internal.lc;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab extends ac {
    private final Callable e;

    public ab(Callable callable) {
        super(false, null, null);
        this.e = callable;
    }

    @Override // com.google.android.libraries.navigation.internal.lc.ac
    public final void a() {
        try {
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
