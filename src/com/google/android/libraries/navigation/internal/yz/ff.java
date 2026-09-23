package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ff extends fy {
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EntrySetSerializedForm");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = h().get(entry.getKey());
            if (obj2 != null && obj2.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return h().c();
    }

    public abstract fd h();

    @Override // com.google.android.libraries.navigation.internal.yz.fy, java.util.Collection, java.util.Set
    public final int hashCode() {
        return h().hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy
    public final boolean i() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return h().size();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return new fe(h());
    }
}
