package com.google.android.libraries.navigation.internal.zz;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends d {
    final /* synthetic */ TypeVariable a;
    final /* synthetic */ d b;

    public c(TypeVariable typeVariable, d dVar) {
        this.a = typeVariable;
        this.b = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.zz.d
    public final Type a(TypeVariable typeVariable, d dVar) {
        return typeVariable.getGenericDeclaration().equals(this.a.getGenericDeclaration()) ? typeVariable : this.b.a(typeVariable, dVar);
    }
}
