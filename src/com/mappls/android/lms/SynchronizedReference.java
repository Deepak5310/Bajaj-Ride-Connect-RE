package com.mappls.android.lms;

/* JADX INFO: loaded from: classes6.dex */
class SynchronizedReference<T> {
    private T mContents = null;

    public synchronized T get() {
        return this.mContents;
    }

    public synchronized T getAndClear() {
        T t;
        t = this.mContents;
        this.mContents = null;
        return t;
    }

    public synchronized void set(T t) {
        this.mContents = t;
    }
}
