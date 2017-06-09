package examples;

import examples.Reader;

class CallTest  {
   public static void main(String[] args) {
        try {        	
        	String fileName = null;        	
        	if(fileName == null) fileName = "D:/workspace/ScalaTest/.project";
        	
        	System.out.println("Read file name : " + fileName);
            Reader in = new Reader(fileName);
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            System.out.println("Error : " +e.getMessage());
            e.printStackTrace();
        }
    }
}