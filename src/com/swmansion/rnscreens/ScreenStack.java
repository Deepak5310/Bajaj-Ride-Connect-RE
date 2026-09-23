package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ScreenStack.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 F2\u00020\u0001:\u0002FGB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0014J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020(H\u0002J\b\u0010.\u001a\u00020(H\u0002J \u0010/\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u000201H\u0016J\u0012\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020(H\u0014J\f\u0010:\u001a\u00060\nR\u00020\u0000H\u0002J\b\u0010;\u001a\u00020(H\u0016J\u0006\u0010<\u001a\u00020(J\u0014\u0010=\u001a\u00020(2\n\u0010>\u001a\u00060\nR\u00020\u0000H\u0002J\b\u0010?\u001a\u00020(H\u0016J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020\u0019H\u0016J\u0010\u0010B\u001a\u00020(2\u0006\u00105\u001a\u000201H\u0016J\u0010\u0010C\u001a\u00020(2\u0006\u00105\u001a\u000201H\u0016J\u0012\u0010D\u001a\u00020(2\b\u0010E\u001a\u0004\u0018\u000108H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00000\tX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u0010\u0010#\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack;", "Lcom/swmansion/rnscreens/ScreenContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissedWrappers", "", "Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "drawingOpPool", "", "Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "drawingOps", "fragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFragments", "()Ljava/util/ArrayList;", "goingForward", "", "getGoingForward", "()Z", "setGoingForward", "(Z)V", "isDetachingCurrentScreen", "previousChildrenCount", "", "removalTransitionStarted", "reverseLastTwoChildren", "rootScreen", "Lcom/swmansion/rnscreens/Screen;", "getRootScreen", "()Lcom/swmansion/rnscreens/Screen;", StackTraceHelper.STACK_KEY, "topScreen", "getTopScreen", "topScreenWrapper", "adapt", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "screen", "dismiss", "", "screenFragment", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchOnFinishTransitioning", "drawAndRelease", "drawChild", "child", "Landroid/view/View;", "drawingTime", "", "endViewTransition", "view", "hasScreen", "screenFragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "notifyContainerUpdate", "obtainDrawingOp", "onUpdate", "onViewAppearTransitionEnd", "performDraw", "op", "removeAllScreens", "removeScreenAt", FirebaseAnalytics.Param.INDEX, "removeView", "startViewTransition", "turnOffA11yUnderTransparentScreen", "visibleBottom", "Companion", "DrawingOp", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScreenStack extends ScreenContainer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Set<ScreenStackFragmentWrapper> dismissedWrappers;
    private final List<DrawingOp> drawingOpPool;
    private List<DrawingOp> drawingOps;
    private boolean goingForward;
    private boolean isDetachingCurrentScreen;
    private int previousChildrenCount;
    private boolean removalTransitionStarted;
    private boolean reverseLastTwoChildren;
    private final ArrayList<ScreenStackFragmentWrapper> stack;
    private ScreenStackFragmentWrapper topScreenWrapper;

    /* JADX INFO: compiled from: ScreenStack.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.StackAnimation.values().length];
            try {
                iArr[Screen.StackAnimation.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Screen.StackAnimation.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Screen.StackAnimation.FADE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Screen.StackAnimation.SLIDE_FROM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Screen.StackAnimation.SLIDE_FROM_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Screen.StackAnimation.SLIDE_FROM_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Screen.StackAnimation.FADE_FROM_BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Screen.StackAnimation.IOS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Screen.StackAnimation.IOS_FROM_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Screen.StackAnimation.IOS_FROM_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ScreenStack(Context context) {
        super(context);
        this.stack = new ArrayList<>();
        this.dismissedWrappers = new HashSet();
        this.drawingOpPool = new ArrayList();
        this.drawingOps = new ArrayList();
    }

    public final boolean getGoingForward() {
        return this.goingForward;
    }

    public final void setGoingForward(boolean z) {
        this.goingForward = z;
    }

    public final void dismiss(ScreenStackFragmentWrapper screenFragment) {
        Intrinsics.checkNotNullParameter(screenFragment, "screenFragment");
        this.dismissedWrappers.add(screenFragment);
        performUpdatesNow();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public Screen getTopScreen() {
        ScreenStackFragmentWrapper screenStackFragmentWrapper = this.topScreenWrapper;
        if (screenStackFragmentWrapper != null) {
            return screenStackFragmentWrapper.getScreen();
        }
        return null;
    }

    public final ArrayList<ScreenStackFragmentWrapper> getFragments() {
        return this.stack;
    }

    public final Screen getRootScreen() {
        int screenCount = getScreenCount();
        for (int i = 0; i < screenCount; i++) {
            ScreenFragmentWrapper screenFragmentWrapperAt = getScreenFragmentWrapperAt(i);
            if (!CollectionsKt.contains(this.dismissedWrappers, screenFragmentWrapperAt)) {
                return screenFragmentWrapperAt.getScreen();
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.ScreenContainer
    public ScreenStackFragment adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenStackFragment(screen);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.startViewTransition(view);
        this.removalTransitionStarted = true;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        if (this.removalTransitionStarted) {
            this.removalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public final void onViewAppearTransitionEnd() {
        if (this.removalTransitionStarted) {
            return;
        }
        dispatchOnFinishTransitioning();
    }

    private final void dispatchOnFinishTransitioning() {
        int surfaceId = UIManagerHelper.getSurfaceId(this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new StackFinishTransitioningEvent(surfaceId, getId()));
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeScreenAt(int index) {
        Set<ScreenStackFragmentWrapper> set = this.dismissedWrappers;
        TypeIntrinsics.asMutableCollection(set).remove(getScreenFragmentWrapperAt(index));
        super.removeScreenAt(index);
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeAllScreens() {
        this.dismissedWrappers.clear();
        super.removeAllScreens();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public boolean hasScreen(ScreenFragmentWrapper screenFragmentWrapper) {
        return super.hasScreen(screenFragmentWrapper) && !CollectionsKt.contains(this.dismissedWrappers, screenFragmentWrapper);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030 A[DONT_INVERT, PHI: r3 r4
      0x0030: PHI (r3v9 com.swmansion.rnscreens.ScreenFragmentWrapper) = (r3v8 com.swmansion.rnscreens.ScreenFragmentWrapper), (r3v10 com.swmansion.rnscreens.ScreenFragmentWrapper) binds: [B:5:0x001e, B:10:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x0030: PHI (r4v3 com.swmansion.rnscreens.ScreenFragmentWrapper) = (r4v2 com.swmansion.rnscreens.ScreenFragmentWrapper), (r4v5 com.swmansion.rnscreens.ScreenFragmentWrapper) binds: [B:5:0x001e, B:10:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:138:0x0035 A[EDGE_INSN: B:138:0x0035->B:15:0x0035 BREAK  A[LOOP:0: B:4:0x0010->B:14:0x0033], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0033 A[LOOP:0: B:4:0x0010->B:14:0x0033, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a8  */
    @Override // com.swmansion.rnscreens.ScreenContainer
    public void onUpdate() {
        Screen.StackAnimation stackAnimation;
        boolean z;
        Screen screen;
        ScreenFragmentWrapper next;
        Screen screen2;
        this.isDetachingCurrentScreen = false;
        int size = this.screenWrappers.size() - 1;
        final ScreenFragmentWrapper screenFragmentWrapper = null;
        ScreenFragmentWrapper screenFragmentWrapper2 = null;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                ScreenFragmentWrapper screenFragmentWrapperAt = getScreenFragmentWrapperAt(size);
                if (!CollectionsKt.contains(this.dismissedWrappers, screenFragmentWrapperAt)) {
                    if (screenFragmentWrapper == null) {
                        screenFragmentWrapper = screenFragmentWrapperAt;
                    } else {
                        screenFragmentWrapper2 = screenFragmentWrapperAt;
                    }
                    if (!screenFragmentWrapperAt.getScreen().isTransparent()) {
                        break;
                    }
                    if (i < 0) {
                        break;
                        break;
                    }
                    size = i;
                } else if (i < 0) {
                    break;
                } else {
                    size = i;
                }
            }
        }
        boolean z2 = true;
        if (!CollectionsKt.contains(this.stack, screenFragmentWrapper)) {
            ScreenStackFragmentWrapper screenStackFragmentWrapper = this.topScreenWrapper;
            if (screenStackFragmentWrapper == null || screenFragmentWrapper == null) {
                if (screenStackFragmentWrapper != null || screenFragmentWrapper == null) {
                    stackAnimation = null;
                } else {
                    stackAnimation = Screen.StackAnimation.NONE;
                    this.goingForward = true;
                }
                z = true;
            } else {
                z = (screenStackFragmentWrapper != null && this.screenWrappers.contains(screenStackFragmentWrapper)) || (screenFragmentWrapper.getScreen().getReplaceAnimation() == Screen.ReplaceAnimation.PUSH);
                if (z) {
                    screen2 = screenFragmentWrapper.getScreen();
                } else {
                    ScreenStackFragmentWrapper screenStackFragmentWrapper2 = this.topScreenWrapper;
                    if (screenStackFragmentWrapper2 == null || (screen2 = screenStackFragmentWrapper2.getScreen()) == null) {
                        stackAnimation = null;
                    }
                }
                stackAnimation = screen2.getStackAnimation();
            }
        } else {
            ScreenStackFragmentWrapper screenStackFragmentWrapper3 = this.topScreenWrapper;
            if (screenStackFragmentWrapper3 == null || Intrinsics.areEqual(screenStackFragmentWrapper3, screenFragmentWrapper)) {
                stackAnimation = null;
                z = true;
            } else {
                ScreenStackFragmentWrapper screenStackFragmentWrapper4 = this.topScreenWrapper;
                stackAnimation = (screenStackFragmentWrapper4 == null || (screen = screenStackFragmentWrapper4.getScreen()) == null) ? null : screen.getStackAnimation();
                z = false;
            }
        }
        FragmentTransaction fragmentTransactionCreateTransaction = createTransaction();
        if (stackAnimation != null) {
            if (z) {
                switch (WhenMappings.$EnumSwitchMapping$0[stackAnimation.ordinal()]) {
                    case 1:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_default_enter_in, R.anim.rns_default_enter_out);
                        break;
                    case 2:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_no_animation_20, R.anim.rns_no_animation_20);
                        break;
                    case 3:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_fade_in, R.anim.rns_fade_out);
                        break;
                    case 4:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_slide_in_from_right, R.anim.rns_slide_out_to_left);
                        break;
                    case 5:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_slide_in_from_left, R.anim.rns_slide_out_to_right);
                        break;
                    case 6:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_slide_in_from_bottom, R.anim.rns_no_animation_medium);
                        break;
                    case 7:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_fade_from_bottom, R.anim.rns_no_animation_350);
                        break;
                    case 8:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_ios_from_right_foreground_open, R.anim.rns_ios_from_right_background_open);
                        break;
                    case 9:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_ios_from_right_foreground_open, R.anim.rns_ios_from_right_background_open);
                        break;
                    case 10:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_ios_from_left_foreground_open, R.anim.rns_ios_from_left_background_open);
                        break;
                }
            } else {
                switch (WhenMappings.$EnumSwitchMapping$0[stackAnimation.ordinal()]) {
                    case 1:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_default_exit_in, R.anim.rns_default_exit_out);
                        break;
                    case 2:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_no_animation_20, R.anim.rns_no_animation_20);
                        break;
                    case 3:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_fade_in, R.anim.rns_fade_out);
                        break;
                    case 4:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_slide_in_from_left, R.anim.rns_slide_out_to_right);
                        break;
                    case 5:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_slide_in_from_right, R.anim.rns_slide_out_to_left);
                        break;
                    case 6:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_no_animation_medium, R.anim.rns_slide_out_to_bottom);
                        break;
                    case 7:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_no_animation_250, R.anim.rns_fade_to_bottom);
                        break;
                    case 8:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_ios_from_right_foreground_close, R.anim.rns_ios_from_right_background_close);
                        break;
                    case 9:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_ios_from_right_background_close, R.anim.rns_ios_from_right_foreground_close);
                        break;
                    case 10:
                        fragmentTransactionCreateTransaction.setCustomAnimations(R.anim.rns_ios_from_left_background_close, R.anim.rns_ios_from_left_foreground_close);
                        break;
                }
            }
        }
        this.goingForward = z;
        if (z && screenFragmentWrapper != null && INSTANCE.needsDrawReordering(screenFragmentWrapper) && screenFragmentWrapper2 == null) {
            this.isDetachingCurrentScreen = true;
        }
        for (ScreenStackFragmentWrapper screenStackFragmentWrapper5 : this.stack) {
            if (!this.screenWrappers.contains(screenStackFragmentWrapper5) || this.dismissedWrappers.contains(screenStackFragmentWrapper5)) {
                fragmentTransactionCreateTransaction.remove(screenStackFragmentWrapper5.getFragment());
            }
        }
        Iterator<ScreenFragmentWrapper> it2 = this.screenWrappers.iterator();
        while (it2.hasNext() && (next = it2.next()) != screenFragmentWrapper2) {
            if (next != screenFragmentWrapper && !CollectionsKt.contains(this.dismissedWrappers, next)) {
                fragmentTransactionCreateTransaction.remove(next.getFragment());
            }
        }
        if (screenFragmentWrapper2 != null && !screenFragmentWrapper2.getFragment().isAdded()) {
            for (ScreenFragmentWrapper screenFragmentWrapper3 : this.screenWrappers) {
                if (z2) {
                    if (screenFragmentWrapper3 == screenFragmentWrapper2) {
                        z2 = false;
                    }
                }
                fragmentTransactionCreateTransaction.add(getId(), screenFragmentWrapper3.getFragment()).runOnCommit(new Runnable() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenStack.onUpdate$lambda$3$lambda$1(screenFragmentWrapper);
                    }
                });
            }
        } else if (screenFragmentWrapper != null && !screenFragmentWrapper.getFragment().isAdded()) {
            fragmentTransactionCreateTransaction.add(getId(), screenFragmentWrapper.getFragment());
        }
        this.topScreenWrapper = screenFragmentWrapper instanceof ScreenStackFragmentWrapper ? (ScreenStackFragmentWrapper) screenFragmentWrapper : null;
        this.stack.clear();
        ArrayList<ScreenStackFragmentWrapper> arrayList = this.stack;
        ArrayList<ScreenFragmentWrapper> arrayList2 = this.screenWrappers;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ScreenFragmentWrapper screenFragmentWrapper4 : arrayList2) {
            Intrinsics.checkNotNull(screenFragmentWrapper4, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragmentWrapper");
            arrayList3.add((ScreenStackFragmentWrapper) screenFragmentWrapper4);
        }
        arrayList.addAll(arrayList3);
        turnOffA11yUnderTransparentScreen(screenFragmentWrapper2);
        fragmentTransactionCreateTransaction.commitNowAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$3$lambda$1(ScreenFragmentWrapper screenFragmentWrapper) {
        Screen screen;
        if (screenFragmentWrapper == null || (screen = screenFragmentWrapper.getScreen()) == null) {
            return;
        }
        screen.bringToFront();
    }

    private final void turnOffA11yUnderTransparentScreen(ScreenFragmentWrapper visibleBottom) {
        ScreenStackFragmentWrapper screenStackFragmentWrapper;
        if (this.screenWrappers.size() > 1 && visibleBottom != null && (screenStackFragmentWrapper = this.topScreenWrapper) != null && screenStackFragmentWrapper.getScreen().isTransparent()) {
            for (ScreenFragmentWrapper screenFragmentWrapper : CollectionsKt.asReversed(CollectionsKt.slice((List) this.screenWrappers, RangesKt.until(0, this.screenWrappers.size() - 1)))) {
                screenFragmentWrapper.getScreen().changeAccessibilityMode(4);
                if (Intrinsics.areEqual(screenFragmentWrapper, visibleBottom)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.changeAccessibilityMode(0);
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    protected void notifyContainerUpdate() {
        Iterator<T> it2 = this.stack.iterator();
        while (it2.hasNext()) {
            ((ScreenStackFragmentWrapper) it2.next()).onContainerUpdate();
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer, android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.isDetachingCurrentScreen) {
            this.isDetachingCurrentScreen = false;
            this.reverseLastTwoChildren = true;
        }
        super.removeView(view);
    }

    private final void drawAndRelease() {
        List<DrawingOp> list = this.drawingOps;
        this.drawingOps = new ArrayList();
        for (DrawingOp drawingOp : list) {
            drawingOp.draw();
            this.drawingOpPool.add(drawingOp);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.drawingOps.size() < this.previousChildrenCount) {
            this.reverseLastTwoChildren = false;
        }
        this.previousChildrenCount = this.drawingOps.size();
        if (this.reverseLastTwoChildren && this.drawingOps.size() >= 2) {
            List<DrawingOp> list = this.drawingOps;
            Collections.swap(list, list.size() - 1, this.drawingOps.size() - 2);
        }
        drawAndRelease();
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        List<DrawingOp> list = this.drawingOps;
        DrawingOp drawingOpObtainDrawingOp = obtainDrawingOp();
        drawingOpObtainDrawingOp.setCanvas(canvas);
        drawingOpObtainDrawingOp.setChild(child);
        drawingOpObtainDrawingOp.setDrawingTime(drawingTime);
        list.add(drawingOpObtainDrawingOp);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performDraw(DrawingOp op) {
        Canvas canvas = op.getCanvas();
        Intrinsics.checkNotNull(canvas);
        super.drawChild(canvas, op.getChild(), op.getDrawingTime());
    }

    private final DrawingOp obtainDrawingOp() {
        if (this.drawingOpPool.isEmpty()) {
            return new DrawingOp();
        }
        List<DrawingOp> list = this.drawingOpPool;
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    /* JADX INFO: compiled from: ScreenStack.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "", "(Lcom/swmansion/rnscreens/ScreenStack;)V", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "setChild", "(Landroid/view/View;)V", "drawingTime", "", "getDrawingTime", "()J", "setDrawingTime", "(J)V", "draw", "", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class DrawingOp {
        private Canvas canvas;
        private View child;
        private long drawingTime;

        public DrawingOp() {
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas) {
            this.canvas = canvas;
        }

        public final View getChild() {
            return this.child;
        }

        public final void setChild(View view) {
            this.child = view;
        }

        public final long getDrawingTime() {
            return this.drawingTime;
        }

        public final void setDrawingTime(long j) {
            this.drawingTime = j;
        }

        public final void draw() {
            ScreenStack.this.performDraw(this);
            this.canvas = null;
            this.child = null;
            this.drawingTime = 0L;
        }
    }

    /* JADX INFO: compiled from: ScreenStack.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack$Companion;", "", "()V", "needsDrawReordering", "", "fragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean needsDrawReordering(ScreenFragmentWrapper fragmentWrapper) {
            return Build.VERSION.SDK_INT >= 33 || fragmentWrapper.getScreen().getStackAnimation() == Screen.StackAnimation.SLIDE_FROM_BOTTOM || fragmentWrapper.getScreen().getStackAnimation() == Screen.StackAnimation.FADE_FROM_BOTTOM || fragmentWrapper.getScreen().getStackAnimation() == Screen.StackAnimation.IOS || fragmentWrapper.getScreen().getStackAnimation() == Screen.StackAnimation.IOS_FROM_RIGHT || fragmentWrapper.getScreen().getStackAnimation() == Screen.StackAnimation.IOS_FROM_LEFT;
        }
    }
}
