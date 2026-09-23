package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public class ProtoStorageClient {
    private final Application application;
    private final String fileName;

    public ProtoStorageClient(Application application, String str) {
        this.application = application;
        this.fileName = str;
    }

    public Completable write(final AbstractMessageLite abstractMessageLite) {
        return Completable.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.ProtoStorageClient$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1710xb45a41fd(abstractMessageLite);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$write$0$com-google-firebase-inappmessaging-internal-ProtoStorageClient, reason: not valid java name */
    /* synthetic */ Object m1710xb45a41fd(AbstractMessageLite abstractMessageLite) throws Exception {
        synchronized (this) {
            FileOutputStream fileOutputStreamOpenFileOutput = this.application.openFileOutput(this.fileName, 0);
            try {
                fileOutputStreamOpenFileOutput.write(abstractMessageLite.toByteArray());
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return abstractMessageLite;
    }

    public <T extends AbstractMessageLite> Maybe<T> read(final Parser<T> parser) {
        return Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.ProtoStorageClient$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1709xe77c986b(parser);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$read$1$com-google-firebase-inappmessaging-internal-ProtoStorageClient, reason: not valid java name */
    /* synthetic */ AbstractMessageLite m1709xe77c986b(Parser parser) throws Exception {
        synchronized (this) {
            try {
                try {
                    FileInputStream fileInputStreamOpenFileInput = this.application.openFileInput(this.fileName);
                    try {
                        AbstractMessageLite abstractMessageLite = (AbstractMessageLite) parser.parseFrom(fileInputStreamOpenFileInput);
                        if (fileInputStreamOpenFileInput != null) {
                            fileInputStreamOpenFileInput.close();
                        }
                        return abstractMessageLite;
                    } catch (Throwable th) {
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            } catch (InvalidProtocolBufferException | FileNotFoundException e) {
                Logging.logi("Recoverable exception while reading cache: " + e.getMessage());
                return null;
            }
        }
    }
}
