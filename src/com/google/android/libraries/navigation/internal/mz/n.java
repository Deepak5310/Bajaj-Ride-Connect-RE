package com.google.android.libraries.navigation.internal.mz;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.bu;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cp;
import com.google.android.libraries.navigation.internal.ms.cr;
import com.google.android.libraries.navigation.internal.ms.cs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends RecyclerView.Adapter implements j {
    public final com.google.android.libraries.navigation.internal.mt.g a;

    public n(cr crVar) {
        this.a = new com.google.android.libraries.navigation.internal.mt.g(crVar);
        setHasStableIds(true);
    }

    @Override // com.google.android.libraries.navigation.internal.mz.j
    public final void a(m mVar) {
        this.a.f = mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mz.j
    public final void b(m mVar) {
        this.a.g = mVar;
    }

    public final void c() {
        this.a.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.a.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        return ((bu) this.a.b.get(i)).d().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return this.a.b(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        this.a.h(((com.google.android.libraries.navigation.internal.mt.f) viewHolder).itemView, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        com.google.android.libraries.navigation.internal.mt.g gVar = this.a;
        return new com.google.android.libraries.navigation.internal.mt.f(gVar.c(viewGroup, i), gVar.d(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        final com.google.android.libraries.navigation.internal.mt.g gVar = this.a;
        final com.google.android.libraries.navigation.internal.mt.f fVar = (com.google.android.libraries.navigation.internal.mt.f) viewHolder;
        gVar.e.post(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.mt.e
            @Override // java.lang.Runnable
            public final void run() {
                cp.a(fVar.itemView).a.m();
            }
        }));
        if (gVar.f == null) {
            return;
        }
        int i = com.google.android.libraries.navigation.internal.mt.f.b;
        bt btVar = fVar.a;
        cr crVar = gVar.c;
        cs csVar = ck.j(fVar.itemView).j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        com.google.android.libraries.navigation.internal.mt.g gVar = this.a;
        com.google.android.libraries.navigation.internal.mt.f fVar = (com.google.android.libraries.navigation.internal.mt.f) viewHolder;
        if (gVar.g == null) {
            return;
        }
        int i = com.google.android.libraries.navigation.internal.mt.f.b;
        bt btVar = fVar.a;
        cr crVar = gVar.c;
        cs csVar = ck.j(fVar.itemView).j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        View view = ((com.google.android.libraries.navigation.internal.mt.f) viewHolder).itemView;
        cr crVar = this.a.c;
        cp.a(view).a.n();
    }
}
