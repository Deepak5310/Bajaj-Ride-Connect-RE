package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.Point;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w {
    private static final String e = "w";
    public static final w a = new w();
    public static final ThreadLocal b = new u();
    private static final ThreadLocal f = new u();
    public static final ThreadLocal c = new u();
    private static final ThreadLocal g = new v();
    public static final ThreadLocal d = new u();

    private w() {
    }

    static void d(Canvas canvas, Path path, int i, float f2, int i2, Paint paint) {
        com.google.android.libraries.navigation.internal.abf.s.k(canvas, "canvas");
        com.google.android.libraries.navigation.internal.abf.s.k(paint, "paint");
        if (path.isEmpty() || f2 <= 0.0f || Color.alpha(i) == 0) {
            return;
        }
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setPathEffect(null);
        e(paint, i2, f2);
        canvas.drawPath(path, paint);
    }

    static void e(Paint paint, int i, float f2) {
        com.google.android.libraries.navigation.internal.abf.s.k(paint, "paint");
        com.google.android.libraries.navigation.internal.abf.s.a(f2 > 0.0f, com.google.android.libraries.navigation.internal.b.b.h(f2, "strokeWidthPx <= 0: "));
        if (i == 1) {
            paint.setStrokeJoin(Paint.Join.BEVEL);
        } else if (i == 2) {
            paint.setStrokeJoin(Paint.Join.ROUND);
        } else {
            paint.setStrokeMiter(f2 * 0.5f);
            paint.setStrokeJoin(Paint.Join.MITER);
        }
    }

    public final void a(List list, aa aaVar, List list2, Path path) {
        float fE = aaVar.e();
        int iCeil = (int) Math.ceil((aaVar.f - fE) / (fE + fE));
        for (int i = -iCeil; i <= iCeil; i++) {
            int i2 = 0;
            Point pointA = aaVar.a((LatLng) list.get(0));
            ArrayList<Point> arrayList = new ArrayList();
            float f2 = i * fE;
            path.moveTo(pointA.x + f2, pointA.y);
            arrayList.add(new Point((int) (pointA.x + f2), pointA.y));
            int i3 = 1;
            int i4 = 0;
            Point point = pointA;
            while (i3 < list.size()) {
                Point pointA2 = aaVar.a((LatLng) list.get(i3));
                if (pointA2.x - point.x > fE / 2.0f) {
                    i4--;
                } else {
                    if (pointA2.x - point.x < (-fE) / 2.0f) {
                        i4++;
                    }
                }
                float f3 = (i + i4) * fE;
                path.lineTo(pointA2.x + f3, pointA2.y);
                arrayList.add(new Point((int) (pointA2.x + f3), pointA2.y));
                i3++;
                point = pointA2;
            }
            if (pointA.x == point.x + (i4 * fE) && pointA.y == point.y) {
                path.close();
            }
            int size = arrayList.size();
            int[] iArr = new int[size + size];
            for (Point point2 : arrayList) {
                iArr[i2] = point2.x;
                iArr[i2 + 1] = point2.y;
                i2 += 2;
            }
            list2.add(new com.google.android.libraries.navigation.internal.abj.d(iArr));
        }
    }

    public final void b(Canvas canvas, Path path, PatternItem[] patternItemArr, int i, int i2, float f2) {
        int length;
        int i3;
        float f3;
        boolean z;
        int length2;
        Paint paint = (Paint) c.get();
        Path path2 = (Path) g.get();
        com.google.android.libraries.navigation.internal.abf.s.k(canvas, "canvas");
        com.google.android.libraries.navigation.internal.abf.s.k(paint, "paint");
        com.google.android.libraries.navigation.internal.abf.s.k(path2, "dotShapePath");
        int i4 = 5;
        if (!path.isEmpty() && (length2 = patternItemArr.length) != 0 && f2 > 0.0f && Color.alpha(i) != 0) {
            float f4 = 0.5f * f2;
            ArrayList arrayList = new ArrayList(length2);
            float fFloatValue = 0.0f;
            int i5 = 0;
            while (i5 < patternItemArr.length) {
                PatternItem patternItem = patternItemArr[i5];
                if (patternItem == null) {
                    com.google.android.libraries.navigation.internal.abf.p.f(e, i4);
                } else if (patternItem.a == 1) {
                    arrayList.add(Float.valueOf(-(fFloatValue + f4)));
                    fFloatValue += f2;
                } else {
                    fFloatValue += patternItem.b.floatValue();
                }
                i5++;
                i4 = 5;
            }
            if (!arrayList.isEmpty()) {
                paint.reset();
                paint.setAntiAlias(true);
                paint.setColor(i);
                paint.setStyle(Paint.Style.STROKE);
                path2.reset();
                path2.addCircle(0.0f, 0.0f, f4, Path.Direction.CCW);
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    paint.setPathEffect(new PathDashPathEffect(path2, fFloatValue, ((Float) arrayList.get(i6)).floatValue(), PathDashPathEffect.Style.TRANSLATE));
                    canvas.drawPath(path, paint);
                }
            }
        }
        Paint paint2 = (Paint) f.get();
        com.google.android.libraries.navigation.internal.abf.s.k(canvas, "canvas");
        com.google.android.libraries.navigation.internal.abf.s.k(paint2, "paint");
        if (path.isEmpty() || f2 <= 0.0f || (length = patternItemArr.length) == 0 || Color.alpha(i) == 0) {
            return;
        }
        List arrayList2 = new ArrayList(length + 1);
        com.google.android.libraries.navigation.internal.abf.s.a(true, com.google.android.libraries.navigation.internal.b.b.h(f2, "dotDiameterPx <= 0: "));
        arrayList2.clear();
        boolean z2 = false;
        boolean z3 = false;
        for (PatternItem patternItem2 : patternItemArr) {
            if (patternItem2 == null) {
                com.google.android.libraries.navigation.internal.abf.p.f(e, 5);
            } else {
                int i7 = patternItem2.a;
                float fFloatValue2 = i7 == 1 ? f2 : patternItem2.b.floatValue();
                boolean z4 = i7 == 0;
                if (arrayList2.isEmpty()) {
                    arrayList2.add(Float.valueOf(fFloatValue2));
                    z2 = z4;
                } else if (z3 == z4) {
                    int size2 = arrayList2.size() - 1;
                    arrayList2.set(size2, Float.valueOf(((Float) arrayList2.get(size2)).floatValue() + fFloatValue2));
                } else {
                    arrayList2.add(Float.valueOf(fFloatValue2));
                }
                z3 = z4;
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        if (arrayList2.size() == 1) {
            if (z2) {
                d(canvas, path, i, f2, i2, paint2);
                return;
            }
            return;
        }
        if (arrayList2.size() % 2 == 1) {
            float fFloatValue3 = ((Float) arrayList2.remove(arrayList2.size() - 1)).floatValue();
            i3 = 0;
            arrayList2.set(0, Float.valueOf(((Float) arrayList2.get(0)).floatValue() + fFloatValue3));
            f3 = fFloatValue3 + 0.0f;
        } else {
            i3 = 0;
            f3 = 0.0f;
        }
        if (z2) {
            z = true;
        } else {
            Float f5 = (Float) arrayList2.get(i3);
            float fFloatValue4 = f5.floatValue();
            arrayList2.add(f5);
            z = true;
            arrayList2 = arrayList2.subList(1, arrayList2.size());
            f3 -= fFloatValue4;
        }
        paint2.reset();
        paint2.setAntiAlias(z);
        paint2.setColor(i);
        paint2.setStrokeWidth(f2);
        paint2.setStyle(Paint.Style.STROKE);
        com.google.android.libraries.navigation.internal.abf.s.k(arrayList2, "List<Float>");
        int size3 = arrayList2.size();
        float[] fArr = new float[size3];
        for (int i8 = i3; i8 < size3; i8++) {
            fArr[i8] = ((Float) arrayList2.get(i8)).floatValue();
        }
        paint2.setPathEffect(new DashPathEffect(fArr, f3));
        e(paint2, i2, f2);
        canvas.drawPath(path, paint2);
    }

    public final void c(Canvas canvas, Path path, int i, float f2, int i2) {
        d(canvas, path, i, f2, i2, (Paint) b.get());
    }

    public final boolean f(float f2, float f3, List list) {
        com.google.android.libraries.navigation.internal.abf.s.k(list, "outlinesCanvasXY");
        int i = (int) f2;
        int iA = com.google.android.libraries.navigation.internal.abf.e.a(15.0d);
        int i2 = i - iA;
        int i3 = (int) f3;
        int i4 = i3 - iA;
        int i5 = i + iA;
        int i6 = i3 + iA;
        com.google.android.libraries.navigation.internal.abj.a aVar = new com.google.android.libraries.navigation.internal.abj.a(new com.google.android.libraries.navigation.internal.abj.c[]{new com.google.android.libraries.navigation.internal.abj.c(i2, i4), new com.google.android.libraries.navigation.internal.abj.c(i5, i4), new com.google.android.libraries.navigation.internal.abj.c(i5, i6), new com.google.android.libraries.navigation.internal.abj.c(i2, i6)});
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.abj.d dVar = (com.google.android.libraries.navigation.internal.abj.d) it2.next();
            int iD = dVar.d();
            if (iD > 1) {
                com.google.android.libraries.navigation.internal.abj.c cVar = new com.google.android.libraries.navigation.internal.abj.c();
                dVar.g(0, cVar);
                com.google.android.libraries.navigation.internal.abj.c cVar2 = new com.google.android.libraries.navigation.internal.abj.c();
                for (int i7 = 1; i7 < iD; i7++) {
                    dVar.g(i7, cVar2);
                    if (!aVar.a(cVar) && !aVar.a(cVar2)) {
                        com.google.android.libraries.navigation.internal.abj.c[] cVarArr = aVar.a;
                        if (!com.google.android.libraries.navigation.internal.abj.c.f(cVar, cVar2, cVarArr[0], cVarArr[1])) {
                            com.google.android.libraries.navigation.internal.abj.c[] cVarArr2 = aVar.a;
                            if (!com.google.android.libraries.navigation.internal.abj.c.f(cVar, cVar2, cVarArr2[1], cVarArr2[2])) {
                                com.google.android.libraries.navigation.internal.abj.c[] cVarArr3 = aVar.a;
                                if (!com.google.android.libraries.navigation.internal.abj.c.f(cVar, cVar2, cVarArr3[2], cVarArr3[3])) {
                                    com.google.android.libraries.navigation.internal.abj.c[] cVarArr4 = aVar.a;
                                    if (!com.google.android.libraries.navigation.internal.abj.c.f(cVar, cVar2, cVarArr4[3], cVarArr4[0])) {
                                        cVar.c(cVar2);
                                    }
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
