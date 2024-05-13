<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="scaffold.framework.demo.models.*" %>

<%@ page import="scaffold.framework.demo.FormHelper.*" %>



<html>
<jsp:include page="../../../templates/header.jsp">
    <jsp:param name="title" value="Promotion list"/>
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
                        <h5 class="card-title fw-semibold mb-4">Mes devis</h5>
                        <div class="card w-100">
                            <div class="card-body p-4">
                                    <div class="table-responsive">
                                        <table class="table text-nowrap mb-0 align-middle">
                                            <thead class="text-dark fs-4">
                                                <tr>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Client</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Construction</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Type de finition</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Montant total</h6>
                                                    </th>
                                                    
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Commande</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Debut construction</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Fin construction</h6>
                                                    </th>

                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Actions</h6>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% V_devistotalavecelevationdejasurcentcomplet[] mesvdevis = (V_devistotalavecelevationdejasurcentcomplet[]) request.getAttribute("devis");
                                                for (V_devistotalavecelevationdejasurcentcomplet mondevis : mesvdevis) {
                                                     %>
                                                    <tr>

                                                <td class="border-bottom-0"><h6 class="fw-semibold mb-0"><%=  mondevis.getClient() %></h6></td>
                                                <td class="border-bottom-0"><h6 class="fw-semibold mb-0"><%=  mondevis.getConstructionlabel() %></h6></td>

                                                <td class="border-bottom-0"><%= mondevis.getTypefinitionlabel() %></td>
                                                <td class="border-bottom-0"><%= mondevis.getMontanttotal() %></td>
                                                <td class="border-bottom-0"><%= mondevis.getDatedecommande() %></td>
                                                <td class="border-bottom-0"><%= mondevis.getDatedebutconstruction() %></td>
                                                <td class="border-bottom-0"><%= mondevis.getDatefinconstruction() %></td>
                                                <td>

                                                    <a href="/admin/detaildevis/<%=mondevis.getId() %>">Voir detail</a>
                                                </td>
                                                    </tr>
                                                <% } %>                   
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <a href="/promotions/add">Add New Promotion</a>
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

