package com.google.android.libraries.navigation.internal.mt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.SectionIndexer;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.bu;
import com.google.android.libraries.navigation.internal.ms.cp;
import com.google.android.libraries.navigation.internal.ms.cq;
import com.google.android.libraries.navigation.internal.ms.cr;
import com.google.android.libraries.navigation.internal.ms.cu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends BaseAdapter implements AbsListView.RecyclerListener, SectionIndexer, c {
    private static final String[] b = new String[26];
    public final g a;
    private Filter c;

    static {
        for (char c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
            b[c - 'A'] = Character.toString(c);
        }
    }

    public i(cr crVar) {
        this.a = new g(crVar);
    }

    private final char b(int i) {
        Object objE = this.a.e(i);
        if (!(objE instanceof cu)) {
            return 'A';
        }
        String strA = ((cu) objE).a();
        if (strA.isEmpty()) {
            return 'A';
        }
        return Character.toUpperCase(strA.charAt(0));
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.libraries.navigation.internal.ms.cs, java.lang.Object] */
    public final void a(i iVar) {
        this.a.g();
        int count = iVar.getCount();
        for (int i = 0; i < count; i++) {
            g gVar = this.a;
            g gVar2 = iVar.a;
            bt btVarD = gVar2.d(gVar2.b(i));
            g gVar3 = iVar.a;
            ?? E = gVar3.e(i);
            gVar3.i(i);
            gVar.f(bu.e(btVarD, E));
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.a();
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.c == null) {
            this.c = new h();
        }
        return this.c;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.a.e(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return this.a.b(i);
    }

    @Override // android.widget.SectionIndexer
    public final int getPositionForSection(int i) {
        int i2 = 0;
        int iMax = Math.max(0, i);
        String[] strArr = b;
        int length = strArr.length;
        char cCharAt = strArr[Math.min(iMax, 25)].charAt(0);
        int iA = this.a.a() - 1;
        while (i2 < iA) {
            int i3 = (i2 + iA) / 2;
            char cB = b(i3);
            if (cB == cCharAt) {
                return i3;
            }
            if (cB < cCharAt) {
                i2 = i3 + 1;
            } else {
                iA = i3 - 1;
            }
        }
        return i2;
    }

    @Override // android.widget.SectionIndexer
    public final int getSectionForPosition(int i) {
        return b(Math.min(Math.max(0, i), this.a.a())) - 'A';
    }

    @Override // android.widget.SectionIndexer
    public final Object[] getSections() {
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001f  */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = this.a.c(viewGroup, itemViewType);
        } else {
            g gVar = this.a;
            cr crVar = gVar.c;
            cq cqVarA = cp.a(view);
            if (cqVarA == null || !cqVarA.a.f.equals(gVar.d(itemViewType))) {
                view = this.a.c(viewGroup, itemViewType);
            }
        }
        this.a.h(view, i);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        g gVar = this.a;
        int i = gVar.d;
        if (i != 0) {
            return i;
        }
        int iMax = Math.max(1, gVar.a.keySet().size());
        gVar.d = iMax;
        return iMax;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        this.a.i(i);
        return true;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public final void onMovedToScrapHeap(View view) {
        g.j(view);
    }
}
