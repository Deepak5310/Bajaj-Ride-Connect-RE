package com.google.android.libraries.navigation.internal.db;

import com.google.android.libraries.navigation.internal.db.as;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class au<T extends as> {
    protected final as a;

    public au(as asVar) {
        this.a = asVar;
    }

    public as d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof au) {
            return com.google.android.libraries.navigation.internal.yx.am.a(this.a, ((au) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g(FirebaseAnalytics.Param.LOCATION, d());
        return akVarB.toString();
    }
}
