<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Font Awesome -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
      rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
      rel="stylesheet"
    />
    <!-- MDB -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.min.css"
      rel="stylesheet"
    />
    <title>Login</title>

</head>
<body>
    <section class="h-100">
      <div class="container vh-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-lg-12 col-xl-11">
            <div class="card text-black" style ="box-shadow: none !important;"> <!-- Added custom class 'no-shadow-card' -->
              <div class="card-body vh-100 p-md-4">
                <div class="row justify-content-center">
                  <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                    <form class="mx-1 mx-md-4" action='<%=request.getContextPath()%>/signup' method = "post">

                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                          <input name = "name" type="text" id="form3Example1c" class="form-control" required />
                          <label class="form-label" for="form3Example1c">Your Name</label>
                        </div>
                      </div>

                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                          <input name = "username" type="email" id="form3Example3c" class="form-control" required/>
                          <label class="form-label" for="form3Example3c">Your Email</label>
                        </div>
                      </div>

                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                          <input name = "password" type="password" id="form3Example4c" class="form-control" required />
                          <label class="form-label" for="form3Example4c">Password</label>
                        </div>
                      </div>

                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                          <input name = "confirmPassword" type="password" id="form3Example4cd" class="form-control" required />
                          <label class="form-label" for="form3Example4cd">Repeat your password</label>
                        </div>
                      </div>
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-user-tag fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <select name = "role" class="form-select" id="role" required>
                            <option selected disabled>Select your role</option>
                            <option value="TEACHER">Teacher</option>
                            <option value="STUDENT" default selected>Student</option>
                          </select>
                        </div>
                      </div>
                      <!-- End of Role dropdown -->

                      <div class="form-check d-flex justify-content-center mb-5">
                        <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" required />
                        <label class="form-check-label" for="form2Example3">
                          * I agree all statements in <a href="#!">Terms of service</a>
                        </label>
                      </div>

                      <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4 gap-4">
                        <button type="submit" class="btn btn-primary btn-lg">Register</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0 text-nowrap">Already have an account? <a href="<%=request.getContextPath()%>/loginController?action=login"
                                                                                      class="link-danger">Login</a></p>
                      </div>

                    </form>
                  </div>
                  <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                      class="img-fluid" alt="Sample image">

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- MDB -->
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.umd.min.js">
    </script>
</body>
</html>
