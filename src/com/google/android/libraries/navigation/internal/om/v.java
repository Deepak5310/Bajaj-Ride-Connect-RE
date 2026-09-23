package com.google.android.libraries.navigation.internal.om;

import com.google.android.libraries.navigation.internal.ace.fn;
import com.google.android.libraries.navigation.internal.ace.fr;
import com.google.android.libraries.navigation.internal.ace.fs;
import com.google.android.libraries.navigation.internal.ace.ga;
import com.google.android.libraries.navigation.internal.ace.gc;
import com.google.android.libraries.navigation.internal.ace.gf;
import com.google.android.libraries.navigation.internal.ace.gk;
import com.google.android.libraries.navigation.internal.ace.gl;
import com.google.android.libraries.navigation.internal.ace.gm;
import com.google.android.libraries.navigation.internal.adi.al;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.adi.bo;
import com.google.android.libraries.navigation.internal.adi.bp;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mp;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v {
    final Map a = new ConcurrentHashMap();
    public final Map b = new ConcurrentHashMap();
    public final fy c;
    private final fy d;
    private final boolean e;

    public v(t tVar) {
        this.d = tVar.a;
        this.c = tVar.b;
        this.e = tVar.c;
    }

    private final u i(String str) {
        return (u) this.a.computeIfAbsent(str, new Function() { // from class: com.google.android.libraries.navigation.internal.om.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new u();
            }
        });
    }

    public final String a(String str, an anVar) {
        return (String) d(str).get(anVar);
    }

    public final String b(String str, bo boVar) {
        if (!this.a.containsKey(str)) {
            return null;
        }
        String str2 = (String) ((u) this.a.get(str)).b.get(boVar);
        if (aq.c(str2)) {
            return null;
        }
        com.google.android.libraries.navigation.internal.zl.m mVar = com.google.android.libraries.navigation.internal.zl.h.a;
        return ((com.google.android.libraries.navigation.internal.zl.b) mVar).a(str2.toString().getBytes(StandardCharsets.UTF_8)).toString();
    }

    public final Map c() {
        return new HashMap(this.a);
    }

    public final Map d(String str) {
        final String strA;
        Set set;
        final EnumMap enumMap = new EnumMap(an.class);
        u uVar = (u) this.a.get(str);
        if (uVar != null && (strA = uVar.a(bo.ROADMAP)) != null && (set = (Set) this.b.get(strA)) != null) {
            new HashSet(set).forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.om.s
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    an anVarB = an.b(((al) obj).c);
                    if (anVarB == null) {
                        anVarB = an.UNKNOWN;
                    }
                    enumMap.put(anVarB, strA);
                }
            });
        }
        return enumMap;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0079  */
    public final boolean e(gm gmVar) {
        boolean z;
        boolean z2;
        bo boVar;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (gmVar == null) {
            return false;
        }
        if ((gmVar.b & 1) == 0) {
            z = false;
        } else {
            ga gaVar = gmVar.c;
            if (gaVar == null) {
                gaVar = ga.a;
            }
            boolean z6 = false;
            for (gc gcVar : gaVar.b) {
                String str = gcVar.d;
                if (!this.b.containsKey(str)) {
                    this.b.put(str, new HashSet());
                }
                Set set = (Set) this.b.get(str);
                al alVar = gcVar.c;
                if (alVar == null) {
                    alVar = al.a;
                }
                set.add(alVar);
                if (!this.e) {
                    Iterator it2 = gcVar.b.iterator();
                    while (it2.hasNext()) {
                        u uVarI = i((String) it2.next());
                        if (!str.equals(uVarI.a(bo.ROADMAP))) {
                            uVarI.b(bo.ROADMAP, str);
                            z6 = true;
                        }
                    }
                }
            }
            if (z6) {
                z = true;
            } else {
                z = false;
            }
        }
        if (this.e) {
            z2 = false;
            for (Map.Entry entry : Collections.unmodifiableMap(gmVar.e).entrySet()) {
                String str2 = (String) entry.getKey();
                gf gfVar = (gf) entry.getValue();
                u uVarI2 = i(str2);
                fw fwVar = new fw();
                for (gl glVar : gfVar.b) {
                    int iA = gk.a(glVar.b);
                    if (iA == 0) {
                        iA = gk.a;
                    }
                    int i = iA - 1;
                    if (iA == 0) {
                        throw null;
                    }
                    if (i == 1) {
                        boVar = bo.ROADMAP;
                    } else if (i == 2) {
                        boVar = bo.ROADMAP_DARK;
                    } else if (i != 3) {
                        boVar = i != 4 ? bo.UNKNOWN : bo.NAVIGATION_LOW_LIGHT;
                    } else {
                        boVar = bo.NAVIGATION;
                    }
                    if (g(boVar)) {
                        fwVar.c(boVar);
                        String str3 = glVar.c;
                        if (aq.c(str3) || str3.equals(uVarI2.b.get(boVar))) {
                            z3 = false;
                        } else {
                            uVarI2.b.put(boVar, str3);
                            z3 = true;
                        }
                        boolean z7 = z2 | z3;
                        String str4 = glVar.d;
                        if (aq.c(str4) || str4.equals(uVarI2.a(boVar))) {
                            z4 = false;
                        } else {
                            uVarI2.b(boVar, str4);
                            z4 = true;
                        }
                        z2 = z7 | z4;
                    }
                }
                fy fyVarI = fwVar.i();
                u uVarI3 = i(str2);
                nn it3 = mp.d(fy.o(uVarI3.b.keySet()), fyVarI).iterator();
                boolean z8 = false;
                while (it3.hasNext()) {
                    bo boVar2 = (bo) it3.next();
                    uVarI3.a.remove(boVar2);
                    uVarI3.b.remove(boVar2);
                    z8 = true;
                }
                z2 |= z8;
            }
        } else {
            for (Map.Entry entry2 : Collections.unmodifiableMap(gmVar.d).entrySet()) {
                String str5 = (String) entry2.getKey();
                bz<bp> bzVar = ((fs) entry2.getValue()).b;
                u uVarI4 = i(str5);
                for (bp bpVar : bzVar) {
                    int i2 = bpVar.b;
                    if ((i2 & 1) != 0 && (i2 & 2) != 0) {
                        bo boVarB = bo.b(bpVar.c);
                        if (boVarB == null) {
                            boVarB = bo.UNKNOWN;
                        }
                        if (boVarB.equals(bo.ROADMAP)) {
                            Map map = uVarI4.b;
                            bo boVarB2 = bo.b(bpVar.c);
                            if (boVarB2 == null) {
                                boVarB2 = bo.UNKNOWN;
                            }
                            if (!Objects.equals((String) map.get(boVarB2), bpVar.d)) {
                                Map map2 = uVarI4.b;
                                bo boVarB3 = bo.b(bpVar.c);
                                if (boVarB3 == null) {
                                    boVarB3 = bo.UNKNOWN;
                                }
                                map2.put(boVarB3, bpVar.d);
                                z5 = true;
                            }
                        }
                    }
                }
                fn fnVar = ((fs) entry2.getValue()).d;
                if (fnVar == null) {
                    fnVar = fn.a;
                }
                Integer numValueOf = Integer.valueOf(fnVar.c);
                fn fnVar2 = ((fs) entry2.getValue()).d;
                if (fnVar2 == null) {
                    fnVar2 = fn.a;
                }
                if ((fnVar2.b & 1) != 0 && !numValueOf.equals(uVarI4.c)) {
                    uVarI4.c = numValueOf;
                    z5 = true;
                }
                fr frVar = ((fs) entry2.getValue()).c;
                if (frVar == null) {
                    frVar = fr.a;
                }
                boolean z9 = frVar.b;
                if (uVarI4.c() && bzVar.isEmpty()) {
                    uVarI4.b.clear();
                    uVarI4.c = null;
                    z5 = true;
                }
            }
            z2 = z5;
        }
        return z | z2;
    }

    public final boolean f(String str) {
        if (this.a.containsKey(str)) {
            return ((u) this.a.get(str)).c() || !((u) this.a.get(str)).a.isEmpty();
        }
        return false;
    }

    public final boolean g(bo boVar) {
        return this.d.contains(boVar);
    }

    public final boolean h(String str) {
        if (this.a.containsKey(str)) {
            return ((u) this.a.get(str)).c();
        }
        return false;
    }
}
