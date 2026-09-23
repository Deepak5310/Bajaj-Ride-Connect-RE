package com.google.android.libraries.navigation.internal.mz;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ms.bg;
import com.google.android.libraries.navigation.internal.ms.bl;
import com.google.android.libraries.navigation.internal.ms.bm;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a extends bm {
    public a(Context context, bg bgVar) {
        super(context, bgVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bm, com.google.android.libraries.navigation.internal.ms.ax
    protected final bl g() {
        return new bl();
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bm
    protected void q(List list) {
        list.add(new d(this));
        super.q(list);
    }
}
