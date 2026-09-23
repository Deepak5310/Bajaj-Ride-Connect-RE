package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzki {
    private final String zza;

    private zzki(String str) {
        this.zza = str;
    }

    public static zzki zzb(char c) {
        return new zzki(",");
    }

    public static zzki zzc(String str) {
        return new zzki(str);
    }

    static final CharSequence zzh(@CheckForNull Object obj) {
        obj.getClass();
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public Appendable zza(Appendable appendable, Iterator it2) throws IOException {
        if (it2.hasNext()) {
            appendable.append(zzh(it2.next()));
            while (it2.hasNext()) {
                appendable.append(this.zza);
                appendable.append(zzh(it2.next()));
            }
        }
        return appendable;
    }

    public final zzki zzd() {
        return new zzkf(this, this);
    }

    public final String zzf(Iterable iterable) {
        Iterator it2 = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        zzg(sb, it2);
        return sb.toString();
    }

    public final StringBuilder zzg(StringBuilder sb, Iterator it2) {
        try {
            zza(sb, it2);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
