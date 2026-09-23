package com.h6ah4i.android.widget.advrecyclerview.animator;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.RemoveAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder;

/* JADX INFO: loaded from: classes6.dex */
public class SwipeDismissItemAnimator extends DraggableItemAnimator {
    public static final Interpolator MOVE_INTERPOLATOR = new AccelerateDecelerateInterpolator();

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.DraggableItemAnimator, com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator, com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    protected void onSetup() {
        setItemAddAnimationsManager(new RefactoredDefaultItemAnimator.DefaultItemAddAnimationManager(this));
        setItemRemoveAnimationManager(new SwipeDismissItemRemoveAnimationManager(this));
        setItemChangeAnimationsManager(new RefactoredDefaultItemAnimator.DefaultItemChangeAnimationManager(this));
        setItemMoveAnimationsManager(new RefactoredDefaultItemAnimator.DefaultItemMoveAnimationManager(this));
        setRemoveDuration(150L);
        setMoveDuration(150L);
    }

    protected static class SwipeDismissItemRemoveAnimationManager extends ItemRemoveAnimationManager {
        protected static final Interpolator DEFAULT_INTERPOLATOR = new AccelerateDecelerateInterpolator();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public void onAnimationCancel(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        }

        public SwipeDismissItemRemoveAnimationManager(BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public void onCreateAnimation(RemoveAnimationInfo removeAnimationInfo) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate;
            if (isSwipeDismissed(removeAnimationInfo.holder)) {
                viewPropertyAnimatorCompatAnimate = ViewCompat.animate(removeAnimationInfo.holder.itemView);
                viewPropertyAnimatorCompatAnimate.setDuration(getDuration());
            } else {
                viewPropertyAnimatorCompatAnimate = ViewCompat.animate(removeAnimationInfo.holder.itemView);
                viewPropertyAnimatorCompatAnimate.setDuration(getDuration());
                viewPropertyAnimatorCompatAnimate.setInterpolator(DEFAULT_INTERPOLATOR);
                viewPropertyAnimatorCompatAnimate.alpha(0.0f);
            }
            startActiveItemAnimation(removeAnimationInfo, removeAnimationInfo.holder, viewPropertyAnimatorCompatAnimate);
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected static boolean isSwipeDismissed(RecyclerView.ViewHolder viewHolder) {
            if (!(viewHolder instanceof SwipeableItemViewHolder)) {
                return false;
            }
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
            int swipeResult = swipeableItemViewHolder.getSwipeResult();
            return (swipeResult == 2 || swipeResult == 3 || swipeResult == 4 || swipeResult == 5) && swipeableItemViewHolder.getAfterSwipeReaction() == 1;
        }

        protected static boolean isSwipeDismissed(RemoveAnimationInfo removeAnimationInfo) {
            return removeAnimationInfo instanceof SwipeDismissRemoveAnimationInfo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public void onAnimationEndedSuccessfully(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (isSwipeDismissed(removeAnimationInfo)) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            } else {
                view.setAlpha(1.0f);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public void onAnimationEndedBeforeStarted(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (isSwipeDismissed(removeAnimationInfo)) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            } else {
                view.setAlpha(1.0f);
            }
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager
        public boolean addPendingAnimation(RecyclerView.ViewHolder viewHolder) {
            if (isSwipeDismissed(viewHolder)) {
                View view = viewHolder.itemView;
                int translationX = (int) (view.getTranslationX() + 0.5f);
                int translationY = (int) (view.getTranslationY() + 0.5f);
                endAnimation(viewHolder);
                view.setTranslationX(translationX);
                view.setTranslationY(translationY);
                enqueuePendingAnimationInfo(new SwipeDismissRemoveAnimationInfo(viewHolder));
                return true;
            }
            endAnimation(viewHolder);
            enqueuePendingAnimationInfo(new RemoveAnimationInfo(viewHolder));
            return true;
        }
    }

    protected static class SwipeDismissRemoveAnimationInfo extends RemoveAnimationInfo {
        public SwipeDismissRemoveAnimationInfo(RecyclerView.ViewHolder viewHolder) {
            super(viewHolder);
        }
    }
}
