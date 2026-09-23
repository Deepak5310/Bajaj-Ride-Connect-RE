package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fk extends com.google.android.libraries.navigation.internal.agi.u implements com.google.android.libraries.navigation.internal.agi.hd {
    final /* synthetic */ fp a;

    public fk(fp fpVar) {
        this.a = fpVar;
    }

    public final com.google.android.libraries.navigation.internal.agi.gi a() {
        return new ff(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new fd(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new fe(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        fp fpVar;
        long j;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() != null && (entry.getKey() instanceof Long)) {
            long jLongValue = ((Long) entry.getKey()).longValue();
            Object value = entry.getValue();
            if (jLongValue == 0) {
                fp fpVar2 = this.a;
                return fpVar2.d && fpVar2.b[fpVar2.e] == value;
            }
            fp fpVar3 = this.a;
            long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
            long[] jArr = fpVar3.a;
            int i = ((int) jG) & fpVar3.c;
            long j2 = jArr[i];
            if (j2 == 0) {
                return false;
            }
            if (jLongValue == j2) {
                return fpVar3.b[i] == value;
            }
            do {
                fpVar = this.a;
                i = (i + 1) & fpVar.c;
                j = jArr[i];
                if (j == 0) {
                    return false;
                }
            } while (jLongValue != j);
            if (fpVar.b[i] == value) {
                return true;
            }
        }
        return false;
    }

    public final void d(Consumer consumer) {
        fp fpVar = this.a;
        fj fjVar = new fj(fpVar);
        if (fpVar.d) {
            fjVar.a = fpVar.e;
            consumer.accept(fjVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != 0) {
                fjVar.a = i;
                consumer.accept(fjVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        fp fpVar = this.a;
        if (fpVar.d) {
            consumer.accept(new fj(fpVar, fpVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            fp fpVar2 = this.a;
            if (fpVar2.a[i] != 0) {
                consumer.accept(new fj(fpVar2, i));
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getKey() == null || !(entry.getKey() instanceof Long)) {
            return false;
        }
        long jLongValue = ((Long) entry.getKey()).longValue();
        Object value = entry.getValue();
        if (jLongValue == 0) {
            fp fpVar = this.a;
            if (!fpVar.d || fpVar.b[fpVar.e] != value) {
                return false;
            }
            fpVar.m();
            return true;
        }
        fp fpVar2 = this.a;
        long jG = com.google.android.libraries.navigation.internal.agc.e.g(jLongValue);
        long[] jArr = fpVar2.a;
        int i = ((int) jG) & fpVar2.c;
        long j = jArr[i];
        if (j == 0) {
            return false;
        }
        if (j == jLongValue) {
            if (fpVar2.b[i] != value) {
                return false;
            }
            fpVar2.l(i);
            return true;
        }
        while (true) {
            fp fpVar3 = this.a;
            i = (i + 1) & fpVar3.c;
            long j2 = jArr[i];
            if (j2 == 0) {
                return false;
            }
            if (j2 == jLongValue && fpVar3.b[i] == value) {
                fpVar3.l(i);
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
