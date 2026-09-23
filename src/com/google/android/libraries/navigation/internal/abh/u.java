package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.PinConfig;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u extends x {
    public final PinConfig a;
    private final fa b = new fa();
    private be c;
    private Canvas d;
    private Bitmap e;
    private Paint f;
    private float g;

    public u(PinConfig pinConfig) {
        this.a = pinConfig;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.x
    public final Bitmap a(be beVar) {
        this.c = beVar;
        float fMax = Math.max(20, Math.min(OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE, beVar.m().densityDpi)) / 160.0f;
        this.g = fMax;
        this.e = Bitmap.createBitmap(Math.round(26.0f * fMax), Math.round(fMax * 37.0f), Bitmap.Config.ARGB_8888);
        this.f = new Paint(1);
        this.d = new Canvas(this.e);
        this.f.setColor(this.a.getBorderColor());
        this.d.drawPath(fa.a("M13 0C5.8175 0 0 5.77328 0 12.9181C0 20.5733 5.59 23.444 9.55499 30.0784C12.09 34.3207 11.3425 37 13 37C14.7225 37 13.975 34.2569 16.445 30.1422C20.085 23.8586 26 20.6052 26 12.9181C26 5.77328 20.1825 0 13 0Z", this.g), this.f);
        this.f.setColor(this.a.getBackgroundColor());
        this.d.drawPath(fa.a("M13.0167 35C12.7836 35 12.7171 34.9346 12.3176 33.725C11.9848 32.6789 11.4854 31.0769 10.1873 29.1154C8.92233 27.1866 7.59085 25.6173 6.32594 24.1135C3.36339 20.5174 1 17.7057 1 12.6385C1.03329 6.19808 6.39251 1 13.0167 1C19.6408 1 25 6.23078 25 12.6385C25 17.7057 22.6699 20.55 19.6741 24.1462C18.4425 25.65 17.1443 27.2193 15.8793 29.1154C14.6144 31.0442 14.0818 32.6135 13.749 33.6596C13.3495 34.9346 13.2497 35 13.0167 35Z", this.g), this.f);
        PinConfig.Glyph glyph = this.a.getGlyph();
        if (glyph.getBitmapDescriptor() != null) {
            z zVar = new z(this.c);
            x xVar = (x) com.google.android.libraries.navigation.internal.lo.n.b(glyph.getBitmapDescriptor().a);
            zVar.b(xVar);
            Bitmap bitmapA = zVar.a(xVar);
            this.d.drawBitmap(bitmapA, (Rect) null, new RectF((this.g * 13.0f) - (bitmapA.getWidth() / 2.0f), (this.g * 13.0f) - (bitmapA.getHeight() / 2.0f), (this.g * 13.0f) + (bitmapA.getWidth() / 2.0f), (this.g * 13.0f) + (bitmapA.getHeight() / 2.0f)), (Paint) null);
        } else if (glyph.getText() != null) {
            String text = glyph.getText();
            this.f.setColor(glyph.getTextColor());
            this.f.setTextSize(this.g * 12.0f);
            this.d.drawText(text, Math.round((this.g * 13.0f) - (this.f.measureText(text) / 2.0f)), Math.round((this.g * 13.0f) - ((this.f.descent() + this.f.ascent()) / 2.0f)), this.f);
        } else {
            this.f.setColor(this.a.getGlyph().getGlyphColor());
            Canvas canvas = this.d;
            float f = this.g;
            float f2 = 13.0f * f;
            canvas.drawCircle(f2, f2, f * 5.0f, this.f);
        }
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        PinConfig pinConfig = ((u) obj).a;
        return this.a.getBackgroundColor() == pinConfig.getBackgroundColor() && this.a.getBorderColor() == pinConfig.getBorderColor() && this.a.getGlyph().equals(pinConfig.getGlyph());
    }

    public final int hashCode() {
        PinConfig.Glyph glyph = this.a.getGlyph();
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a.getBackgroundColor()), Integer.valueOf(this.a.getBorderColor()), glyph.getBitmapDescriptor(), glyph.getText(), Integer.valueOf(glyph.getGlyphColor())});
    }

    public final String toString() {
        PinConfig.Glyph glyph = this.a.getGlyph();
        com.google.android.libraries.navigation.internal.abf.aj ajVarC = com.google.android.libraries.navigation.internal.abf.aj.f(this).c(ViewProps.BACKGROUND_COLOR, this.a.getBackgroundColor()).c(ViewProps.BORDER_COLOR, this.a.getBorderColor());
        ajVarC.g("glyphBitmapDescriptor", glyph.getBitmapDescriptor());
        ajVarC.g("glyphText", glyph.getText());
        return ajVarC.c("glyphColor", glyph.getGlyphColor()).toString();
    }
}
