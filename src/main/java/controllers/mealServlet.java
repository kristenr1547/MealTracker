package controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jdbc.mealDbUtil;
import model.Meal;


@WebServlet("/mealServlet")
public class mealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private mealDbUtil dbUtil;
	
	@Resource(name = "jdbc/shopping_list")
	private DataSource datasource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			dbUtil = new mealDbUtil(datasource);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}






	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//read command parameter
			String theCommand = request.getParameter("command");
			//route to code 
			if(theCommand == null) {
				theCommand = "LIST";
			}
			switch(theCommand) {
			case "LIST":
				listMeals(request,response);
				break;
			case "ADD":
				addMeal(request,response);
				break;
			case "LOAD":
				loadMeal(request,response);
				break;
			case "UPDATE":
				updateMeal(request,response);
				break;
			case "DELETE":
				deleteMeal(request,response);
				break;
			default:
				listMeals(request,response);
			}
	}catch(Exception e) {
		e.printStackTrace();
		throw new ServletException(e);
	}
	}


	private void deleteMeal(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//read student info
		int id = Integer.parseInt(request.getParameter("mealID"));
		String name = request.getParameter("mealName");
		String type = request.getParameter("mealType");
		String day = request.getParameter("mealDay");
		//create new meal object
		Meal meal = new Meal(id,name,type,day);
		//add student to the database
		dbUtil.deleteMeal(meal);
		//send back to the main page
		listMeals(request,response);
		
	}


	private void updateMeal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read student info
		int id = Integer.parseInt(request.getParameter("mealID"));
		String name = request.getParameter("mealName");
		String type = request.getParameter("mealType");
		String day = request.getParameter("mealDay");
		//create new meal object
		Meal meal = new Meal(id,name,type,day);
		//add student to the database
		dbUtil.updateMeal(meal);
		//send back to the main page
		listMeals(request,response);
		
	}


	private void loadMeal(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//get id
		int mealID = Integer.valueOf(request.getParameter("mealID"));
		//get meal from database
		Meal updateMeal = dbUtil.getMeal(mealID);
		//place student in request attribute
		if(updateMeal != null) {
			request.setAttribute("THE_MEAL", updateMeal);
		}
		//sent to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/meal-edit-form.jsp");
		dispatcher.forward(request,response);
	}


	private void addMeal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read student info
		String name = request.getParameter("mealName");
		String type = request.getParameter("mealType");
		String day = request.getParameter("mealDay");
		//create new meal object
		Meal meal = new Meal(name,type,day);
		//add student to the database
		dbUtil.addMeal(meal);
		//send back to the main page
		listMeals(request,response);
		
	}


	private void listMeals(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get meals from db util
		List<Meal> meals = dbUtil.getMeals();
		//add meals to request
		request.setAttribute("MEAL_LIST", meals);
		//send to jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-meals.jsp");
		dispatcher.forward(request,response);
	}

}
