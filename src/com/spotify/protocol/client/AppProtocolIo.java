package com.spotify.protocol.client;

import com.spotify.protocol.error.SpotifyAppRemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface AppProtocolIo {

    public interface DataInput {
        void onData(byte[] bArr, int i);
    }

    PendingResult<Void> connect();

    void disconnect();

    boolean isConnected();

    boolean isConnecting();

    void setDataInput(DataInput dataInput);

    void writeData(byte[] bArr, int i) throws SpotifyAppRemoteException;
}
