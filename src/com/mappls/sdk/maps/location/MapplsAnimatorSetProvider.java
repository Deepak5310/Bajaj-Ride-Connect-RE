package com.mappls.sdk.maps.location;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.animation.Interpolator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class MapplsAnimatorSetProvider {
    private static MapplsAnimatorSetProvider instance;

    private MapplsAnimatorSetProvider() {
    }

    static MapplsAnimatorSetProvider getInstance() {
        if (instance == null) {
            instance = new MapplsAnimatorSetProvider();
        }
        return instance;
    }

    void startAnimation(List<Animator> list, Interpolator interpolator, long j) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(list);
        animatorSet.setInterpolator(interpolator);
        animatorSet.setDuration(j);
        animatorSet.start();
    }
}
