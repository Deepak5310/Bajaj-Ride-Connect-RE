package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends ah {
    public eq a;
    public ev b;

    @Override // com.google.android.libraries.navigation.internal.rz.ah
    public final ai a() {
        eq eqVar = this.a;
        if (eqVar != null) {
            this.b = eqVar.g();
        } else if (this.b == null) {
            int i = ev.d;
            this.b = lv.a;
        }
        return new n(this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ah
    public final eq b() {
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
