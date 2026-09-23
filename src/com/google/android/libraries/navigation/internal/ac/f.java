package com.google.android.libraries.navigation.internal.ac;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.android.apps.gmm.base.views.core.ExpandableTextView;
import com.google.android.apps.gmm.base.views.linear.CircularMaskedLinearLayout;
import com.google.android.apps.gmm.base.views.linear.ClippingLinearLayout;
import com.google.android.apps.gmm.base.views.linear.CompactMultiTextLinearLayout;
import com.google.android.apps.gmm.base.views.linear.EllipsizingListLayout;
import com.google.android.apps.gmm.base.views.listview.EllipsizedList;
import com.google.android.apps.gmm.base.views.listview.EllipsizedMultiLineList;
import com.google.android.apps.gmm.base.views.scrollview.GmmHorizontalScrollView;
import com.google.android.apps.gmm.base.views.squeezedlabel.SqueezedLabelView;
import com.google.android.apps.gmm.base.views.textview.ConstrainedTextView;
import com.google.android.apps.gmm.base.views.textview.ShortVersionEllipsizingTextView;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.gz.i;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.jy.x;
import com.google.android.libraries.navigation.internal.ms.bq;
import com.google.android.libraries.navigation.internal.ms.cf;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cn;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.m;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.t;
import com.google.android.libraries.navigation.internal.yx.ao;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zp.bh;
import com.google.android.libraries.navigation.internal.zp.bi;
import com.google.android.libraries.navigation.internal.zp.bj;
import com.google.android.libraries.navigation.internal.zp.bk;
import com.google.android.libraries.navigation.internal.zq.r;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class f extends com.google.android.libraries.navigation.internal.ms.a {
    public static final bq a;
    private static final View.OnLayoutChangeListener f;
    public final af b;
    public final com.google.android.libraries.navigation.internal.iv.f c;
    public final Handler d = new e(Looper.getMainLooper());
    private final com.google.android.libraries.navigation.internal.ab.a g;

    static {
        cf.a = false;
        cf.b = true;
        f = new b();
        a = new bq();
    }

    public f(af afVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.ab.a aVar) {
        this.b = afVar;
        this.c = fVar;
        ar.q(aVar);
        this.g = aVar;
    }

    private static boolean c(Object obj, View view) {
        if ((view instanceof EllipsizingListLayout) && (obj instanceof Integer)) {
            ((EllipsizingListLayout) view).a = ((Integer) obj).intValue() == 1;
            return true;
        }
        if ((view instanceof RecyclerView) && (obj instanceof Integer)) {
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
            if (layoutManager instanceof com.google.android.libraries.navigation.internal.an.a) {
                com.google.android.libraries.navigation.internal.an.a aVar = (com.google.android.libraries.navigation.internal.an.a) layoutManager;
                int iIntValue = ((Integer) obj).intValue();
                if (aVar.a != iIntValue) {
                    aVar.c = 0;
                    aVar.a = iIntValue;
                    aVar.b = OrientationHelper.createOrientationHelper(aVar, iIntValue);
                    aVar.requestLayout();
                }
                return true;
            }
        }
        return false;
    }

    private final boolean d(Object obj, View view) {
        bh bhVar;
        if (!(obj instanceof aa) && obj != null) {
            return false;
        }
        aa aaVarB = null;
        if (obj != null) {
            aa aaVar = (aa) obj;
            if (aaVar.j()) {
                x xVarB = aa.b(aaVar);
                int i = r.b;
                bi biVarD = xVarB.d();
                if (biVarD == null) {
                    bhVar = (bh) bi.a.q();
                } else {
                    bb bbVar = (bb) biVarD.aH(5, null);
                    bbVar.x(biVarD);
                    bhVar = (bh) bbVar;
                }
                com.google.android.libraries.navigation.internal.zq.a aVar = (com.google.android.libraries.navigation.internal.zq.a) com.google.android.libraries.navigation.internal.zq.b.a.q();
                if (!aVar.b.H()) {
                    aVar.v();
                }
                com.google.android.libraries.navigation.internal.zq.b bVar = (com.google.android.libraries.navigation.internal.zq.b) aVar.b;
                int i2 = i - 1;
                if (i == 0) {
                    throw null;
                }
                bVar.c = i2;
                bVar.b |= 1;
                com.google.android.libraries.navigation.internal.zq.b bVar2 = (com.google.android.libraries.navigation.internal.zq.b) aVar.t();
                if (!bhVar.b.H()) {
                    bhVar.v();
                }
                bi biVar = (bi) bhVar.b;
                bVar2.getClass();
                biVar.g = bVar2;
                biVar.d |= 16;
                xVarB.j((bi) bhVar.t());
                bj bjVar = xVarB.c;
                com.google.android.libraries.navigation.internal.zq.c cVar = (com.google.android.libraries.navigation.internal.zq.c) com.google.android.libraries.navigation.internal.zq.d.a.q();
                if (!cVar.b.H()) {
                    cVar.v();
                }
                com.google.android.libraries.navigation.internal.zq.d dVar = (com.google.android.libraries.navigation.internal.zq.d) cVar.b;
                if (i == 0) {
                    throw null;
                }
                dVar.c = i2;
                dVar.b |= 1;
                com.google.android.libraries.navigation.internal.zq.d dVar2 = (com.google.android.libraries.navigation.internal.zq.d) cVar.t();
                if (!bjVar.b.H()) {
                    bjVar.v();
                }
                bk bkVar = (bk) bjVar.b;
                bk bkVar2 = bk.a;
                dVar2.getClass();
                bkVar.f = dVar2;
                bkVar.b |= Integer.MIN_VALUE;
                aaVarB = xVarB.b();
            }
        }
        com.google.android.libraries.navigation.internal.jw.e.f(view, aaVarB);
        this.g.a(view);
        return true;
    }

    private final void e(Object obj, View view) {
        cn cnVarA = cn.a(view);
        if (obj != null) {
            cnVarA.c(com.google.android.libraries.navigation.internal.ab.e.a, new d(this, view, obj));
        } else {
            cnVarA.c(com.google.android.libraries.navigation.internal.ab.e.a, null);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.a, com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        int iIntValue;
        View view = ckVar.c;
        Object obj2 = null;
        if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ad.b)) {
            if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ms.e)) {
                if (!(cwVar instanceof com.google.android.libraries.navigation.internal.mz.b)) {
                    return false;
                }
                int iOrdinal = ((com.google.android.libraries.navigation.internal.mz.b) cwVar).ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 21) {
                        return false;
                    }
                    return c(obj, view);
                }
                if (!(view instanceof ConstrainedTextView) || !(obj instanceof com.google.android.libraries.navigation.internal.nb.b)) {
                    return false;
                }
                throw null;
            }
            int iOrdinal2 = ((com.google.android.libraries.navigation.internal.ms.e) cwVar).ordinal();
            if (iOrdinal2 == 119) {
                if (!(obj instanceof ap)) {
                    return false;
                }
                ((ap) obj).d(view.getContext());
                if (view instanceof com.google.android.apps.gmm.base.views.scrollview.d) {
                    throw null;
                }
                if (!(view instanceof com.google.android.libraries.navigation.internal.am.b)) {
                    return false;
                }
                throw null;
            }
            if (iOrdinal2 != 123) {
                if (iOrdinal2 == 151) {
                    e(obj, view);
                    return true;
                }
                if (iOrdinal2 != 164) {
                    return false;
                }
                return c(obj, view);
            }
            if (!(view instanceof com.google.android.libraries.navigation.internal.am.b) || !(obj instanceof ap)) {
                return false;
            }
            ((ap) obj).d(view.getContext());
            throw null;
        }
        int iOrdinal3 = ((com.google.android.libraries.navigation.internal.ad.b) cwVar).ordinal();
        if (iOrdinal3 == 5) {
            if (!(view instanceof ExpandableTextView) || obj == null) {
                return false;
            }
            ExpandableTextView expandableTextView = (ExpandableTextView) view;
            com.google.android.apps.gmm.base.views.core.b bVar = new com.google.android.apps.gmm.base.views.core.b(((Boolean) obj).booleanValue());
            expandableTextView.a = bVar.b;
            expandableTextView.b = bVar.a;
            return true;
        }
        if (iOrdinal3 == 11) {
            if (!(view instanceof com.google.android.libraries.navigation.internal.am.a)) {
                return false;
            }
            if (!(obj instanceof Number)) {
                return true;
            }
            ((Number) obj).floatValue();
            throw null;
        }
        if (iOrdinal3 == 25) {
            if (!(view instanceof ExpandableTextView)) {
                return false;
            }
            if (obj == null) {
                return true;
            }
            ExpandableTextView expandableTextView2 = (ExpandableTextView) view;
            int iIntValue2 = ((Integer) obj).intValue();
            expandableTextView2.c = iIntValue2;
            if (true == expandableTextView2.b) {
                iIntValue2 = Integer.MAX_VALUE;
            }
            expandableTextView2.setMaxLines(iIntValue2);
            expandableTextView2.requestLayout();
            return true;
        }
        if (iOrdinal3 == 46) {
            if (!(obj instanceof Boolean)) {
                return false;
            }
            view.setTag(ClippingLinearLayout.a, (Boolean) obj);
            return true;
        }
        if (iOrdinal3 == 53) {
            if (view instanceof EllipsizedList) {
                if (obj == null) {
                    return true;
                }
                ((EllipsizedList) view).setMarginBetweenItems(((ap) obj).d(view.getContext()));
                return true;
            }
            if (!(view instanceof EllipsizedMultiLineList)) {
                return false;
            }
            if (obj == null) {
                return true;
            }
            ((EllipsizedMultiLineList) view).setMarginBetweenItems(((ap) obj).d(view.getContext()));
            return true;
        }
        if (iOrdinal3 == 58) {
            if (!(obj instanceof com.google.android.libraries.navigation.internal.ki.a)) {
                return false;
            }
            ((com.google.android.libraries.navigation.internal.ki.a) obj).a = view;
            return true;
        }
        if (iOrdinal3 == 80) {
            cn cnVarA = cn.a(view);
            if (obj != null) {
                cnVarA.b(com.google.android.libraries.navigation.internal.ab.e.a, new c(this, view, obj, ckVar));
            } else {
                cnVarA.b(com.google.android.libraries.navigation.internal.ab.e.a, null);
            }
            view.setOnClickListener(new a(this));
            return true;
        }
        if (iOrdinal3 == 85) {
            if (!(obj instanceof Boolean)) {
                return false;
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            int i = ClippingLinearLayout.a;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            com.google.android.apps.gmm.base.views.linear.b bVar2 = layoutParams == null ? new com.google.android.apps.gmm.base.views.linear.b() : new com.google.android.apps.gmm.base.views.linear.b(layoutParams);
            bVar2.a = zBooleanValue;
            view.setLayoutParams(bVar2);
            return true;
        }
        if (iOrdinal3 == 99) {
            if (!(view instanceof ShortVersionEllipsizingTextView)) {
                return false;
            }
            if (!(obj instanceof CharSequence)) {
                if (obj != null) {
                    return false;
                }
                obj = null;
            }
            ShortVersionEllipsizingTextView shortVersionEllipsizingTextView = (ShortVersionEllipsizingTextView) view;
            shortVersionEllipsizingTextView.a = (CharSequence) obj;
            shortVersionEllipsizingTextView.forceLayout();
            return true;
        }
        if (iOrdinal3 == 101) {
            if (!(view instanceof com.google.android.apps.gmm.base.views.textview.c) || !(obj instanceof Boolean)) {
                return false;
            }
            ((Boolean) obj).booleanValue();
            throw null;
        }
        if (iOrdinal3 == 28) {
            if (!(obj instanceof com.google.android.libraries.navigation.internal.al.a)) {
                return false;
            }
            if (view instanceof com.google.android.libraries.navigation.internal.ada.a) {
                com.google.android.libraries.navigation.internal.al.a aVar = (com.google.android.libraries.navigation.internal.al.a) obj;
                int i2 = aVar.a;
                int i3 = aVar.b;
                int i4 = aVar.c;
                throw null;
            }
            if (!(view instanceof com.google.android.libraries.navigation.internal.adb.a)) {
                return false;
            }
            com.google.android.libraries.navigation.internal.al.a aVar2 = (com.google.android.libraries.navigation.internal.al.a) obj;
            int i5 = aVar2.a;
            int i6 = aVar2.b;
            int i7 = aVar2.c;
            throw null;
        }
        if (iOrdinal3 == 29) {
            if (!(view instanceof SqueezedLabelView)) {
                return false;
            }
            if (obj == null) {
                return true;
            }
            ((SqueezedLabelView) view).setDesiredTextSize(((ap) obj).a(view.getContext()));
            return true;
        }
        if (iOrdinal3 == 55) {
            if (!(view instanceof com.google.android.apps.gmm.base.views.textview.c)) {
                return false;
            }
            if (!(obj instanceof CharSequence)) {
                if (obj != null) {
                    return false;
                }
                obj = null;
            }
            throw null;
        }
        if (iOrdinal3 == 56) {
            if (!(view instanceof EllipsizedMultiLineList)) {
                return false;
            }
            if (obj == null) {
                return true;
            }
            ((EllipsizedMultiLineList) view).setMarginBetweenLines(((ap) obj).d(view.getContext()));
            return true;
        }
        if (iOrdinal3 == 82) {
            if (!(view instanceof com.google.android.libraries.navigation.internal.ak.b)) {
                return false;
            }
            if (!(obj instanceof com.google.android.libraries.navigation.internal.ak.a)) {
                return false;
            }
            throw null;
        }
        if (iOrdinal3 == 83) {
            if (!(view instanceof ShortVersionEllipsizingTextView)) {
                return false;
            }
            ShortVersionEllipsizingTextView shortVersionEllipsizingTextView2 = (ShortVersionEllipsizingTextView) view;
            if (!(obj instanceof CharSequence)) {
                if (obj != null) {
                    if (!(obj instanceof t)) {
                        return false;
                    }
                    shortVersionEllipsizingTextView2.setOriginalText(((t) obj).b(view.getContext()));
                    return true;
                }
                obj = null;
            }
            shortVersionEllipsizingTextView2.setOriginalText((CharSequence) obj);
            return true;
        }
        if (iOrdinal3 == 96) {
            if (!(view instanceof com.google.android.libraries.navigation.internal.ao.a)) {
                return false;
            }
            if (!(obj instanceof com.google.android.libraries.navigation.internal.ao.b)) {
                if (obj != null) {
                    return false;
                }
                obj = null;
            }
            throw null;
        }
        if (iOrdinal3 == 97) {
            if ((view instanceof com.google.android.apps.gmm.base.views.scrollview.c) && (obj instanceof com.google.android.apps.gmm.base.views.scrollview.b)) {
                throw null;
            }
            if (!(view instanceof GmmHorizontalScrollView) || !(obj instanceof com.google.android.apps.gmm.base.views.scrollview.a)) {
                return false;
            }
            ((GmmHorizontalScrollView) view).a = (com.google.android.apps.gmm.base.views.scrollview.a) obj;
            return true;
        }
        switch (iOrdinal3) {
            case 15:
                if (!(view instanceof CircularMaskedLinearLayout) || !(obj instanceof Integer)) {
                    return false;
                }
                CircularMaskedLinearLayout circularMaskedLinearLayout = (CircularMaskedLinearLayout) view;
                int color = circularMaskedLinearLayout.getResources().getColor(((Integer) obj).intValue());
                if (circularMaskedLinearLayout.b == color) {
                    return true;
                }
                circularMaskedLinearLayout.b = color;
                circularMaskedLinearLayout.a = null;
                return true;
            case 16:
                if (!(view instanceof CircularMaskedLinearLayout)) {
                    return false;
                }
                CircularMaskedLinearLayout circularMaskedLinearLayout2 = (CircularMaskedLinearLayout) view;
                if (obj instanceof ap) {
                    iIntValue = ((ap) obj).e(view.getContext());
                } else {
                    if (!(obj instanceof Integer)) {
                        throw new IllegalArgumentException("Unable to resolve dimension pixel size: ".concat(String.valueOf(String.valueOf(obj))));
                    }
                    iIntValue = ((Integer) obj).intValue();
                }
                circularMaskedLinearLayout2.c = iIntValue;
                return true;
            case 17:
                if (!(view instanceof com.google.android.libraries.navigation.internal.ao.a)) {
                    return false;
                }
                m.aY(obj, view);
                throw null;
            default:
                switch (iOrdinal3) {
                    case 32:
                        if (!(view instanceof com.google.android.libraries.navigation.internal.ak.b)) {
                            return false;
                        }
                        if (obj == null) {
                            throw null;
                        }
                        throw null;
                    case 33:
                        if (!(obj instanceof Integer)) {
                            return false;
                        }
                        if (view instanceof EllipsizedList) {
                            EllipsizedList ellipsizedList = (EllipsizedList) view;
                            ellipsizedList.a = ((Integer) obj).intValue();
                            ellipsizedList.requestLayout();
                            ellipsizedList.invalidate();
                            return true;
                        }
                        if (view instanceof EllipsizingListLayout) {
                            ((EllipsizingListLayout) view).b = ((Integer) obj).intValue();
                            return true;
                        }
                        if (!(view instanceof EllipsizedMultiLineList)) {
                            return false;
                        }
                        EllipsizedMultiLineList ellipsizedMultiLineList = (EllipsizedMultiLineList) view;
                        ellipsizedMultiLineList.a = ((Integer) obj).intValue();
                        ellipsizedMultiLineList.requestLayout();
                        ellipsizedMultiLineList.invalidate();
                        return true;
                    case 34:
                        if (!(view instanceof com.google.android.apps.gmm.base.views.listview.a)) {
                            return false;
                        }
                        if (obj == null) {
                            return true;
                        }
                        ((Boolean) obj).booleanValue();
                        throw null;
                    case 35:
                        if (!(view instanceof com.google.android.apps.gmm.base.views.textview.c)) {
                            return false;
                        }
                        if (!(obj instanceof CharSequence)) {
                            if (obj != null) {
                                return false;
                            }
                            obj = null;
                        }
                        throw null;
                    case 36:
                        if (!(view instanceof ExpandableTextView) || obj == null) {
                            return false;
                        }
                        ((ExpandableTextView) view).setExpanded$ar$ds(((Boolean) obj).booleanValue());
                        return true;
                    case 37:
                        if (!(view instanceof ConstrainedTextView)) {
                            return false;
                        }
                        if (obj != null) {
                            ((ConstrainedTextView) view).b = (com.google.android.apps.gmm.base.views.textview.b) obj;
                            return true;
                        }
                        ((ConstrainedTextView) view).b = ConstrainedTextView.a;
                        return true;
                    default:
                        switch (iOrdinal3) {
                            case 64:
                                if (!(obj instanceof Integer)) {
                                    return true;
                                }
                                view.setTag(((Integer) obj).intValue(), Boolean.TRUE);
                                return true;
                            case 65:
                                if (!(view instanceof com.google.android.apps.gmm.base.views.textview.a) || !(obj instanceof Integer)) {
                                    return false;
                                }
                                throw null;
                            case 66:
                                if (!(view instanceof CompactMultiTextLinearLayout)) {
                                    return false;
                                }
                                if (obj == null) {
                                    return true;
                                }
                                ((CompactMultiTextLinearLayout) view).setMaxLinesInTotal(((Integer) obj).intValue());
                                return true;
                            case 67:
                                if (!(view instanceof CompactMultiTextLinearLayout)) {
                                    return false;
                                }
                                if (obj == null) {
                                    return true;
                                }
                                ((CompactMultiTextLinearLayout) view).setMaxLinesPerView(((Integer) obj).intValue());
                                return true;
                            case 68:
                                if (!(view instanceof com.google.android.apps.gmm.base.views.textview.a) || !(obj instanceof Integer)) {
                                    return false;
                                }
                                throw null;
                            case 69:
                                if (!(view instanceof SqueezedLabelView)) {
                                    return false;
                                }
                                if (obj == null) {
                                    return true;
                                }
                                ((SqueezedLabelView) view).setMinScaleX(((Float) obj).floatValue());
                                return true;
                            case 70:
                                if (!(view instanceof SqueezedLabelView)) {
                                    return false;
                                }
                                if (obj == null) {
                                    return true;
                                }
                                ((SqueezedLabelView) view).setMinTextSize(((ap) obj).e(view.getContext()));
                                return true;
                            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                                view.setScaleX(true != i.d(view) ? 1.0f : -1.0f);
                                return true;
                            default:
                                switch (iOrdinal3) {
                                    case 108:
                                        if (!(view instanceof com.google.android.libraries.navigation.internal.ao.a)) {
                                            return false;
                                        }
                                        m.aY(obj, view);
                                        throw null;
                                    case 109:
                                        if (obj == null) {
                                            view.removeOnLayoutChangeListener(f);
                                            ckVar.o(a, null);
                                            view.setTranslationY(0.0f);
                                            return true;
                                        }
                                        if (!(obj instanceof Number)) {
                                            return false;
                                        }
                                        View.OnLayoutChangeListener onLayoutChangeListener = f;
                                        view.addOnLayoutChangeListener(onLayoutChangeListener);
                                        ckVar.o(a, (Number) obj);
                                        onLayoutChangeListener.onLayoutChange(view, 0, 0, 0, 0, 0, 0, 0, 0);
                                        return true;
                                    case 110:
                                        return d(obj, view);
                                    case PanasonicMakernoteDirectory.TAG_LANDMARK /* 111 */:
                                        if (!(obj instanceof ao)) {
                                            return false;
                                        }
                                        ao aoVar = (ao) obj;
                                        Object obj3 = aoVar.a;
                                        Object obj4 = aoVar.b;
                                        if (obj3 instanceof aa) {
                                            obj2 = obj3;
                                        } else if (obj3 != null) {
                                            return false;
                                        }
                                        if (obj4 instanceof com.google.android.libraries.navigation.internal.afd.a) {
                                            return d(com.google.android.libraries.navigation.internal.jw.e.g((aa) obj2, (com.google.android.libraries.navigation.internal.afd.a) obj4), view);
                                        }
                                        return false;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.a, com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        boolean z = cwVar instanceof com.google.android.libraries.navigation.internal.ms.e;
        View view = ckVar.c;
        if (z) {
            if (((com.google.android.libraries.navigation.internal.ms.e) cwVar).ordinal() != 151) {
                return false;
            }
            e(null, view);
            return true;
        }
        if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ad.b)) {
            return false;
        }
        int iOrdinal = ((com.google.android.libraries.navigation.internal.ad.b) cwVar).ordinal();
        if (iOrdinal != 110 && iOrdinal != 111) {
            return false;
        }
        com.google.android.libraries.navigation.internal.ab.a.b(view);
        com.google.android.libraries.navigation.internal.jw.e.f(view, null);
        return true;
    }
}
