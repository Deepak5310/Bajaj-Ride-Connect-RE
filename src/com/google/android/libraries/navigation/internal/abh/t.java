package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends x {
    private final String a;

    public t(String str) {
        com.google.android.libraries.navigation.internal.abf.t.c(str, "absolutePath cannot be null");
        this.a = str;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.x
    public final Bitmap a(be beVar) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.a);
        if (bitmapDecodeFile != null) {
            return bitmapDecodeFile;
        }
        throw new ApiIllegalArgumentException("Failed to decode image. The provided image must be a Bitmap.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t) {
            return com.google.android.libraries.navigation.internal.abf.r.a(this.a, ((t) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("absolutePath", this.a);
        return ajVarF.toString();
    }
}
