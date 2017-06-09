package examples

import scala.concurrent.duration._
import scala.concurrent.{Future,ExecutionContext,Await}
import ExecutionContext.Implicits.global

object FutureTEst extends App {
  val f1=Future {
    Thread.sleep(10000)
    1 
  }
  
  val f2=Future{
    Thread.sleep(10000)
    2 
   }
  
  val f3=for {
    v1 <- f1
    v2 <- f2
  } yield (v1+v2)
  
  println(Await.result(f3,30.second))

}