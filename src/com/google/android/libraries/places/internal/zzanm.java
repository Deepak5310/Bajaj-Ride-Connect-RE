package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzanm;
import com.google.android.libraries.places.internal.zzanr;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzanm<MessageType extends zzanr<MessageType, BuilderType>, BuilderType extends zzanm<MessageType, BuilderType>> extends zzalv<MessageType, BuilderType> {
    protected zzanr zza;
    private final zzanr zzb;

    protected zzanm(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaD()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzao();
    }

    @Override // com.google.android.libraries.places.internal.zzapa
    public final /* synthetic */ zzaoz zzaE() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzapa
    public final boolean zzaF() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzalv
    /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public final zzanm clone() {
        zzanm zzanmVar = (zzanm) this.zzb.zzb(5, null, null);
        zzanmVar.zza = zzs();
        return zzanmVar;
    }

    public final MessageType zzq() {
        MessageType messagetype = (MessageType) zzs();
        if (messagetype.zzaF()) {
            return messagetype;
        }
        throw new zzaqf(messagetype);
    }

    @Override // com.google.android.libraries.places.internal.zzaoy
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public MessageType zzs() {
        if (!this.zza.zzaD()) {
            return (MessageType) this.zza;
        }
        this.zza.zzay();
        return (MessageType) this.zza;
    }

    protected final void zzu() {
        if (this.zza.zzaD()) {
            return;
        }
        zzv();
    }

    protected void zzv() {
        zzanr zzanrVarZzao = this.zzb.zzao();
        zzapi.zza().zzb(zzanrVarZzao.getClass()).zze(zzanrVarZzao, this.zza);
        this.zza = zzanrVarZzao;
    }
}
