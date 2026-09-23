package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hd;
import com.google.android.libraries.navigation.internal.agi.hj;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ct extends com.google.android.libraries.navigation.internal.agi.u implements hd {
    final /* synthetic */ cy a;

    public ct(cy cyVar) {
        this.a = cyVar;
    }

    public final gi a() {
        return new co(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new cm(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new cn(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        cy cyVar;
        int i;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() != null && (entry.getKey() instanceof Integer)) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            Object value = entry.getValue();
            if (iIntValue == 0) {
                cy cyVar2 = this.a;
                return cyVar2.d && cyVar2.b[cyVar2.e] == value;
            }
            cy cyVar3 = this.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(iIntValue);
            int[] iArr = cyVar3.a;
            int i2 = iE & cyVar3.c;
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            if (iIntValue == i3) {
                return cyVar3.b[i2] == value;
            }
            do {
                cyVar = this.a;
                i2 = (i2 + 1) & cyVar.c;
                i = iArr[i2];
                if (i == 0) {
                    return false;
                }
            } while (iIntValue != i);
            if (cyVar.b[i2] == value) {
                return true;
            }
        }
        return false;
    }

    public final void d(Consumer consumer) {
        cy cyVar = this.a;
        cs csVar = new cs(cyVar);
        if (cyVar.d) {
            csVar.a = cyVar.e;
            consumer.accept(csVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != 0) {
                csVar.a = i;
                consumer.accept(csVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        cy cyVar = this.a;
        if (cyVar.d) {
            consumer.accept(new cs(cyVar, cyVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            cy cyVar2 = this.a;
            if (cyVar2.a[i] != 0) {
                consumer.accept(new cs(cyVar2, i));
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
            cy cyVar = this.a;
            if (!cyVar.d || cyVar.b[cyVar.e] != value) {
                return false;
            }
            cyVar.m();
            return true;
        }
        cy cyVar2 = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(iIntValue);
        int[] iArr = cyVar2.a;
        int i = iE & cyVar2.c;
        int i2 = iArr[i];
        if (i2 == 0) {
            return false;
        }
        if (i2 == iIntValue) {
            if (cyVar2.b[i] != value) {
                return false;
            }
            cyVar2.l(i);
            return true;
        }
        while (true) {
            cy cyVar3 = this.a;
            i = (i + 1) & cyVar3.c;
            int i3 = iArr[i];
            if (i3 == 0) {
                return false;
            }
            if (i3 == iIntValue && cyVar3.b[i] == value) {
                cyVar3.l(i);
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
