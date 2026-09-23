package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class MapStyleOptions extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new n();
    public final String a;

    public MapStyleOptions(String str) {
        this.a = str;
    }

    public static MapStyleOptions loadRawResourceStyle(Context context, int i) throws Resources.NotFoundException {
        try {
            return new MapStyleOptions(new String(com.google.android.libraries.navigation.internal.ll.h.b(context.getResources().openRawResource(i), true), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new Resources.NotFoundException("Failed to read resource " + i + ": " + e.toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
