package com.google.android.libraries.places.internal;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaxc implements zzavt {
    private static final byte[] zza = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

    private zzaxc() {
    }

    /* synthetic */ zzaxc(zzaxb zzaxbVar) {
    }

    private static boolean zzc(byte b) {
        return b < 32 || b >= 126 || b == 37;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final /* bridge */ /* synthetic */ Object zza(byte[] bArr) {
        int i = 0;
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return new String(bArr, 0);
            }
            byte b = bArr[i];
            if (b < 32 || b >= 126 || (b == 37 && i + 2 < length)) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
                int i2 = 0;
                while (true) {
                    int length2 = bArr.length;
                    if (i2 >= length2) {
                        return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), zzkc.zzc);
                    }
                    int i3 = i2 + 1;
                    if (bArr[i2] == 37 && i2 + 2 < length2) {
                        try {
                            byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i3, 2, zzkc.zza), 16));
                            i2 += 3;
                        } catch (NumberFormatException unused) {
                            byteBufferAllocate.put(bArr[i2]);
                            i2 = i3;
                        }
                    }
                    byteBufferAllocate.put(bArr[i2]);
                    i2 = i3;
                }
            } else {
                i++;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final /* bridge */ /* synthetic */ byte[] zzb(Object obj) {
        byte[] bytes = ((String) obj).getBytes(zzkc.zzc);
        int i = 0;
        while (true) {
            int length = bytes.length;
            if (i >= length) {
                return bytes;
            }
            if (zzc(bytes[i])) {
                byte[] bArr = new byte[((length - i) * 3) + i];
                if (i != 0) {
                    System.arraycopy(bytes, 0, bArr, 0, i);
                }
                int i2 = i;
                while (i < bytes.length) {
                    int i3 = i2 + 1;
                    byte b = bytes[i];
                    if (zzc(b)) {
                        bArr[i2] = 37;
                        byte[] bArr2 = zza;
                        bArr[i3] = bArr2[(b >> 4) & 15];
                        bArr[i2 + 2] = bArr2[b & Ascii.SI];
                        i2 += 3;
                    } else {
                        bArr[i2] = b;
                        i2 = i3;
                    }
                    i++;
                }
                return Arrays.copyOf(bArr, i2);
            }
            i++;
        }
    }
}
