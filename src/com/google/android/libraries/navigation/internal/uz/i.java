package com.google.android.libraries.navigation.internal.uz;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import com.google.android.libraries.navigation.internal.adr.gj;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.y;
import com.google.android.libraries.navigation.internal.adr.z;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.hf.m;
import com.google.android.libraries.navigation.internal.hf.n;
import com.google.android.libraries.navigation.internal.hf.s;
import com.google.android.libraries.navigation.internal.hf.u;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.tj.j;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.br;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import org.joda.time.DateTimeZone;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class i implements cs {
    protected final Context a;
    protected final Resources b;
    protected final com.google.android.libraries.navigation.internal.mj.a c;
    protected final n d;
    protected final n.a e;
    protected CharSequence f;
    protected ck[] g;
    protected ev h;
    protected final com.google.android.libraries.navigation.internal.vk.c.a i = new h();

    public i(Context context, com.google.android.libraries.navigation.internal.mj.a aVar, Resources resources, n nVar, n.a aVar2, com.google.android.libraries.navigation.internal.rw.n nVar2) {
        this.a = context;
        this.b = resources;
        this.c = aVar;
        this.d = nVar;
        this.e = aVar2;
        ii.a aVar3 = ii.a.DELAY_NODATA;
        int i = ev.d;
        this.h = lv.a;
    }

    public Spanned a() {
        if (this.h.size() >= 2) {
            return ((com.google.android.libraries.navigation.internal.vk.c) this.h.get(1)).a();
        }
        return null;
    }

    public Spanned b() {
        if (this.h.size() >= 2) {
            return ((com.google.android.libraries.navigation.internal.vk.c) this.h.get(1)).b();
        }
        return null;
    }

    public CharSequence c() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(j jVar, boolean z) {
        boolean z2;
        boolean z3;
        int i;
        int i2;
        com.google.android.libraries.navigation.internal.se.b bVarC = jVar.c();
        bg bgVarF = jVar.b().f();
        eq eqVar = new eq();
        ev evVarB = bgVarF.B();
        if (this.g == null || evVarB.size() != this.g.length) {
            z2 = true;
            break;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= evVarB.size()) {
                z2 = false;
                break;
            } else {
                if (!this.g[i3].equals(evVarB.get(i3))) {
                    z2 = true;
                    break;
                }
                i3++;
            }
        }
        if (z2 && bgVarF.B() != null) {
            this.g = (ck[]) bgVarF.B().toArray(new ck[0]);
        }
        boolean z4 = (bVarC.c() == -1 || bVarC.k == -1) ? false : true;
        int[] array = bgVarF.P(bVarC.a()).stream().mapToInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.uz.e
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return (int) com.google.android.libraries.navigation.internal.ja.a.b((Duration) obj);
            }
        }).toArray();
        double dA = bVarC.a();
        bq[] bqVarArrAa = bgVarF.aa();
        ArrayList arrayList = new ArrayList(bqVarArrAa.length);
        Duration durationPlus = Duration.ZERO;
        for (int i4 = 0; i4 < bqVarArrAa.length; i4++) {
            double dA2 = bgVarF.a(bqVarArrAa[i4].k);
            arrayList.add(bgVarF.K(dA, dA2).plus(durationPlus));
            z zVar = bgVarF.g.c(i4).d;
            if (dA2 > dA && zVar != null) {
                int iA = y.a(zVar.c);
                if (iA == 0) {
                    iA = y.a;
                }
                if (iA != y.c) {
                    durationPlus = durationPlus.plus(Duration.ofSeconds(zVar.b));
                }
            }
        }
        int[] array2 = arrayList.stream().mapToInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.uz.f
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return (int) com.google.android.libraries.navigation.internal.ja.a.b((Duration) obj);
            }
        }).toArray();
        int i5 = 0;
        while (i5 < bgVarF.m()) {
            ck ckVar = (ck) bgVarF.B().get(i5);
            SpannableString spannableString = new SpannableString("");
            Spannable spannable = null;
            if (i5 <= 0 || (i = i5 - 1) >= array.length || !z4) {
                z3 = true;
            } else {
                Spanned spannedF = u.f(this.a.getResources(), Math.max(i5 > 1 ? array[i] - array[i5 - 2] : array[i], 60), 2, this.e);
                bg bgVar = bVarC.b;
                ar.p(i, ((lv) bgVar.I).c);
                ii.a aVar = (ii.a) bgVar.I.get(i);
                Resources resources = this.b;
                if (aVar == null) {
                    aVar = ii.a.DELAY_NODATA;
                }
                if (z) {
                    int iOrdinal = aVar.ordinal();
                    if (iOrdinal == 1) {
                        i2 = com.google.android.libraries.navigation.internal.f.b.c;
                    } else if (iOrdinal != 2) {
                        i2 = iOrdinal != 3 ? com.google.android.libraries.navigation.internal.f.b.e : com.google.android.libraries.navigation.internal.f.b.a;
                    } else {
                        i2 = com.google.android.libraries.navigation.internal.bx.b.a;
                    }
                } else {
                    int iOrdinal2 = aVar.ordinal();
                    if (iOrdinal2 == 1) {
                        i2 = com.google.android.libraries.navigation.internal.f.b.d;
                    } else if (iOrdinal2 != 2) {
                        i2 = iOrdinal2 != 3 ? com.google.android.libraries.navigation.internal.f.b.f : com.google.android.libraries.navigation.internal.f.b.b;
                    } else {
                        i2 = com.google.android.libraries.navigation.internal.bx.b.b;
                    }
                }
                int color = resources.getColor(i2);
                m mVar = new m(spannedF);
                mVar.i(color);
                Spannable spannableB = mVar.b();
                if (i < array2.length) {
                    long seconds = ((long) array2[i]) + TimeUnit.MILLISECONDS.toSeconds(this.c.f().toEpochMilli());
                    com.google.android.libraries.navigation.internal.adr.ar arVar = ((gj) bgVarF.g.a.h.get(i)).f;
                    if (arVar == null) {
                        arVar = com.google.android.libraries.navigation.internal.adr.ar.a;
                    }
                    spannableString = new SpannableString(s.a(this.a, seconds, (DateTimeZone.getAvailableIDs().contains(arVar.c) ? DateTimeZone.forID(arVar.c) : DateTimeZone.getDefault()).toTimeZone(), arVar.d).a);
                }
                z3 = true;
                if (i5 == 1) {
                    this.f = spannedF;
                }
                spannable = spannableB;
            }
            if (z2) {
                eqVar.h(new com.google.android.libraries.navigation.internal.vl.e(i5, this.a, i5 == bgVarF.m() + (-1) ? z3 : false, ckVar.Z(), (i5 <= 0 || bgVarF.B().size() <= 2) ? false : z3, ckVar.V(), spannable, spannableString, this.i, null));
            } else {
                ((com.google.android.libraries.navigation.internal.vk.c) this.h.get(i5)).d(spannable);
                ((com.google.android.libraries.navigation.internal.vk.c) this.h.get(i5)).c(spannableString);
            }
            i5++;
            array = array;
        }
        if (z2) {
            this.h = (ev) eqVar.g().stream().map(new Function() { // from class: com.google.android.libraries.navigation.internal.uz.g
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return (com.google.android.libraries.navigation.internal.vk.c) obj;
                }
            }).collect(br.a);
        }
        if (z4) {
            bVarC.e();
        } else {
            ii.a aVar2 = ii.a.DELAY_NODATA;
        }
        cy.a(this);
    }
}
