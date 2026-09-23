package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ji extends u implements hd {
    final /* synthetic */ jn a;

    public ji(jn jnVar) {
        this.a = jnVar;
    }

    public final gi a() {
        return new jd(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new jb(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new jc(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        jn jnVar;
        Object obj2;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (key == null) {
            jn jnVar2 = this.a;
            return jnVar2.d && Objects.equals(jnVar2.b[jnVar2.e], value);
        }
        jn jnVar3 = this.a;
        Object[] objArr = jnVar3.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(key)) & jnVar3.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (key == obj3) {
            return Objects.equals(jnVar3.b[iE], value);
        }
        do {
            jnVar = this.a;
            iE = (iE + 1) & jnVar.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return false;
            }
        } while (key != obj2);
        return Objects.equals(jnVar.b[iE], value);
    }

    public final void d(Consumer consumer) {
        jn jnVar = this.a;
        jh jhVar = new jh(jnVar);
        if (jnVar.d) {
            jhVar.a = jnVar.e;
            consumer.accept(jhVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != null) {
                jhVar.a = i;
                consumer.accept(jhVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        jn jnVar = this.a;
        if (jnVar.d) {
            consumer.accept(new jh(jnVar, jnVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            jn jnVar2 = this.a;
            if (jnVar2.a[i] != null) {
                consumer.accept(new jh(jnVar2, i));
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
            jn jnVar = this.a;
            if (!jnVar.d || !Objects.equals(jnVar.b[jnVar.e], value)) {
                return false;
            }
            this.a.h();
            return true;
        }
        jn jnVar2 = this.a;
        Object[] objArr = jnVar2.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(key)) & jnVar2.c;
        Object obj2 = objArr[iE];
        if (obj2 == null) {
            return false;
        }
        if (obj2 == key) {
            if (!Objects.equals(jnVar2.b[iE], value)) {
                return false;
            }
            this.a.g(iE);
            return true;
        }
        while (true) {
            jn jnVar3 = this.a;
            iE = (iE + 1) & jnVar3.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (obj3 == key && Objects.equals(jnVar3.b[iE], value)) {
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
