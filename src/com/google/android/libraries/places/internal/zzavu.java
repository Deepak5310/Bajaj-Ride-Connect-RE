package com.google.android.libraries.places.internal;

import io.grpc.Metadata;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavu {
    private Object[] zze;
    private int zzf;
    private static final Logger zzd = Logger.getLogger(zzavu.class.getName());
    public static final zzavn zza = new zzavi();
    public static final zzavm zzb = new zzavj();
    static final zzqi zzc = zzqi.zzj().zzf();

    public zzavu() {
    }

    zzavu(int i, Object[] objArr) {
        this.zzf = i;
        this.zze = objArr;
    }

    private final int zzh() {
        Object[] objArr = this.zze;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private final Object zzi(int i) {
        return this.zze[i + i + 1];
    }

    private final void zzj(int i) {
        Object[] objArr = new Object[i];
        if (!zzk()) {
            Object[] objArr2 = this.zze;
            int i2 = this.zzf;
            System.arraycopy(objArr2, 0, objArr, 0, i2 + i2);
        }
        this.zze = objArr;
    }

    private final boolean zzk() {
        return this.zzf == 0;
    }

    private final byte[] zzl(int i) {
        return (byte[]) this.zze[i + i];
    }

    private final byte[] zzm(int i) {
        Object objZzi = zzi(i);
        if (objZzi instanceof byte[]) {
            return (byte[]) objZzi;
        }
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i = 0; i < this.zzf; i++) {
            if (i != 0) {
                sb.append(',');
            }
            String str = new String(zzl(i), zzkc.zza);
            sb.append(str);
            sb.append('=');
            if (str.endsWith(Metadata.BINARY_HEADER_SUFFIX)) {
                zzqi zzqiVar = zzc;
                byte[] bArrZzm = zzm(i);
                sb.append(zzqiVar.zzk(bArrZzm, 0, bArrZzm.length));
            } else {
                sb.append(new String(zzm(i), zzkc.zza));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    final int zza() {
        return this.zzf;
    }

    @Nullable
    public final Object zzb(zzavp zzavpVar) {
        int i = this.zzf;
        do {
            i--;
            if (i < 0) {
                return null;
            }
        } while (!Arrays.equals(zzavpVar.zze(), zzl(i)));
        Object objZzi = zzi(i);
        if (objZzi instanceof byte[]) {
            return zzavpVar.zza((byte[]) objZzi);
        }
        throw null;
    }

    public final void zzd(zzavp zzavpVar) {
        if (zzk()) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.zzf;
            if (i >= i3) {
                Arrays.fill(this.zze, i2 + i2, i3 + i3, (Object) null);
                this.zzf = i2;
                return;
            }
            if (!Arrays.equals(zzavpVar.zze(), zzl(i))) {
                int i4 = i2 + i2;
                this.zze[i4] = zzl(i);
                Object objZzi = zzi(i);
                if (this.zze instanceof byte[][]) {
                    zzj(zzh());
                }
                this.zze[i4 + 1] = objZzi;
                i2++;
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    public final void zze(zzavu zzavuVar) {
        if (zzavuVar.zzk()) {
            return;
        }
        int iZzh = zzh();
        int i = this.zzf;
        int i2 = i + i;
        int i3 = iZzh - i2;
        if (zzk()) {
            int i4 = zzavuVar.zzf;
            zzj(i2 + i4 + i4);
        } else {
            int i5 = zzavuVar.zzf;
            if (i3 < i5 + i5) {
                int i6 = zzavuVar.zzf;
                zzj(i2 + i6 + i6);
            }
        }
        Object[] objArr = zzavuVar.zze;
        Object[] objArr2 = this.zze;
        int i7 = this.zzf;
        int i8 = zzavuVar.zzf;
        System.arraycopy(objArr, 0, objArr2, i7 + i7, i8 + i8);
        this.zzf += zzavuVar.zzf;
    }

    public final void zzf(zzavp zzavpVar, Object obj) {
        zzkt.zzc(zzavpVar, "key");
        zzkt.zzc(obj, "value");
        int i = this.zzf;
        int i2 = i + i;
        if (i2 == 0 || i2 == zzh()) {
            zzj(Math.max(i2 + i2, 8));
        }
        int i3 = this.zzf;
        this.zze[i3 + i3] = zzavpVar.zze();
        int i4 = this.zzf;
        this.zze[i4 + i4 + 1] = zzavpVar.zzb(obj);
        this.zzf++;
    }

    @Nullable
    final byte[][] zzg() {
        int i = this.zzf;
        int i2 = i + i;
        byte[][] bArr = new byte[i2][];
        Object[] objArr = this.zze;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, i2);
        } else {
            for (int i3 = 0; i3 < this.zzf; i3++) {
                int i4 = i3 + i3;
                bArr[i4] = zzl(i3);
                bArr[i4 + 1] = zzm(i3);
            }
        }
        return bArr;
    }
}
