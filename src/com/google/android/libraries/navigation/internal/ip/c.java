package com.google.android.libraries.navigation.internal.ip;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.google.android.libraries.navigation.internal.adi.aa;
import com.google.android.libraries.navigation.internal.adi.ab;
import com.google.android.libraries.navigation.internal.adi.af;
import com.google.android.libraries.navigation.internal.adi.bg;
import com.google.android.libraries.navigation.internal.adi.bh;
import com.google.android.libraries.navigation.internal.adi.bl;
import com.google.android.libraries.navigation.internal.fr.n;
import com.google.android.libraries.navigation.internal.gz.f;
import com.google.android.libraries.navigation.internal.iv.ac;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bj;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.iq.a {
    private final DisplayMetrics a;
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private final ac e;
    private final int f;

    public c(Context context, DisplayMetrics displayMetrics, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, ac acVar) {
        this.a = displayMetrics;
        this.b = aVar;
        this.c = aVar2;
        this.d = aVar3;
        this.e = acVar;
        this.f = n.b(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.iq.a
    public final ab a(af afVar, Locale locale) {
        boolean z;
        boolean z2;
        com.google.android.libraries.navigation.internal.adi.c cVar = com.google.android.libraries.navigation.internal.adi.c.COMPACT_MULTIZOOM_STYLE_TABLE;
        aa aaVar = (aa) ab.a.q();
        String string = ((com.google.android.libraries.navigation.internal.jb.c) this.d.a()).a().toString();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar = (ab) aaVar.b;
        string.getClass();
        abVar.b |= 64;
        abVar.h = string;
        String strB = com.google.android.libraries.navigation.internal.jb.b.b();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar2 = (ab) aaVar.b;
        abVar2.b |= 2;
        abVar2.d = strB;
        float f = this.a.density;
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar3 = (ab) aaVar.b;
        abVar3.b |= 1024;
        abVar3.l = f;
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar4 = (ab) aaVar.b;
        abVar4.b |= 4;
        abVar4.e = "prod";
        String language = locale.getLanguage();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar5 = (ab) aaVar.b;
        language.getClass();
        abVar5.b |= 1;
        abVar5.c = language;
        String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar6 = (ab) aaVar.b;
        strValueOf.getClass();
        abVar6.b |= 8;
        abVar6.f = strValueOf;
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar7 = (ab) aaVar.b;
        abVar7.p = cVar.d;
        abVar7.b |= 8192;
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab.d((ab) aaVar.b);
        int i = this.f;
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        ab abVar8 = (ab) aaVar.b;
        abVar8.b |= 2097152;
        abVar8.s = i2;
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar9 = (ab) aaVar.b;
        abVar9.b |= 16;
        abVar9.g = "GMM";
        String string2 = ((com.google.android.libraries.navigation.internal.jc.b) ((com.google.android.libraries.navigation.internal.jb.c) this.d.a()).b().c()).toString();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar10 = (ab) aaVar.b;
        string2.getClass();
        abVar10.b |= 128;
        abVar10.i = string2;
        String strB2 = com.google.android.libraries.navigation.internal.jd.a.b((com.google.android.libraries.navigation.internal.jb.c) this.d.a());
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar11 = (ab) aaVar.b;
        abVar11.b |= 131072;
        abVar11.r = strB2;
        String strB3 = ((com.google.android.libraries.navigation.internal.fu.a) this.c.a()).b();
        if (!strB3.isEmpty()) {
            if (!aaVar.b.H()) {
                aaVar.v();
            }
            ab abVar12 = (ab) aaVar.b;
            strB3.getClass();
            abVar12.b |= 512;
            abVar12.k = strB3;
        }
        bg bgVar = (bg) bh.a.q();
        if (!bgVar.b.H()) {
            bgVar.v();
        }
        bh bhVar = (bh) bgVar.b;
        bhVar.b |= 1;
        bhVar.c = 18;
        if (!bgVar.b.H()) {
            bgVar.v();
        }
        bh bhVar2 = (bh) bgVar.b;
        bhVar2.b |= 2;
        bhVar2.d = 1;
        bl blVar = afVar.f;
        if (blVar == null) {
            blVar = bl.a;
        }
        int i3 = blVar.b;
        if (!bgVar.b.H()) {
            bgVar.v();
        }
        bh bhVar3 = (bh) bgVar.b;
        bhVar3.b |= 4;
        bhVar3.e = i3;
        bh bhVar4 = (bh) bgVar.t();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ab abVar13 = (ab) aaVar.b;
        bhVar4.getClass();
        abVar13.o = bhVar4;
        abVar13.b |= 4096;
        Context context = this.e.a.a;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String string3 = (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("com.google.android.libraries.navigation.STYLING_OPTIONS")) ? null : applicationInfo.metaData.getString("com.google.android.libraries.navigation.STYLING_OPTIONS");
            if (string3 != null) {
                z = false;
                z2 = false;
                for (String str : bj.b(',').f().g(string3)) {
                    if (str.equals("B3MWHUG2MR0DQW")) {
                        z = true;
                    } else if (str.equals("B3H9HE845CFHYG")) {
                        z2 = true;
                    } else {
                        f.a(5, com.google.android.libraries.navigation.internal.b.b.g(str, "Warning: the AndroidManifest.xml meta-data com.google.android.libraries.navigation.STYLING_OPTIONS contains an unrecognized value '", "'. Ignoring."));
                    }
                }
            } else {
                z = false;
                z2 = false;
            }
            if (z && z2) {
                f.a(5, "Warning: the AndroidManifest.xml meta-data com.google.android.libraries.navigation.STYLING_OPTIONS contains two conflicting values. Ignoring.");
                z = false;
                z2 = false;
            }
            aaVar.c(ev.q(((z || z2) && true == z) ? "B3MWHUG2MR0DQW" : "B3H9HE845CFHYG"));
            ev evVar = com.google.android.libraries.navigation.internal.iv.d.a;
            ArrayList arrayList = new ArrayList();
            for (String str2 : "".split(",")) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty()) {
                    try {
                        ev evVar2 = com.google.android.libraries.navigation.internal.iv.d.a;
                        if (((lv) evVar2).c > 0) {
                            String str3 = ((com.google.android.libraries.navigation.internal.iv.c) evVar2.get(0)).a;
                            throw null;
                        }
                        arrayList.add(Integer.valueOf(Integer.parseInt(strTrim)));
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
            ar.q(arrayList);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                aaVar.d(((Integer) it2.next()).intValue());
            }
            return (ab) aaVar.t();
        } catch (PackageManager.NameNotFoundException e) {
            throw new AssertionError(e);
        }
    }
}
