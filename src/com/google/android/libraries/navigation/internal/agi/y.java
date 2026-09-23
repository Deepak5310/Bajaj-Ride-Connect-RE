package com.google.android.libraries.navigation.internal.agi;

import com.google.android.libraries.navigation.internal.agg.Cdo;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class y extends x implements Serializable, ia {
    private static final long serialVersionUID = -4940583368468432370L;

    protected y() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.x, com.google.android.libraries.navigation.internal.agi.ht
    public final /* synthetic */ Integer c(Object obj) {
        return hs.a(this, obj);
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.x, com.google.android.libraries.navigation.internal.agc.d
    public boolean containsKey(Object obj) {
        gi giVarListIterator = p().listIterator();
        while (giVarListIterator.hasNext()) {
            if (((ik) giVarListIterator.next()).getKey() == obj) {
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
        return l(((Integer) obj).intValue());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Cdo values() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ hd e() {
        return hy.a(this);
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
    public lb keySet() {
        throw null;
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        hd hdVarP = p();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agi.hw
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ik ikVar = (ik) obj;
                biConsumer.accept(ikVar.getKey(), Integer.valueOf(ikVar.a()));
            }
        };
        if (hdVarP instanceof hz) {
            ((hz) hdVarP).d(consumer);
        } else {
            hdVarP.forEach(consumer);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer g(Object obj, Integer num, BiFunction biFunction) {
        hy.i();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.x, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        m();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer h(Object obj, Integer num) {
        return hs.b(this, obj, num);
    }

    public int hashCode() {
        gi giVarA = ic.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((ik) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer i(Object obj, Integer num) {
        hy.j();
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer j(Object obj) {
        return hs.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer k(Object obj, Integer num) {
        hy.l();
        return null;
    }

    public boolean l(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer m() {
        hx.a();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        hy.c(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ void n(Object obj, Integer num, Integer num2) {
        hy.m();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return h(obj, (Integer) obj2);
    }

    public void putAll(Map map) {
        if (map instanceof ia) {
            gi giVarA = ic.a((ia) map);
            while (giVarA.hasNext()) {
                ik ikVar = (ik) giVarA.next();
                a(ikVar.getKey(), ikVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            hs.b(this, entry.getKey(), (Integer) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        hy.e(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return j(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        hy.k();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        hy.g(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        n(obj, (Integer) obj2, (Integer) obj3);
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = ic.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            ik ikVar = (ik) giVarA.next();
            if (this == ikVar.getKey()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(ikVar.getKey()));
            }
            sb.append("=>");
            sb.append(String.valueOf(ikVar.a()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
