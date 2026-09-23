package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au extends AbstractList {
    public static final au a;
    protected final List b;
    private final int c = -1;

    static {
        int i = ev.d;
        a = new au(lv.a);
    }

    protected au(List list) {
        this.b = list;
    }

    public final Object a() {
        if (this.c != -1) {
            return get(0);
        }
        return null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.b.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return ((lv) this.b).c;
    }
}
