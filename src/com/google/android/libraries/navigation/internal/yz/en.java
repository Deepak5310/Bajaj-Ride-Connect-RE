package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class en extends fb {
    private final transient EnumMap b;

    public en(EnumMap enumMap) {
        this.b = enumMap;
        com.google.android.libraries.navigation.internal.yx.ar.a(!enumMap.isEmpty());
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EnumSerializedForm");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fb
    public final nn a() {
        return new jr(this.b.entrySet().iterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final nn b() {
        return hb.a(this.b.keySet().iterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.b.containsKey(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd, java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof en) {
            obj = ((en) obj).b;
        }
        return this.b.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd, java.util.Map
    public final Object get(Object obj) {
        return this.b.get(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.b.size();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fb, com.google.android.libraries.navigation.internal.yz.fd
    public Object writeReplace() {
        return new em(this.b);
    }
}
