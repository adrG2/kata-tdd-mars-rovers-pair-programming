import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

data class TestData(
    val description: String,
    val commands: List<Command>,
    val expected: Rover
)

class KataMarsRoverTest : FreeSpec({
    "Given a Rover at Position 0,0" - {
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
                description = "decrement Y axis when move Backward facing North",
                commands = listOf(Command.Backward),
                expected = Rover(Point(0, -1), Direction.North)
            )
        ).forEach { (description, commands, expected) ->
            "It should $description" {
                kataMarsRover(commands) shouldBe expected
            }
        }
    }
})