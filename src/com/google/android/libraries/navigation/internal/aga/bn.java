package com.google.android.libraries.navigation.internal.aga;

import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bn {
    public List a;
    public int b;
    public int c;

    public bn(List list) {
        this.a = list;
    }

    public final com.google.android.libraries.navigation.internal.afx.c a() {
        return ((com.google.android.libraries.navigation.internal.afx.z) this.a.get(this.b)).c;
    }

    public final SocketAddress b() {
        return (SocketAddress) ((com.google.android.libraries.navigation.internal.afx.z) this.a.get(this.b)).b.get(this.c);
    }

    public final void c() {
        this.b = 0;
        this.c = 0;
    }
}
