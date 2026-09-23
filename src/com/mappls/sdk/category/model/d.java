package com.mappls.sdk.category.model;

import android.os.Parcel;

/* JADX INFO: loaded from: classes6.dex */
final class d extends b {
    d(Integer num, Integer num2, Boolean bool, Integer num3, Integer num4, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool2, Boolean bool3, String str7, String str8, String str9, Integer num5, Boolean bool4, Boolean bool5) {
        super(num, num2, bool, num3, num4, str, str2, str3, str4, str5, str6, bool2, bool3, str7, str8, str9, num5, bool4, bool5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(maxSelectionCount().intValue());
        parcel.writeInt(searchType().intValue());
        parcel.writeInt(isUsingInternalMap().booleanValue() ? 1 : 0);
        parcel.writeInt(radius().intValue());
        if (page() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(page().intValue());
        }
        if (location() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(location());
        }
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
        if (path() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(path());
        }
        if (geometries() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(geometries());
        }
        if (buffer() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(buffer().intValue());
        }
        if (isSort() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(isSort().booleanValue() ? 1 : 0);
        }
        parcel.writeInt(showRequestOnMap().booleanValue() ? 1 : 0);
    }
}
