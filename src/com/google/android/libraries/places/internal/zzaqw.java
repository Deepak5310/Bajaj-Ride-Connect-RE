package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzaqw {
    DOUBLE(zzaqx.DOUBLE, 1),
    FLOAT(zzaqx.FLOAT, 5),
    INT64(zzaqx.LONG, 0),
    UINT64(zzaqx.LONG, 0),
    INT32(zzaqx.INT, 0),
    FIXED64(zzaqx.LONG, 1),
    FIXED32(zzaqx.INT, 5),
    BOOL(zzaqx.BOOLEAN, 0),
    STRING(zzaqx.STRING, 2),
    GROUP(zzaqx.MESSAGE, 3),
    MESSAGE(zzaqx.MESSAGE, 2),
    BYTES(zzaqx.BYTE_STRING, 2),
    UINT32(zzaqx.INT, 0),
    ENUM(zzaqx.ENUM, 0),
    SFIXED32(zzaqx.INT, 5),
    SFIXED64(zzaqx.LONG, 1),
    SINT32(zzaqx.INT, 0),
    SINT64(zzaqx.LONG, 0);

    private final zzaqx zzt;

    zzaqw(zzaqx zzaqxVar, int i) {
        this.zzt = zzaqxVar;
    }

    public final zzaqx zza() {
        return this.zzt;
    }
}
