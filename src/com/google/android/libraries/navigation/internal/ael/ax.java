package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ax {
    DOUBLE(0, aw.SCALAR, ce.DOUBLE),
    FLOAT(1, aw.SCALAR, ce.FLOAT),
    INT64(2, aw.SCALAR, ce.LONG),
    UINT64(3, aw.SCALAR, ce.LONG),
    INT32(4, aw.SCALAR, ce.INT),
    FIXED64(5, aw.SCALAR, ce.LONG),
    FIXED32(6, aw.SCALAR, ce.INT),
    BOOL(7, aw.SCALAR, ce.BOOLEAN),
    STRING(8, aw.SCALAR, ce.STRING),
    MESSAGE(9, aw.SCALAR, ce.MESSAGE),
    BYTES(10, aw.SCALAR, ce.BYTE_STRING),
    UINT32(11, aw.SCALAR, ce.INT),
    ENUM(12, aw.SCALAR, ce.ENUM),
    SFIXED32(13, aw.SCALAR, ce.INT),
    SFIXED64(14, aw.SCALAR, ce.LONG),
    SINT32(15, aw.SCALAR, ce.INT),
    SINT64(16, aw.SCALAR, ce.LONG),
    GROUP(17, aw.SCALAR, ce.MESSAGE),
    DOUBLE_LIST(18, aw.VECTOR, ce.DOUBLE),
    FLOAT_LIST(19, aw.VECTOR, ce.FLOAT),
    INT64_LIST(20, aw.VECTOR, ce.LONG),
    UINT64_LIST(21, aw.VECTOR, ce.LONG),
    INT32_LIST(22, aw.VECTOR, ce.INT),
    FIXED64_LIST(23, aw.VECTOR, ce.LONG),
    FIXED32_LIST(24, aw.VECTOR, ce.INT),
    BOOL_LIST(25, aw.VECTOR, ce.BOOLEAN),
    STRING_LIST(26, aw.VECTOR, ce.STRING),
    MESSAGE_LIST(27, aw.VECTOR, ce.MESSAGE),
    BYTES_LIST(28, aw.VECTOR, ce.BYTE_STRING),
    UINT32_LIST(29, aw.VECTOR, ce.INT),
    ENUM_LIST(30, aw.VECTOR, ce.ENUM),
    SFIXED32_LIST(31, aw.VECTOR, ce.INT),
    SFIXED64_LIST(32, aw.VECTOR, ce.LONG),
    SINT32_LIST(33, aw.VECTOR, ce.INT),
    SINT64_LIST(34, aw.VECTOR, ce.LONG),
    DOUBLE_LIST_PACKED(35, aw.PACKED_VECTOR, ce.DOUBLE),
    FLOAT_LIST_PACKED(36, aw.PACKED_VECTOR, ce.FLOAT),
    INT64_LIST_PACKED(37, aw.PACKED_VECTOR, ce.LONG),
    UINT64_LIST_PACKED(38, aw.PACKED_VECTOR, ce.LONG),
    INT32_LIST_PACKED(39, aw.PACKED_VECTOR, ce.INT),
    FIXED64_LIST_PACKED(40, aw.PACKED_VECTOR, ce.LONG),
    FIXED32_LIST_PACKED(41, aw.PACKED_VECTOR, ce.INT),
    BOOL_LIST_PACKED(42, aw.PACKED_VECTOR, ce.BOOLEAN),
    UINT32_LIST_PACKED(43, aw.PACKED_VECTOR, ce.INT),
    ENUM_LIST_PACKED(44, aw.PACKED_VECTOR, ce.ENUM),
    SFIXED32_LIST_PACKED(45, aw.PACKED_VECTOR, ce.INT),
    SFIXED64_LIST_PACKED(46, aw.PACKED_VECTOR, ce.LONG),
    SINT32_LIST_PACKED(47, aw.PACKED_VECTOR, ce.INT),
    SINT64_LIST_PACKED(48, aw.PACKED_VECTOR, ce.LONG),
    GROUP_LIST(49, aw.VECTOR, ce.MESSAGE),
    MAP(50, aw.MAP, ce.VOID);

    private static final ax[] aa;
    public final int Z;
    private final aw ac;

    static {
        ax[] axVarArrValues = values();
        aa = new ax[axVarArrValues.length];
        for (ax axVar : axVarArrValues) {
            aa[axVar.Z] = axVar;
        }
    }

    ax(int i, aw awVar, ce ceVar) {
        this.Z = i;
        this.ac = awVar;
        int iOrdinal = awVar.ordinal();
        if (iOrdinal == 1 || iOrdinal == 3) {
            Class cls = ceVar.k;
        }
        if (awVar == aw.SCALAR) {
            ce ceVar2 = ce.VOID;
            ceVar.ordinal();
        }
    }
}
