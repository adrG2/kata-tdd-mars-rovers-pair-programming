fun main() {
    kataMarsRover()
}

data class Point(private val x: Int, private val y: Int)
enum class Direction{ North, South, East, West }
data class Rover(private val point: Point, private val direction: Direction)

fun kataMarsRover(): Rover {
    return Rover(Point(0, 0), Direction.North)
}
