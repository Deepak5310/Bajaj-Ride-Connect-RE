package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class il extends u implements hz {
    final /* synthetic */ iq a;

    public il(iq iqVar) {
        this.a = iqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hz
    public final gi a() {
        return new ig(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new ie(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new Cif(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        iq iqVar;
        Object obj2;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getValue() != null && (entry.getValue() instanceof Integer)) {
            Object key = entry.getKey();
            int iIntValue = ((Integer) entry.getValue()).intValue();
            if (key == null) {
                iq iqVar2 = this.a;
                return iqVar2.d && iqVar2.b[iqVar2.e] == iIntValue;
            }
            iq iqVar3 = this.a;
            Object[] objArr = iqVar3.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(key)) & iqVar3.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (key == obj3) {
                return iqVar3.b[iE] == iIntValue;
            }
            do {
                iqVar = this.a;
                iE = (iE + 1) & iqVar.c;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (key != obj2);
            if (iqVar.b[iE] == iIntValue) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hz
    public final void d(Consumer consumer) {
        iq iqVar = this.a;
        ik ikVar = new ik(iqVar);
        if (iqVar.d) {
            ikVar.a = iqVar.e;
            consumer.accept(ikVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != null) {
                ikVar.a = i;
                consumer.accept(ikVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        iq iqVar = this.a;
        if (iqVar.d) {
            consumer.accept(new ik(iqVar, iqVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            iq iqVar2 = this.a;
            if (iqVar2.a[i] != null) {
                consumer.accept(new ik(iqVar2, i));
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
            iq iqVar = this.a;
            if (!iqVar.d || iqVar.b[iqVar.e] != iIntValue) {
                return false;
            }
            iqVar.s();
            return true;
        }
        iq iqVar2 = this.a;
        Object[] objArr = iqVar2.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(key)) & iqVar2.c;
        Object obj2 = objArr[iE];
        if (obj2 == null) {
            return false;
        }
        if (obj2 == key) {
            if (iqVar2.b[iE] != iIntValue) {
                return false;
            }
            iqVar2.r(iE);
            return true;
        }
        while (true) {
            iq iqVar3 = this.a;
            iE = (iE + 1) & iqVar3.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (obj3 == key && iqVar3.b[iE] == iIntValue) {
                iqVar3.r(iE);
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
