package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.animator.SwipeDismissItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultActionDefault;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

/* JADX INFO: loaded from: classes6.dex */
public class RecyclerViewSwipeManager implements SwipeableItemConstants {
    private static final boolean LOCAL_LOGD = false;
    private static final boolean LOCAL_LOGV = false;
    private static final int MIN_DISTANCE_TOUCH_SLOP_MUL = 5;
    private static final int SLIDE_ITEM_IMMEDIATELY_SET_TRANSLATION_THRESHOLD_DP = 8;
    private static final String TAG = "ARVSwipeManager";
    private InternalHandler mHandler;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private ItemSlidingAnimator mItemSlideAnimator;
    private OnItemSwipeEventListener mItemSwipeEventListener;
    private int mLastTouchX;
    private int mLastTouchY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private RecyclerView mRecyclerView;
    private boolean mSwipeHorizontal;
    private int mSwipeThresholdDistance;
    private RecyclerView.ViewHolder mSwipingItem;
    private SwipingItemOperator mSwipingItemOperator;
    private int mSwipingItemReactionType;
    private int mTouchSlop;
    private int mTouchedItemOffsetX;
    private int mTouchedItemOffsetY;
    private SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> mWrapperAdapter;
    private long mReturnToDefaultPositionAnimationDuration = 300;
    private long mMoveToSpecifiedPositionAnimationDuration = 200;
    private long mMoveToOutsideWindowAnimationDuration = 200;
    private long mCheckingTouchSlop = -1;
    private int mSwipingItemPosition = -1;
    private long mSwipingItemId = -1;
    private final Rect mSwipingItemMargins = new Rect();
    private RecyclerView.OnItemTouchListener mInternalUseOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return RecyclerViewSwipeManager.this.onInterceptTouchEvent(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            RecyclerViewSwipeManager.this.onTouchEvent(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            RecyclerViewSwipeManager.this.onRequestDisallowInterceptTouchEvent(z);
        }
    };
    private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
    private int mLongPressTimeout = ViewConfiguration.getLongPressTimeout();

    public interface OnItemSwipeEventListener {
        void onItemSwipeFinished(int i, int i2, int i3);

        void onItemSwipeStarted(int i);
    }

    private static int determineBackgroundType(float f, boolean z) {
        if (z) {
            return f < 0.0f ? 1 : 3;
        }
        return f < 0.0f ? 2 : 4;
    }

    private static boolean isSpecialSwipeAmountValue(float f) {
        return f == -65536.0f || f == 65536.0f || f == -65537.0f || f == 65537.0f;
    }

    private static int resultCodeToSlideDirection(int i) {
        if (i == 3) {
            return 1;
        }
        if (i != 4) {
            return i != 5 ? 0 : 3;
        }
        return 2;
    }

    public RecyclerView.Adapter createWrappedAdapter(RecyclerView.Adapter adapter) {
        if (!adapter.hasStableIds()) {
            throw new IllegalArgumentException("The passed adapter does not support stable IDs");
        }
        if (this.mWrapperAdapter != null) {
            throw new IllegalStateException("already have a wrapped adapter");
        }
        SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> swipeableItemWrapperAdapter = new SwipeableItemWrapperAdapter<>(this, adapter);
        this.mWrapperAdapter = swipeableItemWrapperAdapter;
        return swipeableItemWrapperAdapter;
    }

    public boolean isReleased() {
        return this.mInternalUseOnItemTouchListener == null;
    }

    public void attachRecyclerView(RecyclerView recyclerView) {
        if (isReleased()) {
            throw new IllegalStateException("Accessing released object");
        }
        if (this.mRecyclerView != null) {
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        int orientation = CustomRecyclerViewUtils.getOrientation(recyclerView);
        if (orientation == -1) {
            throw new IllegalStateException("failed to determine layout orientation");
        }
        this.mRecyclerView = recyclerView;
        recyclerView.addOnItemTouchListener(this.mInternalUseOnItemTouchListener);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(recyclerView.getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mSwipeThresholdDistance = this.mTouchSlop * 5;
        ItemSlidingAnimator itemSlidingAnimator = new ItemSlidingAnimator(this.mWrapperAdapter);
        this.mItemSlideAnimator = itemSlidingAnimator;
        itemSlidingAnimator.setImmediatelySetTranslationThreshold((int) ((recyclerView.getResources().getDisplayMetrics().density * 8.0f) + 0.5f));
        this.mSwipeHorizontal = orientation == 1;
        this.mHandler = new InternalHandler(this);
    }

    public void release() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        cancelSwipe(true);
        InternalHandler internalHandler = this.mHandler;
        if (internalHandler != null) {
            internalHandler.release();
            this.mHandler = null;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (onItemTouchListener = this.mInternalUseOnItemTouchListener) != null) {
            recyclerView.removeOnItemTouchListener(onItemTouchListener);
        }
        this.mInternalUseOnItemTouchListener = null;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        ItemSlidingAnimator itemSlidingAnimator = this.mItemSlideAnimator;
        if (itemSlidingAnimator != null) {
            itemSlidingAnimator.endAnimations();
            this.mItemSlideAnimator = null;
        }
        this.mWrapperAdapter = null;
        this.mRecyclerView = null;
    }

    public boolean isSwiping() {
        return (this.mSwipingItem == null || this.mHandler.isCancelSwipeRequested()) ? false : true;
    }

    public void setLongPressTimeout(int i) {
        this.mLongPressTimeout = i;
    }

    public void setSwipeThresholdDistance(int i) {
        this.mSwipeThresholdDistance = Math.max(i, this.mTouchSlop);
    }

    public int getSwipeThresholdDistance() {
        return this.mSwipeThresholdDistance;
    }

    boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (isSwiping()) {
                return false;
            }
            handleActionDown(recyclerView, motionEvent);
            return false;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (!isSwiping()) {
                    return handleActionMoveWhileNotSwiping(recyclerView, motionEvent);
                }
                handleActionMoveWhileSwiping(motionEvent);
                return true;
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        return handleActionUpOrCancel(motionEvent, true);
    }

    void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (isSwiping()) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    handleActionMoveWhileSwiping(motionEvent);
                    return;
                } else if (actionMasked != 3) {
                    return;
                }
            }
            handleActionUpOrCancel(motionEvent, true);
        }
    }

    void onRequestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            cancelSwipe(true);
        }
    }

    private boolean handleActionDown(RecyclerView recyclerView, MotionEvent motionEvent) {
        int wrappedItemPosition;
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithTranslation(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!(viewHolderFindChildViewHolderUnderWithTranslation instanceof SwipeableItemViewHolder) || (wrappedItemPosition = getWrappedItemPosition(viewHolderFindChildViewHolderUnderWithTranslation)) < 0 || wrappedItemPosition >= this.mWrapperAdapter.getItemCount()) {
            return false;
        }
        if (ItemIdComposer.extractWrappedIdPart(viewHolderFindChildViewHolderUnderWithTranslation.getItemId()) != ItemIdComposer.extractWrappedIdPart(this.mWrapperAdapter.getItemId(wrappedItemPosition))) {
            return false;
        }
        int x = (int) (motionEvent.getX() + 0.5f);
        int y = (int) (motionEvent.getY() + 0.5f);
        View view = viewHolderFindChildViewHolderUnderWithTranslation.itemView;
        int swipeReactionType = this.mWrapperAdapter.getSwipeReactionType(viewHolderFindChildViewHolderUnderWithTranslation, wrappedItemPosition, x - (view.getLeft() + ((int) (view.getTranslationX() + 0.5f))), y - (view.getTop() + ((int) (view.getTranslationY() + 0.5f))));
        if (swipeReactionType == 0) {
            return false;
        }
        this.mInitialTouchX = x;
        this.mInitialTouchY = y;
        this.mCheckingTouchSlop = viewHolderFindChildViewHolderUnderWithTranslation.getItemId();
        this.mSwipingItemReactionType = swipeReactionType;
        if ((16777216 & swipeReactionType) == 0) {
            return true;
        }
        this.mHandler.startLongPressDetection(motionEvent, this.mLongPressTimeout);
        return true;
    }

    private boolean handleActionUpOrCancel(MotionEvent motionEvent, boolean z) {
        int actionMasked;
        if (motionEvent != null) {
            actionMasked = motionEvent.getActionMasked();
            this.mLastTouchX = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchY = (int) (motionEvent.getY() + 0.5f);
        } else {
            actionMasked = 3;
        }
        if (!isSwiping()) {
            handleActionUpOrCancelWhileNotSwiping();
            return false;
        }
        if (!z) {
            return true;
        }
        handleActionUpOrCancelWhileSwiping(actionMasked);
        return true;
    }

    private void handleActionUpOrCancelWhileNotSwiping() {
        InternalHandler internalHandler = this.mHandler;
        if (internalHandler != null) {
            internalHandler.cancelLongPressDetection();
        }
        this.mCheckingTouchSlop = -1L;
        this.mSwipingItemReactionType = 0;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00c5  */
    private void handleActionUpOrCancelWhileSwiping(int i) {
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5 = 1;
        if (i == 1) {
            float f = this.mMinFlingVelocity;
            boolean z2 = this.mSwipeHorizontal;
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) this.mSwipingItem;
            View swipeableContainerView = SwipeableViewHolderUtils.getSwipeableContainerView(swipeableItemViewHolder);
            int width = z2 ? swipeableContainerView.getWidth() : swipeableContainerView.getHeight();
            if (z2) {
                i2 = this.mLastTouchX;
                i3 = this.mInitialTouchX;
            } else {
                i2 = this.mLastTouchY;
                i3 = this.mInitialTouchY;
            }
            float f2 = i2 - i3;
            float fAbs = Math.abs(f2);
            int i6 = this.mSwipingItemReactionType;
            boolean zCanSwipeLeft = z2 ? SwipeReactionUtils.canSwipeLeft(i6) : SwipeReactionUtils.canSwipeUp(i6);
            int i7 = this.mSwipingItemReactionType;
            boolean zCanSwipeRight = z2 ? SwipeReactionUtils.canSwipeRight(i7) : SwipeReactionUtils.canSwipeDown(i7);
            boolean zIsProportionalSwipeAmountModeEnabled = swipeableItemViewHolder.isProportionalSwipeAmountModeEnabled();
            float maxLeftSwipeAmount = z2 ? swipeableItemViewHolder.getMaxLeftSwipeAmount() : swipeableItemViewHolder.getMaxUpSwipeAmount();
            float maxRightSwipeAmount = z2 ? swipeableItemViewHolder.getMaxRightSwipeAmount() : swipeableItemViewHolder.getMaxDownSwipeAmount();
            boolean z3 = false;
            float fAdaptAmount = adaptAmount(swipeableItemViewHolder, z2, maxLeftSwipeAmount, zIsProportionalSwipeAmountModeEnabled, false);
            float fAdaptAmount2 = adaptAmount(swipeableItemViewHolder, z2, maxRightSwipeAmount, zIsProportionalSwipeAmountModeEnabled, false);
            if (isSpecialSwipeAmountValue(fAdaptAmount)) {
                fAdaptAmount = -width;
            }
            if (isSpecialSwipeAmountValue(fAdaptAmount2)) {
                fAdaptAmount2 = width;
            }
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            float xVelocity = z2 ? velocityTracker.getXVelocity() : velocityTracker.getYVelocity();
            float fAbs2 = Math.abs(xVelocity);
            if (fAbs <= this.mSwipeThresholdDistance) {
                z = false;
            } else if (fAbs2 >= f) {
                if (f2 * xVelocity >= 0.0f) {
                    if (xVelocity > 0.0f) {
                        z3 = true;
                    }
                    z = z3;
                    z3 = true;
                } else {
                    z = false;
                }
            } else if (f2 < 0.0f && f2 <= fAdaptAmount * 0.8f) {
                z = z3;
                z3 = true;
            } else if (f2 <= 0.0f || f2 < fAdaptAmount2 * 0.8f) {
                z = false;
            } else {
                z = true;
                z3 = true;
            }
            if (z3) {
                if (!z && zCanSwipeLeft) {
                    i4 = z2 ? 2 : 3;
                } else if (z && zCanSwipeRight) {
                    i4 = z2 ? 4 : 5;
                }
                i5 = i4;
            }
        }
        finishSwiping(i5);
    }

    private boolean handleActionMoveWhileNotSwiping(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mCheckingTouchSlop == -1) {
            return false;
        }
        int x = ((int) (motionEvent.getX() + 0.5f)) - this.mInitialTouchX;
        int y = ((int) (motionEvent.getY() + 0.5f)) - this.mInitialTouchY;
        if (this.mSwipeHorizontal) {
            y = x;
            x = y;
        }
        if (Math.abs(x) > this.mTouchSlop) {
            this.mCheckingTouchSlop = -1L;
            return false;
        }
        if (Math.abs(y) <= this.mTouchSlop) {
            return false;
        }
        if (!this.mSwipeHorizontal ? !(y >= 0 ? (this.mSwipingItemReactionType & 2097152) == 0 : (this.mSwipingItemReactionType & 512) == 0) : !(y >= 0 ? (this.mSwipingItemReactionType & 32768) == 0 : (this.mSwipingItemReactionType & 8) == 0)) {
            this.mCheckingTouchSlop = -1L;
            return false;
        }
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithTranslation(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (viewHolderFindChildViewHolderUnderWithTranslation == null || viewHolderFindChildViewHolderUnderWithTranslation.getItemId() != this.mCheckingTouchSlop) {
            this.mCheckingTouchSlop = -1L;
            return false;
        }
        return checkConditionAndStartSwiping(motionEvent, viewHolderFindChildViewHolderUnderWithTranslation);
    }

    private void handleActionMoveWhileSwiping(MotionEvent motionEvent) {
        this.mLastTouchX = (int) (motionEvent.getX() + 0.5f);
        this.mLastTouchY = (int) (motionEvent.getY() + 0.5f);
        this.mVelocityTracker.addMovement(motionEvent);
        int i = this.mLastTouchX - this.mTouchedItemOffsetX;
        int i2 = this.mLastTouchY - this.mTouchedItemOffsetY;
        this.mSwipingItemOperator.update(getSwipingItemPosition(), i, i2);
    }

    private boolean checkConditionAndStartSwiping(MotionEvent motionEvent, RecyclerView.ViewHolder viewHolder) {
        int wrappedItemPosition = getWrappedItemPosition(viewHolder);
        if (wrappedItemPosition == -1) {
            return false;
        }
        startSwiping(motionEvent, viewHolder, wrappedItemPosition);
        return true;
    }

    private void startSwiping(MotionEvent motionEvent, RecyclerView.ViewHolder viewHolder, int i) {
        this.mHandler.cancelLongPressDetection();
        this.mSwipingItem = viewHolder;
        this.mSwipingItemPosition = i;
        this.mSwipingItemId = this.mWrapperAdapter.getItemId(i);
        this.mLastTouchX = (int) (motionEvent.getX() + 0.5f);
        int y = (int) (motionEvent.getY() + 0.5f);
        this.mLastTouchY = y;
        this.mTouchedItemOffsetX = this.mLastTouchX;
        this.mTouchedItemOffsetY = y;
        this.mCheckingTouchSlop = -1L;
        CustomRecyclerViewUtils.getLayoutMargins(viewHolder.itemView, this.mSwipingItemMargins);
        SwipingItemOperator swipingItemOperator = new SwipingItemOperator(this, this.mSwipingItem, this.mSwipingItemReactionType, this.mSwipeHorizontal);
        this.mSwipingItemOperator = swipingItemOperator;
        swipingItemOperator.start();
        this.mVelocityTracker.clear();
        this.mVelocityTracker.addMovement(motionEvent);
        this.mRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
        OnItemSwipeEventListener onItemSwipeEventListener = this.mItemSwipeEventListener;
        if (onItemSwipeEventListener != null) {
            onItemSwipeEventListener.onItemSwipeStarted(i);
        }
        this.mWrapperAdapter.onSwipeItemStarted(this, viewHolder, i, this.mSwipingItemId);
    }

    private void finishSwiping(int i) {
        RecyclerView.ViewHolder viewHolder = this.mSwipingItem;
        if (viewHolder == null) {
            return;
        }
        this.mHandler.removeDeferredCancelSwipeRequest();
        this.mHandler.cancelLongPressDetection();
        RecyclerView recyclerView = this.mRecyclerView;
        boolean zFinishSwipeSlideToDefaultPosition = false;
        if (recyclerView != null && recyclerView.getParent() != null) {
            this.mRecyclerView.getParent().requestDisallowInterceptTouchEvent(false);
        }
        int swipingItemPosition = getSwipingItemPosition();
        this.mVelocityTracker.clear();
        this.mSwipingItem = null;
        this.mSwipingItemPosition = -1;
        this.mSwipingItemId = -1L;
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
        this.mInitialTouchX = 0;
        this.mTouchedItemOffsetX = 0;
        this.mTouchedItemOffsetY = 0;
        this.mCheckingTouchSlop = -1L;
        this.mSwipingItemReactionType = 0;
        SwipingItemOperator swipingItemOperator = this.mSwipingItemOperator;
        if (swipingItemOperator != null) {
            swipingItemOperator.finish();
            this.mSwipingItemOperator = null;
        }
        int iResultCodeToSlideDirection = resultCodeToSlideDirection(i);
        SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> swipeableItemWrapperAdapter = this.mWrapperAdapter;
        SwipeResultAction swipeResultActionOnSwipeItemFinished = swipeableItemWrapperAdapter != null ? swipeableItemWrapperAdapter.onSwipeItemFinished(viewHolder, swipingItemPosition, i) : null;
        if (swipeResultActionOnSwipeItemFinished == null) {
            swipeResultActionOnSwipeItemFinished = new SwipeResultActionDefault();
        }
        SwipeResultAction swipeResultAction = swipeResultActionOnSwipeItemFinished;
        int resultActionType = swipeResultAction.getResultActionType();
        verifyAfterReaction(i, resultActionType);
        if (resultActionType == 0) {
            zFinishSwipeSlideToDefaultPosition = this.mItemSlideAnimator.finishSwipeSlideToDefaultPosition(viewHolder, this.mSwipeHorizontal, true, this.mReturnToDefaultPositionAnimationDuration, swipingItemPosition, swipeResultAction);
        } else if (resultActionType == 1) {
            RecyclerView.ItemAnimator itemAnimator = this.mRecyclerView.getItemAnimator();
            long removeDuration = itemAnimator != null ? itemAnimator.getRemoveDuration() : 0L;
            RemovingItemDecorator removingItemDecorator = new RemovingItemDecorator(this.mRecyclerView, viewHolder, i, removeDuration, itemAnimator != null ? itemAnimator.getMoveDuration() : 0L);
            removingItemDecorator.setMoveAnimationInterpolator(SwipeDismissItemAnimator.MOVE_INTERPOLATOR);
            removingItemDecorator.start();
            zFinishSwipeSlideToDefaultPosition = this.mItemSlideAnimator.finishSwipeSlideToOutsideOfWindow(viewHolder, iResultCodeToSlideDirection, true, removeDuration, swipingItemPosition, swipeResultAction);
        } else if (resultActionType == 2) {
            zFinishSwipeSlideToDefaultPosition = this.mItemSlideAnimator.finishSwipeSlideToOutsideOfWindow(viewHolder, iResultCodeToSlideDirection, true, this.mMoveToOutsideWindowAnimationDuration, swipingItemPosition, swipeResultAction);
        } else if (resultActionType != 3) {
            throw new IllegalStateException("Unknown after reaction type: " + resultActionType);
        }
        boolean z = zFinishSwipeSlideToDefaultPosition;
        SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> swipeableItemWrapperAdapter2 = this.mWrapperAdapter;
        if (swipeableItemWrapperAdapter2 != null) {
            swipeableItemWrapperAdapter2.onSwipeItemFinished2(viewHolder, swipingItemPosition, i, resultActionType, swipeResultAction);
        }
        OnItemSwipeEventListener onItemSwipeEventListener = this.mItemSwipeEventListener;
        if (onItemSwipeEventListener != null) {
            onItemSwipeEventListener.onItemSwipeFinished(swipingItemPosition, i, resultActionType);
        }
        if (z) {
            return;
        }
        swipeResultAction.slideAnimationEnd();
    }

    private static void verifyAfterReaction(int i, int i2) {
        if ((i2 != 2 && i2 != 1) || i == 2 || i == 3 || i == 4 || i == 5) {
            return;
        }
        throw new IllegalStateException("Unexpected after reaction has been requested: result = " + i + ", afterReaction = " + i2);
    }

    static int getItemPosition(RecyclerView.Adapter adapter, long j, int i) {
        if (adapter == null) {
            return -1;
        }
        int itemCount = adapter.getItemCount();
        if (i >= 0 && i < itemCount && adapter.getItemId(i) == j) {
            return i;
        }
        for (int i2 = 0; i2 < itemCount; i2++) {
            if (adapter.getItemId(i2) == j) {
                return i2;
            }
        }
        return -1;
    }

    public void cancelSwipe() {
        cancelSwipe(false);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0028  */
    /* JADX WARN: Code duplicated, block: B:20:0x002c A[RETURN] */
    public boolean performFakeSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = 0;
        if (!(viewHolder instanceof SwipeableItemViewHolder) || isSwiping()) {
            return false;
        }
        if (i != 1) {
            if (i == 2) {
                if (!this.mSwipeHorizontal) {
                    return false;
                }
            } else {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return false;
                        }
                    } else if (!this.mSwipeHorizontal) {
                        return false;
                    }
                }
                if (this.mSwipeHorizontal) {
                    return false;
                }
            }
        }
        int wrappedItemPosition = getWrappedItemPosition(viewHolder);
        if (wrappedItemPosition == -1) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
        startSwiping(motionEventObtain, viewHolder, wrappedItemPosition);
        motionEventObtain.recycle();
        if (i == 2 || i == 3) {
            i2 = -1;
        } else if (i == 4 || i == 5) {
            i2 = 1;
        }
        applySlideItem(viewHolder, wrappedItemPosition, 0.0f, i2, false, this.mSwipeHorizontal, false, true);
        finishSwiping(i);
        return true;
    }

    void cancelSwipe(boolean z) {
        handleActionUpOrCancel(null, false);
        if (z) {
            finishSwiping(1);
        } else if (isSwiping()) {
            this.mHandler.requestDeferredCancelSwipe();
        }
    }

    boolean isAnimationRunning(RecyclerView.ViewHolder viewHolder) {
        ItemSlidingAnimator itemSlidingAnimator = this.mItemSlideAnimator;
        return itemSlidingAnimator != null && itemSlidingAnimator.isRunning(viewHolder);
    }

    private void slideItem(RecyclerView.ViewHolder viewHolder, float f, boolean z, boolean z2, boolean z3) {
        if (f == -65536.0f) {
            this.mItemSlideAnimator.slideToOutsideOfWindow(viewHolder, 0, z3, this.mMoveToOutsideWindowAnimationDuration);
            return;
        }
        if (f == -65537.0f) {
            this.mItemSlideAnimator.slideToOutsideOfWindow(viewHolder, 1, z3, this.mMoveToOutsideWindowAnimationDuration);
            return;
        }
        if (f == 65536.0f) {
            this.mItemSlideAnimator.slideToOutsideOfWindow(viewHolder, 2, z3, this.mMoveToOutsideWindowAnimationDuration);
            return;
        }
        if (f == 65537.0f) {
            this.mItemSlideAnimator.slideToOutsideOfWindow(viewHolder, 3, z3, this.mMoveToOutsideWindowAnimationDuration);
        } else if (f == 0.0f) {
            this.mItemSlideAnimator.slideToDefaultPosition(viewHolder, z2, z3, this.mReturnToDefaultPositionAnimationDuration);
        } else {
            this.mItemSlideAnimator.slideToSpecifiedPosition(viewHolder, f, z, z2, z3, this.mMoveToSpecifiedPositionAnimationDuration);
        }
    }

    private int getWrappedItemPosition(RecyclerView.ViewHolder viewHolder) {
        return WrapperAdapterUtils.unwrapPosition(this.mRecyclerView.getAdapter(), this.mWrapperAdapter, CustomRecyclerViewUtils.getSynchronizedPosition(viewHolder));
    }

    public long getReturnToDefaultPositionAnimationDuration() {
        return this.mReturnToDefaultPositionAnimationDuration;
    }

    public void setReturnToDefaultPositionAnimationDuration(long j) {
        this.mReturnToDefaultPositionAnimationDuration = j;
    }

    public long getMoveToSpecifiedPositionAnimationDuration() {
        return this.mMoveToSpecifiedPositionAnimationDuration;
    }

    public void setMoveToSpecifiedPositionAnimationDuration(long j) {
        this.mMoveToSpecifiedPositionAnimationDuration = j;
    }

    public long getMoveToOutsideWindowAnimationDuration() {
        return this.mMoveToOutsideWindowAnimationDuration;
    }

    public void setMoveToOutsideWindowAnimationDuration(long j) {
        this.mMoveToOutsideWindowAnimationDuration = j;
    }

    public OnItemSwipeEventListener getOnItemSwipeEventListener() {
        return this.mItemSwipeEventListener;
    }

    public void setOnItemSwipeEventListener(OnItemSwipeEventListener onItemSwipeEventListener) {
        this.mItemSwipeEventListener = onItemSwipeEventListener;
    }

    boolean swipeHorizontal() {
        return this.mSwipeHorizontal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void applySlideItem(RecyclerView.ViewHolder viewHolder, int i, float f, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
        int iDetermineBackgroundType;
        float fMin;
        SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
        if (SwipeableViewHolderUtils.getSwipeableContainerView(swipeableItemViewHolder) == null) {
            return;
        }
        if (f2 == 0.0f) {
            iDetermineBackgroundType = f == 0.0f ? 0 : determineBackgroundType(f, z2);
        } else {
            iDetermineBackgroundType = determineBackgroundType(f2, z2);
        }
        int i2 = iDetermineBackgroundType;
        if (f2 != 0.0f) {
            boolean zIsProportionalSwipeAmountModeEnabled = swipeableItemViewHolder.isProportionalSwipeAmountModeEnabled();
            float maxLeftSwipeAmount = z2 ? swipeableItemViewHolder.getMaxLeftSwipeAmount() : swipeableItemViewHolder.getMaxUpSwipeAmount();
            float maxRightSwipeAmount = z2 ? swipeableItemViewHolder.getMaxRightSwipeAmount() : swipeableItemViewHolder.getMaxDownSwipeAmount();
            fMin = Math.min(Math.max(f2, adaptAmount(swipeableItemViewHolder, z2, maxLeftSwipeAmount, zIsProportionalSwipeAmountModeEnabled, z)), adaptAmount(swipeableItemViewHolder, z2, maxRightSwipeAmount, zIsProportionalSwipeAmountModeEnabled, z));
        } else {
            fMin = f2;
        }
        slideItem(viewHolder, fMin, z, z2, z3);
        this.mWrapperAdapter.onUpdateSlideAmount(viewHolder, i, f2, z, z2, z4, i2);
    }

    void cancelPendingAnimations(RecyclerView.ViewHolder viewHolder) {
        ItemSlidingAnimator itemSlidingAnimator = this.mItemSlideAnimator;
        if (itemSlidingAnimator != null) {
            itemSlidingAnimator.endAnimation(viewHolder);
        }
    }

    int getSwipeContainerViewTranslationX(RecyclerView.ViewHolder viewHolder) {
        return this.mItemSlideAnimator.getSwipeContainerViewTranslationX(viewHolder);
    }

    int getSwipeContainerViewTranslationY(RecyclerView.ViewHolder viewHolder) {
        return this.mItemSlideAnimator.getSwipeContainerViewTranslationY(viewHolder);
    }

    void handleOnLongPress(MotionEvent motionEvent) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForItemId = this.mRecyclerView.findViewHolderForItemId(this.mCheckingTouchSlop);
        if (viewHolderFindViewHolderForItemId != null) {
            checkConditionAndStartSwiping(motionEvent, viewHolderFindViewHolderForItemId);
        }
    }

    int getSwipingItemPosition() {
        return this.mSwipingItemPosition;
    }

    int syncSwipingItemPosition() {
        return syncSwipingItemPosition(this.mSwipingItemPosition);
    }

    int syncSwipingItemPosition(int i) {
        int itemPosition = getItemPosition(this.mWrapperAdapter, this.mSwipingItemId, i);
        this.mSwipingItemPosition = itemPosition;
        return itemPosition;
    }

    static float adaptAmount(SwipeableItemViewHolder swipeableItemViewHolder, boolean z, float f, boolean z2, boolean z3) {
        if (!(z2 ^ z3)) {
            return f;
        }
        if (f == 0.0f || isSpecialSwipeAmountValue(f)) {
            return f;
        }
        View swipeableContainerView = SwipeableViewHolderUtils.getSwipeableContainerView(swipeableItemViewHolder);
        float width = z ? swipeableContainerView.getWidth() : swipeableContainerView.getHeight();
        if (z3) {
            width = width != 0.0f ? 1.0f / width : 0.0f;
        }
        return f * width;
    }

    private static class InternalHandler extends Handler {
        private static final int MSG_DEFERRED_CANCEL_SWIPE = 2;
        private static final int MSG_LONGPRESS = 1;
        private MotionEvent mDownMotionEvent;
        private RecyclerViewSwipeManager mHolder;

        public InternalHandler(RecyclerViewSwipeManager recyclerViewSwipeManager) {
            this.mHolder = recyclerViewSwipeManager;
        }

        public void release() {
            removeCallbacksAndMessages(null);
            this.mHolder = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.mHolder.handleOnLongPress(this.mDownMotionEvent);
            } else {
                if (i != 2) {
                    return;
                }
                this.mHolder.cancelSwipe(true);
            }
        }

        public void startLongPressDetection(MotionEvent motionEvent, int i) {
            cancelLongPressDetection();
            this.mDownMotionEvent = MotionEvent.obtain(motionEvent);
            sendEmptyMessageAtTime(1, motionEvent.getDownTime() + ((long) i));
        }

        public void cancelLongPressDetection() {
            removeMessages(1);
            MotionEvent motionEvent = this.mDownMotionEvent;
            if (motionEvent != null) {
                motionEvent.recycle();
                this.mDownMotionEvent = null;
            }
        }

        public void removeDeferredCancelSwipeRequest() {
            removeMessages(2);
        }

        public void requestDeferredCancelSwipe() {
            if (isCancelSwipeRequested()) {
                return;
            }
            sendEmptyMessage(2);
        }

        public boolean isCancelSwipeRequested() {
            return hasMessages(2);
        }
    }
}
