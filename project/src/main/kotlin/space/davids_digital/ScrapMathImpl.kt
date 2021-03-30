package space.davids_digital

import java.lang.IllegalArgumentException
import kotlin.math.*

class ScrapMathImpl(private val basicMath: BasicMath = BasicMath()): ScrapMath {
    override fun sin(x: Double) = basicMath.sin(x)
    override fun cos(x: Double) = sin(x + PI/2)
    override fun cot(x: Double) = 1/tan(x)
    override fun sec(x: Double) = 1/cos(x)
    override fun tan(x: Double) = sin(x)/cos(x)
    override fun csc(x: Double) = 1/sin(x)

    override fun log(x: Double) = basicMath.log(x)
    override fun log2(x: Double) = log(x)/log(2.0)
    override fun log3(x: Double) = log(x)/log(3.0)
    override fun log5(x: Double) = log(x)/log(5.0)
    override fun log10(x: Double) = log(x)/log(10.0)
}