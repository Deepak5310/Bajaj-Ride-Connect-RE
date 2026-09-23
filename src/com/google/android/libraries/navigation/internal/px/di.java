package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.adg.ho;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class di extends da {
    public static final di a = new di();
    private static final dh b = new dh();

    private di() {
        new dg(mb.a, mb.a);
    }

    public static com.google.android.libraries.navigation.internal.yx.an a(List list, fy fyVar) {
        if (!fyVar.isEmpty()) {
            String strF = f(list);
            nn nnVarListIterator = fyVar.listIterator();
            while (nnVarListIterator.hasNext()) {
                String str = (String) nnVarListIterator.next();
                if (strF.contains(str)) {
                    return com.google.android.libraries.navigation.internal.yx.an.j(str);
                }
            }
        }
        return com.google.android.libraries.navigation.internal.yx.a.a;
    }

    public static String b(hg hgVar, com.google.android.libraries.navigation.internal.yx.an anVar) {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(hgVar);
        akVarB.h();
        com.google.android.libraries.navigation.internal.adg.df dfVar = hgVar.d;
        if (dfVar == null) {
            dfVar = com.google.android.libraries.navigation.internal.adg.df.a;
        }
        com.google.android.libraries.navigation.internal.yx.ak akVarC = akVarB.c("use_case", dfVar.c);
        com.google.android.libraries.navigation.internal.adg.df dfVar2 = hgVar.d;
        if (dfVar2 == null) {
            dfVar2 = com.google.android.libraries.navigation.internal.adg.df.a;
        }
        if ((dfVar2.b & 2) != 0) {
            com.google.android.libraries.navigation.internal.adg.df dfVar3 = hgVar.d;
            if (dfVar3 == null) {
                dfVar3 = com.google.android.libraries.navigation.internal.adg.df.a;
            }
            com.google.android.libraries.navigation.internal.adg.dh dhVar = dfVar3.d;
            if (dhVar == null) {
                dhVar = com.google.android.libraries.navigation.internal.adg.dh.a;
            }
            String strF = f(dhVar.b);
            akVarC.g("subtitle", anVar.g() ? e(strF, (String) anVar.c()) : g(strF));
        }
        com.google.android.libraries.navigation.internal.adg.df dfVar4 = hgVar.d;
        if (dfVar4 == null) {
            dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
        }
        if ((dfVar4.b & 8) != 0) {
            com.google.android.libraries.navigation.internal.adg.df dfVar5 = hgVar.d;
            if (dfVar5 == null) {
                dfVar5 = com.google.android.libraries.navigation.internal.adg.df.a;
            }
            com.google.android.libraries.navigation.internal.adg.dd ddVar = dfVar5.f;
            if (ddVar == null) {
                ddVar = com.google.android.libraries.navigation.internal.adg.dd.a;
            }
            akVarC.c("boost", ddVar.b);
        }
        ho hoVar = hgVar.c;
        if (hoVar == null) {
            hoVar = ho.a;
        }
        if ((hoVar.b & 1) != 0) {
            ho hoVar2 = hgVar.c;
            if (hoVar2 == null) {
                hoVar2 = ho.a;
            }
            akVarC.g("fprint", Long.toHexString(hoVar2.c));
        } else {
            ho hoVar3 = hgVar.c;
            if (hoVar3 == null) {
                hoVar3 = ho.a;
            }
            if ((hoVar3.b & 2) != 0) {
                akVarC.e("hasPredicate", true);
            }
        }
        return akVarC.toString();
    }

    public static String c(com.google.android.libraries.navigation.internal.adg.ef efVar, com.google.android.libraries.navigation.internal.yx.an anVar) {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(efVar);
        akVarB.h();
        com.google.android.libraries.navigation.internal.adg.dt dtVar = efVar.c;
        if (dtVar == null) {
            dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        String strF = f(dtVar.c);
        com.google.android.libraries.navigation.internal.adg.dt dtVar2 = efVar.d;
        if (dtVar2 == null) {
            dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        String strF2 = f(dtVar2.c);
        if (!com.google.android.libraries.navigation.internal.yx.bp.c(strF2)) {
            if (com.google.android.libraries.navigation.internal.yx.bp.c(strF)) {
                strF = strF2;
            } else {
                strF = strF + StringUtils.SPACE + strF2;
            }
        }
        akVarB.g("text", anVar.g() ? e(strF, (String) anVar.c()) : g(strF));
        com.google.android.libraries.navigation.internal.yx.ak akVarC = akVarB.c("identityHash", System.identityHashCode(efVar));
        akVarC.g("fprint", Long.toHexString(com.google.android.libraries.navigation.internal.rb.a.a(efVar)));
        com.google.android.libraries.navigation.internal.yx.ak akVarC2 = akVarC.c("minZoom", efVar.j).c("rank", efVar.i);
        akVarC2.g("isRequired", h(com.google.android.libraries.navigation.internal.rb.a.h(1, efVar.h)));
        akVarC2.g("isSearchResult", h(com.google.android.libraries.navigation.internal.rb.a.i(efVar)));
        com.google.android.libraries.navigation.internal.ado.j jVarE = com.google.android.libraries.navigation.internal.rb.a.e(efVar);
        if (jVarE != null && (jVarE.b & 1) != 0) {
            com.google.android.libraries.navigation.internal.adq.ah ahVar = jVarE.c;
            if (ahVar == null) {
                ahVar = com.google.android.libraries.navigation.internal.adq.ah.a;
            }
            if (ahVar.e) {
                akVarB.e("counterFactual", true);
            }
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ac);
        efVar.h(bhVarS);
        Object objK = efVar.w.k(bhVarS.d);
        com.google.android.libraries.navigation.internal.adg.u uVar = (com.google.android.libraries.navigation.internal.adg.u) (objK == null ? bhVarS.b : bhVarS.c(objK));
        if (uVar.b.size() > 0) {
            TreeSet treeSet = new TreeSet();
            Iterator it2 = uVar.b.iterator();
            while (it2.hasNext()) {
                treeSet.add(Integer.valueOf(((com.google.android.libraries.navigation.internal.adg.ao) it2.next()).c));
            }
            akVarB.g("use_cases", treeSet);
        }
        return akVarB.toString();
    }

    public static boolean d(long j, fy fyVar) {
        if (fyVar.isEmpty()) {
            return false;
        }
        nn nnVarListIterator = fyVar.listIterator();
        while (nnVarListIterator.hasNext()) {
            String str = (String) nnVarListIterator.next();
            if (Long.toHexString(j).contains(str.toLowerCase(Locale.ROOT)) || Long.toString(j).contains(str)) {
                return true;
            }
        }
        return false;
    }

    static String e(String str, String str2) {
        int i;
        StringBuilder sb = new StringBuilder(22);
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf == -1) {
            return str.length() > 20 ? String.valueOf(str.substring(0, 19)).concat("…") : str;
        }
        int length = str2.length() + iIndexOf;
        int iD = com.google.android.libraries.navigation.internal.zy.i.d(3, (20 - str2.length()) / 2, (20 - (str.length() - length)) - str2.length());
        if (iIndexOf - iD <= 0) {
            i = iIndexOf;
        } else {
            sb.append("…");
            i = iD - 1;
        }
        sb.append((CharSequence) str, iIndexOf - i, iIndexOf);
        sb.append('|');
        sb.append(str2);
        sb.append('|');
        int iMax = Math.max(3, 20 - (sb.length() - 2)) + length;
        if (iMax >= str.length()) {
            sb.append((CharSequence) str, length, str.length());
        } else {
            sb.append((CharSequence) str, length, iMax - 1);
            sb.append("…");
        }
        return sb.toString();
    }

    private static String f(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.adg.dp dpVar = (com.google.android.libraries.navigation.internal.adg.dp) it2.next();
            if ((dpVar.b & 32) != 0) {
                sb.append(' ');
            }
            if ((dpVar.b & 1) != 0) {
                sb.append(dpVar.c);
            }
        }
        return sb.toString();
    }

    private static String g(String str) {
        return str.length() > 20 ? String.valueOf(str.substring(0, 19)).concat("…") : str;
    }

    private static String h(boolean z) {
        return true != z ? "N" : "Y";
    }
}
