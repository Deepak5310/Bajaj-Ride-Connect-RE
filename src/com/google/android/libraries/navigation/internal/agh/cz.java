package com.google.android.libraries.navigation.internal.agh;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cz extends com.google.android.libraries.navigation.internal.agi.u implements dz {
    final /* synthetic */ dg a;

    public cz(dg dgVar) {
        this.a = dgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dz
    public final com.google.android.libraries.navigation.internal.agi.gi aR() {
        return new cx(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new cw(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new cy(this, 0, this.a.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() != null && (entry.getKey() instanceof Long)) {
            long jLongValue = ((Long) entry.getKey()).longValue();
            if (this.a.c(jLongValue) && Objects.equals(this.a.aO(jLongValue), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dz
    public final void d(Consumer consumer) {
        i iVar = new i();
        int i = this.a.c;
        for (int i2 = 0; i2 < i; i2++) {
            dg dgVar = this.a;
            iVar.a = dgVar.a[i2];
            iVar.b = dgVar.b[i2];
            consumer.accept(iVar);
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        int i = this.a.c;
        for (int i2 = 0; i2 < i; i2++) {
            dg dgVar = this.a;
            consumer.accept(new i(dgVar.a[i2], dgVar.b[i2]));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new cw(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Long)) {
            return false;
        }
        long jLongValue = ((Long) entry.getKey()).longValue();
        Object value = entry.getValue();
        int iH = this.a.h(jLongValue);
        if (iH == -1 || !Objects.equals(value, this.a.b[iH])) {
            return false;
        }
        dg dgVar = this.a;
        int i = (dgVar.c - iH) - 1;
        int i2 = iH + 1;
        long[] jArr = dgVar.a;
        System.arraycopy(jArr, i2, jArr, iH, i);
        Object[] objArr = this.a.b;
        System.arraycopy(objArr, i2, objArr, iH, i);
        dg dgVar2 = this.a;
        int i3 = dgVar2.c - 1;
        dgVar2.c = i3;
        dgVar2.b[i3] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
