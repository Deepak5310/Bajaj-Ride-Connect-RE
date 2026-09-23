package com.google.android.libraries.navigation.internal.agi;

import com.google.android.libraries.navigation.internal.agg.Cdo;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e extends c implements Serializable, bs {
    private static final long serialVersionUID = -4940583368468432370L;

    protected e() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agi.bk
    public final /* synthetic */ Integer c(Object obj) {
        return bj.a(this, obj);
    }

    public /* synthetic */ void clear() {
        bq.k();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public boolean containsKey(Object obj) {
        gi giVarListIterator = p().listIterator();
        while (giVarListIterator.hasNext()) {
            if (((br) giVarListIterator.next()).getKey() == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return m(((Integer) obj).intValue());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Cdo values() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ hd e() {
        return bq.a(this);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return e();
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
        return p().containsAll(map.entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public hd keySet() {
        throw null;
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(BiConsumer biConsumer) {
        bq.j(this, biConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer g(Object obj, Integer num) {
        bq.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return g(obj, (Integer) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer h(Object obj, Integer num, BiFunction biFunction) {
        bq.m();
        return null;
    }

    public int hashCode() {
        gi giVarA = bv.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((br) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer i(Object obj, Integer num) {
        return bj.b(this, obj, num);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer j(Object obj, Integer num) {
        bq.n();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer k(Object obj) {
        return bj.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer l(Object obj, Integer num) {
        bq.p();
        return null;
    }

    public boolean m(int i) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        bq.d(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ void n(Object obj, Integer num, Integer num2) {
        bq.q();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return i(obj, (Integer) obj2);
    }

    public void putAll(Map map) {
        if (map instanceof bs) {
            gi giVarA = bv.a((bs) map);
            while (giVarA.hasNext()) {
                br brVar = (br) giVarA.next();
                a(brVar.getKey(), brVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            bj.b(this, entry.getKey(), (Integer) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        bq.f(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return k(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        bq.o();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        bq.h(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        n(obj, (Integer) obj2, (Integer) obj3);
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = bv.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            br brVar = (br) giVarA.next();
            if (this == brVar.getKey()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(brVar.getKey()));
            }
            sb.append("=>");
            sb.append(String.valueOf(brVar.a()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
