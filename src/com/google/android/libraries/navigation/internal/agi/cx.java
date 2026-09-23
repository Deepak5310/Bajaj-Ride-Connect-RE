package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class cx extends f implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected cx() {
    }

    private Object readResolve() {
        return cy.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agi.cw
    public final long a() {
        return 0L;
    }

    public final void clear() {
    }

    public Object clone() {
        return cy.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cw
    public final long q(Object obj) {
        return 0L;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
