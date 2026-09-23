package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hd;
import com.google.android.libraries.navigation.internal.agi.hj;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class al extends com.google.android.libraries.navigation.internal.agi.u implements hd {
    final /* synthetic */ aq a;

    public al(aq aqVar) {
        this.a = aqVar;
    }

    public final gi a() {
        return new ag(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new ae(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new af(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        aq aqVar;
        int i;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() != null && (entry.getKey() instanceof Integer) && entry.getValue() != null && (entry.getValue() instanceof Integer)) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if (iIntValue == 0) {
                aq aqVar2 = this.a;
                return aqVar2.d && aqVar2.b[aqVar2.e] == iIntValue2;
            }
            aq aqVar3 = this.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(iIntValue);
            int[] iArr = aqVar3.a;
            int i2 = iE & aqVar3.c;
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            if (iIntValue == i3) {
                return aqVar3.b[i2] == iIntValue2;
            }
            do {
                aqVar = this.a;
                i2 = (i2 + 1) & aqVar.c;
                i = iArr[i2];
                if (i == 0) {
                    return false;
                }
            } while (iIntValue != i);
            if (aqVar.b[i2] == iIntValue2) {
                return true;
            }
        }
        return false;
    }

    public final void d(Consumer consumer) {
        aq aqVar = this.a;
        ak akVar = new ak(aqVar);
        if (aqVar.d) {
            akVar.a = aqVar.e;
            consumer.accept(akVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != 0) {
                akVar.a = i;
                consumer.accept(akVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        aq aqVar = this.a;
        if (aqVar.d) {
            consumer.accept(new ak(aqVar, aqVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            aq aqVar2 = this.a;
            if (aqVar2.a[i] != 0) {
                consumer.accept(new ak(aqVar2, i));
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Integer) || entry.getValue() == null || !(entry.getValue() instanceof Integer)) {
            return false;
        }
        int iIntValue = ((Integer) entry.getKey()).intValue();
        int iIntValue2 = ((Integer) entry.getValue()).intValue();
        if (iIntValue == 0) {
            aq aqVar = this.a;
            if (!aqVar.d || aqVar.b[aqVar.e] != iIntValue2) {
                return false;
            }
            aqVar.w();
            return true;
        }
        aq aqVar2 = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(iIntValue);
        int[] iArr = aqVar2.a;
        int i = iE & aqVar2.c;
        int i2 = iArr[i];
        if (i2 == 0) {
            return false;
        }
        if (i2 == iIntValue) {
            if (aqVar2.b[i] != iIntValue2) {
                return false;
            }
            aqVar2.v(i);
            return true;
        }
        while (true) {
            aq aqVar3 = this.a;
            i = (i + 1) & aqVar3.c;
            int i3 = iArr[i];
            if (i3 == 0) {
                return false;
            }
            if (i3 == iIntValue && aqVar3.b[i] == iIntValue2) {
                aqVar3.v(i);
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
