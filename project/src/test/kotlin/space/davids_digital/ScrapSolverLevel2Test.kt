package space.davids_digital

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.assertAll
import space.davids_digital.TestUtil.Companion.assertBigDouble
import kotlin.Double.Companion.NEGATIVE_INFINITY
import kotlin.Double.Companion.NaN
import kotlin.math.PI

@TestInstance(PER_CLASS)
class ScrapSolverLevel2Test {
    companion object {
        const val NEIGHBORHOOD_DELTA = 0.0000001
        const val MAX_ERROR = 0.000001
        const val PERIOD = 2* PI
    }

    private lateinit var solver: ScrapSolver

    @BeforeAll
    fun initSolver() {
        solver = ScrapSolver(ScrapMathImpl())
    }

    @Test
    fun `at asymptotes`() {
        assertAll(
                // periodic
                {assertEquals(NaN, solver.solve(0.0), MAX_ERROR)},
                {assertEquals(NaN, solver.solve(-0.5 * PI), MAX_ERROR)},
                {assertEquals(6.6834363, solver.solve(PI), MAX_ERROR)},
                {assertEquals(NEGATIVE_INFINITY, solver.solve(-3 / 2 * PI), MAX_ERROR)},
                {assertEquals(NaN, solver.solve(0.0 - PERIOD), MAX_ERROR)},
                {assertEquals(NaN, solver.solve(-0.5 * PI - PERIOD), MAX_ERROR)},
                {assertEquals(NEGATIVE_INFINITY, solver.solve(PI - PERIOD), MAX_ERROR)},
                {assertEquals(NEGATIVE_INFINITY, solver.solve(-3 / 2 * PI - PERIOD), MAX_ERROR)}
        )
    }

    @Test
    fun `near asymptotes`() {
        assertAll(
                {assertBigDouble(2.379606959322E7,   solver.solve(0.0     + NEIGHBORHOOD_DELTA))},
                {assertEquals(NaN,                       solver.solve(-0.5*PI + NEIGHBORHOOD_DELTA))},
                {assertEquals(NaN,                       solver.solve(-PI     + NEIGHBORHOOD_DELTA))},
                {assertEquals(NaN,                       solver.solve(-3/2*PI + NEIGHBORHOOD_DELTA))},
                {assertEquals(NaN,                       solver.solve(0.0     - NEIGHBORHOOD_DELTA))},
                {assertEquals(NaN,                       solver.solve(-0.5*PI - NEIGHBORHOOD_DELTA))},
                {assertEquals(NEGATIVE_INFINITY,         solver.solve(-PI     - NEIGHBORHOOD_DELTA))},
                {assertEquals(NEGATIVE_INFINITY,         solver.solve(-3/2*PI - NEIGHBORHOOD_DELTA))},
                {assertEquals(NEGATIVE_INFINITY,         solver.solve(0.0     + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertEquals(NaN,                       solver.solve(-0.5*PI + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertEquals(NaN,                       solver.solve(-PI     + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertEquals(NaN,                       solver.solve(-3/2*PI + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertEquals(NaN,                       solver.solve(0.0     - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertEquals(NaN,                       solver.solve(-0.5*PI - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertEquals(NEGATIVE_INFINITY,         solver.solve(-PI     - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertEquals(NEGATIVE_INFINITY,         solver.solve(-3/2*PI - NEIGHBORHOOD_DELTA - PERIOD))}

        )
    }

    @Test
    fun `at extremes`() {
        // periodic
        assertAll(
                {assertBigDouble(3.0529194659361445E13,   solver.solve(-0.717))},
                {assertBigDouble(-1.4583709921831516E29,  solver.solve(-1.867))},
                {assertBigDouble(-2.746324158962901E15,   solver.solve(-2.363))},
                {assertBigDouble(-3.0359052276369726E20,  solver.solve(-2.637))},
                {assertBigDouble(4.78789039114917E12,     solver.solve(-5.151))},
                {assertBigDouble(2.2814173515074825E9,    solver.solve(-5.507))},
                {assertBigDouble(6.656125193022193E9,     solver.solve(-5.685))},
                {assertBigDouble(-13.759135310773415,     solver.solve(-5.797))},
                {assertBigDouble(-12.413011870459437,     solver.solve(-5.801))},
                {assertBigDouble(3.0529194659361445E13,   solver.solve(-0.717 - PERIOD))},
                {assertBigDouble(-1.4583709921831516E29,  solver.solve(-1.867 - PERIOD))},
                {assertBigDouble(-2.746324158962901E15,   solver.solve(-2.363 - PERIOD))},
                {assertBigDouble(-3.0359052276369726E20,  solver.solve(-2.637 - PERIOD))},
                {assertBigDouble(4.78789039114917E12,     solver.solve(-5.151 - PERIOD))},
                {assertBigDouble(2.2814173515074825E9,    solver.solve(-5.507 - PERIOD))},
                {assertBigDouble(6.656125193022193E9,     solver.solve(-5.685 - PERIOD))},
                {assertBigDouble(-13.759135310773415,     solver.solve(-5.797 - PERIOD))},
                {assertBigDouble(-12.413011870459437,     solver.solve(-5.801 - PERIOD))},
        // simple
                {assertBigDouble(-0.5583200340259737, solver.solve(0.401))}
        )

    }

    @Test
    fun `near extremes`() {
        assertAll(
                {assertBigDouble(3.0529194940501188E13, solver.solve(-0.717 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-1.4583702097775451E29, solver.solve(-1.867 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-2.746324168437796E15, solver.solve(-2.363 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-3.035903697616726E20, solver.solve(-2.637 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(4.787886328910792E12, solver.solve(-5.151 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(2.28141735883667E9, solver.solve(-5.507 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(6.656125083006235E9, solver.solve(-5.685 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-13.75909462183887, solver.solve(-5.797 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-12.413073588291374, solver.solve(-5.801 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(3.052919437852788E13, solver.solve(-0.717 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-1.4583717729649684E29, solver.solve(-1.867 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-2.746324149495239E15, solver.solve(-2.363 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-3.0359067568669655E20, solver.solve(-2.637 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(4.78789445238783E12, solver.solve(-5.151 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(2.28141734418101E9, solver.solve(-5.507 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(6.656125303013066E9, solver.solve(-5.685 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-13.759175981059713, solver.solve(-5.797 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-12.412950158090965, solver.solve(-5.801 - NEIGHBORHOOD_DELTA))},
                {assertBigDouble(3.0529194940501188E13, solver.solve(-0.717 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-1.4583702097775451E29, solver.solve(-1.867 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-2.746324168437796E15, solver.solve(-2.363 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-3.035903697616726E20, solver.solve(-2.637 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(4.787886328910792E12, solver.solve(-5.151 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(2.28141735883667E9, solver.solve(-5.507 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(6.656125083006235E9, solver.solve(-5.685 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-13.75909462183887, solver.solve(-5.797 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-12.413073588291374, solver.solve(-5.801 + NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(3.052919437852788E13, solver.solve(-0.717 - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-1.4583717729649684E29, solver.solve(-1.867 - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-2.746324149495239E15, solver.solve(-2.363 - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-3.0359067568669655E20, solver.solve(-2.637 - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(4.78789445238783E12, solver.solve(-5.151 - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(2.28141734418101E9, solver.solve(-5.507 - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(6.656125303013066E9, solver.solve(-5.685 - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-13.759175981059713, solver.solve(-5.797 - NEIGHBORHOOD_DELTA - PERIOD))},
                {assertBigDouble(-12.412950158090965, solver.solve(-5.801 - NEIGHBORHOOD_DELTA - PERIOD))},
        // simple
                {assertBigDouble(-0.5583200331288632, solver.solve(0.401 + NEIGHBORHOOD_DELTA))},
                {assertBigDouble(-0.5583200349225645, solver.solve(0.401 - NEIGHBORHOOD_DELTA))}

        )
        // periodic
         }

    @Test
    fun `x = 1 is a break`() {
        assertEquals(NaN, solver.solve(1.0))
        assertEquals(-5.324558406046574E-8, solver.solve(1.0 - NEIGHBORHOOD_DELTA), MAX_ERROR)
        assertEquals(5.324557879502206E-8, solver.solve(1.0 + NEIGHBORHOOD_DELTA), MAX_ERROR)
    }

    @Test
    fun `near zeroes`() {
        // periodic
        assertBigDouble(4.985870152126281E28, solver.solve(-1.864))
        assertBigDouble(3.253047027618872E19, solver.solve(-2.643))
        assertBigDouble(-0.07894168592285791, solver.solve(-3.720))
        assertBigDouble(-3.3995186922729065E11, solver.solve(-5.145))
        assertBigDouble(-12.413011870459437, solver.solve(-5.801))
        assertBigDouble(4.985870152126281E28, solver.solve(-1.864 - PERIOD))
        assertBigDouble(3.253047027618872E19, solver.solve(-2.643 - PERIOD))
        assertBigDouble(-0.07894168592285791, solver.solve(-3.720 - PERIOD))
        assertBigDouble(-3.3995186922729065E11, solver.solve(-5.145 - PERIOD))
        assertBigDouble(-12.413011870459437, solver.solve(-5.801 - PERIOD))
        // simple
        assertEquals(-2.0266179553385388E-4, solver.solve(0.307), MAX_ERROR)
    }

    @Test
    fun `at simple points`() {
        assertAll(
                // periodic
                {assertBigDouble(9.467551013160646E14, solver.solve(-0.6350))},
                {assertBigDouble(8.396770159403462E14, solver.solve(-0.8000))},
                {assertBigDouble(5.087520383882573E29, solver.solve(-1.8627))},
                {assertBigDouble(-9.150634717349539E28, solver.solve(-1.8651))},
                {assertBigDouble(-5.505931951772536E28, solver.solve(-1.8752))},
                {assertBigDouble(-1.7364655471205607E19, solver.solve(-2.6000))},
                {assertBigDouble(-1.47847555394059E20, solver.solve(-2.6416))},
                {assertBigDouble(1.5690707198568324E21, solver.solve(-2.6470))},
                {assertBigDouble(-5244.307172916271, solver.solve(-3.7070))},
                {assertBigDouble(1.6823234512148297, solver.solve(-3.7390))},
                {assertBigDouble(-1.5965177547612164E13, solver.solve(-5.1420))},
                {assertBigDouble(3.121697415663028E12, solver.solve(-5.1470))},
                {assertBigDouble(2.977147179959764E12, solver.solve(-5.1650))},
                {assertBigDouble(3.590227679157593E9, solver.solve(-5.6000))},
                {assertBigDouble(3.2796271139795513E9, solver.solve(-5.7320))},
                {assertBigDouble(-10.617902944663737, solver.solve(-5.7960))},
                {assertBigDouble(-13.040691498785424, solver.solve(-5.8000))},
                {assertBigDouble(-355.242762584736, solver.solve(-5.8040))},
                {assertBigDouble(9.467551013160646E14, solver.solve(-0.6350 - PERIOD))},
                {assertBigDouble(8.396770159403462E14, solver.solve(-0.8000 - PERIOD))},
                {assertBigDouble(5.087520383882573E29, solver.solve(-1.8627 - PERIOD))},
                {assertBigDouble(-9.150634717349539E28, solver.solve(-1.8651 - PERIOD))},
                {assertBigDouble(-5.505931951772536E28, solver.solve(-1.8752 - PERIOD))},
                {assertBigDouble(-1.7364655471205607E19, solver.solve(-2.6000 - PERIOD))},
                {assertBigDouble(-1.47847555394059E20, solver.solve(-2.6416 - PERIOD))},
                {assertBigDouble(1.5690707198568324E21, solver.solve(-2.6470 - PERIOD))},
                {assertBigDouble(-5244.307172916271, solver.solve(-3.7070 - PERIOD))},
                {assertBigDouble(1.6823234512148297, solver.solve(-3.7390 - PERIOD))},
                {assertBigDouble(-1.5965177547612164E13, solver.solve(-5.1420 - PERIOD))},
                {assertBigDouble(3.121697415663028E12, solver.solve(-5.1470 - PERIOD))},
                {assertBigDouble(2.977147179959764E12, solver.solve(-5.1650 - PERIOD))},
                {assertBigDouble(3.590227679157593E9, solver.solve(-5.6000 - PERIOD))},
                {assertBigDouble(3.2796271139795513E9, solver.solve(-5.7320 - PERIOD))},
                {assertBigDouble(-10.617902944663737, solver.solve(-5.7960 - PERIOD))},
                {assertBigDouble(-13.040691498785424, solver.solve(-5.8000 - PERIOD))},
                {assertBigDouble(-355.242762584736, solver.solve(-5.8040 - PERIOD))},
        // simple
                {assertBigDouble(0.6821391206694338, solver.solve(0.280))},
                {assertBigDouble(-0.27684034797093265, solver.solve(0.327))},
                {assertBigDouble(-0.29618223644836766, solver.solve(0.600))},
                {assertBigDouble(0.2987434317911068, solver.solve(1.600))}

        )
    }
}