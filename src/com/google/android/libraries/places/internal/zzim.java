package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzim implements Parcelable.Creator {
    zzim() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzin((AutocompleteActivityMode) parcel.readParcelable(zziu.class.getClassLoader()), zzlx.zzj(parcel.readArrayList(Place.Field.class.getClassLoader())), (zzis) parcel.readParcelable(zziu.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, (LocationBias) parcel.readParcelable(zziu.class.getClassLoader()), (LocationRestriction) parcel.readParcelable(zziu.class.getClassLoader()), zzlx.zzj(parcel.readArrayList(String.class.getClassLoader())), (TypeFilter) parcel.readParcelable(zziu.class.getClassLoader()), zzlx.zzj(parcel.readArrayList(String.class.getClassLoader())), parcel.readInt(), parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzin[i];
    }
}
