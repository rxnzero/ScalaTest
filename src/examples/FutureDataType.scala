package examples

object FuturesDataType extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source

  val myFuture: Future[String] = Future {
    val f = Source.fromFile("D:/workspace/ScalaTest/src/examples/FutureDataType.scala")
    try f.getLines.mkString("\n") finally f.close()
  }

  println(s"started reading build file asynchronously")
  println(s"status: ${myFuture.isCompleted}")
  Thread.sleep(250)
  println(s"status: ${myFuture.isCompleted}")
  println(s"status: ${myFuture.value}")

}