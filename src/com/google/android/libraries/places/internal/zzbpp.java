package com.google.android.libraries.places.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001vB\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nH\u0010¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0000¢\u0006\u0004\b%\u0010'J\u0018\u0010,\u001a\u00020)2\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020\u0007H\u0007¢\u0006\u0004\b-\u0010+J\u000f\u0010/\u001a\u00020\u0007H\u0010¢\u0006\u0004\b.\u0010\tJ\u000f\u00100\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u0010\fJ\u001f\u00104\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\n2\u0006\u00101\u001a\u00020\u0000H\u0010¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0000H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0000H\u0016¢\u0006\u0004\b7\u00106J\u0017\u00108\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0000H\u0016¢\u0006\u0004\b8\u00106J!\u0010:\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u0007H\u0017¢\u0006\u0004\b:\u0010;J!\u0010:\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u00109\u001a\u00020\u0007H\u0007¢\u0006\u0004\b:\u0010<J\u000f\u0010?\u001a\u00020\u0003H\u0010¢\u0006\u0004\b=\u0010>J\u0017\u0010B\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0007H\u0010¢\u0006\u0004\bA\u0010+J!\u0010C\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u0007H\u0017¢\u0006\u0004\bC\u0010;J!\u0010C\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u00109\u001a\u00020\u0007H\u0007¢\u0006\u0004\bC\u0010<J\r\u0010D\u001a\u00020\u0000¢\u0006\u0004\bD\u0010EJ/\u0010G\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\bG\u0010HJ/\u0010G\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\bG\u0010IJ\u0017\u0010L\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\r\u0010N\u001a\u00020\u0000¢\u0006\u0004\bN\u0010EJ\r\u0010O\u001a\u00020\u0000¢\u0006\u0004\bO\u0010EJ\r\u0010P\u001a\u00020\u0000¢\u0006\u0004\bP\u0010EJ\u000f\u0010R\u001a\u00020\u0007H\u0007¢\u0006\u0004\bQ\u0010\tJ\u0015\u0010T\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u0003¢\u0006\u0004\bT\u0010&J\u0015\u0010T\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u0000¢\u0006\u0004\bT\u0010'J\u0017\u0010W\u001a\u00020\n2\u0006\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bW\u0010XJ#\u0010[\u001a\u00020\u00002\b\b\u0002\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010Z\u001a\u00020\u0007H\u0017¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0000H\u0016¢\u0006\u0004\b]\u0010EJ\u000f\u0010^\u001a\u00020\u0000H\u0016¢\u0006\u0004\b^\u0010EJ\u000f\u0010_\u001a\u00020\u0003H\u0016¢\u0006\u0004\b_\u0010>J\u000f\u0010`\u001a\u00020\nH\u0016¢\u0006\u0004\b`\u0010\fJ\u0017\u0010c\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020aH\u0016¢\u0006\u0004\bc\u0010dJ'\u0010c\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020e2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0010¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020iH\u0002¢\u0006\u0004\bj\u0010kR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010l\u001a\u0004\bm\u0010>R\"\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010n\u001a\u0004\bo\u0010\t\"\u0004\bp\u0010qR\u0011\u0010R\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\bR\u0010\tR$\u0010`\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b`\u0010r\u001a\u0004\bs\u0010\f\"\u0004\bt\u0010u¨\u0006w"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "", "data", "<init>", "([B)V", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "(Lokio/ByteString;)I", TypedValues.CycleType.S_WAVE_OFFSET, "target", "targetOffset", "byteCount", "", "copyInto", "(I[BII)V", "algorithm", "digest$third_party_java_src_okio_okio_jvm", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "suffix", "endsWith", "([B)Z", "(Lokio/ByteString;)Z", FirebaseAnalytics.Param.INDEX, "", "getByte", "(I)B", "get", "-deprecated_getByte", "getSize$third_party_java_src_okio_okio_jvm", "getSize", "hex", "key", "hmac$third_party_java_src_okio_okio_jvm", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "fromIndex", "indexOf", "([BI)I", "(Lokio/ByteString;I)I", "internalArray$third_party_java_src_okio_okio_jvm", "()[B", "internalArray", "pos", "internalGet$third_party_java_src_okio_okio_jvm", "internalGet", "lastIndexOf", "md5", "()Lokio/ByteString;", "otherOffset", "rangeEquals", "(I[BII)Z", "(ILokio/ByteString;II)Z", "Ljava/io/ObjectInputStream;", "in", "readObject", "(Ljava/io/ObjectInputStream;)V", "sha1", "sha256", "sha512", "-deprecated_size", "size", "prefix", "startsWith", "Ljava/nio/charset/Charset;", "charset", TypedValues.Custom.S_STRING, "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, "Ljava/io/OutputStream;", "out", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "write$third_party_java_src_okio_okio_jvm", "(Lokio/Buffer;II)V", "Ljava/io/ObjectOutputStream;", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "[B", "getData$third_party_java_src_okio_okio_jvm", "I", "getHashCode$third_party_java_src_okio_okio_jvm", "setHashCode$third_party_java_src_okio_okio_jvm", "(I)V", "Ljava/lang/String;", "getUtf8$third_party_java_src_okio_okio_jvm", "setUtf8$third_party_java_src_okio_okio_jvm", "(Ljava/lang/String;)V", "Companion", "third_party.java_src.okio_okio-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class zzbpp implements Serializable, Comparable {
    public static final zzbpo zza = new zzbpo(null);
    public static final zzbpp zzb = new zzbpp(new byte[0]);
    private final byte[] zzc;
    private transient int zzd;
    private transient String zze;

    public zzbpp(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.zzc = data;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzbpp other = (zzbpp) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        int iZzc = zzc();
        int iZzc2 = other.zzc();
        int iMin = Math.min(iZzc, iZzc2);
        for (int i = 0; i < iMin; i++) {
            int iZza = zza(i) & 255;
            int iZza2 = other.zza(i) & 255;
            if (iZza != iZza2) {
                if (iZza < iZza2) {
                    return -1;
                }
                return 1;
            }
        }
        if (iZzc == iZzc2) {
            return 0;
        }
        if (iZzc < iZzc2) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof zzbpp) {
            zzbpp zzbppVar = (zzbpp) other;
            int iZzc = zzbppVar.zzc();
            byte[] bArr = this.zzc;
            int length = bArr.length;
            if (iZzc == length && zzbppVar.zzl(0, bArr, 0, length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.zzc);
        this.zzd = iHashCode;
        return iHashCode;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0065 A[EDGE_INSN: B:39:0x0065->B:127:0x014a BREAK  A[LOOP:0: B:6:0x0010->B:33:0x004f]] */
    public String toString() {
        int i;
        byte[] bArr = this.zzc;
        int length = bArr.length;
        if (length == 0) {
            return "[size=0]";
        }
        int i2 = zzbqi.zza;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0: while (i3 < length) {
            byte b = bArr[i3];
            if (b < 0) {
                if ((b >> 5) != -2) {
                    if ((b >> 4) != -2) {
                        if ((b >> 3) != -2) {
                            if (i4 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                        int i6 = i3 + 3;
                        if (length > i6) {
                            byte b2 = bArr[i3 + 1];
                            if ((b2 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            byte b3 = bArr[i3 + 2];
                            if ((b3 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            byte b4 = bArr[i6];
                            if ((b4 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            int i7 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << Ascii.FF)) ^ (b << Ascii.DC2);
                            if (i7 <= 1114111) {
                                if (i7 >= 55296 && i7 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i5 = -1;
                                    break;
                                }
                                if (i7 >= 65536) {
                                    i = i4 + 1;
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i5 += 2;
                                    Unit unit = Unit.INSTANCE;
                                    i3 += 4;
                                    i4 = i;
                                } else {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i5 = -1;
                                    break;
                                }
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                    } else {
                        int i8 = i3 + 2;
                        if (length > i8) {
                            byte b5 = bArr[i3 + 1];
                            if ((b5 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            byte b6 = bArr[i8];
                            if ((b6 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            int i9 = ((b6 ^ (-123008)) ^ (b5 << 6)) ^ (b << Ascii.FF);
                            if (i9 >= 2048) {
                                if (i9 >= 55296 && i9 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i5 = -1;
                                    break;
                                }
                                i = i4 + 1;
                                if (i4 == 64) {
                                    break;
                                }
                                if (i9 == 65533) {
                                    i5 = -1;
                                    break;
                                }
                                i3 += 3;
                                i5 += i9 < 65536 ? 1 : 2;
                                Unit unit2 = Unit.INSTANCE;
                                i4 = i;
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                    }
                } else {
                    int i10 = i3 + 1;
                    if (length > i10) {
                        byte b7 = bArr[i10];
                        if ((b7 & 192) != 128) {
                            if (i4 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                        int i11 = (b << 6) ^ (b7 ^ 3968);
                        if (i11 >= 128) {
                            i = i4 + 1;
                            if (i4 != 64) {
                                if (i11 < 160 || i11 == 65533) {
                                    i5 = -1;
                                    break;
                                }
                                i3 += 2;
                                i5 += i11 < 65536 ? 1 : 2;
                                Unit unit3 = Unit.INSTANCE;
                                i4 = i;
                            } else {
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                    } else {
                        if (i4 == 64) {
                            break;
                        }
                        i5 = -1;
                        break;
                    }
                }
            } else {
                i = i4 + 1;
                if (i4 == 64) {
                    break;
                }
                if (b == 10 || b == 13 || (b >= 32 && b < 127)) {
                    i5++;
                    i3++;
                    while (true) {
                        if (i3 >= length) {
                            continue;
                        } else {
                            byte b8 = bArr[i3];
                            if (b8 >= 0) {
                                i3++;
                                int i12 = i + 1;
                                if (i == 64) {
                                    break loop0;
                                }
                                if (b8 == 10 || b8 == 13 || (b8 >= 32 && b8 < 127)) {
                                    i5++;
                                    i = i12;
                                }
                            } else {
                                continue;
                            }
                        }
                        i4 = i;
                    }
                }
                i5 = -1;
                break;
            }
        }
        if (i5 != -1) {
            String strZzf = zzf();
            String strSubstring = strZzf.substring(0, i5);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
            if (i5 >= strZzf.length()) {
                return "[text=" + strReplace$default + "]";
            }
            return "[size=" + this.zzc.length + " text=" + strReplace$default + "…]";
        }
        int length2 = this.zzc.length;
        if (length2 <= 64) {
            return "[hex=" + zze() + "]";
        }
        Intrinsics.checkNotNullParameter(this, "<this>");
        byte[] bArr2 = this.zzc;
        int length3 = bArr2.length;
        if (length3 < 64) {
            throw new IllegalArgumentException("endIndex > length(" + length3 + ")");
        }
        return "[size=" + length2 + " hex=" + (length3 != 64 ? new zzbpp(ArraysKt.copyOfRange(bArr2, 0, 64)) : this).zze() + "…]";
    }

    public byte zza(int i) {
        return this.zzc[i];
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final int getZzd() {
        return this.zzd;
    }

    public int zzc() {
        return this.zzc.length;
    }

    public final String zzd() {
        return zzbpe.zza(this.zzc, null, 1, null);
    }

    public String zze() {
        byte[] bArr = this.zzc;
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i = 0;
        for (byte b : bArr) {
            cArr[i] = zzbqi.zza()[(b >> 4) & 15];
            cArr[i + 1] = zzbqi.zza()[b & Ascii.SI];
            i += 2;
        }
        return StringsKt.concatToString(cArr);
    }

    public final String zzf() {
        String str = this.zze;
        if (str != null) {
            return str;
        }
        String strZza = zzbqg.zza(zzo());
        this.zze = strZza;
        return strZza;
    }

    public zzbpp zzg() {
        int i = 0;
        while (true) {
            byte[] bArr = this.zzc;
            int length = bArr.length;
            if (i >= length) {
                return this;
            }
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b + 32);
                while (i2 < bArrCopyOf.length) {
                    int i3 = i2 + 1;
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                    i2 = i3;
                }
                return new zzbpp(bArrCopyOf);
            }
            i = i2;
        }
    }

    public final void zzh(int i) {
        this.zzd = i;
    }

    public final void zzi(String str) {
        this.zze = str;
    }

    public void zzj(zzbpl buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i3 = zzbqi.zza;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.zzl(this.zzc, 0, i2);
    }

    public boolean zzk(int i, zzbpp other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.zzl(0, this.zzc, 0, i3);
    }

    public boolean zzl(int i, byte[] other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0) {
            return false;
        }
        byte[] bArr = this.zzc;
        return i <= bArr.length - i3 && i2 >= 0 && i2 <= other.length - i3 && zzbpf.zzc(bArr, i, other, i2, i3);
    }

    public final boolean zzm(zzbpp prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return zzk(0, prefix, 0, prefix.zzc.length);
    }

    /* JADX INFO: renamed from: zzn, reason: from getter */
    public final byte[] getZzc() {
        return this.zzc;
    }

    public byte[] zzo() {
        return this.zzc;
    }

    public byte[] zzp() {
        byte[] bArr = this.zzc;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }
}
