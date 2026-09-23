package it.innove;

import android.app.NotificationChannel;
import android.app.Person;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.AudioPlaybackConfiguration;
import android.net.wifi.WifiNetworkSpecifier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Peripheral$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static /* bridge */ /* synthetic */ Person m(Object obj) {
        return (Person) obj;
    }

    public static /* synthetic */ Typeface.Builder m(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AudioPlaybackConfiguration m2295m(Object obj) {
        return (AudioPlaybackConfiguration) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WifiNetworkSpecifier.Builder m2297m() {
        return new WifiNetworkSpecifier.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m2299m() {
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m2302m$1() {
    }
}
