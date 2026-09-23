package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad {
    public static final ah a = new ah(", ").b();

    static Class a(Class cls) {
        return Array.newInstance((Class<?>) cls, 0).getClass();
    }

    static String b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type c(Type type) {
        if (!(type instanceof WildcardType)) {
            return w.e.c(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        int length = lowerBounds.length;
        ar.b(length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (length == 1) {
            return new ac(new Type[]{c(lowerBounds[0])}, new Type[]{Object.class});
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        ar.b(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return new ac(new Type[0], new Type[]{c(upperBounds[0])});
    }

    static TypeVariable d(GenericDeclaration genericDeclaration, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        ab abVar = new ab(new aa(genericDeclaration, str, typeArr));
        ar.f(TypeVariable.class.isInterface(), "%s is not an interface", TypeVariable.class);
        return (TypeVariable) TypeVariable.class.cast(Proxy.newProxyInstance(TypeVariable.class.getClassLoader(), new Class[]{TypeVariable.class}, abVar));
    }

    public static void e(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                ar.i(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    public static Type[] f(Collection collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }
}
