package com.google.android.libraries.navigation.internal.afz;

import com.google.android.libraries.navigation.internal.afx.aa;
import com.google.android.libraries.navigation.internal.afx.bf;
import com.google.android.libraries.navigation.internal.aga.az;
import com.google.android.libraries.navigation.internal.aga.cx;
import com.google.android.libraries.navigation.internal.aga.eu;
import com.google.android.libraries.navigation.internal.aga.ev;
import java.net.InetSocketAddress;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends aa {
    public final CronetEngine a;
    public final eu b = ev.a;
    public final int c = 4194304;
    private final cx d;

    public e(String str, int i, CronetEngine cronetEngine) {
        this.d = new cx(InetSocketAddress.createUnresolved(str, i), az.a(str, i), new a(this));
        this.a = cronetEngine;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.aa
    public final bf a() {
        return this.d;
    }
}
