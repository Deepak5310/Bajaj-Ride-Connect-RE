package com.google.android.libraries.navigation.internal.pz;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import com.google.android.libraries.geo.mapcore.internal.model.ab;
import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.o;
import com.google.android.libraries.geo.mapcore.internal.model.y;
import com.google.android.libraries.geo.mapcore.internal.model.z;
import com.google.android.libraries.geo.mapcore.renderer.eg;
import com.google.android.libraries.geo.mapcore.renderer.eo;
import com.google.android.libraries.geo.mapcore.renderer.ep;
import com.google.android.libraries.geo.mapcore.renderer.er;
import com.google.android.libraries.geo.mapcore.renderer.et;
import com.google.android.libraries.geo.mapcore.renderer.g;
import com.google.android.libraries.navigation.internal.adg.by;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.qy.h;
import com.google.android.libraries.navigation.internal.qz.k;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static final ev a;
    private final ep b;
    private final float c;
    private final h d;
    private final com.google.android.libraries.navigation.internal.pm.a e;

    static {
        int i = ev.d;
        a = lv.a;
    }

    public a(ep epVar, h hVar, com.google.android.libraries.navigation.internal.pm.a aVar, float f) {
        this.b = epVar;
        this.d = hVar;
        this.e = aVar;
        this.c = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final ab g(ev evVar, ab abVar) {
        boolean z;
        if (abVar.c == null || evVar.isEmpty()) {
            return abVar;
        }
        ArrayList arrayList = new ArrayList(abVar.c.size());
        ev evVar2 = abVar.c;
        int size = evVar2.size();
        for (int i = 0; i < size; i++) {
            z zVar = (z) evVar2.get(i);
            String strF = zVar.f();
            int iC = zVar.c();
            boolean z2 = true;
            byte[] bArrB = null;
            if (zVar.d() == 0) {
                z = false;
                break;
            }
            int size2 = evVar.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    z = false;
                    break;
                }
                if (((by) evVar.get(size2)).c == zVar.d()) {
                    if ((((by) evVar.get(size2)).b & 4) == 0) {
                        if ((((by) evVar.get(size2)).b & 1024) != 0) {
                            strF = ((by) evVar.get(size2)).f;
                            if (!strF.startsWith("http://") && !strF.startsWith("https://") && !strF.startsWith("//") && !strF.startsWith("data:")) {
                                strF = com.google.android.libraries.navigation.internal.b.b.g(strF, "icon/name=", "&scale=4");
                            }
                        }
                        z = true;
                        break;
                    }
                    bArrB = ((by) evVar.get(size2)).d.B();
                    strF = "";
                    z = true;
                    break;
                }
            }
            if (zVar.b() == 0) {
                z2 = z;
                break;
            }
            int size3 = evVar.size();
            while (true) {
                size3--;
                if (size3 < 0) {
                    z2 = z;
                    break;
                }
                if (((by) evVar.get(size3)).c == zVar.b() && (((by) evVar.get(size3)).b & 8) != 0) {
                    iC = ((by) evVar.get(size3)).e & 16777215;
                    break;
                }
            }
            if (z2) {
                y yVarH = z.h();
                yVarH.f(strF);
                ((com.google.android.libraries.geo.mapcore.internal.model.h) yVarH).a = bArrB;
                yVarH.d(iC);
                yVarH.b(zVar.a());
                yVarH.e(zVar.e());
                arrayList.add(yVarH.a());
            } else {
                arrayList.add(zVar);
            }
        }
        return new ab(ev.o(arrayList), abVar.e);
    }

    private static float h(ai aiVar, d dVar) {
        if (aiVar == null || !aiVar.q()) {
            return 0.0f;
        }
        return b.b(((o) aiVar.r).c, dVar, 1.0f);
    }

    private final er i(int i, Bitmap bitmap, float f) {
        a aVar = this;
        int iB = aVar.b.b() - 1;
        int iA = aVar.b.a() - 1;
        int width = bitmap.getWidth();
        float f2 = f;
        int height = bitmap.getHeight();
        int i2 = width;
        Bitmap bitmapCreateBitmap = bitmap;
        while (true) {
            if (i2 <= iB && height <= iA && f2 > 0.5d) {
                return aVar.b.f(bitmapCreateBitmap, i, -1, 1, 0, f2);
            }
            int width2 = bitmapCreateBitmap.getWidth();
            int height2 = bitmapCreateBitmap.getHeight();
            int i3 = width2 / 2;
            int i4 = height2 / 2;
            int[] iArr = new int[width2 * height2];
            int[] iArr2 = new int[i3 * i4];
            bitmapCreateBitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
            int i5 = width2 / i3;
            int i6 = height2 / i4;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = 0;
                while (i8 < i3) {
                    int i9 = i8 * i5;
                    int i10 = i7 * i6;
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    int i15 = 0;
                    while (i11 < i6) {
                        int i16 = iB;
                        int i17 = 0;
                        while (i17 < i5) {
                            int i18 = iA;
                            int i19 = iArr[((i10 + i11) * width2) + i9 + i17];
                            i15 += i19 & 255;
                            i14 += (i19 >> 8) & 255;
                            i13 += (i19 >> 16) & 255;
                            i12 += (i19 >> 24) & 255;
                            i17++;
                            i9 = i9;
                            iA = i18;
                        }
                        i11++;
                        iB = i16;
                    }
                    int i20 = iB;
                    int i21 = i5 * i6;
                    iArr2[(i7 * i3) + i8] = (i15 / i21) | ((i14 / i21) << 8) | ((i13 / i21) << 16) | ((i12 / i21) << 24);
                    i8++;
                    iB = i20;
                    iA = iA;
                }
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iArr2, i3, i4, Bitmap.Config.ARGB_8888);
            i2 /= 2;
            height /= 2;
            f2 += f2;
            aVar = this;
            iB = iB;
        }
    }

    private final er j(int i, Picture picture, eg egVar, float f) {
        float f2;
        float f3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float fB = this.b.b();
        float fA = this.b.a();
        int width = egVar.c() ? ((g) egVar).a : picture.getWidth();
        int height = (int) ((egVar.c() ? ((g) egVar).b : picture.getHeight()) * f);
        int i7 = (int) (width * f);
        float f4 = 1.0f;
        while (true) {
            f2 = i7;
            if (f2 <= fB) {
                f3 = height;
                if (f3 <= fA && f4 > 0.5d) {
                    break;
                }
            }
            i7 /= 2;
            height /= 2;
            f4 += f4;
        }
        if (f2 > fB - 2.0f || f3 > fA - 2.0f) {
            i2 = height;
            i3 = i7;
            i4 = 0;
            i5 = 0;
            i6 = -1;
        } else {
            eo eoVarJ = this.b.j(i, i7, height);
            int i8 = eoVarJ.a;
            if (eoVarJ.b) {
                i3 = i7 + 2;
                i2 = height + 2;
                i5 = 1;
                i4 = 0;
            } else {
                i2 = height;
                i3 = i7;
                i4 = 1;
                i5 = 0;
            }
            i6 = i8;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawPicture(picture, new Rect(i5, i5, i7 + i5, height + i5));
        return this.b.f(bitmapCreateBitmap, i, i6, i4, i5, f4);
    }

    private final er k(Bitmap bitmap, float f) {
        int iHashCode = bitmap.hashCode();
        er erVarB = b(iHashCode);
        return erVarB != null ? erVarB : i(iHashCode, bitmap, f);
    }

    final er b(int i) {
        return this.b.g(i);
    }

    public final er d(Bitmap bitmap) {
        return k(bitmap, 1.0f);
    }

    final er e(String str, com.google.android.libraries.navigation.internal.qz.g gVar, eg egVar, float f) {
        Picture pictureD;
        int iHashCode = Arrays.hashCode(new Object[]{str, egVar, Float.valueOf(f)});
        er erVarB = b(iHashCode);
        if (erVarB != null) {
            return erVarB;
        }
        k kVarB = this.d.b(str, String.valueOf(getClass().getName()).concat("#getTextureForIcon()"), gVar);
        if (!kVarB.p()) {
            return null;
        }
        if (kVarB.a() == 3) {
            Bitmap bitmapC = kVarB.c();
            if (bitmapC != null) {
                return i(iHashCode, bitmapC, f * this.c);
            }
            return null;
        }
        if (kVarB.a() != 6 || (pictureD = kVarB.d()) == null) {
            return null;
        }
        return j(iHashCode, pictureD, egVar, f * this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final et f(dp dpVar, ev evVar, ai aiVar, d dVar, com.google.android.libraries.navigation.internal.qz.g gVar) {
        Bitmap bitmapC;
        int i;
        k[] kVarArr;
        er erVarE;
        ab abVar = aiVar != null ? aiVar.t : null;
        String strValueOf = String.valueOf(getClass().getName());
        int i2 = ev.d;
        eq eqVar = new eq();
        if (abVar == null) {
            return null;
        }
        if (abVar.c()) {
            eqVar.h(d(abVar.f));
            return new et(eqVar.g());
        }
        String str = abVar.b;
        if (str == null && abVar.c == null) {
            return null;
        }
        if (str != null && (erVarE = e(str, gVar, abVar.d, 1.0f / abVar.e)) != null) {
            return new et(ev.q(erVarE));
        }
        if (abVar.c == null) {
            return null;
        }
        ab abVarG = g(evVar, abVar);
        String str2 = dpVar.c;
        h hVar = this.d;
        ev evVar2 = abVarG.c;
        int size = evVar2 == null ? 0 : evVar2.size();
        int i3 = aiVar.q() ? ((o) aiVar.r).a : 0;
        float fH = h(aiVar, dVar);
        int i4 = aiVar.q() ? ((o) aiVar.r).g : 0;
        k[] kVarArr2 = new k[size];
        int i5 = 0;
        while (i5 < size) {
            ar.q(evVar2);
            z zVar = (z) evVar2.get(i5);
            if (aq.c(zVar.f())) {
                i = i5;
                kVarArr = kVarArr2;
            } else {
                i = i5;
                kVarArr = kVarArr2;
                kVarArr[i] = hVar.a(ev.q(zVar), abVarG.e, str2, fH, i3, i4, strValueOf.concat("#getTextureGroupForLabelElement()"), gVar);
            }
            i5 = i + 1;
            size = size;
            kVarArr2 = kVarArr;
        }
        k[] kVarArr3 = kVarArr2;
        int i6 = size;
        ArrayList arrayList = new ArrayList(abVarG.c.size());
        for (int i7 = 0; i7 < i6; i7++) {
            k kVar = kVarArr3[i7];
            if (kVar == null) {
                arrayList.add(null);
            } else {
                if (!kVar.p() || (bitmapC = kVar.c()) == null) {
                    return null;
                }
                arrayList.add(bitmapC);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        for (int i8 = 0; i8 < size2; i8++) {
            Bitmap bitmap = (Bitmap) arrayList.get(i8);
            if (bitmap != null) {
                arrayList2.add(k(bitmap, this.c / abVarG.e));
            } else {
                arrayList2.add(null);
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return new et(arrayList2);
    }

    public static Bitmap a(String str, ab abVar, ai aiVar, d dVar, h hVar, String str2, com.google.android.libraries.navigation.internal.qz.g gVar) {
        ev evVar;
        String str3;
        ab abVar2;
        Bitmap bitmap;
        if (aiVar != null && (abVar2 = aiVar.t) != null && (bitmap = abVar2.f) != null) {
            return bitmap;
        }
        if (abVar != null && (str3 = abVar.b) != null) {
            k kVarB = hVar.b(str3, str2, gVar);
            if (kVarB.p()) {
                return kVarB.c();
            }
            return null;
        }
        if (abVar != null) {
            evVar = abVar.c;
            ar.q(evVar);
        } else {
            evVar = a;
        }
        ev evVar2 = evVar;
        int i = (aiVar == null || !aiVar.q()) ? 0 : ((o) aiVar.r).a;
        k kVarA = hVar.a(evVar2, abVar != null ? abVar.e : 1, str, h(aiVar, dVar), i, (aiVar == null || !aiVar.q()) ? 0 : ((o) aiVar.r).g, str2, gVar);
        if (kVarA.p()) {
            return kVarA.c();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    /* JADX WARN: Code duplicated, block: B:19:0x003e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    public final er c(dp dpVar, ev evVar, ai aiVar, d dVar, com.google.android.libraries.navigation.internal.qz.g gVar) {
        int iHashCode;
        er erVarB;
        Bitmap bitmapA;
        er erVarI;
        ab abVarG = aiVar != null ? aiVar.t : null;
        if (abVarG == null || !abVarG.c()) {
            String strValueOf = String.valueOf(getClass().getName());
            if (abVarG == null) {
                if (abVarG != null) {
                    abVarG = g(evVar, abVarG);
                }
                iHashCode = Arrays.hashCode(new Object[]{dpVar.c, abVarG, Float.valueOf(h(aiVar, dVar))});
                erVarB = b(iHashCode);
                if (erVarB != null) {
                    erVarI = erVarB;
                } else {
                    bitmapA = a(dpVar.c, abVarG, aiVar, dVar, this.d, strValueOf.concat("#getTextureForLabelElement()"), gVar);
                    if (bitmapA == null && abVarG != null) {
                        erVarI = i(iHashCode, bitmapA, this.c / abVarG.e);
                    } else {
                        erVarI = null;
                    }
                }
            } else {
                String str = abVarG.b;
                if (str == null && abVarG.c == null) {
                    erVarI = null;
                } else if (str != null) {
                    erVarI = e(str, gVar, abVarG.d, 1.0f / abVarG.e);
                } else {
                    if (abVarG != null) {
                        abVarG = g(evVar, abVarG);
                    }
                    iHashCode = Arrays.hashCode(new Object[]{dpVar.c, abVarG, Float.valueOf(h(aiVar, dVar))});
                    erVarB = b(iHashCode);
                    if (erVarB != null) {
                        erVarI = erVarB;
                    } else {
                        bitmapA = a(dpVar.c, abVarG, aiVar, dVar, this.d, strValueOf.concat("#getTextureForLabelElement()"), gVar);
                        if (bitmapA == null) {
                            erVarI = null;
                        } else {
                            erVarI = i(iHashCode, bitmapA, this.c / abVarG.e);
                        }
                    }
                }
            }
        } else {
            erVarI = d(abVarG.f);
        }
        if (erVarI != null) {
            return erVarI;
        }
        return null;
    }
}
