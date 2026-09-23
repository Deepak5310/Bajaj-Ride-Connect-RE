package com.mappls.sdk.navigation.ui.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Parcelable {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            parcel.writeBoolean(this.a);
        } else {
            parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        }
        if (i2 >= 29) {
            parcel.writeBoolean(this.b);
        } else {
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        }
        if (i2 >= 29) {
            parcel.writeBoolean(this.c);
        } else {
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        }
        if (i2 >= 29) {
            parcel.writeBoolean(this.d);
        } else {
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        }
        if (i2 >= 29) {
            parcel.writeBoolean(this.e);
        } else {
            parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        }
    }
}
