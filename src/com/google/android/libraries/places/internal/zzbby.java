package com.google.android.libraries.places.internal;

import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbby extends zzawk {
    static final boolean zza;
    static final boolean zzb;
    protected static final boolean zzc;
    private static final Logger zzg;
    private static final Set zzh;
    private static final String zzi;
    private static final String zzj;
    private static final String zzk;
    private static final zzbbx zzl;
    private static String zzm;
    private boolean zzA;
    private zzawg zzB;
    final zzawt zzd;
    protected boolean zzf;
    private final String zzp;
    private final String zzq;
    private final int zzr;
    private final zzbjq zzs;
    private final long zzt;
    private final zzaxl zzu;
    private final zzla zzv;
    private boolean zzw;
    private Executor zzx;
    private final boolean zzy;
    private final zzawj zzz;
    private final Random zzn = new Random();
    protected volatile zzbbq zze = zzbbt.INSTANCE;
    private final AtomicReference zzo = new AtomicReference();

    static {
        Logger logger = Logger.getLogger(zzbby.class.getName());
        zzg = logger;
        zzh = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        zzi = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        zzj = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        zzk = property3;
        zza = Boolean.parseBoolean(property);
        zzb = Boolean.parseBoolean(property2);
        zzc = Boolean.parseBoolean(property3);
        zzbbx zzbbxVar = null;
        try {
            try {
                try {
                    zzbbx zzbbxVar2 = (zzbbx) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, zzbby.class.getClassLoader()).asSubclass(zzbbx.class).getConstructor(null).newInstance(null);
                    if (zzbbxVar2.zzb() != null) {
                        logger.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "JndiResourceResolverFactory not available, skipping.", zzbbxVar2.zzb());
                    } else {
                        zzbbxVar = zzbbxVar2;
                    }
                } catch (Exception e) {
                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e);
                }
            } catch (Exception e2) {
                zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e2);
            }
        } catch (ClassCastException e3) {
            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e3);
        } catch (ClassNotFoundException e4) {
            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e4);
        }
        zzl = zzbbxVar;
    }

    protected zzbby(@Nullable String str, String str2, zzawd zzawdVar, zzbjq zzbjqVar, zzla zzlaVar, boolean z) {
        zzkt.zzc(zzawdVar, "args");
        this.zzs = zzbjqVar;
        zzkt.zzc(str2, "name");
        URI uriCreate = URI.create("//".concat(str2));
        zzkt.zzj(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        String authority = uriCreate.getAuthority();
        zzkt.zzd(authority, "nameUri (%s) doesn't have an authority", uriCreate);
        this.zzp = authority;
        this.zzq = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.zzr = zzawdVar.zza();
        } else {
            this.zzr = uriCreate.getPort();
        }
        this.zzd = zzawdVar.zzd();
        long nanos = 0;
        if (!z) {
            String property = System.getProperty("networkaddress.cache.ttl");
            long j = 30;
            if (property != null) {
                try {
                    j = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    zzg.logp(Level.WARNING, "io.grpc.internal.DnsNameResolver", "getNetworkAddressCacheTtlNanos", "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
                }
            }
            nanos = j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
        }
        this.zzt = nanos;
        this.zzv = zzlaVar;
        this.zzu = zzawdVar.zze();
        Executor executorZzf = zzawdVar.zzf();
        this.zzx = executorZzf;
        this.zzy = executorZzf == null;
        this.zzz = zzawdVar.zzc();
    }

    static /* bridge */ /* synthetic */ zzati zzg(zzbby zzbbyVar) throws IOException {
        zzaws zzawsVarZza = zzbbyVar.zzd.zza(InetSocketAddress.createUnresolved(zzbbyVar.zzq, zzbbyVar.zzr));
        if (zzawsVarZza == null) {
            return null;
        }
        return new zzati(Collections.singletonList(zzawsVarZza), zzarv.zza);
    }

    private static String zzm() {
        if (zzm == null) {
            try {
                zzm = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
        return zzm;
    }

    private final void zzn() {
        if (this.zzA || this.zzw) {
            return;
        }
        if (this.zzf) {
            long j = this.zzt;
            if (j != 0 && (j <= 0 || this.zzv.zza(TimeUnit.NANOSECONDS) <= this.zzt)) {
                return;
            }
        }
        this.zzA = true;
        this.zzx.execute(new zzbbv(this, this.zzB));
    }

    @Override // com.google.android.libraries.places.internal.zzawk
    public final String zza() {
        return this.zzp;
    }

    @Override // com.google.android.libraries.places.internal.zzawk
    public final void zzb() {
        zzkt.zzo(this.zzB != null, "not started");
        zzn();
    }

    @Override // com.google.android.libraries.places.internal.zzawk
    public final void zzc() {
        if (this.zzw) {
            return;
        }
        this.zzw = true;
        Executor executor = this.zzx;
        if (executor == null || !this.zzy) {
            return;
        }
        zzbjr.zzc(this.zzs, executor);
        this.zzx = null;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.concurrent.Executor] */
    @Override // com.google.android.libraries.places.internal.zzawk
    public final void zzd(zzawg zzawgVar) {
        zzkt.zzo(this.zzB == null, "already started");
        if (this.zzy) {
            this.zzx = zzbjr.zza(this.zzs);
        }
        this.zzB = zzawgVar;
        zzn();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:13:0x0060  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x01ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:? A[LOOP:5: B:94:0x01b8->B:163:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    /* JADX WARN: Code duplicated, block: B:81:0x018d A[Catch: RuntimeException -> 0x01e4, TryCatch #0 {RuntimeException -> 0x01e4, blocks: (B:64:0x0138, B:65:0x0140, B:67:0x0146, B:68:0x015c, B:70:0x0164, B:72:0x016a, B:73:0x016e, B:75:0x0174, B:79:0x0185, B:81:0x018d, B:86:0x019a, B:89:0x01a6, B:91:0x01ae, B:93:0x01b4, B:94:0x01b8, B:96:0x01be, B:98:0x01ca, B:103:0x01d4, B:104:0x01e3), top: B:134:0x0138 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0199  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a6 A[Catch: RuntimeException -> 0x01e4, TryCatch #0 {RuntimeException -> 0x01e4, blocks: (B:64:0x0138, B:65:0x0140, B:67:0x0146, B:68:0x015c, B:70:0x0164, B:72:0x016a, B:73:0x016e, B:75:0x0174, B:79:0x0185, B:81:0x018d, B:86:0x019a, B:89:0x01a6, B:91:0x01ae, B:93:0x01b4, B:94:0x01b8, B:96:0x01be, B:98:0x01ca, B:103:0x01d4, B:104:0x01e3), top: B:134:0x0138 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01ae A[Catch: RuntimeException -> 0x01e4, TryCatch #0 {RuntimeException -> 0x01e4, blocks: (B:64:0x0138, B:65:0x0140, B:67:0x0146, B:68:0x015c, B:70:0x0164, B:72:0x016a, B:73:0x016e, B:75:0x0174, B:79:0x0185, B:81:0x018d, B:86:0x019a, B:89:0x01a6, B:91:0x01ae, B:93:0x01b4, B:94:0x01b8, B:96:0x01be, B:98:0x01ca, B:103:0x01d4, B:104:0x01e3), top: B:134:0x0138 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01be A[Catch: RuntimeException -> 0x01e4, TryCatch #0 {RuntimeException -> 0x01e4, blocks: (B:64:0x0138, B:65:0x0140, B:67:0x0146, B:68:0x015c, B:70:0x0164, B:72:0x016a, B:73:0x016e, B:75:0x0174, B:79:0x0185, B:81:0x018d, B:86:0x019a, B:89:0x01a6, B:91:0x01ae, B:93:0x01b4, B:94:0x01b8, B:96:0x01be, B:98:0x01ca, B:103:0x01d4, B:104:0x01e3), top: B:134:0x0138 }] */
    protected final zzbbs zzi(boolean z) {
        zzbbw zzbbwVarZza;
        zzbbx zzbbxVar;
        zzawe zzaweVarZzb;
        Double dZzb;
        List listZzi;
        Map mapZzj;
        Iterator it2;
        int iIntValue;
        boolean z2;
        Exception exc = null;
        zzaweVarZzb = null;
        zzawe zzaweVarZzb2 = null;
        exc = null;
        zzbbs zzbbsVar = new zzbbs(null);
        try {
            try {
                try {
                    List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(this.zzq)));
                    ArrayList arrayList = new ArrayList(listUnmodifiableList.size());
                    Iterator it3 = listUnmodifiableList.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(new zzati(Collections.singletonList(new InetSocketAddress((InetAddress) it3.next(), this.zzr)), zzarv.zza));
                    }
                    zzbbsVar.zzb = Collections.unmodifiableList(arrayList);
                    if (zzc) {
                        String str = this.zzq;
                        List<String> listEmptyList = Collections.emptyList();
                        boolean z3 = zza;
                        boolean z4 = zzb;
                        if (!z3) {
                            zzbbwVarZza = null;
                        } else if (!AndroidInfoHelpers.DEVICE_LOCALHOST.equalsIgnoreCase(str)) {
                            if (!str.contains(":")) {
                                boolean z5 = true;
                                int i = 0;
                                while (i < str.length()) {
                                    char cCharAt = str.charAt(i);
                                    if (cCharAt != '.') {
                                        z5 = (z5 ? 1 : 0) & (cCharAt >= '0' && cCharAt <= '9');
                                    }
                                    i++;
                                    z5 = z5;
                                }
                                if (!z5) {
                                    zzbbwVarZza = (zzbbw) this.zzo.get();
                                    if (zzbbwVarZza == null) {
                                        zzbbwVarZza = zzbbxVar.zza();
                                    }
                                }
                            }
                            zzbbwVarZza = null;
                        } else if (z4) {
                            zzbbwVarZza = (zzbbw) this.zzo.get();
                            if (zzbbwVarZza == null && (zzbbxVar = zzl) != null) {
                                zzbbwVarZza = zzbbxVar.zza();
                            }
                        } else {
                            zzbbwVarZza = null;
                        }
                        if (zzbbwVarZza != null) {
                            try {
                                listEmptyList = zzbbwVarZza.zza();
                            } catch (Exception e) {
                                zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveServiceConfig", "ServiceConfig resolution failure", (Throwable) e);
                            }
                        }
                        if (listEmptyList.isEmpty()) {
                            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveServiceConfig", "No TXT records found for {0}", new Object[]{this.zzq});
                        } else {
                            Random random = this.zzn;
                            String strZzm = zzm();
                            try {
                                ArrayList<Map> arrayList2 = new ArrayList();
                                for (String str2 : listEmptyList) {
                                    if (str2.startsWith("grpc_config=")) {
                                        Object objZza = zzbdw.zza(str2.substring(12));
                                        if (!(objZza instanceof List)) {
                                            throw new ClassCastException("wrong type ".concat(String.valueOf(String.valueOf(objZza))));
                                        }
                                        List list = (List) objZza;
                                        zzbdx.zzf(list);
                                        arrayList2.addAll(list);
                                    } else {
                                        zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "parseTxtResults", "Ignoring non service config {0}", new Object[]{str2});
                                    }
                                }
                                Map map = null;
                                for (Map map2 : arrayList2) {
                                    try {
                                        for (Map.Entry entry : map2.entrySet()) {
                                            zzlg.zza(zzh.contains(entry.getKey()), "Bad key: %s", entry);
                                        }
                                        List listZzi2 = zzbdx.zzi(map2, "clientLanguage");
                                        if (listZzi2 == null || listZzi2.isEmpty()) {
                                            dZzb = zzbdx.zzb(map2, "percentage");
                                            if (dZzb == null) {
                                                listZzi = zzbdx.zzi(map2, "clientHostname");
                                                if (listZzi != null && !listZzi.isEmpty()) {
                                                    it2 = listZzi.iterator();
                                                    while (true) {
                                                        if (!it2.hasNext()) {
                                                            map = null;
                                                        } else if (((String) it2.next()).equals(strZzm)) {
                                                        }
                                                    }
                                                }
                                                mapZzj = zzbdx.zzj(map2, "serviceConfig");
                                                if (mapZzj != null) {
                                                    throw new zzlh(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                }
                                                map = mapZzj;
                                            } else {
                                                iIntValue = dZzb.intValue();
                                                if (iIntValue >= 0 || iIntValue > 100) {
                                                    z2 = false;
                                                } else {
                                                    z2 = true;
                                                }
                                                zzlg.zza(z2, "Bad percentage: %s", dZzb);
                                                if (random.nextInt(100) >= iIntValue) {
                                                    listZzi = zzbdx.zzi(map2, "clientHostname");
                                                    if (listZzi != null) {
                                                        it2 = listZzi.iterator();
                                                        while (true) {
                                                            if (!it2.hasNext()) {
                                                                if (((String) it2.next()).equals(strZzm)) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    mapZzj = zzbdx.zzj(map2, "serviceConfig");
                                                    if (mapZzj != null) {
                                                        throw new zzlh(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                    }
                                                    map = mapZzj;
                                                }
                                                map = null;
                                            }
                                        } else {
                                            Iterator it4 = listZzi2.iterator();
                                            while (true) {
                                                if (it4.hasNext()) {
                                                    if ("java".equalsIgnoreCase((String) it4.next())) {
                                                        dZzb = zzbdx.zzb(map2, "percentage");
                                                        if (dZzb == null) {
                                                            listZzi = zzbdx.zzi(map2, "clientHostname");
                                                            if (listZzi != null) {
                                                                it2 = listZzi.iterator();
                                                                while (true) {
                                                                    if (!it2.hasNext()) {
                                                                        if (((String) it2.next()).equals(strZzm)) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            mapZzj = zzbdx.zzj(map2, "serviceConfig");
                                                            if (mapZzj != null) {
                                                                throw new zzlh(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                            }
                                                            map = mapZzj;
                                                        } else {
                                                            iIntValue = dZzb.intValue();
                                                            if (iIntValue >= 0) {
                                                                z2 = false;
                                                            } else {
                                                                z2 = false;
                                                            }
                                                            zzlg.zza(z2, "Bad percentage: %s", dZzb);
                                                            if (random.nextInt(100) >= iIntValue) {
                                                                listZzi = zzbdx.zzi(map2, "clientHostname");
                                                                if (listZzi != null) {
                                                                    it2 = listZzi.iterator();
                                                                    while (true) {
                                                                        if (!it2.hasNext()) {
                                                                            if (((String) it2.next()).equals(strZzm)) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                mapZzj = zzbdx.zzj(map2, "serviceConfig");
                                                                if (mapZzj != null) {
                                                                    throw new zzlh(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                                }
                                                                map = mapZzj;
                                                            }
                                                        }
                                                    }
                                                }
                                                map = null;
                                            }
                                        }
                                        if (map != null) {
                                            break;
                                        }
                                    } catch (RuntimeException e2) {
                                        zzaweVarZzb = zzawe.zzb(zzaxd.zzc.zzg("failed to pick service config choice").zzf(e2));
                                    }
                                }
                                zzaweVarZzb = map == null ? null : zzawe.zza(map);
                            } catch (IOException | RuntimeException e3) {
                                zzaweVarZzb = zzawe.zzb(zzaxd.zzc.zzg("failed to parse TXT records").zzf(e3));
                            }
                            if (zzaweVarZzb != null) {
                                zzaweVarZzb2 = zzaweVarZzb.zzc() != null ? zzawe.zzb(zzaweVarZzb.zzc()) : this.zzz.zza((Map) zzaweVarZzb.zzd());
                            }
                        }
                        zzbbsVar.zzc = zzaweVarZzb2;
                    }
                    return zzbbsVar;
                } catch (Exception e4) {
                    exc = e4;
                    zzld.zza(exc);
                    throw new RuntimeException(exc);
                }
            } catch (Throwable th) {
                Exception exc2 = exc;
                if (exc2 != null) {
                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveAddresses", "Address resolution failure", (Throwable) exc2);
                }
                throw th;
            }
        } catch (Exception e5) {
            zzbbsVar.zza = zzaxd.zzp.zzg("Unable to resolve host ".concat(String.valueOf(this.zzq))).zzf(e5);
            return zzbbsVar;
        }
    }
}
