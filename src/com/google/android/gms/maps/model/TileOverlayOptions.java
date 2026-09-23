package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class TileOverlayOptions extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new af();
    public com.google.android.libraries.navigation.internal.lz.ab a;
    private TileProvider b;
    private boolean c;
    private float d;
    private boolean e;
    private float f;

    public TileOverlayOptions() {
        this.c = true;
        this.e = true;
        this.f = 0.0f;
    }

    public TileOverlayOptions(boolean z, float f, boolean z2, float f2) {
        this.c = true;
        this.e = true;
        this.f = 0.0f;
        this.a = null;
        this.b = null;
        this.c = z;
        this.d = f;
        this.e = z2;
        this.f = f2;
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.e = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.e;
    }

    public TileProvider getTileProvider() {
        return this.b;
    }

    public float getTransparency() {
        return this.f;
    }

    public float getZIndex() {
        return this.d;
    }

    public boolean isVisible() {
        return this.c;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.b = tileProvider;
        this.a = tileProvider == null ? null : new ae(tileProvider);
        return this;
    }

    public TileOverlayOptions transparency(float f) {
        boolean z = false;
        if (f >= 0.0f && f <= 1.0f) {
            z = true;
        }
        be.b(z, "Transparency must be in the range [0..1]");
        this.f = f;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.c = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 3, isVisible());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 4, getZIndex());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 5, getFadeIn());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 6, getTransparency());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public TileOverlayOptions zIndex(float f) {
        this.d = f;
        return this;
    }
}
