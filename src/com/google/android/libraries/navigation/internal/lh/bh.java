package com.google.android.libraries.navigation.internal.lh;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        Account account = null;
        int iE = 0;
        int iE2 = 0;
        com.google.android.libraries.navigation.internal.kw.a aVar = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD == 2) {
                account = (Account) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, Account.CREATOR);
            } else if (iD == 3) {
                iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD != 4) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                aVar = (com.google.android.libraries.navigation.internal.kw.a) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, com.google.android.libraries.navigation.internal.kw.a.CREATOR);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new bg(iE, account, iE2, aVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new bg[i];
    }
}
