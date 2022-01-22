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
                description = "increment Y axis when move Forward facing North",
                commands = listOf(Command.Forward),
                expected = Rover(Point(0, 1), Direction.North)
            ),
            TestData(
                rover = roverAtZeroZeroNorth,
                description = "increment Y axis by 2 when move Forward twice facing North",
                commands = listOf(Command.Forward, Command.Forward),
                expected = Rover(Point(0, 2), Direction.North)
            ),
            TestData(
                rover = roverAtZeroZeroSouth,
                description = "decrement Y axis when move Forward facing South",
                commands = listOf(Command.Forward),
                expected = Rover(Point(0, -1), Direction.South)
            ),
            TestData(
                rover = roverAtZeroZeroEast,
                description = "increment X axis when move Forward facing East",
                commands = listOf(Command.Forward),
                expected = Rover(Point(1, 0), Direction.East)
            ),
            TestData(
                rover = roverAtZeroZeroWest,
                description = "increment X axis when move Forward facing West",
                commands = listOf(Command.Forward),
                expected = Rover(Point(-1, 0), Direction.West)
            ),
            TestData(
                rover = roverAtZeroZeroNorth,
                description = "decrement Y axis when move Backward facing North",
                commands = listOf(Command.Backward),
                expected = Rover(Point(0, -1), Direction.North)
            ),
            TestData(
                rover = roverAtZeroZeroNorth,
                description = "decrement Y axis by 2 when move Backward facing North",
                commands = listOf(Command.Backward, Command.Backward),
                expected = Rover(Point(0, -2), Direction.North)
            ),
            TestData(
                rover = roverAtZeroZeroSouth,
                description = "increment Y axis when move Backward facing South",
                commands = listOf(Command.Backward),
                expected = Rover(Point(0, 1), Direction.South)
            ),
            TestData(
                rover = roverAtZeroZeroEast,
                description = "decrement X axis when move Backward facing East",
                commands = listOf(Command.Backward),
                expected = Rover(Point(-1, 0), Direction.East)
            ),
            TestData(
                rover = roverAtZeroZeroWest,
                description = "increment X axis when move Backward facing West",
                commands = listOf(Command.Backward),
                expected = Rover(Point(1, 0), Direction.West)
            ),
        ).forEach { (rover, description, commands, expected) ->
            "at Position ${rover.point} should $description" {
                kataMarsRover(rover, commands) shouldBe expected
            }
        }
    }

    "Turn the skeleton" - {
        listOf(
            TestData(
                rover = Rover(Point(0, 0), Direction.North),
                commands = listOf(Command.Left),
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