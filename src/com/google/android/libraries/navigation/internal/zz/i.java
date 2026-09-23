package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends l {
    @Override // com.google.android.libraries.navigation.internal.zz.l
    public final /* synthetic */ Class a(Object obj) {
        return ((o) obj).d();
    }

    @Override // com.google.android.libraries.navigation.internal.zz.l
    public final /* synthetic */ Iterable b(Object obj) {
        o oVar = (o) obj;
        Type type = oVar.a;
        if (type instanceof TypeVariable) {
            return o.f(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return o.f(((WildcardType) type).getUpperBounds());
        }
        int i = ev.d;
        eq eqVar = new eq();
        for (Type type2 : oVar.d().getGenericInterfaces()) {
            eqVar.h(oVar.c(type2));
        }
        return eqVar.g();
    }

    @Override // com.google.android.libraries.navigation.internal.zz.l
    public final /* synthetic */ Object c(Object obj) {
        o oVar = (o) obj;
        Type type = oVar.a;
        if (type instanceof TypeVariable) {
            return o.e(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return o.e(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = oVar.d().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return oVar.c(genericSuperclass);
    }
}
