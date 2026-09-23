package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class j extends h implements Serializable, ea {
    private static final long serialVersionUID = -4940583368468432370L;

    protected j() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public boolean c(long j) {
        throw null;
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return dh.d(this, obj);
    }

    public boolean containsValue(Object obj) {
        com.google.android.libraries.navigation.internal.agi.gi it2 = t().listIterator();
        while (it2.hasNext()) {
            if (((dy) it2.next()).getValue() == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public he keySet() {
        throw null;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.google.android.libraries.navigation.internal.agi.gf values() {
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
        return t().containsAll(map.entrySet());
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    public /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd f() {
        return dw.a(this);
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        com.google.android.libraries.navigation.internal.agi.hd hdVarL = t();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agh.dv
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                dy dyVar = (dy) obj;
                biConsumer.accept(Long.valueOf(dyVar.a()), dyVar.getValue());
            }
        };
        if (hdVarL instanceof dz) {
            ((dz) hdVarL).d(consumer);
        } else {
            hdVarL.forEach(consumer);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    public final /* synthetic */ Object g(Long l, Object obj) {
        return dh.b(this, l, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ Object get(Object obj) {
        return dh.a(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        throw new NoSuchMethodError();
    }

    public int hashCode() {
        com.google.android.libraries.navigation.internal.agi.gi giVarA = ec.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((dy) giVarA.next()).hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return g((Long) obj, obj2);
    }

    public void putAll(Map map) {
        if (map instanceof ea) {
            com.google.android.libraries.navigation.internal.agi.gi giVarA = ec.a((ea) map);
            while (giVarA.hasNext()) {
                dy dyVar = (dy) giVarA.next();
                a(dyVar.a(), dyVar.getValue());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            dh.b(this, (Long) entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        return dh.c(this, obj);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        com.google.android.libraries.navigation.internal.agi.gi giVarA = ec.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            size--;
            dy dyVar = (dy) giVarA.next();
            sb.append(String.valueOf(dyVar.a()));
            sb.append("=>");
            if (this == dyVar.getValue()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(dyVar.getValue()));
            }
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
