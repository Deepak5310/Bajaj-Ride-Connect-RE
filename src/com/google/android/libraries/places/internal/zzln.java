package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzln extends zzlp {
    private static final zzln zzb = new zzln();

    private zzln() {
        super("");
    }

    @Override // com.google.android.libraries.places.internal.zzlp, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return zza((zzlp) obj);
    }

    @Override // com.google.android.libraries.places.internal.zzlp
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "-∞";
    }

    @Override // com.google.android.libraries.places.internal.zzlp
    public final int zza(zzlp zzlpVar) {
        return zzlpVar == this ? 0 : -1;
    }

    @Override // com.google.android.libraries.places.internal.zzlp
    final void zzc(StringBuilder sb) {
        sb.append("(-∞");
    }

    @Override // com.google.android.libraries.places.internal.zzlp
    final void zzd(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.libraries.places.internal.zzlp
    final boolean zze(Comparable comparable) {
        return true;
    }
}
