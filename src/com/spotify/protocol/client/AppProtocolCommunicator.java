package com.spotify.protocol.client;

import com.spotify.protocol.AppProtocol;
import com.spotify.protocol.WampClient;
import com.spotify.protocol.WampMessage;
import com.spotify.protocol.error.SpotifyAppRemoteException;
import com.spotify.protocol.mappers.JsonMapper;
import com.spotify.protocol.mappers.JsonMappingException;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.HelloDetails;
import com.spotify.protocol.types.Info;
import com.spotify.protocol.types.Message;
import com.spotify.protocol.types.Roles;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AppProtocolCommunicator implements WampClient, AppProtocolIo.DataInput, WampClient.Sender {
    private static final int PROTOCOL_VERSION = 1;
    private static final String SPOTIFY_REALM = "spotify";
    private final HelloDetails mHelloDetails;
    private final JsonMapper mJsonMapper;
    private final AppProtocolIo mProtocolIo;
    private final WampClient.Router mRouter = new WampRouterImpl();

    @Override // com.spotify.protocol.WampClient.Sender
    public void sendCancel(int i, Object obj) {
    }

    public AppProtocolCommunicator(ConnectionDetails connectionDetails, JsonMapper jsonMapper, AppProtocolIo appProtocolIo) {
        this.mJsonMapper = jsonMapper;
        this.mProtocolIo = appProtocolIo;
        this.mHelloDetails = new HelloDetails(new Roles(null, null, new Empty(), new Empty()), new Info(1, connectionDetails.getRequiredFeatures(), connectionDetails.getId(), connectionDetails.getName(), connectionDetails.getModel(), connectionDetails.getCategory(), connectionDetails.getVersion(), null, connectionDetails.getImageWidth(), connectionDetails.getImageHeight(), connectionDetails.getThumbnailImageHeight(), connectionDetails.getThumbnailImageHeight()), connectionDetails.getAuthMethods(), connectionDetails.getAuthId(), connectionDetails.getExtras());
        appProtocolIo.setDataInput(this);
    }

    public void setMessageReceiver(WampClient.Receiver receiver) {
        this.mRouter.addReceiver(receiver);
    }

    @Override // com.spotify.protocol.client.AppProtocolIo.DataInput
    public void onData(byte[] bArr, int i) {
        try {
            this.mRouter.route(new WampMessage(this.mJsonMapper.toJsonArray(new String(bArr, Charset.forName("UTF-8")))));
        } catch (JsonMappingException e) {
            Debug.e(e, "Message is not parsed.", new Object[0]);
        }
    }

    private void sendWamp(Object[] objArr) throws SpotifyAppRemoteException {
        try {
            byte[] bytes = this.mJsonMapper.toJson(Arrays.asList(objArr)).getBytes(Charset.forName("UTF-8"));
            this.mProtocolIo.writeData(bytes, bytes.length);
        } catch (JsonMappingException e) {
            throw new SpotifyAppRemoteException(e);
        }
    }

    @Override // com.spotify.protocol.WampClient.Sender
    public void sendHello() throws SpotifyAppRemoteException {
        sendWamp(new Object[]{1, SPOTIFY_REALM, this.mHelloDetails});
    }

    @Override // com.spotify.protocol.WampClient.Sender
    public void sendGoodbye() throws SpotifyAppRemoteException {
        sendWamp(new Object[]{6, new Message("The client is shutting down"), WampClient.WAMP_CLIENT_REQUEST_SYSTEM_SHUTDOWN});
    }

    @Override // com.spotify.protocol.WampClient.Sender
    public void sendSubscribe(int i, Object obj, String str) throws SpotifyAppRemoteException {
        sendWamp(new Object[]{32, Integer.valueOf(i), obj, str});
    }

    @Override // com.spotify.protocol.WampClient.Sender
    public void sendUnsubscribe(int i, int i2) throws SpotifyAppRemoteException {
        sendWamp(new Object[]{34, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    @Override // com.spotify.protocol.WampClient.Sender
    public void sendCall(int i, Object obj, String str) throws SpotifyAppRemoteException {
        sendWamp(new Object[]{48, Integer.valueOf(i), AppProtocol.EMPTY, str});
    }

    @Override // com.spotify.protocol.WampClient.Sender
    public void sendCall(int i, Object obj, String str, List<Object> list) throws SpotifyAppRemoteException {
        sendWamp(new Object[]{48, Integer.valueOf(i), AppProtocol.EMPTY, str, list});
    }

    @Override // com.spotify.protocol.WampClient.Sender
    public void sendCall(int i, Object obj, String str, List<Object> list, Object obj2) throws SpotifyAppRemoteException {
        sendWamp(new Object[]{48, Integer.valueOf(i), AppProtocol.EMPTY, str, list, obj2});
    }
}
