package com.google.android.libraries.navigation.internal.kd;

import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zp.ce;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends h {
    public ce a;
    private eq b;
    private ev c;

    @Override // com.google.android.libraries.navigation.internal.kd.h
    public final i a() {
        eq eqVar = this.b;
        if (eqVar != null) {
            this.c = eqVar.g();
        } else if (this.c == null) {
            int i = ev.d;
            this.c = lv.a;
        }
        ce ceVar = this.a;
        if (ceVar != null) {
            return new c(this.c, ceVar);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.kd.h
    public final eq b() {
        if (this.b == null) {
            int i = ev.d;
            this.b = new eq();
        }
        return this.b;
    }
}
