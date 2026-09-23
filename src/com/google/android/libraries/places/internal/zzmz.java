package com.google.android.libraries.places.internal;

import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzmz extends zznb {
    private final char[][] zza;
    private final int zzb;
    private final char zzc;

    protected zzmz(zzna zznaVar, char c, char c2) {
        char[][] cArrZzb = zznaVar.zzb();
        this.zza = cArrZzb;
        this.zzb = cArrZzb.length;
        this.zzc = CharCompanionObject.MAX_VALUE;
    }

    @Override // com.google.android.libraries.places.internal.zznb
    @CheckForNull
    protected final char[] zzb(char c) {
        char[] cArr;
        if (c >= this.zzb || (cArr = this.zza[c]) == null) {
            return null;
        }
        return cArr;
    }

    @Override // com.google.android.libraries.places.internal.zznb, com.google.android.libraries.places.internal.zznd
    public final String zza(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < this.zzb && this.zza[cCharAt] != null) || cCharAt > this.zzc) {
                return zzc(str, i);
            }
        }
        return str;
    }
}
