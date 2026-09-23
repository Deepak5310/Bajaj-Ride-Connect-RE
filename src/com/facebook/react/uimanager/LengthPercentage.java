package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LengthPercentage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/uimanager/LengthPercentage;", "", "()V", "value", "", "unit", "Lcom/facebook/react/uimanager/LengthPercentageType;", "(FLcom/facebook/react/uimanager/LengthPercentageType;)V", "getUnit", "()Lcom/facebook/react/uimanager/LengthPercentageType;", "resolve", "width", "height", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LengthPercentage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LengthPercentageType unit;
    private final float value;

    @JvmStatic
    public static final LengthPercentage setFromDynamic(Dynamic dynamic) {
        return INSTANCE.setFromDynamic(dynamic);
    }

    public LengthPercentage(float f, LengthPercentageType unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.value = f;
        this.unit = unit;
    }

    public final LengthPercentageType getUnit() {
        return this.unit;
    }

    /* JADX INFO: compiled from: LengthPercentage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/LengthPercentage$Companion;", "", "()V", "setFromDynamic", "Lcom/facebook/react/uimanager/LengthPercentage;", "dynamic", "Lcom/facebook/react/bridge/Dynamic;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: LengthPercentage.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.String.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LengthPercentage setFromDynamic(Dynamic dynamic) {
            Intrinsics.checkNotNullParameter(dynamic, "dynamic");
            int i = WhenMappings.$EnumSwitchMapping$0[dynamic.getType().ordinal()];
            if (i == 1) {
                double dAsDouble = dynamic.asDouble();
                if (dAsDouble >= 0.0d) {
                    return new LengthPercentage(PixelUtil.toPixelFromDIP(dAsDouble), LengthPercentageType.POINT);
                }
                return null;
            }
            if (i == 2) {
                String strAsString = dynamic.asString();
                if (StringsKt.endsWith$default(strAsString, "%", false, 2, (Object) null)) {
                    try {
                        String strSubstring = strAsString.substring(0, strAsString.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        float f = Float.parseFloat(strSubstring);
                        if (f >= 0.0f) {
                            return new LengthPercentage(f, LengthPercentageType.PERCENT);
                        }
                        return null;
                    } catch (NumberFormatException unused) {
                        FLog.w(ReactConstants.TAG, "Invalid percentage format: " + strAsString);
                        return null;
                    }
                }
                FLog.w(ReactConstants.TAG, "Invalid string value: " + strAsString);
                return null;
            }
            FLog.w(ReactConstants.TAG, "Unsupported type for radius property: " + dynamic.getType());
            return null;
        }
    }

    public final float resolve(float width, float height) {
        if (this.unit == LengthPercentageType.PERCENT) {
            return (this.value / 100) * Math.min(width, height);
        }
        return this.value;
    }

    public LengthPercentage() {
        this(0.0f, LengthPercentageType.POINT);
    }
}
