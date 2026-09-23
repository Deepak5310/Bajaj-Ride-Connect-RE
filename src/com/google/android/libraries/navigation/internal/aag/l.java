package com.google.android.libraries.navigation.internal.aag;

import io.grpc.internal.GrpcUtil;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l {
    public static l d(String str) {
        return new c(str, GrpcUtil.DEFAULT_PORT_SSL, GrpcUtil.DEFAULT_PORT_SSL);
    }

    public abstract int a();

    public abstract int b();

    public abstract String c();
}
