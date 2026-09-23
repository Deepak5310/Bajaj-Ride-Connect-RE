package com.google.android.libraries.navigation.internal.mt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cr;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends PagerAdapter {
    public final g a;
    private final cr b;
    private final Map c = new HashMap();

    public j(cr crVar) {
        this.a = new g(crVar);
        this.b = crVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        cs csVar = (cs) obj;
        View view = (View) this.c.get(csVar);
        ar.q(view);
        viewGroup.removeView(view);
        this.c.remove(csVar);
        g.j(view);
        this.a.c.b(view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.a.a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object obj) {
        int iIndexOf = this.a.b.indexOf(obj);
        if (iIndexOf < 0) {
            return -2;
        }
        return iIndexOf;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int i) {
        g gVar = this.a;
        Object objD = gVar.d(gVar.b(i));
        this.a.e(i);
        if (!(objD instanceof d)) {
            return "";
        }
        Context context = this.b.d;
        return ((d) objD).a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        g gVar = this.a;
        View viewC = gVar.c(viewGroup, gVar.b(i));
        viewGroup.addView(viewC);
        this.a.h(viewC, i);
        ck ckVarJ = ck.j(viewC);
        ar.q(ckVarJ);
        Map map = this.c;
        cs csVar = ckVarJ.j;
        map.put(csVar, viewC);
        return csVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return this.c.get((cs) obj) == view;
    }
}
