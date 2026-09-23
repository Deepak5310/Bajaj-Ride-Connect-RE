package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fj extends u implements ex {
    final /* synthetic */ fo a;

    public fj(fo foVar) {
        this.a = foVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ex
    public final gi aU() {
        return new fe(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new fc(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new fd(this.a);
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
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (key == null) {
            fo foVar = this.a;
            return foVar.d && Objects.equals(foVar.b[foVar.e], value);
        }
        Object[] objArr = this.a.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (key.equals(obj3)) {
            return Objects.equals(this.a.b[iE], value);
        }
        do {
            iE = (iE + 1) & this.a.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return false;
            }
        } while (!key.equals(obj2));
        return Objects.equals(this.a.b[iE], value);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ex
    public final void d(Consumer consumer) {
        fo foVar = this.a;
        fi fiVar = new fi(foVar);
        if (foVar.d) {
            fiVar.a = foVar.e;
            consumer.accept(fiVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != null) {
                fiVar.a = i;
                consumer.accept(fiVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        fo foVar = this.a;
        if (foVar.d) {
            consumer.accept(new fi(foVar, foVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            fo foVar2 = this.a;
            if (foVar2.a[i] != null) {
                consumer.accept(new fi(foVar2, i));
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
            fo foVar = this.a;
            if (!foVar.d || !Objects.equals(foVar.b[foVar.e], value)) {
                return false;
            }
            this.a.h();
            return true;
        }
        Object[] objArr = this.a.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.c;
        Object obj2 = objArr[iE];
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(key)) {
            if (!Objects.equals(this.a.b[iE], value)) {
                return false;
            }
            this.a.g(iE);
            return true;
        }
        while (true) {
            iE = (iE + 1) & this.a.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (obj3.equals(key) && Objects.equals(this.a.b[iE], value)) {
                this.a.g(iE);
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
