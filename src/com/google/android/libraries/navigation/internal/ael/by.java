package com.google.android.libraries.navigation.internal.ael;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class by extends AbstractMap {
    public final bu a;
    private final Map b;

    public by(Map map, bu buVar) {
        this.b = map;
        this.a = buVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return new bx(this, this.b.entrySet());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2 = this.b.get(obj);
        if (obj2 == null) {
            return null;
        }
        return this.a.a(obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        Object objPut = this.b.put(obj, Integer.valueOf(((bm) obj2).a()));
        if (objPut == null) {
            return null;
        }
        return this.a.a(objPut);
    }
}
