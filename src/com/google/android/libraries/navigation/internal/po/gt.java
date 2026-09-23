package com.google.android.libraries.navigation.internal.po;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class gt implements com.google.android.libraries.navigation.internal.ol.at {
    public final com.google.android.libraries.navigation.internal.ol.au a;
    protected final int b;
    protected final com.google.android.libraries.navigation.internal.qq.h c;

    public gt(com.google.android.libraries.navigation.internal.ol.au auVar, int i, com.google.android.libraries.navigation.internal.qq.h hVar) {
        this.a = auVar;
        this.b = i;
        this.c = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.at
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.at
    public com.google.android.libraries.navigation.internal.ol.au b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.at
    public final boolean c() {
        com.google.android.libraries.navigation.internal.ol.au auVar = this.a;
        return !(auVar instanceof b) || ((b) auVar).r();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                gt gtVar = (gt) obj;
                if (b().equals(gtVar.b()) && this.b == gtVar.b && this.c.equals(gtVar.c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), this.c});
    }
}
