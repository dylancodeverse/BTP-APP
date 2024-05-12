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
                        <h5 class="card-title fw-semibold mb-4">All Promotion</h5>
                        <div class="card w-100">
                            
                            <div class="card-body p-4">
                                <div style="margin-bottom:30px;">
                                    <nav aria-label="Page navigation example">
                                        <form action="/utilisateur/list" class="pagination m-0" method="get">
                                            <input type="number" name="pageNumber" class="page-link" placeholder="Numero de page" style="color: black;"
                                                value="<%= ValidationHelper.sysout(request.getAttribute("pageNumber"))%>"
                                            
                                            >
                                            <input type="number" name="elementParPage" class="page-link" placeholder="Nombre d'elements" style="color: black;"
                                            value="<%= ValidationHelper.sysout(request.getAttribute("elementParPage"))%>"
                                            
                                            >                                                    

                                            <input type="text" name="filtre" class="page-link" placeholder="eg: nom asc Sex desc">

                                            <input type="submit" class="btn btn-primary" value="Allez vers">
                                            
                                        </form>
                                        <p style="color: red;"> <%= ValidationHelper.sysout(request.getAttribute("error"))%></p>

                                    </nav>
                                </div>                                                

                                    <div class="table-responsive">
                                        <table class="table text-nowrap mb-0 align-middle">
                                            <thead class="text-dark fs-4">
                                                <tr>

                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Id</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Nom</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Sexe</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Description</h6>
                                                    </th>
                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Departement</h6>
                                                    </th>

                                                    <th class="border-bottom-0">
                                                        <h6 class="fw-semibold mb-0">Actions</h6>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% UtilisateurComplet[] utilisateurs = (UtilisateurComplet[]) request.getAttribute("list");
                                                for (UtilisateurComplet utilisateur : utilisateurs) { %>
                                                    <tr>

                                                        <td class="border-bottom-0"><h6 class="fw-semibold mb-0"><%= utilisateur.getId() %></h6></td>
                                                        <td class="border-bottom-0"><%= utilisateur.getUtilisateur() %></td>
                                                        <td class="border-bottom-0"><%= utilisateur.getSexLabel() %></td>
                                                        <td class="border-bottom-0"><%= utilisateur.getDescription() %></td>
                                                        <td class="border-bottom-0"><%= utilisateur.getDept() %></td>
                                                        <td>
                                                                                                               
                                                            <a href="/utilisateur/edit/<%= utilisateur.getId() %>">Edit</a> |
                                                            <a href="/utilisateur/delete/<%= utilisateur.getId() %>">Delete</a>
                                                        </td>
                                                    </tr>
                                                <% } %>                   
                                            </tbody>
                                        </table>


                                        <div class="mt-3 d-flex justify-content-end align-items-center">
                                        <nav aria-label="Page navigation example">

                                            <ul class="pagination m-0">


                                                <li class="page-item">
                                                    <form action="" method="get" class="page-link"aria-label="Previous">
                                                        <input type="hidden" name="pageNumber" class="page-link" placeholder="Numero de page" style="color: black;"
                                                            value="<%= ValidationHelper.sysout(request.getAttribute("previous"))%>"
                                                        >
                                                        
                                                        <input type="hidden" name="elementParPage" class="page-link" placeholder="Nombre d'elements" style="color: black;"
                                                        value="<%= ValidationHelper.sysout(request.getAttribute("elementParPage"))%>"
                                                        > 
                                                        
                                                        <span aria-hidden="true">&laquo;</span>
                                                        
                                                        <button type="submit" class="btn btn-primary">Previous</span>
                                                    
                                                    </form>
                                                </li>
                                                <li class="page-item">
                                                    <form action="" method="get" class="page-link"aria-label="Previous">
                                                        <input type="hidden" name="pageNumber" class="page-link" placeholder="Numero de page" style="color: black;"
                                                            value="<%= ValidationHelper.sysout(request.getAttribute("next"))%>"
                                                        >
                                                        <input type="hidden" name="elementParPage" class="page-link" placeholder="Nombre d'elements" style="color: black;"
                                                            value="<%= ValidationHelper.sysout(request.getAttribute("elementParPage"))%>"
                                                        > 
        
                                                        <span aria-hidden="true">&laquo;</span>
        
                                                        <button type="submit" class="btn btn-primary">Next</span>
                                                    </form>
                                                </li>
                                            </ul>
                                        </nav>
                                    </div>
                                    </div>
                                </div>
                            </div>
                            <a href="/utilisateur">Add </a>
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

