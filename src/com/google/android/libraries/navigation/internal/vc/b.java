package com.google.android.libraries.navigation.internal.vc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public Integer a;
    public Integer b;
    public Integer c;
    public Integer d;
    public Integer e;
    public Integer f;
    public String g;
    public Integer h;
    public Float i;
    public Float j;
    public String k;
    public Integer l;
    public Float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f634n;
    public Integer o;
    public Float p;
    public Integer q;
    public Float r;
    public Integer s;

    public b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f634n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
    }

    public b(b bVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f634n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.f634n = bVar.f634n;
        this.o = bVar.o;
        this.p = bVar.p;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.a);
        parcel.writeValue(this.b);
        parcel.writeValue(this.c);
        parcel.writeValue(this.d);
        parcel.writeValue(this.e);
        parcel.writeValue(this.f);
        parcel.writeString(this.g);
        parcel.writeValue(this.h);
        parcel.writeValue(this.i);
        parcel.writeValue(this.j);
        parcel.writeString(this.k);
        parcel.writeValue(this.l);
        parcel.writeValue(this.m);
        parcel.writeString(this.f634n);
        parcel.writeValue(this.o);
        parcel.writeValue(this.p);
        parcel.writeValue(this.q);
        parcel.writeValue(this.r);
        parcel.writeValue(this.s);
    }
}
