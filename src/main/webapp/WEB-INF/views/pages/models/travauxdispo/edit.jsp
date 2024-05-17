<%@ page import="scaffold.framework.demo.models.*" %>
<%@ page import="scaffold.framework.demo.models.admin.*" %>

<%@ page import="scaffold.framework.demo.FormHelper.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../../templates/header.jsp">
    <jsp:param name="title" value="Modifier"/>
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
                            <h5 class="card-title fw-semibold mb-4">Modifier travaux</h5>
                            <form action="/travauxdispo/editVRAI/<%=request.getAttribute("id")%>" method="get">                

                                
                                
                                

                                <div class="mb-3">
                                    <label for="name" class="form-label">Designation:</label>
                                    <input type="text" id="Name" name="travauxdispo" class="form-control" 
                                        style="<%= ValidationHelper.sysout(request.getAttribute("css_travauxdispo"))%>"
                                        value="<%= ValidationHelper.sysout(request.getAttribute("def_travauxdispo"))%>"
                                    />
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_travauxdispo")) %> </p>
                                </div>        

                                <div class="mb-3">
                                    <label for="name" class="form-label">Departement:</label>
                                    <select name="unite" class="form-select" id=""
                                    style="<%= ValidationHelper.sysout(request.getAttribute("css_department"))%>"
                                    >
                                        <option value="">Choisir</option>
                                         <% Unite[] depts = (Unite[]) (request.getAttribute("unite"));   
                                            for (Unite each : depts) { %>
                                            <option value="<%=each.getId()%>"
                                                <%= each.getChecked() %> 
                                                >
                                                <%=each.getUnite() %></option>
                                        <%                                                
                                            }
                                        %>    
                                    </select>
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_department")) %> </p>
                                </div>      
                                <div class="mb-3">
                                    <label for="name" class="form-label">Prix unitaire:</label>
                                    <input type="unite" id="Name" name="prixunitaire" class="form-control" 
                                        style="<%= ValidationHelper.sysout(request.getAttribute("css_prixunitaire"))%>"
                                        value="<%= ValidationHelper.sysout(request.getAttribute("def_prixunitaire"))%>"
                                    />
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_prixunitaire")) %> </p>
                                </div>        
                                
                                <div class="mb-3">
                                    <label for="name" class="form-label">Code:</label>
                                    <input type="unite" id="Name" name="typedetravaux" class="form-control" 
                                        style="<%= ValidationHelper.sysout(request.getAttribute("css_typedetravaux"))%>"
                                        value="<%= ValidationHelper.sysout(request.getAttribute("def_typedetravaux"))%>"
                                    />
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_typedetravaux")) %> </p>
                                </div>        


                                  
                                <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("error")) %> </p>
                                <button type="submit" class="btn btn-primary">Add Promotion</button>
                            </form>
                            <a href="/travauxdispo/travauxdispo" class="mt-5">Back to List</a>
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

