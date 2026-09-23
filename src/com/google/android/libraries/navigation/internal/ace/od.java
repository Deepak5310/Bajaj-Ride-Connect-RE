package com.google.android.libraries.navigation.internal.ace;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class od extends com.google.android.libraries.navigation.internal.ael.bi implements oe {
    public static final od a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public com.google.android.libraries.navigation.internal.ael.bz b = com.google.android.libraries.navigation.internal.ael.dj.b;
    public oc c;
    public ns d;
    public nq e;
    public boolean f;
    public boolean g;
    public boolean h;
    private int j;
    private int k;
    private int l;

    static {
        od odVar = new od();
        a = odVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(od.class, odVar);
    }

    private od() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0003m¡\u0007\u0000\u0001\u0000m\u001buဇ(|ဉ\u000b\u008eဉ\f\u009fဇR ဇ,¡ဉ\u000e", new Object[]{"j", "k", "l", "b", oa.class, "f", "c", "d", "h", "g", "e"});
        }
        if (i3 == 3) {
            return new od();
        }
        if (i3 == 4) {
            return new no();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (od.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final nq c() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final ns d() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final oc e() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final List f() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final boolean g() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final boolean h() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final boolean i() {
        throw null;
    }
}
