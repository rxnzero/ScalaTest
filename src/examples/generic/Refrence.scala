package examples.generic

class Refrence[T] {
  private var contents : T = _
  def set(value:T) { contents = value }
  def get:T = contents
}

object IntegerRefrence {
  def main(args:Array[String]) {
    val cell = new Refrence[Int]
    cell.set(1)
    println("Refrence value is " + cell.get)
  }
}