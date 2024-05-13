<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="scaffold.framework.demo.models.*" %>

<%@ page import="scaffold.framework.demo.FormHelper.*" %>


<html>
<jsp:include page="../../../templates/header.jsp">
    <jsp:param name="title" value=""/>
</jsp:include>

<body>
<div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed">
    <%@ include file="../../../templates/nav.jsp" %>
    <div class="body-wrapper">
        <%@ include file="../../../templates/app-header.jsp" %>
        <div class="container-fluid">
            <div class="container-fluid">
              <div class="card">
                <div class="card-body">
                  <div class="row">
                      <% 
                      Complet_constructionavecprix[] allConstructions =(Complet_constructionavecprix[])  request.getAttribute("constructions");

                      for(Complet_constructionavecprix construction :allConstructions){
                      %>
                        <div class="col-md-4">
                          <h5 class="card-title fw-semibold mb-4"> <%= construction.getConstruction() %> </h5>

                          <div class="card">

                            <img src="../assets/images/Construction-pana(1).svg" class="card-img-top" alt="...">
                            <div class="card-body">
                              <h5 class="card-title"><%= construction.getPrix() %> AR</h5>
                              <p class="card-text"> Nombre en jour de construction : <%= construction.getJourdetravaux() %></p>
                              <form action="/choix/finalisation" method="get">
                                <input type="hidden" name="idconstruction" value="<%= construction.getConstructionid() %>"> 
                                <input type="hidden" name="prix" value="<%= construction.getPrix() %>"> 
                                <input type="hidden" name="construction" value="<%= construction.getConstruction() %>"> 
                                <button class="btn btn-primary">Details</a>
                              </form>
    
                            </div>
                          </div>
                        </div>
                        <% } %>


                  </div>
                </div>
              </div>
            </div>
          </div>
    </div>
    <%@ include file="../../../templates/main-footer.jsp" %>
    <%@ include file="../../../templates/page-footer.jsp" %>
</body>
</html>                

