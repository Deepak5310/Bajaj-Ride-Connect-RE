package com.google.android.libraries.navigation.internal.ac;

import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements View.OnClickListener {
    final /* synthetic */ f a;

    public a(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.d.removeCallbacksAndMessages(null);
        Message messageObtain = Message.obtain();
        messageObtain.obj = view;
        this.a.d.sendMessageDelayed(messageObtain, ViewConfiguration.getPressedStateDuration());
    }
}
