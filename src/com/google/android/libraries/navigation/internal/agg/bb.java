package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.ge;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hi;
import com.google.android.libraries.navigation.internal.agi.hj;
import com.google.android.libraries.navigation.internal.agi.hq;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb extends com.google.android.libraries.navigation.internal.agi.v implements ca {
    final /* synthetic */ be a;

    public bb(be beVar) {
        this.a = beVar;
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
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ge listIterator() {
        return new aw(this.a);
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
        be beVar;
        int i;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Integer)) {
            return false;
        }
        int iIntValue = ((Integer) entry.getKey()).intValue();
        Object value = entry.getValue();
        if (iIntValue == 0) {
            be beVar2 = this.a;
            return beVar2.d && Objects.equals(beVar2.b[beVar2.h], value);
        }
        be beVar3 = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(iIntValue);
        int[] iArr = beVar3.a;
        int i2 = iE & beVar3.c;
        int i3 = iArr[i2];
        if (i3 == 0) {
            return false;
        }
        if (iIntValue == i3) {
            return Objects.equals(beVar3.b[i2], value);
        }
        do {
            beVar = this.a;
            i2 = (i2 + 1) & beVar.c;
            i = iArr[i2];
            if (i == 0) {
                return false;
            }
        } while (iIntValue != i);
        return Objects.equals(beVar.b[i2], value);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bi
    public final /* bridge */ /* synthetic */ gi d() {
        return new ax(this.a);
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
        be beVar = this.a;
        if (beVar.k != 0) {
            return new ba(beVar, beVar.e);
        }
        throw new NoSuchElementException();
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        be beVar = this.a;
        int i = beVar.k;
        int i2 = beVar.e;
        while (i != 0) {
            i--;
            be beVar2 = this.a;
            int i3 = (int) beVar2.g[i2];
            consumer.accept(new ba(beVar2, i2));
            i2 = i3;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hi
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ hi tailSet(Object obj) {
        return k();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bi
    public final void h(Consumer consumer) {
        be beVar = this.a;
        ba baVar = new ba(beVar);
        int i = beVar.k;
        int i2 = beVar.e;
        while (i != 0) {
            i--;
            baVar.a = i2;
            i2 = (int) this.a.g[i2];
            consumer.accept(baVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return i();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object last() {
        be beVar = this.a;
        if (beVar.k != 0) {
            return new ba(beVar, beVar.f);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Integer)) {
            return false;
        }
        int iIntValue = ((Integer) entry.getKey()).intValue();
        Object value = entry.getValue();
        if (iIntValue == 0) {
            be beVar = this.a;
            if (!beVar.d || !Objects.equals(beVar.b[beVar.h], value)) {
                return false;
            }
            this.a.w();
            return true;
        }
        be beVar2 = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(iIntValue);
        int[] iArr = beVar2.a;
        int i = iE & beVar2.c;
        int i2 = iArr[i];
        if (i2 == 0) {
            return false;
        }
        if (i2 == iIntValue) {
            if (!Objects.equals(beVar2.b[i], value)) {
                return false;
            }
            this.a.v(i);
            return true;
        }
        while (true) {
            be beVar3 = this.a;
            i = (i + 1) & beVar3.c;
            int i3 = iArr[i];
            if (i3 == 0) {
                return false;
            }
            if (i3 == iIntValue && Objects.equals(beVar3.b[i], value)) {
                this.a.v(i);
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
