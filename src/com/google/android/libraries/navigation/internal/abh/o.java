package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends x {
    private final String a;

    public o(String str) {
        com.google.android.libraries.navigation.internal.abf.t.c(str, "assetName cannot be null");
        this.a = str;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.x
    public final Bitmap a(be beVar) {
        try {
            InputStream inputStreamOpen = beVar.a.getAssets().open(this.a);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                if (bitmapDecodeStream == null) {
                    throw new ApiIllegalArgumentException("Failed to decode image. The provided image must be a Bitmap.");
                }
                try {
                    inputStreamOpen.close();
                } catch (IOException unused) {
                }
                return bitmapDecodeStream;
            } catch (Throwable th) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            throw new ApiIllegalArgumentException("Failed to decode image. The provided image must be a Bitmap.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            return com.google.android.libraries.navigation.internal.abf.r.a(this.a, ((o) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("assetName", this.a);
        return ajVarF.toString();
    }
}
