package com.google.android.libraries.navigation.internal.yx;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at implements Serializable, as {
    private static final long serialVersionUID = 0;
    private final Object a;

    public at(Object obj) {
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final boolean a(Object obj) {
        return this.a.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final boolean equals(Object obj) {
        if (obj instanceof at) {
            return this.a.equals(((at) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Predicates.equalTo(" + this.a.toString() + ")";
    }
}
