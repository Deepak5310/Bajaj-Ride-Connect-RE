package com.google.android.libraries.navigation.internal.xe;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class az extends ClickableSpan {
    final /* synthetic */ Activity a;
    final /* synthetic */ String b;

    public az(Activity activity, String str) {
        this.a = activity;
        this.b = str;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.b)));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.a.getResources().getColor(com.google.android.libraries.navigation.internal.f.b.g));
    }
}
