package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e {
    private final TypeVariable a;

    public e(TypeVariable typeVariable) {
        ar.q(typeVariable);
        this.a = typeVariable;
    }

    static e a(Type type) {
        if (type instanceof TypeVariable) {
            return new e((TypeVariable) type);
        }
        return null;
    }

    private final boolean c(TypeVariable typeVariable) {
        return this.a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.a.getName().equals(typeVariable.getName());
    }

    final boolean b(Type type) {
        if (type instanceof TypeVariable) {
            return c((TypeVariable) type);
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return c(((e) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a.getGenericDeclaration(), this.a.getName()});
    }

    public final String toString() {
        return this.a.toString();
    }
}
