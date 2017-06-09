//import scala.tools.nsc.*;
import javax.script.*;
		
public class ScalaInterpreter {

//	public static void runScript() {
//		Interpreter n = new Interpreter(new Settings());
//		n.bind("label", "Int", new Integer(4));
//		n.interpret("println(2+label)");
//		// didn't event try to check success or error
//		n.close();
//	}
	
	
	public static void runScript() {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("scala");
		engine.getContext().setAttribute("label", new Integer(4), ScriptContext.ENGINE_SCOPE);
		
		try {
		    engine.eval("println(2+label)");
		} catch (ScriptException ex) {
		    ex.printStackTrace();
		}
	}
	
	public static void main(String[] argv) {
			runScript();
	}
}
