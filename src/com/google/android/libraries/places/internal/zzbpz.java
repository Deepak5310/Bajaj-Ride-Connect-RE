package com.google.android.libraries.places.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\r\u0010 \u001a\u00020\u0015H\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006E"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$third_party_java_src_okio_okio_jvm", "()[I", "getSegments$third_party_java_src_okio_okio_jvm", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$third_party_java_src_okio_okio_jvm", "equals", "", "other", "", "getSize", "getSize$third_party_java_src_okio_okio_jvm", "hashCode", "hex", "hmac", "key", "hmac$third_party_java_src_okio_okio_jvm", "indexOf", "fromIndex", "internalArray", "internalArray$third_party_java_src_okio_okio_jvm", "internalGet", "", "pos", "internalGet$third_party_java_src_okio_okio_jvm", "lastIndexOf", "rangeEquals", "otherOffset", TypedValues.Custom.S_STRING, "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$third_party_java_src_okio_okio_jvm", "writeReplace", "Ljava/lang/Object;", "third_party.java_src.okio_okio-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class zzbpz extends zzbpp {
    private final transient byte[][] zzc;
    private final transient int[] zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbpz(byte[][] segments, int[] directory) {
        super(zzbpp.zzb.getZzc());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.zzc = segments;
        this.zzd = directory;
    }

    private final zzbpp zzs() {
        return new zzbpp(zzp());
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof zzbpp) {
            zzbpp zzbppVar = (zzbpp) other;
            if (zzbppVar.zzc() == zzc() && zzk(0, zzbppVar, 0, zzc())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final int hashCode() {
        int zzd = getZzd();
        if (zzd != 0) {
            return zzd;
        }
        byte[][] bArr = this.zzc;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                zzh(i2);
                return i2;
            }
            int[] iArr = this.zzd;
            byte[][] bArr2 = this.zzc;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = (i5 - i3) + i4;
            byte[] bArr3 = bArr2[i];
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr3[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final String toString() {
        return zzs().toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final byte zza(int i) {
        zzbpf.zzb(this.zzd[this.zzc.length - 1], i, 1L);
        int iZza = zzbqj.zza(this, i);
        int i2 = iZza == 0 ? 0 : this.zzd[iZza - 1];
        int[] iArr = this.zzd;
        byte[][] bArr = this.zzc;
        return bArr[iZza][(i - i2) + iArr[bArr.length + iZza]];
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final int zzc() {
        return this.zzd[this.zzc.length - 1];
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final String zze() {
        return zzs().zze();
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final zzbpp zzg() {
        return zzs().zzg();
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final void zzj(zzbpl buffer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iZza = zzbqj.zza(this, 0);
        int i4 = 0;
        while (i4 < i2) {
            if (iZza == 0) {
                iZza = 0;
                i3 = 0;
            } else {
                i3 = this.zzd[iZza - 1];
            }
            int[] iArr = this.zzd;
            int i5 = iArr[iZza] - i3;
            int i6 = iArr[this.zzc.length + iZza];
            int iMin = Math.min(i2, i5 + i3) - i4;
            int i7 = i6 + (i4 - i3);
            zzbpx zzbpxVar = new zzbpx(this.zzc[iZza], i7, i7 + iMin, true, false);
            zzbpx zzbpxVar2 = buffer.zza;
            if (zzbpxVar2 == null) {
                zzbpxVar.zzh = zzbpxVar;
                zzbpxVar.zzg = zzbpxVar.zzh;
                buffer.zza = zzbpxVar.zzg;
            } else {
                Intrinsics.checkNotNull(zzbpxVar2);
                zzbpx zzbpxVar3 = zzbpxVar2.zzh;
                Intrinsics.checkNotNull(zzbpxVar3);
                zzbpxVar3.zzb(zzbpxVar);
            }
            i4 += iMin;
            iZza++;
        }
        buffer.zzE(buffer.getZzb() + ((long) i2));
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final boolean zzk(int i, zzbpp other, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(other, "other");
        if (zzc() - i3 < 0) {
            return false;
        }
        int iZza = zzbqj.zza(this, 0);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            if (iZza == 0) {
                iZza = 0;
                i4 = 0;
            } else {
                i4 = this.zzd[iZza - 1];
            }
            int[] iArr = this.zzd;
            int i7 = iArr[iZza] - i4;
            int i8 = iArr[this.zzc.length + iZza];
            int iMin = Math.min(i3, i7 + i4) - i5;
            if (!other.zzl(i6, this.zzc[iZza], i8 + (i5 - i4), iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iZza++;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final boolean zzl(int i, byte[] other, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > zzc() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i5 = i3 + i;
        int iZza = zzbqj.zza(this, i);
        while (i < i5) {
            if (iZza == 0) {
                iZza = 0;
                i4 = 0;
            } else {
                i4 = this.zzd[iZza - 1];
            }
            int[] iArr = this.zzd;
            int i6 = iArr[iZza] - i4;
            int i7 = iArr[this.zzc.length + iZza];
            int iMin = Math.min(i5, i6 + i4) - i;
            if (!zzbpf.zzc(this.zzc[iZza], i7 + (i - i4), other, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iZza++;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final byte[] zzo() {
        return zzp();
    }

    @Override // com.google.android.libraries.places.internal.zzbpp
    public final byte[] zzp() {
        byte[] bArr = new byte[zzc()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[][] bArr2 = this.zzc;
            int length = bArr2.length;
            if (i >= length) {
                return bArr;
            }
            int[] iArr = this.zzd;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(bArr2[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
    }

    /* JADX INFO: renamed from: zzq, reason: from getter */
    public final int[] getZzd() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: zzr, reason: from getter */
    public final byte[][] getZzc() {
        return this.zzc;
    }
}
