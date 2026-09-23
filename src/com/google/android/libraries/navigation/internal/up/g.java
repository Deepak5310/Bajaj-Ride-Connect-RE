package com.google.android.libraries.navigation.internal.up;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aap.l;
import com.google.android.libraries.navigation.internal.adr.bc;
import com.google.android.libraries.navigation.internal.adr.bg;
import com.google.android.libraries.navigation.internal.adr.bh;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bs;
import com.google.android.libraries.navigation.internal.bp.ca;
import com.google.android.libraries.navigation.internal.gz.i;
import com.google.android.libraries.navigation.internal.qz.k;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bj;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class g {
    static final int a;
    static final int b;
    static final int c;
    static final int d;
    private static final j f = j.e("com.google.android.libraries.navigation.internal.up.g");
    public final Application e;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private final HashSet h;
    private final HashSet i;
    private Drawable j;
    private bs k;

    static {
        int i = com.google.android.libraries.navigation.internal.dw.h.J;
        a = i;
        int i2 = com.google.android.libraries.navigation.internal.dw.h.k;
        b = i2;
        int i3 = com.google.android.libraries.navigation.internal.dw.h.a;
        c = i3;
        d = com.google.android.libraries.navigation.internal.dw.h.i;
        ez ezVar = new ez();
        ezVar.f(bg.TYPE_TOWARD_NAME, Integer.valueOf(i));
        ezVar.f(bg.TYPE_TOWARD_ROAD_NAME, Integer.valueOf(i));
        ezVar.f(bg.TYPE_TO_ROAD_NAME, Integer.valueOf(i2));
        ezVar.f(bg.TYPE_AT_ROAD_NAME, Integer.valueOf(i3));
        ezVar.f(bg.TYPE_INTERSECTION, Integer.valueOf(i3));
        ezVar.f(bg.TYPE_EXIT_NUMBER, Integer.valueOf(i2));
        ezVar.f(bg.TYPE_EXIT_NAME, Integer.valueOf(i2));
        ezVar.f(bg.TYPE_FOLLOW_ROAD_NAME, 0);
        ezVar.f(bg.TYPE_FROM_ROAD_NAME, 0);
        ezVar.f(bg.TYPE_TITLE, Integer.valueOf(i));
        ezVar.f(bg.TYPE_ADDRESS, Integer.valueOf(i));
        ezVar.f(bg.TYPE_TRANSIT_SIGNPOST, 0);
        ezVar.f(bg.TYPE_TRANSIT_ENTRANCE_NAME, 0);
        ezVar.f(bg.TYPE_TRANSIT_EXIT_NAME, 0);
        ezVar.d();
    }

    public g(Application application, com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.e = application;
        this.g = aVar;
        this.i = i(application, com.google.android.libraries.navigation.internal.dw.h.m);
        this.h = i(application, com.google.android.libraries.navigation.internal.dw.h.f419n);
    }

    static void b(bs bsVar, f fVar, Drawable drawable, String str) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TextFormatter.makeCueWithIcon");
        try {
            String upperCase = aq.c(bsVar.e()) ? "" : bsVar.e().toUpperCase(Locale.getDefault());
            if (str != null) {
                fVar.j(str, bsVar.g(), upperCase, drawable);
            } else {
                fVar.c(bsVar.g(), upperCase, bsVar.b(), drawable);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static e f(Context context, bq bqVar, int i) {
        Collection collection;
        Collection collection2;
        int iH;
        Collection collectionQ;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TextFormatter.getCuesToDisplay");
        try {
            HashSet hashSet = new HashSet();
            Collection collectionA = d.a(bqVar.y, hashSet);
            ArrayList arrayList = new ArrayList();
            bs bsVar = bqVar.u;
            bs bsVar2 = bqVar.v;
            if (bsVar != null || bsVar2 != null) {
                if (bsVar != null) {
                    hashSet.add(bsVar.g());
                }
                if (bsVar2 != null) {
                    hashSet.add(bsVar2.g());
                }
                arrayList.add(a(context, bqVar));
            }
            arrayList.addAll(d.a(bqVar.w, hashSet));
            Collection collectionA2 = d.a(bqVar.x, hashSet);
            boolean zIsEmpty = collectionA.isEmpty();
            boolean zIsEmpty2 = arrayList.isEmpty();
            boolean z = true;
            if (!zIsEmpty) {
                collection = true != zIsEmpty2 ? arrayList : collectionA2;
                collection2 = collectionA;
            } else if (zIsEmpty2) {
                collection = arrayList;
                collection2 = collectionA2;
            } else {
                collection = collectionA2;
                collection2 = arrayList;
            }
            int iH2 = 0;
            boolean z2 = collection2 == collectionA2;
            boolean z3 = collection2 == collectionA;
            boolean z4 = collection == collectionA2;
            Collection collection3 = collection;
            Collection collection4 = collection2;
            if (i == 3) {
                if (!collection2.isEmpty()) {
                    collectionQ = collection2;
                    collectionQ = ev.q((bs) collection2.iterator().next());
                }
                collectionQ = collection2;
                int i2 = ev.d;
                collection3 = lv.a;
                collection4 = collectionQ;
            }
            if (!collection3.isEmpty()) {
                int iH3 = h(bqVar, false, false, false);
                if (i == 1) {
                    z = false;
                }
                iH = h(bqVar, z4, z, z3);
                iH2 = iH3;
            } else if (collection4.isEmpty()) {
                iH = 0;
            } else {
                iH2 = h(bqVar, z2, false, false);
                iH = 0;
            }
            e eVar = new e(collection4, collection3, iH2, iH);
            if (dVarB != null) {
                Trace.endSection();
            }
            return eVar;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static int h(bq bqVar, boolean z, boolean z2, boolean z3) {
        l lVar = bqVar.d;
        if (z) {
            if (lVar == l.DEPART || z3 || ca.d(lVar)) {
                return a;
            }
        } else {
            if (lVar == l.UTURN) {
                return c;
            }
            if (z3) {
                return b;
            }
        }
        if (z2) {
            return d;
        }
        return 0;
    }

    private static HashSet i(Context context, int i) {
        Iterable iterableG = bj.b(',').g(context.getString(i));
        HashSet hashSet = new HashSet();
        Iterator it2 = iterableG.iterator();
        while (it2.hasNext()) {
            hashSet.add(((String) it2.next()).trim());
        }
        return hashSet;
    }

    private static boolean j(bs bsVar) {
        return bsVar.f() != null || bsVar.h();
    }

    public final void c(bq bqVar, f fVar) {
        bs bsVarB = bqVar.b();
        if ((bqVar.e() || bqVar.v != null) && (bsVarB == null || bsVarB.f() == null)) {
            bsVarB = a(this.e, bqVar);
        } else if (bsVarB == null) {
            bsVarB = null;
        }
        if (bsVarB == null || !bsVarB.h()) {
            fVar.g(com.google.android.libraries.navigation.internal.bl.d.f(bqVar));
            fVar.a(StringUtils.SPACE);
        }
        if (bsVarB != null) {
            e(ev.q(bsVarB), bqVar.d == l.UTURN ? c : 0, true, null, fVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:163:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x006f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072 A[Catch: all -> 0x00e2, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00e2, blocks: (B:4:0x000b, B:6:0x0011, B:29:0x0072, B:73:0x00e9, B:74:0x00ee, B:76:0x00f5, B:83:0x012d, B:91:0x013d, B:90:0x013a, B:92:0x013e, B:129:0x01bf, B:140:0x01d5, B:139:0x01d2, B:37:0x0082, B:36:0x007f, B:38:0x0083, B:40:0x0089, B:48:0x0095, B:57:0x00cf, B:58:0x00d3, B:64:0x00dc, B:54:0x00be, B:55:0x00c4, B:56:0x00ca, B:67:0x00df, B:136:0x01cd, B:77:0x0103, B:79:0x0107, B:81:0x0118, B:80:0x0110, B:7:0x0017, B:9:0x0021, B:11:0x0044, B:13:0x004a, B:15:0x0051, B:18:0x005f, B:26:0x006e, B:25:0x006b, B:87:0x0135, B:59:0x00d4, B:60:0x00d8, B:93:0x0148, B:95:0x0152, B:97:0x0158, B:110:0x017d, B:111:0x0181, B:114:0x018b, B:120:0x019f, B:122:0x01a6, B:124:0x01ac, B:126:0x01b2, B:127:0x01b6, B:101:0x0161, B:104:0x0169, B:106:0x0175, B:41:0x008a, B:43:0x008e, B:45:0x0092, B:47:0x0094, B:33:0x007a), top: B:151:0x000b, inners: #0, #1, #4, #5, #6, #8, #10, #11 }] */
    final void d(bs bsVar, boolean z, com.google.android.libraries.navigation.internal.qz.g gVar, f fVar) {
        String strF;
        Drawable drawableA;
        int i;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TextFormatter.makeStepCue");
        if (z) {
            try {
                strF = bsVar.f();
                if (strF != null) {
                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("TextFormatter.makeRoadName-icon");
                    try {
                        com.google.android.libraries.navigation.internal.qy.h hVar = (com.google.android.libraries.navigation.internal.qy.h) this.g.a();
                        if (hVar != null) {
                            k kVarD = hVar.d(strF, getClass().getName() + "#formatStepCue()", gVar);
                            if (kVarD.p() && (kVarD.a() == 3 || kVarD.a() == 6)) {
                                com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("TextFormatter.makeRoadName-drawable");
                                try {
                                    drawableA = kVarD.e(this.e);
                                    if (dVarB3 != null) {
                                        Trace.endSection();
                                    }
                                } catch (Throwable th) {
                                    if (dVarB3 != null) {
                                        try {
                                            Trace.endSection();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } else {
                                drawableA = null;
                            }
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                        } else {
                            drawableA = null;
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                        }
                    } catch (Throwable th3) {
                        if (dVarB2 != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } else if (bsVar.h()) {
                    synchronized (this) {
                        drawableA = this.j;
                        if (drawableA == null || this.k != bsVar) {
                            TextView textView = (TextView) ((LayoutInflater) this.e.getSystemService("layout_inflater")).inflate(com.google.android.libraries.navigation.internal.dw.e.d, (ViewGroup) null);
                            textView.setText(bsVar.g());
                            int iOrdinal = bsVar.b().ordinal();
                            if (iOrdinal == 0) {
                                textView.setBackgroundResource(com.google.android.libraries.navigation.internal.dw.c.e);
                            } else if (iOrdinal == 1) {
                                textView.setBackgroundResource(com.google.android.libraries.navigation.internal.dw.c.f);
                            } else if (iOrdinal == 2) {
                                textView.setBackgroundResource(com.google.android.libraries.navigation.internal.dw.c.g);
                            }
                            drawableA = com.google.android.libraries.navigation.internal.kj.c.a(textView);
                            synchronized (this) {
                                this.j = drawableA;
                                this.k = bsVar;
                            }
                        }
                    }
                } else {
                    drawableA = null;
                }
            } catch (Throwable th5) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } else {
            strF = null;
            drawableA = null;
        }
        if (drawableA != null) {
            b(bsVar, fVar, drawableA, strF);
        } else if (bsVar.h()) {
            bg bgVarD = bsVar.d();
            String strG = bsVar.g();
            com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("TextFormatter.makeRoadName");
            try {
                String string = bgVarD == bg.TYPE_EXIT_NUMBER ? this.e.getString(com.google.android.libraries.navigation.internal.dw.h.e) : this.e.getString(com.google.android.libraries.navigation.internal.dw.h.d);
                int iIndexOf = string.indexOf("{0}");
                fVar.m(string.substring(0, iIndexOf), strG, string.substring(iIndexOf + 3));
                if (dVarB4 != null) {
                    Trace.endSection();
                }
            } catch (Throwable th7) {
                if (dVarB4 != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                    }
                }
                throw th7;
            }
        } else {
            String strG2 = bsVar.g();
            com.google.android.libraries.navigation.internal.nw.d dVarB5 = com.google.android.libraries.navigation.internal.nw.e.b("TextFormatter.makeRoadName");
            try {
                if (strG2.length() < 4 || strG2.charAt(1) != ' ' || strG2.charAt(3) != ' ') {
                    i = 0;
                    while (true) {
                        int iIndexOf2 = strG2.indexOf(32, i);
                        int i2 = (iIndexOf2 <= 0 || iIndexOf2 <= i || !this.i.contains(strG2.substring(i, iIndexOf2))) ? -1 : iIndexOf2 + 1;
                        if (i2 < 0) {
                            break;
                        } else {
                            i = i2;
                        }
                    }
                } else {
                    i = 0;
                }
                int length = strG2.length();
                while (true) {
                    int i3 = length - 1;
                    int iLastIndexOf = strG2.lastIndexOf(32, i3);
                    if (iLastIndexOf <= 0 || iLastIndexOf >= i3 || !this.h.contains(strG2.substring(iLastIndexOf + 1, length))) {
                        iLastIndexOf = -1;
                    }
                    if (iLastIndexOf < 0) {
                        break;
                    } else {
                        length = iLastIndexOf;
                    }
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    throw th5;
                }
                if (length <= i) {
                    length = strG2.length();
                    i = 0;
                }
                fVar.l(i > 0 ? strG2.substring(0, i) : null, strG2.substring(i, length), length < strG2.length() ? strG2.substring(length) : null);
                if (dVarB5 != null) {
                    Trace.endSection();
                }
            } catch (Throwable th9) {
                if (dVarB5 != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th10) {
                        th9.addSuppressed(th10);
                    }
                }
                throw th9;
            }
        }
        if (dVarB != null) {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005d A[Catch: all -> 0x008e, TryCatch #1 {all -> 0x008e, blocks: (B:3:0x0006, B:6:0x000e, B:8:0x0019, B:26:0x0053, B:27:0x0057, B:29:0x005d, B:31:0x0065, B:33:0x006b, B:39:0x007b, B:35:0x0071, B:40:0x007e, B:42:0x0085, B:10:0x001e, B:13:0x0024, B:15:0x0028, B:20:0x0039, B:22:0x0041, B:23:0x0049, B:25:0x004f, B:19:0x002f), top: B:55:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0065 A[Catch: all -> 0x008e, TryCatch #1 {all -> 0x008e, blocks: (B:3:0x0006, B:6:0x000e, B:8:0x0019, B:26:0x0053, B:27:0x0057, B:29:0x005d, B:31:0x0065, B:33:0x006b, B:39:0x007b, B:35:0x0071, B:40:0x007e, B:42:0x0085, B:10:0x001e, B:13:0x0024, B:15:0x0028, B:20:0x0039, B:22:0x0041, B:23:0x0049, B:25:0x004f, B:19:0x002f), top: B:55:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0085 A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #1 {all -> 0x008e, blocks: (B:3:0x0006, B:6:0x000e, B:8:0x0019, B:26:0x0053, B:27:0x0057, B:29:0x005d, B:31:0x0065, B:33:0x006b, B:39:0x007b, B:35:0x0071, B:40:0x007e, B:42:0x0085, B:10:0x001e, B:13:0x0024, B:15:0x0028, B:20:0x0039, B:22:0x0041, B:23:0x0049, B:25:0x004f, B:19:0x002f), top: B:55:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x007e A[SYNTHETIC] */
    public final void e(Collection collection, int i, boolean z, com.google.android.libraries.navigation.internal.qz.g gVar, f fVar) {
        String strSubstring;
        Iterator it2;
        bs bsVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TextFormatter.makeStepCues");
        try {
            if (!collection.isEmpty()) {
                Application application = this.e;
                int i2 = d;
                String string = application.getString(i2);
                bs bsVar2 = null;
                if (i == i2) {
                    fVar.a(string);
                } else {
                    String string2 = (i == a || i == b || i == c) ? this.e.getResources().getString(i) : "{0}";
                    int iIndexOf = string2.indexOf("{0}");
                    int i3 = iIndexOf + 3;
                    if (iIndexOf > 0) {
                        fVar.i(string2.substring(0, iIndexOf));
                    }
                    if (i3 < string2.length()) {
                        strSubstring = string2.substring(i3);
                    }
                    it2 = collection.iterator();
                    while (it2.hasNext()) {
                        bsVar = (bs) it2.next();
                        if (bsVar2 == null) {
                            fVar.a(((j(bsVar2) || bsVar2.e() != null) && !j(bsVar)) ? string : StringUtils.SPACE);
                        }
                        d(bsVar, z, gVar, fVar);
                        bsVar2 = bsVar;
                    }
                    if (strSubstring != null) {
                        fVar.h(strSubstring);
                    }
                }
                strSubstring = null;
                it2 = collection.iterator();
                while (it2.hasNext()) {
                    bsVar = (bs) it2.next();
                    if (bsVar2 == null) {
                        fVar.a(((j(bsVar2) || bsVar2.e() != null) && !j(bsVar)) ? string : StringUtils.SPACE);
                    }
                    d(bsVar, z, gVar, fVar);
                    bsVar2 = bsVar;
                }
                if (strSubstring != null) {
                    fVar.h(strSubstring);
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void g(bs bsVar, f fVar) {
        String string = this.e.getResources().getString(com.google.android.libraries.navigation.internal.dw.h.G);
        int iIndexOf = string.indexOf("{0}");
        int i = iIndexOf + 3;
        if (iIndexOf > 0) {
            fVar.e(string.substring(0, iIndexOf));
        }
        if (bsVar == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1909)).p("The road name step cue for a long step is null");
        } else {
            d(bsVar, true, null, fVar);
        }
        if (i < string.length()) {
            fVar.e(string.substring(i));
        }
    }

    static bs a(Context context, bq bqVar) {
        String strG;
        bs bsVar = bqVar.u;
        bs bsVar2 = bqVar.v;
        if (bsVar2 != null && bsVar != null) {
            String strG2 = bsVar2.g();
            String strG3 = bsVar.g();
            strG = i.a(context) ? String.format("%s %s", strG2, strG3) : String.format("%s %s", strG3, strG2);
        } else if (bsVar != null) {
            strG = bsVar.g();
        } else {
            if (bsVar2 == null) {
                throw new IllegalArgumentException("The Step has no exit number or exit name");
            }
            strG = bsVar2.g();
        }
        bc bcVar = (bc) bh.a.q();
        if (!bcVar.b.H()) {
            bcVar.v();
        }
        bh bhVar = (bh) bcVar.b;
        strG.getClass();
        bhVar.b |= 2;
        bhVar.d = strG;
        bg bgVar = bqVar.e() ? bg.TYPE_EXIT_NUMBER : bg.TYPE_EXIT_NAME;
        if (!bcVar.b.H()) {
            bcVar.v();
        }
        bh bhVar2 = (bh) bcVar.b;
        bhVar2.c = bgVar.o;
        bhVar2.b |= 1;
        bs bsVarC = bs.c((bh) bcVar.t(), bqVar.e);
        ar.q(bsVarC);
        return bsVarC;
    }
}
