package com.bajaj.rideconnect.re;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import org.json.JSONArray;

import java.util.List;

/**
 * High-performance, hardware-accelerated Dark Knight Cockpit MapView.
 * Embeds Mappls (MapmyIndia) interactive vector map engine with native Javascript bridge.
 * Features:
 * - 60 FPS vector tile rendering with Dark/Night automotive styling
 * - Real-time vehicle location puck with heading orientation
 * - Turn-by-turn route polyline with neon cyan glow
 * - Seamless offline radar fallback
 */
public class MapplsMapView extends FrameLayout {

    private WebView webView;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private boolean isMapLoaded = false;
    private double lastLat = 28.6139; // Default New Delhi
    private double lastLng = 77.2090;
    private float lastBearing = 0f;
    private String currentAccentHex = "#38BDF8";
    private String currentAccentRgb = "56, 189, 248";
    private boolean isDarkMode = true;
    private final Path clipPath = new Path();
    private final RectF rectF = new RectF();
    private float cornerRadiusDp = 0f;

    public interface OnMapReadyCallback {
        void onMapReady();
    }

    public interface OnMapClickListener {
        void onMapClick(double lat, double lng);
    }

    public interface OnMapInteractionListener {
        void onMapDragged();
        void onMapRecentered();
        void onMapBearingChanged(double bearing);
        void onOrientationModeChanged(boolean is3D, double bearing);
    }

    private OnMapReadyCallback mapReadyCallback;
    private OnMapClickListener mapClickListener;
    private OnMapInteractionListener mapInteractionListener;

    public MapplsMapView(Context context) {
        super(context);
        init(context);
    }

    public MapplsMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MapplsMapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setOnMapReadyCallback(OnMapReadyCallback callback) {
        this.mapReadyCallback = callback;
        if (isMapLoaded && callback != null) {
            callback.onMapReady();
        }
    }

    public void setOnMapClickListener(OnMapClickListener listener) {
        this.mapClickListener = listener;
    }

    public void setOnMapInteractionListener(OnMapInteractionListener listener) {
        this.mapInteractionListener = listener;
    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    private void init(Context context) {
        setBackgroundColor(Color.TRANSPARENT);
        float density = context.getResources().getDisplayMetrics().density;
        if (cornerRadiusDp > 0f) {
            setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    if (view.getWidth() > 0 && view.getHeight() > 0) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), cornerRadiusDp * density);
                    }
                }
            });
            setClipToOutline(true);
        } else {
            setClipToOutline(false);
        }

        try {
            android.content.SharedPreferences prefs = context.getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE);
            float savedLat = prefs.getFloat("saved_rider_lat", 0.0f);
            float savedLng = prefs.getFloat("saved_rider_lng", 0.0f);
            if (savedLat != 0.0f && savedLng != 0.0f) {
                lastLat = savedLat;
                lastLng = savedLng;
            }
        } catch (Exception ignored) {}

        webView = new WebView(context);
        webView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        webView.setBackgroundColor(Color.TRANSPARENT);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setAllowFileAccess(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);
        ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);

        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void onMapInitialized() {
                mainHandler.post(() -> {
                    isMapLoaded = true;
                    if (currentAccentHex != null) {
                        String script = String.format(java.util.Locale.US,
                                "setMapAccentColor('%s', '%s');", currentAccentHex, currentAccentRgb);
                        webView.evaluateJavascript(script, null);
                    }
                    webView.evaluateJavascript("setMapTheme(" + isDarkMode + ");", null);
                    if (mapReadyCallback != null) {
                        mapReadyCallback.onMapReady();
                    }
                });
            }

            @JavascriptInterface
            public void onMapTapped(double lat, double lng) {
                mainHandler.post(() -> {
                    if (mapClickListener != null) {
                        mapClickListener.onMapClick(lat, lng);
                    }
                });
            }

            @JavascriptInterface
            public void onMapDragged() {
                mainHandler.post(() -> {
                    if (mapInteractionListener != null) {
                        mapInteractionListener.onMapDragged();
                    }
                });
            }

            @JavascriptInterface
            public void onMapRecentered() {
                mainHandler.post(() -> {
                    if (mapInteractionListener != null) {
                        mapInteractionListener.onMapRecentered();
                    }
                });
            }

            @JavascriptInterface
            public void onMapBearingChanged(double bearing) {
                mainHandler.post(() -> {
                    if (mapInteractionListener != null) {
                        mapInteractionListener.onMapBearingChanged(bearing);
                    }
                });
            }

            @JavascriptInterface
            public void onOrientationModeChanged(boolean is3D, double bearing) {
                mainHandler.post(() -> {
                    if (mapInteractionListener != null) {
                        mapInteractionListener.onOrientationModeChanged(is3D, bearing);
                    }
                });
            }
        }, "AndroidBridge");

        webView.setWebChromeClient(new android.webkit.WebChromeClient() {
            @Override
            public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
                android.util.Log.d("MapplsMapView", "Console [" + consoleMessage.messageLevel() + "]: "
                        + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")");
                return true;
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                android.util.Log.d("MapplsMapView", "Page finished loading: " + url);
            }

            @Override
            public void onReceivedError(WebView view, android.webkit.WebResourceRequest request, android.webkit.WebResourceError error) {
                android.util.Log.e("MapplsMapView", "Resource error on " + request.getUrl() + ": " + error.getDescription());
            }
        });

        webView.setLayerType(android.view.View.LAYER_TYPE_HARDWARE, null);
        addView(webView);
        loadMapplsHtml();
    }

    private void loadMapplsHtml() {
        String apiKey = MapplsApiClient.MAPPLS_REST_KEY;
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta charset='utf-8' />\n" +
                "  <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />\n" +
                "  <title>Mappls Cockpit Navigation</title>\n" +
                "  <script src='https://apis.mappls.com/advancedmaps/api/" + apiKey + "/map_sdk?v=3.0&layer=vector&callback=initMap'></script>\n" +
                "  <style>\n" +
                "    :root { --accent-hex: " + currentAccentHex + "; --accent-rgb: " + currentAccentRgb + "; }\n" +
                "    body, html { margin:0; padding:0; height:100%; width:100%; overflow:hidden; font-family:sans-serif; }\n" +
                "    #map { position:absolute; top:0; bottom:0; width:100%; height:100%; }\n" +
                "    body.dark-mode, body.dark-mode #map { background:#000000 !important; }\n" +
                "    body.light-mode, body.light-mode #map { background:#F8FAFC !important; }\n" +
                "    body.dark-mode #map canvas { filter: invert(92%) hue-rotate(180deg) brightness(85%) contrast(108%) !important; }\n" +
                "    body.light-mode #map canvas { filter: none !important; }\n" +
                "    .mapboxgl-ctrl-attrib, .maplibregl-ctrl-attrib, .mappls-ctrl-attrib, .mappls-attrib,\n" +
                "    .mapboxgl-ctrl-bottom-right, .maplibregl-ctrl-bottom-right, .mappls-ctrl-bottom-right,\n" +
                "    .mapboxgl-ctrl-bottom-left, .maplibregl-ctrl-bottom-left, .mappls-ctrl-bottom-left,\n" +
                "    .mapboxgl-ctrl-logo, .maplibregl-ctrl-logo, .mappls-logo,\n" +
                "    .mapboxgl-compact, .maplibregl-compact,\n" +
                "    .mapboxgl-ctrl, .maplibregl-ctrl, .mappls-ctrl,\n" +
                "    div[class*='attrib'], div[class*='logo'], div[class*='ctrl-bottom'],\n" +
                "    a[href*='mapmyindia'], a[href*='mappls'], [title*='MapmyIndia'], [title*='Mappls'],\n" +
                "    .maplibregl-ctrl-attrib-inner, .mapboxgl-ctrl-attrib-inner {\n" +
                "       display: none !important; visibility: hidden !important; opacity: 0 !important; height: 0 !important; width: 0 !important; pointer-events: none !important;\n" +
                "    }\n" +
                "    .puck-marker {\n" +
                "       width: 44px; height: 44px;\n" +
                "       background: radial-gradient(circle, rgba(var(--accent-rgb),0.45) 0%, rgba(var(--accent-rgb),0.1) 70%, transparent 100%);\n" +
                "       border-radius: 50%;\n" +
                "       display: flex; align-items: center; justify-content: center;\n" +
                "       transition: transform 0.3s cubic-bezier(0.2, 0.9, 0.3, 1);\n" +
                "    }\n" +
                "    .puck-arrow {\n" +
                "       width: 0; height: 0;\n" +
                "       border-left: 9px solid transparent;\n" +
                "       border-right: 9px solid transparent;\n" +
                "       border-bottom: 22px solid var(--accent-hex);\n" +
                "       filter: drop-shadow(0 0 8px var(--accent-hex));\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body class='dark-mode'>\n" +
                "<div id='map'></div>\n" +
                "<script>\n" +
                "  var map = null;\n" +
                "  var puckEl = null;\n" +
                "  var puckMarker = null;\n" +
                "  var routeLayerId = 'nav-route-line';\n" +
                "  var routeSourceId = 'nav-route-source';\n" +
                "  var currentAccentColor = '" + currentAccentHex + "';\n" +
                "\n" +
                "  function setMapAccentColor(hex, rgb) {\n" +
                "    currentAccentColor = hex;\n" +
                "    document.documentElement.style.setProperty('--accent-hex', hex);\n" +
                "    document.documentElement.style.setProperty('--accent-rgb', rgb);\n" +
                "    if (map && map.getLayer && map.getLayer(routeLayerId)) {\n" +
                "      try { map.setPaintProperty(routeLayerId, 'line-color', hex); } catch(e) {}\n" +
                "    }\n" +
                "  }\n" +
                "\n" +
                "  function purgeAttributions() {\n" +
                "    var toRemove = document.querySelectorAll('.mapboxgl-ctrl-attrib, .maplibregl-ctrl-attrib, .mappls-ctrl-attrib, .mapboxgl-ctrl-bottom-right, .maplibregl-ctrl-bottom-right, .mappls-ctrl-bottom-right, .mapboxgl-ctrl-bottom-left, .maplibregl-ctrl-bottom-left, .mappls-ctrl-bottom-left, .mapboxgl-ctrl-logo, .maplibregl-ctrl-logo, .mappls-logo, div[class*=\"attrib\"], div[class*=\"logo\"], a[href*=\"mapmyindia\"], a[href*=\"mappls\"]');\n" +
                "    for (var i = 0; i < toRemove.length; i++) {\n" +
                "      var el = toRemove[i];\n" +
                "      if (el && el.parentNode) { el.parentNode.removeChild(el); }\n" +
                "    }\n" +
                "  }\n" +
                "  setInterval(purgeAttributions, 300);\n" +
                "\n" +
                "  function initMap() {\n" +
                "    if (map) return;\n" +
                "    console.log('initMap called, typeof mappls=' + typeof mappls);\n" +
                "    try {\n" +
                "      if (typeof mappls === 'undefined' || !mappls.Map) {\n" +
                "         setTimeout(initMap, 250);\n" +
                "         return;\n" +
                "      }\n" +
                "      map = new mappls.Map('map', {\n" +
                "        center: [" + lastLat + ", " + lastLng + "],\n" +
                "        zoom: 15,\n" +
                "        zoomControl: false,\n" +
                "        attribution: false,\n" +
                "        attributionControl: false\n" +
                "      });\n" +
                "      map.on('load', function() {\n" +
                "        console.log('Mappls vector map loaded successfully!');\n" +
                "        purgeAttributions();\n" +
                "        createPuckMarker();\n" +
                "        if (window.AndroidBridge) {\n" +
                "          window.AndroidBridge.onMapInitialized();\n" +
                "        }\n" +
                "      });\n" +
                "      map.on('error', function(err) {\n" +
                "        console.error('Mappls map error: ' + JSON.stringify(err));\n" +
                "      });\n" +
                "      map.on('click', function(e) {\n" +
                "        if (e && e.lngLat && window.AndroidBridge) {\n" +
                "          window.AndroidBridge.onMapTapped(e.lngLat.lat, e.lngLat.lng);\n" +
                "        }\n" +
                "      });\n" +
                "      map.on('dragstart', function() {\n" +
                "        isUserInteracting = true;\n" +
                "        if (window.AndroidBridge && window.AndroidBridge.onMapDragged) {\n" +
                "          window.AndroidBridge.onMapDragged();\n" +
                "        }\n" +
                "      });\n" +
                "      map.on('rotatestart', function() {\n" +
                "        isUserInteracting = true;\n" +
                "        if (window.AndroidBridge && window.AndroidBridge.onMapDragged) {\n" +
                "          window.AndroidBridge.onMapDragged();\n" +
                "        }\n" +
                "      });\n" +
                "      map.on('pitchstart', function() {\n" +
                "        isUserInteracting = true;\n" +
                "        if (window.AndroidBridge && window.AndroidBridge.onMapDragged) {\n" +
                "          window.AndroidBridge.onMapDragged();\n" +
                "        }\n" +
                "      });\n" +
                "      map.on('rotate', function() {\n" +
                "        if (window.AndroidBridge && window.AndroidBridge.onMapBearingChanged && map) {\n" +
                "          window.AndroidBridge.onMapBearingChanged(map.getBearing());\n" +
                "        }\n" +
                "      });\n" +
                "    } catch(err) {\n" +
                "      console.error('initMap exception: ' + err);\n" +
                "      setTimeout(initMap, 800);\n" +
                "    }\n" +
                "  }\n" +
                "  if (document.readyState === 'complete' || document.readyState === 'interactive') { initMap(); } else { window.addEventListener('DOMContentLoaded', initMap); }\n" +
                "\n" +
                "  function createPuckMarker() {\n" +
                "    puckEl = document.createElement('div');\n" +
                "    puckEl.className = 'puck-marker';\n" +
                "    var arrow = document.createElement('div');\n" +
                "    arrow.className = 'puck-arrow';\n" +
                "    puckEl.appendChild(arrow);\n" +
                "    if (typeof mappls.Marker !== 'undefined') {\n" +
                "       puckMarker = new mappls.Marker({\n" +
                "          map: map,\n" +
                "          position: {lat: " + lastLat + ", lng: " + lastLng + "},\n" +
                "          element: puckEl\n" +
                "       });\n" +
                "    }\n" +
                "  }\n" +
                "  var curRiderLat = " + lastLat + ";\n" +
                "  var curRiderLng = " + lastLng + ";\n" +
                "  var curBearing = 0;\n" +
                "  var isUserInteracting = false;\n" +
                "  var isNavigating = false;\n" +
                "  var is3DMode = false;\n" +
                "\n" +
                "  function setNavigating(nav) {\n" +
                "    isNavigating = nav;\n" +
                "  }\n" +
                "\n" +
                "  function setRiderPosition(lat, lng, bearing) {\n" +
                "    if (!map) return;\n" +
                "    curRiderLat = lat;\n" +
                "    curRiderLng = lng;\n" +
                "    curBearing = bearing;\n" +
                "    try {\n" +
                "      if (puckMarker && puckMarker.setPosition) {\n" +
                "        puckMarker.setPosition({lat: lat, lng: lng});\n" +
                "      }\n" +
                "      if (puckEl) {\n" +
                "        puckEl.style.transform = 'rotate(' + bearing + 'deg)';\n" +
                "      }\n" +
                "      if (!isUserInteracting) {\n" +
                "        map.easeTo({\n" +
                "          center: [lng, lat],\n" +
                "          bearing: (isNavigating || is3DMode) ? bearing : map.getBearing(),\n" +
                "          pitch: is3DMode ? 55 : (isNavigating ? 45 : 0),\n" +
                "          duration: 350\n" +
                "        });\n" +
                "      }\n" +
                "    } catch(e) {}\n" +
                "  }\n" +
                "\n" +
                "  function recenterOnRider() {\n" +
                "    if (!map) return;\n" +
                "    isUserInteracting = false;\n" +
                "    try {\n" +
                "      map.flyTo({\n" +
                "        center: [curRiderLng, curRiderLat],\n" +
                "        zoom: 16,\n" +
                "        bearing: (is3DMode || isNavigating) ? curBearing : 0,\n" +
                "        pitch: is3DMode ? 55 : (isNavigating ? 45 : 0),\n" +
                "        speed: 1.3\n" +
                "      });\n" +
                "      if (window.AndroidBridge && window.AndroidBridge.onMapRecentered) {\n" +
                "        window.AndroidBridge.onMapRecentered();\n" +
                "      }\n" +
                "    } catch(e) {}\n" +
                "  }\n" +
                "\n" +
                "  function toggleOrientation() {\n" +
                "    if (!map) return;\n" +
                "    try {\n" +
                "      var currentBearing = map.getBearing();\n" +
                "      if (Math.abs(currentBearing) > 5 && !is3DMode) {\n" +
                "        is3DMode = false;\n" +
                "        map.easeTo({ bearing: 0, pitch: 0, duration: 400 });\n" +
                "        if (window.AndroidBridge && window.AndroidBridge.onOrientationModeChanged) {\n" +
                "          window.AndroidBridge.onOrientationModeChanged(false, 0);\n" +
                "        }\n" +
                "      } else if (!is3DMode) {\n" +
                "        is3DMode = true;\n" +
                "        var targetBearing = (typeof curBearing !== 'undefined' && curBearing !== 0) ? curBearing : map.getBearing();\n" +
                "        map.easeTo({ bearing: targetBearing, pitch: 55, duration: 500 });\n" +
                "        if (window.AndroidBridge && window.AndroidBridge.onOrientationModeChanged) {\n" +
                "          window.AndroidBridge.onOrientationModeChanged(true, targetBearing);\n" +
                "        }\n" +
                "      } else {\n" +
                "        is3DMode = false;\n" +
                "        map.easeTo({ bearing: 0, pitch: 0, duration: 400 });\n" +
                "        if (window.AndroidBridge && window.AndroidBridge.onOrientationModeChanged) {\n" +
                "          window.AndroidBridge.onOrientationModeChanged(false, 0);\n" +
                "        }\n" +
                "      }\n" +
                "    } catch(e) {\n" +
                "      console.error('toggleOrientation error: ' + e);\n" +
                "    }\n" +
                "  }\n" +
                "\n" +
                "  function resetNorth() {\n" +
                "    if (!map) return;\n" +
                "    is3DMode = false;\n" +
                "    try {\n" +
                "      map.easeTo({\n" +
                "        bearing: 0,\n" +
                "        pitch: 0,\n" +
                "        duration: 400\n" +
                "      });\n" +
                "      if (window.AndroidBridge && window.AndroidBridge.onOrientationModeChanged) {\n" +
                "        window.AndroidBridge.onOrientationModeChanged(false, 0);\n" +
                "      }\n" +
                "      if (window.AndroidBridge && window.AndroidBridge.onMapBearingChanged) {\n" +
                "        window.AndroidBridge.onMapBearingChanged(0);\n" +
                "      }\n" +
                "    } catch(e) {}\n" +
                "  }\n" +
                "\n" +
                "  var destMarker = null;\n" +
                "  function drawRouteLine(coordsJson) {\n" +
                "    if (!map) return;\n" +
                "    try {\n" +
                "      var coords = JSON.parse(coordsJson);\n" +
                "      if (map.getSource && map.getSource(routeSourceId)) {\n" +
                "        map.getSource(routeSourceId).setData({\n" +
                "          'type': 'Feature',\n" +
                "          'properties': {},\n" +
                "          'geometry': {\n" +
                "            'type': 'LineString',\n" +
                "            'coordinates': coords\n" +
                "          }\n" +
                "        });\n" +
                "      } else if (map.addSource) {\n" +
                "        map.addSource(routeSourceId, {\n" +
                "          'type': 'geojson',\n" +
                "          'data': {\n" +
                "            'type': 'Feature',\n" +
                "            'properties': {},\n" +
                "            'geometry': {\n" +
                "              'type': 'LineString',\n" +
                "              'coordinates': coords\n" +
                "            }\n" +
                "          }\n" +
                "        });\n" +
                "        map.addLayer({\n" +
                "          'id': routeLayerId,\n" +
                "          'type': 'line',\n" +
                "          'source': routeSourceId,\n" +
                "          'layout': { 'line-join': 'round', 'line-cap': 'round' },\n" +
                "          'paint': {\n" +
                "            'line-color': currentAccentColor,\n" +
                "            'line-width': 7,\n" +
                "            'line-opacity': 0.95\n" +
                "          }\n" +
                "        });\n" +
                "      }\n" +
                "      if (coords && coords.length > 0 && typeof mappls.Marker !== 'undefined') {\n" +
                "        var endPt = coords[coords.length - 1];\n" +
                "        if (destMarker && destMarker.setPosition) {\n" +
                "          destMarker.setPosition({lng: endPt[0], lat: endPt[1]});\n" +
                "        } else {\n" +
                "          var pinEl = document.createElement('div');\n" +
                "          pinEl.style.width = '24px'; pinEl.style.height = '24px';\n" +
                "          pinEl.style.borderRadius = '50%'; pinEl.style.background = '#EF4444';\n" +
                "          pinEl.style.border = '3px solid #FFFFFF'; pinEl.style.boxShadow = '0 0 10px rgba(239,68,68,0.9)';\n" +
                "          destMarker = new mappls.Marker({ map: map, position: {lng: endPt[0], lat: endPt[1]}, element: pinEl });\n" +
                "        }\n" +
                "      }\n" +
                "    } catch(e) {}\n" +
                "  }\n" +
                "\n" +
                "  function fitRouteBounds(coordsJson) {\n" +
                "    if (!map) return;\n" +
                "    try {\n" +
                "      var coords = JSON.parse(coordsJson);\n" +
                "      if (!coords || coords.length === 0) return;\n" +
                "      var minX = coords[0][0], minY = coords[0][1], maxX = coords[0][0], maxY = coords[0][1];\n" +
                "      for (var i = 1; i < coords.length; i++) {\n" +
                "        if (coords[i][0] < minX) minX = coords[i][0];\n" +
                "        if (coords[i][0] > maxX) maxX = coords[i][0];\n" +
                "        if (coords[i][1] < minY) minY = coords[i][1];\n" +
                "        if (coords[i][1] > maxY) maxY = coords[i][1];\n" +
                "      }\n" +
                "      map.fitBounds([[minX, minY], [maxX, maxY]], { padding: 80, duration: 600 });\n" +
                "    } catch(e) {}\n" +
                "  }\n" +
                "\n" +
                "  function clearRouteLine() {\n" +
                "    if (!map) return;\n" +
                "    try {\n" +
                "      if (destMarker && destMarker.remove) { destMarker.remove(); destMarker = null; }\n" +
                "      if (map.getLayer && map.getLayer(routeLayerId)) map.removeLayer(routeLayerId);\n" +
                "      if (map.getSource && map.getSource(routeSourceId)) map.removeSource(routeSourceId);\n" +
                "    } catch(e) {}\n" +
                "  }\n" +
                "\n" +
                "  function zoomIn() { if (map && map.zoomIn) map.zoomIn(); }\n" +
                "  function zoomOut() { if (map && map.zoomOut) map.zoomOut(); }\n" +
                "  function setMapTheme(isDark) {\n" +
                "    document.body.className = isDark ? 'dark-mode' : 'light-mode';\n" +
                "    var canvases = document.querySelectorAll('canvas');\n" +
                "    for (var i = 0; i < canvases.length; i++) {\n" +
                "      canvases[i].style.filter = isDark ? 'invert(92%) hue-rotate(180deg) brightness(85%) contrast(108%) !important' : 'none !important';\n" +
                "    }\n" +
                "  }\n" +
                "  function setSatellite(isSat) { setMapTheme(!isSat); }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";

        webView.loadDataWithBaseURL("https://apis.mappls.com/", html, "text/html", "UTF-8", null);
    }

    /**
     * Dynamically updates the map's route polyline, vehicle puck arrow, and radar glow
     * to match the Material You wallpaper accent color.
     */
    public void setThemeAccent(int accentColor) {
        int r = Color.red(accentColor);
        int g = Color.green(accentColor);
        int b = Color.blue(accentColor);
        currentAccentHex = String.format("#%06X", (0xFFFFFF & accentColor));
        currentAccentRgb = r + ", " + g + ", " + b;
        if (!isMapLoaded || webView == null) return;
        mainHandler.post(() -> {
            String script = String.format(java.util.Locale.US,
                    "setMapAccentColor('%s', '%s');", currentAccentHex, currentAccentRgb);
            webView.evaluateJavascript(script, null);
        });
    }

    public void updateRiderLocation(double lat, double lng, float bearing) {
        lastLat = lat;
        lastLng = lng;
        lastBearing = bearing;
        try {
            getContext().getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                    .edit()
                    .putFloat("saved_rider_lat", (float) lat)
                    .putFloat("saved_rider_lng", (float) lng)
                    .apply();
        } catch (Exception ignored) {}
        if (!isMapLoaded) return;

        mainHandler.post(() -> {
            String script = String.format(java.util.Locale.US, "setRiderPosition(%.6f, %.6f, %.1f);", lat, lng, bearing);
            webView.evaluateJavascript(script, null);
        });
    }

    public void plotRoute(List<double[]> coordinatesLngLat) {
        if (!isMapLoaded || coordinatesLngLat == null || coordinatesLngLat.isEmpty()) return;

        mainHandler.post(() -> {
            try {
                JSONArray arr = new JSONArray();
                for (double[] point : coordinatesLngLat) {
                    JSONArray p = new JSONArray();
                    p.put(point[0]); // Lng
                    p.put(point[1]); // Lat
                    arr.put(p);
                }
                String script = "drawRouteLine('" + arr.toString() + "');";
                webView.evaluateJavascript(script, null);
            } catch (Exception ignored) {}
        });
    }

    public void fitRouteBounds(List<double[]> coordinatesLngLat) {
        if (!isMapLoaded || coordinatesLngLat == null || coordinatesLngLat.isEmpty()) return;

        mainHandler.post(() -> {
            try {
                JSONArray arr = new JSONArray();
                for (double[] point : coordinatesLngLat) {
                    JSONArray p = new JSONArray();
                    p.put(point[0]); // Lng
                    p.put(point[1]); // Lat
                    arr.put(p);
                }
                String script = "fitRouteBounds('" + arr.toString() + "');";
                webView.evaluateJavascript(script, null);
            } catch (Exception ignored) {}
        });
    }

    public void clearRoute() {
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript("clearRouteLine();", null));
    }

    public void zoomIn() {
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript("zoomIn();", null));
    }

    public void zoomOut() {
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript("zoomOut();", null));
    }

    public boolean isDarkMode() {
        return isDarkMode;
    }

    public void setMapTheme(boolean dark) {
        this.isDarkMode = dark;
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript("setMapTheme(" + dark + ");", null));
    }

    public void toggleMapTheme() {
        setMapTheme(!isDarkMode);
    }

    public void setSatelliteMode(boolean satellite) {
        setMapTheme(!satellite);
    }

    public void centerOnCurrentLocation() {
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript("recenterOnRider();", null));
    }

    public void resetNorth() {
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript("resetNorth();", null));
    }

    public void toggleOrientation() {
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript("toggleOrientation();", null));
    }

    public void setNavigating(boolean navigating) {
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript("setNavigating(" + navigating + ");", null));
    }

    public void simulateDrag() {
        if (!isMapLoaded) return;
        mainHandler.post(() -> webView.evaluateJavascript(
            "if (map) { map.panBy([150, 150]); isUserInteracting = true; if (window.AndroidBridge && window.AndroidBridge.onMapDragged) window.AndroidBridge.onMapDragged(); }",
            null
        ));
    }

    public void centerOnLocation(double lat, double lng) {
        lastLat = lat;
        lastLng = lng;
        if (!isMapLoaded) return;
        mainHandler.post(() -> {
            String script = String.format(java.util.Locale.US,
                "if (map) { map.flyTo({ center: [%.6f, %.6f], zoom: 16, speed: 1.3 }); }",
                lng, lat);
            webView.evaluateJavascript(script, null);
        });
    }

    public void setCornerRadius(float radiusDp) {
        this.cornerRadiusDp = radiusDp;
        updateClipPath();
        invalidateOutline();
        invalidate();
    }

    private void updateClipPath() {
        clipPath.reset();
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) return;
        rectF.set(0, 0, w, h);
        float r = cornerRadiusDp * getResources().getDisplayMetrics().density;
        clipPath.addRoundRect(rectF, r, r, Path.Direction.CW);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateClipPath();
    }

    @Override
    public void draw(Canvas canvas) {
        if (clipPath != null && !clipPath.isEmpty()) {
            canvas.save();
            canvas.clipPath(clipPath);
            super.draw(canvas);
            canvas.restore();
        } else {
            super.draw(canvas);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (clipPath != null && !clipPath.isEmpty()) {
            canvas.save();
            canvas.clipPath(clipPath);
            super.dispatchDraw(canvas);
            canvas.restore();
        } else {
            super.dispatchDraw(canvas);
        }
    }

    public void onResume() {
        if (webView != null) {
            webView.onResume();
        }
    }

    public void onPause() {
        if (webView != null) {
            webView.onPause();
        }
    }

    public void onDestroy() {
        mainHandler.removeCallbacksAndMessages(null);
        if (webView != null) {
            removeView(webView);
            webView.stopLoading();
            webView.clearHistory();
            webView.clearCache(true);
            webView.loadUrl("about:blank");
            webView.onPause();
            webView.removeAllViews();
            webView.destroy();
            webView = null;
        }
    }
}
