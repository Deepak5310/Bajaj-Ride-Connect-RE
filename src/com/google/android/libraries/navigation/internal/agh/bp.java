package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bp extends com.google.android.libraries.navigation.internal.agi.u implements bd {
    final /* synthetic */ bu a;

    public bp(bu buVar) {
        this.a = buVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bd
    public final com.google.android.libraries.navigation.internal.agi.gi a() {
        return new bk(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new bi(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new bj(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        bu buVar;
        long j;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() != null && (entry.getKey() instanceof Long) && entry.getValue() != null && (entry.getValue() instanceof Integer)) {
            long jLongValue = ((Long) entry.getKey()).longValue();
            int iIntValue = ((Integer) entry.getValue()).intValue();
            if (jLongValue == 0) {
                bu buVar2 = this.a;
                return buVar2.d && buVar2.b[buVar2.e] == iIntValue;
            }
            bu buVar3 = this.a;
            long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
            long[] jArr = buVar3.a;
            int i = ((int) jG) & buVar3.c;
            long j2 = jArr[i];
            if (j2 == 0) {
                return false;
            }
            if (jLongValue == j2) {
                return buVar3.b[i] == iIntValue;
            }
            do {
                buVar = this.a;
                i = (i + 1) & buVar.c;
                j = jArr[i];
                if (j == 0) {
                    return false;
                }
            } while (jLongValue != j);
            if (buVar.b[i] == iIntValue) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bd
    public final void d(Consumer consumer) {
        bu buVar = this.a;
        bo boVar = new bo(buVar);
        if (buVar.d) {
            boVar.a = buVar.e;
            consumer.accept(boVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != 0) {
                boVar.a = i;
                consumer.accept(boVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        bu buVar = this.a;
        if (buVar.d) {
            consumer.accept(new bo(buVar, buVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            bu buVar2 = this.a;
            if (buVar2.a[i] != 0) {
                consumer.accept(new bo(buVar2, i));
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Long) || entry.getValue() == null || !(entry.getValue() instanceof Integer)) {
            return false;
        }
        long jLongValue = ((Long) entry.getKey()).longValue();
        int iIntValue = ((Integer) entry.getValue()).intValue();
        if (jLongValue == 0) {
            bu buVar = this.a;
            if (!buVar.d || buVar.b[buVar.e] != iIntValue) {
                return false;
            }
            buVar.w();
            return true;
        }
        bu buVar2 = this.a;
        long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
        long[] jArr = buVar2.a;
        int i = ((int) jG) & buVar2.c;
        long j = jArr[i];
        if (j == 0) {
            return false;
        }
        if (j == jLongValue) {
            if (buVar2.b[i] != iIntValue) {
                return false;
            }
            buVar2.v(i);
            return true;
        }
        while (true) {
            bu buVar3 = this.a;
            i = (i + 1) & buVar3.c;
            long j2 = jArr[i];
            if (j2 == 0) {
                return false;
            }
            if (j2 == jLongValue && buVar3.b[i] == iIntValue) {
                buVar3.v(i);
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
