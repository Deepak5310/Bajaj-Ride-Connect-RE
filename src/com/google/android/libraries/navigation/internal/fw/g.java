package com.google.android.libraries.navigation.internal.fw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public enum g {
    PROTOCOL_ERROR_INVALID_CONTENT_TYPE(true),
    PROTOCOL_ERROR_VERSION_MISMATCH(true),
    HTTP_BAD_REQUEST(true),
    HTTP_NOT_FOUND(false),
    HTTP_SERVER_ERROR(false),
    HTTP_UNKNOWN_STATUS_CODE(false),
    IO_ERROR(false),
    NO_CONNECTIVITY(false),
    INVALID_API_TOKEN(false),
    INVALID_GAIA_AUTH_TOKEN(false),
    MALFORMED_MESSAGE(false),
    SINGLE_REQUEST_ERROR(false),
    SINGLE_REQUEST_FATAL_ERROR(true),
    REQUEST_TIMEOUT(false),
    CAPACITY_LIMIT_EXCEEDED(false),
    CANCELED(true),
    UNSUPPORTED_REQUEST_TYPE(false),
    CANNOT_CREATE_REQUEST(true);

    public final boolean s;

    g(boolean z) {
        this.s = z;
    }
}
