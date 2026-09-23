package com.google.android.libraries.navigation.internal.yr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am {
    public static final /* synthetic */ int a = 0;

    static {
        new Random().nextInt();
        new HashMap();
    }

    @JvmStatic
    public static final AnimatorListenerAdapter a(AnimatorListenerAdapter delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new a(delegate, delegate);
    }

    @JvmStatic
    public static final com.google.android.libraries.navigation.internal.yx.aa b(com.google.android.libraries.navigation.internal.yx.aa function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new aq(i.c(), function);
    }

    @JvmStatic
    public static final com.google.android.libraries.navigation.internal.aac.s c(com.google.android.libraries.navigation.internal.aac.s asyncCallable) {
        Intrinsics.checkNotNullParameter(asyncCallable, "asyncCallable");
        return new an(i.c(), asyncCallable);
    }

    @JvmStatic
    public static final com.google.android.libraries.navigation.internal.aac.t d(com.google.android.libraries.navigation.internal.aac.t asyncFunction) {
        Intrinsics.checkNotNullParameter(asyncFunction, "asyncFunction");
        return new ao(i.c(), asyncFunction);
    }

    @JvmStatic
    public static final Runnable e(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return new as(new Ref.ObjectRef(), i.c(), runnable);
    }

    @JvmStatic
    public static final Callable f(Callable callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        return new ap(i.c(), callable);
    }

    /* JADX INFO: compiled from: PG */
    final class a extends AnimatorListenerAdapter {
        private final Animator.AnimatorListener a;
        private final Animator.AnimatorPauseListener b;
        private ag c;

        public a(Animator.AnimatorListener delegate, Animator.AnimatorPauseListener animatorPauseListener) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.a = delegate;
            this.b = animatorPauseListener;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.c = null;
            this.a.onAnimationCancel(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            ag agVar = this.c;
            this.c = null;
            if (i.i() || agVar == null) {
                this.a.onAnimationEnd(animator);
                return;
            }
            ae aeVarA = i.a();
            ag agVarE = i.e(aeVarA, agVar);
            try {
                this.a.onAnimationEnd(animator);
                Unit unit = Unit.INSTANCE;
                i.e(aeVarA, agVarE);
            } catch (Throwable th) {
                try {
                    f.a(th);
                    throw th;
                } catch (Throwable th2) {
                    i.e(aeVarA, agVarE);
                    throw th2;
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.c = null;
            Animator.AnimatorPauseListener animatorPauseListener = this.b;
            if (animatorPauseListener != null) {
                animatorPauseListener.onAnimationPause(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.c = null;
            this.a.onAnimationRepeat(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.c = i.c();
            Animator.AnimatorPauseListener animatorPauseListener = this.b;
            if (animatorPauseListener != null) {
                animatorPauseListener.onAnimationResume(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.c = i.c();
            this.a.onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.c = i.c();
            this.a.onAnimationStart(animator, z);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            ag agVar = this.c;
            this.c = null;
            if (i.i() || agVar == null) {
                this.a.onAnimationEnd(animator, z);
                return;
            }
            ae aeVarA = i.a();
            ag agVarE = i.e(aeVarA, agVar);
            try {
                this.a.onAnimationEnd(animator, z);
                Unit unit = Unit.INSTANCE;
                i.e(aeVarA, agVarE);
            } catch (Throwable th) {
                try {
                    f.a(th);
                    throw th;
                } catch (Throwable th2) {
                    i.e(aeVarA, agVarE);
                    throw th2;
                }
            }
        }
    }
}
