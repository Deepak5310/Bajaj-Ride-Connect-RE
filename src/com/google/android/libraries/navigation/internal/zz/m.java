package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.as;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum m implements as {
    IGNORE_TYPE_VARIABLE_OR_WILDCARD,
    INTERFACE_ONLY;

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final /* synthetic */ boolean a(Object obj) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            Type type = ((o) obj).a;
            return ((type instanceof TypeVariable) || (type instanceof WildcardType)) ? false : true;
        }
        if (iOrdinal == 1) {
            return ((o) obj).d().isInterface();
        }
        throw null;
    }
}
