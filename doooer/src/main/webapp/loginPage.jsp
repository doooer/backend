<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
  <div class="container">
    <div class="card" style="width: 350px; margin-left: auto; margin-right: auto; border: none;">
      <h1 class="display-4">Please Login</h1>
      <form action="/login" method="POST">
      <!--
        <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
        -->
        <div class="form-group">
          <label for="username">Username</label> 
          <input type="text" id="username" name="username" class="form-control" />
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="password" name="password" class="form-control">     
        </div>  
        <input type="submit" value="Login" class="btn btn-primary">
      </form>
    </div>
  </div>
</body>
</html>