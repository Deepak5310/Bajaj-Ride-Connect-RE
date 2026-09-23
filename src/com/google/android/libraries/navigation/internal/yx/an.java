package com.google.android.libraries.navigation.internal.yx;

import java.io.Serializable;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class an implements Serializable {
    private static final long serialVersionUID = 0;

    public static an h(Optional optional) {
        if (optional == null) {
            return null;
        }
        return i(optional.orElse(null));
    }

    public static an i(Object obj) {
        return obj == null ? a.a : new aw(obj);
    }

    public static an j(Object obj) {
        ar.q(obj);
        return new aw(obj);
    }

    public abstract an a(an anVar);

    public abstract an b(aa aaVar);

    public abstract Object c();

    public abstract Object d(br brVar);

    public abstract Object e(Object obj);

    public abstract boolean equals(Object obj);

    public abstract Object f();

    public abstract boolean g();

    public abstract int hashCode();

    public final Optional k() {
        return Optional.ofNullable(f());
    }

    public abstract String toString();
}
