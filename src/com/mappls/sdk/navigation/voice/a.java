package com.mappls.sdk.navigation.voice;

import android.content.Context;
import android.media.AudioManager;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.s;
import com.mappls.sdk.navigation.v;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements c, v<com.mappls.sdk.navigation.d> {
    public static boolean c = false;
    private static com.mappls.sdk.navigation.apis.b d;
    protected Context a;
    protected int b;

    protected a(Context context, String str) {
        new Locale("en", "IN");
        this.a = context;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.a = context;
        StringBuilder sbA = h.a("Initializing prolog system : ");
        sbA.append(System.currentTimeMillis() - jCurrentTimeMillis);
        NavigationLogger.i(sbA.toString(), new Object[0]);
        this.b = ((Integer) NavigationContext.getNavigationContext().k().l0.get()).intValue();
        a(NavigationContext.getNavigationContext().k(), str);
    }

    private void a(s sVar, String str) {
        try {
            sVar.e();
            sVar.I0.a(this);
        } catch (Exception e) {
            NavigationLogger.e(e, "Loading voice config exception %s", str);
        }
    }

    private synchronized void a(boolean z) {
        if (!z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager == null) {
                return;
            }
            audioManager.setBluetoothScoOn(false);
            audioManager.stopBluetoothSco();
            audioManager.setMode(0);
            c = false;
            return;
        }
        try {
            AudioManager audioManager2 = (AudioManager) this.a.getSystemService("audio");
            if (audioManager2 != null && audioManager2.isBluetoothScoAvailableOffCall()) {
                audioManager2.setMode(0);
                audioManager2.startBluetoothSco();
                audioManager2.setBluetoothScoOn(true);
                audioManager2.setMode(3);
                c = true;
            }
        } catch (Exception e) {
            NavigationLogger.d(e);
            c = false;
            e.getMessage();
        }
    }

    protected final synchronized void a() {
        com.mappls.sdk.navigation.apis.b bVar;
        NavigationLogger.d("abandonAudioFocus", new Object[0]);
        if ((this.a != null && NavigationContext.getNavigationContext().k() != null && ((Integer) NavigationContext.getNavigationContext().k().l0.a(NavigationContext.getNavigationContext().k().I0.get())).intValue() == 0) || c) {
            a(false);
        }
        Context context = this.a;
        if (context != null && (bVar = d) != null) {
            bVar.a(context, NavigationContext.getNavigationContext().k().I0.get());
        }
        d = null;
    }

    @Override // com.mappls.sdk.navigation.v
    public final /* bridge */ /* synthetic */ void a(com.mappls.sdk.navigation.d dVar) {
    }

    protected final synchronized void b() {
        com.mappls.sdk.navigation.apis.b bVar;
        Context context;
        NavigationLogger.d("requestAudioFocus", new Object[0]);
        try {
            bVar = new com.mappls.sdk.navigation.apis.b();
        } catch (Exception e) {
            NavigationLogger.d(e);
            bVar = null;
        }
        d = bVar;
        if (bVar != null && (context = this.a) != null && bVar.a(context, NavigationContext.getNavigationContext().k().I0.get(), this.b) && ((Integer) NavigationContext.getNavigationContext().k().l0.a(NavigationContext.getNavigationContext().k().I0.get())).intValue() == 0) {
            a(true);
        }
    }
}
