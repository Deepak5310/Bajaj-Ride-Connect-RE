package com.drew.imaging;

import com.drew.lang.CompoundException;

/* JADX INFO: loaded from: classes3.dex */
public class ImageProcessingException extends CompoundException {
    private static final long serialVersionUID = -9115669182209912676L;

    public ImageProcessingException(String str) {
        super(str);
    }

    public ImageProcessingException(String str, Throwable th) {
        super(str, th);
    }

    public ImageProcessingException(Throwable th) {
        super(th);
    }
}
