package com.google.android.libraries.navigation.internal.lh;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<bg> CREATOR = new bh();
    final int a;
    public final Account b;
    public final int c;
    public final com.google.android.libraries.navigation.internal.kw.a d;

    public bg(int i, Account account, int i2, com.google.android.libraries.navigation.internal.kw.a aVar) {
        this.a = i;
        this.b = account;
        this.c = i2;
        this.d = aVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.b, i);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, this.d, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
