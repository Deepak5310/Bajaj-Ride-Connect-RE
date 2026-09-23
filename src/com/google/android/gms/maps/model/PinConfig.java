package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class PinConfig extends com.google.android.libraries.navigation.internal.li.a {
    public static final int BITMAP_LENGTH_DP = 37;
    public static final int BITMAP_WIDTH_DP = 26;
    public static final Parcelable.Creator<PinConfig> CREATOR = new q();
    public static final int DEFAULT_PIN_BACKGROUND_COLOR = -1424587;
    public static final int DEFAULT_PIN_BORDER_COLOR = -3857889;
    public static final int DEFAULT_PIN_GLYPH_COLOR = -5041134;
    private final int a;
    private final int b;
    private final Glyph c;

    /* JADX INFO: compiled from: PG */
    public static class Builder {
        private int a = PinConfig.DEFAULT_PIN_BACKGROUND_COLOR;
        private int b = PinConfig.DEFAULT_PIN_BORDER_COLOR;
        private Glyph c = new Glyph(PinConfig.DEFAULT_PIN_GLYPH_COLOR);

        public PinConfig build() {
            return new PinConfig(this.a, this.b, this.c);
        }

        public Builder setBackgroundColor(int i) {
            this.a = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.b = i;
            return this;
        }

        public Builder setGlyph(Glyph glyph) {
            this.c = glyph;
            return this;
        }
    }

    /* JADX INFO: compiled from: PG */
    public static class Glyph extends com.google.android.libraries.navigation.internal.li.a {
        public static final Parcelable.Creator<Glyph> CREATOR = new i();
        public static final float DEFAULT_CIRCLE_RADIUS_DP = 5.0f;
        public static final float X_COORDINATE_DP = 13.0f;
        public static final float Y_COORDINATE_DP = 13.0f;
        public BitmapDescriptor a;
        private String b;
        private int c;
        private int d;

        public Glyph(int i) {
            this.d = ViewCompat.MEASURED_STATE_MASK;
            this.c = i;
        }

        public Glyph(BitmapDescriptor bitmapDescriptor) {
            this.c = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.d = ViewCompat.MEASURED_STATE_MASK;
            this.a = bitmapDescriptor;
        }

        public Glyph(String str) {
            this(str, ViewCompat.MEASURED_STATE_MASK);
        }

        public Glyph(String str, int i) {
            this.c = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.b = str;
            this.d = i;
        }

        public Glyph(String str, IBinder iBinder, int i, int i2) {
            BitmapDescriptor bitmapDescriptor;
            this.c = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.d = ViewCompat.MEASURED_STATE_MASK;
            this.b = str;
            if (iBinder == null) {
                bitmapDescriptor = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
                bitmapDescriptor = new BitmapDescriptor(iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lo.j(iBinder));
            }
            this.a = bitmapDescriptor;
            this.c = i;
            this.d = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Glyph)) {
                return false;
            }
            Glyph glyph = (Glyph) obj;
            if (this.c != glyph.c || !Objects.equals(this.b, glyph.b) || this.d != glyph.d) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor = this.a;
            if ((bitmapDescriptor == null && glyph.a != null) || (bitmapDescriptor != null && glyph.a == null)) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor2 = glyph.a;
            if (bitmapDescriptor == null || bitmapDescriptor2 == null) {
                return true;
            }
            return Objects.equals(com.google.android.libraries.navigation.internal.lo.n.b(bitmapDescriptor.a), com.google.android.libraries.navigation.internal.lo.n.b(bitmapDescriptor2.a));
        }

        public BitmapDescriptor getBitmapDescriptor() {
            return this.a;
        }

        public int getGlyphColor() {
            return this.c;
        }

        public String getText() {
            return this.b;
        }

        public int getTextColor() {
            return this.d;
        }

        public int hashCode() {
            return Objects.hash(this.b, this.a, Integer.valueOf(this.c));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
            com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, getText());
            BitmapDescriptor bitmapDescriptor = this.a;
            com.google.android.libraries.navigation.internal.li.d.n(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.a.asBinder());
            com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, getGlyphColor());
            com.google.android.libraries.navigation.internal.li.d.h(parcel, 5, getTextColor());
            com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
        }
    }

    public PinConfig(int i, int i2, Glyph glyph) {
        this.a = i;
        this.b = i2;
        this.c = glyph;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getBackgroundColor() {
        return this.a;
    }

    public int getBorderColor() {
        return this.b;
    }

    public Glyph getGlyph() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, getBackgroundColor());
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, getBorderColor());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, getGlyph(), i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
