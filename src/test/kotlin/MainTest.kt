import com.github.wpanas.turboStripLowercaseAccents
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.apache.commons.lang3.StringUtils.stripAccents
import java.lang.Character.MAX_CODE_POINT
import java.lang.Character.MIN_CODE_POINT

class MainTest : StringSpec({
    "should run" {
        turboStripLowercaseAccents("ąć") shouldBe "ac"
    }

    "should be good for all from" {
        assertSoftly {
            IntRange(MIN_CODE_POINT, MAX_CODE_POINT)
                .filter { Character.isLowerCase(it) }
                .map { Character.toString(it) }
                .forEach { input ->
                    val turboStrippedString = turboStripLowercaseAccents(input)
                    val casuallyStrippedString = stripAccents(input)
                    withClue("\"$input\" to \"$casuallyStrippedString\",") {
                        turboStrippedString shouldBe casuallyStrippedString
                    }
                }
        }
    }

    "should not strip accents for uppercase characters" {
        turboStripLowercaseAccents("Ś") shouldBe "Ś"
    }
})