package com.google.android.libraries.navigation.internal.oz;

import com.google.android.libraries.navigation.internal.qd.n;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final n a;
    public final e b;

    public c(n nVar, e eVar) {
        this.a = nVar;
        this.b = eVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.b.equals(this.b) && cVar.a.equals(this.a);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }
}
