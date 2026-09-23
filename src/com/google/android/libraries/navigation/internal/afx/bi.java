package com.google.android.libraries.navigation.internal.afx;

import io.grpc.Metadata;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bi extends bl {
    public bi(String str, bj bjVar) {
        super(str, false);
        com.google.android.libraries.navigation.internal.yx.ar.i(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
        com.google.android.libraries.navigation.internal.yx.ar.r(bjVar, "marshaller");
    }
}
