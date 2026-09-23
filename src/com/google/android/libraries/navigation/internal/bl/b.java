package com.google.android.libraries.navigation.internal.bl;

import com.google.android.libraries.navigation.internal.aap.l;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class b extends d.a {
    private final hu e;

    public b(l lVar, hs hsVar, hu huVar, boolean z, int i) {
        super(lVar, hsVar, z, i);
        this.e = huVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bl.d.a
    public final boolean a(l lVar, hs hsVar, hu huVar, int i) {
        return this.e == huVar && super.a(lVar, hsVar, huVar, i);
    }
}
