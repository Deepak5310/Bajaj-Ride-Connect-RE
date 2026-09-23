package com.google.android.libraries.navigation;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.google.android.libraries.navigation.environment.NavApiEnvironmentManager;
import com.google.android.libraries.navigation.internal.xe.bb;
import com.google.android.libraries.navigation.internal.xe.ea;
import com.google.android.libraries.navigation.internal.xe.ek;
import com.google.android.libraries.navigation.internal.xe.fx;
import com.google.android.libraries.navigation.internal.xe.gk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class NavigationApi {
    private static ForegroundServiceManager b;
    static final gk a = new gk(bb.d, com.google.android.libraries.navigation.internal.vq.c.a);
    private static boolean c = false;

    /* JADX INFO: compiled from: PG */
    public @interface ErrorCode {
        public static final int LOCATION_PERMISSION_MISSING = 4;
        public static final int NETWORK_ERROR = 3;
        public static final int NOT_AUTHORIZED = 1;
        public static final int TERMS_NOT_ACCEPTED = 2;
    }

    /* JADX INFO: compiled from: PG */
    public interface NavigatorListener {
        void onError(int i);

        void onNavigatorReady(Navigator navigator);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnTermsResponseListener {
        void onTermsResponse(boolean z);
    }

    private NavigationApi() {
    }

    public static boolean areTermsAccepted(Application application) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(application, "The application provided is null.");
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(application);
            orCreate.bw().a(com.google.android.libraries.navigation.internal.zp.n.CX);
            return orCreate.x().e();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static synchronized void clearForegroundServiceManager() {
        try {
            ForegroundServiceManager foregroundServiceManager = b;
            if (foregroundServiceManager != null) {
                foregroundServiceManager.a.a(null);
                foregroundServiceManager.a.b(null);
            }
            c = false;
            b = null;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static synchronized ForegroundServiceManager getForegroundServiceManager(Application application) {
        try {
            if (!c || b == null) {
                initForegroundServiceManagerProvider(application, null, null);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
        return b;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0006
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    public static java.lang.String getNavSDKVersion() {
        /*
            java.lang.String r0 = "6.1.0"
            return r0
        L3:
            r0 = move-exception
            goto L6
        L5:
            r0 = move-exception
        L6:
            com.google.android.libraries.navigation.environment.b.c(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.navigation.NavigationApi.getNavSDKVersion():java.lang.String");
    }

    public static void getNavigator(Activity activity, NavigatorListener navigatorListener) {
        try {
            getNavigator(activity, navigatorListener, TermsAndConditionsCheckOption.ENABLED);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static void getNavigatorNoToS(Application application, NavigatorListener navigatorListener) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(application, "The application provided is null.");
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(application);
            ek.a().b(orCreate, ea.a(orCreate, a), navigatorListener, TermsAndConditionsCheckOption.SKIPPED);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static RoadSnappedLocationProvider getRoadSnappedLocationProvider(Application application) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(application, "The application provided is null.");
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(application);
            orCreate.bw().a(com.google.android.libraries.navigation.internal.zp.n.Dd);
            if (!ek.a().g()) {
                return null;
            }
            int i = com.google.android.libraries.navigation.internal.rv.a.a;
            com.google.android.libraries.navigation.internal.ru.c cVarA = com.google.android.libraries.navigation.internal.ru.e.a();
            return new fx(new com.google.android.libraries.navigation.internal.vt.d(cVarA.B(), (com.google.android.libraries.navigation.internal.vt.a) ((com.google.android.libraries.navigation.environment.m) cVarA).ac.a()), orCreate.t(), orCreate.br(), orCreate.S());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static NavigationTransactionRecorder getTransactionRecorder(Application application) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(application, "The application provided is null.");
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(application);
            orCreate.bw().a(com.google.android.libraries.navigation.internal.zp.n.De);
            if (ek.a().g()) {
                return new NavigationTransactionRecorder(orCreate.ar(), orCreate.bm(), orCreate.B(), orCreate.H(), orCreate.bw(), orCreate.bz(), orCreate.S(), orCreate.bb());
            }
            return null;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static synchronized void initForegroundServiceManagerMessageAndIntent(Application application, Integer num, String str, Intent intent) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.b(!c, "ForegroundServiceManager has already been initialized");
            com.google.android.libraries.navigation.internal.abf.t.c(application, "The application provided is null.");
            b = new ForegroundServiceManager(NavApiEnvironmentManager.getOrCreate(application), num, str, intent, null);
            getNavigator(application, new h(intent));
            c = true;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static synchronized void initForegroundServiceManagerProvider(Application application, Integer num, NotificationContentProvider notificationContentProvider) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.b(!c, "ForegroundServiceManager has already been initialized");
            com.google.android.libraries.navigation.internal.abf.t.c(application, "The application provided is null.");
            b = new ForegroundServiceManager(NavApiEnvironmentManager.getOrCreate(application), num, null, null, notificationContentProvider);
            c = true;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static void resetTermsAccepted(Application application) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(application, "The application provided is null.");
            com.google.android.libraries.navigation.internal.abf.t.b(!ek.a().f(), "Navigator has not been fetched.");
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(application);
            orCreate.bw().a(com.google.android.libraries.navigation.internal.zp.n.aI);
            com.google.android.libraries.navigation.internal.fu.a aVarX = orCreate.x();
            com.google.android.libraries.navigation.internal.xf.i.f(((com.google.android.libraries.navigation.internal.xf.i) aVarX).a.a());
            ((com.google.android.libraries.navigation.internal.xf.i) aVarX).c.set(false);
            ((com.google.android.libraries.navigation.internal.xf.i) aVarX).b.d(null);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static void setAbnormalTerminationReportingEnabled(boolean z) {
        try {
            NavApiEnvironmentManager.a = z;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static void showTermsAndConditionsDialog(Activity activity, String str, OnTermsResponseListener onTermsResponseListener) {
        try {
            showTermsAndConditionsDialog(activity, str, null, null, onTermsResponseListener, TermsAndConditionsCheckOption.ENABLED);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static void getNavigator(Activity activity, NavigatorListener navigatorListener, TermsAndConditionsCheckOption termsAndConditionsCheckOption) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(activity, "The activity provided is null.");
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(activity.getApplication());
            ek.a().b(orCreate, new ea(activity, orCreate, a, new com.google.android.libraries.navigation.internal.xf.b(orCreate.C(), orCreate.H()), orCreate.bf(), orCreate.bw()), navigatorListener, termsAndConditionsCheckOption);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static void showTermsAndConditionsDialog(Activity activity, String str, String str2, OnTermsResponseListener onTermsResponseListener) {
        try {
            showTermsAndConditionsDialog(activity, str, str2, null, onTermsResponseListener, TermsAndConditionsCheckOption.ENABLED);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static void showTermsAndConditionsDialog(Activity activity, String str, String str2, TermsAndConditionsUIParams termsAndConditionsUIParams, OnTermsResponseListener onTermsResponseListener, TermsAndConditionsCheckOption termsAndConditionsCheckOption) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(activity, "The activity provided is null.");
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(activity.getApplication());
            orCreate.bw().a(com.google.android.libraries.navigation.internal.zp.n.aJ);
            a.a(activity, orCreate.bw(), orCreate.x(), orCreate.bz(), str, str2, termsAndConditionsUIParams, onTermsResponseListener, termsAndConditionsCheckOption);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static void getNavigator(Application application, NavigatorListener navigatorListener) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(application, "The application provided is null.");
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(application);
            ek.a().b(orCreate, ea.a(orCreate, a), navigatorListener, TermsAndConditionsCheckOption.ENABLED);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
