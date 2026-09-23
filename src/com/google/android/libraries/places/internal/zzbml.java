package com.google.android.libraries.places.internal;

import java.security.PrivilegedExceptionAction;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbml implements PrivilegedExceptionAction {
    zzbml() {
    }

    @Override // java.security.PrivilegedExceptionAction
    public final /* bridge */ /* synthetic */ Object run() throws Exception {
        return SSLEngine.class.getMethod("getApplicationProtocol", null);
    }
}
