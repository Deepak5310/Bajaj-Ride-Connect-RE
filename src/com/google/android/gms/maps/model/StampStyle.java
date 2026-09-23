package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class StampStyle extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<StampStyle> CREATOR = new u();
    protected final BitmapDescriptor a;

    /* JADX INFO: compiled from: PG */
    static abstract class Builder<T extends Builder<T>> {
        BitmapDescriptor a;

        protected abstract Builder a();

        public T stamp(BitmapDescriptor bitmapDescriptor) {
            this.a = bitmapDescriptor;
            return (T) a();
        }
    }

    protected StampStyle(BitmapDescriptor bitmapDescriptor) {
        this.a = bitmapDescriptor;
    }

    public boolean a() {
        return false;
    }

    public BitmapDescriptor getStamp() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 2, this.a.a.asBinder());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public StampStyle(IBinder iBinder) {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        if (iBinder == null) {
            jVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            jVar = iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lo.j(iBinder);
        }
        this.a = new BitmapDescriptor(jVar);
    }
}
