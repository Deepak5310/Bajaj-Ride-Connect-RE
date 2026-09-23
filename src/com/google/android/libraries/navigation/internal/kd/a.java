package com.google.android.libraries.navigation.internal.kd;

import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.w;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a implements Serializable, w {
    public final aa b;
    public Integer c;

    public a(com.google.android.libraries.navigation.internal.afd.a aVar) {
        this.b = aa.k(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.jy.w
    public final com.google.android.libraries.navigation.internal.afd.a a() {
        return this.b.k;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.b, aVar.b) && Objects.equals(this.c, aVar.c);
    }

    public final int hashCode() {
        return Objects.hash(this.b, this.c);
    }
}
