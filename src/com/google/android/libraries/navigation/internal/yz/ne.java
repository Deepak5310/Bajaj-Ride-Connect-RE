package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ne implements nc {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof nc) {
            nc ncVar = (nc) obj;
            if (com.google.android.libraries.navigation.internal.yx.am.a(b(), ncVar.b()) && com.google.android.libraries.navigation.internal.yx.am.a(a(), ncVar.a()) && com.google.android.libraries.navigation.internal.yx.am.a(c(), ncVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a(), c()});
    }

    public final String toString() {
        return "(" + String.valueOf(b()) + "," + String.valueOf(a()) + ")=" + String.valueOf(c());
    }
}
