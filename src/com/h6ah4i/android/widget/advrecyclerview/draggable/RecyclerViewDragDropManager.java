package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPath;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class RecyclerViewDragDropManager implements DraggableItemConstants {
    public static final int ITEM_MOVE_MODE_DEFAULT = 0;
    public static final int ITEM_MOVE_MODE_SWAP = 1;
    private static final boolean LOCAL_LOGD = false;
    private static final boolean LOCAL_LOGI = true;
    private static final boolean LOCAL_LOGV = false;
    private static final float SCROLL_AMOUNT_COEFF = 25.0f;
    private static final int SCROLL_DIR_DOWN = 2;
    private static final int SCROLL_DIR_LEFT = 4;
    private static final int SCROLL_DIR_NONE = 0;
    private static final int SCROLL_DIR_RIGHT = 8;
    private static final int SCROLL_DIR_UP = 1;
    private static final float SCROLL_THRESHOLD = 0.3f;
    private static final float SCROLL_TOUCH_SLOP_MULTIPLY = 1.5f;
    private static final String TAG = "ARVDragDropManager";
    private int mActualScrollByXAmount;
    private int mActualScrollByYAmount;
    private boolean mCanDragH;
    private boolean mCanDragV;
    private boolean mCheckCanDrop;
    private Object mComposedAdapterTag;
    private float mDisplayDensity;
    private int mDragMaxTouchX;
    private int mDragMaxTouchY;
    private int mDragMinTouchX;
    private int mDragMinTouchY;
    private int mDragScrollDistanceX;
    private int mDragScrollDistanceY;
    private int mDragStartTouchX;
    private int mDragStartTouchY;
    private ItemDraggableRange mDraggableRange;
    private DraggingItemDecorator mDraggingItemDecorator;
    private DraggingItemInfo mDraggingItemInfo;
    RecyclerView.ViewHolder mDraggingItemViewHolder;
    private BaseEdgeEffectDecorator mEdgeEffectDecorator;
    private InternalHandler mHandler;
    private boolean mInScrollByMethod;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mInitiateOnLongPress;
    private boolean mInitiateOnTouch;
    private OnItemDragEventListener mItemDragEventListener;
    private int mLastTouchX;
    private int mLastTouchY;
    private NestedScrollView mNestedScrollView;
    private int mNestedScrollViewScrollX;
    private int mNestedScrollViewScrollY;
    private int mOrigOverScrollMode;
    private RecyclerView mRecyclerView;
    private ItemDraggableRange mRootDraggableRange;
    private int mScrollTouchSlop;
    private NinePatchDrawable mShadowDrawable;
    private SwapTargetItemOperator mSwapTargetItemOperator;
    private int mTouchSlop;
    private DraggableItemWrapperAdapter mWrapperAdapter;
    public static final Interpolator DEFAULT_SWAP_TARGET_TRANSITION_INTERPOLATOR = new BasicSwapTargetTranslationInterpolator();
    public static final Interpolator DEFAULT_ITEM_SETTLE_BACK_INTO_PLACE_ANIMATION_INTERPOLATOR = new DecelerateInterpolator();
    private Interpolator mSwapTargetTranslationInterpolator = DEFAULT_SWAP_TARGET_TRANSITION_INTERPOLATOR;
    private long mInitialTouchItemId = -1;
    private boolean mInitiateOnMove = true;
    private final Rect mTmpRect1 = new Rect();
    private int mItemSettleBackIntoPlaceAnimationDuration = 200;
    private Interpolator mItemSettleBackIntoPlaceAnimationInterpolator = DEFAULT_ITEM_SETTLE_BACK_INTO_PLACE_ANIMATION_INTERPOLATOR;
    private int mItemMoveMode = 0;
    private DraggingItemEffectsInfo mDraggingItemEffectsInfo = new DraggingItemEffectsInfo();
    private int mScrollDirMask = 0;
    private float mDragEdgeScrollSpeed = 1.0f;
    private int mCurrentItemMoveMode = 0;
    private SwapTarget mTempSwapTarget = new SwapTarget();
    private FindSwapTargetContext mFindSwapTargetContext = new FindSwapTargetContext();
    private final Runnable mCheckItemSwappingRunnable = new Runnable() { // from class: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.3
        @Override // java.lang.Runnable
        public void run() {
            if (RecyclerViewDragDropManager.this.mDraggingItemViewHolder != null) {
                RecyclerViewDragDropManager recyclerViewDragDropManager = RecyclerViewDragDropManager.this;
                recyclerViewDragDropManager.checkItemSwapping(recyclerViewDragDropManager.getRecyclerView());
            }
        }
    };
    private RecyclerView.OnItemTouchListener mInternalUseOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return RecyclerViewDragDropManager.this.onInterceptTouchEvent(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            RecyclerViewDragDropManager.this.onTouchEvent(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            RecyclerViewDragDropManager.this.onRequestDisallowInterceptTouchEvent(z);
        }
    };
    private RecyclerView.OnScrollListener mInternalUseOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            RecyclerViewDragDropManager.this.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            RecyclerViewDragDropManager.this.onScrolled(recyclerView, i, i2);
        }
    };
    private ScrollOnDraggingProcessRunnable mScrollOnDraggingProcess = new ScrollOnDraggingProcessRunnable(this);
    private int mLongPressTimeout = ViewConfiguration.getLongPressTimeout();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemMoveMode {
    }

    public interface OnItemDragEventListener {
        void onItemDragFinished(int i, int i2, boolean z);

        void onItemDragMoveDistanceUpdated(int i, int i2);

        void onItemDragPositionChanged(int i, int i2);

        void onItemDragStarted(int i);
    }

    private static boolean supportsEdgeEffect() {
        return true;
    }

    static class SwapTarget {
        public RecyclerView.ViewHolder holder;
        public int position;
        public boolean self;

        SwapTarget() {
        }

        public void clear() {
            this.holder = null;
            this.position = -1;
            this.self = false;
        }
    }

    static class FindSwapTargetContext {
        public boolean checkCanSwap;
        public RecyclerView.ViewHolder draggingItem;
        public DraggingItemInfo draggingItemInfo;
        public int lastTouchX;
        public int lastTouchY;
        public int layoutType;
        public int overlayItemLeft;
        public int overlayItemLeftNotClipped;
        public int overlayItemTop;
        public int overlayItemTopNotClipped;
        public ItemDraggableRange rootAdapterRange;
        public RecyclerView rv;
        public boolean vertical;
        public ItemDraggableRange wrappedAdapterRange;

        FindSwapTargetContext() {
        }

        public void setup(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, DraggingItemInfo draggingItemInfo, int i, int i2, ItemDraggableRange itemDraggableRange, ItemDraggableRange itemDraggableRange2, boolean z) {
            this.rv = recyclerView;
            this.draggingItemInfo = draggingItemInfo;
            this.draggingItem = viewHolder;
            this.lastTouchX = i;
            this.lastTouchY = i2;
            this.wrappedAdapterRange = itemDraggableRange;
            this.rootAdapterRange = itemDraggableRange2;
            this.checkCanSwap = z;
            int layoutType = CustomRecyclerViewUtils.getLayoutType(recyclerView);
            this.layoutType = layoutType;
            this.vertical = CustomRecyclerViewUtils.extractOrientation(layoutType) == 1;
            int i3 = i - draggingItemInfo.grabbedPositionX;
            this.overlayItemLeftNotClipped = i3;
            this.overlayItemLeft = i3;
            int i4 = i2 - draggingItemInfo.grabbedPositionY;
            this.overlayItemTopNotClipped = i4;
            this.overlayItemTop = i4;
            if (this.vertical) {
                int iMax = Math.max(this.overlayItemLeft, recyclerView.getPaddingLeft());
                this.overlayItemLeft = iMax;
                this.overlayItemLeft = Math.min(iMax, Math.max(0, (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.draggingItemInfo.width));
            } else {
                int iMax2 = Math.max(i4, recyclerView.getPaddingTop());
                this.overlayItemTop = iMax2;
                this.overlayItemTop = Math.min(iMax2, Math.max(0, (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - this.draggingItemInfo.height));
            }
        }

        public void clear() {
            this.rv = null;
            this.draggingItemInfo = null;
            this.draggingItem = null;
        }
    }

    public RecyclerView.Adapter createWrappedAdapter(RecyclerView.Adapter adapter) {
        if (!adapter.hasStableIds()) {
            throw new IllegalArgumentException("The passed adapter does not support stable IDs");
        }
        if (this.mWrapperAdapter != null) {
            throw new IllegalStateException("already have a wrapped adapter");
        }
        DraggableItemWrapperAdapter draggableItemWrapperAdapter = new DraggableItemWrapperAdapter(this, adapter);
        this.mWrapperAdapter = draggableItemWrapperAdapter;
        return draggableItemWrapperAdapter;
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
        this.mRecyclerView = recyclerView;
        recyclerView.addOnScrollListener(this.mInternalUseOnScrollListener);
        this.mRecyclerView.addOnItemTouchListener(this.mInternalUseOnItemTouchListener);
        this.mDisplayDensity = this.mRecyclerView.getResources().getDisplayMetrics().density;
        int scaledTouchSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mTouchSlop = scaledTouchSlop;
        this.mScrollTouchSlop = (int) ((scaledTouchSlop * 1.5f) + 0.5f);
        this.mHandler = new InternalHandler(this);
        if (supportsEdgeEffect()) {
            int orientation = CustomRecyclerViewUtils.getOrientation(this.mRecyclerView);
            if (orientation == 0) {
                this.mEdgeEffectDecorator = new LeftRightEdgeEffectDecorator(this.mRecyclerView);
            } else if (orientation == 1) {
                this.mEdgeEffectDecorator = new TopBottomEdgeEffectDecorator(this.mRecyclerView);
            }
            BaseEdgeEffectDecorator baseEdgeEffectDecorator = this.mEdgeEffectDecorator;
            if (baseEdgeEffectDecorator != null) {
                baseEdgeEffectDecorator.start();
            }
        }
    }

    public void release() {
        RecyclerView.OnScrollListener onScrollListener;
        RecyclerView.OnItemTouchListener onItemTouchListener;
        cancelDrag(true);
        InternalHandler internalHandler = this.mHandler;
        if (internalHandler != null) {
            internalHandler.release();
            this.mHandler = null;
        }
        BaseEdgeEffectDecorator baseEdgeEffectDecorator = this.mEdgeEffectDecorator;
        if (baseEdgeEffectDecorator != null) {
            baseEdgeEffectDecorator.finish();
            this.mEdgeEffectDecorator = null;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (onItemTouchListener = this.mInternalUseOnItemTouchListener) != null) {
            recyclerView.removeOnItemTouchListener(onItemTouchListener);
        }
        this.mInternalUseOnItemTouchListener = null;
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null && (onScrollListener = this.mInternalUseOnScrollListener) != null) {
            recyclerView2.removeOnScrollListener(onScrollListener);
        }
        this.mInternalUseOnScrollListener = null;
        ScrollOnDraggingProcessRunnable scrollOnDraggingProcessRunnable = this.mScrollOnDraggingProcess;
        if (scrollOnDraggingProcessRunnable != null) {
            scrollOnDraggingProcessRunnable.release();
            this.mScrollOnDraggingProcess = null;
        }
        this.mWrapperAdapter = null;
        this.mRecyclerView = null;
        this.mSwapTargetTranslationInterpolator = null;
    }

    public boolean isDragging() {
        return (this.mDraggingItemInfo == null || this.mHandler.isCancelDragRequested()) ? false : true;
    }

    public void setDraggingItemShadowDrawable(NinePatchDrawable ninePatchDrawable) {
        this.mShadowDrawable = ninePatchDrawable;
    }

    public void setSwapTargetTranslationInterpolator(Interpolator interpolator) {
        this.mSwapTargetTranslationInterpolator = interpolator;
    }

    public boolean isInitiateOnLongPressEnabled() {
        return this.mInitiateOnLongPress;
    }

    public void setInitiateOnLongPress(boolean z) {
        this.mInitiateOnLongPress = z;
    }

    public boolean isInitiateOnMoveEnabled() {
        return this.mInitiateOnMove;
    }

    public void setInitiateOnMove(boolean z) {
        this.mInitiateOnMove = z;
    }

    public boolean isInitiateOnTouchEnabled() {
        return this.mInitiateOnTouch;
    }

    public void setInitiateOnTouch(boolean z) {
        this.mInitiateOnTouch = z;
    }

    public void setLongPressTimeout(int i) {
        this.mLongPressTimeout = i;
    }

    public Interpolator setSwapTargetTranslationInterpolator() {
        return this.mSwapTargetTranslationInterpolator;
    }

    public OnItemDragEventListener getOnItemDragEventListener() {
        return this.mItemDragEventListener;
    }

    public void setOnItemDragEventListener(OnItemDragEventListener onItemDragEventListener) {
        this.mItemDragEventListener = onItemDragEventListener;
    }

    public void setDragEdgeScrollSpeed(float f) {
        this.mDragEdgeScrollSpeed = Math.min(Math.max(f, 0.0f), 2.0f);
    }

    public float getDragEdgeScrollSpeed() {
        return this.mDragEdgeScrollSpeed;
    }

    public void setCheckCanDropEnabled(boolean z) {
        this.mCheckCanDrop = z;
    }

    public boolean isCheckCanDropEnabled() {
        return this.mCheckCanDrop;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000d, code lost:
    
        if (r0 != 3) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (isDragging()) {
                        handleActionMoveWhileDragging(recyclerView, motionEvent);
                        return true;
                    }
                    if (handleActionMoveWhileNotDragging(recyclerView, motionEvent)) {
                        return true;
                    }
                }
            }
            return handleActionUpOrCancel(actionMasked, true);
        }
        if (!isDragging()) {
            return handleActionDown(recyclerView, motionEvent);
        }
        return false;
    }

    void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (isDragging()) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    handleActionMoveWhileDragging(recyclerView, motionEvent);
                    return;
                } else if (actionMasked != 3) {
                    return;
                }
            }
            handleActionUpOrCancel(actionMasked, true);
        }
    }

    void onRequestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            cancelDrag(true);
        }
    }

    void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.mInScrollByMethod) {
            this.mActualScrollByXAmount = i;
            this.mActualScrollByYAmount = i2;
        } else if (isDragging()) {
            ViewCompat.postOnAnimationDelayed(this.mRecyclerView, this.mCheckItemSwappingRunnable, 500L);
        }
    }

    void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 1) {
            cancelDrag(true);
        }
    }

    private boolean handleActionDown(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!checkTouchedItemState(recyclerView, viewHolderFindChildViewHolderUnderWithoutTranslation)) {
            return false;
        }
        int x = (int) (motionEvent.getX() + 0.5f);
        int y = (int) (motionEvent.getY() + 0.5f);
        if (!canStartDrag(viewHolderFindChildViewHolderUnderWithoutTranslation, x, y)) {
            return false;
        }
        int orientation = CustomRecyclerViewUtils.getOrientation(this.mRecyclerView);
        int spanCount = CustomRecyclerViewUtils.getSpanCount(this.mRecyclerView);
        this.mLastTouchX = x;
        this.mInitialTouchX = x;
        this.mLastTouchY = y;
        this.mInitialTouchY = y;
        this.mInitialTouchItemId = viewHolderFindChildViewHolderUnderWithoutTranslation.getItemId();
        boolean z = true;
        this.mCanDragH = orientation == 0 || (orientation == 1 && spanCount > 1);
        if (orientation != 1 && (orientation != 0 || spanCount <= 1)) {
            z = false;
        }
        this.mCanDragV = z;
        if (this.mInitiateOnTouch) {
            return checkConditionAndStartDragging(recyclerView, motionEvent, false);
        }
        if (!this.mInitiateOnLongPress) {
            return false;
        }
        this.mHandler.startLongPressDetection(motionEvent, this.mLongPressTimeout);
        return false;
    }

    void handleOnLongPress(MotionEvent motionEvent) {
        if (this.mInitiateOnLongPress) {
            checkConditionAndStartDragging(this.mRecyclerView, motionEvent, false);
        }
    }

    void handleOnCheckItemViewSizeUpdate() {
        RecyclerView.ViewHolder viewHolderFindViewHolderForItemId = this.mRecyclerView.findViewHolderForItemId(this.mDraggingItemInfo.id);
        if (viewHolderFindViewHolderForItemId == null) {
            return;
        }
        int width = viewHolderFindViewHolderForItemId.itemView.getWidth();
        int height = viewHolderFindViewHolderForItemId.itemView.getHeight();
        if (width == this.mDraggingItemInfo.width && height == this.mDraggingItemInfo.height) {
            return;
        }
        DraggingItemInfo draggingItemInfoCreateWithNewView = DraggingItemInfo.createWithNewView(this.mDraggingItemInfo, viewHolderFindViewHolderForItemId);
        this.mDraggingItemInfo = draggingItemInfoCreateWithNewView;
        this.mDraggingItemDecorator.updateDraggingItemView(draggingItemInfoCreateWithNewView, viewHolderFindViewHolderForItemId);
    }

    private void startDragging(RecyclerView recyclerView, MotionEvent motionEvent, RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange, AdapterPath adapterPath, int i, Object obj) {
        safeEndAnimation(recyclerView, viewHolder);
        this.mHandler.cancelLongPressDetection();
        this.mDraggingItemInfo = new DraggingItemInfo(recyclerView, viewHolder, this.mLastTouchX, this.mLastTouchY);
        this.mDraggingItemViewHolder = viewHolder;
        this.mDraggableRange = itemDraggableRange;
        this.mRootDraggableRange = convertToRootAdapterRange(adapterPath, itemDraggableRange);
        NestedScrollView nestedScrollViewFindAncestorNestedScrollView = findAncestorNestedScrollView(this.mRecyclerView);
        if (nestedScrollViewFindAncestorNestedScrollView != null && !this.mRecyclerView.isNestedScrollingEnabled()) {
            this.mNestedScrollView = nestedScrollViewFindAncestorNestedScrollView;
        } else {
            this.mNestedScrollView = null;
        }
        this.mOrigOverScrollMode = recyclerView.getOverScrollMode();
        recyclerView.setOverScrollMode(2);
        this.mLastTouchX = (int) (motionEvent.getX() + 0.5f);
        this.mLastTouchY = (int) (motionEvent.getY() + 0.5f);
        NestedScrollView nestedScrollView = this.mNestedScrollView;
        this.mNestedScrollViewScrollX = nestedScrollView != null ? nestedScrollView.getScrollX() : 0;
        NestedScrollView nestedScrollView2 = this.mNestedScrollView;
        this.mNestedScrollViewScrollY = nestedScrollView2 != null ? nestedScrollView2.getScrollY() : 0;
        int i2 = this.mLastTouchY;
        this.mDragMaxTouchY = i2;
        this.mDragMinTouchY = i2;
        this.mDragStartTouchY = i2;
        int i3 = this.mLastTouchX;
        this.mDragMaxTouchX = i3;
        this.mDragMinTouchX = i3;
        this.mDragStartTouchX = i3;
        this.mScrollDirMask = 0;
        this.mCurrentItemMoveMode = this.mItemMoveMode;
        this.mComposedAdapterTag = obj;
        this.mRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
        startScrollOnDraggingProcess();
        this.mWrapperAdapter.startDraggingItem(this.mDraggingItemInfo, viewHolder, this.mDraggableRange, i, this.mCurrentItemMoveMode);
        this.mWrapperAdapter.onBindViewHolder(viewHolder, i);
        DraggingItemDecorator draggingItemDecorator = new DraggingItemDecorator(this.mRecyclerView, viewHolder, this.mRootDraggableRange);
        this.mDraggingItemDecorator = draggingItemDecorator;
        draggingItemDecorator.setShadowDrawable(this.mShadowDrawable);
        this.mDraggingItemDecorator.setupDraggingItemEffects(this.mDraggingItemEffectsInfo);
        this.mDraggingItemDecorator.start(this.mDraggingItemInfo, this.mLastTouchX, this.mLastTouchY);
        int layoutType = CustomRecyclerViewUtils.getLayoutType(this.mRecyclerView);
        if (!this.mCheckCanDrop && CustomRecyclerViewUtils.isLinearLayout(layoutType)) {
            SwapTargetItemOperator swapTargetItemOperator = new SwapTargetItemOperator(this.mRecyclerView, viewHolder, this.mDraggingItemInfo);
            this.mSwapTargetItemOperator = swapTargetItemOperator;
            swapTargetItemOperator.setSwapTargetTranslationInterpolator(this.mSwapTargetTranslationInterpolator);
            this.mSwapTargetItemOperator.start();
            this.mSwapTargetItemOperator.update(this.mDraggingItemDecorator.getDraggingItemTranslationX(), this.mDraggingItemDecorator.getDraggingItemTranslationY());
        }
        BaseEdgeEffectDecorator baseEdgeEffectDecorator = this.mEdgeEffectDecorator;
        if (baseEdgeEffectDecorator != null) {
            baseEdgeEffectDecorator.reorderToTop();
        }
        this.mWrapperAdapter.onDragItemStarted();
        OnItemDragEventListener onItemDragEventListener = this.mItemDragEventListener;
        if (onItemDragEventListener != null) {
            onItemDragEventListener.onItemDragStarted(this.mWrapperAdapter.getDraggingItemInitialPosition());
            this.mItemDragEventListener.onItemDragMoveDistanceUpdated(0, 0);
        }
    }

    public int getItemMoveMode() {
        return this.mItemMoveMode;
    }

    public void setItemMoveMode(int i) {
        this.mItemMoveMode = i;
    }

    public void cancelDrag() {
        cancelDrag(false);
    }

    void cancelDrag(boolean z) {
        handleActionUpOrCancel(3, false);
        if (z) {
            finishDragging(false);
        } else if (isDragging()) {
            this.mHandler.requestDeferredCancelDrag();
        }
    }

    private void finishDragging(boolean z) {
        int draggingItemInitialPosition;
        int draggingItemCurrentPosition;
        if (isDragging()) {
            InternalHandler internalHandler = this.mHandler;
            if (internalHandler != null) {
                internalHandler.removeDeferredCancelDragRequest();
                this.mHandler.removeDraggingItemViewSizeUpdateCheckRequest();
            }
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && this.mDraggingItemViewHolder != null) {
                recyclerView.setOverScrollMode(this.mOrigOverScrollMode);
            }
            DraggingItemDecorator draggingItemDecorator = this.mDraggingItemDecorator;
            if (draggingItemDecorator != null) {
                draggingItemDecorator.setReturnToDefaultPositionAnimationDuration(this.mItemSettleBackIntoPlaceAnimationDuration);
                this.mDraggingItemDecorator.setReturnToDefaultPositionAnimationInterpolator(this.mItemSettleBackIntoPlaceAnimationInterpolator);
                this.mDraggingItemDecorator.finish(true);
            }
            SwapTargetItemOperator swapTargetItemOperator = this.mSwapTargetItemOperator;
            if (swapTargetItemOperator != null) {
                swapTargetItemOperator.setReturnToDefaultPositionAnimationDuration(this.mItemSettleBackIntoPlaceAnimationDuration);
                this.mDraggingItemDecorator.setReturnToDefaultPositionAnimationInterpolator(this.mItemSettleBackIntoPlaceAnimationInterpolator);
                this.mSwapTargetItemOperator.finish(true);
            }
            BaseEdgeEffectDecorator baseEdgeEffectDecorator = this.mEdgeEffectDecorator;
            if (baseEdgeEffectDecorator != null) {
                baseEdgeEffectDecorator.releaseBothGlows();
            }
            stopScrollOnDraggingProcess();
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 != null && recyclerView2.getParent() != null) {
                this.mRecyclerView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            RecyclerView recyclerView3 = this.mRecyclerView;
            if (recyclerView3 != null) {
                recyclerView3.invalidate();
            }
            this.mDraggableRange = null;
            this.mRootDraggableRange = null;
            this.mDraggingItemDecorator = null;
            this.mSwapTargetItemOperator = null;
            this.mDraggingItemViewHolder = null;
            this.mDraggingItemInfo = null;
            this.mComposedAdapterTag = null;
            this.mNestedScrollView = null;
            this.mLastTouchX = 0;
            this.mLastTouchY = 0;
            this.mNestedScrollViewScrollX = 0;
            this.mNestedScrollViewScrollY = 0;
            this.mDragStartTouchX = 0;
            this.mDragStartTouchY = 0;
            this.mDragMinTouchX = 0;
            this.mDragMinTouchY = 0;
            this.mDragMaxTouchX = 0;
            this.mDragMaxTouchY = 0;
            this.mDragScrollDistanceX = 0;
            this.mDragScrollDistanceY = 0;
            this.mCanDragH = false;
            this.mCanDragV = false;
            DraggableItemWrapperAdapter draggableItemWrapperAdapter = this.mWrapperAdapter;
            if (draggableItemWrapperAdapter != null) {
                draggingItemInitialPosition = draggableItemWrapperAdapter.getDraggingItemInitialPosition();
                draggingItemCurrentPosition = this.mWrapperAdapter.getDraggingItemCurrentPosition();
                this.mWrapperAdapter.onDragItemFinished(draggingItemInitialPosition, draggingItemCurrentPosition, z);
            } else {
                draggingItemInitialPosition = -1;
                draggingItemCurrentPosition = -1;
            }
            OnItemDragEventListener onItemDragEventListener = this.mItemDragEventListener;
            if (onItemDragEventListener != null) {
                onItemDragEventListener.onItemDragFinished(draggingItemInitialPosition, draggingItemCurrentPosition, z);
            }
        }
    }

    private boolean handleActionUpOrCancel(int i, boolean z) {
        boolean z2 = i == 1;
        boolean zIsDragging = isDragging();
        InternalHandler internalHandler = this.mHandler;
        if (internalHandler != null) {
            internalHandler.cancelLongPressDetection();
        }
        this.mInitialTouchX = 0;
        this.mInitialTouchY = 0;
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
        this.mDragStartTouchX = 0;
        this.mDragStartTouchY = 0;
        this.mDragMinTouchX = 0;
        this.mDragMinTouchY = 0;
        this.mDragMaxTouchX = 0;
        this.mDragMaxTouchY = 0;
        this.mDragScrollDistanceX = 0;
        this.mDragScrollDistanceY = 0;
        this.mInitialTouchItemId = -1L;
        this.mCanDragH = false;
        this.mCanDragV = false;
        if (z && isDragging()) {
            finishDragging(z2);
        }
        return zIsDragging;
    }

    private boolean handleActionMoveWhileNotDragging(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mInitiateOnMove) {
            return checkConditionAndStartDragging(recyclerView, motionEvent, true);
        }
        return false;
    }

    private boolean checkConditionAndStartDragging(RecyclerView recyclerView, MotionEvent motionEvent, boolean z) {
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithoutTranslation;
        if (this.mDraggingItemInfo != null) {
            return false;
        }
        int x = (int) (motionEvent.getX() + 0.5f);
        int y = (int) (motionEvent.getY() + 0.5f);
        this.mLastTouchX = x;
        this.mLastTouchY = y;
        if (this.mInitialTouchItemId == -1) {
            return false;
        }
        if ((z && ((!this.mCanDragH || Math.abs(x - this.mInitialTouchX) <= this.mTouchSlop) && (!this.mCanDragV || Math.abs(y - this.mInitialTouchY) <= this.mTouchSlop))) || (viewHolderFindChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(recyclerView, this.mInitialTouchX, this.mInitialTouchY)) == null || !canStartDrag(viewHolderFindChildViewHolderUnderWithoutTranslation, x, y)) {
            return false;
        }
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        AdapterPath adapterPath = new AdapterPath();
        int iUnwrapPosition = WrapperAdapterUtils.unwrapPosition(adapter, this.mWrapperAdapter, null, viewHolderFindChildViewHolderUnderWithoutTranslation.getAdapterPosition(), adapterPath);
        ItemDraggableRange itemDraggableRange = this.mWrapperAdapter.getItemDraggableRange(viewHolderFindChildViewHolderUnderWithoutTranslation, iUnwrapPosition);
        if (itemDraggableRange == null) {
            itemDraggableRange = new ItemDraggableRange(0, Math.max(0, this.mWrapperAdapter.getItemCount() - 1));
        }
        ItemDraggableRange itemDraggableRange2 = itemDraggableRange;
        verifyItemDraggableRange(itemDraggableRange2, iUnwrapPosition);
        startDragging(recyclerView, motionEvent, viewHolderFindChildViewHolderUnderWithoutTranslation, itemDraggableRange2, adapterPath, iUnwrapPosition, adapterPath.lastSegment().tag);
        return true;
    }

    private boolean canStartDrag(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        int adapterPosition = viewHolder.getAdapterPosition();
        int iUnwrapPosition = WrapperAdapterUtils.unwrapPosition(this.mRecyclerView.getAdapter(), this.mWrapperAdapter, (Object) null, adapterPosition);
        if (iUnwrapPosition == -1) {
            return false;
        }
        View view = viewHolder.itemView;
        return this.mWrapperAdapter.canStartDrag(viewHolder, iUnwrapPosition, i - (view.getLeft() + ((int) (view.getTranslationX() + 0.5f))), i2 - (view.getTop() + ((int) (view.getTranslationY() + 0.5f)))) && viewHolder.getAdapterPosition() == adapterPosition;
    }

    private void verifyItemDraggableRange(ItemDraggableRange itemDraggableRange, int i) {
        int iMax = Math.max(0, this.mWrapperAdapter.getItemCount() - 1);
        if (itemDraggableRange.getStart() > itemDraggableRange.getEnd()) {
            throw new IllegalStateException("Invalid wrappedAdapterRange specified --- start > wrappedAdapterRange (wrappedAdapterRange = " + itemDraggableRange + ")");
        }
        if (itemDraggableRange.getStart() < 0) {
            throw new IllegalStateException("Invalid wrappedAdapterRange specified --- start < 0 (wrappedAdapterRange = " + itemDraggableRange + ")");
        }
        if (itemDraggableRange.getEnd() > iMax) {
            throw new IllegalStateException("Invalid wrappedAdapterRange specified --- end >= count (wrappedAdapterRange = " + itemDraggableRange + ")");
        }
        if (itemDraggableRange.checkInRange(i)) {
            return;
        }
        throw new IllegalStateException("Invalid wrappedAdapterRange specified --- does not contain drag target item (wrappedAdapterRange = " + itemDraggableRange + ", position = " + i + ")");
    }

    private void handleActionMoveWhileDragging(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.mLastTouchX = (int) (motionEvent.getX() + 0.5f);
        this.mLastTouchY = (int) (motionEvent.getY() + 0.5f);
        NestedScrollView nestedScrollView = this.mNestedScrollView;
        this.mNestedScrollViewScrollX = nestedScrollView != null ? nestedScrollView.getScrollX() : 0;
        NestedScrollView nestedScrollView2 = this.mNestedScrollView;
        this.mNestedScrollViewScrollY = nestedScrollView2 != null ? nestedScrollView2.getScrollY() : 0;
        this.mDragMinTouchX = Math.min(this.mDragMinTouchX, this.mLastTouchX);
        this.mDragMinTouchY = Math.min(this.mDragMinTouchY, this.mLastTouchY);
        this.mDragMaxTouchX = Math.max(this.mDragMaxTouchX, this.mLastTouchX);
        this.mDragMaxTouchY = Math.max(this.mDragMaxTouchY, this.mLastTouchY);
        updateDragDirectionMask();
        if (this.mDraggingItemDecorator.update(getLastTouchX(), getLastTouchY(), false)) {
            SwapTargetItemOperator swapTargetItemOperator = this.mSwapTargetItemOperator;
            if (swapTargetItemOperator != null) {
                swapTargetItemOperator.update(this.mDraggingItemDecorator.getDraggingItemTranslationX(), this.mDraggingItemDecorator.getDraggingItemTranslationY());
            }
            checkItemSwapping(recyclerView);
            onItemMoveDistanceUpdated();
        }
    }

    private void updateDragDirectionMask() {
        int orientation = CustomRecyclerViewUtils.getOrientation(this.mRecyclerView);
        if (orientation == 0) {
            int lastTouchX = getLastTouchX();
            int i = this.mDragStartTouchX;
            int i2 = this.mDragMinTouchX;
            int i3 = i - i2;
            int i4 = this.mScrollTouchSlop;
            if (i3 > i4 || this.mDragMaxTouchX - lastTouchX > i4) {
                this.mScrollDirMask |= 4;
            }
            if (this.mDragMaxTouchX - i > i4 || lastTouchX - i2 > i4) {
                this.mScrollDirMask |= 8;
                return;
            }
            return;
        }
        if (orientation != 1) {
            return;
        }
        int lastTouchY = getLastTouchY();
        int i5 = this.mDragStartTouchY;
        int i6 = this.mDragMinTouchY;
        int i7 = i5 - i6;
        int i8 = this.mScrollTouchSlop;
        if (i7 > i8 || this.mDragMaxTouchY - lastTouchY > i8) {
            this.mScrollDirMask = 1 | this.mScrollDirMask;
        }
        if (this.mDragMaxTouchY - i5 > i8 || lastTouchY - i6 > i8) {
            this.mScrollDirMask |= 2;
        }
    }

    private int getLastTouchX() {
        int i = this.mLastTouchX;
        NestedScrollView nestedScrollView = this.mNestedScrollView;
        return nestedScrollView != null ? i + (nestedScrollView.getScrollX() - this.mNestedScrollViewScrollX) : i;
    }

    private int getLastTouchY() {
        int i = this.mLastTouchY;
        NestedScrollView nestedScrollView = this.mNestedScrollView;
        return nestedScrollView != null ? i + (nestedScrollView.getScrollY() - this.mNestedScrollViewScrollY) : i;
    }

    void checkItemSwapping(RecyclerView recyclerView) {
        RecyclerView.ViewHolder viewHolder = this.mDraggingItemViewHolder;
        FindSwapTargetContext findSwapTargetContext = this.mFindSwapTargetContext;
        findSwapTargetContext.setup(recyclerView, viewHolder, this.mDraggingItemInfo, getLastTouchX(), getLastTouchY(), this.mDraggableRange, this.mRootDraggableRange, this.mCheckCanDrop);
        int draggingItemInitialPosition = this.mWrapperAdapter.getDraggingItemInitialPosition();
        int draggingItemCurrentPosition = this.mWrapperAdapter.getDraggingItemCurrentPosition();
        boolean zCanDropItems = false;
        SwapTarget swapTargetFindSwapTargetItem = findSwapTargetItem(this.mTempSwapTarget, findSwapTargetContext, false);
        if (swapTargetFindSwapTargetItem.position != -1) {
            boolean z = this.mCheckCanDrop;
            zCanDropItems = z ? this.mWrapperAdapter.canDropItems(draggingItemInitialPosition, swapTargetFindSwapTargetItem.position) : !z;
            if (!zCanDropItems) {
                swapTargetFindSwapTargetItem = findSwapTargetItem(this.mTempSwapTarget, findSwapTargetContext, true);
                if (swapTargetFindSwapTargetItem.position != -1) {
                    zCanDropItems = this.mWrapperAdapter.canDropItems(draggingItemInitialPosition, swapTargetFindSwapTargetItem.position);
                }
            }
        }
        if (zCanDropItems && swapTargetFindSwapTargetItem.holder == null) {
            throw new IllegalStateException("bug check");
        }
        if (zCanDropItems) {
            swapItems(recyclerView, draggingItemCurrentPosition, viewHolder, swapTargetFindSwapTargetItem.holder);
        }
        SwapTargetItemOperator swapTargetItemOperator = this.mSwapTargetItemOperator;
        if (swapTargetItemOperator != null) {
            swapTargetItemOperator.setSwapTargetItem(zCanDropItems ? swapTargetFindSwapTargetItem.holder : null);
        }
        if (zCanDropItems) {
            this.mHandler.scheduleDraggingItemViewSizeUpdateCheck();
        }
        swapTargetFindSwapTargetItem.clear();
        findSwapTargetContext.clear();
    }

    private void onItemMoveDistanceUpdated() {
        if (this.mItemDragEventListener == null) {
            return;
        }
        this.mItemDragEventListener.onItemDragMoveDistanceUpdated(this.mDragScrollDistanceX + this.mDraggingItemDecorator.getDraggingItemMoveOffsetX(), this.mDragScrollDistanceY + this.mDraggingItemDecorator.getDraggingItemMoveOffsetY());
    }

    void handleScrollOnDragging() {
        RecyclerView recyclerView = this.mRecyclerView;
        int orientation = CustomRecyclerViewUtils.getOrientation(recyclerView);
        boolean z = true;
        if (orientation != 0) {
            if (orientation != 1) {
                return;
            } else {
                z = false;
            }
        }
        if (this.mNestedScrollView != null) {
            handleScrollOnDraggingInternalWithNestedScrollView(recyclerView, z);
        } else {
            handleScrollOnDraggingInternalWithRecyclerView(recyclerView, z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0074  */
    private void handleScrollOnDraggingInternalWithNestedScrollView(RecyclerView recyclerView, boolean z) {
        NestedScrollView nestedScrollView = this.mNestedScrollView;
        int scrollX = nestedScrollView.getScrollX();
        int scrollY = nestedScrollView.getScrollY();
        Rect rect = new Rect();
        int lastTouchX = getLastTouchX();
        rect.right = lastTouchX;
        rect.left = lastTouchX;
        int lastTouchY = getLastTouchY();
        rect.bottom = lastTouchY;
        rect.top = lastTouchY;
        offsetDescendantRectToAncestorCoords(this.mRecyclerView, nestedScrollView, rect);
        int i = rect.left - scrollX;
        int i2 = rect.top - scrollY;
        float width = 1.0f / (z ? nestedScrollView.getWidth() : nestedScrollView.getHeight());
        if (!z) {
            i = i2;
        }
        float f = (i * width) - 0.5f;
        float fMax = Math.max(0.0f, SCROLL_THRESHOLD - (0.5f - Math.abs(f))) * 3.3333333f;
        int i3 = this.mScrollDirMask;
        int iSignum = ((int) Math.signum(f)) * ((int) ((this.mDragEdgeScrollSpeed * 25.0f * this.mDisplayDensity * fMax) + 0.5f));
        if (iSignum > 0) {
            if (((z ? 8 : 2) & i3) == 0) {
                iSignum = 0;
            }
        } else if (iSignum < 0) {
            if (((z ? 4 : 1) & i3) == 0) {
                iSignum = 0;
            }
        }
        if (iSignum != 0) {
            safeEndAnimationsIfRequired(recyclerView);
            if (z) {
                nestedScrollView.scrollBy(iSignum, 0);
            } else {
                nestedScrollView.scrollBy(0, iSignum);
            }
        }
        if (this.mDraggingItemDecorator.update(getLastTouchX(), getLastTouchY(), false)) {
            SwapTargetItemOperator swapTargetItemOperator = this.mSwapTargetItemOperator;
            if (swapTargetItemOperator != null) {
                swapTargetItemOperator.update(this.mDraggingItemDecorator.getDraggingItemTranslationX(), this.mDraggingItemDecorator.getDraggingItemTranslationY());
            }
            checkItemSwapping(recyclerView);
            onItemMoveDistanceUpdated();
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0156  */
    /* JADX WARN: Code duplicated, block: B:40:0x009b  */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0151, code lost:
    
        r1 = r17.mDisplayDensity;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0153, code lost:
    
        r5 = r1 * 0.005f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x013e, code lost:
    
        r1 = -r17.mDisplayDensity;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleScrollOnDraggingInternalWithRecyclerView(RecyclerView recyclerView, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iScrollByYAndGetScrolledAmount;
        float f;
        float f2;
        int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
        if (width == 0) {
            return;
        }
        float f3 = 1.0f / width;
        float lastTouchX = ((z ? getLastTouchX() : getLastTouchY()) * f3) - 0.5f;
        float fMax = Math.max(0.0f, SCROLL_THRESHOLD - (0.5f - Math.abs(lastTouchX))) * 3.3333333f;
        int i = this.mScrollDirMask;
        DraggingItemDecorator draggingItemDecorator = this.mDraggingItemDecorator;
        int iSignum = ((int) Math.signum(lastTouchX)) * ((int) ((this.mDragEdgeScrollSpeed * 25.0f * this.mDisplayDensity * fMax) + 0.5f));
        ItemDraggableRange itemDraggableRange = this.mRootDraggableRange;
        int iFindFirstCompletelyVisibleItemPosition = CustomRecyclerViewUtils.findFirstCompletelyVisibleItemPosition(this.mRecyclerView);
        int iFindLastCompletelyVisibleItemPosition = CustomRecyclerViewUtils.findLastCompletelyVisibleItemPosition(this.mRecyclerView);
        if (iFindFirstCompletelyVisibleItemPosition != -1) {
            z2 = iFindFirstCompletelyVisibleItemPosition <= itemDraggableRange.getStart();
            z3 = iFindFirstCompletelyVisibleItemPosition <= itemDraggableRange.getStart() - 1;
        } else {
            z2 = false;
            z3 = false;
        }
        if (iFindLastCompletelyVisibleItemPosition != -1) {
            z5 = iFindLastCompletelyVisibleItemPosition >= itemDraggableRange.getEnd();
            z4 = iFindLastCompletelyVisibleItemPosition >= itemDraggableRange.getEnd() + 1;
        } else {
            z4 = false;
            z5 = false;
        }
        if (iSignum > 0) {
            if ((i & (z ? 8 : 2)) == 0) {
                iSignum = 0;
            }
        } else if (iSignum < 0) {
            if ((i & (z ? 4 : 1)) == 0) {
                iSignum = 0;
            }
        }
        if ((!z3 && iSignum < 0) || (!z4 && iSignum > 0)) {
            safeEndAnimationsIfRequired(recyclerView);
            if (z) {
                iScrollByYAndGetScrolledAmount = scrollByXAndGetScrolledAmount(iSignum);
            } else {
                iScrollByYAndGetScrolledAmount = scrollByYAndGetScrolledAmount(iSignum);
            }
            if (iSignum < 0) {
                draggingItemDecorator.setIsScrolling(!z2);
            } else {
                draggingItemDecorator.setIsScrolling(!z5);
            }
            draggingItemDecorator.refresh(true);
            SwapTargetItemOperator swapTargetItemOperator = this.mSwapTargetItemOperator;
            if (swapTargetItemOperator != null) {
                swapTargetItemOperator.update(draggingItemDecorator.getDraggingItemTranslationX(), draggingItemDecorator.getDraggingItemTranslationY());
            }
        } else {
            draggingItemDecorator.setIsScrolling(false);
            iScrollByYAndGetScrolledAmount = 0;
        }
        if (this.mEdgeEffectDecorator != null) {
            if (this.mOrigOverScrollMode == 2) {
                f = 0.0f;
                f2 = f;
            } else {
                boolean z6 = iScrollByYAndGetScrolledAmount != 0;
                int translatedItemPositionLeft = z ? draggingItemDecorator.getTranslatedItemPositionLeft() : draggingItemDecorator.getTranslatedItemPositionTop();
                int translatedItemPositionRight = z ? draggingItemDecorator.getTranslatedItemPositionRight() : draggingItemDecorator.getTranslatedItemPositionBottom();
                int i2 = (translatedItemPositionLeft + translatedItemPositionRight) / 2;
                if (iFindFirstCompletelyVisibleItemPosition != 0 || iFindLastCompletelyVisibleItemPosition != 0 ? i2 >= width / 2 : iSignum >= 0) {
                    translatedItemPositionLeft = translatedItemPositionRight;
                }
                float f4 = (translatedItemPositionLeft * f3) - 0.5f;
                if (Math.abs(f4) <= 0.4f || iSignum == 0 || z6) {
                    f = 0.0f;
                } else {
                    f = 0.0f;
                    if (f4 < 0.0f) {
                        if (z) {
                        }
                    } else if (z) {
                    }
                }
                f2 = f;
            }
            updateEdgeEffect(f2);
        }
        ViewCompat.postOnAnimation(this.mRecyclerView, this.mCheckItemSwappingRunnable);
        if (iScrollByYAndGetScrolledAmount != 0) {
            if (z) {
                this.mDragScrollDistanceX += iScrollByYAndGetScrolledAmount;
            } else {
                this.mDragScrollDistanceY += iScrollByYAndGetScrolledAmount;
            }
            onItemMoveDistanceUpdated();
        }
    }

    private void updateEdgeEffect(float f) {
        if (f == 0.0f) {
            this.mEdgeEffectDecorator.releaseBothGlows();
        } else if (f < 0.0f) {
            this.mEdgeEffectDecorator.pullFirstEdge(f);
        } else {
            this.mEdgeEffectDecorator.pullSecondEdge(f);
        }
    }

    private static NestedScrollView findAncestorNestedScrollView(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof NestedScrollView) {
                return (NestedScrollView) parent;
            }
        }
        return null;
    }

    private static boolean offsetDescendantRectToAncestorCoords(View view, View view2, Rect rect) {
        Object parent;
        do {
            parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ((ViewGroup) parent).offsetDescendantRectToMyCoords(view, rect);
            view = (View) parent;
        } while (parent != view2);
        return true;
    }

    private int scrollByYAndGetScrolledAmount(int i) {
        this.mActualScrollByYAmount = 0;
        this.mInScrollByMethod = true;
        this.mRecyclerView.scrollBy(0, i);
        this.mInScrollByMethod = false;
        return this.mActualScrollByYAmount;
    }

    private int scrollByXAndGetScrolledAmount(int i) {
        this.mActualScrollByXAmount = 0;
        this.mInScrollByMethod = true;
        this.mRecyclerView.scrollBy(i, 0);
        this.mInScrollByMethod = false;
        return this.mActualScrollByXAmount;
    }

    RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    private void startScrollOnDraggingProcess() {
        this.mScrollOnDraggingProcess.start();
    }

    private void stopScrollOnDraggingProcess() {
        ScrollOnDraggingProcessRunnable scrollOnDraggingProcessRunnable = this.mScrollOnDraggingProcess;
        if (scrollOnDraggingProcessRunnable != null) {
            scrollOnDraggingProcessRunnable.stop();
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d A[PHI: r9
      0x004d: PHI (r9v3 boolean) = (r9v0 boolean), (r9v1 boolean), (r9v1 boolean), (r9v1 boolean), (r9v1 boolean) binds: [B:15:0x004b, B:30:0x00aa, B:32:0x00ae, B:39:0x00f3, B:36:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    private void swapItems(RecyclerView recyclerView, int i, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Rect layoutMargins = CustomRecyclerViewUtils.getLayoutMargins(viewHolder2.itemView, this.mTmpRect1);
        int wrappedAdapterPosition = getWrappedAdapterPosition(viewHolder2);
        int iAbs = Math.abs(i - wrappedAdapterPosition);
        if (i == -1 || wrappedAdapterPosition == -1 || ItemIdComposer.extractWrappedIdPart(this.mWrapperAdapter.getItemId(i)) != ItemIdComposer.extractWrappedIdPart(this.mDraggingItemInfo.id)) {
            return;
        }
        boolean z = true;
        boolean z2 = false;
        boolean z3 = CustomRecyclerViewUtils.isLinearLayout(CustomRecyclerViewUtils.getLayoutType(recyclerView)) && !this.mCheckCanDrop;
        if (iAbs == 0) {
            z = z2;
        } else if (iAbs == 1 && viewHolder != null && z3) {
            View view = viewHolder.itemView;
            View view2 = viewHolder2.itemView;
            Rect rect = this.mDraggingItemInfo.margins;
            if (this.mCanDragH) {
                int iMin = Math.min(view.getLeft() - rect.left, view2.getLeft() - layoutMargins.left);
                float fMax = iMin + ((Math.max(view.getRight() + rect.right, view2.getRight() + layoutMargins.right) - iMin) * 0.5f);
                float lastTouchX = (getLastTouchX() - this.mDraggingItemInfo.grabbedPositionX) + (this.mDraggingItemInfo.width * 0.5f);
                if (wrappedAdapterPosition >= i ? lastTouchX > fMax : lastTouchX < fMax) {
                    z2 = true;
                }
            }
            if (z2 || !this.mCanDragV) {
                z = z2;
            } else {
                int iMin2 = Math.min(view.getTop() - rect.top, view2.getTop() - layoutMargins.top);
                float fMax2 = iMin2 + ((Math.max(view.getBottom() + rect.bottom, view2.getBottom() + layoutMargins.bottom) - iMin2) * 0.5f);
                float lastTouchY = (getLastTouchY() - this.mDraggingItemInfo.grabbedPositionY) + (this.mDraggingItemInfo.height * 0.5f);
                if (wrappedAdapterPosition >= i ? lastTouchY <= fMax2 : lastTouchY >= fMax2) {
                    z = z2;
                }
            }
        }
        if (z) {
            performSwapItems(recyclerView, viewHolder, viewHolder2, layoutMargins, i, wrappedAdapterPosition);
        }
    }

    private void performSwapItems(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, Rect rect, int i, int i2) {
        int decoratedMeasuredWidth;
        int i3;
        OnItemDragEventListener onItemDragEventListener = this.mItemDragEventListener;
        if (onItemDragEventListener != null) {
            onItemDragEventListener.onItemDragPositionChanged(i, i2);
        }
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int layoutType = CustomRecyclerViewUtils.getLayoutType(this.mRecyclerView);
        boolean z = CustomRecyclerViewUtils.extractOrientation(layoutType) == 1;
        int iFindFirstVisibleItemPosition = CustomRecyclerViewUtils.findFirstVisibleItemPosition(this.mRecyclerView, false);
        View view = viewHolder != null ? viewHolder.itemView : null;
        View view2 = viewHolder2.itemView;
        View viewFindViewByPosition = CustomRecyclerViewUtils.findViewByPosition(layoutManager, iFindFirstVisibleItemPosition);
        int layoutPosition = viewHolder != null ? viewHolder.getLayoutPosition() : -1;
        int layoutPosition2 = viewHolder2.getLayoutPosition();
        Integer itemViewOrigin = getItemViewOrigin(view, z);
        Integer itemViewOrigin2 = getItemViewOrigin(view2, z);
        Integer itemViewOrigin3 = getItemViewOrigin(viewFindViewByPosition, z);
        this.mWrapperAdapter.moveItem(i, i2, layoutType);
        if (iFindFirstVisibleItemPosition == layoutPosition && itemViewOrigin3 != null && itemViewOrigin2 != null) {
            scrollBySpecifiedOrientation(recyclerView, -(itemViewOrigin2.intValue() - itemViewOrigin3.intValue()), z);
            safeEndAnimations(recyclerView);
            return;
        }
        if (iFindFirstVisibleItemPosition != layoutPosition2 || view == null || itemViewOrigin == null || itemViewOrigin.equals(itemViewOrigin2)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (z) {
            decoratedMeasuredWidth = layoutManager.getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin;
            i3 = marginLayoutParams.bottomMargin;
        } else {
            decoratedMeasuredWidth = layoutManager.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin;
            i3 = marginLayoutParams.rightMargin;
        }
        scrollBySpecifiedOrientation(recyclerView, -(decoratedMeasuredWidth + i3), z);
        safeEndAnimations(recyclerView);
    }

    private static void scrollBySpecifiedOrientation(RecyclerView recyclerView, int i, boolean z) {
        if (z) {
            recyclerView.scrollBy(0, i);
        } else {
            recyclerView.scrollBy(i, 0);
        }
    }

    private static Integer getItemViewOrigin(View view, boolean z) {
        if (view != null) {
            return Integer.valueOf(z ? view.getTop() : view.getLeft());
        }
        return null;
    }

    private boolean checkTouchedItemState(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (!(viewHolder instanceof DraggableItemViewHolder)) {
            return false;
        }
        int wrappedAdapterPosition = getWrappedAdapterPosition(viewHolder);
        return wrappedAdapterPosition >= 0 && wrappedAdapterPosition < this.mWrapperAdapter.getItemCount();
    }

    private static void safeEndAnimation(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView != null ? recyclerView.getItemAnimator() : null;
        if (itemAnimator != null) {
            itemAnimator.endAnimation(viewHolder);
        }
    }

    private static void safeEndAnimations(RecyclerView recyclerView) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView != null ? recyclerView.getItemAnimator() : null;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
    }

    private void safeEndAnimationsIfRequired(RecyclerView recyclerView) {
        if (this.mSwapTargetItemOperator != null) {
            safeEndAnimations(recyclerView);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    private SwapTarget findSwapTargetItem(SwapTarget swapTarget, FindSwapTargetContext findSwapTargetContext, boolean z) {
        RecyclerView.ViewHolder viewHolderFindSwapTargetItemForLinearLayoutManager;
        swapTarget.clear();
        if (findSwapTargetContext.draggingItem == null || (getWrappedAdapterPosition(findSwapTargetContext.draggingItem) != -1 && findSwapTargetContext.draggingItem.getItemId() == findSwapTargetContext.draggingItemInfo.id)) {
            int i = findSwapTargetContext.layoutType;
            if (i == 0 || i == 1) {
                viewHolderFindSwapTargetItemForLinearLayoutManager = findSwapTargetItemForLinearLayoutManager(findSwapTargetContext, z);
            } else if (i == 2 || i == 3) {
                viewHolderFindSwapTargetItemForLinearLayoutManager = findSwapTargetItemForGridLayoutManager(findSwapTargetContext, z);
            } else if (i == 4 || i == 5) {
                viewHolderFindSwapTargetItemForLinearLayoutManager = findSwapTargetItemForStaggeredGridLayoutManager(findSwapTargetContext, z);
            } else {
                viewHolderFindSwapTargetItemForLinearLayoutManager = null;
            }
        } else {
            viewHolderFindSwapTargetItemForLinearLayoutManager = null;
        }
        if (viewHolderFindSwapTargetItemForLinearLayoutManager == findSwapTargetContext.draggingItem) {
            swapTarget.self = true;
            viewHolderFindSwapTargetItemForLinearLayoutManager = null;
        }
        int wrappedAdapterPosition = getWrappedAdapterPosition(viewHolderFindSwapTargetItemForLinearLayoutManager);
        RecyclerView.ViewHolder viewHolder = (viewHolderFindSwapTargetItemForLinearLayoutManager == null || findSwapTargetContext.wrappedAdapterRange == null || findSwapTargetContext.wrappedAdapterRange.checkInRange(wrappedAdapterPosition)) ? viewHolderFindSwapTargetItemForLinearLayoutManager : null;
        swapTarget.holder = viewHolder;
        swapTarget.position = viewHolder != null ? wrappedAdapterPosition : -1;
        return swapTarget;
    }

    private static RecyclerView.ViewHolder findSwapTargetItemForGridLayoutManager(FindSwapTargetContext findSwapTargetContext, boolean z) {
        if (z) {
            return null;
        }
        RecyclerView.ViewHolder viewHolderFindSwapTargetItemForGridLayoutManagerInternal1 = findSwapTargetItemForGridLayoutManagerInternal1(findSwapTargetContext);
        return viewHolderFindSwapTargetItemForGridLayoutManagerInternal1 == null ? findSwapTargetItemForGridLayoutManagerInternal2(findSwapTargetContext) : viewHolderFindSwapTargetItemForGridLayoutManagerInternal1;
    }

    private static RecyclerView.ViewHolder findSwapTargetItemForStaggeredGridLayoutManager(FindSwapTargetContext findSwapTargetContext, boolean z) {
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithoutTranslation;
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithoutTranslation2;
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithoutTranslation3;
        if (z || findSwapTargetContext.draggingItem == null) {
            return null;
        }
        int i = findSwapTargetContext.overlayItemLeft + 1;
        int i2 = (findSwapTargetContext.overlayItemLeft + (findSwapTargetContext.draggingItemInfo.width / 2)) - 1;
        int i3 = (findSwapTargetContext.overlayItemLeft + findSwapTargetContext.draggingItemInfo.width) - 2;
        int i4 = findSwapTargetContext.overlayItemTop + 1;
        int i5 = (findSwapTargetContext.overlayItemTop + (findSwapTargetContext.draggingItemInfo.height / 2)) - 1;
        int i6 = (findSwapTargetContext.overlayItemTop + findSwapTargetContext.draggingItemInfo.height) - 2;
        if (findSwapTargetContext.vertical) {
            float f = i5;
            viewHolderFindChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, i, f);
            viewHolderFindChildViewHolderUnderWithoutTranslation2 = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, i3, f);
            viewHolderFindChildViewHolderUnderWithoutTranslation3 = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, i2, f);
        } else {
            float f2 = i2;
            viewHolderFindChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, f2, i4);
            viewHolderFindChildViewHolderUnderWithoutTranslation2 = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, f2, i5);
            viewHolderFindChildViewHolderUnderWithoutTranslation3 = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, f2, i6);
        }
        if (viewHolderFindChildViewHolderUnderWithoutTranslation3 == findSwapTargetContext.draggingItem) {
            return null;
        }
        if (viewHolderFindChildViewHolderUnderWithoutTranslation3 == viewHolderFindChildViewHolderUnderWithoutTranslation || viewHolderFindChildViewHolderUnderWithoutTranslation3 == viewHolderFindChildViewHolderUnderWithoutTranslation2) {
            return viewHolderFindChildViewHolderUnderWithoutTranslation3;
        }
        return null;
    }

    private static RecyclerView.ViewHolder findSwapTargetItemForGridLayoutManagerInternal1(FindSwapTargetContext findSwapTargetContext) {
        return CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, findSwapTargetContext.lastTouchX, findSwapTargetContext.lastTouchY);
    }

    private static RecyclerView.ViewHolder findSwapTargetItemForGridLayoutManagerInternal2(FindSwapTargetContext findSwapTargetContext) {
        float f;
        float f2;
        int spanCount = CustomRecyclerViewUtils.getSpanCount(findSwapTargetContext.rv);
        int height = findSwapTargetContext.rv.getHeight();
        int width = findSwapTargetContext.rv.getWidth();
        int paddingLeft = findSwapTargetContext.vertical ? findSwapTargetContext.rv.getPaddingLeft() : 0;
        int paddingTop = !findSwapTargetContext.vertical ? findSwapTargetContext.rv.getPaddingTop() : 0;
        int paddingRight = ((width - paddingLeft) - (findSwapTargetContext.vertical ? findSwapTargetContext.rv.getPaddingRight() : 0)) / spanCount;
        int paddingBottom = ((height - paddingTop) - (!findSwapTargetContext.vertical ? findSwapTargetContext.rv.getPaddingBottom() : 0)) / spanCount;
        int i = findSwapTargetContext.lastTouchX;
        int i2 = findSwapTargetContext.lastTouchY;
        int start = findSwapTargetContext.rootAdapterRange.getStart();
        int end = findSwapTargetContext.rootAdapterRange.getEnd();
        if (findSwapTargetContext.vertical) {
            f = i - paddingLeft;
            f2 = paddingRight;
        } else {
            f = i2 - paddingTop;
            f2 = paddingBottom;
        }
        for (int iMin = Math.min(Math.max((int) (f / f2), 0), spanCount - 1); iMin >= 0; iMin--) {
            RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, findSwapTargetContext.vertical ? (paddingRight * iMin) + paddingLeft + (paddingRight / 2) : i, !findSwapTargetContext.vertical ? (paddingBottom * iMin) + paddingTop + (paddingBottom / 2) : i2);
            if (viewHolderFindChildViewHolderUnderWithoutTranslation != null) {
                int adapterPosition = viewHolderFindChildViewHolderUnderWithoutTranslation.getAdapterPosition();
                if (adapterPosition == -1 || adapterPosition < start || adapterPosition > end) {
                    return null;
                }
                return viewHolderFindChildViewHolderUnderWithoutTranslation;
            }
        }
        return null;
    }

    private static RecyclerView.ViewHolder findSwapTargetItemForLinearLayoutManager(FindSwapTargetContext findSwapTargetContext, boolean z) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (findSwapTargetContext.draggingItem == null) {
            return null;
        }
        if (!findSwapTargetContext.checkCanSwap && !z) {
            int adapterPosition = findSwapTargetContext.draggingItem.getAdapterPosition();
            int top = findSwapTargetContext.vertical ? findSwapTargetContext.draggingItem.itemView.getTop() : findSwapTargetContext.draggingItem.itemView.getLeft();
            int i = findSwapTargetContext.vertical ? findSwapTargetContext.overlayItemTop : findSwapTargetContext.overlayItemLeft;
            if (i < top) {
                if (adapterPosition <= 0) {
                    return null;
                }
                viewHolderFindViewHolderForAdapterPosition = findSwapTargetContext.rv.findViewHolderForAdapterPosition(adapterPosition - 1);
            } else {
                if (i <= top || adapterPosition >= findSwapTargetContext.rv.getAdapter().getItemCount() - 1) {
                    return null;
                }
                viewHolderFindViewHolderForAdapterPosition = findSwapTargetContext.rv.findViewHolderForAdapterPosition(adapterPosition + 1);
            }
            return viewHolderFindViewHolderForAdapterPosition;
        }
        float f = findSwapTargetContext.draggingItem.itemView.getResources().getDisplayMetrics().density * 8.0f;
        float fMin = Math.min(findSwapTargetContext.draggingItemInfo.width * 0.2f, f);
        float fMin2 = Math.min(findSwapTargetContext.draggingItemInfo.height * 0.2f, f);
        float f2 = findSwapTargetContext.overlayItemLeft + (findSwapTargetContext.draggingItemInfo.width * 0.5f);
        float f3 = findSwapTargetContext.overlayItemTop + (findSwapTargetContext.draggingItemInfo.height * 0.5f);
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, f2 - fMin, f3 - fMin2);
        if (viewHolderFindChildViewHolderUnderWithoutTranslation == CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(findSwapTargetContext.rv, f2 + fMin, f3 + fMin2)) {
            return viewHolderFindChildViewHolderUnderWithoutTranslation;
        }
        return null;
    }

    public void setItemSettleBackIntoPlaceAnimationDuration(int i) {
        this.mItemSettleBackIntoPlaceAnimationDuration = i;
    }

    public int getItemSettleBackIntoPlaceAnimationDuration() {
        return this.mItemSettleBackIntoPlaceAnimationDuration;
    }

    public void setItemSettleBackIntoPlaceAnimationInterpolator(Interpolator interpolator) {
        this.mItemSettleBackIntoPlaceAnimationInterpolator = interpolator;
    }

    public Interpolator getItemSettleBackIntoPlaceAnimationInterpolator() {
        return this.mItemSettleBackIntoPlaceAnimationInterpolator;
    }

    public void setDragStartItemAnimationDuration(int i) {
        this.mDraggingItemEffectsInfo.durationMillis = i;
    }

    public int getDragStartItemAnimationDuration() {
        return this.mDraggingItemEffectsInfo.durationMillis;
    }

    public void setDragStartItemScaleAnimationInterpolator(Interpolator interpolator) {
        this.mDraggingItemEffectsInfo.scaleInterpolator = interpolator;
    }

    public Interpolator getDragStartItemScaleAnimationInterpolator() {
        return this.mDraggingItemEffectsInfo.scaleInterpolator;
    }

    public void setDragStartItemRotationAnimationInterpolator(Interpolator interpolator) {
        this.mDraggingItemEffectsInfo.rotationInterpolator = interpolator;
    }

    public Interpolator getDragStartItemRotationAnimationInterpolator() {
        return this.mDraggingItemEffectsInfo.rotationInterpolator;
    }

    public void setDragStartItemAlphaAnimationInterpolator(Interpolator interpolator) {
        this.mDraggingItemEffectsInfo.alphaInterpolator = interpolator;
    }

    public Interpolator getDragStartItemAlphaAnimationInterpolator() {
        return this.mDraggingItemEffectsInfo.alphaInterpolator;
    }

    public void setDraggingItemScale(float f) {
        this.mDraggingItemEffectsInfo.scale = f;
    }

    public float getDraggingItemScale() {
        return this.mDraggingItemEffectsInfo.scale;
    }

    public void setDraggingItemRotation(float f) {
        this.mDraggingItemEffectsInfo.rotation = f;
    }

    public float getDraggingItemRotation() {
        return this.mDraggingItemEffectsInfo.rotation;
    }

    public void setDraggingItemAlpha(float f) {
        this.mDraggingItemEffectsInfo.alpha = f;
    }

    public float getDraggingItemAlpha() {
        return this.mDraggingItemEffectsInfo.alpha;
    }

    void onItemViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == this.mDraggingItemViewHolder) {
            onDraggingItemViewRecycled();
            return;
        }
        SwapTargetItemOperator swapTargetItemOperator = this.mSwapTargetItemOperator;
        if (swapTargetItemOperator != null) {
            swapTargetItemOperator.onItemViewRecycled(viewHolder);
        }
    }

    RecyclerView.ViewHolder getDraggingItemViewHolder() {
        return this.mDraggingItemViewHolder;
    }

    void onNewDraggingItemViewBound(RecyclerView.ViewHolder viewHolder) {
        if (this.mDraggingItemViewHolder != null) {
            onDraggingItemViewRecycled();
        }
        this.mDraggingItemViewHolder = viewHolder;
        this.mDraggingItemDecorator.setDraggingItemViewHolder(viewHolder);
    }

    private void onDraggingItemViewRecycled() {
        Log.i(TAG, "a view holder object which is bound to currently dragging item is recycled");
        this.mDraggingItemViewHolder = null;
        this.mDraggingItemDecorator.invalidateDraggingItem();
    }

    private int getWrappedAdapterPosition(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return -1;
        }
        return WrapperAdapterUtils.unwrapPosition(this.mRecyclerView.getAdapter(), this.mWrapperAdapter, this.mComposedAdapterTag, viewHolder.getAdapterPosition());
    }

    private ItemDraggableRange convertToRootAdapterRange(AdapterPath adapterPath, ItemDraggableRange itemDraggableRange) {
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        return new ItemDraggableRange(WrapperAdapterUtils.wrapPosition(adapterPath, this.mWrapperAdapter, adapter, itemDraggableRange.getStart()), WrapperAdapterUtils.wrapPosition(adapterPath, this.mWrapperAdapter, adapter, itemDraggableRange.getEnd()));
    }

    private static class ScrollOnDraggingProcessRunnable implements Runnable {
        private final WeakReference<RecyclerViewDragDropManager> mHolderRef;
        private boolean mStarted;

        public ScrollOnDraggingProcessRunnable(RecyclerViewDragDropManager recyclerViewDragDropManager) {
            this.mHolderRef = new WeakReference<>(recyclerViewDragDropManager);
        }

        public void start() {
            RecyclerViewDragDropManager recyclerViewDragDropManager;
            RecyclerView recyclerView;
            if (this.mStarted || (recyclerViewDragDropManager = this.mHolderRef.get()) == null || (recyclerView = recyclerViewDragDropManager.getRecyclerView()) == null) {
                return;
            }
            ViewCompat.postOnAnimation(recyclerView, this);
            this.mStarted = true;
        }

        public void stop() {
            if (this.mStarted) {
                this.mStarted = false;
            }
        }

        public void release() {
            this.mHolderRef.clear();
            this.mStarted = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerViewDragDropManager recyclerViewDragDropManager = this.mHolderRef.get();
            if (recyclerViewDragDropManager != null && this.mStarted) {
                recyclerViewDragDropManager.handleScrollOnDragging();
                RecyclerView recyclerView = recyclerViewDragDropManager.getRecyclerView();
                if (recyclerView != null && this.mStarted) {
                    ViewCompat.postOnAnimation(recyclerView, this);
                } else {
                    this.mStarted = false;
                }
            }
        }
    }

    private static class InternalHandler extends Handler {
        private static final int MSG_CHECK_ITEM_VIEW_SIZE_UPDATE = 3;
        private static final int MSG_DEFERRED_CANCEL_DRAG = 2;
        private static final int MSG_LONGPRESS = 1;
        private MotionEvent mDownMotionEvent;
        private RecyclerViewDragDropManager mHolder;

        public InternalHandler(RecyclerViewDragDropManager recyclerViewDragDropManager) {
            this.mHolder = recyclerViewDragDropManager;
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
            } else if (i == 2) {
                this.mHolder.cancelDrag(true);
            } else {
                if (i != 3) {
                    return;
                }
                this.mHolder.handleOnCheckItemViewSizeUpdate();
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

        public void removeDeferredCancelDragRequest() {
            removeMessages(2);
        }

        public void requestDeferredCancelDrag() {
            if (isCancelDragRequested()) {
                return;
            }
            sendEmptyMessage(2);
        }

        public boolean isCancelDragRequested() {
            return hasMessages(2);
        }

        public void scheduleDraggingItemViewSizeUpdateCheck() {
            sendEmptyMessage(3);
        }

        public void removeDraggingItemViewSizeUpdateCheckRequest() {
            removeMessages(3);
        }
    }
}
