package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends x {
    private final String a;

    public q(String str) {
        com.google.android.libraries.navigation.internal.abf.t.c(str, "fileName cannot be null");
        this.a = str;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.x
    public final Bitmap a(be beVar) {
        StrictMode.ThreadPolicy threadPolicyA = com.google.android.libraries.navigation.internal.abf.w.a.a();
        try {
            try {
                FileInputStream fileInputStreamOpenFileInput = beVar.a.openFileInput(this.a);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
                    if (bitmapDecodeStream == null) {
                        throw new ApiIllegalArgumentException("Failed to decode image. The provided image must be a Bitmap.");
                    }
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused) {
                    }
                    com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyA);
                    return bitmapDecodeStream;
                } catch (Throwable th) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                throw new ApiIllegalArgumentException("Failed to decode image. The provided image must be a Bitmap.");
            }
        } catch (Throwable th2) {
            com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyA);
            throw th2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return com.google.android.libraries.navigation.internal.abf.r.a(this.a, ((q) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("fileName", this.a);
        return ajVarF.toString();
    }
}
