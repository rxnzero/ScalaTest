package examples

import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._
import com.sun.xml.internal.bind.v2.schemagen.Form
import java.text.SimpleDateFormat

object TimerCallBack extends App {

  def timerCallback(callback: () => Unit) {
    while(true) {
      callback()
      Thread sleep 1000
    }
  }
  
  override def main(args:Array[String]) {
    timerCallback(() => {
      val now = new Date
      val df =  new SimpleDateFormat("YYYY-MM-dd HH:mm:ss", Locale.KOREA);
      println("[" + (df format now) + "] current time")
    }
    )
    
  }
}