import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import scala.tools.nsc.interpreter.IMain;
import scala.tools.nsc.settings.MutableSettings.BooleanSetting;


public class EvalTest {
	public static void main(String[] args) {
		try {
			ScriptEngineManager m = new ScriptEngineManager();
			ScriptEngine engine = m.getEngineByName("scala");
			
			// java run option : -Dscala.usejavacp=true 
//			((BooleanSetting)(((IMain)engine).settings().usejavacp())).value_$eq(true);

			if(engine!=null) {
				System.out.println("> Engine start");
//				engine.eval("object HelloWorld {def main(args: Array[String]) { println(\"Hello, world!\") }}");
				Object o = engine.eval("println(\"Hello SCALA\"); 1 + 1"); // 
				System.out.println("return object is " + o.toString());				
			}	
			else 
				System.out.println("> Engine is NULL");
	    } catch (ScriptException se) {
	    	System.out.println("> Error : " + se.toString());
			se.printStackTrace();
	    }
		catch (Exception e) {
	        System.out.println("> Error : " + e.toString());
			e.printStackTrace();
	    }
		System.out.println("End.");
	}

}
