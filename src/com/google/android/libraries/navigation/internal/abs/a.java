package com.google.android.libraries.navigation.internal.abs;

import com.google.android.libraries.navigation.internal.abf.aj;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public a(String str, int i, int i2, int i3) {
        this.a = str;
        this.b = i;
        com.google.android.libraries.navigation.internal.abf.s.a(i != 0, "glHandle");
        this.c = i2;
        this.d = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return com.google.android.libraries.navigation.internal.abf.r.a(this.a, aVar.a) && com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.b), Integer.valueOf(aVar.b)) && com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.c), Integer.valueOf(aVar.c)) && com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.d), Integer.valueOf(aVar.d));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("glShaderVariableName", this.a);
        return ajVarF.c("glHandle", this.b).c("glType", this.c).c("glSize", this.d).toString();
    }
}
