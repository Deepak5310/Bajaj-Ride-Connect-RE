package com.google.android.libraries.navigation.internal.vc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        b bVar = new b();
        ClassLoader classLoader = Integer.class.getClassLoader();
        ClassLoader classLoader2 = Float.class.getClassLoader();
        bVar.a = (Integer) parcel.readValue(classLoader);
        bVar.b = (Integer) parcel.readValue(classLoader);
        bVar.c = (Integer) parcel.readValue(classLoader);
        bVar.d = (Integer) parcel.readValue(classLoader);
        bVar.e = (Integer) parcel.readValue(classLoader);
        bVar.f = (Integer) parcel.readValue(classLoader);
        bVar.g = parcel.readString();
        bVar.h = (Integer) parcel.readValue(classLoader);
        bVar.i = (Float) parcel.readValue(classLoader2);
        bVar.j = (Float) parcel.readValue(classLoader2);
        bVar.k = parcel.readString();
        bVar.l = (Integer) parcel.readValue(classLoader);
        bVar.m = (Float) parcel.readValue(classLoader2);
        bVar.f634n = parcel.readString();
        bVar.o = (Integer) parcel.readValue(classLoader);
        bVar.p = (Float) parcel.readValue(classLoader2);
        bVar.q = (Integer) parcel.readValue(classLoader);
        bVar.r = (Float) parcel.readValue(classLoader2);
        bVar.s = (Integer) parcel.readValue(classLoader);
        return bVar;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
