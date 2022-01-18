import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class KataMarsRoverTest: FreeSpec({
    "it should verify rover init creation" {
        kataMarsRover(
            arrayOf(Command.Forward, Command.Forward)
        ) shouldBe Rover(Point(0, 2), Direction.North)
    }
})