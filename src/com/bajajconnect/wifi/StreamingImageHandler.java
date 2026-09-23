package com.bajajconnect.wifi;

import android.content.Context;
import android.graphics.Bitmap;
import com.bajajconnect.wifi.views.NavigationSearchScreen;

/* JADX INFO: loaded from: classes3.dex */
public class StreamingImageHandler {
    private static final int HEADER_HEIGHT = 50;
    private static final String TAG = "com.bajajconnect.wifi.StreamingImageHandler";
    public static final int TFT_HEIGHT = 480;
    public static final int TFT_WIDTH = 800;
    public static NavigationSearchScreen navigationSearchScreen;

    public static Bitmap getSearchScreenNew(Context context, Bitmap bitmap) {
        if (navigationSearchScreen == null) {
            navigationSearchScreen = new NavigationSearchScreen(context);
        }
        int i = AnonymousClass1.$SwitchMap$com$bajajconnect$wifi$Screens[MirroringGlobarVar.currentScreen.ordinal()];
        if (i == 1) {
            return navigationSearchScreen.getBitmap();
        }
        if (i == 2) {
            return navigationSearchScreen.tftRouteInfoScreen.drawView(bitmap);
        }
        if (i != 3) {
            return null;
        }
        return navigationSearchScreen.tftTurnByTurnScreen.drawView(bitmap);
    }

    /* JADX INFO: renamed from: com.bajajconnect.wifi.StreamingImageHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bajajconnect$wifi$Screens;

        static {
            int[] iArr = new int[Screens.values().length];
            $SwitchMap$com$bajajconnect$wifi$Screens = iArr;
            try {
                iArr[Screens.SEARCH_SCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bajajconnect$wifi$Screens[Screens.ROUTE_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bajajconnect$wifi$Screens[Screens.TBT_SCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
