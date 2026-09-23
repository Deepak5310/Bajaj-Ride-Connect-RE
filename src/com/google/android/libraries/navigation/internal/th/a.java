package com.google.android.libraries.navigation.internal.th;

import com.google.android.libraries.navigation.internal.zr.ch;
import com.google.android.libraries.navigation.internal.zr.ci;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final ch a = (ch) ci.a.q();
    private final List b = new ArrayList();

    public final void a() {
        ch chVar = this.a;
        if (chVar.a.H()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        chVar.b = chVar.s();
        this.b.clear();
    }
}
