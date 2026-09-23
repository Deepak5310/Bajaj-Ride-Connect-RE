package com.mappls.sdk.navigation.ui;

import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends b {
    public c(Integer num, Integer num2, String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Integer num3) {
        super(num, num2, str, str2, bool, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, num3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.intValue());
        parcel.writeInt(this.b.intValue());
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e.booleanValue() ? 1 : 0);
        parcel.writeInt(this.f.booleanValue() ? 1 : 0);
        parcel.writeInt(this.g.booleanValue() ? 1 : 0);
        parcel.writeInt(this.h.booleanValue() ? 1 : 0);
        parcel.writeInt(this.i.booleanValue() ? 1 : 0);
        parcel.writeInt(this.j.booleanValue() ? 1 : 0);
        parcel.writeInt(this.k.booleanValue() ? 1 : 0);
        parcel.writeInt(this.l.booleanValue() ? 1 : 0);
        parcel.writeInt(this.m.booleanValue() ? 1 : 0);
        parcel.writeInt(this.f716n.booleanValue() ? 1 : 0);
        parcel.writeInt(this.o.booleanValue() ? 1 : 0);
        parcel.writeInt(this.p.booleanValue() ? 1 : 0);
        parcel.writeInt(this.q.intValue());
    }
}
