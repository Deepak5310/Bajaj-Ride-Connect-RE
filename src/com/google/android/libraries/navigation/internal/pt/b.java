package com.google.android.libraries.navigation.internal.pt;

import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yx.am;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final b a = new b(null, new ai(new x(), new x()));
    public final a b;
    public final com.google.android.libraries.navigation.internal.oe.e c;
    public x d = null;

    public b(a aVar, com.google.android.libraries.navigation.internal.oe.e eVar) {
        this.b = aVar;
        this.c = eVar;
    }

    public final com.google.android.libraries.navigation.internal.oe.e a() {
        com.google.android.libraries.navigation.internal.oe.e eVar = this.c;
        return eVar instanceof com.google.android.libraries.navigation.internal.oe.f ? eVar.a() : eVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        b bVar = (b) obj;
        return am.a(this.b, bVar.b) && am.a(a(), bVar.a());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, a()});
    }

    public final String toString() {
        return String.format("%s - %s", this.b, this.c.a());
    }
}
