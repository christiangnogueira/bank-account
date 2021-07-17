package com.micronaut.study

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.micronaut.study")
		.start()
}

