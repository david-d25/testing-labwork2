package space.davids_digital

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

class TestUtil {
    companion object {
        private const val PRECISION = 1E-4

        fun assertBigDouble(expected: Double, actual: Double) {
            assertEquals(expected.getMantissa(), actual.getMantissa(), PRECISION)
            assertEquals(expected.getOrder(), actual.getOrder())
        }

        private fun Double.getMantissa() = this / (10.0.pow(floor(log10(this))))

        private fun Double.getOrder() = log10(this).toInt()
    }
}