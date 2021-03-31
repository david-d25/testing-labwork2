package space.davids_digital

import java.io.File
import java.io.PrintWriter
import kotlin.math.abs

class CsvDumper {
    companion object {
        fun dumpCsv(math: ScrapMath, solver: ScrapSolver, filename: String, from: Double, to: Double, step: Double) {
            PrintWriter(File(filename)).use { writer ->
                writer.println("x,f(x),sin(x),cos(x),tan(x),cot(x),sec(x),csc(x),log(x),log2(x),log3(x),log5(x),log10(x)")
                var x: Double = from
                while (x < to) {
                    writer.print("$x, ${solver.solve(x)}, ${math.sin(x)}, ${math.cos(x)}, ${math.tan(x)}, ${math.cot(x)}, ${math.sec(x)}, ${math.csc(x)}, ")
                    writer.println(
                        if (x > 0)  "${math.log(x)}, ${math.log2(x)}, ${math.log3(x)}, ${math.log5(x)}, ${math.log10(x)}"
                        else        "NaN, NaN, NaN, NaN, NaN"
                    )
                    x += step

                    if (abs(x) <= 1e-6)
                        x = 0.0
                }
            }
        }
    }
}

fun main() {
    val math = ScrapMathImpl(BasicMath())
    CsvDumper.dumpCsv(math, ScrapSolver(math), "file.csv", -8.0, 8.0, 0.0625)
}