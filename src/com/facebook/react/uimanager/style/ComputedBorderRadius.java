package com.facebook.react.uimanager.style;

import kotlin.Metadata;

/* JADX INFO: compiled from: ComputedBorderRadius.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0016\u001a\u00020\u0014J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/facebook/react/uimanager/style/ComputedBorderRadius;", "", "()V", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "getBottomRight", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hasRoundedBorders", "hashCode", "", "toString", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ComputedBorderRadius {
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    public static /* synthetic */ ComputedBorderRadius copy$default(ComputedBorderRadius computedBorderRadius, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = computedBorderRadius.topLeft;
        }
        if ((i & 2) != 0) {
            f2 = computedBorderRadius.topRight;
        }
        if ((i & 4) != 0) {
            f3 = computedBorderRadius.bottomLeft;
        }
        if ((i & 8) != 0) {
            f4 = computedBorderRadius.bottomRight;
        }
        return computedBorderRadius.copy(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getTopLeft() {
        return this.topLeft;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getTopRight() {
        return this.topRight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getBottomLeft() {
        return this.bottomLeft;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getBottomRight() {
        return this.bottomRight;
    }

    public final ComputedBorderRadius copy(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        return new ComputedBorderRadius(topLeft, topRight, bottomLeft, bottomRight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComputedBorderRadius)) {
            return false;
        }
        ComputedBorderRadius computedBorderRadius = (ComputedBorderRadius) other;
        return Float.compare(this.topLeft, computedBorderRadius.topLeft) == 0 && Float.compare(this.topRight, computedBorderRadius.topRight) == 0 && Float.compare(this.bottomLeft, computedBorderRadius.bottomLeft) == 0 && Float.compare(this.bottomRight, computedBorderRadius.bottomRight) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.topLeft) * 31) + Float.hashCode(this.topRight)) * 31) + Float.hashCode(this.bottomLeft)) * 31) + Float.hashCode(this.bottomRight);
    }

    public String toString() {
        return "ComputedBorderRadius(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ")";
    }

    public ComputedBorderRadius(float f, float f2, float f3, float f4) {
        this.topLeft = f;
        this.topRight = f2;
        this.bottomLeft = f3;
        this.bottomRight = f4;
    }

    public final float getTopLeft() {
        return this.topLeft;
    }

    public final float getTopRight() {
        return this.topRight;
    }

    public final float getBottomLeft() {
        return this.bottomLeft;
    }

    public final float getBottomRight() {
        return this.bottomRight;
    }

    public final boolean hasRoundedBorders() {
        return this.topLeft > 0.0f || this.topRight > 0.0f || this.bottomLeft > 0.0f || this.bottomRight > 0.0f;
    }

    public ComputedBorderRadius() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
