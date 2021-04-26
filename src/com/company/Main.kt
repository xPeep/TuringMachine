package com.company

import com.company.turingmachine.TuringMachine
import java.io.IOException

object Main {
	@JvmStatic
	fun main(args: Array<String>) {
		try {
			val tur = TuringMachine()
			tur.rules("src/com/company/turingmachine/a_add_b.txt")
			println(" 3 + 2 ")
			tur.simulation()
			tur.rules("src/com/company/turingmachine/a_minus_b.txt")
			println(" 4 - 2 ")
			tur.simulation()
		} catch (e: IOException) {
			e.printStackTrace()
		}
	}
}
