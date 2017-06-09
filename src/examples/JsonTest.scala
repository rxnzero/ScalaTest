package examples
import scala.util.parsing.json._
//import org.json4s.jackson.Serialization

object JsonTest {
 
  def main(arg : Array[String]): Unit ={
    val message =   """
                                       { "callid"    : 1           ,
                                         "gatewayid" : "gatewayid-1" ,
                                         "switchid"  : "switch-id"   ,
                                          "content"   :  "hi"
                                          }
"""
   val result = JSON.parseFull(message)

  result match {
    case Some(e) => val res1 = e.asInstanceOf[Map[String,Any]];
                    print(res1.get("callid"))
    case None => println("Failed.")

  }

} 
}