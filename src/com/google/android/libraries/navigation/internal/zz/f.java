package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public final d a;

    public f() {
        this.a = new d();
    }

    public f(d dVar) {
        this.a = dVar;
    }

    public final Type a(Type type) {
        ar.q(type);
        if (type instanceof TypeVariable) {
            d dVar = this.a;
            TypeVariable typeVariable = (TypeVariable) type;
            return dVar.a(typeVariable, new c(typeVariable, dVar));
        }
        if (!(type instanceof ParameterizedType)) {
            if (type instanceof GenericArrayType) {
                return ad.c(a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new ac(b(wildcardType.getLowerBounds()), b(wildcardType.getUpperBounds()));
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type ownerType = parameterizedType.getOwnerType();
        Type typeA = ownerType == null ? null : a(ownerType);
        Type typeA2 = a(parameterizedType.getRawType());
        Type[] typeArrB = b(parameterizedType.getActualTypeArguments());
        Class cls = (Class) typeA2;
        ah ahVar = ad.a;
        if (typeA == null) {
            return new z(s.c.a(cls), cls, typeArrB);
        }
        ar.f(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new z(typeA, cls, typeArrB);
    }

    public final Type[] b(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = a(typeArr[i]);
        }
        return typeArr2;
    }
}
