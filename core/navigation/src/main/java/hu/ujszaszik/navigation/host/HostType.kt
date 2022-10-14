package hu.ujszaszik.navigation.host

enum class HostType {
    // Shows no App Bar
    DEFAULT,

    // Shows App Bar
    MAIN,

    // Shows App Bar with back arrow
    SUB;

    val showAppBar: Boolean
        get() = this != DEFAULT
}