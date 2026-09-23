package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g extends f implements Serializable, ce {
    private static final long serialVersionUID = -4940583368468432370L;

    protected g() {
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        cd.b(this, obj, biFunction);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        cd.c(this, obj, function);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        cd.d(this, obj, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return bw.d(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean containsValue(Object obj) {
        return cd.m(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final /* synthetic */ Long d(Object obj) {
        return bw.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public boolean e(long j) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return h();
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
        return u().containsAll(map.entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public gf values() {
        throw null;
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(BiConsumer biConsumer) {
        cd.l(this, biConsumer);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public he keySet() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        l(obj, (Long) obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd h() {
        return cd.a(this);
    }

    public int hashCode() {
        com.google.android.libraries.navigation.internal.agi.gi giVarA = ch.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((cp) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long i(Long l, BiFunction biFunction) {
        cd.n();
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long j(Long l, Function function) {
        cd.o();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long k(Long l, BiFunction biFunction) {
        cd.p();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long l(Object obj, Long l) {
        cd.q();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long m(Long l, Long l2, BiFunction biFunction) {
        cd.r();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        cd.f(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long n(Long l, Long l2) {
        return bw.b(this, l, l2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long o(Long l, Long l2) {
        cd.s();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long p(Object obj) {
        return bw.c(this, obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return n((Long) obj, (Long) obj2);
    }

    public void putAll(Map map) {
        if (map instanceof ce) {
            com.google.android.libraries.navigation.internal.agi.gi giVarA = ch.a((ce) map);
            while (giVarA.hasNext()) {
                cp cpVar = (cp) giVarA.next();
                b(cpVar.a(), cpVar.b());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            bw.b(this, (Long) entry.getKey(), (Long) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        cd.h(this, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long q(Long l, Long l2) {
        cd.u();
        return null;
    }

    public boolean r(long j) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return p(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        cd.t();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        cd.j(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        s((Long) obj, (Long) obj2, (Long) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ boolean s(Long l, Long l2, Long l3) {
        cd.v();
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        com.google.android.libraries.navigation.internal.agi.gi giVarA = ch.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            cp cpVar = (cp) giVarA.next();
            sb.append(String.valueOf(cpVar.a()));
            sb.append("=>");
            sb.append(String.valueOf(cpVar.b()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
