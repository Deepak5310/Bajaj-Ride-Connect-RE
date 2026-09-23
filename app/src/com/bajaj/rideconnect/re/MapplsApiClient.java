package com.bajaj.rideconnect.re;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Lightweight, zero-dependency Mappls (MapmyIndia) REST Client.
 * Connects directly to official Bajaj Mappls endpoints:
 * - OAuth Token: https://outpost.mappls.com/api/security/oauth/token
 * - AutoSuggest: https://atlas.mappls.com/api/places/search/json
 * - Directions:  https://apis.mappls.com/advancedmaps/v1/...
 */
public class MapplsApiClient {

    private static final String TAG = "MapplsApiClient";

    // Authoritative Bajaj Connect Credentials
    public static final String MAPPLS_REST_KEY = "b1307a05531ee9af4a58eb0b5d0674ef";
    public static final String MAPPLS_CLIENT_ID = "96dHZVzsAutdyZ2AvmkqqsfYYSPELKZV9PCQ878iRfGCNB44VijcZGViqyhWyv1S9YVKTmYPqBZXNcGiWSVtlg==";
    public static final String MAPPLS_CLIENT_SECRET = "lrFxI-iSEg8VPzd2rMwu91pNVCzbSGi-wwexOxVWGyvQxf_zqE0KnCQfAdqPb0E7hbG0fl8nWnbE5x5Q0JwcVSYeedjKx0N8";

    private static MapplsApiClient instance;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    private String cachedToken = null;
    private long tokenExpiryTimeMs = 0;

    public static synchronized MapplsApiClient getInstance() {
        if (instance == null) {
            instance = new MapplsApiClient();
        }
        return instance;
    }

    public interface TokenCallback {
        void onSuccess(String token);
        void onError(String error);
    }

    public interface PlacesCallback {
        void onSuccess(List<PlaceResult> results);
        void onError(String error);
    }

    public interface RouteCallback {
        void onSuccess(RouteResult route);
        void onError(String error);
    }

    public static class PlaceResult {
        public final String name;
        public final String address;
        public final String mapplsPin;
        public double lat;
        public double lng;
        public final double distanceMeters;
        public final String type;

        public PlaceResult(String name, String address, String mapplsPin, double lat, double lng, double distanceMeters, String type) {
            this.name = name;
            this.address = address;
            this.mapplsPin = mapplsPin;
            this.lat = lat;
            this.lng = lng;
            this.distanceMeters = distanceMeters;
            this.type = type;
        }

        public String getFormattedDistance() {
            if (distanceMeters <= 0) return "";
            if (distanceMeters < 1000) {
                return (int) distanceMeters + " m";
            }
            return String.format(java.util.Locale.US, "%.1f km", distanceMeters / 1000.0);
        }

        @Override
        public String toString() {
            return name + " (" + address + ")";
        }
    }

    public static class RouteStep {
        public final String instruction;
        public final String street;
        public final double distanceMeters;
        public final double durationSeconds;
        public final int maneuverID;
        public final double lat;
        public final double lng;

        public RouteStep(String instruction, String street, double distanceMeters,
                         double durationSeconds, int maneuverID, double lat, double lng) {
            this.instruction = instruction;
            this.street = street;
            this.distanceMeters = distanceMeters;
            this.durationSeconds = durationSeconds;
            this.maneuverID = maneuverID;
            this.lat = lat;
            this.lng = lng;
        }
    }

    public static class RouteResult {
        public final double totalDistanceMeters;
        public final double totalDurationSeconds;
        public final String geometryPolyline;
        public final List<RouteStep> steps;
        public double destLat = 0.0;
        public double destLng = 0.0;

        public RouteResult(double totalDistanceMeters, double totalDurationSeconds,
                           String geometryPolyline, List<RouteStep> steps) {
            this.totalDistanceMeters = totalDistanceMeters;
            this.totalDurationSeconds = totalDurationSeconds;
            this.geometryPolyline = geometryPolyline;
            this.steps = steps;
        }
    }

    public void getAccessToken(TokenCallback callback) {
        if (cachedToken != null && System.currentTimeMillis() < tokenExpiryTimeMs) {
            callback.onSuccess(cachedToken);
            return;
        }

        executor.execute(() -> {
            try {
                URL url = new URL("https://outpost.mappls.com/api/security/oauth/token");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setConnectTimeout(8000);
                conn.setReadTimeout(8000);
                conn.setDoOutput(true);

                String postData = "client_id=" + URLEncoder.encode(MAPPLS_CLIENT_ID, "UTF-8")
                        + "&client_secret=" + URLEncoder.encode(MAPPLS_CLIENT_SECRET, "UTF-8")
                        + "&grant_type=client_credentials";

                try (OutputStream os = conn.getOutputStream()) {
                    os.write(postData.getBytes(StandardCharsets.UTF_8));
                }

                int code = conn.getResponseCode();
                if (code == 200) {
                    String resp = readStream(conn.getInputStream());
                    JSONObject json = new JSONObject(resp);
                    String token = json.getString("access_token");
                    int expiresIn = json.optInt("expires_in", 86400);

                    cachedToken = token;
                    tokenExpiryTimeMs = System.currentTimeMillis() + ((long) (expiresIn - 120) * 1000L);
                    mainHandler.post(() -> callback.onSuccess(token));
                } else {
                    String err = "Auth HTTP " + code + ": " + readStream(conn.getErrorStream());
                    mainHandler.post(() -> callback.onError(err));
                }
            } catch (Exception e) {
                Log.w(TAG, "OAuth token fetch failed: " + e.getMessage());
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    public void searchPlaces(String query, double currentLat, double currentLng, PlacesCallback callback) {
        getAccessToken(new TokenCallback() {
            @Override
            public void onSuccess(String token) {
                executor.execute(() -> {
                    try {
                        StringBuilder sb = new StringBuilder("https://atlas.mappls.com/api/places/search/json?");
                        sb.append("query=").append(URLEncoder.encode(query, "UTF-8"));
                        if (currentLat != 0.0 && currentLng != 0.0) {
                            sb.append("&location=").append(currentLat).append(",").append(currentLng);
                        }
                        sb.append("&bridge=true");

                        URL url = new URL(sb.toString());
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Authorization", "bearer " + token);
                        conn.setRequestProperty("Accept", "application/json");
                        conn.setConnectTimeout(8000);
                        conn.setReadTimeout(8000);

                        int code = conn.getResponseCode();
                        if (code == 200) {
                            String resp = readStream(conn.getInputStream());
                            JSONObject json = new JSONObject(resp);
                            JSONArray locs = json.optJSONArray("suggestedLocations");
                            List<PlaceResult> results = new ArrayList<>();
                            if (locs != null) {
                                for (int i = 0; i < locs.length(); i++) {
                                    JSONObject loc = locs.getJSONObject(i);
                                    String name = loc.optString("placeName", "");
                                    String addr = loc.optString("placeAddress", "");
                                    String pin = loc.optString("eLoc", loc.optString("mapplsPin", ""));
                                    double lat = loc.optDouble("latitude", 0.0);
                                    double lng = loc.optDouble("longitude", 0.0);
                                    double dist = loc.optDouble("distance", 0.0);
                                    String type = loc.optString("type", "POI");
                                    results.add(new PlaceResult(name, addr, pin, lat, lng, dist, type));
                                }
                            }
                            mainHandler.post(() -> callback.onSuccess(results));
                        } else {
                            mainHandler.post(() -> callback.onError("AutoSuggest HTTP " + code));
                        }
                    } catch (Exception e) {
                        Log.w(TAG, "Search places failed: " + e.getMessage());
                        mainHandler.post(() -> callback.onError(e.getMessage()));
                    }
                });
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

    public void getDirections(double startLat, double startLng, double destLat, double destLng, RouteCallback callback) {
        getDirections(startLat, startLng, destLat, destLng, null, callback);
    }

    public void getDirections(double startLat, double startLng, double destLat, double destLng, String destEloc, RouteCallback callback) {
        executor.execute(() -> {
            try {
                // Try biking profile first, fallback to driving
                RouteResult res = requestRoute("biking", startLat, startLng, destLat, destLng, destEloc);
                if (res == null) {
                    res = requestRoute("driving", startLat, startLng, destLat, destLng, destEloc);
                }
                if (res != null) {
                    RouteResult finalRes = res;
                    mainHandler.post(() -> callback.onSuccess(finalRes));
                } else {
                    mainHandler.post(() -> callback.onError("No route found"));
                }
            } catch (Exception e) {
                Log.w(TAG, "Directions request failed: " + e.getMessage());
                mainHandler.post(() -> callback.onError(e.getMessage()));
            }
        });
    }

    private RouteResult requestRoute(String profile, double startLat, double startLng, double destLat, double destLng, String destEloc) {
        try {
            String coords;
            if (destEloc != null && !destEloc.trim().isEmpty()) {
                coords = String.format(java.util.Locale.US, "%.6f,%.6f;%s", startLng, startLat, destEloc.trim());
            } else {
                coords = String.format(java.util.Locale.US, "%.6f,%.6f;%.6f,%.6f", startLng, startLat, destLng, destLat);
            }
            String urlStr = "https://apis.mappls.com/advancedmaps/v1/" + MAPPLS_REST_KEY
                    + "/route_adv/" + profile + "/" + coords
                    + "?steps=true&overview=full&geometries=polyline6&alternatives=true";

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(9000);
            conn.setReadTimeout(9000);

            if (conn.getResponseCode() != 200) {
                return null;
            }

            String resp = readStream(conn.getInputStream());
            JSONObject json = new JSONObject(resp);
            JSONArray routes = json.optJSONArray("routes");
            if (routes == null || routes.length() == 0) return null;

            JSONObject route = routes.getJSONObject(0);
            double totalDist = route.optDouble("distance", 0.0);
            double totalDur = route.optDouble("duration", 0.0);
            String polyline = route.optString("geometry", "");

            List<RouteStep> steps = new ArrayList<>();
            JSONArray legs = route.optJSONArray("legs");
            if (legs != null && legs.length() > 0) {
                JSONArray stepsArr = legs.getJSONObject(0).optJSONArray("steps");
                if (stepsArr != null) {
                    for (int i = 0; i < stepsArr.length(); i++) {
                        JSONObject s = stepsArr.getJSONObject(i);
                        double dist = s.optDouble("distance", 0.0);
                        double dur = s.optDouble("duration", 0.0);
                        String name = s.optString("name", "");

                        JSONObject man = s.optJSONObject("maneuver");
                        String instr = "";
                        int manId = 0;
                        double stepLat = 0.0;
                        double stepLng = 0.0;

                        if (man != null) {
                            instr = man.optString("instruction", name);
                            String type = man.optString("type", "");
                            String modifier = man.optString("modifier", "");
                            manId = resolveMapplsManeuverId(type, modifier, s.optInt("maneuverID", 0));

                            JSONArray loc = man.optJSONArray("location");
                            if (loc != null && loc.length() >= 2) {
                                stepLng = loc.getDouble(0);
                                stepLat = loc.getDouble(1);
                            }
                        }
                        steps.add(new RouteStep(instr, name, dist, dur, manId, stepLat, stepLng));
                    }
                }
            }

            return new RouteResult(totalDist, totalDur, polyline, steps);
        } catch (Exception e) {
            Log.d(TAG, "Route profile " + profile + " error: " + e.getMessage());
            return null;
        }
    }

    private int resolveMapplsManeuverId(String type, String modifier, int explicitId) {
        if (explicitId > 0) return explicitId;

        if ("arrive".equalsIgnoreCase(type)) return 8; // Destination reached
        if ("depart".equalsIgnoreCase(type)) return 0; // Straight
        if ("roundabout".equalsIgnoreCase(type) || "rotary".equalsIgnoreCase(type)) return 58;

        if ("turn".equalsIgnoreCase(type) || "fork".equalsIgnoreCase(type) || "end of road".equalsIgnoreCase(type)) {
            if ("left".equalsIgnoreCase(modifier)) return 19;
            if ("right".equalsIgnoreCase(modifier)) return 2;
            if ("sharp left".equalsIgnoreCase(modifier)) return 20;
            if ("sharp right".equalsIgnoreCase(modifier)) return 3;
            if ("slight left".equalsIgnoreCase(modifier)) return 15;
            if ("slight right".equalsIgnoreCase(modifier)) return 1;
            if ("uturn".equalsIgnoreCase(modifier)) return 4;
        }

        if ("continue".equalsIgnoreCase(type) || "straight".equalsIgnoreCase(modifier)) return 0;
        return 7; // Default continue/keep
    }

    private static String readStream(InputStream is) throws Exception {
        if (is == null) return "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
            return sb.toString();
        }
    }
}

