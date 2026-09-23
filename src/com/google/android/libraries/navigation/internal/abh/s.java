package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends x {
    private final int a;

    public s(int i) {
        com.google.android.libraries.navigation.internal.abf.t.a(i >= 0, String.format("invalid resource id: %s", Integer.valueOf(i)));
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.x
    public final Bitmap a(be beVar) {
        Bitmap bitmapK = beVar.k(this.a);
        if (bitmapK != null) {
            return bitmapK;
        }
        throw new ApiIllegalArgumentException("Failed to decode image. The provided image must be a Bitmap.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && this.a == ((s) obj).a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a)});
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.abf.aj.f(this).c("resourceId ", this.a).toString();
    }
}
