package examples

import scala.collection._
import scala.util.parsing.json._

object Colours extends Enumeration {
  val Red, Amber, Green = Value
}

object WeekDays extends Enumeration {
  val Mon,Tue,Wed,Thu,Fri = Value
}

object Functions {
  def f(x: Colours.Value)  = println("That's a colour")
//  def f(x: WeekDays.Value) = println("That's a weekday")
}

object test {

  import  Colours._

  def main(arg : Array[String]): Unit ={
    Functions.f(Red)
  }

}