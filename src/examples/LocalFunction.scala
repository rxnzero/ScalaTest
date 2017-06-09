package examples

import scala.io.Source

object LocalFunction {
  
  def processFile(filename : String, width : Int ) {
    
    // 외부함수의 인자를 참조할 수 있음
   def processLine(line: String)  {
      if (line.length > width)
      println(filename + ": " + line.trim)
    }
   
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine( line)
  }

    def main(arg : Array[String]): Unit ={
      LocalFunction.processFile("D:/workspace/ScalaTest/src/examples/LocalFunction.scala", 10);

    }
}