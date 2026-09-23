package com.google.android.libraries.navigation.internal.e;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements NotificationCompat.Extender {
    public CharSequence a;
    public CharSequence b;
    public Bitmap c;
    private final int d = 1;
    private final boolean e = true;

    @Override // androidx.core.app.NotificationCompat.Extender
    public final NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.car.support.CarNavExtender.EXTENDED", true);
        bundle.putSerializable("content_id", null);
        bundle.putInt("type", 1);
        bundle.putCharSequence(NotificationCompat.EXTRA_TITLE, this.a);
        bundle.putCharSequence("android.title.night", null);
        bundle.putCharSequence(NotificationCompat.EXTRA_TEXT, this.b);
        bundle.putCharSequence("android.text.night", null);
        bundle.putCharSequence("sub_text", null);
        bundle.putCharSequence("sub_text.night", null);
        bundle.putParcelable(NotificationCompat.EXTRA_LARGE_ICON, this.c);
        bundle.putInt("action_icon", 0);
        bundle.putInt("action_icon.night", 0);
        bundle.putParcelable("content_intent", null);
        bundle.putParcelable("content_pending_intent", null);
        bundle.putInt("app_color", 0);
        bundle.putInt("app_night_color", 0);
        bundle.putBoolean("stream_visibility", true);
        bundle.putBoolean("heads_up_visibility", false);
        bundle.putBoolean("ignore_in_stream", false);
        builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
        return builder;
    }
}
