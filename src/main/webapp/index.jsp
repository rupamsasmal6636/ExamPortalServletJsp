<html>

<head>
    <%@ include file="resources/styles.jsp" %>
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.min.css" rel="stylesheet" />
</head>

<body class="body">
    <%@ include file="views/shared/navbar.jsp" %>
        <!-- body -->
        <div class="position-relative h-75 ">
            <div class="bg_img h-100 w-100 d-flex flex-column align-items-center justify-content-center gap-2  ">
                <div class="text_quote">All you need in your</div>
                <div class="text_quote h1 text-warning ">EXAM TOOLBOX</div>
                <a class="text-white" href="<%=contextPath%>/loginController?action=login">
                    <Button class="btn btn-outline-warning rounded-pill border-1 ">Start Now</Button>
                </a>
            </div>
        </div>

        <!--About Sections+footer-->
        <section class="mt-lg-5 h-100 w-100">
            <div class="container-fluid">
                <div class="h1 text-center text-white ">About Portal</div>
                <%-- About Portal --%>
                    <div class="row ">
                        <div class="col-sm-3  col-lg-3  mb-3 inner_card_rotate">
                            <div class="h-100 card ">
                                <img src="./resources/images/createExam.jpeg" class="card-img-top" alt="John Doe">
                                <div class="card-body">
                                    <h5 class="card-title">Create Exam: </h5>
                                    <p class="card-text">Begin your journey of knowledge creation.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3  col-lg-3  mb-3 inner_card_rotate ">
                            <div class="h-100 card card ">
                                <img src="./resources/images/asignExam.jpeg" class="card-img-top" alt="Jane Smith">
                                <div class="card-body">
                                    <h5 class="card-title">Assign Exam:</h5>
                                    <p class="card-text">Empower learners with the opportunity to embark on their
                                        educational
                                        quests.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3  col-lg-3  mb-3 inner_card_rotate ">
                            <div class="h-100 card card ">
                                <img src="./resources/images/attemptTest.jpeg" class="card-img-top"
                                    alt="Michael Johnson">
                                <div class="card-body">
                                    <h5 class="card-title">Attempt Test:</h5>
                                    <p class="card-text">Illuminate your path to success with the brilliance of your
                                        knowledge.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3  col-lg-3  mb-3 inner_card_rotate ">
                            <div class="h-100 card card ">
                                <img src="./resources/images/getResult.jpeg" class="card-img-top" alt="Sarah Williams">
                                <div class="card-body">
                                    <h5 class="card-title">Get Result: </h5>
                                    <p class="card-text">Unlock the gateway to your achievements and discoveries.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Contact Us -->
                    <div class="row mt-5">
                        <div class="h1 text-center text-white ">About Portal</div>
                        <div class="col-md-4 mb-2 col-lg-4 card_glow">
                            <div class="h-100 card">
                                <div class="card-body text-center">
                                    <i class="fa-solid fa-headset"></i>
                                    <h5 class="card-title">Support Team</h5>
                                    <div class="d-flex flex-column justify-content-start align-items-lg-start">
                                        <div class="d-flex align-items-center justify-content-start gap-2 "><i
                                                class="far fa-envelope"></i><span>support@examportal.com</span></div>
                                        <div class="d-flex align-items-center justify-content-start gap-2 "><i
                                                class="fas fa-phone"></i> +1 (800) 123-4567</div>
                                        <div class="d-flex align-items-center justify-content-start gap-2 "><i
                                                class="fas fa-clock"></i> Availability: 24/7</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4 mb-2 col-lg-4 card_glow">
                            <div class="h-100 card">
                                <div class="card-body text-center">
                                    <i class="fa-solid fa-phone-volume"></i>
                                    <h5 class="card-title">Sales Inquiries</h5>
                                    <div class="d-flex flex-column justify-content-start align-items-lg-start">
                                        <div class="d-flex align-items-center justify-content-start gap-2 "><i
                                                class="far fa-envelope"></i>&nbsp;sales@examportal.com</div>
                                        <div class="d-flex align-items-center justify-content-start gap-2 "><i
                                                class="fas fa-phone"></i>&nbsp; +1 (800) 555-1234</div>
                                        <div class="d-flex align-items-center justify-content-start gap-2 "><i
                                                class="fas fa-clock"></i>&nbsp; Monday - Friday, 8:00 AM - 5:00 PM (GMT)
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 mb-2 col-lg-4 card_glow">
                            <div class="h-100 card">
                                <div class="card-body text-center">

                                    <i class="fa-solid fa-comment-dots"></i>&nbsp;
                                    <h5 class="card-title">Feedback Team</h5>
                                    <div class="d-flex flex-column justify-content-start align-items-lg-start  gap-2">
                                        <div class="d-flex align-items-center justify-content-start  "><i
                                                class="far fa-envelope"></i>&nbsp; &nbsp; feedback@examportal.com</div>
                                        <div class="d-flex align-items-center justify-content-start  "><i
                                                class="fas fa-phone"></i>&nbsp; &nbsp; +1 (800) 789-0123</div>
                                        <div class="d-flex align-items-center justify-content-start  "><i
                                                class="fas fa-clock"></i>&nbsp; &nbsp; Online Form Submission 24/7
                                            Available</div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="footer card-footer position-relative w-100 ">
                <%@ include file="views/shared/footer.jsp" %>
            </div>


        </section>


        <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.umd.min.js"></script>


</body>

</html>