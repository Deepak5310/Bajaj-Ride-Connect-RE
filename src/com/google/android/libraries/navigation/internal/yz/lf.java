package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lf extends dl implements Serializable, Map {
    public final Map a;

    public lf(Map map) {
        com.google.android.libraries.navigation.internal.yx.ar.q(map);
        this.a = map;
    }

    public static void b(Class cls, Object obj) {
        Map map = com.google.android.libraries.navigation.internal.zy.l.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(cls);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new le(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Object put(Class cls, Object obj) {
        b(cls, obj);
        return super.put(cls, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final Set entrySet() {
        return new ld(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl
    protected final Map f() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final void putAll(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            b((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }
}
