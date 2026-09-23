package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class el extends com.google.android.libraries.navigation.internal.agi.u implements dz {
    final /* synthetic */ eq a;

    public el(eq eqVar) {
        this.a = eqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dz
    public final com.google.android.libraries.navigation.internal.agi.gi aR() {
        return new eg(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new ee(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new ef(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        eq eqVar;
        long j;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Long)) {
            return false;
        }
        long jLongValue = ((Long) entry.getKey()).longValue();
        Object value = entry.getValue();
        if (jLongValue == 0) {
            eq eqVar2 = this.a;
            return eqVar2.d && Objects.equals(eqVar2.b[eqVar2.e], value);
        }
        eq eqVar3 = this.a;
        long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
        long[] jArr = eqVar3.a;
        int i = ((int) jG) & eqVar3.c;
        long j2 = jArr[i];
        if (j2 == 0) {
            return false;
        }
        if (jLongValue == j2) {
            return Objects.equals(eqVar3.b[i], value);
        }
        do {
            eqVar = this.a;
            i = (i + 1) & eqVar.c;
            j = jArr[i];
            if (j == 0) {
                return false;
            }
        } while (jLongValue != j);
        return Objects.equals(eqVar.b[i], value);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dz
    public final void d(Consumer consumer) {
        eq eqVar = this.a;
        ek ekVar = new ek(eqVar);
        if (eqVar.d) {
            ekVar.a = eqVar.e;
            consumer.accept(ekVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != 0) {
                ekVar.a = i;
                consumer.accept(ekVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        eq eqVar = this.a;
        if (eqVar.d) {
            consumer.accept(new ek(eqVar, eqVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            eq eqVar2 = this.a;
            if (eqVar2.a[i] != 0) {
                consumer.accept(new ek(eqVar2, i));
            }
        }
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
        if (jLongValue == 0) {
            eq eqVar = this.a;
            if (!eqVar.d || !Objects.equals(eqVar.b[eqVar.e], value)) {
                return false;
            }
            this.a.m();
            return true;
        }
        eq eqVar2 = this.a;
        long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
        long[] jArr = eqVar2.a;
        int i = ((int) jG) & eqVar2.c;
        long j = jArr[i];
        if (j == 0) {
            return false;
        }
        if (j == jLongValue) {
            if (!Objects.equals(eqVar2.b[i], value)) {
                return false;
            }
            this.a.j(i);
            return true;
        }
        while (true) {
            eq eqVar3 = this.a;
            i = (i + 1) & eqVar3.c;
            long j2 = jArr[i];
            if (j2 == 0) {
                return false;
            }
            if (j2 == jLongValue && Objects.equals(eqVar3.b[i], value)) {
                this.a.j(i);
                return true;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
