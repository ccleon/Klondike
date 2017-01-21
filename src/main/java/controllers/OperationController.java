package controllers;

import models.Game;
import views.ErrorReportView;

public abstract class OperationController extends Controller{
	
	ErrorReportView errorReport;
	
	protected OperationController(Game game){
		super(game);
		errorReport = new ErrorReportView();
	}
	
	public abstract void accept (OperationControllerVisitor operationControllerVisitor);
	
}
