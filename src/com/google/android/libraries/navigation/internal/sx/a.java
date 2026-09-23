package com.google.android.libraries.navigation.internal.sx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class a extends com.google.android.libraries.navigation.internal.yx.v {
    @Override // com.google.android.libraries.navigation.internal.yx.v
    protected final /* bridge */ /* synthetic */ Object b(Object obj) {
        com.google.android.libraries.navigation.internal.fw.g gVar = (com.google.android.libraries.navigation.internal.fw.g) obj;
        switch (gVar) {
            case PROTOCOL_ERROR_INVALID_CONTENT_TYPE:
                return s.PROTOCOL_ERROR_INVALID_CONTENT_TYPE;
            case PROTOCOL_ERROR_VERSION_MISMATCH:
                return s.PROTOCOL_ERROR_VERSION_MISMATCH;
            case HTTP_BAD_REQUEST:
                return s.HTTP_BAD_REQUEST;
            case HTTP_NOT_FOUND:
                return s.HTTP_NOT_FOUND;
            case HTTP_SERVER_ERROR:
                return s.HTTP_SERVER_ERROR;
            case HTTP_UNKNOWN_STATUS_CODE:
                return s.HTTP_UNKNOWN_STATUS_CODE;
            case IO_ERROR:
                return s.IO_ERROR;
            case NO_CONNECTIVITY:
                return s.NO_CONNECTIVITY;
            case INVALID_API_TOKEN:
                return s.INVALID_API_TOKEN;
            case INVALID_GAIA_AUTH_TOKEN:
                return s.INVALID_GAIA_AUTH_TOKEN;
            case MALFORMED_MESSAGE:
                return s.MALFORMED_MESSAGE;
            case SINGLE_REQUEST_ERROR:
                return s.SINGLE_REQUEST_ERROR;
            case SINGLE_REQUEST_FATAL_ERROR:
                return s.SINGLE_REQUEST_FATAL_ERROR;
            case REQUEST_TIMEOUT:
                return s.REQUEST_TIMEOUT;
            case CAPACITY_LIMIT_EXCEEDED:
                return s.CAPACITY_LIMIT_EXCEEDED;
            case CANCELED:
                return s.CANCELED;
            case UNSUPPORTED_REQUEST_TYPE:
                return s.UNSUPPORTED_REQUEST_TYPE;
            case CANNOT_CREATE_REQUEST:
                return s.CANNOT_CREATE_REQUEST;
            default:
                throw new IllegalArgumentException("unknown enum value: ".concat(String.valueOf(String.valueOf(gVar))));
        }
    }
}
