package com.google.android.libraries.navigation.internal.agi;

import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cn extends u implements dd {
    final /* synthetic */ cu a;

    public cn(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dd
    public final gi a() {
        return new cl(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new ck(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new cm(this, 0, this.a.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getValue() != null && (entry.getValue() instanceof Long)) {
            Object key = entry.getKey();
            if (this.a.containsKey(key) && this.a.q(key) == ((Long) entry.getValue()).longValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dd
    public final void d(Consumer consumer) {
        g gVar = new g();
        int i = this.a.d;
        for (int i2 = 0; i2 < i; i2++) {
            cu cuVar = this.a;
            gVar.a = cuVar.b[i2];
            gVar.b = cuVar.c[i2];
            consumer.accept(gVar);
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        int i = this.a.d;
        for (int i2 = 0; i2 < i; i2++) {
            cu cuVar = this.a;
            consumer.accept(new g(cuVar.b[i2], cuVar.c[i2]));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new ck(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getValue() == null || !(entry.getValue() instanceof Long)) {
            return false;
        }
        Object key = entry.getKey();
        long jLongValue = ((Long) entry.getValue()).longValue();
        int iP = this.a.p(key);
        if (iP == -1) {
            return false;
        }
        cu cuVar = this.a;
        if (jLongValue != cuVar.c[iP]) {
            return false;
        }
        int i = (cuVar.d - iP) - 1;
        Object[] objArr = cuVar.b;
        int i2 = iP + 1;
        System.arraycopy(objArr, i2, objArr, iP, i);
        long[] jArr = this.a.c;
        System.arraycopy(jArr, i2, jArr, iP, i);
        cu cuVar2 = this.a;
        int i3 = cuVar2.d - 1;
        cuVar2.d = i3;
        cuVar2.b[i3] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
