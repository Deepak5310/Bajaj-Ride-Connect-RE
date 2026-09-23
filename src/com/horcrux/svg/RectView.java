package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
class RectView extends RenderableView {
    private SVGLength mH;
    private SVGLength mRx;
    private SVGLength mRy;
    private SVGLength mW;
    private SVGLength mX;
    private SVGLength mY;

    public RectView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setX(Dynamic dynamic) {
        this.mX = SVGLength.from(dynamic);
        invalidate();
    }

    public void setX(String str) {
        this.mX = SVGLength.from(str);
        invalidate();
    }

    public void setX(Double d) {
        this.mX = SVGLength.from(d);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.mY = SVGLength.from(dynamic);
        invalidate();
    }

    public void setY(String str) {
        this.mY = SVGLength.from(str);
        invalidate();
    }

    public void setY(Double d) {
        this.mY = SVGLength.from(d);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.mW = SVGLength.from(dynamic);
        invalidate();
    }

    public void setWidth(String str) {
        this.mW = SVGLength.from(str);
        invalidate();
    }

    public void setWidth(Double d) {
        this.mW = SVGLength.from(d);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
        invalidate();
    }

    public void setHeight(String str) {
        this.mH = SVGLength.from(str);
        invalidate();
    }

    public void setHeight(Double d) {
        this.mH = SVGLength.from(d);
        invalidate();
    }

    public void setRx(Dynamic dynamic) {
        this.mRx = SVGLength.from(dynamic);
        invalidate();
    }

    public void setRx(String str) {
        this.mRx = SVGLength.from(str);
        invalidate();
    }

    public void setRx(Double d) {
        this.mRx = SVGLength.from(d);
        invalidate();
    }

    public void setRy(Dynamic dynamic) {
        this.mRy = SVGLength.from(dynamic);
        invalidate();
    }

    public void setRy(String str) {
        this.mRy = SVGLength.from(str);
        invalidate();
    }

    public void setRy(Double d) {
        this.mRy = SVGLength.from(d);
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0061  */
    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        double dRelativeOnWidth;
        double dRelativeOnHeight;
        double d;
        double d2;
        Path path = new Path();
        double dRelativeOnWidth2 = relativeOnWidth(this.mX);
        double dRelativeOnHeight2 = relativeOnHeight(this.mY);
        double dRelativeOnWidth3 = relativeOnWidth(this.mW);
        double dRelativeOnHeight3 = relativeOnHeight(this.mH);
        SVGLength sVGLength = this.mRx;
        if (sVGLength != null || this.mRy != null) {
            if (sVGLength == null) {
                dRelativeOnWidth = relativeOnHeight(this.mRy);
            } else {
                if (this.mRy == null) {
                    dRelativeOnWidth = relativeOnWidth(sVGLength);
                } else {
                    dRelativeOnWidth = relativeOnWidth(sVGLength);
                    dRelativeOnHeight = relativeOnHeight(this.mRy);
                }
                d = dRelativeOnWidth3 / 2.0d;
                if (dRelativeOnWidth > d) {
                    dRelativeOnWidth = d;
                }
                d2 = dRelativeOnHeight3 / 2.0d;
                if (dRelativeOnHeight > d2) {
                    dRelativeOnHeight = d2;
                }
                path.addRoundRect((float) dRelativeOnWidth2, (float) dRelativeOnHeight2, (float) (dRelativeOnWidth2 + dRelativeOnWidth3), (float) (dRelativeOnHeight2 + dRelativeOnHeight3), (float) dRelativeOnWidth, (float) dRelativeOnHeight, Path.Direction.CW);
            }
            dRelativeOnHeight = dRelativeOnWidth;
            d = dRelativeOnWidth3 / 2.0d;
            if (dRelativeOnWidth > d) {
                dRelativeOnWidth = d;
            }
            d2 = dRelativeOnHeight3 / 2.0d;
            if (dRelativeOnHeight > d2) {
                dRelativeOnHeight = d2;
            }
            path.addRoundRect((float) dRelativeOnWidth2, (float) dRelativeOnHeight2, (float) (dRelativeOnWidth2 + dRelativeOnWidth3), (float) (dRelativeOnHeight2 + dRelativeOnHeight3), (float) dRelativeOnWidth, (float) dRelativeOnHeight, Path.Direction.CW);
        } else {
            path.addRect((float) dRelativeOnWidth2, (float) dRelativeOnHeight2, (float) (dRelativeOnWidth2 + dRelativeOnWidth3), (float) (dRelativeOnHeight2 + dRelativeOnHeight3), Path.Direction.CW);
            path.close();
        }
        this.elements = new ArrayList<>();
        this.elements.add(new PathElement(ElementType.kCGPathElementMoveToPoint, new Point[]{new Point(dRelativeOnWidth2, dRelativeOnHeight2)}));
        double d3 = dRelativeOnWidth3 + dRelativeOnWidth2;
        this.elements.add(new PathElement(ElementType.kCGPathElementAddLineToPoint, new Point[]{new Point(d3, dRelativeOnHeight2)}));
        double d4 = dRelativeOnHeight2 + dRelativeOnHeight3;
        this.elements.add(new PathElement(ElementType.kCGPathElementAddLineToPoint, new Point[]{new Point(d3, d4)}));
        this.elements.add(new PathElement(ElementType.kCGPathElementAddLineToPoint, new Point[]{new Point(dRelativeOnWidth2, d4)}));
        this.elements.add(new PathElement(ElementType.kCGPathElementAddLineToPoint, new Point[]{new Point(dRelativeOnWidth2, dRelativeOnHeight2)}));
        return path;
    }
}
