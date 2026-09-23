package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cq extends com.google.android.libraries.navigation.internal.agi.u implements com.google.android.libraries.navigation.internal.agi.hd {
    final /* synthetic */ cv a;

    public cq(cv cvVar) {
        this.a = cvVar;
    }

    public final com.google.android.libraries.navigation.internal.agi.gi a() {
        return new cl(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new cj(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new ck(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        cv cvVar;
        long j;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() != null && (entry.getKey() instanceof Long) && entry.getValue() != null && (entry.getValue() instanceof Long)) {
            long jLongValue = ((Long) entry.getKey()).longValue();
            long jLongValue2 = ((Long) entry.getValue()).longValue();
            if (jLongValue == 0) {
                cv cvVar2 = this.a;
                return cvVar2.e && cvVar2.c[cvVar2.f] == jLongValue2;
            }
            cv cvVar3 = this.a;
            long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
            long[] jArr = cvVar3.b;
            int i = ((int) jG) & cvVar3.d;
            long j2 = jArr[i];
            if (j2 == 0) {
                return false;
            }
            if (jLongValue == j2) {
                return cvVar3.c[i] == jLongValue2;
            }
            do {
                cvVar = this.a;
                i = (i + 1) & cvVar.d;
                j = jArr[i];
                if (j == 0) {
                    return false;
                }
            } while (jLongValue != j);
            if (cvVar.c[i] == jLongValue2) {
                return true;
            }
        }
        return false;
    }

    public final void d(Consumer consumer) {
        cv cvVar = this.a;
        cp cpVar = new cp(cvVar);
        if (cvVar.e) {
            cpVar.a = cvVar.f;
            consumer.accept(cpVar);
        }
        int i = this.a.f;
        while (i != 0) {
            i--;
            if (this.a.b[i] != 0) {
                cpVar.a = i;
                consumer.accept(cpVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        cv cvVar = this.a;
        if (cvVar.e) {
            consumer.accept(new cp(cvVar, cvVar.f));
        }
        int i = this.a.f;
        while (i != 0) {
            i--;
            cv cvVar2 = this.a;
            if (cvVar2.b[i] != 0) {
                consumer.accept(new cp(cvVar2, i));
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Long) || entry.getValue() == null || !(entry.getValue() instanceof Long)) {
            return false;
        }
        long jLongValue = ((Long) entry.getKey()).longValue();
        long jLongValue2 = ((Long) entry.getValue()).longValue();
        if (jLongValue == 0) {
            cv cvVar = this.a;
            if (!cvVar.e || cvVar.c[cvVar.f] != jLongValue2) {
                return false;
            }
            cvVar.x();
            return true;
        }
        cv cvVar2 = this.a;
        long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
        long[] jArr = cvVar2.b;
        int i = ((int) jG) & cvVar2.d;
        long j = jArr[i];
        if (j == 0) {
            return false;
        }
        if (j == jLongValue) {
            if (cvVar2.c[i] != jLongValue2) {
                return false;
            }
            cvVar2.w(i);
            return true;
        }
        while (true) {
            cv cvVar3 = this.a;
            i = (i + 1) & cvVar3.d;
            long j2 = jArr[i];
            if (j2 == 0) {
                return false;
            }
            if (j2 == jLongValue && cvVar3.c[i] == jLongValue2) {
                cvVar3.w(i);
                return true;
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
