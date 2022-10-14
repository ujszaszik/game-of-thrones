package hu.ujszaszik.data.remote.error

enum class NetworkError(val message: String) {
    NO_CONNECTION("There is no internet connection."),
    TIMEOUT("The request has timed out."),
    API_ERROR("An error occurred during fetching data.")
}