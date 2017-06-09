package examples.file

import java.io.File
import scala.io.Source

class ReadFile {

  def printFile(fileName : String) {
       val file = new File(fileName)
       Source.fromFile(file).getLines().foreach(line => println(line))
  } 
}

object ReadFile {
   def main(args:Array[String]) {
    val readFile = new ReadFile
    readFile.printFile("D:/workspace/ScalaTest/src/examples/file/ReadFIle.scala")
  }
}