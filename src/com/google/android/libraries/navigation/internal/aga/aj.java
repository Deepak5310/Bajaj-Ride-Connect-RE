package com.google.android.libraries.navigation.internal.aga;

import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aj implements Runnable {
    public final com.google.android.libraries.navigation.internal.afx.bu a;
    final /* synthetic */ am b;

    public aj(am amVar, com.google.android.libraries.navigation.internal.afx.bu buVar) {
        this.b = amVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(buVar, "savedListener");
        this.a = buVar;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0236 A[Catch: RuntimeException -> 0x028d, all -> 0x036f, IOException -> 0x0372, TryCatch #1 {RuntimeException -> 0x028d, blocks: (B:94:0x01e1, B:95:0x01e9, B:97:0x01ef, B:98:0x0205, B:100:0x020d, B:102:0x0213, B:103:0x0217, B:105:0x021d, B:109:0x022e, B:111:0x0236, B:116:0x0243, B:119:0x024f, B:121:0x0257, B:123:0x025d, B:124:0x0261, B:126:0x0267, B:128:0x0273, B:133:0x027d, B:134:0x028c), top: B:209:0x01e1 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0242  */
    /* JADX WARN: Code duplicated, block: B:118:0x024e  */
    /* JADX WARN: Code duplicated, block: B:119:0x024f A[Catch: RuntimeException -> 0x028d, all -> 0x036f, IOException -> 0x0372, TryCatch #1 {RuntimeException -> 0x028d, blocks: (B:94:0x01e1, B:95:0x01e9, B:97:0x01ef, B:98:0x0205, B:100:0x020d, B:102:0x0213, B:103:0x0217, B:105:0x021d, B:109:0x022e, B:111:0x0236, B:116:0x0243, B:119:0x024f, B:121:0x0257, B:123:0x025d, B:124:0x0261, B:126:0x0267, B:128:0x0273, B:133:0x027d, B:134:0x028c), top: B:209:0x01e1 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0257 A[Catch: RuntimeException -> 0x028d, all -> 0x036f, IOException -> 0x0372, TryCatch #1 {RuntimeException -> 0x028d, blocks: (B:94:0x01e1, B:95:0x01e9, B:97:0x01ef, B:98:0x0205, B:100:0x020d, B:102:0x0213, B:103:0x0217, B:105:0x021d, B:109:0x022e, B:111:0x0236, B:116:0x0243, B:119:0x024f, B:121:0x0257, B:123:0x025d, B:124:0x0261, B:126:0x0267, B:128:0x0273, B:133:0x027d, B:134:0x028c), top: B:209:0x01e1 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0267 A[Catch: RuntimeException -> 0x028d, all -> 0x036f, IOException -> 0x0372, TryCatch #1 {RuntimeException -> 0x028d, blocks: (B:94:0x01e1, B:95:0x01e9, B:97:0x01ef, B:98:0x0205, B:100:0x020d, B:102:0x0213, B:103:0x0217, B:105:0x021d, B:109:0x022e, B:111:0x0236, B:116:0x0243, B:119:0x024f, B:121:0x0257, B:123:0x025d, B:124:0x0261, B:126:0x0267, B:128:0x0273, B:133:0x027d, B:134:0x028c), top: B:209:0x01e1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0279  */
    /* JADX WARN: Code duplicated, block: B:163:0x0303 A[Catch: Exception -> 0x0311, all -> 0x036f, TRY_ENTER, TryCatch #7 {Exception -> 0x0311, blocks: (B:18:0x0090, B:19:0x009d, B:21:0x00a3, B:22:0x00b9, B:163:0x0303, B:164:0x0310), top: B:214:0x0079 }] */
    /* JADX WARN: Code duplicated, block: B:236:0x027d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:246:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:0x0273 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:? A[LOOP:5: B:124:0x0261->B:248:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:? A[Catch: Exception -> 0x0311, all -> 0x036f, SYNTHETIC, TRY_LEAVE, TryCatch #7 {Exception -> 0x0311, blocks: (B:18:0x0090, B:19:0x009d, B:21:0x00a3, B:22:0x00b9, B:163:0x0303, B:164:0x0310), top: B:214:0x0079 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0107 A[Catch: all -> 0x036f, IOException -> 0x0372, TryCatch #2 {IOException -> 0x0372, blocks: (B:6:0x002a, B:8:0x003c, B:10:0x0043, B:12:0x004a, B:14:0x0054, B:15:0x006b, B:185:0x0362, B:16:0x0079, B:23:0x00bf, B:25:0x00c3, B:61:0x0131, B:63:0x0137, B:90:0x01d0, B:91:0x01d5, B:93:0x01db, B:94:0x01e1, B:95:0x01e9, B:97:0x01ef, B:98:0x0205, B:100:0x020d, B:102:0x0213, B:103:0x0217, B:105:0x021d, B:109:0x022e, B:111:0x0236, B:116:0x0243, B:119:0x024f, B:121:0x0257, B:123:0x025d, B:124:0x0261, B:126:0x0267, B:128:0x0273, B:133:0x027d, B:134:0x028c, B:137:0x028f, B:146:0x02c2, B:148:0x02c6, B:152:0x02eb, B:149:0x02cc, B:140:0x02a5, B:144:0x02ae, B:150:0x02d7, B:60:0x0124, B:28:0x00d1, B:50:0x0107, B:52:0x0111, B:54:0x0115, B:32:0x00dc, B:36:0x00e7, B:38:0x00ed, B:46:0x0100, B:47:0x0101, B:167:0x0313), top: B:211:0x002a }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.libraries.navigation.internal.aga.ad] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.google.android.libraries.navigation.internal.aga.ad] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.google.android.libraries.navigation.internal.aga.ad] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Throwable th;
        final IOException iOException;
        ?? r8;
        ai aiVar;
        com.google.android.libraries.navigation.internal.afx.cq cqVar;
        ?? r9;
        final ?? r5;
        Throwable th2;
        Exception exc;
        ak akVarA;
        al alVar;
        com.google.android.libraries.navigation.internal.afx.bs bsVar;
        com.google.android.libraries.navigation.internal.afx.bs bsVar2;
        Double dB;
        List listH;
        Map mapI;
        Iterator it2;
        int iIntValue;
        boolean z;
        String str = "run";
        if (am.a.isLoggable(Level.FINER)) {
            am.a.logp(Level.FINER, "io.grpc.internal.DnsNameResolver$Resolve", "run", "Attempting DNS resolution of ".concat(String.valueOf(this.b.j)));
        }
        ?? r10 = 0;
        r10 = 0;
        ?? r11 = 0;
        try {
            try {
                am amVar = this.b;
                com.google.android.libraries.navigation.internal.afx.cc ccVarA = amVar.g.a(InetSocketAddress.createUnresolved(amVar.j, amVar.k));
                com.google.android.libraries.navigation.internal.afx.z zVar = ccVarA != null ? new com.google.android.libraries.navigation.internal.afx.z(ccVarA) : null;
                final com.google.android.libraries.navigation.internal.afx.bv bvVar = new com.google.android.libraries.navigation.internal.afx.bv();
                if (zVar != null) {
                    if (am.a.isLoggable(Level.FINER)) {
                        am.a.logp(Level.FINER, "io.grpc.internal.DnsNameResolver$Resolve", "run", "Using proxy address " + zVar.toString());
                    }
                    bvVar.b(new com.google.android.libraries.navigation.internal.afx.cm(null, Collections.singletonList(zVar)));
                } else {
                    try {
                        am amVar2 = this.b;
                        ad adVar = new ad();
                        try {
                            int i = amVar2.r;
                            List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(amVar2.j)));
                            ArrayList arrayList = new ArrayList(listUnmodifiableList.size());
                            Iterator it3 = listUnmodifiableList.iterator();
                            while (it3.hasNext()) {
                                arrayList.add(new com.google.android.libraries.navigation.internal.afx.z(new InetSocketAddress((InetAddress) it3.next(), amVar2.k)));
                            }
                            adVar.b = Collections.unmodifiableList(arrayList);
                            r5 = adVar;
                            if (am.e) {
                                List<String> listEmptyList = Collections.emptyList();
                                boolean z2 = am.c;
                                boolean z3 = am.d;
                                String str2 = amVar2.j;
                                if (!z2) {
                                    akVarA = null;
                                } else if (!AndroidInfoHelpers.DEVICE_LOCALHOST.equalsIgnoreCase(str2)) {
                                    if (!str2.contains(":")) {
                                        boolean z4 = true;
                                        for (int i2 = 0; i2 < str2.length(); i2++) {
                                            char cCharAt = str2.charAt(i2);
                                            if (cCharAt != '.') {
                                                z4 &= cCharAt >= '0' && cCharAt <= '9';
                                            }
                                        }
                                        if (!z4) {
                                            akVarA = (ak) amVar2.i.get();
                                            if (akVarA == null) {
                                                akVarA = alVar.a();
                                            }
                                        }
                                    }
                                    akVarA = null;
                                } else if (z3) {
                                    akVarA = (ak) amVar2.i.get();
                                    if (akVarA == null && (alVar = am.f) != null) {
                                        akVarA = alVar.a();
                                    }
                                } else {
                                    akVarA = null;
                                }
                                if (akVarA != null) {
                                    try {
                                        String str3 = amVar2.j;
                                        listEmptyList = akVarA.a();
                                    } catch (Exception e) {
                                        am.a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveServiceConfig", "ServiceConfig resolution failure", (Throwable) e);
                                    }
                                }
                                if (listEmptyList.isEmpty()) {
                                    am.a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveServiceConfig", "No TXT records found for {0}", new Object[]{amVar2.j});
                                } else {
                                    Random random = amVar2.h;
                                    String strE = am.e();
                                    try {
                                        try {
                                            ArrayList<Map> arrayList2 = new ArrayList();
                                            for (String str4 : listEmptyList) {
                                                if (str4.startsWith("grpc_config=")) {
                                                    String strSubstring = str4.substring(12);
                                                    Logger logger = bv.a;
                                                    JsonReader jsonReader = new JsonReader(new StringReader(strSubstring));
                                                    try {
                                                        Object objA = bv.a(jsonReader);
                                                        try {
                                                            jsonReader.close();
                                                        } catch (IOException e2) {
                                                            bv.a.logp(Level.WARNING, "io.grpc.internal.JsonParser", "parse", "Failed to close", (Throwable) e2);
                                                        }
                                                        if (!(objA instanceof List)) {
                                                            throw new ClassCastException("wrong type ".concat(String.valueOf(String.valueOf(objA))));
                                                        }
                                                        List list = (List) objA;
                                                        bw.j(list);
                                                        arrayList2.addAll(list);
                                                    } catch (Throwable th3) {
                                                        try {
                                                            jsonReader.close();
                                                            throw th3;
                                                        } catch (IOException e3) {
                                                            bv.a.logp(Level.WARNING, "io.grpc.internal.JsonParser", "parse", "Failed to close", (Throwable) e3);
                                                            throw th3;
                                                        }
                                                    }
                                                } else {
                                                    am.a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "parseTxtResults", "Ignoring non service config {0}", new Object[]{str4});
                                                }
                                            }
                                            Map map = null;
                                            for (Map map2 : arrayList2) {
                                                try {
                                                    for (Map.Entry entry : map2.entrySet()) {
                                                        com.google.android.libraries.navigation.internal.yx.ca.b(am.b.contains(entry.getKey()), "Bad key: %s", entry);
                                                    }
                                                    List listH2 = bw.h(map2, "clientLanguage");
                                                    if (listH2 == null || listH2.isEmpty()) {
                                                        dB = bw.b(map2, "percentage");
                                                        if (dB == null) {
                                                            listH = bw.h(map2, "clientHostname");
                                                            if (listH != null && !listH.isEmpty()) {
                                                                it2 = listH.iterator();
                                                                while (true) {
                                                                    if (!it2.hasNext()) {
                                                                        map = null;
                                                                    } else if (((String) it2.next()).equals(strE)) {
                                                                    }
                                                                }
                                                            }
                                                            mapI = bw.i(map2, "serviceConfig");
                                                            if (mapI != null) {
                                                                throw new com.google.android.libraries.navigation.internal.yx.cb(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                            }
                                                            map = mapI;
                                                        } else {
                                                            iIntValue = dB.intValue();
                                                            if (iIntValue >= 0 || iIntValue > 100) {
                                                                z = false;
                                                            } else {
                                                                z = true;
                                                            }
                                                            com.google.android.libraries.navigation.internal.yx.ca.b(z, "Bad percentage: %s", dB);
                                                            if (random.nextInt(100) >= iIntValue) {
                                                                listH = bw.h(map2, "clientHostname");
                                                                if (listH != null) {
                                                                    it2 = listH.iterator();
                                                                    while (true) {
                                                                        if (!it2.hasNext()) {
                                                                            if (((String) it2.next()).equals(strE)) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                mapI = bw.i(map2, "serviceConfig");
                                                                if (mapI != null) {
                                                                    throw new com.google.android.libraries.navigation.internal.yx.cb(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                                }
                                                                map = mapI;
                                                            }
                                                            map = null;
                                                        }
                                                    } else {
                                                        Iterator it4 = listH2.iterator();
                                                        while (true) {
                                                            if (it4.hasNext()) {
                                                                if ("java".equalsIgnoreCase((String) it4.next())) {
                                                                    dB = bw.b(map2, "percentage");
                                                                    if (dB == null) {
                                                                        listH = bw.h(map2, "clientHostname");
                                                                        if (listH != null) {
                                                                            it2 = listH.iterator();
                                                                            while (true) {
                                                                                if (!it2.hasNext()) {
                                                                                    if (((String) it2.next()).equals(strE)) {
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        mapI = bw.i(map2, "serviceConfig");
                                                                        if (mapI != null) {
                                                                            throw new com.google.android.libraries.navigation.internal.yx.cb(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                                        }
                                                                        map = mapI;
                                                                    } else {
                                                                        iIntValue = dB.intValue();
                                                                        if (iIntValue >= 0) {
                                                                            z = false;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                        com.google.android.libraries.navigation.internal.yx.ca.b(z, "Bad percentage: %s", dB);
                                                                        if (random.nextInt(100) >= iIntValue) {
                                                                            listH = bw.h(map2, "clientHostname");
                                                                            if (listH != null) {
                                                                                it2 = listH.iterator();
                                                                                while (true) {
                                                                                    if (!it2.hasNext()) {
                                                                                        if (((String) it2.next()).equals(strE)) {
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            mapI = bw.i(map2, "serviceConfig");
                                                                            if (mapI != null) {
                                                                                throw new com.google.android.libraries.navigation.internal.yx.cb(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                                            }
                                                                            map = mapI;
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
                                                } catch (RuntimeException e4) {
                                                    bsVar2 = new com.google.android.libraries.navigation.internal.afx.bs(com.google.android.libraries.navigation.internal.afx.cl.c.b("failed to pick service config choice").a(e4));
                                                }
                                            }
                                            bsVar2 = map == null ? null : new com.google.android.libraries.navigation.internal.afx.bs(map);
                                        } catch (IOException e5) {
                                            e = e5;
                                            bsVar2 = new com.google.android.libraries.navigation.internal.afx.bs(com.google.android.libraries.navigation.internal.afx.cl.c.b("failed to parse TXT records").a(e));
                                        }
                                    } catch (RuntimeException e6) {
                                        e = e6;
                                        bsVar2 = new com.google.android.libraries.navigation.internal.afx.bs(com.google.android.libraries.navigation.internal.afx.cl.c.b("failed to parse TXT records").a(e));
                                    }
                                    if (bsVar2 != null) {
                                        com.google.android.libraries.navigation.internal.afx.cl clVar = bsVar2.a;
                                        bsVar = clVar != null ? new com.google.android.libraries.navigation.internal.afx.bs(clVar) : amVar2.p.a((Map) bsVar2.b);
                                    }
                                    adVar.c = bsVar;
                                    r5 = adVar;
                                }
                                bsVar = null;
                                adVar.c = bsVar;
                                r5 = adVar;
                            }
                            try {
                                if (r5.a != null) {
                                    this.b.m.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.aga.af
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.google.android.libraries.navigation.internal.afx.bv bvVar2 = new com.google.android.libraries.navigation.internal.afx.bv();
                                            bvVar2.b(com.google.android.libraries.navigation.internal.afx.cm.b(r5.a));
                                            this.a.a.a(bvVar2.a());
                                        }
                                    });
                                    boolean z5 = r5.a == null;
                                    am amVar3 = this.b;
                                    aiVar = new ai(this, z5);
                                    cqVar = amVar3.m;
                                } else {
                                    List list2 = r5.b;
                                    if (list2 != null) {
                                        bvVar.b(new com.google.android.libraries.navigation.internal.afx.cm(null, list2));
                                    }
                                    com.google.android.libraries.navigation.internal.afx.bs bsVar3 = r5.c;
                                    if (bsVar3 != null) {
                                        bvVar.b = bsVar3;
                                    }
                                    r10 = r5;
                                }
                            } catch (IOException e7) {
                                iOException = e7;
                                r8 = r5;
                                this.b.m.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.aga.ah
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.libraries.navigation.internal.afx.bv bvVar2 = new com.google.android.libraries.navigation.internal.afx.bv();
                                        com.google.android.libraries.navigation.internal.afx.cl clVar2 = com.google.android.libraries.navigation.internal.afx.cl.f;
                                        aj ajVar = this.a;
                                        bvVar2.b(com.google.android.libraries.navigation.internal.afx.cm.b(clVar2.b("Unable to resolve host ".concat(String.valueOf(ajVar.b.j))).a(iOException)));
                                        ajVar.a.a(bvVar2.a());
                                    }
                                });
                                r9 = r8;
                            } catch (Throwable th4) {
                                th = th4;
                                r11 = r5;
                                this.b.m.execute(new ai(this, r11 != 0 && r11.a == null));
                                throw th;
                            }
                            cqVar.execute(aiVar);
                        } catch (Exception e8) {
                            try {
                                com.google.android.libraries.navigation.internal.yx.bx.c(e8);
                                throw new RuntimeException(e8);
                            } catch (Throwable th5) {
                                exc = e8;
                                th2 = th5;
                                if (exc != null) {
                                    throw th2;
                                }
                                am.a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveAddresses", "Address resolution failure", (Throwable) exc);
                                throw th2;
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                            exc = null;
                            if (exc != null) {
                                throw th2;
                            }
                            am.a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveAddresses", "Address resolution failure", (Throwable) exc);
                            throw th2;
                        }
                    } catch (Exception e9) {
                        "run".a = com.google.android.libraries.navigation.internal.afx.cl.f.b("Unable to resolve host ".concat(String.valueOf("Using proxy address ".j))).a(e9);
                        r5 = str;
                    }
                }
                this.b.m.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.aga.ag
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a.a(bvVar.a());
                    }
                });
                r9 = r10;
            } catch (IOException e10) {
                iOException = e10;
                r8 = r10;
            }
            boolean z6 = r9 != 0 && r9.a == null;
            am amVar4 = this.b;
            aiVar = new ai(this, z6);
            cqVar = amVar4.m;
            cqVar.execute(aiVar);
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
