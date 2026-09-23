package com.google.android.libraries.navigation.internal.agh;

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
public abstract class c extends a implements Serializable, as {
    private static final long serialVersionUID = -4940583368468432370L;

    protected c() {
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        aq.b(this, obj, biFunction);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        aq.c(this, obj, function);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        aq.d(this, obj, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return ak.d(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return q(((Double) obj).doubleValue());
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agh.al
    public final /* synthetic */ Double d(Object obj) {
        return ak.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agh.al
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
        return x().containsAll(map.entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.google.android.libraries.navigation.internal.age.k values() {
        throw null;
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        com.google.android.libraries.navigation.internal.agi.hd hdVarX = x();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agh.ao
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                b bVar = (b) obj;
                biConsumer.accept(Long.valueOf(bVar.b()), Double.valueOf(bVar.a()));
            }
        };
        if (hdVarX instanceof ar) {
            ((ar) hdVarX).d(consumer);
        } else {
            hdVarX.forEach(consumer);
        }
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public he keySet() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        r();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd h() {
        return aq.a(this);
    }

    @Override // java.util.Map
    public final int hashCode() {
        com.google.android.libraries.navigation.internal.agi.gi giVarA = au.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((b) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double i(Long l, BiFunction biFunction) {
        aq.l();
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double j(Long l, Function function) {
        aq.m();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double k(Long l, BiFunction biFunction) {
        aq.n();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double l(Long l, Double d, BiFunction biFunction) {
        aq.o();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double m(Long l, Double d) {
        return ak.b(this, l, d);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        aq.f(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double n(Long l, Double d) {
        aq.p();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double o(Object obj) {
        return ak.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double p(Long l, Double d) {
        aq.r();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return m((Long) obj, (Double) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        if (map instanceof as) {
            com.google.android.libraries.navigation.internal.agi.gi giVarA = au.a((as) map);
            while (giVarA.hasNext()) {
                b bVar = (b) giVarA.next();
                b(bVar.b(), bVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            ak.b(this, (Long) entry.getKey(), (Double) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        aq.h(this, obj, obj2);
        return null;
    }

    public boolean q(double d) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double r() {
        ap.a();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return o(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        aq.q();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        aq.j(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        s((Long) obj, (Double) obj2, (Double) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ void s(Long l, Double d, Double d2) {
        aq.s();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        com.google.android.libraries.navigation.internal.agi.gi giVarA = au.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            b bVar = (b) giVarA.next();
            sb.append(String.valueOf(bVar.b()));
            sb.append("=>");
            sb.append(String.valueOf(bVar.a()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
