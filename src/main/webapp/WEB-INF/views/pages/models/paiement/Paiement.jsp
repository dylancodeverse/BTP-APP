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
                            <h5 class="card-title fw-semibold mb-4">Payer</h5>
                            <form action="/paiement/paiement" method="post">                

                                <div class="mb-3">
                                    <label for="name" class="form-label">Date de paiement:</label>
                                    <input type="date" id="Name" name="datedepaiement" class="form-control" required  />
                                </div>        
                                <div class="mb-3">
                                    <label for="name" class="form-label">Montant:</label>
                                    <input type="number" id="Year" name="montant" class="form-control" required  />
                                </div>        
                                <div class="mb-3">
                                    <label for="name" class="form-label">Devis:</label>
                                    <select name="commande" class="form-control" id="">
                                        <option value="">Choisir</option>
                                        <% 
                                        Commande[] cmds = (Commande[]) request.getAttribute("mescommandes") ; 
                                        for(Commande cmd : cmds ){ %>
                                            <option value="<%=cmd.getId() %>"> <%= cmd.getLabel() %> </option>
                                        <%    
                                        }
                                        %>
                                    </select>
                                </div>                                        


                                <button type="submit" class="btn btn-primary">Payer</button>
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

