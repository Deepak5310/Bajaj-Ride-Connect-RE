package com.google.android.libraries.geo.navcore.ui.header.views;

import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    final float a;
    final ap b;
    final ap c;

    public i() {
        ar.a(true);
        this.a = 1.4f;
        this.b = null;
        this.c = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            float f = iVar.a;
            ap apVar = iVar.b;
            if (am.a(null, null)) {
                ap apVar2 = iVar.c;
                if (am.a(null, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(1.4f), null, null});
    }
}
