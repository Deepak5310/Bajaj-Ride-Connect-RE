package com.google.android.libraries.navigation.internal.agi;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dy extends u implements ex {
    final /* synthetic */ ef a;

    public dy(ef efVar) {
        this.a = efVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ex
    public final gi aU() {
        return new dw(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new dv(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new dx(this, 0, this.a.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        return this.a.containsKey(key) && Objects.equals(this.a.get(key), entry.getValue());
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ex
    public final void d(Consumer consumer) {
        j jVar = new j();
        int i = this.a.c;
        for (int i2 = 0; i2 < i; i2++) {
            ef efVar = this.a;
            jVar.a = efVar.a[i2];
            jVar.b = efVar.b[i2];
            consumer.accept(jVar);
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        int i = this.a.c;
        for (int i2 = 0; i2 < i; i2++) {
            ef efVar = this.a;
            consumer.accept(new j(efVar.a[i2], efVar.b[i2]));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new dv(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        int iE = this.a.e(key);
        if (iE == -1 || !Objects.equals(value, this.a.b[iE])) {
            return false;
        }
        ef efVar = this.a;
        int i = (efVar.c - iE) - 1;
        int i2 = iE + 1;
        Object[] objArr = efVar.a;
        System.arraycopy(objArr, i2, objArr, iE, i);
        Object[] objArr2 = this.a.b;
        System.arraycopy(objArr2, i2, objArr2, iE, i);
        ef efVar2 = this.a;
        int i3 = efVar2.c - 1;
        efVar2.c = i3;
        efVar2.a[i3] = null;
        efVar2.b[i3] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
