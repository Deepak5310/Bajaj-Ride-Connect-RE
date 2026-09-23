package com.spotify.android.appremote.api;

import android.graphics.Bitmap;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.types.Image;
import com.spotify.protocol.types.ImageUri;

/* JADX INFO: loaded from: classes4.dex */
public interface ImagesApi {
    CallResult<Bitmap> getImage(ImageUri imageUri);

    CallResult<Bitmap> getImage(ImageUri imageUri, Image.Dimension dimension);
}
