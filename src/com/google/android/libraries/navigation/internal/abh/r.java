package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends x {
    private final Bitmap a;

    public r(Bitmap bitmap) {
        this.a = bitmap;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.x
    public final Bitmap a(be beVar) {
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            return bitmap;
        }
        throw new ApiIllegalArgumentException("Failed to decode image. The provided image must be a Bitmap.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return com.google.android.libraries.navigation.internal.abf.r.a(this.a, ((r) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("bitmap", this.a);
        return ajVarF.toString();
    }
}
