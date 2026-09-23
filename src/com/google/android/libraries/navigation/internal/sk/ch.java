package com.google.android.libraries.navigation.internal.sk;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ch implements ce {
    public static final /* synthetic */ int a = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.ch");
    private static final MediaPlayer.OnErrorListener c = new cf();
    private static final MediaPlayer.OnInfoListener d = new cg();
    private final Executor e;
    private final com.google.android.libraries.navigation.internal.hn.r f;

    public ch(Executor executor, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.e = executor;
        this.f = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.ce
    public final c a(Resources resources, int i, com.google.android.libraries.navigation.internal.sl.s sVar) {
        AssetFileDescriptor assetFileDescriptorOpenRawResourceFd;
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.e();
        try {
            assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(i);
        } catch (Resources.NotFoundException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1479)).o();
            assetFileDescriptorOpenRawResourceFd = null;
        }
        if (assetFileDescriptorOpenRawResourceFd == null) {
            return null;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnErrorListener(c);
        mediaPlayer.setOnInfoListener(d);
        try {
            assetFileDescriptorOpenRawResourceFd.getFileDescriptor();
            assetFileDescriptorOpenRawResourceFd.getStartOffset();
            assetFileDescriptorOpenRawResourceFd.getLength();
            mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
            assetFileDescriptorOpenRawResourceFd.close();
            mediaPlayer.setAudioStreamType(3);
            int i2 = b.f;
            resources.getResourceName(i);
            return c(mediaPlayer, sVar, i2);
        } catch (Exception unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1478)).p("Error loading sound file from resource");
            mediaPlayer.release();
            return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.ce
    public final c b(File file, com.google.android.libraries.navigation.internal.sl.s sVar, int i) {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.e();
        if (!file.exists()) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.FULL)).F(1474)).p("MediaAlert file doesn't exist");
            return null;
        }
        if (!file.canRead()) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.FULL)).F(1473)).p("MediaAlert file doesn't have read permissions");
            return null;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnErrorListener(c);
        mediaPlayer.setOnInfoListener(d);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                mediaPlayer.setDataSource(fileInputStream.getFD());
                mediaPlayer.setAudioStreamType(3);
                file.getPath();
                c cVarC = c(mediaPlayer, sVar, i);
                fileInputStream.close();
                return cVarC;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1472)).p("Exception creating MediaAlert from file");
            mediaPlayer.release();
            return null;
        }
    }

    public final c c(MediaPlayer mediaPlayer, com.google.android.libraries.navigation.internal.sl.s sVar, int i) {
        return new cd(mediaPlayer, sVar, this.e, i, this.f);
    }
}
