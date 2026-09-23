package com.spotify.protocol;

import com.spotify.protocol.types.Empty;

/* JADX INFO: loaded from: classes4.dex */
public final class AppProtocol {
    public static final Empty EMPTY = new Empty();

    public interface ErrorUri {
        public static final String ERROR_AUTHENTICATION_FAILED = "com.spotify.error.client_authentication_failed";
        public static final String ERROR_FEATURE_VERSION_MISMATCH = "com.spotify.error.unsupported_version";
        public static final String ERROR_INVALID_ARGUMENT = "wamp.error.invalid_argument";
        public static final String ERROR_INVALID_URI = "wamp.error.invalid_uri";
        public static final String ERROR_NOT_LOGGED_IN = "com.spotify.error.not_logged_in";
        public static final String ERROR_OFFLINE_MODE_ACTIVE = "com.spotify.error.offline_mode_active";
        public static final String ERROR_USER_NOT_AUTHORIZED = "com.spotify.error.user_not_authorized";
        public static final String WAMP_ERROR = "wamp.error";
        public static final String WAMP_ERROR_NOT_AUTHORIZED = "wamp.error.not_authorized";
        public static final String WAMP_ERROR_SYSTEM_SHUTDOWN = "wamp.error.system_shutdown";
    }

    private AppProtocol() {
    }

    public static class Topic {
        public static final String CAPABILITIES = "com.spotify.capabilities";
        public static final String CONNECT_VOLUME_STATE = "com.spotify.volume.volume_state";
        public static final String PLAYER_CONTEXT = "com.spotify.current_context";
        public static final String PLAYER_STATE = "com.spotify.player_state";
        public static final String STATUS = "com.spotify.status";

        private Topic() {
        }
    }

    public static class CallUri {
        public static final String CAPABILITIES = "com.spotify.get_capabilities";
        public static final String CONNECT_DECREASE_VOLUME = "com.spotify.volume.decrease_volume";
        public static final String CONNECT_INCREASE_VOLUME = "com.spotify.volume.increase_volume";
        public static final String CONNECT_SET_VOLUME = "com.spotify.volume.set_volume";
        public static final String CONNECT_SWITCH_TO_LOCAL_DEVICE = "com.spotify.connect_switch_to_local_device";
        public static final String GET_CHILDREN_OF_ITEM = "com.spotify.get_children_of_item";
        public static final String GET_CROSSFADE = "com.spotify.get_crossfade";
        public static final String GET_IMAGE = "com.spotify.get_image";
        public static final String GET_PLAYER_STATE = "com.spotify.get_player_state";
        public static final String GET_RECOMMENDED_ROOT_ITEMS = "com.spotify.get_recommended_root_items";
        public static final String GET_SAVED = "com.spotify.get_saved";
        public static final String GET_THUMBNAIL_IMAGE = "com.spotify.get_thumbnail_image";
        public static final String PLAY_ITEM = "com.spotify.play_item";
        public static final String PLAY_QUEUE = "com.spotify.queue_spotify_uri";
        public static final String PLAY_URI = "com.spotify.play_spotify_uri";
        public static final String PLAY_URI_WITH_OPTION_EXTRAS = "com.spotify.play_spotify_uri_option_extras";
        public static final String SEEK_TO_RELATIVE_POSITION = "com.spotify.seek_to_relative_position";
        public static final String SET_PLAYBACK_POSITION = "com.spotify.set_playback_position";
        public static final String SET_PLAYBACK_SPEED = "com.spotify.set_playback_speed";
        public static final String SET_REPEAT = "com.spotify.set_repeat";
        public static final String SET_SAVED = "com.spotify.set_saved";
        public static final String SET_SHUFFLE = "com.spotify.set_shuffle";
        public static final String SKIP_NEXT = "com.spotify.skip_next";
        public static final String SKIP_PREVIOUS = "com.spotify.skip_previous";
        public static final String SKIP_TO_INDEX = "com.spotify.skip_to_index";
        public static final String TOGGLE_REPEAT = "com.spotify.toggle_repeat";
        public static final String TOGGLE_SHUFFLE = "com.spotify.toggle_shuffle";

        private CallUri() {
        }
    }

    public static class ItemId {
        public static final String RECENTLY_PLAYED = "com.spotify.recently-played";

        private ItemId() {
        }
    }
}
