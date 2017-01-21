package views;

import utils.IO;

public class ErrorReportView {
	private IO io;
	
	public ErrorReportView(){
		io=new IO();
	}
	
	public void specificError(String error){
		io.writeln(error);
	}
	
	public void generalError(){
		io.writeln("ERROR: Movimiento no permitido.");
	}
	
}
