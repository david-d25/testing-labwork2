package space.davids_digital
import kotlin.math.*

fun main() {
    val asymptotesPeriodic = arrayOf(0.0, -0.5*PI, -PI,  -3/2* PI)
    val extremesPeriodic = arrayOf(-0.717,-1.867,-2.363,-2.637,-5.151,-5.507,-5.685,-5.797,-5.801)
    val zeroesPeriodic = arrayOf(-1.864,-2.643,-3.72,-5.145,-5.801)
    val simplePointsPeriodic = arrayOf(-0.635, -0.8, -1.8627, -1.8651, -1.8752, -2.6, -2.6416, -2.647, -3.707, -3.739, -5.142, -5.147, -5.165, -5.6, -5.732, -5.796, -5.8, -5.804)
    val extremes = arrayOf(0.401)
    val zeroes = arrayOf(0.307, 1.0)
    val simplePoints = arrayOf(0.28, 0.327, 0.6, 1.6)
    val format = { x: Double -> x.toString().replace("Infinity", "POSITIVE_INFINITY") }
    for (x in simplePointsPeriodic + asymptotesPeriodic + extremesPeriodic + zeroesPeriodic) {
        println("`when`(mathMock.sin(${format(x)})).thenReturn(${format(sin(x))})")
        println("`when`(mathMock.cos(${format(x)})).thenReturn(${format(cos(x))})")
        println("`when`(mathMock.tan(${format(x)})).thenReturn(${format(tan(x))})")
        println("`when`(mathMock.cot(${format(x)})).thenReturn(${format(1/ tan(x))})")
        println("`when`(mathMock.sec(${format(x)})).thenReturn(${format(1/ cos(x))})")
        println("`when`(mathMock.csc(${format(x)})).thenReturn(${format(1/ sin(x))})")
        println("`when`(mathMock.sin(${format(x)} - PERIOD)).thenReturn(${format(sin(x))})")
        println("`when`(mathMock.cos(${format(x)} - PERIOD)).thenReturn(${format(cos(x))})")
        println("`when`(mathMock.tan(${format(x)} - PERIOD)).thenReturn(${format(tan(x))})")
        println("`when`(mathMock.cot(${format(x)} - PERIOD)).thenReturn(${format(1/ tan(x))})")
        println("`when`(mathMock.sec(${format(x)} - PERIOD)).thenReturn(${format(1/ cos(x))})")
        println("`when`(mathMock.csc(${format(x)} - PERIOD)).thenReturn(${format(1/ sin(x))})")
        println("`when`(mathMock.sin(${format(x)} - 100*PERIOD)).thenReturn(${format(sin(x))})")
        println("`when`(mathMock.cos(${format(x)} - 100*PERIOD)).thenReturn(${format(cos(x))})")
        println("`when`(mathMock.tan(${format(x)} - 100*PERIOD)).thenReturn(${format(tan(x))})")
        println("`when`(mathMock.cot(${format(x)} - 100*PERIOD)).thenReturn(${format(1/ tan(x))})")
        println("`when`(mathMock.sec(${format(x)} - 100*PERIOD)).thenReturn(${format(1/ cos(x))})")
        println("`when`(mathMock.csc(${format(x)} - 100*PERIOD)).thenReturn(${format(1/ sin(x))})")

    }

    for (x in asymptotesPeriodic + extremesPeriodic) {
        println("`when`(mathMock.sin(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(sin(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cos(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(cos(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.tan(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(tan(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cot(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(1/ tan(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sec(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(1/ cos(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.csc(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(1/ sin(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sin(${format(x)} - NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(sin(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cos(${format(x)} - NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(cos(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.tan(${format(x)} - NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(tan(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cot(${format(x)} - NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(1/ tan(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sec(${format(x)} - NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(1/ cos(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.csc(${format(x)} - NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(1/ sin(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sin(${format(x)} - NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(sin(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cos(${format(x)} - NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(cos(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.tan(${format(x)} - NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(tan(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cot(${format(x)} - NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(1/ tan(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sec(${format(x)} - NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(1/ cos(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.csc(${format(x)} - NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(1/ sin(x - ScrapSolverTest.NEIGHBORHOOD_DELTA))})")

        println("`when`(mathMock.sin(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(sin(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cos(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(cos(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.tan(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(tan(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cot(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(1/ tan(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sec(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(1/ cos(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.csc(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(1/ sin(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sin(${format(x)} + NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(sin(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cos(${format(x)} + NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(cos(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.tan(${format(x)} + NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(tan(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cot(${format(x)} + NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(1/ tan(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sec(${format(x)} + NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(1/ cos(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.csc(${format(x)} + NEIGHBORHOOD_DELTA - PERIOD)).thenReturn(${format(1/ sin(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sin(${format(x)} + NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(sin(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cos(${format(x)} + NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(cos(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.tan(${format(x)} + NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(tan(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.cot(${format(x)} + NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(1/ tan(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.sec(${format(x)} + NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(1/ cos(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
        println("`when`(mathMock.csc(${format(x)} + NEIGHBORHOOD_DELTA - 100*PERIOD)).thenReturn(${format(1/ sin(x + ScrapSolverTest.NEIGHBORHOOD_DELTA))})")
    }

    for (x in extremes + zeroes + simplePoints) {
        println("`when`(mathMock.log(${format(x)})).thenReturn(${format(log(x, E))})")
        println("`when`(mathMock.log2(${format(x)})).thenReturn(${format(log(x, 2.0))})")
        println("`when`(mathMock.log3(${format(x)})).thenReturn(${format(log(x, 3.0))})")
        println("`when`(mathMock.log5(${format(x)})).thenReturn(${format(log(x, 5.0))})")
        println("`when`(mathMock.log10(${format(x)})).thenReturn(${format(log(x, 10.0))})")
    }

    for (x in extremes + zeroes) {
        println("`when`(mathMock.log(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x - ScrapSolverTest.NEIGHBORHOOD_DELTA, E))})")
        println("`when`(mathMock.log2(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x - ScrapSolverTest.NEIGHBORHOOD_DELTA, 2.0))})")
        println("`when`(mathMock.log3(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x - ScrapSolverTest.NEIGHBORHOOD_DELTA, 3.0))})")
        println("`when`(mathMock.log5(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x - ScrapSolverTest.NEIGHBORHOOD_DELTA, 5.0))})")
        println("`when`(mathMock.log10(${format(x)} - NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x - ScrapSolverTest.NEIGHBORHOOD_DELTA, 10.0))})")

        println("`when`(mathMock.log(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x + ScrapSolverTest.NEIGHBORHOOD_DELTA, E))})")
        println("`when`(mathMock.log2(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x + ScrapSolverTest.NEIGHBORHOOD_DELTA, 2.0))})")
        println("`when`(mathMock.log3(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x + ScrapSolverTest.NEIGHBORHOOD_DELTA, 3.0))})")
        println("`when`(mathMock.log5(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x + ScrapSolverTest.NEIGHBORHOOD_DELTA, 5.0))})")
        println("`when`(mathMock.log10(${format(x)} + NEIGHBORHOOD_DELTA)).thenReturn(${format(log(x + ScrapSolverTest.NEIGHBORHOOD_DELTA, 10.0))})")
    }
}