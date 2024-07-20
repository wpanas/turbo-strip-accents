# Turbo Strip Accents

An alternative implementation for [StringUtils.stripAccents]
from `org.apache.commons:commons-lang3`. It suppose to be faster
than the original, but it only works for **lowercase** characters.

## How to use it?

```kotlin
turboStripLowercaseAccents("ąćśę") shouldBe "acse"
```


[StringUtils.stripAccents]: https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html#stripAccents(java.lang.String)