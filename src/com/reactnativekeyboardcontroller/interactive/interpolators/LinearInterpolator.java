package com.reactnativekeyboardcontroller.interactive.interpolators;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: LinearInterpolator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/reactnativekeyboardcontroller/interactive/interpolators/LinearInterpolator;", "Lcom/reactnativekeyboardcontroller/interactive/interpolators/Interpolator;", "()V", "interpolate", "", "dy", "absoluteFingerPosition", "keyboardPosition", TypedValues.CycleType.S_WAVE_OFFSET, "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LinearInterpolator implements Interpolator {
    @Override // com.reactnativekeyboardcontroller.interactive.interpolators.Interpolator
    public int interpolate(int dy, int absoluteFingerPosition, int keyboardPosition, int offset) {
        return dy;
    }
}
