package com.google.android.libraries.navigation.internal.afx;

import io.grpc.Metadata;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bk extends bl {
    public bk(String str, bg bgVar) {
        super(str, false);
        com.google.android.libraries.navigation.internal.yx.ar.i(str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
        com.google.android.libraries.navigation.internal.yx.ar.b(str.length() > 4, "empty key name");
        com.google.android.libraries.navigation.internal.yx.ar.r(bgVar, "marshaller is null");
    }
}
