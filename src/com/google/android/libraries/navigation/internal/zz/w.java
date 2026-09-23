package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum w {
    JAVA6,
    JAVA7,
    JAVA8,
    JAVA9;

    static final w e;

    static {
        w wVar = JAVA6;
        w wVar2 = JAVA7;
        w wVar3 = JAVA8;
        w wVar4 = JAVA9;
        if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
            if (new a() { // from class: com.google.android.libraries.navigation.internal.zz.u
            }.a().toString().contains("java.util.Map.java.util.Map")) {
                e = wVar3;
                return;
            } else {
                e = wVar4;
                return;
            }
        }
        if (new a() { // from class: com.google.android.libraries.navigation.internal.zz.v
        }.a() instanceof Class) {
            e = wVar2;
        } else {
            e = wVar;
        }
    }

    final ev a(Type[] typeArr) {
        int i = ev.d;
        eq eqVar = new eq();
        for (Type type : typeArr) {
            eqVar.h(d(type));
        }
        return eqVar.g();
    }

    final Type c(Type type) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return new t(type);
        }
        if (iOrdinal == 1) {
            return type instanceof Class ? ad.a((Class) type) : new t(type);
        }
        if (iOrdinal == 2) {
            return JAVA7.c(type);
        }
        if (iOrdinal == 3) {
            return JAVA8.c(type);
        }
        throw null;
    }

    final String b(Type type) {
        int iOrdinal = ordinal();
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? ad.b(type) : JAVA8.b(type);
        }
        try {
            return (String) Type.class.getMethod("getTypeName", null).invoke(type, null);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("Type.getTypeName should be available in Java 8");
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    final Type d(Type type) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            ar.q(type);
            if (!(type instanceof Class)) {
                return type;
            }
            Class cls = (Class) type;
            return cls.isArray() ? new t(cls.getComponentType()) : type;
        }
        if (iOrdinal == 1) {
            ar.q(type);
            return type;
        }
        if (iOrdinal == 2) {
            return JAVA7.d(type);
        }
        if (iOrdinal == 3) {
            return JAVA8.d(type);
        }
        throw null;
    }
}
