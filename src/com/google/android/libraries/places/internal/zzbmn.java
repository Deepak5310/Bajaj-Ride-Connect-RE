package com.google.android.libraries.places.internal;

import java.security.PrivilegedExceptionAction;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbmn implements PrivilegedExceptionAction {
    zzbmn() {
    }

    @Override // java.security.PrivilegedExceptionAction
    public final /* bridge */ /* synthetic */ Object run() throws Exception {
        return SSLSocket.class.getMethod("getApplicationProtocol", null);
    }
}
