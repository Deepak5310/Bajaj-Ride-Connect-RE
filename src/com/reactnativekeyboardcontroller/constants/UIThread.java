package com.reactnativekeyboardcontroller.constants;

import kotlin.Metadata;

/* JADX INFO: compiled from: UIThread.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reactnativekeyboardcontroller/constants/UIThread;", "", "()V", "FPS", "", "MILLISECONDS_IN_SECOND", "", "NEXT_FRAME", "", "getNEXT_FRAME", "()J", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UIThread {
    public static final int FPS = 60;
    public static final double MILLISECONDS_IN_SECOND = 1000.0d;
    public static final UIThread INSTANCE = new UIThread();
    private static final long NEXT_FRAME = (long) Math.floor(16.666666666666668d);

    private UIThread() {
    }

    public final long getNEXT_FRAME() {
        return NEXT_FRAME;
    }
}
