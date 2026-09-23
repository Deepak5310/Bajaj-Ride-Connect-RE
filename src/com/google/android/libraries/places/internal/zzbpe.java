package com.google.android.libraries.places.internal;

import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\nH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\r"}, d2 = {"BASE64", "", "getBASE64$annotations", "()V", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "third_party.java_src.okio_okio-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class zzbpe {
    private static final byte[] zza;
    private static final byte[] zzb;

    static {
        zzbpo zzbpoVar = zzbpp.zza;
        zza = zzbpo.zza("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getZzc();
        zzb = zzbpo.zza("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getZzc();
    }

    public static /* synthetic */ String zza(byte[] bArr, byte[] bArr2, int i, Object obj) {
        byte[] map = zza;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        int length = bArr.length;
        int i2 = length + 2;
        int i3 = length - (length % 3);
        byte[] bArr3 = new byte[(i2 / 3) * 4];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 3;
            byte b = bArr[i4];
            int i7 = i4 + 2;
            byte b2 = bArr[i4 + 1];
            i4 += 3;
            byte b3 = bArr[i7];
            bArr3[i5] = map[(b & 255) >> 2];
            bArr3[i5 + 1] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            bArr3[i5 + 2] = map[((b2 & Ascii.SI) << 2) | ((b3 & 255) >> 6)];
            i5 += 4;
            bArr3[i6] = map[b3 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length - i3;
        if (length2 == 1) {
            byte b4 = bArr[i4];
            bArr3[i5] = map[(b4 & 255) >> 2];
            bArr3[i5 + 1] = map[(b4 & 3) << 4];
            bArr3[i5 + 2] = Base64.padSymbol;
            bArr3[i5 + 3] = Base64.padSymbol;
        } else if (length2 == 2) {
            int i8 = i4 + 1;
            byte b5 = bArr[i4];
            byte b6 = bArr[i8];
            bArr3[i5] = map[(b5 & 255) >> 2];
            bArr3[i5 + 1] = map[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            bArr3[i5 + 2] = map[(b6 & Ascii.SI) << 2];
            bArr3[i5 + 3] = Base64.padSymbol;
        }
        return zzbqg.zza(bArr3);
    }
}
