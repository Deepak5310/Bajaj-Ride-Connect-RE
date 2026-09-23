package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dn extends Cdo implements kd {
    protected dn() {
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final boolean A() {
        return b().A();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public boolean B(kd kdVar) {
        return b().B(kdVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public boolean C(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.Cdo
    protected /* bridge */ /* synthetic */ Object aF() {
        throw null;
    }

    protected abstract kd b();

    public Collection c(Object obj) {
        throw null;
    }

    public Collection d(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final boolean equals(Object obj) {
        return obj == this || b().equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final int hashCode() {
        return b().hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final int i() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public void q() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final boolean s(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public boolean t(Object obj, Object obj2) {
        return b().t(obj, obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public Collection u() {
        return b().u();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public Map w() {
        return b().w();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public Set x() {
        return b().x();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final boolean y(Object obj, Object obj2) {
        throw null;
    }
}
