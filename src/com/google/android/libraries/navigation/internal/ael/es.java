package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum es {
    DOUBLE(et.DOUBLE, 1),
    FLOAT(et.FLOAT, 5),
    INT64(et.LONG, 0),
    UINT64(et.LONG, 0),
    INT32(et.INT, 0),
    FIXED64(et.LONG, 1),
    FIXED32(et.INT, 5),
    BOOL(et.BOOLEAN, 0),
    STRING(et.STRING, 2),
    GROUP(et.MESSAGE, 3),
    MESSAGE(et.MESSAGE, 2),
    BYTES(et.BYTE_STRING, 2),
    UINT32(et.INT, 0),
    ENUM(et.ENUM, 0),
    SFIXED32(et.INT, 5),
    SFIXED64(et.LONG, 1),
    SINT32(et.INT, 0),
    SINT64(et.LONG, 0);

    public final et s;
    public final int t;

    es(et etVar, int i) {
        this.s = etVar;
        this.t = i;
    }
}
