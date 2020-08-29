<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

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
  <nav class="navbar navbar-expand-sm navbar-dark bg-danger">
    <a class="navbar-brand" href="../index.jsp">
      <img id="logo" src="${pageContext.request.contextPath}/partials/logo.png" 
           alt="logo" class="rounded-circle" />
    </a>
  
    <div class="collapse navbar-collapse" id="collapsible">
      <ul class="navbar-nav nav-tabs text-center">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/pkmPages/insert.jsp">
            Add New Pokemon
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/Pokemon/List">
            Display Pokemons
          </a>
        </li>
      </ul>  
    </div>  
  </nav>
  <br/><br/>
</body>
</html>
