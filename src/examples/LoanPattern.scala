package examples

import java.io.BufferedReader
import java.io.IOException
import java.io.FileReader

class LoanPattern {
  
  def isNull(line:String):Boolean = {
   var checkNull = false
   Option(line) match {
      case Some(value) =>
        checkNull = false
      case None =>
        checkNull = true
    }
    checkNull
  }
  
  def withFile(filename:String)(work:String => Unit) {
    var bufferedReader:BufferedReader = null
    try {
      bufferedReader = new BufferedReader(new FileReader(filename))
      var line:String = null
      var done = false
      var count = 0
      
      while (!done) {
        count += 1
        line = bufferedReader.readLine()
        var check:Boolean = isNull(line);
//        println("T - " + check + " : " + line)
        if(check) 
          done = true
        else 
          work(line)
      }
    } catch {
      case ex:IOException => ex.printStackTrace()
    } finally {
      if (bufferedReader != null)
      bufferedReader.close()
    }
  }
}

object LoanPattern extends App {
  val pattern:LoanPattern = new LoanPattern
  
  println(">> Run Method1")
  
  pattern.withFile("D:/workspace/ScalaTest/src/examples/LoanPattern.scala") {
    line => println(line)
  }
  
  println(">> Run other Method.. sleep 1sec")
  
  Thread sleep 1000
  
  // do other job
  pattern.withFile("D:/workspace/ScalaTest/src/examples/LoanPattern.scala") {
    line => println("Sample : " +line)
  }
}