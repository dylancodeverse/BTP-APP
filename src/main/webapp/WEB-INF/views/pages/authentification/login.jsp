<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../templates/header.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>
<body>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                <a href="./index.html" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="../assets/images/Construction-pana(1).svg" width="180" alt="">
                </a>
                <p class="text-center">Your Social Campaigns</p>
                <form method="post" action="/login">

                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Numero de telephone</label>
                    <input  class="form-control" name="numero" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>

                  <button type ="submit" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">Connecter</a>
                  
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="../../templates/main-footer.jsp" %>
  <%@ include file="../../templates/page-footer.jsp" %>

  </body>

</html>