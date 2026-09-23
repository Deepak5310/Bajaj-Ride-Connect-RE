package com.h6ah4i.android.widget.advrecyclerview.event;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseRecyclerViewEventDistributor<T> {
    protected List<T> mListeners;
    protected boolean mPerformingClearMethod;
    protected RecyclerView mRecyclerView;
    protected boolean mReleased;

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public void release() {
        if (this.mReleased) {
            return;
        }
        this.mReleased = true;
        clear(true);
        onRelease();
    }

    public boolean isReleased() {
        return this.mReleased;
    }

    public void attachRecyclerView(RecyclerView recyclerView) {
        verifyIsNotReleased("attachRecyclerView()");
        verifyIsNotPerformingClearMethod("attachRecyclerView()");
        onRecyclerViewAttached(recyclerView);
    }

    public boolean add(T t) {
        return add(t, -1);
    }

    public boolean add(T t, int i) {
        verifyIsNotReleased("add()");
        verifyIsNotPerformingClearMethod("add()");
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        if (this.mListeners.contains(t)) {
            return true;
        }
        if (i < 0) {
            this.mListeners.add(t);
        } else {
            this.mListeners.add(i, t);
        }
        if (!(t instanceof RecyclerViewEventDistributorListener)) {
            return true;
        }
        ((RecyclerViewEventDistributorListener) t).onAddedToEventDistributor(this);
        return true;
    }

    public boolean remove(T t) {
        verifyIsNotPerformingClearMethod("remove()");
        verifyIsNotReleased("remove()");
        List<T> list = this.mListeners;
        if (list == null) {
            return false;
        }
        boolean zRemove = list.remove(t);
        if (zRemove && (t instanceof RecyclerViewEventDistributorListener)) {
            ((RecyclerViewEventDistributorListener) t).onRemovedFromEventDistributor(this);
        }
        return zRemove;
    }

    public void clear() {
        clear(false);
    }

    protected void clear(boolean z) {
        if (!z) {
            verifyIsNotReleased("clear()");
        }
        verifyIsNotPerformingClearMethod("clear()");
        List<T> list = this.mListeners;
        if (list == null) {
            return;
        }
        try {
            this.mPerformingClearMethod = true;
            for (int size = list.size() - 1; size >= 0; size--) {
                T tRemove = this.mListeners.remove(size);
                if (tRemove instanceof RecyclerViewEventDistributorListener) {
                    ((RecyclerViewEventDistributorListener) tRemove).onRemovedFromEventDistributor(this);
                }
            }
            this.mPerformingClearMethod = false;
        } catch (Throwable th) {
            this.mPerformingClearMethod = false;
            throw th;
        }
    }

    public int size() {
        List<T> list = this.mListeners;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public boolean contains(T t) {
        List<T> list = this.mListeners;
        if (list != null) {
            return list.contains(t);
        }
        return false;
    }

    protected void onRelease() {
        this.mRecyclerView = null;
        this.mListeners = null;
        this.mPerformingClearMethod = false;
    }

    protected void onRecyclerViewAttached(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    protected void verifyIsNotPerformingClearMethod(String str) {
        if (this.mPerformingClearMethod) {
            throw new IllegalStateException(str + " can not be called while performing the clear() method");
        }
    }

    protected void verifyIsNotReleased(String str) {
        if (this.mReleased) {
            throw new IllegalStateException(str + " can not be called after release() method called");
        }
    }
}
