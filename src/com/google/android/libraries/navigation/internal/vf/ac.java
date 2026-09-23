package com.google.android.libraries.navigation.internal.vf;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac implements com.google.android.libraries.navigation.internal.ms.c {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.vf.ac");
    private final Context b;
    private final com.google.android.libraries.navigation.internal.ms.be c;

    public ac(Context context, com.google.android.libraries.navigation.internal.ms.be beVar) {
        this.b = context;
        this.c = beVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.c
    public final void a(View view, boolean z) {
        View viewA = com.google.android.libraries.navigation.internal.ms.be.a(view, ai.c);
        if (viewA == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1936)).p("TextView not found. Cannot perform animation.");
            return;
        }
        View viewA2 = com.google.android.libraries.navigation.internal.ms.be.a(view, ai.b);
        if (viewA2 == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1935)).p("IconView not found. Cannot perform animation.");
        } else {
            viewA.setTranslationX(((viewA2.getWidth() / 2) + ai.j.d(this.b)) * (true != com.google.android.libraries.navigation.internal.gz.i.a(this.b) ? -1 : 1));
        }
    }
}
