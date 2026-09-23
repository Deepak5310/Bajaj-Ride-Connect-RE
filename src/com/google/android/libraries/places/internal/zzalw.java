package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzalv;
import com.google.android.libraries.places.internal.zzalw;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzalw<MessageType extends zzalw<MessageType, BuilderType>, BuilderType extends zzalv<MessageType, BuilderType>> implements zzaoz {
    protected int zza = 0;

    int zzag(zzapm zzapmVar) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzaoz
    public final zzaml zzah() {
        try {
            int iZzal = zzal();
            zzaml zzamlVar = zzaml.zzb;
            byte[] bArr = new byte[iZzal];
            zzamu zzamuVar = new zzamu(bArr, 0, iZzal);
            zzaC(zzamuVar);
            zzamuVar.zzD();
            return new zzami(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaoz
    public final void zzai(OutputStream outputStream) throws IOException {
        int iZzal = zzal();
        int i = zzamy.zzf;
        if (iZzal > 4096) {
            iZzal = 4096;
        }
        zzamw zzamwVar = new zzamw(outputStream, iZzal);
        zzaC(zzamwVar);
        zzamwVar.zzI();
    }

    @Override // com.google.android.libraries.places.internal.zzaoz
    public final byte[] zzaj() {
        try {
            int iZzal = zzal();
            byte[] bArr = new byte[iZzal];
            zzamu zzamuVar = new zzamu(bArr, 0, iZzal);
            zzaC(zzamuVar);
            zzamuVar.zzD();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
