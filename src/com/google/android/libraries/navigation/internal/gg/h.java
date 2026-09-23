package com.google.android.libraries.navigation.internal.gg;

import android.accounts.Account;
import com.google.android.libraries.navigation.internal.db.as;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public Object a;
    public String b;
    public Account c;
    public as d;
    public n e;
    private int f;

    public final void a(int i) {
        ar.d(i >= 0, "negative numTries: %s", i);
        this.f = i;
    }
}
