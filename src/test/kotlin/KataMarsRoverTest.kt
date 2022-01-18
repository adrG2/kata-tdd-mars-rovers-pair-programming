import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class KataMarsRoverTest: FreeSpec({
    "it should verify rover init creation" {
        kataMarsRover() shouldBe Rover(Point(0, 0), Direction.North)
    }
})