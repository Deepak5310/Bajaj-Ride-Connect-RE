package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbne {
    private static final zzbpp zza;
    private static final zzbnb[] zzb;
    private static final Map zzc;

    static {
        zzbpo zzbpoVar = zzbpp.zza;
        zza = zzbpo.zza(":");
        int i = 0;
        zzb = new zzbnb[]{new zzbnb(zzbnb.zze, zzbpo.zza("")), new zzbnb(zzbnb.zzb, zzbpo.zza("GET")), new zzbnb(zzbnb.zzb, zzbpo.zza("POST")), new zzbnb(zzbnb.zzc, zzbpo.zza(RemoteSettings.FORWARD_SLASH_STRING)), new zzbnb(zzbnb.zzc, zzbpo.zza("/index.html")), new zzbnb(zzbnb.zzd, zzbpo.zza(UriUtil.HTTP_SCHEME)), new zzbnb(zzbnb.zzd, zzbpo.zza(UriUtil.HTTPS_SCHEME)), new zzbnb(zzbnb.zza, zzbpo.zza("200")), new zzbnb(zzbnb.zza, zzbpo.zza("204")), new zzbnb(zzbnb.zza, zzbpo.zza("206")), new zzbnb(zzbnb.zza, zzbpo.zza("304")), new zzbnb(zzbnb.zza, zzbpo.zza("400")), new zzbnb(zzbnb.zza, zzbpo.zza("404")), new zzbnb(zzbnb.zza, zzbpo.zza("500")), new zzbnb("accept-charset", ""), new zzbnb(GrpcUtil.CONTENT_ACCEPT_ENCODING, "gzip, deflate"), new zzbnb("accept-language", ""), new zzbnb("accept-ranges", ""), new zzbnb("accept", ""), new zzbnb("access-control-allow-origin", ""), new zzbnb("age", ""), new zzbnb("allow", ""), new zzbnb("authorization", ""), new zzbnb("cache-control", ""), new zzbnb("content-disposition", ""), new zzbnb(GrpcUtil.CONTENT_ENCODING, ""), new zzbnb("content-language", ""), new zzbnb("content-length", ""), new zzbnb("content-location", ""), new zzbnb("content-range", ""), new zzbnb("content-type", ""), new zzbnb("cookie", ""), new zzbnb("date", ""), new zzbnb("etag", ""), new zzbnb("expect", ""), new zzbnb("expires", ""), new zzbnb("from", ""), new zzbnb("host", ""), new zzbnb("if-match", ""), new zzbnb("if-modified-since", ""), new zzbnb("if-none-match", ""), new zzbnb("if-range", ""), new zzbnb("if-unmodified-since", ""), new zzbnb("last-modified", ""), new zzbnb("link", ""), new zzbnb(FirebaseAnalytics.Param.LOCATION, ""), new zzbnb("max-forwards", ""), new zzbnb("proxy-authenticate", ""), new zzbnb("proxy-authorization", ""), new zzbnb("range", ""), new zzbnb("referer", ""), new zzbnb("refresh", ""), new zzbnb("retry-after", ""), new zzbnb("server", ""), new zzbnb("set-cookie", ""), new zzbnb("strict-transport-security", ""), new zzbnb("transfer-encoding", ""), new zzbnb("user-agent", ""), new zzbnb("vary", ""), new zzbnb("via", ""), new zzbnb("www-authenticate", "")};
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        while (true) {
            zzbnb[] zzbnbVarArr = zzb;
            int length = zzbnbVarArr.length;
            if (i >= 61) {
                zzc = Collections.unmodifiableMap(linkedHashMap);
                return;
            } else {
                if (!linkedHashMap.containsKey(zzbnbVarArr[i].zzh)) {
                    linkedHashMap.put(zzbnbVarArr[i].zzh, Integer.valueOf(i));
                }
                i++;
            }
        }
    }

    static /* bridge */ /* synthetic */ zzbpp zzc(zzbpp zzbppVar) throws IOException {
        int iZzc = zzbppVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            byte bZza = zzbppVar.zza(i);
            if (bZza >= 65 && bZza <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(zzbppVar.zzf()));
            }
        }
        return zzbppVar;
    }
}
