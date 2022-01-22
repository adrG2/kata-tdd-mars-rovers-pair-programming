import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

data class TestData(
    val rover: Rover = Rover(Point(0,0), Direction.North),
    val description: String,
    val commands: List<Command>,
    val expected: Rover
)

class KataMarsRoverTest : FreeSpec({
    "Move the skeleton" - {
        listOf(
            TestData(
                description = "increment Y axis when move Forward facing North",
                commands = listOf(Command.Forward),
                expected = Rover(Point(0, 1), Direction.North)
            ),
            TestData(
                description = "increment Y axis by 2 when move Forward twice facing North",
                commands = listOf(Command.Forward, Command.Forward),
                expected = Rover(Point(0, 2), Direction.North)
            ),
            TestData(
                rover = Rover(Point(0,0), Direction.South),
                description = "decrement Y axis when move Forward facing South",
                commands = listOf(Command.Forward),
                expected = Rover(Point(0, -1), Direction.South)
            ),
            TestData(
                rover = Rover(Point(0,0), Direction.East),
                description = "increment X axis when move Forward facing East",
                commands = listOf(Command.Forward),
                expected = Rover(Point(1, 0), Direction.East)
            ),
            TestData(
                rover = Rover(Point(0,0), Direction.West),
                description = "increment X axis when move Forward facing West",
                commands = listOf(Command.Forward),
                expected = Rover(Point(-1, 0), Direction.West)
            ),
            TestData(
                description = "decrement Y axis when move Backward facing North",
                commands = listOf(Command.Backward),
                expected = Rover(Point(0, -1), Direction.North)
            ),
            TestData(
                description = "decrement Y axis by 2 when move Backward facing North",
                commands = listOf(Command.Backward, Command.Backward),
                expected = Rover(Point(0, -2), Direction.North)
            ),
            TestData(
                rover = Rover(Point(0,0), Direction.South),
                description = "increment Y axis when move Backward facing South",
                commands = listOf(Command.Backward),
                expected = Rover(Point(0, 1), Direction.South)
            ),
            TestData(
                rover = Rover(Point(0,0), Direction.East),
                description = "decrement X axis when move Backward facing East",
                commands = listOf(Command.Backward),
                expected = Rover(Point(-1, 0), Direction.East)
            ),
            TestData(
                rover = Rover(Point(0,0), Direction.West),
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
})