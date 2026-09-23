package com.google.android.libraries.navigation.internal.mz;

import androidx.recyclerview.widget.RecyclerView;
import com.bajajconnect.rideapp.R;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public final RecyclerView a;
    public RecyclerView.OnItemTouchListener b;
    public m c;
    public m d;

    private m(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public static final m a(RecyclerView recyclerView) {
        m mVar = (m) recyclerView.getTag(R.id.badge_bullet_view);
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(recyclerView);
        mVar2.b(recyclerView.getAdapter());
        recyclerView.setTag(R.id.badge_bullet_view, mVar2);
        return mVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(RecyclerView.Adapter adapter) {
        if (adapter instanceof j) {
            j jVar = (j) adapter;
            jVar.a(this);
            jVar.b(this);
        }
    }
}
