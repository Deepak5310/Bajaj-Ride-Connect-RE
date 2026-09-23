package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dr extends com.google.android.libraries.navigation.internal.agi.v implements er {
    final /* synthetic */ du a;

    public dr(du duVar) {
        this.a = duVar;
    }

    public static final com.google.android.libraries.navigation.internal.agi.hi i() {
        throw new UnsupportedOperationException();
    }

    public static final com.google.android.libraries.navigation.internal.agi.hi j() {
        throw new UnsupportedOperationException();
    }

    public static final com.google.android.libraries.navigation.internal.agi.hi k() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a */
    public final com.google.android.libraries.navigation.internal.agi.ge listIterator() {
        return new dm(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new com.google.android.libraries.navigation.internal.agi.hq(listIterator(), com.google.android.libraries.navigation.internal.agc.h.b(this.a), 81);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        du duVar;
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
            du duVar2 = this.a;
            return duVar2.d && Objects.equals(duVar2.b[duVar2.h], value);
        }
        du duVar3 = this.a;
        long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
        long[] jArr = duVar3.a;
        int i = ((int) jG) & duVar3.c;
        long j2 = jArr[i];
        if (j2 == 0) {
            return false;
        }
        if (jLongValue == j2) {
            return Objects.equals(duVar3.b[i], value);
        }
        do {
            duVar = this.a;
            i = (i + 1) & duVar.c;
            j = jArr[i];
            if (j == 0) {
                return false;
            }
        } while (jLongValue != j);
        return Objects.equals(duVar.b[i], value);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dz
    public final void d(Consumer consumer) {
        du duVar = this.a;
        dq dqVar = new dq(duVar);
        int i = duVar.k;
        int i2 = duVar.e;
        while (i != 0) {
            i--;
            dqVar.a = i2;
            i2 = (int) this.a.g[i2];
            consumer.accept(dqVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hi
    /* JADX INFO: renamed from: e */
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hi headSet(Object obj) {
        return i();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hi
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hi subSet(Object obj, Object obj2) {
        return j();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object first() {
        du duVar = this.a;
        if (duVar.k != 0) {
            return new dq(duVar, duVar.e);
        }
        throw new NoSuchElementException();
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        du duVar = this.a;
        int i = duVar.k;
        int i2 = duVar.e;
        while (i != 0) {
            i--;
            du duVar2 = this.a;
            int i3 = (int) duVar2.g[i2];
            consumer.accept(new dq(duVar2, i2));
            i2 = i3;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hi
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hi tailSet(Object obj) {
        return k();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dz
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.agi.gw aR() {
        return new dn(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return i();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object last() {
        du duVar = this.a;
        if (duVar.k != 0) {
            return new dq(duVar, duVar.f);
        }
        throw new NoSuchElementException();
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
            du duVar = this.a;
            if (!duVar.d || !Objects.equals(duVar.b[duVar.h], value)) {
                return false;
            }
            this.a.v();
            return true;
        }
        du duVar2 = this.a;
        long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
        long[] jArr = duVar2.a;
        int i = ((int) jG) & duVar2.c;
        long j = jArr[i];
        if (j == 0) {
            return false;
        }
        if (j == jLongValue) {
            if (!Objects.equals(duVar2.b[i], value)) {
                return false;
            }
            this.a.u(i);
            return true;
        }
        while (true) {
            du duVar3 = this.a;
            i = (i + 1) & duVar3.c;
            long j2 = jArr[i];
            if (j2 == 0) {
                return false;
            }
            if (j2 == jLongValue && Objects.equals(duVar3.b[i], value)) {
                this.a.u(i);
                return true;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return j();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return k();
    }
}
