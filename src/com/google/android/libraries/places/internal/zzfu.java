package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfu {
    private String description;
    private Integer distanceMeters;
    private zzb[] matchedSubstrings;
    private String placeId;
    private zza structuredFormatting;
    private String[] types;

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    class zza {
        private String mainText;
        private zzb[] mainTextMatchedSubstrings;
        private String secondaryText;
        private zzb[] secondaryTextMatchedSubstrings;

        zza() {
        }

        final zzlx zza() {
            zzb[] zzbVarArr = this.mainTextMatchedSubstrings;
            return zzbVarArr != null ? zzlx.zzk(zzbVarArr) : zzlx.zzl();
        }

        final zzlx zzb() {
            zzb[] zzbVarArr = this.secondaryTextMatchedSubstrings;
            return zzbVarArr != null ? zzlx.zzk(zzbVarArr) : zzlx.zzl();
        }

        final String zzc() {
            return this.mainText;
        }

        final String zzd() {
            return this.secondaryText;
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    class zzb {
        Integer length;
        Integer offset;

        zzb() {
        }
    }

    zzfu() {
    }

    final zza zza() {
        return this.structuredFormatting;
    }

    final zzlx zzb() {
        zzb[] zzbVarArr = this.matchedSubstrings;
        return zzbVarArr != null ? zzlx.zzk(zzbVarArr) : zzlx.zzl();
    }

    final zzlx zzc() {
        String[] strArr = this.types;
        return strArr != null ? zzlx.zzk(strArr) : zzlx.zzl();
    }

    final Integer zzd() {
        return this.distanceMeters;
    }

    final String zze() {
        return this.description;
    }

    final String zzf() {
        return this.placeId;
    }
}
