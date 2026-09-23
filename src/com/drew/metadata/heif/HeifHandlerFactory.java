package com.drew.metadata.heif;

import com.drew.imaging.heif.HeifHandler;
import com.drew.metadata.Metadata;
import com.drew.metadata.heif.boxes.HandlerBox;

/* JADX INFO: loaded from: classes3.dex */
public class HeifHandlerFactory {
    private static final String HANDLER_PICTURE = "pict";
    private HeifHandler caller;

    public HeifHandlerFactory(HeifHandler heifHandler) {
        this.caller = heifHandler;
    }

    public HeifHandler getHandler(HandlerBox handlerBox, Metadata metadata) {
        if (handlerBox.getHandlerType().equals(HANDLER_PICTURE)) {
            return new HeifPictureHandler(metadata);
        }
        return this.caller;
    }
}
