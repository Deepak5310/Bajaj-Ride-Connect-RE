package com.google.android.libraries.navigation.internal.lh;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak extends com.google.android.libraries.navigation.internal.d.a implements al {
    public ak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.libraries.navigation.internal.lh.al
    public final Account e() throws RemoteException {
        Parcel parcelB = b(2, a());
        Account account = (Account) com.google.android.libraries.navigation.internal.d.c.a(parcelB, Account.CREATOR);
        parcelB.recycle();
        return account;
    }
}
