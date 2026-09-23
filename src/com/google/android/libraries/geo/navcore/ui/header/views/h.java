package com.google.android.libraries.geo.navcore.ui.header.views;

import android.content.res.Resources;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.adr.dr;
import com.google.android.libraries.navigation.internal.bp.ar;
import com.google.android.libraries.navigation.internal.gw.w;
import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(MultiIconView multiIconView, List list, com.google.android.libraries.navigation.internal.um.d dVar, com.google.android.libraries.navigation.internal.um.c cVar, int i) {
        int i2;
        int i3;
        int i4;
        e[] eVarArr;
        e eVar;
        List listA;
        int i5;
        int i6;
        List listO = list;
        if (listO == null) {
            int i7 = ev.d;
            multiIconView.setIcons(lv.a);
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        int i8 = 0;
        if (i > 0 && list.size() > i) {
            if (list.size() <= i) {
                listO = ev.o(list);
            } else {
                int size = list.size() - i;
                int size2 = -1;
                int i9 = -1;
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (size2 < 0 && ((ar) listO.get(i10)).b == dr.a) {
                        size2 = i10;
                    }
                    if (i9 < 0 && ((ar) listO.get((list.size() - i10) - 1)).b == dr.a) {
                        i9 = i10;
                    }
                }
                if (size2 < 0 || i9 < 0) {
                    size2 = list.size() / 2;
                    i9 = size2;
                }
                ArrayList arrayList2 = new ArrayList(listO);
                int i11 = size + 2;
                int iMax = Math.max(size2, i9);
                if (iMax >= i11) {
                    int i12 = size + 1;
                    listA = iMax == i9 ? f.a(arrayList2, 0, i12) : f.a(arrayList2, i12, 0);
                } else if (size2 + i9 >= size + 4) {
                    if (Math.min(size2, i9) == i9) {
                        i5 = i9 - 1;
                        i6 = (size - i5) + 2;
                    } else {
                        int i13 = size2 - 1;
                        i5 = (size - i13) + 2;
                        i6 = i13;
                    }
                    listA = f.a(arrayList2, i6, i5);
                } else {
                    listA = f.a(arrayList2, 0, size + 1);
                }
                listO = ev.o(listA);
            }
        }
        Iterator it2 = listO.iterator();
        while (it2.hasNext()) {
            arrayList.add(f.b((ar) it2.next())[0]);
        }
        ev evVarO = ev.o(arrayList);
        Resources resources = multiIconView.getResources();
        ArrayList arrayList3 = new ArrayList();
        int i14 = 0;
        while (i14 < evVarO.size()) {
            if (i14 > 0) {
                Picture pictureA = dVar.a.a(resources, com.google.android.libraries.navigation.internal.dw.g.c);
                com.google.android.libraries.navigation.internal.gw.o oVar = dVar.b;
                w wVarF = x.f();
                wVarF.b(z);
                com.google.android.libraries.navigation.internal.gw.d dVar2 = (com.google.android.libraries.navigation.internal.gw.d) wVarF;
                dVar2.a = Integer.valueOf(dVar.c);
                dVar2.b = Integer.valueOf(dVar.d);
                Drawable drawableB = oVar.b(resources, pictureA, wVarF.c());
                arrayList3.add(new g(drawableB, Math.round(drawableB.getIntrinsicWidth() / 2.0f), Math.round((i14 - 0.5f) * cVar.d), 0, false, cVar.c));
            }
            e[] eVarArr2 = (e[]) evVarO.get(i14);
            int length = eVarArr2.length;
            int i15 = i8;
            while (i15 < length) {
                e eVar2 = eVarArr2[i15];
                int i16 = eVar2.c ? cVar.a : cVar.b;
                int i17 = cVar.d;
                int i18 = cVar.e;
                com.google.android.libraries.navigation.internal.um.b bVar = eVar2.a;
                com.google.android.libraries.navigation.internal.um.a aVar = (com.google.android.libraries.navigation.internal.um.a) dVar.f.get(bVar);
                if (aVar == null) {
                    Picture pictureA2 = dVar.a.a(resources, bVar.m);
                    float width = pictureA2.getWidth();
                    float f = dVar.e;
                    float height = pictureA2.getHeight();
                    float f2 = dVar.e;
                    int i19 = i15;
                    float f3 = width * f;
                    float f4 = bVar.f619n * f3;
                    int iCeil = (int) Math.ceil(f4);
                    float f5 = iCeil - f4;
                    int i20 = length;
                    int iCeil2 = (int) Math.ceil(f3 + f5);
                    float f6 = height * f2;
                    int iCeil3 = (int) Math.ceil(f6);
                    i2 = i18;
                    eVar = eVar2;
                    i3 = i19;
                    i4 = i20;
                    eVarArr = eVarArr2;
                    com.google.android.libraries.navigation.internal.um.a aVar2 = new com.google.android.libraries.navigation.internal.um.a(dVar, resources, pictureA2, iCeil2, iCeil3, com.google.android.libraries.navigation.internal.o.d.e(f5, iCeil3 - f6, f3, f6), iCeil);
                    dVar.f.put(bVar, aVar2);
                    aVar = aVar2;
                } else {
                    i2 = i18;
                    i3 = i15;
                    i4 = length;
                    eVarArr = eVarArr2;
                    eVar = eVar2;
                }
                arrayList3.add(new g(aVar.b(), aVar.a(), i14 * i17, -i2, eVar.b, i16));
                i15 = i3 + 1;
                resources = resources;
                cVar = cVar;
                evVarO = evVarO;
                length = i4;
                eVarArr2 = eVarArr;
                i14 = i14;
            }
            i14++;
            z = true;
            i8 = 0;
        }
        multiIconView.setIcons(ev.o(arrayList3));
    }
}
