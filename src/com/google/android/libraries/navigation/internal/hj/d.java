package com.google.android.libraries.navigation.internal.hj;

import android.accounts.Account;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    @JvmStatic
    public static final boolean a(Account account) {
        return Intrinsics.areEqual(account != null ? account.type : null, "com.google");
    }
}
