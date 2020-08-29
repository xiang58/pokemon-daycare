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
  <jsp:include page="../partials/menu.jsp" />

  <div class="container">
    <form name="edit" action="${pageContext.request.contextPath}/Pokemon" method="POST">
      Edit pokedex:
      <input type="number" id="pokedex" name="pokedex" min="1" max="892" required />
      <br><br>
    
      Edit Pokemon's name:
      <input type="text" id="name" name="name" required>
      <br><br>
      
      Edit the pokemon's level:
      <input type="number" id=lv name="lv" min="1" max="100" required />
      <br><br>
      
      Edit Pokemon's 1st type:
      <select id="type1" name="type1" required>
        <option selected></option>
        <option>Normal</option>
        <option>Fire</option>
        <option>Water</option>
        <option>Grass</option>
        <option>Electric</option>
        <option>Ice</option>
        <option>Fight</option>
        <option>Poison</option>
        <option>Ground</option>
        <option>Flying</option>
        <option>Psychic</option>
        <option>Bug</option>
        <option>Rock</option>
        <option>Ghost</option>
        <option>Gragon</option>
        <option>Steel</option>
        <option>Dark</option>
        <option>Fairy</option>
      </select>
      <br><br>
      
      Edit Pokemon's 2nd type:
      <select id="type2" name="type2">
        <option selected></option>
        <option>Normal</option>
        <option>Fire</option>
        <option>Water</option>
        <option>Grass</option>
        <option>Electric</option>
        <option>Ice</option>
        <option>Fight</option>
        <option>Poison</option>
        <option>Ground</option>
        <option>Flying</option>
        <option>Psychic</option>
        <option>Bug</option>
        <option>Rock</option>
        <option>Ghost</option>
        <option>Gragon</option>
        <option>Steel</option>
        <option>Dark</option>
        <option>Fairy</option>
      </select>
      <br><br>
      
      Edit Pokemon's gender:
      <input type="radio" name="gender" value="M" required>
      <label for="gender">Male</label>
      <input type="radio" name="gender" value="F">
      <label for="gender">Female</label>
      <input type="radio" name="gender" value="?">
      <label for="gender">Unknown</label>
      <br><br>
      
      Edit Pokemon's nickname:
      <input type="text" id="nickname" name="nickname">
      <br><br>
      
      Edit comments:<br/>
      <textarea id="comments" name="comments" rows="4" cols="50"></textarea>
      
      <input type="hidden" name="pkm-id" value="${pkm.id}" /><br/><br/>
      <input type="hidden" name="action" value="update" />
      <input type="submit" value="Submit" class="btn btn-danger" />
      <br/><br/>
    </form>
  </div>
</body>
</html>
