package com.google.android.libraries.places.internal;

import com.facebook.hermes.intl.Constants;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okio.Utf8;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzqa {
    private static final zzmb zza = zzmb.zzp("applet", Constants.SENSITIVITY_BASE, "embed", "math", "meta", "object", "svg", "template");
    private static final zzmb zzb = zzmb.zzl("script");
    private static final zzmb zzc = zzmb.zzl("style");
    private static final zzmb zzd = zzmb.zzp("area", "br", "col", "hr", "img", "input", "link", "param", "source", SavingTrackHelper.TRACK_NAME, "wbr");
    private static final zzmb zze = zzmb.zzl("input");
    private static final zzmb zzf = zzmb.zzl("form");
    private static final zzmb zzg = zzmb.zzl("script");
    private static final zzmb zzh = zzmb.zzm("button", "input");
    private static final zzmb zzi = zzmb.zzm("button", "input");
    private static final zzmb zzj = zzmb.zzm("a", "area");
    private static final zzmb zzk = zzmb.zzp("alternate", "author", "bookmark", "canonical", "cite", "help", "icon", "license", "next", "prefetch", "dns-prefetch", "prerender", "preconnect", "preload", "prev", "search", "subresource");
    private static final zzmb zzl = zzmb.zzl("form");
    private static final zzmb zzm = zzmb.zzl("input");
    private static final zzmb zzn = zzmb.zzm("input", "textarea");
    private static final zzmb zzo = zzmb.zzo("audio", "img", "input", "source", "video");
    private static final zzmb zzp = zzmb.zzl("iframe");
    private final String zzq;
    private final Map zzr = new LinkedHashMap();
    private final List zzs = new ArrayList();

    public zzqa(String str) {
        if (!"a".matches("[a-z0-9-]+")) {
            throw new IllegalArgumentException("Invalid element name \"a\". Only lowercase letters, numbers and '-' allowed.");
        }
        if (zza.contains("a")) {
            throw new IllegalArgumentException("Element \"a\" is not supported.");
        }
        this.zzq = "a";
    }

    public final zzpz zza() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.zzq);
        for (Map.Entry entry : this.zzr.entrySet()) {
            sb.append(StringUtils.SPACE);
            sb.append((String) entry.getKey());
            sb.append("=\"");
            sb.append(zzpw.zza((String) entry.getValue()));
            sb.append("\"");
        }
        boolean zContains = zzd.contains(this.zzq);
        sb.append(">");
        if (!zContains) {
            Iterator it2 = this.zzs.iterator();
            while (it2.hasNext()) {
                sb.append((String) it2.next());
            }
            sb.append("</");
            sb.append(this.zzq);
            sb.append(">");
        }
        return new zzpz(sb.toString());
    }

    public final zzqa zzb(String str) {
        Iterator it2 = Arrays.asList(new zzpz(zzpw.zza(zzahx.zza(str, Utf8.REPLACEMENT_CODE_POINT)))).iterator();
        zzkt.zzq(!zzd.contains(this.zzq), "Element \"%s\" is a void element and so cannot have content.", this.zzq);
        zzkt.zzq(!zzb.contains(this.zzq), "Element \"%s\" requires SafeScript contents, not SafeHTML or text.", this.zzq);
        zzkt.zzq(true ^ zzc.contains(this.zzq), "Element \"%s\" requires SafeStyleSheet contents, not SafeHTML or text.", this.zzq);
        while (it2.hasNext()) {
            this.zzs.add(((zzpz) it2.next()).zza());
        }
        return this;
    }

    public final zzqa zzc(zzqb zzqbVar) {
        String str;
        zzmb zzmbVar = zzj;
        if (!zzmbVar.contains(this.zzq) && !this.zzq.equals("link")) {
            throw new IllegalArgumentException("Attribute \"href\" with a SafeUrl value can only be used by one of the following elements: ".concat(String.valueOf(String.valueOf(zzmbVar))));
        }
        if (!this.zzq.equals("link") || (str = (String) this.zzr.get("rel")) == null || zzk.contains(str.toLowerCase(Locale.ENGLISH))) {
            this.zzr.put("href", zzahx.zza(zzqbVar.zza(), Utf8.REPLACEMENT_CODE_POINT));
            return this;
        }
        throw new IllegalArgumentException("SafeUrl values for the href attribute are not allowed on <link rel=" + str + ">. Did you intend to use a TrustedResourceUrl?");
    }
}
