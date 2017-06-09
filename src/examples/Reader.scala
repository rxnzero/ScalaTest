package examples

import java.io._

class Reader(fname:String) {
   private val in = new BufferedReader(new FileReader(fname))  
   @throws[IOException]
   def read() = in.read() 
}