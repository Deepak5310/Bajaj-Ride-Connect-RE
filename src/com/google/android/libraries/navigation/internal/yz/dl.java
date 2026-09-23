package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dl extends Cdo implements Map {
    protected dl() {
    }

    @Override // com.google.android.libraries.navigation.internal.yz.Cdo
    protected /* bridge */ /* synthetic */ Object aF() {
        throw null;
    }

    @Override // java.util.Map
    public void clear() {
        f().clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return f().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return f().containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        return f().entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj == this || f().equals(obj);
    }

    protected abstract Map f();

    @Override // java.util.Map
    public Object get(Object obj) {
        return f().get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return f().hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return f().isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return f().keySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return f().put(obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        f().putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return f().remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return f().size();
    }

    @Override // java.util.Map
    public Collection values() {
        return f().values();
    }
}
