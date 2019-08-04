package raj.outlet_form.data

data class flight(
    val appendix: Appendix,
    val flights: List<Flight>
)

data class Flight(
    val `class`: String,
    val airlineCode: String,
    val arrivalTime: Long,
    val departureTime: Long,
    val destinationCode: String,
    val fares: List<Fare>,
    val originCode: String
)

data class Fare(
    val fare: Int,
    val providerId: Int
)

data class Appendix(
    val airlines: Airlines,
    val airports: Airports,
    val providers: Providers
)

data class Airports(
    val BOM: String,
    val DEL: String
)

data class Airlines(
    val `6E`: String,
    val `9W`: String,
    val AI: String,
    val G8: String,
    val SG: String
)

data class Providers(
    val `1`: String,
    val `2`: String,
    val `3`: String,
    val `4`: String
)