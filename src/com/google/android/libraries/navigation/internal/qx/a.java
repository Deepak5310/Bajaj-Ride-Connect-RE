package com.google.android.libraries.navigation.internal.qx;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.qy.c {
    public static final ev a = ev.u(Pattern.compile(String.format("https?://(www.)?%s.*", "mapsresources-pa\\.googleapis\\.com")), Pattern.compile(String.format("https?://(www.)?%s.*", ".*mapsresources-pa\\.sandbox\\.googleapis\\.com")), Pattern.compile(String.format("https?://(www.)?%s.*", "google\\.com")), Pattern.compile(String.format("https?://(www.)?%s.*", "tactile\\.sandbox\\.google\\.com")), Pattern.compile(String.format("https?://(www.)?%s.*", "gstatic\\.com")));
    public final com.google.android.libraries.navigation.internal.gg.f b;

    public a(com.google.android.libraries.navigation.internal.gg.f fVar) {
        this.b = fVar;
    }
}
