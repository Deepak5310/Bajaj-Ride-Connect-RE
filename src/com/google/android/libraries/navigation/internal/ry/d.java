package com.google.android.libraries.navigation.internal.ry;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.bp.bs;
import com.google.android.libraries.navigation.internal.dw.h;
import com.google.android.libraries.navigation.internal.sa.f;
import com.google.android.libraries.navigation.internal.sa.g;
import com.google.android.libraries.navigation.internal.yx.bj;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.google.android.libraries.navigation.internal.rx.a {
    private static final int c = h.J;
    private static final int d = h.k;
    private static final int e = h.a;
    private static final int f = h.i;
    public final Context a;
    public final c b = new c();
    private final Set g;
    private final Set h;

    public d(Context context) {
        this.a = context;
        this.g = b(context, h.m);
        this.h = b(context, h.f419n);
    }

    private static Set b(Context context, int i) {
        Iterable iterableG = bj.b(',').g(context.getString(i));
        HashSet hashSet = new HashSet();
        Iterator it2 = iterableG.iterator();
        while (it2.hasNext()) {
            hashSet.add(((String) it2.next()).trim());
        }
        return hashSet;
    }

    private static boolean c(bs bsVar) {
        return bsVar.f() != null || bsVar.h();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:30:0x006b  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:61:0x0105 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:65:0x0116  */
    /* JADX WARN: Code duplicated, block: B:67:0x0119 A[LOOP:2: B:59:0x00ff->B:67:0x0119, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x0138  */
    /* JADX WARN: Code duplicated, block: B:78:0x013d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0144  */
    /* JADX WARN: Code duplicated, block: B:81:0x0149  */
    /* JADX WARN: Code duplicated, block: B:84:0x0150  */
    /* JADX WARN: Code duplicated, block: B:85:0x0155  */
    /* JADX WARN: Code duplicated, block: B:88:0x0160 A[LOOP:1: B:69:0x011f->B:88:0x0160, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x0164  */
    /* JADX WARN: Code duplicated, block: B:97:0x013b A[EDGE_INSN: B:97:0x013b->B:77:0x013b BREAK  A[LOOP:1: B:69:0x011f->B:88:0x0160], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x011b A[EDGE_INSN: B:98:0x011b->B:68:0x011b BREAK  A[LOOP:2: B:59:0x00ff->B:67:0x0119], SYNTHETIC] */
    public final com.google.android.libraries.navigation.internal.sa.h a(Collection collection, int i) {
        String strSubstring;
        Iterator it2;
        bs bsVar;
        bs bsVar2;
        String strF;
        String strE;
        String upperCase;
        String strG;
        int i2;
        int iIndexOf;
        int i3;
        int length;
        int iLastIndexOf;
        String strSubstring2;
        String strSubstring3;
        a aVar = new a();
        if (collection.isEmpty()) {
            return com.google.android.libraries.navigation.internal.sa.h.f().a();
        }
        Context context = this.a;
        int i4 = f;
        String string = context.getString(i4);
        if (i != i4) {
            String string2 = (i == c || i == d || i == e) ? this.a.getResources().getString(i) : "{0}";
            int iIndexOf2 = string2.indexOf("{0}");
            int i5 = iIndexOf2 + 3;
            if (iIndexOf2 > 0) {
                aVar.i(string2.substring(0, iIndexOf2));
            }
            if (i5 < string2.length()) {
                strSubstring = string2.substring(i5);
            }
            it2 = collection.iterator();
            bsVar = null;
            while (it2.hasNext()) {
                bsVar2 = (bs) it2.next();
                if (bsVar != null) {
                    aVar.e = ((c(bsVar) || bsVar.e() != null) && !c(bsVar2)) ? string : StringUtils.SPACE;
                }
                strF = bsVar2.f();
                strE = bsVar2.e();
                if (strE != null || strE.isEmpty()) {
                    upperCase = "";
                } else {
                    upperCase = strE.toUpperCase(Locale.getDefault());
                }
                if (strF != null) {
                    String strG2 = bsVar2.g();
                    com.google.android.libraries.navigation.internal.sa.e eVarB = f.b();
                    aVar.k(eVarB, strF, strG2);
                    aVar.n(eVarB, upperCase, false);
                    aVar.f.h(eVarB.a());
                    aVar.g = 3;
                } else if (bsVar2.h()) {
                    String strG3 = bsVar2.g();
                    hs hsVarB = bsVar2.b();
                    com.google.android.libraries.navigation.internal.sa.e eVarB2 = f.b();
                    aVar.d(eVarB2, strG3, hsVarB);
                    aVar.n(eVarB2, upperCase, false);
                    aVar.f.h(eVarB2.a());
                    aVar.g = 1;
                } else {
                    strG = bsVar2.g();
                    if (strG.length() < 4 || strG.charAt(1) != ' ' || strG.charAt(3) != ' ') {
                        i2 = 0;
                        while (true) {
                            iIndexOf = strG.indexOf(32, i2);
                            if (iIndexOf > 0 || iIndexOf <= i2 || !this.g.contains(strG.substring(i2, iIndexOf))) {
                                i3 = -1;
                            } else {
                                i3 = iIndexOf + 1;
                            }
                            if (i3 < 0) {
                                break;
                            }
                            i2 = i3;
                        }
                    } else {
                        i2 = 0;
                    }
                    length = strG.length();
                    while (true) {
                        int i6 = length - 1;
                        iLastIndexOf = strG.lastIndexOf(32, i6);
                        if (iLastIndexOf > 0 || iLastIndexOf >= i6 || !this.h.contains(strG.substring(iLastIndexOf + 1, length))) {
                            iLastIndexOf = -1;
                        }
                        if (iLastIndexOf < 0) {
                            break;
                        }
                        length = iLastIndexOf;
                    }
                    if (length <= i2) {
                        length = strG.length();
                        i2 = 0;
                    }
                    if (i2 > 0) {
                        strSubstring2 = strG.substring(0, i2);
                    } else {
                        strSubstring2 = null;
                    }
                    if (length < strG.length()) {
                        strSubstring3 = strG.substring(length);
                    } else {
                        strSubstring3 = null;
                    }
                    aVar.l(strSubstring2, strG.substring(i2, length), strSubstring3);
                }
                bsVar = bsVar2;
            }
            if (strSubstring != null) {
                aVar.h(strSubstring);
            }
            g gVarF = com.google.android.libraries.navigation.internal.sa.h.f();
            gVarF.f(aVar.a);
            gVarF.e(aVar.b);
            gVarF.d(aVar.c);
            gVarF.c(aVar.d);
            gVarF.g(aVar.f.g());
            return gVarF.a();
        }
        aVar.e = string;
        strSubstring = null;
        it2 = collection.iterator();
        bsVar = null;
        while (it2.hasNext()) {
            bsVar2 = (bs) it2.next();
            if (bsVar != null) {
                aVar.e = ((c(bsVar) || bsVar.e() != null) && !c(bsVar2)) ? string : StringUtils.SPACE;
            }
            strF = bsVar2.f();
            strE = bsVar2.e();
            if (strE != null) {
                upperCase = "";
            } else {
                upperCase = "";
            }
            if (strF != null) {
                String strG4 = bsVar2.g();
                com.google.android.libraries.navigation.internal.sa.e eVarB3 = f.b();
                aVar.k(eVarB3, strF, strG4);
                aVar.n(eVarB3, upperCase, false);
                aVar.f.h(eVarB3.a());
                aVar.g = 3;
            } else if (bsVar2.h()) {
                String strG5 = bsVar2.g();
                hs hsVarB2 = bsVar2.b();
                com.google.android.libraries.navigation.internal.sa.e eVarB4 = f.b();
                aVar.d(eVarB4, strG5, hsVarB2);
                aVar.n(eVarB4, upperCase, false);
                aVar.f.h(eVarB4.a());
                aVar.g = 1;
            } else {
                strG = bsVar2.g();
                if (strG.length() < 4) {
                    i2 = 0;
                    while (true) {
                        iIndexOf = strG.indexOf(32, i2);
                        if (iIndexOf > 0) {
                            i3 = -1;
                        } else {
                            i3 = -1;
                        }
                        if (i3 < 0) {
                            break;
                            break;
                        }
                        i2 = i3;
                    }
                } else {
                    i2 = 0;
                    while (true) {
                        iIndexOf = strG.indexOf(32, i2);
                        if (iIndexOf > 0) {
                            i3 = -1;
                        } else {
                            i3 = -1;
                        }
                        if (i3 < 0) {
                            break;
                            break;
                        }
                        i2 = i3;
                    }
                }
                length = strG.length();
                while (true) {
                    int i7 = length - 1;
                    iLastIndexOf = strG.lastIndexOf(32, i7);
                    if (iLastIndexOf > 0) {
                        iLastIndexOf = -1;
                    } else {
                        iLastIndexOf = -1;
                    }
                    if (iLastIndexOf < 0) {
                        break;
                        break;
                    }
                    length = iLastIndexOf;
                }
                if (length <= i2) {
                    length = strG.length();
                    i2 = 0;
                }
                if (i2 > 0) {
                    strSubstring2 = strG.substring(0, i2);
                } else {
                    strSubstring2 = null;
                }
                if (length < strG.length()) {
                    strSubstring3 = strG.substring(length);
                } else {
                    strSubstring3 = null;
                }
                aVar.l(strSubstring2, strG.substring(i2, length), strSubstring3);
            }
            bsVar = bsVar2;
        }
        if (strSubstring != null) {
            aVar.h(strSubstring);
        }
        g gVarF2 = com.google.android.libraries.navigation.internal.sa.h.f();
        gVarF2.f(aVar.a);
        gVarF2.e(aVar.b);
        gVarF2.d(aVar.c);
        gVarF2.c(aVar.d);
        gVarF2.g(aVar.f.g());
        return gVarF2.a();
    }
}
