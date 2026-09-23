package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzann extends zzalx {
    private final zzanr zza;

    public zzann(zzanr zzanrVar) {
        this.zza = zzanrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzapg
    public final /* synthetic */ Object zzb(zzamr zzamrVar, zzand zzandVar) throws zzaoc {
        int i = zzanr.zzd;
        zzanr zzanrVarZzao = this.zza.zzao();
        try {
            zzapm zzapmVarZzb = zzapi.zza().zzb(zzanrVarZzao.getClass());
            zzapmVarZzb.zzf(zzanrVarZzao, zzams.zzq(zzamrVar), zzandVar);
            zzapmVarZzb.zzd(zzanrVarZzao);
            return zzanrVarZzao;
        } catch (zzaoc e) {
            e = e;
            if (e.zzl()) {
                e = new zzaoc(e);
            }
            e.zzh(zzanrVarZzao);
            throw e;
        } catch (zzaqf e2) {
            zzaoc zzaocVarZza = e2.zza();
            zzaocVarZza.zzh(zzanrVarZzao);
            throw zzaocVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzaoc) {
                throw ((zzaoc) e3.getCause());
            }
            zzaoc zzaocVar = new zzaoc(e3);
            zzaocVar.zzh(zzanrVarZzao);
            throw zzaocVar;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzaoc) {
                throw ((zzaoc) e4.getCause());
            }
            throw e4;
        }
    }
}
