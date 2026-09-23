package com.google.android.libraries.navigation.internal.ms;

import android.view.View;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cn implements View.OnClickListener, View.OnLongClickListener {
    private Map a;
    private Map b;

    public static final cn a(View view) {
        cn cnVar = (cn) view.getTag(2131230768);
        if (cnVar != null) {
            return cnVar;
        }
        boolean zIsLongClickable = view.isLongClickable();
        cn cnVar2 = new cn();
        view.setOnClickListener(cnVar2);
        view.setOnLongClickListener(cnVar2);
        view.setTag(2131230768, cnVar2);
        if (zIsLongClickable) {
            return cnVar2;
        }
        view.setLongClickable(false);
        return cnVar2;
    }

    public final void b(bq bqVar, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.a == null) {
                this.a = new IdentityHashMap();
            }
            this.a.put(bqVar, onClickListener);
        } else {
            Map map = this.a;
            if (map != null) {
                map.remove(bqVar);
            }
        }
    }

    public final void c(bq bqVar, View.OnLongClickListener onLongClickListener) {
        if (onLongClickListener != null) {
            if (this.b == null) {
                this.b = new IdentityHashMap();
            }
            this.b.put(bqVar, onLongClickListener);
        } else {
            Map map = this.b;
            if (map != null) {
                map.remove(bqVar);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Map map = this.a;
        if (map == null) {
            return;
        }
        ev evVarO = ev.o(map.values());
        int size = evVarO.size();
        for (int i = 0; i < size; i++) {
            ((View.OnClickListener) evVarO.get(i)).onClick(view);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Map map = this.b;
        if (map == null) {
            return false;
        }
        ev evVarO = ev.o(map.values());
        int size = evVarO.size();
        for (int i = 0; i < size; i++) {
            ((View.OnLongClickListener) evVarO.get(i)).onLongClick(view);
        }
        return !evVarO.isEmpty();
    }
}
