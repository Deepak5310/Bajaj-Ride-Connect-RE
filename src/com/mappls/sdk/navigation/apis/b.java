package com.mappls.sdk.navigation.apis;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.google.android.gms.common.util.zzb$$ExternalSyntheticApiModelOutline0;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.routing.h;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements AudioManager.OnAudioFocusChangeListener {
    public static boolean b = false;
    com.mappls.sdk.navigation.routing.d a;

    public final boolean a(Context context, com.mappls.sdk.navigation.d dVar) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.a = NavigationContext.getNavigationContext().h();
        b = false;
        if (Build.VERSION.SDK_INT < 26) {
            return 1 == audioManager.abandonAudioFocus(this);
        }
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(((Integer) NavigationContext.getNavigationContext().k().m0.get()).intValue()).setContentType(1).build();
        PathTreeWalk$$ExternalSyntheticApiModelOutline0.m3558m();
        return 1 == audioManager.abandonAudioFocusRequest(zzb$$ExternalSyntheticApiModelOutline0.m(NavigationContext.getNavigationContext().k().w.a(dVar).booleanValue() ? 2 : 3).setAudioAttributes(audioAttributesBuild).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this).build());
    }

    public final boolean a(Context context, com.mappls.sdk.navigation.d dVar, int i) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.a = NavigationContext.getNavigationContext().h();
        if (Build.VERSION.SDK_INT < 26) {
            b = 1 == audioManager.requestAudioFocus(this, i, NavigationContext.getNavigationContext().k().w.a(dVar).booleanValue() ? 2 : 3);
        } else {
            AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(((Integer) NavigationContext.getNavigationContext().k().m0.get()).intValue()).setContentType(1).build();
            PathTreeWalk$$ExternalSyntheticApiModelOutline0.m3558m();
            AudioFocusRequest audioFocusRequestBuild = zzb$$ExternalSyntheticApiModelOutline0.m(NavigationContext.getNavigationContext().k().w.a(dVar).booleanValue() ? 2 : 3).setAudioAttributes(audioAttributesBuild).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this).build();
            Object obj = new Object();
            int iRequestAudioFocus = audioManager.requestAudioFocus(audioFocusRequestBuild);
            synchronized (obj) {
                try {
                    if (iRequestAudioFocus == 1) {
                        b = true;
                    } else if (iRequestAudioFocus == 0 || iRequestAudioFocus == 2) {
                        b = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        NavigationLogger.d("AudioFocusHelperImpl.onAudioFocusChange(): Unexpected audio focus change: " + i, new Object[0]);
        if (i == 1 || i == 2 || i == 3) {
            b = true;
            return;
        }
        if (i == -1 || i == -2 || i == -3) {
            b = false;
            com.mappls.sdk.navigation.routing.d dVar = this.a;
            if (dVar != null) {
                dVar.o().getClass();
                h.d();
            }
        }
    }
}
