package com.google.android.apps.gmm.base.views.viewpager;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.mt.k;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements cx {
    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        int itemPosition;
        if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ad.b)) {
            return false;
        }
        View view = ckVar.c;
        int iOrdinal = ((com.google.android.libraries.navigation.internal.ad.b) cwVar).ordinal();
        if (iOrdinal == 79) {
            if (!(view instanceof ArrowViewPager)) {
                return false;
            }
            if (obj == null) {
                obj = null;
            } else if (!(obj instanceof ArrowViewPager.a)) {
                return false;
            }
            ((ArrowViewPager) view).j = (ArrowViewPager.a) obj;
            return true;
        }
        if (iOrdinal == 81) {
            if (!(view instanceof ArrowViewPager)) {
                return false;
            }
            if (obj == null) {
                obj = null;
            } else if (!(obj instanceof e)) {
                return false;
            }
            ((ArrowViewPager) view).k = (e) obj;
            return true;
        }
        if (iOrdinal == 114) {
            if (!(view instanceof ArrowViewPager) || !(obj instanceof Boolean)) {
                return false;
            }
            ((ArrowViewPager) view).c.setFocusable(((Boolean) obj).booleanValue());
            return true;
        }
        switch (iOrdinal) {
            case 7:
                if (!(view instanceof ArrowViewPager) || !(obj instanceof bt)) {
                    return false;
                }
                ArrowViewPager arrowViewPager = (ArrowViewPager) view;
                k kVar = new k(ckVar.g.l(), (bt) obj);
                arrowViewPager.d = kVar;
                arrowViewPager.c.setAdapter(kVar);
                arrowViewPager.f(arrowViewPager.c.getCurrentItem());
                return true;
            case 8:
                if (!(view instanceof ArrowViewPager)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                }
                ArrowViewPager arrowViewPager2 = (ArrowViewPager) view;
                PagerAdapter pagerAdapter = arrowViewPager2.d;
                if (pagerAdapter != null && obj != null && (itemPosition = pagerAdapter.getItemPosition(obj)) != -2 && itemPosition != arrowViewPager2.a()) {
                    arrowViewPager2.c.setCurrentItem(itemPosition);
                    arrowViewPager2.f(itemPosition);
                }
                return true;
            case 9:
                if (!(view instanceof ArrowViewPager) || !(obj instanceof List)) {
                    return false;
                }
                List list = (List) obj;
                PagerAdapter pagerAdapter2 = ((ArrowViewPager) view).d;
                if (pagerAdapter2 != null) {
                    ((com.google.android.libraries.navigation.internal.mt.b) pagerAdapter2).b(list);
                }
                return true;
            case 10:
                if (!(view instanceof ArrowViewPager) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((ArrowViewPager) view).g((Boolean) obj);
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        return false;
    }
}
