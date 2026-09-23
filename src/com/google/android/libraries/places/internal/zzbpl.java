package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.imageutils.JfifUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.spotify.sdk.android.auth.LoginActivity;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0090\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u007f\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0016J$\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0091\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$third_party_java_src_okio_okio_jvm", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", TypedValues.CycleType.S_WAVE_OFFSET, "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", FirebaseAnalytics.Param.INDEX, "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", LoginActivity.REQUEST_KEY, "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$third_party_java_src_okio_okio_jvm", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", ContextChain.TAG_INFRA, "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", TypedValues.Custom.S_STRING, "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "third_party.java_src.okio_okio-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class zzbpl implements Cloneable, ByteChannel, zzbpn, zzbpm {
    public zzbpx zza;
    private long zzb;

    public final /* synthetic */ Object clone() {
        zzbpl zzbplVar = new zzbpl();
        if (this.zzb != 0) {
            zzbpx zzbpxVar = this.zza;
            Intrinsics.checkNotNull(zzbpxVar);
            zzbpx zzbpxVarZzc = zzbpxVar.zzc();
            zzbplVar.zza = zzbpxVarZzc;
            zzbpxVarZzc.zzh = zzbpxVarZzc;
            zzbpxVarZzc.zzg = zzbpxVarZzc.zzh;
            for (zzbpx zzbpxVar2 = zzbpxVar.zzg; zzbpxVar2 != zzbpxVar; zzbpxVar2 = zzbpxVar2.zzg) {
                zzbpx zzbpxVar3 = zzbpxVarZzc.zzh;
                Intrinsics.checkNotNull(zzbpxVar3);
                Intrinsics.checkNotNull(zzbpxVar2);
                zzbpxVar3.zzb(zzbpxVar2.zzc());
            }
            zzbplVar.zzb = this.zzb;
        }
        return zzbplVar;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbqc
    public final void close() {
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof zzbpl) {
            long j = this.zzb;
            zzbpl zzbplVar = (zzbpl) other;
            if (j == zzbplVar.zzb) {
                if (j == 0) {
                    return true;
                }
                zzbpx zzbpxVar = this.zza;
                Intrinsics.checkNotNull(zzbpxVar);
                zzbpx zzbpxVar2 = zzbplVar.zza;
                Intrinsics.checkNotNull(zzbpxVar2);
                int i = zzbpxVar.zzc;
                int i2 = zzbpxVar2.zzc;
                long j2 = 0;
                while (j2 < this.zzb) {
                    long jMin = Math.min(zzbpxVar.zzd - i, zzbpxVar2.zzd - i2);
                    long j3 = 0;
                    while (j3 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (zzbpxVar.zzb[i] == zzbpxVar2.zzb[i2]) {
                            j3++;
                            i = i3;
                            i2 = i4;
                        }
                    }
                    if (i == zzbpxVar.zzd) {
                        zzbpxVar = zzbpxVar.zzg;
                        Intrinsics.checkNotNull(zzbpxVar);
                        i = zzbpxVar.zzc;
                    }
                    if (i2 == zzbpxVar2.zzd) {
                        zzbpxVar2 = zzbpxVar2.zzg;
                        Intrinsics.checkNotNull(zzbpxVar2);
                        i2 = zzbpxVar2.zzc;
                    }
                    j2 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbpm, com.google.android.libraries.places.internal.zzbqa, java.io.Flushable
    public final void flush() {
    }

    public final int hashCode() {
        zzbpx zzbpxVar = this.zza;
        if (zzbpxVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = zzbpxVar.zzd;
            for (int i3 = zzbpxVar.zzc; i3 < i2; i3++) {
                i = (i * 31) + zzbpxVar.zzb[i3];
            }
            zzbpxVar = zzbpxVar.zzg;
            Intrinsics.checkNotNull(zzbpxVar);
        } while (zzbpxVar != this.zza);
        return i;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzbpx zzbpxVar = this.zza;
        if (zzbpxVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), zzbpxVar.zzd - zzbpxVar.zzc);
        sink.put(zzbpxVar.zzb, zzbpxVar.zzc, iMin);
        int i = zzbpxVar.zzc + iMin;
        zzbpxVar.zzc = i;
        this.zzb -= (long) iMin;
        if (i == zzbpxVar.zzd) {
            this.zza = zzbpxVar.zza();
            zzbpy.zzb(zzbpxVar);
        }
        return iMin;
    }

    public final String toString() {
        return zzz().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i = iRemaining;
        while (i > 0) {
            zzbpx zzbpxVarZzB = zzB(1);
            int iMin = Math.min(i, 8192 - zzbpxVarZzB.zzd);
            source.get(zzbpxVarZzB.zzb, zzbpxVarZzB.zzd, iMin);
            i -= iMin;
            zzbpxVarZzB.zzd += iMin;
        }
        this.zzb += (long) iRemaining;
        return iRemaining;
    }

    public final short zzC() throws EOFException {
        int iZzc;
        if (this.zzb < 2) {
            throw new EOFException(null);
        }
        zzbpx zzbpxVar = this.zza;
        Intrinsics.checkNotNull(zzbpxVar);
        int i = zzbpxVar.zzc;
        int i2 = zzbpxVar.zzd;
        if (i2 - i < 2) {
            iZzc = ((zzc() & 255) << 8) | (zzc() & 255);
        } else {
            byte[] bArr = zzbpxVar.zzb;
            int i3 = (bArr[i] & 255) << 8;
            int i4 = bArr[i + 1] & 255;
            this.zzb -= 2;
            int i5 = i + 2;
            if (i5 == i2) {
                this.zza = zzbpxVar.zza();
                zzbpy.zzb(zzbpxVar);
            } else {
                zzbpxVar.zzc = i5;
            }
            iZzc = i3 | i4;
        }
        return (short) iZzc;
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final void zzD(long j) throws EOFException {
        throw null;
    }

    public final void zzE(long j) {
        this.zzb = j;
    }

    public final boolean zzG() {
        return this.zzb == 0;
    }

    @Override // com.google.android.libraries.places.internal.zzbqc
    public final long zza(zzbpl sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.zzb;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        sink.zzn(this, j);
        return j;
    }

    public final byte zzb(long j) {
        zzbpf.zzb(this.zzb, j, 1L);
        zzbpx zzbpxVar = this.zza;
        if (zzbpxVar == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        long j2 = this.zzb;
        if (j2 - j < j) {
            while (j2 > j) {
                zzbpxVar = zzbpxVar.zzh;
                Intrinsics.checkNotNull(zzbpxVar);
                j2 -= (long) (zzbpxVar.zzd - zzbpxVar.zzc);
            }
            Intrinsics.checkNotNull(zzbpxVar);
            return zzbpxVar.zzb[(int) ((((long) zzbpxVar.zzc) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            long j4 = ((long) (zzbpxVar.zzd - zzbpxVar.zzc)) + j3;
            if (j4 > j) {
                Intrinsics.checkNotNull(zzbpxVar);
                return zzbpxVar.zzb[(int) ((((long) zzbpxVar.zzc) + j) - j3)];
            }
            zzbpxVar = zzbpxVar.zzg;
            Intrinsics.checkNotNull(zzbpxVar);
            j3 = j4;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final byte zzc() throws EOFException {
        if (this.zzb == 0) {
            throw new EOFException(null);
        }
        zzbpx zzbpxVar = this.zza;
        Intrinsics.checkNotNull(zzbpxVar);
        int i = zzbpxVar.zzc;
        int i2 = zzbpxVar.zzd;
        int i3 = i + 1;
        byte b = zzbpxVar.zzb[i];
        this.zzb--;
        if (i3 == i2) {
            this.zza = zzbpxVar.zza();
            zzbpy.zzb(zzbpxVar);
        } else {
            zzbpxVar.zzc = i3;
        }
        return b;
    }

    public final int zzd(byte[] sink, int i, int i2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzbpf.zzb(sink.length, i, i2);
        zzbpx zzbpxVar = this.zza;
        if (zzbpxVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, zzbpxVar.zzd - zzbpxVar.zzc);
        int i3 = zzbpxVar.zzc;
        ArraysKt.copyInto(zzbpxVar.zzb, sink, i, i3, i3 + iMin);
        int i4 = zzbpxVar.zzc + iMin;
        zzbpxVar.zzc = i4;
        this.zzb -= (long) iMin;
        if (i4 != zzbpxVar.zzd) {
            return iMin;
        }
        this.zza = zzbpxVar.zza();
        zzbpy.zzb(zzbpxVar);
        return iMin;
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final int zze() throws EOFException {
        if (this.zzb < 4) {
            throw new EOFException(null);
        }
        zzbpx zzbpxVar = this.zza;
        Intrinsics.checkNotNull(zzbpxVar);
        int i = zzbpxVar.zzc;
        int i2 = zzbpxVar.zzd;
        if (i2 - i < 4) {
            return ((zzc() & 255) << 24) | ((zzc() & 255) << 16) | ((zzc() & 255) << 8) | (zzc() & 255);
        }
        byte[] bArr = zzbpxVar.zzb;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = (bArr[i + 1] & 255) << 16;
        int i5 = (bArr[i + 2] & 255) << 8;
        int i6 = bArr[i + 3] & 255;
        this.zzb -= 4;
        int i7 = i6 | i4 | i3 | i5;
        int i8 = i + 4;
        if (i8 == i2) {
            this.zza = zzbpxVar.zza();
            zzbpy.zzb(zzbpxVar);
        } else {
            zzbpxVar.zzc = i8;
        }
        return i7;
    }

    public final long zzf() {
        long j = this.zzb;
        if (j == 0) {
            return 0L;
        }
        zzbpx zzbpxVar = this.zza;
        Intrinsics.checkNotNull(zzbpxVar);
        zzbpx zzbpxVar2 = zzbpxVar.zzh;
        Intrinsics.checkNotNull(zzbpxVar2);
        int i = zzbpxVar2.zzd;
        if (i < 8192 && zzbpxVar2.zzf) {
            j -= (long) (i - zzbpxVar2.zzc);
        }
        return j;
    }

    /* JADX INFO: renamed from: zzg, reason: from getter */
    public final long getZzb() {
        return this.zzb;
    }

    public final String zzi() {
        return zzh(this.zzb, Charsets.UTF_8);
    }

    public final zzbpl zzk(zzbpp byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.zzj(this, 0, byteString.zzc());
        return this;
    }

    public final zzbpl zzl(byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = i2;
        zzbpf.zzb(source.length, i, j);
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                this.zzb += j;
                return this;
            }
            zzbpx zzbpxVarZzB = zzB(1);
            int iMin = Math.min(i4 - i3, 8192 - zzbpxVarZzB.zzd);
            int i5 = i3 + iMin;
            ArraysKt.copyInto(source, zzbpxVarZzB.zzb, zzbpxVarZzB.zzd, i3, i5);
            zzbpxVarZzB.zzd += iMin;
            i3 = i5;
        }
    }

    public final zzbpl zzm(int i) {
        zzbpx zzbpxVarZzB = zzB(1);
        byte[] bArr = zzbpxVarZzB.zzb;
        int i2 = zzbpxVarZzB.zzd;
        zzbpxVarZzB.zzd = i2 + 1;
        bArr[i2] = (byte) i;
        this.zzb++;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbqa
    public final void zzn(zzbpl source, long j) {
        zzbpx zzbpxVar;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        zzbpf.zzb(source.zzb, 0L, j);
        while (j > 0) {
            zzbpx zzbpxVar2 = source.zza;
            Intrinsics.checkNotNull(zzbpxVar2);
            int i = zzbpxVar2.zzd;
            zzbpx zzbpxVar3 = source.zza;
            Intrinsics.checkNotNull(zzbpxVar3);
            long j2 = i - zzbpxVar3.zzc;
            int i2 = 0;
            if (j < j2) {
                zzbpx zzbpxVar4 = this.zza;
                if (zzbpxVar4 != null) {
                    Intrinsics.checkNotNull(zzbpxVar4);
                    zzbpxVar = zzbpxVar4.zzh;
                } else {
                    zzbpxVar = null;
                }
                int i3 = (int) j;
                if (zzbpxVar != null && zzbpxVar.zzf) {
                    if ((((long) zzbpxVar.zzd) + j) - ((long) (zzbpxVar.zze ? 0 : zzbpxVar.zzc)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        zzbpx zzbpxVar5 = source.zza;
                        Intrinsics.checkNotNull(zzbpxVar5);
                        zzbpxVar5.zze(zzbpxVar, i3);
                        source.zzb -= j;
                        this.zzb += j;
                        return;
                    }
                }
                zzbpx zzbpxVar6 = source.zza;
                Intrinsics.checkNotNull(zzbpxVar6);
                source.zza = zzbpxVar6.zzd(i3);
            }
            zzbpx zzbpxVar7 = source.zza;
            Intrinsics.checkNotNull(zzbpxVar7);
            int i4 = zzbpxVar7.zzd - zzbpxVar7.zzc;
            source.zza = zzbpxVar7.zza();
            zzbpx zzbpxVar8 = this.zza;
            if (zzbpxVar8 == null) {
                this.zza = zzbpxVar7;
                zzbpxVar7.zzh = zzbpxVar7;
                zzbpxVar7.zzg = zzbpxVar7.zzh;
            } else {
                Intrinsics.checkNotNull(zzbpxVar8);
                zzbpx zzbpxVar9 = zzbpxVar8.zzh;
                Intrinsics.checkNotNull(zzbpxVar9);
                zzbpxVar9.zzb(zzbpxVar7);
                zzbpx zzbpxVar10 = zzbpxVar7.zzh;
                if (zzbpxVar10 == zzbpxVar7) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.checkNotNull(zzbpxVar10);
                if (zzbpxVar10.zzf) {
                    int i5 = zzbpxVar7.zzd - zzbpxVar7.zzc;
                    zzbpx zzbpxVar11 = zzbpxVar7.zzh;
                    Intrinsics.checkNotNull(zzbpxVar11);
                    int i6 = 8192 - zzbpxVar11.zzd;
                    zzbpx zzbpxVar12 = zzbpxVar7.zzh;
                    Intrinsics.checkNotNull(zzbpxVar12);
                    if (!zzbpxVar12.zze) {
                        zzbpx zzbpxVar13 = zzbpxVar7.zzh;
                        Intrinsics.checkNotNull(zzbpxVar13);
                        i2 = zzbpxVar13.zzc;
                    }
                    if (i5 <= i6 + i2) {
                        zzbpx zzbpxVar14 = zzbpxVar7.zzh;
                        Intrinsics.checkNotNull(zzbpxVar14);
                        zzbpxVar7.zze(zzbpxVar14, i5);
                        zzbpxVar7.zza();
                        zzbpy.zzb(zzbpxVar7);
                    }
                }
            }
            long j3 = i4;
            source.zzb -= j3;
            this.zzb += j3;
            j -= j3;
        }
    }

    public final zzbpl zzo(long j) {
        if (j == 0) {
            zzm(48);
        } else {
            long j2 = (j >>> 1) | j;
            long j3 = j2 | (j2 >>> 2);
            long j4 = j3 | (j3 >>> 4);
            long j5 = j4 | (j4 >>> 8);
            long j6 = j5 - ((j5 >>> 1) & 6148914691236517205L);
            long j7 = ((j6 >>> 2) & 3689348814741910323L) + (j6 & 3689348814741910323L);
            long j8 = ((j7 >>> 4) + j7) & 1085102592571150095L;
            long j9 = j8 + (j8 >>> 8);
            long j10 = j9 + (j9 >>> 16);
            int i = (int) ((((j10 & 63) + ((j10 >>> 32) & 63)) + 3) >> 2);
            zzbpx zzbpxVarZzB = zzB(i);
            byte[] bArr = zzbpxVarZzB.zzb;
            int i2 = zzbpxVarZzB.zzd;
            int i3 = i2 + i;
            while (true) {
                i3--;
                if (i3 < i2) {
                    break;
                }
                bArr[i3] = zzbqh.zza()[(int) (15 & j)];
                j >>>= 4;
            }
            zzbpxVarZzB.zzd += i;
            this.zzb += (long) i;
        }
        return this;
    }

    public final zzbpl zzp(int i) {
        zzbpx zzbpxVarZzB = zzB(4);
        byte[] bArr = zzbpxVarZzB.zzb;
        int i2 = zzbpxVarZzB.zzd;
        bArr[i2] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        zzbpxVarZzB.zzd = i2 + 4;
        this.zzb += 4;
        return this;
    }

    public final zzbpl zzq(int i) {
        zzbpx zzbpxVarZzB = zzB(2);
        byte[] bArr = zzbpxVarZzB.zzb;
        int i2 = zzbpxVarZzB.zzd;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        zzbpxVarZzB.zzd = i2 + 2;
        this.zzb += 2;
        return this;
    }

    public final zzbpl zzr(OutputStream out, long j) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        zzbpf.zzb(this.zzb, 0L, j);
        zzbpx zzbpxVar = this.zza;
        while (j > 0) {
            Intrinsics.checkNotNull(zzbpxVar);
            int iMin = (int) Math.min(j, zzbpxVar.zzd - zzbpxVar.zzc);
            out.write(zzbpxVar.zzb, zzbpxVar.zzc, iMin);
            int i = zzbpxVar.zzc + iMin;
            zzbpxVar.zzc = i;
            long j2 = iMin;
            this.zzb -= j2;
            j -= j2;
            if (i == zzbpxVar.zzd) {
                zzbpx zzbpxVarZza = zzbpxVar.zza();
                this.zza = zzbpxVarZza;
                zzbpy.zzb(zzbpxVar);
                zzbpxVar = zzbpxVarZza;
            }
        }
        return this;
    }

    public final zzbpl zzs(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        zzt(string, 0, string.length());
        return this;
    }

    public final zzbpl zzt(String string, int i, int i2) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (i2 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < 0");
        }
        if (i2 > string.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + string.length());
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            char cCharAt = string.charAt(i3);
            if (cCharAt < 128) {
                zzbpx zzbpxVarZzB = zzB(1);
                byte[] bArr = zzbpxVarZzB.zzb;
                int i5 = zzbpxVarZzB.zzd - i3;
                int iMin = Math.min(i2, 8192 - i5);
                bArr[i3 + i5] = (byte) cCharAt;
                i3 = i4;
                while (i3 < iMin) {
                    char cCharAt2 = string.charAt(i3);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i3 + i5] = (byte) cCharAt2;
                    i3++;
                }
                int i6 = zzbpxVarZzB.zzd;
                int i7 = (i5 + i3) - i6;
                zzbpxVarZzB.zzd = i6 + i7;
                this.zzb += (long) i7;
            } else {
                if (cCharAt < 2048) {
                    zzbpx zzbpxVarZzB2 = zzB(2);
                    byte[] bArr2 = zzbpxVarZzB2.zzb;
                    int i8 = zzbpxVarZzB2.zzd;
                    bArr2[i8] = (byte) ((cCharAt >> 6) | JfifUtil.MARKER_SOFn);
                    bArr2[i8 + 1] = (byte) ((cCharAt & '?') | 128);
                    zzbpxVarZzB2.zzd = i8 + 2;
                    this.zzb += 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    zzbpx zzbpxVarZzB3 = zzB(3);
                    byte[] bArr3 = zzbpxVarZzB3.zzb;
                    int i9 = zzbpxVarZzB3.zzd;
                    bArr3[i9] = (byte) ((cCharAt >> '\f') | CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY);
                    bArr3[i9 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((cCharAt & '?') | 128);
                    zzbpxVarZzB3.zzd = i9 + 3;
                    this.zzb += 3;
                } else {
                    char cCharAt3 = i4 < i2 ? string.charAt(i4) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 >= 57344) {
                        zzm(63);
                    } else {
                        zzbpx zzbpxVarZzB4 = zzB(4);
                        byte[] bArr4 = zzbpxVarZzB4.zzb;
                        int i10 = zzbpxVarZzB4.zzd;
                        int i11 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        bArr4[i10] = (byte) ((i11 >> 18) | 240);
                        bArr4[i10 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i10 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i10 + 3] = (byte) ((i11 & 63) | 128);
                        zzbpxVarZzB4.zzd = i10 + 4;
                        this.zzb += 4;
                        i3 += 2;
                    }
                }
                i3 = i4;
            }
        }
        return this;
    }

    public final zzbpl zzu(int i) {
        if (i < 128) {
            zzm(i);
        } else if (i < 2048) {
            zzbpx zzbpxVarZzB = zzB(2);
            byte[] bArr = zzbpxVarZzB.zzb;
            int i2 = zzbpxVarZzB.zzd;
            bArr[i2] = (byte) ((i >> 6) | JfifUtil.MARKER_SOFn);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            zzbpxVarZzB.zzd = i2 + 2;
            this.zzb += 2;
        } else if (i >= 55296 && i < 57344) {
            zzm(63);
        } else if (i < 65536) {
            zzbpx zzbpxVarZzB2 = zzB(3);
            byte[] bArr2 = zzbpxVarZzB2.zzb;
            int i3 = zzbpxVarZzB2.zzd;
            bArr2[i3] = (byte) ((i >> 12) | CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            zzbpxVarZzB2.zzd = i3 + 3;
            this.zzb += 3;
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x".concat(String.valueOf(zzbpf.zza(i))));
            }
            zzbpx zzbpxVarZzB3 = zzB(4);
            byte[] bArr3 = zzbpxVarZzB3.zzb;
            int i4 = zzbpxVarZzB3.zzd;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            zzbpxVarZzB3.zzd = i4 + 4;
            this.zzb += 4;
        }
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbpm
    public final /* bridge */ /* synthetic */ zzbpm zzv(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbpm
    public final /* bridge */ /* synthetic */ zzbpm zzw(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbpm
    public final /* bridge */ /* synthetic */ zzbpm zzx(String str) {
        throw null;
    }

    public final zzbpp zzz() {
        long j = this.zzb;
        if (j <= 2147483647L) {
            return zzA((int) j);
        }
        throw new IllegalStateException("size > Int.MAX_VALUE: " + j);
    }

    public final zzbpx zzB(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        zzbpx zzbpxVar = this.zza;
        if (zzbpxVar == null) {
            zzbpx zzbpxVarZza = zzbpy.zza();
            this.zza = zzbpxVarZza;
            zzbpxVarZza.zzh = zzbpxVarZza;
            zzbpxVarZza.zzg = zzbpxVarZza;
            return zzbpxVarZza;
        }
        Intrinsics.checkNotNull(zzbpxVar);
        zzbpx zzbpxVar2 = zzbpxVar.zzh;
        Intrinsics.checkNotNull(zzbpxVar2);
        if (zzbpxVar2.zzd + i <= 8192 && zzbpxVar2.zzf) {
            return zzbpxVar2;
        }
        zzbpx zzbpxVarZza2 = zzbpy.zza();
        zzbpxVar2.zzb(zzbpxVarZza2);
        return zzbpxVarZza2;
    }

    public final byte[] zzH(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j);
        }
        if (this.zzb < j) {
            throw new EOFException(null);
        }
        int i = (int) j;
        byte[] sink = new byte[i];
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i2 = 0;
        while (i2 < i) {
            int iZzd = zzd(sink, i2, i - i2);
            if (iZzd == -1) {
                throw new EOFException(null);
            }
            i2 += iZzd;
        }
        return sink;
    }

    public final String zzh(long j, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j);
        }
        if (this.zzb < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        zzbpx zzbpxVar = this.zza;
        Intrinsics.checkNotNull(zzbpxVar);
        int i = zzbpxVar.zzc;
        int i2 = zzbpxVar.zzd;
        if (((long) i) + j > i2) {
            return new String(zzH(j), charset);
        }
        int i3 = (int) j;
        String str = new String(zzbpxVar.zzb, i, i3, charset);
        int i4 = i + i3;
        zzbpxVar.zzc = i4;
        this.zzb -= j;
        if (i4 == i2) {
            this.zza = zzbpxVar.zza();
            zzbpy.zzb(zzbpxVar);
        }
        return str;
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final zzbpp zzy(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j);
        }
        if (this.zzb < j) {
            throw new EOFException(null);
        }
        if (j < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new zzbpp(zzH(j));
        }
        zzbpp zzbppVarZzA = zzA((int) j);
        zzF(j);
        return zzbppVarZzA;
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final void zzF(long j) throws EOFException {
        while (j > 0) {
            zzbpx zzbpxVar = this.zza;
            if (zzbpxVar == null) {
                throw new EOFException(null);
            }
            int iMin = (int) Math.min(j, zzbpxVar.zzd - zzbpxVar.zzc);
            long j2 = iMin;
            this.zzb -= j2;
            j -= j2;
            int i = zzbpxVar.zzc + iMin;
            zzbpxVar.zzc = i;
            if (i == zzbpxVar.zzd) {
                this.zza = zzbpxVar.zza();
                zzbpy.zzb(zzbpxVar);
            }
        }
    }

    public final String zzj(long j) throws EOFException {
        zzbpx zzbpxVar;
        long j2;
        long j3;
        long j4;
        long j5 = this.zzb;
        long j6 = j5 < Long.MAX_VALUE ? j5 : Long.MAX_VALUE;
        if (j6 == 0 || (zzbpxVar = this.zza) == null) {
            j4 = -1;
            j3 = -1;
        } else if (j5 < 0) {
            while (j5 > 0) {
                zzbpxVar = zzbpxVar.zzh;
                Intrinsics.checkNotNull(zzbpxVar);
                j5 -= (long) (zzbpxVar.zzd - zzbpxVar.zzc);
            }
            if (zzbpxVar != null) {
                long j7 = 0;
                while (true) {
                    if (j5 < j6) {
                        byte[] bArr = zzbpxVar.zzb;
                        int iMin = (int) Math.min(zzbpxVar.zzd, (((long) zzbpxVar.zzc) + j6) - j5);
                        int i = (int) ((((long) zzbpxVar.zzc) + j7) - j5);
                        while (true) {
                            if (i >= iMin) {
                                j7 = j5 + ((long) (zzbpxVar.zzd - zzbpxVar.zzc));
                                zzbpxVar = zzbpxVar.zzg;
                                Intrinsics.checkNotNull(zzbpxVar);
                                j5 = j7;
                            } else if (bArr[i] == 10) {
                                j2 = i - zzbpxVar.zzc;
                                j3 = j2 + j5;
                                j4 = -1;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            }
            j4 = -1;
            j3 = -1;
        } else {
            j5 = 0;
            while (true) {
                long j8 = ((long) (zzbpxVar.zzd - zzbpxVar.zzc)) + j5;
                if (j8 > 0) {
                    break;
                }
                zzbpxVar = zzbpxVar.zzg;
                Intrinsics.checkNotNull(zzbpxVar);
                j5 = j8;
            }
            if (zzbpxVar != null) {
                long j9 = 0;
                while (true) {
                    if (j5 < j6) {
                        byte[] bArr2 = zzbpxVar.zzb;
                        int iMin2 = (int) Math.min(zzbpxVar.zzd, (((long) zzbpxVar.zzc) + j6) - j5);
                        int i2 = (int) ((((long) zzbpxVar.zzc) + j9) - j5);
                        while (true) {
                            if (i2 >= iMin2) {
                                j9 = ((long) (zzbpxVar.zzd - zzbpxVar.zzc)) + j5;
                                zzbpxVar = zzbpxVar.zzg;
                                Intrinsics.checkNotNull(zzbpxVar);
                                j5 = j9;
                            } else if (bArr2[i2] == 10) {
                                j2 = i2 - zzbpxVar.zzc;
                                j3 = j2 + j5;
                                j4 = -1;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
            }
            j4 = -1;
            j3 = -1;
        }
        if (j3 != j4) {
            int i3 = zzbqh.zza;
            Intrinsics.checkNotNullParameter(this, "<this>");
            if (j3 > 0) {
                long j10 = j3 + j4;
                if (zzb(j10) == 13) {
                    String strZzh = zzh(j10, Charsets.UTF_8);
                    zzF(2L);
                    return strZzh;
                }
            }
            String strZzh2 = zzh(j3, Charsets.UTF_8);
            zzF(1L);
            return strZzh2;
        }
        zzbpl out = new zzbpl();
        long jMin = Math.min(32L, this.zzb);
        Intrinsics.checkNotNullParameter(out, "out");
        zzbpf.zzb(this.zzb, 0L, jMin);
        if (jMin != 0) {
            out.zzb += jMin;
            zzbpx zzbpxVar2 = this.zza;
            long j11 = 0;
            while (true) {
                Intrinsics.checkNotNull(zzbpxVar2);
                long j12 = zzbpxVar2.zzd - zzbpxVar2.zzc;
                if (j11 < j12) {
                    break;
                }
                zzbpxVar2 = zzbpxVar2.zzg;
                j11 -= j12;
            }
            while (jMin > 0) {
                Intrinsics.checkNotNull(zzbpxVar2);
                zzbpx zzbpxVarZzc = zzbpxVar2.zzc();
                int i4 = zzbpxVarZzc.zzc + ((int) j11);
                zzbpxVarZzc.zzc = i4;
                zzbpxVarZzc.zzd = Math.min(i4 + ((int) jMin), zzbpxVarZzc.zzd);
                zzbpx zzbpxVar3 = out.zza;
                if (zzbpxVar3 == null) {
                    zzbpxVarZzc.zzh = zzbpxVarZzc;
                    zzbpxVarZzc.zzg = zzbpxVarZzc.zzh;
                    out.zza = zzbpxVarZzc.zzg;
                } else {
                    Intrinsics.checkNotNull(zzbpxVar3);
                    zzbpx zzbpxVar4 = zzbpxVar3.zzh;
                    Intrinsics.checkNotNull(zzbpxVar4);
                    zzbpxVar4.zzb(zzbpxVarZzc);
                }
                jMin -= (long) (zzbpxVarZzc.zzd - zzbpxVarZzc.zzc);
                zzbpxVar2 = zzbpxVar2.zzg;
                j11 = 0;
            }
        }
        throw new EOFException("\\n not found: limit=" + Math.min(this.zzb, Long.MAX_VALUE) + " content=" + out.zzy(out.zzb).zze() + "…");
    }

    public final zzbpp zzA(int i) {
        if (i == 0) {
            return zzbpp.zzb;
        }
        zzbpf.zzb(this.zzb, 0L, i);
        zzbpx zzbpxVar = this.zza;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(zzbpxVar);
            int i5 = zzbpxVar.zzd;
            int i6 = zzbpxVar.zzc;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            zzbpxVar = zzbpxVar.zzg;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 + i4];
        zzbpx zzbpxVar2 = this.zza;
        int i7 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(zzbpxVar2);
            bArr[i7] = zzbpxVar2.zzb;
            i2 += zzbpxVar2.zzd - zzbpxVar2.zzc;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = zzbpxVar2.zzc;
            zzbpxVar2.zze = true;
            i7++;
            zzbpxVar2 = zzbpxVar2.zzg;
        }
        return new zzbpz(bArr, iArr);
    }
}
