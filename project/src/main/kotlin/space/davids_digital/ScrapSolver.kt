package space.davids_digital

import kotlin.math.pow

class ScrapSolver(private val mathImpl: ScrapMath) {
    private val cot = mathImpl::cot
    private val sin = mathImpl::sin
    private val cos = mathImpl::cos
    private val csc = mathImpl::csc
    private val tan = mathImpl::tan
    private val sec = mathImpl::sec
    private val log = mathImpl::log
    private val log2 = mathImpl::log2
    private val log3 = mathImpl::log3
    private val log5 = mathImpl::log5
    private val log10 = mathImpl::log10

    fun solve(x: Double): Double {
        return if (x <= 0)
            ((((((((((((((((((cot(x).pow(2)) - sin(x)).pow(2)) * cos(x)) - sin(x)) / (cos(x) / (sin(x).pow(3)))).pow(2)).pow(3)).pow(3)).pow(3)) + sin(x)) - cot(x)) * cot(x)) + sin(x)).pow(2)) / (((cot(x) - cos(x)).pow(2)) / (cot(x) * (((cot(x) / (sec(x) - (tan(x) + cot(x)))) - cot(x)) / sec(x))))) - ((((((tan(x) * csc(x)) / cot(x)) + ((((cot(x) - ((sin(x).pow(3)) + (csc(x) / (csc(x) / tan(x))))) / csc(x)) - ((((sin(x) / cos(x)).pow(2)) - tan(x)) - sin(x))) - cot(x))) * (sec(x) - (((sec(x) + (tan(x) / (tan(x) / (sec(x).pow(3))))) / sin(x)) + ((((cot(x).pow(3)) / cot(x)) + (sin(x) / cos(x))).pow(3))))).pow(3)).pow(3))) * tan(x))
        else
            (((((log(x).pow(3)) * log(x)) * (log10(x) + log(x))) * ((log5(x) + (log10(x) * log2(x))) / log5(x))) + ((log(x) - log(x)) + (log2(x) - log3(x))))
    }
}