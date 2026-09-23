package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class kf extends u implements hd {
    final /* synthetic */ kk a;

    public kf(kk kkVar) {
        this.a = kkVar;
    }

    public final gi a() {
        return new ka(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new jy(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new jz(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        kk kkVar;
        Object obj2;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (key == null) {
            kk kkVar2 = this.a;
            return kkVar2.d && kkVar2.b[kkVar2.e] == value;
        }
        kk kkVar3 = this.a;
        Object[] objArr = kkVar3.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(key)) & kkVar3.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (key == obj3) {
            return kkVar3.b[iE] == value;
        }
        do {
            kkVar = this.a;
            iE = (iE + 1) & kkVar.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return false;
            }
        } while (key != obj2);
        return kkVar.b[iE] == value;
    }

    public final void d(Consumer consumer) {
        kk kkVar = this.a;
        ke keVar = new ke(kkVar);
        if (kkVar.d) {
            keVar.a = kkVar.e;
            consumer.accept(keVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != null) {
                keVar.a = i;
                consumer.accept(keVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        kk kkVar = this.a;
        if (kkVar.d) {
            consumer.accept(new ke(kkVar, kkVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            kk kkVar2 = this.a;
            if (kkVar2.a[i] != null) {
                consumer.accept(new ke(kkVar2, i));
            }
        }
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
            kk kkVar = this.a;
            if (!kkVar.d || kkVar.b[kkVar.e] != value) {
                return false;
            }
            kkVar.h();
            return true;
        }
        kk kkVar2 = this.a;
        Object[] objArr = kkVar2.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(key)) & kkVar2.c;
        Object obj2 = objArr[iE];
        if (obj2 == null) {
            return false;
        }
        if (obj2 == key) {
            if (kkVar2.b[iE] != value) {
                return false;
            }
            kkVar2.g(iE);
            return true;
        }
        while (true) {
            kk kkVar3 = this.a;
            iE = (iE + 1) & kkVar3.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (obj3 == key && kkVar3.b[iE] == value) {
                kkVar3.g(iE);
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
