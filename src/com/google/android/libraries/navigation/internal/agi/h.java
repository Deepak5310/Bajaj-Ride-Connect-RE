package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h extends f implements Serializable, de {
    private static final long serialVersionUID = -4940583368468432370L;

    protected h() {
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public boolean containsKey(Object obj) {
        gi it2 = t().listIterator();
        while (it2.hasNext()) {
            if (((dc) it2.next()).getKey() == obj) {
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
        return m(((Long) obj).longValue());
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agi.cw
    public final /* synthetic */ Long d(Object obj) {
        return cv.a(this, obj);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.google.android.libraries.navigation.internal.agh.gf values() {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return f();
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

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ hd f() {
        return db.a(this);
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        hd hdVarT = t();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agi.cz
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                dc dcVar = (dc) obj;
                biConsumer.accept(dcVar.getKey(), Long.valueOf(dcVar.a()));
            }
        };
        if (hdVarT instanceof dd) {
            ((dd) hdVarT).d(consumer);
        } else {
            hdVarT.forEach(consumer);
        }
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public hd keySet() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        n();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long h(Object obj, Long l, BiFunction biFunction) {
        db.i();
        return null;
    }

    public int hashCode() {
        gi giVarA = dg.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((dc) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long i(Object obj, Long l) {
        return cv.b(this, obj, l);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long j(Object obj, Long l) {
        db.j();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long k(Object obj) {
        return cv.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long l(Object obj, Long l) {
        db.l();
        return null;
    }

    public boolean m(long j) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        db.c(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long n() {
        da.a();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ void o(Object obj, Long l, Long l2) {
        db.m();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return i(obj, (Long) obj2);
    }

    public void putAll(Map map) {
        if (map instanceof de) {
            gi giVarA = dg.a((de) map);
            while (giVarA.hasNext()) {
                dc dcVar = (dc) giVarA.next();
                b(dcVar.getKey(), dcVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            cv.b(this, entry.getKey(), (Long) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        db.e(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return k(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        db.k();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        db.g(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        o(obj, (Long) obj2, (Long) obj3);
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = dg.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            dc dcVar = (dc) giVarA.next();
            if (this == dcVar.getKey()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(dcVar.getKey()));
            }
            sb.append("=>");
            sb.append(String.valueOf(dcVar.a()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
