<%@ page import="scaffold.framework.demo.models.*" %>

<%@ page import="scaffold.framework.demo.FormHelper.*" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../../templates/header.jsp">
    <jsp:param name="title" value="Import donnees"/>
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
                            <h5 class="card-title fw-semibold mb-4">Importer les donnees</h5>
                            <form action="/uploaddonnees" method="post" enctype="multipart/form-data">                

                                <div class="mb-3">
                                    <label for="name" class="form-label">Maison et travaux:</label>
                                    <input type="file" id="maisontravaux" name="maisonettravaux" class="form-control" required  />
                                </div>        
                                <div class="mb-3">
                                    <label for="name" class="form-label">devis:</label>
                                    <input type="file" id="devis" name="devis" class="form-control" required  />
                                </div>  
                                <div class="mb-3">
                                    <label for="name" class="form-label">separateur:</label>
                                    <input type="text" id="devis" name="separateur" class="form-control" required  />
                                </div>                                      


                                <button type="submit" class="btn btn-primary">Importer</button>
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

