<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
  <div class="container">
    <div class="card" style="width: 350px; margin-left: auto; margin-right: auto; border: none;">
      <h1 class="display-4">Please Login</h1>
      <form action="/api/checkKey" method="POST">
        <div class="form-group">
          <label for="key">Key</label> 
          <input type="text" id="key" name="key" class="form-control" />
        </div>
        <input type="submit" value="Submit" class="btn btn-primary">
      </form>
    </div>
  </div>
</body>
</html>