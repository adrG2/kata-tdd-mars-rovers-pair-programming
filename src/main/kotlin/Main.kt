fun main() {
    kataMarsRover(commands = listOf(Command.MoveForward))
}

data class Point(val x: Int, val y: Int)
enum class Direction { North, South, East, West }
data class Rover(val point: Point, val direction: Direction)
enum class Command { MoveForward, MoveBackward, TurnLeft, TurnRight }

fun kataMarsRover(
    rover: Rover = Rover(Point(0, 0), Direction.North),
    commands: List<Command>
): Rover = commands.fold(rover, Rover::sendCommand)


fun Rover.sendCommand(command: Command): Rover =
    when (command) {
        Command.MoveForward -> when (direction) {
            Direction.North -> copy(point = point.copy(y = point.y + 1))
            Direction.South -> copy(point = point.copy(y = point.y - 1))
            Direction.East  -> copy(point = point.copy(x = point.x + 1))
            Direction.West  -> copy(point = point.copy(x = point.x - 1))
        }
        Command.MoveBackward -> when (direction) {
            Direction.North -> copy(point = point.copy(y = point.y - 1))
            Direction.South -> copy(point = point.copy(y = point.y + 1))
            Direction.East  -> copy(point = point.copy(x = point.x - 1))
            Direction.West  -> copy(point = point.copy(x = point.x + 1))
        }
        Command.TurnLeft -> when (direction) {
            Direction.North -> copy(direction = Direction.West)
            Direction.South -> copy(direction = Direction.East)
            Direction.East -> copy(direction = Direction.North)
            Direction.West -> copy(direction = Direction.South)
        }
        Command.TurnRight -> when (direction) {
            Direction.North -> this
            Direction.South -> this
            Direction.East -> this
            Direction.West -> this
        }
    }

