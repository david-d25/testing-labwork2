package space.davids_digital

import java.lang.IllegalArgumentException
import kotlin.math.*

class ScrapMathImpl: ScrapMath {
    companion object {
        private const val MAX_DELTA = 0.000000000001
    }

    override fun sin(x: Double): Double {
        if (x.isNaN())
            throw IllegalArgumentException("x should be a real number")

        var result = 0.0
        var monomial: Double
        var monomialIndex = 0
        do {
            monomial = (-1.0).pow(monomialIndex) * x.pow(2*monomialIndex + 1) / factorial(2*monomialIndex + 1)
            result += monomial
            monomialIndex++
        } while (abs(monomial) > MAX_DELTA)
        return result
    }

    override fun cos(x: Double) = sin(x + PI/2)
    override fun cot(x: Double) = 1/tan(x)
    override fun sec(x: Double) = 1/cos(x)
    override fun tan(x: Double) = sin(x)/cos(x)
    override fun csc(x: Double) = 1/sin(x)

    override fun log(x: Double): Double {
        if (x <= 0 || x.isNaN())
            throw IllegalArgumentException("x should be real positive number")

        var result = 0.0
        var monomial: Double
        var monomialIndex = 0
        do {
            monomial = 1.0/(2*monomialIndex + 1) * ((x-1)/(x+1)).pow(2*monomialIndex + 1)
            result += monomial
            monomialIndex++
        } while (abs(monomial) > MAX_DELTA)
        result *= 2
        return result
    }

    override fun log2(x: Double) = log(x)/log(2.0)
    override fun log3(x: Double) = log(x)/log(3.0)
    override fun log5(x: Double) = log(x)/log(5.0)
    override fun log10(x: Double) = log(x)/log(10.0)

    private fun factorial(x: Int): Double {
        var result = 1.0
        var counter = x
        while (counter > 0) {
            result *= counter
            counter--
        }
        return result
    }
}