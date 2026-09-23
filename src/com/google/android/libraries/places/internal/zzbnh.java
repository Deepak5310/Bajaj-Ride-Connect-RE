package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbnh implements zzbmz {
    final zzbnc zza;
    private final zzbpn zzb;
    private final zzbnf zzc;

    zzbnh(zzbpn zzbpnVar, int i, boolean z) {
        this.zzb = zzbpnVar;
        zzbnf zzbnfVar = new zzbnf(zzbpnVar);
        this.zzc = zzbnfVar;
        this.zza = new zzbnc(4096, 4096, zzbnfVar);
    }

    private final List zzb(int i, short s, byte b, int i2) throws IOException {
        zzbnf zzbnfVar = this.zzc;
        zzbnfVar.zzd = i;
        zzbnfVar.zza = i;
        zzbnfVar.zze = s;
        zzbnfVar.zzb = b;
        zzbnfVar.zzc = i2;
        this.zza.zze();
        return this.zza.zzb();
    }

    private final void zzc(zzbmy zzbmyVar, int i) throws IOException {
        this.zzb.zze();
        this.zzb.zzc();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzb.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.places.internal.zzbmz
    public final boolean zza(zzbmy zzbmyVar) throws IOException {
        try {
            this.zzb.zzD(9L);
            int iZzb = zzbnj.zzb(this.zzb);
            if (iZzb > 16384) {
                throw zzbnj.zzi("FRAME_SIZE_ERROR: %s", Integer.valueOf(iZzb));
            }
            byte bZzc = (byte) (this.zzb.zzc() & 255);
            byte bZzc2 = (byte) (this.zzb.zzc() & 255);
            int iZze = this.zzb.zze() & Integer.MAX_VALUE;
            if (zzbnj.zza.isLoggable(Level.FINE)) {
                zzbnj.zza.logp(Level.FINE, "io.grpc.okhttp.internal.framed.Http2$Reader", "nextFrame", zzbng.zza(true, iZze, iZzb, bZzc, bZzc2));
            }
            switch (bZzc) {
                case 0:
                    boolean z = bZzc2 & 1;
                    if ((bZzc2 & 32) != 0) {
                        throw zzbnj.zzi("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                    }
                    int iZzc = (bZzc2 & 8) != 0 ? this.zzb.zzc() & 255 : 0;
                    zzbmyVar.zza(1 == z, iZze, this.zzb, zzbnj.zza(iZzb, bZzc2, (short) iZzc), iZzb);
                    this.zzb.zzF(iZzc);
                    return true;
                case 1:
                    if (iZze == 0) {
                        throw zzbnj.zzi("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                    }
                    boolean z2 = bZzc2 & 32;
                    boolean z3 = bZzc2 & 1;
                    int iZzc2 = (bZzc2 & 8) != 0 ? this.zzb.zzc() & 255 : 0;
                    if (z2 != 0) {
                        zzc(zzbmyVar, iZze);
                        iZzb -= 5;
                    }
                    short s = (short) iZzc2;
                    zzbmyVar.zzh(false, 1 == z3, iZze, -1, zzb(zzbnj.zza(iZzb, bZzc2, s), s, bZzc2, iZze), 4);
                    return true;
                case 2:
                    if (iZzb != 5) {
                        throw zzbnj.zzi("TYPE_PRIORITY length: %d != 5", Integer.valueOf(iZzb));
                    }
                    if (iZze == 0) {
                        throw zzbnj.zzi("TYPE_PRIORITY streamId == 0", new Object[0]);
                    }
                    zzc(zzbmyVar, iZze);
                    return true;
                case 3:
                    if (iZzb != 4) {
                        throw zzbnj.zzi("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(iZzb));
                    }
                    if (iZze == 0) {
                        throw zzbnj.zzi("TYPE_RST_STREAM streamId == 0", new Object[0]);
                    }
                    int iZze2 = this.zzb.zze();
                    zzbmx zzbmxVarZza = zzbmx.zza(iZze2);
                    if (zzbmxVarZza == null) {
                        throw zzbnj.zzi("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iZze2));
                    }
                    zzbmyVar.zze(iZze, zzbmxVarZza);
                    return true;
                case 4:
                    if (iZze != 0) {
                        throw zzbnj.zzi("TYPE_SETTINGS streamId != 0", new Object[0]);
                    }
                    if ((bZzc2 & 1) == 0) {
                        if (iZzb % 6 != 0) {
                            throw zzbnj.zzi("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(iZzb));
                        }
                        zzbnm zzbnmVar = new zzbnm();
                        for (int i = 0; i < iZzb; i += 6) {
                            zzbpn zzbpnVar = this.zzb;
                            zzbpv zzbpvVar = (zzbpv) zzbpnVar;
                            zzbpvVar.zzD(2L);
                            short sZzC = zzbpvVar.zzb.zzC();
                            int iZze3 = zzbpnVar.zze();
                            switch (sZzC) {
                                case 1:
                                case 6:
                                    break;
                                case 2:
                                    if (iZze3 != 0 && iZze3 != 1) {
                                        throw zzbnj.zzi("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                    }
                                    break;
                                case 3:
                                    sZzC = 4;
                                    break;
                                case 4:
                                    if (iZze3 < 0) {
                                        throw zzbnj.zzi("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    }
                                    sZzC = 7;
                                    break;
                                    break;
                                case 5:
                                    if (iZze3 < 16384 || iZze3 > 16777215) {
                                        throw zzbnj.zzi("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iZze3));
                                    }
                                    break;
                                default:
                                    continue;
                                    break;
                            }
                            zzbnmVar.zze(sZzC, 0, iZze3);
                        }
                        zzbmyVar.zzf(false, zzbnmVar);
                        if (zzbnmVar.zzb() >= 0) {
                            this.zza.zzd(zzbnmVar.zzb());
                        }
                    } else if (iZzb != 0) {
                        throw zzbnj.zzi("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    }
                    return true;
                case 5:
                    if (iZze == 0) {
                        throw zzbnj.zzi("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                    }
                    short sZzc = (short) ((bZzc2 & 8) != 0 ? this.zzb.zzc() & 255 : 0);
                    zzbmyVar.zzd(iZze, this.zzb.zze() & Integer.MAX_VALUE, zzb(zzbnj.zza(iZzb - 4, bZzc2, sZzc), sZzc, bZzc2, iZze));
                    return true;
                case 6:
                    if (iZzb != 8) {
                        throw zzbnj.zzi("TYPE_PING length != 8: %s", Integer.valueOf(iZzb));
                    }
                    if (iZze != 0) {
                        throw zzbnj.zzi("TYPE_PING streamId != 0", new Object[0]);
                    }
                    boolean z4 = 1 == (bZzc2 & 1);
                    zzbpn zzbpnVar2 = this.zzb;
                    zzbmyVar.zzc(z4, zzbpnVar2.zze(), zzbpnVar2.zze());
                    return true;
                case 7:
                    if (iZzb < 8) {
                        throw zzbnj.zzi("TYPE_GOAWAY length < 8: %s", Integer.valueOf(iZzb));
                    }
                    if (iZze != 0) {
                        throw zzbnj.zzi("TYPE_GOAWAY streamId != 0", new Object[0]);
                    }
                    zzbpn zzbpnVar3 = this.zzb;
                    int i2 = iZzb - 8;
                    int iZze4 = zzbpnVar3.zze();
                    int iZze5 = zzbpnVar3.zze();
                    zzbmx zzbmxVarZza2 = zzbmx.zza(iZze5);
                    if (zzbmxVarZza2 == null) {
                        throw zzbnj.zzi("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iZze5));
                    }
                    zzbpp zzbppVarZzy = zzbpp.zzb;
                    if (i2 > 0) {
                        zzbppVarZzy = this.zzb.zzy(i2);
                    }
                    zzbmyVar.zzb(iZze4, zzbmxVarZza2, zzbppVarZzy);
                    return true;
                case 8:
                    if (iZzb != 4) {
                        throw zzbnj.zzi("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(iZzb));
                    }
                    long jZze = ((long) this.zzb.zze()) & 2147483647L;
                    if (jZze == 0) {
                        throw zzbnj.zzi("windowSizeIncrement was 0", new Object[0]);
                    }
                    zzbmyVar.zzg(iZze, jZze);
                    return true;
                default:
                    this.zzb.zzF(iZzb);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }
}
