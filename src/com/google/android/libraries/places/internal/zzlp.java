package com.google.android.libraries.places.internal;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzlp implements Comparable, Serializable {
    final Comparable zza;

    zzlp(Comparable comparable) {
        this.zza = comparable;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzlp) {
            try {
                if (compareTo((zzlp) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public int compareTo(zzlp zzlpVar) {
        if (zzlpVar != zzln.zzb) {
            if (zzlpVar == zzll.zzb) {
                return -1;
            }
            Comparable comparable = this.zza;
            Comparable comparable2 = zzlpVar.zza;
            int i = zzmk.zzc;
            int iCompareTo = comparable.compareTo(comparable2);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            boolean z = this instanceof zzlm;
            if (z == (zzlpVar instanceof zzlm)) {
                return 0;
            }
            if (!z) {
                return -1;
            }
        }
        return 1;
    }

    abstract void zzc(StringBuilder sb);

    abstract void zzd(StringBuilder sb);

    abstract boolean zze(Comparable comparable);
}
