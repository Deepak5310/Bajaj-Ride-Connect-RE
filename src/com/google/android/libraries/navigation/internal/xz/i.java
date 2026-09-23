package com.google.android.libraries.navigation.internal.xz;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public Uri.Builder a = new Uri.Builder().scheme("file").authority("").path(RemoteSettings.FORWARD_SLASH_STRING);
    public final eq b;

    public i() {
        int i = ev.d;
        this.b = new eq();
    }
}
