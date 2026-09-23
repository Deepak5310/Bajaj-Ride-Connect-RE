package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.hg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i {
    public int a;
    public hg b;

    public i(int i, hg hgVar) {
        this.a = i;
        this.b = hgVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a == iVar.a && this.b == iVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a * 37) + System.identityHashCode(this.b);
    }
}
