package com.google.android.libraries.navigation.internal.mt;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.libraries.navigation.internal.ms.cp;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends PagerAdapter {
    protected final List a = new ArrayList();
    protected final Map b = new HashMap();

    protected void a(View view) {
        throw null;
    }

    public final void b(List list) {
        this.a.clear();
        if (list != null) {
            this.a.addAll(list);
        }
        notifyDataSetChanged();
    }

    protected abstract View c();

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        cs csVar = (cs) obj;
        View view = (View) this.b.get(csVar);
        viewGroup.removeView(view);
        cp.a(view).e();
        this.b.remove(csVar);
        a(view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object obj) {
        int iIndexOf = this.a.indexOf((cs) obj);
        if (iIndexOf < 0) {
            return -2;
        }
        return iIndexOf;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        cs csVar = (cs) this.a.get(i);
        ar.r(csVar, com.google.android.libraries.navigation.internal.b.b.b(i, "Null model at position "));
        View viewC = c();
        ar.r(viewC, com.google.android.libraries.navigation.internal.b.b.b(i, "Null view for model at position "));
        viewGroup.addView(viewC);
        cp.a(viewC).c(csVar);
        this.b.put(csVar, viewC);
        return csVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return this.b.get((cs) obj) == view;
    }
}
