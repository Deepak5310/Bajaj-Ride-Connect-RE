package com.zoontek.rnbootsplash;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.window.SplashScreen;
import android.window.SplashScreenView;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.PixelUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNBootSplashModuleImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J!\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u001eJ\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nJ\r\u0010!\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/zoontek/rnbootsplash/RNBootSplashModuleImpl;", "", "()V", "NAME", "", "mFadeOutDialog", "Lcom/zoontek/rnbootsplash/RNBootSplashDialog;", "mInitialDialog", "mPromiseQueue", "Lcom/zoontek/rnbootsplash/RNBootSplashQueue;", "Lcom/facebook/react/bridge/Promise;", "mStatus", "Lcom/zoontek/rnbootsplash/RNBootSplashModuleImpl$Status;", "mThemeResId", "", "clearPromiseQueue", "", "getConstants", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "hide", "fade", "", BaseJavaModule.METHOD_TYPE_PROMISE, "hideAndClearPromiseQueue", "init", "activity", "Landroid/app/Activity;", "themeResId", "init$react_native_bootsplash_release", "isSamsungOneUI4", "isVisible", "onHostDestroy", "onHostDestroy$react_native_bootsplash_release", "Status", "react-native-bootsplash_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RNBootSplashModuleImpl {
    public static final String NAME = "RNBootSplash";
    private static RNBootSplashDialog mFadeOutDialog;
    private static RNBootSplashDialog mInitialDialog;
    public static final RNBootSplashModuleImpl INSTANCE = new RNBootSplashModuleImpl();
    private static final RNBootSplashQueue<Promise> mPromiseQueue = new RNBootSplashQueue<>();
    private static Status mStatus = Status.HIDDEN;
    private static int mThemeResId = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RNBootSplashModuleImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/zoontek/rnbootsplash/RNBootSplashModuleImpl$Status;", "", "(Ljava/lang/String;I)V", "HIDDEN", "HIDING", "INITIALIZING", "VISIBLE", "react-native-bootsplash_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    enum Status {
        HIDDEN,
        HIDING,
        INITIALIZING,
        VISIBLE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }
    }

    private RNBootSplashModuleImpl() {
    }

    public final void init$react_native_bootsplash_release(final Activity activity, int themeResId) {
        int i;
        if (mThemeResId != -1) {
            FLog.w(ReactConstants.TAG, "RNBootSplash: Ignored initialization, module is already initialized.");
            return;
        }
        mThemeResId = themeResId;
        if (activity == null) {
            FLog.w(ReactConstants.TAG, "RNBootSplash: Ignored initialization, current activity is null.");
            return;
        }
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(R.attr.postBootSplashTheme, typedValue, true) && (i = typedValue.resourceId) != 0) {
            activity.setTheme(i);
        }
        final View viewFindViewById = activity.findViewById(android.R.id.content);
        mStatus = Status.INITIALIZING;
        viewFindViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$init$1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (RNBootSplashModuleImpl.mStatus == RNBootSplashModuleImpl.Status.INITIALIZING) {
                    return false;
                }
                viewFindViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
        if (Build.VERSION.SDK_INT >= 31) {
            activity.getSplashScreen().setOnExitAnimationListener(new SplashScreen.OnExitAnimationListener() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda5
                @Override // android.window.SplashScreen.OnExitAnimationListener
                public final void onSplashScreenExit(SplashScreenView splashScreenView) {
                    RNBootSplashModuleImpl.init$lambda$0(activity, splashScreenView);
                }
            });
        }
        mInitialDialog = new RNBootSplashDialog(activity, mThemeResId, false);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                RNBootSplashModuleImpl.init$lambda$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(Activity activity, SplashScreenView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.remove();
        activity.getSplashScreen().clearOnExitAnimationListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1() {
        RNBootSplashDialog rNBootSplashDialog = mInitialDialog;
        if (rNBootSplashDialog != null) {
            rNBootSplashDialog.show(new Function0<Unit>() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$init$3$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RNBootSplashModuleImpl rNBootSplashModuleImpl = RNBootSplashModuleImpl.INSTANCE;
                    RNBootSplashModuleImpl.mStatus = RNBootSplashModuleImpl.Status.VISIBLE;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPromiseQueue() {
        while (true) {
            RNBootSplashQueue<Promise> rNBootSplashQueue = mPromiseQueue;
            if (rNBootSplashQueue.isEmpty()) {
                return;
            }
            Promise promiseShift = rNBootSplashQueue.shift();
            if (promiseShift != null) {
                promiseShift.resolve(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAndClearPromiseQueue(final ReactApplicationContext reactContext, final boolean fade) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                RNBootSplashModuleImpl.hideAndClearPromiseQueue$lambda$2(reactContext, fade);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideAndClearPromiseQueue$lambda$2(final ReactApplicationContext reactContext, final boolean z) {
        Unit unit;
        Intrinsics.checkNotNullParameter(reactContext, "$reactContext");
        Activity currentActivity = reactContext.getCurrentActivity();
        if (mStatus == Status.INITIALIZING || currentActivity == null || currentActivity.isFinishing() || currentActivity.isDestroyed()) {
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$hideAndClearPromiseQueue$1$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    timer.cancel();
                    RNBootSplashModuleImpl.INSTANCE.hideAndClearPromiseQueue(reactContext, z);
                }
            }, 100L);
            return;
        }
        if (mStatus == Status.HIDING) {
            return;
        }
        if (mStatus == Status.HIDDEN) {
            INSTANCE.clearPromiseQueue();
            return;
        }
        mStatus = Status.HIDING;
        RNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1 rNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1 = new Function0<Unit>() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Unit unit2;
                final RNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1$fadeOutDialogDismiss$1 rNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1$fadeOutDialogDismiss$1 = new Function0<Unit>() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1$fadeOutDialogDismiss$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RNBootSplashModuleImpl rNBootSplashModuleImpl = RNBootSplashModuleImpl.INSTANCE;
                        RNBootSplashModuleImpl.mFadeOutDialog = null;
                        RNBootSplashModuleImpl rNBootSplashModuleImpl2 = RNBootSplashModuleImpl.INSTANCE;
                        RNBootSplashModuleImpl.mStatus = RNBootSplashModuleImpl.Status.HIDDEN;
                        RNBootSplashModuleImpl.INSTANCE.clearPromiseQueue();
                    }
                };
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.zoontek.rnbootsplash.RNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1$initialDialogDismiss$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RNBootSplashModuleImpl rNBootSplashModuleImpl = RNBootSplashModuleImpl.INSTANCE;
                        Unit unit3 = null;
                        RNBootSplashModuleImpl.mInitialDialog = null;
                        RNBootSplashDialog rNBootSplashDialog = RNBootSplashModuleImpl.mFadeOutDialog;
                        if (rNBootSplashDialog != null) {
                            rNBootSplashDialog.dismiss(rNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1$fadeOutDialogDismiss$1);
                            unit3 = Unit.INSTANCE;
                        }
                        if (unit3 == null) {
                            rNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1$fadeOutDialogDismiss$1.invoke();
                        }
                    }
                };
                RNBootSplashDialog rNBootSplashDialog = RNBootSplashModuleImpl.mInitialDialog;
                if (rNBootSplashDialog != null) {
                    rNBootSplashDialog.dismiss(function0);
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    function0.invoke();
                }
            }
        };
        if (z) {
            RNBootSplashDialog rNBootSplashDialog = new RNBootSplashDialog(currentActivity, mThemeResId, true);
            mFadeOutDialog = rNBootSplashDialog;
            rNBootSplashDialog.show(rNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1);
            return;
        }
        RNBootSplashDialog rNBootSplashDialog2 = mInitialDialog;
        if (rNBootSplashDialog2 != null) {
            rNBootSplashDialog2.dismiss(rNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            rNBootSplashModuleImpl$hideAndClearPromiseQueue$1$hideSequence$1.invoke();
        }
    }

    public final boolean isSamsungOneUI4() {
        Object objM2319constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            RNBootSplashModuleImpl rNBootSplashModuleImpl = this;
            objM2319constructorimpl = Result.m2319constructorimpl(Boolean.valueOf((Build.VERSION.class.getDeclaredField("SEM_PLATFORM_INT").getInt(null) - 90000) / 10000 == 4));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2319constructorimpl = Result.m2319constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2325isFailureimpl(objM2319constructorimpl)) {
            objM2319constructorimpl = false;
        }
        return ((Boolean) objM2319constructorimpl).booleanValue();
    }

    public final void onHostDestroy$react_native_bootsplash_release() {
        mStatus = Status.HIDDEN;
        mThemeResId = -1;
        clearPromiseQueue();
        RNBootSplashDialog rNBootSplashDialog = mInitialDialog;
        if (rNBootSplashDialog != null) {
            rNBootSplashDialog.dismiss();
            mInitialDialog = null;
        }
        RNBootSplashDialog rNBootSplashDialog2 = mFadeOutDialog;
        if (rNBootSplashDialog2 != null) {
            rNBootSplashDialog2.dismiss();
            mFadeOutDialog = null;
        }
    }

    public final Map<String, Object> getConstants(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Resources resources = reactContext.getResources();
        HashMap map = new HashMap();
        int i = reactContext.getResources().getConfiguration().uiMode & 48;
        int identifier = resources.getIdentifier("status_bar_height", "dimen", SystemMediaRouteProvider.PACKAGE_NAME);
        int identifier2 = resources.getIdentifier("navigation_bar_height", "dimen", SystemMediaRouteProvider.PACKAGE_NAME);
        float dIPFromPixel = 0.0f;
        float dIPFromPixel2 = identifier > 0 ? PixelUtil.toDIPFromPixel(resources.getDimensionPixelSize(identifier)) : 0.0f;
        if (identifier2 > 0 && !ViewConfiguration.get(reactContext).hasPermanentMenuKey()) {
            dIPFromPixel = PixelUtil.toDIPFromPixel(resources.getDimensionPixelSize(identifier2));
        }
        HashMap map2 = map;
        map2.put("darkModeEnabled", Boolean.valueOf(i == 32));
        map2.put("logoSizeRatio", Double.valueOf(isSamsungOneUI4() ? 0.5d : 1.0d));
        map2.put("navigationBarHeight", Float.valueOf(dIPFromPixel));
        map2.put("statusBarHeight", Float.valueOf(dIPFromPixel2));
        return map2;
    }

    public final void hide(ReactApplicationContext reactContext, boolean fade, Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        mPromiseQueue.push(promise);
        hideAndClearPromiseQueue(reactContext, fade);
    }

    public final void isVisible(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(mStatus != Status.HIDDEN));
    }
}
