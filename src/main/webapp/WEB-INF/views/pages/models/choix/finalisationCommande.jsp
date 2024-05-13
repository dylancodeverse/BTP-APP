<%@ page import="scaffold.framework.demo.models.*" %>

<%@ page import="scaffold.framework.demo.FormHelper.*" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../../templates/header.jsp">
    <jsp:param name="title" value="Add promotion"/>
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

                            <% 
                                Typefinition [] typefinitions = (Typefinition []) request.getAttribute("listefinition");
                                Double prix = (Double) request.getAttribute("prix");
                                String construction = (String) request.getAttribute("construction");
                                String id = (String) request.getAttribute("idconstruction") ;
                                %>
                                <form action="/choix/finalisation" method="post">
                                    <div class="row">
                                        <label for=""> Date debut de la construction</label>
                                        <input type="date" name="datedebutravaux" id="" class="form-control" placeholder="" style="margin-bottom: 50px;">
                                <%    
                                for(Typefinition typefinition : typefinitions ){ %>
                                                
                                            <div class="col-md-4">
                                                <h5 class="card-title fw-semibold mb-4"> Pour <%= typefinition.getTypefinition() %>  </h5>
                                                  <h5>ce sera  <%= typefinition.getNewPrixSansSurCent(prix) %> AR</h5>  
                                                <div class="card">
                    
                                                <img src="../assets/images/Construction-pana(1).svg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title"> Elevation de <%= typefinition.getElevation() %></h5>
                                                        Choisir :
                                                    <input type="radio" id="sports" name="typefinition" value="<%=typefinition.getId()%>">

                                                    <button class="btn btn-primary">Valider</a>
                        
                                                </div>
                                                </div>
                                            </div>
                                                                            
                                <% } %>  
                                <input type="hidden"  name="idconstruction" value="<%=id%>">

                            </div>
                            </form>

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

