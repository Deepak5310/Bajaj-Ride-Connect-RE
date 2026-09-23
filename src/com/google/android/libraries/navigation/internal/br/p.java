package com.google.android.libraries.navigation.internal.br;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import androidx.core.content.ContextCompat;
import androidx.core.text.BidiFormatter;
import com.google.android.libraries.navigation.internal.adr.ae;
import com.google.android.libraries.navigation.internal.adr.ah;
import com.google.android.libraries.navigation.internal.adr.aj;
import com.google.android.libraries.navigation.internal.adr.gm;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.yx.ao;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gz;
import com.google.android.libraries.navigation.internal.yz.hb;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.br.p");
    private final Context b;
    private final com.google.android.libraries.navigation.internal.bn.d c;
    private final com.google.android.libraries.navigation.internal.bn.a d;
    private final String e;
    private final BidiFormatter h;
    private final boolean j;
    private final com.google.android.libraries.navigation.internal.ci.a k;
    private final boolean f = false;
    private final boolean g = false;
    private final String i = aq.b(null);

    public p(o oVar) {
        this.b = oVar.a;
        this.c = oVar.b;
        this.k = oVar.g;
        this.d = oVar.c;
        this.e = oVar.e;
        this.h = oVar.d;
        this.j = oVar.f;
    }

    private final Drawable b(ah ahVar) {
        if (this.c == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('U')).p("Component icon was found in renderable component but DirectionsIconManager was not specified.");
            return null;
        }
        if (this.k == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('T')).p("Component icon was found in renderable component but DarkModeIndicator was not specified.");
            return null;
        }
        int iA = ae.a(ahVar.c);
        if (iA == 0) {
            iA = ae.a;
        }
        if (iA == ae.c && (ahVar.b & 2) != 0) {
            return this.c.g(ahVar.d, this.d, false, null);
        }
        if (this.c == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('V')).p("iconManager is null");
            return null;
        }
        String str = ((d) l.a(ahVar)).a;
        if (str == null) {
            return null;
        }
        return this.c.a(str, x.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final CharSequence c(ev evVar) {
        no it2 = evVar.iterator();
        ArrayList arrayList = new ArrayList();
        CharSequence charSequenceD = d((gn) it2.next(), true, !it2.hasNext(), null);
        arrayList.add(charSequenceD);
        String strValueOf = String.valueOf(charSequenceD.toString());
        Resources resources = this.b.getResources();
        String strConcat = "\u200b".concat(strValueOf);
        while (it2.hasNext()) {
            CharSequence charSequenceD2 = d((gn) it2.next(), false, !it2.hasNext(), null);
            arrayList.add(charSequenceD2);
            strConcat = resources.getString(it2.hasNext() ? com.google.android.libraries.navigation.internal.bx.g.D : com.google.android.libraries.navigation.internal.bx.g.C, strConcat, charSequenceD2);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strConcat);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            CharSequence charSequence = (CharSequence) arrayList.get(i);
            String string = charSequence.toString();
            int iIndexOf = strConcat.indexOf(string, 0);
            while (iIndexOf >= 0) {
                final Integer numValueOf = Integer.valueOf(iIndexOf);
                Optional optionalFindFirst = arrayList2.stream().filter(new Predicate() { // from class: com.google.android.libraries.navigation.internal.br.m
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ((Integer) ((ao) obj).a).equals(numValueOf);
                    }
                }).findFirst();
                if (!optionalFindFirst.isPresent()) {
                    break;
                }
                iIndexOf = strConcat.indexOf(string, ((Integer) ((ao) optionalFindFirst.get()).b).intValue());
            }
            if (iIndexOf >= 0) {
                int length = string.length() + iIndexOf;
                spannableStringBuilder.replace(iIndexOf, length, charSequence);
                arrayList2.add(new ao(Integer.valueOf(iIndexOf), Integer.valueOf(length)));
            }
        }
        Collections.sort(arrayList2, Comparator.comparing(new Function() { // from class: com.google.android.libraries.navigation.internal.br.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (Integer) ((ao) obj).a;
            }
        }));
        for (int i2 = 1; i2 < arrayList2.size(); i2++) {
            spannableStringBuilder.setSpan(new a(), ((Integer) ((ao) arrayList2.get(i2 - 1)).b).intValue(), ((Integer) ((ao) arrayList2.get(i2)).a).intValue(), 0);
        }
        return spannableStringBuilder;
    }

    private final CharSequence d(gn gnVar, boolean z, boolean z2, Integer num) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u200b");
        aj ajVar = gnVar.d;
        if (ajVar == null) {
            ajVar = aj.a;
        }
        int i = ajVar.b & 1;
        if (i != 0) {
            aj ajVar2 = gnVar.d;
            if (ajVar2 == null) {
                ajVar2 = aj.a;
            }
            spannableStringBuilder.append((CharSequence) ajVar2.c);
            spannableStringBuilder.append((char) 8203);
        }
        Context context = this.b;
        v vVar = new v(gnVar, z, z2, context.getResources(), this.c, 0);
        if (i != 0) {
            vVar.a = null;
        }
        aj ajVar3 = gnVar.d;
        if (ajVar3 == null) {
            ajVar3 = aj.a;
        }
        if (ajVar3.d) {
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 0);
        }
        spannableStringBuilder.setSpan(vVar, 0, spannableStringBuilder.length(), 0);
        return spannableStringBuilder;
    }

    private static boolean e(gn gnVar) {
        int iA = gm.a(gnVar.c);
        if (iA == 0) {
            iA = gm.a;
        }
        if (iA != gm.g) {
            return false;
        }
        if ((gnVar.b & 4) == 0) {
            return true;
        }
        ah ahVar = gnVar.e;
        if (ahVar == null) {
            ahVar = ah.a;
        }
        if ((ahVar.b & 2) != 0) {
            return false;
        }
        ah ahVar2 = gnVar.e;
        if (ahVar2 == null) {
            ahVar2 = ah.a;
        }
        return ahVar2.e.size() == 0;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:106:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:108:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:112:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:113:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:115:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:116:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:118:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:120:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:121:0x022e A[PHI: r6
      0x022e: PHI (r6v10 java.lang.CharSequence) = (r6v62 java.lang.CharSequence), (r6v63 java.lang.CharSequence), (r6v64 java.lang.CharSequence) binds: [B:120:0x01fd, B:96:0x018c, B:67:0x010a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:143:0x025e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0098  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:63:0x0103  */
    /* JADX WARN: Code duplicated, block: B:66:0x0108  */
    /* JADX WARN: Code duplicated, block: B:69:0x010e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0114  */
    /* JADX WARN: Code duplicated, block: B:73:0x0118  */
    /* JADX WARN: Code duplicated, block: B:77:0x0122  */
    /* JADX WARN: Code duplicated, block: B:79:0x0133  */
    /* JADX WARN: Code duplicated, block: B:81:0x013b  */
    /* JADX WARN: Code duplicated, block: B:83:0x013f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0143  */
    /* JADX WARN: Code duplicated, block: B:88:0x014d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0159  */
    /* JADX WARN: Code duplicated, block: B:92:0x0161  */
    /* JADX WARN: Code duplicated, block: B:93:0x0186  */
    /* JADX WARN: Code duplicated, block: B:95:0x018a  */
    public final CharSequence a(Collection collection) {
        int iA;
        int iA2;
        int i;
        Drawable drawable;
        CharSequence charSequenceB;
        CharSequence charSequence;
        String str;
        String str2;
        int i2;
        aj ajVar;
        String str3;
        String str4;
        Spannable spannableB;
        String strUnicodeWrap;
        int i3;
        com.google.android.libraries.navigation.internal.hf.m mVar;
        ah ahVar;
        Drawable drawableB;
        String str5;
        String str6;
        CharSequence charSequenceC;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        gz gzVarI = hb.i(collection.iterator());
        while (true) {
            boolean z = false;
            while (gzVarI.hasNext()) {
                gn gnVar = (gn) gzVarI.a();
                if (e(gnVar)) {
                    int i4 = ev.d;
                    eq eqVar = new eq();
                    eqVar.h((gn) gzVarI.next());
                    while (gzVarI.hasNext()) {
                        gn gnVar2 = (gn) gzVarI.a();
                        int iA3 = gm.a(gnVar2.c);
                        if (iA3 == 0) {
                            iA3 = gm.a;
                        }
                        if (iA3 != gm.l && !e(gnVar2)) {
                            break;
                        }
                        gnVar = (gn) gzVarI.next();
                        if (e(gnVar)) {
                            aj ajVar2 = gnVar.d;
                            if (ajVar2 == null) {
                                ajVar2 = aj.a;
                            }
                            if ((ajVar2.b & 1) != 0) {
                                eqVar.h(gnVar);
                            }
                        }
                    }
                    charSequenceB = c(eqVar.g());
                } else {
                    gn gnVar3 = (gn) gzVarI.next();
                    if (e(gnVar3)) {
                        aj ajVar3 = gnVar3.d;
                        if (ajVar3 == null) {
                            ajVar3 = aj.a;
                        }
                        if ((ajVar3.b & 1) != 0) {
                            charSequenceC = c(ev.q(gnVar3));
                        } else {
                            iA = gm.a(gnVar3.c);
                            if (iA == 0) {
                                iA = gm.a;
                            }
                            if (iA == gm.s) {
                                iA2 = gm.a(gnVar3.c);
                                if (iA2 == 0) {
                                    iA2 = gm.a;
                                }
                                i = iA2 - 1;
                                if (iA2 == 0) {
                                    throw null;
                                }
                                if (i == 9) {
                                    drawable = ContextCompat.getDrawable(this.b, com.google.android.libraries.navigation.internal.f.d.v);
                                    if (drawable != null) {
                                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                                        spannableStringBuilder2.append(' ');
                                        spannableStringBuilder2.append((CharSequence) new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).d(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), this.b.getString(com.google.android.libraries.navigation.internal.bx.g.E)));
                                        spannableStringBuilder2.append(' ');
                                        charSequence = spannableStringBuilder2;
                                        charSequence = strUnicodeWrap;
                                        charSequence = str5;
                                        charSequenceB = charSequence;
                                    } else {
                                        charSequenceB = null;
                                    }
                                } else if (i == 10) {
                                    charSequenceB = null;
                                } else if (i != 20) {
                                    if (i == 22) {
                                        charSequence = str5;
                                        i2 = gnVar3.b;
                                        if ((i2 & 4) != 0) {
                                            ahVar = gnVar3.e;
                                            if (ahVar == null) {
                                                ahVar = ah.a;
                                            }
                                            drawableB = b(ahVar);
                                            if (drawableB == null) {
                                                charSequenceB = null;
                                            } else {
                                                charSequenceB = new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).d(drawableB, 0.0f, 0.0f, (ahVar.b & 4) != 0 ? ahVar.f : " ");
                                            }
                                        } else if ((i2 & 2) == 0) {
                                            charSequenceB = null;
                                        } else {
                                            ajVar = gnVar3.d;
                                            if (ajVar == null) {
                                                ajVar = aj.a;
                                            }
                                            str3 = ajVar.c;
                                            if (!str3.isEmpty()) {
                                                strUnicodeWrap = this.h.unicodeWrap(str3);
                                                i3 = ajVar.b;
                                                if ((i3 & 4) != 0) {
                                                    if (com.google.android.libraries.navigation.internal.gz.b.b(ajVar.e)) {
                                                        Pattern pattern = com.google.android.libraries.navigation.internal.hf.n.a;
                                                        this.b.getResources();
                                                        mVar = new com.google.android.libraries.navigation.internal.hf.m(com.google.android.libraries.navigation.internal.b.b.g(strUnicodeWrap, " ", " "));
                                                        int color = Color.parseColor(ajVar.e);
                                                        com.google.android.libraries.navigation.internal.hf.n.a aVar = mVar.c;
                                                        aVar.a.add(new BackgroundColorSpan(color));
                                                        mVar.c = aVar;
                                                    }
                                                    if ((ajVar.b & 8) != 0) {
                                                        mVar.i(Color.parseColor(ajVar.f));
                                                    }
                                                    if (ajVar.d) {
                                                        mVar.g();
                                                    }
                                                    charSequenceB = mVar.b();
                                                } else if ((i3 & 8) != 0) {
                                                }
                                                charSequence = strUnicodeWrap;
                                                Pattern pattern2 = com.google.android.libraries.navigation.internal.hf.n.a;
                                                this.b.getResources();
                                                mVar = new com.google.android.libraries.navigation.internal.hf.m(strUnicodeWrap);
                                                if ((ajVar.b & 8) != 0) {
                                                    mVar.i(Color.parseColor(ajVar.f));
                                                }
                                                if (ajVar.d) {
                                                    mVar.g();
                                                }
                                                charSequenceB = mVar.b();
                                            } else if ((ajVar.b & 4) != 0) {
                                                str4 = ajVar.e;
                                                if (com.google.android.libraries.navigation.internal.gz.b.b(str4)) {
                                                    spannableB = new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).b(new ColorDrawable(Color.parseColor(str4)), 0.0f, 0.0f);
                                                } else {
                                                    charSequenceB = null;
                                                }
                                            } else {
                                                charSequenceB = null;
                                            }
                                        }
                                    } else {
                                        charSequence = strUnicodeWrap;
                                        charSequence = str5;
                                        charSequenceB = charSequence;
                                    }
                                } else if (true != this.j) {
                                    str2 = "  •  ";
                                } else {
                                    str = "\n";
                                }
                            } else {
                                iA2 = gm.a(gnVar3.c);
                                if (iA2 == 0) {
                                    iA2 = gm.a;
                                }
                                i = iA2 - 1;
                                if (iA2 == 0) {
                                    throw null;
                                }
                                if (i == 9) {
                                    drawable = ContextCompat.getDrawable(this.b, com.google.android.libraries.navigation.internal.f.d.v);
                                    if (drawable != null) {
                                        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
                                        spannableStringBuilder3.append(' ');
                                        spannableStringBuilder3.append((CharSequence) new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).d(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), this.b.getString(com.google.android.libraries.navigation.internal.bx.g.E)));
                                        spannableStringBuilder3.append(' ');
                                        charSequence = spannableStringBuilder3;
                                        charSequence = strUnicodeWrap;
                                        charSequence = str5;
                                        charSequenceB = charSequence;
                                    } else {
                                        charSequenceB = null;
                                    }
                                } else if (i == 10) {
                                    charSequenceB = null;
                                } else if (i != 20) {
                                    if (i == 22) {
                                        charSequence = str5;
                                        i2 = gnVar3.b;
                                        if ((i2 & 4) != 0) {
                                            ahVar = gnVar3.e;
                                            if (ahVar == null) {
                                                ahVar = ah.a;
                                            }
                                            drawableB = b(ahVar);
                                            if (drawableB == null) {
                                                charSequenceB = null;
                                            } else {
                                                charSequenceB = new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).d(drawableB, 0.0f, 0.0f, (ahVar.b & 4) != 0 ? ahVar.f : " ");
                                            }
                                        } else if ((i2 & 2) == 0) {
                                            charSequenceB = null;
                                        } else {
                                            ajVar = gnVar3.d;
                                            if (ajVar == null) {
                                                ajVar = aj.a;
                                            }
                                            str3 = ajVar.c;
                                            if (!str3.isEmpty()) {
                                                strUnicodeWrap = this.h.unicodeWrap(str3);
                                                i3 = ajVar.b;
                                                if ((i3 & 4) != 0) {
                                                    if (com.google.android.libraries.navigation.internal.gz.b.b(ajVar.e)) {
                                                        Pattern pattern3 = com.google.android.libraries.navigation.internal.hf.n.a;
                                                        this.b.getResources();
                                                        mVar = new com.google.android.libraries.navigation.internal.hf.m(com.google.android.libraries.navigation.internal.b.b.g(strUnicodeWrap, " ", " "));
                                                        int color2 = Color.parseColor(ajVar.e);
                                                        com.google.android.libraries.navigation.internal.hf.n.a aVar2 = mVar.c;
                                                        aVar2.a.add(new BackgroundColorSpan(color2));
                                                        mVar.c = aVar2;
                                                    }
                                                    if ((ajVar.b & 8) != 0) {
                                                        mVar.i(Color.parseColor(ajVar.f));
                                                    }
                                                    if (ajVar.d) {
                                                        mVar.g();
                                                    }
                                                    charSequenceB = mVar.b();
                                                } else if ((i3 & 8) != 0) {
                                                }
                                                charSequence = strUnicodeWrap;
                                                Pattern pattern4 = com.google.android.libraries.navigation.internal.hf.n.a;
                                                this.b.getResources();
                                                mVar = new com.google.android.libraries.navigation.internal.hf.m(strUnicodeWrap);
                                                if ((ajVar.b & 8) != 0) {
                                                    mVar.i(Color.parseColor(ajVar.f));
                                                }
                                                if (ajVar.d) {
                                                    mVar.g();
                                                }
                                                charSequenceB = mVar.b();
                                            } else if ((ajVar.b & 4) != 0) {
                                                str4 = ajVar.e;
                                                if (com.google.android.libraries.navigation.internal.gz.b.b(str4)) {
                                                    spannableB = new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).b(new ColorDrawable(Color.parseColor(str4)), 0.0f, 0.0f);
                                                } else {
                                                    charSequenceB = null;
                                                }
                                            } else {
                                                charSequenceB = null;
                                            }
                                        }
                                    } else {
                                        charSequence = strUnicodeWrap;
                                        charSequence = str5;
                                        charSequenceB = charSequence;
                                    }
                                } else if (true != this.j) {
                                    str2 = "  •  ";
                                } else {
                                    str = "\n";
                                }
                            }
                        }
                    } else {
                        iA = gm.a(gnVar3.c);
                        if (iA == 0) {
                            iA = gm.a;
                        }
                        if (iA == gm.s || (gnVar3.b & 4) == 0) {
                            iA2 = gm.a(gnVar3.c);
                            if (iA2 == 0) {
                                iA2 = gm.a;
                            }
                            i = iA2 - 1;
                            if (iA2 == 0) {
                                throw null;
                            }
                            if (i == 9) {
                                drawable = ContextCompat.getDrawable(this.b, com.google.android.libraries.navigation.internal.f.d.v);
                                if (drawable != null) {
                                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder();
                                    spannableStringBuilder4.append(' ');
                                    spannableStringBuilder4.append((CharSequence) new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).d(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), this.b.getString(com.google.android.libraries.navigation.internal.bx.g.E)));
                                    spannableStringBuilder4.append(' ');
                                    charSequence = spannableStringBuilder4;
                                    charSequence = strUnicodeWrap;
                                    charSequence = str5;
                                    charSequenceB = charSequence;
                                } else {
                                    charSequenceB = null;
                                }
                            } else if (i == 10) {
                                charSequenceB = null;
                            } else if (i != 20) {
                                if (i == 22 || (str5 = this.e) == null) {
                                    charSequence = str5;
                                    i2 = gnVar3.b;
                                    if ((i2 & 4) != 0) {
                                        ahVar = gnVar3.e;
                                        if (ahVar == null) {
                                            ahVar = ah.a;
                                        }
                                        drawableB = b(ahVar);
                                        if (drawableB == null) {
                                            charSequenceB = null;
                                        } else {
                                            charSequenceB = new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).d(drawableB, 0.0f, 0.0f, (ahVar.b & 4) != 0 ? ahVar.f : " ");
                                        }
                                    } else if ((i2 & 2) == 0) {
                                        charSequenceB = null;
                                    } else {
                                        ajVar = gnVar3.d;
                                        if (ajVar == null) {
                                            ajVar = aj.a;
                                        }
                                        str3 = ajVar.c;
                                        if (!str3.isEmpty()) {
                                            strUnicodeWrap = this.h.unicodeWrap(str3);
                                            i3 = ajVar.b;
                                            if ((i3 & 4) != 0) {
                                                if (com.google.android.libraries.navigation.internal.gz.b.b(ajVar.e)) {
                                                    Pattern pattern5 = com.google.android.libraries.navigation.internal.hf.n.a;
                                                    this.b.getResources();
                                                    mVar = new com.google.android.libraries.navigation.internal.hf.m(com.google.android.libraries.navigation.internal.b.b.g(strUnicodeWrap, " ", " "));
                                                    int color3 = Color.parseColor(ajVar.e);
                                                    com.google.android.libraries.navigation.internal.hf.n.a aVar3 = mVar.c;
                                                    aVar3.a.add(new BackgroundColorSpan(color3));
                                                    mVar.c = aVar3;
                                                }
                                                if ((ajVar.b & 8) != 0 && com.google.android.libraries.navigation.internal.gz.b.b(ajVar.f)) {
                                                    mVar.i(Color.parseColor(ajVar.f));
                                                }
                                                if (ajVar.d) {
                                                    mVar.g();
                                                }
                                                charSequenceB = mVar.b();
                                            } else if ((i3 & 8) != 0 && !ajVar.d) {
                                                charSequence = strUnicodeWrap;
                                                charSequence = str5;
                                                charSequenceB = charSequence;
                                            }
                                            charSequence = strUnicodeWrap;
                                            Pattern pattern6 = com.google.android.libraries.navigation.internal.hf.n.a;
                                            this.b.getResources();
                                            mVar = new com.google.android.libraries.navigation.internal.hf.m(strUnicodeWrap);
                                            if ((ajVar.b & 8) != 0) {
                                                mVar.i(Color.parseColor(ajVar.f));
                                            }
                                            if (ajVar.d) {
                                                mVar.g();
                                            }
                                            charSequenceB = mVar.b();
                                        } else if ((ajVar.b & 4) != 0) {
                                            str4 = ajVar.e;
                                            if (com.google.android.libraries.navigation.internal.gz.b.b(str4)) {
                                                spannableB = new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).b(new ColorDrawable(Color.parseColor(str4)), 0.0f, 0.0f);
                                            } else {
                                                charSequenceB = null;
                                            }
                                        } else {
                                            charSequenceB = null;
                                        }
                                    }
                                } else {
                                    charSequence = strUnicodeWrap;
                                    charSequence = str5;
                                    charSequenceB = charSequence;
                                }
                            } else if (true != this.j) {
                                str2 = "  •  ";
                            } else {
                                str = "\n";
                            }
                        } else {
                            ah ahVar2 = gnVar3.e;
                            if (ahVar2 == null) {
                                ahVar2 = ah.a;
                            }
                            Drawable drawableB2 = b(ahVar2);
                            if (drawableB2 == null) {
                                str6 = "";
                            } else {
                                CharSequence[] charSequenceArr = new CharSequence[3];
                                charSequenceArr[0] = StringUtils.SPACE;
                                charSequenceArr[1] = new com.google.android.libraries.navigation.internal.hf.n(this.b.getResources()).d(drawableB2, 0.0f, 0.0f, (ahVar2.b & 4) != 0 ? ahVar2.f : " ");
                                charSequenceArr[2] = StringUtils.SPACE;
                                charSequenceB = TextUtils.concat(charSequenceArr);
                            }
                        }
                    }
                }
                if (charSequenceB != null) {
                    charSequenceB = str;
                    charSequenceB = str2;
                    charSequenceB = spannableB;
                    charSequenceB = str6;
                    charSequenceB = charSequenceC;
                    int iA4 = gm.a(gnVar.c);
                    if (iA4 == 0) {
                        iA4 = gm.a;
                    }
                    boolean z2 = iA4 == gm.d;
                    if (!z && spannableStringBuilder.length() > 0 && !z2) {
                        spannableStringBuilder.append((CharSequence) this.i);
                    }
                    spannableStringBuilder.append(charSequenceB);
                    if (gnVar.f || z2) {
                        z = true;
                    }
                } else {
                    charSequenceB = str;
                    charSequenceB = str2;
                    charSequenceB = spannableB;
                    charSequenceB = str6;
                    charSequenceB = charSequenceC;
                }
            }
            return spannableStringBuilder;
        }
    }
}
