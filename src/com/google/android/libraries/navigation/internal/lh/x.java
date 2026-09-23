package com.google.android.libraries.navigation.internal.lh;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<x> CREATOR = new y();
    static final com.google.android.libraries.navigation.internal.ld.z[] a = new com.google.android.libraries.navigation.internal.ld.z[0];
    static final com.google.android.libraries.navigation.internal.lc.d[] b = new com.google.android.libraries.navigation.internal.lc.d[0];
    final int c;
    final int d;
    int e;
    String f;
    IBinder g;
    com.google.android.libraries.navigation.internal.ld.z[] h;
    Bundle i;
    Account j;
    com.google.android.libraries.navigation.internal.lc.d[] k;
    com.google.android.libraries.navigation.internal.lc.d[] l;
    boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f481n;
    boolean o;
    public String p;

    public x(int i, int i2, int i3, String str, IBinder iBinder, com.google.android.libraries.navigation.internal.ld.z[] zVarArr, Bundle bundle, Account account, com.google.android.libraries.navigation.internal.lc.d[] dVarArr, com.google.android.libraries.navigation.internal.lc.d[] dVarArr2, boolean z, int i4, boolean z2, String str2) {
        zVarArr = zVarArr == null ? a : zVarArr;
        bundle = bundle == null ? new Bundle() : bundle;
        dVarArr = dVarArr == null ? b : dVarArr;
        dVarArr2 = dVarArr2 == null ? b : dVarArr2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f = "com.google.android.gms";
        } else {
            this.f = str;
        }
        if (i < 2) {
            Account accountE = null;
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                al akVar = iInterfaceQueryLocalInterface instanceof al ? (al) iInterfaceQueryLocalInterface : new ak(iBinder);
                if (akVar != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        accountE = akVar.e();
                    } catch (RemoteException unused) {
                    } finally {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                }
            }
            this.j = accountE;
        } else {
            this.g = iBinder;
            this.j = account;
        }
        this.h = zVarArr;
        this.i = bundle;
        this.k = dVarArr;
        this.l = dVarArr2;
        this.m = z;
        this.f481n = i4;
        this.o = z2;
        this.p = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        y.a(this, parcel, i);
    }
}
