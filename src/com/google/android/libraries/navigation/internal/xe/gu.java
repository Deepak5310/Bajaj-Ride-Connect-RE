package com.google.android.libraries.navigation.internal.xe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.libraries.navigation.NavigationRoadStretchRenderingData;
import com.google.android.libraries.navigation.internal.adr.ii;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class gu extends com.google.android.libraries.navigation.internal.ms.bt<gv> {
    public static LayerDrawable a;
    public static final com.google.android.libraries.navigation.internal.nc.ap b = com.google.android.libraries.navigation.internal.nc.a.g(6);
    private static final com.google.android.libraries.navigation.internal.nc.ah c = com.google.android.libraries.navigation.internal.ae.b.d(com.google.android.libraries.navigation.internal.dw.g.f418n);
    private static final com.google.android.libraries.navigation.internal.nc.x d;
    private static final com.google.android.libraries.navigation.internal.nc.ah f;
    private static final ViewOutlineProvider g;

    static {
        com.google.android.libraries.navigation.internal.nc.ae aeVar = new com.google.android.libraries.navigation.internal.nc.ae(-12216321);
        d = aeVar;
        com.google.android.libraries.navigation.internal.nc.ah ahVarD = com.google.android.libraries.navigation.internal.ae.b.d(com.google.android.libraries.navigation.internal.dw.g.m);
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(4);
        f = new com.google.android.libraries.navigation.internal.nc.al(new Object[]{ahVarD, aVarG, aeVar}, ahVarD, aVarG, aeVar);
        g = new gt();
    }

    static double b(int i, float f2, int i2) {
        return (((double) i) / ((double) i2)) * ((double) f2);
    }

    static float c(Context context) {
        return (int) (context.getResources().getDisplayMetrics().density * (context.getResources().getConfiguration().orientation == 2 ? 120.0f : 290.0f));
    }

    public static ShapeDrawable h(int i, int i2) {
        LayerDrawable layerDrawable = a;
        ShapeDrawable shapeDrawable = (layerDrawable == null || i >= layerDrawable.getNumberOfLayers() + (-1)) ? new ShapeDrawable(new RectShape()) : (ShapeDrawable) a.getDrawable(i);
        shapeDrawable.getPaint().setColor(i2);
        return shapeDrawable;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        return new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(40)), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(-10)), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.h(), com.google.android.libraries.navigation.internal.ms.bz.q()), com.google.android.libraries.navigation.internal.ms.ah.aq(1), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.aJ(c), com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(20)), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(20)), com.google.android.libraries.navigation.internal.ms.ch.e(com.google.android.libraries.navigation.internal.ms.e.TRANSLATION_Z, com.google.android.libraries.navigation.internal.nc.a.g(20))), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(12)), com.google.android.libraries.navigation.internal.ms.ch.c(com.google.android.libraries.navigation.internal.ms.e.LAYOUT_HEIGHT, new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.gr
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                return Integer.valueOf((int) gu.c(context));
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(-10)), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(4)), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.w(true), com.google.android.libraries.navigation.internal.ms.ch.e(com.google.android.libraries.navigation.internal.ms.e.OUTLINE_PROVIDER, g)}), com.google.android.libraries.navigation.internal.ms.ah.o(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.gs
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                int i;
                ii iiVar;
                gl glVarA = ((gv) csVar).a();
                int iA = glVarA.a();
                int i2 = glVarA.b;
                List<NavigationRoadStretchRenderingData> arrayList = (i2 == 0 || (iiVar = glVarA.a) == null) ? new ArrayList<>() : bc.a(iiVar, glVarA.d, 0).getRoadStretchRenderingDataList();
                float fC = gu.c(context);
                double d2 = fC;
                Drawable[] drawableArr = new Drawable[arrayList.size() + 3];
                drawableArr[0] = gu.h(0, -12216321);
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    NavigationRoadStretchRenderingData navigationRoadStretchRenderingData = arrayList.get(i3);
                    i3++;
                    NavigationRoadStretchRenderingData.Style style = navigationRoadStretchRenderingData.getStyle();
                    NavigationRoadStretchRenderingData.Style style2 = NavigationRoadStretchRenderingData.Style.UNKNOWN;
                    int iOrdinal = style.ordinal();
                    if (iOrdinal != 1) {
                        i = iOrdinal != 2 ? -12216321 : -1245162;
                    } else {
                        i = -485842;
                    }
                    drawableArr[i3] = gu.h(i3, i);
                }
                drawableArr[arrayList.size() + 1] = gu.h(arrayList.size() + 1, -3881788);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setStroke(6, -1);
                gradientDrawable.setColor(0);
                gradientDrawable.setCornerRadius(gu.b.a(context));
                drawableArr[arrayList.size() + 2] = gradientDrawable;
                gu.a = new LayerDrawable(drawableArr);
                int i4 = 0;
                while (i4 < arrayList.size()) {
                    NavigationRoadStretchRenderingData navigationRoadStretchRenderingData2 = arrayList.get(i4);
                    double dB = gu.b(navigationRoadStretchRenderingData2.getOffsetMeters(), fC, i2);
                    i4++;
                    gu.a.setLayerInset(i4, 0, Math.max((int) Math.round((d2 - dB) - Math.max(1.0d, gu.b(navigationRoadStretchRenderingData2.getLengthMeters(), fC, i2))), 0), 0, (int) Math.round(dB));
                }
                gu.a.setLayerInset(arrayList.size() + 1, 0, (int) Math.round(d2 - (iA == 0 ? 0.0d : gu.b(iA, fC, i2))), 0, 0);
                gu.a.setLayerInset(2 + arrayList.size(), 0, 0, 0, 0);
                return gu.a;
            }
        }))), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.aJ(f), com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(38)), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(32)), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(-9)), com.google.android.libraries.navigation.internal.ms.ch.c(com.google.android.libraries.navigation.internal.ms.e.LAYOUT_MARGIN_TOP, new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.gq
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                LayerDrawable layerDrawable = gu.a;
                gl glVarA = ((gv) csVar).a();
                int i = glVarA.b;
                return Integer.valueOf(i != 0 ? (-64) + ((int) ((-(glVarA.a() / i)) * gu.c(context))) : -64);
            }
        })));
    }
}
