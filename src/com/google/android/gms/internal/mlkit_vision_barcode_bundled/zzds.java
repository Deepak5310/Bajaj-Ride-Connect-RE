package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzds {
    private static final zzds zzb = new zzds(true);
    final zzgl zza = new zzge(16);
    private boolean zzc;
    private boolean zzd;

    private zzds() {
    }

    public static int zza(zzdr zzdrVar, Object obj) {
        zzhf zzhfVarZzd = zzdrVar.zzd();
        int iZza = zzdrVar.zza();
        zzdrVar.zzg();
        int iZzC = zzdi.zzC(iZza);
        if (zzhfVarZzd == zzhf.GROUP) {
            zzel.zzi((zzfl) obj);
            iZzC += iZzC;
        }
        zzhg zzhgVar = zzhg.INT;
        int iZzE = 4;
        switch (zzhfVarZzd) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                iZzE = 8;
                return iZzC + iZzE;
            case FLOAT:
                ((Float) obj).floatValue();
                return iZzC + iZzE;
            case INT64:
                iZzE = zzdi.zzE(((Long) obj).longValue());
                return iZzC + iZzE;
            case UINT64:
                iZzE = zzdi.zzE(((Long) obj).longValue());
                return iZzC + iZzE;
            case INT32:
                iZzE = zzdi.zzx(((Integer) obj).intValue());
                return iZzC + iZzE;
            case FIXED64:
                ((Long) obj).longValue();
                iZzE = 8;
                return iZzC + iZzE;
            case FIXED32:
                ((Integer) obj).intValue();
                return iZzC + iZzE;
            case BOOL:
                ((Boolean) obj).booleanValue();
                iZzE = 1;
                return iZzC + iZzE;
            case STRING:
                iZzE = obj instanceof zzdb ? zzdi.zzu((zzdb) obj) : zzdi.zzB((String) obj);
                return iZzC + iZzE;
            case GROUP:
                iZzE = zzdi.zzw((zzfl) obj);
                return iZzC + iZzE;
            case MESSAGE:
                iZzE = obj instanceof zzes ? zzdi.zzy((zzes) obj) : zzdi.zzz((zzfl) obj);
                return iZzC + iZzE;
            case BYTES:
                iZzE = obj instanceof zzdb ? zzdi.zzu((zzdb) obj) : zzdi.zzt((byte[]) obj);
                return iZzC + iZzE;
            case UINT32:
                iZzE = zzdi.zzD(((Integer) obj).intValue());
                return iZzC + iZzE;
            case ENUM:
                iZzE = obj instanceof zzee ? zzdi.zzx(((zzee) obj).zza()) : zzdi.zzx(((Integer) obj).intValue());
                return iZzC + iZzE;
            case SFIXED32:
                ((Integer) obj).intValue();
                return iZzC + iZzE;
            case SFIXED64:
                ((Long) obj).longValue();
                iZzE = 8;
                return iZzC + iZzE;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                iZzE = zzdi.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iZzC + iZzE;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                iZzE = zzdi.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iZzC + iZzE;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static zzds zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzfq) {
            return ((zzfq) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry entry) {
        zzfl zzflVarZzl;
        zzdr zzdrVar = (zzdr) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzes) {
            throw null;
        }
        zzdrVar.zzg();
        if (zzdrVar.zze() != zzhg.MESSAGE) {
            this.zza.put(zzdrVar, zzl(value));
            return;
        }
        Object objZze = zze(zzdrVar);
        if (objZze == null) {
            this.zza.put(zzdrVar, zzl(value));
            return;
        }
        if (objZze instanceof zzfq) {
            zzflVarZzl = zzdrVar.zzc((zzfq) objZze, (zzfq) value);
        } else {
            zzfk zzfkVarZzV = ((zzfl) objZze).zzV();
            zzdrVar.zzb(zzfkVarZzV, (zzfl) value);
            zzflVarZzl = zzfkVarZzV.zzl();
        }
        this.zza.put(zzdrVar, zzflVarZzl);
    }

    private static boolean zzn(Map.Entry entry) {
        zzdr zzdrVar = (zzdr) entry.getKey();
        if (zzdrVar.zze() != zzhg.MESSAGE) {
            return true;
        }
        zzdrVar.zzg();
        Object value = entry.getValue();
        if (value instanceof zzfm) {
            return ((zzfm) value).zzY();
        }
        if (value instanceof zzes) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int iZzD;
        int iZzD2;
        zzdr zzdrVar = (zzdr) entry.getKey();
        Object value = entry.getValue();
        if (zzdrVar.zze() != zzhg.MESSAGE) {
            return zza(zzdrVar, value);
        }
        zzdrVar.zzg();
        zzdrVar.zzf();
        if (value instanceof zzes) {
            int iZza = ((zzdr) entry.getKey()).zza();
            int iZzD3 = zzdi.zzD(8);
            int iZza2 = ((zzes) value).zza();
            iZzD = iZzD3 + iZzD3 + zzdi.zzD(16) + zzdi.zzD(iZza);
            iZzD2 = zzdi.zzD(24) + zzdi.zzD(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzdr) entry.getKey()).zza();
            int iZzD4 = zzdi.zzD(8);
            iZzD = iZzD4 + iZzD4 + zzdi.zzD(16) + zzdi.zzD(iZza3);
            iZzD2 = zzdi.zzD(24) + zzdi.zzz((zzfl) value);
        }
        return iZzD + iZzD2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzds) {
            return this.zza.equals(((zzds) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int iZzo = 0;
        for (int i = 0; i < this.zza.zzb(); i++) {
            iZzo += zzo(this.zza.zzg(i));
        }
        Iterator it2 = this.zza.zzc().iterator();
        while (it2.hasNext()) {
            iZzo += zzo((Map.Entry) it2.next());
        }
        return iZzo;
    }

    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzds clone() {
        zzds zzdsVar = new zzds();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzdsVar.zzi((zzdr) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzdsVar.zzi((zzdr) entry.getKey(), entry.getValue());
        }
        zzdsVar.zzd = this.zzd;
        return zzdsVar;
    }

    public final Object zze(zzdr zzdrVar) {
        Object obj = this.zza.get(zzdrVar);
        if (!(obj instanceof zzes)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzer(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzds zzdsVar) {
        for (int i = 0; i < zzdsVar.zza.zzb(); i++) {
            zzm(zzdsVar.zza.zzg(i));
        }
        Iterator it2 = zzdsVar.zza.zzc().iterator();
        while (it2.hasNext()) {
            zzm((Map.Entry) it2.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004c  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzee) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
    
        if (r0 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzes) == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(zzdr zzdrVar, Object obj) {
        boolean z;
        zzdrVar.zzg();
        zzdrVar.zzd();
        zzel.zze(obj);
        zzhf zzhfVar = zzhf.DOUBLE;
        zzhg zzhgVar = zzhg.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof zzdb)) {
                    break;
                }
                if (obj instanceof zzes) {
                    this.zzd = true;
                }
                this.zza.put(zzdrVar, obj);
                return;
            case ENUM:
                if (!(obj instanceof Integer)) {
                    break;
                }
                if (obj instanceof zzes) {
                    this.zzd = true;
                }
                this.zza.put(zzdrVar, obj);
                return;
            case MESSAGE:
                if (!(obj instanceof zzfl)) {
                    break;
                }
                if (obj instanceof zzes) {
                    this.zzd = true;
                }
                this.zza.put(zzdrVar, obj);
                return;
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzdrVar.zza()), zzdrVar.zzd().zza(), obj.getClass().getName()));
        }
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzn(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it2 = this.zza.zzc().iterator();
        while (it2.hasNext()) {
            if (!zzn((Map.Entry) it2.next())) {
                return false;
            }
        }
        return true;
    }

    private zzds(boolean z) {
        zzg();
        zzg();
    }
}
