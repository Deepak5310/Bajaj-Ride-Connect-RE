package com.google.android.libraries.navigation.internal.pi;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac {
    public final com.google.android.libraries.navigation.internal.pn.o a;

    public ac(com.google.android.libraries.navigation.internal.pn.o oVar) {
        this.a = oVar;
    }

    public final boolean a() {
        return this.a == com.google.android.libraries.navigation.internal.pn.o.LAST_FINGER_UP || this.a == com.google.android.libraries.navigation.internal.pn.o.FINGER_ACTION_CANCEL;
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("type", this.a);
        return akVarB.toString();
    }
}
