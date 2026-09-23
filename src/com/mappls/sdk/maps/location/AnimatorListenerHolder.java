package com.mappls.sdk.maps.location;

/* JADX INFO: loaded from: classes4.dex */
class AnimatorListenerHolder {
    private final int animatorType;
    private final MapplsAnimator.AnimationsValueChangeListener listener;

    AnimatorListenerHolder(int i, MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener) {
        this.animatorType = i;
        this.listener = animationsValueChangeListener;
    }

    public int getAnimatorType() {
        return this.animatorType;
    }

    public MapplsAnimator.AnimationsValueChangeListener getListener() {
        return this.listener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AnimatorListenerHolder animatorListenerHolder = (AnimatorListenerHolder) obj;
        if (this.animatorType != animatorListenerHolder.animatorType) {
            return false;
        }
        MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listener;
        MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener2 = animatorListenerHolder.listener;
        if (animationsValueChangeListener != null) {
            return animationsValueChangeListener.equals(animationsValueChangeListener2);
        }
        return animationsValueChangeListener2 == null;
    }

    public int hashCode() {
        int i = this.animatorType * 31;
        MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listener;
        return i + (animationsValueChangeListener != null ? animationsValueChangeListener.hashCode() : 0);
    }
}
