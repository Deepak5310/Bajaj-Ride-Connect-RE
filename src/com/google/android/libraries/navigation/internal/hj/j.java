package com.google.android.libraries.navigation.internal.hj;

import android.accounts.Account;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public static final j a = new j();

    private j() {
    }

    @JvmStatic
    public static final i a(Account account) {
        i iVar;
        i nVar;
        if (account != null) {
            if (account instanceof i) {
                iVar = (i) account;
            } else {
                f fVarB = b(account);
                f fVar = f.UNKNOWN;
                int iOrdinal = fVarB.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        String name = account.name;
                        Intrinsics.checkNotNullExpressionValue(name, "name");
                        String type = account.type;
                        Intrinsics.checkNotNullExpressionValue(type, "type");
                        nVar = new n(name, type);
                    } else if (iOrdinal == 2) {
                        String name2 = account.name;
                        Intrinsics.checkNotNullExpressionValue(name2, "name");
                        nVar = new o(name2);
                    } else {
                        if (iOrdinal != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        iVar = g.a;
                    }
                    iVar = nVar;
                } else {
                    iVar = h.a;
                }
            }
            if (iVar != null) {
                return iVar;
            }
        }
        return g.a;
    }

    private static final f b(Account account) {
        if (Intrinsics.areEqual(account.type, "com.google")) {
            return f.GOOGLE;
        }
        if (!Intrinsics.areEqual(account.type, "com.google.android.apps.maps")) {
            String str = account.type;
            throw new IllegalArgumentException("GmmAccount requires a known type. ".concat(""));
        }
        if (Intrinsics.areEqual(account.name, g.a.name)) {
            return f.SIGNED_OUT;
        }
        String name = account.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt.startsWith$default(name, "incognito@", false, 2, (Object) null) ? f.INCOGNITO : f.UNKNOWN;
    }
}
