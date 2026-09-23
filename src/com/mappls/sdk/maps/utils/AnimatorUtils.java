package com.mappls.sdk.maps.utils;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: loaded from: classes4.dex */
public class AnimatorUtils {

    public interface OnAnimationEndListener {
        void onAnimationEnd();
    }

    public static void animate(View view, int i, OnAnimationEndListener onAnimationEndListener) {
        animate(view, i, -1, onAnimationEndListener);
    }

    public static void animate(final View view, int i, int i2, final OnAnimationEndListener onAnimationEndListener) {
        if (view == null) {
            return;
        }
        view.setLayerType(2, null);
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(view.getContext(), i);
        if (i2 != -1) {
            animatorLoadAnimator.setDuration(i2);
        }
        animatorLoadAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.mappls.sdk.maps.utils.AnimatorUtils.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setLayerType(0, null);
                OnAnimationEndListener onAnimationEndListener2 = onAnimationEndListener;
                if (onAnimationEndListener2 != null) {
                    onAnimationEndListener2.onAnimationEnd();
                }
            }
        });
        animatorLoadAnimator.setTarget(view);
        animatorLoadAnimator.start();
    }

    public static void animate(View view, int i) {
        animate(view, i, -1);
    }

    public static void animate(View view, int i, int i2) {
        animate(view, i, i2, null);
    }

    public static void rotate(final View view, float f) {
        view.setLayerType(2, null);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ROTATION, view.getRotation(), f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.mappls.sdk.maps.utils.AnimatorUtils.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setLayerType(0, null);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public static void rotateBy(final View view, float f) {
        view.setLayerType(2, null);
        view.animate().rotationBy(f).setInterpolator(new FastOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.mappls.sdk.maps.utils.AnimatorUtils.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setLayerType(0, null);
            }
        });
    }

    public static void alpha(final View view, float f, final OnAnimationEndListener onAnimationEndListener) {
        view.setLayerType(2, null);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, view.getAlpha(), f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.mappls.sdk.maps.utils.AnimatorUtils.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setLayerType(0, null);
                OnAnimationEndListener onAnimationEndListener2 = onAnimationEndListener;
                if (onAnimationEndListener2 != null) {
                    onAnimationEndListener2.onAnimationEnd();
                }
            }
        });
        objectAnimatorOfFloat.start();
    }

    public static void alpha(View view, float f) {
        alpha(view, f, null);
    }
}
