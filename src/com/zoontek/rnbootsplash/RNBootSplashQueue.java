package com.zoontek.rnbootsplash;

import androidx.exifinterface.media.ExifInterface;
import java.util.Vector;
import kotlin.Metadata;

/* JADX INFO: compiled from: RNBootSplashQueue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\r\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/zoontek/rnbootsplash/RNBootSplashQueue;", ExifInterface.LONGITUDE_EAST, "Ljava/util/Vector;", "()V", "push", "", "item", "(Ljava/lang/Object;)V", "shift", "()Ljava/lang/Object;", "react-native-bootsplash_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RNBootSplashQueue<E> extends Vector<E> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i) {
        return (E) removeAt(i);
    }

    public /* bridge */ Object removeAt(int i) {
        return super.remove(i);
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public final synchronized E shift() {
        if (size() == 0) {
            return null;
        }
        E eElementAt = elementAt(0);
        removeElementAt(0);
        return eElementAt;
    }

    public final void push(E item) {
        addElement(item);
    }
}
