package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzra;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.maps.android.BuildConfig;
import com.spotify.android.appremote.internal.SdkRemoteClientConnector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import kotlin.time.DurationKt;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTimeConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpv implements zzjs {
    private static volatile zzpv zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzmh zzG;
    private String zzH;
    private zzaz zzI;
    private long zzJ;
    long zza;
    private final zzif zzc;
    private final zzhk zzd;
    private zzaw zze;
    private zzhm zzf;
    private zzoy zzg;
    private zzae zzh;
    private final zzqa zzi;
    private zzmc zzj;
    private zzoa zzk;
    private final zzpi zzl;
    private zzhw zzm;
    private final zzio zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzqe zzK = new zzpq(this);

    zzpv(zzpw zzpwVar, zzio zzioVar) {
        Preconditions.checkNotNull(zzpwVar);
        this.zzn = zzio.zzp(zzpwVar.zza, null, null);
        this.zzB = -1L;
        this.zzl = new zzpi(this);
        zzqa zzqaVar = new zzqa(this);
        zzqaVar.zzaw();
        this.zzi = zzqaVar;
        zzhk zzhkVar = new zzhk(this);
        zzhkVar.zzaw();
        this.zzd = zzhkVar;
        zzif zzifVar = new zzif(this);
        zzifVar.zzaw();
        this.zzc = zzifVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaX().zzq(new zzpk(this, zzpwVar));
    }

    static /* bridge */ /* synthetic */ void zzH(zzpv zzpvVar, zzpw zzpwVar) {
        zzpvVar.zzaX().zzg();
        zzpvVar.zzm = new zzhw(zzpvVar);
        zzaw zzawVar = new zzaw(zzpvVar);
        zzawVar.zzaw();
        zzpvVar.zze = zzawVar;
        zzpvVar.zzi().zzu((zzal) Preconditions.checkNotNull(zzpvVar.zzc));
        zzoa zzoaVar = new zzoa(zzpvVar);
        zzoaVar.zzaw();
        zzpvVar.zzk = zzoaVar;
        zzae zzaeVar = new zzae(zzpvVar);
        zzaeVar.zzaw();
        zzpvVar.zzh = zzaeVar;
        zzmc zzmcVar = new zzmc(zzpvVar);
        zzmcVar.zzaw();
        zzpvVar.zzj = zzmcVar;
        zzoy zzoyVar = new zzoy(zzpvVar);
        zzoyVar.zzaw();
        zzpvVar.zzg = zzoyVar;
        zzpvVar.zzf = new zzhm(zzpvVar);
        if (zzpvVar.zzs != zzpvVar.zzt) {
            zzpvVar.zzaW().zze().zzc("Not all upload components initialized", Integer.valueOf(zzpvVar.zzs), Integer.valueOf(zzpvVar.zzt));
        }
        zzpvVar.zzo.set(true);
        zzpvVar.zzaW().zzj().zza("UploadController is now fully initialized");
    }

    static final void zzaA(com.google.android.gms.internal.measurement.zzhl zzhlVar, int i, String str) {
        List listZzp = zzhlVar.zzp();
        for (int i2 = 0; i2 < listZzp.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhq) listZzp.get(i2)).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhp zzhpVarZze = com.google.android.gms.internal.measurement.zzhq.zze();
        zzhpVarZze.zzj("_err");
        long j = i;
        Long.valueOf(j).getClass();
        zzhpVarZze.zzi(j);
        com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) zzhpVarZze.zzba();
        com.google.android.gms.internal.measurement.zzhp zzhpVarZze2 = com.google.android.gms.internal.measurement.zzhq.zze();
        zzhpVarZze2.zzj("_ev");
        zzhpVarZze2.zzk(str);
        com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) zzhpVarZze2.zzba();
        zzhlVar.zzf(zzhqVar);
        zzhlVar.zzf(zzhqVar2);
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhl zzhlVar, String str) {
        List listZzp = zzhlVar.zzp();
        for (int i = 0; i < listZzp.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhq) listZzp.get(i)).zzg())) {
                zzhlVar.zzh(i);
                return;
            }
        }
    }

    private final int zzaC(String str, zzao zzaoVar) {
        zzju zzjuVarZzf;
        zzif zzifVar = this.zzc;
        if (zzifVar.zzi(str) == null) {
            zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.FAILSAFE);
            return 1;
        }
        zzh zzhVarZzl = zzj().zzl(str);
        if (zzhVarZzl == null || zze.zza(zzhVarZzl.zzK()).zzb() != zzju.POLICY || (zzjuVarZzf = zzifVar.zzf(str, zzjw.AD_PERSONALIZATION)) == zzju.UNINITIALIZED) {
            zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.REMOTE_DEFAULT);
            return zzifVar.zzu(str, zzjw.AD_PERSONALIZATION) ? 0 : 1;
        }
        zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.REMOTE_ENFORCED_DEFAULT);
        return zzjuVarZzf == zzju.GRANTED ? 0 : 1;
    }

    private final zzr zzaD(String str) {
        zzh zzhVarZzl = zzj().zzl(str);
        if (zzhVarZzl == null || TextUtils.isEmpty(zzhVarZzl.zzF())) {
            zzaW().zzd().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzaF = zzaF(zzhVarZzl);
        if (boolZzaF == null || boolZzaF.booleanValue()) {
            return new zzr(str, zzhVarZzl.zzH(), zzhVarZzl.zzF(), zzhVarZzl.zze(), zzhVarZzl.zzE(), zzhVarZzl.zzq(), zzhVarZzl.zzn(), (String) null, zzhVarZzl.zzaJ(), false, zzhVarZzl.zzG(), 0L, 0, zzhVarZzl.zzaI(), false, zzhVarZzl.zzA(), zzhVarZzl.zzx(), zzhVarZzl.zzo(), zzhVarZzl.zzN(), (String) null, zzu(str).zzq(), "", (String) null, zzhVarZzl.zzaL(), zzhVarZzl.zzw(), zzu(str).zzb(), zzm(str).zzj(), zzhVarZzl.zza(), zzhVarZzl.zzf(), zzhVarZzl.zzM(), zzhVarZzl.zzK(), 0L, zzhVarZzl.zzb());
        }
        zzaW().zze().zzb("App version does not match; dropping. appId", zzhe.zzn(str));
        return null;
    }

    private final zzaz zzaE() {
        if (this.zzI == null) {
            this.zzI = new zzpn(this, this.zzn);
        }
        return this.zzI;
    }

    private final Boolean zzaF(zzh zzhVar) {
        try {
            if (zzhVar.zze() != -2147483648L) {
                if (zzhVar.zze() == Wrappers.packageManager(this.zzn.zzaT()).getPackageInfo(zzhVar.zzC(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzaT()).getPackageInfo(zzhVar.zzC(), 0).versionName;
                String strZzF = zzhVar.zzF();
                if (strZzF != null && strZzF.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static String zzaG(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    private final void zzaH() {
        zzaX().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaW().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaW().zzj().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final void zzaI(com.google.android.gms.internal.measurement.zzhw zzhwVar, long j, boolean z) {
        Object obj;
        String str = true != z ? "_lte" : "_se";
        zzqd zzqdVarZzy = zzj().zzy(zzhwVar.zzaF(), str);
        zzqd zzqdVar = (zzqdVarZzy == null || (obj = zzqdVarZzy.zze) == null) ? new zzqd(zzhwVar.zzaF(), "auto", str, zzaU().currentTimeMillis(), Long.valueOf(j)) : new zzqd(zzhwVar.zzaF(), "auto", str, zzaU().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        com.google.android.gms.internal.measurement.zzin zzinVarZze = com.google.android.gms.internal.measurement.zzio.zze();
        zzinVarZze.zzf(str);
        zzinVarZze.zzg(zzaU().currentTimeMillis());
        Object obj2 = zzqdVar.zze;
        zzinVarZze.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zzio zzioVar = (com.google.android.gms.internal.measurement.zzio) zzinVarZze.zzba();
        int iZza = zzqa.zza(zzhwVar, str);
        if (iZza >= 0) {
            zzhwVar.zzaC(iZza, zzioVar);
        } else {
            zzhwVar.zzp(zzioVar);
        }
        if (j > 0) {
            zzj().zzai(zzqdVar);
            zzaW().zzj().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ() {
        zzaX().zzg();
        if (this.zzr.isEmpty() || zzaE().zze()) {
            return;
        }
        long jMax = Math.max(0L, ((long) ((Integer) zzgi.zzaA.zza(null)).intValue()) - (zzaU().elapsedRealtime() - this.zzJ));
        zzaW().zzj().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(jMax));
        zzaE().zzd(jMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaK(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private final void zzaL() {
        long jMax;
        long jMax2;
        zzaX().zzg();
        zzM();
        if (this.zza > 0) {
            long jAbs = DateUtils.MILLIS_PER_HOUR - Math.abs(zzaU().elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzaW().zzj().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzq().zzc();
                zzx().zza();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzM() || !zzaN()) {
            zzaW().zzj().zza("Nothing to upload or uploading impossible");
            zzq().zzc();
            zzx().zza();
            return;
        }
        long jCurrentTimeMillis = zzaU().currentTimeMillis();
        zzi();
        long jMax3 = Math.max(0L, ((Long) zzgi.zzN.zza(null)).longValue());
        boolean z = true;
        if (!zzj().zzac() && !zzj().zzab()) {
            z = false;
        }
        if (z) {
            String strZzo = zzi().zzo();
            if (TextUtils.isEmpty(strZzo) || ".none.".equals(strZzo)) {
                zzi();
                jMax = Math.max(0L, ((Long) zzgi.zzH.zza(null)).longValue());
            } else {
                zzi();
                jMax = Math.max(0L, ((Long) zzgi.zzI.zza(null)).longValue());
            }
        } else {
            zzi();
            jMax = Math.max(0L, ((Long) zzgi.zzG.zza(null)).longValue());
        }
        long jZza = this.zzk.zzd.zza();
        long jZza2 = this.zzk.zze.zza();
        boolean z2 = z;
        long jMax4 = Math.max(zzj().zzf(), zzj().zzh());
        if (jMax4 != 0) {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            jMax2 = jAbs2 + jMax3;
            long jMax5 = Math.max(jAbs3, jAbs4);
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            if (!zzA().zzz(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    zzi();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzgi.zzP.zza(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    zzi();
                    jMax2 += Math.max(0L, ((Long) zzgi.zzO.zza(null)).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } else {
            jMax2 = 0;
            break;
        }
        if (jMax2 == 0) {
            zzaW().zzj().zza("Next upload time is 0");
            zzq().zzc();
            zzx().zza();
            return;
        }
        if (!zzp().zzd()) {
            zzaW().zzj().zza("No network");
            zzq().zzb();
            zzx().zza();
            return;
        }
        long jZza3 = this.zzk.zzc.zza();
        zzi();
        long jMax6 = Math.max(0L, ((Long) zzgi.zzE.zza(null)).longValue());
        if (!zzA().zzz(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzq().zzc();
        long jCurrentTimeMillis2 = jMax2 - zzaU().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzi();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzgi.zzJ.zza(null)).longValue());
            this.zzk.zzd.zzb(zzaU().currentTimeMillis());
        }
        zzaW().zzj().zzb("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzx().zzd(jCurrentTimeMillis2);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x03bf A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x03d7 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x03f0 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0406 A[Catch: all -> 0x0e85, TRY_ENTER, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0416  */
    /* JADX WARN: Code duplicated, block: B:124:0x0418 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0428  */
    /* JADX WARN: Code duplicated, block: B:130:0x042f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0431 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0465  */
    /* JADX WARN: Code duplicated, block: B:139:0x0466 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0477  */
    /* JADX WARN: Code duplicated, block: B:144:0x047e A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0488 A[Catch: all -> 0x0e85, LOOP:10: B:142:0x0478->B:146:0x0488, LOOP_END, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:151:0x04b4 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:158:0x04e2 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:162:0x04ff A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x050f A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x0520  */
    /* JADX WARN: Code duplicated, block: B:171:0x053f A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x054f A[PHI: r4 r9
      0x054f: PHI (r4v35 com.google.android.gms.internal.measurement.zzhw) = 
      (r4v33 com.google.android.gms.internal.measurement.zzhw)
      (r4v33 com.google.android.gms.internal.measurement.zzhw)
      (r4v38 com.google.android.gms.internal.measurement.zzhw)
     binds: [B:163:0x050d, B:165:0x051e, B:161:0x04fa] A[DONT_GENERATE, DONT_INLINE]
      0x054f: PHI (r9v41 int) = (r9v40 int), (r9v40 int), (r9v56 int) binds: [B:163:0x050d, B:165:0x051e, B:161:0x04fa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:177:0x055b A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x056d A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x05f0 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x05fe A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x063c A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0666 A[Catch: all -> 0x0e85, LOOP:9: B:204:0x0660->B:206:0x0666, LOOP_END, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0670  */
    /* JADX WARN: Code duplicated, block: B:217:0x06c3 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:219:0x06cc A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:221:0x06d2 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:5:0x0027, B:8:0x002f, B:9:0x0043, B:12:0x0059, B:15:0x007f, B:17:0x00b4, B:20:0x00c5, B:22:0x00cf, B:209:0x068c, B:24:0x00ff, B:26:0x0111, B:29:0x0121, B:31:0x0127, B:45:0x0165, B:47:0x0173, B:50:0x0193, B:52:0x0199, B:54:0x01a9, B:56:0x01b7, B:58:0x01c7, B:59:0x01d4, B:60:0x01d7, B:63:0x01ed, B:73:0x0220, B:76:0x022a, B:78:0x0238, B:83:0x0286, B:79:0x0256, B:81:0x0264, B:87:0x0297, B:89:0x02c3, B:90:0x02ed, B:92:0x0324, B:94:0x032b, B:97:0x0337, B:99:0x036e, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:108:0x03b1, B:105:0x03a6, B:111:0x03b8, B:114:0x03bf, B:115:0x03d7, B:117:0x03f0, B:118:0x03fc, B:121:0x0406, B:127:0x0429, B:124:0x0418, B:149:0x04a8, B:151:0x04b4, B:154:0x04c5, B:156:0x04d6, B:158:0x04e2, B:175:0x0555, B:177:0x055b, B:178:0x0567, B:180:0x056d, B:182:0x057d, B:184:0x0587, B:185:0x059a, B:187:0x05a0, B:188:0x05bb, B:190:0x05c1, B:191:0x05df, B:192:0x05ea, B:196:0x0611, B:193:0x05f0, B:195:0x05fe, B:197:0x061c, B:198:0x0636, B:200:0x063c, B:202:0x064f, B:203:0x065c, B:204:0x0660, B:206:0x0666, B:208:0x0676, B:162:0x04ff, B:164:0x050f, B:167:0x0522, B:169:0x0533, B:171:0x053f, B:131:0x0431, B:133:0x043d, B:135:0x0449, B:147:0x048e, B:139:0x0466, B:142:0x0478, B:144:0x047e, B:146:0x0488, B:33:0x012d, B:35:0x0138, B:37:0x0144, B:39:0x014a, B:43:0x0155, B:212:0x06a4, B:214:0x06b2, B:216:0x06bb, B:227:0x06eb, B:217:0x06c3, B:219:0x06cc, B:221:0x06d2, B:224:0x06de, B:226:0x06e6, B:228:0x06ee, B:229:0x06fa, B:232:0x0702, B:234:0x0714, B:235:0x071f, B:237:0x0727, B:241:0x074c, B:243:0x0766, B:245:0x077b, B:247:0x0795, B:249:0x07aa, B:250:0x07b8, B:252:0x07be, B:254:0x07ce, B:255:0x07d5, B:257:0x07e1, B:258:0x07e8, B:259:0x07eb, B:261:0x082d, B:263:0x0833, B:269:0x085a, B:271:0x0862, B:272:0x086b, B:274:0x0871, B:275:0x0877, B:277:0x088c, B:279:0x089c, B:281:0x08ac, B:283:0x08b4, B:284:0x08b7, B:292:0x0929, B:294:0x0942, B:296:0x0958, B:298:0x095d, B:300:0x0961, B:302:0x0965, B:304:0x096f, B:305:0x0975, B:307:0x0979, B:309:0x097f, B:310:0x098d, B:311:0x0996, B:316:0x09bb, B:320:0x09c2, B:264:0x0841, B:266:0x0847, B:268:0x084d, B:248:0x07a7, B:244:0x0778, B:238:0x072c, B:240:0x0732), top: B:467:0x000f, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x06db  */
    /* JADX WARN: Code duplicated, block: B:42:0x0153  */
    /* JADX WARN: Code duplicated, block: B:430:0x0d59 A[Catch: all -> 0x0e83, TryCatch #1 {all -> 0x0e83, blocks: (B:416:0x0cbd, B:418:0x0cd2, B:421:0x0cd9, B:426:0x0d0a, B:428:0x0d49, B:431:0x0d7a, B:432:0x0d7e, B:433:0x0d88, B:435:0x0dcb, B:436:0x0dd8, B:438:0x0de9, B:446:0x0e35, B:447:0x0e46, B:452:0x0e65, B:451:0x0e52, B:442:0x0e01, B:444:0x0e1a, B:430:0x0d59, B:422:0x0ce1, B:424:0x0ced, B:425:0x0cf3, B:455:0x0e72), top: B:466:0x0025, inners: #0, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:496:0x0429 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:500:0x0611 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x064f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x0636 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:509:0x048e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:514:0x06eb A[SYNTHETIC] */
    private final boolean zzaM(String str, long j) throws Throwable {
        boolean z;
        int i;
        int i2;
        com.google.android.gms.internal.measurement.zzhw zzhwVar;
        boolean z2;
        zzpr zzprVar;
        long j2;
        int iZzc;
        long j3;
        zzpr zzprVar2;
        int i3;
        long jZzt;
        HashMap map;
        int i4;
        com.google.android.gms.internal.measurement.zzhq zzhqVarZzG;
        Long lValueOf;
        String str2;
        String str3;
        int i5;
        com.google.android.gms.internal.measurement.zzhw zzhwVar2;
        boolean z3;
        String str4;
        int i6;
        com.google.android.gms.internal.measurement.zzhw zzhwVar3;
        int i7;
        int i8;
        com.google.android.gms.internal.measurement.zzhl zzhlVar;
        int i9;
        int i10;
        String str5;
        int i11;
        int i12;
        Bundle bundleZzF;
        int i13;
        zzqa zzqaVarZzA;
        ArrayList arrayList;
        Iterator it2;
        com.google.android.gms.internal.measurement.zzhp zzhpVarZze;
        Object obj;
        com.google.android.gms.internal.measurement.zzhq zzhqVarZzn;
        String str6;
        int i14;
        int i15;
        com.google.android.gms.internal.measurement.zzhl zzhlVar2;
        ArrayList arrayList2;
        int i16;
        int i17;
        int i18;
        String strZzh;
        int iCharCount;
        int iCodePointAt;
        String str7;
        zzpv zzpvVar = this;
        String str8 = FirebaseAnalytics.Event.PURCHASE;
        String str9 = "_ai";
        String str10 = FirebaseAnalytics.Param.ITEMS;
        zzj().zzH();
        try {
            zzpr zzprVar3 = new zzpr(zzpvVar, null);
            zzj().zzat(str, j, zzpvVar.zzB, zzprVar3);
            List list = zzprVar3.zzc;
            try {
                if (list == null || list.isEmpty()) {
                    z = false;
                    zzj().zzS();
                } else {
                    com.google.android.gms.internal.measurement.zzhw zzhwVar4 = (com.google.android.gms.internal.measurement.zzhw) zzprVar3.zza.zzch();
                    zzhwVar4.zzu();
                    com.google.android.gms.internal.measurement.zzhl zzhlVar3 = null;
                    com.google.android.gms.internal.measurement.zzhl zzhlVar4 = null;
                    int i19 = -1;
                    int i20 = 0;
                    int i21 = 0;
                    boolean z4 = false;
                    int i22 = 0;
                    int i23 = -1;
                    while (true) {
                        i = i22;
                        i2 = i21;
                        com.google.android.gms.internal.measurement.zzhl zzhlVar5 = zzhlVar3;
                        int i24 = i23;
                        if (i20 >= zzprVar3.zzc.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzhl zzhlVar6 = (com.google.android.gms.internal.measurement.zzhl) ((com.google.android.gms.internal.measurement.zzhm) zzprVar3.zzc.get(i20)).zzch();
                        int i25 = i20;
                        if (zzr().zzx(zzprVar3.zza.zzF(), zzhlVar6.zzo())) {
                            zzaW().zzk().zzc("Dropping blocked raw event. appId", zzhe.zzn(zzprVar3.zza.zzF()), zzpvVar.zzn.zzj().zzd(zzhlVar6.zzo()));
                            if (!zzr().zzt(zzprVar3.zza.zzF()) && !zzr().zzy(zzprVar3.zza.zzF()) && !"_err".equals(zzhlVar6.zzo())) {
                                zzB().zzR(zzpvVar.zzK, zzprVar3.zza.zzF(), 11, "_ev", zzhlVar6.zzo(), 0);
                            }
                            i22 = i;
                            str3 = str8;
                            str4 = str9;
                            i12 = i19;
                            z3 = z4;
                            i21 = i2;
                            zzhlVar3 = zzhlVar5;
                            i23 = i24;
                            i11 = i25;
                            str5 = str10;
                            zzhwVar3 = zzhwVar4;
                        } else {
                            com.google.android.gms.internal.measurement.zzoy.zzb();
                            String str11 = str10;
                            if (zzi().zzx(null, zzgi.zzbf)) {
                                String strZzo = zzhlVar6.zzo();
                                str2 = "_et";
                                if (strZzo.equals(str8) || strZzo.equals("_iap") || strZzo.equals("ecommerce_purchase")) {
                                    com.google.android.gms.internal.measurement.zzhp zzhpVarZze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                                    zzhpVarZze2.zzj("_cbs");
                                    if (z4) {
                                        str7 = "returning_buyer";
                                    } else {
                                        String strZzF = zzprVar3.zza.zzF();
                                        if (zzpvVar.zzaO(strZzF, str8) && zzpvVar.zzaO(strZzF, "_iap") && zzpvVar.zzaO(strZzF, "ecommerce_purchase")) {
                                            str7 = "new_buyer";
                                        } else {
                                            str7 = "returning_buyer";
                                        }
                                    }
                                    zzhpVarZze2.zzk(str7);
                                    zzhlVar6.zzf((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze2.zzba());
                                    z4 = true;
                                }
                            } else {
                                str2 = "_et";
                            }
                            if (zzhlVar6.zzo().equals(zzjy.zza(str9))) {
                                zzhlVar6.zzi(str9);
                                zzaW().zzj().zza("Renaming ad_impression to _ai");
                                if (Log.isLoggable(zzaW().zzr(), 5)) {
                                    for (int i26 = 0; i26 < zzhlVar6.zza(); i26++) {
                                        if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhlVar6.zzn(i26).zzg()) && !zzhlVar6.zzn(i26).zzh().isEmpty() && "admob".equalsIgnoreCase(zzhlVar6.zzn(i26).zzh())) {
                                            zzaW().zzl().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                        }
                                    }
                                }
                            }
                            boolean zZzw = zzr().zzw(zzprVar3.zza.zzF(), zzhlVar6.zzo());
                            if (zZzw) {
                                str3 = str8;
                            } else {
                                zzA();
                                String strZzo2 = zzhlVar6.zzo();
                                Preconditions.checkNotEmpty(strZzo2);
                                str3 = str8;
                                if (strZzo2.hashCode() != 95027 || !strZzo2.equals("_ui")) {
                                    i6 = i;
                                    str4 = str9;
                                    zzhwVar2 = zzhwVar4;
                                    i5 = i19;
                                    z3 = z4;
                                    zZzw = false;
                                }
                                if (zZzw) {
                                    arrayList2 = new ArrayList(zzhlVar6.zzp());
                                    i17 = -1;
                                    i18 = -1;
                                    for (i16 = 0; i16 < arrayList2.size(); i16++) {
                                        if ("value".equals(((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i16)).zzg())) {
                                            i17 = i16;
                                        } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i16)).zzg())) {
                                            i18 = i16;
                                        }
                                    }
                                    if (i17 != -1) {
                                        if (!((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i17)).zzw() || ((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i17)).zzu()) {
                                            if (i18 == -1) {
                                                strZzh = ((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i18)).zzh();
                                                if (strZzh.length() == 3) {
                                                    iCharCount = 0;
                                                    while (iCharCount < strZzh.length()) {
                                                        iCodePointAt = strZzh.codePointAt(iCharCount);
                                                        if (Character.isLetter(iCodePointAt)) {
                                                            iCharCount += Character.charCount(iCodePointAt);
                                                        }
                                                    }
                                                }
                                            }
                                            zzaW().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                            zzhlVar6.zzh(i17);
                                            zzaB(zzhlVar6, "_c");
                                            zzaA(zzhlVar6, 19, FirebaseAnalytics.Param.CURRENCY);
                                            break;
                                        }
                                        zzaW().zzl().zza("Value must be specified with a numeric type.");
                                        zzhlVar6.zzh(i17);
                                        zzaB(zzhlVar6, "_c");
                                        zzaA(zzhlVar6, 18, "value");
                                    }
                                }
                                if ("_e".equals(zzhlVar6.zzo())) {
                                    zzA();
                                    if (zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar6.zzba(), "_fr") == null) {
                                        if (zzhlVar4 != null && Math.abs(zzhlVar4.zzc() - zzhlVar6.zzc()) <= 1000) {
                                            zzhlVar2 = (com.google.android.gms.internal.measurement.zzhl) zzhlVar4.clone();
                                            if (zzpvVar.zzaP(zzhlVar6, zzhlVar2)) {
                                                zzhwVar3 = zzhwVar2;
                                                int i27 = i5;
                                                zzhwVar3.zzad(i27, zzhlVar2);
                                                i8 = i27;
                                                i23 = i24;
                                                zzhlVar3 = null;
                                                zzhlVar4 = null;
                                            }
                                        }
                                        zzhwVar3 = zzhwVar2;
                                        zzhlVar3 = zzhlVar6;
                                        i8 = i5;
                                        i23 = i2;
                                    } else {
                                        zzhwVar3 = zzhwVar2;
                                        i7 = i5;
                                        i23 = i24;
                                        i8 = i7;
                                        zzhlVar3 = zzhlVar5;
                                    }
                                } else {
                                    zzhwVar3 = zzhwVar2;
                                    i7 = i5;
                                    if ("_vs".equals(zzhlVar6.zzo())) {
                                        zzA();
                                        if (zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar6.zzba(), str2) == null) {
                                            if (zzhlVar5 != null && Math.abs(zzhlVar5.zzc() - zzhlVar6.zzc()) <= 1000) {
                                                zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzhlVar5.clone();
                                                if (zzpvVar.zzaP(zzhlVar, zzhlVar6)) {
                                                    zzhwVar3.zzad(i24, zzhlVar);
                                                    i23 = i24;
                                                    i8 = i7;
                                                    zzhlVar3 = null;
                                                    zzhlVar4 = null;
                                                }
                                            }
                                            i23 = i24;
                                            zzhlVar4 = zzhlVar6;
                                            i8 = i2;
                                        } else {
                                            i23 = i24;
                                            i8 = i7;
                                        }
                                    } else {
                                        i23 = i24;
                                        i8 = i7;
                                    }
                                    zzhlVar3 = zzhlVar5;
                                }
                                if (zzhlVar6.zza() != 0) {
                                    zzA();
                                    bundleZzF = zzqa.zzF(zzhlVar6.zzp());
                                    i13 = 0;
                                    while (i13 < zzhlVar6.zza()) {
                                        zzhqVarZzn = zzhlVar6.zzn(i13);
                                        str6 = str11;
                                        if (zzhqVarZzn.zzg().equals(str6) || zzhqVarZzn.zzi().isEmpty()) {
                                            i14 = i8;
                                            i15 = i6;
                                            if (!zzhqVarZzn.zzg().equals(str6)) {
                                                zzpvVar.zzaw(zzhlVar6.zzo(), (com.google.android.gms.internal.measurement.zzhp) zzhqVarZzn.zzch(), bundleZzF, zzprVar3.zza.zzF());
                                            }
                                        } else {
                                            String strZzF2 = zzprVar3.zza.zzF();
                                            List listZzi = zzhqVarZzn.zzi();
                                            Bundle[] bundleArr = new Bundle[listZzi.size()];
                                            i14 = i8;
                                            int i28 = 0;
                                            while (i28 < listZzi.size()) {
                                                com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) listZzi.get(i28);
                                                zzA();
                                                List list2 = listZzi;
                                                Bundle bundleZzF2 = zzqa.zzF(zzhqVar.zzi());
                                                Iterator it3 = zzhqVar.zzi().iterator();
                                                while (it3.hasNext()) {
                                                    zzpvVar.zzaw(zzhlVar6.zzo(), (com.google.android.gms.internal.measurement.zzhp) ((com.google.android.gms.internal.measurement.zzhq) it3.next()).zzch(), bundleZzF2, strZzF2);
                                                    it3 = it3;
                                                    i6 = i6;
                                                }
                                                bundleArr[i28] = bundleZzF2;
                                                i28++;
                                                listZzi = list2;
                                                i6 = i6;
                                            }
                                            i15 = i6;
                                            bundleZzF.putParcelableArray(str6, bundleArr);
                                        }
                                        i13++;
                                        i8 = i14;
                                        str11 = str6;
                                        i6 = i15;
                                    }
                                    i9 = i8;
                                    i10 = i6;
                                    str5 = str11;
                                    zzhlVar6.zzg();
                                    zzqaVarZzA = zzA();
                                    arrayList = new ArrayList();
                                    for (String str12 : bundleZzF.keySet()) {
                                        zzhpVarZze = com.google.android.gms.internal.measurement.zzhq.zze();
                                        zzhpVarZze.zzj(str12);
                                        obj = bundleZzF.get(str12);
                                        if (obj != null) {
                                            zzqaVarZzA.zzw(zzhpVarZze, obj);
                                            arrayList.add((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze.zzba());
                                        }
                                    }
                                    it2 = arrayList.iterator();
                                    while (it2.hasNext()) {
                                        zzhlVar6.zzf((com.google.android.gms.internal.measurement.zzhq) it2.next());
                                    }
                                } else {
                                    i9 = i8;
                                    i10 = i6;
                                    str5 = str11;
                                }
                                i11 = i25;
                                zzprVar3.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhm) zzhlVar6.zzba());
                                zzhwVar3.zzn(zzhlVar6);
                                i21 = i2 + 1;
                                i12 = i9;
                                i22 = i10;
                            }
                            str4 = str9;
                            int i29 = 0;
                            boolean z5 = false;
                            boolean z6 = false;
                            while (true) {
                                z3 = z4;
                                if (i29 >= zzhlVar6.zza()) {
                                    break;
                                }
                                if ("_c".equals(zzhlVar6.zzn(i29).zzg())) {
                                    com.google.android.gms.internal.measurement.zzhp zzhpVar = (com.google.android.gms.internal.measurement.zzhp) zzhlVar6.zzn(i29).zzch();
                                    zzhpVar.zzi(1L);
                                    zzhlVar6.zzk(i29, (com.google.android.gms.internal.measurement.zzhq) zzhpVar.zzba());
                                    z5 = true;
                                } else if ("_r".equals(zzhlVar6.zzn(i29).zzg())) {
                                    com.google.android.gms.internal.measurement.zzhp zzhpVar2 = (com.google.android.gms.internal.measurement.zzhp) zzhlVar6.zzn(i29).zzch();
                                    zzhpVar2.zzi(1L);
                                    zzhlVar6.zzk(i29, (com.google.android.gms.internal.measurement.zzhq) zzhpVar2.zzba());
                                    z6 = true;
                                }
                                i29++;
                                z4 = z3;
                                zzhwVar4 = zzhwVar4;
                                i19 = i19;
                            }
                            zzhwVar2 = zzhwVar4;
                            i5 = i19;
                            if (!z5 && zZzw) {
                                zzaW().zzj().zzb("Marking event as conversion", zzpvVar.zzn.zzj().zzd(zzhlVar6.zzo()));
                                com.google.android.gms.internal.measurement.zzhp zzhpVarZze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zzhpVarZze3.zzj("_c");
                                zzhpVarZze3.zzi(1L);
                                zzhlVar6.zze(zzhpVarZze3);
                            }
                            if (!z6) {
                                zzaW().zzj().zzb("Marking event as real-time", zzpvVar.zzn.zzj().zzd(zzhlVar6.zzo()));
                                com.google.android.gms.internal.measurement.zzhp zzhpVarZze4 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zzhpVarZze4.zzj("_r");
                                zzhpVarZze4.zzi(1L);
                                zzhlVar6.zze(zzhpVarZze4);
                            }
                            if (zzj().zzo(zza(), zzprVar3.zza.zzF(), false, false, false, false, true, false, false).zze > zzi().zzh(zzprVar3.zza.zzF(), zzgi.zzo)) {
                                zzaB(zzhlVar6, "_r");
                                i6 = i;
                            } else {
                                i6 = 1;
                            }
                            if (zzqf.zzaq(zzhlVar6.zzo()) && zZzw && zzj().zzo(zza(), zzprVar3.zza.zzF(), false, false, true, false, false, false, false).zzc > zzi().zzh(zzprVar3.zza.zzF(), zzgi.zzn)) {
                                zzaW().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                                boolean z7 = false;
                                int i30 = -1;
                                com.google.android.gms.internal.measurement.zzhp zzhpVar3 = null;
                                for (int i31 = 0; i31 < zzhlVar6.zza(); i31++) {
                                    com.google.android.gms.internal.measurement.zzhq zzhqVarZzn2 = zzhlVar6.zzn(i31);
                                    if ("_c".equals(zzhqVarZzn2.zzg())) {
                                        zzhpVar3 = (com.google.android.gms.internal.measurement.zzhp) zzhqVarZzn2.zzch();
                                        i30 = i31;
                                    } else if ("_err".equals(zzhqVarZzn2.zzg())) {
                                        z7 = true;
                                    }
                                }
                                if (z7) {
                                    if (zzhpVar3 != null) {
                                        zzhlVar6.zzh(i30);
                                    } else {
                                        zzhpVar3 = null;
                                        if (zzhpVar3 != null) {
                                            com.google.android.gms.internal.measurement.zzhp zzhpVar4 = (com.google.android.gms.internal.measurement.zzhp) zzhpVar3.clone();
                                            zzhpVar4.zzj("_err");
                                            zzhpVar4.zzi(10L);
                                            zzhlVar6.zzk(i30, (com.google.android.gms.internal.measurement.zzhq) zzhpVar4.zzba());
                                        } else {
                                            zzaW().zze().zzb("Did not find conversion parameter. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                                        }
                                    }
                                } else if (zzhpVar3 != null) {
                                    com.google.android.gms.internal.measurement.zzhp zzhpVar5 = (com.google.android.gms.internal.measurement.zzhp) zzhpVar3.clone();
                                    zzhpVar5.zzj("_err");
                                    zzhpVar5.zzi(10L);
                                    zzhlVar6.zzk(i30, (com.google.android.gms.internal.measurement.zzhq) zzhpVar5.zzba());
                                } else {
                                    zzaW().zze().zzb("Did not find conversion parameter. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                                }
                            }
                            if (zZzw) {
                                arrayList2 = new ArrayList(zzhlVar6.zzp());
                                i17 = -1;
                                i18 = -1;
                                while (i16 < arrayList2.size()) {
                                    if ("value".equals(((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i16)).zzg())) {
                                        i17 = i16;
                                    } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i16)).zzg())) {
                                        i18 = i16;
                                    }
                                }
                                if (i17 != -1) {
                                    if (((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i17)).zzw()) {
                                    }
                                    if (i18 == -1) {
                                        strZzh = ((com.google.android.gms.internal.measurement.zzhq) arrayList2.get(i18)).zzh();
                                        if (strZzh.length() == 3) {
                                            iCharCount = 0;
                                            while (iCharCount < strZzh.length()) {
                                                iCodePointAt = strZzh.codePointAt(iCharCount);
                                                if (Character.isLetter(iCodePointAt)) {
                                                    iCharCount += Character.charCount(iCodePointAt);
                                                }
                                            }
                                        }
                                    }
                                    zzaW().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                    zzhlVar6.zzh(i17);
                                    zzaB(zzhlVar6, "_c");
                                    zzaA(zzhlVar6, 19, FirebaseAnalytics.Param.CURRENCY);
                                    break;
                                }
                            }
                            if ("_e".equals(zzhlVar6.zzo())) {
                                zzA();
                                if (zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar6.zzba(), "_fr") == null) {
                                    if (zzhlVar4 != null) {
                                        zzhlVar2 = (com.google.android.gms.internal.measurement.zzhl) zzhlVar4.clone();
                                        if (zzpvVar.zzaP(zzhlVar6, zzhlVar2)) {
                                            zzhwVar3 = zzhwVar2;
                                            int i210 = i5;
                                            zzhwVar3.zzad(i210, zzhlVar2);
                                            i8 = i210;
                                            i23 = i24;
                                            zzhlVar3 = null;
                                            zzhlVar4 = null;
                                        }
                                    }
                                    zzhwVar3 = zzhwVar2;
                                    zzhlVar3 = zzhlVar6;
                                    i8 = i5;
                                    i23 = i2;
                                } else {
                                    zzhwVar3 = zzhwVar2;
                                    i7 = i5;
                                    i23 = i24;
                                    i8 = i7;
                                    zzhlVar3 = zzhlVar5;
                                }
                            } else {
                                zzhwVar3 = zzhwVar2;
                                i7 = i5;
                                if ("_vs".equals(zzhlVar6.zzo())) {
                                    zzA();
                                    if (zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar6.zzba(), str2) == null) {
                                        if (zzhlVar5 != null) {
                                            zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzhlVar5.clone();
                                            if (zzpvVar.zzaP(zzhlVar, zzhlVar6)) {
                                                zzhwVar3.zzad(i24, zzhlVar);
                                                i23 = i24;
                                                i8 = i7;
                                                zzhlVar3 = null;
                                                zzhlVar4 = null;
                                            }
                                        }
                                        i23 = i24;
                                        zzhlVar4 = zzhlVar6;
                                        i8 = i2;
                                    } else {
                                        i23 = i24;
                                        i8 = i7;
                                    }
                                } else {
                                    i23 = i24;
                                    i8 = i7;
                                }
                                zzhlVar3 = zzhlVar5;
                            }
                            if (zzhlVar6.zza() != 0) {
                                zzA();
                                bundleZzF = zzqa.zzF(zzhlVar6.zzp());
                                i13 = 0;
                                while (i13 < zzhlVar6.zza()) {
                                    zzhqVarZzn = zzhlVar6.zzn(i13);
                                    str6 = str11;
                                    if (zzhqVarZzn.zzg().equals(str6)) {
                                        i14 = i8;
                                        i15 = i6;
                                        if (!zzhqVarZzn.zzg().equals(str6)) {
                                            zzpvVar.zzaw(zzhlVar6.zzo(), (com.google.android.gms.internal.measurement.zzhp) zzhqVarZzn.zzch(), bundleZzF, zzprVar3.zza.zzF());
                                        }
                                    } else {
                                        i14 = i8;
                                        i15 = i6;
                                        if (!zzhqVarZzn.zzg().equals(str6)) {
                                            zzpvVar.zzaw(zzhlVar6.zzo(), (com.google.android.gms.internal.measurement.zzhp) zzhqVarZzn.zzch(), bundleZzF, zzprVar3.zza.zzF());
                                        }
                                    }
                                    i13++;
                                    i8 = i14;
                                    str11 = str6;
                                    i6 = i15;
                                }
                                i9 = i8;
                                i10 = i6;
                                str5 = str11;
                                zzhlVar6.zzg();
                                zzqaVarZzA = zzA();
                                arrayList = new ArrayList();
                                while (r7.hasNext()) {
                                    zzhpVarZze = com.google.android.gms.internal.measurement.zzhq.zze();
                                    zzhpVarZze.zzj(str12);
                                    obj = bundleZzF.get(str12);
                                    if (obj != null) {
                                        zzqaVarZzA.zzw(zzhpVarZze, obj);
                                        arrayList.add((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze.zzba());
                                    }
                                }
                                it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    zzhlVar6.zzf((com.google.android.gms.internal.measurement.zzhq) it2.next());
                                }
                            } else {
                                i9 = i8;
                                i10 = i6;
                                str5 = str11;
                            }
                            i11 = i25;
                            zzprVar3.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhm) zzhlVar6.zzba());
                            zzhwVar3.zzn(zzhlVar6);
                            i21 = i2 + 1;
                            i12 = i9;
                            i22 = i10;
                        }
                        i20 = i11 + 1;
                        i19 = i12;
                        zzhwVar4 = zzhwVar3;
                        str10 = str5;
                        str8 = str3;
                        str9 = str4;
                        z4 = z3;
                    }
                    com.google.android.gms.internal.measurement.zzhw zzhwVar5 = zzhwVar4;
                    long j4 = 0;
                    long jLongValue = 0;
                    int i32 = i2;
                    int i33 = 0;
                    while (i33 < i32) {
                        com.google.android.gms.internal.measurement.zzhm zzhmVarZzh = zzhwVar5.zzh(i33);
                        if ("_e".equals(zzhmVarZzh.zzh())) {
                            zzA();
                            if (zzqa.zzG(zzhmVarZzh, "_fr") != null) {
                                zzhwVar5.zzD(i33);
                                i32--;
                                i33--;
                            } else {
                                zzA();
                                zzhqVarZzG = zzqa.zzG(zzhmVarZzh, "_et");
                                if (zzhqVarZzG == null) {
                                    if (zzhqVarZzG.zzw()) {
                                        lValueOf = Long.valueOf(zzhqVarZzG.zzd());
                                    } else {
                                        lValueOf = null;
                                    }
                                    if (lValueOf == null && lValueOf.longValue() > 0) {
                                        jLongValue += lValueOf.longValue();
                                    }
                                }
                            }
                        } else {
                            zzA();
                            zzhqVarZzG = zzqa.zzG(zzhmVarZzh, "_et");
                            if (zzhqVarZzG == null) {
                                if (zzhqVarZzG.zzw()) {
                                    lValueOf = Long.valueOf(zzhqVarZzG.zzd());
                                } else {
                                    lValueOf = null;
                                }
                                if (lValueOf == null) {
                                }
                            }
                        }
                        i33++;
                    }
                    zzpvVar.zzaI(zzhwVar5, jLongValue, false);
                    Iterator it4 = zzhwVar5.zzaM().iterator();
                    while (it4.hasNext()) {
                        if ("_s".equals(((com.google.android.gms.internal.measurement.zzhm) it4.next()).zzh())) {
                            zzj().zzP(zzhwVar5.zzaF(), "_se");
                            break;
                        }
                    }
                    if (zzqa.zza(zzhwVar5, "_sid") >= 0) {
                        zzpvVar.zzaI(zzhwVar5, jLongValue, true);
                    } else {
                        int iZza = zzqa.zza(zzhwVar5, "_se");
                        if (iZza >= 0) {
                            zzhwVar5.zzE(iZza);
                            zzaW().zze().zzb("Session engagement user property is in the bundle without session ID. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                        }
                    }
                    String strZzF3 = zzprVar3.zza.zzF();
                    zzaX().zzg();
                    zzM();
                    zzh zzhVarZzl = zzj().zzl(strZzF3);
                    if (zzhVarZzl == null) {
                        zzaW().zze().zzb("Cannot fix consent fields without appInfo. appId", zzhe.zzn(strZzF3));
                    } else {
                        zzpvVar.zzQ(zzhVarZzl, zzhwVar5);
                    }
                    String strZzF4 = zzprVar3.zza.zzF();
                    zzaX().zzg();
                    zzM();
                    zzh zzhVarZzl2 = zzj().zzl(strZzF4);
                    if (zzhVarZzl2 == null) {
                        zzaW().zzk().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzhe.zzn(strZzF4));
                    } else {
                        zzpvVar.zzaa(zzhVarZzl2, zzhwVar5);
                    }
                    zzhwVar5.zzax(Long.MAX_VALUE);
                    zzhwVar5.zzab(Long.MIN_VALUE);
                    for (int i34 = 0; i34 < zzhwVar5.zzc(); i34++) {
                        com.google.android.gms.internal.measurement.zzhm zzhmVarZzh2 = zzhwVar5.zzh(i34);
                        if (zzhmVarZzh2.zzd() < zzhwVar5.zzf()) {
                            zzhwVar5.zzax(zzhmVarZzh2.zzd());
                        }
                        if (zzhmVarZzh2.zzd() > zzhwVar5.zze()) {
                            zzhwVar5.zzab(zzhmVarZzh2.zzd());
                        }
                    }
                    zzhwVar5.zzB();
                    zzjx zzjxVar = zzjx.zza;
                    zzjx zzjxVarZzl = zzpvVar.zzu(zzprVar3.zza.zzF()).zzl(zzjx.zzk(zzprVar3.zza.zzK(), 100));
                    zzjx zzjxVarZzt = zzj().zzt(zzprVar3.zza.zzF());
                    zzj().zzW(zzprVar3.zza.zzF(), zzjxVarZzl);
                    zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
                    if (!zzjxVarZzl.zzr(zzjwVar) && zzjxVarZzt.zzr(zzjwVar)) {
                        zzj().zzI(zzprVar3.zza.zzF());
                    } else if (zzjxVarZzl.zzr(zzjwVar) && !zzjxVarZzt.zzr(zzjwVar)) {
                        zzj().zzQ(zzprVar3.zza.zzF());
                    }
                    zzjw zzjwVar2 = zzjw.AD_STORAGE;
                    if (!zzjxVarZzl.zzr(zzjwVar2)) {
                        zzhwVar5.zzz();
                        zzhwVar5.zzw();
                        zzhwVar5.zzt();
                    }
                    if (!zzjxVarZzl.zzr(zzjwVar)) {
                        zzhwVar5.zzq();
                        zzhwVar5.zzA();
                    }
                    zzqr.zzb();
                    if (zzi().zzx(zzprVar3.zza.zzF(), zzgi.zzaV) && zzB().zzab(zzprVar3.zza.zzF()) && zzpvVar.zzu(zzprVar3.zza.zzF()).zzr(zzjwVar2) && zzprVar3.zza.zzbt()) {
                        zzpvVar.zzR(zzhwVar5, zzprVar3);
                    }
                    zzhwVar5.zzr();
                    zzhwVar5.zzi(zzh().zza(zzhwVar5.zzaF(), zzhwVar5.zzaM(), zzhwVar5.zzaN(), Long.valueOf(zzhwVar5.zzf()), Long.valueOf(zzhwVar5.zze()), !zzjxVarZzl.zzr(zzjwVar)));
                    if (zzi().zzB(zzprVar3.zza.zzF())) {
                        try {
                            HashMap map2 = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom secureRandomZzJ = zzB().zzJ();
                            int i35 = 0;
                            while (i35 < zzhwVar5.zzc()) {
                                com.google.android.gms.internal.measurement.zzhl zzhlVar7 = (com.google.android.gms.internal.measurement.zzhl) zzhwVar5.zzh(i35).zzch();
                                if (zzhlVar7.zzo().equals("_ep")) {
                                    zzA();
                                    String str13 = (String) zzqa.zzH((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba(), "_en");
                                    zzbd zzbdVarZzs = (zzbd) map2.get(str13);
                                    if (zzbdVarZzs == null && (zzbdVarZzs = zzj().zzs(zzprVar3.zza.zzF(), (String) Preconditions.checkNotNull(str13))) != null) {
                                        map2.put(str13, zzbdVarZzs);
                                    }
                                    if (zzbdVarZzs != null && zzbdVarZzs.zzi == null) {
                                        Long l = zzbdVarZzs.zzj;
                                        if (l != null && l.longValue() > 1) {
                                            zzA();
                                            zzqa.zzD(zzhlVar7, "_sr", l);
                                        }
                                        Boolean bool = zzbdVarZzs.zzk;
                                        if (bool != null && bool.booleanValue()) {
                                            zzA();
                                            zzqa.zzD(zzhlVar7, "_efs", 1L);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                    }
                                    zzhwVar5.zzad(i35, zzhlVar7);
                                    zzprVar2 = zzprVar3;
                                    map = map2;
                                    secureRandomZzJ = secureRandomZzJ;
                                    i4 = i35;
                                } else {
                                    zzif zzifVarZzr = zzr();
                                    String strZzF5 = zzprVar3.zza.zzF();
                                    String strZza = zzifVarZzr.zza(strZzF5, "measurement.account.time_zone_offset_minutes");
                                    if (TextUtils.isEmpty(strZza)) {
                                        j2 = j4;
                                    } else {
                                        try {
                                            j2 = Long.parseLong(strZza);
                                        } catch (NumberFormatException e) {
                                            zzifVarZzr.zzu.zzaW().zzk().zzc("Unable to parse timezone offset. appId", zzhe.zzn(strZzF5), e);
                                            j2 = j4;
                                        }
                                    }
                                    long jZzt2 = zzB().zzt(zzhlVar7.zzc(), j2);
                                    com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba();
                                    Long l2 = 1L;
                                    if (!TextUtils.isEmpty("_dbg")) {
                                        Iterator it5 = zzhmVar.zzi().iterator();
                                        while (true) {
                                            if (it5.hasNext()) {
                                                com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) it5.next();
                                                Iterator it6 = it5;
                                                if ("_dbg".equals(zzhqVar2.zzg())) {
                                                    if (l2.equals(Long.valueOf(zzhqVar2.zzd()))) {
                                                        iZzc = 1;
                                                        break;
                                                    }
                                                } else {
                                                    it5 = it6;
                                                }
                                            }
                                            iZzc = zzr().zzc(zzprVar3.zza.zzF(), zzhlVar7.zzo());
                                            break;
                                        }
                                    }
                                    iZzc = zzr().zzc(zzprVar3.zza.zzF(), zzhlVar7.zzo());
                                    break;
                                    if (iZzc <= 0) {
                                        zzaW().zzk().zzc("Sample rate must be positive. event, rate", zzhlVar7.zzo(), Integer.valueOf(iZzc));
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                        zzhwVar5.zzad(i35, zzhlVar7);
                                        zzprVar2 = zzprVar3;
                                        map = map2;
                                        secureRandomZzJ = secureRandomZzJ;
                                        i4 = i35;
                                    } else {
                                        zzbd zzbdVarZza = (zzbd) map2.get(zzhlVar7.zzo());
                                        if (zzbdVarZza == null) {
                                            j3 = j2;
                                            zzbdVarZza = zzj().zzs(zzprVar3.zza.zzF(), zzhlVar7.zzo());
                                            if (zzbdVarZza == null) {
                                                zzaW().zzk().zzc("Event being bundled has no eventAggregate. appId, eventName", zzprVar3.zza.zzF(), zzhlVar7.zzo());
                                                zzbdVarZza = new zzbd(zzprVar3.zza.zzF(), zzhlVar7.zzo(), 1L, 1L, 1L, zzhlVar7.zzc(), 0L, null, null, null, null);
                                            }
                                        } else {
                                            j3 = j2;
                                        }
                                        zzA();
                                        Long l3 = (Long) zzqa.zzH((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba(), "_eid");
                                        boolean z8 = l3 != null;
                                        Boolean boolValueOf = Boolean.valueOf(z8);
                                        zzprVar2 = zzprVar3;
                                        if (iZzc == 1) {
                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                            boolValueOf.getClass();
                                            if (z8 && (zzbdVarZza.zzi != null || zzbdVarZza.zzj != null || zzbdVarZza.zzk != null)) {
                                                map2.put(zzhlVar7.zzo(), zzbdVarZza.zza(null, null, null));
                                            }
                                            zzhwVar5.zzad(i35, zzhlVar7);
                                            map = map2;
                                            secureRandomZzJ = secureRandomZzJ;
                                            i4 = i35;
                                        } else {
                                            if (secureRandomZzJ.nextInt(iZzc) == 0) {
                                                zzA();
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar6 = zzhwVar5;
                                                Long lValueOf2 = Long.valueOf(iZzc);
                                                zzqa.zzD(zzhlVar7, "_sr", lValueOf2);
                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                                boolValueOf.getClass();
                                                if (z8) {
                                                    zzbdVarZza = zzbdVarZza.zza(null, lValueOf2, null);
                                                }
                                                map2.put(zzhlVar7.zzo(), zzbdVarZza.zzb(zzhlVar7.zzc(), jZzt2));
                                                map = map2;
                                                secureRandomZzJ = secureRandomZzJ;
                                                i4 = i35;
                                                zzhwVar5 = zzhwVar6;
                                            } else {
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar7 = zzhwVar5;
                                                Long l4 = zzbdVarZza.zzh;
                                                if (l4 != null) {
                                                    jZzt = l4.longValue();
                                                    i3 = i35;
                                                } else {
                                                    i3 = i35;
                                                    jZzt = zzB().zzt(zzhlVar7.zzb(), j3);
                                                }
                                                if (jZzt != jZzt2) {
                                                    zzA();
                                                    zzqa.zzD(zzhlVar7, "_efs", 1L);
                                                    zzA();
                                                    Long lValueOf3 = Long.valueOf(iZzc);
                                                    zzqa.zzD(zzhlVar7, "_sr", lValueOf3);
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                                    boolValueOf.getClass();
                                                    if (z8) {
                                                        zzbdVarZza = zzbdVarZza.zza(null, lValueOf3, true);
                                                    }
                                                    map = map2;
                                                    map.put(zzhlVar7.zzo(), zzbdVarZza.zzb(zzhlVar7.zzc(), jZzt2));
                                                } else {
                                                    map = map2;
                                                    boolValueOf.getClass();
                                                    if (z8) {
                                                        map.put(zzhlVar7.zzo(), zzbdVarZza.zza(l3, null, null));
                                                    }
                                                }
                                                i4 = i3;
                                                zzhwVar5 = zzhwVar7;
                                            }
                                            zzhwVar5.zzad(i4, zzhlVar7);
                                        }
                                    }
                                }
                                i35 = i4 + 1;
                                secureRandomZzJ = secureRandomZzJ;
                                zzhwVar5 = zzhwVar5;
                                map2 = map;
                                zzprVar3 = zzprVar2;
                                j4 = 0;
                                zzpvVar = this;
                            }
                            zzhwVar = zzhwVar5;
                            zzpr zzprVar4 = zzprVar3;
                            HashMap map3 = map2;
                            z2 = true;
                            if (arrayList3.size() < zzhwVar.zzc()) {
                                zzhwVar.zzu();
                                zzhwVar.zzj(arrayList3);
                            }
                            Iterator it7 = map3.entrySet().iterator();
                            while (it7.hasNext()) {
                                zzj().zzV((zzbd) ((Map.Entry) it7.next()).getValue());
                            }
                            zzprVar = zzprVar4;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            zzj().zzL();
                            throw th2;
                        }
                    } else {
                        zzhwVar = zzhwVar5;
                        z2 = true;
                        zzprVar = zzprVar3;
                    }
                    String strZzF6 = zzprVar.zza.zzF();
                    zzh zzhVarZzl3 = zzj().zzl(strZzF6);
                    if (zzhVarZzl3 == null) {
                        zzaW().zze().zzb("Bundling raw events w/o app info. appId", zzhe.zzn(zzprVar.zza.zzF()));
                    } else if (zzhwVar.zzc() > 0) {
                        long jZzs = zzhVarZzl3.zzs();
                        if (jZzs != 0) {
                            zzhwVar.zzap(jZzs);
                        } else {
                            zzhwVar.zzx();
                        }
                        long jZzu = zzhVarZzl3.zzu();
                        if (jZzu != 0) {
                            jZzs = jZzu;
                        }
                        if (jZzs != 0) {
                            zzhwVar.zzaq(jZzs);
                        } else {
                            zzhwVar.zzy();
                        }
                        zzhVarZzl3.zzQ(zzhwVar.zzc());
                        zzhwVar.zzV((int) zzhVarZzl3.zzr());
                        zzhwVar.zzP((int) zzhVarZzl3.zzt());
                        zzhVarZzl3.zzau(zzhwVar.zzf());
                        zzhVarZzl3.zzas(zzhwVar.zze());
                        String strZzB = zzhVarZzl3.zzB();
                        if (strZzB != null) {
                            zzhwVar.zzaj(strZzB);
                        } else {
                            zzhwVar.zzv();
                        }
                        zzj().zzT(zzhVarZzl3, false, false);
                    }
                    if (zzhwVar.zzc() > 0) {
                        this.zzn.zzaV();
                        com.google.android.gms.internal.measurement.zzgo zzgoVarZzj = zzr().zzj(zzprVar.zza.zzF());
                        if (zzgoVarZzj != null && zzgoVarZzj.zzw()) {
                            zzhwVar.zzR(zzgoVarZzj.zzc());
                        } else if (zzprVar.zza.zzP().isEmpty()) {
                            zzhwVar.zzR(-1L);
                        } else {
                            zzaW().zzk().zzb("Did not find measurement config or missing version info. appId", zzhe.zzn(zzprVar.zza.zzF()));
                        }
                        zzaw zzawVarZzj = zzj();
                        com.google.android.gms.internal.measurement.zzhx zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba();
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzav();
                        Preconditions.checkNotNull(zzhxVar);
                        Preconditions.checkNotEmpty(zzhxVar.zzF());
                        Preconditions.checkState(zzhxVar.zzbK());
                        zzawVarZzj.zzO();
                        zzio zzioVar = zzawVarZzj.zzu;
                        long jCurrentTimeMillis = zzioVar.zzaU().currentTimeMillis();
                        long jZzo = zzhxVar.zzo();
                        zzioVar.zzf();
                        if (jZzo >= jCurrentTimeMillis - zzam.zzI()) {
                            long jZzo2 = zzhxVar.zzo();
                            zzioVar.zzf();
                            if (jZzo2 > zzam.zzI() + jCurrentTimeMillis) {
                                zzioVar.zzaW().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzhe.zzn(zzhxVar.zzF()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzhxVar.zzo()));
                            }
                        } else {
                            zzioVar.zzaW().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzhe.zzn(zzhxVar.zzF()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzhxVar.zzo()));
                        }
                        try {
                            byte[] bArrZzB = zzawVarZzj.zzg.zzA().zzB(zzhxVar.zzcd());
                            zzio zzioVar2 = zzawVarZzj.zzu;
                            zzioVar2.zzaW().zzj().zzb("Saving bundle, size", Integer.valueOf(bArrZzB.length));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("app_id", zzhxVar.zzF());
                            contentValues.put("bundle_end_timestamp", Long.valueOf(zzhxVar.zzo()));
                            contentValues.put("data", bArrZzB);
                            contentValues.put("has_realtime", Integer.valueOf(i));
                            if (zzhxVar.zzbR()) {
                                contentValues.put("retry_count", Integer.valueOf(zzhxVar.zzg()));
                            }
                            try {
                                if (zzawVarZzj.zzj().insert("queue", null, contentValues) == -1) {
                                    zzioVar2.zzaW().zze().zzb("Failed to insert bundle (got -1). appId", zzhe.zzn(zzhxVar.zzF()));
                                }
                            } catch (SQLiteException e2) {
                                zzawVarZzj.zzu.zzaW().zze().zzc("Error storing bundle. appId", zzhe.zzn(zzhxVar.zzF()), e2);
                            }
                        } catch (IOException e3) {
                            zzawVarZzj.zzu.zzaW().zze().zzc("Data loss. Failed to serialize bundle. appId", zzhe.zzn(zzhxVar.zzF()), e3);
                        }
                    }
                    zzj().zzJ(zzprVar.zzb);
                    zzaw zzawVarZzj2 = zzj();
                    try {
                        zzawVarZzj2.zzj().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strZzF6, strZzF6});
                    } catch (SQLiteException e4) {
                        zzawVarZzj2.zzu.zzaW().zze().zzc("Failed to remove unused event metadata. appId", zzhe.zzn(strZzF6), e4);
                    }
                    zzj().zzS();
                    z = z2;
                }
                zzj().zzL();
                return z;
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                zzj().zzL();
                throw th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private final boolean zzaN() {
        zzaX().zzg();
        zzM();
        return zzj().zzaa() || !TextUtils.isEmpty(zzj().zzA());
    }

    private final boolean zzaO(String str, String str2) {
        zzbd zzbdVarZzs = zzj().zzs(str, str2);
        return zzbdVarZzs == null || zzbdVarZzs.zzc < 1;
    }

    private final boolean zzaP(com.google.android.gms.internal.measurement.zzhl zzhlVar, com.google.android.gms.internal.measurement.zzhl zzhlVar2) {
        Preconditions.checkArgument("_e".equals(zzhlVar.zzo()));
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzhqVarZzG = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba(), "_sc");
        String strZzh = zzhqVarZzG == null ? null : zzhqVarZzG.zzh();
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzhqVarZzG2 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar2.zzba(), "_pc");
        String strZzh2 = zzhqVarZzG2 != null ? zzhqVarZzG2.zzh() : null;
        if (strZzh2 == null || !strZzh2.equals(strZzh)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhlVar.zzo()));
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzhqVarZzG3 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba(), "_et");
        if (zzhqVarZzG3 == null || !zzhqVarZzG3.zzw() || zzhqVarZzG3.zzd() <= 0) {
            return true;
        }
        long jZzd = zzhqVarZzG3.zzd();
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzhqVarZzG4 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar2.zzba(), "_et");
        if (zzhqVarZzG4 != null && zzhqVarZzG4.zzd() > 0) {
            jZzd += zzhqVarZzG4.zzd();
        }
        zzA();
        zzqa.zzD(zzhlVar2, "_et", Long.valueOf(jZzd));
        zzA();
        zzqa.zzD(zzhlVar, "_fr", 1L);
        return true;
    }

    private static final boolean zzaQ(zzr zzrVar) {
        return (TextUtils.isEmpty(zzrVar.zzb) && TextUtils.isEmpty(zzrVar.zzp)) ? false : true;
    }

    private static final zzpg zzaR(zzpg zzpgVar) {
        if (zzpgVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzpgVar.zzax()) {
            return zzpgVar;
        }
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzpgVar.getClass()))));
    }

    private static final Boolean zzaS(zzr zzrVar) {
        Boolean bool = zzrVar.zzq;
        String str = zzrVar.zzE;
        if (!TextUtils.isEmpty(str)) {
            zzju zzjuVarZzb = zze.zza(str).zzb();
            zzju zzjuVar = zzju.UNINITIALIZED;
            int iOrdinal = zzjuVarZzb.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return true;
            }
            if (iOrdinal == 3) {
                return false;
            }
        }
        return bool;
    }

    public static zzpv zzz(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpv.class) {
                if (zzb == null) {
                    zzb = new zzpv((zzpw) Preconditions.checkNotNull(new zzpw(context)), null);
                }
            }
        }
        return zzb;
    }

    public final zzqa zzA() {
        zzqa zzqaVar = this.zzi;
        zzaR(zzqaVar);
        return zzqaVar;
    }

    public final zzqf zzB() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzw();
    }

    final String zzC(zzjx zzjxVar) {
        if (!zzjxVar.zzr(zzjw.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzB().zzJ().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final String zzD(zzr zzrVar) {
        try {
            return (String) zzaX().zzf(new zzpo(this, zzrVar)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaW().zze().zzc("Failed to get app instance id. appId", zzhe.zzn(zzrVar.zza), e);
            return null;
        }
    }

    final List zzF(zzr zzrVar, Bundle bundle) {
        zzaX().zzg();
        zzqr.zzb();
        zzam zzamVarZzi = zzi();
        String str = zzrVar.zza;
        if (!zzamVarZzi.zzx(str, zzgi.zzaV) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzaW().zze().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzaw zzawVarZzj = zzj();
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzav();
                        try {
                            int iDelete = zzawVarZzj.zzj().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            zzawVarZzj.zzu.zzaW().zzj().zzd("Pruned " + iDelete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzawVarZzj.zzu.zzaW().zze().zzc("Error pruning trigger URIs. appId", zzhe.zzn(str), e);
                        }
                    }
                }
            }
        }
        zzaw zzawVarZzj2 = zzj();
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzawVarZzj2.zzg();
        zzawVarZzj2.zzav();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zzawVarZzj2.zzj().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new zzov(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e2) {
                zzawVarZzj2.zzu.zzaW().zze().zzc("Error querying trigger uris. appId", zzhe.zzn(str2), e2);
                arrayList = Collections.emptyList();
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    final void zzK(Runnable runnable) {
        zzaX().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    final void zzL() {
        zzaX().zzg();
        zzM();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzaz()) {
            FileChannel fileChannel = this.zzy;
            zzaX().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaW().zze().zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i2 = fileChannel.read(byteBufferAllocate);
                    if (i2 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                    } else if (i2 != -1) {
                        zzaW().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(i2));
                    }
                } catch (IOException e) {
                    zzaW().zze().zzb("Failed to read from channel", e);
                }
            }
            int iZzi = this.zzn.zzh().zzi();
            zzaX().zzg();
            if (i > iZzi) {
                zzaW().zze().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
                return;
            }
            if (i < iZzi) {
                FileChannel fileChannel2 = this.zzy;
                zzaX().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaW().zze().zza("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iZzi);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zze().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
                        return;
                    } catch (IOException e2) {
                        zzaW().zze().zzb("Failed to write to channel", e2);
                    }
                }
                zzaW().zze().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
            }
        }
    }

    final void zzM() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void zzN(String str, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        int iZza;
        int iIndexOf;
        Set setZzo = zzr().zzo(str);
        if (setZzo != null) {
            zzhwVar.zzl(setZzo);
        }
        if (zzr().zzB(str)) {
            zzhwVar.zzs();
        }
        if (zzr().zzE(str)) {
            String strZzaK = zzhwVar.zzaK();
            if (!TextUtils.isEmpty(strZzaK) && (iIndexOf = strZzaK.indexOf(".")) != -1) {
                zzhwVar.zzam(strZzaK.substring(0, iIndexOf));
            }
        }
        if (zzr().zzF(str) && (iZza = zzqa.zza(zzhwVar, "_id")) != -1) {
            zzhwVar.zzE(iZza);
        }
        if (zzr().zzD(str)) {
            zzhwVar.zzt();
        }
        if (zzr().zzA(str)) {
            zzhwVar.zzq();
            if (zzu(str).zzr(zzjw.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzps zzpsVar = (zzps) map.get(str);
                if (zzpsVar == null || zzpsVar.zzb + zzi().zzk(str, zzgi.zzaj) < zzaU().elapsedRealtime()) {
                    zzpsVar = new zzps(this);
                    map.put(str, zzpsVar);
                }
                zzhwVar.zzac(zzpsVar.zza);
            }
        }
        if (zzr().zzC(str)) {
            zzhwVar.zzA();
        }
    }

    final void zzO(zzh zzhVar) {
        zzaX().zzg();
        if (TextUtils.isEmpty(zzhVar.zzH()) && TextUtils.isEmpty(zzhVar.zzA())) {
            zzW((String) Preconditions.checkNotNull(zzhVar.zzC()), 204, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzC());
        zzaW().zzj().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgo zzgoVarZzj = zzr().zzj(str);
        String strZzl = zzr().zzl(str);
        ArrayMap arrayMap = null;
        if (zzgoVarZzj != null) {
            if (!TextUtils.isEmpty(strZzl)) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, strZzl);
                arrayMap = arrayMap2;
            }
            String strZzk = zzr().zzk(str);
            if (!TextUtils.isEmpty(strZzk)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put(HttpHeaders.IF_NONE_MATCH, strZzk);
            }
        }
        this.zzu = true;
        zzp().zza(zzhVar, arrayMap, new zzhg() { // from class: com.google.android.gms.measurement.internal.zzpj
            @Override // com.google.android.gms.measurement.internal.zzhg
            public final void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.zzW(str2, i, th, bArr, map);
            }
        });
    }

    final void zzP(zzr zzrVar, long j) {
        zzh zzhVarZzl = zzj().zzl((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzhVarZzl != null && zzB().zzaw(zzrVar.zzb, zzhVarZzl.zzH(), zzrVar.zzp, zzhVarZzl.zzA())) {
            zzaW().zzk().zzb("New GMP App Id passed in. Removing cached database data. appId", zzhe.zzn(zzhVarZzl.zzC()));
            zzaw zzawVarZzj = zzj();
            String strZzC = zzhVarZzl.zzC();
            zzawVarZzj.zzav();
            zzawVarZzj.zzg();
            Preconditions.checkNotEmpty(strZzC);
            try {
                SQLiteDatabase sQLiteDatabaseZzj = zzawVarZzj.zzj();
                String[] strArr = {strZzC};
                int iDelete = sQLiteDatabaseZzj.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("trigger_uris", "app_id=?", strArr);
                if (iDelete > 0) {
                    zzawVarZzj.zzu.zzaW().zzj().zzc("Deleted application data. app, records", strZzC, Integer.valueOf(iDelete));
                }
            } catch (SQLiteException e) {
                zzawVarZzj.zzu.zzaW().zze().zzc("Error deleting application data. appId, error", zzhe.zzn(strZzC), e);
            }
            zzhVarZzl = null;
        }
        if (zzhVarZzl != null) {
            boolean z = (zzhVarZzl.zze() == -2147483648L || zzhVarZzl.zze() == zzrVar.zzj) ? false : true;
            String strZzF = zzhVarZzl.zzF();
            if (z || ((zzhVarZzl.zze() != -2147483648L || strZzF == null || strZzF.equals(zzrVar.zzc)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", strZzF);
                zzbh zzbhVar = new zzbh("_au", new zzbf(bundle), "auto", j);
                if (zzi().zzx(null, zzgi.zzbm)) {
                    zzU(zzbhVar, zzrVar);
                } else {
                    zzS(zzbhVar, zzrVar);
                }
            }
        }
    }

    final void zzQ(zzh zzhVar, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        com.google.android.gms.internal.measurement.zzio zzioVar;
        zzaX().zzg();
        zzM();
        zzao zzaoVarZzb = zzao.zzb(zzhwVar.zzaH());
        String strZzC = zzhVar.zzC();
        zzaX().zzg();
        zzM();
        zzjx zzjxVarZzu = zzu(strZzC);
        zzju zzjuVar = zzju.UNINITIALIZED;
        int iOrdinal = zzjxVarZzu.zze().ordinal();
        if (iOrdinal == 1) {
            zzaoVarZzb.zzd(zzjw.AD_STORAGE, zzan.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            zzaoVarZzb.zzc(zzjw.AD_STORAGE, zzjxVarZzu.zzb());
        } else {
            zzaoVarZzb.zzd(zzjw.AD_STORAGE, zzan.FAILSAFE);
        }
        int iOrdinal2 = zzjxVarZzu.zzf().ordinal();
        if (iOrdinal2 == 1) {
            zzaoVarZzb.zzd(zzjw.ANALYTICS_STORAGE, zzan.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            zzaoVarZzb.zzc(zzjw.ANALYTICS_STORAGE, zzjxVarZzu.zzb());
        } else {
            zzaoVarZzb.zzd(zzjw.ANALYTICS_STORAGE, zzan.FAILSAFE);
        }
        String strZzC2 = zzhVar.zzC();
        zzaX().zzg();
        zzM();
        zzba zzbaVarZzl = zzl(strZzC2, zzm(strZzC2), zzu(strZzC2), zzaoVarZzb);
        zzhwVar.zzak(((Boolean) Preconditions.checkNotNull(zzbaVarZzl.zzh())).booleanValue());
        if (!TextUtils.isEmpty(zzbaVarZzl.zzi())) {
            zzhwVar.zzU(zzbaVarZzl.zzi());
        }
        zzaX().zzg();
        zzM();
        Iterator it2 = zzhwVar.zzaN().iterator();
        do {
            if (!it2.hasNext()) {
                zzioVar = null;
                break;
            }
            zzioVar = (com.google.android.gms.internal.measurement.zzio) it2.next();
        } while (!"_npa".equals(zzioVar.zzg()));
        if (zzioVar != null) {
            zzjw zzjwVar = zzjw.AD_PERSONALIZATION;
            if (zzaoVarZzb.zza(zzjwVar) == zzan.UNSET) {
                zzqd zzqdVarZzy = zzj().zzy(zzhVar.zzC(), "_npa");
                if (zzqdVarZzy != null) {
                    String str = zzqdVarZzy.zzb;
                    if ("tcf".equals(str)) {
                        zzaoVarZzb.zzd(zzjwVar, zzan.TCF);
                    } else if (SdkRemoteClientConnector.CATEGORY.equals(str)) {
                        zzaoVarZzb.zzd(zzjwVar, zzan.API);
                    } else {
                        zzaoVarZzb.zzd(zzjwVar, zzan.MANIFEST);
                    }
                } else {
                    Boolean boolZzx = zzhVar.zzx();
                    if (boolZzx == null || ((boolZzx.booleanValue() && zzioVar.zzc() != 1) || !(boolZzx.booleanValue() || zzioVar.zzc() == 0))) {
                        zzaoVarZzb.zzd(zzjwVar, zzan.API);
                    } else {
                        zzaoVarZzb.zzd(zzjwVar, zzan.MANIFEST);
                    }
                }
            }
        } else {
            int iZzaC = zzaC(zzhVar.zzC(), zzaoVarZzb);
            com.google.android.gms.internal.measurement.zzin zzinVarZze = com.google.android.gms.internal.measurement.zzio.zze();
            zzinVarZze.zzf("_npa");
            zzinVarZze.zzg(zzaU().currentTimeMillis());
            zzinVarZze.zze(iZzaC);
            zzhwVar.zzp((com.google.android.gms.internal.measurement.zzio) zzinVarZze.zzba());
            zzaW().zzj().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(iZzaC));
        }
        zzhwVar.zzS(zzaoVarZzb.toString());
        boolean zZzv = this.zzc.zzv(zzhVar.zzC());
        List listZzaM = zzhwVar.zzaM();
        int i = 0;
        for (int i2 = 0; i2 < listZzaM.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhm) listZzaM.get(i2)).zzh())) {
                com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) ((com.google.android.gms.internal.measurement.zzhm) listZzaM.get(i2)).zzch();
                List listZzp = zzhlVar.zzp();
                for (int i3 = 0; i3 < listZzp.size(); i3++) {
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhq) listZzp.get(i3)).zzg())) {
                        String strZzh = ((com.google.android.gms.internal.measurement.zzhq) listZzp.get(i3)).zzh();
                        if (zZzv && strZzh.length() > 4) {
                            char[] charArray = strZzh.toCharArray();
                            for (int i4 = 1; i4 < 64; i4++) {
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            strZzh = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhp zzhpVarZze = com.google.android.gms.internal.measurement.zzhq.zze();
                        zzhpVarZze.zzj("_tcfd");
                        zzhpVarZze.zzk(strZzh);
                        zzhlVar.zzj(i3, zzhpVarZze);
                        break;
                    }
                }
                zzhwVar.zzad(i2, zzhlVar);
                return;
            }
        }
    }

    final void zzR(com.google.android.gms.internal.measurement.zzhw zzhwVar, zzpr zzprVar) {
        for (int i = 0; i < zzhwVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzhwVar.zzh(i).zzch();
            Iterator it2 = zzhlVar.zzp().iterator();
            while (it2.hasNext()) {
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhq) it2.next()).zzg())) {
                    if (zzprVar.zza.zza() >= zzi().zzh(zzprVar.zza.zzF(), zzgi.zzak)) {
                        int iZzh = zzi().zzh(zzprVar.zza.zzF(), zzgi.zzax);
                        String strZzF = null;
                        if (iZzh <= 0) {
                            if (zzi().zzx(zzprVar.zza.zzF(), zzgi.zzaX)) {
                                strZzF = zzB().zzF();
                                com.google.android.gms.internal.measurement.zzhp zzhpVarZze = com.google.android.gms.internal.measurement.zzhq.zze();
                                zzhpVarZze.zzj("_tu");
                                zzhpVarZze.zzk(strZzF);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze.zzba());
                            }
                            com.google.android.gms.internal.measurement.zzhp zzhpVarZze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zzhpVarZze2.zzj("_tr");
                            zzhpVarZze2.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze2.zzba());
                            zzov zzovVarZzl = zzA().zzl(zzprVar.zza.zzF(), zzhwVar, zzhlVar, strZzF);
                            if (zzovVarZzl != null) {
                                zzaW().zzj().zzc("Generated trigger URI. appId, uri", zzprVar.zza.zzF(), zzovVarZzl.zza);
                                zzj().zzad(zzprVar.zza.zzF(), zzovVarZzl);
                                Deque deque = this.zzr;
                                if (!deque.contains(zzprVar.zza.zzF())) {
                                    deque.add(zzprVar.zza.zzF());
                                }
                            }
                        } else if (zzj().zzo(zza(), zzprVar.zza.zzF(), false, false, false, false, false, false, true).zzg > iZzh) {
                            com.google.android.gms.internal.measurement.zzhp zzhpVarZze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zzhpVarZze3.zzj("_tnr");
                            zzhpVarZze3.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze3.zzba());
                        } else {
                            if (zzi().zzx(zzprVar.zza.zzF(), zzgi.zzaX)) {
                                strZzF = zzB().zzF();
                                com.google.android.gms.internal.measurement.zzhp zzhpVarZze4 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zzhpVarZze4.zzj("_tu");
                                zzhpVarZze4.zzk(strZzF);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze4.zzba());
                            }
                            com.google.android.gms.internal.measurement.zzhp zzhpVarZze5 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zzhpVarZze5.zzj("_tr");
                            zzhpVarZze5.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze5.zzba());
                            zzov zzovVarZzl2 = zzA().zzl(zzprVar.zza.zzF(), zzhwVar, zzhlVar, strZzF);
                            if (zzovVarZzl2 != null) {
                                zzaW().zzj().zzc("Generated trigger URI. appId, uri", zzprVar.zza.zzF(), zzovVarZzl2.zza);
                                zzj().zzad(zzprVar.zza.zzF(), zzovVarZzl2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzprVar.zza.zzF())) {
                                    deque2.add(zzprVar.zza.zzF());
                                }
                            }
                        }
                    }
                    zzhwVar.zzae(i, (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba());
                    break;
                }
            }
        }
    }

    final void zzS(zzbh zzbhVar, zzr zzrVar) {
        zzbh zzbhVar2;
        List<zzai> listZzC;
        List<zzai> listZzC2;
        List<zzai> listZzC3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        zzM();
        long j = zzbhVar.zzd;
        zzhf zzhfVarZzb = zzhf.zzb(zzbhVar);
        zzaX().zzg();
        zzqf.zzN((this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) ? null : this.zzG, zzhfVarZzb.zzd, false);
        zzbh zzbhVarZza = zzhfVarZzb.zza();
        zzA();
        if (zzqa.zzE(zzbhVarZza, zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            List list = zzrVar.zzs;
            if (list != null) {
                String str3 = zzbhVarZza.zza;
                if (!list.contains(str3)) {
                    zzaW().zzd().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zzbhVarZza.zza, zzbhVarZza.zzc);
                    return;
                } else {
                    Bundle bundleZzc = zzbhVarZza.zzb.zzc();
                    bundleZzc.putLong("ga_safelisted", 1L);
                    zzbhVar2 = new zzbh(str3, new zzbf(bundleZzc), zzbhVarZza.zzc, zzbhVarZza.zzd);
                }
            } else {
                zzbhVar2 = zzbhVarZza;
            }
            zzj().zzH();
            try {
                zzra.zzb();
                if (zzi().zzx(null, zzgi.zzbi) && "_s".equals(zzbhVar2.zza) && !zzj().zzZ(str2, "_s") && zzbhVar2.zzb.zze("_sid").longValue() != 0) {
                    if (zzj().zzZ(str2, "_f") || zzj().zzZ(str2, "_v")) {
                        zzj().zzG(str2, null, "_sid", zzf(str2, zzbhVar2));
                    } else {
                        zzj().zzG(str2, Long.valueOf(zzaU().currentTimeMillis() - 15000), "_sid", zzf(str2, zzbhVar2));
                    }
                }
                zzaw zzawVarZzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzawVarZzj.zzg();
                zzawVarZzj.zzav();
                if (j < 0) {
                    zzawVarZzj.zzu.zzaW().zzk().zzc("Invalid time querying timed out conditional properties", zzhe.zzn(str2), Long.valueOf(j));
                    listZzC = Collections.emptyList();
                } else {
                    listZzC = zzawVarZzj.zzC("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzai zzaiVar : listZzC) {
                    if (zzaiVar != null) {
                        zzaW().zzj().zzd("User property timed out", zzaiVar.zza, this.zzn.zzj().zzf(zzaiVar.zzc.zzb), zzaiVar.zzc.zza());
                        zzbh zzbhVar3 = zzaiVar.zzg;
                        if (zzbhVar3 != null) {
                            zzax(new zzbh(zzbhVar3, j), zzrVar);
                        }
                        zzj().zza(str2, zzaiVar.zzc.zzb);
                    }
                }
                zzaw zzawVarZzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzawVarZzj2.zzg();
                zzawVarZzj2.zzav();
                if (j < 0) {
                    zzawVarZzj2.zzu.zzaW().zzk().zzc("Invalid time querying expired conditional properties", zzhe.zzn(str2), Long.valueOf(j));
                    listZzC2 = Collections.emptyList();
                } else {
                    listZzC2 = zzawVarZzj2.zzC("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listZzC2.size());
                for (zzai zzaiVar2 : listZzC2) {
                    if (zzaiVar2 != null) {
                        zzaW().zzj().zzd("User property expired", zzaiVar2.zza, this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                        zzj().zzP(str2, zzaiVar2.zzc.zzb);
                        zzbh zzbhVar4 = zzaiVar2.zzk;
                        if (zzbhVar4 != null) {
                            arrayList.add(zzbhVar4);
                        }
                        zzj().zza(str2, zzaiVar2.zzc.zzb);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    zzax(new zzbh((zzbh) it2.next(), j), zzrVar);
                }
                zzaw zzawVarZzj3 = zzj();
                String str4 = zzbhVar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzawVarZzj3.zzg();
                zzawVarZzj3.zzav();
                if (j < 0) {
                    zzio zzioVar = zzawVarZzj3.zzu;
                    zzioVar.zzaW().zzk().zzd("Invalid time querying triggered conditional properties", zzhe.zzn(str2), zzioVar.zzj().zzd(str4), Long.valueOf(j));
                    listZzC3 = Collections.emptyList();
                } else {
                    listZzC3 = zzawVarZzj3.zzC("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(listZzC3.size());
                for (zzai zzaiVar3 : listZzC3) {
                    if (zzaiVar3 != null) {
                        zzqb zzqbVar = zzaiVar3.zzc;
                        zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(zzaiVar3.zza), zzaiVar3.zzb, zzqbVar.zzb, j, Preconditions.checkNotNull(zzqbVar.zza()));
                        if (zzj().zzai(zzqdVar)) {
                            zzaW().zzj().zzd("User property triggered", zzaiVar3.zza, this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                        } else {
                            zzaW().zze().zzd("Too many active user properties, ignoring", zzhe.zzn(zzaiVar3.zza), this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                        }
                        zzbh zzbhVar5 = zzaiVar3.zzi;
                        if (zzbhVar5 != null) {
                            arrayList2.add(zzbhVar5);
                        }
                        zzaiVar3.zzc = new zzqb(zzqdVar);
                        zzaiVar3.zze = true;
                        zzj().zzah(zzaiVar3);
                    }
                }
                zzax(zzbhVar2, zzrVar);
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    zzax(new zzbh((zzbh) it3.next(), j), zzrVar);
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzT(zzbh zzbhVar, String str) {
        zzh zzhVarZzl = zzj().zzl(str);
        if (zzhVarZzl == null || TextUtils.isEmpty(zzhVarZzl.zzF())) {
            zzaW().zzd().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzaF = zzaF(zzhVarZzl);
        if (boolZzaF == null) {
            if (!"_ui".equals(zzbhVar.zza)) {
                zzaW().zzk().zzb("Could not find package. appId", zzhe.zzn(str));
            }
        } else if (!boolZzaF.booleanValue()) {
            zzaW().zze().zzb("App version does not match; dropping event. appId", zzhe.zzn(str));
            return;
        }
        zzU(zzbhVar, new zzr(str, zzhVarZzl.zzH(), zzhVarZzl.zzF(), zzhVarZzl.zze(), zzhVarZzl.zzE(), zzhVarZzl.zzq(), zzhVarZzl.zzn(), (String) null, zzhVarZzl.zzaJ(), false, zzhVarZzl.zzG(), 0L, 0, zzhVarZzl.zzaI(), false, zzhVarZzl.zzA(), zzhVarZzl.zzx(), zzhVarZzl.zzo(), zzhVarZzl.zzN(), (String) null, zzu(str).zzq(), "", (String) null, zzhVarZzl.zzaL(), zzhVarZzl.zzw(), zzu(str).zzb(), zzm(str).zzj(), zzhVarZzl.zza(), zzhVarZzl.zzf(), zzhVarZzl.zzM(), zzhVarZzl.zzK(), 0L, zzhVarZzl.zzb()));
    }

    final void zzU(zzbh zzbhVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzhf zzhfVarZzb = zzhf.zzb(zzbhVar);
        zzB().zzO(zzhfVarZzb.zzd, zzj().zzk(str));
        zzB().zzQ(zzhfVarZzb, zzi().zzf(str));
        zzbh zzbhVarZza = zzhfVarZzb.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbhVarZza.zza)) {
            zzbf zzbfVar = zzbhVarZza.zzb;
            if ("referrer API v2".equals(zzbfVar.zzg("_cis"))) {
                String strZzg = zzbfVar.zzg("gclid");
                if (!TextUtils.isEmpty(strZzg)) {
                    zzas(new zzqb("_lgclid", zzbhVarZza.zzd, strZzg, "auto"), zzrVar);
                }
            }
        }
        zzS(zzbhVarZza, zzrVar);
    }

    final void zzV() {
        this.zzt++;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0042  */
    /* JADX WARN: Code duplicated, block: B:14:0x0044 A[PHI: r8
      0x0044: PHI (r8v13 int) = (r8v2 int), (r8v0 int) binds: [B:12:0x0040, B:10:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    final void zzW(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzaH();
                throw th2;
            }
        }
        zzhc zzhcVarZzj = zzaW().zzj();
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzhcVarZzj.zzb("onConfigFetched. Response size", numValueOf);
        zzj().zzH();
        try {
            zzh zzhVarZzl = zzj().zzl(str);
            if (i == 200 || i == 204) {
                if (th == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (i == 304) {
                i = 304;
                if (th == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (zzhVarZzl == null) {
                zzaW().zzk().zzb("App does not exist in onConfigFetched. appId", zzhe.zzn(str));
            } else if (z || i == 404) {
                String strZzaG = zzaG(map, HttpHeaders.LAST_MODIFIED);
                String strZzaG2 = zzaG(map, HttpHeaders.ETAG);
                if (i != 404 && i != 304) {
                    zzr().zzz(str, bArr, strZzaG, strZzaG2);
                } else if (zzr().zzj(str) == null) {
                    zzr().zzz(str, null, null, null);
                }
                zzhVarZzl.zzab(zzaU().currentTimeMillis());
                zzj().zzT(zzhVarZzl, false, false);
                if (i == 404) {
                    zzaW().zzl().zzb("Config not found. Using empty config. appId", str);
                } else {
                    zzaW().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), numValueOf);
                }
                if (zzp().zzd() && zzaN()) {
                    zzat();
                } else if (zzi().zzx(null, zzgi.zzaM) && zzp().zzd() && zzj().zzY(zzhVarZzl.zzC())) {
                    zzav(zzhVarZzl.zzC());
                } else {
                    zzaL();
                }
            } else {
                zzhVarZzl.zzam(zzaU().currentTimeMillis());
                zzj().zzT(zzhVarZzl, false, false);
                zzaW().zzj().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzr().zzq(str);
                this.zzk.zze.zzb(zzaU().currentTimeMillis());
                if (i == 503 || i == 429) {
                    this.zzk.zzc.zzb(zzaU().currentTimeMillis());
                }
                zzaL();
            }
            zzj().zzS();
            zzj().zzL();
            this.zzu = false;
            zzaH();
        } catch (Throwable th3) {
            zzj().zzL();
            throw th3;
        }
    }

    final void zzX(boolean z) {
        zzaL();
    }

    /* JADX WARN: Code duplicated, block: B:107:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x016a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x018f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x021b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x021a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x008b A[Catch: all -> 0x02cd, PHI: r0
      0x008b: PHI (r0v2 int) = (r0v0 int), (r0v36 int) binds: [B:7:0x0026, B:13:0x0031] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {all -> 0x02cd, blocks: (B:4:0x0015, B:6:0x001a, B:14:0x0033, B:19:0x007f, B:18:0x0070, B:20:0x008b, B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:78:0x0248, B:80:0x025d, B:82:0x0267, B:84:0x0271, B:91:0x028e, B:85:0x0275, B:87:0x027f, B:89:0x0285, B:90:0x0289, B:93:0x0294, B:94:0x029b, B:26:0x00d2, B:96:0x029d), top: B:108:0x0015, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00bf A[Catch: SQLiteException -> 0x029c, all -> 0x02cd, TryCatch #3 {SQLiteException -> 0x029c, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:78:0x0248, B:80:0x025d, B:82:0x0267, B:84:0x0271, B:91:0x028e, B:85:0x0275, B:87:0x027f, B:89:0x0285, B:90:0x0289, B:93:0x0294, B:94:0x029b, B:26:0x00d2), top: B:107:0x00a2, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00d2 A[Catch: SQLiteException -> 0x029c, all -> 0x02cd, TryCatch #3 {SQLiteException -> 0x029c, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:78:0x0248, B:80:0x025d, B:82:0x0267, B:84:0x0271, B:91:0x028e, B:85:0x0275, B:87:0x027f, B:89:0x0285, B:90:0x0289, B:93:0x0294, B:94:0x029b, B:26:0x00d2), top: B:107:0x00a2, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00f4 A[Catch: all -> 0x0293, TryCatch #0 {all -> 0x0293, blocks: (B:28:0x00e6, B:30:0x00f4, B:32:0x0100, B:33:0x0109, B:35:0x010f, B:37:0x0129, B:41:0x0154, B:43:0x015e, B:46:0x016d, B:47:0x0172, B:49:0x0178, B:51:0x018f, B:57:0x01e4, B:58:0x01e8, B:60:0x01ee, B:61:0x01f5, B:62:0x020f, B:65:0x021b, B:66:0x0222, B:68:0x0224, B:69:0x0233, B:71:0x0235, B:73:0x0239, B:76:0x0240, B:77:0x0241, B:52:0x01b1, B:53:0x01b6, B:55:0x01bc), top: B:102:0x00e6, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0100 A[Catch: all -> 0x0293, TryCatch #0 {all -> 0x0293, blocks: (B:28:0x00e6, B:30:0x00f4, B:32:0x0100, B:33:0x0109, B:35:0x010f, B:37:0x0129, B:41:0x0154, B:43:0x015e, B:46:0x016d, B:47:0x0172, B:49:0x0178, B:51:0x018f, B:57:0x01e4, B:58:0x01e8, B:60:0x01ee, B:61:0x01f5, B:62:0x020f, B:65:0x021b, B:66:0x0222, B:68:0x0224, B:69:0x0233, B:71:0x0235, B:73:0x0239, B:76:0x0240, B:77:0x0241, B:52:0x01b1, B:53:0x01b6, B:55:0x01bc), top: B:102:0x00e6, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x010f A[Catch: all -> 0x0293, TryCatch #0 {all -> 0x0293, blocks: (B:28:0x00e6, B:30:0x00f4, B:32:0x0100, B:33:0x0109, B:35:0x010f, B:37:0x0129, B:41:0x0154, B:43:0x015e, B:46:0x016d, B:47:0x0172, B:49:0x0178, B:51:0x018f, B:57:0x01e4, B:58:0x01e8, B:60:0x01ee, B:61:0x01f5, B:62:0x020f, B:65:0x021b, B:66:0x0222, B:68:0x0224, B:69:0x0233, B:71:0x0235, B:73:0x0239, B:76:0x0240, B:77:0x0241, B:52:0x01b1, B:53:0x01b6, B:55:0x01bc), top: B:102:0x00e6, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0129 A[Catch: all -> 0x0293, TryCatch #0 {all -> 0x0293, blocks: (B:28:0x00e6, B:30:0x00f4, B:32:0x0100, B:33:0x0109, B:35:0x010f, B:37:0x0129, B:41:0x0154, B:43:0x015e, B:46:0x016d, B:47:0x0172, B:49:0x0178, B:51:0x018f, B:57:0x01e4, B:58:0x01e8, B:60:0x01ee, B:61:0x01f5, B:62:0x020f, B:65:0x021b, B:66:0x0222, B:68:0x0224, B:69:0x0233, B:71:0x0235, B:73:0x0239, B:76:0x0240, B:77:0x0241, B:52:0x01b1, B:53:0x01b6, B:55:0x01bc), top: B:102:0x00e6, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0150  */
    /* JADX WARN: Code duplicated, block: B:49:0x0178 A[Catch: all -> 0x0293, TryCatch #0 {all -> 0x0293, blocks: (B:28:0x00e6, B:30:0x00f4, B:32:0x0100, B:33:0x0109, B:35:0x010f, B:37:0x0129, B:41:0x0154, B:43:0x015e, B:46:0x016d, B:47:0x0172, B:49:0x0178, B:51:0x018f, B:57:0x01e4, B:58:0x01e8, B:60:0x01ee, B:61:0x01f5, B:62:0x020f, B:65:0x021b, B:66:0x0222, B:68:0x0224, B:69:0x0233, B:71:0x0235, B:73:0x0239, B:76:0x0240, B:77:0x0241, B:52:0x01b1, B:53:0x01b6, B:55:0x01bc), top: B:102:0x00e6, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01b1 A[Catch: all -> 0x0293, TryCatch #0 {all -> 0x0293, blocks: (B:28:0x00e6, B:30:0x00f4, B:32:0x0100, B:33:0x0109, B:35:0x010f, B:37:0x0129, B:41:0x0154, B:43:0x015e, B:46:0x016d, B:47:0x0172, B:49:0x0178, B:51:0x018f, B:57:0x01e4, B:58:0x01e8, B:60:0x01ee, B:61:0x01f5, B:62:0x020f, B:65:0x021b, B:66:0x0222, B:68:0x0224, B:69:0x0233, B:71:0x0235, B:73:0x0239, B:76:0x0240, B:77:0x0241, B:52:0x01b1, B:53:0x01b6, B:55:0x01bc), top: B:102:0x00e6, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01bc A[Catch: all -> 0x0293, LOOP:3: B:53:0x01b6->B:55:0x01bc, LOOP_END, TryCatch #0 {all -> 0x0293, blocks: (B:28:0x00e6, B:30:0x00f4, B:32:0x0100, B:33:0x0109, B:35:0x010f, B:37:0x0129, B:41:0x0154, B:43:0x015e, B:46:0x016d, B:47:0x0172, B:49:0x0178, B:51:0x018f, B:57:0x01e4, B:58:0x01e8, B:60:0x01ee, B:61:0x01f5, B:62:0x020f, B:65:0x021b, B:66:0x0222, B:68:0x0224, B:69:0x0233, B:71:0x0235, B:73:0x0239, B:76:0x0240, B:77:0x0241, B:52:0x01b1, B:53:0x01b6, B:55:0x01bc), top: B:102:0x00e6, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:60:0x01ee A[Catch: all -> 0x0293, TRY_LEAVE, TryCatch #0 {all -> 0x0293, blocks: (B:28:0x00e6, B:30:0x00f4, B:32:0x0100, B:33:0x0109, B:35:0x010f, B:37:0x0129, B:41:0x0154, B:43:0x015e, B:46:0x016d, B:47:0x0172, B:49:0x0178, B:51:0x018f, B:57:0x01e4, B:58:0x01e8, B:60:0x01ee, B:61:0x01f5, B:62:0x020f, B:65:0x021b, B:66:0x0222, B:68:0x0224, B:69:0x0233, B:71:0x0235, B:73:0x0239, B:76:0x0240, B:77:0x0241, B:52:0x01b1, B:53:0x01b6, B:55:0x01bc), top: B:102:0x00e6, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x025d A[Catch: SQLiteException -> 0x029c, all -> 0x02cd, TryCatch #3 {SQLiteException -> 0x029c, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:78:0x0248, B:80:0x025d, B:82:0x0267, B:84:0x0271, B:91:0x028e, B:85:0x0275, B:87:0x027f, B:89:0x0285, B:90:0x0289, B:93:0x0294, B:94:0x029b, B:26:0x00d2), top: B:107:0x00a2, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0275 A[Catch: SQLiteException -> 0x029c, all -> 0x02cd, TryCatch #3 {SQLiteException -> 0x029c, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:78:0x0248, B:80:0x025d, B:82:0x0267, B:84:0x0271, B:91:0x028e, B:85:0x0275, B:87:0x027f, B:89:0x0285, B:90:0x0289, B:93:0x0294, B:94:0x029b, B:26:0x00d2), top: B:107:0x00a2, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x027f A[Catch: SQLiteException -> 0x029c, all -> 0x02cd, TryCatch #3 {SQLiteException -> 0x029c, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:78:0x0248, B:80:0x025d, B:82:0x0267, B:84:0x0271, B:91:0x028e, B:85:0x0275, B:87:0x027f, B:89:0x0285, B:90:0x0289, B:93:0x0294, B:94:0x029b, B:26:0x00d2), top: B:107:0x00a2, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0289 A[Catch: SQLiteException -> 0x029c, all -> 0x02cd, TryCatch #3 {SQLiteException -> 0x029c, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:78:0x0248, B:80:0x025d, B:82:0x0267, B:84:0x0271, B:91:0x028e, B:85:0x0275, B:87:0x027f, B:89:0x0285, B:90:0x0289, B:93:0x0294, B:94:0x029b, B:26:0x00d2), top: B:107:0x00a2, outer: #4 }] */
    final void zzY(boolean z, int i, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        Integer numValueOf;
        long j;
        long j2;
        zzaw zzawVarZzj;
        long jLongValue;
        Iterator it2;
        HashMap map;
        Iterator it3;
        Iterator it4;
        com.google.android.gms.internal.measurement.zzhv zzhvVar;
        zzph zzphVar;
        com.google.android.gms.internal.measurement.zzhv zzhvVar2;
        zzph zzphVar2;
        long jZzd;
        int i2 = i;
        zzaX().zzg();
        zzM();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaH();
                throw th2;
            }
        } else {
            bArr2 = bArr;
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        if (z) {
            if (i2 == 200) {
                if (th != null) {
                    zzhc zzhcVarZzj = zzaW().zzj();
                    numValueOf = Integer.valueOf(i2);
                    zzhcVarZzj.zzc("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
                    if (z) {
                        this.zzk.zzd.zzb(zzaU().currentTimeMillis());
                    }
                    this.zzk.zze.zzb(0L);
                    zzaL();
                    if (z) {
                        zzaW().zzj().zzc("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
                    } else {
                        zzaW().zzj().zza("Purged empty bundles");
                    }
                    zzj().zzH();
                    j = -1;
                    if (!zzi().zzx(null, zzgi.zzaM)) {
                        j2 = -1;
                    } else if (zzi().zzx(null, zzgi.zzaP)) {
                        map = new HashMap();
                        it3 = list.iterator();
                        while (it3.hasNext()) {
                            Pair pair = (Pair) it3.next();
                            zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) pair.first;
                            zzphVar2 = (zzph) pair.second;
                            if (zzphVar2.zza() != zzmf.SGTM_CLIENT) {
                                long j3 = j;
                                jZzd = zzj().zzd(str, zzhvVar2, zzphVar2.zzc(), zzphVar2.zzd(), zzphVar2.zza(), null);
                                if (zzphVar2.zza() == zzmf.GOOGLE_SIGNAL_PENDING) {
                                    map.put(zzhvVar2.zzf(), Long.valueOf(jZzd));
                                }
                                j = j3;
                            }
                        }
                        j2 = j;
                        it4 = list.iterator();
                        while (it4.hasNext()) {
                            Pair pair2 = (Pair) it4.next();
                            zzhvVar = (com.google.android.gms.internal.measurement.zzhv) pair2.first;
                            zzphVar = (zzph) pair2.second;
                            if (zzphVar.zza() == zzmf.SGTM_CLIENT) {
                                zzj().zzd(str, zzhvVar, zzphVar.zzc(), zzphVar.zzd(), zzphVar.zza(), (Long) map.get(zzhvVar.zzf()));
                            }
                        }
                    } else {
                        j2 = -1;
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            Pair pair3 = (Pair) it2.next();
                            com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) pair3.first;
                            zzph zzphVar3 = (zzph) pair3.second;
                            zzj().zzd(str, zzhvVar3, zzphVar3.zzc(), zzphVar3.zzd(), zzphVar3.zza(), null);
                        }
                    }
                    for (Long l : list2) {
                        zzawVarZzj = zzj();
                        jLongValue = l.longValue();
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzav();
                        if (zzawVarZzj.zzj().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    zzj().zzS();
                    zzj().zzL();
                    this.zzA = null;
                    if (!zzi().zzx(null, zzgi.zzaM)) {
                        if (zzp().zzd()) {
                            this.zzB = j2;
                            zzaL();
                        } else {
                            this.zzB = j2;
                            zzaL();
                        }
                    } else if (zzp().zzd()) {
                        this.zzB = j2;
                        zzaL();
                    } else {
                        this.zzB = j2;
                        zzaL();
                    }
                    this.zza = 0L;
                }
            } else if (i2 == 204) {
                i2 = 204;
                if (th != null) {
                    zzhc zzhcVarZzj2 = zzaW().zzj();
                    numValueOf = Integer.valueOf(i2);
                    zzhcVarZzj2.zzc("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
                    if (z) {
                        this.zzk.zzd.zzb(zzaU().currentTimeMillis());
                    }
                    this.zzk.zze.zzb(0L);
                    zzaL();
                    if (z) {
                        zzaW().zzj().zzc("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
                    } else {
                        zzaW().zzj().zza("Purged empty bundles");
                    }
                    zzj().zzH();
                    j = -1;
                    if (!zzi().zzx(null, zzgi.zzaM)) {
                        j2 = -1;
                    } else if (zzi().zzx(null, zzgi.zzaP)) {
                        map = new HashMap();
                        it3 = list.iterator();
                        while (it3.hasNext()) {
                            Pair pair4 = (Pair) it3.next();
                            zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) pair4.first;
                            zzphVar2 = (zzph) pair4.second;
                            if (zzphVar2.zza() != zzmf.SGTM_CLIENT) {
                                long j4 = j;
                                jZzd = zzj().zzd(str, zzhvVar2, zzphVar2.zzc(), zzphVar2.zzd(), zzphVar2.zza(), null);
                                if (zzphVar2.zza() == zzmf.GOOGLE_SIGNAL_PENDING) {
                                    map.put(zzhvVar2.zzf(), Long.valueOf(jZzd));
                                }
                                j = j4;
                            }
                        }
                        j2 = j;
                        it4 = list.iterator();
                        while (it4.hasNext()) {
                            Pair pair5 = (Pair) it4.next();
                            zzhvVar = (com.google.android.gms.internal.measurement.zzhv) pair5.first;
                            zzphVar = (zzph) pair5.second;
                            if (zzphVar.zza() == zzmf.SGTM_CLIENT) {
                                zzj().zzd(str, zzhvVar, zzphVar.zzc(), zzphVar.zzd(), zzphVar.zza(), (Long) map.get(zzhvVar.zzf()));
                            }
                        }
                    } else {
                        j2 = -1;
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            Pair pair6 = (Pair) it2.next();
                            com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) pair6.first;
                            zzph zzphVar4 = (zzph) pair6.second;
                            zzj().zzd(str, zzhvVar4, zzphVar4.zzc(), zzphVar4.zzd(), zzphVar4.zza(), null);
                        }
                    }
                    while (r2.hasNext()) {
                        zzawVarZzj = zzj();
                        jLongValue = l.longValue();
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzav();
                        if (zzawVarZzj.zzj().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    zzj().zzS();
                    zzj().zzL();
                    this.zzA = null;
                    if (!zzi().zzx(null, zzgi.zzaM)) {
                        if (zzp().zzd()) {
                            this.zzB = j2;
                            zzaL();
                        } else {
                            this.zzB = j2;
                            zzaL();
                        }
                    } else if (zzp().zzd()) {
                        this.zzB = j2;
                        zzaL();
                    } else {
                        this.zzB = j2;
                        zzaL();
                    }
                    this.zza = 0L;
                }
            }
            String str2 = new String(bArr2, StandardCharsets.UTF_8);
            zzaW().zzl().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str2.substring(0, Math.min(32, str2.length())));
            this.zzk.zze.zzb(zzaU().currentTimeMillis());
            if (i2 == 503 || i2 == 429) {
                this.zzk.zzc.zzb(zzaU().currentTimeMillis());
            }
            zzj().zzM(list2);
            zzaL();
        } else {
            zzhc zzhcVarZzj3 = zzaW().zzj();
            numValueOf = Integer.valueOf(i2);
            zzhcVarZzj3.zzc("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
            if (z) {
                try {
                    this.zzk.zzd.zzb(zzaU().currentTimeMillis());
                } catch (SQLiteException e) {
                    zzaW().zze().zzb("Database error while trying to delete uploaded bundles", e);
                    this.zza = zzaU().elapsedRealtime();
                    zzaW().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
                }
            }
            this.zzk.zze.zzb(0L);
            zzaL();
            if (z) {
                zzaW().zzj().zzc("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
            } else {
                zzaW().zzj().zza("Purged empty bundles");
            }
            zzj().zzH();
            try {
                j = -1;
                if (!zzi().zzx(null, zzgi.zzaM)) {
                    j2 = -1;
                } else if (zzi().zzx(null, zzgi.zzaP)) {
                    map = new HashMap();
                    it3 = list.iterator();
                    while (it3.hasNext()) {
                        Pair pair7 = (Pair) it3.next();
                        zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) pair7.first;
                        zzphVar2 = (zzph) pair7.second;
                        if (zzphVar2.zza() != zzmf.SGTM_CLIENT) {
                            long j5 = j;
                            jZzd = zzj().zzd(str, zzhvVar2, zzphVar2.zzc(), zzphVar2.zzd(), zzphVar2.zza(), null);
                            if (zzphVar2.zza() == zzmf.GOOGLE_SIGNAL_PENDING && jZzd != j5 && !zzhvVar2.zzf().isEmpty()) {
                                map.put(zzhvVar2.zzf(), Long.valueOf(jZzd));
                            }
                            j = j5;
                        }
                    }
                    j2 = j;
                    it4 = list.iterator();
                    while (it4.hasNext()) {
                        Pair pair8 = (Pair) it4.next();
                        zzhvVar = (com.google.android.gms.internal.measurement.zzhv) pair8.first;
                        zzphVar = (zzph) pair8.second;
                        if (zzphVar.zza() == zzmf.SGTM_CLIENT) {
                            zzj().zzd(str, zzhvVar, zzphVar.zzc(), zzphVar.zzd(), zzphVar.zza(), (Long) map.get(zzhvVar.zzf()));
                        }
                    }
                } else {
                    j2 = -1;
                    it2 = list.iterator();
                    while (it2.hasNext()) {
                        Pair pair9 = (Pair) it2.next();
                        com.google.android.gms.internal.measurement.zzhv zzhvVar5 = (com.google.android.gms.internal.measurement.zzhv) pair9.first;
                        zzph zzphVar5 = (zzph) pair9.second;
                        zzj().zzd(str, zzhvVar5, zzphVar5.zzc(), zzphVar5.zzd(), zzphVar5.zza(), null);
                    }
                }
                while (r2.hasNext()) {
                    try {
                        zzawVarZzj = zzj();
                        jLongValue = l.longValue();
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzav();
                        try {
                            if (zzawVarZzj.zzj().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e2) {
                            zzawVarZzj.zzu.zzaW().zze().zzb("Failed to delete a bundle in a queue table", e2);
                            throw e2;
                        }
                    } catch (SQLiteException e3) {
                        List list3 = this.zzA;
                        if (list3 == null || !list3.contains(l)) {
                            throw e3;
                        }
                    }
                }
                zzj().zzS();
                zzj().zzL();
                this.zzA = null;
                if (!zzi().zzx(null, zzgi.zzaM) && zzp().zzd() && zzj().zzY(str)) {
                    zzav(str);
                } else if (zzp().zzd() || !zzaN()) {
                    this.zzB = j2;
                    zzaL();
                } else {
                    zzat();
                }
                this.zza = 0L;
            } catch (Throwable th3) {
                zzj().zzL();
                throw th3;
            }
        }
        this.zzv = false;
        zzaH();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001e A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:21:0x0067, B:24:0x008d, B:13:0x001e, B:15:0x004b, B:17:0x0055, B:19:0x005f, B:20:0x0063), top: B:29:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0063 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:21:0x0067, B:24:0x008d, B:13:0x001e, B:15:0x004b, B:17:0x0055, B:19:0x005f, B:20:0x0063), top: B:29:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0067 A[Catch: all -> 0x0010, PHI: r5
      0x0067: PHI (r5v9 int) = (r5v1 int), (r5v0 int) binds: [B:12:0x001c, B:10:0x0019] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:21:0x0067, B:24:0x008d, B:13:0x001e, B:15:0x004b, B:17:0x0055, B:19:0x005f, B:20:0x0063), top: B:29:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:23:0x008c  */
    final void zzZ(String str, int i, Throwable th, byte[] bArr, zzpz zzpzVar) {
        String strSubstring;
        Object obj;
        zzaX().zzg();
        zzM();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzv = false;
                zzaH();
            }
        }
        if (i == 200) {
            if (th == null) {
                zzj().zzK(Long.valueOf(zzpzVar.zzc()));
                zzaW().zzj().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
                if (!zzi().zzx(null, zzgi.zzaM) && zzp().zzd() && zzj().zzY(str)) {
                    zzav(str);
                } else {
                    zzaL();
                }
            } else {
                String str2 = new String(bArr, StandardCharsets.UTF_8);
                strSubstring = str2.substring(0, Math.min(32, str2.length()));
                zzhc zzhcVarZzl = zzaW().zzl();
                Integer numValueOf = Integer.valueOf(i);
                obj = th;
                if (th == null) {
                    obj = strSubstring;
                }
                zzhcVarZzl.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf, obj);
                zzj().zzN(Long.valueOf(zzpzVar.zzc()));
                zzaL();
            }
        } else if (i == 204) {
            i = 204;
            if (th == null) {
                zzj().zzK(Long.valueOf(zzpzVar.zzc()));
                zzaW().zzj().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
                if (!zzi().zzx(null, zzgi.zzaM)) {
                    zzaL();
                } else {
                    zzaL();
                }
            } else {
                String str3 = new String(bArr, StandardCharsets.UTF_8);
                strSubstring = str3.substring(0, Math.min(32, str3.length()));
                zzhc zzhcVarZzl2 = zzaW().zzl();
                Integer numValueOf2 = Integer.valueOf(i);
                obj = th;
                if (th == null) {
                    obj = strSubstring;
                }
                zzhcVarZzl2.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf2, obj);
                zzj().zzN(Long.valueOf(zzpzVar.zzc()));
                zzaL();
            }
        } else {
            String str4 = new String(bArr, StandardCharsets.UTF_8);
            strSubstring = str4.substring(0, Math.min(32, str4.length()));
            zzhc zzhcVarZzl3 = zzaW().zzl();
            Integer numValueOf3 = Integer.valueOf(i);
            obj = th;
            if (th == null) {
                obj = strSubstring;
            }
            zzhcVarZzl3.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf3, obj);
            zzj().zzN(Long.valueOf(zzpzVar.zzc()));
            zzaL();
        }
    }

    final long zza() {
        long jCurrentTimeMillis = zzaU().currentTimeMillis();
        zzoa zzoaVar = this.zzk;
        zzoaVar.zzav();
        zzoaVar.zzg();
        zzhp zzhpVar = zzoaVar.zzf;
        long jZza = zzhpVar.zza();
        if (jZza == 0) {
            jZza = ((long) zzoaVar.zzu.zzw().zzJ().nextInt(DateTimeConstants.MILLIS_PER_DAY)) + 1;
            zzhpVar.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final Context zzaT() {
        return this.zzn.zzaT();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final Clock zzaU() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaU();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzaf zzaV() {
        return this.zzn.zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzhe zzaW() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzil zzaX() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaX();
    }

    final void zzaa(zzh zzhVar, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        zzaX().zzg();
        zzM();
        com.google.android.gms.internal.measurement.zzhb zzhbVarZzc = com.google.android.gms.internal.measurement.zzhc.zzc();
        byte[] bArrZzaN = zzhVar.zzaN();
        if (bArrZzaN != null) {
            try {
                zzhbVarZzc = (com.google.android.gms.internal.measurement.zzhb) zzqa.zzp(zzhbVarZzc, bArrZzaN);
            } catch (com.google.android.gms.internal.measurement.zzmm unused) {
                zzaW().zzk().zzb("Failed to parse locally stored ad campaign info. appId", zzhe.zzn(zzhVar.zzC()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhm zzhmVar : zzhwVar.zzaM()) {
            if (zzhmVar.zzh().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzqa.zzI(zzhmVar, "gclid", "");
                String str2 = (String) zzqa.zzI(zzhmVar, "gbraid", "");
                String str3 = (String) zzqa.zzI(zzhmVar, "gad_source", "");
                if (!str.isEmpty() || !str2.isEmpty()) {
                    long jLongValue = ((Long) zzqa.zzI(zzhmVar, "click_timestamp", 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = zzhmVar.zzd();
                    }
                    if ("referrer API v2".equals(zzqa.zzH(zzhmVar, "_cis"))) {
                        if (jLongValue > zzhbVarZzc.zzb()) {
                            if (str.isEmpty()) {
                                zzhbVarZzc.zzh();
                            } else {
                                zzhbVarZzc.zzp(str);
                            }
                            if (str2.isEmpty()) {
                                zzhbVarZzc.zzg();
                            } else {
                                zzhbVarZzc.zzo(str2);
                            }
                            if (str3.isEmpty()) {
                                zzhbVarZzc.zzf();
                            } else {
                                zzhbVarZzc.zzn(str3);
                            }
                            zzhbVarZzc.zzm(jLongValue);
                        }
                    } else if (jLongValue > zzhbVarZzc.zza()) {
                        if (str.isEmpty()) {
                            zzhbVarZzc.zze();
                        } else {
                            zzhbVarZzc.zzk(str);
                        }
                        if (str2.isEmpty()) {
                            zzhbVarZzc.zzd();
                        } else {
                            zzhbVarZzc.zzj(str2);
                        }
                        if (str3.isEmpty()) {
                            zzhbVarZzc.zzc();
                        } else {
                            zzhbVarZzc.zzi(str3);
                        }
                        zzhbVarZzc.zzl(jLongValue);
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzhc) zzhbVarZzc.zzba()).equals(com.google.android.gms.internal.measurement.zzhc.zze())) {
            zzhwVar.zzF((com.google.android.gms.internal.measurement.zzhc) zzhbVarZzc.zzba());
        }
        zzhVar.zzR(((com.google.android.gms.internal.measurement.zzhc) zzhbVarZzc.zzba()).zzcd());
        if (zzhVar.zzaK()) {
            zzj().zzT(zzhVar, false, false);
        }
    }

    final void zzab(zzr zzrVar) throws Throwable {
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzi().zzx(null, zzgi.zzay)) {
            long jCurrentTimeMillis = zzaU().currentTimeMillis();
            int iZzh = zzi().zzh(null, zzgi.zzah);
            zzi();
            long jZzF = jCurrentTimeMillis - zzam.zzF();
            while (i < iZzh && zzaM(null, jZzF)) {
                i++;
            }
        } else {
            zzi();
            long jZzH = zzam.zzH();
            while (i < jZzH && zzaM(str, 0L)) {
                i++;
            }
        }
        if (zzi().zzx(null, zzgi.zzaz)) {
            zzaX().zzg();
            zzaJ();
        }
        if (zzi().zzx(null, zzgi.zzaQ) && this.zzl.zzd(str, com.google.android.gms.internal.measurement.zzih.zzb(zzrVar.zzG))) {
            zzaW().zzj().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzau(str, zzaU().currentTimeMillis());
        }
    }

    final void zzac(zzr zzrVar) {
        boolean z;
        zzbd zzbdVarZzs;
        boolean z2;
        long j;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j2;
        boolean z3;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        if (zzaQ(zzrVar)) {
            zzh zzhVarZzl = zzj().zzl(str);
            if (zzhVarZzl != null && TextUtils.isEmpty(zzhVarZzl.zzH()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzhVarZzl.zzab(0L);
                zzj().zzT(zzhVarZzl, false, false);
                zzr().zzr(str);
            }
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            long jCurrentTimeMillis = zzrVar.zzl;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = zzaU().currentTimeMillis();
            }
            this.zzn.zzg().zzg();
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaW().zzk().zzc("Incorrect app type, assuming installed app. appId, appType", zzhe.zzn(str), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzH();
            try {
                zzqd zzqdVarZzy = zzj().zzy(str, "_npa");
                Boolean boolZzaS = zzaS(zzrVar);
                if (zzqdVarZzy != null && !"auto".equals(zzqdVarZzy.zzb)) {
                    z = true;
                } else if (boolZzaS != null) {
                    z = true;
                    zzqb zzqbVar = new zzqb("_npa", jCurrentTimeMillis, Long.valueOf(true != boolZzaS.booleanValue() ? 0L : 1L), "auto");
                    if (zzqdVarZzy == null || !zzqdVarZzy.zze.equals(zzqbVar.zzd)) {
                        zzas(zzqbVar, zzrVar);
                    }
                } else {
                    z = true;
                    if (zzqdVarZzy != null) {
                        zzag("_npa", zzrVar);
                    }
                }
                if (zzi().zzx(null, zzgi.zzbl)) {
                    zzP(zzrVar, zzrVar.zzF);
                } else {
                    zzP(zzrVar, jCurrentTimeMillis);
                }
                zzg(zzrVar);
                if (i == 0) {
                    zzbdVarZzs = zzj().zzs(str, "_f");
                    z2 = false;
                } else {
                    zzbdVarZzs = zzj().zzs(str, "_v");
                    z2 = z;
                }
                if (zzbdVarZzs == null) {
                    long j3 = ((jCurrentTimeMillis / DateUtils.MILLIS_PER_HOUR) + 1) * DateUtils.MILLIS_PER_HOUR;
                    if (z2) {
                        long j4 = jCurrentTimeMillis;
                        zzas(new zzqb("_fvt", j4, Long.valueOf(j3), "auto"), zzrVar);
                        zzaX().zzg();
                        zzM();
                        Bundle bundle = new Bundle();
                        bundle.putLong("_c", 1L);
                        bundle.putLong("_r", 1L);
                        bundle.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle.putLong("_dac", 1L);
                        }
                        zzU(new zzbh("_v", new zzbf(bundle), "auto", j4), zzrVar);
                    } else {
                        zzas(new zzqb("_fot", jCurrentTimeMillis, Long.valueOf(j3), "auto"), zzrVar);
                        zzaX().zzg();
                        zzhw zzhwVar = (zzhw) Preconditions.checkNotNull(this.zzm);
                        if (str == null || str.isEmpty()) {
                            j = jCurrentTimeMillis;
                            zzhwVar.zza.zzaW().zzm().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzio zzioVar = zzhwVar.zza;
                            zzioVar.zzaX().zzg();
                            if (zzhwVar.zza()) {
                                zzhv zzhvVar = new zzhv(zzhwVar, str);
                                zzioVar.zzaX().zzg();
                                j = jCurrentTimeMillis;
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzioVar.zzaT().getPackageManager();
                                if (packageManager == null) {
                                    zzioVar.zzaW().zzm().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzioVar.zzaW().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                                        if (resolveInfo.serviceInfo != null) {
                                            String str2 = resolveInfo.serviceInfo.packageName;
                                            if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str2) && zzhwVar.zza()) {
                                                try {
                                                    zzioVar.zzaW().zzj().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzioVar.zzaT(), new Intent(intent), zzhvVar, 1) ? "available" : "not available");
                                                } catch (RuntimeException e) {
                                                    zzhwVar.zza.zzaW().zze().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                }
                                            } else {
                                                zzioVar.zzaW().zzk().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzioVar.zzaW().zzi().zza("Install Referrer Reporter is not available");
                                j = jCurrentTimeMillis;
                            }
                        }
                        zzaX().zzg();
                        zzM();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong("_pfo", 0L);
                        bundle2.putLong("_sys", 0L);
                        bundle2.putLong("_sysu", 0L);
                        bundle2.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle2.putLong("_dac", 1L);
                        }
                        String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                        zzaw zzawVarZzj = zzj();
                        Preconditions.checkNotEmpty(str3);
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzav();
                        long jZze = zzawVarZzj.zze(str3, "first_open_count");
                        zzio zzioVar2 = this.zzn;
                        if (zzioVar2.zzaT().getPackageManager() == null) {
                            zzaW().zze().zzb("PackageManager is null, first open report might be inaccurate. appId", zzhe.zzn(str3));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(zzioVar2.zzaT()).getPackageInfo(str3, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                zzaW().zze().zzc("Package info is null, first open report might be inaccurate. appId", zzhe.zzn(str3), e2);
                                packageInfo = null;
                            }
                            if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                applicationInfo = null;
                            } else {
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    applicationInfo = null;
                                    if (!zzi().zzx(null, zzgi.zzaH)) {
                                        bundle2.putLong("_uwa", 1L);
                                    } else if (jZze == 0) {
                                        bundle2.putLong("_uwa", 1L);
                                        jZze = 0;
                                    }
                                    z3 = false;
                                } else {
                                    applicationInfo = null;
                                    z3 = true;
                                }
                                zzas(new zzqb("_fi", j, Long.valueOf(true != z3 ? 0L : 1L), "auto"), zzrVar);
                            }
                            try {
                                applicationInfo2 = Wrappers.packageManager(this.zzn.zzaT()).getApplicationInfo(str3, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                zzaW().zze().zzc("Application info is null, first open report might be inaccurate. appId", zzhe.zzn(str3), e3);
                                applicationInfo2 = applicationInfo;
                            }
                            if (applicationInfo2 != null) {
                                if ((applicationInfo2.flags & 1) != 0) {
                                    j2 = 1;
                                    bundle2.putLong("_sys", 1L);
                                } else {
                                    j2 = 1;
                                }
                                if ((applicationInfo2.flags & 128) != 0) {
                                    bundle2.putLong("_sysu", j2);
                                }
                            }
                        }
                        if (jZze >= 0) {
                            bundle2.putLong("_pfo", jZze);
                        }
                        zzU(new zzbh("_f", new zzbf(bundle2), "auto", j), zzrVar);
                    }
                } else {
                    long j5 = jCurrentTimeMillis;
                    if (zzrVar.zzi) {
                        zzU(new zzbh("_cd", new zzbf(new Bundle()), "auto", j5), zzrVar);
                    }
                }
                zzj().zzS();
                zzj().zzL();
            } catch (Throwable th) {
                zzj().zzL();
                throw th;
            }
        }
    }

    final void zzad() {
        this.zzs++;
    }

    final void zzae(zzai zzaiVar) {
        zzr zzrVarZzaD = zzaD((String) Preconditions.checkNotNull(zzaiVar.zza));
        if (zzrVarZzaD != null) {
            zzaf(zzaiVar, zzrVarZzaD);
        }
    }

    final void zzaf(zzai zzaiVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zzc.zzb);
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzj().zzH();
            try {
                zzg(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzaiVar.zza);
                zzai zzaiVarZzm = zzj().zzm(str, zzaiVar.zzc.zzb);
                if (zzaiVarZzm != null) {
                    zzaW().zzd().zzc("Removing conditional user property", zzaiVar.zza, this.zzn.zzj().zzf(zzaiVar.zzc.zzb));
                    zzj().zza(str, zzaiVar.zzc.zzb);
                    if (zzaiVarZzm.zze) {
                        zzj().zzP(str, zzaiVar.zzc.zzb);
                    }
                    zzbh zzbhVar = zzaiVar.zzk;
                    if (zzbhVar != null) {
                        zzbf zzbfVar = zzbhVar.zzb;
                        zzax((zzbh) Preconditions.checkNotNull(zzB().zzC(str, ((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, zzbfVar != null ? zzbfVar.zzc() : null, zzaiVarZzm.zzb, zzbhVar.zzd, true, true)), zzrVar);
                    }
                } else {
                    zzaW().zzk().zzc("Conditional user property doesn't exist", zzhe.zzn(zzaiVar.zza), this.zzn.zzj().zzf(zzaiVar.zzc.zzb));
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzag(String str, zzr zzrVar) {
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            Boolean boolZzaS = zzaS(zzrVar);
            if ("_npa".equals(str) && boolZzaS != null) {
                zzaW().zzd().zza("Falling back to manifest metadata value for ad personalization");
                zzas(new zzqb("_npa", zzaU().currentTimeMillis(), Long.valueOf(true != boolZzaS.booleanValue() ? 0L : 1L), "auto"), zzrVar);
                return;
            }
            zzhc zzhcVarZzd = zzaW().zzd();
            zzio zzioVar = this.zzn;
            zzhcVarZzd.zzb("Removing user property", zzioVar.zzj().zzf(str));
            zzj().zzH();
            try {
                zzg(zzrVar);
                if ("_id".equals(str)) {
                    zzj().zzP((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                }
                zzj().zzP((String) Preconditions.checkNotNull(zzrVar.zza), str);
                zzj().zzS();
                zzaW().zzd().zzb("User property removed", zzioVar.zzj().zzf(str));
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzah(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzaw zzawVarZzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzawVarZzj.zzg();
        zzawVarZzj.zzav();
        try {
            SQLiteDatabase sQLiteDatabaseZzj = zzawVarZzj.zzj();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZzj.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseZzj.delete("upload_queue", "app_id=?", strArr);
            if (iDelete > 0) {
                zzawVarZzj.zzu.zzaW().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzawVarZzj.zzu.zzaW().zze().zzc("Error resetting analytics data. appId, error", zzhe.zzn(str), e);
        }
        if (zzrVar.zzh) {
            zzac(zzrVar);
        }
    }

    final void zzai(zzr zzrVar) {
        zzaX().zzg();
        zzM();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zzbaVarZze = zzba.zze(zzrVar.zzA);
        zzaW().zzj().zzc("Setting DMA consent for package", str, zzbaVarZze);
        zzaX().zzg();
        zzM();
        zzju zzjuVarZzf = zzba.zzc(zzd(str), 100).zzf();
        this.zzD.put(str, zzbaVarZze);
        zzj().zzU(str, zzbaVarZze);
        zzju zzjuVarZzf2 = zzba.zzc(zzd(str), 100).zzf();
        zzaX().zzg();
        zzM();
        boolean z = zzjuVarZzf == zzju.DENIED && zzjuVarZzf2 == zzju.GRANTED;
        boolean z2 = zzjuVarZzf == zzju.GRANTED && zzjuVarZzf2 == zzju.DENIED;
        if (z || z2) {
            zzaW().zzj().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzo(zza(), str, false, false, false, false, false, false, false).zzf < zzi().zzh(str, zzgi.zzal)) {
                bundle.putLong("_r", 1L);
                zzaW().zzj().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzo(zza(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    public final void zzaj(String str, zzmh zzmhVar) {
        zzaX().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzmhVar != null) {
            this.zzH = str;
            this.zzG = zzmhVar;
        }
    }

    final void zzak(zzr zzrVar) {
        zzaX().zzg();
        zzM();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjx zzjxVarZzk = zzjx.zzk(zzrVar.zzu, zzrVar.zzz);
        zzu(str);
        zzaW().zzj().zzc("Setting storage consent for package", str, zzjxVarZzk);
        zzaq(str, zzjxVarZzk);
    }

    final void zzal(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaW().zze().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    protected final void zzam() {
        zzaX().zzg();
        zzj().zzO();
        zzaw zzawVarZzj = zzj();
        zzawVarZzj.zzg();
        zzawVarZzj.zzav();
        if (zzawVarZzj.zzae() && ((Long) zzgi.zzau.zza(null)).longValue() != 0) {
            SQLiteDatabase sQLiteDatabaseZzj = zzawVarZzj.zzj();
            zzio zzioVar = zzawVarZzj.zzu;
            int iDelete = sQLiteDatabaseZzj.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzioVar.zzaU().currentTimeMillis()), String.valueOf(zzgi.zzau.zza(null))});
            if (iDelete > 0) {
                zzioVar.zzaW().zzj().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzaU().currentTimeMillis());
        }
        zzaL();
    }

    final void zzan(zzai zzaiVar) {
        zzr zzrVarZzaD = zzaD((String) Preconditions.checkNotNull(zzaiVar.zza));
        if (zzrVarZzaD != null) {
            zzao(zzaiVar, zzrVarZzaD);
        }
    }

    final void zzao(zzai zzaiVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        Preconditions.checkNotNull(zzaiVar.zzb);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zzc.zzb);
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzai zzaiVar2 = new zzai(zzaiVar);
            boolean z = false;
            zzaiVar2.zze = false;
            zzj().zzH();
            try {
                zzai zzaiVarZzm = zzj().zzm((String) Preconditions.checkNotNull(zzaiVar2.zza), zzaiVar2.zzc.zzb);
                if (zzaiVarZzm != null && !zzaiVarZzm.zzb.equals(zzaiVar2.zzb)) {
                    zzaW().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzb, zzaiVarZzm.zzb);
                }
                if (zzaiVarZzm != null && zzaiVarZzm.zze) {
                    zzaiVar2.zzb = zzaiVarZzm.zzb;
                    zzaiVar2.zzd = zzaiVarZzm.zzd;
                    zzaiVar2.zzh = zzaiVarZzm.zzh;
                    zzaiVar2.zzf = zzaiVarZzm.zzf;
                    zzaiVar2.zzi = zzaiVarZzm.zzi;
                    zzaiVar2.zze = true;
                    zzqb zzqbVar = zzaiVar2.zzc;
                    zzaiVar2.zzc = new zzqb(zzqbVar.zzb, zzaiVarZzm.zzc.zzc, zzqbVar.zza(), zzaiVarZzm.zzc.zzf);
                } else if (TextUtils.isEmpty(zzaiVar2.zzf)) {
                    zzqb zzqbVar2 = zzaiVar2.zzc;
                    zzaiVar2.zzc = new zzqb(zzqbVar2.zzb, zzaiVar2.zzd, zzqbVar2.zza(), zzaiVar2.zzc.zzf);
                    zzaiVar2.zze = true;
                    z = true;
                }
                if (zzaiVar2.zze) {
                    zzqb zzqbVar3 = zzaiVar2.zzc;
                    zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(zzaiVar2.zza), zzaiVar2.zzb, zzqbVar3.zzb, zzqbVar3.zzc, Preconditions.checkNotNull(zzqbVar3.zza()));
                    if (zzj().zzai(zzqdVar)) {
                        zzaW().zzd().zzd("User property updated immediately", zzaiVar2.zza, this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                    } else {
                        zzaW().zze().zzd("(2)Too many active user properties, ignoring", zzhe.zzn(zzaiVar2.zza), this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                    }
                    if (z && zzaiVar2.zzi != null) {
                        zzax(new zzbh(zzaiVar2.zzi, zzaiVar2.zzd), zzrVar);
                    }
                }
                if (zzj().zzah(zzaiVar2)) {
                    zzaW().zzd().zzd("Conditional property added", zzaiVar2.zza, this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                } else {
                    zzaW().zze().zzd("Too many conditional properties, ignoring", zzhe.zzn(zzaiVar2.zza), this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzap(String str, zzag zzagVar) {
        zzam zzamVarZzi = zzi();
        zzgg zzggVar = zzgi.zzaP;
        if (zzamVarZzi.zzx(null, zzggVar)) {
            zzaX().zzg();
            zzM();
            zzaw zzawVarZzj = zzj();
            long j = zzagVar.zza;
            zzpz zzpzVarZzx = zzawVarZzj.zzx(j);
            if (zzpzVarZzx == null) {
                zzaW().zzk().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
                return;
            }
            String strZzh = zzpzVarZzx.zzh();
            if (zzagVar.zzb != zzme.SUCCESS.zza()) {
                if (zzagVar.zzb == zzme.BACKOFF.zza()) {
                    Map map = this.zzF;
                    zzpt zzptVar = (zzpt) map.get(strZzh);
                    if (zzptVar == null) {
                        zzptVar = new zzpt(this);
                        map.put(strZzh, zzptVar);
                    } else {
                        zzptVar.zzb();
                    }
                    zzaW().zzj().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, strZzh, Long.valueOf((zzptVar.zzc - zzaU().currentTimeMillis()) / 1000));
                }
                zzaw zzawVarZzj2 = zzj();
                Long lValueOf = Long.valueOf(zzagVar.zza);
                zzawVarZzj2.zzN(lValueOf);
                zzaW().zzj().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, lValueOf);
                return;
            }
            Map map2 = this.zzF;
            if (map2.containsKey(strZzh)) {
                map2.remove(strZzh);
            }
            zzaw zzawVarZzj3 = zzj();
            Long lValueOf2 = Long.valueOf(j);
            zzawVarZzj3.zzK(lValueOf2);
            zzaW().zzj().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, lValueOf2);
            long j2 = zzagVar.zzc;
            if (j2 > 0) {
                zzaw zzawVarZzj4 = zzj();
                zzio zzioVar = zzawVarZzj4.zzu;
                if (zzioVar.zzf().zzx(null, zzggVar)) {
                    zzawVarZzj4.zzg();
                    zzawVarZzj4.zzav();
                    Long lValueOf3 = Long.valueOf(j2);
                    Preconditions.checkNotNull(lValueOf3);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("upload_type", Integer.valueOf(zzmf.GOOGLE_SIGNAL.zza()));
                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzioVar.zzaU().currentTimeMillis()));
                    try {
                        if (zzawVarZzj4.zzj().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzmf.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                            zzioVar.zzaW().zzk().zzc("Google Signal pending batch not updated. appId, rowId", str, lValueOf3);
                        }
                    } catch (SQLiteException e) {
                        zzawVarZzj4.zzu.zzaW().zze().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                        throw e;
                    }
                }
                zzaW().zzj().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzagVar.zzc));
                zzav(str);
            }
        }
    }

    final void zzaq(String str, zzjx zzjxVar) {
        zzaX().zzg();
        zzM();
        this.zzC.put(str, zzjxVar);
        zzj().zzX(str, zzjxVar);
    }

    final void zzar(String str, boolean z, Long l, Long l2) {
        zzh zzhVarZzl = zzj().zzl(str);
        if (zzhVarZzl != null) {
            zzhVarZzl.zzaF(z);
            zzhVarZzl.zzaG(l);
            zzhVarZzl.zzaH(l2);
            if (zzhVarZzl.zzaK()) {
                zzj().zzT(zzhVarZzl, false, false);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:43:0x0108  */
    final void zzas(zzqb zzqbVar, zzr zzrVar) {
        zzqd zzqdVarZzy;
        zzbd zzbdVarZzs;
        long jLongValue;
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzqf zzqfVarZzB = zzB();
            String str = zzqbVar.zzb;
            int iZzj = zzqfVarZzB.zzj(str);
            if (iZzj != 0) {
                zzqf zzqfVarZzB2 = zzB();
                zzi();
                zzB().zzR(this.zzK, zzrVar.zza, iZzj, "_ev", zzqfVarZzB2.zzG(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int iZzd = zzB().zzd(str, zzqbVar.zza());
            if (iZzd != 0) {
                zzqf zzqfVarZzB3 = zzB();
                zzi();
                String strZzG = zzqfVarZzB3.zzG(str, 24, true);
                Object objZza = zzqbVar.zza();
                zzB().zzR(this.zzK, zzrVar.zza, iZzd, "_ev", strZzG, (objZza == null || !((objZza instanceof String) || (objZza instanceof CharSequence))) ? 0 : objZza.toString().length());
                return;
            }
            Object objZzE = zzB().zzE(str, zzqbVar.zza());
            if (objZzE != null) {
                String str2 = "_sid";
                if ("_sid".equals(str)) {
                    long j = zzqbVar.zzc;
                    String str3 = zzqbVar.zzf;
                    String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzqd zzqdVarZzy2 = zzj().zzy(str4, "_sno");
                    if (zzqdVarZzy2 != null) {
                        Object obj = zzqdVarZzy2.zze;
                        if (obj instanceof Long) {
                            jLongValue = ((Long) obj).longValue();
                        } else {
                            if (zzqdVarZzy2 != null) {
                                zzaW().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzqdVarZzy2.zze);
                            }
                            zzbdVarZzs = zzj().zzs(str4, "_s");
                            if (zzbdVarZzs != null) {
                                zzhc zzhcVarZzj = zzaW().zzj();
                                long j2 = zzbdVarZzs.zzc;
                                zzhcVarZzj.zzb("Backfill the session number. Last used session number", Long.valueOf(j2));
                                jLongValue = j2;
                            } else {
                                jLongValue = 0;
                            }
                        }
                    } else {
                        if (zzqdVarZzy2 != null) {
                            zzaW().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzqdVarZzy2.zze);
                        }
                        zzbdVarZzs = zzj().zzs(str4, "_s");
                        if (zzbdVarZzs != null) {
                            zzhc zzhcVarZzj2 = zzaW().zzj();
                            long j3 = zzbdVarZzs.zzc;
                            zzhcVarZzj2.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                            jLongValue = j3;
                        } else {
                            jLongValue = 0;
                        }
                    }
                    zzas(new zzqb("_sno", j, Long.valueOf(jLongValue + 1), str3), zzrVar);
                } else {
                    str2 = "_sid";
                }
                String str5 = zzrVar.zza;
                zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(str5), (String) Preconditions.checkNotNull(zzqbVar.zzf), str, zzqbVar.zzc, objZzE);
                zzhc zzhcVarZzj3 = zzaW().zzj();
                zzio zzioVar = this.zzn;
                String str6 = zzqdVar.zzc;
                zzhcVarZzj3.zzc("Setting user property", zzioVar.zzj().zzf(str6), objZzE);
                zzj().zzH();
                try {
                    if ("_id".equals(str6) && (zzqdVarZzy = zzj().zzy(str5, "_id")) != null && !zzqdVar.zze.equals(zzqdVarZzy.zze)) {
                        zzj().zzP(str5, "_lair");
                    }
                    zzg(zzrVar);
                    boolean zZzai = zzj().zzai(zzqdVar);
                    if (str2.equals(str)) {
                        long jZzd = zzA().zzd(zzrVar.zzw);
                        zzh zzhVarZzl = zzj().zzl(str5);
                        if (zzhVarZzl != null) {
                            zzhVarZzl.zzaB(jZzd);
                            if (zzhVarZzl.zzaK()) {
                                zzj().zzT(zzhVarZzl, false, false);
                            }
                        }
                    }
                    zzj().zzS();
                    if (!zZzai) {
                        zzaW().zze().zzc("Too many unique user properties are set. Ignoring user property", zzioVar.zzj().zzf(str6), zzqdVar.zze);
                        zzB().zzR(this.zzK, str5, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzL();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0108 A[Catch: all -> 0x01b9, PHI: r5 r7
      0x0108: PHI (r5v10 long) = (r5v6 long), (r5v11 long), (r5v6 long) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r7v12 android.database.Cursor) = (r7v21 android.database.Cursor), (r7v22 android.database.Cursor), (r7v23 android.database.Cursor) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0173 A[Catch: all -> 0x01b9, PHI: r1 r7
      0x0173: PHI (r1v20 ??) = (r1v40 ??), (r1v41 ??), (r1v42 ??) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r7v2 java.lang.Object) = (r7v32 java.lang.Object), (r7v16 java.lang.Object), (r7v33 java.lang.Object) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzpv] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v20, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [com.google.android.gms.measurement.internal.zzaw] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzjq, com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.google.android.gms.measurement.internal.zzjq] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.CharSequence, java.lang.String] */
    final void zzat() {
        Throwable th;
        SQLiteException e;
        String string;
        ?? r1;
        boolean zIsEmpty;
        zzh zzhVarZzl;
        Cursor cursor;
        Cursor cursor2;
        zzaX().zzg();
        zzM();
        this.zzw = true;
        try {
            zzio zzioVar = this.zzn;
            zzioVar.zzaV();
            Boolean boolZzl = zzioVar.zzu().zzl();
            if (boolZzl == null) {
                zzaW().zzk().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzl.booleanValue()) {
                zzaW().zze().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaL();
            } else {
                zzaX().zzg();
                if (this.zzz != null) {
                    zzaW().zzj().zza("Uploading requested multiple times");
                } else if (zzp().zzd()) {
                    ?? CurrentTimeMillis = zzaU().currentTimeMillis();
                    ?? r7 = 0;
                    cursorRawQuery = null;
                    cursorRawQuery = null;
                    cursorRawQuery = null;
                    ?? r8 = 0;
                    Object obj = null;
                    cursorRawQuery = null;
                    Cursor cursorRawQuery = null;
                    int iZzh = zzi().zzh(null, zzgi.zzah);
                    zzi();
                    long jZzF = CurrentTimeMillis - zzam.zzF();
                    for (int i = 0; i < iZzh && zzaM(null, jZzF); i++) {
                    }
                    zzqr.zzb();
                    zzaX().zzg();
                    zzaJ();
                    long jZza = this.zzk.zzd.zza();
                    if (jZza != 0) {
                        zzaW().zzd().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(CurrentTimeMillis - jZza)));
                    }
                    ?? ZzA = zzj().zzA();
                    long j = -1;
                    if (TextUtils.isEmpty(ZzA)) {
                        try {
                            this.zzB = -1L;
                            ZzA = zzj();
                            zzi();
                            long jZzF2 = CurrentTimeMillis - zzam.zzF();
                            ZzA.zzg();
                            ZzA.zzav();
                            try {
                                CurrentTimeMillis = ZzA.zzj().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jZzF2)});
                                try {
                                    if (CurrentTimeMillis.moveToFirst()) {
                                        string = CurrentTimeMillis.getString(0);
                                        if (CurrentTimeMillis != 0) {
                                            r8 = string;
                                            r1 = CurrentTimeMillis;
                                            obj = string;
                                            r1 = CurrentTimeMillis;
                                            r1.close();
                                            r8 = obj;
                                        }
                                    } else {
                                        ZzA.zzu.zzaW().zzj().zza("No expired configs for apps with pending events");
                                        if (CurrentTimeMillis != 0) {
                                            r8 = string;
                                            r1 = CurrentTimeMillis;
                                            obj = string;
                                            r1 = CurrentTimeMillis;
                                            r1.close();
                                            r8 = obj;
                                        }
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    ZzA.zzu.zzaW().zze().zzb("Error selecting expired configs", e);
                                    r8 = cursorRawQuery;
                                    r1 = CurrentTimeMillis;
                                    obj = cursorRawQuery;
                                    if (CurrentTimeMillis != 0) {
                                        r8 = string;
                                        r1 = CurrentTimeMillis;
                                        obj = string;
                                        r1 = CurrentTimeMillis;
                                        r1.close();
                                        r8 = obj;
                                    }
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                CurrentTimeMillis = 0;
                                ZzA.zzu.zzaW().zze().zzb("Error selecting expired configs", e);
                                r8 = cursorRawQuery;
                                r1 = CurrentTimeMillis;
                                obj = cursorRawQuery;
                                if (CurrentTimeMillis != 0) {
                                    r8 = string;
                                    r1 = CurrentTimeMillis;
                                    obj = string;
                                    r1 = CurrentTimeMillis;
                                    r1.close();
                                    r8 = obj;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (r7 != 0) {
                                    r7.close();
                                }
                                throw th;
                            }
                            r8 = string;
                            r1 = CurrentTimeMillis;
                            obj = string;
                            r1 = CurrentTimeMillis;
                            zIsEmpty = TextUtils.isEmpty(r8);
                            CurrentTimeMillis = zIsEmpty;
                            if (!zIsEmpty && (zzhVarZzl = zzj().zzl(r8)) != null) {
                                CurrentTimeMillis = zzhVarZzl;
                                zzO(zzhVarZzl);
                                CurrentTimeMillis = zzhVarZzl;
                            }
                            CurrentTimeMillis = zzhVarZzl;
                        } catch (Throwable th3) {
                            th = th3;
                            r7 = CurrentTimeMillis;
                        }
                    } else {
                        if (this.zzB == -1) {
                            zzaw zzawVarZzj = zzj();
                            try {
                                try {
                                    cursorRawQuery = zzawVarZzj.zzj().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    boolean zMoveToFirst = cursorRawQuery.moveToFirst();
                                    cursor2 = cursorRawQuery;
                                    cursor = cursorRawQuery;
                                    if (zMoveToFirst) {
                                        j = cursorRawQuery.getLong(0);
                                        if (cursorRawQuery != null) {
                                            cursor2 = cursorRawQuery;
                                            cursor = cursorRawQuery;
                                            cursor2.close();
                                            cursor = cursor2;
                                        }
                                    } else if (cursorRawQuery != null) {
                                        cursor2 = cursorRawQuery;
                                        cursor = cursorRawQuery;
                                        cursor2.close();
                                        cursor = cursor2;
                                    }
                                } catch (SQLiteException e4) {
                                    zzawVarZzj.zzu.zzaW().zze().zzb("Error querying raw events", e4);
                                    cursor2 = cursorRawQuery;
                                    cursor = cursorRawQuery;
                                    if (cursorRawQuery != null) {
                                    }
                                    cursor2 = cursorRawQuery;
                                    cursor = cursorRawQuery;
                                    this.zzB = j;
                                    cursorRawQuery = cursor;
                                    zzau(ZzA, CurrentTimeMillis);
                                }
                                cursor2 = cursorRawQuery;
                                cursor = cursorRawQuery;
                                this.zzB = j;
                                cursorRawQuery = cursor;
                            } catch (Throwable th4) {
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                throw th4;
                            }
                        }
                        zzau(ZzA, CurrentTimeMillis);
                    }
                    e = e2;
                    ZzA.zzu.zzaW().zze().zzb("Error selecting expired configs", e);
                    r8 = cursorRawQuery;
                    r1 = CurrentTimeMillis;
                    obj = cursorRawQuery;
                    if (CurrentTimeMillis != 0) {
                        r8 = string;
                        r1 = CurrentTimeMillis;
                        obj = string;
                        r1 = CurrentTimeMillis;
                        r1.close();
                        r8 = obj;
                    }
                    r8 = string;
                    r1 = CurrentTimeMillis;
                    obj = string;
                    r1 = CurrentTimeMillis;
                    zIsEmpty = TextUtils.isEmpty(r8);
                    CurrentTimeMillis = zIsEmpty;
                    if (!zIsEmpty) {
                        CurrentTimeMillis = zzhVarZzl;
                        zzO(zzhVarZzl);
                        CurrentTimeMillis = zzhVarZzl;
                    }
                    CurrentTimeMillis = zzhVarZzl;
                } else {
                    zzaW().zzj().zza("Network not connected, ignoring upload request");
                    zzaL();
                }
            }
            this.zzw = false;
            zzaH();
        } catch (Throwable th5) {
            this.zzw = false;
            zzaH();
            throw th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x022c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0233  */
    /* JADX WARN: Code duplicated, block: B:116:0x0284  */
    /* JADX WARN: Code duplicated, block: B:119:0x02af  */
    /* JADX WARN: Code duplicated, block: B:121:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:123:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:125:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:128:0x0301  */
    /* JADX WARN: Code duplicated, block: B:130:0x0306  */
    /* JADX WARN: Code duplicated, block: B:133:0x0313  */
    /* JADX WARN: Code duplicated, block: B:136:0x031e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0328  */
    /* JADX WARN: Code duplicated, block: B:141:0x0347  */
    /* JADX WARN: Code duplicated, block: B:145:0x036d  */
    /* JADX WARN: Code duplicated, block: B:149:0x0384  */
    /* JADX WARN: Code duplicated, block: B:152:0x0397  */
    /* JADX WARN: Code duplicated, block: B:157:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:159:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:163:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:165:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:168:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:175:0x041a  */
    /* JADX WARN: Code duplicated, block: B:177:0x042e  */
    /* JADX WARN: Code duplicated, block: B:182:0x0450  */
    /* JADX WARN: Code duplicated, block: B:185:0x0459 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:186:0x045b  */
    /* JADX WARN: Code duplicated, block: B:187:0x045d  */
    /* JADX WARN: Code duplicated, block: B:188:0x0461 A[PHI: r2
      0x0461: PHI (r2v8 boolean) = (r2v7 boolean), (r2v21 boolean) binds: [B:184:0x0457, B:186:0x045b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:191:0x0475  */
    /* JADX WARN: Code duplicated, block: B:197:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:200:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:204:0x04cc A[LOOP:5: B:202:0x04c6->B:204:0x04cc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:207:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:209:0x0504  */
    /* JADX WARN: Code duplicated, block: B:210:0x0507  */
    /* JADX WARN: Code duplicated, block: B:212:0x0511  */
    /* JADX WARN: Code duplicated, block: B:215:0x052a  */
    /* JADX WARN: Code duplicated, block: B:220:0x0567 A[LOOP:6: B:218:0x0561->B:220:0x0567, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:223:0x0599  */
    /* JADX WARN: Code duplicated, block: B:225:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:226:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:228:0x05df  */
    /* JADX WARN: Code duplicated, block: B:230:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:231:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:235:0x0601  */
    /* JADX WARN: Code duplicated, block: B:238:0x060e A[LOOP:7: B:236:0x0608->B:238:0x060e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:241:0x064c  */
    /* JADX WARN: Code duplicated, block: B:243:0x0670  */
    /* JADX WARN: Code duplicated, block: B:250:0x0699  */
    /* JADX WARN: Code duplicated, block: B:251:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:257:0x06da  */
    /* JADX WARN: Code duplicated, block: B:268:0x0224 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:270:? A[LOOP:0: B:94:0x020a->B:270:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x0404 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x03a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:280:0x0379 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:0x035f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:285:0x0481 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x048a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:? A[LOOP:4: B:189:0x046f->B:287:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:308:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:93:0x0206  */
    /* JADX WARN: Code duplicated, block: B:96:0x0210  */
    /* JADX WARN: Instruction removed from duplicated block: B:223:0x0599, please report this as an issue */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x06d7: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:255:0x06d7 */
    final void zzau(String str, long j) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2;
        List listEmptyList;
        com.google.android.gms.internal.measurement.zzht zzhtVarZzb;
        int size;
        List arrayList;
        boolean z;
        boolean zZzr;
        boolean zZzr2;
        boolean zZzx;
        zzpi zzpiVar;
        zzph zzphVarZza;
        int i;
        com.google.android.gms.internal.measurement.zzhv zzhvVar;
        List arrayList2;
        boolean z2;
        Iterator it2;
        String string;
        com.google.android.gms.internal.measurement.zzht zzhtVarZzc;
        String strZzm;
        ArrayList arrayList3;
        Iterator it3;
        zzam zzamVarZzi;
        zzgg zzggVar;
        com.google.android.gms.internal.measurement.zzhv zzhvVar2;
        com.google.android.gms.internal.measurement.zzht zzhtVar;
        int i2;
        com.google.android.gms.internal.measurement.zzht zzhtVarZzb2;
        String strZzm2;
        zzph zzphVar;
        zzmf zzmfVar;
        zzmf zzmfVar2;
        Object objZzi;
        Object objZzq;
        com.google.android.gms.internal.measurement.zzhw zzhwVar;
        int i3;
        String strZzaL;
        int i4;
        ArrayList arrayList4;
        Iterator it4;
        boolean z3;
        boolean z4;
        Long lValueOf;
        Long lValueOf2;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        com.google.android.gms.internal.measurement.zzhm zzhmVar;
        com.google.android.gms.internal.measurement.zzhq zzhqVarZzG;
        com.google.android.gms.internal.measurement.zzhq zzhqVarZzG2;
        com.google.android.gms.internal.measurement.zzim zzimVarZzb;
        Iterator it5;
        String strZzT;
        int i5;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        com.google.android.gms.internal.measurement.zzhx zzhxVar2;
        long jZzc;
        long jZzc2;
        int iZzh = zzi().zzh(str, zzgi.zzg);
        int i6 = 0;
        int iMax = Math.max(0, zzi().zzh(str, zzgi.zzh));
        zzaw zzawVarZzj = zzj();
        zzawVarZzj.zzg();
        zzawVarZzj.zzav();
        int i7 = 1;
        Preconditions.checkArgument(iZzh > 0);
        Preconditions.checkArgument(iMax > 0);
        Preconditions.checkNotEmpty(str);
        try {
            try {
                cursorQuery = zzawVarZzj.zzj().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(iZzh));
                try {
                    if (cursorQuery.moveToFirst()) {
                        ArrayList arrayList5 = new ArrayList();
                        int length = 0;
                        while (true) {
                            long j2 = cursorQuery.getLong(i6);
                            try {
                                byte[] blob = cursorQuery.getBlob(i7);
                                zzqa zzqaVarZzA = zzawVarZzj.zzg.zzA();
                                try {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i8 = gZIPInputStream.read(bArr);
                                        if (i8 <= 0) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(bArr, 0, i8);
                                        }
                                    }
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (!arrayList5.isEmpty() && byteArray.length + length > iMax) {
                                        break;
                                    }
                                    try {
                                        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzqa.zzp(com.google.android.gms.internal.measurement.zzhx.zzz(), byteArray);
                                        if (!arrayList5.isEmpty()) {
                                            com.google.android.gms.internal.measurement.zzhx zzhxVar3 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) arrayList5.get(0)).first;
                                            com.google.android.gms.internal.measurement.zzhx zzhxVar4 = (com.google.android.gms.internal.measurement.zzhx) zzhwVar2.zzba();
                                            if (!zzhxVar3.zzK().equals(zzhxVar4.zzK()) || !zzhxVar3.zzJ().equals(zzhxVar4.zzJ()) || zzhxVar3.zzbu() != zzhxVar4.zzbu() || !zzhxVar3.zzL().equals(zzhxVar4.zzL())) {
                                                break;
                                            }
                                            Iterator it6 = zzhxVar3.zzY().iterator();
                                            while (true) {
                                                jZzc = -1;
                                                if (!it6.hasNext()) {
                                                    jZzc2 = -1;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzio zzioVar = (com.google.android.gms.internal.measurement.zzio) it6.next();
                                                if ("_npa".equals(zzioVar.zzg())) {
                                                    jZzc2 = zzioVar.zzc();
                                                    break;
                                                }
                                            }
                                            for (com.google.android.gms.internal.measurement.zzio zzioVar2 : zzhxVar4.zzY()) {
                                                if ("_npa".equals(zzioVar2.zzg())) {
                                                    jZzc = zzioVar2.zzc();
                                                    break;
                                                }
                                            }
                                            if (jZzc2 != jZzc) {
                                                break;
                                            }
                                        }
                                        if (!cursorQuery.isNull(2)) {
                                            zzhwVar2.zzat(cursorQuery.getInt(2));
                                        }
                                        length += byteArray.length;
                                        arrayList5.add(Pair.create((com.google.android.gms.internal.measurement.zzhx) zzhwVar2.zzba(), Long.valueOf(j2)));
                                    } catch (IOException e) {
                                        zzawVarZzj.zzu.zzaW().zze().zzc("Failed to merge queued bundle. appId", zzhe.zzn(str), e);
                                    }
                                    if (!cursorQuery.moveToNext() || length > iMax) {
                                        break;
                                    }
                                    i6 = 0;
                                    i7 = 1;
                                } catch (IOException e2) {
                                    zzqaVarZzA.zzu.zzaW().zze().zzb("Failed to ungzip content", e2);
                                    throw e2;
                                }
                            } catch (IOException e3) {
                                zzawVarZzj.zzu.zzaW().zze().zzc("Failed to unzip queued bundle. appId", zzhe.zzn(str), e3);
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        listEmptyList = arrayList5;
                    } else {
                        listEmptyList = Collections.emptyList();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    zzawVarZzj.zzu.zzaW().zze().zzc("Error querying bundles. appId", zzhe.zzn(str), e);
                    listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                    }
                    if (listEmptyList.isEmpty()) {
                    }
                    if (zzu(str).zzr(zzjw.AD_STORAGE)) {
                        it5 = listEmptyList.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                strZzT = null;
                                break;
                            }
                            zzhxVar2 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) it5.next()).first;
                            if (!zzhxVar2.zzT().isEmpty()) {
                                strZzT = zzhxVar2.zzT();
                                break;
                            }
                        }
                        if (strZzT != null) {
                            for (i5 = 0; i5 < listEmptyList.size(); i5++) {
                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) ((Pair) listEmptyList.get(i5)).first;
                                if (!zzhxVar.zzT().isEmpty()) {
                                    listEmptyList = listEmptyList.subList(0, i5);
                                    break;
                                }
                            }
                        }
                    }
                    zzhtVarZzb = com.google.android.gms.internal.measurement.zzhv.zzb();
                    size = listEmptyList.size();
                    arrayList = new ArrayList(listEmptyList.size());
                    if (zzi().zzy(str)) {
                        z = false;
                    } else {
                        z = false;
                    }
                    zZzr = zzu(str).zzr(zzjw.AD_STORAGE);
                    zZzr2 = zzu(str).zzr(zzjw.ANALYTICS_STORAGE);
                    zzrd.zzb();
                    zZzx = zzi().zzx(str, zzgi.zzaL);
                    zzpiVar = this.zzl;
                    zzphVarZza = zzpiVar.zza(str);
                    i = 0;
                    while (i < size) {
                        zzhwVar = (com.google.android.gms.internal.measurement.zzhw) ((com.google.android.gms.internal.measurement.zzhx) ((Pair) listEmptyList.get(i)).first).zzch();
                        arrayList.add((Long) ((Pair) listEmptyList.get(i)).second);
                        zzi().zzj();
                        zzhwVar.zzaB(119002L);
                        zzhwVar.zzaA(j);
                        List list = listEmptyList;
                        this.zzn.zzaV();
                        i3 = size;
                        zzhwVar.zzau(false);
                        if (!z) {
                            zzhwVar.zzt();
                        }
                        if (!zZzr) {
                            zzhwVar.zzz();
                            zzhwVar.zzw();
                        }
                        if (!zZzr2) {
                            zzhwVar.zzq();
                        }
                        zzN(str, zzhwVar);
                        if (!zZzx) {
                            zzhwVar.zzA();
                        }
                        if (!zZzr2) {
                            zzhwVar.zzr();
                        }
                        strZzaL = zzhwVar.zzaL();
                        if (TextUtils.isEmpty(strZzaL)) {
                            i4 = i3;
                        } else {
                            i4 = i3;
                            if (strZzaL.equals("00000000-0000-0000-0000-000000000000")) {
                                z3 = z;
                                z4 = zZzr;
                                z7 = zZzr2;
                                z8 = zZzx;
                            }
                            if (zzhwVar.zzc() != 0) {
                                if (zzi().zzx(str, zzgi.zzaB)) {
                                    zzhwVar.zzQ(zzA().zzf(((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba()).zzcd()));
                                }
                                if (zzi().zzx(null, zzgi.zzaP)) {
                                    zzhwVar.zzaw(zzimVarZzb);
                                }
                                zzhtVarZzb.zzc(zzhwVar);
                            }
                            i++;
                            listEmptyList = list;
                            size = i4;
                            z = z3;
                            zZzr = z4;
                            zZzx = z8;
                            zZzr2 = z7;
                        }
                        arrayList4 = new ArrayList(zzhwVar.zzaM());
                        it4 = arrayList4.iterator();
                        z3 = z;
                        z4 = zZzr;
                        lValueOf = null;
                        lValueOf2 = null;
                        z5 = false;
                        z6 = false;
                        while (it4.hasNext()) {
                            zZzr2 = zZzr2;
                            zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it4.next();
                            zZzx = zZzx;
                            if ("_fx".equals(zzhmVar.zzh())) {
                                it4.remove();
                                z5 = true;
                            } else if ("_f".equals(zzhmVar.zzh())) {
                                zzA();
                                zzhqVarZzG = zzqa.zzG(zzhmVar, "_pfo");
                                if (zzhqVarZzG != null) {
                                    lValueOf = Long.valueOf(zzhqVarZzG.zzd());
                                }
                                zzA();
                                zzhqVarZzG2 = zzqa.zzG(zzhmVar, "_uwa");
                                if (zzhqVarZzG2 != null) {
                                    lValueOf2 = Long.valueOf(zzhqVarZzG2.zzd());
                                }
                            } else {
                                zZzx = zZzx;
                                zZzr2 = zZzr2;
                            }
                            z6 = true;
                        }
                        z7 = zZzr2;
                        z8 = zZzx;
                        if (z5) {
                            zzhwVar.zzu();
                            zzhwVar.zzj(arrayList4);
                        }
                        if (z6) {
                            zzar(zzhwVar.zzaF(), true, lValueOf, lValueOf2);
                        }
                        if (zzhwVar.zzc() != 0) {
                            if (zzi().zzx(str, zzgi.zzaB)) {
                                zzhwVar.zzQ(zzA().zzf(((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba()).zzcd()));
                            }
                            if (zzi().zzx(null, zzgi.zzaP)) {
                                zzhwVar.zzaw(zzimVarZzb);
                            }
                            zzhtVarZzb.zzc(zzhwVar);
                        }
                        i++;
                        listEmptyList = list;
                        size = i4;
                        z = z3;
                        zZzr = z4;
                        zZzx = z8;
                        zZzr2 = z7;
                    }
                    if (zzhtVarZzb.zza() == 0) {
                        zzal(arrayList);
                        zzY(false, 204, null, null, str, Collections.emptyList());
                        return;
                    }
                    zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                    arrayList2 = new ArrayList();
                    if (zzi().zzx(null, zzgi.zzaP)) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (zzphVarZza.zza() == zzmf.SGTM) {
                        it2 = ((com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba()).zzh().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (((com.google.android.gms.internal.measurement.zzhx) it2.next()).zzbI()) {
                                    string = UUID.randomUUID().toString();
                                    break;
                                }
                            } else {
                                string = null;
                                break;
                            }
                        }
                        com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                        zzaX().zzg();
                        zzM();
                        zzhtVarZzc = com.google.android.gms.internal.measurement.zzhv.zzc(zzhvVar3);
                        if (!TextUtils.isEmpty(string)) {
                            zzhtVarZzc.zzf(string);
                        }
                        strZzm = zzr().zzm(str);
                        if (!TextUtils.isEmpty(strZzm)) {
                            zzhtVarZzc.zzg(strZzm);
                        }
                        arrayList3 = new ArrayList();
                        it3 = zzhvVar3.zzh().iterator();
                        while (it3.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhw zzhwVarZzA = com.google.android.gms.internal.measurement.zzhx.zzA((com.google.android.gms.internal.measurement.zzhx) it3.next());
                            zzhwVarZzA.zzt();
                            arrayList3.add((com.google.android.gms.internal.measurement.zzhx) zzhwVarZzA.zzba());
                        }
                        zzhtVarZzc.zzd();
                        zzhtVarZzc.zzb(arrayList3);
                        zzamVarZzi = zzi();
                        zzggVar = zzgi.zzaN;
                        if (zzamVarZzi.zzx(null, zzggVar)) {
                            zzhc zzhcVarZzj = zzaW().zzj();
                            if (TextUtils.isEmpty(string)) {
                                objZzi = BuildConfig.TRAVIS;
                            } else {
                                objZzi = zzhtVarZzc.zzi();
                            }
                            zzhcVarZzj.zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", objZzi);
                        } else {
                            zzaW().zzj().zza("[sgtm] Processed MeasurementBatch for sGTM.");
                        }
                        zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzc.zzba();
                        if (!TextUtils.isEmpty(string)) {
                            com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                            zzaX().zzg();
                            zzM();
                            zzhtVarZzb2 = com.google.android.gms.internal.measurement.zzhv.zzb();
                            zzaW().zzj().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", string);
                            zzhtVarZzb2.zzf(string);
                            for (com.google.android.gms.internal.measurement.zzhx zzhxVar5 : zzhvVar4.zzh()) {
                                com.google.android.gms.internal.measurement.zzhw zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                zzhwVarZzz.zzY(zzhxVar5.zzN());
                                zzhwVarZzz.zzV(zzhxVar5.zzd());
                                zzhtVarZzb2.zzc(zzhwVarZzz);
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVar5 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb2.zzba();
                            strZzm2 = zzpiVar.zzg.zzr().zzm(str);
                            if (TextUtils.isEmpty(strZzm2)) {
                                String str2 = (String) zzgi.zzr.zza(null);
                                if (z2) {
                                    zzmfVar = zzmf.GOOGLE_SIGNAL_PENDING;
                                } else {
                                    zzmfVar = zzmf.GOOGLE_SIGNAL;
                                }
                                zzphVar = new zzph(str2, Collections.emptyMap(), zzmfVar, null);
                            } else {
                                Uri uri = Uri.parse((String) zzgi.zzr.zza(null));
                                Uri.Builder builderBuildUpon = uri.buildUpon();
                                builderBuildUpon.authority(strZzm2 + "." + uri.getAuthority());
                                String string2 = builderBuildUpon.build().toString();
                                if (z2) {
                                    zzmfVar2 = zzmf.GOOGLE_SIGNAL_PENDING;
                                } else {
                                    zzmfVar2 = zzmf.GOOGLE_SIGNAL;
                                }
                                zzphVar = new zzph(string2, Collections.emptyMap(), zzmfVar2, null);
                            }
                            arrayList2.add(Pair.create(zzhvVar5, zzphVar));
                        }
                        if (z2) {
                            zzhtVar = (com.google.android.gms.internal.measurement.zzht) zzhvVar2.zzch();
                            for (i2 = 0; i2 < zzhvVar2.zza(); i2++) {
                                com.google.android.gms.internal.measurement.zzhw zzhwVar3 = (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zze(i2).zzch();
                                zzhwVar3.zzC();
                                zzhwVar3.zzO(j);
                                zzhtVar.zze(i2, zzhwVar3);
                            }
                            arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba(), zzphVarZza));
                            zzal(arrayList);
                            zzY(false, 204, null, null, str, arrayList2);
                            if (zzay(str, zzphVarZza.zzc())) {
                                zzaW().zzj().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                                Intent intent = new Intent();
                                intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                                intent.setPackage(str);
                                zzaK(this.zzn.zzaT(), intent);
                                return;
                            }
                            return;
                        }
                        zzhvVar = zzhvVar2;
                    } else if (z2) {
                        z2 = true;
                        it2 = ((com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba()).zzh().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (((com.google.android.gms.internal.measurement.zzhx) it2.next()).zzbI()) {
                                    string = UUID.randomUUID().toString();
                                    break;
                                }
                            } else {
                                string = null;
                                break;
                            }
                        }
                        com.google.android.gms.internal.measurement.zzhv zzhvVar6 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                        zzaX().zzg();
                        zzM();
                        zzhtVarZzc = com.google.android.gms.internal.measurement.zzhv.zzc(zzhvVar6);
                        if (!TextUtils.isEmpty(string)) {
                            zzhtVarZzc.zzf(string);
                        }
                        strZzm = zzr().zzm(str);
                        if (!TextUtils.isEmpty(strZzm)) {
                            zzhtVarZzc.zzg(strZzm);
                        }
                        arrayList3 = new ArrayList();
                        it3 = zzhvVar6.zzh().iterator();
                        while (it3.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhw zzhwVarZzA2 = com.google.android.gms.internal.measurement.zzhx.zzA((com.google.android.gms.internal.measurement.zzhx) it3.next());
                            zzhwVarZzA2.zzt();
                            arrayList3.add((com.google.android.gms.internal.measurement.zzhx) zzhwVarZzA2.zzba());
                        }
                        zzhtVarZzc.zzd();
                        zzhtVarZzc.zzb(arrayList3);
                        zzamVarZzi = zzi();
                        zzggVar = zzgi.zzaN;
                        if (zzamVarZzi.zzx(null, zzggVar)) {
                            zzhc zzhcVarZzj2 = zzaW().zzj();
                            if (TextUtils.isEmpty(string)) {
                                objZzi = BuildConfig.TRAVIS;
                            } else {
                                objZzi = zzhtVarZzc.zzi();
                            }
                            zzhcVarZzj2.zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", objZzi);
                        } else {
                            zzaW().zzj().zza("[sgtm] Processed MeasurementBatch for sGTM.");
                        }
                        zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzc.zzba();
                        if (!TextUtils.isEmpty(string)) {
                            com.google.android.gms.internal.measurement.zzhv zzhvVar7 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                            zzaX().zzg();
                            zzM();
                            zzhtVarZzb2 = com.google.android.gms.internal.measurement.zzhv.zzb();
                            zzaW().zzj().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", string);
                            zzhtVarZzb2.zzf(string);
                            while (r0.hasNext()) {
                                com.google.android.gms.internal.measurement.zzhw zzhwVarZzz2 = com.google.android.gms.internal.measurement.zzhx.zzz();
                                zzhwVarZzz2.zzY(zzhxVar5.zzN());
                                zzhwVarZzz2.zzV(zzhxVar5.zzd());
                                zzhtVarZzb2.zzc(zzhwVarZzz2);
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVar8 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb2.zzba();
                            strZzm2 = zzpiVar.zzg.zzr().zzm(str);
                            if (TextUtils.isEmpty(strZzm2)) {
                                Uri uri2 = Uri.parse((String) zzgi.zzr.zza(null));
                                Uri.Builder builderBuildUpon2 = uri2.buildUpon();
                                builderBuildUpon2.authority(strZzm2 + "." + uri2.getAuthority());
                                String string3 = builderBuildUpon2.build().toString();
                                if (z2) {
                                    zzmfVar2 = zzmf.GOOGLE_SIGNAL_PENDING;
                                } else {
                                    zzmfVar2 = zzmf.GOOGLE_SIGNAL;
                                }
                                zzphVar = new zzph(string3, Collections.emptyMap(), zzmfVar2, null);
                            } else {
                                String str3 = (String) zzgi.zzr.zza(null);
                                if (z2) {
                                    zzmfVar = zzmf.GOOGLE_SIGNAL_PENDING;
                                } else {
                                    zzmfVar = zzmf.GOOGLE_SIGNAL;
                                }
                                zzphVar = new zzph(str3, Collections.emptyMap(), zzmfVar, null);
                            }
                            arrayList2.add(Pair.create(zzhvVar8, zzphVar));
                        }
                        if (z2) {
                            zzhtVar = (com.google.android.gms.internal.measurement.zzht) zzhvVar2.zzch();
                            while (i2 < zzhvVar2.zza()) {
                                com.google.android.gms.internal.measurement.zzhw zzhwVar4 = (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zze(i2).zzch();
                                zzhwVar4.zzC();
                                zzhwVar4.zzO(j);
                                zzhtVar.zze(i2, zzhwVar4);
                            }
                            arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba(), zzphVarZza));
                            zzal(arrayList);
                            zzY(false, 204, null, null, str, arrayList2);
                            if (zzay(str, zzphVarZza.zzc())) {
                                zzaW().zzj().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                                Intent intent2 = new Intent();
                                intent2.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                                intent2.setPackage(str);
                                zzaK(this.zzn.zzaT(), intent2);
                                return;
                            }
                            return;
                        }
                        zzhvVar = zzhvVar2;
                    }
                    if (zzi().zzx(null, zzgi.zzaO)) {
                    }
                    if (Log.isLoggable(zzaW().zzr(), 2)) {
                        objZzq = zzA().zzq(zzhvVar);
                    } else {
                        objZzq = null;
                    }
                    zzA();
                    byte[] bArrZzcd = zzhvVar.zzcd();
                    zzal(arrayList);
                    this.zzk.zze.zzb(j);
                    zzaW().zzj().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(bArrZzcd.length), objZzq);
                    this.zzv = true;
                    zzp().zzc(str, zzphVarZza, zzhvVar, new zzpl(this, str, arrayList2));
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (listEmptyList.isEmpty()) {
            if (zzu(str).zzr(zzjw.AD_STORAGE)) {
                it5 = listEmptyList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        strZzT = null;
                        break;
                    }
                    zzhxVar2 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) it5.next()).first;
                    if (!zzhxVar2.zzT().isEmpty()) {
                        strZzT = zzhxVar2.zzT();
                        break;
                    }
                }
                if (strZzT != null) {
                    while (i5 < listEmptyList.size()) {
                        zzhxVar = (com.google.android.gms.internal.measurement.zzhx) ((Pair) listEmptyList.get(i5)).first;
                        if (!zzhxVar.zzT().isEmpty() && !zzhxVar.zzT().equals(strZzT)) {
                            listEmptyList = listEmptyList.subList(0, i5);
                            break;
                        }
                    }
                }
            }
            zzhtVarZzb = com.google.android.gms.internal.measurement.zzhv.zzb();
            size = listEmptyList.size();
            arrayList = new ArrayList(listEmptyList.size());
            if (zzi().zzy(str) || !zzu(str).zzr(zzjw.AD_STORAGE)) {
                z = false;
            } else {
                z = true;
            }
            zZzr = zzu(str).zzr(zzjw.AD_STORAGE);
            zZzr2 = zzu(str).zzr(zzjw.ANALYTICS_STORAGE);
            zzrd.zzb();
            zZzx = zzi().zzx(str, zzgi.zzaL);
            zzpiVar = this.zzl;
            zzphVarZza = zzpiVar.zza(str);
            i = 0;
            while (i < size) {
                zzhwVar = (com.google.android.gms.internal.measurement.zzhw) ((com.google.android.gms.internal.measurement.zzhx) ((Pair) listEmptyList.get(i)).first).zzch();
                arrayList.add((Long) ((Pair) listEmptyList.get(i)).second);
                zzi().zzj();
                zzhwVar.zzaB(119002L);
                zzhwVar.zzaA(j);
                List list2 = listEmptyList;
                this.zzn.zzaV();
                i3 = size;
                zzhwVar.zzau(false);
                if (!z) {
                    zzhwVar.zzt();
                }
                if (!zZzr) {
                    zzhwVar.zzz();
                    zzhwVar.zzw();
                }
                if (!zZzr2) {
                    zzhwVar.zzq();
                }
                zzN(str, zzhwVar);
                if (!zZzx) {
                    zzhwVar.zzA();
                }
                if (!zZzr2) {
                    zzhwVar.zzr();
                }
                strZzaL = zzhwVar.zzaL();
                if (TextUtils.isEmpty(strZzaL)) {
                    i4 = i3;
                    if (strZzaL.equals("00000000-0000-0000-0000-000000000000")) {
                        z3 = z;
                        z4 = zZzr;
                        z7 = zZzr2;
                        z8 = zZzx;
                    }
                    if (zzhwVar.zzc() != 0) {
                        if (zzi().zzx(str, zzgi.zzaB)) {
                            zzhwVar.zzQ(zzA().zzf(((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba()).zzcd()));
                        }
                        if (zzi().zzx(null, zzgi.zzaP) && (zzimVarZzb = zzphVarZza.zzb()) != null) {
                            zzhwVar.zzaw(zzimVarZzb);
                        }
                        zzhtVarZzb.zzc(zzhwVar);
                    }
                    i++;
                    listEmptyList = list2;
                    size = i4;
                    z = z3;
                    zZzr = z4;
                    zZzx = z8;
                    zZzr2 = z7;
                } else {
                    i4 = i3;
                }
                arrayList4 = new ArrayList(zzhwVar.zzaM());
                it4 = arrayList4.iterator();
                z3 = z;
                z4 = zZzr;
                lValueOf = null;
                lValueOf2 = null;
                z5 = false;
                z6 = false;
                while (it4.hasNext()) {
                    zZzr2 = zZzr2;
                    zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it4.next();
                    zZzx = zZzx;
                    if ("_fx".equals(zzhmVar.zzh())) {
                        it4.remove();
                        z5 = true;
                    } else if ("_f".equals(zzhmVar.zzh())) {
                        zzA();
                        zzhqVarZzG = zzqa.zzG(zzhmVar, "_pfo");
                        if (zzhqVarZzG != null) {
                            lValueOf = Long.valueOf(zzhqVarZzG.zzd());
                        }
                        zzA();
                        zzhqVarZzG2 = zzqa.zzG(zzhmVar, "_uwa");
                        if (zzhqVarZzG2 != null) {
                            lValueOf2 = Long.valueOf(zzhqVarZzG2.zzd());
                        }
                    } else {
                        zZzx = zZzx;
                        zZzr2 = zZzr2;
                    }
                    z6 = true;
                }
                z7 = zZzr2;
                z8 = zZzx;
                if (z5) {
                    zzhwVar.zzu();
                    zzhwVar.zzj(arrayList4);
                }
                if (z6) {
                    zzar(zzhwVar.zzaF(), true, lValueOf, lValueOf2);
                }
                if (zzhwVar.zzc() != 0) {
                    if (zzi().zzx(str, zzgi.zzaB)) {
                        zzhwVar.zzQ(zzA().zzf(((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba()).zzcd()));
                    }
                    if (zzi().zzx(null, zzgi.zzaP)) {
                        zzhwVar.zzaw(zzimVarZzb);
                    }
                    zzhtVarZzb.zzc(zzhwVar);
                }
                i++;
                listEmptyList = list2;
                size = i4;
                z = z3;
                zZzr = z4;
                zZzx = z8;
                zZzr2 = z7;
            }
            if (zzhtVarZzb.zza() == 0) {
                zzal(arrayList);
                zzY(false, 204, null, null, str, Collections.emptyList());
                return;
            }
            zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
            arrayList2 = new ArrayList();
            if (zzi().zzx(null, zzgi.zzaP) || zzphVarZza.zza() != zzmf.SGTM_CLIENT) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (zzphVarZza.zza() == zzmf.SGTM) {
                it2 = ((com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba()).zzh().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((com.google.android.gms.internal.measurement.zzhx) it2.next()).zzbI()) {
                            string = UUID.randomUUID().toString();
                            break;
                        }
                    } else {
                        string = null;
                        break;
                    }
                }
                com.google.android.gms.internal.measurement.zzhv zzhvVar9 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                zzaX().zzg();
                zzM();
                zzhtVarZzc = com.google.android.gms.internal.measurement.zzhv.zzc(zzhvVar9);
                if (!TextUtils.isEmpty(string)) {
                    zzhtVarZzc.zzf(string);
                }
                strZzm = zzr().zzm(str);
                if (!TextUtils.isEmpty(strZzm)) {
                    zzhtVarZzc.zzg(strZzm);
                }
                arrayList3 = new ArrayList();
                it3 = zzhvVar9.zzh().iterator();
                while (it3.hasNext()) {
                    com.google.android.gms.internal.measurement.zzhw zzhwVarZzA3 = com.google.android.gms.internal.measurement.zzhx.zzA((com.google.android.gms.internal.measurement.zzhx) it3.next());
                    zzhwVarZzA3.zzt();
                    arrayList3.add((com.google.android.gms.internal.measurement.zzhx) zzhwVarZzA3.zzba());
                }
                zzhtVarZzc.zzd();
                zzhtVarZzc.zzb(arrayList3);
                zzamVarZzi = zzi();
                zzggVar = zzgi.zzaN;
                if (zzamVarZzi.zzx(null, zzggVar)) {
                    zzhc zzhcVarZzj3 = zzaW().zzj();
                    if (TextUtils.isEmpty(string)) {
                        objZzi = BuildConfig.TRAVIS;
                    } else {
                        objZzi = zzhtVarZzc.zzi();
                    }
                    zzhcVarZzj3.zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", objZzi);
                } else {
                    zzaW().zzj().zza("[sgtm] Processed MeasurementBatch for sGTM.");
                }
                zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzc.zzba();
                if (!TextUtils.isEmpty(string) && zzi().zzx(null, zzggVar)) {
                    com.google.android.gms.internal.measurement.zzhv zzhvVar10 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                    zzaX().zzg();
                    zzM();
                    zzhtVarZzb2 = com.google.android.gms.internal.measurement.zzhv.zzb();
                    zzaW().zzj().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", string);
                    zzhtVarZzb2.zzf(string);
                    while (r0.hasNext()) {
                        com.google.android.gms.internal.measurement.zzhw zzhwVarZzz3 = com.google.android.gms.internal.measurement.zzhx.zzz();
                        zzhwVarZzz3.zzY(zzhxVar5.zzN());
                        zzhwVarZzz3.zzV(zzhxVar5.zzd());
                        zzhtVarZzb2.zzc(zzhwVarZzz3);
                    }
                    com.google.android.gms.internal.measurement.zzhv zzhvVar11 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb2.zzba();
                    strZzm2 = zzpiVar.zzg.zzr().zzm(str);
                    if (TextUtils.isEmpty(strZzm2)) {
                        Uri uri3 = Uri.parse((String) zzgi.zzr.zza(null));
                        Uri.Builder builderBuildUpon3 = uri3.buildUpon();
                        builderBuildUpon3.authority(strZzm2 + "." + uri3.getAuthority());
                        String string4 = builderBuildUpon3.build().toString();
                        if (z2) {
                            zzmfVar2 = zzmf.GOOGLE_SIGNAL_PENDING;
                        } else {
                            zzmfVar2 = zzmf.GOOGLE_SIGNAL;
                        }
                        zzphVar = new zzph(string4, Collections.emptyMap(), zzmfVar2, null);
                    } else {
                        String str4 = (String) zzgi.zzr.zza(null);
                        if (z2) {
                            zzmfVar = zzmf.GOOGLE_SIGNAL_PENDING;
                        } else {
                            zzmfVar = zzmf.GOOGLE_SIGNAL;
                        }
                        zzphVar = new zzph(str4, Collections.emptyMap(), zzmfVar, null);
                    }
                    arrayList2.add(Pair.create(zzhvVar11, zzphVar));
                }
                if (z2) {
                    zzhtVar = (com.google.android.gms.internal.measurement.zzht) zzhvVar2.zzch();
                    while (i2 < zzhvVar2.zza()) {
                        com.google.android.gms.internal.measurement.zzhw zzhwVar5 = (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zze(i2).zzch();
                        zzhwVar5.zzC();
                        zzhwVar5.zzO(j);
                        zzhtVar.zze(i2, zzhwVar5);
                    }
                    arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba(), zzphVarZza));
                    zzal(arrayList);
                    zzY(false, 204, null, null, str, arrayList2);
                    if (zzay(str, zzphVarZza.zzc())) {
                        zzaW().zzj().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                        Intent intent3 = new Intent();
                        intent3.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                        intent3.setPackage(str);
                        zzaK(this.zzn.zzaT(), intent3);
                        return;
                    }
                    return;
                }
                zzhvVar = zzhvVar2;
            } else if (z2) {
                z2 = true;
                it2 = ((com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba()).zzh().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((com.google.android.gms.internal.measurement.zzhx) it2.next()).zzbI()) {
                            string = UUID.randomUUID().toString();
                            break;
                        }
                    } else {
                        string = null;
                        break;
                    }
                }
                com.google.android.gms.internal.measurement.zzhv zzhvVar12 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                zzaX().zzg();
                zzM();
                zzhtVarZzc = com.google.android.gms.internal.measurement.zzhv.zzc(zzhvVar12);
                if (!TextUtils.isEmpty(string)) {
                    zzhtVarZzc.zzf(string);
                }
                strZzm = zzr().zzm(str);
                if (!TextUtils.isEmpty(strZzm)) {
                    zzhtVarZzc.zzg(strZzm);
                }
                arrayList3 = new ArrayList();
                it3 = zzhvVar12.zzh().iterator();
                while (it3.hasNext()) {
                    com.google.android.gms.internal.measurement.zzhw zzhwVarZzA4 = com.google.android.gms.internal.measurement.zzhx.zzA((com.google.android.gms.internal.measurement.zzhx) it3.next());
                    zzhwVarZzA4.zzt();
                    arrayList3.add((com.google.android.gms.internal.measurement.zzhx) zzhwVarZzA4.zzba());
                }
                zzhtVarZzc.zzd();
                zzhtVarZzc.zzb(arrayList3);
                zzamVarZzi = zzi();
                zzggVar = zzgi.zzaN;
                if (zzamVarZzi.zzx(null, zzggVar)) {
                    zzhc zzhcVarZzj4 = zzaW().zzj();
                    if (TextUtils.isEmpty(string)) {
                        objZzi = BuildConfig.TRAVIS;
                    } else {
                        objZzi = zzhtVarZzc.zzi();
                    }
                    zzhcVarZzj4.zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", objZzi);
                } else {
                    zzaW().zzj().zza("[sgtm] Processed MeasurementBatch for sGTM.");
                }
                zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzc.zzba();
                if (!TextUtils.isEmpty(string)) {
                    com.google.android.gms.internal.measurement.zzhv zzhvVar13 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb.zzba();
                    zzaX().zzg();
                    zzM();
                    zzhtVarZzb2 = com.google.android.gms.internal.measurement.zzhv.zzb();
                    zzaW().zzj().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", string);
                    zzhtVarZzb2.zzf(string);
                    while (r0.hasNext()) {
                        com.google.android.gms.internal.measurement.zzhw zzhwVarZzz4 = com.google.android.gms.internal.measurement.zzhx.zzz();
                        zzhwVarZzz4.zzY(zzhxVar5.zzN());
                        zzhwVarZzz4.zzV(zzhxVar5.zzd());
                        zzhtVarZzb2.zzc(zzhwVarZzz4);
                    }
                    com.google.android.gms.internal.measurement.zzhv zzhvVar14 = (com.google.android.gms.internal.measurement.zzhv) zzhtVarZzb2.zzba();
                    strZzm2 = zzpiVar.zzg.zzr().zzm(str);
                    if (TextUtils.isEmpty(strZzm2)) {
                        Uri uri4 = Uri.parse((String) zzgi.zzr.zza(null));
                        Uri.Builder builderBuildUpon4 = uri4.buildUpon();
                        builderBuildUpon4.authority(strZzm2 + "." + uri4.getAuthority());
                        String string5 = builderBuildUpon4.build().toString();
                        if (z2) {
                            zzmfVar2 = zzmf.GOOGLE_SIGNAL_PENDING;
                        } else {
                            zzmfVar2 = zzmf.GOOGLE_SIGNAL;
                        }
                        zzphVar = new zzph(string5, Collections.emptyMap(), zzmfVar2, null);
                    } else {
                        String str5 = (String) zzgi.zzr.zza(null);
                        if (z2) {
                            zzmfVar = zzmf.GOOGLE_SIGNAL_PENDING;
                        } else {
                            zzmfVar = zzmf.GOOGLE_SIGNAL;
                        }
                        zzphVar = new zzph(str5, Collections.emptyMap(), zzmfVar, null);
                    }
                    arrayList2.add(Pair.create(zzhvVar14, zzphVar));
                }
                if (z2) {
                    zzhtVar = (com.google.android.gms.internal.measurement.zzht) zzhvVar2.zzch();
                    while (i2 < zzhvVar2.zza()) {
                        com.google.android.gms.internal.measurement.zzhw zzhwVar6 = (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zze(i2).zzch();
                        zzhwVar6.zzC();
                        zzhwVar6.zzO(j);
                        zzhtVar.zze(i2, zzhwVar6);
                    }
                    arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba(), zzphVarZza));
                    zzal(arrayList);
                    zzY(false, 204, null, null, str, arrayList2);
                    if (zzay(str, zzphVarZza.zzc())) {
                        zzaW().zzj().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                        Intent intent4 = new Intent();
                        intent4.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                        intent4.setPackage(str);
                        zzaK(this.zzn.zzaT(), intent4);
                        return;
                    }
                    return;
                }
                zzhvVar = zzhvVar2;
            }
            if (zzi().zzx(null, zzgi.zzaO) || zzp().zzd()) {
                if (Log.isLoggable(zzaW().zzr(), 2)) {
                    objZzq = zzA().zzq(zzhvVar);
                } else {
                    objZzq = null;
                }
                zzA();
                byte[] bArrZzcd2 = zzhvVar.zzcd();
                zzal(arrayList);
                this.zzk.zze.zzb(j);
                zzaW().zzj().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(bArrZzcd2.length), objZzq);
                this.zzv = true;
                zzp().zzc(str, zzphVarZza, zzhvVar, new zzpl(this, str, arrayList2));
            }
        }
    }

    final void zzav(String str) {
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzg;
        zzaX().zzg();
        zzM();
        this.zzw = true;
        try {
            zzio zzioVar = this.zzn;
            zzioVar.zzaV();
            Boolean boolZzl = zzioVar.zzu().zzl();
            if (boolZzl == null) {
                zzaW().zzk().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzl.booleanValue()) {
                zzaW().zze().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaL();
            } else if (!zzp().zzd()) {
                zzaW().zzj().zza("Network not connected, ignoring upload request");
                zzaL();
            } else if (zzj().zzY(str)) {
                zzpz zzpzVarZzw = zzj().zzw(str);
                if (zzpzVarZzw != null && (zzhvVarZzg = zzpzVarZzw.zzg()) != null) {
                    zzaW().zzj().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpzVarZzw.zzd(), zzpzVarZzw.zzh());
                    byte[] bArrZzcd = zzhvVarZzg.zzcd();
                    if (Log.isLoggable(zzaW().zzr(), 2)) {
                        zzaW().zzj().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrZzcd.length), zzA().zzq(zzhvVarZzg));
                    }
                    this.zzv = true;
                    zzp().zzc(str, zzpzVarZzw.zzf(), zzhvVarZzg, new zzpm(this, str, zzpzVarZzw));
                }
            } else {
                zzaW().zzj().zzb("[sgtm] Upload queue has no batches for appId", str);
            }
        } finally {
            this.zzw = false;
            zzaH();
        }
    }

    final void zzaw(String str, com.google.android.gms.internal.measurement.zzhp zzhpVar, Bundle bundle, String str2) {
        List listListOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        long jZzd = (zzqf.zzap(zzhpVar.zzl()) || zzqf.zzap(str)) ? zzi().zzd(str2, true) : zzi().zzc(str2, true);
        long jCodePointCount = zzhpVar.zzm().codePointCount(0, zzhpVar.zzm().length());
        zzqf zzqfVarZzB = zzB();
        String strZzl = zzhpVar.zzl();
        zzi();
        String strZzG = zzqfVarZzB.zzG(strZzl, 40, true);
        if (jCodePointCount <= jZzd || listListOf.contains(zzhpVar.zzl())) {
            return;
        }
        if ("_ev".equals(zzhpVar.zzl())) {
            bundle.putString("_ev", zzB().zzG(zzhpVar.zzm(), zzi().zzd(str2, true), true));
            return;
        }
        zzaW().zzl().zzc("Param value is too long; discarded. Name, value length", strZzG, Long.valueOf(jCodePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strZzG);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(zzhpVar.zzl());
    }

    /* JADX WARN: Code duplicated, block: B:102:0x037c A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0383 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:108:0x03a7 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x03bf A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x03c6 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:116:0x0401 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x041e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0424 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0444 A[Catch: all -> 0x0bc1, TRY_LEAVE, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0463 A[Catch: all -> 0x0bc1, TRY_ENTER, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x047a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0484 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0496 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x04aa A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x0528 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0569 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x057e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:168:0x05d8 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x061c A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x0627 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x0632 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x063d A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x0649 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x065a A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0684 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x068c A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x069e A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0741  */
    /* JADX WARN: Code duplicated, block: B:240:0x074b A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:243:0x0774 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x0779 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:246:0x077f A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:265:0x0804  */
    /* JADX WARN: Code duplicated, block: B:267:0x0807 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:270:0x0817 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x083a A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:296:0x08ca  */
    /* JADX WARN: Code duplicated, block: B:299:0x090a A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:301:0x0914 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:304:0x0921 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:306:0x093e A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:308:0x0980  */
    /* JADX WARN: Code duplicated, block: B:311:0x0989 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:316:0x09aa A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:320:0x09c6 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:322:0x0a02 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:333:0x0a84 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:338:0x0abe A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:345:0x0b2e A[Catch: SQLiteException -> 0x0b47, all -> 0x0bc1, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0b47, blocks: (B:343:0x0b1d, B:345:0x0b2e), top: B:369:0x0b1d, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:347:0x0b42  */
    /* JADX WARN: Code duplicated, block: B:395:0x0a21 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:398:0x0a94 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:0x0a91 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:400:? A[LOOP:3: B:331:0x0a7e->B:400:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:0x0333 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x031d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x019f A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01b4 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:68:0x01fe A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0210 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x021e A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0265 A[Catch: all -> 0x0bc1, TRY_LEAVE, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x02cf A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0313  */
    /* JADX WARN: Code duplicated, block: B:94:0x0316 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0323 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x0302, B:100:0x0339, B:102:0x037c, B:104:0x0383, B:105:0x039a, B:108:0x03a7, B:110:0x03bf, B:112:0x03c6, B:113:0x03dd, B:116:0x0401, B:120:0x0424, B:121:0x043b, B:122:0x0444, B:125:0x0463, B:127:0x047c, B:129:0x0484, B:131:0x0490, B:133:0x0496, B:134:0x049d, B:136:0x04aa, B:138:0x04b2, B:140:0x04ba, B:142:0x04c2, B:144:0x04c6, B:145:0x04d2, B:146:0x04df, B:148:0x0504, B:158:0x0528, B:159:0x053d, B:161:0x0569, B:164:0x0580, B:167:0x05bc, B:169:0x05e4, B:171:0x061c, B:172:0x061f, B:174:0x0627, B:175:0x062a, B:177:0x0632, B:178:0x0635, B:180:0x063d, B:181:0x0640, B:183:0x0649, B:184:0x064d, B:186:0x065a, B:187:0x065d, B:189:0x0684, B:191:0x068c, B:192:0x068f, B:194:0x069e, B:196:0x06a8, B:200:0x06bf, B:205:0x06cc, B:238:0x0743, B:240:0x074b, B:241:0x074e, B:243:0x0774, B:246:0x077f, B:249:0x0787, B:250:0x07a1, B:252:0x07a7, B:254:0x07bb, B:256:0x07c7, B:258:0x07d4, B:262:0x07ee, B:263:0x07fe, B:267:0x0807, B:268:0x080a, B:270:0x0817, B:271:0x081c, B:273:0x083a, B:275:0x083e, B:277:0x084e, B:279:0x0859, B:280:0x0864, B:282:0x086e, B:284:0x087a, B:286:0x0884, B:288:0x088a, B:290:0x089a, B:292:0x08ae, B:294:0x08b4, B:295:0x08bd, B:297:0x08ce, B:299:0x090a, B:301:0x0914, B:302:0x0917, B:304:0x0921, B:306:0x093e, B:307:0x0949, B:309:0x0981, B:311:0x0989, B:313:0x0993, B:314:0x09a0, B:316:0x09aa, B:317:0x09b7, B:318:0x09c0, B:320:0x09c6, B:322:0x0a02, B:324:0x0a0c, B:326:0x0a1e, B:328:0x0a24, B:329:0x0a68, B:330:0x0a73, B:331:0x0a7e, B:333:0x0a84, B:342:0x0ad2, B:343:0x0b1d, B:345:0x0b2e, B:359:0x0b90, B:348:0x0b44, B:350:0x0b48, B:336:0x0a94, B:338:0x0abe, B:354:0x0b61, B:355:0x0b78, B:358:0x0b7b, B:244:0x0779, B:208:0x06d7, B:212:0x06e3, B:216:0x06f1, B:220:0x06ff, B:224:0x070d, B:228:0x071b, B:232:0x0727, B:236:0x0734, B:168:0x05d8, B:155:0x0510, B:94:0x0316, B:95:0x031d, B:97:0x0323, B:99:0x0333, B:54:0x0195, B:56:0x019f, B:58:0x01b4, B:64:0x01d4, B:69:0x020a, B:71:0x0210, B:73:0x021e, B:75:0x0232, B:78:0x0239, B:87:0x02c5, B:89:0x02cf, B:80:0x0265, B:81:0x0285, B:86:0x02ac, B:85:0x0299, B:67:0x01e0, B:68:0x01fe), top: B:371:0x0157, inners: #0, #1, #2, #8 }] */
    final void zzax(zzbh zzbhVar, zzr zzrVar) {
        zzbf zzbfVar;
        String strZzg;
        long jLongValue;
        String upperCase;
        String strConcat;
        zzqd zzqdVarZzy;
        zzbh zzbhVar2;
        zzaw zzawVarZzj;
        zzqd zzqdVar;
        zzqd zzqdVar2;
        double dDoubleValue;
        String str;
        boolean zZzaq;
        boolean zEquals;
        zzbf zzbfVar2;
        zzbe zzbeVar;
        long length;
        Object objZzf;
        zzbh zzbhVar3;
        zzas zzasVarZzp;
        long jZzH;
        Bundle bundleZzc;
        zzaw zzawVarZzj2;
        String str2;
        long jDelete;
        zzbc zzbcVar;
        zzio zzioVar;
        String str3;
        String str4;
        zzbd zzbdVarZzs;
        zzbd zzbdVarZzc;
        String str5;
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzz;
        String str6;
        String str7;
        String str8;
        long j;
        String str9;
        long j2;
        com.google.android.gms.internal.measurement.zzjm zzjmVarZza;
        Map mapZzd;
        ArrayList arrayList;
        String str10;
        zzjx zzjxVarZzl;
        zzjw zzjwVar;
        String str11;
        zzio zzioVar2;
        zzh zzhVarZzl;
        int i;
        List listZzE;
        int i2;
        zzaw zzawVarZzj3;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        zzaw zzawVarZzj4;
        zzbe zzbeVar2;
        boolean zZzw;
        int i3;
        String str12;
        ContentValues contentValues;
        String next;
        zzh zzhVarZzl2;
        String str13;
        Object obj;
        zzqd zzqdVarZzy2;
        Object obj2;
        long jMax;
        long jIntValue;
        String str14 = "app_id";
        String str15 = "_fx";
        String str16 = "raw_events";
        Preconditions.checkNotNull(zzrVar);
        String str17 = zzrVar.zza;
        Preconditions.checkNotEmpty(str17);
        long jNanoTime = System.nanoTime();
        zzaX().zzg();
        zzM();
        zzA();
        if (zzqa.zzE(zzbhVar, zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzif zzifVarZzr = zzr();
            String str18 = zzbhVar.zza;
            String str19 = "_err";
            if (zzifVarZzr.zzx(str17, str18)) {
                zzaW().zzk().zzc("Dropping blocked event. appId", zzhe.zzn(str17), this.zzn.zzj().zzd(str18));
                if (!zzr().zzt(str17) && !zzr().zzy(str17)) {
                    if ("_err".equals(str18)) {
                        return;
                    }
                    zzB().zzR(this.zzK, str17, 11, "_ev", str18, 0);
                    return;
                }
                zzh zzhVarZzl3 = zzj().zzl(str17);
                if (zzhVarZzl3 != null) {
                    long jAbs = Math.abs(zzaU().currentTimeMillis() - Math.max(zzhVarZzl3.zzp(), zzhVarZzl3.zzg()));
                    zzi();
                    if (jAbs > ((Long) zzgi.zzM.zza(null)).longValue()) {
                        zzaW().zzd().zza("Fetching config for blocked app");
                        zzO(zzhVarZzl3);
                        return;
                    }
                    return;
                }
                return;
            }
            zzhf zzhfVarZzb = zzhf.zzb(zzbhVar);
            zzB().zzQ(zzhfVarZzb, zzi().zzf(str17));
            int iZzi = zzi().zzi(str17, zzgi.zzaf, 10, 35);
            Bundle bundle = zzhfVarZzb.zzd;
            for (String str20 : new TreeSet(bundle.keySet())) {
                if (FirebaseAnalytics.Param.ITEMS.equals(str20)) {
                    zzB().zzP(bundle.getParcelableArray(str20), iZzi);
                }
            }
            zzbh zzbhVarZza = zzhfVarZzb.zza();
            if (Log.isLoggable(zzaW().zzr(), 2)) {
                zzaW().zzj().zzb("Logging event", this.zzn.zzj().zzc(zzbhVarZza));
            }
            zzj().zzH();
            try {
                zzg(zzrVar);
                String str21 = zzbhVarZza.zza;
                boolean z = "ecommerce_purchase".equals(str21) || FirebaseAnalytics.Event.PURCHASE.equals(str21) || FirebaseAnalytics.Event.REFUND.equals(str21);
                if ("_iap".equals(str21)) {
                    zzbfVar = zzbhVarZza.zzb;
                    strZzg = zzbfVar.zzg(FirebaseAnalytics.Param.CURRENCY);
                    if (z) {
                        dDoubleValue = zzbfVar.zzd("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            dDoubleValue = zzbfVar.zze("value").longValue() * 1000000.0d;
                        }
                        if (dDoubleValue <= 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            zzaW().zzk().zzc("Data lost. Currency value is too big. appId", zzhe.zzn(str17), Double.valueOf(dDoubleValue));
                            zzj().zzS();
                        } else {
                            jLongValue = Math.round(dDoubleValue);
                            if (FirebaseAnalytics.Event.REFUND.equals(str21)) {
                                jLongValue = -jLongValue;
                            }
                        }
                    } else {
                        str14 = "app_id";
                        str15 = "_fx";
                        jLongValue = zzbfVar.zze("value").longValue();
                    }
                    if (!TextUtils.isEmpty(strZzg)) {
                        upperCase = strZzg.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            strConcat = "_ltv_".concat(String.valueOf(upperCase));
                            zzqdVarZzy = zzj().zzy(str17, strConcat);
                            if (zzqdVarZzy == null && (zzqdVarZzy.zze instanceof Long)) {
                                zzbhVar2 = zzbhVarZza;
                                zzqdVar = new zzqd(str17, zzbhVarZza.zzc, strConcat, zzaU().currentTimeMillis(), Long.valueOf(((Long) zzqdVarZzy.zze).longValue() + jLongValue));
                            } else {
                                zzbhVar2 = zzbhVarZza;
                                zzawVarZzj = zzj();
                                int iZzh = zzi().zzh(str17, zzgi.zzS) - 1;
                                Preconditions.checkNotEmpty(str17);
                                zzawVarZzj.zzg();
                                zzawVarZzj.zzav();
                                try {
                                    zzawVarZzj.zzj().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str17, str17, String.valueOf(iZzh)});
                                } catch (SQLiteException e) {
                                    zzawVarZzj.zzu.zzaW().zze().zzc("Error pruning currencies. appId", zzhe.zzn(str17), e);
                                }
                                zzqdVar = new zzqd(str17, zzbhVar2.zzc, strConcat, zzaU().currentTimeMillis(), Long.valueOf(jLongValue));
                            }
                            zzqdVar2 = zzqdVar;
                            if (!zzj().zzai(zzqdVar2)) {
                                zzaW().zze().zzd("Too many unique user properties are set. Ignoring user property. appId", zzhe.zzn(str17), this.zzn.zzj().zzf(zzqdVar2.zzc), zzqdVar2.zze);
                                zzB().zzR(this.zzK, str17, 9, null, null, 0);
                            }
                            str = zzbhVar2.zza;
                            zZzaq = zzqf.zzaq(str);
                            zEquals = str19.equals(str);
                            zzB();
                            zzbfVar2 = zzbhVar2.zzb;
                            if (zzbfVar2 == null) {
                                length = 0;
                            } else {
                                zzbeVar = new zzbe(zzbfVar2);
                                length = 0;
                                while (zzbeVar.hasNext()) {
                                    String next2 = zzbeVar.next();
                                    String str22 = next2;
                                    objZzf = zzbfVar2.zzf(next2);
                                    if (objZzf instanceof Parcelable[]) {
                                        length += (long) ((Parcelable[]) objZzf).length;
                                    }
                                }
                            }
                            zzbhVar3 = zzbhVar2;
                            zzasVarZzp = zzj().zzp(zza(), str17, length + 1, true, zZzaq, false, zEquals, false, false, false);
                            long j3 = zzasVarZzp.zzb;
                            zzi();
                            jZzH = j3 - zzam.zzH();
                            if (jZzH > 0) {
                                if (jZzH % 1000 == 1) {
                                    zzaW().zze().zzc("Data loss. Too many events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzb));
                                }
                                zzj().zzS();
                            } else if (zZzaq) {
                                long j4 = zzasVarZzp.zza;
                                zzi();
                                jIntValue = j4 - ((long) ((Integer) zzgi.zzm.zza(null)).intValue());
                                if (jIntValue > 0) {
                                    if (jIntValue % 1000 == 1) {
                                        zzaW().zze().zzc("Data loss. Too many public events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zza));
                                    }
                                    zzB().zzR(this.zzK, str17, 16, "_ev", zzbhVar3.zza, 0);
                                    zzj().zzS();
                                } else {
                                    if (zEquals) {
                                        bundleZzc = zzbfVar2.zzc();
                                        zzqf zzqfVarZzB = zzB();
                                        String str23 = zzbhVar3.zzc;
                                        zzqfVarZzB.zzS(bundleZzc, "_o", str23);
                                        if (zzB().zzak(str17, zzrVar.zzD)) {
                                            zzB().zzS(bundleZzc, "_dbg", 1L);
                                            zzB().zzS(bundleZzc, "_r", 1L);
                                        }
                                        if ("_s".equals(str)) {
                                            obj2 = zzqdVarZzy2.zze;
                                            if (obj2 instanceof Long) {
                                                zzB().zzS(bundleZzc, "_sno", obj2);
                                            }
                                        }
                                        if (zzi().zzx(null, zzgi.zzbg)) {
                                            double d = Double.parseDouble((String) obj);
                                            bundleZzc.remove("value");
                                            bundleZzc.putDouble("value", d);
                                        }
                                        zzawVarZzj2 = zzj();
                                        Preconditions.checkNotEmpty(str17);
                                        zzawVarZzj2.zzg();
                                        zzawVarZzj2.zzav();
                                        str2 = str16;
                                        jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                        if (jDelete > 0) {
                                            zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                        }
                                        zzioVar = this.zzn;
                                        str3 = str2;
                                        zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                        zzaw zzawVarZzj5 = zzj();
                                        str4 = zzbcVar.zzb;
                                        zzbdVarZzs = zzawVarZzj5.zzs(str17, str4);
                                        if (zzbdVarZzs != null) {
                                            if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                            }
                                            zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                        } else {
                                            zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                            zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                        }
                                        zzj().zzV(zzbdVarZzc);
                                        zzaX().zzg();
                                        zzM();
                                        Preconditions.checkNotNull(zzbcVar);
                                        Preconditions.checkNotNull(zzrVar);
                                        String str24 = zzbcVar.zza;
                                        Preconditions.checkNotEmpty(str24);
                                        str5 = zzrVar.zza;
                                        Preconditions.checkArgument(str24.equals(str5));
                                        zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                        boolean z2 = true;
                                        zzhwVarZzz.zzar(1);
                                        zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                        if (!TextUtils.isEmpty(str5)) {
                                            zzhwVarZzz.zzI(str5);
                                        }
                                        str6 = zzrVar.zzd;
                                        if (!TextUtils.isEmpty(str6)) {
                                            zzhwVarZzz.zzK(str6);
                                        }
                                        str7 = zzrVar.zzc;
                                        if (!TextUtils.isEmpty(str7)) {
                                            zzhwVarZzz.zzL(str7);
                                        }
                                        str8 = zzrVar.zzw;
                                        if (!TextUtils.isEmpty(str8)) {
                                            zzhwVarZzz.zzav(str8);
                                        }
                                        j = zzrVar.zzj;
                                        if (j != -2147483648L) {
                                            zzhwVarZzz.zzM((int) j);
                                        }
                                        zzhwVarZzz.zzai(zzrVar.zze);
                                        str9 = zzrVar.zzb;
                                        if (!TextUtils.isEmpty(str9)) {
                                            zzhwVarZzz.zzah(str9);
                                        }
                                        zzjx zzjxVarZzl2 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzhwVarZzz.zzT(zzjxVarZzl2.zzp());
                                        if (zzhwVarZzz.zzaJ().isEmpty()) {
                                            str13 = zzrVar.zzp;
                                            if (!TextUtils.isEmpty(str13)) {
                                                zzhwVarZzz.zzH(str13);
                                            }
                                        }
                                        zzqr.zzb();
                                        if (!zzi().zzx(str5, zzgi.zzaV)) {
                                        }
                                        j2 = zzrVar.zzf;
                                        if (j2 != 0) {
                                            zzhwVarZzz.zzW(j2);
                                        }
                                        zzhwVarZzz.zzZ(zzrVar.zzr);
                                        zzqa zzqaVarZzA = zzA();
                                        zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                com.google.android.gms.internal.measurement.zzki.zzc();
                                            }
                                        });
                                        if (zzjmVarZza == null) {
                                            mapZzd = Collections.emptyMap();
                                        } else {
                                            mapZzd = zzjmVarZza.zzd();
                                        }
                                        if (mapZzd != null) {
                                            arrayList = null;
                                        } else {
                                            arrayList = null;
                                        }
                                        if (arrayList != null) {
                                            zzhwVarZzz.zzk(arrayList);
                                        }
                                        if (zzi().zzx(null, zzgi.zzbk)) {
                                            zzhwVarZzz.zzaf("");
                                        }
                                        str10 = zzrVar.zza;
                                        zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzjwVar = zzjw.AD_STORAGE;
                                        if (zzjxVarZzl.zzr(zzjwVar)) {
                                            zzjxVarZzl = zzjxVarZzl;
                                            zzjwVar = zzjwVar;
                                            str11 = "_r";
                                        } else {
                                            zzjxVarZzl = zzjxVarZzl;
                                            zzjwVar = zzjwVar;
                                            str11 = "_r";
                                        }
                                        zzioVar2 = this.zzn;
                                        zzioVar2.zzg().zzv();
                                        zzhwVarZzz.zzX(Build.MODEL);
                                        zzioVar2.zzg().zzv();
                                        zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                        zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                        zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                        zzhwVarZzz.zzay(zzrVar.zzy);
                                        if (zzioVar2.zzJ()) {
                                            zzhwVarZzz.zzaF();
                                            if (!TextUtils.isEmpty(null)) {
                                                zzhwVarZzz.zzY(null);
                                            }
                                        }
                                        zzhVarZzl = zzj().zzl(str10);
                                        if (zzhVarZzl == null) {
                                            zzhVarZzl = new zzh(zzioVar2, str10);
                                            zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                            zzhVarZzl.zzan(zzrVar.zzk);
                                            zzhVarZzl.zzao(zzrVar.zzb);
                                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                                zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                            }
                                            zzhVarZzl.zzat(0L);
                                            zzhVarZzl.zzau(0L);
                                            zzhVarZzl.zzas(0L);
                                            zzhVarZzl.zzX(zzrVar.zzc);
                                            zzhVarZzl.zzY(zzrVar.zzj);
                                            zzhVarZzl.zzW(zzrVar.zzd);
                                            zzhVarZzl.zzap(zzrVar.zze);
                                            zzhVarZzl.zzaj(zzrVar.zzf);
                                            zzhVarZzl.zzav(zzrVar.zzh);
                                            zzhVarZzl.zzal(zzrVar.zzr);
                                            i = 0;
                                            zzj().zzT(zzhVarZzl, false, false);
                                        } else {
                                            i = 0;
                                        }
                                        if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                            zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                        }
                                        if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                            zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                        }
                                        listZzE = zzj().zzE(str10);
                                        for (i2 = i; i2 < listZzE.size(); i2++) {
                                            com.google.android.gms.internal.measurement.zzin zzinVarZze = com.google.android.gms.internal.measurement.zzio.zze();
                                            zzinVarZze.zzf(((zzqd) listZzE.get(i2)).zzc);
                                            zzinVarZze.zzg(((zzqd) listZzE.get(i2)).zzd);
                                            zzA().zzx(zzinVarZze, ((zzqd) listZzE.get(i2)).zze);
                                            zzhwVarZzz.zzo(zzinVarZze);
                                            if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                            }
                                        }
                                        zzawVarZzj3 = zzj();
                                        zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                        zzawVarZzj3.zzg();
                                        zzawVarZzj3.zzav();
                                        Preconditions.checkNotNull(zzhxVar);
                                        Preconditions.checkNotEmpty(zzhxVar.zzF());
                                        byte[] bArrZzcd = zzhxVar.zzcd();
                                        long jZzf = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd);
                                        ContentValues contentValues2 = new ContentValues();
                                        String str25 = str14;
                                        contentValues2.put(str25, zzhxVar.zzF());
                                        contentValues2.put("metadata_fingerprint", Long.valueOf(jZzf));
                                        contentValues2.put("metadata", bArrZzcd);
                                        zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                                        zzawVarZzj4 = zzj();
                                        zzbeVar2 = new zzbe(zzbcVar.zzf);
                                        while (true) {
                                            if (zzbeVar2.hasNext()) {
                                                zzif zzifVarZzr2 = zzr();
                                                String str26 = zzbcVar.zza;
                                                zZzw = zzifVarZzr2.zzw(str26, zzbcVar.zzb);
                                                zzas zzasVarZzo = zzj().zzo(zza(), str26, false, false, false, false, false, false, false);
                                                if (zZzw) {
                                                }
                                                i3 = 0;
                                                break;
                                            }
                                            next = zzbeVar2.next();
                                            String str27 = next;
                                            if (str11.equals(next)) {
                                            }
                                            i3 = 1;
                                            break;
                                        }
                                        zzawVarZzj4.zzg();
                                        zzawVarZzj4.zzav();
                                        Preconditions.checkNotNull(zzbcVar);
                                        str12 = zzbcVar.zza;
                                        Preconditions.checkNotEmpty(str12);
                                        byte[] bArrZzcd2 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                        contentValues = new ContentValues();
                                        contentValues.put(str25, str12);
                                        contentValues.put("name", zzbcVar.zzb);
                                        contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                        contentValues.put("metadata_fingerprint", Long.valueOf(jZzf));
                                        contentValues.put("data", bArrZzcd2);
                                        contentValues.put("realtime", Integer.valueOf(i3));
                                        if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                            zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                        } else {
                                            this.zza = 0L;
                                        }
                                        zzj().zzS();
                                        zzj().zzL();
                                        zzaL();
                                        zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                        return;
                                    }
                                    jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                                    if (jMax <= 0) {
                                        if (jMax == 1) {
                                            zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                                        }
                                        zzj().zzS();
                                    } else {
                                        bundleZzc = zzbfVar2.zzc();
                                        zzqf zzqfVarZzB2 = zzB();
                                        String str28 = zzbhVar3.zzc;
                                        zzqfVarZzB2.zzS(bundleZzc, "_o", str28);
                                        if (zzB().zzak(str17, zzrVar.zzD)) {
                                            zzB().zzS(bundleZzc, "_dbg", 1L);
                                            zzB().zzS(bundleZzc, "_r", 1L);
                                        }
                                        if ("_s".equals(str) && (zzqdVarZzy2 = zzj().zzy(zzrVar.zza, "_sno")) != null) {
                                            obj2 = zzqdVarZzy2.zze;
                                            if (obj2 instanceof Long) {
                                                zzB().zzS(bundleZzc, "_sno", obj2);
                                            }
                                        }
                                        if (zzi().zzx(null, zzgi.zzbg) && Objects.equals(str28, "am") && Objects.equals(str, "_ai") && (obj = bundleZzc.get("value")) != null && (obj instanceof String)) {
                                            try {
                                                double d2 = Double.parseDouble((String) obj);
                                                bundleZzc.remove("value");
                                                bundleZzc.putDouble("value", d2);
                                            } catch (NumberFormatException unused) {
                                            }
                                        }
                                        zzawVarZzj2 = zzj();
                                        Preconditions.checkNotEmpty(str17);
                                        zzawVarZzj2.zzg();
                                        zzawVarZzj2.zzav();
                                        try {
                                            try {
                                                try {
                                                    str2 = str16;
                                                    try {
                                                        jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                                        while (true) {
                                                            if (zzbeVar2.hasNext()) {
                                                                zzif zzifVarZzr3 = zzr();
                                                                String str29 = zzbcVar.zza;
                                                                zZzw = zzifVarZzr3.zzw(str29, zzbcVar.zzb);
                                                                zzas zzasVarZzo2 = zzj().zzo(zza(), str29, false, false, false, false, false, false, false);
                                                                if (zZzw || zzasVarZzo2.zze >= zzi().zzh(str29, zzgi.zzo)) {
                                                                    i3 = 0;
                                                                    break;
                                                                }
                                                            } else {
                                                                next = zzbeVar2.next();
                                                                String str210 = next;
                                                                if (str11.equals(next)) {
                                                                }
                                                            }
                                                            i3 = 1;
                                                            break;
                                                        }
                                                    } catch (SQLiteException e2) {
                                                        e = e2;
                                                        zzawVarZzj2.zzu.zzaW().zze().zzc("Error deleting over the limit events. appId", zzhe.zzn(str17), e);
                                                        jDelete = 0;
                                                    }
                                                } catch (SQLiteException e3) {
                                                    e = e3;
                                                    str2 = str16;
                                                }
                                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                                                zzawVarZzj4 = zzj();
                                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                                zzawVarZzj4.zzg();
                                                zzawVarZzj4.zzav();
                                                Preconditions.checkNotNull(zzbcVar);
                                                str12 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str12);
                                                byte[] bArrZzcd3 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                                contentValues = new ContentValues();
                                                contentValues.put(str25, str12);
                                                contentValues.put("name", zzbcVar.zzb);
                                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf));
                                                contentValues.put("data", bArrZzcd3);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                try {
                                                    if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                        zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                                    } else {
                                                        this.zza = 0L;
                                                    }
                                                } catch (SQLiteException e4) {
                                                    zzawVarZzj4.zzu.zzaW().zze().zzc("Error storing raw event. appId", zzhe.zzn(zzbcVar.zza), e4);
                                                }
                                                zzj().zzS();
                                                zzj().zzL();
                                                zzaL();
                                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            } catch (SQLiteException e5) {
                                                zzawVarZzj3.zzu.zzaW().zze().zzc("Error storing raw event metadata. appId", zzhe.zzn(zzhxVar.zzF()), e5);
                                                throw e5;
                                            }
                                            zzawVarZzj3 = zzj();
                                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                            zzawVarZzj3.zzg();
                                            zzawVarZzj3.zzav();
                                            Preconditions.checkNotNull(zzhxVar);
                                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                                            byte[] bArrZzcd4 = zzhxVar.zzcd();
                                            long jZzf2 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd4);
                                            ContentValues contentValues3 = new ContentValues();
                                            String str211 = str14;
                                            contentValues3.put(str211, zzhxVar.zzF());
                                            contentValues3.put("metadata_fingerprint", Long.valueOf(jZzf2));
                                            contentValues3.put("metadata", bArrZzcd4);
                                        } catch (IOException e6) {
                                            zzaW().zze().zzc("Data loss. Failed to insert raw event metadata. appId", zzhe.zzn(zzhwVarZzz.zzaF()), e6);
                                        }
                                        if (jDelete > 0) {
                                            zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                        }
                                        zzioVar = this.zzn;
                                        str3 = str2;
                                        zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                        zzaw zzawVarZzj6 = zzj();
                                        str4 = zzbcVar.zzb;
                                        zzbdVarZzs = zzawVarZzj6.zzs(str17, str4);
                                        if (zzbdVarZzs != null) {
                                            zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                            zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                        } else if (zzj().zzi(str17) >= zzi().zzb(str17) || !zZzaq) {
                                            zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                        } else {
                                            zzaW().zze().zzd("Too many event names used, ignoring event. appId, name, supported count", zzhe.zzn(str17), zzioVar.zzj().zzd(str4), Integer.valueOf(zzi().zzb(str17)));
                                            zzB().zzR(this.zzK, str17, 8, null, null, 0);
                                        }
                                        zzj().zzV(zzbdVarZzc);
                                        zzaX().zzg();
                                        zzM();
                                        Preconditions.checkNotNull(zzbcVar);
                                        Preconditions.checkNotNull(zzrVar);
                                        String str212 = zzbcVar.zza;
                                        Preconditions.checkNotEmpty(str212);
                                        str5 = zzrVar.zza;
                                        Preconditions.checkArgument(str212.equals(str5));
                                        zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                        boolean z3 = true;
                                        zzhwVarZzz.zzar(1);
                                        zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                        if (!TextUtils.isEmpty(str5)) {
                                            zzhwVarZzz.zzI(str5);
                                        }
                                        str6 = zzrVar.zzd;
                                        if (!TextUtils.isEmpty(str6)) {
                                            zzhwVarZzz.zzK(str6);
                                        }
                                        str7 = zzrVar.zzc;
                                        if (!TextUtils.isEmpty(str7)) {
                                            zzhwVarZzz.zzL(str7);
                                        }
                                        str8 = zzrVar.zzw;
                                        if (!TextUtils.isEmpty(str8)) {
                                            zzhwVarZzz.zzav(str8);
                                        }
                                        j = zzrVar.zzj;
                                        if (j != -2147483648L) {
                                            zzhwVarZzz.zzM((int) j);
                                        }
                                        zzhwVarZzz.zzai(zzrVar.zze);
                                        str9 = zzrVar.zzb;
                                        if (!TextUtils.isEmpty(str9)) {
                                            zzhwVarZzz.zzah(str9);
                                        }
                                        zzjx zzjxVarZzl3 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzhwVarZzz.zzT(zzjxVarZzl3.zzp());
                                        if (zzhwVarZzz.zzaJ().isEmpty()) {
                                            str13 = zzrVar.zzp;
                                            if (!TextUtils.isEmpty(str13)) {
                                                zzhwVarZzz.zzH(str13);
                                            }
                                        }
                                        zzqr.zzb();
                                        if (!zzi().zzx(str5, zzgi.zzaV) && zzB().zzab(str5)) {
                                            zzhwVarZzz.zzG(zzrVar.zzB);
                                            long j5 = zzrVar.zzC;
                                            if (!zzjxVarZzl3.zzr(zzjw.AD_STORAGE) && j5 != 0) {
                                                j5 = (j5 & (-2)) | 32;
                                            }
                                            zzhwVarZzz.zzaa(j5 == 1);
                                            if (j5 != 0) {
                                                com.google.android.gms.internal.measurement.zzhf zzhfVarZza = com.google.android.gms.internal.measurement.zzhg.zza();
                                                if ((j5 & 1) == 0) {
                                                    z3 = false;
                                                }
                                                zzhfVarZza.zzc(z3);
                                                zzhfVarZza.zze((j5 & 2) != 0);
                                                zzhfVarZza.zzf((j5 & 4) != 0);
                                                zzhfVarZza.zzg((j5 & 8) != 0);
                                                zzhfVarZza.zzb((j5 & 16) != 0);
                                                zzhfVarZza.zza((j5 & 32) != 0);
                                                zzhfVarZza.zzd((64 & j5) != 0);
                                                zzhwVarZzz.zzN((com.google.android.gms.internal.measurement.zzhg) zzhfVarZza.zzba());
                                            }
                                        }
                                        j2 = zzrVar.zzf;
                                        if (j2 != 0) {
                                            zzhwVarZzz.zzW(j2);
                                        }
                                        zzhwVarZzz.zzZ(zzrVar.zzr);
                                        zzqa zzqaVarZzA2 = zzA();
                                        zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA2.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                com.google.android.gms.internal.measurement.zzki.zzc();
                                            }
                                        });
                                        if (zzjmVarZza == null) {
                                            mapZzd = Collections.emptyMap();
                                        } else {
                                            mapZzd = zzjmVarZza.zzd();
                                        }
                                        if (mapZzd != null || mapZzd.isEmpty()) {
                                            arrayList = null;
                                        } else {
                                            arrayList = new ArrayList();
                                            int iIntValue = ((Integer) zzgi.zzae.zza(null)).intValue();
                                            for (Map.Entry entry : mapZzd.entrySet()) {
                                                if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                                    try {
                                                        int i4 = Integer.parseInt((String) entry.getValue());
                                                        if (i4 != 0) {
                                                            arrayList.add(Integer.valueOf(i4));
                                                            if (arrayList.size() >= iIntValue) {
                                                                zzqaVarZzA2.zzu.zzaW().zzk().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                                                break;
                                                            }
                                                            continue;
                                                        } else {
                                                            continue;
                                                        }
                                                    } catch (NumberFormatException e7) {
                                                        zzqaVarZzA2.zzu.zzaW().zzk().zzb("Experiment ID NumberFormatException", e7);
                                                    }
                                                }
                                            }
                                            if (arrayList.isEmpty()) {
                                                arrayList = null;
                                            }
                                        }
                                        if (arrayList != null) {
                                            zzhwVarZzz.zzk(arrayList);
                                        }
                                        if (zzi().zzx(null, zzgi.zzbk)) {
                                            zzhwVarZzz.zzaf("");
                                        }
                                        str10 = zzrVar.zza;
                                        zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzjwVar = zzjw.AD_STORAGE;
                                        if (zzjxVarZzl.zzr(zzjwVar) || !zzrVar.zzn) {
                                            zzjxVarZzl = zzjxVarZzl;
                                            zzjwVar = zzjwVar;
                                            str11 = "_r";
                                        } else {
                                            Pair pairZzd = this.zzk.zzd(str10, zzjxVarZzl);
                                            if (TextUtils.isEmpty((CharSequence) pairZzd.first)) {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            } else {
                                                zzhwVarZzz.zzas((String) pairZzd.first);
                                                if (pairZzd.second != null) {
                                                    zzhwVarZzz.zzal(((Boolean) pairZzd.second).booleanValue());
                                                }
                                                String str30 = str15;
                                                if (zzbcVar.zzb.equals(str30) || ((String) pairZzd.first).equals("00000000-0000-0000-0000-000000000000") || (zzhVarZzl2 = zzj().zzl(str10)) == null || !zzhVarZzl2.zzaM()) {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                } else {
                                                    zzar(str10, false, null, null);
                                                    Bundle bundle2 = new Bundle();
                                                    Long lZzy = zzhVarZzl2.zzy();
                                                    if (lZzy != null) {
                                                        bundle2.putLong("_pfo", Math.max(0L, lZzy.longValue()));
                                                    }
                                                    Long lZzz = zzhVarZzl2.zzz();
                                                    if (lZzz != null) {
                                                        bundle2.putLong("_uwa", lZzz.longValue());
                                                    }
                                                    str11 = "_r";
                                                    bundle2.putLong(str11, 1L);
                                                    this.zzK.zza(str10, str30, bundle2);
                                                }
                                            }
                                        }
                                        zzioVar2 = this.zzn;
                                        zzioVar2.zzg().zzv();
                                        zzhwVarZzz.zzX(Build.MODEL);
                                        zzioVar2.zzg().zzv();
                                        zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                        zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                        zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                        zzhwVarZzz.zzay(zzrVar.zzy);
                                        if (zzioVar2.zzJ()) {
                                            zzhwVarZzz.zzaF();
                                            if (!TextUtils.isEmpty(null)) {
                                                zzhwVarZzz.zzY(null);
                                            }
                                        }
                                        zzhVarZzl = zzj().zzl(str10);
                                        if (zzhVarZzl == null) {
                                            zzhVarZzl = new zzh(zzioVar2, str10);
                                            zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                            zzhVarZzl.zzan(zzrVar.zzk);
                                            zzhVarZzl.zzao(zzrVar.zzb);
                                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                                zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                            }
                                            zzhVarZzl.zzat(0L);
                                            zzhVarZzl.zzau(0L);
                                            zzhVarZzl.zzas(0L);
                                            zzhVarZzl.zzX(zzrVar.zzc);
                                            zzhVarZzl.zzY(zzrVar.zzj);
                                            zzhVarZzl.zzW(zzrVar.zzd);
                                            zzhVarZzl.zzap(zzrVar.zze);
                                            zzhVarZzl.zzaj(zzrVar.zzf);
                                            zzhVarZzl.zzav(zzrVar.zzh);
                                            zzhVarZzl.zzal(zzrVar.zzr);
                                            i = 0;
                                            zzj().zzT(zzhVarZzl, false, false);
                                        } else {
                                            i = 0;
                                        }
                                        if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzhVarZzl.zzD())) {
                                            zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                        }
                                        if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                            zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                        }
                                        listZzE = zzj().zzE(str10);
                                        while (i2 < listZzE.size()) {
                                            com.google.android.gms.internal.measurement.zzin zzinVarZze2 = com.google.android.gms.internal.measurement.zzio.zze();
                                            zzinVarZze2.zzf(((zzqd) listZzE.get(i2)).zzc);
                                            zzinVarZze2.zzg(((zzqd) listZzE.get(i2)).zzd);
                                            zzA().zzx(zzinVarZze2, ((zzqd) listZzE.get(i2)).zze);
                                            zzhwVarZzz.zzo(zzinVarZze2);
                                            if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc) && zzhVarZzl.zzv() != 0 && zzA().zzd(zzrVar.zzw) != zzhVarZzl.zzv()) {
                                                zzhwVarZzz.zzA();
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (zEquals) {
                                    bundleZzc = zzbfVar2.zzc();
                                    zzqf zzqfVarZzB3 = zzB();
                                    String str213 = zzbhVar3.zzc;
                                    zzqfVarZzB3.zzS(bundleZzc, "_o", str213);
                                    if (zzB().zzak(str17, zzrVar.zzD)) {
                                        zzB().zzS(bundleZzc, "_dbg", 1L);
                                        zzB().zzS(bundleZzc, "_r", 1L);
                                    }
                                    if ("_s".equals(str)) {
                                        obj2 = zzqdVarZzy2.zze;
                                        if (obj2 instanceof Long) {
                                            zzB().zzS(bundleZzc, "_sno", obj2);
                                        }
                                    }
                                    if (zzi().zzx(null, zzgi.zzbg)) {
                                        double d3 = Double.parseDouble((String) obj);
                                        bundleZzc.remove("value");
                                        bundleZzc.putDouble("value", d3);
                                    }
                                    zzawVarZzj2 = zzj();
                                    Preconditions.checkNotEmpty(str17);
                                    zzawVarZzj2.zzg();
                                    zzawVarZzj2.zzav();
                                    str2 = str16;
                                    jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                    if (jDelete > 0) {
                                        zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                    }
                                    zzioVar = this.zzn;
                                    str3 = str2;
                                    zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                    zzaw zzawVarZzj7 = zzj();
                                    str4 = zzbcVar.zzb;
                                    zzbdVarZzs = zzawVarZzj7.zzs(str17, str4);
                                    if (zzbdVarZzs != null) {
                                        if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                        }
                                        zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                    } else {
                                        zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                        zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                    }
                                    zzj().zzV(zzbdVarZzc);
                                    zzaX().zzg();
                                    zzM();
                                    Preconditions.checkNotNull(zzbcVar);
                                    Preconditions.checkNotNull(zzrVar);
                                    String str214 = zzbcVar.zza;
                                    Preconditions.checkNotEmpty(str214);
                                    str5 = zzrVar.zza;
                                    Preconditions.checkArgument(str214.equals(str5));
                                    zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                    boolean z4 = true;
                                    zzhwVarZzz.zzar(1);
                                    zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                    if (!TextUtils.isEmpty(str5)) {
                                        zzhwVarZzz.zzI(str5);
                                    }
                                    str6 = zzrVar.zzd;
                                    if (!TextUtils.isEmpty(str6)) {
                                        zzhwVarZzz.zzK(str6);
                                    }
                                    str7 = zzrVar.zzc;
                                    if (!TextUtils.isEmpty(str7)) {
                                        zzhwVarZzz.zzL(str7);
                                    }
                                    str8 = zzrVar.zzw;
                                    if (!TextUtils.isEmpty(str8)) {
                                        zzhwVarZzz.zzav(str8);
                                    }
                                    j = zzrVar.zzj;
                                    if (j != -2147483648L) {
                                        zzhwVarZzz.zzM((int) j);
                                    }
                                    zzhwVarZzz.zzai(zzrVar.zze);
                                    str9 = zzrVar.zzb;
                                    if (!TextUtils.isEmpty(str9)) {
                                        zzhwVarZzz.zzah(str9);
                                    }
                                    zzjx zzjxVarZzl4 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                    zzhwVarZzz.zzT(zzjxVarZzl4.zzp());
                                    if (zzhwVarZzz.zzaJ().isEmpty()) {
                                        str13 = zzrVar.zzp;
                                        if (!TextUtils.isEmpty(str13)) {
                                            zzhwVarZzz.zzH(str13);
                                        }
                                    }
                                    zzqr.zzb();
                                    if (!zzi().zzx(str5, zzgi.zzaV)) {
                                    }
                                    j2 = zzrVar.zzf;
                                    if (j2 != 0) {
                                        zzhwVarZzz.zzW(j2);
                                    }
                                    zzhwVarZzz.zzZ(zzrVar.zzr);
                                    zzqa zzqaVarZzA3 = zzA();
                                    zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA3.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.google.android.gms.internal.measurement.zzki.zzc();
                                        }
                                    });
                                    if (zzjmVarZza == null) {
                                        mapZzd = Collections.emptyMap();
                                    } else {
                                        mapZzd = zzjmVarZza.zzd();
                                    }
                                    if (mapZzd != null) {
                                        arrayList = null;
                                    } else {
                                        arrayList = null;
                                    }
                                    if (arrayList != null) {
                                        zzhwVarZzz.zzk(arrayList);
                                    }
                                    if (zzi().zzx(null, zzgi.zzbk)) {
                                        zzhwVarZzz.zzaf("");
                                    }
                                    str10 = zzrVar.zza;
                                    zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                    zzjwVar = zzjw.AD_STORAGE;
                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                        zzjxVarZzl = zzjxVarZzl;
                                        zzjwVar = zzjwVar;
                                        str11 = "_r";
                                    } else {
                                        zzjxVarZzl = zzjxVarZzl;
                                        zzjwVar = zzjwVar;
                                        str11 = "_r";
                                    }
                                    zzioVar2 = this.zzn;
                                    zzioVar2.zzg().zzv();
                                    zzhwVarZzz.zzX(Build.MODEL);
                                    zzioVar2.zzg().zzv();
                                    zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                    zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                    zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                    zzhwVarZzz.zzay(zzrVar.zzy);
                                    if (zzioVar2.zzJ()) {
                                        zzhwVarZzz.zzaF();
                                        if (!TextUtils.isEmpty(null)) {
                                            zzhwVarZzz.zzY(null);
                                        }
                                    }
                                    zzhVarZzl = zzj().zzl(str10);
                                    if (zzhVarZzl == null) {
                                        zzhVarZzl = new zzh(zzioVar2, str10);
                                        zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                        zzhVarZzl.zzan(zzrVar.zzk);
                                        zzhVarZzl.zzao(zzrVar.zzb);
                                        if (zzjxVarZzl.zzr(zzjwVar)) {
                                            zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                        }
                                        zzhVarZzl.zzat(0L);
                                        zzhVarZzl.zzau(0L);
                                        zzhVarZzl.zzas(0L);
                                        zzhVarZzl.zzX(zzrVar.zzc);
                                        zzhVarZzl.zzY(zzrVar.zzj);
                                        zzhVarZzl.zzW(zzrVar.zzd);
                                        zzhVarZzl.zzap(zzrVar.zze);
                                        zzhVarZzl.zzaj(zzrVar.zzf);
                                        zzhVarZzl.zzav(zzrVar.zzh);
                                        zzhVarZzl.zzal(zzrVar.zzr);
                                        i = 0;
                                        zzj().zzT(zzhVarZzl, false, false);
                                    } else {
                                        i = 0;
                                    }
                                    if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                        zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                    }
                                    if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                        zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                    }
                                    listZzE = zzj().zzE(str10);
                                    while (i2 < listZzE.size()) {
                                        com.google.android.gms.internal.measurement.zzin zzinVarZze3 = com.google.android.gms.internal.measurement.zzio.zze();
                                        zzinVarZze3.zzf(((zzqd) listZzE.get(i2)).zzc);
                                        zzinVarZze3.zzg(((zzqd) listZzE.get(i2)).zzd);
                                        zzA().zzx(zzinVarZze3, ((zzqd) listZzE.get(i2)).zze);
                                        zzhwVarZzz.zzo(zzinVarZze3);
                                        if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                        }
                                    }
                                    zzawVarZzj3 = zzj();
                                    zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                    zzawVarZzj3.zzg();
                                    zzawVarZzj3.zzav();
                                    Preconditions.checkNotNull(zzhxVar);
                                    Preconditions.checkNotEmpty(zzhxVar.zzF());
                                    byte[] bArrZzcd5 = zzhxVar.zzcd();
                                    long jZzf3 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd5);
                                    ContentValues contentValues4 = new ContentValues();
                                    String str215 = str14;
                                    contentValues4.put(str215, zzhxVar.zzF());
                                    contentValues4.put("metadata_fingerprint", Long.valueOf(jZzf3));
                                    contentValues4.put("metadata", bArrZzcd5);
                                    zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues4, 4);
                                    zzawVarZzj4 = zzj();
                                    zzbeVar2 = new zzbe(zzbcVar.zzf);
                                    while (true) {
                                        if (zzbeVar2.hasNext()) {
                                            zzif zzifVarZzr4 = zzr();
                                            String str216 = zzbcVar.zza;
                                            zZzw = zzifVarZzr4.zzw(str216, zzbcVar.zzb);
                                            zzas zzasVarZzo3 = zzj().zzo(zza(), str216, false, false, false, false, false, false, false);
                                            if (zZzw) {
                                            }
                                            i3 = 0;
                                            break;
                                        }
                                        next = zzbeVar2.next();
                                        String str217 = next;
                                        if (str11.equals(next)) {
                                        }
                                        i3 = 1;
                                        break;
                                    }
                                    zzawVarZzj4.zzg();
                                    zzawVarZzj4.zzav();
                                    Preconditions.checkNotNull(zzbcVar);
                                    str12 = zzbcVar.zza;
                                    Preconditions.checkNotEmpty(str12);
                                    byte[] bArrZzcd6 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                    contentValues = new ContentValues();
                                    contentValues.put(str215, str12);
                                    contentValues.put("name", zzbcVar.zzb);
                                    contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(jZzf3));
                                    contentValues.put("data", bArrZzcd6);
                                    contentValues.put("realtime", Integer.valueOf(i3));
                                    if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                        zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                    } else {
                                        this.zza = 0L;
                                    }
                                    zzj().zzS();
                                    zzj().zzL();
                                    zzaL();
                                    zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                    return;
                                }
                                jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                                if (jMax <= 0) {
                                    bundleZzc = zzbfVar2.zzc();
                                    zzqf zzqfVarZzB4 = zzB();
                                    String str218 = zzbhVar3.zzc;
                                    zzqfVarZzB4.zzS(bundleZzc, "_o", str218);
                                    if (zzB().zzak(str17, zzrVar.zzD)) {
                                        zzB().zzS(bundleZzc, "_dbg", 1L);
                                        zzB().zzS(bundleZzc, "_r", 1L);
                                    }
                                    if ("_s".equals(str)) {
                                        obj2 = zzqdVarZzy2.zze;
                                        if (obj2 instanceof Long) {
                                            zzB().zzS(bundleZzc, "_sno", obj2);
                                        }
                                    }
                                    if (zzi().zzx(null, zzgi.zzbg)) {
                                        double d4 = Double.parseDouble((String) obj);
                                        bundleZzc.remove("value");
                                        bundleZzc.putDouble("value", d4);
                                    }
                                    zzawVarZzj2 = zzj();
                                    Preconditions.checkNotEmpty(str17);
                                    zzawVarZzj2.zzg();
                                    zzawVarZzj2.zzav();
                                    str2 = str16;
                                    jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                    if (jDelete > 0) {
                                        zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                    }
                                    zzioVar = this.zzn;
                                    str3 = str2;
                                    zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                    zzaw zzawVarZzj8 = zzj();
                                    str4 = zzbcVar.zzb;
                                    zzbdVarZzs = zzawVarZzj8.zzs(str17, str4);
                                    if (zzbdVarZzs != null) {
                                        if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                        }
                                        zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                    } else {
                                        zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                        zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                    }
                                    zzj().zzV(zzbdVarZzc);
                                    zzaX().zzg();
                                    zzM();
                                    Preconditions.checkNotNull(zzbcVar);
                                    Preconditions.checkNotNull(zzrVar);
                                    String str219 = zzbcVar.zza;
                                    Preconditions.checkNotEmpty(str219);
                                    str5 = zzrVar.zza;
                                    Preconditions.checkArgument(str219.equals(str5));
                                    zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                    boolean z5 = true;
                                    zzhwVarZzz.zzar(1);
                                    zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                    if (!TextUtils.isEmpty(str5)) {
                                        zzhwVarZzz.zzI(str5);
                                    }
                                    str6 = zzrVar.zzd;
                                    if (!TextUtils.isEmpty(str6)) {
                                        zzhwVarZzz.zzK(str6);
                                    }
                                    str7 = zzrVar.zzc;
                                    if (!TextUtils.isEmpty(str7)) {
                                        zzhwVarZzz.zzL(str7);
                                    }
                                    str8 = zzrVar.zzw;
                                    if (!TextUtils.isEmpty(str8)) {
                                        zzhwVarZzz.zzav(str8);
                                    }
                                    j = zzrVar.zzj;
                                    if (j != -2147483648L) {
                                        zzhwVarZzz.zzM((int) j);
                                    }
                                    zzhwVarZzz.zzai(zzrVar.zze);
                                    str9 = zzrVar.zzb;
                                    if (!TextUtils.isEmpty(str9)) {
                                        zzhwVarZzz.zzah(str9);
                                    }
                                    zzjx zzjxVarZzl5 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                    zzhwVarZzz.zzT(zzjxVarZzl5.zzp());
                                    if (zzhwVarZzz.zzaJ().isEmpty()) {
                                        str13 = zzrVar.zzp;
                                        if (!TextUtils.isEmpty(str13)) {
                                            zzhwVarZzz.zzH(str13);
                                        }
                                    }
                                    zzqr.zzb();
                                    if (!zzi().zzx(str5, zzgi.zzaV)) {
                                    }
                                    j2 = zzrVar.zzf;
                                    if (j2 != 0) {
                                        zzhwVarZzz.zzW(j2);
                                    }
                                    zzhwVarZzz.zzZ(zzrVar.zzr);
                                    zzqa zzqaVarZzA4 = zzA();
                                    zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA4.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.google.android.gms.internal.measurement.zzki.zzc();
                                        }
                                    });
                                    if (zzjmVarZza == null) {
                                        mapZzd = Collections.emptyMap();
                                    } else {
                                        mapZzd = zzjmVarZza.zzd();
                                    }
                                    if (mapZzd != null) {
                                        arrayList = null;
                                    } else {
                                        arrayList = null;
                                    }
                                    if (arrayList != null) {
                                        zzhwVarZzz.zzk(arrayList);
                                    }
                                    if (zzi().zzx(null, zzgi.zzbk)) {
                                        zzhwVarZzz.zzaf("");
                                    }
                                    str10 = zzrVar.zza;
                                    zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                    zzjwVar = zzjw.AD_STORAGE;
                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                        zzjxVarZzl = zzjxVarZzl;
                                        zzjwVar = zzjwVar;
                                        str11 = "_r";
                                    } else {
                                        zzjxVarZzl = zzjxVarZzl;
                                        zzjwVar = zzjwVar;
                                        str11 = "_r";
                                    }
                                    zzioVar2 = this.zzn;
                                    zzioVar2.zzg().zzv();
                                    zzhwVarZzz.zzX(Build.MODEL);
                                    zzioVar2.zzg().zzv();
                                    zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                    zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                    zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                    zzhwVarZzz.zzay(zzrVar.zzy);
                                    if (zzioVar2.zzJ()) {
                                        zzhwVarZzz.zzaF();
                                        if (!TextUtils.isEmpty(null)) {
                                            zzhwVarZzz.zzY(null);
                                        }
                                    }
                                    zzhVarZzl = zzj().zzl(str10);
                                    if (zzhVarZzl == null) {
                                        zzhVarZzl = new zzh(zzioVar2, str10);
                                        zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                        zzhVarZzl.zzan(zzrVar.zzk);
                                        zzhVarZzl.zzao(zzrVar.zzb);
                                        if (zzjxVarZzl.zzr(zzjwVar)) {
                                            zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                        }
                                        zzhVarZzl.zzat(0L);
                                        zzhVarZzl.zzau(0L);
                                        zzhVarZzl.zzas(0L);
                                        zzhVarZzl.zzX(zzrVar.zzc);
                                        zzhVarZzl.zzY(zzrVar.zzj);
                                        zzhVarZzl.zzW(zzrVar.zzd);
                                        zzhVarZzl.zzap(zzrVar.zze);
                                        zzhVarZzl.zzaj(zzrVar.zzf);
                                        zzhVarZzl.zzav(zzrVar.zzh);
                                        zzhVarZzl.zzal(zzrVar.zzr);
                                        i = 0;
                                        zzj().zzT(zzhVarZzl, false, false);
                                    } else {
                                        i = 0;
                                    }
                                    if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                        zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                    }
                                    if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                        zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                    }
                                    listZzE = zzj().zzE(str10);
                                    while (i2 < listZzE.size()) {
                                        com.google.android.gms.internal.measurement.zzin zzinVarZze4 = com.google.android.gms.internal.measurement.zzio.zze();
                                        zzinVarZze4.zzf(((zzqd) listZzE.get(i2)).zzc);
                                        zzinVarZze4.zzg(((zzqd) listZzE.get(i2)).zzd);
                                        zzA().zzx(zzinVarZze4, ((zzqd) listZzE.get(i2)).zze);
                                        zzhwVarZzz.zzo(zzinVarZze4);
                                        if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                        }
                                    }
                                    zzawVarZzj3 = zzj();
                                    zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                    zzawVarZzj3.zzg();
                                    zzawVarZzj3.zzav();
                                    Preconditions.checkNotNull(zzhxVar);
                                    Preconditions.checkNotEmpty(zzhxVar.zzF());
                                    byte[] bArrZzcd7 = zzhxVar.zzcd();
                                    long jZzf4 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd7);
                                    ContentValues contentValues5 = new ContentValues();
                                    String str2110 = str14;
                                    contentValues5.put(str2110, zzhxVar.zzF());
                                    contentValues5.put("metadata_fingerprint", Long.valueOf(jZzf4));
                                    contentValues5.put("metadata", bArrZzcd7);
                                    zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues5, 4);
                                    zzawVarZzj4 = zzj();
                                    zzbeVar2 = new zzbe(zzbcVar.zzf);
                                    while (true) {
                                        if (zzbeVar2.hasNext()) {
                                            zzif zzifVarZzr5 = zzr();
                                            String str2111 = zzbcVar.zza;
                                            zZzw = zzifVarZzr5.zzw(str2111, zzbcVar.zzb);
                                            zzas zzasVarZzo4 = zzj().zzo(zza(), str2111, false, false, false, false, false, false, false);
                                            if (zZzw) {
                                            }
                                            i3 = 0;
                                            break;
                                        }
                                        next = zzbeVar2.next();
                                        String str2112 = next;
                                        if (str11.equals(next)) {
                                        }
                                        i3 = 1;
                                        break;
                                    }
                                    zzawVarZzj4.zzg();
                                    zzawVarZzj4.zzav();
                                    Preconditions.checkNotNull(zzbcVar);
                                    str12 = zzbcVar.zza;
                                    Preconditions.checkNotEmpty(str12);
                                    byte[] bArrZzcd8 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                    contentValues = new ContentValues();
                                    contentValues.put(str2110, str12);
                                    contentValues.put("name", zzbcVar.zzb);
                                    contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(jZzf4));
                                    contentValues.put("data", bArrZzcd8);
                                    contentValues.put("realtime", Integer.valueOf(i3));
                                    if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                        zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                    } else {
                                        this.zza = 0L;
                                    }
                                    zzj().zzS();
                                    zzj().zzL();
                                    zzaL();
                                    zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                    return;
                                }
                                if (jMax == 1) {
                                    zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                                }
                                zzj().zzS();
                            }
                        }
                    }
                    str16 = "raw_events";
                    zzbhVar2 = zzbhVarZza;
                    str19 = "_err";
                    str = zzbhVar2.zza;
                    zZzaq = zzqf.zzaq(str);
                    zEquals = str19.equals(str);
                    zzB();
                    zzbfVar2 = zzbhVar2.zzb;
                    if (zzbfVar2 == null) {
                        length = 0;
                    } else {
                        zzbeVar = new zzbe(zzbfVar2);
                        length = 0;
                        while (zzbeVar.hasNext()) {
                            String next3 = zzbeVar.next();
                            String str220 = next3;
                            objZzf = zzbfVar2.zzf(next3);
                            if (objZzf instanceof Parcelable[]) {
                                length += (long) ((Parcelable[]) objZzf).length;
                            }
                        }
                    }
                    zzbhVar3 = zzbhVar2;
                    zzasVarZzp = zzj().zzp(zza(), str17, length + 1, true, zZzaq, false, zEquals, false, false, false);
                    long j6 = zzasVarZzp.zzb;
                    zzi();
                    jZzH = j6 - zzam.zzH();
                    if (jZzH > 0) {
                        if (jZzH % 1000 == 1) {
                            zzaW().zze().zzc("Data loss. Too many events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzb));
                        }
                        zzj().zzS();
                    } else if (zZzaq) {
                        long j7 = zzasVarZzp.zza;
                        zzi();
                        jIntValue = j7 - ((long) ((Integer) zzgi.zzm.zza(null)).intValue());
                        if (jIntValue > 0) {
                            if (jIntValue % 1000 == 1) {
                                zzaW().zze().zzc("Data loss. Too many public events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zza));
                            }
                            zzB().zzR(this.zzK, str17, 16, "_ev", zzbhVar3.zza, 0);
                            zzj().zzS();
                        } else {
                            if (zEquals) {
                                bundleZzc = zzbfVar2.zzc();
                                zzqf zzqfVarZzB5 = zzB();
                                String str2113 = zzbhVar3.zzc;
                                zzqfVarZzB5.zzS(bundleZzc, "_o", str2113);
                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                    zzB().zzS(bundleZzc, "_dbg", 1L);
                                    zzB().zzS(bundleZzc, "_r", 1L);
                                }
                                if ("_s".equals(str)) {
                                    obj2 = zzqdVarZzy2.zze;
                                    if (obj2 instanceof Long) {
                                        zzB().zzS(bundleZzc, "_sno", obj2);
                                    }
                                }
                                if (zzi().zzx(null, zzgi.zzbg)) {
                                    double d5 = Double.parseDouble((String) obj);
                                    bundleZzc.remove("value");
                                    bundleZzc.putDouble("value", d5);
                                }
                                zzawVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str17);
                                zzawVarZzj2.zzg();
                                zzawVarZzj2.zzav();
                                str2 = str16;
                                jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                if (jDelete > 0) {
                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                }
                                zzioVar = this.zzn;
                                str3 = str2;
                                zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                zzaw zzawVarZzj9 = zzj();
                                str4 = zzbcVar.zzb;
                                zzbdVarZzs = zzawVarZzj9.zzs(str17, str4);
                                if (zzbdVarZzs != null) {
                                    if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                    }
                                    zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                    zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                }
                                zzj().zzV(zzbdVarZzc);
                                zzaX().zzg();
                                zzM();
                                Preconditions.checkNotNull(zzbcVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str2114 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str2114);
                                str5 = zzrVar.zza;
                                Preconditions.checkArgument(str2114.equals(str5));
                                zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                boolean z6 = true;
                                zzhwVarZzz.zzar(1);
                                zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                if (!TextUtils.isEmpty(str5)) {
                                    zzhwVarZzz.zzI(str5);
                                }
                                str6 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str6)) {
                                    zzhwVarZzz.zzK(str6);
                                }
                                str7 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzhwVarZzz.zzL(str7);
                                }
                                str8 = zzrVar.zzw;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzhwVarZzz.zzav(str8);
                                }
                                j = zzrVar.zzj;
                                if (j != -2147483648L) {
                                    zzhwVarZzz.zzM((int) j);
                                }
                                zzhwVarZzz.zzai(zzrVar.zze);
                                str9 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzhwVarZzz.zzah(str9);
                                }
                                zzjx zzjxVarZzl6 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzhwVarZzz.zzT(zzjxVarZzl6.zzp());
                                if (zzhwVarZzz.zzaJ().isEmpty()) {
                                    str13 = zzrVar.zzp;
                                    if (!TextUtils.isEmpty(str13)) {
                                        zzhwVarZzz.zzH(str13);
                                    }
                                }
                                zzqr.zzb();
                                if (!zzi().zzx(str5, zzgi.zzaV)) {
                                }
                                j2 = zzrVar.zzf;
                                if (j2 != 0) {
                                    zzhwVarZzz.zzW(j2);
                                }
                                zzhwVarZzz.zzZ(zzrVar.zzr);
                                zzqa zzqaVarZzA5 = zzA();
                                zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA5.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                    }
                                });
                                if (zzjmVarZza == null) {
                                    mapZzd = Collections.emptyMap();
                                } else {
                                    mapZzd = zzjmVarZza.zzd();
                                }
                                if (mapZzd != null) {
                                    arrayList = null;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    zzhwVarZzz.zzk(arrayList);
                                }
                                if (zzi().zzx(null, zzgi.zzbk)) {
                                    zzhwVarZzz.zzaf("");
                                }
                                str10 = zzrVar.zza;
                                zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzjwVar = zzjw.AD_STORAGE;
                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                    zzjxVarZzl = zzjxVarZzl;
                                    zzjwVar = zzjwVar;
                                    str11 = "_r";
                                } else {
                                    zzjxVarZzl = zzjxVarZzl;
                                    zzjwVar = zzjwVar;
                                    str11 = "_r";
                                }
                                zzioVar2 = this.zzn;
                                zzioVar2.zzg().zzv();
                                zzhwVarZzz.zzX(Build.MODEL);
                                zzioVar2.zzg().zzv();
                                zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                zzhwVarZzz.zzay(zzrVar.zzy);
                                if (zzioVar2.zzJ()) {
                                    zzhwVarZzz.zzaF();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzhwVarZzz.zzY(null);
                                    }
                                }
                                zzhVarZzl = zzj().zzl(str10);
                                if (zzhVarZzl == null) {
                                    zzhVarZzl = new zzh(zzioVar2, str10);
                                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                    zzhVarZzl.zzan(zzrVar.zzk);
                                    zzhVarZzl.zzao(zzrVar.zzb);
                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                        zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                    }
                                    zzhVarZzl.zzat(0L);
                                    zzhVarZzl.zzau(0L);
                                    zzhVarZzl.zzas(0L);
                                    zzhVarZzl.zzX(zzrVar.zzc);
                                    zzhVarZzl.zzY(zzrVar.zzj);
                                    zzhVarZzl.zzW(zzrVar.zzd);
                                    zzhVarZzl.zzap(zzrVar.zze);
                                    zzhVarZzl.zzaj(zzrVar.zzf);
                                    zzhVarZzl.zzav(zzrVar.zzh);
                                    zzhVarZzl.zzal(zzrVar.zzr);
                                    i = 0;
                                    zzj().zzT(zzhVarZzl, false, false);
                                } else {
                                    i = 0;
                                }
                                if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                    zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                    zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                }
                                listZzE = zzj().zzE(str10);
                                while (i2 < listZzE.size()) {
                                    com.google.android.gms.internal.measurement.zzin zzinVarZze5 = com.google.android.gms.internal.measurement.zzio.zze();
                                    zzinVarZze5.zzf(((zzqd) listZzE.get(i2)).zzc);
                                    zzinVarZze5.zzg(((zzqd) listZzE.get(i2)).zzd);
                                    zzA().zzx(zzinVarZze5, ((zzqd) listZzE.get(i2)).zze);
                                    zzhwVarZzz.zzo(zzinVarZze5);
                                    if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                    }
                                }
                                zzawVarZzj3 = zzj();
                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                zzawVarZzj3.zzg();
                                zzawVarZzj3.zzav();
                                Preconditions.checkNotNull(zzhxVar);
                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                byte[] bArrZzcd9 = zzhxVar.zzcd();
                                long jZzf5 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd9);
                                ContentValues contentValues6 = new ContentValues();
                                String str2115 = str14;
                                contentValues6.put(str2115, zzhxVar.zzF());
                                contentValues6.put("metadata_fingerprint", Long.valueOf(jZzf5));
                                contentValues6.put("metadata", bArrZzcd9);
                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues6, 4);
                                zzawVarZzj4 = zzj();
                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                while (true) {
                                    if (zzbeVar2.hasNext()) {
                                        zzif zzifVarZzr6 = zzr();
                                        String str2116 = zzbcVar.zza;
                                        zZzw = zzifVarZzr6.zzw(str2116, zzbcVar.zzb);
                                        zzas zzasVarZzo5 = zzj().zzo(zza(), str2116, false, false, false, false, false, false, false);
                                        if (zZzw) {
                                        }
                                        i3 = 0;
                                        break;
                                    }
                                    next = zzbeVar2.next();
                                    String str2117 = next;
                                    if (str11.equals(next)) {
                                    }
                                    i3 = 1;
                                    break;
                                }
                                zzawVarZzj4.zzg();
                                zzawVarZzj4.zzav();
                                Preconditions.checkNotNull(zzbcVar);
                                str12 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str12);
                                byte[] bArrZzcd10 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                contentValues = new ContentValues();
                                contentValues.put(str2115, str12);
                                contentValues.put("name", zzbcVar.zzb);
                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf5));
                                contentValues.put("data", bArrZzcd10);
                                contentValues.put("realtime", Integer.valueOf(i3));
                                if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                    zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                } else {
                                    this.zza = 0L;
                                }
                                zzj().zzS();
                                zzj().zzL();
                                zzaL();
                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                            if (jMax <= 0) {
                                bundleZzc = zzbfVar2.zzc();
                                zzqf zzqfVarZzB6 = zzB();
                                String str2118 = zzbhVar3.zzc;
                                zzqfVarZzB6.zzS(bundleZzc, "_o", str2118);
                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                    zzB().zzS(bundleZzc, "_dbg", 1L);
                                    zzB().zzS(bundleZzc, "_r", 1L);
                                }
                                if ("_s".equals(str)) {
                                    obj2 = zzqdVarZzy2.zze;
                                    if (obj2 instanceof Long) {
                                        zzB().zzS(bundleZzc, "_sno", obj2);
                                    }
                                }
                                if (zzi().zzx(null, zzgi.zzbg)) {
                                    double d6 = Double.parseDouble((String) obj);
                                    bundleZzc.remove("value");
                                    bundleZzc.putDouble("value", d6);
                                }
                                zzawVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str17);
                                zzawVarZzj2.zzg();
                                zzawVarZzj2.zzav();
                                str2 = str16;
                                jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                if (jDelete > 0) {
                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                }
                                zzioVar = this.zzn;
                                str3 = str2;
                                zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                zzaw zzawVarZzj10 = zzj();
                                str4 = zzbcVar.zzb;
                                zzbdVarZzs = zzawVarZzj10.zzs(str17, str4);
                                if (zzbdVarZzs != null) {
                                    if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                    }
                                    zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                    zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                }
                                zzj().zzV(zzbdVarZzc);
                                zzaX().zzg();
                                zzM();
                                Preconditions.checkNotNull(zzbcVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str2119 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str2119);
                                str5 = zzrVar.zza;
                                Preconditions.checkArgument(str2119.equals(str5));
                                zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                boolean z7 = true;
                                zzhwVarZzz.zzar(1);
                                zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                if (!TextUtils.isEmpty(str5)) {
                                    zzhwVarZzz.zzI(str5);
                                }
                                str6 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str6)) {
                                    zzhwVarZzz.zzK(str6);
                                }
                                str7 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzhwVarZzz.zzL(str7);
                                }
                                str8 = zzrVar.zzw;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzhwVarZzz.zzav(str8);
                                }
                                j = zzrVar.zzj;
                                if (j != -2147483648L) {
                                    zzhwVarZzz.zzM((int) j);
                                }
                                zzhwVarZzz.zzai(zzrVar.zze);
                                str9 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzhwVarZzz.zzah(str9);
                                }
                                zzjx zzjxVarZzl7 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzhwVarZzz.zzT(zzjxVarZzl7.zzp());
                                if (zzhwVarZzz.zzaJ().isEmpty()) {
                                    str13 = zzrVar.zzp;
                                    if (!TextUtils.isEmpty(str13)) {
                                        zzhwVarZzz.zzH(str13);
                                    }
                                }
                                zzqr.zzb();
                                if (!zzi().zzx(str5, zzgi.zzaV)) {
                                }
                                j2 = zzrVar.zzf;
                                if (j2 != 0) {
                                    zzhwVarZzz.zzW(j2);
                                }
                                zzhwVarZzz.zzZ(zzrVar.zzr);
                                zzqa zzqaVarZzA6 = zzA();
                                zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA6.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                    }
                                });
                                if (zzjmVarZza == null) {
                                    mapZzd = Collections.emptyMap();
                                } else {
                                    mapZzd = zzjmVarZza.zzd();
                                }
                                if (mapZzd != null) {
                                    arrayList = null;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    zzhwVarZzz.zzk(arrayList);
                                }
                                if (zzi().zzx(null, zzgi.zzbk)) {
                                    zzhwVarZzz.zzaf("");
                                }
                                str10 = zzrVar.zza;
                                zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzjwVar = zzjw.AD_STORAGE;
                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                    zzjxVarZzl = zzjxVarZzl;
                                    zzjwVar = zzjwVar;
                                    str11 = "_r";
                                } else {
                                    zzjxVarZzl = zzjxVarZzl;
                                    zzjwVar = zzjwVar;
                                    str11 = "_r";
                                }
                                zzioVar2 = this.zzn;
                                zzioVar2.zzg().zzv();
                                zzhwVarZzz.zzX(Build.MODEL);
                                zzioVar2.zzg().zzv();
                                zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                zzhwVarZzz.zzay(zzrVar.zzy);
                                if (zzioVar2.zzJ()) {
                                    zzhwVarZzz.zzaF();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzhwVarZzz.zzY(null);
                                    }
                                }
                                zzhVarZzl = zzj().zzl(str10);
                                if (zzhVarZzl == null) {
                                    zzhVarZzl = new zzh(zzioVar2, str10);
                                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                    zzhVarZzl.zzan(zzrVar.zzk);
                                    zzhVarZzl.zzao(zzrVar.zzb);
                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                        zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                    }
                                    zzhVarZzl.zzat(0L);
                                    zzhVarZzl.zzau(0L);
                                    zzhVarZzl.zzas(0L);
                                    zzhVarZzl.zzX(zzrVar.zzc);
                                    zzhVarZzl.zzY(zzrVar.zzj);
                                    zzhVarZzl.zzW(zzrVar.zzd);
                                    zzhVarZzl.zzap(zzrVar.zze);
                                    zzhVarZzl.zzaj(zzrVar.zzf);
                                    zzhVarZzl.zzav(zzrVar.zzh);
                                    zzhVarZzl.zzal(zzrVar.zzr);
                                    i = 0;
                                    zzj().zzT(zzhVarZzl, false, false);
                                } else {
                                    i = 0;
                                }
                                if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                    zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                    zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                }
                                listZzE = zzj().zzE(str10);
                                while (i2 < listZzE.size()) {
                                    com.google.android.gms.internal.measurement.zzin zzinVarZze6 = com.google.android.gms.internal.measurement.zzio.zze();
                                    zzinVarZze6.zzf(((zzqd) listZzE.get(i2)).zzc);
                                    zzinVarZze6.zzg(((zzqd) listZzE.get(i2)).zzd);
                                    zzA().zzx(zzinVarZze6, ((zzqd) listZzE.get(i2)).zze);
                                    zzhwVarZzz.zzo(zzinVarZze6);
                                    if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                    }
                                }
                                zzawVarZzj3 = zzj();
                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                zzawVarZzj3.zzg();
                                zzawVarZzj3.zzav();
                                Preconditions.checkNotNull(zzhxVar);
                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                byte[] bArrZzcd11 = zzhxVar.zzcd();
                                long jZzf6 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd11);
                                ContentValues contentValues7 = new ContentValues();
                                String str21110 = str14;
                                contentValues7.put(str21110, zzhxVar.zzF());
                                contentValues7.put("metadata_fingerprint", Long.valueOf(jZzf6));
                                contentValues7.put("metadata", bArrZzcd11);
                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues7, 4);
                                zzawVarZzj4 = zzj();
                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                while (true) {
                                    if (zzbeVar2.hasNext()) {
                                        zzif zzifVarZzr7 = zzr();
                                        String str21111 = zzbcVar.zza;
                                        zZzw = zzifVarZzr7.zzw(str21111, zzbcVar.zzb);
                                        zzas zzasVarZzo6 = zzj().zzo(zza(), str21111, false, false, false, false, false, false, false);
                                        if (zZzw) {
                                        }
                                        i3 = 0;
                                        break;
                                    }
                                    next = zzbeVar2.next();
                                    String str21112 = next;
                                    if (str11.equals(next)) {
                                    }
                                    i3 = 1;
                                    break;
                                }
                                zzawVarZzj4.zzg();
                                zzawVarZzj4.zzav();
                                Preconditions.checkNotNull(zzbcVar);
                                str12 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str12);
                                byte[] bArrZzcd12 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                contentValues = new ContentValues();
                                contentValues.put(str21110, str12);
                                contentValues.put("name", zzbcVar.zzb);
                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf6));
                                contentValues.put("data", bArrZzcd12);
                                contentValues.put("realtime", Integer.valueOf(i3));
                                if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                    zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                } else {
                                    this.zza = 0L;
                                }
                                zzj().zzS();
                                zzj().zzL();
                                zzaL();
                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            if (jMax == 1) {
                                zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                            }
                            zzj().zzS();
                        }
                    } else {
                        if (zEquals) {
                            bundleZzc = zzbfVar2.zzc();
                            zzqf zzqfVarZzB7 = zzB();
                            String str21113 = zzbhVar3.zzc;
                            zzqfVarZzB7.zzS(bundleZzc, "_o", str21113);
                            if (zzB().zzak(str17, zzrVar.zzD)) {
                                zzB().zzS(bundleZzc, "_dbg", 1L);
                                zzB().zzS(bundleZzc, "_r", 1L);
                            }
                            if ("_s".equals(str)) {
                                obj2 = zzqdVarZzy2.zze;
                                if (obj2 instanceof Long) {
                                    zzB().zzS(bundleZzc, "_sno", obj2);
                                }
                            }
                            if (zzi().zzx(null, zzgi.zzbg)) {
                                double d7 = Double.parseDouble((String) obj);
                                bundleZzc.remove("value");
                                bundleZzc.putDouble("value", d7);
                            }
                            zzawVarZzj2 = zzj();
                            Preconditions.checkNotEmpty(str17);
                            zzawVarZzj2.zzg();
                            zzawVarZzj2.zzav();
                            str2 = str16;
                            jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                            if (jDelete > 0) {
                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                            }
                            zzioVar = this.zzn;
                            str3 = str2;
                            zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                            zzaw zzawVarZzj11 = zzj();
                            str4 = zzbcVar.zzb;
                            zzbdVarZzs = zzawVarZzj11.zzs(str17, str4);
                            if (zzbdVarZzs != null) {
                                if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                }
                                zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                            } else {
                                zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                            }
                            zzj().zzV(zzbdVarZzc);
                            zzaX().zzg();
                            zzM();
                            Preconditions.checkNotNull(zzbcVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str21114 = zzbcVar.zza;
                            Preconditions.checkNotEmpty(str21114);
                            str5 = zzrVar.zza;
                            Preconditions.checkArgument(str21114.equals(str5));
                            zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                            boolean z8 = true;
                            zzhwVarZzz.zzar(1);
                            zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                            if (!TextUtils.isEmpty(str5)) {
                                zzhwVarZzz.zzI(str5);
                            }
                            str6 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str6)) {
                                zzhwVarZzz.zzK(str6);
                            }
                            str7 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str7)) {
                                zzhwVarZzz.zzL(str7);
                            }
                            str8 = zzrVar.zzw;
                            if (!TextUtils.isEmpty(str8)) {
                                zzhwVarZzz.zzav(str8);
                            }
                            j = zzrVar.zzj;
                            if (j != -2147483648L) {
                                zzhwVarZzz.zzM((int) j);
                            }
                            zzhwVarZzz.zzai(zzrVar.zze);
                            str9 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str9)) {
                                zzhwVarZzz.zzah(str9);
                            }
                            zzjx zzjxVarZzl8 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzhwVarZzz.zzT(zzjxVarZzl8.zzp());
                            if (zzhwVarZzz.zzaJ().isEmpty()) {
                                str13 = zzrVar.zzp;
                                if (!TextUtils.isEmpty(str13)) {
                                    zzhwVarZzz.zzH(str13);
                                }
                            }
                            zzqr.zzb();
                            if (!zzi().zzx(str5, zzgi.zzaV)) {
                            }
                            j2 = zzrVar.zzf;
                            if (j2 != 0) {
                                zzhwVarZzz.zzW(j2);
                            }
                            zzhwVarZzz.zzZ(zzrVar.zzr);
                            zzqa zzqaVarZzA7 = zzA();
                            zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA7.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                }
                            });
                            if (zzjmVarZza == null) {
                                mapZzd = Collections.emptyMap();
                            } else {
                                mapZzd = zzjmVarZza.zzd();
                            }
                            if (mapZzd != null) {
                                arrayList = null;
                            } else {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                                zzhwVarZzz.zzk(arrayList);
                            }
                            if (zzi().zzx(null, zzgi.zzbk)) {
                                zzhwVarZzz.zzaf("");
                            }
                            str10 = zzrVar.zza;
                            zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzjwVar = zzjw.AD_STORAGE;
                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                zzjxVarZzl = zzjxVarZzl;
                                zzjwVar = zzjwVar;
                                str11 = "_r";
                            } else {
                                zzjxVarZzl = zzjxVarZzl;
                                zzjwVar = zzjwVar;
                                str11 = "_r";
                            }
                            zzioVar2 = this.zzn;
                            zzioVar2.zzg().zzv();
                            zzhwVarZzz.zzX(Build.MODEL);
                            zzioVar2.zzg().zzv();
                            zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                            zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                            zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                            zzhwVarZzz.zzay(zzrVar.zzy);
                            if (zzioVar2.zzJ()) {
                                zzhwVarZzz.zzaF();
                                if (!TextUtils.isEmpty(null)) {
                                    zzhwVarZzz.zzY(null);
                                }
                            }
                            zzhVarZzl = zzj().zzl(str10);
                            if (zzhVarZzl == null) {
                                zzhVarZzl = new zzh(zzioVar2, str10);
                                zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                zzhVarZzl.zzan(zzrVar.zzk);
                                zzhVarZzl.zzao(zzrVar.zzb);
                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                    zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                }
                                zzhVarZzl.zzat(0L);
                                zzhVarZzl.zzau(0L);
                                zzhVarZzl.zzas(0L);
                                zzhVarZzl.zzX(zzrVar.zzc);
                                zzhVarZzl.zzY(zzrVar.zzj);
                                zzhVarZzl.zzW(zzrVar.zzd);
                                zzhVarZzl.zzap(zzrVar.zze);
                                zzhVarZzl.zzaj(zzrVar.zzf);
                                zzhVarZzl.zzav(zzrVar.zzh);
                                zzhVarZzl.zzal(zzrVar.zzr);
                                i = 0;
                                zzj().zzT(zzhVarZzl, false, false);
                            } else {
                                i = 0;
                            }
                            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                            }
                            listZzE = zzj().zzE(str10);
                            while (i2 < listZzE.size()) {
                                com.google.android.gms.internal.measurement.zzin zzinVarZze7 = com.google.android.gms.internal.measurement.zzio.zze();
                                zzinVarZze7.zzf(((zzqd) listZzE.get(i2)).zzc);
                                zzinVarZze7.zzg(((zzqd) listZzE.get(i2)).zzd);
                                zzA().zzx(zzinVarZze7, ((zzqd) listZzE.get(i2)).zze);
                                zzhwVarZzz.zzo(zzinVarZze7);
                                if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                }
                            }
                            zzawVarZzj3 = zzj();
                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                            zzawVarZzj3.zzg();
                            zzawVarZzj3.zzav();
                            Preconditions.checkNotNull(zzhxVar);
                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                            byte[] bArrZzcd13 = zzhxVar.zzcd();
                            long jZzf7 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd13);
                            ContentValues contentValues8 = new ContentValues();
                            String str21115 = str14;
                            contentValues8.put(str21115, zzhxVar.zzF());
                            contentValues8.put("metadata_fingerprint", Long.valueOf(jZzf7));
                            contentValues8.put("metadata", bArrZzcd13);
                            zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues8, 4);
                            zzawVarZzj4 = zzj();
                            zzbeVar2 = new zzbe(zzbcVar.zzf);
                            while (true) {
                                if (zzbeVar2.hasNext()) {
                                    zzif zzifVarZzr8 = zzr();
                                    String str21116 = zzbcVar.zza;
                                    zZzw = zzifVarZzr8.zzw(str21116, zzbcVar.zzb);
                                    zzas zzasVarZzo7 = zzj().zzo(zza(), str21116, false, false, false, false, false, false, false);
                                    if (zZzw) {
                                    }
                                    i3 = 0;
                                    break;
                                }
                                next = zzbeVar2.next();
                                String str21117 = next;
                                if (str11.equals(next)) {
                                }
                                i3 = 1;
                                break;
                            }
                            zzawVarZzj4.zzg();
                            zzawVarZzj4.zzav();
                            Preconditions.checkNotNull(zzbcVar);
                            str12 = zzbcVar.zza;
                            Preconditions.checkNotEmpty(str12);
                            byte[] bArrZzcd14 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                            contentValues = new ContentValues();
                            contentValues.put(str21115, str12);
                            contentValues.put("name", zzbcVar.zzb);
                            contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzf7));
                            contentValues.put("data", bArrZzcd14);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                            } else {
                                this.zza = 0L;
                            }
                            zzj().zzS();
                            zzj().zzL();
                            zzaL();
                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                            return;
                        }
                        jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                        if (jMax <= 0) {
                            bundleZzc = zzbfVar2.zzc();
                            zzqf zzqfVarZzB8 = zzB();
                            String str21118 = zzbhVar3.zzc;
                            zzqfVarZzB8.zzS(bundleZzc, "_o", str21118);
                            if (zzB().zzak(str17, zzrVar.zzD)) {
                                zzB().zzS(bundleZzc, "_dbg", 1L);
                                zzB().zzS(bundleZzc, "_r", 1L);
                            }
                            if ("_s".equals(str)) {
                                obj2 = zzqdVarZzy2.zze;
                                if (obj2 instanceof Long) {
                                    zzB().zzS(bundleZzc, "_sno", obj2);
                                }
                            }
                            if (zzi().zzx(null, zzgi.zzbg)) {
                                double d8 = Double.parseDouble((String) obj);
                                bundleZzc.remove("value");
                                bundleZzc.putDouble("value", d8);
                            }
                            zzawVarZzj2 = zzj();
                            Preconditions.checkNotEmpty(str17);
                            zzawVarZzj2.zzg();
                            zzawVarZzj2.zzav();
                            str2 = str16;
                            jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                            if (jDelete > 0) {
                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                            }
                            zzioVar = this.zzn;
                            str3 = str2;
                            zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                            zzaw zzawVarZzj12 = zzj();
                            str4 = zzbcVar.zzb;
                            zzbdVarZzs = zzawVarZzj12.zzs(str17, str4);
                            if (zzbdVarZzs != null) {
                                if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                }
                                zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                            } else {
                                zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                            }
                            zzj().zzV(zzbdVarZzc);
                            zzaX().zzg();
                            zzM();
                            Preconditions.checkNotNull(zzbcVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str21119 = zzbcVar.zza;
                            Preconditions.checkNotEmpty(str21119);
                            str5 = zzrVar.zza;
                            Preconditions.checkArgument(str21119.equals(str5));
                            zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                            boolean z9 = true;
                            zzhwVarZzz.zzar(1);
                            zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                            if (!TextUtils.isEmpty(str5)) {
                                zzhwVarZzz.zzI(str5);
                            }
                            str6 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str6)) {
                                zzhwVarZzz.zzK(str6);
                            }
                            str7 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str7)) {
                                zzhwVarZzz.zzL(str7);
                            }
                            str8 = zzrVar.zzw;
                            if (!TextUtils.isEmpty(str8)) {
                                zzhwVarZzz.zzav(str8);
                            }
                            j = zzrVar.zzj;
                            if (j != -2147483648L) {
                                zzhwVarZzz.zzM((int) j);
                            }
                            zzhwVarZzz.zzai(zzrVar.zze);
                            str9 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str9)) {
                                zzhwVarZzz.zzah(str9);
                            }
                            zzjx zzjxVarZzl9 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzhwVarZzz.zzT(zzjxVarZzl9.zzp());
                            if (zzhwVarZzz.zzaJ().isEmpty()) {
                                str13 = zzrVar.zzp;
                                if (!TextUtils.isEmpty(str13)) {
                                    zzhwVarZzz.zzH(str13);
                                }
                            }
                            zzqr.zzb();
                            if (!zzi().zzx(str5, zzgi.zzaV)) {
                            }
                            j2 = zzrVar.zzf;
                            if (j2 != 0) {
                                zzhwVarZzz.zzW(j2);
                            }
                            zzhwVarZzz.zzZ(zzrVar.zzr);
                            zzqa zzqaVarZzA8 = zzA();
                            zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA8.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                }
                            });
                            if (zzjmVarZza == null) {
                                mapZzd = Collections.emptyMap();
                            } else {
                                mapZzd = zzjmVarZza.zzd();
                            }
                            if (mapZzd != null) {
                                arrayList = null;
                            } else {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                                zzhwVarZzz.zzk(arrayList);
                            }
                            if (zzi().zzx(null, zzgi.zzbk)) {
                                zzhwVarZzz.zzaf("");
                            }
                            str10 = zzrVar.zza;
                            zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzjwVar = zzjw.AD_STORAGE;
                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                zzjxVarZzl = zzjxVarZzl;
                                zzjwVar = zzjwVar;
                                str11 = "_r";
                            } else {
                                zzjxVarZzl = zzjxVarZzl;
                                zzjwVar = zzjwVar;
                                str11 = "_r";
                            }
                            zzioVar2 = this.zzn;
                            zzioVar2.zzg().zzv();
                            zzhwVarZzz.zzX(Build.MODEL);
                            zzioVar2.zzg().zzv();
                            zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                            zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                            zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                            zzhwVarZzz.zzay(zzrVar.zzy);
                            if (zzioVar2.zzJ()) {
                                zzhwVarZzz.zzaF();
                                if (!TextUtils.isEmpty(null)) {
                                    zzhwVarZzz.zzY(null);
                                }
                            }
                            zzhVarZzl = zzj().zzl(str10);
                            if (zzhVarZzl == null) {
                                zzhVarZzl = new zzh(zzioVar2, str10);
                                zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                zzhVarZzl.zzan(zzrVar.zzk);
                                zzhVarZzl.zzao(zzrVar.zzb);
                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                    zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                }
                                zzhVarZzl.zzat(0L);
                                zzhVarZzl.zzau(0L);
                                zzhVarZzl.zzas(0L);
                                zzhVarZzl.zzX(zzrVar.zzc);
                                zzhVarZzl.zzY(zzrVar.zzj);
                                zzhVarZzl.zzW(zzrVar.zzd);
                                zzhVarZzl.zzap(zzrVar.zze);
                                zzhVarZzl.zzaj(zzrVar.zzf);
                                zzhVarZzl.zzav(zzrVar.zzh);
                                zzhVarZzl.zzal(zzrVar.zzr);
                                i = 0;
                                zzj().zzT(zzhVarZzl, false, false);
                            } else {
                                i = 0;
                            }
                            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                            }
                            listZzE = zzj().zzE(str10);
                            while (i2 < listZzE.size()) {
                                com.google.android.gms.internal.measurement.zzin zzinVarZze8 = com.google.android.gms.internal.measurement.zzio.zze();
                                zzinVarZze8.zzf(((zzqd) listZzE.get(i2)).zzc);
                                zzinVarZze8.zzg(((zzqd) listZzE.get(i2)).zzd);
                                zzA().zzx(zzinVarZze8, ((zzqd) listZzE.get(i2)).zze);
                                zzhwVarZzz.zzo(zzinVarZze8);
                                if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                }
                            }
                            zzawVarZzj3 = zzj();
                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                            zzawVarZzj3.zzg();
                            zzawVarZzj3.zzav();
                            Preconditions.checkNotNull(zzhxVar);
                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                            byte[] bArrZzcd15 = zzhxVar.zzcd();
                            long jZzf8 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd15);
                            ContentValues contentValues9 = new ContentValues();
                            String str211110 = str14;
                            contentValues9.put(str211110, zzhxVar.zzF());
                            contentValues9.put("metadata_fingerprint", Long.valueOf(jZzf8));
                            contentValues9.put("metadata", bArrZzcd15);
                            zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues9, 4);
                            zzawVarZzj4 = zzj();
                            zzbeVar2 = new zzbe(zzbcVar.zzf);
                            while (true) {
                                if (zzbeVar2.hasNext()) {
                                    zzif zzifVarZzr9 = zzr();
                                    String str211111 = zzbcVar.zza;
                                    zZzw = zzifVarZzr9.zzw(str211111, zzbcVar.zzb);
                                    zzas zzasVarZzo8 = zzj().zzo(zza(), str211111, false, false, false, false, false, false, false);
                                    if (zZzw) {
                                    }
                                    i3 = 0;
                                    break;
                                }
                                next = zzbeVar2.next();
                                String str211112 = next;
                                if (str11.equals(next)) {
                                }
                                i3 = 1;
                                break;
                            }
                            zzawVarZzj4.zzg();
                            zzawVarZzj4.zzav();
                            Preconditions.checkNotNull(zzbcVar);
                            str12 = zzbcVar.zza;
                            Preconditions.checkNotEmpty(str12);
                            byte[] bArrZzcd16 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                            contentValues = new ContentValues();
                            contentValues.put(str211110, str12);
                            contentValues.put("name", zzbcVar.zzb);
                            contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzf8));
                            contentValues.put("data", bArrZzcd16);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                            } else {
                                this.zza = 0L;
                            }
                            zzj().zzS();
                            zzj().zzL();
                            zzaL();
                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                            return;
                        }
                        if (jMax == 1) {
                            zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                        }
                        zzj().zzS();
                    }
                } else {
                    if (z) {
                        z = true;
                        zzbfVar = zzbhVarZza.zzb;
                        strZzg = zzbfVar.zzg(FirebaseAnalytics.Param.CURRENCY);
                        if (z) {
                            dDoubleValue = zzbfVar.zzd("value").doubleValue() * 1000000.0d;
                            if (dDoubleValue == 0.0d) {
                                dDoubleValue = zzbfVar.zze("value").longValue() * 1000000.0d;
                            }
                            if (dDoubleValue <= 9.223372036854776E18d) {
                            }
                            zzaW().zzk().zzc("Data lost. Currency value is too big. appId", zzhe.zzn(str17), Double.valueOf(dDoubleValue));
                            zzj().zzS();
                        } else {
                            str14 = "app_id";
                            str15 = "_fx";
                            jLongValue = zzbfVar.zze("value").longValue();
                        }
                        if (!TextUtils.isEmpty(strZzg)) {
                            upperCase = strZzg.toUpperCase(Locale.US);
                            if (upperCase.matches("[A-Z]{3}")) {
                                strConcat = "_ltv_".concat(String.valueOf(upperCase));
                                zzqdVarZzy = zzj().zzy(str17, strConcat);
                                if (zzqdVarZzy == null) {
                                    zzbhVar2 = zzbhVarZza;
                                    zzawVarZzj = zzj();
                                    int iZzh2 = zzi().zzh(str17, zzgi.zzS) - 1;
                                    Preconditions.checkNotEmpty(str17);
                                    zzawVarZzj.zzg();
                                    zzawVarZzj.zzav();
                                    zzawVarZzj.zzj().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str17, str17, String.valueOf(iZzh2)});
                                    zzqdVar = new zzqd(str17, zzbhVar2.zzc, strConcat, zzaU().currentTimeMillis(), Long.valueOf(jLongValue));
                                    zzqdVar2 = zzqdVar;
                                    if (!zzj().zzai(zzqdVar2)) {
                                        zzaW().zze().zzd("Too many unique user properties are set. Ignoring user property. appId", zzhe.zzn(str17), this.zzn.zzj().zzf(zzqdVar2.zzc), zzqdVar2.zze);
                                        zzB().zzR(this.zzK, str17, 9, null, null, 0);
                                    }
                                    str = zzbhVar2.zza;
                                    zZzaq = zzqf.zzaq(str);
                                    zEquals = str19.equals(str);
                                    zzB();
                                    zzbfVar2 = zzbhVar2.zzb;
                                    if (zzbfVar2 == null) {
                                        length = 0;
                                    } else {
                                        zzbeVar = new zzbe(zzbfVar2);
                                        length = 0;
                                        while (zzbeVar.hasNext()) {
                                            String next4 = zzbeVar.next();
                                            String str221 = next4;
                                            objZzf = zzbfVar2.zzf(next4);
                                            if (objZzf instanceof Parcelable[]) {
                                                length += (long) ((Parcelable[]) objZzf).length;
                                            }
                                        }
                                    }
                                    zzbhVar3 = zzbhVar2;
                                    zzasVarZzp = zzj().zzp(zza(), str17, length + 1, true, zZzaq, false, zEquals, false, false, false);
                                    long j8 = zzasVarZzp.zzb;
                                    zzi();
                                    jZzH = j8 - zzam.zzH();
                                    if (jZzH > 0) {
                                        if (jZzH % 1000 == 1) {
                                            zzaW().zze().zzc("Data loss. Too many events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzb));
                                        }
                                        zzj().zzS();
                                    } else if (zZzaq) {
                                        long j9 = zzasVarZzp.zza;
                                        zzi();
                                        jIntValue = j9 - ((long) ((Integer) zzgi.zzm.zza(null)).intValue());
                                        if (jIntValue > 0) {
                                            if (jIntValue % 1000 == 1) {
                                                zzaW().zze().zzc("Data loss. Too many public events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zza));
                                            }
                                            zzB().zzR(this.zzK, str17, 16, "_ev", zzbhVar3.zza, 0);
                                            zzj().zzS();
                                        } else {
                                            if (zEquals) {
                                                bundleZzc = zzbfVar2.zzc();
                                                zzqf zzqfVarZzB9 = zzB();
                                                String str211113 = zzbhVar3.zzc;
                                                zzqfVarZzB9.zzS(bundleZzc, "_o", str211113);
                                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                                    zzB().zzS(bundleZzc, "_dbg", 1L);
                                                    zzB().zzS(bundleZzc, "_r", 1L);
                                                }
                                                if ("_s".equals(str)) {
                                                    obj2 = zzqdVarZzy2.zze;
                                                    if (obj2 instanceof Long) {
                                                        zzB().zzS(bundleZzc, "_sno", obj2);
                                                    }
                                                }
                                                if (zzi().zzx(null, zzgi.zzbg)) {
                                                    double d9 = Double.parseDouble((String) obj);
                                                    bundleZzc.remove("value");
                                                    bundleZzc.putDouble("value", d9);
                                                }
                                                zzawVarZzj2 = zzj();
                                                Preconditions.checkNotEmpty(str17);
                                                zzawVarZzj2.zzg();
                                                zzawVarZzj2.zzav();
                                                str2 = str16;
                                                jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                                if (jDelete > 0) {
                                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                                }
                                                zzioVar = this.zzn;
                                                str3 = str2;
                                                zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                                zzaw zzawVarZzj13 = zzj();
                                                str4 = zzbcVar.zzb;
                                                zzbdVarZzs = zzawVarZzj13.zzs(str17, str4);
                                                if (zzbdVarZzs != null) {
                                                    if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                                    }
                                                    zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                                } else {
                                                    zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                                    zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                                }
                                                zzj().zzV(zzbdVarZzc);
                                                zzaX().zzg();
                                                zzM();
                                                Preconditions.checkNotNull(zzbcVar);
                                                Preconditions.checkNotNull(zzrVar);
                                                String str211114 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str211114);
                                                str5 = zzrVar.zza;
                                                Preconditions.checkArgument(str211114.equals(str5));
                                                zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                                boolean z10 = true;
                                                zzhwVarZzz.zzar(1);
                                                zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                                if (!TextUtils.isEmpty(str5)) {
                                                    zzhwVarZzz.zzI(str5);
                                                }
                                                str6 = zzrVar.zzd;
                                                if (!TextUtils.isEmpty(str6)) {
                                                    zzhwVarZzz.zzK(str6);
                                                }
                                                str7 = zzrVar.zzc;
                                                if (!TextUtils.isEmpty(str7)) {
                                                    zzhwVarZzz.zzL(str7);
                                                }
                                                str8 = zzrVar.zzw;
                                                if (!TextUtils.isEmpty(str8)) {
                                                    zzhwVarZzz.zzav(str8);
                                                }
                                                j = zzrVar.zzj;
                                                if (j != -2147483648L) {
                                                    zzhwVarZzz.zzM((int) j);
                                                }
                                                zzhwVarZzz.zzai(zzrVar.zze);
                                                str9 = zzrVar.zzb;
                                                if (!TextUtils.isEmpty(str9)) {
                                                    zzhwVarZzz.zzah(str9);
                                                }
                                                zzjx zzjxVarZzl10 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                                zzhwVarZzz.zzT(zzjxVarZzl10.zzp());
                                                if (zzhwVarZzz.zzaJ().isEmpty()) {
                                                    str13 = zzrVar.zzp;
                                                    if (!TextUtils.isEmpty(str13)) {
                                                        zzhwVarZzz.zzH(str13);
                                                    }
                                                }
                                                zzqr.zzb();
                                                if (!zzi().zzx(str5, zzgi.zzaV)) {
                                                }
                                                j2 = zzrVar.zzf;
                                                if (j2 != 0) {
                                                    zzhwVarZzz.zzW(j2);
                                                }
                                                zzhwVarZzz.zzZ(zzrVar.zzr);
                                                zzqa zzqaVarZzA9 = zzA();
                                                zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA9.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                                    }
                                                });
                                                if (zzjmVarZza == null) {
                                                    mapZzd = Collections.emptyMap();
                                                } else {
                                                    mapZzd = zzjmVarZza.zzd();
                                                }
                                                if (mapZzd != null) {
                                                    arrayList = null;
                                                } else {
                                                    arrayList = null;
                                                }
                                                if (arrayList != null) {
                                                    zzhwVarZzz.zzk(arrayList);
                                                }
                                                if (zzi().zzx(null, zzgi.zzbk)) {
                                                    zzhwVarZzz.zzaf("");
                                                }
                                                str10 = zzrVar.zza;
                                                zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                                zzjwVar = zzjw.AD_STORAGE;
                                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                } else {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                }
                                                zzioVar2 = this.zzn;
                                                zzioVar2.zzg().zzv();
                                                zzhwVarZzz.zzX(Build.MODEL);
                                                zzioVar2.zzg().zzv();
                                                zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                                zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                                zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                                zzhwVarZzz.zzay(zzrVar.zzy);
                                                if (zzioVar2.zzJ()) {
                                                    zzhwVarZzz.zzaF();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzhwVarZzz.zzY(null);
                                                    }
                                                }
                                                zzhVarZzl = zzj().zzl(str10);
                                                if (zzhVarZzl == null) {
                                                    zzhVarZzl = new zzh(zzioVar2, str10);
                                                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                                    zzhVarZzl.zzan(zzrVar.zzk);
                                                    zzhVarZzl.zzao(zzrVar.zzb);
                                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                                        zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                                    }
                                                    zzhVarZzl.zzat(0L);
                                                    zzhVarZzl.zzau(0L);
                                                    zzhVarZzl.zzas(0L);
                                                    zzhVarZzl.zzX(zzrVar.zzc);
                                                    zzhVarZzl.zzY(zzrVar.zzj);
                                                    zzhVarZzl.zzW(zzrVar.zzd);
                                                    zzhVarZzl.zzap(zzrVar.zze);
                                                    zzhVarZzl.zzaj(zzrVar.zzf);
                                                    zzhVarZzl.zzav(zzrVar.zzh);
                                                    zzhVarZzl.zzal(zzrVar.zzr);
                                                    i = 0;
                                                    zzj().zzT(zzhVarZzl, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                    zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                                }
                                                if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                                    zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                                }
                                                listZzE = zzj().zzE(str10);
                                                while (i2 < listZzE.size()) {
                                                    com.google.android.gms.internal.measurement.zzin zzinVarZze9 = com.google.android.gms.internal.measurement.zzio.zze();
                                                    zzinVarZze9.zzf(((zzqd) listZzE.get(i2)).zzc);
                                                    zzinVarZze9.zzg(((zzqd) listZzE.get(i2)).zzd);
                                                    zzA().zzx(zzinVarZze9, ((zzqd) listZzE.get(i2)).zze);
                                                    zzhwVarZzz.zzo(zzinVarZze9);
                                                    if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                                    }
                                                }
                                                zzawVarZzj3 = zzj();
                                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                                zzawVarZzj3.zzg();
                                                zzawVarZzj3.zzav();
                                                Preconditions.checkNotNull(zzhxVar);
                                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                                byte[] bArrZzcd17 = zzhxVar.zzcd();
                                                long jZzf9 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd17);
                                                ContentValues contentValues10 = new ContentValues();
                                                String str211115 = str14;
                                                contentValues10.put(str211115, zzhxVar.zzF());
                                                contentValues10.put("metadata_fingerprint", Long.valueOf(jZzf9));
                                                contentValues10.put("metadata", bArrZzcd17);
                                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues10, 4);
                                                zzawVarZzj4 = zzj();
                                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                                while (true) {
                                                    if (zzbeVar2.hasNext()) {
                                                        zzif zzifVarZzr10 = zzr();
                                                        String str211116 = zzbcVar.zza;
                                                        zZzw = zzifVarZzr10.zzw(str211116, zzbcVar.zzb);
                                                        zzas zzasVarZzo9 = zzj().zzo(zza(), str211116, false, false, false, false, false, false, false);
                                                        if (zZzw) {
                                                        }
                                                        i3 = 0;
                                                        break;
                                                    }
                                                    next = zzbeVar2.next();
                                                    String str211117 = next;
                                                    if (str11.equals(next)) {
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzawVarZzj4.zzg();
                                                zzawVarZzj4.zzav();
                                                Preconditions.checkNotNull(zzbcVar);
                                                str12 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str12);
                                                byte[] bArrZzcd18 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                                contentValues = new ContentValues();
                                                contentValues.put(str211115, str12);
                                                contentValues.put("name", zzbcVar.zzb);
                                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf9));
                                                contentValues.put("data", bArrZzcd18);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                    zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzS();
                                                zzj().zzL();
                                                zzaL();
                                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                            jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                                            if (jMax <= 0) {
                                                bundleZzc = zzbfVar2.zzc();
                                                zzqf zzqfVarZzB10 = zzB();
                                                String str211118 = zzbhVar3.zzc;
                                                zzqfVarZzB10.zzS(bundleZzc, "_o", str211118);
                                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                                    zzB().zzS(bundleZzc, "_dbg", 1L);
                                                    zzB().zzS(bundleZzc, "_r", 1L);
                                                }
                                                if ("_s".equals(str)) {
                                                    obj2 = zzqdVarZzy2.zze;
                                                    if (obj2 instanceof Long) {
                                                        zzB().zzS(bundleZzc, "_sno", obj2);
                                                    }
                                                }
                                                if (zzi().zzx(null, zzgi.zzbg)) {
                                                    double d10 = Double.parseDouble((String) obj);
                                                    bundleZzc.remove("value");
                                                    bundleZzc.putDouble("value", d10);
                                                }
                                                zzawVarZzj2 = zzj();
                                                Preconditions.checkNotEmpty(str17);
                                                zzawVarZzj2.zzg();
                                                zzawVarZzj2.zzav();
                                                str2 = str16;
                                                jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                                if (jDelete > 0) {
                                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                                }
                                                zzioVar = this.zzn;
                                                str3 = str2;
                                                zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                                zzaw zzawVarZzj14 = zzj();
                                                str4 = zzbcVar.zzb;
                                                zzbdVarZzs = zzawVarZzj14.zzs(str17, str4);
                                                if (zzbdVarZzs != null) {
                                                    if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                                    }
                                                    zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                                } else {
                                                    zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                                    zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                                }
                                                zzj().zzV(zzbdVarZzc);
                                                zzaX().zzg();
                                                zzM();
                                                Preconditions.checkNotNull(zzbcVar);
                                                Preconditions.checkNotNull(zzrVar);
                                                String str211119 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str211119);
                                                str5 = zzrVar.zza;
                                                Preconditions.checkArgument(str211119.equals(str5));
                                                zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                                boolean z11 = true;
                                                zzhwVarZzz.zzar(1);
                                                zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                                if (!TextUtils.isEmpty(str5)) {
                                                    zzhwVarZzz.zzI(str5);
                                                }
                                                str6 = zzrVar.zzd;
                                                if (!TextUtils.isEmpty(str6)) {
                                                    zzhwVarZzz.zzK(str6);
                                                }
                                                str7 = zzrVar.zzc;
                                                if (!TextUtils.isEmpty(str7)) {
                                                    zzhwVarZzz.zzL(str7);
                                                }
                                                str8 = zzrVar.zzw;
                                                if (!TextUtils.isEmpty(str8)) {
                                                    zzhwVarZzz.zzav(str8);
                                                }
                                                j = zzrVar.zzj;
                                                if (j != -2147483648L) {
                                                    zzhwVarZzz.zzM((int) j);
                                                }
                                                zzhwVarZzz.zzai(zzrVar.zze);
                                                str9 = zzrVar.zzb;
                                                if (!TextUtils.isEmpty(str9)) {
                                                    zzhwVarZzz.zzah(str9);
                                                }
                                                zzjx zzjxVarZzl11 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                                zzhwVarZzz.zzT(zzjxVarZzl11.zzp());
                                                if (zzhwVarZzz.zzaJ().isEmpty()) {
                                                    str13 = zzrVar.zzp;
                                                    if (!TextUtils.isEmpty(str13)) {
                                                        zzhwVarZzz.zzH(str13);
                                                    }
                                                }
                                                zzqr.zzb();
                                                if (!zzi().zzx(str5, zzgi.zzaV)) {
                                                }
                                                j2 = zzrVar.zzf;
                                                if (j2 != 0) {
                                                    zzhwVarZzz.zzW(j2);
                                                }
                                                zzhwVarZzz.zzZ(zzrVar.zzr);
                                                zzqa zzqaVarZzA10 = zzA();
                                                zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA10.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                                    }
                                                });
                                                if (zzjmVarZza == null) {
                                                    mapZzd = Collections.emptyMap();
                                                } else {
                                                    mapZzd = zzjmVarZza.zzd();
                                                }
                                                if (mapZzd != null) {
                                                    arrayList = null;
                                                } else {
                                                    arrayList = null;
                                                }
                                                if (arrayList != null) {
                                                    zzhwVarZzz.zzk(arrayList);
                                                }
                                                if (zzi().zzx(null, zzgi.zzbk)) {
                                                    zzhwVarZzz.zzaf("");
                                                }
                                                str10 = zzrVar.zza;
                                                zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                                zzjwVar = zzjw.AD_STORAGE;
                                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                } else {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                }
                                                zzioVar2 = this.zzn;
                                                zzioVar2.zzg().zzv();
                                                zzhwVarZzz.zzX(Build.MODEL);
                                                zzioVar2.zzg().zzv();
                                                zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                                zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                                zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                                zzhwVarZzz.zzay(zzrVar.zzy);
                                                if (zzioVar2.zzJ()) {
                                                    zzhwVarZzz.zzaF();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzhwVarZzz.zzY(null);
                                                    }
                                                }
                                                zzhVarZzl = zzj().zzl(str10);
                                                if (zzhVarZzl == null) {
                                                    zzhVarZzl = new zzh(zzioVar2, str10);
                                                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                                    zzhVarZzl.zzan(zzrVar.zzk);
                                                    zzhVarZzl.zzao(zzrVar.zzb);
                                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                                        zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                                    }
                                                    zzhVarZzl.zzat(0L);
                                                    zzhVarZzl.zzau(0L);
                                                    zzhVarZzl.zzas(0L);
                                                    zzhVarZzl.zzX(zzrVar.zzc);
                                                    zzhVarZzl.zzY(zzrVar.zzj);
                                                    zzhVarZzl.zzW(zzrVar.zzd);
                                                    zzhVarZzl.zzap(zzrVar.zze);
                                                    zzhVarZzl.zzaj(zzrVar.zzf);
                                                    zzhVarZzl.zzav(zzrVar.zzh);
                                                    zzhVarZzl.zzal(zzrVar.zzr);
                                                    i = 0;
                                                    zzj().zzT(zzhVarZzl, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                    zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                                }
                                                if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                                    zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                                }
                                                listZzE = zzj().zzE(str10);
                                                while (i2 < listZzE.size()) {
                                                    com.google.android.gms.internal.measurement.zzin zzinVarZze10 = com.google.android.gms.internal.measurement.zzio.zze();
                                                    zzinVarZze10.zzf(((zzqd) listZzE.get(i2)).zzc);
                                                    zzinVarZze10.zzg(((zzqd) listZzE.get(i2)).zzd);
                                                    zzA().zzx(zzinVarZze10, ((zzqd) listZzE.get(i2)).zze);
                                                    zzhwVarZzz.zzo(zzinVarZze10);
                                                    if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                                    }
                                                }
                                                zzawVarZzj3 = zzj();
                                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                                zzawVarZzj3.zzg();
                                                zzawVarZzj3.zzav();
                                                Preconditions.checkNotNull(zzhxVar);
                                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                                byte[] bArrZzcd19 = zzhxVar.zzcd();
                                                long jZzf10 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd19);
                                                ContentValues contentValues11 = new ContentValues();
                                                String str2111110 = str14;
                                                contentValues11.put(str2111110, zzhxVar.zzF());
                                                contentValues11.put("metadata_fingerprint", Long.valueOf(jZzf10));
                                                contentValues11.put("metadata", bArrZzcd19);
                                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues11, 4);
                                                zzawVarZzj4 = zzj();
                                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                                while (true) {
                                                    if (zzbeVar2.hasNext()) {
                                                        zzif zzifVarZzr11 = zzr();
                                                        String str2111111 = zzbcVar.zza;
                                                        zZzw = zzifVarZzr11.zzw(str2111111, zzbcVar.zzb);
                                                        zzas zzasVarZzo10 = zzj().zzo(zza(), str2111111, false, false, false, false, false, false, false);
                                                        if (zZzw) {
                                                        }
                                                        i3 = 0;
                                                        break;
                                                    }
                                                    next = zzbeVar2.next();
                                                    String str2111112 = next;
                                                    if (str11.equals(next)) {
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzawVarZzj4.zzg();
                                                zzawVarZzj4.zzav();
                                                Preconditions.checkNotNull(zzbcVar);
                                                str12 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str12);
                                                byte[] bArrZzcd110 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                                contentValues = new ContentValues();
                                                contentValues.put(str2111110, str12);
                                                contentValues.put("name", zzbcVar.zzb);
                                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf10));
                                                contentValues.put("data", bArrZzcd110);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                    zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzS();
                                                zzj().zzL();
                                                zzaL();
                                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                            if (jMax == 1) {
                                                zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                                            }
                                            zzj().zzS();
                                        }
                                    } else {
                                        if (zEquals) {
                                            bundleZzc = zzbfVar2.zzc();
                                            zzqf zzqfVarZzB11 = zzB();
                                            String str2111113 = zzbhVar3.zzc;
                                            zzqfVarZzB11.zzS(bundleZzc, "_o", str2111113);
                                            if (zzB().zzak(str17, zzrVar.zzD)) {
                                                zzB().zzS(bundleZzc, "_dbg", 1L);
                                                zzB().zzS(bundleZzc, "_r", 1L);
                                            }
                                            if ("_s".equals(str)) {
                                                obj2 = zzqdVarZzy2.zze;
                                                if (obj2 instanceof Long) {
                                                    zzB().zzS(bundleZzc, "_sno", obj2);
                                                }
                                            }
                                            if (zzi().zzx(null, zzgi.zzbg)) {
                                                double d11 = Double.parseDouble((String) obj);
                                                bundleZzc.remove("value");
                                                bundleZzc.putDouble("value", d11);
                                            }
                                            zzawVarZzj2 = zzj();
                                            Preconditions.checkNotEmpty(str17);
                                            zzawVarZzj2.zzg();
                                            zzawVarZzj2.zzav();
                                            str2 = str16;
                                            jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                            if (jDelete > 0) {
                                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                            }
                                            zzioVar = this.zzn;
                                            str3 = str2;
                                            zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                            zzaw zzawVarZzj15 = zzj();
                                            str4 = zzbcVar.zzb;
                                            zzbdVarZzs = zzawVarZzj15.zzs(str17, str4);
                                            if (zzbdVarZzs != null) {
                                                if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                                }
                                                zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                            } else {
                                                zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                                zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                            }
                                            zzj().zzV(zzbdVarZzc);
                                            zzaX().zzg();
                                            zzM();
                                            Preconditions.checkNotNull(zzbcVar);
                                            Preconditions.checkNotNull(zzrVar);
                                            String str2111114 = zzbcVar.zza;
                                            Preconditions.checkNotEmpty(str2111114);
                                            str5 = zzrVar.zza;
                                            Preconditions.checkArgument(str2111114.equals(str5));
                                            zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                            boolean z12 = true;
                                            zzhwVarZzz.zzar(1);
                                            zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                            if (!TextUtils.isEmpty(str5)) {
                                                zzhwVarZzz.zzI(str5);
                                            }
                                            str6 = zzrVar.zzd;
                                            if (!TextUtils.isEmpty(str6)) {
                                                zzhwVarZzz.zzK(str6);
                                            }
                                            str7 = zzrVar.zzc;
                                            if (!TextUtils.isEmpty(str7)) {
                                                zzhwVarZzz.zzL(str7);
                                            }
                                            str8 = zzrVar.zzw;
                                            if (!TextUtils.isEmpty(str8)) {
                                                zzhwVarZzz.zzav(str8);
                                            }
                                            j = zzrVar.zzj;
                                            if (j != -2147483648L) {
                                                zzhwVarZzz.zzM((int) j);
                                            }
                                            zzhwVarZzz.zzai(zzrVar.zze);
                                            str9 = zzrVar.zzb;
                                            if (!TextUtils.isEmpty(str9)) {
                                                zzhwVarZzz.zzah(str9);
                                            }
                                            zzjx zzjxVarZzl12 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzhwVarZzz.zzT(zzjxVarZzl12.zzp());
                                            if (zzhwVarZzz.zzaJ().isEmpty()) {
                                                str13 = zzrVar.zzp;
                                                if (!TextUtils.isEmpty(str13)) {
                                                    zzhwVarZzz.zzH(str13);
                                                }
                                            }
                                            zzqr.zzb();
                                            if (!zzi().zzx(str5, zzgi.zzaV)) {
                                            }
                                            j2 = zzrVar.zzf;
                                            if (j2 != 0) {
                                                zzhwVarZzz.zzW(j2);
                                            }
                                            zzhwVarZzz.zzZ(zzrVar.zzr);
                                            zzqa zzqaVarZzA11 = zzA();
                                            zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA11.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                                }
                                            });
                                            if (zzjmVarZza == null) {
                                                mapZzd = Collections.emptyMap();
                                            } else {
                                                mapZzd = zzjmVarZza.zzd();
                                            }
                                            if (mapZzd != null) {
                                                arrayList = null;
                                            } else {
                                                arrayList = null;
                                            }
                                            if (arrayList != null) {
                                                zzhwVarZzz.zzk(arrayList);
                                            }
                                            if (zzi().zzx(null, zzgi.zzbk)) {
                                                zzhwVarZzz.zzaf("");
                                            }
                                            str10 = zzrVar.zza;
                                            zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzjwVar = zzjw.AD_STORAGE;
                                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            } else {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            }
                                            zzioVar2 = this.zzn;
                                            zzioVar2.zzg().zzv();
                                            zzhwVarZzz.zzX(Build.MODEL);
                                            zzioVar2.zzg().zzv();
                                            zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                            zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                            zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                            zzhwVarZzz.zzay(zzrVar.zzy);
                                            if (zzioVar2.zzJ()) {
                                                zzhwVarZzz.zzaF();
                                                if (!TextUtils.isEmpty(null)) {
                                                    zzhwVarZzz.zzY(null);
                                                }
                                            }
                                            zzhVarZzl = zzj().zzl(str10);
                                            if (zzhVarZzl == null) {
                                                zzhVarZzl = new zzh(zzioVar2, str10);
                                                zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                                zzhVarZzl.zzan(zzrVar.zzk);
                                                zzhVarZzl.zzao(zzrVar.zzb);
                                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                                    zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                                }
                                                zzhVarZzl.zzat(0L);
                                                zzhVarZzl.zzau(0L);
                                                zzhVarZzl.zzas(0L);
                                                zzhVarZzl.zzX(zzrVar.zzc);
                                                zzhVarZzl.zzY(zzrVar.zzj);
                                                zzhVarZzl.zzW(zzrVar.zzd);
                                                zzhVarZzl.zzap(zzrVar.zze);
                                                zzhVarZzl.zzaj(zzrVar.zzf);
                                                zzhVarZzl.zzav(zzrVar.zzh);
                                                zzhVarZzl.zzal(zzrVar.zzr);
                                                i = 0;
                                                zzj().zzT(zzhVarZzl, false, false);
                                            } else {
                                                i = 0;
                                            }
                                            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                            }
                                            if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                                zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                            }
                                            listZzE = zzj().zzE(str10);
                                            while (i2 < listZzE.size()) {
                                                com.google.android.gms.internal.measurement.zzin zzinVarZze11 = com.google.android.gms.internal.measurement.zzio.zze();
                                                zzinVarZze11.zzf(((zzqd) listZzE.get(i2)).zzc);
                                                zzinVarZze11.zzg(((zzqd) listZzE.get(i2)).zzd);
                                                zzA().zzx(zzinVarZze11, ((zzqd) listZzE.get(i2)).zze);
                                                zzhwVarZzz.zzo(zzinVarZze11);
                                                if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                                }
                                            }
                                            zzawVarZzj3 = zzj();
                                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                            zzawVarZzj3.zzg();
                                            zzawVarZzj3.zzav();
                                            Preconditions.checkNotNull(zzhxVar);
                                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                                            byte[] bArrZzcd111 = zzhxVar.zzcd();
                                            long jZzf11 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd111);
                                            ContentValues contentValues12 = new ContentValues();
                                            String str2111115 = str14;
                                            contentValues12.put(str2111115, zzhxVar.zzF());
                                            contentValues12.put("metadata_fingerprint", Long.valueOf(jZzf11));
                                            contentValues12.put("metadata", bArrZzcd111);
                                            zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues12, 4);
                                            zzawVarZzj4 = zzj();
                                            zzbeVar2 = new zzbe(zzbcVar.zzf);
                                            while (true) {
                                                if (zzbeVar2.hasNext()) {
                                                    zzif zzifVarZzr12 = zzr();
                                                    String str2111116 = zzbcVar.zza;
                                                    zZzw = zzifVarZzr12.zzw(str2111116, zzbcVar.zzb);
                                                    zzas zzasVarZzo11 = zzj().zzo(zza(), str2111116, false, false, false, false, false, false, false);
                                                    if (zZzw) {
                                                    }
                                                    i3 = 0;
                                                    break;
                                                }
                                                next = zzbeVar2.next();
                                                String str2111117 = next;
                                                if (str11.equals(next)) {
                                                }
                                                i3 = 1;
                                                break;
                                            }
                                            zzawVarZzj4.zzg();
                                            zzawVarZzj4.zzav();
                                            Preconditions.checkNotNull(zzbcVar);
                                            str12 = zzbcVar.zza;
                                            Preconditions.checkNotEmpty(str12);
                                            byte[] bArrZzcd112 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                            contentValues = new ContentValues();
                                            contentValues.put(str2111115, str12);
                                            contentValues.put("name", zzbcVar.zzb);
                                            contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzf11));
                                            contentValues.put("data", bArrZzcd112);
                                            contentValues.put("realtime", Integer.valueOf(i3));
                                            if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                            } else {
                                                this.zza = 0L;
                                            }
                                            zzj().zzS();
                                            zzj().zzL();
                                            zzaL();
                                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                                        if (jMax <= 0) {
                                            bundleZzc = zzbfVar2.zzc();
                                            zzqf zzqfVarZzB12 = zzB();
                                            String str2111118 = zzbhVar3.zzc;
                                            zzqfVarZzB12.zzS(bundleZzc, "_o", str2111118);
                                            if (zzB().zzak(str17, zzrVar.zzD)) {
                                                zzB().zzS(bundleZzc, "_dbg", 1L);
                                                zzB().zzS(bundleZzc, "_r", 1L);
                                            }
                                            if ("_s".equals(str)) {
                                                obj2 = zzqdVarZzy2.zze;
                                                if (obj2 instanceof Long) {
                                                    zzB().zzS(bundleZzc, "_sno", obj2);
                                                }
                                            }
                                            if (zzi().zzx(null, zzgi.zzbg)) {
                                                double d12 = Double.parseDouble((String) obj);
                                                bundleZzc.remove("value");
                                                bundleZzc.putDouble("value", d12);
                                            }
                                            zzawVarZzj2 = zzj();
                                            Preconditions.checkNotEmpty(str17);
                                            zzawVarZzj2.zzg();
                                            zzawVarZzj2.zzav();
                                            str2 = str16;
                                            jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                            if (jDelete > 0) {
                                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                            }
                                            zzioVar = this.zzn;
                                            str3 = str2;
                                            zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                            zzaw zzawVarZzj16 = zzj();
                                            str4 = zzbcVar.zzb;
                                            zzbdVarZzs = zzawVarZzj16.zzs(str17, str4);
                                            if (zzbdVarZzs != null) {
                                                if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                                }
                                                zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                            } else {
                                                zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                                zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                            }
                                            zzj().zzV(zzbdVarZzc);
                                            zzaX().zzg();
                                            zzM();
                                            Preconditions.checkNotNull(zzbcVar);
                                            Preconditions.checkNotNull(zzrVar);
                                            String str2111119 = zzbcVar.zza;
                                            Preconditions.checkNotEmpty(str2111119);
                                            str5 = zzrVar.zza;
                                            Preconditions.checkArgument(str2111119.equals(str5));
                                            zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                            boolean z13 = true;
                                            zzhwVarZzz.zzar(1);
                                            zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                            if (!TextUtils.isEmpty(str5)) {
                                                zzhwVarZzz.zzI(str5);
                                            }
                                            str6 = zzrVar.zzd;
                                            if (!TextUtils.isEmpty(str6)) {
                                                zzhwVarZzz.zzK(str6);
                                            }
                                            str7 = zzrVar.zzc;
                                            if (!TextUtils.isEmpty(str7)) {
                                                zzhwVarZzz.zzL(str7);
                                            }
                                            str8 = zzrVar.zzw;
                                            if (!TextUtils.isEmpty(str8)) {
                                                zzhwVarZzz.zzav(str8);
                                            }
                                            j = zzrVar.zzj;
                                            if (j != -2147483648L) {
                                                zzhwVarZzz.zzM((int) j);
                                            }
                                            zzhwVarZzz.zzai(zzrVar.zze);
                                            str9 = zzrVar.zzb;
                                            if (!TextUtils.isEmpty(str9)) {
                                                zzhwVarZzz.zzah(str9);
                                            }
                                            zzjx zzjxVarZzl13 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzhwVarZzz.zzT(zzjxVarZzl13.zzp());
                                            if (zzhwVarZzz.zzaJ().isEmpty()) {
                                                str13 = zzrVar.zzp;
                                                if (!TextUtils.isEmpty(str13)) {
                                                    zzhwVarZzz.zzH(str13);
                                                }
                                            }
                                            zzqr.zzb();
                                            if (!zzi().zzx(str5, zzgi.zzaV)) {
                                            }
                                            j2 = zzrVar.zzf;
                                            if (j2 != 0) {
                                                zzhwVarZzz.zzW(j2);
                                            }
                                            zzhwVarZzz.zzZ(zzrVar.zzr);
                                            zzqa zzqaVarZzA12 = zzA();
                                            zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA12.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                                }
                                            });
                                            if (zzjmVarZza == null) {
                                                mapZzd = Collections.emptyMap();
                                            } else {
                                                mapZzd = zzjmVarZza.zzd();
                                            }
                                            if (mapZzd != null) {
                                                arrayList = null;
                                            } else {
                                                arrayList = null;
                                            }
                                            if (arrayList != null) {
                                                zzhwVarZzz.zzk(arrayList);
                                            }
                                            if (zzi().zzx(null, zzgi.zzbk)) {
                                                zzhwVarZzz.zzaf("");
                                            }
                                            str10 = zzrVar.zza;
                                            zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzjwVar = zzjw.AD_STORAGE;
                                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            } else {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            }
                                            zzioVar2 = this.zzn;
                                            zzioVar2.zzg().zzv();
                                            zzhwVarZzz.zzX(Build.MODEL);
                                            zzioVar2.zzg().zzv();
                                            zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                            zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                            zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                            zzhwVarZzz.zzay(zzrVar.zzy);
                                            if (zzioVar2.zzJ()) {
                                                zzhwVarZzz.zzaF();
                                                if (!TextUtils.isEmpty(null)) {
                                                    zzhwVarZzz.zzY(null);
                                                }
                                            }
                                            zzhVarZzl = zzj().zzl(str10);
                                            if (zzhVarZzl == null) {
                                                zzhVarZzl = new zzh(zzioVar2, str10);
                                                zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                                zzhVarZzl.zzan(zzrVar.zzk);
                                                zzhVarZzl.zzao(zzrVar.zzb);
                                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                                    zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                                }
                                                zzhVarZzl.zzat(0L);
                                                zzhVarZzl.zzau(0L);
                                                zzhVarZzl.zzas(0L);
                                                zzhVarZzl.zzX(zzrVar.zzc);
                                                zzhVarZzl.zzY(zzrVar.zzj);
                                                zzhVarZzl.zzW(zzrVar.zzd);
                                                zzhVarZzl.zzap(zzrVar.zze);
                                                zzhVarZzl.zzaj(zzrVar.zzf);
                                                zzhVarZzl.zzav(zzrVar.zzh);
                                                zzhVarZzl.zzal(zzrVar.zzr);
                                                i = 0;
                                                zzj().zzT(zzhVarZzl, false, false);
                                            } else {
                                                i = 0;
                                            }
                                            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                            }
                                            if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                                zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                            }
                                            listZzE = zzj().zzE(str10);
                                            while (i2 < listZzE.size()) {
                                                com.google.android.gms.internal.measurement.zzin zzinVarZze12 = com.google.android.gms.internal.measurement.zzio.zze();
                                                zzinVarZze12.zzf(((zzqd) listZzE.get(i2)).zzc);
                                                zzinVarZze12.zzg(((zzqd) listZzE.get(i2)).zzd);
                                                zzA().zzx(zzinVarZze12, ((zzqd) listZzE.get(i2)).zze);
                                                zzhwVarZzz.zzo(zzinVarZze12);
                                                if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                                }
                                            }
                                            zzawVarZzj3 = zzj();
                                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                            zzawVarZzj3.zzg();
                                            zzawVarZzj3.zzav();
                                            Preconditions.checkNotNull(zzhxVar);
                                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                                            byte[] bArrZzcd113 = zzhxVar.zzcd();
                                            long jZzf12 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd113);
                                            ContentValues contentValues13 = new ContentValues();
                                            String str21111110 = str14;
                                            contentValues13.put(str21111110, zzhxVar.zzF());
                                            contentValues13.put("metadata_fingerprint", Long.valueOf(jZzf12));
                                            contentValues13.put("metadata", bArrZzcd113);
                                            zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues13, 4);
                                            zzawVarZzj4 = zzj();
                                            zzbeVar2 = new zzbe(zzbcVar.zzf);
                                            while (true) {
                                                if (zzbeVar2.hasNext()) {
                                                    zzif zzifVarZzr13 = zzr();
                                                    String str21111111 = zzbcVar.zza;
                                                    zZzw = zzifVarZzr13.zzw(str21111111, zzbcVar.zzb);
                                                    zzas zzasVarZzo12 = zzj().zzo(zza(), str21111111, false, false, false, false, false, false, false);
                                                    if (zZzw) {
                                                    }
                                                    i3 = 0;
                                                    break;
                                                }
                                                next = zzbeVar2.next();
                                                String str21111112 = next;
                                                if (str11.equals(next)) {
                                                }
                                                i3 = 1;
                                                break;
                                            }
                                            zzawVarZzj4.zzg();
                                            zzawVarZzj4.zzav();
                                            Preconditions.checkNotNull(zzbcVar);
                                            str12 = zzbcVar.zza;
                                            Preconditions.checkNotEmpty(str12);
                                            byte[] bArrZzcd114 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                            contentValues = new ContentValues();
                                            contentValues.put(str21111110, str12);
                                            contentValues.put("name", zzbcVar.zzb);
                                            contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzf12));
                                            contentValues.put("data", bArrZzcd114);
                                            contentValues.put("realtime", Integer.valueOf(i3));
                                            if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                            } else {
                                                this.zza = 0L;
                                            }
                                            zzj().zzS();
                                            zzj().zzL();
                                            zzaL();
                                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        if (jMax == 1) {
                                            zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                                        }
                                        zzj().zzS();
                                    }
                                } else {
                                    zzbhVar2 = zzbhVarZza;
                                    zzawVarZzj = zzj();
                                    int iZzh3 = zzi().zzh(str17, zzgi.zzS) - 1;
                                    Preconditions.checkNotEmpty(str17);
                                    zzawVarZzj.zzg();
                                    zzawVarZzj.zzav();
                                    zzawVarZzj.zzj().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str17, str17, String.valueOf(iZzh3)});
                                    zzqdVar = new zzqd(str17, zzbhVar2.zzc, strConcat, zzaU().currentTimeMillis(), Long.valueOf(jLongValue));
                                    zzqdVar2 = zzqdVar;
                                    if (!zzj().zzai(zzqdVar2)) {
                                        zzaW().zze().zzd("Too many unique user properties are set. Ignoring user property. appId", zzhe.zzn(str17), this.zzn.zzj().zzf(zzqdVar2.zzc), zzqdVar2.zze);
                                        zzB().zzR(this.zzK, str17, 9, null, null, 0);
                                    }
                                    str = zzbhVar2.zza;
                                    zZzaq = zzqf.zzaq(str);
                                    zEquals = str19.equals(str);
                                    zzB();
                                    zzbfVar2 = zzbhVar2.zzb;
                                    if (zzbfVar2 == null) {
                                        length = 0;
                                    } else {
                                        zzbeVar = new zzbe(zzbfVar2);
                                        length = 0;
                                        while (zzbeVar.hasNext()) {
                                            String next5 = zzbeVar.next();
                                            String str222 = next5;
                                            objZzf = zzbfVar2.zzf(next5);
                                            if (objZzf instanceof Parcelable[]) {
                                                length += (long) ((Parcelable[]) objZzf).length;
                                            }
                                        }
                                    }
                                    zzbhVar3 = zzbhVar2;
                                    zzasVarZzp = zzj().zzp(zza(), str17, length + 1, true, zZzaq, false, zEquals, false, false, false);
                                    long j10 = zzasVarZzp.zzb;
                                    zzi();
                                    jZzH = j10 - zzam.zzH();
                                    if (jZzH > 0) {
                                        if (jZzH % 1000 == 1) {
                                            zzaW().zze().zzc("Data loss. Too many events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzb));
                                        }
                                        zzj().zzS();
                                    } else if (zZzaq) {
                                        long j11 = zzasVarZzp.zza;
                                        zzi();
                                        jIntValue = j11 - ((long) ((Integer) zzgi.zzm.zza(null)).intValue());
                                        if (jIntValue > 0) {
                                            if (jIntValue % 1000 == 1) {
                                                zzaW().zze().zzc("Data loss. Too many public events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zza));
                                            }
                                            zzB().zzR(this.zzK, str17, 16, "_ev", zzbhVar3.zza, 0);
                                            zzj().zzS();
                                        } else {
                                            if (zEquals) {
                                                bundleZzc = zzbfVar2.zzc();
                                                zzqf zzqfVarZzB13 = zzB();
                                                String str21111113 = zzbhVar3.zzc;
                                                zzqfVarZzB13.zzS(bundleZzc, "_o", str21111113);
                                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                                    zzB().zzS(bundleZzc, "_dbg", 1L);
                                                    zzB().zzS(bundleZzc, "_r", 1L);
                                                }
                                                if ("_s".equals(str)) {
                                                    obj2 = zzqdVarZzy2.zze;
                                                    if (obj2 instanceof Long) {
                                                        zzB().zzS(bundleZzc, "_sno", obj2);
                                                    }
                                                }
                                                if (zzi().zzx(null, zzgi.zzbg)) {
                                                    double d13 = Double.parseDouble((String) obj);
                                                    bundleZzc.remove("value");
                                                    bundleZzc.putDouble("value", d13);
                                                }
                                                zzawVarZzj2 = zzj();
                                                Preconditions.checkNotEmpty(str17);
                                                zzawVarZzj2.zzg();
                                                zzawVarZzj2.zzav();
                                                str2 = str16;
                                                jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                                if (jDelete > 0) {
                                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                                }
                                                zzioVar = this.zzn;
                                                str3 = str2;
                                                zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                                zzaw zzawVarZzj17 = zzj();
                                                str4 = zzbcVar.zzb;
                                                zzbdVarZzs = zzawVarZzj17.zzs(str17, str4);
                                                if (zzbdVarZzs != null) {
                                                    if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                                    }
                                                    zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                                } else {
                                                    zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                                    zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                                }
                                                zzj().zzV(zzbdVarZzc);
                                                zzaX().zzg();
                                                zzM();
                                                Preconditions.checkNotNull(zzbcVar);
                                                Preconditions.checkNotNull(zzrVar);
                                                String str21111114 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str21111114);
                                                str5 = zzrVar.zza;
                                                Preconditions.checkArgument(str21111114.equals(str5));
                                                zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                                boolean z14 = true;
                                                zzhwVarZzz.zzar(1);
                                                zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                                if (!TextUtils.isEmpty(str5)) {
                                                    zzhwVarZzz.zzI(str5);
                                                }
                                                str6 = zzrVar.zzd;
                                                if (!TextUtils.isEmpty(str6)) {
                                                    zzhwVarZzz.zzK(str6);
                                                }
                                                str7 = zzrVar.zzc;
                                                if (!TextUtils.isEmpty(str7)) {
                                                    zzhwVarZzz.zzL(str7);
                                                }
                                                str8 = zzrVar.zzw;
                                                if (!TextUtils.isEmpty(str8)) {
                                                    zzhwVarZzz.zzav(str8);
                                                }
                                                j = zzrVar.zzj;
                                                if (j != -2147483648L) {
                                                    zzhwVarZzz.zzM((int) j);
                                                }
                                                zzhwVarZzz.zzai(zzrVar.zze);
                                                str9 = zzrVar.zzb;
                                                if (!TextUtils.isEmpty(str9)) {
                                                    zzhwVarZzz.zzah(str9);
                                                }
                                                zzjx zzjxVarZzl14 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                                zzhwVarZzz.zzT(zzjxVarZzl14.zzp());
                                                if (zzhwVarZzz.zzaJ().isEmpty()) {
                                                    str13 = zzrVar.zzp;
                                                    if (!TextUtils.isEmpty(str13)) {
                                                        zzhwVarZzz.zzH(str13);
                                                    }
                                                }
                                                zzqr.zzb();
                                                if (!zzi().zzx(str5, zzgi.zzaV)) {
                                                }
                                                j2 = zzrVar.zzf;
                                                if (j2 != 0) {
                                                    zzhwVarZzz.zzW(j2);
                                                }
                                                zzhwVarZzz.zzZ(zzrVar.zzr);
                                                zzqa zzqaVarZzA13 = zzA();
                                                zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA13.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                                    }
                                                });
                                                if (zzjmVarZza == null) {
                                                    mapZzd = Collections.emptyMap();
                                                } else {
                                                    mapZzd = zzjmVarZza.zzd();
                                                }
                                                if (mapZzd != null) {
                                                    arrayList = null;
                                                } else {
                                                    arrayList = null;
                                                }
                                                if (arrayList != null) {
                                                    zzhwVarZzz.zzk(arrayList);
                                                }
                                                if (zzi().zzx(null, zzgi.zzbk)) {
                                                    zzhwVarZzz.zzaf("");
                                                }
                                                str10 = zzrVar.zza;
                                                zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                                zzjwVar = zzjw.AD_STORAGE;
                                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                } else {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                }
                                                zzioVar2 = this.zzn;
                                                zzioVar2.zzg().zzv();
                                                zzhwVarZzz.zzX(Build.MODEL);
                                                zzioVar2.zzg().zzv();
                                                zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                                zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                                zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                                zzhwVarZzz.zzay(zzrVar.zzy);
                                                if (zzioVar2.zzJ()) {
                                                    zzhwVarZzz.zzaF();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzhwVarZzz.zzY(null);
                                                    }
                                                }
                                                zzhVarZzl = zzj().zzl(str10);
                                                if (zzhVarZzl == null) {
                                                    zzhVarZzl = new zzh(zzioVar2, str10);
                                                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                                    zzhVarZzl.zzan(zzrVar.zzk);
                                                    zzhVarZzl.zzao(zzrVar.zzb);
                                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                                        zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                                    }
                                                    zzhVarZzl.zzat(0L);
                                                    zzhVarZzl.zzau(0L);
                                                    zzhVarZzl.zzas(0L);
                                                    zzhVarZzl.zzX(zzrVar.zzc);
                                                    zzhVarZzl.zzY(zzrVar.zzj);
                                                    zzhVarZzl.zzW(zzrVar.zzd);
                                                    zzhVarZzl.zzap(zzrVar.zze);
                                                    zzhVarZzl.zzaj(zzrVar.zzf);
                                                    zzhVarZzl.zzav(zzrVar.zzh);
                                                    zzhVarZzl.zzal(zzrVar.zzr);
                                                    i = 0;
                                                    zzj().zzT(zzhVarZzl, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                    zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                                }
                                                if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                                    zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                                }
                                                listZzE = zzj().zzE(str10);
                                                while (i2 < listZzE.size()) {
                                                    com.google.android.gms.internal.measurement.zzin zzinVarZze13 = com.google.android.gms.internal.measurement.zzio.zze();
                                                    zzinVarZze13.zzf(((zzqd) listZzE.get(i2)).zzc);
                                                    zzinVarZze13.zzg(((zzqd) listZzE.get(i2)).zzd);
                                                    zzA().zzx(zzinVarZze13, ((zzqd) listZzE.get(i2)).zze);
                                                    zzhwVarZzz.zzo(zzinVarZze13);
                                                    if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                                    }
                                                }
                                                zzawVarZzj3 = zzj();
                                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                                zzawVarZzj3.zzg();
                                                zzawVarZzj3.zzav();
                                                Preconditions.checkNotNull(zzhxVar);
                                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                                byte[] bArrZzcd115 = zzhxVar.zzcd();
                                                long jZzf13 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd115);
                                                ContentValues contentValues14 = new ContentValues();
                                                String str21111115 = str14;
                                                contentValues14.put(str21111115, zzhxVar.zzF());
                                                contentValues14.put("metadata_fingerprint", Long.valueOf(jZzf13));
                                                contentValues14.put("metadata", bArrZzcd115);
                                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues14, 4);
                                                zzawVarZzj4 = zzj();
                                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                                while (true) {
                                                    if (zzbeVar2.hasNext()) {
                                                        zzif zzifVarZzr14 = zzr();
                                                        String str21111116 = zzbcVar.zza;
                                                        zZzw = zzifVarZzr14.zzw(str21111116, zzbcVar.zzb);
                                                        zzas zzasVarZzo13 = zzj().zzo(zza(), str21111116, false, false, false, false, false, false, false);
                                                        if (zZzw) {
                                                        }
                                                        i3 = 0;
                                                        break;
                                                    }
                                                    next = zzbeVar2.next();
                                                    String str21111117 = next;
                                                    if (str11.equals(next)) {
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzawVarZzj4.zzg();
                                                zzawVarZzj4.zzav();
                                                Preconditions.checkNotNull(zzbcVar);
                                                str12 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str12);
                                                byte[] bArrZzcd116 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                                contentValues = new ContentValues();
                                                contentValues.put(str21111115, str12);
                                                contentValues.put("name", zzbcVar.zzb);
                                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf13));
                                                contentValues.put("data", bArrZzcd116);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                    zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzS();
                                                zzj().zzL();
                                                zzaL();
                                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                            jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                                            if (jMax <= 0) {
                                                bundleZzc = zzbfVar2.zzc();
                                                zzqf zzqfVarZzB14 = zzB();
                                                String str21111118 = zzbhVar3.zzc;
                                                zzqfVarZzB14.zzS(bundleZzc, "_o", str21111118);
                                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                                    zzB().zzS(bundleZzc, "_dbg", 1L);
                                                    zzB().zzS(bundleZzc, "_r", 1L);
                                                }
                                                if ("_s".equals(str)) {
                                                    obj2 = zzqdVarZzy2.zze;
                                                    if (obj2 instanceof Long) {
                                                        zzB().zzS(bundleZzc, "_sno", obj2);
                                                    }
                                                }
                                                if (zzi().zzx(null, zzgi.zzbg)) {
                                                    double d14 = Double.parseDouble((String) obj);
                                                    bundleZzc.remove("value");
                                                    bundleZzc.putDouble("value", d14);
                                                }
                                                zzawVarZzj2 = zzj();
                                                Preconditions.checkNotEmpty(str17);
                                                zzawVarZzj2.zzg();
                                                zzawVarZzj2.zzav();
                                                str2 = str16;
                                                jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                                if (jDelete > 0) {
                                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                                }
                                                zzioVar = this.zzn;
                                                str3 = str2;
                                                zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                                zzaw zzawVarZzj18 = zzj();
                                                str4 = zzbcVar.zzb;
                                                zzbdVarZzs = zzawVarZzj18.zzs(str17, str4);
                                                if (zzbdVarZzs != null) {
                                                    if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                                    }
                                                    zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                                } else {
                                                    zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                                    zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                                }
                                                zzj().zzV(zzbdVarZzc);
                                                zzaX().zzg();
                                                zzM();
                                                Preconditions.checkNotNull(zzbcVar);
                                                Preconditions.checkNotNull(zzrVar);
                                                String str21111119 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str21111119);
                                                str5 = zzrVar.zza;
                                                Preconditions.checkArgument(str21111119.equals(str5));
                                                zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                                boolean z15 = true;
                                                zzhwVarZzz.zzar(1);
                                                zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                                if (!TextUtils.isEmpty(str5)) {
                                                    zzhwVarZzz.zzI(str5);
                                                }
                                                str6 = zzrVar.zzd;
                                                if (!TextUtils.isEmpty(str6)) {
                                                    zzhwVarZzz.zzK(str6);
                                                }
                                                str7 = zzrVar.zzc;
                                                if (!TextUtils.isEmpty(str7)) {
                                                    zzhwVarZzz.zzL(str7);
                                                }
                                                str8 = zzrVar.zzw;
                                                if (!TextUtils.isEmpty(str8)) {
                                                    zzhwVarZzz.zzav(str8);
                                                }
                                                j = zzrVar.zzj;
                                                if (j != -2147483648L) {
                                                    zzhwVarZzz.zzM((int) j);
                                                }
                                                zzhwVarZzz.zzai(zzrVar.zze);
                                                str9 = zzrVar.zzb;
                                                if (!TextUtils.isEmpty(str9)) {
                                                    zzhwVarZzz.zzah(str9);
                                                }
                                                zzjx zzjxVarZzl15 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                                zzhwVarZzz.zzT(zzjxVarZzl15.zzp());
                                                if (zzhwVarZzz.zzaJ().isEmpty()) {
                                                    str13 = zzrVar.zzp;
                                                    if (!TextUtils.isEmpty(str13)) {
                                                        zzhwVarZzz.zzH(str13);
                                                    }
                                                }
                                                zzqr.zzb();
                                                if (!zzi().zzx(str5, zzgi.zzaV)) {
                                                }
                                                j2 = zzrVar.zzf;
                                                if (j2 != 0) {
                                                    zzhwVarZzz.zzW(j2);
                                                }
                                                zzhwVarZzz.zzZ(zzrVar.zzr);
                                                zzqa zzqaVarZzA14 = zzA();
                                                zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA14.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                                    }
                                                });
                                                if (zzjmVarZza == null) {
                                                    mapZzd = Collections.emptyMap();
                                                } else {
                                                    mapZzd = zzjmVarZza.zzd();
                                                }
                                                if (mapZzd != null) {
                                                    arrayList = null;
                                                } else {
                                                    arrayList = null;
                                                }
                                                if (arrayList != null) {
                                                    zzhwVarZzz.zzk(arrayList);
                                                }
                                                if (zzi().zzx(null, zzgi.zzbk)) {
                                                    zzhwVarZzz.zzaf("");
                                                }
                                                str10 = zzrVar.zza;
                                                zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                                zzjwVar = zzjw.AD_STORAGE;
                                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                } else {
                                                    zzjxVarZzl = zzjxVarZzl;
                                                    zzjwVar = zzjwVar;
                                                    str11 = "_r";
                                                }
                                                zzioVar2 = this.zzn;
                                                zzioVar2.zzg().zzv();
                                                zzhwVarZzz.zzX(Build.MODEL);
                                                zzioVar2.zzg().zzv();
                                                zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                                zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                                zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                                zzhwVarZzz.zzay(zzrVar.zzy);
                                                if (zzioVar2.zzJ()) {
                                                    zzhwVarZzz.zzaF();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzhwVarZzz.zzY(null);
                                                    }
                                                }
                                                zzhVarZzl = zzj().zzl(str10);
                                                if (zzhVarZzl == null) {
                                                    zzhVarZzl = new zzh(zzioVar2, str10);
                                                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                                    zzhVarZzl.zzan(zzrVar.zzk);
                                                    zzhVarZzl.zzao(zzrVar.zzb);
                                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                                        zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                                    }
                                                    zzhVarZzl.zzat(0L);
                                                    zzhVarZzl.zzau(0L);
                                                    zzhVarZzl.zzas(0L);
                                                    zzhVarZzl.zzX(zzrVar.zzc);
                                                    zzhVarZzl.zzY(zzrVar.zzj);
                                                    zzhVarZzl.zzW(zzrVar.zzd);
                                                    zzhVarZzl.zzap(zzrVar.zze);
                                                    zzhVarZzl.zzaj(zzrVar.zzf);
                                                    zzhVarZzl.zzav(zzrVar.zzh);
                                                    zzhVarZzl.zzal(zzrVar.zzr);
                                                    i = 0;
                                                    zzj().zzT(zzhVarZzl, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                    zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                                }
                                                if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                                    zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                                }
                                                listZzE = zzj().zzE(str10);
                                                while (i2 < listZzE.size()) {
                                                    com.google.android.gms.internal.measurement.zzin zzinVarZze14 = com.google.android.gms.internal.measurement.zzio.zze();
                                                    zzinVarZze14.zzf(((zzqd) listZzE.get(i2)).zzc);
                                                    zzinVarZze14.zzg(((zzqd) listZzE.get(i2)).zzd);
                                                    zzA().zzx(zzinVarZze14, ((zzqd) listZzE.get(i2)).zze);
                                                    zzhwVarZzz.zzo(zzinVarZze14);
                                                    if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                                    }
                                                }
                                                zzawVarZzj3 = zzj();
                                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                                zzawVarZzj3.zzg();
                                                zzawVarZzj3.zzav();
                                                Preconditions.checkNotNull(zzhxVar);
                                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                                byte[] bArrZzcd117 = zzhxVar.zzcd();
                                                long jZzf14 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd117);
                                                ContentValues contentValues15 = new ContentValues();
                                                String str211111110 = str14;
                                                contentValues15.put(str211111110, zzhxVar.zzF());
                                                contentValues15.put("metadata_fingerprint", Long.valueOf(jZzf14));
                                                contentValues15.put("metadata", bArrZzcd117);
                                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues15, 4);
                                                zzawVarZzj4 = zzj();
                                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                                while (true) {
                                                    if (zzbeVar2.hasNext()) {
                                                        zzif zzifVarZzr15 = zzr();
                                                        String str211111111 = zzbcVar.zza;
                                                        zZzw = zzifVarZzr15.zzw(str211111111, zzbcVar.zzb);
                                                        zzas zzasVarZzo14 = zzj().zzo(zza(), str211111111, false, false, false, false, false, false, false);
                                                        if (zZzw) {
                                                        }
                                                        i3 = 0;
                                                        break;
                                                    }
                                                    next = zzbeVar2.next();
                                                    String str211111112 = next;
                                                    if (str11.equals(next)) {
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzawVarZzj4.zzg();
                                                zzawVarZzj4.zzav();
                                                Preconditions.checkNotNull(zzbcVar);
                                                str12 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str12);
                                                byte[] bArrZzcd118 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                                contentValues = new ContentValues();
                                                contentValues.put(str211111110, str12);
                                                contentValues.put("name", zzbcVar.zzb);
                                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf14));
                                                contentValues.put("data", bArrZzcd118);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                    zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzS();
                                                zzj().zzL();
                                                zzaL();
                                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                            if (jMax == 1) {
                                                zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                                            }
                                            zzj().zzS();
                                        }
                                    } else {
                                        if (zEquals) {
                                            bundleZzc = zzbfVar2.zzc();
                                            zzqf zzqfVarZzB15 = zzB();
                                            String str211111113 = zzbhVar3.zzc;
                                            zzqfVarZzB15.zzS(bundleZzc, "_o", str211111113);
                                            if (zzB().zzak(str17, zzrVar.zzD)) {
                                                zzB().zzS(bundleZzc, "_dbg", 1L);
                                                zzB().zzS(bundleZzc, "_r", 1L);
                                            }
                                            if ("_s".equals(str)) {
                                                obj2 = zzqdVarZzy2.zze;
                                                if (obj2 instanceof Long) {
                                                    zzB().zzS(bundleZzc, "_sno", obj2);
                                                }
                                            }
                                            if (zzi().zzx(null, zzgi.zzbg)) {
                                                double d15 = Double.parseDouble((String) obj);
                                                bundleZzc.remove("value");
                                                bundleZzc.putDouble("value", d15);
                                            }
                                            zzawVarZzj2 = zzj();
                                            Preconditions.checkNotEmpty(str17);
                                            zzawVarZzj2.zzg();
                                            zzawVarZzj2.zzav();
                                            str2 = str16;
                                            jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                            if (jDelete > 0) {
                                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                            }
                                            zzioVar = this.zzn;
                                            str3 = str2;
                                            zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                            zzaw zzawVarZzj19 = zzj();
                                            str4 = zzbcVar.zzb;
                                            zzbdVarZzs = zzawVarZzj19.zzs(str17, str4);
                                            if (zzbdVarZzs != null) {
                                                if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                                }
                                                zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                            } else {
                                                zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                                zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                            }
                                            zzj().zzV(zzbdVarZzc);
                                            zzaX().zzg();
                                            zzM();
                                            Preconditions.checkNotNull(zzbcVar);
                                            Preconditions.checkNotNull(zzrVar);
                                            String str211111114 = zzbcVar.zza;
                                            Preconditions.checkNotEmpty(str211111114);
                                            str5 = zzrVar.zza;
                                            Preconditions.checkArgument(str211111114.equals(str5));
                                            zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                            boolean z16 = true;
                                            zzhwVarZzz.zzar(1);
                                            zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                            if (!TextUtils.isEmpty(str5)) {
                                                zzhwVarZzz.zzI(str5);
                                            }
                                            str6 = zzrVar.zzd;
                                            if (!TextUtils.isEmpty(str6)) {
                                                zzhwVarZzz.zzK(str6);
                                            }
                                            str7 = zzrVar.zzc;
                                            if (!TextUtils.isEmpty(str7)) {
                                                zzhwVarZzz.zzL(str7);
                                            }
                                            str8 = zzrVar.zzw;
                                            if (!TextUtils.isEmpty(str8)) {
                                                zzhwVarZzz.zzav(str8);
                                            }
                                            j = zzrVar.zzj;
                                            if (j != -2147483648L) {
                                                zzhwVarZzz.zzM((int) j);
                                            }
                                            zzhwVarZzz.zzai(zzrVar.zze);
                                            str9 = zzrVar.zzb;
                                            if (!TextUtils.isEmpty(str9)) {
                                                zzhwVarZzz.zzah(str9);
                                            }
                                            zzjx zzjxVarZzl16 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzhwVarZzz.zzT(zzjxVarZzl16.zzp());
                                            if (zzhwVarZzz.zzaJ().isEmpty()) {
                                                str13 = zzrVar.zzp;
                                                if (!TextUtils.isEmpty(str13)) {
                                                    zzhwVarZzz.zzH(str13);
                                                }
                                            }
                                            zzqr.zzb();
                                            if (!zzi().zzx(str5, zzgi.zzaV)) {
                                            }
                                            j2 = zzrVar.zzf;
                                            if (j2 != 0) {
                                                zzhwVarZzz.zzW(j2);
                                            }
                                            zzhwVarZzz.zzZ(zzrVar.zzr);
                                            zzqa zzqaVarZzA15 = zzA();
                                            zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA15.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                                }
                                            });
                                            if (zzjmVarZza == null) {
                                                mapZzd = Collections.emptyMap();
                                            } else {
                                                mapZzd = zzjmVarZza.zzd();
                                            }
                                            if (mapZzd != null) {
                                                arrayList = null;
                                            } else {
                                                arrayList = null;
                                            }
                                            if (arrayList != null) {
                                                zzhwVarZzz.zzk(arrayList);
                                            }
                                            if (zzi().zzx(null, zzgi.zzbk)) {
                                                zzhwVarZzz.zzaf("");
                                            }
                                            str10 = zzrVar.zza;
                                            zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzjwVar = zzjw.AD_STORAGE;
                                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            } else {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            }
                                            zzioVar2 = this.zzn;
                                            zzioVar2.zzg().zzv();
                                            zzhwVarZzz.zzX(Build.MODEL);
                                            zzioVar2.zzg().zzv();
                                            zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                            zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                            zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                            zzhwVarZzz.zzay(zzrVar.zzy);
                                            if (zzioVar2.zzJ()) {
                                                zzhwVarZzz.zzaF();
                                                if (!TextUtils.isEmpty(null)) {
                                                    zzhwVarZzz.zzY(null);
                                                }
                                            }
                                            zzhVarZzl = zzj().zzl(str10);
                                            if (zzhVarZzl == null) {
                                                zzhVarZzl = new zzh(zzioVar2, str10);
                                                zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                                zzhVarZzl.zzan(zzrVar.zzk);
                                                zzhVarZzl.zzao(zzrVar.zzb);
                                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                                    zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                                }
                                                zzhVarZzl.zzat(0L);
                                                zzhVarZzl.zzau(0L);
                                                zzhVarZzl.zzas(0L);
                                                zzhVarZzl.zzX(zzrVar.zzc);
                                                zzhVarZzl.zzY(zzrVar.zzj);
                                                zzhVarZzl.zzW(zzrVar.zzd);
                                                zzhVarZzl.zzap(zzrVar.zze);
                                                zzhVarZzl.zzaj(zzrVar.zzf);
                                                zzhVarZzl.zzav(zzrVar.zzh);
                                                zzhVarZzl.zzal(zzrVar.zzr);
                                                i = 0;
                                                zzj().zzT(zzhVarZzl, false, false);
                                            } else {
                                                i = 0;
                                            }
                                            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                            }
                                            if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                                zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                            }
                                            listZzE = zzj().zzE(str10);
                                            while (i2 < listZzE.size()) {
                                                com.google.android.gms.internal.measurement.zzin zzinVarZze15 = com.google.android.gms.internal.measurement.zzio.zze();
                                                zzinVarZze15.zzf(((zzqd) listZzE.get(i2)).zzc);
                                                zzinVarZze15.zzg(((zzqd) listZzE.get(i2)).zzd);
                                                zzA().zzx(zzinVarZze15, ((zzqd) listZzE.get(i2)).zze);
                                                zzhwVarZzz.zzo(zzinVarZze15);
                                                if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                                }
                                            }
                                            zzawVarZzj3 = zzj();
                                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                            zzawVarZzj3.zzg();
                                            zzawVarZzj3.zzav();
                                            Preconditions.checkNotNull(zzhxVar);
                                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                                            byte[] bArrZzcd119 = zzhxVar.zzcd();
                                            long jZzf15 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd119);
                                            ContentValues contentValues16 = new ContentValues();
                                            String str211111115 = str14;
                                            contentValues16.put(str211111115, zzhxVar.zzF());
                                            contentValues16.put("metadata_fingerprint", Long.valueOf(jZzf15));
                                            contentValues16.put("metadata", bArrZzcd119);
                                            zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues16, 4);
                                            zzawVarZzj4 = zzj();
                                            zzbeVar2 = new zzbe(zzbcVar.zzf);
                                            while (true) {
                                                if (zzbeVar2.hasNext()) {
                                                    zzif zzifVarZzr16 = zzr();
                                                    String str211111116 = zzbcVar.zza;
                                                    zZzw = zzifVarZzr16.zzw(str211111116, zzbcVar.zzb);
                                                    zzas zzasVarZzo15 = zzj().zzo(zza(), str211111116, false, false, false, false, false, false, false);
                                                    if (zZzw) {
                                                    }
                                                    i3 = 0;
                                                    break;
                                                }
                                                next = zzbeVar2.next();
                                                String str211111117 = next;
                                                if (str11.equals(next)) {
                                                }
                                                i3 = 1;
                                                break;
                                            }
                                            zzawVarZzj4.zzg();
                                            zzawVarZzj4.zzav();
                                            Preconditions.checkNotNull(zzbcVar);
                                            str12 = zzbcVar.zza;
                                            Preconditions.checkNotEmpty(str12);
                                            byte[] bArrZzcd1110 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                            contentValues = new ContentValues();
                                            contentValues.put(str211111115, str12);
                                            contentValues.put("name", zzbcVar.zzb);
                                            contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzf15));
                                            contentValues.put("data", bArrZzcd1110);
                                            contentValues.put("realtime", Integer.valueOf(i3));
                                            if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                            } else {
                                                this.zza = 0L;
                                            }
                                            zzj().zzS();
                                            zzj().zzL();
                                            zzaL();
                                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                                        if (jMax <= 0) {
                                            bundleZzc = zzbfVar2.zzc();
                                            zzqf zzqfVarZzB16 = zzB();
                                            String str211111118 = zzbhVar3.zzc;
                                            zzqfVarZzB16.zzS(bundleZzc, "_o", str211111118);
                                            if (zzB().zzak(str17, zzrVar.zzD)) {
                                                zzB().zzS(bundleZzc, "_dbg", 1L);
                                                zzB().zzS(bundleZzc, "_r", 1L);
                                            }
                                            if ("_s".equals(str)) {
                                                obj2 = zzqdVarZzy2.zze;
                                                if (obj2 instanceof Long) {
                                                    zzB().zzS(bundleZzc, "_sno", obj2);
                                                }
                                            }
                                            if (zzi().zzx(null, zzgi.zzbg)) {
                                                double d16 = Double.parseDouble((String) obj);
                                                bundleZzc.remove("value");
                                                bundleZzc.putDouble("value", d16);
                                            }
                                            zzawVarZzj2 = zzj();
                                            Preconditions.checkNotEmpty(str17);
                                            zzawVarZzj2.zzg();
                                            zzawVarZzj2.zzav();
                                            str2 = str16;
                                            jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                            if (jDelete > 0) {
                                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                            }
                                            zzioVar = this.zzn;
                                            str3 = str2;
                                            zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                            zzaw zzawVarZzj110 = zzj();
                                            str4 = zzbcVar.zzb;
                                            zzbdVarZzs = zzawVarZzj110.zzs(str17, str4);
                                            if (zzbdVarZzs != null) {
                                                if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                                }
                                                zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                            } else {
                                                zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                                zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                            }
                                            zzj().zzV(zzbdVarZzc);
                                            zzaX().zzg();
                                            zzM();
                                            Preconditions.checkNotNull(zzbcVar);
                                            Preconditions.checkNotNull(zzrVar);
                                            String str211111119 = zzbcVar.zza;
                                            Preconditions.checkNotEmpty(str211111119);
                                            str5 = zzrVar.zza;
                                            Preconditions.checkArgument(str211111119.equals(str5));
                                            zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                            boolean z17 = true;
                                            zzhwVarZzz.zzar(1);
                                            zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                            if (!TextUtils.isEmpty(str5)) {
                                                zzhwVarZzz.zzI(str5);
                                            }
                                            str6 = zzrVar.zzd;
                                            if (!TextUtils.isEmpty(str6)) {
                                                zzhwVarZzz.zzK(str6);
                                            }
                                            str7 = zzrVar.zzc;
                                            if (!TextUtils.isEmpty(str7)) {
                                                zzhwVarZzz.zzL(str7);
                                            }
                                            str8 = zzrVar.zzw;
                                            if (!TextUtils.isEmpty(str8)) {
                                                zzhwVarZzz.zzav(str8);
                                            }
                                            j = zzrVar.zzj;
                                            if (j != -2147483648L) {
                                                zzhwVarZzz.zzM((int) j);
                                            }
                                            zzhwVarZzz.zzai(zzrVar.zze);
                                            str9 = zzrVar.zzb;
                                            if (!TextUtils.isEmpty(str9)) {
                                                zzhwVarZzz.zzah(str9);
                                            }
                                            zzjx zzjxVarZzl17 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzhwVarZzz.zzT(zzjxVarZzl17.zzp());
                                            if (zzhwVarZzz.zzaJ().isEmpty()) {
                                                str13 = zzrVar.zzp;
                                                if (!TextUtils.isEmpty(str13)) {
                                                    zzhwVarZzz.zzH(str13);
                                                }
                                            }
                                            zzqr.zzb();
                                            if (!zzi().zzx(str5, zzgi.zzaV)) {
                                            }
                                            j2 = zzrVar.zzf;
                                            if (j2 != 0) {
                                                zzhwVarZzz.zzW(j2);
                                            }
                                            zzhwVarZzz.zzZ(zzrVar.zzr);
                                            zzqa zzqaVarZzA16 = zzA();
                                            zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA16.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                                }
                                            });
                                            if (zzjmVarZza == null) {
                                                mapZzd = Collections.emptyMap();
                                            } else {
                                                mapZzd = zzjmVarZza.zzd();
                                            }
                                            if (mapZzd != null) {
                                                arrayList = null;
                                            } else {
                                                arrayList = null;
                                            }
                                            if (arrayList != null) {
                                                zzhwVarZzz.zzk(arrayList);
                                            }
                                            if (zzi().zzx(null, zzgi.zzbk)) {
                                                zzhwVarZzz.zzaf("");
                                            }
                                            str10 = zzrVar.zza;
                                            zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                            zzjwVar = zzjw.AD_STORAGE;
                                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            } else {
                                                zzjxVarZzl = zzjxVarZzl;
                                                zzjwVar = zzjwVar;
                                                str11 = "_r";
                                            }
                                            zzioVar2 = this.zzn;
                                            zzioVar2.zzg().zzv();
                                            zzhwVarZzz.zzX(Build.MODEL);
                                            zzioVar2.zzg().zzv();
                                            zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                            zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                            zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                            zzhwVarZzz.zzay(zzrVar.zzy);
                                            if (zzioVar2.zzJ()) {
                                                zzhwVarZzz.zzaF();
                                                if (!TextUtils.isEmpty(null)) {
                                                    zzhwVarZzz.zzY(null);
                                                }
                                            }
                                            zzhVarZzl = zzj().zzl(str10);
                                            if (zzhVarZzl == null) {
                                                zzhVarZzl = new zzh(zzioVar2, str10);
                                                zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                                zzhVarZzl.zzan(zzrVar.zzk);
                                                zzhVarZzl.zzao(zzrVar.zzb);
                                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                                    zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                                }
                                                zzhVarZzl.zzat(0L);
                                                zzhVarZzl.zzau(0L);
                                                zzhVarZzl.zzas(0L);
                                                zzhVarZzl.zzX(zzrVar.zzc);
                                                zzhVarZzl.zzY(zzrVar.zzj);
                                                zzhVarZzl.zzW(zzrVar.zzd);
                                                zzhVarZzl.zzap(zzrVar.zze);
                                                zzhVarZzl.zzaj(zzrVar.zzf);
                                                zzhVarZzl.zzav(zzrVar.zzh);
                                                zzhVarZzl.zzal(zzrVar.zzr);
                                                i = 0;
                                                zzj().zzT(zzhVarZzl, false, false);
                                            } else {
                                                i = 0;
                                            }
                                            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                                zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                            }
                                            if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                                zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                            }
                                            listZzE = zzj().zzE(str10);
                                            while (i2 < listZzE.size()) {
                                                com.google.android.gms.internal.measurement.zzin zzinVarZze16 = com.google.android.gms.internal.measurement.zzio.zze();
                                                zzinVarZze16.zzf(((zzqd) listZzE.get(i2)).zzc);
                                                zzinVarZze16.zzg(((zzqd) listZzE.get(i2)).zzd);
                                                zzA().zzx(zzinVarZze16, ((zzqd) listZzE.get(i2)).zze);
                                                zzhwVarZzz.zzo(zzinVarZze16);
                                                if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                                }
                                            }
                                            zzawVarZzj3 = zzj();
                                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                            zzawVarZzj3.zzg();
                                            zzawVarZzj3.zzav();
                                            Preconditions.checkNotNull(zzhxVar);
                                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                                            byte[] bArrZzcd1111 = zzhxVar.zzcd();
                                            long jZzf16 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd1111);
                                            ContentValues contentValues17 = new ContentValues();
                                            String str2111111110 = str14;
                                            contentValues17.put(str2111111110, zzhxVar.zzF());
                                            contentValues17.put("metadata_fingerprint", Long.valueOf(jZzf16));
                                            contentValues17.put("metadata", bArrZzcd1111);
                                            zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues17, 4);
                                            zzawVarZzj4 = zzj();
                                            zzbeVar2 = new zzbe(zzbcVar.zzf);
                                            while (true) {
                                                if (zzbeVar2.hasNext()) {
                                                    zzif zzifVarZzr17 = zzr();
                                                    String str2111111111 = zzbcVar.zza;
                                                    zZzw = zzifVarZzr17.zzw(str2111111111, zzbcVar.zzb);
                                                    zzas zzasVarZzo16 = zzj().zzo(zza(), str2111111111, false, false, false, false, false, false, false);
                                                    if (zZzw) {
                                                    }
                                                    i3 = 0;
                                                    break;
                                                }
                                                next = zzbeVar2.next();
                                                String str2111111112 = next;
                                                if (str11.equals(next)) {
                                                }
                                                i3 = 1;
                                                break;
                                            }
                                            zzawVarZzj4.zzg();
                                            zzawVarZzj4.zzav();
                                            Preconditions.checkNotNull(zzbcVar);
                                            str12 = zzbcVar.zza;
                                            Preconditions.checkNotEmpty(str12);
                                            byte[] bArrZzcd1112 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                            contentValues = new ContentValues();
                                            contentValues.put(str2111111110, str12);
                                            contentValues.put("name", zzbcVar.zzb);
                                            contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzf16));
                                            contentValues.put("data", bArrZzcd1112);
                                            contentValues.put("realtime", Integer.valueOf(i3));
                                            if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                                zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                            } else {
                                                this.zza = 0L;
                                            }
                                            zzj().zzS();
                                            zzj().zzL();
                                            zzaL();
                                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        if (jMax == 1) {
                                            zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                                        }
                                        zzj().zzS();
                                    }
                                }
                            }
                        }
                    } else {
                        str14 = "app_id";
                        str15 = "_fx";
                    }
                    str16 = "raw_events";
                    zzbhVar2 = zzbhVarZza;
                    str19 = "_err";
                    str = zzbhVar2.zza;
                    zZzaq = zzqf.zzaq(str);
                    zEquals = str19.equals(str);
                    zzB();
                    zzbfVar2 = zzbhVar2.zzb;
                    if (zzbfVar2 == null) {
                        length = 0;
                    } else {
                        zzbeVar = new zzbe(zzbfVar2);
                        length = 0;
                        while (zzbeVar.hasNext()) {
                            String next6 = zzbeVar.next();
                            String str223 = next6;
                            objZzf = zzbfVar2.zzf(next6);
                            if (objZzf instanceof Parcelable[]) {
                                length += (long) ((Parcelable[]) objZzf).length;
                            }
                        }
                    }
                    zzbhVar3 = zzbhVar2;
                    zzasVarZzp = zzj().zzp(zza(), str17, length + 1, true, zZzaq, false, zEquals, false, false, false);
                    long j12 = zzasVarZzp.zzb;
                    zzi();
                    jZzH = j12 - zzam.zzH();
                    if (jZzH > 0) {
                        if (jZzH % 1000 == 1) {
                            zzaW().zze().zzc("Data loss. Too many events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzb));
                        }
                        zzj().zzS();
                    } else if (zZzaq) {
                        long j13 = zzasVarZzp.zza;
                        zzi();
                        jIntValue = j13 - ((long) ((Integer) zzgi.zzm.zza(null)).intValue());
                        if (jIntValue > 0) {
                            if (jIntValue % 1000 == 1) {
                                zzaW().zze().zzc("Data loss. Too many public events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zza));
                            }
                            zzB().zzR(this.zzK, str17, 16, "_ev", zzbhVar3.zza, 0);
                            zzj().zzS();
                        } else {
                            if (zEquals) {
                                bundleZzc = zzbfVar2.zzc();
                                zzqf zzqfVarZzB17 = zzB();
                                String str2111111113 = zzbhVar3.zzc;
                                zzqfVarZzB17.zzS(bundleZzc, "_o", str2111111113);
                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                    zzB().zzS(bundleZzc, "_dbg", 1L);
                                    zzB().zzS(bundleZzc, "_r", 1L);
                                }
                                if ("_s".equals(str)) {
                                    obj2 = zzqdVarZzy2.zze;
                                    if (obj2 instanceof Long) {
                                        zzB().zzS(bundleZzc, "_sno", obj2);
                                    }
                                }
                                if (zzi().zzx(null, zzgi.zzbg)) {
                                    double d17 = Double.parseDouble((String) obj);
                                    bundleZzc.remove("value");
                                    bundleZzc.putDouble("value", d17);
                                }
                                zzawVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str17);
                                zzawVarZzj2.zzg();
                                zzawVarZzj2.zzav();
                                str2 = str16;
                                jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                if (jDelete > 0) {
                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                }
                                zzioVar = this.zzn;
                                str3 = str2;
                                zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                zzaw zzawVarZzj111 = zzj();
                                str4 = zzbcVar.zzb;
                                zzbdVarZzs = zzawVarZzj111.zzs(str17, str4);
                                if (zzbdVarZzs != null) {
                                    if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                    }
                                    zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                    zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                }
                                zzj().zzV(zzbdVarZzc);
                                zzaX().zzg();
                                zzM();
                                Preconditions.checkNotNull(zzbcVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str2111111114 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str2111111114);
                                str5 = zzrVar.zza;
                                Preconditions.checkArgument(str2111111114.equals(str5));
                                zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                boolean z18 = true;
                                zzhwVarZzz.zzar(1);
                                zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                if (!TextUtils.isEmpty(str5)) {
                                    zzhwVarZzz.zzI(str5);
                                }
                                str6 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str6)) {
                                    zzhwVarZzz.zzK(str6);
                                }
                                str7 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzhwVarZzz.zzL(str7);
                                }
                                str8 = zzrVar.zzw;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzhwVarZzz.zzav(str8);
                                }
                                j = zzrVar.zzj;
                                if (j != -2147483648L) {
                                    zzhwVarZzz.zzM((int) j);
                                }
                                zzhwVarZzz.zzai(zzrVar.zze);
                                str9 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzhwVarZzz.zzah(str9);
                                }
                                zzjx zzjxVarZzl18 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzhwVarZzz.zzT(zzjxVarZzl18.zzp());
                                if (zzhwVarZzz.zzaJ().isEmpty()) {
                                    str13 = zzrVar.zzp;
                                    if (!TextUtils.isEmpty(str13)) {
                                        zzhwVarZzz.zzH(str13);
                                    }
                                }
                                zzqr.zzb();
                                if (!zzi().zzx(str5, zzgi.zzaV)) {
                                }
                                j2 = zzrVar.zzf;
                                if (j2 != 0) {
                                    zzhwVarZzz.zzW(j2);
                                }
                                zzhwVarZzz.zzZ(zzrVar.zzr);
                                zzqa zzqaVarZzA17 = zzA();
                                zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA17.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                    }
                                });
                                if (zzjmVarZza == null) {
                                    mapZzd = Collections.emptyMap();
                                } else {
                                    mapZzd = zzjmVarZza.zzd();
                                }
                                if (mapZzd != null) {
                                    arrayList = null;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    zzhwVarZzz.zzk(arrayList);
                                }
                                if (zzi().zzx(null, zzgi.zzbk)) {
                                    zzhwVarZzz.zzaf("");
                                }
                                str10 = zzrVar.zza;
                                zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzjwVar = zzjw.AD_STORAGE;
                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                    zzjxVarZzl = zzjxVarZzl;
                                    zzjwVar = zzjwVar;
                                    str11 = "_r";
                                } else {
                                    zzjxVarZzl = zzjxVarZzl;
                                    zzjwVar = zzjwVar;
                                    str11 = "_r";
                                }
                                zzioVar2 = this.zzn;
                                zzioVar2.zzg().zzv();
                                zzhwVarZzz.zzX(Build.MODEL);
                                zzioVar2.zzg().zzv();
                                zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                zzhwVarZzz.zzay(zzrVar.zzy);
                                if (zzioVar2.zzJ()) {
                                    zzhwVarZzz.zzaF();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzhwVarZzz.zzY(null);
                                    }
                                }
                                zzhVarZzl = zzj().zzl(str10);
                                if (zzhVarZzl == null) {
                                    zzhVarZzl = new zzh(zzioVar2, str10);
                                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                    zzhVarZzl.zzan(zzrVar.zzk);
                                    zzhVarZzl.zzao(zzrVar.zzb);
                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                        zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                    }
                                    zzhVarZzl.zzat(0L);
                                    zzhVarZzl.zzau(0L);
                                    zzhVarZzl.zzas(0L);
                                    zzhVarZzl.zzX(zzrVar.zzc);
                                    zzhVarZzl.zzY(zzrVar.zzj);
                                    zzhVarZzl.zzW(zzrVar.zzd);
                                    zzhVarZzl.zzap(zzrVar.zze);
                                    zzhVarZzl.zzaj(zzrVar.zzf);
                                    zzhVarZzl.zzav(zzrVar.zzh);
                                    zzhVarZzl.zzal(zzrVar.zzr);
                                    i = 0;
                                    zzj().zzT(zzhVarZzl, false, false);
                                } else {
                                    i = 0;
                                }
                                if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                    zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                    zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                }
                                listZzE = zzj().zzE(str10);
                                while (i2 < listZzE.size()) {
                                    com.google.android.gms.internal.measurement.zzin zzinVarZze17 = com.google.android.gms.internal.measurement.zzio.zze();
                                    zzinVarZze17.zzf(((zzqd) listZzE.get(i2)).zzc);
                                    zzinVarZze17.zzg(((zzqd) listZzE.get(i2)).zzd);
                                    zzA().zzx(zzinVarZze17, ((zzqd) listZzE.get(i2)).zze);
                                    zzhwVarZzz.zzo(zzinVarZze17);
                                    if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                    }
                                }
                                zzawVarZzj3 = zzj();
                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                zzawVarZzj3.zzg();
                                zzawVarZzj3.zzav();
                                Preconditions.checkNotNull(zzhxVar);
                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                byte[] bArrZzcd1113 = zzhxVar.zzcd();
                                long jZzf17 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd1113);
                                ContentValues contentValues18 = new ContentValues();
                                String str2111111115 = str14;
                                contentValues18.put(str2111111115, zzhxVar.zzF());
                                contentValues18.put("metadata_fingerprint", Long.valueOf(jZzf17));
                                contentValues18.put("metadata", bArrZzcd1113);
                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues18, 4);
                                zzawVarZzj4 = zzj();
                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                while (true) {
                                    if (zzbeVar2.hasNext()) {
                                        zzif zzifVarZzr18 = zzr();
                                        String str2111111116 = zzbcVar.zza;
                                        zZzw = zzifVarZzr18.zzw(str2111111116, zzbcVar.zzb);
                                        zzas zzasVarZzo17 = zzj().zzo(zza(), str2111111116, false, false, false, false, false, false, false);
                                        if (zZzw) {
                                        }
                                        i3 = 0;
                                        break;
                                    }
                                    next = zzbeVar2.next();
                                    String str2111111117 = next;
                                    if (str11.equals(next)) {
                                    }
                                    i3 = 1;
                                    break;
                                }
                                zzawVarZzj4.zzg();
                                zzawVarZzj4.zzav();
                                Preconditions.checkNotNull(zzbcVar);
                                str12 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str12);
                                byte[] bArrZzcd1114 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                contentValues = new ContentValues();
                                contentValues.put(str2111111115, str12);
                                contentValues.put("name", zzbcVar.zzb);
                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf17));
                                contentValues.put("data", bArrZzcd1114);
                                contentValues.put("realtime", Integer.valueOf(i3));
                                if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                    zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                } else {
                                    this.zza = 0L;
                                }
                                zzj().zzS();
                                zzj().zzL();
                                zzaL();
                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                            if (jMax <= 0) {
                                bundleZzc = zzbfVar2.zzc();
                                zzqf zzqfVarZzB18 = zzB();
                                String str2111111118 = zzbhVar3.zzc;
                                zzqfVarZzB18.zzS(bundleZzc, "_o", str2111111118);
                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                    zzB().zzS(bundleZzc, "_dbg", 1L);
                                    zzB().zzS(bundleZzc, "_r", 1L);
                                }
                                if ("_s".equals(str)) {
                                    obj2 = zzqdVarZzy2.zze;
                                    if (obj2 instanceof Long) {
                                        zzB().zzS(bundleZzc, "_sno", obj2);
                                    }
                                }
                                if (zzi().zzx(null, zzgi.zzbg)) {
                                    double d18 = Double.parseDouble((String) obj);
                                    bundleZzc.remove("value");
                                    bundleZzc.putDouble("value", d18);
                                }
                                zzawVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str17);
                                zzawVarZzj2.zzg();
                                zzawVarZzj2.zzav();
                                str2 = str16;
                                jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                                if (jDelete > 0) {
                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                                }
                                zzioVar = this.zzn;
                                str3 = str2;
                                zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                                zzaw zzawVarZzj112 = zzj();
                                str4 = zzbcVar.zzb;
                                zzbdVarZzs = zzawVarZzj112.zzs(str17, str4);
                                if (zzbdVarZzs != null) {
                                    if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                    }
                                    zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                    zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                                }
                                zzj().zzV(zzbdVarZzc);
                                zzaX().zzg();
                                zzM();
                                Preconditions.checkNotNull(zzbcVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str2111111119 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str2111111119);
                                str5 = zzrVar.zza;
                                Preconditions.checkArgument(str2111111119.equals(str5));
                                zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                boolean z19 = true;
                                zzhwVarZzz.zzar(1);
                                zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                                if (!TextUtils.isEmpty(str5)) {
                                    zzhwVarZzz.zzI(str5);
                                }
                                str6 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str6)) {
                                    zzhwVarZzz.zzK(str6);
                                }
                                str7 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzhwVarZzz.zzL(str7);
                                }
                                str8 = zzrVar.zzw;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzhwVarZzz.zzav(str8);
                                }
                                j = zzrVar.zzj;
                                if (j != -2147483648L) {
                                    zzhwVarZzz.zzM((int) j);
                                }
                                zzhwVarZzz.zzai(zzrVar.zze);
                                str9 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzhwVarZzz.zzah(str9);
                                }
                                zzjx zzjxVarZzl19 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzhwVarZzz.zzT(zzjxVarZzl19.zzp());
                                if (zzhwVarZzz.zzaJ().isEmpty()) {
                                    str13 = zzrVar.zzp;
                                    if (!TextUtils.isEmpty(str13)) {
                                        zzhwVarZzz.zzH(str13);
                                    }
                                }
                                zzqr.zzb();
                                if (!zzi().zzx(str5, zzgi.zzaV)) {
                                }
                                j2 = zzrVar.zzf;
                                if (j2 != 0) {
                                    zzhwVarZzz.zzW(j2);
                                }
                                zzhwVarZzz.zzZ(zzrVar.zzr);
                                zzqa zzqaVarZzA18 = zzA();
                                zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA18.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                    }
                                });
                                if (zzjmVarZza == null) {
                                    mapZzd = Collections.emptyMap();
                                } else {
                                    mapZzd = zzjmVarZza.zzd();
                                }
                                if (mapZzd != null) {
                                    arrayList = null;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    zzhwVarZzz.zzk(arrayList);
                                }
                                if (zzi().zzx(null, zzgi.zzbk)) {
                                    zzhwVarZzz.zzaf("");
                                }
                                str10 = zzrVar.zza;
                                zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzjwVar = zzjw.AD_STORAGE;
                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                    zzjxVarZzl = zzjxVarZzl;
                                    zzjwVar = zzjwVar;
                                    str11 = "_r";
                                } else {
                                    zzjxVarZzl = zzjxVarZzl;
                                    zzjwVar = zzjwVar;
                                    str11 = "_r";
                                }
                                zzioVar2 = this.zzn;
                                zzioVar2.zzg().zzv();
                                zzhwVarZzz.zzX(Build.MODEL);
                                zzioVar2.zzg().zzv();
                                zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                                zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                                zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                                zzhwVarZzz.zzay(zzrVar.zzy);
                                if (zzioVar2.zzJ()) {
                                    zzhwVarZzz.zzaF();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzhwVarZzz.zzY(null);
                                    }
                                }
                                zzhVarZzl = zzj().zzl(str10);
                                if (zzhVarZzl == null) {
                                    zzhVarZzl = new zzh(zzioVar2, str10);
                                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                    zzhVarZzl.zzan(zzrVar.zzk);
                                    zzhVarZzl.zzao(zzrVar.zzb);
                                    if (zzjxVarZzl.zzr(zzjwVar)) {
                                        zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                    }
                                    zzhVarZzl.zzat(0L);
                                    zzhVarZzl.zzau(0L);
                                    zzhVarZzl.zzas(0L);
                                    zzhVarZzl.zzX(zzrVar.zzc);
                                    zzhVarZzl.zzY(zzrVar.zzj);
                                    zzhVarZzl.zzW(zzrVar.zzd);
                                    zzhVarZzl.zzap(zzrVar.zze);
                                    zzhVarZzl.zzaj(zzrVar.zzf);
                                    zzhVarZzl.zzav(zzrVar.zzh);
                                    zzhVarZzl.zzal(zzrVar.zzr);
                                    i = 0;
                                    zzj().zzT(zzhVarZzl, false, false);
                                } else {
                                    i = 0;
                                }
                                if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                    zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                    zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                                }
                                listZzE = zzj().zzE(str10);
                                while (i2 < listZzE.size()) {
                                    com.google.android.gms.internal.measurement.zzin zzinVarZze18 = com.google.android.gms.internal.measurement.zzio.zze();
                                    zzinVarZze18.zzf(((zzqd) listZzE.get(i2)).zzc);
                                    zzinVarZze18.zzg(((zzqd) listZzE.get(i2)).zzd);
                                    zzA().zzx(zzinVarZze18, ((zzqd) listZzE.get(i2)).zze);
                                    zzhwVarZzz.zzo(zzinVarZze18);
                                    if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                    }
                                }
                                zzawVarZzj3 = zzj();
                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                                zzawVarZzj3.zzg();
                                zzawVarZzj3.zzav();
                                Preconditions.checkNotNull(zzhxVar);
                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                byte[] bArrZzcd1115 = zzhxVar.zzcd();
                                long jZzf18 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd1115);
                                ContentValues contentValues19 = new ContentValues();
                                String str21111111110 = str14;
                                contentValues19.put(str21111111110, zzhxVar.zzF());
                                contentValues19.put("metadata_fingerprint", Long.valueOf(jZzf18));
                                contentValues19.put("metadata", bArrZzcd1115);
                                zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues19, 4);
                                zzawVarZzj4 = zzj();
                                zzbeVar2 = new zzbe(zzbcVar.zzf);
                                while (true) {
                                    if (zzbeVar2.hasNext()) {
                                        zzif zzifVarZzr19 = zzr();
                                        String str21111111111 = zzbcVar.zza;
                                        zZzw = zzifVarZzr19.zzw(str21111111111, zzbcVar.zzb);
                                        zzas zzasVarZzo18 = zzj().zzo(zza(), str21111111111, false, false, false, false, false, false, false);
                                        if (zZzw) {
                                        }
                                        i3 = 0;
                                        break;
                                    }
                                    next = zzbeVar2.next();
                                    String str21111111112 = next;
                                    if (str11.equals(next)) {
                                    }
                                    i3 = 1;
                                    break;
                                }
                                zzawVarZzj4.zzg();
                                zzawVarZzj4.zzav();
                                Preconditions.checkNotNull(zzbcVar);
                                str12 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str12);
                                byte[] bArrZzcd1116 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                                contentValues = new ContentValues();
                                contentValues.put(str21111111110, str12);
                                contentValues.put("name", zzbcVar.zzb);
                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzf18));
                                contentValues.put("data", bArrZzcd1116);
                                contentValues.put("realtime", Integer.valueOf(i3));
                                if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                    zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                                } else {
                                    this.zza = 0L;
                                }
                                zzj().zzS();
                                zzj().zzL();
                                zzaL();
                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            if (jMax == 1) {
                                zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                            }
                            zzj().zzS();
                        }
                    } else {
                        if (zEquals) {
                            bundleZzc = zzbfVar2.zzc();
                            zzqf zzqfVarZzB19 = zzB();
                            String str21111111113 = zzbhVar3.zzc;
                            zzqfVarZzB19.zzS(bundleZzc, "_o", str21111111113);
                            if (zzB().zzak(str17, zzrVar.zzD)) {
                                zzB().zzS(bundleZzc, "_dbg", 1L);
                                zzB().zzS(bundleZzc, "_r", 1L);
                            }
                            if ("_s".equals(str)) {
                                obj2 = zzqdVarZzy2.zze;
                                if (obj2 instanceof Long) {
                                    zzB().zzS(bundleZzc, "_sno", obj2);
                                }
                            }
                            if (zzi().zzx(null, zzgi.zzbg)) {
                                double d19 = Double.parseDouble((String) obj);
                                bundleZzc.remove("value");
                                bundleZzc.putDouble("value", d19);
                            }
                            zzawVarZzj2 = zzj();
                            Preconditions.checkNotEmpty(str17);
                            zzawVarZzj2.zzg();
                            zzawVarZzj2.zzav();
                            str2 = str16;
                            jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                            if (jDelete > 0) {
                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                            }
                            zzioVar = this.zzn;
                            str3 = str2;
                            zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                            zzaw zzawVarZzj113 = zzj();
                            str4 = zzbcVar.zzb;
                            zzbdVarZzs = zzawVarZzj113.zzs(str17, str4);
                            if (zzbdVarZzs != null) {
                                if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                }
                                zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                            } else {
                                zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                            }
                            zzj().zzV(zzbdVarZzc);
                            zzaX().zzg();
                            zzM();
                            Preconditions.checkNotNull(zzbcVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str21111111114 = zzbcVar.zza;
                            Preconditions.checkNotEmpty(str21111111114);
                            str5 = zzrVar.zza;
                            Preconditions.checkArgument(str21111111114.equals(str5));
                            zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                            boolean z110 = true;
                            zzhwVarZzz.zzar(1);
                            zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                            if (!TextUtils.isEmpty(str5)) {
                                zzhwVarZzz.zzI(str5);
                            }
                            str6 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str6)) {
                                zzhwVarZzz.zzK(str6);
                            }
                            str7 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str7)) {
                                zzhwVarZzz.zzL(str7);
                            }
                            str8 = zzrVar.zzw;
                            if (!TextUtils.isEmpty(str8)) {
                                zzhwVarZzz.zzav(str8);
                            }
                            j = zzrVar.zzj;
                            if (j != -2147483648L) {
                                zzhwVarZzz.zzM((int) j);
                            }
                            zzhwVarZzz.zzai(zzrVar.zze);
                            str9 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str9)) {
                                zzhwVarZzz.zzah(str9);
                            }
                            zzjx zzjxVarZzl110 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzhwVarZzz.zzT(zzjxVarZzl110.zzp());
                            if (zzhwVarZzz.zzaJ().isEmpty()) {
                                str13 = zzrVar.zzp;
                                if (!TextUtils.isEmpty(str13)) {
                                    zzhwVarZzz.zzH(str13);
                                }
                            }
                            zzqr.zzb();
                            if (!zzi().zzx(str5, zzgi.zzaV)) {
                            }
                            j2 = zzrVar.zzf;
                            if (j2 != 0) {
                                zzhwVarZzz.zzW(j2);
                            }
                            zzhwVarZzz.zzZ(zzrVar.zzr);
                            zzqa zzqaVarZzA19 = zzA();
                            zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA19.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                }
                            });
                            if (zzjmVarZza == null) {
                                mapZzd = Collections.emptyMap();
                            } else {
                                mapZzd = zzjmVarZza.zzd();
                            }
                            if (mapZzd != null) {
                                arrayList = null;
                            } else {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                                zzhwVarZzz.zzk(arrayList);
                            }
                            if (zzi().zzx(null, zzgi.zzbk)) {
                                zzhwVarZzz.zzaf("");
                            }
                            str10 = zzrVar.zza;
                            zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzjwVar = zzjw.AD_STORAGE;
                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                zzjxVarZzl = zzjxVarZzl;
                                zzjwVar = zzjwVar;
                                str11 = "_r";
                            } else {
                                zzjxVarZzl = zzjxVarZzl;
                                zzjwVar = zzjwVar;
                                str11 = "_r";
                            }
                            zzioVar2 = this.zzn;
                            zzioVar2.zzg().zzv();
                            zzhwVarZzz.zzX(Build.MODEL);
                            zzioVar2.zzg().zzv();
                            zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                            zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                            zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                            zzhwVarZzz.zzay(zzrVar.zzy);
                            if (zzioVar2.zzJ()) {
                                zzhwVarZzz.zzaF();
                                if (!TextUtils.isEmpty(null)) {
                                    zzhwVarZzz.zzY(null);
                                }
                            }
                            zzhVarZzl = zzj().zzl(str10);
                            if (zzhVarZzl == null) {
                                zzhVarZzl = new zzh(zzioVar2, str10);
                                zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                zzhVarZzl.zzan(zzrVar.zzk);
                                zzhVarZzl.zzao(zzrVar.zzb);
                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                    zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                }
                                zzhVarZzl.zzat(0L);
                                zzhVarZzl.zzau(0L);
                                zzhVarZzl.zzas(0L);
                                zzhVarZzl.zzX(zzrVar.zzc);
                                zzhVarZzl.zzY(zzrVar.zzj);
                                zzhVarZzl.zzW(zzrVar.zzd);
                                zzhVarZzl.zzap(zzrVar.zze);
                                zzhVarZzl.zzaj(zzrVar.zzf);
                                zzhVarZzl.zzav(zzrVar.zzh);
                                zzhVarZzl.zzal(zzrVar.zzr);
                                i = 0;
                                zzj().zzT(zzhVarZzl, false, false);
                            } else {
                                i = 0;
                            }
                            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                            }
                            listZzE = zzj().zzE(str10);
                            while (i2 < listZzE.size()) {
                                com.google.android.gms.internal.measurement.zzin zzinVarZze19 = com.google.android.gms.internal.measurement.zzio.zze();
                                zzinVarZze19.zzf(((zzqd) listZzE.get(i2)).zzc);
                                zzinVarZze19.zzg(((zzqd) listZzE.get(i2)).zzd);
                                zzA().zzx(zzinVarZze19, ((zzqd) listZzE.get(i2)).zze);
                                zzhwVarZzz.zzo(zzinVarZze19);
                                if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                }
                            }
                            zzawVarZzj3 = zzj();
                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                            zzawVarZzj3.zzg();
                            zzawVarZzj3.zzav();
                            Preconditions.checkNotNull(zzhxVar);
                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                            byte[] bArrZzcd1117 = zzhxVar.zzcd();
                            long jZzf19 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd1117);
                            ContentValues contentValues110 = new ContentValues();
                            String str21111111115 = str14;
                            contentValues110.put(str21111111115, zzhxVar.zzF());
                            contentValues110.put("metadata_fingerprint", Long.valueOf(jZzf19));
                            contentValues110.put("metadata", bArrZzcd1117);
                            zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues110, 4);
                            zzawVarZzj4 = zzj();
                            zzbeVar2 = new zzbe(zzbcVar.zzf);
                            while (true) {
                                if (zzbeVar2.hasNext()) {
                                    zzif zzifVarZzr110 = zzr();
                                    String str21111111116 = zzbcVar.zza;
                                    zZzw = zzifVarZzr110.zzw(str21111111116, zzbcVar.zzb);
                                    zzas zzasVarZzo19 = zzj().zzo(zza(), str21111111116, false, false, false, false, false, false, false);
                                    if (zZzw) {
                                    }
                                    i3 = 0;
                                    break;
                                }
                                next = zzbeVar2.next();
                                String str21111111117 = next;
                                if (str11.equals(next)) {
                                }
                                i3 = 1;
                                break;
                            }
                            zzawVarZzj4.zzg();
                            zzawVarZzj4.zzav();
                            Preconditions.checkNotNull(zzbcVar);
                            str12 = zzbcVar.zza;
                            Preconditions.checkNotEmpty(str12);
                            byte[] bArrZzcd1118 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                            contentValues = new ContentValues();
                            contentValues.put(str21111111115, str12);
                            contentValues.put("name", zzbcVar.zzb);
                            contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzf19));
                            contentValues.put("data", bArrZzcd1118);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                            } else {
                                this.zza = 0L;
                            }
                            zzj().zzS();
                            zzj().zzL();
                            zzaL();
                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                            return;
                        }
                        jMax = zzasVarZzp.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzi().zzh(zzrVar.zza, zzgi.zzl))));
                        if (jMax <= 0) {
                            bundleZzc = zzbfVar2.zzc();
                            zzqf zzqfVarZzB110 = zzB();
                            String str21111111118 = zzbhVar3.zzc;
                            zzqfVarZzB110.zzS(bundleZzc, "_o", str21111111118);
                            if (zzB().zzak(str17, zzrVar.zzD)) {
                                zzB().zzS(bundleZzc, "_dbg", 1L);
                                zzB().zzS(bundleZzc, "_r", 1L);
                            }
                            if ("_s".equals(str)) {
                                obj2 = zzqdVarZzy2.zze;
                                if (obj2 instanceof Long) {
                                    zzB().zzS(bundleZzc, "_sno", obj2);
                                }
                            }
                            if (zzi().zzx(null, zzgi.zzbg)) {
                                double d110 = Double.parseDouble((String) obj);
                                bundleZzc.remove("value");
                                bundleZzc.putDouble("value", d110);
                            }
                            zzawVarZzj2 = zzj();
                            Preconditions.checkNotEmpty(str17);
                            zzawVarZzj2.zzg();
                            zzawVarZzj2.zzav();
                            str2 = str16;
                            jDelete = zzawVarZzj2.zzj().delete(str2, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str17, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzawVarZzj2.zzu.zzf().zzh(str17, zzgi.zzp))))});
                            if (jDelete > 0) {
                                zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(jDelete));
                            }
                            zzioVar = this.zzn;
                            str3 = str2;
                            zzbcVar = new zzbc(zzioVar, zzbhVar3.zzc, str17, zzbhVar3.zza, zzbhVar3.zzd, 0L, bundleZzc);
                            zzaw zzawVarZzj114 = zzj();
                            str4 = zzbcVar.zzb;
                            zzbdVarZzs = zzawVarZzj114.zzs(str17, str4);
                            if (zzbdVarZzs != null) {
                                if (zzj().zzi(str17) >= zzi().zzb(str17)) {
                                }
                                zzbdVarZzc = new zzbd(str17, str4, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                            } else {
                                zzbcVar = zzbcVar.zza(zzioVar, zzbdVarZzs.zzf);
                                zzbdVarZzc = zzbdVarZzs.zzc(zzbcVar.zzd);
                            }
                            zzj().zzV(zzbdVarZzc);
                            zzaX().zzg();
                            zzM();
                            Preconditions.checkNotNull(zzbcVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str21111111119 = zzbcVar.zza;
                            Preconditions.checkNotEmpty(str21111111119);
                            str5 = zzrVar.zza;
                            Preconditions.checkArgument(str21111111119.equals(str5));
                            zzhwVarZzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                            boolean z111 = true;
                            zzhwVarZzz.zzar(1);
                            zzhwVarZzz.zzan(SystemMediaRouteProvider.PACKAGE_NAME);
                            if (!TextUtils.isEmpty(str5)) {
                                zzhwVarZzz.zzI(str5);
                            }
                            str6 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str6)) {
                                zzhwVarZzz.zzK(str6);
                            }
                            str7 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str7)) {
                                zzhwVarZzz.zzL(str7);
                            }
                            str8 = zzrVar.zzw;
                            if (!TextUtils.isEmpty(str8)) {
                                zzhwVarZzz.zzav(str8);
                            }
                            j = zzrVar.zzj;
                            if (j != -2147483648L) {
                                zzhwVarZzz.zzM((int) j);
                            }
                            zzhwVarZzz.zzai(zzrVar.zze);
                            str9 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str9)) {
                                zzhwVarZzz.zzah(str9);
                            }
                            zzjx zzjxVarZzl111 = zzu((String) Preconditions.checkNotNull(str5)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzhwVarZzz.zzT(zzjxVarZzl111.zzp());
                            if (zzhwVarZzz.zzaJ().isEmpty()) {
                                str13 = zzrVar.zzp;
                                if (!TextUtils.isEmpty(str13)) {
                                    zzhwVarZzz.zzH(str13);
                                }
                            }
                            zzqr.zzb();
                            if (!zzi().zzx(str5, zzgi.zzaV)) {
                            }
                            j2 = zzrVar.zzf;
                            if (j2 != 0) {
                                zzhwVarZzz.zzW(j2);
                            }
                            zzhwVarZzz.zzZ(zzrVar.zzr);
                            zzqa zzqaVarZzA110 = zzA();
                            zzjmVarZza = com.google.android.gms.internal.measurement.zzjm.zza(zzqaVarZzA110.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.google.android.gms.internal.measurement.zzki.zzc();
                                }
                            });
                            if (zzjmVarZza == null) {
                                mapZzd = Collections.emptyMap();
                            } else {
                                mapZzd = zzjmVarZza.zzd();
                            }
                            if (mapZzd != null) {
                                arrayList = null;
                            } else {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                                zzhwVarZzz.zzk(arrayList);
                            }
                            if (zzi().zzx(null, zzgi.zzbk)) {
                                zzhwVarZzz.zzaf("");
                            }
                            str10 = zzrVar.zza;
                            zzjxVarZzl = zzu((String) Preconditions.checkNotNull(str10)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                            zzjwVar = zzjw.AD_STORAGE;
                            if (zzjxVarZzl.zzr(zzjwVar)) {
                                zzjxVarZzl = zzjxVarZzl;
                                zzjwVar = zzjwVar;
                                str11 = "_r";
                            } else {
                                zzjxVarZzl = zzjxVarZzl;
                                zzjwVar = zzjwVar;
                                str11 = "_r";
                            }
                            zzioVar2 = this.zzn;
                            zzioVar2.zzg().zzv();
                            zzhwVarZzz.zzX(Build.MODEL);
                            zzioVar2.zzg().zzv();
                            zzhwVarZzz.zzam(Build.VERSION.RELEASE);
                            zzhwVarZzz.zzaz((int) zzioVar2.zzg().zza());
                            zzhwVarZzz.zzaD(zzioVar2.zzg().zzb());
                            zzhwVarZzz.zzay(zzrVar.zzy);
                            if (zzioVar2.zzJ()) {
                                zzhwVarZzz.zzaF();
                                if (!TextUtils.isEmpty(null)) {
                                    zzhwVarZzz.zzY(null);
                                }
                            }
                            zzhVarZzl = zzj().zzl(str10);
                            if (zzhVarZzl == null) {
                                zzhVarZzl = new zzh(zzioVar2, str10);
                                zzhVarZzl.zzV(zzC(zzjxVarZzl));
                                zzhVarZzl.zzan(zzrVar.zzk);
                                zzhVarZzl.zzao(zzrVar.zzb);
                                if (zzjxVarZzl.zzr(zzjwVar)) {
                                    zzhVarZzl.zzax(this.zzk.zzf(str10, zzrVar.zzn));
                                }
                                zzhVarZzl.zzat(0L);
                                zzhVarZzl.zzau(0L);
                                zzhVarZzl.zzas(0L);
                                zzhVarZzl.zzX(zzrVar.zzc);
                                zzhVarZzl.zzY(zzrVar.zzj);
                                zzhVarZzl.zzW(zzrVar.zzd);
                                zzhVarZzl.zzap(zzrVar.zze);
                                zzhVarZzl.zzaj(zzrVar.zzf);
                                zzhVarZzl.zzav(zzrVar.zzh);
                                zzhVarZzl.zzal(zzrVar.zzr);
                                i = 0;
                                zzj().zzT(zzhVarZzl, false, false);
                            } else {
                                i = 0;
                            }
                            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                                zzhwVarZzz.zzJ((String) Preconditions.checkNotNull(zzhVarZzl.zzD()));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzl.zzG())) {
                                zzhwVarZzz.zzag((String) Preconditions.checkNotNull(zzhVarZzl.zzG()));
                            }
                            listZzE = zzj().zzE(str10);
                            while (i2 < listZzE.size()) {
                                com.google.android.gms.internal.measurement.zzin zzinVarZze110 = com.google.android.gms.internal.measurement.zzio.zze();
                                zzinVarZze110.zzf(((zzqd) listZzE.get(i2)).zzc);
                                zzinVarZze110.zzg(((zzqd) listZzE.get(i2)).zzd);
                                zzA().zzx(zzinVarZze110, ((zzqd) listZzE.get(i2)).zze);
                                zzhwVarZzz.zzo(zzinVarZze110);
                                if (!"_sid".equals(((zzqd) listZzE.get(i2)).zzc)) {
                                }
                            }
                            zzawVarZzj3 = zzj();
                            zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVarZzz.zzba();
                            zzawVarZzj3.zzg();
                            zzawVarZzj3.zzav();
                            Preconditions.checkNotNull(zzhxVar);
                            Preconditions.checkNotEmpty(zzhxVar.zzF());
                            byte[] bArrZzcd1119 = zzhxVar.zzcd();
                            long jZzf110 = zzawVarZzj3.zzg.zzA().zzf(bArrZzcd1119);
                            ContentValues contentValues111 = new ContentValues();
                            String str211111111110 = str14;
                            contentValues111.put(str211111111110, zzhxVar.zzF());
                            contentValues111.put("metadata_fingerprint", Long.valueOf(jZzf110));
                            contentValues111.put("metadata", bArrZzcd1119);
                            zzawVarZzj3.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues111, 4);
                            zzawVarZzj4 = zzj();
                            zzbeVar2 = new zzbe(zzbcVar.zzf);
                            while (true) {
                                if (zzbeVar2.hasNext()) {
                                    zzif zzifVarZzr111 = zzr();
                                    String str211111111111 = zzbcVar.zza;
                                    zZzw = zzifVarZzr111.zzw(str211111111111, zzbcVar.zzb);
                                    zzas zzasVarZzo110 = zzj().zzo(zza(), str211111111111, false, false, false, false, false, false, false);
                                    if (zZzw) {
                                    }
                                    i3 = 0;
                                    break;
                                }
                                next = zzbeVar2.next();
                                String str211111111112 = next;
                                if (str11.equals(next)) {
                                }
                                i3 = 1;
                                break;
                            }
                            zzawVarZzj4.zzg();
                            zzawVarZzj4.zzav();
                            Preconditions.checkNotNull(zzbcVar);
                            str12 = zzbcVar.zza;
                            Preconditions.checkNotEmpty(str12);
                            byte[] bArrZzcd11110 = zzawVarZzj4.zzg.zzA().zzm(zzbcVar).zzcd();
                            contentValues = new ContentValues();
                            contentValues.put(str211111111110, str12);
                            contentValues.put("name", zzbcVar.zzb);
                            contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzf110));
                            contentValues.put("data", bArrZzcd11110);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (zzawVarZzj4.zzj().insert(str3, null, contentValues) == -1) {
                                zzawVarZzj4.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str12));
                            } else {
                                this.zza = 0L;
                            }
                            zzj().zzS();
                            zzj().zzL();
                            zzaL();
                            zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                            return;
                        }
                        if (jMax == 1) {
                            zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzasVarZzp.zzd));
                        }
                        zzj().zzS();
                    }
                }
                zzj().zzL();
            } catch (Throwable th) {
                zzj().zzL();
                throw th;
            }
        }
    }

    final boolean zzay(String str, String str2) {
        zzh zzhVarZzl = zzj().zzl(str);
        if (zzhVarZzl != null && zzB().zzak(str, zzhVarZzl.zzM())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpt zzptVar = (zzpt) this.zzF.get(str2);
        if (zzptVar == null) {
            return true;
        }
        return zzptVar.zzc();
    }

    final boolean zzaz() {
        zzaX().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaW().zzj().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzf();
        File filesDir = this.zzn.zzaT().getFilesDir();
        com.google.android.gms.internal.measurement.zzbx.zza();
        int i = com.google.android.gms.internal.measurement.zzcc.zzb;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzx = fileLockTryLock;
            if (fileLockTryLock != null) {
                zzaW().zzj().zza("Storage concurrent access okay");
                return true;
            }
            zzaW().zze().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaW().zze().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaW().zze().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzaW().zzk().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    final Bundle zzd(String str) {
        zzaX().zzg();
        zzM();
        if (zzr().zzi(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjx zzjxVarZzu = zzu(str);
        bundle.putAll(zzjxVarZzu.zzc());
        bundle.putAll(zzl(str, zzm(str), zzjxVarZzu, new zzao()).zzb());
        zzqd zzqdVarZzy = zzj().zzy(str, "_npa");
        bundle.putString("ad_personalization", 1 != (zzqdVarZzy != null ? zzqdVarZzy.zze.equals(1L) : zzaC(str, new zzao())) ? "granted" : "denied");
        return bundle;
    }

    final Bundle zzf(String str, zzbh zzbhVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.zze("_sid").longValue());
        zzqd zzqdVarZzy = zzj().zzy(str, "_sno");
        if (zzqdVarZzy != null) {
            Object obj = zzqdVarZzy.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0139  */
    /* JADX WARN: Code duplicated, block: B:53:0x0144  */
    /* JADX WARN: Code duplicated, block: B:56:0x014f  */
    /* JADX WARN: Code duplicated, block: B:59:0x015b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0170  */
    /* JADX WARN: Code duplicated, block: B:65:0x0196  */
    /* JADX WARN: Code duplicated, block: B:66:0x019c  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01f0  */
    final zzh zzg(zzr zzrVar) {
        boolean z;
        String str;
        long j;
        String str2;
        String str3;
        String str4;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str5 = zzrVar.zza;
        Preconditions.checkNotEmpty(str5);
        String str6 = zzrVar.zzv;
        zzpu zzpuVar = null;
        if (!str6.isEmpty()) {
            this.zzE.put(str5, new zzps(this, str6));
        }
        zzh zzhVarZzl = zzj().zzl(str5);
        zzjx zzjxVarZzl = zzu(str5).zzl(zzjx.zzk(zzrVar.zzu, 100));
        zzjw zzjwVar = zzjw.AD_STORAGE;
        String strZzf = zzjxVarZzl.zzr(zzjwVar) ? this.zzk.zzf(str5, zzrVar.zzn) : "";
        boolean z2 = true;
        if (zzhVarZzl == null) {
            zzh zzhVar = new zzh(this.zzn, str5);
            if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                zzhVar.zzV(zzC(zzjxVarZzl));
            }
            if (zzjxVarZzl.zzr(zzjwVar)) {
                zzhVar.zzax(strZzf);
            }
            zzhVarZzl = zzhVar;
        } else {
            if (zzjxVarZzl.zzr(zzjwVar) && strZzf != null && !strZzf.equals(zzhVarZzl.zzJ())) {
                boolean zIsEmpty = TextUtils.isEmpty(zzhVarZzl.zzJ());
                zzhVarZzl.zzax(strZzf);
                if (zzrVar.zzn && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(str5, zzjxVarZzl).first) && !zIsEmpty) {
                    if (zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                        zzhVarZzl.zzV(zzC(zzjxVarZzl));
                        z = false;
                    } else {
                        z = true;
                    }
                    if (zzj().zzy(str5, "_id") != null && zzj().zzy(str5, "_lair") == null) {
                        zzj().zzai(new zzqd(str5, "auto", "_lair", zzaU().currentTimeMillis(), 1L));
                    }
                } else if (TextUtils.isEmpty(zzhVarZzl.zzD()) && zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                    zzhVarZzl.zzV(zzC(zzjxVarZzl));
                }
                zzhVarZzl.zzao(zzrVar.zzb);
                zzhVarZzl.zzS(zzrVar.zzp);
                str = zzrVar.zzk;
                if (!TextUtils.isEmpty(str)) {
                    zzhVarZzl.zzan(str);
                }
                j = zzrVar.zze;
                if (j != 0) {
                    zzhVarZzl.zzap(j);
                }
                str2 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str2)) {
                    zzhVarZzl.zzX(str2);
                }
                zzhVarZzl.zzY(zzrVar.zzj);
                str3 = zzrVar.zzd;
                if (str3 != null) {
                    zzhVarZzl.zzW(str3);
                }
                zzhVarZzl.zzaj(zzrVar.zzf);
                zzhVarZzl.zzav(zzrVar.zzh);
                str4 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str4)) {
                    zzhVarZzl.zzaq(str4);
                }
                zzhVarZzl.zzU(zzrVar.zzn);
                zzhVarZzl.zzaw(zzrVar.zzq);
                zzhVarZzl.zzal(zzrVar.zzr);
                zzhVarZzl.zzaA(zzrVar.zzw);
                com.google.android.gms.internal.measurement.zzpn.zzb();
                if (zzi().zzx(null, zzgi.zzaK)) {
                    zzhVarZzl.zzay(zzrVar.zzs);
                } else {
                    com.google.android.gms.internal.measurement.zzpn.zzb();
                    if (zzi().zzx(null, zzgi.zzaJ)) {
                        zzhVarZzl.zzay(null);
                    }
                }
                zzhVarZzl.zzaD(zzrVar.zzx);
                zzhVarZzl.zzaC(zzrVar.zzD);
                zzqr.zzb();
                if (zzi().zzx(null, zzgi.zzaV)) {
                    zzhVarZzl.zzT(zzrVar.zzB);
                }
                zzhVarZzl.zzaE(zzrVar.zzy);
                zzhVarZzl.zzaz(zzrVar.zzE);
                if (zzi().zzx(null, zzgi.zzaP)) {
                    zzhVarZzl.zzaa(zzrVar.zzG);
                }
                if (!zzhVarZzl.zzaK()) {
                    if (z) {
                    }
                    return zzhVarZzl;
                }
                z2 = z;
                zzj().zzT(zzhVarZzl, z2, false);
                return zzhVarZzl;
            }
            if (TextUtils.isEmpty(zzhVarZzl.zzD()) && zzjxVarZzl.zzr(zzjw.ANALYTICS_STORAGE)) {
                zzhVarZzl.zzV(zzC(zzjxVarZzl));
            }
        }
        z = false;
        zzhVarZzl.zzao(zzrVar.zzb);
        zzhVarZzl.zzS(zzrVar.zzp);
        str = zzrVar.zzk;
        if (!TextUtils.isEmpty(str)) {
            zzhVarZzl.zzan(str);
        }
        j = zzrVar.zze;
        if (j != 0) {
            zzhVarZzl.zzap(j);
        }
        str2 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str2)) {
            zzhVarZzl.zzX(str2);
        }
        zzhVarZzl.zzY(zzrVar.zzj);
        str3 = zzrVar.zzd;
        if (str3 != null) {
            zzhVarZzl.zzW(str3);
        }
        zzhVarZzl.zzaj(zzrVar.zzf);
        zzhVarZzl.zzav(zzrVar.zzh);
        str4 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str4)) {
            zzhVarZzl.zzaq(str4);
        }
        zzhVarZzl.zzU(zzrVar.zzn);
        zzhVarZzl.zzaw(zzrVar.zzq);
        zzhVarZzl.zzal(zzrVar.zzr);
        zzhVarZzl.zzaA(zzrVar.zzw);
        com.google.android.gms.internal.measurement.zzpn.zzb();
        if (zzi().zzx(null, zzgi.zzaK)) {
            zzhVarZzl.zzay(zzrVar.zzs);
        } else {
            com.google.android.gms.internal.measurement.zzpn.zzb();
            if (zzi().zzx(null, zzgi.zzaJ)) {
                zzhVarZzl.zzay(null);
            }
        }
        zzhVarZzl.zzaD(zzrVar.zzx);
        zzhVarZzl.zzaC(zzrVar.zzD);
        zzqr.zzb();
        if (zzi().zzx(null, zzgi.zzaV)) {
            zzhVarZzl.zzT(zzrVar.zzB);
        }
        zzhVarZzl.zzaE(zzrVar.zzy);
        zzhVarZzl.zzaz(zzrVar.zzE);
        if (zzi().zzx(null, zzgi.zzaP)) {
            zzhVarZzl.zzaa(zzrVar.zzG);
        }
        if (!zzhVarZzl.zzaK()) {
            if (z) {
            }
            return zzhVarZzl;
        }
        z2 = z;
        zzj().zzT(zzhVarZzl, z2, false);
        return zzhVarZzl;
    }

    public final zzae zzh() {
        zzae zzaeVar = this.zzh;
        zzaR(zzaeVar);
        return zzaeVar;
    }

    public final zzam zzi() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    public final zzaw zzj() {
        zzaw zzawVar = this.zze;
        zzaR(zzawVar);
        return zzawVar;
    }

    final zzba zzl(String str, zzba zzbaVar, zzjx zzjxVar, zzao zzaoVar) {
        zzju zzjuVar;
        zzju zzjuVarZzf;
        int iZza = 90;
        if (zzr().zzi(str) == null) {
            if (zzbaVar.zzf() == zzju.DENIED) {
                iZza = zzbaVar.zza();
                zzaoVar.zzc(zzjw.AD_USER_DATA, iZza);
            } else {
                zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.FAILSAFE);
            }
            return new zzba((Boolean) false, iZza, (Boolean) true, "-");
        }
        zzju zzjuVarZzf2 = zzbaVar.zzf();
        if (zzjuVarZzf2 == zzju.GRANTED || zzjuVarZzf2 == (zzjuVar = zzju.DENIED)) {
            iZza = zzbaVar.zza();
            zzaoVar.zzc(zzjw.AD_USER_DATA, iZza);
        } else if (zzjuVarZzf2 != zzju.POLICY || (zzjuVarZzf = this.zzc.zzf(str, zzjw.AD_USER_DATA)) == zzju.UNINITIALIZED) {
            zzif zzifVar = this.zzc;
            zzjw zzjwVarZzh = zzifVar.zzh(str, zzjw.AD_USER_DATA);
            zzju zzjuVarZze = zzjxVar.zze();
            zzju zzjuVar2 = zzju.GRANTED;
            boolean z = zzjuVarZze == zzjuVar2 || zzjuVarZze == zzjuVar;
            if (zzjwVarZzh == zzjw.AD_STORAGE && z) {
                zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.REMOTE_DELEGATION);
                zzjuVarZzf2 = zzjuVarZze;
            } else {
                zzjw zzjwVar = zzjw.AD_USER_DATA;
                zzaoVar.zzd(zzjwVar, zzan.REMOTE_DEFAULT);
                zzjuVarZzf2 = true != zzifVar.zzu(str, zzjwVar) ? zzjuVar : zzjuVar2;
            }
        } else {
            zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.REMOTE_ENFORCED_DEFAULT);
            zzjuVarZzf2 = zzjuVarZzf;
        }
        boolean zZzv = this.zzc.zzv(str);
        SortedSet sortedSetZzp = zzr().zzp(str);
        if (zzjuVarZzf2 == zzju.DENIED || sortedSetZzp.isEmpty()) {
            return new zzba((Boolean) false, iZza, Boolean.valueOf(zZzv), "-");
        }
        return new zzba((Boolean) true, iZza, Boolean.valueOf(zZzv), zZzv ? TextUtils.join("", sortedSetZzp) : "");
    }

    final zzba zzm(String str) {
        zzaX().zzg();
        zzM();
        Map map = this.zzD;
        zzba zzbaVar = (zzba) map.get(str);
        if (zzbaVar != null) {
            return zzbaVar;
        }
        zzba zzbaVarZzq = zzj().zzq(str);
        map.put(str, zzbaVarZzq);
        return zzbaVarZzq;
    }

    public final zzgx zzo() {
        return this.zzn.zzj();
    }

    public final zzhk zzp() {
        zzhk zzhkVar = this.zzd;
        zzaR(zzhkVar);
        return zzhkVar;
    }

    public final zzhm zzq() {
        zzhm zzhmVar = this.zzf;
        if (zzhmVar != null) {
            return zzhmVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzif zzr() {
        zzif zzifVar = this.zzc;
        zzaR(zzifVar);
        return zzifVar;
    }

    final zzio zzt() {
        return this.zzn;
    }

    final zzjx zzu(String str) {
        zzjx zzjxVar = zzjx.zza;
        zzaX().zzg();
        zzM();
        zzjx zzjxVarZzu = (zzjx) this.zzC.get(str);
        if (zzjxVarZzu == null) {
            zzjxVarZzu = zzj().zzu(str);
            if (zzjxVarZzu == null) {
                zzjxVarZzu = zzjx.zza;
            }
            zzaq(str, zzjxVarZzu);
        }
        return zzjxVarZzu;
    }

    public final zzmc zzv() {
        zzmc zzmcVar = this.zzj;
        zzaR(zzmcVar);
        return zzmcVar;
    }

    public final zzoa zzw() {
        return this.zzk;
    }

    public final zzoy zzx() {
        zzoy zzoyVar = this.zzg;
        zzaR(zzoyVar);
        return zzoyVar;
    }

    public final zzpi zzy() {
        return this.zzl;
    }
}
