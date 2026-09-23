package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ce extends u implements hd {
    final /* synthetic */ cj a;

    public ce(cj cjVar) {
        this.a = cjVar;
    }

    public final gi a() {
        return new bz(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new bx(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new by(this.a);
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
        if (entry.getValue() != null && (entry.getValue() instanceof Integer)) {
            Object key = entry.getKey();
            int iIntValue = ((Integer) entry.getValue()).intValue();
            if (key == null) {
                cj cjVar = this.a;
                return cjVar.d && cjVar.b[cjVar.e] == iIntValue;
            }
            Object[] objArr = this.a.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (key.equals(obj3)) {
                return this.a.b[iE] == iIntValue;
            }
            do {
                iE = (iE + 1) & this.a.c;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (!key.equals(obj2));
            if (this.a.b[iE] == iIntValue) {
                return true;
            }
        }
        return false;
    }

    public final void d(Consumer consumer) {
        cj cjVar = this.a;
        cd cdVar = new cd(cjVar);
        if (cjVar.d) {
            cdVar.a = cjVar.e;
            consumer.accept(cdVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != null) {
                cdVar.a = i;
                consumer.accept(cdVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        cj cjVar = this.a;
        if (cjVar.d) {
            consumer.accept(new cd(cjVar, cjVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            cj cjVar2 = this.a;
            if (cjVar2.a[i] != null) {
                consumer.accept(new cd(cjVar2, i));
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getValue() == null || !(entry.getValue() instanceof Integer)) {
            return false;
        }
        Object key = entry.getKey();
        int iIntValue = ((Integer) entry.getValue()).intValue();
        if (key == null) {
            cj cjVar = this.a;
            if (!cjVar.d || cjVar.b[cjVar.e] != iIntValue) {
                return false;
            }
            cjVar.s();
            return true;
        }
        Object[] objArr = this.a.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.c;
        Object obj2 = objArr[iE];
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(key)) {
            cj cjVar2 = this.a;
            if (cjVar2.b[iE] != iIntValue) {
                return false;
            }
            cjVar2.r(iE);
            return true;
        }
        while (true) {
            iE = (iE + 1) & this.a.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (obj3.equals(key)) {
                cj cjVar3 = this.a;
                if (cjVar3.b[iE] == iIntValue) {
                    cjVar3.r(iE);
                    return true;
                }
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
