package com.mappls.sdk.navigation.ui.views.turnlane;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.Stack;

/* JADX INFO: loaded from: classes4.dex */
public class LanesStyleKit {

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.views.turnlane.LanesStyleKit$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mappls$sdk$navigation$ui$views$turnlane$LanesStyleKit$ResizingBehavior;

        static {
            int[] iArr = new int[ResizingBehavior.values().length];
            $SwitchMap$com$mappls$sdk$navigation$ui$views$turnlane$LanesStyleKit$ResizingBehavior = iArr;
            try {
                iArr[ResizingBehavior.AspectFit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mappls$sdk$navigation$ui$views$turnlane$LanesStyleKit$ResizingBehavior[ResizingBehavior.AspectFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mappls$sdk$navigation$ui$views$turnlane$LanesStyleKit$ResizingBehavior[ResizingBehavior.Center.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static class CacheForLaneRight {
        private static Paint paint = new Paint();
        private static RectF originalFrame = new RectF(0.0f, 0.0f, 30.0f, 30.0f);
        private static RectF resizedFrame = new RectF();
        private static RectF frame = new RectF();
        private static RectF group = new RectF();
        private static RectF bezierRect = new RectF();
        private static Path bezierPath = new Path();
        private static RectF bezier2Rect = new RectF();
        private static Path bezier2Path = new Path();

        private CacheForLaneRight() {
        }
    }

    private static class CacheForLaneRightOnly {
        private static Paint paint = new Paint();
        private static RectF originalFrame = new RectF(0.0f, 0.0f, 30.0f, 30.0f);
        private static RectF resizedFrame = new RectF();
        private static RectF frame = new RectF();
        private static RectF group = new RectF();
        private static RectF rectangleRect = new RectF();
        private static Path rectanglePath = new Path();
        private static RectF bezierRect = new RectF();
        private static Path bezierPath = new Path();
        private static RectF bezier2Rect = new RectF();
        private static Path bezier2Path = new Path();
        private static RectF bezier3Rect = new RectF();
        private static Path bezier3Path = new Path();

        private CacheForLaneRightOnly() {
        }
    }

    private static class CacheForLaneSlightRight {
        private static Paint paint = new Paint();
        private static RectF originalFrame = new RectF(0.0f, 0.0f, 30.0f, 30.0f);
        private static RectF resizedFrame = new RectF();
        private static RectF frame = new RectF();
        private static RectF bezier3Rect = new RectF();
        private static Path bezier3Path = new Path();
        private static RectF bezierRect = new RectF();
        private static Path bezierPath = new Path();

        private CacheForLaneSlightRight() {
        }
    }

    private static class CacheForLaneStraight {
        private static Paint paint = new Paint();
        private static RectF originalFrame = new RectF(0.0f, 0.0f, 30.0f, 30.0f);
        private static RectF resizedFrame = new RectF();
        private static RectF frame = new RectF();
        private static RectF group = new RectF();
        private static RectF rectangleRect = new RectF();
        private static Path rectanglePath = new Path();
        private static RectF bezierRect = new RectF();
        private static Path bezierPath = new Path();

        private CacheForLaneStraight() {
        }
    }

    private static class CacheForLaneStraightOnly {
        private static Paint paint = new Paint();
        private static RectF originalFrame = new RectF(0.0f, 0.0f, 30.0f, 30.0f);
        private static RectF resizedFrame = new RectF();
        private static RectF frame = new RectF();
        private static RectF group = new RectF();
        private static RectF bezier2Rect = new RectF();
        private static Path bezier2Path = new Path();
        private static RectF bezier3Rect = new RectF();
        private static Path bezier3Path = new Path();
        private static RectF rectangleRect = new RectF();
        private static Path rectanglePath = new Path();
        private static RectF bezierRect = new RectF();
        private static Path bezierPath = new Path();

        private CacheForLaneStraightOnly() {
        }
    }

    private static class CacheForLaneStraightRight {
        private static Paint paint = new Paint();
        private static RectF originalFrame = new RectF(0.0f, 0.0f, 30.0f, 30.0f);
        private static RectF resizedFrame = new RectF();
        private static RectF frame = new RectF();
        private static RectF group = new RectF();
        private static RectF rectangleRect = new RectF();
        private static Path rectanglePath = new Path();
        private static RectF bezierRect = new RectF();
        private static Path bezierPath = new Path();
        private static RectF bezier2Rect = new RectF();
        private static Path bezier2Path = new Path();
        private static RectF bezier3Rect = new RectF();
        private static Path bezier3Path = new Path();

        private CacheForLaneStraightRight() {
        }
    }

    private static class CacheForLaneUturn {
        private static Paint paint = new Paint();
        private static RectF originalFrame = new RectF(0.0f, 0.0f, 30.0f, 30.0f);
        private static RectF resizedFrame = new RectF();
        private static RectF frame = new RectF();
        private static RectF group = new RectF();
        private static RectF bezierRect = new RectF();
        private static Path bezierPath = new Path();
        private static RectF bezier2Rect = new RectF();
        private static Path bezier2Path = new Path();

        private CacheForLaneUturn() {
        }
    }

    public enum ResizingBehavior {
        AspectFit,
        AspectFill,
        Stretch,
        Center
    }

    public static void drawLaneRight(Canvas canvas, int i, PointF pointF) {
        drawLaneRight(canvas, new RectF(0.0f, 0.0f, 30.0f, 30.0f), ResizingBehavior.AspectFit, i, pointF);
    }

    public static void drawLaneRight(Canvas canvas, RectF rectF, ResizingBehavior resizingBehavior, int i, PointF pointF) {
        Stack stack = new Stack();
        stack.push(new Matrix());
        Paint paint = CacheForLaneRight.paint;
        float fMin = Math.min(pointF.x / 30.0f, pointF.y / 30.0f);
        canvas.save();
        RectF rectF2 = CacheForLaneRight.resizedFrame;
        resizingBehaviorApply(resizingBehavior, CacheForLaneRight.originalFrame, rectF, rectF2);
        canvas.translate(rectF2.left, rectF2.top);
        canvas.scale(rectF2.width() / 30.0f, rectF2.height() / 30.0f);
        CacheForLaneRight.frame.set(0.0f, 0.0f, pointF.x, pointF.y);
        RectF rectF3 = CacheForLaneRight.group;
        rectF3.set(0.0f, 0.0f, 14.85f, 23.0f);
        canvas.save();
        canvas.translate(9.0f, 4.0f);
        ((Matrix) stack.peek()).postTranslate(9.0f, 4.0f);
        canvas.scale(fMin, fMin);
        ((Matrix) stack.peek()).postScale(fMin, fMin);
        CacheForLaneRight.bezierRect.set(5.87f, 0.0f, 14.85f, 12.02f);
        Path path = CacheForLaneRight.bezierPath;
        path.reset();
        path.moveTo(b.a(rectF3, 0.50217f, rectF3.left), (rectF3.height() * 1.4E-4f) + rectF3.top);
        path.cubicTo(b.a(rectF3, 0.50834f, rectF3.left), a.a(rectF3, 7.0E-5f, rectF3.top), b.a(rectF3, 0.51727f, rectF3.left), a.a(rectF3, 0.0027f, rectF3.top), b.a(rectF3, 0.52351f, rectF3.left), a.a(rectF3, 0.00697f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.53419f, rectF3.left), a.a(rectF3, 0.01264f, rectF3.top), rectF3.width() + rectF3.left, a.a(rectF3, 0.26153f, rectF3.top), rectF3.width() + rectF3.left, a.a(rectF3, 0.26153f, rectF3.top));
        path.cubicTo(rectF3.width() + rectF3.left, a.a(rectF3, 0.26153f, rectF3.top), b.a(rectF3, 0.53007f, rectF3.left), a.a(rectF3, 0.50996f, rectF3.top), b.a(rectF3, 0.51955f, rectF3.left), a.a(rectF3, 0.51553f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.51301f, rectF3.left), a.a(rectF3, 0.51993f, rectF3.top), b.a(rectF3, 0.50386f, rectF3.left), a.a(rectF3, 0.52258f, rectF3.top), b.a(rectF3, 0.49391f, rectF3.left), a.a(rectF3, 0.52258f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.47472f, rectF3.left), a.a(rectF3, 0.52258f, rectF3.top), b.a(rectF3, 0.45924f, rectF3.left), a.a(rectF3, 0.51254f, rectF3.top), b.a(rectF3, 0.45924f, rectF3.left), a.a(rectF3, 0.50014f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.45924f, rectF3.left), a.a(rectF3, 0.49721f, rectF3.top), b.a(rectF3, 0.46007f, rectF3.left), a.a(rectF3, 0.4944f, rectF3.top), b.a(rectF3, 0.46169f, rectF3.left), a.a(rectF3, 0.49183f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.46455f, rectF3.left), a.a(rectF3, 0.48682f, rectF3.top), b.a(rectF3, 0.52572f, rectF3.left), a.a(rectF3, 0.37804f, rectF3.top), b.a(rectF3, 0.52837f, rectF3.left), a.a(rectF3, 0.37334f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.52866f, rectF3.left), a.a(rectF3, 0.35658f, rectF3.top), b.a(rectF3, 0.5129f, rectF3.left), a.a(rectF3, 0.34823f, rectF3.top), b.a(rectF3, 0.49331f, rectF3.left), a.a(rectF3, 0.34823f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.48889f, rectF3.left), a.a(rectF3, 0.34823f, rectF3.top), b.a(rectF3, 0.48416f, rectF3.left), a.a(rectF3, 0.34806f, rectF3.top), b.a(rectF3, 0.48011f, rectF3.left), a.a(rectF3, 0.34805f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.4746f, rectF3.left), a.a(rectF3, 0.34798f, rectF3.top), b.a(rectF3, 0.39493f, rectF3.left), a.a(rectF3, 0.34818f, rectF3.top), b.a(rectF3, 0.39493f, rectF3.left), a.a(rectF3, 0.34818f, rectF3.top));
        c.a(rectF3, 0.1744f, rectF3.top, path, b.a(rectF3, 0.39911f, rectF3.left));
        path.cubicTo(b.a(rectF3, 0.39911f, rectF3.left), a.a(rectF3, 0.1744f, rectF3.top), b.a(rectF3, 0.4782f, rectF3.left), a.a(rectF3, 0.1746f, rectF3.top), b.a(rectF3, 0.48401f, rectF3.left), a.a(rectF3, 0.17461f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.48839f, rectF3.left), a.a(rectF3, 0.17452f, rectF3.top), b.a(rectF3, 0.49309f, rectF3.left), a.a(rectF3, 0.17435f, rectF3.top), b.a(rectF3, 0.49748f, rectF3.left), a.a(rectF3, 0.17435f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.51708f, rectF3.left), a.a(rectF3, 0.17435f, rectF3.top), b.a(rectF3, 0.53283f, rectF3.left), a.a(rectF3, 0.166f, rectF3.top), b.a(rectF3, 0.53283f, rectF3.left), a.a(rectF3, 0.15335f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.5299f, rectF3.left), a.a(rectF3, 0.14453f, rectF3.top), b.a(rectF3, 0.46873f, rectF3.left), a.a(rectF3, 0.03576f, rectF3.top), b.a(rectF3, 0.466f, rectF3.left), a.a(rectF3, 0.03091f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.46431f, rectF3.left), a.a(rectF3, 0.02818f, rectF3.top), b.a(rectF3, 0.46341f, rectF3.left), a.a(rectF3, 0.02537f, rectF3.top), b.a(rectF3, 0.46341f, rectF3.left), a.a(rectF3, 0.02243f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.46341f, rectF3.left), a.a(rectF3, 0.01013f, rectF3.top), b.a(rectF3, 0.47875f, rectF3.left), a.a(rectF3, 1.4E-4f, rectF3.top), b.a(rectF3, 0.49775f, rectF3.left), rectF3.top);
        path.lineTo(b.a(rectF3, 0.50217f, rectF3.left), (rectF3.height() * 1.4E-4f) + rectF3.top);
        path.close();
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path, paint);
        CacheForLaneRight.bezier2Rect.set(0.0f, 6.03f, 11.03f, 23.0f);
        Path path2 = CacheForLaneRight.bezier2Path;
        path2.reset();
        path2.moveTo(rectF3.left, (rectF3.height() * 1.0f) + rectF3.top);
        c.a(rectF3, 0.41572f, rectF3.top, path2, b.a(rectF3, 0.00417f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.00417f, rectF3.left), a.a(rectF3, 0.41572f, rectF3.top), b.a(rectF3, 0.02316f, rectF3.left), a.a(rectF3, 0.26219f, rectF3.top), b.a(rectF3, 0.26516f, rectF3.left), a.a(rectF3, 0.26219f, rectF3.top));
        path2.lineTo(b.a(rectF3, 0.74277f, rectF3.left), (rectF3.height() * 0.26219f) + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeMiter(10.0f);
        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        canvas.drawPath(path2, paint);
        canvas.restore();
        canvas.restore();
        canvas.restore();
    }

    public static void drawLaneRightOnly(Canvas canvas, int i, int i2, PointF pointF) {
        drawLaneRightOnly(canvas, new RectF(0.0f, 0.0f, 30.0f, 30.0f), ResizingBehavior.AspectFit, i, i2, pointF);
    }

    public static void drawLaneRightOnly(Canvas canvas, RectF rectF, ResizingBehavior resizingBehavior, int i, int i2, PointF pointF) {
        Stack stack = new Stack();
        stack.push(new Matrix());
        Paint paint = CacheForLaneRightOnly.paint;
        float fMin = Math.min(pointF.x / 30.0f, pointF.y / 30.0f);
        canvas.save();
        RectF rectF2 = CacheForLaneRightOnly.resizedFrame;
        resizingBehaviorApply(resizingBehavior, CacheForLaneRightOnly.originalFrame, rectF, rectF2);
        canvas.translate(rectF2.left, rectF2.top);
        canvas.scale(rectF2.width() / 30.0f, rectF2.height() / 30.0f);
        CacheForLaneRightOnly.frame.set(0.0f, 0.0f, pointF.x, pointF.y);
        RectF rectF3 = CacheForLaneRightOnly.group;
        rectF3.set(0.0f, 0.0f, 21.97f, 25.0f);
        canvas.save();
        canvas.translate(5.0f, 2.0f);
        ((Matrix) stack.peek()).postTranslate(5.0f, 2.0f);
        canvas.scale(fMin, fMin);
        ((Matrix) stack.peek()).postScale(fMin, fMin);
        RectF rectF4 = CacheForLaneRightOnly.rectangleRect;
        rectF4.set(4.0f, 9.0f, 8.0f, 25.0f);
        Path path = CacheForLaneRightOnly.rectanglePath;
        path.reset();
        path.moveTo(rectF4.left, rectF4.top);
        path.lineTo(rectF4.right, rectF4.top);
        path.lineTo(rectF4.right, rectF4.bottom);
        path.lineTo(rectF4.left, rectF4.bottom);
        path.close();
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i2);
        canvas.drawPath(path, paint);
        CacheForLaneRightOnly.bezierRect.set(0.0f, 0.0f, 12.02f, 9.99f);
        Path path2 = CacheForLaneRightOnly.bezierPath;
        path2.reset();
        path2.moveTo(b.a(rectF3, 0.27386f, rectF3.left), (rectF3.height() * 1.1E-4f) + rectF3.top);
        path2.cubicTo(b.a(rectF3, 0.2756f, rectF3.left), a.a(rectF3, 0.00224f, rectF3.top), b.a(rectF3, 0.53413f, rectF3.left), a.a(rectF3, 0.31865f, rectF3.top), b.a(rectF3, 0.53965f, rectF3.left), a.a(rectF3, 0.3254f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.54425f, rectF3.left), a.a(rectF3, 0.32928f, rectF3.top), b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.33472f, rectF3.top), b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.34063f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.35203f, rectF3.top), b.a(rectF3, 0.53651f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top), b.a(rectF3, 0.52354f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.52046f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top), b.a(rectF3, 0.51752f, rectF3.left), a.a(rectF3, 0.36073f, rectF3.top), b.a(rectF3, 0.51483f, rectF3.left), a.a(rectF3, 0.35977f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.50959f, rectF3.left), a.a(rectF3, 0.35807f, rectF3.top), b.a(rectF3, 0.39573f, rectF3.left), a.a(rectF3, 0.32173f, rectF3.top), b.a(rectF3, 0.3908f, rectF3.left), a.a(rectF3, 0.32016f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.37325f, rectF3.left), a.a(rectF3, 0.31999f, rectF3.top), b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.32935f, rectF3.top), b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.34099f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.34361f, rectF3.top), b.a(rectF3, 0.36434f, rectF3.left), a.a(rectF3, 0.34642f, rectF3.top), b.a(rectF3, 0.36433f, rectF3.left), a.a(rectF3, 0.34883f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.36425f, rectF3.left), a.a(rectF3, 0.3521f, rectF3.top), b.a(rectF3, 0.36447f, rectF3.left), a.a(rectF3, 0.39943f, rectF3.top), b.a(rectF3, 0.36447f, rectF3.left), a.a(rectF3, 0.39943f, rectF3.top));
        c.a(rectF3, 0.39695f, rectF3.top, path2, b.a(rectF3, 0.18255f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.18255f, rectF3.left), a.a(rectF3, 0.39695f, rectF3.top), b.a(rectF3, 0.18276f, rectF3.left), a.a(rectF3, 0.34996f, rectF3.top), b.a(rectF3, 0.18278f, rectF3.left), a.a(rectF3, 0.34651f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.18268f, rectF3.left), a.a(rectF3, 0.34391f, rectF3.top), b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.34112f, rectF3.top), b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.33851f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.32687f, rectF3.top), b.a(rectF3, 0.17377f, rectF3.left), a.a(rectF3, 0.31751f, rectF3.top), b.a(rectF3, 0.16052f, rectF3.left), a.a(rectF3, 0.31751f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.15129f, rectF3.left), a.a(rectF3, 0.31925f, rectF3.top), b.a(rectF3, 0.03743f, rectF3.left), a.a(rectF3, 0.35559f, rectF3.top), b.a(rectF3, 0.03235f, rectF3.left), a.a(rectF3, 0.35721f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.0295f, rectF3.left), a.a(rectF3, 0.35821f, rectF3.top), b.a(rectF3, 0.02656f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top), b.a(rectF3, 0.02348f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.0106f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top), b.a(rectF3, 1.4E-4f, rectF3.left), a.a(rectF3, 0.34964f, rectF3.top), rectF3.left, a.a(rectF3, 0.33835f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 7.0E-5f, rectF3.left), a.a(rectF3, 0.33206f, rectF3.top), b.a(rectF3, 0.00283f, rectF3.left), a.a(rectF3, 0.32675f, rectF3.top), b.a(rectF3, 0.0073f, rectF3.left), a.a(rectF3, 0.32305f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.01291f, rectF3.left), a.a(rectF3, 0.3162f, rectF3.top), b.a(rectF3, 0.27191f, rectF3.left), a.a(rectF3, 0.00224f, rectF3.top), b.a(rectF3, 0.27375f, rectF3.left), rectF3.top);
        path2.lineTo(b.a(rectF3, 0.27386f, rectF3.left), (rectF3.height() * 1.1E-4f) + rectF3.top);
        path2.close();
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i2);
        canvas.drawPath(path2, paint);
        CacheForLaneRightOnly.bezier2Rect.set(12.99f, 8.58f, 21.97f, 20.6f);
        Path path3 = CacheForLaneRightOnly.bezier2Path;
        path3.reset();
        path3.moveTo(b.a(rectF3, 0.59384f, rectF3.left), (rectF3.height() * 0.50353f) + rectF3.top);
        c.a(rectF3, 0.50373f, rectF3.top, path3, b.a(rectF3, 0.65146f, rectF3.left));
        c.a(rectF3, 0.50365f, rectF3.top, path3, b.a(rectF3, 0.65123f, rectF3.left));
        path3.cubicTo(b.a(rectF3, 0.65401f, rectF3.left), a.a(rectF3, 0.50365f, rectF3.top), b.a(rectF3, 0.65729f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top), b.a(rectF3, 0.66034f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.67358f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top), b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.49581f, rectF3.top), b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.48417f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.48297f, rectF3.top), b.a(rectF3, 0.68418f, rectF3.left), a.a(rectF3, 0.48153f, rectF3.top), b.a(rectF3, 0.68396f, rectF3.left), a.a(rectF3, 0.48041f, rectF3.top));
        c.a(rectF3, 0.48053f, rectF3.top, path3, b.a(rectF3, 0.68409f, rectF3.left));
        c.a(rectF3, 0.37137f, rectF3.top, path3, b.a(rectF3, 0.63899f, rectF3.left));
        c.a(rectF3, 0.37153f, rectF3.top, path3, b.a(rectF3, 0.63904f, rectF3.left));
        path3.cubicTo(b.a(rectF3, 0.63794f, rectF3.left), a.a(rectF3, 0.36913f, rectF3.top), b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.36649f, rectF3.top), b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.36373f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.35233f, rectF3.top), b.a(rectF3, 0.64782f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top), b.a(rectF3, 0.66079f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.66757f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top), b.a(rectF3, 0.67376f, rectF3.left), a.a(rectF3, 0.34557f, rectF3.top), b.a(rectF3, 0.67804f, rectF3.left), a.a(rectF3, 0.34961f, rectF3.top));
        c.a(rectF3, 0.34949f, rectF3.top, path3, b.a(rectF3, 0.67795f, rectF3.left));
        c.a(rectF3, 0.58369f, rectF3.top, path3, b.a(rectF3, 1.0f, rectF3.left));
        c.a(rectF3, 0.81745f, rectF3.top, path3, b.a(rectF3, 0.67513f, rectF3.left));
        c.a(rectF3, 0.81733f, rectF3.top, path3, b.a(rectF3, 0.67522f, rectF3.left));
        path3.cubicTo(b.a(rectF3, 0.67094f, rectF3.left), a.a(rectF3, 0.82137f, rectF3.top), b.a(rectF3, 0.6647f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top), b.a(rectF3, 0.65792f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.64495f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top), b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.81461f, rectF3.top), b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.80321f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.80045f, rectF3.top), b.a(rectF3, 0.63508f, rectF3.left), a.a(rectF3, 0.79781f, rectF3.top), b.a(rectF3, 0.63621f, rectF3.left), a.a(rectF3, 0.79541f, rectF3.top));
        c.a(rectF3, 0.79557f, rectF3.top, path3, b.a(rectF3, 0.63617f, rectF3.left));
        c.a(rectF3, 0.68641f, rectF3.top, path3, b.a(rectF3, 0.68127f, rectF3.left));
        c.a(rectF3, 0.68653f, rectF3.top, path3, b.a(rectF3, 0.68113f, rectF3.left));
        path3.cubicTo(b.a(rectF3, 0.68132f, rectF3.left), a.a(rectF3, 0.68541f, rectF3.top), b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.68397f, rectF3.top), b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.68277f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.67113f, rectF3.top), b.a(rectF3, 0.67076f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top), b.a(rectF3, 0.65751f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.65446f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top), b.a(rectF3, 0.65119f, rectF3.left), a.a(rectF3, 0.66329f, rectF3.top), b.a(rectF3, 0.64841f, rectF3.left), a.a(rectF3, 0.66329f, rectF3.top));
        c.a(rectF3, 0.66321f, rectF3.top, path3, b.a(rectF3, 0.64859f, rectF3.left));
        path3.lineTo(b.a(rectF3, 0.59102f, rectF3.left), (rectF3.height() * 0.66341f) + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        path3.setFillType(Path.FillType.EVEN_ODD);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path3, paint);
        CacheForLaneRightOnly.bezier3Rect.set(6.03f, 14.61f, 15.03f, 25.0f);
        Path path4 = CacheForLaneRightOnly.bezier3Path;
        path4.reset();
        path4.moveTo(b.a(rectF3, 0.27429f, rectF3.left), rectF3.height() + rectF3.top);
        c.a(rectF3, 0.83475f, rectF3.top, path4, b.a(rectF3, 0.27429f, rectF3.left));
        path4.cubicTo(b.a(rectF3, 0.27429f, rectF3.left), a.a(rectF3, 0.76907f, rectF3.top), b.a(rectF3, 0.30633f, rectF3.left), a.a(rectF3, 0.70583f, rectF3.top), b.a(rectF3, 0.36427f, rectF3.left), a.a(rectF3, 0.66431f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.42007f, rectF3.left), a.a(rectF3, 0.62431f, rectF3.top), b.a(rectF3, 0.49758f, rectF3.left), a.a(rectF3, 0.58431f, rectF3.top), b.a(rectF3, 0.58433f, rectF3.left), a.a(rectF3, 0.58431f, rectF3.top));
        path4.lineTo(b.a(rectF3, 0.68391f, rectF3.left), (rectF3.height() * 0.58431f) + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeMiter(10.0f);
        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        canvas.drawPath(path4, paint);
        canvas.restore();
        canvas.restore();
        canvas.restore();
    }

    public static void drawLaneSlightRight(Canvas canvas, int i, PointF pointF) {
        drawLaneSlightRight(canvas, new RectF(0.0f, 0.0f, 30.0f, 30.0f), ResizingBehavior.AspectFit, i, pointF);
    }

    public static void drawLaneSlightRight(Canvas canvas, RectF rectF, ResizingBehavior resizingBehavior, int i, PointF pointF) {
        Stack stack = new Stack();
        stack.push(new Matrix());
        Paint paint = CacheForLaneSlightRight.paint;
        float fMin = Math.min(pointF.x / 30.0f, pointF.y / 30.0f);
        canvas.save();
        RectF rectF2 = CacheForLaneSlightRight.resizedFrame;
        resizingBehaviorApply(resizingBehavior, CacheForLaneSlightRight.originalFrame, rectF, rectF2);
        canvas.translate(rectF2.left, rectF2.top);
        canvas.scale(rectF2.width() / 30.0f, rectF2.height() / 30.0f);
        CacheForLaneSlightRight.frame.set(0.0f, 0.0f, pointF.x, pointF.y);
        canvas.save();
        canvas.translate(9.28f, -0.86f);
        ((Matrix) stack.peek()).postTranslate(9.28f, -0.86f);
        canvas.scale(fMin, fMin);
        ((Matrix) stack.peek()).postScale(fMin, fMin);
        CacheForLaneSlightRight.bezier3Rect.set(0.0f, 10.61f, 7.17f, 27.6f);
        Path path = CacheForLaneSlightRight.bezier3Path;
        path.reset();
        path.moveTo(7.17f, 10.61f);
        path.lineTo(1.47f, 15.89f);
        path.cubicTo(0.6f, 17.21f, 0.0f, 18.82f, 0.0f, 20.47f);
        path.lineTo(0.0f, 27.6f);
        paint.reset();
        paint.setFlags(1);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeMiter(10.0f);
        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        canvas.drawPath(path, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(10.25f, 0.0f);
        ((Matrix) stack.peek()).postTranslate(10.25f, 0.0f);
        canvas.rotate(49.0f);
        ((Matrix) stack.peek()).postRotate(49.0f);
        CacheForLaneSlightRight.bezierRect.set(0.0f, 0.0f, 12.02f, 9.99f);
        Path path2 = CacheForLaneSlightRight.bezierPath;
        path2.reset();
        path2.moveTo(4.01f, 9.92f);
        path2.lineTo(4.02f, 8.66f);
        path2.lineTo(4.01f, 8.66f);
        path2.cubicTo(4.01f, 8.6f, 4.01f, 8.53f, 4.01f, 8.46f);
        path2.cubicTo(4.01f, 8.17f, 3.82f, 7.94f, 3.53f, 7.94f);
        path2.cubicTo(3.5f, 7.94f, 3.46f, 7.94f, 3.43f, 7.94f);
        path2.lineTo(3.44f, 7.94f);
        path2.lineTo(0.71f, 8.93f);
        path2.lineTo(0.71f, 8.93f);
        path2.cubicTo(0.65f, 8.96f, 0.58f, 8.97f, 0.52f, 8.97f);
        path2.cubicTo(0.23f, 8.97f, 0.0f, 8.74f, 0.0f, 8.45f);
        path2.cubicTo(0.0f, 8.3f, 0.06f, 8.17f, 0.16f, 8.07f);
        path2.lineTo(0.16f, 8.08f);
        path2.lineTo(6.02f, 0.0f);
        path2.lineTo(11.86f, 8.14f);
        path2.lineTo(11.86f, 8.14f);
        path2.cubicTo(11.96f, 8.23f, 12.02f, 8.37f, 12.02f, 8.52f);
        path2.cubicTo(12.02f, 8.8f, 11.79f, 9.03f, 11.5f, 9.03f);
        path2.cubicTo(11.43f, 9.03f, 11.37f, 9.02f, 11.31f, 8.99f);
        path2.lineTo(11.31f, 8.99f);
        path2.lineTo(8.58f, 8.0f);
        path2.lineTo(8.59f, 8.01f);
        path2.cubicTo(8.56f, 8.0f, 8.52f, 8.0f, 8.49f, 8.0f);
        path2.cubicTo(8.2f, 8.0f, 8.01f, 8.23f, 8.01f, 8.53f);
        path2.cubicTo(8.01f, 8.59f, 8.0f, 8.66f, 8.0f, 8.73f);
        path2.lineTo(8.0f, 8.72f);
        path2.lineTo(8.01f, 9.99f);
        paint.reset();
        paint.setFlags(1);
        path2.setFillType(Path.FillType.EVEN_ODD);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path2, paint);
        canvas.restore();
        canvas.restore();
        canvas.restore();
    }

    public static void drawLaneStraight(Canvas canvas, int i, PointF pointF) {
        drawLaneStraight(canvas, new RectF(0.0f, 0.0f, 30.0f, 30.0f), ResizingBehavior.AspectFit, i, pointF);
    }

    public static void drawLaneStraight(Canvas canvas, RectF rectF, ResizingBehavior resizingBehavior, int i, PointF pointF) {
        Stack stack = new Stack();
        stack.push(new Matrix());
        Paint paint = CacheForLaneStraight.paint;
        float fMin = Math.min(pointF.x / 30.0f, pointF.y / 30.0f);
        canvas.save();
        RectF rectF2 = CacheForLaneStraight.resizedFrame;
        resizingBehaviorApply(resizingBehavior, CacheForLaneStraight.originalFrame, rectF, rectF2);
        canvas.translate(rectF2.left, rectF2.top);
        canvas.scale(rectF2.width() / 30.0f, rectF2.height() / 30.0f);
        CacheForLaneStraight.frame.set(0.0f, 0.0f, pointF.x, pointF.y);
        RectF rectF3 = CacheForLaneStraight.group;
        rectF3.set(0.0f, 0.0f, 12.02f, 24.0f);
        canvas.save();
        canvas.translate(9.0f, 3.0f);
        ((Matrix) stack.peek()).postTranslate(9.0f, 3.0f);
        canvas.scale(fMin, fMin);
        ((Matrix) stack.peek()).postScale(fMin, fMin);
        RectF rectF4 = CacheForLaneStraight.rectangleRect;
        rectF4.set(4.0f, 8.0f, 8.0f, 24.0f);
        Path path = CacheForLaneStraight.rectanglePath;
        path.reset();
        path.addRect(rectF4, Path.Direction.CW);
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path, paint);
        CacheForLaneStraight.bezierRect.set(0.0f, 0.0f, 12.02f, 9.99f);
        Path path2 = CacheForLaneStraight.bezierPath;
        path2.reset();
        path2.moveTo(b.a(rectF3, 0.33372f, rectF3.left), (rectF3.height() * 0.4135f) + rectF3.top);
        c.a(rectF3, 0.36075f, rectF3.top, path2, b.a(rectF3, 0.33414f, rectF3.left));
        c.a(rectF3, 0.36096f, rectF3.top, path2, b.a(rectF3, 0.33397f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.33397f, rectF3.left), a.a(rectF3, 0.35842f, rectF3.top), b.a(rectF3, 0.33364f, rectF3.left), a.a(rectF3, 0.35542f, rectF3.top), b.a(rectF3, 0.33364f, rectF3.left), a.a(rectF3, 0.35262f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.33364f, rectF3.left), a.a(rectF3, 0.3405f, rectF3.top), b.a(rectF3, 0.31766f, rectF3.left), a.a(rectF3, 0.33075f, rectF3.top), b.a(rectF3, 0.29345f, rectF3.left), a.a(rectF3, 0.33075f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.29096f, rectF3.left), a.a(rectF3, 0.33075f, rectF3.top), b.a(rectF3, 0.28796f, rectF3.left), a.a(rectF3, 0.33079f, rectF3.top), b.a(rectF3, 0.28563f, rectF3.left), a.a(rectF3, 0.331f, rectF3.top));
        c.a(rectF3, 0.33087f, rectF3.top, path2, b.a(rectF3, 0.28588f, rectF3.left));
        c.a(rectF3, 0.37217f, rectF3.top, path2, b.a(rectF3, 0.05882f, rectF3.left));
        c.a(rectF3, 0.37212f, rectF3.top, path2, b.a(rectF3, 0.05916f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.05416f, rectF3.left), a.a(rectF3, 0.37312f, rectF3.top), b.a(rectF3, 0.04867f, rectF3.left), a.a(rectF3, 0.37371f, rectF3.top), b.a(rectF3, 0.04293f, rectF3.left), a.a(rectF3, 0.37371f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.01922f, rectF3.left), a.a(rectF3, 0.37371f, rectF3.top), rectF3.left, a.a(rectF3, 0.36408f, rectF3.top), rectF3.left, a.a(rectF3, 0.35221f, rectF3.top));
        path2.cubicTo(rectF3.left, a.a(rectF3, 0.346f, rectF3.top), b.a(rectF3, 0.00516f, rectF3.left), a.a(rectF3, 0.34033f, rectF3.top), b.a(rectF3, 0.01356f, rectF3.left), a.a(rectF3, 0.33642f, rectF3.top));
        c.a(rectF3, 0.3365f, rectF3.top, path2, b.a(rectF3, 0.01331f, rectF3.left));
        path2.lineTo(b.a(rectF3, 0.50046f, rectF3.left), rectF3.top);
        c.a(rectF3, 0.33908f, rectF3.top, path2, b.a(rectF3, 0.98669f, rectF3.left));
        c.a(rectF3, 0.339f, rectF3.top, path2, b.a(rectF3, 0.98644f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.99484f, rectF3.left), a.a(rectF3, 0.34292f, rectF3.top), rectF3.width() + rectF3.left, a.a(rectF3, 0.34862f, rectF3.top), rectF3.width() + rectF3.left, a.a(rectF3, 0.35483f, rectF3.top));
        path2.cubicTo(rectF3.width() + rectF3.left, a.a(rectF3, 0.36671f, rectF3.top), b.a(rectF3, 0.98078f, rectF3.left), a.a(rectF3, 0.37629f, rectF3.top), b.a(rectF3, 0.95707f, rectF3.left), a.a(rectF3, 0.37629f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.95133f, rectF3.left), a.a(rectF3, 0.37629f, rectF3.top), b.a(rectF3, 0.94584f, rectF3.left), a.a(rectF3, 0.37575f, rectF3.top), b.a(rectF3, 0.94084f, rectF3.left), a.a(rectF3, 0.37471f, rectF3.top));
        c.a(rectF3, 0.37475f, rectF3.top, path2, b.a(rectF3, 0.94118f, rectF3.left));
        c.a(rectF3, 0.33346f, rectF3.top, path2, b.a(rectF3, 0.71412f, rectF3.left));
        c.a(rectF3, 0.33358f, rectF3.top, path2, b.a(rectF3, 0.71437f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.71204f, rectF3.left), a.a(rectF3, 0.33342f, rectF3.top), b.a(rectF3, 0.70904f, rectF3.left), a.a(rectF3, 0.33333f, rectF3.top), b.a(rectF3, 0.70655f, rectF3.left), a.a(rectF3, 0.33333f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.68234f, rectF3.left), a.a(rectF3, 0.33333f, rectF3.top), b.a(rectF3, 0.66636f, rectF3.left), a.a(rectF3, 0.34308f, rectF3.top), b.a(rectF3, 0.66636f, rectF3.left), a.a(rectF3, 0.35521f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.66636f, rectF3.left), a.a(rectF3, 0.358f, rectF3.top), b.a(rectF3, 0.66603f, rectF3.left), a.a(rectF3, 0.361f, rectF3.top), b.a(rectF3, 0.66603f, rectF3.left), a.a(rectF3, 0.36354f, rectF3.top));
        c.a(rectF3, 0.36338f, rectF3.top, path2, b.a(rectF3, 0.66586f, rectF3.left));
        path2.lineTo(b.a(rectF3, 0.66628f, rectF3.left), (rectF3.height() * 0.41608f) + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        path2.setFillType(Path.FillType.EVEN_ODD);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path2, paint);
        canvas.restore();
        canvas.restore();
    }

    public static void drawLaneStraightOnly(Canvas canvas, int i, int i2, PointF pointF) {
        drawLaneStraightOnly(canvas, new RectF(0.0f, 0.0f, 30.0f, 30.0f), ResizingBehavior.AspectFit, i, i2, pointF);
    }

    public static void drawLaneStraightOnly(Canvas canvas, RectF rectF, ResizingBehavior resizingBehavior, int i, int i2, PointF pointF) {
        Stack stack = new Stack();
        stack.push(new Matrix());
        Paint paint = CacheForLaneStraightOnly.paint;
        float fMin = Math.min(pointF.x / 30.0f, pointF.y / 30.0f);
        canvas.save();
        RectF rectF2 = CacheForLaneStraightOnly.resizedFrame;
        resizingBehaviorApply(resizingBehavior, CacheForLaneStraightOnly.originalFrame, rectF, rectF2);
        canvas.translate(rectF2.left, rectF2.top);
        canvas.scale(rectF2.width() / 30.0f, rectF2.height() / 30.0f);
        CacheForLaneStraightOnly.frame.set(0.0f, 0.0f, pointF.x, pointF.y);
        RectF rectF3 = CacheForLaneStraightOnly.group;
        rectF3.set(0.0f, 0.0f, 21.97f, 25.0f);
        canvas.save();
        canvas.translate(5.0f, 2.0f);
        ((Matrix) stack.peek()).postTranslate(5.0f, 2.0f);
        canvas.scale(fMin, fMin);
        ((Matrix) stack.peek()).postScale(fMin, fMin);
        CacheForLaneStraightOnly.bezier2Rect.set(12.99f, 8.58f, 21.97f, 20.6f);
        Path path = CacheForLaneStraightOnly.bezier2Path;
        path.reset();
        path.moveTo(b.a(rectF3, 0.59384f, rectF3.left), (rectF3.height() * 0.50353f) + rectF3.top);
        c.a(rectF3, 0.50373f, rectF3.top, path, b.a(rectF3, 0.65146f, rectF3.left));
        c.a(rectF3, 0.50365f, rectF3.top, path, b.a(rectF3, 0.65123f, rectF3.left));
        path.cubicTo(b.a(rectF3, 0.65401f, rectF3.left), a.a(rectF3, 0.50365f, rectF3.top), b.a(rectF3, 0.65729f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top), b.a(rectF3, 0.66034f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.67358f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top), b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.49581f, rectF3.top), b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.48417f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.48297f, rectF3.top), b.a(rectF3, 0.68418f, rectF3.left), a.a(rectF3, 0.48153f, rectF3.top), b.a(rectF3, 0.68396f, rectF3.left), a.a(rectF3, 0.48041f, rectF3.top));
        c.a(rectF3, 0.48053f, rectF3.top, path, b.a(rectF3, 0.68409f, rectF3.left));
        c.a(rectF3, 0.37137f, rectF3.top, path, b.a(rectF3, 0.63899f, rectF3.left));
        c.a(rectF3, 0.37153f, rectF3.top, path, b.a(rectF3, 0.63904f, rectF3.left));
        path.cubicTo(b.a(rectF3, 0.63794f, rectF3.left), a.a(rectF3, 0.36913f, rectF3.top), b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.36649f, rectF3.top), b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.36373f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.35233f, rectF3.top), b.a(rectF3, 0.64782f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top), b.a(rectF3, 0.66079f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.66757f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top), b.a(rectF3, 0.67376f, rectF3.left), a.a(rectF3, 0.34557f, rectF3.top), b.a(rectF3, 0.67804f, rectF3.left), a.a(rectF3, 0.34961f, rectF3.top));
        c.a(rectF3, 0.34949f, rectF3.top, path, b.a(rectF3, 0.67795f, rectF3.left));
        c.a(rectF3, 0.58369f, rectF3.top, path, b.a(rectF3, 1.0f, rectF3.left));
        c.a(rectF3, 0.81745f, rectF3.top, path, b.a(rectF3, 0.67513f, rectF3.left));
        c.a(rectF3, 0.81733f, rectF3.top, path, b.a(rectF3, 0.67522f, rectF3.left));
        path.cubicTo(b.a(rectF3, 0.67094f, rectF3.left), a.a(rectF3, 0.82137f, rectF3.top), b.a(rectF3, 0.6647f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top), b.a(rectF3, 0.65792f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.64495f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top), b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.81461f, rectF3.top), b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.80321f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.80045f, rectF3.top), b.a(rectF3, 0.63508f, rectF3.left), a.a(rectF3, 0.79781f, rectF3.top), b.a(rectF3, 0.63621f, rectF3.left), a.a(rectF3, 0.79541f, rectF3.top));
        c.a(rectF3, 0.79557f, rectF3.top, path, b.a(rectF3, 0.63617f, rectF3.left));
        c.a(rectF3, 0.68641f, rectF3.top, path, b.a(rectF3, 0.68127f, rectF3.left));
        c.a(rectF3, 0.68653f, rectF3.top, path, b.a(rectF3, 0.68113f, rectF3.left));
        path.cubicTo(b.a(rectF3, 0.68132f, rectF3.left), a.a(rectF3, 0.68541f, rectF3.top), b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.68397f, rectF3.top), b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.68277f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.67113f, rectF3.top), b.a(rectF3, 0.67076f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top), b.a(rectF3, 0.65751f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top));
        path.cubicTo(b.a(rectF3, 0.65446f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top), b.a(rectF3, 0.65119f, rectF3.left), a.a(rectF3, 0.66329f, rectF3.top), b.a(rectF3, 0.64841f, rectF3.left), a.a(rectF3, 0.66329f, rectF3.top));
        c.a(rectF3, 0.66321f, rectF3.top, path, b.a(rectF3, 0.64859f, rectF3.left));
        path.lineTo(b.a(rectF3, 0.59102f, rectF3.left), (rectF3.height() * 0.66341f) + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        path.setFillType(Path.FillType.EVEN_ODD);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i2);
        canvas.drawPath(path, paint);
        CacheForLaneStraightOnly.bezier3Rect.set(6.03f, 14.61f, 15.03f, 25.0f);
        Path path2 = CacheForLaneStraightOnly.bezier3Path;
        path2.reset();
        path2.moveTo(b.a(rectF3, 0.27429f, rectF3.left), rectF3.height() + rectF3.top);
        c.a(rectF3, 0.83475f, rectF3.top, path2, b.a(rectF3, 0.27429f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.27429f, rectF3.left), a.a(rectF3, 0.76907f, rectF3.top), b.a(rectF3, 0.30633f, rectF3.left), a.a(rectF3, 0.70583f, rectF3.top), b.a(rectF3, 0.36427f, rectF3.left), a.a(rectF3, 0.66431f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.42007f, rectF3.left), a.a(rectF3, 0.62431f, rectF3.top), b.a(rectF3, 0.49758f, rectF3.left), a.a(rectF3, 0.58431f, rectF3.top), b.a(rectF3, 0.58433f, rectF3.left), a.a(rectF3, 0.58431f, rectF3.top));
        path2.lineTo(b.a(rectF3, 0.68391f, rectF3.left), (rectF3.height() * 0.58431f) + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeMiter(10.0f);
        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i2);
        canvas.drawPath(path2, paint);
        canvas.restore();
        RectF rectF4 = CacheForLaneStraightOnly.rectangleRect;
        rectF4.set(4.0f, 9.0f, 8.0f, 25.0f);
        Path path3 = CacheForLaneStraightOnly.rectanglePath;
        path3.reset();
        path3.moveTo(rectF4.left, rectF4.top);
        path3.lineTo(rectF4.right, rectF4.top);
        path3.lineTo(rectF4.right, rectF4.bottom);
        path3.lineTo(rectF4.left, rectF4.bottom);
        path3.close();
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path3, paint);
        CacheForLaneStraightOnly.bezierRect.set(0.0f, 0.0f, 12.02f, 9.99f);
        Path path4 = CacheForLaneStraightOnly.bezierPath;
        path4.reset();
        path4.moveTo(b.a(rectF3, 0.27386f, rectF3.left), (rectF3.height() * 1.1E-4f) + rectF3.top);
        path4.cubicTo(b.a(rectF3, 0.2756f, rectF3.left), a.a(rectF3, 0.00224f, rectF3.top), b.a(rectF3, 0.53413f, rectF3.left), a.a(rectF3, 0.31865f, rectF3.top), b.a(rectF3, 0.53965f, rectF3.left), a.a(rectF3, 0.3254f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.54425f, rectF3.left), a.a(rectF3, 0.32928f, rectF3.top), b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.33472f, rectF3.top), b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.34063f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.35203f, rectF3.top), b.a(rectF3, 0.53651f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top), b.a(rectF3, 0.52354f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.52046f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top), b.a(rectF3, 0.51752f, rectF3.left), a.a(rectF3, 0.36073f, rectF3.top), b.a(rectF3, 0.51483f, rectF3.left), a.a(rectF3, 0.35977f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.50959f, rectF3.left), a.a(rectF3, 0.35807f, rectF3.top), b.a(rectF3, 0.39573f, rectF3.left), a.a(rectF3, 0.32173f, rectF3.top), b.a(rectF3, 0.3908f, rectF3.left), a.a(rectF3, 0.32016f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.37325f, rectF3.left), a.a(rectF3, 0.31999f, rectF3.top), b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.32935f, rectF3.top), b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.34099f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.34361f, rectF3.top), b.a(rectF3, 0.36434f, rectF3.left), a.a(rectF3, 0.34642f, rectF3.top), b.a(rectF3, 0.36433f, rectF3.left), a.a(rectF3, 0.34883f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.36425f, rectF3.left), a.a(rectF3, 0.3521f, rectF3.top), b.a(rectF3, 0.36447f, rectF3.left), a.a(rectF3, 0.39943f, rectF3.top), b.a(rectF3, 0.36447f, rectF3.left), a.a(rectF3, 0.39943f, rectF3.top));
        c.a(rectF3, 0.39695f, rectF3.top, path4, b.a(rectF3, 0.18255f, rectF3.left));
        path4.cubicTo(b.a(rectF3, 0.18255f, rectF3.left), a.a(rectF3, 0.39695f, rectF3.top), b.a(rectF3, 0.18276f, rectF3.left), a.a(rectF3, 0.34996f, rectF3.top), b.a(rectF3, 0.18278f, rectF3.left), a.a(rectF3, 0.34651f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.18268f, rectF3.left), a.a(rectF3, 0.34391f, rectF3.top), b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.34112f, rectF3.top), b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.33851f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.32687f, rectF3.top), b.a(rectF3, 0.17377f, rectF3.left), a.a(rectF3, 0.31751f, rectF3.top), b.a(rectF3, 0.16052f, rectF3.left), a.a(rectF3, 0.31751f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.15129f, rectF3.left), a.a(rectF3, 0.31925f, rectF3.top), b.a(rectF3, 0.03743f, rectF3.left), a.a(rectF3, 0.35559f, rectF3.top), b.a(rectF3, 0.03235f, rectF3.left), a.a(rectF3, 0.35721f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.0295f, rectF3.left), a.a(rectF3, 0.35821f, rectF3.top), b.a(rectF3, 0.02656f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top), b.a(rectF3, 0.02348f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.0106f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top), b.a(rectF3, 1.4E-4f, rectF3.left), a.a(rectF3, 0.34964f, rectF3.top), rectF3.left, a.a(rectF3, 0.33835f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 7.0E-5f, rectF3.left), a.a(rectF3, 0.33206f, rectF3.top), b.a(rectF3, 0.00283f, rectF3.left), a.a(rectF3, 0.32675f, rectF3.top), b.a(rectF3, 0.0073f, rectF3.left), a.a(rectF3, 0.32305f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.01291f, rectF3.left), a.a(rectF3, 0.3162f, rectF3.top), b.a(rectF3, 0.27191f, rectF3.left), a.a(rectF3, 0.00224f, rectF3.top), b.a(rectF3, 0.27375f, rectF3.left), rectF3.top);
        path4.lineTo(b.a(rectF3, 0.27386f, rectF3.left), (rectF3.height() * 1.1E-4f) + rectF3.top);
        path4.close();
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path4, paint);
        canvas.restore();
        canvas.restore();
    }

    public static void drawLaneStraightRight(Canvas canvas, int i, PointF pointF) {
        drawLaneStraightRight(canvas, new RectF(0.0f, 0.0f, 30.0f, 30.0f), ResizingBehavior.AspectFit, i, pointF);
    }

    public static void drawLaneStraightRight(Canvas canvas, RectF rectF, ResizingBehavior resizingBehavior, int i, PointF pointF) {
        Stack stack = new Stack();
        stack.push(new Matrix());
        Paint paint = CacheForLaneStraightRight.paint;
        float fMin = Math.min(pointF.x / 30.0f, pointF.y / 30.0f);
        canvas.save();
        RectF rectF2 = CacheForLaneStraightRight.resizedFrame;
        resizingBehaviorApply(resizingBehavior, CacheForLaneStraightRight.originalFrame, rectF, rectF2);
        canvas.translate(rectF2.left, rectF2.top);
        canvas.scale(rectF2.width() / 30.0f, rectF2.height() / 30.0f);
        CacheForLaneStraightRight.frame.set(0.0f, 0.0f, pointF.x, pointF.y);
        RectF rectF3 = CacheForLaneStraightRight.group;
        rectF3.set(0.0f, 0.0f, 21.97f, 25.0f);
        canvas.save();
        canvas.translate(5.0f, 2.0f);
        ((Matrix) stack.peek()).postTranslate(5.0f, 2.0f);
        canvas.scale(fMin, fMin);
        ((Matrix) stack.peek()).postScale(fMin, fMin);
        RectF rectF4 = CacheForLaneStraightRight.rectangleRect;
        rectF4.set(4.0f, 9.5f, 8.0f, 25.0f);
        Path path = CacheForLaneStraightRight.rectanglePath;
        path.reset();
        path.moveTo(rectF4.left, rectF4.top);
        path.lineTo(rectF4.right, rectF4.top);
        path.lineTo(rectF4.right, rectF4.bottom);
        path.lineTo(rectF4.left, rectF4.bottom);
        path.close();
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path, paint);
        CacheForLaneStraightRight.bezierRect.set(0.0f, 0.0f, 12.02f, 9.99f);
        Path path2 = CacheForLaneStraightRight.bezierPath;
        path2.reset();
        path2.moveTo(b.a(rectF3, 0.27386f, rectF3.left), (rectF3.height() * 1.1E-4f) + rectF3.top);
        path2.cubicTo(b.a(rectF3, 0.2756f, rectF3.left), a.a(rectF3, 0.00224f, rectF3.top), b.a(rectF3, 0.53413f, rectF3.left), a.a(rectF3, 0.31865f, rectF3.top), b.a(rectF3, 0.53965f, rectF3.left), a.a(rectF3, 0.3254f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.54425f, rectF3.left), a.a(rectF3, 0.32928f, rectF3.top), b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.33472f, rectF3.top), b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.34063f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.54702f, rectF3.left), a.a(rectF3, 0.35203f, rectF3.top), b.a(rectF3, 0.53651f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top), b.a(rectF3, 0.52354f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.52046f, rectF3.left), a.a(rectF3, 0.36123f, rectF3.top), b.a(rectF3, 0.51752f, rectF3.left), a.a(rectF3, 0.36073f, rectF3.top), b.a(rectF3, 0.51483f, rectF3.left), a.a(rectF3, 0.35977f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.50959f, rectF3.left), a.a(rectF3, 0.35807f, rectF3.top), b.a(rectF3, 0.39573f, rectF3.left), a.a(rectF3, 0.32173f, rectF3.top), b.a(rectF3, 0.3908f, rectF3.left), a.a(rectF3, 0.32016f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.37325f, rectF3.left), a.a(rectF3, 0.31999f, rectF3.top), b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.32935f, rectF3.top), b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.34099f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.36451f, rectF3.left), a.a(rectF3, 0.34361f, rectF3.top), b.a(rectF3, 0.36434f, rectF3.left), a.a(rectF3, 0.34642f, rectF3.top), b.a(rectF3, 0.36433f, rectF3.left), a.a(rectF3, 0.34883f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.36425f, rectF3.left), a.a(rectF3, 0.3521f, rectF3.top), b.a(rectF3, 0.36447f, rectF3.left), a.a(rectF3, 0.39943f, rectF3.top), b.a(rectF3, 0.36447f, rectF3.left), a.a(rectF3, 0.39943f, rectF3.top));
        c.a(rectF3, 0.39695f, rectF3.top, path2, b.a(rectF3, 0.18255f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.18255f, rectF3.left), a.a(rectF3, 0.39695f, rectF3.top), b.a(rectF3, 0.18276f, rectF3.left), a.a(rectF3, 0.34996f, rectF3.top), b.a(rectF3, 0.18278f, rectF3.left), a.a(rectF3, 0.34651f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.18268f, rectF3.left), a.a(rectF3, 0.34391f, rectF3.top), b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.34112f, rectF3.top), b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.33851f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.18251f, rectF3.left), a.a(rectF3, 0.32687f, rectF3.top), b.a(rectF3, 0.17377f, rectF3.left), a.a(rectF3, 0.31751f, rectF3.top), b.a(rectF3, 0.16052f, rectF3.left), a.a(rectF3, 0.31751f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.15129f, rectF3.left), a.a(rectF3, 0.31925f, rectF3.top), b.a(rectF3, 0.03743f, rectF3.left), a.a(rectF3, 0.35559f, rectF3.top), b.a(rectF3, 0.03235f, rectF3.left), a.a(rectF3, 0.35721f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.0295f, rectF3.left), a.a(rectF3, 0.35821f, rectF3.top), b.a(rectF3, 0.02656f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top), b.a(rectF3, 0.02348f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.0106f, rectF3.left), a.a(rectF3, 0.35875f, rectF3.top), b.a(rectF3, 1.4E-4f, rectF3.left), a.a(rectF3, 0.34964f, rectF3.top), rectF3.left, a.a(rectF3, 0.33835f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 7.0E-5f, rectF3.left), a.a(rectF3, 0.33206f, rectF3.top), b.a(rectF3, 0.00283f, rectF3.left), a.a(rectF3, 0.32675f, rectF3.top), b.a(rectF3, 0.0073f, rectF3.left), a.a(rectF3, 0.32305f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.01291f, rectF3.left), a.a(rectF3, 0.3162f, rectF3.top), b.a(rectF3, 0.27191f, rectF3.left), a.a(rectF3, 0.00224f, rectF3.top), b.a(rectF3, 0.27375f, rectF3.left), rectF3.top);
        path2.lineTo(b.a(rectF3, 0.27386f, rectF3.left), (rectF3.height() * 1.1E-4f) + rectF3.top);
        path2.close();
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path2, paint);
        CacheForLaneStraightRight.bezier2Rect.set(12.99f, 8.58f, 21.97f, 20.6f);
        Path path3 = CacheForLaneStraightRight.bezier2Path;
        path3.reset();
        path3.moveTo(b.a(rectF3, 0.59384f, rectF3.left), (rectF3.height() * 0.50353f) + rectF3.top);
        c.a(rectF3, 0.50373f, rectF3.top, path3, b.a(rectF3, 0.65146f, rectF3.left));
        c.a(rectF3, 0.50365f, rectF3.top, path3, b.a(rectF3, 0.65123f, rectF3.left));
        path3.cubicTo(b.a(rectF3, 0.65401f, rectF3.left), a.a(rectF3, 0.50365f, rectF3.top), b.a(rectF3, 0.65729f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top), b.a(rectF3, 0.66034f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.67358f, rectF3.left), a.a(rectF3, 0.50349f, rectF3.top), b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.49581f, rectF3.top), b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.48417f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.68423f, rectF3.left), a.a(rectF3, 0.48297f, rectF3.top), b.a(rectF3, 0.68418f, rectF3.left), a.a(rectF3, 0.48153f, rectF3.top), b.a(rectF3, 0.68396f, rectF3.left), a.a(rectF3, 0.48041f, rectF3.top));
        c.a(rectF3, 0.48053f, rectF3.top, path3, b.a(rectF3, 0.68409f, rectF3.left));
        c.a(rectF3, 0.37137f, rectF3.top, path3, b.a(rectF3, 0.63899f, rectF3.left));
        c.a(rectF3, 0.37153f, rectF3.top, path3, b.a(rectF3, 0.63904f, rectF3.left));
        path3.cubicTo(b.a(rectF3, 0.63794f, rectF3.left), a.a(rectF3, 0.36913f, rectF3.top), b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.36649f, rectF3.top), b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.36373f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.63731f, rectF3.left), a.a(rectF3, 0.35233f, rectF3.top), b.a(rectF3, 0.64782f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top), b.a(rectF3, 0.66079f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.66757f, rectF3.left), a.a(rectF3, 0.34309f, rectF3.top), b.a(rectF3, 0.67376f, rectF3.left), a.a(rectF3, 0.34557f, rectF3.top), b.a(rectF3, 0.67804f, rectF3.left), a.a(rectF3, 0.34961f, rectF3.top));
        c.a(rectF3, 0.34949f, rectF3.top, path3, b.a(rectF3, 0.67795f, rectF3.left));
        c.a(rectF3, 0.58369f, rectF3.top, path3, b.a(rectF3, 1.0f, rectF3.left));
        c.a(rectF3, 0.81745f, rectF3.top, path3, b.a(rectF3, 0.67513f, rectF3.left));
        c.a(rectF3, 0.81733f, rectF3.top, path3, b.a(rectF3, 0.67522f, rectF3.left));
        path3.cubicTo(b.a(rectF3, 0.67094f, rectF3.left), a.a(rectF3, 0.82137f, rectF3.top), b.a(rectF3, 0.6647f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top), b.a(rectF3, 0.65792f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.64495f, rectF3.left), a.a(rectF3, 0.82385f, rectF3.top), b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.81461f, rectF3.top), b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.80321f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.63448f, rectF3.left), a.a(rectF3, 0.80045f, rectF3.top), b.a(rectF3, 0.63508f, rectF3.left), a.a(rectF3, 0.79781f, rectF3.top), b.a(rectF3, 0.63621f, rectF3.left), a.a(rectF3, 0.79541f, rectF3.top));
        c.a(rectF3, 0.79557f, rectF3.top, path3, b.a(rectF3, 0.63617f, rectF3.left));
        c.a(rectF3, 0.68641f, rectF3.top, path3, b.a(rectF3, 0.68127f, rectF3.left));
        c.a(rectF3, 0.68653f, rectF3.top, path3, b.a(rectF3, 0.68113f, rectF3.left));
        path3.cubicTo(b.a(rectF3, 0.68132f, rectF3.left), a.a(rectF3, 0.68541f, rectF3.top), b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.68397f, rectF3.top), b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.68277f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.68141f, rectF3.left), a.a(rectF3, 0.67113f, rectF3.top), b.a(rectF3, 0.67076f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top), b.a(rectF3, 0.65751f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top));
        path3.cubicTo(b.a(rectF3, 0.65446f, rectF3.left), a.a(rectF3, 0.66345f, rectF3.top), b.a(rectF3, 0.65119f, rectF3.left), a.a(rectF3, 0.66329f, rectF3.top), b.a(rectF3, 0.64841f, rectF3.left), a.a(rectF3, 0.66329f, rectF3.top));
        c.a(rectF3, 0.66321f, rectF3.top, path3, b.a(rectF3, 0.64859f, rectF3.left));
        path3.lineTo(b.a(rectF3, 0.59102f, rectF3.left), (rectF3.height() * 0.66341f) + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        path3.setFillType(Path.FillType.EVEN_ODD);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path3, paint);
        CacheForLaneStraightRight.bezier3Rect.set(6.03f, 14.61f, 15.03f, 25.0f);
        Path path4 = CacheForLaneStraightRight.bezier3Path;
        path4.reset();
        path4.moveTo(b.a(rectF3, 0.27429f, rectF3.left), rectF3.height() + rectF3.top);
        c.a(rectF3, 0.83475f, rectF3.top, path4, b.a(rectF3, 0.27429f, rectF3.left));
        path4.cubicTo(b.a(rectF3, 0.27429f, rectF3.left), a.a(rectF3, 0.76907f, rectF3.top), b.a(rectF3, 0.30633f, rectF3.left), a.a(rectF3, 0.70583f, rectF3.top), b.a(rectF3, 0.36427f, rectF3.left), a.a(rectF3, 0.66431f, rectF3.top));
        path4.cubicTo(b.a(rectF3, 0.42007f, rectF3.left), a.a(rectF3, 0.62431f, rectF3.top), b.a(rectF3, 0.49758f, rectF3.left), a.a(rectF3, 0.58431f, rectF3.top), b.a(rectF3, 0.58433f, rectF3.left), a.a(rectF3, 0.58431f, rectF3.top));
        path4.lineTo(b.a(rectF3, 0.68391f, rectF3.left), (rectF3.height() * 0.58431f) + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeMiter(10.0f);
        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        canvas.drawPath(path4, paint);
        canvas.restore();
        canvas.restore();
        canvas.restore();
    }

    public static void drawLaneUturn(Canvas canvas, int i, PointF pointF) {
        drawLaneUturn(canvas, new RectF(0.0f, 0.0f, 30.0f, 30.0f), ResizingBehavior.AspectFit, i, pointF);
    }

    public static void drawLaneUturn(Canvas canvas, RectF rectF, ResizingBehavior resizingBehavior, int i, PointF pointF) {
        Stack stack = new Stack();
        stack.push(new Matrix());
        Paint paint = CacheForLaneUturn.paint;
        float fMin = Math.min(pointF.x / 30.0f, pointF.y / 30.0f);
        canvas.save();
        RectF rectF2 = CacheForLaneUturn.resizedFrame;
        resizingBehaviorApply(resizingBehavior, CacheForLaneUturn.originalFrame, rectF, rectF2);
        canvas.translate(rectF2.left, rectF2.top);
        canvas.scale(rectF2.width() / 30.0f, rectF2.height() / 30.0f);
        CacheForLaneUturn.frame.set(0.0f, 0.0f, pointF.x, pointF.y);
        RectF rectF3 = CacheForLaneUturn.group;
        rectF3.set(0.0f, 0.0f, 16.0f, 22.0f);
        canvas.save();
        canvas.translate(9.0f, 5.0f);
        ((Matrix) stack.peek()).postTranslate(9.0f, 5.0f);
        canvas.scale(fMin, fMin);
        ((Matrix) stack.peek()).postScale(fMin, fMin);
        CacheForLaneUturn.bezierRect.set(0.0f, 0.0f, 10.0f, 22.0f);
        Path path = CacheForLaneUturn.bezierPath;
        path.reset();
        path.moveTo(b.a(rectF3, 0.62498f, rectF3.left), (rectF3.height() * 0.68182f) + rectF3.top);
        c.a(rectF3, 0.28459f, rectF3.top, path, b.a(rectF3, 0.62498f, rectF3.left));
        path.cubicTo(b.a(rectF3, 0.62498f, rectF3.left), a.a(rectF3, 0.20995f, rectF3.top), b.a(rectF3, 0.62498f, rectF3.left), rectF3.top, b.a(rectF3, 0.31249f, rectF3.left), rectF3.top);
        float f = rectF3.left;
        float f2 = rectF3.top;
        path.cubicTo(f, f2, f, a.a(rectF3, 0.27273f, f2), rectF3.left, a.a(rectF3, 0.27273f, rectF3.top));
        path.lineTo(rectF3.left, rectF3.height() + rectF3.top);
        paint.reset();
        paint.setFlags(1);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeMiter(10.0f);
        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        canvas.drawPath(path, paint);
        canvas.restore();
        CacheForLaneUturn.bezier2Rect.set(4.01f, 12.99f, 16.0f, 21.97f);
        Path path2 = CacheForLaneUturn.bezier2Path;
        path2.reset();
        path2.moveTo(b.a(rectF3, 0.75119f, rectF3.left), (rectF3.height() * 0.59306f) + rectF3.top);
        path2.cubicTo(b.a(rectF3, 0.75119f, rectF3.left), a.a(rectF3, 0.59306f, rectF3.top), b.a(rectF3, 0.7509f, rectF3.left), a.a(rectF3, 0.64646f, rectF3.top), b.a(rectF3, 0.75088f, rectF3.left), a.a(rectF3, 0.65038f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.75102f, rectF3.left), a.a(rectF3, 0.65333f, rectF3.top), b.a(rectF3, 0.75125f, rectF3.left), a.a(rectF3, 0.65651f, rectF3.top), b.a(rectF3, 0.75125f, rectF3.left), a.a(rectF3, 0.65947f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.75125f, rectF3.left), a.a(rectF3, 0.6727f, rectF3.top), b.a(rectF3, 0.76325f, rectF3.left), a.a(rectF3, 0.68334f, rectF3.top), b.a(rectF3, 0.78144f, rectF3.left), a.a(rectF3, 0.68334f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.79411f, rectF3.left), a.a(rectF3, 0.68135f, rectF3.top), b.a(rectF3, 0.95046f, rectF3.left), a.a(rectF3, 0.64006f, rectF3.top), b.a(rectF3, 0.95744f, rectF3.left), a.a(rectF3, 0.63822f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.96136f, rectF3.left), a.a(rectF3, 0.63708f, rectF3.top), b.a(rectF3, 0.9654f, rectF3.left), a.a(rectF3, 0.63647f, rectF3.top), b.a(rectF3, 0.96962f, rectF3.left), a.a(rectF3, 0.63647f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.98363f, rectF3.left), a.a(rectF3, 0.63647f, rectF3.top), b.a(rectF3, 0.99555f, rectF3.left), a.a(rectF3, 0.64296f, rectF3.top), b.a(rectF3, 1.0f, rectF3.left), a.a(rectF3, 0.65204f, rectF3.top));
        c.a(rectF3, 0.65989f, rectF3.top, path2, b.a(rectF3, 0.99996f, rectF3.left));
        c.a(rectF3, 0.6679f, rectF3.top, path2, b.a(rectF3, 0.99996f, rectF3.left));
        path2.cubicTo(b.a(rectF3, 0.99829f, rectF3.left), a.a(rectF3, 0.67142f, rectF3.top), b.a(rectF3, 0.99548f, rectF3.left), a.a(rectF3, 0.67455f, rectF3.top), b.a(rectF3, 0.99185f, rectF3.left), a.a(rectF3, 0.67704f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.98369f, rectF3.left), a.a(rectF3, 0.68425f, rectF3.top), b.a(rectF3, 0.62595f, rectF3.left), a.a(rectF3, 0.9987f, rectF3.top), b.a(rectF3, 0.62595f, rectF3.left), a.a(rectF3, 0.9987f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.62595f, rectF3.left), a.a(rectF3, 0.9987f, rectF3.top), b.a(rectF3, 0.49849f, rectF3.left), a.a(rectF3, 0.88548f, rectF3.top), b.a(rectF3, 0.39416f, rectF3.left), a.a(rectF3, 0.7928f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.32387f, rectF3.left), a.a(rectF3, 0.73035f, rectF3.top), b.a(rectF3, 0.26407f, rectF3.left), a.a(rectF3, 0.67723f, rectF3.top), b.a(rectF3, 0.26085f, rectF3.left), a.a(rectF3, 0.67437f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.25452f, rectF3.left), a.a(rectF3, 0.66996f, rectF3.top), b.a(rectF3, 0.25071f, rectF3.left), a.a(rectF3, 0.66378f, rectF3.top), b.a(rectF3, 0.25071f, rectF3.left), a.a(rectF3, 0.65706f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.25071f, rectF3.left), a.a(rectF3, 0.64411f, rectF3.top), b.a(rectF3, 0.26515f, rectF3.left), a.a(rectF3, 0.63365f, rectF3.top), b.a(rectF3, 0.28296f, rectF3.left), a.a(rectF3, 0.63365f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.28718f, rectF3.left), a.a(rectF3, 0.63365f, rectF3.top), b.a(rectF3, 0.29122f, rectF3.left), a.a(rectF3, 0.63422f, rectF3.top), b.a(rectF3, 0.29491f, rectF3.left), a.a(rectF3, 0.63531f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.30212f, rectF3.left), a.a(rectF3, 0.63724f, rectF3.top), b.a(rectF3, 0.45847f, rectF3.left), a.a(rectF3, 0.67854f, rectF3.top), b.a(rectF3, 0.46523f, rectF3.left), a.a(rectF3, 0.68032f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.48933f, rectF3.left), a.a(rectF3, 0.68052f, rectF3.top), b.a(rectF3, 0.50133f, rectF3.left), a.a(rectF3, 0.66988f, rectF3.top), b.a(rectF3, 0.50133f, rectF3.left), a.a(rectF3, 0.65665f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.50133f, rectF3.left), a.a(rectF3, 0.65368f, rectF3.top), b.a(rectF3, 0.50157f, rectF3.left), a.a(rectF3, 0.65048f, rectF3.top), b.a(rectF3, 0.50158f, rectF3.left), a.a(rectF3, 0.64775f, rectF3.top));
        path2.cubicTo(b.a(rectF3, 0.50168f, rectF3.left), a.a(rectF3, 0.64403f, rectF3.top), b.a(rectF3, 0.50139f, rectF3.left), a.a(rectF3, 0.59025f, rectF3.top), b.a(rectF3, 0.50139f, rectF3.left), a.a(rectF3, 0.59025f, rectF3.top));
        path2.lineTo(b.a(rectF3, 0.75119f, rectF3.left), (rectF3.height() * 0.59306f) + rectF3.top);
        path2.close();
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path2, paint);
        canvas.restore();
        canvas.restore();
    }

    public static void resizingBehaviorApply(ResizingBehavior resizingBehavior, RectF rectF, RectF rectF2, RectF rectF3) {
        float fMin;
        if (rectF.equals(rectF2) || rectF2 == null) {
            rectF3.set(rectF);
            return;
        }
        if (resizingBehavior == ResizingBehavior.Stretch) {
            rectF3.set(rectF2);
            return;
        }
        float fAbs = Math.abs(rectF2.width() / rectF.width());
        float fAbs2 = Math.abs(rectF2.height() / rectF.height());
        int i = AnonymousClass1.$SwitchMap$com$mappls$sdk$navigation$ui$views$turnlane$LanesStyleKit$ResizingBehavior[resizingBehavior.ordinal()];
        if (i == 1) {
            fMin = Math.min(fAbs, fAbs2);
        } else if (i != 2) {
            fMin = i != 3 ? 0.0f : 1.0f;
        } else {
            fMin = Math.max(fAbs, fAbs2);
        }
        float fAbs3 = Math.abs(rectF.width() * fMin) / 2.0f;
        float fAbs4 = Math.abs(rectF.height() * fMin) / 2.0f;
        rectF3.set(rectF2.centerX() - fAbs3, rectF2.centerY() - fAbs4, rectF2.centerX() + fAbs3, rectF2.centerY() + fAbs4);
    }
}
