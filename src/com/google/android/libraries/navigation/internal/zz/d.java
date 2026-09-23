package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class d {
    public final fd c;

    public d() {
        this.c = ma.b;
    }

    public d(fd fdVar) {
        this.c = fdVar;
    }

    public Type a(TypeVariable typeVariable, d dVar) {
        Type type = (Type) this.c.get(new e(typeVariable));
        if (type != null) {
            return new f(dVar).a(type);
        }
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length != 0) {
            Type[] typeArrB = new f(dVar).b(bounds);
            if (!x.a || !Arrays.equals(bounds, typeArrB)) {
                return ad.d(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrB);
            }
        }
        return typeVariable;
    }
}
