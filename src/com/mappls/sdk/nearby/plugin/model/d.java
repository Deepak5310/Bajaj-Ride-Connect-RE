package com.mappls.sdk.nearby.plugin.model;

import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
final class d extends b {
    d(Integer num, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, String str6) {
        super(num, str, str2, str3, str4, str5, bool, bool2, str6);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(radius().intValue());
        if (sortBy() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(sortBy());
        }
        if (searchBy() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(searchBy());
        }
        if (bounds() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(bounds());
        }
        if (pod() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(pod());
        }
        if (filter() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(filter());
        }
        if (explain() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(explain().booleanValue() ? 1 : 0);
        }
        if (richData() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(richData().booleanValue() ? 1 : 0);
        }
        if (userName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(userName());
        }
    }
}
