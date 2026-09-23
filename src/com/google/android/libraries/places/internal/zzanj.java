package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzanj {
    DOUBLE(0, 1, zzaod.DOUBLE),
    FLOAT(1, 1, zzaod.FLOAT),
    INT64(2, 1, zzaod.LONG),
    UINT64(3, 1, zzaod.LONG),
    INT32(4, 1, zzaod.INT),
    FIXED64(5, 1, zzaod.LONG),
    FIXED32(6, 1, zzaod.INT),
    BOOL(7, 1, zzaod.BOOLEAN),
    STRING(8, 1, zzaod.STRING),
    MESSAGE(9, 1, zzaod.MESSAGE),
    BYTES(10, 1, zzaod.BYTE_STRING),
    UINT32(11, 1, zzaod.INT),
    ENUM(12, 1, zzaod.ENUM),
    SFIXED32(13, 1, zzaod.INT),
    SFIXED64(14, 1, zzaod.LONG),
    SINT32(15, 1, zzaod.INT),
    SINT64(16, 1, zzaod.LONG),
    GROUP(17, 1, zzaod.MESSAGE),
    DOUBLE_LIST(18, 2, zzaod.DOUBLE),
    FLOAT_LIST(19, 2, zzaod.FLOAT),
    INT64_LIST(20, 2, zzaod.LONG),
    UINT64_LIST(21, 2, zzaod.LONG),
    INT32_LIST(22, 2, zzaod.INT),
    FIXED64_LIST(23, 2, zzaod.LONG),
    FIXED32_LIST(24, 2, zzaod.INT),
    BOOL_LIST(25, 2, zzaod.BOOLEAN),
    STRING_LIST(26, 2, zzaod.STRING),
    MESSAGE_LIST(27, 2, zzaod.MESSAGE),
    BYTES_LIST(28, 2, zzaod.BYTE_STRING),
    UINT32_LIST(29, 2, zzaod.INT),
    ENUM_LIST(30, 2, zzaod.ENUM),
    SFIXED32_LIST(31, 2, zzaod.INT),
    SFIXED64_LIST(32, 2, zzaod.LONG),
    SINT32_LIST(33, 2, zzaod.INT),
    SINT64_LIST(34, 2, zzaod.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzaod.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzaod.FLOAT),
    INT64_LIST_PACKED(37, 3, zzaod.LONG),
    UINT64_LIST_PACKED(38, 3, zzaod.LONG),
    INT32_LIST_PACKED(39, 3, zzaod.INT),
    FIXED64_LIST_PACKED(40, 3, zzaod.LONG),
    FIXED32_LIST_PACKED(41, 3, zzaod.INT),
    BOOL_LIST_PACKED(42, 3, zzaod.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzaod.INT),
    ENUM_LIST_PACKED(44, 3, zzaod.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzaod.INT),
    SFIXED64_LIST_PACKED(46, 3, zzaod.LONG),
    SINT32_LIST_PACKED(47, 3, zzaod.INT),
    SINT64_LIST_PACKED(48, 3, zzaod.LONG),
    GROUP_LIST(49, 2, zzaod.MESSAGE),
    MAP(50, 4, zzaod.VOID);

    private static final zzanj[] zzZ;
    private final zzaod zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzanj[] zzanjVarArrValues = values();
        zzZ = new zzanj[zzanjVarArrValues.length];
        for (zzanj zzanjVar : zzanjVarArrValues) {
            zzZ[zzanjVar.zzac] = zzanjVar;
        }
    }

    zzanj(int i, int i2, zzaod zzaodVar) {
        this.zzac = i;
        this.zzab = zzaodVar;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            this.zzad = zzaodVar.zza();
        } else {
            this.zzad = null;
        }
        if (i2 == 1) {
            zzaod zzaodVar2 = zzaod.VOID;
            zzaodVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
