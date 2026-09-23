package com.bajajconnect.wifi.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bajajconnect.R;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.StreamingImageHandler;
import com.bajajconnect.wifi.TouchPoint;

/* JADX INFO: loaded from: classes3.dex */
public class TftRouteInfoScreen {
    private Context context;
    private final View view;

    public void injectTouchPoints(TouchPoint touchPoint) {
    }

    public TftRouteInfoScreen(Context context) {
        this.context = context;
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tft_route_info_layout, (ViewGroup) null);
        this.view = viewInflate;
        viewInflate.measure(View.MeasureSpec.getSize(viewInflate.getMeasuredWidth()), View.MeasureSpec.getSize(viewInflate.getMeasuredHeight()));
        viewInflate.layout(0, 0, 800, StreamingImageHandler.TFT_HEIGHT);
    }

    public View getView() {
        return this.view;
    }

    public Bitmap drawView(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(800, StreamingImageHandler.TFT_HEIGHT, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.save();
            if (bitmap != null) {
                if (bitmap.getWidth() > 800 || bitmap.getHeight() > 480) {
                    canvas.drawBitmap(bitmap, new Rect(0, 0, 800, StreamingImageHandler.TFT_HEIGHT), new Rect(0, 0, 800, StreamingImageHandler.TFT_HEIGHT), (Paint) null);
                } else {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                }
            }
            canvas.restore();
            canvas.save();
            this.view.draw(canvas);
            canvas.restore();
            if (MirroringGlobarVar.isSearchProcessing) {
                canvas.save();
                canvas.translate(0.0f, 0.0f);
                StreamingImageHandler.navigationSearchScreen.progressView.getView().draw(canvas);
                canvas.restore();
            }
            return bitmapCreateBitmap;
        } catch (Exception unused) {
            return null;
        }
    }
}
