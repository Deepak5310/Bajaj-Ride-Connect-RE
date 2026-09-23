package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hj;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bu extends com.google.android.libraries.navigation.internal.agi.u implements bi {
    final /* synthetic */ bz a;

    public bu(bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new bn(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new bo(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        bz bzVar;
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
            bz bzVar2 = this.a;
            return bzVar2.d && Objects.equals(bzVar2.b[bzVar2.e], value);
        }
        bz bzVar3 = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(iIntValue);
        int[] iArr = bzVar3.a;
        int i2 = iE & bzVar3.c;
        int i3 = iArr[i2];
        if (i3 == 0) {
            return false;
        }
        if (iIntValue == i3) {
            return Objects.equals(bzVar3.b[i2], value);
        }
        do {
            bzVar = this.a;
            i2 = (i2 + 1) & bzVar.c;
            i = iArr[i2];
            if (i == 0) {
                return false;
            }
        } while (iIntValue != i);
        return Objects.equals(bzVar.b[i2], value);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bi
    public final gi d() {
        return new bp(this.a);
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        bz bzVar = this.a;
        if (bzVar.d) {
            consumer.accept(new bt(bzVar, bzVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            bz bzVar2 = this.a;
            if (bzVar2.a[i] != 0) {
                consumer.accept(new bt(bzVar2, i));
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bi
    public final void h(Consumer consumer) {
        bz bzVar = this.a;
        bt btVar = new bt(bzVar);
        if (bzVar.d) {
            btVar.a = bzVar.e;
            consumer.accept(btVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != 0) {
                btVar.a = i;
                consumer.accept(btVar);
            }
        }
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
            bz bzVar = this.a;
            if (!bzVar.d || !Objects.equals(bzVar.b[bzVar.e], value)) {
                return false;
            }
            this.a.m();
            return true;
        }
        bz bzVar2 = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(iIntValue);
        int[] iArr = bzVar2.a;
        int i = iE & bzVar2.c;
        int i2 = iArr[i];
        if (i2 == 0) {
            return false;
        }
        if (i2 == iIntValue) {
            if (!Objects.equals(bzVar2.b[i], value)) {
                return false;
            }
            this.a.k(i);
            return true;
        }
        while (true) {
            bz bzVar3 = this.a;
            i = (i + 1) & bzVar3.c;
            int i3 = iArr[i];
            if (i3 == 0) {
                return false;
            }
            if (i3 == iIntValue && Objects.equals(bzVar3.b[i], value)) {
                this.a.k(i);
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
