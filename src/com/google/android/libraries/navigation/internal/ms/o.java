package com.google.android.libraries.navigation.internal.ms;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class o implements dd {
    public final /* synthetic */ dd a;

    @Override // com.google.android.libraries.navigation.internal.ms.dd
    public final Object a(final cs csVar) {
        final dd ddVar = this.a;
        return new View.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.ms.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ddVar.a(csVar);
            }
        };
    }

    @Override // com.google.android.libraries.navigation.internal.ms.dd
    public final /* synthetic */ boolean b() {
        return false;
    }
}
