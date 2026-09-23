package com.google.android.libraries.navigation.internal.qd;

import com.google.android.libraries.navigation.internal.oe.ai;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public ai a;
    public float b;
    public boolean c = false;
    private final m d = m.a;

    final boolean a(com.google.android.libraries.navigation.internal.pb.t tVar) {
        if (this.a == null) {
            return true;
        }
        float fH = tVar.h();
        float f = this.b;
        return fH > f + f || fH < f / 2.0f || !this.a.l(tVar.v().c);
    }
}
