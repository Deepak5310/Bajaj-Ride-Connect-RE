package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
abstract class BaseDraggableItemDecorator extends RecyclerView.ItemDecoration {
    private static final int RETURN_TO_DEFAULT_POS_ANIMATE_THRESHOLD_DP = 2;
    private static final int RETURN_TO_DEFAULT_POS_ANIMATE_THRESHOLD_MSEC = 20;
    protected RecyclerView.ViewHolder mDraggingItemViewHolder;
    protected final RecyclerView mRecyclerView;
    private final int mReturnToDefaultPositionAnimateThreshold;
    private int mReturnToDefaultPositionDuration = 200;
    private Interpolator mReturnToDefaultPositionInterpolator;

    public BaseDraggableItemDecorator(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        this.mRecyclerView = recyclerView;
        this.mDraggingItemViewHolder = viewHolder;
        this.mReturnToDefaultPositionAnimateThreshold = (int) ((recyclerView.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }

    public void setReturnToDefaultPositionAnimationDuration(int i) {
        this.mReturnToDefaultPositionDuration = i;
    }

    public void setReturnToDefaultPositionAnimationInterpolator(Interpolator interpolator) {
        this.mReturnToDefaultPositionInterpolator = interpolator;
    }

    protected void moveToDefaultPosition(View view, float f, float f2, float f3, float f4, boolean z) {
        final float translationZ = ViewCompat.getTranslationZ(view);
        int iDetermineMoveToDefaultPositionAnimationDurationFactor = (int) (this.mReturnToDefaultPositionDuration * determineMoveToDefaultPositionAnimationDurationFactor(view, f, f2, f3, f4));
        if (z && iDetermineMoveToDefaultPositionAnimationDurationFactor > 20) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(view);
            view.setScaleX(f);
            view.setScaleY(f2);
            view.setRotation(f3);
            view.setAlpha(f4);
            ViewCompat.setTranslationZ(view, translationZ + 1.0f);
            viewPropertyAnimatorCompatAnimate.cancel();
            viewPropertyAnimatorCompatAnimate.setDuration(iDetermineMoveToDefaultPositionAnimationDurationFactor);
            viewPropertyAnimatorCompatAnimate.setInterpolator(this.mReturnToDefaultPositionInterpolator);
            viewPropertyAnimatorCompatAnimate.translationX(0.0f);
            viewPropertyAnimatorCompatAnimate.translationY(0.0f);
            viewPropertyAnimatorCompatAnimate.translationZ(translationZ);
            viewPropertyAnimatorCompatAnimate.alpha(1.0f);
            viewPropertyAnimatorCompatAnimate.rotation(0.0f);
            viewPropertyAnimatorCompatAnimate.scaleX(1.0f);
            viewPropertyAnimatorCompatAnimate.scaleY(1.0f);
            viewPropertyAnimatorCompatAnimate.setListener(new ViewPropertyAnimatorListener() { // from class: com.h6ah4i.android.widget.advrecyclerview.draggable.BaseDraggableItemDecorator.1
                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationCancel(View view2) {
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view2) {
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view2) {
                    ViewCompat.animate(view2).setListener(null);
                    BaseDraggableItemDecorator.resetDraggingItemViewEffects(view2, translationZ);
                    if (view2.getParent() instanceof RecyclerView) {
                        ViewCompat.postInvalidateOnAnimation((RecyclerView) view2.getParent());
                    }
                }
            });
            viewPropertyAnimatorCompatAnimate.start();
            return;
        }
        resetDraggingItemViewEffects(view, translationZ);
    }

    protected float determineMoveToDefaultPositionAnimationDurationFactor(View view, float f, float f2, float f3, float f4) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int width = view.getWidth() / 2;
        int height = view.getHeight() / 2;
        float fAbs = width > 0 ? Math.abs(translationX / width) : 0.0f;
        float fAbs2 = height > 0 ? Math.abs(translationY / height) : 0.0f;
        return Math.min(Math.max(Math.max(Math.max(Math.max(Math.max(0.0f, fAbs), fAbs2), Math.abs(Math.max(f, f2) - 1.0f)), Math.abs(f3 * 0.033333335f)), Math.abs(f4 - 1.0f)), 1.0f);
    }

    protected static void resetDraggingItemViewEffects(View view, float f) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        ViewCompat.setTranslationZ(view, f);
        view.setAlpha(1.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    protected static void setItemTranslation(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimation(viewHolder);
        }
        viewHolder.itemView.setTranslationX(f);
        viewHolder.itemView.setTranslationY(f2);
    }
}
