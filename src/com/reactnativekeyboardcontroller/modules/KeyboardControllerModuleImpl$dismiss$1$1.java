package com.reactnativekeyboardcontroller.modules;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: KeyboardControllerModuleImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "insetsController", "Landroidx/core/view/WindowInsetsAnimationControllerCompat;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class KeyboardControllerModuleImpl$dismiss$1$1 extends Lambda implements Function1<WindowInsetsAnimationControllerCompat, Unit> {
    final /* synthetic */ boolean $keepFocus;
    final /* synthetic */ View $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KeyboardControllerModuleImpl$dismiss$1$1(View view, boolean z) {
        super(1);
        this.$view = view;
        this.$keepFocus = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat) {
        invoke2(windowInsetsAnimationControllerCompat);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WindowInsetsAnimationControllerCompat insetsController) {
        Intrinsics.checkNotNullParameter(insetsController, "insetsController");
        insetsController.finish(false);
        final View view = this.$view;
        final boolean z = this.$keepFocus;
        view.post(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$dismiss$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardControllerModuleImpl.access$dismiss$lambda$0$maybeClearFocus(z, view);
            }
        });
    }
}
