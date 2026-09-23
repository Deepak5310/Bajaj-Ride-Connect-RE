package com.google.android.gms.maps.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class TextureStyle extends StampStyle {

    /* JADX INFO: compiled from: PG */
    public static final class Builder extends StampStyle.Builder<Builder> {
        @Override // com.google.android.gms.maps.model.StampStyle.Builder
        protected final /* bridge */ /* synthetic */ StampStyle.Builder a() {
            return this;
        }

        public TextureStyle build() {
            return new TextureStyle(this.a);
        }
    }

    public TextureStyle(BitmapDescriptor bitmapDescriptor) {
        super(bitmapDescriptor);
    }

    public static Builder newBuilder(BitmapDescriptor bitmapDescriptor) {
        return new Builder().stamp(bitmapDescriptor);
    }

    @Override // com.google.android.gms.maps.model.StampStyle
    public final boolean a() {
        return false;
    }
}
