package com.google.android.libraries.places.internal;

import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzauh {
    public static final Charset zza = Charset.forName(CharEncoding.US_ASCII);
    public static final zzqi zzb = zzavu.zzc;

    public static int zza(zzavu zzavuVar) {
        return zzavuVar.zza();
    }

    public static zzavp zzb(String str, zzaug zzaugVar) {
        boolean z = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return new zzavs(str, z, zzaugVar, null);
    }

    public static zzavu zzc(byte[]... bArr) {
        return new zzavu(bArr.length >> 1, bArr);
    }

    public static byte[][] zzd(zzavu zzavuVar) {
        return zzavuVar.zzg();
    }
}
