package function

class Lec15 {
}

fun main() {
  iterate(listOf(1, 2, 3, 4, 5)) { num ->
    if (num == 3) {
      // return // crossinline을 쓰면 사용을 할 수 없다.
    }
    println(num)
  }
}

inline fun iterate(numbers: List<Int>, crossinline exec: (Int) -> Unit) {
  for (num in numbers) {
    exec(num)
  }
}

inline fun repeat(
  times: Int,
  noinline exec: () -> Unit, // noinline 지시어를 붙였다!
) {
  for (i in 1..times) {
    exec()
  }
}

// 고차함수의 성능 개선 시 inline 함수를 활용할 수 있다..
// inline 함수의 단점은 없을까?

// 함수 본문이 큰 경우 inline으로 생성되는 코드 양이 많아져 APP 사이즈가 커질 수 있다.
// 즉, 코드 중복이 발생될 수 있음에 유의해야한다.
// ( 예를 들어, B 함수에서 A inline 함수를 2번 호출한다면, 어쩔 수 없이 코드 중복이 발생하게 된다. )
// 자주 쓰는 함수 중에 .forEach{ } 가 있는데 이것도 inline 함수이다.
