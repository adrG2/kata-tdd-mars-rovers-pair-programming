import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

data class TestData(
    val rover: Rover,
    val description: String? = null,
    val commands: List<Command>,
    val expected: Rover
)

class KataMarsRoverTest : FreeSpec({

    val roverAtZeroZeroNorth = Rover(Point(0, 0), Direction.North)
    val roverAtZeroZeroSouth = Rover(Point(0, 0), Direction.South)
    val roverAtZeroZeroEast = Rover(Point(0, 0), Direction.East)
    val roverAtZeroZeroWest = Rover(Point(0, 0), Direction.West)

    "Move the skeleton" - {
        listOf(
            TestData(
                rover = roverAtZeroZeroNorth,
                commands = listOf(Command.MoveForward),
                expected = Rover(Point(0, 1), Direction.North)
            ),
            TestData(
                rover = roverAtZeroZeroNorth,
                commands = listOf(Command.MoveForward, Command.MoveForward),
                expected = Rover(Point(0, 2), Direction.North)
            ),
            TestData(
                rover = roverAtZeroZeroSouth,
                commands = listOf(Command.MoveForward),
                expected = Rover(Point(0, -1), Direction.South)
            ),
            TestData(
                rover = roverAtZeroZeroEast,
                commands = listOf(Command.MoveForward),
                expected = Rover(Point(1, 0), Direction.East)
            ),
            TestData(
                rover = roverAtZeroZeroWest,
                commands = listOf(Command.MoveForward),
                expected = Rover(Point(-1, 0), Direction.West)
            ),
            TestData(
                rover = roverAtZeroZeroNorth,
                commands = listOf(Command.MoveBackward),
                expected = Rover(Point(0, -1), Direction.North)
            ),
            TestData(
                rover = roverAtZeroZeroNorth,
                commands = listOf(Command.MoveBackward, Command.MoveBackward),
                expected = Rover(Point(0, -2), Direction.North)
            ),
            TestData(
                rover = roverAtZeroZeroSouth,
                commands = listOf(Command.MoveBackward),
                expected = Rover(Point(0, 1), Direction.South)
            ),
            TestData(
                rover = roverAtZeroZeroEast,
                commands = listOf(Command.MoveBackward),
                expected = Rover(Point(-1, 0), Direction.East)
            ),
            TestData(
                rover = roverAtZeroZeroWest,
                commands = listOf(Command.MoveBackward),
                expected = Rover(Point(1, 0), Direction.West)
            ),
        ).forEach { (rover, _, commands, expected) ->
            """
             given a Rover at ${rover.point} facing ${rover.direction}
             when $commands
             then ${rover.point} facing ${rover.direction}
            """ {
                kataMarsRover(rover, commands) shouldBe expected
            }
        }
    }

    "Turn the skeleton" - {
        listOf(
            TestData(
                rover = Rover(Point(0, 0), Direction.North),
                commands = listOf(Command.TurnLeft),
                expected = Rover(Point(0, 0), Direction.West)
            ),
        ).forEach { (rover, _, commands, expected) ->
            """
                given facing ${rover.direction} 
                when $commands
                then make the rover face ${expected.direction}
            """ {
                kataMarsRover(rover, commands) shouldBe expected
            }
        }
    }
})