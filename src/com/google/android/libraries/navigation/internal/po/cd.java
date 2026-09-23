package com.google.android.libraries.navigation.internal.po;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cd extends gt implements com.google.android.libraries.navigation.internal.ol.at {
    private final com.google.android.libraries.navigation.internal.oe.x d;

    public cd(com.google.android.libraries.navigation.internal.ol.aa aaVar, int i, com.google.android.libraries.navigation.internal.qq.h hVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        super(aaVar, i, hVar);
        this.d = new com.google.android.libraries.navigation.internal.oe.x(xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.po.gt, com.google.android.libraries.navigation.internal.ol.at
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.ol.aa b() {
        return (com.google.android.libraries.navigation.internal.ol.aa) this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.po.gt
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                cd cdVar = (cd) obj;
                if (b().equals(cdVar.b()) && this.b == cdVar.b && this.c.equals(cdVar.c) && this.d.equals(cdVar.d)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.po.gt
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(super.hashCode()), this.d});
    }
}
