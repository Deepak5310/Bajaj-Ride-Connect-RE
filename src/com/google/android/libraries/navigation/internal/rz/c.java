package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends u {
    public eq a;
    public ev b;
    public byte c;

    @Override // com.google.android.libraries.navigation.internal.rz.u
    public final eq a() {
        if (this.a == null) {
            if (this.b == null) {
                int i = ev.d;
                this.a = new eq();
            } else {
                int i2 = ev.d;
                eq eqVar = new eq();
                this.a = eqVar;
                eqVar.j(this.b);
                this.b = null;
            }
        }
        return this.a;
    }
}
