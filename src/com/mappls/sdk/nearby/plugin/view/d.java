package com.mappls.sdk.nearby.plugin.view;

import android.graphics.Bitmap;
import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
final class d extends b {
    d(Integer num, Integer num2, Integer num3, Bitmap bitmap, Integer num4, String str, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, String str2, String str3) {
        super(num, num2, num3, bitmap, num4, str, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15, num16, num17, num18, str2, str3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iIntValue;
        parcel.writeInt(backgroundColor().intValue());
        parcel.writeInt(toolbarBackgroundColor().intValue());
        parcel.writeInt(toolbarIcon().intValue());
        parcel.writeParcelable(toolbarBitmap(), i);
        parcel.writeInt(toolbarTextColor().intValue());
        parcel.writeString(toolbarText());
        parcel.writeInt(addressBackgroundColor().intValue());
        parcel.writeInt(addressTooltipTextColor().intValue());
        parcel.writeInt(addressTextColor().intValue());
        parcel.writeInt(changeLocationButtonTextColor().intValue());
        parcel.writeInt(useCurrentLocationButtonTextColor().intValue());
        parcel.writeInt(selectedCategoryBackgroundColor().intValue());
        parcel.writeInt(selectedCategoryTextColor().intValue());
        parcel.writeInt(selectedCategoryTintColor().intValue());
        parcel.writeInt(categoryBackgroundColor().intValue());
        parcel.writeInt(categoryTextColor().intValue());
        parcel.writeInt(categoryTintColor().intValue());
        parcel.writeInt(submitButtonResource().intValue());
        if (submitButtonColor() == null) {
            iIntValue = 1;
        } else {
            parcel.writeInt(0);
            iIntValue = submitButtonColor().intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeInt(submitButtonTextColor().intValue());
        parcel.writeString(submitButtonText());
        parcel.writeString(locationInfoLabelText());
    }
}
