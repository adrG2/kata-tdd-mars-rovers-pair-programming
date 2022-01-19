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
            )
        ).forEach { (description, commands, expected) ->
            "It should $description" {
                kataMarsRover(commands) shouldBe expected
            }
        }
    }
})