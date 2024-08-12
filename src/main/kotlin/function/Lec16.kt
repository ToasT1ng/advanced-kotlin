package function

fun add(a: Int, b: Int) = a + b

fun main() {

  val add1 = { a: Int, b: Int -> a + b }

  val add2 = fun (a: Int, b: Int) = a + b

  val add3 = ::add

  val personConstructor = ::Person
  val personNameGetter = Person::name.getter
  // Callable Reference => Java 와 Kotlin 방식 차이 존재함

  KStringFilter { it.startsWith("A") }  // SAM (=Single Abstract Method) 생성자
  consumeFilter({ it.startsWith("A") }) // fun1 vs. fun2 => 더 구체화된 함수로 해석됨
  consumeFilter(Filter<String> { it.startsWith("A") }) // fun2로 해석됨
}

// fun1
fun consumeFilter(filter: StringFilter) { }

// fun2
fun <T> consumeFilter(filter: Filter<T>) {}

fun interface KStringFilter {
  fun predicate(str: String): Boolean
}


class Person(
  val name: String,
  val age: Int
)
