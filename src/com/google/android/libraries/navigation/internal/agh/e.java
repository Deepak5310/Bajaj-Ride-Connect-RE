package com.google.android.libraries.navigation.internal.agh;

import com.google.android.libraries.navigation.internal.agg.Cdo;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e extends d implements Serializable, be {
    private static final long serialVersionUID = -4940583368468432370L;

    protected e() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agh.ax
    public final /* synthetic */ Integer c(Object obj) {
        return aw.a(this, obj);
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        bc.b(this, obj, biFunction);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        bc.c(this, obj, function);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        bc.d(this, obj, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return aw.d(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return p(((Integer) obj).intValue());
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agh.ax
    public boolean d(long j) {
        throw null;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Cdo values() {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return g();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        return t().containsAll(map.entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public he keySet() {
        throw null;
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        com.google.android.libraries.navigation.internal.agi.hd hdVarT = t();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agh.ba
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                bo boVar = (bo) obj;
                biConsumer.accept(Long.valueOf(boVar.b()), Integer.valueOf(boVar.a()));
            }
        };
        if (hdVarT instanceof bd) {
            ((bd) hdVarT).d(consumer);
        } else {
            hdVarT.forEach(consumer);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd g() {
        return bc.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        q();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer h(Long l, BiFunction biFunction) {
        bc.l();
        return null;
    }

    public int hashCode() {
        com.google.android.libraries.navigation.internal.agi.gi giVarA = bg.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((bo) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer i(Long l, Function function) {
        bc.m();
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer j(Long l, BiFunction biFunction) {
        bc.n();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer k(Long l, Integer num, BiFunction biFunction) {
        bc.o();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer l(Long l, Integer num) {
        return aw.b(this, l, num);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer m(Long l, Integer num) {
        bc.p();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        bc.f(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer n(Object obj) {
        return aw.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer o(Long l, Integer num) {
        bc.r();
        return null;
    }

    public boolean p(int i) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return l((Long) obj, (Integer) obj2);
    }

    public void putAll(Map map) {
        if (map instanceof be) {
            com.google.android.libraries.navigation.internal.agi.gi giVarA = bg.a((be) map);
            while (giVarA.hasNext()) {
                bo boVar = (bo) giVarA.next();
                a(boVar.b(), boVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            aw.b(this, (Long) entry.getKey(), (Integer) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        bc.h(this, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer q() {
        bb.a();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ void r(Long l, Integer num, Integer num2) {
        bc.s();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return n(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        bc.q();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        bc.j(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        r((Long) obj, (Integer) obj2, (Integer) obj3);
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        com.google.android.libraries.navigation.internal.agi.gi giVarA = bg.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            bo boVar = (bo) giVarA.next();
            sb.append(String.valueOf(boVar.b()));
            sb.append("=>");
            sb.append(String.valueOf(boVar.a()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
