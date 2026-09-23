package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.ContentApi;
import com.spotify.protocol.AppProtocol;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Coding;
import com.spotify.protocol.client.RemoteClient;
import com.spotify.protocol.types.ChildrenPageRequest;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.GetRecommendedContentItemsRequest;
import com.spotify.protocol.types.Identifier;
import com.spotify.protocol.types.ListItem;
import com.spotify.protocol.types.ListItems;

/* JADX INFO: loaded from: classes4.dex */
public class ContentApiImpl implements ContentApi {
    private final RemoteClient mRemoteClient;

    public ContentApiImpl(RemoteClient remoteClient) {
        this.mRemoteClient = remoteClient;
    }

    @Override // com.spotify.android.appremote.api.ContentApi
    public CallResult<ListItems> getRecommendedContentItems(String str) {
        Validate.checkNotNull(str);
        return this.mRemoteClient.call(AppProtocol.CallUri.GET_RECOMMENDED_ROOT_ITEMS, new GetRecommendedContentItemsRequest(str), ListItems.class);
    }

    @Override // com.spotify.android.appremote.api.ContentApi
    public CallResult<ListItems> getChildrenOfItem(ListItem listItem, int i, int i2) {
        Validate.checkNotNull(listItem);
        return this.mRemoteClient.call(AppProtocol.CallUri.GET_CHILDREN_OF_ITEM, new ChildrenPageRequest(listItem.id, i, i2), ListItems.class);
    }

    @Override // com.spotify.android.appremote.api.ContentApi
    public CallResult<Empty> playContentItem(ListItem listItem) {
        Coding.checkNotNull(listItem);
        if (!listItem.playable) {
            throw new IllegalArgumentException("The ContentItem is not playable.");
        }
        return this.mRemoteClient.call(AppProtocol.CallUri.PLAY_ITEM, new Identifier(listItem.id), Empty.class);
    }
}
