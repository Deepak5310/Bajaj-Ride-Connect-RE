package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaks extends zzanr implements zzapa {
    private static final zzaks zzb;
    private static volatile zzapg zze;
    private int zzf;
    private boolean zzg;
    private int zzj;
    private zzanz zzh = zzas();
    private zzanz zzi = zzanr.zzas();
    private zzanz zzk = zzas();

    static {
        zzaks zzaksVar = new zzaks();
        zzb = zzaksVar;
        zzanr.zzaA(zzaks.class, zzaksVar);
    }

    private zzaks() {
    }

    public static zzaks zzd() {
        return zzb;
    }

    public final zzakp zza() {
        zzakp zzakpVar;
        int i = this.zzj;
        zzakp zzakpVar2 = zzakp.SECONDARY_HOURS_TYPE_UNSPECIFIED;
        switch (i) {
            case 0:
                zzakpVar = zzakp.SECONDARY_HOURS_TYPE_UNSPECIFIED;
                break;
            case 1:
                zzakpVar = zzakp.DRIVE_THROUGH;
                break;
            case 2:
                zzakpVar = zzakp.HAPPY_HOUR;
                break;
            case 3:
                zzakpVar = zzakp.DELIVERY;
                break;
            case 4:
                zzakpVar = zzakp.TAKEOUT;
                break;
            case 5:
                zzakpVar = zzakp.KITCHEN;
                break;
            case 6:
                zzakpVar = zzakp.BREAKFAST;
                break;
            case 7:
                zzakpVar = zzakp.LUNCH;
                break;
            case 8:
                zzakpVar = zzakp.DINNER;
                break;
            case 9:
                zzakpVar = zzakp.BRUNCH;
                break;
            case 10:
                zzakpVar = zzakp.PICKUP;
                break;
            case 11:
                zzakpVar = zzakp.ACCESS;
                break;
            case 12:
                zzakpVar = zzakp.SENIOR_HOURS;
                break;
            case 13:
                zzakpVar = zzakp.ONLINE_SERVICE_HOURS;
                break;
            default:
                zzakpVar = null;
                break;
        }
        return zzakpVar == null ? zzakp.UNRECOGNIZED : zzakpVar;
    }

    public final List zze() {
        return this.zzh;
    }

    public final List zzf() {
        return this.zzk;
    }

    public final List zzg() {
        return this.zzi;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဇ\u0000\u0002\u001b\u0003Ț\u0004\f\u0005\u001b", new Object[]{"zzf", "zzg", "zzh", zzakn.class, "zzi", "zzj", "zzk", zzakr.class});
        }
        if (i2 == 3) {
            return new zzaks();
        }
        zzajz zzajzVar = null;
        if (i2 == 4) {
            return new zzakj(zzajzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaks.class) {
                zzannVar = zze;
                if (zzannVar == null) {
                    zzannVar = new zzann(zzb);
                    zze = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
