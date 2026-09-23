package com.google.android.libraries.navigation.internal.xt;

import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.gj;
import com.google.android.libraries.navigation.internal.yz.lg;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class br {
    public final String a;
    public final com.google.android.libraries.navigation.internal.ael.x b;
    public final fy c;
    public final fd d;
    public final bq e;

    /* JADX WARN: Code duplicated, block: B:116:0x0287  */
    public br(com.google.android.libraries.navigation.internal.xs.k kVar, bq bqVar) {
        com.google.android.libraries.navigation.internal.xs.g gVar;
        fd fdVarC;
        long j;
        if (kVar.b.b.isEmpty()) {
            com.google.android.libraries.navigation.internal.xs.c.a.equals(kVar.c);
        }
        this.a = kVar.c();
        this.b = kVar.c.c;
        kVar.b();
        kVar.a();
        Map mapUnmodifiableMap = kVar.c.f.size() == 0 ? null : Collections.unmodifiableMap(kVar.c.f);
        this.c = mapUnmodifiableMap != null ? fy.o(mapUnmodifiableMap.keySet()) : mb.a;
        if (kVar.c.f.size() > 0) {
            gVar = kVar.b;
            Collection<com.google.android.libraries.navigation.internal.xp.k> collectionValues = Collections.unmodifiableMap(kVar.c.f).values();
            int i = 0;
            if (collectionValues == null) {
                fdVarC = ma.b;
            } else {
                ez ezVar = new ez();
                for (com.google.android.libraries.navigation.internal.xp.k kVar2 : collectionValues) {
                    int iA = com.google.android.libraries.navigation.internal.xp.j.a(kVar2.c);
                    int i2 = iA - 1;
                    if (iA == 0) {
                        throw null;
                    }
                    if (i2 == 0) {
                        ezVar.f(kVar2.e, Long.valueOf(kVar2.c == 1 ? ((Long) kVar2.d).longValue() : 0L));
                    } else if (i2 == 1) {
                        ezVar.f(kVar2.e, Boolean.valueOf(kVar2.c == 2 ? ((Boolean) kVar2.d).booleanValue() : false));
                    } else if (i2 == 2) {
                        ezVar.f(kVar2.e, Double.valueOf(kVar2.c == 3 ? ((Double) kVar2.d).doubleValue() : 0.0d));
                    } else if (i2 == 3) {
                        ezVar.f(kVar2.e, kVar2.c == 4 ? (String) kVar2.d : "");
                    } else {
                        if (i2 != 4) {
                            throw new IllegalStateException("Could not serialize Flag for override: ".concat(String.valueOf(kVar2.e)));
                        }
                        ezVar.f(kVar2.e, (kVar2.c == 5 ? (com.google.android.libraries.navigation.internal.ael.x) kVar2.d : com.google.android.libraries.navigation.internal.ael.x.b).B());
                    }
                }
                fdVarC = ezVar.c();
            }
            if (!fdVarC.isEmpty()) {
                HashMap map = new HashMap(fdVarC);
                gj gjVar = new gj(lg.a);
                nn nnVarE = gVar.b.listIterator();
                while (nnVarE.hasNext()) {
                    com.google.android.libraries.navigation.internal.xs.f fVar = (com.google.android.libraries.navigation.internal.xs.f) nnVarE.next();
                    Object objRemove = map.remove(fVar.b());
                    if (objRemove == null) {
                        gjVar.n(fVar);
                    } else if (objRemove instanceof String) {
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(fVar.a, fVar.b, 4, 0L, objRemove));
                    } else if (objRemove instanceof byte[]) {
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(fVar.a, fVar.b, 5, 0L, objRemove));
                    } else if (objRemove instanceof Boolean) {
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(fVar.a, fVar.b, ((Boolean) objRemove).booleanValue() ? 1 : 0, 0L, null));
                    } else if (objRemove instanceof Long) {
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(fVar.a, fVar.b, 2, ((Long) objRemove).longValue(), null));
                    } else {
                        if (!(objRemove instanceof Double)) {
                            throw new IllegalStateException("Cannot serialize override for existing flag " + fVar.b() + ": " + objRemove.toString());
                        }
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(fVar.a, fVar.b, 3, Double.doubleToRawLongBits(((Double) objRemove).doubleValue()), null));
                    }
                }
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    int length = str.length();
                    if (length > 19 || length == 0) {
                        j = 0;
                        break;
                    }
                    long jCharAt = str.charAt(i) - '0';
                    if (jCharAt < 1 || jCharAt > 9) {
                        j = 0;
                        break;
                    }
                    int i3 = 1;
                    while (true) {
                        if (i3 >= length) {
                            if (jCharAt >= 0 && jCharAt <= 2305843009213693951L) {
                                j = jCharAt;
                                break;
                            }
                            break;
                        }
                        int iCharAt = str.charAt(i3) - '0';
                        if (!((iCharAt < 0) | (iCharAt > 9))) {
                            jCharAt = (jCharAt * 10) + ((long) iCharAt);
                            i3++;
                        }
                        j = 0;
                        break;
                    }
                    String str2 = j == 0 ? str : null;
                    if (obj instanceof String) {
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(j, str2, 4, 0L, obj));
                    } else if (obj instanceof byte[]) {
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(j, str2, 5, 0L, obj));
                    } else if (obj instanceof Boolean) {
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(j, str2, ((Boolean) obj).booleanValue() ? 1 : 0, 0L, null));
                    } else if (obj instanceof Long) {
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(j, str2, 2, ((Long) obj).longValue(), null));
                    } else {
                        if (!(obj instanceof Double)) {
                            throw new IllegalStateException("Cannot serialize override " + str + ": " + String.valueOf(obj));
                        }
                        gjVar.n(new com.google.android.libraries.navigation.internal.xs.f(j, str2, 3, Double.doubleToRawLongBits(((Double) obj).doubleValue()), null));
                    }
                    i = 0;
                }
                gVar = new com.google.android.libraries.navigation.internal.xs.g(gjVar.i());
            }
        } else {
            gVar = kVar.b;
        }
        ez ezVarH = fd.h(gVar.b.size() + 3);
        nn nnVarE2 = gVar.b.listIterator();
        while (nnVarE2.hasNext()) {
            com.google.android.libraries.navigation.internal.xs.f fVar2 = (com.google.android.libraries.navigation.internal.xs.f) nnVarE2.next();
            ezVarH.f(fVar2.b(), fVar2.a());
        }
        ezVarH.f("__phenotype_server_token", kVar.b());
        ezVarH.f("__phenotype_snapshot_token", kVar.c());
        ezVarH.f("__phenotype_configuration_version", Long.valueOf(kVar.a()));
        this.d = ezVarH.c();
        this.e = bqVar;
    }

    static br a(bu buVar) {
        return new br(buVar, new bq());
    }

    public br(bu buVar, bq bqVar) {
        int i;
        com.google.android.libraries.navigation.internal.ael.x xVar;
        String str;
        bu.a.equals(buVar);
        this.a = buVar.c;
        this.b = buVar.d;
        String str2 = buVar.e;
        long j = buVar.f;
        this.c = mb.a;
        ez ezVarH = fd.h(buVar.g.size() + 3);
        for (bx bxVar : buVar.g) {
            int i2 = bxVar.c;
            if (i2 == 0) {
                i = bw.f;
            } else if (i2 == 2) {
                i = bw.a;
            } else if (i2 == 3) {
                i = bw.b;
            } else if (i2 == 4) {
                i = bw.c;
            } else if (i2 != 5) {
                i = i2 != 6 ? 0 : bw.e;
            } else {
                i = bw.d;
            }
            if (i == 0) {
                throw null;
            }
            int i3 = i - 1;
            if (i3 == 0) {
                ezVarH.f(bxVar.e, Long.valueOf(bxVar.c == 2 ? ((Long) bxVar.d).longValue() : 0L));
            } else if (i3 == 1) {
                ezVarH.f(bxVar.e, Boolean.valueOf(bxVar.c == 3 ? ((Boolean) bxVar.d).booleanValue() : false));
            } else if (i3 == 2) {
                ezVarH.f(bxVar.e, Double.valueOf(bxVar.c == 4 ? ((Double) bxVar.d).doubleValue() : 0.0d));
            } else if (i3 == 3) {
                String str3 = bxVar.e;
                if (bxVar.c == 5) {
                    str = (String) bxVar.d;
                } else {
                    str = "";
                }
                ezVarH.f(str3, str);
            } else if (i3 == 4) {
                String str4 = bxVar.e;
                if (bxVar.c == 6) {
                    xVar = (com.google.android.libraries.navigation.internal.ael.x) bxVar.d;
                } else {
                    xVar = com.google.android.libraries.navigation.internal.ael.x.b;
                }
                ezVarH.f(str4, xVar.B());
            }
        }
        ezVarH.f("__phenotype_server_token", buVar.e);
        ezVarH.f("__phenotype_snapshot_token", buVar.c);
        ezVarH.f("__phenotype_configuration_version", Long.valueOf(buVar.f));
        this.d = ezVarH.c();
        this.e = bqVar;
    }
}
