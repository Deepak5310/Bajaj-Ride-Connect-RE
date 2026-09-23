package com.google.android.libraries.navigation.internal.ve;

import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.oe.x;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends a {
    private final x a;
    private final com.google.android.libraries.navigation.internal.vg.b b;
    private final Drawable c;
    private final String d;

    public b(x xVar, com.google.android.libraries.navigation.internal.vg.b bVar, Drawable drawable, String str) {
        Objects.requireNonNull(xVar);
        this.a = xVar;
        this.b = bVar;
        this.c = drawable;
        this.d = str;
    }

    @Override // com.google.android.libraries.navigation.internal.ve.a
    public final Drawable c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ve.a
    public final x d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ve.a
    public final com.google.android.libraries.navigation.internal.vg.b e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.vg.b bVar;
        Drawable drawable;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a.equals(aVar.d()) && ((bVar = this.b) != null ? bVar.equals(aVar.e()) : aVar.e() == null) && ((drawable = this.c) != null ? drawable.equals(aVar.c()) : aVar.c() == null) && ((str = this.d) != null ? str.equals(aVar.f()) : aVar.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ve.a
    public final String f() {
        return this.d;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        com.google.android.libraries.navigation.internal.vg.b bVar = this.b;
        int iHashCode2 = ((iHashCode * 1000003) ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        Drawable drawable = this.c;
        int iHashCode3 = (iHashCode2 ^ (drawable == null ? 0 : drawable.hashCode())) * 1000003;
        String str = this.d;
        return iHashCode3 ^ (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        Drawable drawable = this.c;
        com.google.android.libraries.navigation.internal.vg.b bVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(bVar) + ", " + String.valueOf(drawable) + ", " + this.d + "}";
    }
}
