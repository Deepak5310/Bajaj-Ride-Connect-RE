package com.mappls.sdk.maps.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.mappls.sdk.maps.MapplsMap;

/* JADX INFO: loaded from: classes4.dex */
class MapplsCameraAnimatorAdapter extends MapplsFloatAnimator {
    private final MapplsMap.CancelableCallback cancelableCallback;

    MapplsCameraAnimatorAdapter(Float[] fArr, MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener, MapplsMap.CancelableCallback cancelableCallback) {
        super(fArr, animationsValueChangeListener, Integer.MAX_VALUE);
        this.cancelableCallback = cancelableCallback;
        addListener(new MapplsAnimatorListener());
    }

    private final class MapplsAnimatorListener extends AnimatorListenerAdapter {
        private MapplsAnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (MapplsCameraAnimatorAdapter.this.cancelableCallback != null) {
                MapplsCameraAnimatorAdapter.this.cancelableCallback.onCancel();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (MapplsCameraAnimatorAdapter.this.cancelableCallback != null) {
                MapplsCameraAnimatorAdapter.this.cancelableCallback.onFinish();
            }
        }
    }
}
