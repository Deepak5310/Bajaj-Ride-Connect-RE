package j$.util;

import com.google.common.base.Ascii;
import j$.sun.nio.cs.ISO_8859_1;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public class Base64 {
    public static Encoder getEncoder() {
        return Encoder.RFC4648;
    }

    public static Decoder getDecoder() {
        return Decoder.RFC4648;
    }

    public static class Encoder {
        private static final byte[] CRLF;
        static final Encoder RFC2045;
        static final Encoder RFC4648;
        static final Encoder RFC4648_URLSAFE;
        private static final char[] toBase64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] toBase64URL = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean doPadding;
        private final boolean isURL;
        private final int linemax;
        private final byte[] newline;

        private Encoder(boolean z, byte[] bArr, int i, boolean z2) {
            this.isURL = z;
            this.newline = bArr;
            this.linemax = i;
            this.doPadding = z2;
        }

        static {
            byte[] bArr = {Ascii.CR, 10};
            CRLF = bArr;
            RFC4648 = new Encoder(false, null, -1, true);
            RFC4648_URLSAFE = new Encoder(true, null, -1, true);
            RFC2045 = new Encoder(false, bArr, 76, true);
        }

        private final int outLength(int i) {
            int i2;
            if (this.doPadding) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.linemax;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.newline.length) : i2;
        }

        public byte[] encode(byte[] bArr) {
            int iOutLength = outLength(bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iEncode0 = encode0(bArr, 0, bArr.length, bArr2);
            return iEncode0 != iOutLength ? Arrays.copyOf(bArr2, iEncode0) : bArr2;
        }

        public String encodeToString(byte[] bArr) {
            byte[] bArrEncode = encode(bArr);
            return new String(bArrEncode, 0, 0, bArrEncode.length);
        }

        private void encodeBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3, boolean z) {
            char[] cArr = z ? toBase64URL : toBase64;
            while (i < i2) {
                int i4 = i + 2;
                int i5 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
                i += 3;
                int i6 = i5 | (bArr[i4] & 255);
                bArr2[i3] = (byte) cArr[(i6 >>> 18) & 63];
                bArr2[i3 + 1] = (byte) cArr[(i6 >>> 12) & 63];
                int i7 = i3 + 3;
                bArr2[i3 + 2] = (byte) cArr[(i6 >>> 6) & 63];
                i3 += 4;
                bArr2[i7] = (byte) cArr[i6 & 63];
            }
        }

        private int encode0(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr = this.isURL ? toBase64URL : toBase64;
            int i3 = ((i2 - i) / 3) * 3;
            int i4 = i + i3;
            int i5 = this.linemax;
            if (i5 > 0 && i3 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            }
            int i6 = i3;
            int i7 = i;
            int i8 = 0;
            while (i7 < i4) {
                int iMin = Math.min(i7 + i6, i4);
                encodeBlock(bArr, i7, iMin, bArr2, i8, this.isURL);
                int i9 = ((iMin - i7) / 3) * 4;
                i8 += i9;
                if (i9 == this.linemax && iMin < i2) {
                    byte[] bArr3 = this.newline;
                    int length = bArr3.length;
                    int i10 = 0;
                    while (i10 < length) {
                        bArr2[i8] = bArr3[i10];
                        i10++;
                        i8++;
                    }
                }
                i7 = iMin;
            }
            if (i7 >= i2) {
                return i8;
            }
            int i11 = i7 + 1;
            int i12 = bArr[i7] & 255;
            int i13 = i8 + 1;
            bArr2[i8] = (byte) cArr[i12 >> 2];
            if (i11 == i2) {
                int i14 = i8 + 2;
                bArr2[i13] = (byte) cArr[(i12 << 4) & 63];
                if (!this.doPadding) {
                    return i14;
                }
                int i15 = i8 + 3;
                bArr2[i14] = kotlin.io.encoding.Base64.padSymbol;
                int i16 = i8 + 4;
                bArr2[i15] = kotlin.io.encoding.Base64.padSymbol;
                return i16;
            }
            int i17 = bArr[i11] & 255;
            bArr2[i13] = (byte) cArr[((i12 << 4) & 63) | (i17 >> 4)];
            int i18 = i8 + 3;
            bArr2[i8 + 2] = (byte) cArr[(i17 << 2) & 63];
            if (!this.doPadding) {
                return i18;
            }
            int i19 = i8 + 4;
            bArr2[i18] = kotlin.io.encoding.Base64.padSymbol;
            return i19;
        }
    }

    public static class Decoder {
        static final Decoder RFC2045;
        static final Decoder RFC4648;
        static final Decoder RFC4648_URLSAFE;
        private static final int[] fromBase64;
        private static final int[] fromBase64URL;
        private final boolean isMIME;
        private final boolean isURL;

        private Decoder(boolean z, boolean z2) {
            this.isURL = z;
            this.isMIME = z2;
        }

        static {
            int[] iArr = new int[256];
            fromBase64 = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < Encoder.toBase64.length; i++) {
                fromBase64[Encoder.toBase64[i]] = i;
            }
            fromBase64[61] = -2;
            int[] iArr2 = new int[256];
            fromBase64URL = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i2 = 0; i2 < Encoder.toBase64URL.length; i2++) {
                fromBase64URL[Encoder.toBase64URL[i2]] = i2;
            }
            fromBase64URL[61] = -2;
            RFC4648 = new Decoder(false, false);
            RFC4648_URLSAFE = new Decoder(true, false);
            RFC2045 = new Decoder(false, true);
        }

        public byte[] decode(byte[] bArr) {
            int iOutLength = outLength(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iDecode0 = decode0(bArr, 0, bArr.length, bArr2);
            return iDecode0 != iOutLength ? Arrays.copyOf(bArr2, iDecode0) : bArr2;
        }

        public byte[] decode(String str) {
            return decode(str.getBytes(ISO_8859_1.INSTANCE));
        }

        private int outLength(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.isURL ? fromBase64URL : fromBase64;
            int i4 = i2 - i;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.isMIME && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.isMIME) {
                int i6 = 0;
                while (i < i2) {
                    int i7 = i + 1;
                    int i8 = bArr[i] & 255;
                    if (i8 == 61) {
                        i4 -= (i2 - i7) + 1;
                        break;
                    }
                    if (iArr[i8] == -1) {
                        i6++;
                    }
                    i = i7;
                }
                i4 -= i6;
            } else if (bArr[i2 - 1] == 61) {
                i5 = bArr[i2 - 2] == 61 ? 2 : 1;
            }
            if (i5 == 0 && (i3 = i4 & 3) != 0) {
                i5 = 4 - i3;
            }
            return (((i4 + 3) / 4) * 3) - i5;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0073 A[PHI: r5 r7
          0x0073: PHI (r5v6 int) = (r5v1 int), (r5v1 int), (r5v14 int) binds: [B:9:0x001a, B:11:0x001e, B:18:0x006f] A[DONT_GENERATE, DONT_INLINE]
          0x0073: PHI (r7v6 int) = (r7v1 int), (r7v1 int), (r7v9 int) binds: [B:9:0x001a, B:11:0x001e, B:18:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:22:0x007d  */
        /* JADX WARN: Code duplicated, block: B:25:0x0082 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:26:0x0084  */
        /* JADX WARN: Code duplicated, block: B:29:0x008d  */
        /* JADX WARN: Code duplicated, block: B:34:0x0099  */
        /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:42:0x00da  */
        /* JADX WARN: Code duplicated, block: B:60:0x00a0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:63:0x0080 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:64:0x009d A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
        
            if (r6 != 18) goto L43;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int decode0(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3;
            int i4;
            int i5;
            int[] iArr = this.isURL ? fromBase64URL : fromBase64;
            int i6 = i;
            int i7 = 0;
            int i8 = 0;
            int i9 = 18;
            while (i6 < i2) {
                if (i9 != 18 || i6 + 4 >= i2) {
                    i3 = i6 + 1;
                    i4 = iArr[bArr[i6] & 255];
                    if (i4 < 0) {
                        i5 = (i4 << i9) | i8;
                        i9 -= 6;
                        if (i9 < 0) {
                            bArr2[i7] = (byte) (i5 >> 16);
                            int i10 = i7 + 2;
                            bArr2[i7 + 1] = (byte) (i5 >> 8);
                            i7 += 3;
                            bArr2[i10] = (byte) i5;
                            i8 = 0;
                            i9 = 18;
                        } else {
                            i8 = i5;
                        }
                    } else if (i4 == -2) {
                        if (i9 == 6) {
                            if (i3 != i2) {
                                i6 += 2;
                                if (bArr[i3] == 61) {
                                    break;
                                }
                            }
                            throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                        }
                        i6 = i3;
                    } else if (this.isMIME) {
                        throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i6], 16));
                    }
                    i6 = i3;
                } else {
                    int i11 = ((i2 - i6) & (-4)) + i6;
                    while (i6 < i11) {
                        int i12 = iArr[bArr[i6] & 255];
                        int i13 = iArr[bArr[i6 + 1] & 255];
                        int i14 = iArr[bArr[i6 + 2] & 255];
                        int i15 = i6 + 4;
                        int i16 = iArr[bArr[i6 + 3] & 255];
                        if ((i12 | i13 | i14 | i16) < 0) {
                            break;
                        }
                        int i17 = (i12 << 18) | (i13 << 12) | (i14 << 6) | i16;
                        bArr2[i7] = (byte) (i17 >> 16);
                        int i18 = i7 + 2;
                        bArr2[i7 + 1] = (byte) (i17 >> 8);
                        i7 += 3;
                        bArr2[i18] = (byte) i17;
                        i6 = i15;
                    }
                    if (i6 >= i2) {
                        break;
                    }
                    i3 = i6 + 1;
                    i4 = iArr[bArr[i6] & 255];
                    if (i4 < 0) {
                        i5 = (i4 << i9) | i8;
                        i9 -= 6;
                        if (i9 < 0) {
                            bArr2[i7] = (byte) (i5 >> 16);
                            int i19 = i7 + 2;
                            bArr2[i7 + 1] = (byte) (i5 >> 8);
                            i7 += 3;
                            bArr2[i19] = (byte) i5;
                            i8 = 0;
                            i9 = 18;
                        } else {
                            i8 = i5;
                        }
                    } else if (i4 == -2) {
                        if (i9 == 6) {
                            if (i3 != i2) {
                                i6 += 2;
                                if (bArr[i3] == 61) {
                                    break;
                                }
                            }
                            throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                        }
                        i6 = i3;
                    } else if (this.isMIME) {
                        throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i6], 16));
                    }
                    i6 = i3;
                }
            }
            if (i9 == 6) {
                bArr2[i7] = (byte) (i8 >> 16);
                i7++;
            } else if (i9 == 0) {
                int i20 = i7 + 1;
                bArr2[i7] = (byte) (i8 >> 16);
                i7 += 2;
                bArr2[i20] = (byte) (i8 >> 8);
            } else if (i9 == 12) {
                throw new IllegalArgumentException("Last unit does not have enough valid bits");
            }
            while (i6 < i2) {
                if (this.isMIME) {
                    int i21 = iArr[bArr[i6] & 255];
                    i6++;
                    if (i21 < 0) {
                    }
                }
                throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i6);
            }
            return i7;
        }
    }
}
