package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.Typography;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type a;
    private final ev b;
    private final Class c;

    public z(Type type, Class cls, Type[] typeArr) {
        ar.q(cls);
        ar.a(typeArr.length == cls.getTypeParameters().length);
        ad.e(typeArr, "type parameter");
        this.a = type;
        this.c = cls;
        this.b = w.e.a(typeArr);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        return this.c.equals(parameterizedType.getRawType()) && am.a(this.a, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return ad.f(this.b);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a != null && w.e.ordinal() != 3) {
            sb.append(w.e.b(this.a));
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        sb.append(this.c.getName());
        sb.append(Typography.less);
        ev evVar = this.b;
        ah ahVar = ad.a;
        final w wVar = w.e;
        Objects.requireNonNull(wVar);
        sb.append(ahVar.f(gs.b(evVar, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.zz.y
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return wVar.b((Type) obj);
            }
        })));
        sb.append(Typography.greater);
        return sb.toString();
    }

    public final int hashCode() {
        Type type = this.a;
        return ((type == null ? 0 : type.hashCode()) ^ this.b.hashCode()) ^ this.c.hashCode();
    }
}
