package com.google.android.libraries.navigation.internal.zz;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class p {
    private final Set a = new HashSet();

    public void a(Class cls) {
    }

    public void b(ParameterizedType parameterizedType) {
    }

    public void c(TypeVariable typeVariable) {
        throw null;
    }

    public void d(WildcardType wildcardType) {
        throw null;
    }

    public void e(GenericArrayType genericArrayType) {
    }

    public final void f(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        c((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        d((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        b((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        a((Class) type);
                    } else {
                        if (!(type instanceof GenericArrayType)) {
                            throw new AssertionError("Unknown type: " + type.toString());
                        }
                        e((GenericArrayType) type);
                    }
                } catch (Throwable th) {
                    this.a.remove(type);
                    throw th;
                }
            }
        }
    }
}
