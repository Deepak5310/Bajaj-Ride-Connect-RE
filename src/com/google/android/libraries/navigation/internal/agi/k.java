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
public abstract class k extends i implements Serializable, ey {
    private static final long serialVersionUID = -4940583368468432370L;

    protected k() {
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public gf values() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ey
    public /* synthetic */ hd b() {
        return ev.a(this);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public hd keySet() {
        throw null;
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return ev.b(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return ev.c(this, obj, biFunction);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.i, com.google.android.libraries.navigation.internal.agc.d
    public boolean containsKey(Object obj) {
        gi it2 = i().listIterator();
        while (it2.hasNext()) {
            if (((ew) it2.next()).getKey() == obj) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        gi it2 = i().listIterator();
        while (it2.hasNext()) {
            if (((ew) it2.next()).getValue() == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
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
        return i().containsAll(map.entrySet());
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        hd hdVarD = i();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agi.eu
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ew ewVar = (ew) obj;
                biConsumer.accept(ewVar.getKey(), ewVar.getValue());
            }
        };
        if (hdVarD instanceof ex) {
            ((ex) hdVarD).d(consumer);
        } else {
            hdVarD.forEach(consumer);
        }
    }

    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return (obj3 != null || containsKey(obj)) ? obj3 : obj2;
    }

    public int hashCode() {
        gi giVarA = fa.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((ew) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return ev.d(this, obj, obj2, biFunction);
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return eg.a();
    }

    public void putAll(Map map) {
        if (map instanceof ey) {
            gi giVarA = fa.a((ey) map);
            while (giVarA.hasNext()) {
                ew ewVar = (ew) giVarA.next();
                put(ewVar.getKey(), ewVar.getValue());
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

    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return ev.e(this, obj, obj2);
    }

    public /* synthetic */ Object remove(Object obj) {
        return eg.b();
    }

    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return ev.h(this, obj, obj2);
    }

    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return ev.f(this, obj, obj2);
    }

    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return ev.i(this, obj, obj2, obj3);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = fa.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            ew ewVar = (ew) giVarA.next();
            if (this == ewVar.getKey()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(ewVar.getKey()));
            }
            size--;
            sb.append("=>");
            if (this == ewVar.getValue()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(ewVar.getValue()));
            }
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
