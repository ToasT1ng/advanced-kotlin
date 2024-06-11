package generic

fun main() {
  val cage: Cage2<out Fish> = Cage2<GoldFish>()
}

class Cage2<T : Any> {  //<T : Any> 와 같이 사용하면 Cage2<GoldFish?>() 같은 사용을 비허용한다. 즉 Null이 비허용된다.
  private val animals: MutableList<T> = mutableListOf()

  fun getFirst(): T {
    return animals.first()
  }

  fun put(animal: T) {
    this.animals.add(animal)
  }

  fun moveFrom(otherCage: Cage2<out T>) {
    this.animals.addAll(otherCage.animals)
  }

  fun moveTo(otherCage: Cage2<in T>) {
    otherCage.animals.addAll(this.animals)
  }
}
