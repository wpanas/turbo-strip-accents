package com.github.wpanas

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import org.apache.commons.lang3.StringUtils
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup
import java.util.concurrent.TimeUnit

val INPUT: String = betterLookupTable.keys.joinToString("")

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 10)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
class MyBenchmark {

    @Benchmark
    fun apacheBenchmark(): String {
        return StringUtils.stripAccents(INPUT)
    }

    @Benchmark
    fun turboBenchmark(): String {
        return turboStripLowercaseAccents(INPUT)
    }

}