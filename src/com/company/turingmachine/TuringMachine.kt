package com.company.turingmachine

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.*

class TuringMachine {
	private var rules: ArrayList<Array<String>>? = null
	private lateinit var tape: Array<String>
	private var state: String? = null
	private var position = 0

	@Throws(IOException::class)
	fun rules(path: String?) {
		val fileInput = FileReader(path)
		val rows = BufferedReader(fileInput)
		val tapeData = rows.readLine().split(" ".toRegex()).toTypedArray()
		tape = tapeData
		val numberLoadedRules = Integer.valueOf(rows.readLine())
		rules = ArrayList()
		for (i in 0 until numberLoadedRules) {
			val rules = rows.readLine().split(" ".toRegex()).toTypedArray()
			this.rules!!.add(rules)
		}
		println("Successfully")
	}

	fun simulation() {
		state = tape[0]
		position = 0
		goTo@ while (true) {
			println("""${tape.contentToString()} state: $state position: $position""")
			for (rule in rules!!) {
				if (rule[0] == state && rule[1] == tape[position + 1]) {
					when {
						"B" == rule[2] -> {
							tape[position + 1] = "B"
							state = rule[3]
							continue@goTo
						}
						"R" == rule[2] -> {
							tape[position] = tape[position + 1]
							tape[position + 1] = rule[3]
							state = rule[3]
							position++
							continue@goTo
						}
						"L" == rule[2] -> {
							tape[position] = tape[position - 1]
							tape[position - 1] = rule[3]
							state = rule[3]
							position--
							continue@goTo
						}
					}
					println("Failed")
					return
				}
			}
			break
		}
	}
}
