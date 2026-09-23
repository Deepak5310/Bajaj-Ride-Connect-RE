package com.google.android.libraries.places.internal;

import java.security.PrivilegedExceptionAction;
import javax.net.ssl.SSLParameters;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbmm implements PrivilegedExceptionAction {
    zzbmm() {
    }

    @Override // java.security.PrivilegedExceptionAction
    public final /* bridge */ /* synthetic */ Object run() throws Exception {
        return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
    }
}
