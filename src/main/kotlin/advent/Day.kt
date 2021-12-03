package advent

/**
 * @author Patrick Younan
 */
interface Day {

    fun solve()
}

fun solve(day: Day) {
    val start = System.currentTimeMillis()
    day.solve()
    val elapsed = System.currentTimeMillis() - start
    println("Solution took $elapsed ms.")
}