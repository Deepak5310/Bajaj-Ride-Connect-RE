package com.google.android.libraries.navigation.internal.agi;

import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eq extends v implements fp {
    final /* synthetic */ et a;

    public eq(et etVar) {
        this.a = etVar;
    }

    public static final hi i() {
        throw new UnsupportedOperationException();
    }

    public static final hi j() {
        throw new UnsupportedOperationException();
    }

    public static final hi k() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a */
    public final ge listIterator() {
        return new el(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new hq(listIterator(), com.google.android.libraries.navigation.internal.agc.h.b(this.a), 81);
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
        Object obj2;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (key == null) {
            et etVar = this.a;
            return etVar.d && Objects.equals(etVar.b[etVar.h], value);
        }
        Object[] objArr = this.a.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (key.equals(obj3)) {
            return Objects.equals(this.a.b[iE], value);
        }
        do {
            iE = (iE + 1) & this.a.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return false;
            }
        } while (!key.equals(obj2));
        return Objects.equals(this.a.b[iE], value);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ex
    public final void d(Consumer consumer) {
        et etVar = this.a;
        ep epVar = new ep(etVar);
        int i = etVar.k;
        int i2 = etVar.e;
        while (i != 0) {
            i--;
            epVar.a = i2;
            i2 = (int) this.a.g[i2];
            consumer.accept(epVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hi
    /* JADX INFO: renamed from: e */
    public final /* bridge */ /* synthetic */ hi headSet(Object obj) {
        return i();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hi
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ hi subSet(Object obj, Object obj2) {
        return j();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object first() {
        et etVar = this.a;
        if (etVar.k != 0) {
            return new ep(etVar, etVar.e);
        }
        throw new NoSuchElementException();
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        et etVar = this.a;
        int i = etVar.k;
        int i2 = etVar.e;
        while (i != 0) {
            i--;
            et etVar2 = this.a;
            int i3 = (int) etVar2.g[i2];
            consumer.accept(new ep(etVar2, i2));
            i2 = i3;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hi
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ hi tailSet(Object obj) {
        return k();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ex
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final gw aU() {
        return new em(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return i();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object last() {
        et etVar = this.a;
        if (etVar.k != 0) {
            return new ep(etVar, etVar.f);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (key == null) {
            et etVar = this.a;
            if (!etVar.d || !Objects.equals(etVar.b[etVar.h], value)) {
                return false;
            }
            this.a.k();
            return true;
        }
        Object[] objArr = this.a.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.c;
        Object obj2 = objArr[iE];
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(key)) {
            if (!Objects.equals(this.a.b[iE], value)) {
                return false;
            }
            this.a.j(iE);
            return true;
        }
        while (true) {
            iE = (iE + 1) & this.a.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (obj3.equals(key) && Objects.equals(this.a.b[iE], value)) {
                this.a.j(iE);
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
