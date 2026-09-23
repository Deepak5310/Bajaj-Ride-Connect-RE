package com.reactnativekeyboardcontroller.interactive;

import android.os.CancellationSignal;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.DynamicAnimationKt;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: KeyboardAnimationController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eJ\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010%\u001a\u00020\u000eJ\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\u0016\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u0017J&\u0010,\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/reactnativekeyboardcontroller/interactive/KeyboardAnimationController;", "", "()V", "animationControlListener", "com/reactnativekeyboardcontroller/interactive/KeyboardAnimationController$animationControlListener$2$1", "getAnimationControlListener", "()Lcom/reactnativekeyboardcontroller/interactive/KeyboardAnimationController$animationControlListener$2$1;", "animationControlListener$delegate", "Lkotlin/Lazy;", "currentSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "insetsAnimationController", "Landroidx/core/view/WindowInsetsAnimationControllerCompat;", "isImeShownAtStart", "", "pendingRequestCancellationSignal", "Landroid/os/CancellationSignal;", "pendingRequestOnReady", "Lkotlin/Function1;", "", "animateImeToVisibility", "visible", "velocityY", "", "(ZLjava/lang/Float;)V", "animateToFinish", "(Ljava/lang/Float;)V", "cancel", "finish", "getCurrentKeyboardHeight", "", "insetBy", "dy", "insetTo", "inset", "isInsetAnimationFinishing", "isInsetAnimationInProgress", "isInsetAnimationRequestPending", "onRequestReady", "controller", "reset", "startAndFling", "view", "Landroid/view/View;", "startControlRequest", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KeyboardAnimationController {

    /* JADX INFO: renamed from: animationControlListener$delegate, reason: from kotlin metadata */
    private final Lazy animationControlListener = LazyKt.lazy(new Function0<KeyboardAnimationController$animationControlListener$2.AnonymousClass1>() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$animationControlListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$animationControlListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final KeyboardAnimationController keyboardAnimationController = this.this$0;
            return new WindowInsetsAnimationControlListenerCompat() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$animationControlListener$2.1
                @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
                public void onReady(WindowInsetsAnimationControllerCompat controller, int types) {
                    Intrinsics.checkNotNullParameter(controller, "controller");
                    keyboardAnimationController.onRequestReady(controller);
                }

                @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
                public void onFinished(WindowInsetsAnimationControllerCompat controller) {
                    Intrinsics.checkNotNullParameter(controller, "controller");
                    keyboardAnimationController.reset();
                }

                @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
                public void onCancelled(WindowInsetsAnimationControllerCompat controller) {
                    keyboardAnimationController.reset();
                }
            };
        }
    });
    private SpringAnimation currentSpringAnimation;
    private WindowInsetsAnimationControllerCompat insetsAnimationController;
    private boolean isImeShownAtStart;
    private CancellationSignal pendingRequestCancellationSignal;
    private Function1<? super WindowInsetsAnimationControllerCompat, Unit> pendingRequestOnReady;

    private final KeyboardAnimationController$animationControlListener$2.AnonymousClass1 getAnimationControlListener() {
        return (KeyboardAnimationController$animationControlListener$2.AnonymousClass1) this.animationControlListener.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startControlRequest$default(KeyboardAnimationController keyboardAnimationController, View view, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        keyboardAnimationController.startControlRequest(view, function1);
    }

    public final void startControlRequest(View view, Function1<? super WindowInsetsAnimationControllerCompat, Unit> onRequestReady) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isInsetAnimationInProgress()) {
            throw new IllegalStateException("Animation in progress. Can not start a new request to controlWindowInsetsAnimation()".toString());
        }
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        boolean z = false;
        if (rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
            z = true;
        }
        this.isImeShownAtStart = z;
        this.pendingRequestCancellationSignal = new CancellationSignal();
        this.pendingRequestOnReady = onRequestReady;
        InteractiveKeyboardProvider.INSTANCE.setInteractive(true);
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(view);
        if (windowInsetsController != null) {
            windowInsetsController.controlWindowInsetsAnimation(WindowInsetsCompat.Type.ime(), -1L, KeyboardAnimationControllerKt.linearInterpolator, this.pendingRequestCancellationSignal, getAnimationControlListener());
        }
    }

    public final void startAndFling(View view, final float velocityY) {
        Intrinsics.checkNotNullParameter(view, "view");
        startControlRequest(view, new Function1<WindowInsetsAnimationControllerCompat, Unit>() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController.startAndFling.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat) {
                invoke2(windowInsetsAnimationControllerCompat);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WindowInsetsAnimationControllerCompat it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                KeyboardAnimationController.this.animateToFinish(Float.valueOf(velocityY));
            }
        });
    }

    public final int insetBy(int dy) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        InteractiveKeyboardProvider.INSTANCE.setInteractive(true);
        return insetTo(windowInsetsAnimationControllerCompat.getCurrentInsets().bottom - dy);
    }

    public final int insetTo(int inset) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        int i = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        int i2 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        boolean z = this.isImeShownAtStart;
        int i3 = z ? i2 : i;
        int i4 = z ? i : i2;
        int iCoerceIn = RangesKt.coerceIn(inset, i, i2);
        int i5 = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom - iCoerceIn;
        windowInsetsAnimationControllerCompat.setInsetsAndAlpha(Insets.of(0, 0, 0, iCoerceIn), 1.0f, (iCoerceIn - i3) / (i4 - i3));
        return i5;
    }

    public final boolean isInsetAnimationInProgress() {
        return this.insetsAnimationController != null;
    }

    public final boolean isInsetAnimationFinishing() {
        return this.currentSpringAnimation != null;
    }

    public final boolean isInsetAnimationRequestPending() {
        return this.pendingRequestCancellationSignal != null;
    }

    public final void cancel() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat != null) {
            windowInsetsAnimationControllerCompat.finish(this.isImeShownAtStart);
        }
        CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        SpringAnimation springAnimation = this.currentSpringAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        reset();
    }

    public final void finish() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
                return;
            }
            return;
        }
        int i = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
        int i2 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        int i3 = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        if (i == i2) {
            windowInsetsAnimationControllerCompat.finish(true);
            return;
        }
        if (i == i3) {
            windowInsetsAnimationControllerCompat.finish(false);
        } else if (windowInsetsAnimationControllerCompat.getCurrentFraction() >= 0.15f) {
            windowInsetsAnimationControllerCompat.finish(!this.isImeShownAtStart);
        } else {
            windowInsetsAnimationControllerCompat.finish(this.isImeShownAtStart);
        }
    }

    public static /* synthetic */ void animateToFinish$default(KeyboardAnimationController keyboardAnimationController, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        keyboardAnimationController.animateToFinish(f);
    }

    public final void animateToFinish(Float velocityY) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
                return;
            }
            return;
        }
        InteractiveKeyboardProvider.INSTANCE.setInteractive(false);
        int i = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
        int i2 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        int i3 = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        if (velocityY != null) {
            animateImeToVisibility(velocityY.floatValue() < 0.0f, velocityY);
            return;
        }
        if (i == i2) {
            windowInsetsAnimationControllerCompat.finish(true);
            return;
        }
        if (i == i3) {
            windowInsetsAnimationControllerCompat.finish(false);
        } else if (windowInsetsAnimationControllerCompat.getCurrentFraction() >= 0.15f) {
            animateImeToVisibility$default(this, !this.isImeShownAtStart, null, 2, null);
        } else {
            animateImeToVisibility$default(this, this.isImeShownAtStart, null, 2, null);
        }
    }

    public final int getCurrentKeyboardHeight() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        return windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestReady(WindowInsetsAnimationControllerCompat controller) {
        this.pendingRequestCancellationSignal = null;
        this.insetsAnimationController = controller;
        Function1<? super WindowInsetsAnimationControllerCompat, Unit> function1 = this.pendingRequestOnReady;
        if (function1 != null) {
            function1.invoke(controller);
        }
        this.pendingRequestOnReady = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reset() {
        this.insetsAnimationController = null;
        this.pendingRequestCancellationSignal = null;
        this.isImeShownAtStart = false;
        SpringAnimation springAnimation = this.currentSpringAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.currentSpringAnimation = null;
        this.pendingRequestOnReady = null;
    }

    static /* synthetic */ void animateImeToVisibility$default(KeyboardAnimationController keyboardAnimationController, boolean z, Float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = null;
        }
        keyboardAnimationController.animateImeToVisibility(z, f);
    }

    private final void animateImeToVisibility(boolean visible, Float velocityY) {
        int i;
        final WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Controller should not be null");
        }
        Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController.animateImeToVisibility.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                KeyboardAnimationController.this.insetTo(MathKt.roundToInt(f));
            }
        };
        Function0<Float> function0 = new Function0<Float>() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController.animateImeToVisibility.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(windowInsetsAnimationControllerCompat.getCurrentInsets().bottom);
            }
        };
        if (visible) {
            i = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        } else {
            i = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        }
        SpringAnimation springAnimationSpringAnimationOf = DynamicAnimationKt.springAnimationOf(function1, function0, i);
        if (springAnimationSpringAnimationOf.getSpring() == null) {
            springAnimationSpringAnimationOf.setSpring(new SpringForce());
        }
        SpringForce spring = springAnimationSpringAnimationOf.getSpring();
        Intrinsics.checkExpressionValueIsNotNull(spring, "spring");
        spring.setDampingRatio(1.0f);
        spring.setStiffness(1500.0f);
        if (velocityY != null) {
            springAnimationSpringAnimationOf.setStartVelocity(velocityY.floatValue());
        }
        springAnimationSpringAnimationOf.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda0
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                KeyboardAnimationController.animateImeToVisibility$lambda$3$lambda$2(this.f$0, dynamicAnimation, z, f, f2);
            }
        });
        springAnimationSpringAnimationOf.start();
        this.currentSpringAnimation = springAnimationSpringAnimationOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateImeToVisibility$lambda$3$lambda$2(KeyboardAnimationController this$0, DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(dynamicAnimation, this$0.currentSpringAnimation)) {
            this$0.currentSpringAnimation = null;
        }
        this$0.finish();
    }
}
