package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kn extends at {
    private static final long serialVersionUID = 0;
    transient com.google.android.libraries.navigation.internal.yx.br c;

    public kn(Map map, com.google.android.libraries.navigation.internal.yx.br brVar) {
        super(map);
        this.c = brVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.c = (com.google.android.libraries.navigation.internal.yx.br) Objects.requireNonNull(objectInputStream.readObject());
        r((Map) Objects.requireNonNull(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.c);
        objectOutputStream.writeObject(((ae) this).a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.at, com.google.android.libraries.navigation.internal.yz.ae
    public final /* bridge */ /* synthetic */ Collection a() {
        return (Set) this.c.a();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.at, com.google.android.libraries.navigation.internal.yz.ae
    public final Collection e(Collection collection) {
        if (collection instanceof NavigableSet) {
            return mp.h((NavigableSet) collection);
        }
        return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.at, com.google.android.libraries.navigation.internal.yz.ae
    public final Collection f(Object obj, Collection collection) {
        if (collection instanceof NavigableSet) {
            return new ab(this, obj, (NavigableSet) collection, null);
        }
        return collection instanceof SortedSet ? new ad(this, obj, (SortedSet) collection, null) : new ac(this, obj, (Set) collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae, com.google.android.libraries.navigation.internal.yz.an
    public final Map o() {
        Map map = ((ae) this).a;
        if (map instanceof NavigableMap) {
            return new s(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new v(this, (SortedMap) map) : new o(this, map);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae, com.google.android.libraries.navigation.internal.yz.an
    public final Set p() {
        Map map = ((ae) this).a;
        if (map instanceof NavigableMap) {
            return new t(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new w(this, (SortedMap) map) : new r(this, map);
    }
}
