package com.google.android.libraries.navigation.internal.mz;

import androidx.recyclerview.widget.RecyclerView;
import com.bajajconnect.rideapp.R;
import com.google.android.libraries.navigation.internal.ms.cq;
import com.google.android.libraries.navigation.internal.ms.cr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends RecyclerView.RecycledViewPool {
    private final cr a;
    private final n b;

    public i(cr crVar, n nVar) {
        this.a = crVar;
        this.b = nVar;
    }

    private static boolean a(int i) {
        return i >= 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void clear() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final RecyclerView.ViewHolder getRecycledView(int i) {
        if (!a(i)) {
            return super.getRecycledView(i);
        }
        cq cqVarE = this.a.e(this.b.a.d(i), null, false);
        if (cqVarE == null) {
            return null;
        }
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) cqVarE.a().getTag(R.id.autofill_inline_suggestion_title);
        if (viewHolder != null) {
            return viewHolder;
        }
        cqVarE.d();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void putRecycledView(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setAccessibilityDelegate(null);
        if (!a(viewHolder.getItemViewType())) {
            super.putRecycledView(viewHolder);
        } else {
            viewHolder.itemView.setTag(R.id.autofill_inline_suggestion_title, viewHolder);
            this.a.b(viewHolder.itemView);
        }
    }
}
