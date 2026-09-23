package com.google.android.libraries.navigation.internal.q;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa implements com.google.android.libraries.navigation.internal.ms.c {
    final /* synthetic */ boolean a = false;

    public aa(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.ms.c
    public final void a(View view, boolean z) {
        view.animate().alpha(1.0f).setInterpolator(com.google.android.libraries.navigation.internal.k.a.a).setDuration(250L).setStartDelay(0L).setListener(new z(view, 1.0f)).start();
    }
}
