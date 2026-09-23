package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hd;
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
public abstract class b extends a implements Serializable, aa {
    private static final long serialVersionUID = -4940583368468432370L;

    protected b() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agg.u
    public final /* synthetic */ Integer c(Object obj) {
        return t.a(this, obj);
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        z.b(this, obj, biFunction);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        z.c(this, obj, function);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        z.d(this, obj, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return t.d(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return p(((Integer) obj).intValue());
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agg.u
    public boolean d(int i) {
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
    public ez keySet() {
        throw null;
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        hd hdVarT = t();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agg.x
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ak akVar = (ak) obj;
                biConsumer.accept(Integer.valueOf(akVar.a()), Integer.valueOf(akVar.b()));
            }
        };
        if (hdVarT instanceof al) {
            ((al) hdVarT).d(consumer);
        } else {
            hdVarT.forEach(consumer);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ hd g() {
        return z.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        q();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer h(Integer num, BiFunction biFunction) {
        z.l();
        return null;
    }

    public int hashCode() {
        gi giVarA = ac.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((ak) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer i(Integer num, Function function) {
        z.m();
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer j(Integer num, BiFunction biFunction) {
        z.n();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer k(Integer num, Integer num2, BiFunction biFunction) {
        z.o();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer l(Integer num, Integer num2) {
        return t.b(this, num, num2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer m(Integer num, Integer num2) {
        z.p();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        z.f(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer n(Object obj) {
        return t.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer o(Integer num, Integer num2) {
        z.r();
        return null;
    }

    public boolean p(int i) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return l((Integer) obj, (Integer) obj2);
    }

    public void putAll(Map map) {
        if (map instanceof aa) {
            gi giVarA = ac.a((aa) map);
            while (giVarA.hasNext()) {
                ak akVar = (ak) giVarA.next();
                a(akVar.a(), akVar.b());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            t.b(this, (Integer) entry.getKey(), (Integer) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        z.h(this, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer q() {
        y.a();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ void r(Integer num, Integer num2, Integer num3) {
        z.s();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return n(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        z.q();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        z.j(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        r((Integer) obj, (Integer) obj2, (Integer) obj3);
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = ac.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            ak akVar = (ak) giVarA.next();
            sb.append(String.valueOf(akVar.a()));
            sb.append("=>");
            sb.append(String.valueOf(akVar.b()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
