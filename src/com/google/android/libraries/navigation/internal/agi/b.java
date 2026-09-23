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
public abstract class b extends a implements Serializable, as {
    private static final long serialVersionUID = -4940583368468432370L;

    protected b() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agi.am
    public final /* synthetic */ Float c(Object obj) {
        return al.a(this, obj);
    }

    @Override // java.util.Map
    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agc.d
    public boolean containsKey(Object obj) {
        gi giVarListIterator = p().listIterator();
        while (giVarListIterator.hasNext()) {
            if (((bc) giVarListIterator.next()).getKey() == obj) {
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
        return l(((Float) obj).floatValue());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.google.android.libraries.navigation.internal.agf.l values() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ hd e() {
        return ar.a(this);
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
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        hd hdVarP = p();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agi.ap
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                bc bcVar = (bc) obj;
                biConsumer.accept(bcVar.getKey(), Float.valueOf(bcVar.a()));
            }
        };
        if (hdVarP instanceof bd) {
            ((bd) hdVarP).d(consumer);
        } else {
            hdVarP.forEach(consumer);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float g(Object obj, Float f, BiFunction biFunction) {
        ar.i();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        m();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float h(Object obj, Float f) {
        return al.b(this, obj, f);
    }

    @Override // java.util.Map
    public int hashCode() {
        gi giVarA = au.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((bc) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float i(Object obj, Float f) {
        ar.j();
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float j(Object obj) {
        return al.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float k(Object obj, Float f) {
        ar.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public boolean l(float f) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float m() {
        aq.a();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        ar.c(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ void n(Object obj, Float f, Float f2) {
        ar.m();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return h(obj, (Float) obj2);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        if (map instanceof as) {
            gi giVarA = au.a((as) map);
            while (giVarA.hasNext()) {
                bc bcVar = (bc) giVarA.next();
                a(bcVar.getKey(), bcVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            al.b(this, entry.getKey(), (Float) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        ar.e(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return j(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        ar.k();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        ar.g(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        n(obj, (Float) obj2, (Float) obj3);
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = au.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            bc bcVar = (bc) giVarA.next();
            if (this == bcVar.getKey()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(bcVar.getKey()));
            }
            sb.append("=>");
            sb.append(String.valueOf(bcVar.a()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
