package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hd;
import com.google.android.libraries.navigation.internal.agi.kx;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g extends f implements Serializable, ci {
    private static final long serialVersionUID = -4940583368468432370L;

    protected g() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agg.cd
    public boolean c(int i) {
        throw null;
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return cc.d(this, obj);
    }

    public boolean containsValue(Object obj) {
        gi giVarListIterator = i().listIterator();
        while (giVarListIterator.hasNext()) {
            if (((cs) giVarListIterator.next()).getValue() == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ez keySet() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ci
    public final /* synthetic */ hd e() {
        return ch.a(this);
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
        return i().containsAll(map.entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public kx values() {
        throw null;
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(final BiConsumer biConsumer) {
        hd hdVarI = i();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agg.cg
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                cs csVar = (cs) obj;
                biConsumer.accept(Integer.valueOf(csVar.a()), csVar.getValue());
            }
        };
        if (hdVarI instanceof ct) {
            ((ct) hdVarI).d(consumer);
        } else {
            hdVarI.forEach(consumer);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ci
    public final /* synthetic */ Object g(Integer num, Object obj) {
        return cc.b(this, num, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ Object get(Object obj) {
        return cc.a(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        throw new NoSuchMethodError();
    }

    public int hashCode() {
        gi giVarA = ck.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((cs) giVarA.next()).hashCode();
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
        if (map instanceof ci) {
            gi giVarA = ck.a((ci) map);
            while (giVarA.hasNext()) {
                cs csVar = (cs) giVarA.next();
                a(csVar.a(), csVar.getValue());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            cc.b(this, (Integer) entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        return cc.c(this, obj);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi giVarA = ck.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            size--;
            cs csVar = (cs) giVarA.next();
            sb.append(String.valueOf(csVar.a()));
            sb.append("=>");
            if (this == csVar.getValue()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(csVar.getValue()));
            }
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
