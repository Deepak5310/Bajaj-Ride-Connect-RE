package com.google.android.libraries.navigation;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class at implements Parcelable.Creator {
    public static final SpeedAlertOptions a(Parcel parcel) {
        try {
            return new SpeedAlertOptions(parcel.readFloat(), parcel.readFloat(), parcel.readDouble());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static final SpeedAlertOptions[] b(int i) {
        try {
            return new SpeedAlertOptions[i];
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return b(i);
    }
}
