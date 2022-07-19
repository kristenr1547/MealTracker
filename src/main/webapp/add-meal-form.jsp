<%@ page import="java.util.*,controllers.*,model.*,jdbc.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>

    <div class="grid" style="justify: center;">
        <div>
            <h1 class="display-4 .text-center" style="text-align: center;">ENTER MEAL: </h1>
            <br><br>
            <form action="mealServlet" method="GET">
            <input type="hidden" name="command" value="ADD"/>
                <div class="mb-3">
                  <label class="form-label">Meal</label>
                  <input type="text" class="form-control" name="mealName">
                </div>
                <div class="mb-3">
                  <label class="form-label">Meal Type</label>
                  <input type="text" class="form-control" name="mealType">
                </div>
                <div class="mb-3">
                <label class="form-label">Meal Day</label>
                <input type="text" class="form-control" name="mealDay">
              </div>
                <button class="btn button" type="submit"> Save </button>
              </form>
        </div>
      </div>

		<div style="clear: both;"></div>

			<a href="mealServlet">Back to List</a>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>