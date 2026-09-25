package com.bajaj.rideconnect.re

import android.os.Handler
import android.os.Looper
import android.util.Log
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.Locale
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MapplsApiClient private constructor() {

    private val executor: ExecutorService = Executors.newFixedThreadPool(2)
    private val mainHandler = Handler(Looper.getMainLooper())

    private var cachedToken: String? = null
    private var tokenExpiryTimeMs: Long = 0

    interface TokenCallback {
        fun onSuccess(token: String)
        fun onError(error: String)
    }

    interface PlacesCallback {
        fun onSuccess(results: List<PlaceResult>)
        fun onError(error: String)
    }

    interface RouteCallback {
        fun onSuccess(route: RouteResult)
        fun onError(error: String)
    }

    class PlaceResult(
        @JvmField val name: String,
        @JvmField val address: String,
        @JvmField val mapplsPin: String,
        @JvmField var lat: Double,
        @JvmField var lng: Double,
        @JvmField val distanceMeters: Double,
        @JvmField val type: String
    ) {
        fun getFormattedDistance(): String {
            if (distanceMeters <= 0) return ""
            if (distanceMeters < 1000) {
                return "${distanceMeters.toInt()} m"
            }
            return String.format(Locale.US, "%.1f km", distanceMeters / 1000.0)
        }

        override fun toString(): String = "$name ($address)"
    }

    class RouteStep(
        @JvmField val instruction: String,
        @JvmField val street: String,
        @JvmField val distanceMeters: Double,
        @JvmField val durationSeconds: Double,
        @JvmField val maneuverID: Int,
        @JvmField val lat: Double,
        @JvmField val lng: Double
    )

    class RouteResult(
        @JvmField val totalDistanceMeters: Double,
        @JvmField val totalDurationSeconds: Double,
        @JvmField val geometryPolyline: String,
        @JvmField val steps: List<RouteStep>,
        @JvmField var destLat: Double = 0.0,
        @JvmField var destLng: Double = 0.0
    )

    fun getAccessToken(callback: TokenCallback) {
        val currentToken = cachedToken
        if (currentToken != null && System.currentTimeMillis() < tokenExpiryTimeMs) {
            callback.onSuccess(currentToken)
            return
        }

        executor.execute {
            var conn: HttpURLConnection? = null
            try {
                val url = URI.create("https://outpost.mappls.com/api/security/oauth/token").toURL()
                conn = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                    connectTimeout = 8000
                    readTimeout = 8000
                    doOutput = true
                }

                val postData = "client_id=" + URLEncoder.encode(MAPPLS_CLIENT_ID, "UTF-8") +
                    "&client_secret=" + URLEncoder.encode(MAPPLS_CLIENT_SECRET, "UTF-8") +
                    "&grant_type=client_credentials"

                conn.outputStream.use { os ->
                    os.write(postData.toByteArray(StandardCharsets.UTF_8))
                }

                val code = conn.responseCode
                if (code == 200) {
                    val resp = readStream(conn.inputStream)
                    val json = JSONObject(resp)
                    val token = json.getString("access_token")
                    val expiresIn = json.optInt("expires_in", 86400)

                    cachedToken = token
                    tokenExpiryTimeMs = System.currentTimeMillis() + ((expiresIn - 120).toLong() * 1000L)
                    mainHandler.post { callback.onSuccess(token) }
                } else {
                    val err = "Auth HTTP $code: " + readStream(conn.errorStream)
                    mainHandler.post { callback.onError(err) }
                }
            } catch (e: Exception) {
                Log.w(TAG, "OAuth token fetch failed: ${e.message}")
                mainHandler.post { callback.onError(e.message ?: "Unknown OAuth error") }
            } finally {
                conn?.disconnect()
            }
        }
    }

    fun searchPlaces(query: String, currentLat: Double, currentLng: Double, callback: PlacesCallback) {
        getAccessToken(object : TokenCallback {
            override fun onSuccess(token: String) {
                executor.execute {
                    var conn: HttpURLConnection? = null
                    try {
                        val sb = StringBuilder("https://atlas.mappls.com/api/places/search/json?")
                        sb.append("query=").append(URLEncoder.encode(query, "UTF-8"))
                        if (currentLat != 0.0 && currentLng != 0.0) {
                            sb.append("&location=").append(currentLat).append(",").append(currentLng)
                        }
                        sb.append("&bridge=true")

                        val url = URI.create(sb.toString()).toURL()
                        conn = (url.openConnection() as HttpURLConnection).apply {
                            requestMethod = "GET"
                            setRequestProperty("Authorization", "bearer $token")
                            setRequestProperty("Accept", "application/json")
                            connectTimeout = 8000
                            readTimeout = 8000
                        }

                        val code = conn.responseCode
                        if (code == 200) {
                            val resp = readStream(conn.inputStream)
                            val json = JSONObject(resp)
                            val locs = json.optJSONArray("suggestedLocations")
                            val results = mutableListOf<PlaceResult>()
                            if (locs != null) {
                                for (i in 0 until locs.length()) {
                                    val loc = locs.getJSONObject(i)
                                    val name = loc.optString("placeName", "")
                                    val addr = loc.optString("placeAddress", "")
                                    val pin = loc.optString("eLoc", loc.optString("mapplsPin", ""))
                                    val lat = loc.optDouble("latitude", 0.0)
                                    val lng = loc.optDouble("longitude", 0.0)
                                    val dist = loc.optDouble("distance", 0.0)
                                    val type = loc.optString("type", "POI")
                                    results.add(PlaceResult(name, addr, pin, lat, lng, dist, type))
                                }
                            }
                            mainHandler.post { callback.onSuccess(results) }
                        } else {
                            mainHandler.post { callback.onError("AutoSuggest HTTP $code") }
                        }
                    } catch (e: Exception) {
                        Log.w(TAG, "Search places failed: ${e.message}")
                        mainHandler.post { callback.onError(e.message ?: "Unknown search error") }
                    } finally {
                        conn?.disconnect()
                    }
                }
            }

            override fun onError(error: String) {
                callback.onError(error)
            }
        })
    }

    @JvmOverloads
    fun getDirections(
        startLat: Double,
        startLng: Double,
        destLat: Double,
        destLng: Double,
        destEloc: String? = null,
        callback: RouteCallback
    ) {
        executor.execute {
            try {
                var res = requestRoute("biking", startLat, startLng, destLat, destLng, destEloc)
                if (res == null) {
                    res = requestRoute("driving", startLat, startLng, destLat, destLng, destEloc)
                }
                if (res != null) {
                    val finalRes = res
                    mainHandler.post { callback.onSuccess(finalRes) }
                } else {
                    mainHandler.post { callback.onError("No route found") }
                }
            } catch (e: Exception) {
                Log.w(TAG, "Directions request failed: ${e.message}")
                mainHandler.post { callback.onError(e.message ?: "Unknown route error") }
            }
        }
    }

    private fun requestRoute(
        profile: String,
        startLat: Double,
        startLng: Double,
        destLat: Double,
        destLng: Double,
        destEloc: String?
    ): RouteResult? {
        var conn: HttpURLConnection? = null
        try {
            val coords = if (!destEloc.isNullOrBlank()) {
                String.format(Locale.US, "%.6f,%.6f;%s", startLng, startLat, destEloc.trim())
            } else {
                String.format(Locale.US, "%.6f,%.6f;%.6f,%.6f", startLng, startLat, destLng, destLat)
            }
            val urlStr = "https://apis.mappls.com/advancedmaps/v1/$MAPPLS_REST_KEY/route_adv/$profile/$coords?steps=true&overview=full&geometries=polyline6&alternatives=true"

            val url = URI.create(urlStr).toURL()
            conn = (url.openConnection() as HttpURLConnection).apply {
                requestMethod = "GET"
                setRequestProperty("Accept", "application/json")
                connectTimeout = 9000
                readTimeout = 9000
            }

            if (conn.responseCode != 200) {
                return null
            }

            val resp = readStream(conn.inputStream)
            val json = JSONObject(resp)
            val routes = json.optJSONArray("routes") ?: return null
            if (routes.length() == 0) return null

            val route = routes.getJSONObject(0)
            val totalDist = route.optDouble("distance", 0.0)
            val totalDur = route.optDouble("duration", 0.0)
            val polyline = route.optString("geometry", "")

            val steps = mutableListOf<RouteStep>()
            val legs = route.optJSONArray("legs")
            if (legs != null && legs.length() > 0) {
                val stepsArr = legs.getJSONObject(0).optJSONArray("steps")
                if (stepsArr != null) {
                    for (i in 0 until stepsArr.length()) {
                        val s = stepsArr.getJSONObject(i)
                        val dist = s.optDouble("distance", 0.0)
                        val dur = s.optDouble("duration", 0.0)
                        val name = s.optString("name", "")

                        val man = s.optJSONObject("maneuver")
                        val instr: String
                        val manId: Int
                        var stepLat = 0.0
                        var stepLng = 0.0

                        if (man != null) {
                            val type = man.optString("type", "")
                            val modifier = man.optString("modifier", "")
                            var rawInstr = man.optString("instruction", "")
                            if (rawInstr.isEmpty()) {
                                rawInstr = s.optString("instruction", "")
                            }
                            instr = buildManeuverInstruction(type, modifier, name, rawInstr)
                            manId = resolveMapplsManeuverId(type, modifier, s.optInt("maneuverID", 0))

                            val loc = man.optJSONArray("location")
                            if (loc != null && loc.length() >= 2) {
                                stepLng = loc.getDouble(0)
                                stepLat = loc.getDouble(1)
                            }
                        } else {
                            instr = if (name.isNotEmpty()) "Continue on $name" else "Continue straight"
                            manId = 0
                        }
                        steps.add(RouteStep(instr, name, dist, dur, manId, stepLat, stepLng))
                    }
                }
            }

            return RouteResult(totalDist, totalDur, polyline, steps)
        } catch (e: Exception) {
            Log.d(TAG, "Route profile $profile error: ${e.message}")
            return null
        } finally {
            conn?.disconnect()
        }
    }

    private fun buildManeuverInstruction(type: String, modifier: String, name: String?, rawInstr: String?): String {
        if (!rawInstr.isNullOrBlank() && !rawInstr.trim().equals(name?.trim(), ignoreCase = true)) {
            return rawInstr.trim()
        }
        val road = if (!name.isNullOrBlank()) name.trim() else ""
        val roadSuffix = if (road.isNotEmpty()) " onto $road" else ""
        val onRoadSuffix = if (road.isNotEmpty()) " on $road" else ""

        if ("arrive".equals(type, ignoreCase = true)) {
            return if (road.isNotEmpty()) "Arrive at $road" else "Arrive at destination"
        }
        if ("depart".equals(type, ignoreCase = true)) {
            return if (road.isNotEmpty()) "Head towards $road" else "Proceed on route"
        }
        if ("roundabout".equals(type, ignoreCase = true) || "rotary".equals(type, ignoreCase = true)) {
            return if (road.isNotEmpty()) "At roundabout, exit onto $road" else "Enter roundabout"
        }
        if ("uturn".equals(modifier, ignoreCase = true) || "uturn".equals(type, ignoreCase = true)) {
            return "Make a U-turn$onRoadSuffix"
        }
        if ("sharp right".equals(modifier, ignoreCase = true)) {
            return "Sharp right$roadSuffix"
        }
        if ("sharp left".equals(modifier, ignoreCase = true)) {
            return "Sharp left$roadSuffix"
        }
        if ("slight right".equals(modifier, ignoreCase = true)) {
            return "Keep right$onRoadSuffix"
        }
        if ("slight left".equals(modifier, ignoreCase = true)) {
            return "Keep left$onRoadSuffix"
        }
        if ("right".equals(modifier, ignoreCase = true)) {
            return "Turn right$roadSuffix"
        }
        if ("left".equals(modifier, ignoreCase = true)) {
            return "Turn left$roadSuffix"
        }
        if ("straight".equals(modifier, ignoreCase = true) || "continue".equals(type, ignoreCase = true)) {
            return if (road.isNotEmpty()) "Continue straight on $road" else "Continue straight"
        }
        if (road.isNotEmpty()) {
            return "Continue on $road"
        }
        return "Continue straight"
    }

    private fun resolveMapplsManeuverId(type: String, modifier: String?, explicitId: Int): Int {
        if ("arrive".equals(type, ignoreCase = true)) return 8
        if ("depart".equals(type, ignoreCase = true)) return 0
        if ("roundabout".equals(type, ignoreCase = true) || "rotary".equals(type, ignoreCase = true)) return 58

        if (modifier != null) {
            val modLower = modifier.lowercase(Locale.ROOT)
            if (modLower.contains("sharp left")) return 20
            if (modLower.contains("slight left")) return 15
            if (modLower.contains("left")) return 19

            if (modLower.contains("sharp right")) return 3
            if (modLower.contains("slight right")) return 1
            if (modLower.contains("right")) return 2

            if (modLower.contains("uturn")) return 4
            if (modLower.contains("straight")) return 0
        }

        if ("continue".equals(type, ignoreCase = true)) return 0
        if (explicitId > 0) return explicitId
        return 7
    }

    private fun readStream(stream: InputStream?): String {
        stream ?: return ""
        BufferedReader(InputStreamReader(stream, StandardCharsets.UTF_8)).use { br ->
            val sb = StringBuilder()
            var line: String?
            while (br.readLine().also { line = it } != null) {
                sb.append(line).append('\n')
            }
            return sb.toString()
        }
    }

    companion object {
        private const val TAG = "MapplsApiClient"

        const val MAPPLS_REST_KEY: String = "b1307a05531ee9af4a58eb0b5d0674ef"
        const val MAPPLS_CLIENT_ID: String = "96dHZVzsAutdyZ2AvmkqqsfYYSPELKZV9PCQ878iRfGCNB44VijcZGViqyhWyv1S9YVKTmYPqBZXNcGiWSVtlg=="
        const val MAPPLS_CLIENT_SECRET: String = "lrFxI-iSEg8VPzd2rMwu91pNVCzbSGi-wwexOxVWGyvQxf_zqE0KnCQfAdqPb0E7hbG0fl8nWnbE5x5Q0JwcVSYeedjKx0N8"

        @Volatile
        private var instance: MapplsApiClient? = null

        @JvmStatic
        fun getInstance(): MapplsApiClient {
            return instance ?: synchronized(this) {
                instance ?: MapplsApiClient().also { instance = it }
            }
        }
    }
}
