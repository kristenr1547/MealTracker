<%@ page import="java.util.*,controllers.*,model.*,jdbc.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Grocery List</title>
   
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="shopping.css" rel="stylesheet">
</head>

  <body>
    <nav class="navbar navbar-custom navbar-expand-lg navbar-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Meal Prep Tracker</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Items</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Meals</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Cost</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <br><br>
        <div class="container">
      <div class="row">
      <div class="col-12">
        <h1 class="display-4">Planned Meals </h1>
                	<br><br>
    		 <div class="list-group">
				<c:forEach var="tempMeal" items="${MEAL_LIST}">
				<c:url var="tempLink" value="mealServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name ="mealID" value = "${tempMeal.mealID}"/>
				</c:url>
						<a href="${tempLink}" class="list-group-item list-group-item-action"> ${tempMeal.mealName}
						</a>
				</c:forEach>
        	</div>
        	<br><br>
         <input type="button" class="btn button" value="Add Meal"
         onclick="window.location.href='add-meal-form.jsp'; return false;"
         />
      </div>
    </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>