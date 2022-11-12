package lx.com.data
import com.google.gson.annotations.SerializedName


data class RouteResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("currentDateTime")
    val currentDateTime: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("route")
    val route: Route
) {
    data class Route(
        @SerializedName("traoptimal")
        val traoptimal: List<Traoptimal>
    ) {
        data class Traoptimal(
            @SerializedName("guide")
            val guide: List<Guide>,
            @SerializedName("path")
            val path: List<List<Double>>,
            @SerializedName("section")
            val section: List<Section>,
            @SerializedName("summary")
            val summary: Summary
        ) {
            data class Guide(
                @SerializedName("distance")
                val distance: Int,
                @SerializedName("duration")
                val duration: Int,
                @SerializedName("instructions")
                val instructions: String,
                @SerializedName("pointIndex")
                val pointIndex: Int,
                @SerializedName("type")
                val type: Int
            )

            data class Section(
                @SerializedName("congestion")
                val congestion: Int,
                @SerializedName("distance")
                val distance: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("pointCount")
                val pointCount: Int,
                @SerializedName("pointIndex")
                val pointIndex: Int,
                @SerializedName("speed")
                val speed: Int
            )

            data class Summary(
                @SerializedName("bbox")
                val bbox: List<List<Double>>,
                @SerializedName("departureTime")
                val departureTime: String,
                @SerializedName("distance")
                val distance: Int,
                @SerializedName("duration")
                val duration: Int,
                @SerializedName("etaServiceType")
                val etaServiceType: Int,
                @SerializedName("fuelPrice")
                val fuelPrice: Int,
                @SerializedName("goal")
                val goal: Goal,
                @SerializedName("start")
                val start: Start,
                @SerializedName("taxiFare")
                val taxiFare: Int,
                @SerializedName("tollFare")
                val tollFare: Int
            ) {
                data class Goal(
                    @SerializedName("dir")
                    val dir: Int,
                    @SerializedName("location")
                    val location: List<Double>
                )

                data class Start(
                    @SerializedName("location")
                    val location: List<Double>
                )
            }
        }
    }
}