package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalb extends zzanr implements zzapa {
    private static final zzalb zzb;
    private static volatile zzapg zze;
    private int zzA;
    private int zzD;
    private int zzE;
    private int zzG;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private zzaks zzW;
    private zzarl zzZ;
    private boolean zzaa;
    private boolean zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private boolean zzag;
    private boolean zzah;
    private boolean zzai;
    private boolean zzaj;
    private boolean zzak;
    private boolean zzal;
    private zzakw zzam;
    private zzaku zzan;
    private zzakb zzap;
    private boolean zzaq;
    private boolean zzar;
    private boolean zzas;
    private boolean zzat;
    private boolean zzau;
    private zzajs zzav;
    private zzajn zzaw;
    private int zzf;
    private int zzg;
    private zzarl zzj;
    private zzarl zzm;
    private zzaky zzs;
    private zzari zzt;
    private zzahw zzu;
    private double zzv;
    private zzaks zzz;
    private String zzh = "";
    private String zzi = "";
    private zzanz zzk = zzanr.zzas();
    private String zzl = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private zzanz zzr = zzas();
    private String zzw = "";
    private String zzx = "";
    private zzanz zzy = zzas();
    private zzanz zzB = zzas();
    private String zzC = "";
    private zzanz zzF = zzas();
    private String zzH = "";
    private String zzI = "";
    private zzanz zzX = zzas();
    private zzanz zzY = zzas();
    private zzanz zzao = zzas();

    static {
        zzalb zzalbVar = new zzalb();
        zzb = zzalbVar;
        zzanr.zzaA(zzalb.class, zzalbVar);
    }

    private zzalb() {
    }

    public static zzalb zzl() {
        return zzb;
    }

    public final List zzA() {
        return this.zzk;
    }

    public final boolean zzB() {
        return this.zzM;
    }

    public final boolean zzC() {
        return this.zzK;
    }

    public final boolean zzD() {
        return this.zzL;
    }

    public final boolean zzE() {
        return this.zzO;
    }

    public final boolean zzF() {
        return this.zzS;
    }

    public final boolean zzG() {
        return this.zzP;
    }

    public final boolean zzH() {
        return this.zzR;
    }

    public final boolean zzI() {
        return this.zzQ;
    }

    public final boolean zzJ() {
        return this.zzV;
    }

    public final boolean zzK() {
        return this.zzT;
    }

    public final boolean zzL() {
        return this.zzJ;
    }

    public final boolean zzM() {
        return (this.zzf & 2048) != 0;
    }

    public final boolean zzN() {
        return (this.zzf & 2097152) != 0;
    }

    public final boolean zzO() {
        return (this.zzf & 512) != 0;
    }

    public final boolean zzP() {
        return (this.zzf & 1024) != 0;
    }

    public final boolean zzQ() {
        return (this.zzf & 1) != 0;
    }

    public final boolean zzR() {
        return (this.zzf & 4194304) != 0;
    }

    public final boolean zzS() {
        return (this.zzf & 8) != 0;
    }

    public final boolean zzT() {
        return (this.zzf & 4) != 0;
    }

    public final boolean zzU() {
        return (this.zzf & 32) != 0;
    }

    public final boolean zzV() {
        return (this.zzf & 8192) != 0;
    }

    public final boolean zzW() {
        return (this.zzf & 131072) != 0;
    }

    public final boolean zzX() {
        return (this.zzf & 16384) != 0;
    }

    public final boolean zzY() {
        return (this.zzf & 65536) != 0;
    }

    public final boolean zzZ() {
        return (this.zzf & 32768) != 0;
    }

    public final double zza() {
        return this.zzv;
    }

    public final boolean zzaa() {
        return (this.zzf & 1048576) != 0;
    }

    public final boolean zzab() {
        return (this.zzf & 262144) != 0;
    }

    public final boolean zzac() {
        return (this.zzf & 256) != 0;
    }

    public final boolean zzad() {
        return (this.zzf & 128) != 0;
    }

    public final boolean zzae() {
        return (this.zzf & 64) != 0;
    }

    public final boolean zzaf() {
        return (this.zzf & 16) != 0;
    }

    public final int zzc() {
        return this.zzG;
    }

    public final int zzd() {
        return this.zzA;
    }

    public final zzahw zze() {
        zzahw zzahwVar = this.zzu;
        return zzahwVar == null ? zzahw.zzd() : zzahwVar;
    }

    public final zzakb zzf() {
        zzakb zzakbVar = this.zzap;
        return zzakbVar == null ? zzakb.zzc() : zzakbVar;
    }

    public final zzaki zzg() {
        zzaki zzakiVar;
        int i = this.zzD;
        zzaki zzakiVar2 = zzaki.BUSINESS_STATUS_UNSPECIFIED;
        if (i == 0) {
            zzakiVar = zzaki.BUSINESS_STATUS_UNSPECIFIED;
        } else if (i == 1) {
            zzakiVar = zzaki.OPERATIONAL;
        } else if (i == 2) {
            zzakiVar = zzaki.CLOSED_TEMPORARILY;
        } else if (i != 3) {
            zzakiVar = i != 4 ? null : zzaki.FUTURE_OPENING;
        } else {
            zzakiVar = zzaki.CLOSED_PERMANENTLY;
        }
        return zzakiVar == null ? zzaki.UNRECOGNIZED : zzakiVar;
    }

    public final zzaks zzh() {
        zzaks zzaksVar = this.zzW;
        return zzaksVar == null ? zzaks.zzd() : zzaksVar;
    }

    public final zzaks zzi() {
        zzaks zzaksVar = this.zzz;
        return zzaksVar == null ? zzaks.zzd() : zzaksVar;
    }

    public final zzaky zzj() {
        zzaky zzakyVar = this.zzs;
        return zzakyVar == null ? zzaky.zzc() : zzakyVar;
    }

    public final zzalh zzm() {
        zzalh zzalhVar;
        int i = this.zzE;
        zzalh zzalhVar2 = zzalh.PRICE_LEVEL_UNSPECIFIED;
        if (i == 0) {
            zzalhVar = zzalh.PRICE_LEVEL_UNSPECIFIED;
        } else if (i == 1) {
            zzalhVar = zzalh.PRICE_LEVEL_FREE;
        } else if (i == 2) {
            zzalhVar = zzalh.PRICE_LEVEL_INEXPENSIVE;
        } else if (i == 3) {
            zzalhVar = zzalh.PRICE_LEVEL_MODERATE;
        } else if (i != 4) {
            zzalhVar = i != 5 ? null : zzalh.PRICE_LEVEL_VERY_EXPENSIVE;
        } else {
            zzalhVar = zzalh.PRICE_LEVEL_EXPENSIVE;
        }
        return zzalhVar == null ? zzalh.UNRECOGNIZED : zzalhVar;
    }

    public final zzari zzn() {
        zzari zzariVar = this.zzt;
        return zzariVar == null ? zzari.zzf() : zzariVar;
    }

    public final zzarl zzo() {
        zzarl zzarlVar = this.zzj;
        return zzarlVar == null ? zzarl.zzc() : zzarlVar;
    }

    public final zzarl zzp() {
        zzarl zzarlVar = this.zzZ;
        return zzarlVar == null ? zzarl.zzc() : zzarlVar;
    }

    public final String zzq() {
        return this.zzp;
    }

    public final String zzr() {
        return this.zzI;
    }

    public final String zzs() {
        return this.zzH;
    }

    public final String zzt() {
        return this.zzi;
    }

    public final String zzu() {
        return this.zzo;
    }

    public final String zzv() {
        return this.zzx;
    }

    public final List zzw() {
        return this.zzr;
    }

    public final List zzx() {
        return this.zzB;
    }

    public final List zzy() {
        return this.zzY;
    }

    public final List zzz() {
        return this.zzy;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0000D\u0000\u0002\u0001OD\u0000\b\u0000\u0001Ȉ\u0002Ȉ\u0005Ț\u0007Ȉ\bȈ\tȈ\n\u001b\u000bဉ\u0002\fဉ\u0003\rဉ\u0004\u000e\u0000\u000fȈ\u0010Ȉ\u0015ဉ\u0005\u0016င\u0006\u0018Ȉ\u0019\f\u001a\f\u001b\u001b\u001cင\u0007\u001dȈ\u001eȈ\u001fဉ\u0000 ဉ\u0001!ဇ\b\"ဇ\t#ဇ\n$ဇ\u000b%ဇ\f&ဇ\r'ဇ\u000e(ဇ\u000f)ဇ\u0010*ဇ\u0011+ဇ\u0012,ဇ\u0013-ဇ\u0014.ဉ\u0015/\u001b1\u001b2Ȉ3Ȉ4ဉ\u00165\u001b6\u001b7ဇ\u00178ဇ\u00189ဇ\u0019:ဇ\u001a;ဇ\u001b<ဇ\u001c=ဇ\u001d>ဇ\u001e?ဇ\u001f@ဇ Aဇ!Bဇ\"Cဉ#Fဉ$G\u001bHဉ%Iဇ&Jဇ'Kဇ(Lဇ)Mဇ*Nဉ+Oဉ,", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzk", "zzn", "zzo", "zzp", "zzr", zzakd.class, "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzz", "zzA", "zzC", "zzD", "zzE", "zzF", zzakf.class, "zzG", "zzH", "zzI", "zzj", "zzm", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", zzaks.class, "zzY", zzaks.class, "zzl", "zzq", "zzZ", "zzy", zzalk.class, "zzB", zzajy.class, "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", zzala.class, "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw"});
        }
        if (i2 == 3) {
            return new zzalb();
        }
        zzajz zzajzVar = null;
        if (i2 == 4) {
            return new zzakg(zzajzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzalb.class) {
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
