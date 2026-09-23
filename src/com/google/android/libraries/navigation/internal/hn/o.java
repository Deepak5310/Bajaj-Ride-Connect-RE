package com.google.android.libraries.navigation.internal.hn;

import com.google.android.libraries.navigation.internal.afl.fd;
import com.google.android.libraries.navigation.internal.afl.ff;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o {
    final fd a;
    final boolean b;
    final boolean c;
    final ff d;

    public o(fd fdVar, boolean z, boolean z2, ff ffVar) {
        this.a = fdVar;
        this.b = z;
        this.c = z2;
        this.d = ffVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a == oVar.a && this.b == oVar.b && this.c == oVar.c && this.d == oVar.d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Boolean.valueOf(this.b), Boolean.valueOf(this.c), this.d});
    }
}
