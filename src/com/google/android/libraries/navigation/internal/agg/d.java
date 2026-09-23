package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gf;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hd;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d extends c implements Serializable, bj {
    private static final long serialVersionUID = -4940583368468432370L;

    protected d() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agg.as
    public boolean c(int i) {
        throw null;
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return ar.d(this, obj);
    }

    public boolean containsValue(Object obj) {
        gi it2 = u().listIterator();
        while (it2.hasNext()) {
            if (((bh) it2.next()).getValue() == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ez keySet() {
        throw null;
    }

    @Override // java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public gf values() {
        throw null;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
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
        return u().containsAll(map.entrySet());
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bj
    public /* synthetic */ hd f() {
        return bg.a(this);
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        hd hdVarL = u();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agg.bf
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                bh bhVar = (bh) obj;
                biConsumer.accept(Integer.valueOf(bhVar.a()), bhVar.getValue());
            }
        };
        if (hdVarL instanceof bi) {
            ((bi) hdVarL).h(consumer);
        } else {
            hdVarL.forEach(consumer);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bj
    public final /* synthetic */ Object g(Integer num, Object obj) {
        return ar.b(this, num, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ Object get(Object obj) {
        return ar.a(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        throw new NoSuchMethodError();
    }

    public int hashCode() {
        gi giVarA = bl.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((bh) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return g((Integer) obj, obj2);
    }

    public void putAll(Map map) {
        if (map instanceof bj) {
            gi giVarA = bl.a((bj) map);
            while (giVarA.hasNext()) {
                bh bhVar = (bh) giVarA.next();
                a(bhVar.a(), bhVar.getValue());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            ar.b(this, (Integer) entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        return ar.c(this, obj);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = bl.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            size--;
            bh bhVar = (bh) giVarA.next();
            sb.append(String.valueOf(bhVar.a()));
            sb.append("=>");
            if (this == bhVar.getValue()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(bhVar.getValue()));
            }
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
