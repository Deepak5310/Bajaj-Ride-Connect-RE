package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dp extends u implements dd {
    final /* synthetic */ du a;

    public dp(du duVar) {
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dd
    public final gi a() {
        return new dk(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new di(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new dj(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object obj2;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getValue() != null && (entry.getValue() instanceof Long)) {
            Object key = entry.getKey();
            long jLongValue = ((Long) entry.getValue()).longValue();
            if (key == null) {
                du duVar = this.a;
                return duVar.e && duVar.c[duVar.f] == jLongValue;
            }
            Object[] objArr = this.a.b;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.d;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (key.equals(obj3)) {
                return this.a.c[iE] == jLongValue;
            }
            do {
                iE = (iE + 1) & this.a.d;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (!key.equals(obj2));
            if (this.a.c[iE] == jLongValue) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dd
    public final void d(Consumer consumer) {
        du duVar = this.a;
        Cdo cdo = new Cdo(duVar);
        if (duVar.e) {
            cdo.a = duVar.f;
            consumer.accept(cdo);
        }
        int i = this.a.f;
        while (i != 0) {
            i--;
            if (this.a.b[i] != null) {
                cdo.a = i;
                consumer.accept(cdo);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        du duVar = this.a;
        if (duVar.e) {
            consumer.accept(new Cdo(duVar, duVar.f));
        }
        int i = this.a.f;
        while (i != 0) {
            i--;
            du duVar2 = this.a;
            if (duVar2.b[i] != null) {
                consumer.accept(new Cdo(duVar2, i));
            }
        }
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
        if (key == null) {
            du duVar = this.a;
            if (!duVar.e || duVar.c[duVar.f] != jLongValue) {
                return false;
            }
            duVar.s();
            return true;
        }
        Object[] objArr = this.a.b;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.d;
        Object obj2 = objArr[iE];
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(key)) {
            du duVar2 = this.a;
            if (duVar2.c[iE] != jLongValue) {
                return false;
            }
            duVar2.r(iE);
            return true;
        }
        while (true) {
            iE = (iE + 1) & this.a.d;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (obj3.equals(key)) {
                du duVar3 = this.a;
                if (duVar3.c[iE] == jLongValue) {
                    duVar3.r(iE);
                    return true;
                }
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
