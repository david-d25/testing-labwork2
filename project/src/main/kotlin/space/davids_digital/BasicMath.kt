package space.davids_digital

import java.lang.IllegalArgumentException
import kotlin.math.abs
import kotlin.math.pow

open class BasicMath {
    companion object {
        private const val MAX_DELTA = 0.000000000001
    }

    open fun sin(x: Double): Double {
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

    open fun log(x: Double): Double {
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