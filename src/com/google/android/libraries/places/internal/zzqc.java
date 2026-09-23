package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzqc {
    public static final /* synthetic */ int zza = 0;
    private static final zzmb zzb = zzmb.zzn(UriUtil.HTTP_SCHEME, UriUtil.HTTPS_SCHEME, "mailto", "ftp");
    private static final zzmb zzc = zzmb.zzp("audio/3gpp2", "audio/3gpp", "audio/aac", "audio/midi", "audio/mp3", "audio/mp4", "audio/mpeg", "audio/oga", "audio/ogg", "audio/opus", "audio/x-m4a", "audio/x-matroska", "audio/x-wav", "audio/wav", "audio/webm", "image/bmp", "image/gif", "image/jpeg", "image/jpg", "image/png", "image/svg+xml", "image/tiff", "image/webp", "image/x-icon", "video/mpeg", "video/mp4", "video/ogg", "video/webm", "video/x-matroska", "font/ttf");
    private static final zzmb zzd = zzmb.zzk();

    public static zzqb zza(String str, zzqb zzqbVar) {
        char cCharAt;
        int i;
        char cCharAt2;
        char cCharAt3;
        zzmb zzmbVar = zzd;
        String strZza = zzjv.zza(str);
        zzmx it2 = zzb.iterator();
        while (it2.hasNext()) {
            if (strZza.startsWith(String.valueOf((String) it2.next()).concat(":"))) {
                return new zzqb(str);
            }
        }
        if (!strZza.startsWith("data:")) {
            Iterator it3 = zzmbVar.iterator();
            while (it3.hasNext()) {
                if (strZza.startsWith(String.valueOf(zzjv.zza(((zzpy) it3.next()).name()).replace('_', '-')).concat(":"))) {
                    return new zzqb(str);
                }
            }
            for (int i2 = 0; i2 < str.length() && (cCharAt = str.charAt(i2)) != '#' && cCharAt != '/'; i2++) {
                if (cCharAt == ':') {
                    return zzqbVar;
                }
                if (cCharAt == '?') {
                    break;
                }
            }
            return new zzqb(str);
        }
        String strZza2 = zzjv.zza(str);
        if (strZza2.startsWith("data:") && strZza2.length() > 5) {
            int i3 = 5;
            while (i3 < strZza2.length() && (cCharAt3 = strZza2.charAt(i3)) != ';' && cCharAt3 != ',') {
                i3++;
            }
            if (zzc.contains(strZza2.substring(5, i3)) && strZza2.startsWith(";base64,", i3) && (i = i3 + 8) < strZza2.length()) {
                while (i < strZza2.length() && (cCharAt2 = strZza2.charAt(i)) != '=') {
                    if ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || ((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '+' || cCharAt2 == '/')) {
                        i++;
                    }
                }
                while (i < strZza2.length()) {
                    if (strZza2.charAt(i) == '=') {
                        i++;
                    }
                }
                return new zzqb(str);
            }
        }
        return zzqbVar;
    }
}
