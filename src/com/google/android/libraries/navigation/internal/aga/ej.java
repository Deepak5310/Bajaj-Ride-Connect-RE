package com.google.android.libraries.navigation.internal.aga;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ej extends com.google.android.libraries.navigation.internal.afx.bx {
    private final boolean a;
    private final int b;
    private final int c;
    private final h d;

    public ej(boolean z, int i, int i2, h hVar) {
        this.a = z;
        this.b = i;
        this.c = i2;
        com.google.android.libraries.navigation.internal.yx.ar.r(hVar, "autoLoadBalancerFactory");
        this.d = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bx
    public final com.google.android.libraries.navigation.internal.afx.bs a(Map map) {
        com.google.android.libraries.navigation.internal.afx.bs bsVar;
        List listUnmodifiableList;
        String strE;
        com.google.android.libraries.navigation.internal.afx.bs bsVarB;
        Object obj;
        ed edVar;
        dc dcVar;
        Map mapI;
        try {
            h hVar = this.d;
            da daVar = null;
            if (map != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    if (map.containsKey("loadBalancingConfig")) {
                        arrayList.addAll(bw.g(map, "loadBalancingConfig"));
                    }
                    if (arrayList.isEmpty() && (strE = bw.e(map, "loadBalancingPolicy")) != null) {
                        arrayList.add(Collections.singletonMap(strE.toLowerCase(Locale.ROOT), Collections.emptyMap()));
                    }
                    List<Map> listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
                    if (listUnmodifiableList2 == null) {
                        listUnmodifiableList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        for (Map map2 : listUnmodifiableList2) {
                            if (map2.size() != 1) {
                                throw new RuntimeException("There are " + map2.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + String.valueOf(map2));
                            }
                            String str = (String) ((Map.Entry) map2.entrySet().iterator().next()).getKey();
                            arrayList2.add(new ek(str, bw.i(map2, str)));
                        }
                        listUnmodifiableList = Collections.unmodifiableList(arrayList2);
                    }
                } catch (RuntimeException e) {
                    bsVar = new com.google.android.libraries.navigation.internal.afx.bs(com.google.android.libraries.navigation.internal.afx.cl.c.b("can't parse load balancer configuration").a(e));
                }
            } else {
                listUnmodifiableList = null;
            }
            if (listUnmodifiableList == null || listUnmodifiableList.isEmpty()) {
                bsVarB = null;
            } else {
                com.google.android.libraries.navigation.internal.afx.bc bcVar = hVar.a;
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = listUnmodifiableList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        bsVar = new com.google.android.libraries.navigation.internal.afx.bs(com.google.android.libraries.navigation.internal.afx.cl.c.b(com.google.android.libraries.navigation.internal.b.b.n(arrayList3, "None of ", " specified by Service Config are available.")));
                        bsVarB = bsVar;
                        break;
                    }
                    ek ekVar = (ek) it2.next();
                    String str2 = ekVar.a;
                    com.google.android.libraries.navigation.internal.afx.ba baVarA = bcVar.a(str2);
                    if (baVarA != null) {
                        if (!arrayList3.isEmpty()) {
                            Logger.getLogger(em.class.getName()).logp(Level.FINEST, "io.grpc.internal.ServiceConfigUtil", "selectLbPolicyFromList", "{0} specified by Service Config are not available", arrayList3);
                        }
                        bsVarB = baVarA.b(ekVar.b);
                        if (bsVarB.a != null) {
                            break;
                        }
                        bsVarB = new com.google.android.libraries.navigation.internal.afx.bs(new el(baVarA, bsVarB.b));
                        break;
                    }
                    arrayList3.add(str2);
                }
            }
            if (bsVarB == null) {
                obj = null;
            } else {
                com.google.android.libraries.navigation.internal.afx.cl clVar = bsVarB.a;
                if (clVar != null) {
                    return new com.google.android.libraries.navigation.internal.afx.bs(clVar);
                }
                obj = bsVarB.b;
            }
            boolean z = this.a;
            int i = this.b;
            int i2 = this.c;
            if (!z || map == null || (mapI = bw.i(map, "retryThrottling")) == null) {
                edVar = null;
            } else {
                float fFloatValue = bw.b(mapI, "maxTokens").floatValue();
                float fFloatValue2 = bw.b(mapI, "tokenRatio").floatValue();
                com.google.android.libraries.navigation.internal.yx.ar.l(fFloatValue > 0.0f, "maxToken should be greater than zero");
                com.google.android.libraries.navigation.internal.yx.ar.l(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
                edVar = new ed(fFloatValue, fFloatValue2);
            }
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            Map mapI2 = map == null ? null : bw.i(map, "healthCheckConfig");
            List<Map> listG = bw.g(map, "methodConfig");
            if (listG == null) {
                dcVar = new dc(null, map3, map4, edVar, obj, mapI2);
            } else {
                for (Map map5 : listG) {
                    da daVar2 = new da(map5, z, i, i2);
                    List<Map> listG2 = bw.g(map5, "name");
                    if (listG2 == null || listG2.isEmpty()) {
                        z = z;
                    } else {
                        for (Map map6 : listG2) {
                            String strE2 = bw.e(map6, NotificationCompat.CATEGORY_SERVICE);
                            boolean z2 = z;
                            String strE3 = bw.e(map6, FirebaseAnalytics.Param.METHOD);
                            if (com.google.android.libraries.navigation.internal.yx.aq.c(strE2)) {
                                com.google.android.libraries.navigation.internal.yx.ar.f(com.google.android.libraries.navigation.internal.yx.aq.c(strE3), "missing service name for method %s", strE3);
                                com.google.android.libraries.navigation.internal.yx.ar.f(daVar == null, "Duplicate default method config in service config %s", map);
                                daVar = daVar2;
                            } else if (com.google.android.libraries.navigation.internal.yx.aq.c(strE3)) {
                                com.google.android.libraries.navigation.internal.yx.ar.f(!map4.containsKey(strE2), "Duplicate service %s", strE2);
                                map4.put(strE2, daVar2);
                            } else {
                                com.google.android.libraries.navigation.internal.yx.ar.r(strE2, "fullServiceName");
                                com.google.android.libraries.navigation.internal.yx.ar.r(strE3, "methodName");
                                String str3 = strE2 + RemoteSettings.FORWARD_SLASH_STRING + strE3;
                                com.google.android.libraries.navigation.internal.yx.ar.f(!map3.containsKey(str3), "Duplicate method name %s", str3);
                                map3.put(str3, daVar2);
                            }
                            z = z2;
                        }
                    }
                }
                dcVar = new dc(daVar, map3, map4, edVar, obj, mapI2);
            }
            return new com.google.android.libraries.navigation.internal.afx.bs(dcVar);
        } catch (RuntimeException e2) {
            return new com.google.android.libraries.navigation.internal.afx.bs(com.google.android.libraries.navigation.internal.afx.cl.c.b("failed to parse service config").a(e2));
        }
    }
}
