package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzbmu {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String zzf;

    zzbmu(String str) {
        this.zzf = str;
    }

    public static zzbmu zza(String str) throws IOException {
        zzbmu zzbmuVar = HTTP_1_0;
        if (str.equals(zzbmuVar.zzf)) {
            return zzbmuVar;
        }
        zzbmu zzbmuVar2 = HTTP_1_1;
        if (str.equals(zzbmuVar2.zzf)) {
            return zzbmuVar2;
        }
        zzbmu zzbmuVar3 = HTTP_2;
        if (str.equals(zzbmuVar3.zzf)) {
            return zzbmuVar3;
        }
        zzbmu zzbmuVar4 = SPDY_3;
        if (str.equals(zzbmuVar4.zzf)) {
            return zzbmuVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzf;
    }
}
