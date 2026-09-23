package com.google.android.libraries.navigation.internal.hj;

import android.accounts.Account;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends i {
    public static final g a = new g();
    public static final boolean b;

    static {
        f fVar = f.UNKNOWN;
        b = true;
    }

    private g() {
        super("signedout@", "com.google.android.apps.maps");
    }

    public final String a() {
        a aVar = k.a;
        if (aVar == null) {
            return null;
        }
        new Account(this.c, "com.google.android.apps.maps");
        return (String) aVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.hj.i
    public final boolean b() {
        return b;
    }
}
