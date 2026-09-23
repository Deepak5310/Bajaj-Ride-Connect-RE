package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bd extends u implements hd {
    final /* synthetic */ bi a;

    public bd(bi biVar) {
        this.a = biVar;
    }

    public final gi a() {
        return new ay(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new aw(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new ax(this.a);
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
        if (entry.getValue() != null && (entry.getValue() instanceof Float)) {
            Object key = entry.getKey();
            float fFloatValue = ((Float) entry.getValue()).floatValue();
            if (key == null) {
                bi biVar = this.a;
                return biVar.d && Float.floatToIntBits(biVar.b[biVar.e]) == Float.floatToIntBits(fFloatValue);
            }
            Object[] objArr = this.a.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (key.equals(obj3)) {
                return Float.floatToIntBits(this.a.b[iE]) == Float.floatToIntBits(fFloatValue);
            }
            do {
                iE = (iE + 1) & this.a.c;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (!key.equals(obj2));
            if (Float.floatToIntBits(this.a.b[iE]) == Float.floatToIntBits(fFloatValue)) {
                return true;
            }
        }
        return false;
    }

    public final void d(Consumer consumer) {
        bi biVar = this.a;
        bc bcVar = new bc(biVar);
        if (biVar.d) {
            bcVar.a = biVar.e;
            consumer.accept(bcVar);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            if (this.a.a[i] != null) {
                bcVar.a = i;
                consumer.accept(bcVar);
            }
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        bi biVar = this.a;
        if (biVar.d) {
            consumer.accept(new bc(biVar, biVar.e));
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            bi biVar2 = this.a;
            if (biVar2.a[i] != null) {
                consumer.accept(new bc(biVar2, i));
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry.getValue() == null || !(entry.getValue() instanceof Float)) {
            return false;
        }
        Object key = entry.getKey();
        float fFloatValue = ((Float) entry.getValue()).floatValue();
        if (key == null) {
            bi biVar = this.a;
            if (!biVar.d || Float.floatToIntBits(biVar.b[biVar.e]) != Float.floatToIntBits(fFloatValue)) {
                return false;
            }
            biVar.r();
            return true;
        }
        Object[] objArr = this.a.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(key.hashCode()) & this.a.c;
        Object obj2 = objArr[iE];
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(key)) {
            bi biVar2 = this.a;
            if (Float.floatToIntBits(biVar2.b[iE]) != Float.floatToIntBits(fFloatValue)) {
                return false;
            }
            biVar2.q(iE);
            return true;
        }
        while (true) {
            iE = (iE + 1) & this.a.c;
            Object obj3 = objArr[iE];
            if (obj3 == null) {
                return false;
            }
            if (obj3.equals(key)) {
                bi biVar3 = this.a;
                if (Float.floatToIntBits(biVar3.b[iE]) == Float.floatToIntBits(fFloatValue)) {
                    biVar3.q(iE);
                    return true;
                }
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
