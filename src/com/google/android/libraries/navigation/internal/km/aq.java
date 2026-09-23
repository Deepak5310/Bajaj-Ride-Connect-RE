package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum aq {
    SUCCESS(0),
    REQUEST_TIMEOUT(1),
    IO_ERROR(2),
    CANCELED(3),
    PROTOCOL_ERROR_INVALID_CONTENT_TYPE(4),
    PROTOCOL_ERROR_VERSION_MISMATCH(5),
    MALFORMED_MESSAGE(6),
    HTTP_BAD_REQUEST(7),
    INVALID_API_TOKEN(8),
    HTTP_SERVER_ERROR(9),
    NO_CONNECTIVITY(10),
    UNSUPPORTED_REQUEST_TYPE(11),
    HTTP_UNKNOWN_STATUS_CODE(12),
    HTTP_NOT_FOUND(13),
    INVALID_GAIA_AUTH_TOKEN(14),
    DEADLINE_EXCEEDED(15),
    FAILED_PRECONDITION(16),
    INTERNAL(17),
    INVALID_ARGUMENT(18),
    OUT_OF_RANGE(19),
    PERMISSION_DENIED(20),
    UNAUTHENTICATED(21),
    UNAVAILABLE(22),
    CANNOT_CREATE_REQUEST(23);

    public final int y;

    aq(int i) {
        this.y = i;
    }
}
