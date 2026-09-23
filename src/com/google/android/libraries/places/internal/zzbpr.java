package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class zzbpr {
    public static final zzbpm zza(zzbqa zzbqaVar) {
        Intrinsics.checkNotNullParameter(zzbqaVar, "<this>");
        return new zzbpu(zzbqaVar);
    }

    public static final zzbpn zzb(zzbqc zzbqcVar) {
        Intrinsics.checkNotNullParameter(zzbqcVar, "<this>");
        return new zzbpv(zzbqcVar);
    }

    public static final zzbqa zzc(Socket socket) throws IOException {
        int i = zzbps.zza;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        zzbqb zzbqbVar = new zzbqb(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream(...)");
        zzbpt sink = new zzbpt(outputStream, zzbqbVar);
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new zzbph(zzbqbVar, sink);
    }

    public static final zzbqc zzd(Socket socket) throws IOException {
        int i = zzbps.zza;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        zzbqb zzbqbVar = new zzbqb(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        zzbpq source = new zzbpq(inputStream, zzbqbVar);
        Intrinsics.checkNotNullParameter(source, "source");
        return new zzbpi(zzbqbVar, source);
    }
}
