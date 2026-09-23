package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbno {
    String zza;
    String zzb;
    int zzc = -1;

    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078 A[LOOP:3: B:32:0x005d->B:43:0x0078, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x0080 A[LOOP:2: B:24:0x004a->B:46:0x0080, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1 A[LOOP:1: B:53:0x0094->B:57:0x00a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x00a7 A[EDGE_INSN: B:83:0x00a7->B:58:0x00a7 BREAK  A[LOOP:1: B:53:0x0094->B:57:0x00a1], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0090 A[SYNTHETIC] */
    private static InetAddress zzf(String str, int i, int i2) {
        int i3;
        int i4;
        char cCharAt;
        int i5;
        int i6;
        int iZza;
        byte[] bArr = new byte[16];
        int i7 = 0;
        int i8 = 1;
        int i9 = -1;
        int i10 = -1;
        int i11 = 0;
        while (i8 < i2) {
            if (i11 == 16) {
                return null;
            }
            int i12 = i8 + 2;
            if (i12 <= i2 && str.regionMatches(i8, "::", i7, 2)) {
                if (i9 != -1) {
                    return null;
                }
                i11 += 2;
                if (i12 == i2) {
                    i9 = i11;
                    break;
                }
                i9 = i11;
                i10 = i12;
                i8 = i10;
                i5 = 0;
                while (i8 < i2) {
                    iZza = zzbnq.zza(str.charAt(i8));
                    if (iZza == -1) {
                        break;
                        break;
                    }
                    i8++;
                    i5 = (i5 << 4) + iZza;
                }
                i6 = i8 - i10;
                if (i6 != 0) {
                }
                return null;
            }
            if (i11 != 0) {
                if (!str.regionMatches(i8, ":", i7, 1)) {
                    if (str.regionMatches(i8, ".", i7, 1)) {
                        int i13 = i11 - 2;
                        int i14 = i13;
                        while (i10 < i2) {
                            if (i14 != 16) {
                                if (i14 == i13) {
                                    i3 = i7;
                                    i4 = i10;
                                    while (i4 < i2) {
                                        cCharAt = str.charAt(i4);
                                        if (cCharAt < '0' || cCharAt > '9') {
                                            break;
                                        }
                                        if (i3 != 0) {
                                            i3 = ((i3 * 10) + cCharAt) - 48;
                                            if (i3 <= 255) {
                                                i4++;
                                            }
                                        } else if (i10 == i4) {
                                            i3 = 0;
                                            i3 = ((i3 * 10) + cCharAt) - 48;
                                            if (i3 <= 255) {
                                                i4++;
                                            }
                                        }
                                    }
                                    if (i4 - i10 != 0) {
                                        bArr[i14] = (byte) i3;
                                        i14++;
                                        i10 = i4;
                                        i7 = 0;
                                    }
                                } else if (str.charAt(i10) == '.') {
                                    i10++;
                                    i3 = i7;
                                    i4 = i10;
                                    while (i4 < i2) {
                                        cCharAt = str.charAt(i4);
                                        if (cCharAt < '0') {
                                            break;
                                        }
                                        break;
                                        break;
                                    }
                                    if (i4 - i10 != 0) {
                                        bArr[i14] = (byte) i3;
                                        i14++;
                                        i10 = i4;
                                        i7 = 0;
                                    }
                                }
                            }
                        }
                        if (i14 == i11 + 2) {
                            i11 += 2;
                            break;
                        }
                    }
                    return null;
                }
                i8++;
            }
            i10 = i8;
            i8 = i10;
            i5 = 0;
            while (i8 < i2) {
                iZza = zzbnq.zza(str.charAt(i8));
                if (iZza == -1) {
                    break;
                }
                i8++;
                i5 = (i5 << 4) + iZza;
            }
            i6 = i8 - i10;
            if (i6 != 0 || i6 > 4) {
                return null;
            }
            int i15 = i11 + 1;
            bArr[i11] = (byte) ((i5 >>> 8) & 255);
            i11 += 2;
            bArr[i15] = (byte) (i5 & 255);
            i7 = 0;
        }
        if (i11 != 16) {
            if (i9 == -1) {
                return null;
            }
            int i16 = i11 - i9;
            System.arraycopy(bArr, i9, bArr, 16 - i16, i16);
            Arrays.fill(bArr, i9, (16 - i11) + i9, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zza);
        sb.append("://");
        if (this.zzb.indexOf(58) != -1) {
            sb.append('[');
            sb.append(this.zzb);
            sb.append(']');
        } else {
            sb.append(this.zzb);
        }
        int iZza = zza();
        if (iZza != zzbnq.zzb(this.zza)) {
            sb.append(':');
            sb.append(iZza);
        }
        return sb.toString();
    }

    final int zza() {
        int i = this.zzc;
        return i != -1 ? i : zzbnq.zzb(this.zza);
    }

    public final zzbno zzb(String str) {
        int i;
        String strSubstring;
        if (str == null) {
            throw new IllegalArgumentException("host == null");
        }
        int i2 = 0;
        int iCharCount = 0;
        while (true) {
            int length = str.length();
            i = -1;
            if (iCharCount >= length) {
                strSubstring = str.substring(0, length);
                break;
            }
            if (str.charAt(iCharCount) == '%') {
                zzbpl zzbplVar = new zzbpl();
                zzbplVar.zzt(str, 0, iCharCount);
                while (iCharCount < length) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt != 37) {
                        zzbplVar.zzu(iCodePointAt);
                    } else {
                        int i3 = iCharCount + 2;
                        if (i3 < length) {
                            int iZza = zzbnq.zza(str.charAt(iCharCount + 1));
                            int iZza2 = zzbnq.zza(str.charAt(i3));
                            if (iZza != -1 && iZza2 != -1) {
                                zzbplVar.zzm((iZza << 4) + iZza2);
                                iCharCount = i3;
                                iCodePointAt = 37;
                            }
                        }
                        iCodePointAt = 37;
                        zzbplVar.zzu(iCodePointAt);
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                }
                strSubstring = zzbplVar.zzi();
                break;
            }
            iCharCount++;
        }
        String strZzi = null;
        if (strSubstring.startsWith("[") && strSubstring.endsWith("]")) {
            InetAddress inetAddressZzf = zzf(strSubstring, 1, strSubstring.length() - 1);
            if (inetAddressZzf != null) {
                byte[] address = inetAddressZzf.getAddress();
                if (address.length != 16) {
                    throw new AssertionError();
                }
                int i4 = 0;
                int i5 = 0;
                while (i4 < address.length) {
                    int i6 = i4;
                    while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                        i6 += 2;
                    }
                    int i7 = i6 - i4;
                    int i8 = i7 > i5 ? i7 : i5;
                    if (i7 > i5) {
                        i = i4;
                    }
                    i4 = i6 + 2;
                    i5 = i8;
                }
                zzbpl zzbplVar2 = new zzbpl();
                while (i2 < address.length) {
                    if (i2 == i) {
                        zzbplVar2.zzm(58);
                        i2 += i5;
                        if (i2 == 16) {
                            zzbplVar2.zzm(58);
                        }
                    } else {
                        if (i2 > 0) {
                            zzbplVar2.zzm(58);
                        }
                        zzbplVar2.zzo(((address[i2] & 255) << 8) | (address[i2 + 1] & 255));
                        i2 += 2;
                    }
                }
                strZzi = zzbplVar2.zzi();
            }
        } else {
            try {
                String lowerCase = IDN.toASCII(strSubstring).toLowerCase(Locale.US);
                if (!lowerCase.isEmpty()) {
                    while (true) {
                        if (i2 >= lowerCase.length()) {
                            strZzi = lowerCase;
                            break;
                        }
                        char cCharAt = lowerCase.charAt(i2);
                        if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                            break;
                            break;
                            break;
                        }
                        i2++;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (strZzi == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        this.zzb = strZzi;
        return this;
    }

    public final zzbno zzc(int i) {
        if (i > 0 && i <= 65535) {
            this.zzc = i;
            return this;
        }
        throw new IllegalArgumentException("unexpected port: " + i);
    }

    public final zzbnq zze() {
        if (this.zza == null) {
            throw new IllegalStateException("scheme == null");
        }
        if (this.zzb != null) {
            return new zzbnq(this, null);
        }
        throw new IllegalStateException("host == null");
    }

    public final zzbno zzd(String str) {
        this.zza = UriUtil.HTTPS_SCHEME;
        return this;
    }
}
