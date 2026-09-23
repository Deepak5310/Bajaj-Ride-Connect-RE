package com.google.android.libraries.navigation.internal.lv;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<ai> CREATOR = new aj();
    public final int a;
    public final IBinder b;
    public final IBinder c;
    public final PendingIntent d;
    public final String e;

    public ai(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str) {
        this.a = i;
        this.b = iBinder;
        this.c = iBinder2;
        this.d = pendingIntent;
        this.e = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.os.IBinder, com.google.android.libraries.navigation.internal.lu.s] */
    public static ai a(IInterface iInterface, com.google.android.libraries.navigation.internal.lu.s sVar, String str) {
        if (iInterface == null) {
            iInterface = null;
        }
        return new ai(2, iInterface, sVar, null, str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, i2);
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, this.d, i);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 6, this.e);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
