package com.h6ah4i.android.widget.advrecyclerview.swipeable.action;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SwipeResultAction {
    private final int mResultAction;

    protected void onCleanUp() {
    }

    protected void onPerformAction() {
    }

    protected void onSlideAnimationEnd() {
    }

    protected SwipeResultAction(int i) {
        this.mResultAction = i;
    }

    public int getResultActionType() {
        return this.mResultAction;
    }

    public final void performAction() {
        onPerformAction();
    }

    public final void slideAnimationEnd() {
        onSlideAnimationEnd();
        onCleanUp();
    }
}
