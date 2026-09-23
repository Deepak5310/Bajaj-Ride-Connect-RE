package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends p {
    public final Map a = new HashMap();

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void a(Class cls) {
        f(cls.getGenericSuperclass());
        f(cls.getGenericInterfaces());
    }

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void b(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        ar.k(typeParameters.length == actualTypeArguments.length);
        for (int i = 0; i < typeParameters.length; i++) {
            e eVar = new e(typeParameters[i]);
            Type type = actualTypeArguments[i];
            if (!this.a.containsKey(eVar)) {
                Type type2 = type;
                while (true) {
                    if (type2 == null) {
                        this.a.put(eVar, type);
                        break;
                    } else {
                        if (eVar.b(type2)) {
                            while (type != null) {
                                type = (Type) this.a.remove(e.a(type));
                            }
                            break;
                        }
                        type2 = (Type) this.a.get(e.a(type2));
                    }
                }
            }
        }
        f(cls);
        f(parameterizedType.getOwnerType());
    }

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void c(TypeVariable typeVariable) {
        f(typeVariable.getBounds());
    }

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void d(WildcardType wildcardType) {
        f(wildcardType.getUpperBounds());
    }
}
