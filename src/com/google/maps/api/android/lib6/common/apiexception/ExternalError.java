package com.google.maps.api.android.lib6.common.apiexception;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes6.dex */
public class ExternalError extends Error implements ApiExpectedException {
    public ExternalError(Error error) {
        super(error);
    }
}
