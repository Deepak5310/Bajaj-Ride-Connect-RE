package com.google.android.libraries.navigation.internal.agh;

import com.google.android.libraries.navigation.internal.agi.kx;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class m extends l implements Serializable, ez {
    private static final long serialVersionUID = -4940583368468432370L;

    protected m() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.l, com.google.android.libraries.navigation.internal.agh.eu
    public boolean c(long j) {
        throw null;
    }

    public /* synthetic */ void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.l, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return et.d(this, obj);
    }

    public boolean containsValue(Object obj) {
        com.google.android.libraries.navigation.internal.agi.gi giVarListIterator = i().listIterator();
        while (giVarListIterator.hasNext()) {
            if (((fj) giVarListIterator.next()).getValue() == obj) {
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

    @Override // com.google.android.libraries.navigation.internal.agh.ez
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd e() {
        return ey.a(this);
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
        com.google.android.libraries.navigation.internal.agi.hd hdVarI = i();
        Consumer consumer = new Consumer() { // from class: com.google.android.libraries.navigation.internal.agh.ex
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                fj fjVar = (fj) obj;
                biConsumer.accept(Long.valueOf(fjVar.a()), fjVar.getValue());
            }
        };
        if (hdVarI instanceof fk) {
            ((fk) hdVarI).d(consumer);
        } else {
            hdVarI.forEach(consumer);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ez
    public final /* synthetic */ Object g(Long l, Object obj) {
        return et.b(this, l, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.l, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ Object get(Object obj) {
        return et.a(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        throw new NoSuchMethodError();
    }

    public int hashCode() {
        com.google.android.libraries.navigation.internal.agi.gi giVarA = fb.a(this);
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iHashCode += ((fj) giVarA.next()).hashCode();
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
        if (map instanceof ez) {
            com.google.android.libraries.navigation.internal.agi.gi giVarA = fb.a((ez) map);
            while (giVarA.hasNext()) {
                fj fjVar = (fj) giVarA.next();
                a(fjVar.a(), fjVar.getValue());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            et.b(this, (Long) entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        return et.c(this, obj);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        com.google.android.libraries.navigation.internal.agi.gi giVarA = fb.a(this);
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            size--;
            fj fjVar = (fj) giVarA.next();
            sb.append(String.valueOf(fjVar.a()));
            sb.append("=>");
            if (this == fjVar.getValue()) {
                sb.append("(this map)");
            } else {
                sb.append(String.valueOf(fjVar.getValue()));
            }
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
