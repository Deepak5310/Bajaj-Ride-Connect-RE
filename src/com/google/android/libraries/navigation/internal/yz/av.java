package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class av implements nd {
    private transient Set a;

    @Override // com.google.android.libraries.navigation.internal.yz.nd
    public Object a(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.nd
    public Object b(Object obj, Object obj2, Object obj3) {
        throw null;
    }

    public abstract Iterator c();

    @Override // com.google.android.libraries.navigation.internal.yz.nd
    public final Set d() {
        Set set = this.a;
        if (set != null) {
            return set;
        }
        au auVar = new au(this);
        this.a = auVar;
        return auVar;
    }

    public void e() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof nd) {
            return d().equals(((nd) obj).d());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.nd
    public boolean f(Object obj, Object obj2) {
        throw null;
    }

    public final int hashCode() {
        return d().hashCode();
    }

    public final String toString() {
        return j().toString();
    }
}
