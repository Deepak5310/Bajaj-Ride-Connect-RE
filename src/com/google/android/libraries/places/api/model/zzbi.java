package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbi extends zzv {
    public static final Parcelable.Creator<zzbi> CREATOR = new zzbh();

    zzbi(String str, int i, int i2, String str2, AuthorAttributions authorAttributions) {
        super(str, i, i2, str2, authorAttributions);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAttributions());
        parcel.writeInt(getHeight());
        parcel.writeInt(getWidth());
        parcel.writeString(zza());
        parcel.writeParcelable(getAuthorAttributions(), i);
    }
}
