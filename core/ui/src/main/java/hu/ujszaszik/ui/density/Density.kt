package hu.ujszaszik.ui.density

enum class Density(val value: Float) {
    LDPI(0.75f),
    MDPI(1.0f),
    HDPI(1.5f),
    XHDPI(2.0f),
    XXHDPI(3.0f),
    XXXHDPI(4.0f);

    companion object {
        fun getByValue(density: Float): Density? {
            return when {
                density <= LDPI.value -> LDPI
                density <= MDPI.value -> MDPI
                density <= HDPI.value -> HDPI
                density <= XHDPI.value -> XHDPI
                density <= XXHDPI.value -> XXHDPI
                density <= XXXHDPI.value -> XXXHDPI
                else -> null
            }
        }
    }

}