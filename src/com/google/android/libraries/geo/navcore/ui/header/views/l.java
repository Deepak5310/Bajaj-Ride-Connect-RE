package com.google.android.libraries.geo.navcore.ui.header.views;

import com.google.android.libraries.navigation.internal.bp.bq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    final bq a;
    final com.google.android.libraries.navigation.internal.up.g b;

    public l(bq bqVar, com.google.android.libraries.navigation.internal.up.g gVar) {
        this.a = bqVar;
        this.b = gVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        return this.a.equals(((l) obj).a);
    }
}
