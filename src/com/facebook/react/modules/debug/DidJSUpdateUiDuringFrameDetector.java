package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LongArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DidJSUpdateUiDuringFrameDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;", "Lcom/facebook/react/bridge/NotThreadSafeBridgeIdleDebugListener;", "Lcom/facebook/react/uimanager/debug/NotThreadSafeViewHierarchyUpdateDebugListener;", "()V", "transitionToBusyEvents", "Lcom/facebook/react/common/LongArray;", "transitionToIdleEvents", "viewHierarchyUpdateEnqueuedEvents", "viewHierarchyUpdateFinishedEvents", "wasIdleAtEndOfLastFrame", "", "didEndFrameIdle", "startTime", "", "endTime", "getDidJSHitFrameAndCleanup", "frameStartTimeNanos", "frameEndTimeNanos", "onBridgeDestroyed", "", "onTransitionToBridgeBusy", "onTransitionToBridgeIdle", "onViewHierarchyUpdateEnqueued", "onViewHierarchyUpdateFinished", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DidJSUpdateUiDuringFrameDetector implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LongArray transitionToBusyEvents;
    private final LongArray transitionToIdleEvents;
    private final LongArray viewHierarchyUpdateEnqueuedEvents;
    private final LongArray viewHierarchyUpdateFinishedEvents;
    private volatile boolean wasIdleAtEndOfLastFrame;

    public DidJSUpdateUiDuringFrameDetector() {
        LongArray longArrayCreateWithInitialCapacity = LongArray.createWithInitialCapacity(20);
        Intrinsics.checkNotNullExpressionValue(longArrayCreateWithInitialCapacity, "createWithInitialCapacity(...)");
        this.transitionToIdleEvents = longArrayCreateWithInitialCapacity;
        LongArray longArrayCreateWithInitialCapacity2 = LongArray.createWithInitialCapacity(20);
        Intrinsics.checkNotNullExpressionValue(longArrayCreateWithInitialCapacity2, "createWithInitialCapacity(...)");
        this.transitionToBusyEvents = longArrayCreateWithInitialCapacity2;
        LongArray longArrayCreateWithInitialCapacity3 = LongArray.createWithInitialCapacity(20);
        Intrinsics.checkNotNullExpressionValue(longArrayCreateWithInitialCapacity3, "createWithInitialCapacity(...)");
        this.viewHierarchyUpdateEnqueuedEvents = longArrayCreateWithInitialCapacity3;
        LongArray longArrayCreateWithInitialCapacity4 = LongArray.createWithInitialCapacity(20);
        Intrinsics.checkNotNullExpressionValue(longArrayCreateWithInitialCapacity4, "createWithInitialCapacity(...)");
        this.viewHierarchyUpdateFinishedEvents = longArrayCreateWithInitialCapacity4;
        this.wasIdleAtEndOfLastFrame = true;
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onTransitionToBridgeIdle() {
        this.transitionToIdleEvents.add(System.nanoTime());
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onTransitionToBridgeBusy() {
        this.transitionToBusyEvents.add(System.nanoTime());
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onBridgeDestroyed() {
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public synchronized void onViewHierarchyUpdateEnqueued() {
        this.viewHierarchyUpdateEnqueuedEvents.add(System.nanoTime());
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public synchronized void onViewHierarchyUpdateFinished() {
        this.viewHierarchyUpdateFinishedEvents.add(System.nanoTime());
    }

    public final synchronized boolean getDidJSHitFrameAndCleanup(long frameStartTimeNanos, long frameEndTimeNanos) {
        boolean z;
        Companion companion = INSTANCE;
        boolean zHasEventBetweenTimestamps = companion.hasEventBetweenTimestamps(this.viewHierarchyUpdateFinishedEvents, frameStartTimeNanos, frameEndTimeNanos);
        boolean zDidEndFrameIdle = didEndFrameIdle(frameStartTimeNanos, frameEndTimeNanos);
        z = true;
        if (!zHasEventBetweenTimestamps && (!zDidEndFrameIdle || companion.hasEventBetweenTimestamps(this.viewHierarchyUpdateEnqueuedEvents, frameStartTimeNanos, frameEndTimeNanos))) {
            z = false;
        }
        companion.cleanUp(this.transitionToIdleEvents, frameEndTimeNanos);
        companion.cleanUp(this.transitionToBusyEvents, frameEndTimeNanos);
        companion.cleanUp(this.viewHierarchyUpdateEnqueuedEvents, frameEndTimeNanos);
        companion.cleanUp(this.viewHierarchyUpdateFinishedEvents, frameEndTimeNanos);
        this.wasIdleAtEndOfLastFrame = zDidEndFrameIdle;
        return z;
    }

    private final boolean didEndFrameIdle(long startTime, long endTime) {
        Companion companion = INSTANCE;
        long lastEventBetweenTimestamps = companion.getLastEventBetweenTimestamps(this.transitionToIdleEvents, startTime, endTime);
        long lastEventBetweenTimestamps2 = companion.getLastEventBetweenTimestamps(this.transitionToBusyEvents, startTime, endTime);
        if (lastEventBetweenTimestamps == -1 && lastEventBetweenTimestamps2 == -1) {
            return this.wasIdleAtEndOfLastFrame;
        }
        return lastEventBetweenTimestamps > lastEventBetweenTimestamps2;
    }

    /* JADX INFO: compiled from: DidJSUpdateUiDuringFrameDetector.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\r"}, d2 = {"Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector$Companion;", "", "()V", "cleanUp", "", "eventArray", "Lcom/facebook/react/common/LongArray;", "endTime", "", "getLastEventBetweenTimestamps", "startTime", "hasEventBetweenTimestamps", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean hasEventBetweenTimestamps(LongArray eventArray, long startTime, long endTime) {
            int size = eventArray.size();
            for (int i = 0; i < size; i++) {
                long j = eventArray.get(i);
                if (startTime <= j && j < endTime) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long getLastEventBetweenTimestamps(LongArray eventArray, long startTime, long endTime) {
            int size = eventArray.size();
            long j = -1;
            for (int i = 0; i < size; i++) {
                long j2 = eventArray.get(i);
                if (startTime > j2 || j2 >= endTime) {
                    if (j2 >= endTime) {
                        break;
                    }
                } else {
                    j = j2;
                }
            }
            return j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void cleanUp(LongArray eventArray, long endTime) {
            int size = eventArray.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (eventArray.get(i2) < endTime) {
                    i++;
                }
            }
            if (i > 0) {
                int i3 = size - i;
                for (int i4 = 0; i4 < i3; i4++) {
                    eventArray.set(i4, eventArray.get(i4 + i));
                }
                eventArray.dropTail(i);
            }
        }
    }
}
