package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yz.fw;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends p {
    final /* synthetic */ fw a;

    public g(fw fwVar) {
        this.a = fwVar;
    }

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void a(Class cls) {
        this.a.c(cls);
    }

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void b(ParameterizedType parameterizedType) {
        this.a.c((Class) parameterizedType.getRawType());
    }

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void c(TypeVariable typeVariable) {
        f(typeVariable.getBounds());
    }

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void d(WildcardType wildcardType) {
        f(wildcardType.getUpperBounds());
    }

    @Override // com.google.android.libraries.navigation.internal.zz.p
    public final void e(GenericArrayType genericArrayType) {
        this.a.c(ad.a(new h(genericArrayType.getGenericComponentType()).d()));
    }
}
