package com.google.android.libraries.navigation.internal.lh;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements Parcelable.Creator {
    static void a(x xVar, Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, xVar.c);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, xVar.d);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, xVar.e);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 4, xVar.f);
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 5, xVar.g);
        com.google.android.libraries.navigation.internal.li.d.u(parcel, 6, xVar.h, i);
        com.google.android.libraries.navigation.internal.li.d.j(parcel, 7, xVar.i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 8, xVar.j, i);
        com.google.android.libraries.navigation.internal.li.d.u(parcel, 10, xVar.k, i);
        com.google.android.libraries.navigation.internal.li.d.u(parcel, 11, xVar.l, i);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 12, xVar.m);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 13, xVar.f481n);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 14, xVar.o);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 15, xVar.p);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        com.google.android.libraries.navigation.internal.ld.z[] zVarArr = x.a;
        Bundle bundle = new Bundle();
        com.google.android.libraries.navigation.internal.lc.d[] dVarArr = x.b;
        com.google.android.libraries.navigation.internal.lc.d[] dVarArr2 = dVarArr;
        String strN = null;
        IBinder iBinderJ = null;
        Account account = null;
        String strN2 = null;
        int iE = 0;
        int iE2 = 0;
        int iE3 = 0;
        boolean zS = false;
        int iE4 = 0;
        boolean zS2 = false;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 1:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 2:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 3:
                    iE3 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 4:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 5:
                    iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
                    break;
                case 6:
                    zVarArr = (com.google.android.libraries.navigation.internal.ld.z[]) com.google.android.libraries.navigation.internal.li.c.v(parcel, i, com.google.android.libraries.navigation.internal.ld.z.CREATOR);
                    break;
                case 7:
                    bundle = com.google.android.libraries.navigation.internal.li.c.i(parcel, i);
                    break;
                case 8:
                    account = (Account) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, Account.CREATOR);
                    break;
                case 9:
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
                case 10:
                    dVarArr = (com.google.android.libraries.navigation.internal.lc.d[]) com.google.android.libraries.navigation.internal.li.c.v(parcel, i, com.google.android.libraries.navigation.internal.lc.d.CREATOR);
                    break;
                case 11:
                    dVarArr2 = (com.google.android.libraries.navigation.internal.lc.d[]) com.google.android.libraries.navigation.internal.li.c.v(parcel, i, com.google.android.libraries.navigation.internal.lc.d.CREATOR);
                    break;
                case 12:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 13:
                    iE4 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 14:
                    zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 15:
                    strN2 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new x(iE, iE2, iE3, strN, iBinderJ, zVarArr, bundle, account, dVarArr, dVarArr2, zS, iE4, zS2, strN2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new x[i];
    }
}
