fun main() {
    kataMarsRover(listOf(Command.Forward))
}

data class Point(val x: Int, val y: Int)
enum class Direction { North, South, East, West }
data class Rover(val point: Point, val direction: Direction)
enum class Command { Forward, Backward, Left, Right }

fun kataMarsRover(commands: List<Command>): Rover {
    var rover = Rover(Point(0, 0), Direction.North)
    for (command in commands) {
        rover = rover.sendCommand(command)
    }
    return rover
}

fun Rover.sendCommand(command: Command): Rover =
    when (command) {
        Command.Forward -> when (direction) {
            Direction.North -> copy(point = point.copy(y = point.y + 1))
            Direction.South -> copy(point = point.copy(y = point.y - 1))
            Direction.East -> this
            Direction.West -> this
        }
        Command.Backward -> when (direction) {
            Direction.North -> copy(point = point.copy(y = point.y - 1))
            Direction.South -> this
            Direction.East -> this
            Direction.West -> this
        }
        Command.Left -> when (direction) {
            Direction.North -> copy(direction = Direction.West)
            Direction.South -> this
            Direction.East -> this
            Direction.West -> copy(direction = Direction.South)
        }
        Command.Right -> when (direction) {
            Direction.North -> this
            Direction.South -> this
            Direction.East -> this
            Direction.West -> this
        }
    }

