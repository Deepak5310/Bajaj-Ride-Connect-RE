package com.h6ah4i.android.widget.advrecyclerview.touchguard;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class RecyclerViewTouchActionGuardManager {
    private static final boolean LOCAL_LOGD = false;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "ARVTouchActionGuardMgr";
    private boolean mEnabled;
    private boolean mGuarding;
    private int mInitialTouchY;
    private boolean mInterceptScrollingWhileAnimationRunning;
    private RecyclerView.OnItemTouchListener mInternalUseOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.h6ah4i.android.widget.advrecyclerview.touchguard.RecyclerViewTouchActionGuardManager.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return RecyclerViewTouchActionGuardManager.this.onInterceptTouchEvent(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            RecyclerViewTouchActionGuardManager.this.onTouchEvent(recyclerView, motionEvent);
        }
    };
    private int mLastTouchY;
    private RecyclerView mRecyclerView;
    private int mTouchSlop;

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
        recyclerView.addOnItemTouchListener(this.mInternalUseOnItemTouchListener);
        this.mTouchSlop = ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop();
    }

    public void release() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (onItemTouchListener = this.mInternalUseOnItemTouchListener) != null) {
            recyclerView.removeOnItemTouchListener(onItemTouchListener);
        }
        this.mInternalUseOnItemTouchListener = null;
        this.mRecyclerView = null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x001d  */
    boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            handleActionDown(motionEvent);
        } else if (actionMasked == 1) {
            handleActionUpOrCancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                handleActionUpOrCancel();
            }
        } else if (handleActionMove(recyclerView, motionEvent)) {
            return true;
        }
        return false;
    }

    void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mEnabled) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3) {
                handleActionUpOrCancel();
            }
        }
    }

    private boolean handleActionMove(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.mGuarding) {
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            int i = y - this.mInitialTouchY;
            if (this.mInterceptScrollingWhileAnimationRunning && Math.abs(i) > this.mTouchSlop && recyclerView.isAnimating()) {
                this.mGuarding = true;
            }
        }
        return this.mGuarding;
    }

    private void handleActionUpOrCancel() {
        this.mGuarding = false;
        this.mInitialTouchY = 0;
        this.mLastTouchY = 0;
    }

    private void handleActionDown(MotionEvent motionEvent) {
        int y = (int) (motionEvent.getY() + 0.5f);
        this.mLastTouchY = y;
        this.mInitialTouchY = y;
        this.mGuarding = false;
    }

    public void setEnabled(boolean z) {
        if (this.mEnabled == z) {
            return;
        }
        this.mEnabled = z;
        if (z) {
            return;
        }
        handleActionUpOrCancel();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setInterceptVerticalScrollingWhileAnimationRunning(boolean z) {
        this.mInterceptScrollingWhileAnimationRunning = z;
    }

    public boolean isInterceptScrollingWhileAnimationRunning() {
        return this.mInterceptScrollingWhileAnimationRunning;
    }
}
