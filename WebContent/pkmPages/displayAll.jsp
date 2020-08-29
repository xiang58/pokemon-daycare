<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="ISO-8859-1" />
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous" />
  <link rel="stylesheet" href="../styles/style.css" />
  <title>Pokemon Daycare</title>
  <link rel="icon" type="image/png" href="favicon.ico" />
</head>

<body>
  <jsp:include page="../partials/menu.jsp" />
  
  <div class="container">
    <form action="${pageContext.request.contextPath}/Pokemon/List" method="GET">
      Filter By: 
      <select id="category" name="category" onchange="display()">
        <option selected></option>
        <option value="pokedex">Pokedex</option>
        <option value="lv">Pokemon's Level</option>
        <option value="name">Pokemon's Name</option>
        <option value="type1">Pokemon's 1st Type</option>
        <option value="type2">Pokemon's 2nd Type</option>
        <option value="gender">Pokemon's Gender</option>
        <option value="nickname">Pokemon's Nickname</option>
      </select>
      
      <br/><br/>
      
      <div id="input" style="display:none">
        <span id="label"></span>&nbsp;&nbsp;
        <input type="text" id="filter-by" name="filter-by" required />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="Confirm" class="btn btn-danger" />
      </div>
    </form>
    
    <br/><br/><br/>
    
    <table class="table table-striped">
      <thead class="thead-light">
        <tr>
          <th>ID</th> <th>Pokedex</th> <th>Level</th>
          <th>Name</th> <th>1st Type</th> <th>2nd Type</th>
          <th>Gender</th> <th>Nickname</th> <th>Comments</th> <th></th>
        </tr>
      </thead>
      
      <tbody>
        <c:forEach var="pkm" items="${pokemons}">
          <tr>
            <td><c:out value="${pkm.id}" /></td>
            <td><c:out value="${pkm.pokedex}" /></td>
            <td><c:out value="${pkm.lv}" /></td>
            <td><c:out value="${pkm.name}" /></td>
            <td><c:out value="${pkm.type1}" /></td>
            <td><c:out value="${pkm.type2}" /></td>
            <td><c:out value="${pkm.gender}" /></td>
            <td><c:out value="${pkm.nickname}" /></td>
            <td><c:out value="${pkm.comments}" /></td>
            <td>
              <a href="${pageContext.request.contextPath}/Pokemon/List?id=${pkm.id}">edit</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  
  <script>
  	function display() {
  	  const category = document.getElementById('category').value;
  	  const textbox = document.getElementById('input');
  	  const label = document.getElementById('label');
  	  const filterBy = document.getElementById('filter-by');
  	  
  	  if (category === 'pokedex') {
  	  	textbox.style.display = 'block';
  	  	filterBy.type = 'number';
  	  	label.innerHTML = 'Enter a pokedex: ';
  	  }
  	  else if (category === 'lv') {
  	  	textbox.style.display = 'block';
  	  	filterBy.type = 'number';
  	  	label.innerHTML = "Enter the pokemon's level: ";
  	  }
  	  else if (category === 'name') {
  	  	textbox.style.display = 'block';
  	  	label.innerHTML = "Enter the pokemon's name: ";
  	  }
  	  else if (category === 'type1') {
  	  	textbox.style.display = 'block';
  	  	label.innerHTML = "Enter the pokemon's 1st type: ";
  	  }
  	  else if (category === 'type2') {
  	  	textbox.style.display = 'block';
  	  	label.innerHTML = "Enter the pokemon's 2nd type: ";
  	  }
  	  else if (category === 'gender') {
  	  	textbox.style.display = 'block';
  	  	label.innerHTML = "Enter the pokemon's gender: ";
  	  }
  	  else if (category === 'nickname') {
  	  	textbox.style.display = 'block';
  	  	label.innerHTML = "Enter the pokemon's nickname: ";
  	  }
  	  else textbox.style.display = 'none';
  	}
  </script>
</body>
</html>
