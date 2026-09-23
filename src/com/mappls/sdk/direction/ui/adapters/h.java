package com.mappls.sdk.direction.ui.adapters;

import android.view.View;
import com.mappls.sdk.direction.ui.model.StopModel;

/* JADX INFO: loaded from: classes6.dex */
final class h implements View.OnClickListener {
    final /* synthetic */ j.b a;
    final /* synthetic */ j b;

    h(j jVar, j.b bVar) {
        this.b = jVar;
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.b.getItemViewType(this.a.getBindingAdapterPosition()) == 0 && this.b.a.size() < 3 && this.b.b != null) {
            this.b.b.a();
        }
        if (this.b.a.size() > 2 && !com.mappls.sdk.direction.ui.common.a.a((StopModel) this.b.a.get(this.a.getBindingAdapterPosition())) && this.b.b != null) {
            this.b.b.a((StopModel) this.b.a.get(this.a.getBindingAdapterPosition()));
        }
        if (this.b.c.showAddWaypointOption().booleanValue() && this.b.getItemViewType(this.a.getBindingAdapterPosition()) == 1 && this.b.a.size() == 2 && !com.mappls.sdk.direction.ui.common.a.a((StopModel) this.b.a.get(this.a.getBindingAdapterPosition())) && !com.mappls.sdk.direction.ui.common.a.a((StopModel) this.b.a.get(0))) {
            this.b.b.a(this.a.getBindingAdapterPosition());
        }
    }
}
