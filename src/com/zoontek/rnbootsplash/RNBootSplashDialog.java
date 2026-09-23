package com.zoontek.rnbootsplash;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNBootSplashDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\b\u0010\r\u001a\u00020\nH\u0017J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/zoontek/rnbootsplash/RNBootSplashDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "themeResId", "", "fade", "", "(Landroid/app/Activity;IZ)V", "dismiss", "", "callback", "Lkotlin/Function0;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "show", "react-native-bootsplash_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RNBootSplashDialog extends Dialog {
    private final boolean fade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNBootSplashDialog(Activity activity, int i, boolean z) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.fade = z;
        setOwnerActivity(activity);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    @Deprecated(message = "Deprecated in favor of OnBackPressedCallback")
    public void onBackPressed() {
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity != null) {
            ownerActivity.moveTaskToBack(true);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                RNBootSplashDialog rNBootSplashDialog = this;
                super.dismiss();
                Result.m2319constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m2319constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public final void dismiss(final Function0<Unit> callback) {
        Object objM2319constructorimpl;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (isShowing()) {
            setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zoontek.rnbootsplash.RNBootSplashDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    RNBootSplashDialog.dismiss$lambda$1(callback, dialogInterface);
                }
            });
            try {
                Result.Companion companion = Result.INSTANCE;
                RNBootSplashDialog rNBootSplashDialog = this;
                super.dismiss();
                objM2319constructorimpl = Result.m2319constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM2319constructorimpl = Result.m2319constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m2322exceptionOrNullimpl(objM2319constructorimpl) != null) {
                callback.invoke();
                return;
            }
            return;
        }
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$1(Function0 callback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    @Override // android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            RNBootSplashDialog rNBootSplashDialog = this;
            super.show();
            Result.m2319constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m2319constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void show(final Function0<Unit> callback) {
        Object objM2319constructorimpl;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!isShowing()) {
            setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.zoontek.rnbootsplash.RNBootSplashDialog$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    RNBootSplashDialog.show$lambda$5(callback, dialogInterface);
                }
            });
            try {
                Result.Companion companion = Result.INSTANCE;
                RNBootSplashDialog rNBootSplashDialog = this;
                super.show();
                objM2319constructorimpl = Result.m2319constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM2319constructorimpl = Result.m2319constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m2322exceptionOrNullimpl(objM2319constructorimpl) != null) {
                callback.invoke();
                return;
            }
            return;
        }
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$5(Function0 callback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setWindowAnimations(this.fade ? R.style.BootSplashFadeOutAnimation : R.style.BootSplashNoAnimation);
            if (RNBootSplashModuleImpl.INSTANCE.isSamsungOneUI4()) {
                window.setBackgroundDrawableResource(R.drawable.compat_splash_screen_oneui_4);
            }
        }
        super.onCreate(savedInstanceState);
    }
}
