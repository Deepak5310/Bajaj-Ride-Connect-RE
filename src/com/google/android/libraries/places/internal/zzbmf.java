package com.google.android.libraries.places.internal;

import com.facebook.imageutils.JfifUtil;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbmf {
    private final String zza;
    private final int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private char[] zzg;

    public zzbmf(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.zza = name;
        this.zzb = name.length();
    }

    private final char zzb() {
        int i;
        int i2;
        int i3 = this.zzc + 1;
        this.zzc = i3;
        if (i3 == this.zzb) {
            throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
        }
        char c = this.zzg[i3];
        if (c != ' ' && c != '%' && c != '\\' && c != '_' && c != '\"' && c != '#') {
            switch (c) {
                default:
                    switch (c) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            int iZzc = zzc(i3);
                            this.zzc++;
                            if (iZzc >= 128) {
                                if (iZzc < 192 || iZzc > 247) {
                                    iZzc = 63;
                                } else {
                                    if (iZzc <= 223) {
                                        i = iZzc & 31;
                                        i2 = 1;
                                    } else if (iZzc <= 239) {
                                        i = iZzc & 15;
                                        i2 = 2;
                                    } else {
                                        i = iZzc & 7;
                                        i2 = 3;
                                    }
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 < i2) {
                                            int i5 = this.zzc;
                                            int i6 = i5 + 1;
                                            this.zzc = i6;
                                            if (i6 != this.zzb && this.zzg[i6] == '\\') {
                                                int i7 = i5 + 2;
                                                this.zzc = i7;
                                                int iZzc2 = zzc(i7);
                                                this.zzc++;
                                                if ((iZzc2 & JfifUtil.MARKER_SOFn) == 128) {
                                                    i = (i << 6) + (iZzc2 & 63);
                                                    i4++;
                                                }
                                            }
                                            iZzc = 63;
                                        } else {
                                            iZzc = (char) i;
                                        }
                                    }
                                }
                            }
                            return (char) iZzc;
                    }
                case '*':
                case '+':
                case ',':
                    return c;
            }
        }
        return c;
    }

    private final int zzc(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.zzb) {
            throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
        }
        char[] cArr = this.zzg;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
            }
            i2 = c - '7';
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    private final String zzd() {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        char c2;
        char c3;
        int i5;
        char c4;
        char c5;
        while (true) {
            i = this.zzc;
            i2 = this.zzb;
            if (i >= i2 || this.zzg[i] != ' ') {
                break;
            }
            this.zzc = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.zzd = i;
        this.zzc = i + 1;
        while (true) {
            i3 = this.zzc;
            i4 = this.zzb;
            if (i3 >= i4 || (c5 = this.zzg[i3]) == '=' || c5 == ' ') {
                break;
            }
            this.zzc = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
        }
        this.zze = i3;
        if (this.zzg[i3] == ' ') {
            while (true) {
                i3 = this.zzc;
                i5 = this.zzb;
                if (i3 >= i5 || (c4 = this.zzg[i3]) == '=' || c4 != ' ') {
                    break;
                }
                this.zzc = i3 + 1;
            }
            if (this.zzg[i3] != '=' || i3 == i5) {
                throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
            }
        }
        this.zzc = i3 + 1;
        while (true) {
            int i6 = this.zzc;
            if (i6 >= this.zzb || this.zzg[i6] != ' ') {
                break;
            }
            this.zzc = i6 + 1;
        }
        int i7 = this.zze;
        int i8 = this.zzd;
        if (i7 - i8 > 4) {
            char[] cArr = this.zzg;
            if (cArr[i8 + 3] == '.' && (((c = cArr[i8]) == 'O' || c == 'o') && (((c2 = cArr[i8 + 1]) == 'I' || c2 == 'i') && ((c3 = cArr[i8 + 2]) == 'D' || c3 == 'd')))) {
                i8 += 4;
                this.zzd = i8;
            }
        }
        return new String(this.zzg, i8, i7 - i8);
    }

    public final String zza(String str) {
        String str2;
        char[] cArr;
        char c;
        int i;
        int i2;
        char c2;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = this.zza.toCharArray();
        String strZzd = zzd();
        if (strZzd == null) {
            return null;
        }
        do {
            int i3 = this.zzc;
            int i4 = this.zzb;
            if (i3 == i4) {
                return null;
            }
            char c3 = this.zzg[i3];
            if (c3 == '\"') {
                int i5 = i3 + 1;
                this.zzc = i5;
                this.zzd = i5;
                this.zze = i5;
                while (true) {
                    int i6 = this.zzc;
                    if (i6 == this.zzb) {
                        throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
                    }
                    char[] cArr2 = this.zzg;
                    char c4 = cArr2[i6];
                    if (c4 == '\"') {
                        this.zzc = i6 + 1;
                        while (true) {
                            int i7 = this.zzc;
                            if (i7 >= this.zzb || this.zzg[i7] != ' ') {
                                break;
                            }
                            this.zzc = i7 + 1;
                        }
                        char[] cArr3 = this.zzg;
                        int i8 = this.zzd;
                        str2 = new String(cArr3, i8, this.zze - i8);
                        break;
                    }
                    if (c4 == '\\') {
                        cArr2[this.zze] = zzb();
                    } else {
                        cArr2[this.zze] = c4;
                    }
                    this.zzc++;
                    this.zze++;
                }
            } else if (c3 != '#') {
                if (c3 == '+' || c3 == ',' || c3 == ';') {
                    str2 = "";
                } else {
                    this.zzd = i3;
                    this.zze = i3;
                    while (true) {
                        int i9 = this.zzc;
                        if (i9 >= this.zzb) {
                            char[] cArr4 = this.zzg;
                            int i10 = this.zzd;
                            str2 = new String(cArr4, i10, this.zze - i10);
                            break;
                        }
                        char[] cArr5 = this.zzg;
                        char c5 = cArr5[i9];
                        if (c5 != ' ') {
                            if (c5 != ';') {
                                if (c5 == '\\') {
                                    int i11 = this.zze;
                                    this.zze = i11 + 1;
                                    cArr5[i11] = zzb();
                                    this.zzc++;
                                } else if (c5 != '+' && c5 != ',') {
                                    int i12 = this.zze;
                                    this.zze = i12 + 1;
                                    cArr5[i12] = c5;
                                    this.zzc = i9 + 1;
                                }
                            }
                            int i13 = this.zzd;
                            str2 = new String(cArr5, i13, this.zze - i13);
                            break;
                        }
                        int i14 = this.zze;
                        this.zzf = i14;
                        this.zzc = i9 + 1;
                        this.zze = i14 + 1;
                        cArr5[i14] = ' ';
                        while (true) {
                            i = this.zzc;
                            i2 = this.zzb;
                            if (i >= i2) {
                                break;
                            }
                            char[] cArr6 = this.zzg;
                            if (cArr6[i] != ' ') {
                                break;
                            }
                            int i15 = this.zze;
                            this.zze = i15 + 1;
                            cArr6[i15] = ' ';
                            this.zzc = i + 1;
                        }
                        if (i == i2 || (c2 = this.zzg[i]) == ',' || c2 == '+' || c2 == ';') {
                            char[] cArr7 = this.zzg;
                            int i16 = this.zzd;
                            str2 = new String(cArr7, i16, this.zzf - i16);
                            break;
                        }
                    }
                }
            } else {
                if (i3 + 4 >= i4) {
                    throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
                }
                this.zzd = i3;
                this.zzc = i3 + 1;
                while (true) {
                    int i17 = this.zzc;
                    if (i17 == this.zzb || (c = (cArr = this.zzg)[i17]) == '+' || c == ',' || c == ';') {
                        this.zze = i17;
                        break;
                    }
                    int i18 = i17 + 1;
                    if (c == ' ') {
                        this.zze = i17;
                        this.zzc = i18;
                        while (true) {
                            int i19 = this.zzc;
                            if (i19 >= this.zzb || this.zzg[i19] != ' ') {
                                break;
                            }
                            this.zzc = i19 + 1;
                        }
                    } else {
                        if (c >= 'A' && c <= 'F') {
                            cArr[i17] = (char) (c + ' ');
                        }
                        this.zzc = i18;
                    }
                }
                int i20 = this.zze;
                int i21 = this.zzd;
                int i22 = i20 - i21;
                if (i22 < 5 || (i22 & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
                }
                int i23 = i22 >> 1;
                byte[] bArr = new byte[i23];
                int i24 = i21 + 1;
                int i25 = 0;
                while (i25 < i23) {
                    bArr[i25] = (byte) zzc(i24);
                    i25++;
                    i24 += 2;
                }
                str2 = new String(this.zzg, this.zzd, i22);
            }
            if ("cn".equalsIgnoreCase(strZzd)) {
                return str2;
            }
            int i26 = this.zzc;
            if (i26 >= this.zzb) {
                return null;
            }
            char c6 = this.zzg[i26];
            if (c6 != ',' && c6 != ';' && c6 != '+') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
            }
            this.zzc = i26 + 1;
            strZzd = zzd();
        } while (strZzd != null);
        throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
    }
}
