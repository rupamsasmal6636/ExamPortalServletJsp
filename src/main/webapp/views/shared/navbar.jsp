<%
    String contextPath = request.getContextPath();
%>
<div class="w-100">
        <nav class="navbar navbar-expand-md nav nav_decoration p-2">
            <div class="d-flex align-items-center justify-content-between w-100 ">
                <a class="navbar_brand" href="<%=contextPath%>/index.jsp">Exam Portal</a>
                <div class="row-cols-1 ">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="<%=contextPath%>/loginController?action=login"><Button class="btn btn-outline-primary rounded-pill">Sign In</Button></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="<%=contextPath%>/loginController?action=register"><Button class="btn btn-outline-secondary  rounded-pill">Sign Up</Button></a>
                            </li>
                        </ul>

                    </div>
                </div>
            </div>
        </nav>
    </div>