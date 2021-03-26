package space.davids_digital

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.Double.Companion.POSITIVE_INFINITY
import kotlin.math.PI

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScrapSolutionTest {
    companion object {
        const val DELTA = 0.0001
        const val PERIOD = 2*PI
    }

    private lateinit var mathMock: ScrapMath

    @BeforeAll
    fun initMock() {
        mathMock = mock(ScrapMath::class.java)
        `when`(mathMock.sin(0.0)).thenReturn(0.0)
        `when`(mathMock.sin(-1.0)).thenReturn(-0.841470985)
        `when`(mathMock.sin(-PI/2)).thenReturn(-1.0)
        `when`(mathMock.sin(-PI/2 + DELTA)).thenReturn(-0.999999995)
        `when`(mathMock.sin(-PI/2 - DELTA)).thenReturn(-0.999999995)
        `when`(mathMock.sin(-2.0)).thenReturn(-0.909297427)
        `when`(mathMock.sin(-PI)).thenReturn(0.0)
        `when`(mathMock.sin(-4.0)).thenReturn(0.756802495)
        `when`(mathMock.sin(-3/2*PI)).thenReturn(1.0)
        `when`(mathMock.sin(-3/2*PI + DELTA)).thenReturn(0.999999995)
        `when`(mathMock.sin(-3/2*PI - DELTA)).thenReturn(0.999999995)
        `when`(mathMock.sin(-5.0)).thenReturn(0.958924275)
        `when`(mathMock.sin(-2*PI)).thenReturn(0.0)

        `when`(mathMock.cos(0.0)).thenReturn(1.0)
        `when`(mathMock.cos(-1.0)).thenReturn(0.540302306)
        `when`(mathMock.cos(-PI/2)).thenReturn(0.0)
        `when`(mathMock.cos(-PI/2 + DELTA)).thenReturn(9.99999998e-5)
        `when`(mathMock.cos(-PI/2 - DELTA)).thenReturn(-9.99999998e-5)
        `when`(mathMock.cos(-2.0)).thenReturn(-0.416146837)
        `when`(mathMock.cos(-PI)).thenReturn(-1.0)
        `when`(mathMock.cos(-4.0)).thenReturn(-0.653643621)
        `when`(mathMock.cos(-3/2*PI)).thenReturn(0.0)
        `when`(mathMock.cos(-3/2*PI + DELTA)).thenReturn(-9.99999998e-5)
        `when`(mathMock.cos(-3/2*PI - DELTA)).thenReturn(9.99999998e-5)
        `when`(mathMock.cos(-5.0)).thenReturn(0.283662185)
        `when`(mathMock.cos(-2*PI)).thenReturn(1.0)

        `when`(mathMock.cot(0.0)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.cot(-1.0)).thenReturn(-0.642092616)
        `when`(mathMock.cot(-PI/2)).thenReturn(0.0)
        `when`(mathMock.cot(-PI/2 + DELTA)).thenReturn(-0.0001)
        `when`(mathMock.cot(-PI/2 - DELTA)).thenReturn(0.0001)
        `when`(mathMock.cot(-2.0)).thenReturn(0.457657554)
        `when`(mathMock.cot(-PI)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.cot(-4.0)).thenReturn(-0.863691154)
        `when`(mathMock.cot(-3/2*PI)).thenReturn(0.0)
        `when`(mathMock.cot(-3/2*PI + DELTA)).thenReturn(-0.0001)
        `when`(mathMock.cot(-3/2*PI - DELTA)).thenReturn(0.0001)
        `when`(mathMock.cot(-5.0)).thenReturn(0.295812916)
        `when`(mathMock.cot(-2*PI)).thenReturn(POSITIVE_INFINITY)

        `when`(mathMock.sec(0.0)).thenReturn(1.0)
        `when`(mathMock.sec(-1.0)).thenReturn(1.85081572)
        `when`(mathMock.sec(-PI/2)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.sec(-PI/2 + DELTA)).thenReturn(10000.0)
        `when`(mathMock.sec(-PI/2 - DELTA)).thenReturn(-10000.0)
        `when`(mathMock.sec(-2.0)).thenReturn(-2.40299796)
        `when`(mathMock.sec(-PI)).thenReturn(-1.0)
        `when`(mathMock.sec(-4.0)).thenReturn(-1.52988566)
        `when`(mathMock.sec(-3/2*PI)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.sec(-3/2*PI + DELTA)).thenReturn(-10000.0)
        `when`(mathMock.sec(-3/2*PI - DELTA)).thenReturn(10000.0)
        `when`(mathMock.sec(-5.0)).thenReturn(3.52532009)
        `when`(mathMock.sec(-2*PI)).thenReturn(1.0)

        `when`(mathMock.tan(0.0)).thenReturn(0.0)
        `when`(mathMock.tan(-1.0)).thenReturn(-1.55740772)
        `when`(mathMock.tan(-PI/2)).thenReturn(-1.63312394e16)
        `when`(mathMock.tan(-PI/2 + DELTA)).thenReturn(-9999.99997)
        `when`(mathMock.tan(-PI/2 - DELTA)).thenReturn(9999.99997)
        `when`(mathMock.tan(-2.0)).thenReturn(2.18503986)
        `when`(mathMock.tan(-PI)).thenReturn(0.0)
        `when`(mathMock.tan(-4.0)).thenReturn(-1.15782128)
        `when`(mathMock.tan(-3/2*PI)).thenReturn(-5.44374645e15)
        `when`(mathMock.tan(-3/2*PI + DELTA)).thenReturn(-9999.99997)
        `when`(mathMock.tan(-3/2*PI - DELTA)).thenReturn(9999.99997)
        `when`(mathMock.tan(-5.0)).thenReturn(3.38051501)
        `when`(mathMock.tan(-2*PI)).thenReturn(0.0)

        `when`(mathMock.csc(0.0)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.csc(-1.0)).thenReturn(-1.18839511)
        `when`(mathMock.csc(-PI/2)).thenReturn(-1.0)
        `when`(mathMock.csc(-PI/2 + DELTA)).thenReturn(-1.0)
        `when`(mathMock.csc(-PI/2 - DELTA)).thenReturn(-1.0)
        `when`(mathMock.csc(-2.0)).thenReturn(-1.09975017)
        `when`(mathMock.csc(-PI)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.csc(-4.0)).thenReturn(1.32134871)
        `when`(mathMock.csc(-3/2*PI)).thenReturn(1.0)
        `when`(mathMock.csc(-3/2*PI + DELTA)).thenReturn(1.0)
        `when`(mathMock.csc(-3/2*PI - DELTA)).thenReturn(1.0)
        `when`(mathMock.csc(-5.0)).thenReturn(1.04283521)
        `when`(mathMock.csc(-2*PI)).thenReturn(POSITIVE_INFINITY)

        `when`(mathMock.sin(-PERIOD + 0.0)).thenReturn(0.0)
        `when`(mathMock.sin(-PERIOD + -1.0)).thenReturn(-0.841470985)
        `when`(mathMock.sin(-PERIOD + -PI/2)).thenReturn(-1.0)
        `when`(mathMock.sin(-PERIOD + -PI/2 + DELTA)).thenReturn(-0.999999995)
        `when`(mathMock.sin(-PERIOD + -PI/2 - DELTA)).thenReturn(-0.999999995)
        `when`(mathMock.sin(-PERIOD + -2.0)).thenReturn(-0.909297427)
        `when`(mathMock.sin(-PERIOD + -PI)).thenReturn(0.0)
        `when`(mathMock.sin(-PERIOD + -4.0)).thenReturn(0.756802495)
        `when`(mathMock.sin(-PERIOD + -3/2*PI)).thenReturn(1.0)
        `when`(mathMock.sin(-PERIOD + -3/2*PI + DELTA)).thenReturn(0.999999995)
        `when`(mathMock.sin(-PERIOD + -3/2*PI - DELTA)).thenReturn(0.999999995)
        `when`(mathMock.sin(-PERIOD + -5.0)).thenReturn(0.958924275)
        `when`(mathMock.sin(-PERIOD + -2*PI)).thenReturn(0.0)

        `when`(mathMock.cos(-PERIOD + 0.0)).thenReturn(1.0)
        `when`(mathMock.cos(-PERIOD + -1.0)).thenReturn(0.540302306)
        `when`(mathMock.cos(-PERIOD + -PI/2)).thenReturn(0.0)
        `when`(mathMock.cos(-PERIOD + -PI/2 + DELTA)).thenReturn(9.99999998e-5)
        `when`(mathMock.cos(-PERIOD + -PI/2 - DELTA)).thenReturn(-9.99999998e-5)
        `when`(mathMock.cos(-PERIOD + -2.0)).thenReturn(-0.416146837)
        `when`(mathMock.cos(-PERIOD + -PI)).thenReturn(-1.0)
        `when`(mathMock.cos(-PERIOD + -4.0)).thenReturn(-0.653643621)
        `when`(mathMock.cos(-PERIOD + -3/2*PI)).thenReturn(0.0)
        `when`(mathMock.cos(-PERIOD + -3/2*PI + DELTA)).thenReturn(-9.99999998e-5)
        `when`(mathMock.cos(-PERIOD + -3/2*PI - DELTA)).thenReturn(9.99999998e-5)
        `when`(mathMock.cos(-PERIOD + -5.0)).thenReturn(0.283662185)
        `when`(mathMock.cos(-PERIOD + -2*PI)).thenReturn(1.0)

        `when`(mathMock.cot(-PERIOD + 0.0)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.cot(-PERIOD + -1.0)).thenReturn(-0.642092616)
        `when`(mathMock.cot(-PERIOD + -PI/2)).thenReturn(0.0)
        `when`(mathMock.cot(-PERIOD + -PI/2 + DELTA)).thenReturn(-0.0001)
        `when`(mathMock.cot(-PERIOD + -PI/2 - DELTA)).thenReturn(0.0001)
        `when`(mathMock.cot(-PERIOD + -2.0)).thenReturn(0.457657554)
        `when`(mathMock.cot(-PERIOD + -PI)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.cot(-PERIOD + -4.0)).thenReturn(-0.863691154)
        `when`(mathMock.cot(-PERIOD + -3/2*PI)).thenReturn(0.0)
        `when`(mathMock.cot(-PERIOD + -3/2*PI + DELTA)).thenReturn(-0.0001)
        `when`(mathMock.cot(-PERIOD + -3/2*PI - DELTA)).thenReturn(0.0001)
        `when`(mathMock.cot(-PERIOD + -5.0)).thenReturn(0.295812916)
        `when`(mathMock.cot(-PERIOD + -2*PI)).thenReturn(POSITIVE_INFINITY)

        `when`(mathMock.sec(-PERIOD + 0.0)).thenReturn(1.0)
        `when`(mathMock.sec(-PERIOD + -1.0)).thenReturn(1.85081572)
        `when`(mathMock.sec(-PERIOD + -PI/2)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.sec(-PERIOD + -PI/2 + DELTA)).thenReturn(10000.0)
        `when`(mathMock.sec(-PERIOD + -PI/2 - DELTA)).thenReturn(-10000.0)
        `when`(mathMock.sec(-PERIOD + -2.0)).thenReturn(-2.40299796)
        `when`(mathMock.sec(-PERIOD + -PI)).thenReturn(-1.0)
        `when`(mathMock.sec(-PERIOD + -4.0)).thenReturn(-1.52988566)
        `when`(mathMock.sec(-PERIOD + -3/2*PI)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.sec(-PERIOD + -3/2*PI + DELTA)).thenReturn(-10000.0)
        `when`(mathMock.sec(-PERIOD + -3/2*PI - DELTA)).thenReturn(10000.0)
        `when`(mathMock.sec(-PERIOD + -5.0)).thenReturn(3.52532009)
        `when`(mathMock.sec(-PERIOD + -2*PI)).thenReturn(1.0)

        `when`(mathMock.tan(-PERIOD + 0.0)).thenReturn(0.0)
        `when`(mathMock.tan(-PERIOD + -1.0)).thenReturn(-1.55740772)
        `when`(mathMock.tan(-PERIOD + -PI/2)).thenReturn(-1.63312394e16)
        `when`(mathMock.tan(-PERIOD + -PI/2 + DELTA)).thenReturn(-9999.99997)
        `when`(mathMock.tan(-PERIOD + -PI/2 - DELTA)).thenReturn(9999.99997)
        `when`(mathMock.tan(-PERIOD + -2.0)).thenReturn(2.18503986)
        `when`(mathMock.tan(-PERIOD + -PI)).thenReturn(0.0)
        `when`(mathMock.tan(-PERIOD + -4.0)).thenReturn(-1.15782128)
        `when`(mathMock.tan(-PERIOD + -3/2*PI)).thenReturn(-5.44374645e15)
        `when`(mathMock.tan(-PERIOD + -3/2*PI + DELTA)).thenReturn(-9999.99997)
        `when`(mathMock.tan(-PERIOD + -3/2*PI - DELTA)).thenReturn(9999.99997)
        `when`(mathMock.tan(-PERIOD + -5.0)).thenReturn(3.38051501)
        `when`(mathMock.tan(-PERIOD + -2*PI)).thenReturn(0.0)

        `when`(mathMock.csc(-PERIOD + 0.0)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.csc(-PERIOD + -1.0)).thenReturn(-1.18839511)
        `when`(mathMock.csc(-PERIOD + -PI/2)).thenReturn(-1.0)
        `when`(mathMock.csc(-PERIOD + -PI/2 + DELTA)).thenReturn(-1.0)
        `when`(mathMock.csc(-PERIOD + -PI/2 - DELTA)).thenReturn(-1.0)
        `when`(mathMock.csc(-PERIOD + -2.0)).thenReturn(-1.09975017)
        `when`(mathMock.csc(-PERIOD + -PI)).thenReturn(POSITIVE_INFINITY)
        `when`(mathMock.csc(-PERIOD + -4.0)).thenReturn(1.32134871)
        `when`(mathMock.csc(-PERIOD + -3/2*PI)).thenReturn(1.0)
        `when`(mathMock.csc(-PERIOD + -3/2*PI + DELTA)).thenReturn(1.0)
        `when`(mathMock.csc(-PERIOD + -3/2*PI - DELTA)).thenReturn(1.0)
        `when`(mathMock.csc(-PERIOD + -5.0)).thenReturn(1.04283521)
        `when`(mathMock.csc(-PERIOD + -2*PI)).thenReturn(POSITIVE_INFINITY)
    }

    /**
     * points: 0, -1, -pi/2 (+/- DELTA), -2, -pi, -4, -3/2*pi (+/- DELTA), -5, -2*pi
     */

    @Test
    fun `x = 0`() {
        val solver = ScrapSolution(mathMock)
        assertEquals(Double.NaN, solver.solve(0.0), DELTA)
        assertEquals(Double.NaN, solver.solve(0.0 - PERIOD), DELTA)
    }

    @Test
    fun `x = -1`() {
        val solver = ScrapSolution(mathMock)
        assertEquals(1.2818590689346397E28, solver.solve(-1.0), DELTA)
        assertEquals(1.2818590689346397E28, solver.solve(-1.0 - PERIOD), DELTA)
    }
}