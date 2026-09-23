package com.google.android.libraries.navigation.internal.afn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.facebook.react.uimanager.ViewProps;
import com.mappls.sdk.maps.style.layers.Property;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends DefaultHandler {
    private static final Matrix w = new Matrix();
    Picture b;
    Canvas c;
    Paint d;
    Paint h;
    HashMap a = new HashMap();
    boolean e = false;
    Stack f = new Stack();
    Stack g = new Stack();
    boolean i = false;
    Stack j = new Stack();
    Stack k = new Stack();
    float l = 1.0f;
    Stack m = new Stack();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    RectF f329n = new RectF();
    RectF o = null;
    RectF p = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    float q = 72.0f;
    int r = 0;
    private boolean x = false;
    private int y = 0;
    private boolean z = false;
    HashMap s = new HashMap();
    HashMap t = new HashMap();
    g u = null;
    l v = null;
    private boolean A = false;

    public m(Picture picture) {
        this.b = picture;
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        this.h.setStyle(Paint.Style.FILL);
    }

    private final g e(boolean z, Attributes attributes) {
        g gVar = new g();
        gVar.a = o.d("id", attributes);
        gVar.c = z;
        Float fValueOf = Float.valueOf(0.0f);
        if (z) {
            gVar.d = a("x1", attributes, fValueOf).floatValue();
            gVar.f = a("x2", attributes, fValueOf).floatValue();
            gVar.e = a("y1", attributes, fValueOf).floatValue();
            gVar.g = a("y2", attributes, fValueOf).floatValue();
        } else {
            gVar.h = a("cx", attributes, fValueOf).floatValue();
            gVar.i = a("cy", attributes, fValueOf).floatValue();
            gVar.j = a("r", attributes, fValueOf).floatValue();
        }
        String strD = o.d("gradientTransform", attributes);
        if (strD != null) {
            gVar.m = o.a(strD);
        }
        String strD2 = o.d("href", attributes);
        if (strD2 != null) {
            if (strD2.startsWith("#")) {
                strD2 = strD2.substring(1);
            }
            gVar.b = strD2;
        }
        return gVar;
    }

    private final Float f(String str, Attributes attributes) {
        return a(str, attributes, null);
    }

    private final void g(k kVar, Integer num, boolean z, Paint paint) {
        paint.setColor(n(num.intValue()) | ViewCompat.MEASURED_STATE_MASK);
        Float fA = kVar.a(ViewProps.OPACITY);
        if (fA == null) {
            fA = kVar.a(true != z ? "stroke-opacity" : "fill-opacity");
        }
        if (fA == null) {
            fA = Float.valueOf(1.0f);
        }
        paint.setAlpha((int) (fA.floatValue() * 255.0f * this.l));
    }

    private final void h(Path path) {
        path.computeBounds(this.f329n, false);
        i(this.f329n.left, this.f329n.top);
        i(this.f329n.right, this.f329n.bottom);
    }

    private final void i(float f, float f2) {
        if (f < this.p.left) {
            this.p.left = f;
        }
        if (f > this.p.right) {
            this.p.right = f;
        }
        if (f2 < this.p.top) {
            this.p.top = f2;
        }
        if (f2 > this.p.bottom) {
            this.p.bottom = f2;
        }
    }

    private final void j(float f, float f2, float f3, float f4) {
        i(f, f2);
        i(f + f3, f2 + f4);
    }

    private final void k() {
        this.c.restore();
        this.r--;
    }

    private final void l(Attributes attributes) {
        String strD = o.d(ViewProps.TRANSFORM, attributes);
        Matrix matrixA = strD == null ? w : o.a(strD);
        this.r++;
        this.c.save();
        this.c.concat(matrixA);
    }

    private static final Paint.Align m(Attributes attributes) {
        String strD = o.d("text-anchor", attributes);
        if (strD == null) {
            return null;
        }
        if ("middle".equals(strD)) {
            return Paint.Align.CENTER;
        }
        return ViewProps.END.equals(strD) ? Paint.Align.RIGHT : Paint.Align.LEFT;
    }

    private static final int n(int i) {
        return i & 16777215;
    }

    public final Float a(String str, Attributes attributes, Float f) {
        Float fValueOf;
        int width;
        float height;
        float fFloatValue;
        float fFloatValue2;
        float f2;
        float f3 = this.q;
        String strD = o.d(str, attributes);
        if (strD == null) {
            fValueOf = null;
        } else {
            if (strD.endsWith("px")) {
                fFloatValue = Float.parseFloat(strD.substring(0, strD.length() - 2));
            } else {
                if (strD.endsWith("pt")) {
                    fFloatValue2 = Float.valueOf(strD.substring(0, strD.length() - 2)).floatValue() * f3;
                    f2 = 72.0f;
                } else if (strD.endsWith("pc")) {
                    fFloatValue2 = Float.valueOf(strD.substring(0, strD.length() - 2)).floatValue() * f3;
                    f2 = 6.0f;
                } else if (strD.endsWith("cm")) {
                    fFloatValue2 = Float.valueOf(strD.substring(0, strD.length() - 2)).floatValue() * f3;
                    f2 = 2.54f;
                } else if (strD.endsWith("mm")) {
                    fFloatValue2 = Float.valueOf(strD.substring(0, strD.length() - 2)).floatValue() * f3;
                    f2 = 254.0f;
                } else if (strD.endsWith("in")) {
                    fFloatValue = Float.valueOf(strD.substring(0, strD.length() - 2)).floatValue() * f3;
                } else if (strD.endsWith("em")) {
                    fValueOf = Float.valueOf(Float.valueOf(strD.substring(0, strD.length() - 2)).floatValue() * this.h.getTextSize());
                } else if (strD.endsWith("ex")) {
                    fValueOf = Float.valueOf((Float.valueOf(strD.substring(0, strD.length() - 2)).floatValue() * this.h.getTextSize()) / 2.0f);
                } else if (strD.endsWith("%")) {
                    Float fValueOf2 = Float.valueOf(strD.substring(0, strD.length() - 1));
                    if (str.indexOf("x") >= 0 || str.equals("width")) {
                        width = this.c.getWidth();
                    } else {
                        if (str.indexOf("y") >= 0 || str.equals("height")) {
                            width = this.c.getHeight();
                        } else {
                            height = (this.c.getHeight() + this.c.getWidth()) / 2.0f;
                        }
                        fValueOf = Float.valueOf(fValueOf2.floatValue() * height);
                    }
                    height = width / 100.0f;
                    fValueOf = Float.valueOf(fValueOf2.floatValue() * height);
                } else {
                    fValueOf = Float.valueOf(strD);
                }
                fFloatValue = fFloatValue2 / f2;
            }
            fValueOf = Float.valueOf(fFloatValue);
        }
        return fValueOf == null ? f : fValueOf;
    }

    public final boolean b(k kVar, HashMap map) {
        if ("none".equals(kVar.c("display"))) {
            return false;
        }
        String strC = kVar.c("fill");
        if (strC == null) {
            if (this.i) {
                return this.h.getColor() != 0;
            }
            this.h.setShader(null);
            this.h.setColor(ViewCompat.MEASURED_STATE_MASK);
            return true;
        }
        if (strC.startsWith("url(#")) {
            Shader shader = (Shader) map.get(strC.substring(5, strC.length() - 1));
            if (shader != null) {
                this.h.setShader(shader);
                return true;
            }
            this.h.setShader(null);
            g(kVar, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK), true, this.h);
            return true;
        }
        if (strC.equalsIgnoreCase("none")) {
            this.h.setShader(null);
            this.h.setColor(0);
            return true;
        }
        this.h.setShader(null);
        Integer numB = kVar.b("fill");
        if (numB != null) {
            g(kVar, numB, true, this.h);
            return true;
        }
        g(kVar, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK), true, this.h);
        return true;
    }

    public final boolean c(k kVar) {
        if ("none".equals(kVar.c("display"))) {
            return false;
        }
        Float fA = kVar.a("stroke-width");
        if (fA != null) {
            this.d.setStrokeWidth(fA.floatValue());
        }
        float f = 0.0f;
        if (this.d.getStrokeWidth() <= 0.0f) {
            return false;
        }
        String strC = kVar.c("stroke-linecap");
        if ("round".equals(strC)) {
            this.d.setStrokeCap(Paint.Cap.ROUND);
        } else if (Property.LINE_CAP_SQUARE.equals(strC)) {
            this.d.setStrokeCap(Paint.Cap.SQUARE);
        } else if (Property.LINE_CAP_BUTT.equals(strC)) {
            this.d.setStrokeCap(Paint.Cap.BUTT);
        }
        String strC2 = kVar.c("stroke-linejoin");
        if (Property.LINE_JOIN_MITER.equals(strC2)) {
            this.d.setStrokeJoin(Paint.Join.MITER);
        } else if ("round".equals(strC2)) {
            this.d.setStrokeJoin(Paint.Join.ROUND);
        } else if (Property.LINE_JOIN_BEVEL.equals(strC2)) {
            this.d.setStrokeJoin(Paint.Join.BEVEL);
        }
        String strC3 = kVar.c("stroke-dasharray");
        String strC4 = kVar.c("stroke-dashoffset");
        if (strC3 != null) {
            if (strC3.equals("none")) {
                this.d.setPathEffect(null);
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(strC3, " ,");
                int iCountTokens = stringTokenizer.countTokens();
                if ((iCountTokens & 1) == 1) {
                    iCountTokens += iCountTokens;
                }
                float[] fArr = new float[iCountTokens];
                float f2 = 1.0f;
                int i = 0;
                float f3 = 0.0f;
                while (stringTokenizer.hasMoreTokens()) {
                    int i2 = i + 1;
                    try {
                        f2 = Float.parseFloat(stringTokenizer.nextToken());
                    } catch (NumberFormatException unused) {
                    }
                    fArr[i] = f2;
                    f3 += f2;
                    i = i2;
                }
                int i3 = 0;
                while (i < iCountTokens) {
                    float f4 = fArr[i3];
                    fArr[i] = f4;
                    f3 += f4;
                    i++;
                    i3++;
                }
                if (strC4 != null) {
                    try {
                        f = Float.parseFloat(strC4) % f3;
                    } catch (NumberFormatException unused2) {
                    }
                }
                this.d.setPathEffect(new DashPathEffect(fArr, f));
            }
        }
        String strC5 = kVar.c("stroke");
        if (strC5 == null) {
            if (this.e) {
                return this.d.getColor() != 0;
            }
            this.d.setColor(0);
            return false;
        }
        if (strC5.equalsIgnoreCase("none")) {
            this.d.setColor(0);
            return false;
        }
        Integer numB = kVar.b("stroke");
        if (numB != null) {
            g(kVar, numB, false, this.d);
            return true;
        }
        this.d.setColor(0);
        return false;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i, int i2) {
        l lVar = this.v;
        if (lVar == null || !lVar.f) {
            return;
        }
        String str = lVar.e;
        if (str == null) {
            lVar.e = new String(cArr, i, i2);
        } else {
            lVar.e = String.valueOf(str).concat(new String(cArr, i, i2));
        }
        if (lVar.g > 0) {
            Paint paint = lVar.a;
            if (paint == null) {
                paint = lVar.b;
            }
            Rect rect = new Rect();
            String str2 = lVar.e;
            paint.getTextBounds(str2, 0, str2.length(), rect);
            lVar.d += lVar.g == 1 ? -rect.centerY() : rect.height();
        }
    }

    public final void d(Attributes attributes, Paint paint) {
        Typeface typefaceCreate;
        if ("none".equals(attributes.getValue("display"))) {
            return;
        }
        if (attributes.getValue("font-size") != null) {
            paint.setTextSize(a("font-size", attributes, Float.valueOf(10.0f)).floatValue());
        }
        String strD = o.d("font-family", attributes);
        String strD2 = o.d("font-style", attributes);
        String strD3 = o.d("font-weight", attributes);
        if (strD == null && strD2 == null && strD3 == null) {
            typefaceCreate = null;
        } else {
            int i = true != "italic".equals(strD2) ? 0 : 2;
            if ("bold".equals(strD3)) {
                i |= 1;
            }
            typefaceCreate = Typeface.create(strD, i);
        }
        if (typefaceCreate != null) {
            paint.setTypeface(typefaceCreate);
        }
        if (m(attributes) != null) {
            paint.setTextAlign(m(attributes));
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endDocument() {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        g gVar;
        g gVar2;
        int i = 0;
        if (this.A) {
            if (str2.equals("defs")) {
                this.A = false;
                return;
            }
            return;
        }
        if (str2.equals("svg")) {
            this.b.endRecording();
            return;
        }
        boolean z = this.x;
        if (!z && str2.equals("text")) {
            l lVar = this.v;
            if (lVar != null) {
                Canvas canvas = this.c;
                Paint paint = lVar.b;
                if (paint != null) {
                    canvas.drawText(lVar.e, lVar.c, lVar.d, paint);
                }
                Paint paint2 = lVar.a;
                if (paint2 != null) {
                    canvas.drawText(lVar.e, lVar.c, lVar.d, paint2);
                }
                this.v.f = false;
            }
            k();
            return;
        }
        if (str2.equals("linearGradient")) {
            g gVar3 = this.u;
            if (gVar3.a != null) {
                String str4 = gVar3.b;
                if (str4 != null && (gVar2 = (g) this.t.get(str4)) != null) {
                    this.u = gVar2.a(this.u);
                }
                int size = this.u.l.size();
                int[] iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = ((Integer) this.u.l.get(i2)).intValue();
                }
                int size2 = this.u.k.size();
                float[] fArr = new float[size2];
                while (i < size2) {
                    fArr[i] = ((Float) this.u.k.get(i)).floatValue();
                    i++;
                }
                g gVar4 = this.u;
                LinearGradient linearGradient = new LinearGradient(gVar4.d, gVar4.e, gVar4.f, gVar4.g, iArr, fArr, Shader.TileMode.CLAMP);
                Matrix matrix = this.u.m;
                if (matrix != null) {
                    linearGradient.setLocalMatrix(matrix);
                }
                this.s.put(this.u.a, linearGradient);
                HashMap map = this.t;
                g gVar5 = this.u;
                map.put(gVar5.a, gVar5);
                return;
            }
            return;
        }
        if (!str2.equals("radialGradient")) {
            if (str2.equals("g")) {
                if (this.z) {
                    this.z = false;
                }
                if (z) {
                    int i3 = this.y - 1;
                    this.y = i3;
                    if (i3 == 0) {
                        this.x = false;
                    }
                }
                this.s.clear();
                k();
                this.h = (Paint) this.j.pop();
                this.i = ((Boolean) this.k.pop()).booleanValue();
                this.d = (Paint) this.f.pop();
                this.e = ((Boolean) this.g.pop()).booleanValue();
                this.l = ((Float) this.m.pop()).floatValue();
                return;
            }
            return;
        }
        g gVar6 = this.u;
        if (gVar6.a != null) {
            String str5 = gVar6.b;
            if (str5 != null && (gVar = (g) this.t.get(str5)) != null) {
                this.u = gVar.a(this.u);
            }
            int size3 = this.u.l.size();
            int[] iArr2 = new int[size3];
            for (int i4 = 0; i4 < size3; i4++) {
                iArr2[i4] = ((Integer) this.u.l.get(i4)).intValue();
            }
            int size4 = this.u.k.size();
            float[] fArr2 = new float[size4];
            while (i < size4) {
                fArr2[i] = ((Float) this.u.k.get(i)).floatValue();
                i++;
            }
            g gVar7 = this.u;
            RadialGradient radialGradient = new RadialGradient(gVar7.h, gVar7.i, gVar7.j, iArr2, fArr2, Shader.TileMode.CLAMP);
            Matrix matrix2 = this.u.m;
            if (matrix2 != null) {
                radialGradient.setLocalMatrix(matrix2);
            }
            this.s.put(this.u.a, radialGradient);
            HashMap map2 = this.t;
            g gVar8 = this.u;
            map2.put(gVar8.a, gVar8);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startDocument() {
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0322 A[PHI: r0
      0x0322: PHI (r0v51 java.lang.Float) = (r0v50 java.lang.Float), (r0v49 java.lang.Float) binds: [B:136:0x0320, B:132:0x031a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        char c;
        boolean z;
        m mVar = this;
        Attributes attributes2 = attributes;
        if (!mVar.e) {
            mVar.d.setAlpha(255);
        }
        if (!mVar.i) {
            mVar.h.setAlpha(255);
        }
        float f = 0.0f;
        if (mVar.z) {
            if (str2.equals("rect")) {
                Float f2 = mVar.f("x", attributes2);
                if (f2 == null) {
                    f2 = Float.valueOf(0.0f);
                }
                Float f3 = mVar.f("y", attributes2);
                if (f3 == null) {
                    f3 = Float.valueOf(0.0f);
                }
                mVar.o = new RectF(f2.floatValue(), f3.floatValue(), f2.floatValue() + mVar.f("width", attributes2).floatValue(), f3.floatValue() + mVar.f("height", attributes2).floatValue());
                return;
            }
            return;
        }
        if (mVar.A) {
            return;
        }
        if (str2.equals("svg")) {
            mVar.c = mVar.b.beginRecording((int) Math.ceil(mVar.f("width", attributes2).floatValue()), (int) Math.ceil(mVar.f("height", attributes2).floatValue()));
            return;
        }
        boolean z2 = true;
        if (str2.equals("defs")) {
            mVar.A = true;
            return;
        }
        if (str2.equals("linearGradient")) {
            mVar.u = mVar.e(true, attributes2);
            return;
        }
        if (str2.equals("radialGradient")) {
            mVar.u = mVar.e(false, attributes2);
            return;
        }
        if (str2.equals("stop")) {
            if (mVar.u != null) {
                Float f4 = mVar.f(TypedValues.CycleType.S_WAVE_OFFSET, attributes2);
                f4.floatValue();
                n nVar = new n(o.d("style", attributes2));
                String strA = nVar.a("stop-color");
                int i = strA != null ? strA.startsWith("#") ? Integer.parseInt(strA.substring(1), 16) : Integer.parseInt(strA, 16) : -16777216;
                String strA2 = nVar.a("stop-opacity");
                int iN = n(i);
                int iRound = strA2 != null ? iN | (Math.round(Float.parseFloat(strA2) * 255.0f) << 24) : iN | ViewCompat.MEASURED_STATE_MASK;
                mVar.u.k.add(f4);
                mVar.u.l.add(Integer.valueOf(iRound));
                return;
            }
            return;
        }
        if (str2.equals("use")) {
            String value = attributes2.getValue("xlink:href");
            String value2 = attributes2.getValue(ViewProps.TRANSFORM);
            String value3 = attributes2.getValue("x");
            String value4 = attributes2.getValue("y");
            StringBuilder sb = new StringBuilder("<g xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1'");
            if (value2 != null || value3 != null || value4 != null) {
                sb.append(" transform='");
                if (value2 != null) {
                    sb.append(o.c(value2));
                }
                if (value3 != null || value4 != null) {
                    sb.append("translate(");
                    sb.append(value3 != null ? o.c(value3) : "0");
                    sb.append(",");
                    sb.append(value4 != null ? o.c(value4) : "0");
                    sb.append(")");
                }
                sb.append("'");
            }
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String qName = attributes2.getQName(i2);
                if (!"x".equals(qName) && !"y".equals(qName) && !"width".equals(qName) && !"height".equals(qName) && !"xlink:href".equals(qName) && !ViewProps.TRANSFORM.equals(qName)) {
                    sb.append(StringUtils.SPACE);
                    sb.append(qName);
                    sb.append("='");
                    sb.append(o.c(attributes2.getValue(i2)));
                    sb.append("'");
                }
            }
            sb.append(">");
            sb.append((String) mVar.a.get(value.substring(1)));
            sb.append("</g>");
            InputSource inputSource = new InputSource(new StringReader(sb.toString()));
            try {
                XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                xMLReader.setContentHandler(mVar);
                xMLReader.parse(inputSource);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (str2.equals("g")) {
            if ("bounds".equalsIgnoreCase(o.d("id", attributes2))) {
                mVar.z = true;
            }
            if (mVar.x) {
                mVar.y++;
            }
            if ("none".equals(o.d("display", attributes2)) && !mVar.x) {
                mVar.x = true;
                mVar.y = 1;
            }
            mVar.l(attributes2);
            k kVar = new k(attributes2);
            mVar.j.push(new Paint(mVar.h));
            mVar.f.push(new Paint(mVar.d));
            mVar.k.push(Boolean.valueOf(mVar.i));
            mVar.g.push(Boolean.valueOf(mVar.e));
            mVar.m.push(Float.valueOf(mVar.l));
            Float f5 = mVar.f(ViewProps.OPACITY, attributes2);
            if (f5 != null) {
                mVar.l *= f5.floatValue();
            }
            mVar.d(attributes2, mVar.h);
            mVar.d(attributes2, mVar.d);
            mVar.b(kVar, mVar.s);
            mVar.c(kVar);
            mVar.i |= kVar.c("fill") != null;
            mVar.e |= kVar.c("stroke") != null;
            return;
        }
        boolean z3 = mVar.x;
        j jVarB = null;
        if (!z3 && str2.equals("rect")) {
            Float fValueOf = Float.valueOf(0.0f);
            Float fA = mVar.a("x", attributes2, fValueOf);
            Float fA2 = mVar.a("y", attributes2, fValueOf);
            Float f6 = mVar.f("width", attributes2);
            Float f7 = mVar.f("height", attributes2);
            Float fA3 = mVar.a("rx", attributes2, null);
            Float fA4 = mVar.a("ry", attributes2, null);
            if (fA3 != null) {
                fValueOf = fA3;
                if (fA4 == null) {
                    fA4 = fValueOf;
                }
            } else if (fA4 == null) {
                fA4 = fValueOf;
            } else {
                fValueOf = fA4;
            }
            mVar.l(attributes2);
            k kVar2 = new k(attributes2);
            if (mVar.b(kVar2, mVar.s)) {
                mVar.j(fA.floatValue(), fA2.floatValue(), f6.floatValue(), f7.floatValue());
                if (fValueOf.floatValue() > 0.0f || fA4.floatValue() > 0.0f) {
                    mVar.f329n.set(fA.floatValue(), fA2.floatValue(), fA.floatValue() + f6.floatValue(), fA2.floatValue() + f7.floatValue());
                    mVar.c.drawRoundRect(mVar.f329n, fValueOf.floatValue(), fA4.floatValue(), mVar.h);
                } else {
                    mVar.c.drawRect(fA.floatValue(), fA2.floatValue(), f6.floatValue() + fA.floatValue(), f7.floatValue() + fA2.floatValue(), mVar.h);
                }
            }
            if (mVar.c(kVar2)) {
                if (fValueOf.floatValue() > 0.0f || fA4.floatValue() > 0.0f) {
                    mVar.f329n.set(fA.floatValue(), fA2.floatValue(), fA.floatValue() + f6.floatValue(), fA2.floatValue() + f7.floatValue());
                    mVar.c.drawRoundRect(mVar.f329n, fValueOf.floatValue(), fA4.floatValue(), mVar.d);
                } else {
                    mVar.c.drawRect(fA.floatValue(), fA2.floatValue(), fA.floatValue() + f6.floatValue(), fA2.floatValue() + f7.floatValue(), mVar.d);
                }
            }
            k();
            return;
        }
        if (!z3 && str2.equals("image")) {
            String strD = o.d("href", attributes2);
            if (!strD.startsWith("data") || strD.indexOf("base64") <= 0) {
                return;
            }
            String strSubstring = strD.substring(strD.indexOf(",") + 1);
            Float fValueOf2 = Float.valueOf(0.0f);
            Float fA5 = mVar.a("x", attributes2, fValueOf2);
            Float fA6 = mVar.a("y", attributes2, fValueOf2);
            Float fA7 = mVar.a("width", attributes2, fValueOf2);
            Float fA8 = mVar.a("height", attributes2, fValueOf2);
            mVar.l(attributes2);
            mVar.j(fA5.floatValue(), fA6.floatValue(), fA7.floatValue(), fA8.floatValue());
            Canvas canvas = mVar.c;
            float fFloatValue = fA5.floatValue();
            float fFloatValue2 = fA6.floatValue();
            float fFloatValue3 = fA7.floatValue();
            float fFloatValue4 = fA8.floatValue();
            byte[] bArrDecode = Base64.decode(strSubstring, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null) {
                bitmapDecodeByteArray.prepareToDraw();
                Paint paint = new Paint(3);
                RectF rectF = new RectF(fFloatValue, fFloatValue2, fFloatValue3 + fFloatValue, fFloatValue4 + fFloatValue2);
                canvas.clipRect(rectF, Region.Op.REPLACE);
                canvas.drawBitmap(bitmapDecodeByteArray, (Rect) null, rectF, paint);
                bitmapDecodeByteArray.recycle();
            }
            k();
            return;
        }
        if (!z3 && str2.equals(Property.SYMBOL_PLACEMENT_LINE)) {
            Float f8 = mVar.f("x1", attributes2);
            Float f9 = mVar.f("x2", attributes2);
            Float f10 = mVar.f("y1", attributes2);
            Float f11 = mVar.f("y2", attributes2);
            if (mVar.c(new k(attributes2))) {
                mVar.l(attributes2);
                mVar.i(f8.floatValue(), f10.floatValue());
                mVar.i(f9.floatValue(), f11.floatValue());
                mVar.c.drawLine(f8.floatValue(), f10.floatValue(), f9.floatValue(), f11.floatValue(), mVar.d);
                k();
                return;
            }
            return;
        }
        if (!z3 && str2.equals("circle")) {
            Float f12 = mVar.f("cx", attributes2);
            Float f13 = mVar.f("cy", attributes2);
            Float f14 = mVar.f("r", attributes2);
            if (f12 == null || f13 == null || f14 == null) {
                return;
            }
            mVar.l(attributes2);
            k kVar3 = new k(attributes2);
            if (mVar.b(kVar3, mVar.s)) {
                mVar.i(f12.floatValue() - f14.floatValue(), f13.floatValue() - f14.floatValue());
                mVar.i(f12.floatValue() + f14.floatValue(), f13.floatValue() + f14.floatValue());
                mVar.c.drawCircle(f12.floatValue(), f13.floatValue(), f14.floatValue(), mVar.h);
            }
            if (mVar.c(kVar3)) {
                mVar.c.drawCircle(f12.floatValue(), f13.floatValue(), f14.floatValue(), mVar.d);
            }
            k();
            return;
        }
        if (!z3 && str2.equals("ellipse")) {
            Float f15 = mVar.f("cx", attributes2);
            Float f16 = mVar.f("cy", attributes2);
            Float f17 = mVar.f("rx", attributes2);
            Float f18 = mVar.f("ry", attributes2);
            if (f15 == null || f16 == null || f17 == null || f18 == null) {
                return;
            }
            mVar.l(attributes2);
            k kVar4 = new k(attributes2);
            mVar.f329n.set(f15.floatValue() - f17.floatValue(), f16.floatValue() - f18.floatValue(), f15.floatValue() + f17.floatValue(), f16.floatValue() + f18.floatValue());
            if (mVar.b(kVar4, mVar.s)) {
                mVar.i(f15.floatValue() - f17.floatValue(), f16.floatValue() - f18.floatValue());
                mVar.i(f15.floatValue() + f17.floatValue(), f16.floatValue() + f18.floatValue());
                mVar.c.drawOval(mVar.f329n, mVar.h);
            }
            if (mVar.c(kVar4)) {
                mVar.c.drawOval(mVar.f329n, mVar.d);
            }
            k();
            return;
        }
        if (!z3 && (str2.equals("polygon") || str2.equals("polyline"))) {
            int length = attributes.getLength();
            for (int i3 = 0; i3 < length; i3++) {
                if (attributes2.getLocalName(i3).equals("points")) {
                    jVarB = o.b(attributes2.getValue(i3));
                    break;
                }
            }
            if (jVarB != null) {
                Path path = new Path();
                ArrayList arrayList = jVarB.a;
                if (arrayList.size() > 1) {
                    mVar.l(attributes2);
                    k kVar5 = new k(attributes2);
                    path.moveTo(((Float) arrayList.get(0)).floatValue(), ((Float) arrayList.get(1)).floatValue());
                    for (int i4 = 2; i4 < arrayList.size(); i4 += 2) {
                        path.lineTo(((Float) arrayList.get(i4)).floatValue(), ((Float) arrayList.get(i4 + 1)).floatValue());
                    }
                    if (str2.equals("polygon")) {
                        path.close();
                    }
                    if (mVar.b(kVar5, mVar.s)) {
                        mVar.h(path);
                        mVar.c.drawPath(path, mVar.h);
                    }
                    if (mVar.c(kVar5)) {
                        mVar.c.drawPath(path, mVar.d);
                    }
                    k();
                    return;
                }
                return;
            }
            return;
        }
        if (z3 || !str2.equals(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
            if (!z3 && str2.equals("text")) {
                mVar.l(attributes2);
                mVar.v = new l(mVar, attributes2);
                return;
            }
            if (z3) {
                return;
            }
            String str4 = "";
            for (int i5 = 0; i5 < attributes.getLength(); i5++) {
                str4 = str4 + StringUtils.SPACE + attributes2.getLocalName(i5) + "='" + attributes2.getValue(i5) + "'";
            }
            return;
        }
        String strD2 = o.d("d", attributes2);
        int length2 = strD2.length();
        a aVar = new a(strD2);
        aVar.c();
        Path path2 = new Path();
        RectF rectF2 = new RectF();
        char c2 = 'x';
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        float f22 = 0.0f;
        float f23 = 0.0f;
        float f24 = 0.0f;
        while (true) {
            int i6 = aVar.a;
            if (i6 >= length2) {
                Path path3 = path2;
                mVar.l(attributes2);
                k kVar6 = new k(attributes2);
                if (mVar.b(kVar6, mVar.s)) {
                    mVar.h(path3);
                    mVar.c.drawPath(path3, mVar.h);
                }
                if (mVar.c(kVar6)) {
                    mVar.c.drawPath(path3, mVar.d);
                }
                k();
                return;
            }
            char cCharAt = strD2.charAt(i6);
            if (Character.isDigit(cCharAt) || cCharAt == '.' || cCharAt == '-') {
                if (c2 != 'M') {
                    c = c2 == 'm' ? 'l' : 'L';
                }
                c2 = c;
            } else {
                aVar.b();
                c2 = cCharAt;
            }
            path2.computeBounds(rectF2, z2);
            switch (c2) {
                case 'A':
                case PanasonicMakernoteDirectory.TAG_FACE_RECOGNITION_INFO /* 97 */:
                    float fA9 = aVar.a();
                    float fA10 = aVar.a();
                    float fA11 = aVar.a();
                    int iA = (int) aVar.a();
                    strD2 = strD2;
                    int iA2 = (int) aVar.a();
                    float fA12 = aVar.a();
                    float fA13 = aVar.a();
                    length2 = length2;
                    if (c2 == 'a') {
                        fA12 += f20;
                        fA13 += f21;
                    }
                    float f25 = fA12;
                    rectF2 = rectF2;
                    float f26 = fA13;
                    float f27 = f19;
                    double d = f20;
                    float f28 = f22;
                    double d2 = f21;
                    double d3 = fA9;
                    double d4 = fA10;
                    double d5 = fA11;
                    aVar = aVar;
                    boolean z4 = iA == 1;
                    boolean z5 = iA2 == 1;
                    double radians = Math.toRadians(d5 % 360.0d);
                    double dCos = Math.cos(radians);
                    double dSin = Math.sin(radians);
                    boolean z6 = z5;
                    Path path4 = path2;
                    double d6 = f25;
                    double d7 = (d - d6) / 2.0d;
                    double d8 = f26;
                    double d9 = (d2 - d8) / 2.0d;
                    double dAbs = Math.abs(d3);
                    double d10 = dAbs * dAbs;
                    double dAbs2 = Math.abs(d4);
                    double d11 = dAbs2 * dAbs2;
                    double d12 = ((-dSin) * d7) + (d9 * dCos);
                    double d13 = d12 * d12;
                    double d14 = (dCos * d7) + (dSin * d9);
                    double d15 = d14 * d14;
                    double d16 = (d15 / d10) + (d13 / d11);
                    if (d16 > 1.0d) {
                        dAbs *= Math.sqrt(d16);
                        dAbs2 *= Math.sqrt(d16);
                        d11 = dAbs2 * dAbs2;
                        d10 = dAbs * dAbs;
                    }
                    double d17 = z4 == z6 ? -1.0d : 1.0d;
                    double d18 = d13 * d10;
                    double d19 = d15 * d11;
                    double d20 = (((d10 * d11) - d18) - d19) / (d18 + d19);
                    if (d20 < 0.0d) {
                        d20 = 0.0d;
                    }
                    double dSqrt = d17 * Math.sqrt(d20);
                    double d21 = (d + d6) / 2.0d;
                    double d22 = (d2 + d8) / 2.0d;
                    double d23 = ((dAbs * d12) / dAbs2) * dSqrt;
                    double d24 = dCos * d23;
                    double d25 = dSqrt * (-((dAbs2 * d14) / dAbs));
                    double d26 = dSin * d25;
                    double d27 = dSin * d23;
                    double d28 = dCos * d25;
                    double d29 = d14 - d23;
                    double d30 = -d14;
                    double d31 = -d12;
                    double d32 = (d12 - d25) / dAbs2;
                    double d33 = d29 / dAbs;
                    double d34 = (d33 * d33) + (d32 * d32);
                    double dAcos = (d32 < 0.0d ? -1.0d : 1.0d) * Math.acos(d33 / Math.sqrt(d34));
                    double d35 = (d31 - d25) / dAbs2;
                    double d36 = (d30 - d23) / dAbs;
                    double d37 = (d33 * d35) - (d32 * d36) < 0.0d ? -1.0d : 1.0d;
                    double degrees = Math.toDegrees(dAcos);
                    double degrees2 = Math.toDegrees(d37 * Math.acos(((d33 * d36) + (d32 * d35)) / Math.sqrt(d34 * ((d36 * d36) + (d35 * d35)))));
                    if (iA2 != 1) {
                        if (degrees2 > 0.0d) {
                            degrees2 -= 360.0d;
                        }
                    } else if (degrees2 < 0.0d) {
                        degrees2 += 360.0d;
                    }
                    double d38 = d22 + d27 + d28;
                    double d39 = d21 + (d24 - d26);
                    path2 = path4;
                    path2.addArc(new RectF((float) (d39 - dAbs), (float) (d38 - dAbs2), (float) (d39 + dAbs), (float) (d38 + dAbs2)), (float) (degrees % 360.0d), (float) (degrees2 % 360.0d));
                    f19 = f27;
                    f22 = f28;
                    f20 = f25;
                    f21 = f26;
                    z = false;
                    break;
                case 'C':
                case 'c':
                    float fA14 = aVar.a();
                    float fA15 = aVar.a();
                    float fA16 = aVar.a();
                    float fA17 = aVar.a();
                    float fA18 = aVar.a();
                    float fA19 = aVar.a();
                    if (c2 == 'c') {
                        fA14 += f20;
                        fA16 += f20;
                        fA18 += f20;
                        fA15 += f21;
                        fA17 += f21;
                        fA19 += f21;
                    }
                    float f29 = fA14;
                    float f30 = fA15;
                    float f31 = fA17;
                    float f32 = fA18;
                    float f33 = fA19;
                    f22 = fA16;
                    path2.cubicTo(f29, f30, f22, f31, f32, f33);
                    f19 = f31;
                    f20 = f32;
                    f21 = f33;
                    z = true;
                    length2 = length2;
                    path2 = path2;
                    break;
                case 'H':
                case 'h':
                    float fA20 = aVar.a();
                    if (c2 == 'h') {
                        path2.rLineTo(fA20, 0.0f);
                        f20 += fA20;
                    } else {
                        path2.lineTo(fA20, f21);
                        f20 = fA20;
                    }
                    z = false;
                    break;
                case 'L':
                case 'l':
                    float fA21 = aVar.a();
                    float fA22 = aVar.a();
                    if (c2 == 'l') {
                        path2.rLineTo(fA21, fA22);
                        f20 += fA21;
                        f21 += fA22;
                    } else {
                        path2.lineTo(fA21, fA22);
                        strD2 = strD2;
                        length2 = length2;
                        aVar = aVar;
                        path2 = path2;
                        rectF2 = rectF2;
                        f20 = fA21;
                        f21 = fA22;
                    }
                    z = false;
                    break;
                case PanasonicMakernoteDirectory.TAG_AF_POINT_POSITION /* 77 */:
                case 'm':
                    float fA23 = aVar.a();
                    float fA24 = aVar.a();
                    if (c2 == 'm') {
                        path2.rMoveTo(fA23, fA24);
                        f20 += fA23;
                        f21 += fA24;
                    } else {
                        path2.moveTo(fA23, fA24);
                        f20 = fA23;
                        f21 = fA24;
                    }
                    strD2 = strD2;
                    length2 = length2;
                    aVar = aVar;
                    path2 = path2;
                    rectF2 = rectF2;
                    f24 = f20;
                    f23 = f21;
                    z = false;
                    break;
                case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
                case 'q':
                    float fA25 = aVar.a();
                    float fA26 = aVar.a();
                    float fA27 = aVar.a();
                    float fA28 = aVar.a();
                    if (c2 == 'q') {
                        fA27 += f20;
                        fA28 += f21;
                        fA25 += f20;
                        fA26 += f21;
                    }
                    float f34 = fA25;
                    float f35 = fA28;
                    f22 = f34;
                    path2.cubicTo(f20, f21, f22, fA26, fA27, f35);
                    f21 = f35;
                    f19 = fA26;
                    f20 = fA27;
                    z = true;
                    length2 = length2;
                    path2 = path2;
                    break;
                case PanasonicMakernoteDirectory.TAG_ACCESSORY_TYPE /* 83 */:
                case 's':
                    float f36 = f21 + f21;
                    float f37 = f20 + f20;
                    float fA29 = aVar.a();
                    float fA30 = aVar.a();
                    float fA31 = aVar.a();
                    float fA32 = aVar.a();
                    if (c2 == 's') {
                        fA29 += f20;
                        fA31 += f20;
                        fA30 += f21;
                        fA32 += f21;
                    }
                    float f38 = fA30;
                    float f39 = fA31;
                    f22 = fA29;
                    path2.cubicTo(f37 - f22, f36 - f19, f22, f38, f39, fA32);
                    strD2 = strD2;
                    aVar = aVar;
                    rectF2 = rectF2;
                    f20 = f39;
                    f21 = fA32;
                    f19 = f38;
                    z = true;
                    length2 = length2;
                    path2 = path2;
                    c2 = c2;
                    break;
                case 'T':
                case 't':
                    float f40 = f21 + f21;
                    float f41 = f20 + f20;
                    float fA33 = aVar.a();
                    float fA34 = aVar.a();
                    if (c2 == 't') {
                        fA33 += f20;
                        fA34 += f21;
                    }
                    float f42 = fA33;
                    float f43 = fA34;
                    float f44 = f40 - f19;
                    f22 = f41 - f22;
                    path2.cubicTo(f20, f21, f22, f44, f42, f43);
                    f19 = f44;
                    f20 = f42;
                    f21 = f43;
                    z = true;
                    length2 = length2;
                    path2 = path2;
                    break;
                case ReconyxHyperFireMakernoteDirectory.TAG_USER_LABEL /* 86 */:
                case 'v':
                    float fA35 = aVar.a();
                    if (c2 == 'v') {
                        path2.rLineTo(f, fA35);
                        f21 += fA35;
                    } else {
                        path2.lineTo(f20, fA35);
                        f21 = fA35;
                    }
                    z = false;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    strD2 = strD2;
                    length2 = length2;
                    aVar = aVar;
                    path2 = path2;
                    rectF2 = rectF2;
                    f21 = f23;
                    f20 = f24;
                    z = false;
                    break;
                default:
                    strD2 = strD2;
                    length2 = length2;
                    aVar = aVar;
                    path2 = path2;
                    rectF2 = rectF2;
                    aVar.b();
                    z = false;
                    break;
            }
            aVar.c();
            if (true != z) {
                f19 = f21;
            }
            if (true != z) {
                f22 = f20;
            }
            mVar = this;
            attributes2 = attributes;
            z2 = true;
            path2 = path2;
            rectF2 = rectF2;
            length2 = length2;
            c2 = c2;
            aVar = aVar;
            f = 0.0f;
            strD2 = strD2;
        }
    }
}
