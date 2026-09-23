package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bk {
    public final int a;
    public final com.google.android.libraries.geo.mapcore.internal.model.aq b;
    public String c;
    public final String d;
    public com.google.android.libraries.geo.mapcore.internal.model.bv e = null;
    public com.google.android.libraries.geo.mapcore.internal.model.bd f = null;
    public com.google.android.libraries.navigation.internal.zy.e g;
    public fd h;

    public bk(int i, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, String str, String str2, com.google.android.libraries.navigation.internal.zy.e eVar, fd fdVar) {
        this.a = i;
        this.b = aqVar;
        this.c = str;
        this.d = str2;
        this.g = eVar;
        this.h = fdVar;
    }

    public final com.google.android.libraries.geo.mapcore.internal.model.v a() {
        com.google.android.libraries.geo.mapcore.internal.model.bd bdVar;
        com.google.android.libraries.navigation.internal.zy.e eVar;
        fd fdVar;
        com.google.android.libraries.geo.mapcore.internal.model.bv bvVar = this.e;
        if (bvVar == null || (bdVar = this.f) == null || (eVar = this.g) == null || (fdVar = this.h) == null) {
            return null;
        }
        return new com.google.android.libraries.geo.mapcore.internal.model.v(this.a, this.b, bvVar, bdVar, eVar, fdVar);
    }
}
