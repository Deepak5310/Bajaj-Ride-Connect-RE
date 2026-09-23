package com.google.android.libraries.navigation.internal.aga;

import com.google.android.libraries.navigation.internal.yz.no;
import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dk {
    public int a;
    private List b;
    private int c;
    private int d;

    public dk(List list) {
        d(list);
    }

    public final com.google.android.libraries.navigation.internal.afx.c a() {
        if (f()) {
            return ((com.google.android.libraries.navigation.internal.afx.z) this.b.get(this.c)).c;
        }
        throw new IllegalStateException("Index is off the end of the address group list");
    }

    public final SocketAddress b() {
        if (f()) {
            return (SocketAddress) ((com.google.android.libraries.navigation.internal.afx.z) this.b.get(this.c)).b.get(this.d);
        }
        throw new IllegalStateException("Index is past the end of the address group list");
    }

    public final void c() {
        this.c = 0;
        this.d = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(List list) {
        com.google.android.libraries.navigation.internal.yx.ar.r(list, "newGroups");
        this.b = list;
        c();
        no it2 = ((com.google.android.libraries.navigation.internal.yz.ev) list).iterator();
        int size = 0;
        while (it2.hasNext()) {
            size += ((com.google.android.libraries.navigation.internal.afx.z) it2.next()).b.size();
        }
        this.a = size;
    }

    public final boolean e() {
        if (!f()) {
            return false;
        }
        com.google.android.libraries.navigation.internal.afx.z zVar = (com.google.android.libraries.navigation.internal.afx.z) this.b.get(this.c);
        int i = this.d + 1;
        this.d = i;
        if (i < zVar.b.size()) {
            return true;
        }
        int i2 = this.c + 1;
        this.c = i2;
        this.d = 0;
        return i2 < this.b.size();
    }

    public final boolean f() {
        return this.c < this.b.size();
    }

    public final boolean g(SocketAddress socketAddress) {
        for (int i = 0; i < this.b.size(); i++) {
            int iIndexOf = ((com.google.android.libraries.navigation.internal.afx.z) this.b.get(i)).b.indexOf(socketAddress);
            if (iIndexOf != -1) {
                this.c = i;
                this.d = iIndexOf;
                return true;
            }
        }
        return false;
    }
}
