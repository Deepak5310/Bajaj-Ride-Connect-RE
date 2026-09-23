package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum s implements bm {
    UNKNOWN(0),
    PROTOCOL_ERROR_INVALID_CONTENT_TYPE(1),
    PROTOCOL_ERROR_VERSION_MISMATCH(2),
    HTTP_BAD_REQUEST(3),
    HTTP_NOT_FOUND(4),
    HTTP_SERVER_ERROR(5),
    HTTP_UNKNOWN_STATUS_CODE(6),
    IO_ERROR(7),
    NO_CONNECTIVITY(8),
    INVALID_API_TOKEN(9),
    INVALID_GAIA_AUTH_TOKEN(10),
    MALFORMED_MESSAGE(11),
    SINGLE_REQUEST_ERROR(12),
    SINGLE_REQUEST_FATAL_ERROR(13),
    REQUEST_TIMEOUT(14),
    CAPACITY_LIMIT_EXCEEDED(15),
    CANCELED(16),
    UNSUPPORTED_REQUEST_TYPE(17),
    CANNOT_CREATE_REQUEST(18),
    UNRECOGNIZED(-1);

    private final int v;

    s(int i) {
        this.v = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.v;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(a());
    }
}
