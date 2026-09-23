package com.google.android.libraries.navigation.internal.he;

import android.content.Intent;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b {
    public final int a;
    public final Intent b;

    public b(int i, Intent intent) {
        this.a = i;
        this.b = intent;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.b.filterEquals(bVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.b.filterHashCode() * 37) + this.a;
    }

    public final String toString() {
        ak akVarC = al.b(this).c("capabilityId", this.a);
        akVarC.g("intent", this.b);
        return akVarC.toString();
    }
}
