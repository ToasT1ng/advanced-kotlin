package function


class Lec14 {
}

fun main() {
  var num = 5
  num += 1
  val plusOne: () -> Unit = { num += 1 }
}


// 고차함수 1 : 파라미터로 함수를 받는 경우
fun compute(num1: Int, num2: Int, op: (Int, Int) -> Int): Int {
  return op(num1, num2)
}

// 고차함수 2 : 반환타입이 함수인 경우
fun opGenerator(): (Int, Int) -> Int {
  return { a, b -> a + b }
}
