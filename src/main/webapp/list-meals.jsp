<%@ page import="java.util.*,controllers.*,model.*,jdbc.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="header.jsp"/>
        <div class="container">
      <div class="row">
      <div class="col-12">
        <h1 class="display-4">Planned Meals </h1>
                	<br><br>
                	
  <table class="table table-hover">
  <tbody>

				<c:forEach var="tempMeal" items="${MEAL_LIST}">
				
			
				<c:url var="tempLink" value="mealServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name ="mealID" value = "${tempMeal.mealID}"/>
				</c:url>
				
				<c:url var="deleteLink" value="mealServlet">
				<c:param name="command" value="DELETE"/>
				<c:param name ="mealID" value = "${tempMeal.mealID}"/>
				</c:url>
				
				 <tr>
				<td>${tempMeal.mealName}</td>
				<td><a href="${tempLink}">Edit</a></td>
				<td><a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this meal?'))) return false">Delete</a></td>
				</tr>
				</c:forEach>

  </tbody>
</table>   	
            





         <input type="button" class="btn button" value="Add Meal"
         onclick="window.location.href='add-meal-form.jsp'; return false;"
         />
      </div>
    </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>