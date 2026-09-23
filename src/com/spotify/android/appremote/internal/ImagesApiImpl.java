package com.spotify.android.appremote.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.spotify.android.appremote.api.ImagesApi;
import com.spotify.protocol.AppProtocol;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Coding;
import com.spotify.protocol.client.ErrorCallback;
import com.spotify.protocol.client.RemoteClient;
import com.spotify.protocol.client.ResultUtils;
import com.spotify.protocol.types.Image;
import com.spotify.protocol.types.ImageIdentifier;
import com.spotify.protocol.types.ImageUri;
import com.spotify.protocol.types.Types;

/* JADX INFO: loaded from: classes4.dex */
public class ImagesApiImpl implements ImagesApi {
    private final RemoteClient mRemoteClient;

    public ImagesApiImpl(RemoteClient remoteClient) {
        this.mRemoteClient = (RemoteClient) Coding.checkNotNull(remoteClient);
    }

    @Override // com.spotify.android.appremote.api.ImagesApi
    public CallResult<Bitmap> getImage(ImageUri imageUri) {
        return getImage(imageUri, Image.Dimension.LARGE);
    }

    @Override // com.spotify.android.appremote.api.ImagesApi
    public CallResult<Bitmap> getImage(ImageUri imageUri, Image.Dimension dimension) {
        CallResult callResultCall = this.mRemoteClient.call(AppProtocol.CallUri.GET_IMAGE, new ImageIdentifier(imageUri.raw, dimension), Image.class);
        final CallResult<Bitmap> callResult = new CallResult<>(Types.RequestId.NONE);
        callResultCall.setResultCallback(new CallResult.ResultCallback() { // from class: com.spotify.android.appremote.internal.ImagesApiImpl$$ExternalSyntheticLambda0
            @Override // com.spotify.protocol.client.CallResult.ResultCallback
            public final void onResult(Object obj) {
                ImagesApiImpl.lambda$getImage$0(callResult, (Image) obj);
            }
        });
        callResultCall.setErrorCallback(new ErrorCallback() { // from class: com.spotify.android.appremote.internal.ImagesApiImpl$$ExternalSyntheticLambda1
            @Override // com.spotify.protocol.client.ErrorCallback
            public final void onError(Throwable th) {
                callResult.deliverError(th);
            }
        });
        return callResult;
    }

    static /* synthetic */ void lambda$getImage$0(CallResult callResult, Image image) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            callResult.deliverResult(ResultUtils.createSuccessfulResult(BitmapFactory.decodeByteArray(image.imageData, 0, image.imageData.length, options)));
        } catch (Exception e) {
            callResult.deliverError(e);
        }
    }
}
