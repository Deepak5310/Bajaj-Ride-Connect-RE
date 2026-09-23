package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.graphics.drawable.Drawable;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.FilterHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.util.zzb$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BoxShadowDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/react/uimanager/drawable/BoxShadowDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", AppStateModule.APP_STATE_BACKGROUND, "Lcom/facebook/react/uimanager/drawable/CSSBackgroundDrawable;", ViewProps.SHADOW_COLOR, "", "offsetX", "", "offsetY", "blurRadius", "spread", "(Landroid/content/Context;Lcom/facebook/react/uimanager/drawable/CSSBackgroundDrawable;IFFFF)V", "renderNode", "Landroid/graphics/RenderNode;", "shadowShapeDrawable", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BoxShadowDrawable extends Drawable {
    private final CSSBackgroundDrawable background;
    private final float offsetX;
    private final float offsetY;
    private final RenderNode renderNode;
    private final CSSBackgroundDrawable shadowShapeDrawable;
    private final float spread;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public BoxShadowDrawable(Context context, CSSBackgroundDrawable background, int i, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(background, "background");
        this.background = background;
        this.offsetX = f;
        this.offsetY = f2;
        this.spread = f4;
        CSSBackgroundDrawable cSSBackgroundDrawable = new CSSBackgroundDrawable(context);
        cSSBackgroundDrawable.setColor(i);
        this.shadowShapeDrawable = cSSBackgroundDrawable;
        RenderNode renderNodeM = zzb$$ExternalSyntheticApiModelOutline0.m("BoxShadowDrawable");
        renderNodeM.setClipToBounds(false);
        renderNodeM.setRenderEffect(FilterHelper.createBlurEffect$default(FilterHelper.INSTANCE, f3 * 0.5f, null, 2, null));
        this.renderNode = renderNodeM;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!canvas.isHardwareAccelerated()) {
            FLog.w("BoxShadowDrawable", "BoxShadowDrawable requires a hardware accelerated canvas");
            return;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToInt(PixelUtil.toPixelFromDIP(this.spread)), 0);
        Rect rect = new Rect(getBounds());
        int i = -iCoerceAtLeast;
        rect.inset(i, i);
        Rect rect2 = new Rect(0, 0, rect.width(), rect.height());
        if (!Intrinsics.areEqual(this.shadowShapeDrawable.getBounds(), rect2) || this.shadowShapeDrawable.getLayoutDirection() != getLayoutDirection() || !Intrinsics.areEqual(this.shadowShapeDrawable.getBorderRadius(), this.background.getBorderRadius()) || !Intrinsics.areEqual(this.shadowShapeDrawable.getColorFilter(), getColorFilter())) {
            this.shadowShapeDrawable.setBounds(rect2);
            this.shadowShapeDrawable.setLayoutDirection(getLayoutDirection());
            this.shadowShapeDrawable.setBorderRadius(this.background.getBorderRadius());
            this.shadowShapeDrawable.setColorFilter(getColorFilter());
            RenderNode renderNode = this.renderNode;
            Rect rect3 = new Rect(rect);
            rect3.offset(MathKt.roundToInt(PixelUtil.toPixelFromDIP(this.offsetX)), MathKt.roundToInt(PixelUtil.toPixelFromDIP(this.offsetY)));
            renderNode.setPosition(rect3);
            this.shadowShapeDrawable.draw(renderNode.beginRecording());
            renderNode.endRecording();
        }
        Path borderBoxPath = this.background.getBorderBoxPath();
        if (borderBoxPath != null) {
            canvas.clipOutPath(borderBoxPath);
        } else {
            canvas.clipOutRect(this.background.getBorderBoxRect());
        }
        canvas.drawRenderNode(this.renderNode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.renderNode.setAlpha(alpha / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return MathKt.roundToInt(this.renderNode.getAlpha() * 255);
    }
}
