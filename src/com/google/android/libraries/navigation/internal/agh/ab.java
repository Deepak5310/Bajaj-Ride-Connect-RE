package com.google.android.libraries.navigation.internal.agh;

import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab extends com.google.android.libraries.navigation.internal.agi.u implements ar {
    final /* synthetic */ ai a;

    public ab(ai aiVar) {
        this.a = aiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ar
    public final com.google.android.libraries.navigation.internal.agi.gi a() {
        return new z(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new y(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new aa(this, 0, this.a.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() != null && (entry.getKey() instanceof Long) && entry.getValue() != null && (entry.getValue() instanceof Double)) {
            long jLongValue = ((Long) entry.getKey()).longValue();
            if (this.a.e(jLongValue) && Double.doubleToLongBits(this.a.t(jLongValue)) == Double.doubleToLongBits(((Double) entry.getValue()).doubleValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ar
    public final void d(Consumer consumer) {
        b bVar = new b();
        int i = this.a.d;
        for (int i2 = 0; i2 < i; i2++) {
            ai aiVar = this.a;
            bVar.a = aiVar.b[i2];
            bVar.b = aiVar.c[i2];
            consumer.accept(bVar);
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        int i = this.a.d;
        for (int i2 = 0; i2 < i; i2++) {
            ai aiVar = this.a;
            consumer.accept(new b(aiVar.b[i2], aiVar.c[i2]));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new y(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Long) || entry.getValue() == null || !(entry.getValue() instanceof Double)) {
            return false;
        }
        long jLongValue = ((Long) entry.getKey()).longValue();
        double dDoubleValue = ((Double) entry.getValue()).doubleValue();
        int iU = this.a.u(jLongValue);
        if (iU == -1) {
            return false;
        }
        long jDoubleToLongBits = Double.doubleToLongBits(dDoubleValue);
        ai aiVar = this.a;
        if (jDoubleToLongBits != Double.doubleToLongBits(aiVar.c[iU])) {
            return false;
        }
        int i = (aiVar.d - iU) - 1;
        long[] jArr = aiVar.b;
        int i2 = iU + 1;
        System.arraycopy(jArr, i2, jArr, iU, i);
        double[] dArr = this.a.c;
        System.arraycopy(dArr, i2, dArr, iU, i);
        this.a.d--;
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
