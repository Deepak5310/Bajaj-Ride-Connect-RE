package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzazv extends zzaxv {
    private static final zzazt zza = new zzazo();
    private static final zzazt zzb = new zzazp();
    private static final zzazt zzc = new zzazq();
    private static final zzazt zzd = new zzazr();
    private static final zzazu zze = new zzazs();
    private final Deque zzf;
    private Deque zzg;
    private int zzh;
    private boolean zzi;

    public zzazv() {
        this.zzf = new ArrayDeque();
    }

    private final int zzm(zzazu zzazuVar, int i, Object obj, int i2) throws IOException {
        zza(i);
        if (!this.zzf.isEmpty()) {
            zzp();
        }
        while (i > 0 && !this.zzf.isEmpty()) {
            zzbhb zzbhbVar = (zzbhb) this.zzf.peek();
            int iMin = Math.min(i, zzbhbVar.zzf());
            i2 = zzazuVar.zza(zzbhbVar, iMin, obj, i2);
            i -= iMin;
            this.zzh -= iMin;
            zzp();
        }
        if (i <= 0) {
            return i2;
        }
        throw new AssertionError("Failed executing read operation");
    }

    private final int zzn(zzazt zzaztVar, int i, Object obj, int i2) {
        try {
            return zzm(zzaztVar, i, obj, i2);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private final void zzo() {
        if (!this.zzi) {
            ((zzbhb) this.zzf.remove()).close();
            return;
        }
        this.zzg.add((zzbhb) this.zzf.remove());
        zzbhb zzbhbVar = (zzbhb) this.zzf.peek();
        if (zzbhbVar != null) {
            zzbhbVar.zzb();
        }
    }

    private final void zzp() {
        if (((zzbhb) this.zzf.peek()).zzf() == 0) {
            zzo();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaxv, com.google.android.libraries.places.internal.zzbhb, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        while (!this.zzf.isEmpty()) {
            ((zzbhb) this.zzf.remove()).close();
        }
        if (this.zzg != null) {
            while (!this.zzg.isEmpty()) {
                ((zzbhb) this.zzg.remove()).close();
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaxv, com.google.android.libraries.places.internal.zzbhb
    public final void zzc() {
        if (!this.zzi) {
            throw new InvalidMarkException();
        }
        zzbhb zzbhbVar = (zzbhb) this.zzf.peek();
        if (zzbhbVar != null) {
            int iZzf = zzbhbVar.zzf();
            zzbhbVar.zzc();
            this.zzh += zzbhbVar.zzf() - iZzf;
        }
        while (true) {
            zzbhb zzbhbVar2 = (zzbhb) this.zzg.pollLast();
            if (zzbhbVar2 == null) {
                return;
            }
            zzbhbVar2.zzc();
            this.zzf.addFirst(zzbhbVar2);
            this.zzh += zzbhbVar2.zzf();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaxv, com.google.android.libraries.places.internal.zzbhb
    public final boolean zzd() {
        Iterator it2 = this.zzf.iterator();
        while (it2.hasNext()) {
            if (!((zzbhb) it2.next()).zzd()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final int zze() {
        return zzn(zza, 1, null, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final int zzf() {
        return this.zzh;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.libraries.places.internal.zzbhb] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.libraries.places.internal.zzbhb] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.libraries.places.internal.zzazv] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.libraries.places.internal.zzazv] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // com.google.android.libraries.places.internal.zzbhb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzbhb zzg(int i) {
        zzbhb zzbhbVarZzg;
        int i2;
        zzbhb zzbhbVarZzg2;
        ?? r1;
        ?? r0;
        if (i <= 0) {
            return zzbhe.zza();
        }
        zza(i);
        this.zzh -= i;
        ?? r2 = 0;
        ?? zzazvVar = 0;
        while (true) {
            zzbhb zzbhbVar = (zzbhb) this.zzf.peek();
            int iZzf = zzbhbVar.zzf();
            if (iZzf > i) {
                zzbhbVarZzg2 = zzbhbVar.zzg(i);
                i2 = 0;
            } else {
                if (this.zzi) {
                    zzbhbVarZzg = zzbhbVar.zzg(iZzf);
                    zzo();
                } else {
                    zzbhbVarZzg = (zzbhb) this.zzf.poll();
                }
                zzbhb zzbhbVar2 = zzbhbVarZzg;
                i2 = i - iZzf;
                zzbhbVarZzg2 = zzbhbVar2;
            }
            if (r2 == 0) {
                r0 = zzbhbVarZzg2;
            } else {
                if (zzazvVar == 0) {
                    zzazvVar = new zzazv(i2 != 0 ? Math.min(this.zzf.size() + 2, 16) : 2);
                    zzazvVar.zzh(r2);
                    r2 = zzazvVar;
                }
                zzazvVar.zzh(zzbhbVarZzg2);
                r0 = r2;
                r1 = zzazvVar;
            }
            if (i2 <= 0) {
                break;
            }
            r1 = zzazvVar;
            i = i2;
            r2 = r0;
            zzazvVar = r1;
        }
        return r0;
    }

    public final void zzh(zzbhb zzbhbVar) {
        boolean z = this.zzi && this.zzf.isEmpty();
        if (zzbhbVar instanceof zzazv) {
            zzazv zzazvVar = (zzazv) zzbhbVar;
            while (!zzazvVar.zzf.isEmpty()) {
                this.zzf.add((zzbhb) zzazvVar.zzf.remove());
            }
            this.zzh += zzazvVar.zzh;
            zzazvVar.zzh = 0;
            zzazvVar.close();
        } else {
            this.zzf.add(zzbhbVar);
            this.zzh += zzbhbVar.zzf();
        }
        if (z) {
            ((zzbhb) this.zzf.peek()).zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final void zzi(ByteBuffer byteBuffer) {
        zzn(zzd, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final void zzj(OutputStream outputStream, int i) throws IOException {
        zzm(zze, i, outputStream, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final void zzk(byte[] bArr, int i, int i2) {
        zzn(zzc, i2, bArr, i);
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final void zzl(int i) {
        zzn(zzb, i, null, 0);
    }

    public zzazv(int i) {
        this.zzf = new ArrayDeque(i);
    }

    @Override // com.google.android.libraries.places.internal.zzaxv, com.google.android.libraries.places.internal.zzbhb
    public final void zzb() {
        if (this.zzg == null) {
            this.zzg = new ArrayDeque(Math.min(this.zzf.size(), 16));
        }
        while (!this.zzg.isEmpty()) {
            ((zzbhb) this.zzg.remove()).close();
        }
        this.zzi = true;
        zzbhb zzbhbVar = (zzbhb) this.zzf.peek();
        if (zzbhbVar != null) {
            zzbhbVar.zzb();
        }
    }
}
