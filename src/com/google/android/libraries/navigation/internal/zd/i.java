package com.google.android.libraries.navigation.internal.zd;

import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum i implements h {
    DEFAULT,
    NO_OP,
    SIMPLE_CLASSNAME;

    @Override // com.google.android.libraries.navigation.internal.zd.h
    public final /* synthetic */ boolean a(com.google.android.libraries.navigation.internal.zb.t tVar, StringBuilder sb) {
        int iOrdinal = ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return false;
            }
            if (iOrdinal != 2) {
                throw null;
            }
            throw null;
        }
        if (tVar == com.google.android.libraries.navigation.internal.zb.t.a) {
            return false;
        }
        sb.append(tVar.b());
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb.append(tVar.d());
        sb.append(':');
        sb.append(tVar.a());
        return true;
    }
}
