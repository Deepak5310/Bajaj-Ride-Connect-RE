package com.google.android.libraries.navigation.internal.bp;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends ac {
    public final ac[] a;

    public z(ac[] acVarArr) {
        this.a = acVarArr;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ac
    public final boolean a() {
        for (ac acVar : this.a) {
            if (!acVar.a()) {
                return false;
            }
        }
        return this.a.length > 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            return Arrays.equals(((z) obj).a, this.a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (ac acVar : this.a) {
            sb.append(acVar);
        }
        return sb.toString();
    }
}
