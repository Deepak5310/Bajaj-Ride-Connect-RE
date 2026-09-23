package com.google.android.libraries.geo.navcore.ui.header.views;

import com.google.android.libraries.navigation.internal.yx.am;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public final List a;
    public final com.google.android.libraries.navigation.internal.um.d b;
    private final com.google.android.libraries.navigation.internal.um.c c;
    private final int d = 8;

    public d(List list, com.google.android.libraries.navigation.internal.um.d dVar, com.google.android.libraries.navigation.internal.um.c cVar) {
        this.a = list;
        this.b = dVar;
        this.c = cVar;
    }

    public final void a(MultiIconView multiIconView) {
        h.a(multiIconView, this.a, this.b, this.c, 8);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (am.a(this.a, dVar.a) && am.a(this.b, dVar.b) && am.a(this.c, dVar.c)) {
                int i = dVar.d;
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, 8});
    }
}
