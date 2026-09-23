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
public abstract class aa extends z implements Serializable, ix {
    private static final long serialVersionUID = -4940583368468432370L;

    protected aa() {
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public gf values() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ix
    public final /* synthetic */ hd b() {
        return iw.a(this);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public lb keySet() {
        throw null;
    }

    @Override // java.util.Map
    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return iw.b(this, obj, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return iw.c(this, obj, biFunction);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.z, com.google.android.libraries.navigation.internal.agc.d
    public boolean containsKey(Object obj) {
        gi it2 = d().listIterator();
        while (it2.hasNext()) {
            if (((jh) it2.next()).getKey() == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        gi it2 = d().listIterator();
        while (it2.hasNext()) {
            if (((jh) it2.next()).getValue() == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return b();
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
        return d().containsAll(map.entrySet());
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        hd hdVarD = d();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agi.iv
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                jh jhVar = (jh) obj;
                biConsumer.accept(jhVar.getKey(), jhVar.getValue());
            }
        };
        if (hdVarD instanceof ji) {
            ((ji) hdVarD).d(consumer);
        } else {
            hdVarD.forEach(consumer);
        }
    }

    @Override // java.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return (obj3 != null || containsKey(obj)) ? obj3 : obj2;
    }

    @Override // java.util.Map
    public int hashCode() {
        gi giVarA = iz.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((jh) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return iw.d(this, obj, obj2, biFunction);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ix, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return ir.a();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        if (map instanceof ix) {
            gi giVarA = iz.a((ix) map);
            while (giVarA.hasNext()) {
                jh jhVar = (jh) giVarA.next();
                put(jhVar.getKey(), jhVar.getValue());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return iw.e(this, obj, obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ix, java.util.Map
    public /* synthetic */ Object remove(Object obj) {
        return ir.b();
    }

    @Override // java.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return iw.h(this, obj, obj2);
    }

    @Override // java.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return iw.f(this, obj, obj2);
    }

    @Override // java.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return iw.i(this, obj, obj2, obj3);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = iz.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            jh jhVar = (jh) giVarA.next();
            if (this == jhVar.getKey()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(jhVar.getKey()));
            }
            size--;
            sb.append("=>");
            if (this == jhVar.getValue()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(jhVar.getValue()));
            }
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
