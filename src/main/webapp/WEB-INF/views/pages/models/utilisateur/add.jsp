<%@ page import="scaffold.framework.demo.models.*" %>

<%@ page import="scaffold.framework.demo.FormHelper.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../../templates/header.jsp">
    <jsp:param name="title" value="Ajouter utilisateur"/>
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
                            <h5 class="card-title fw-semibold mb-4">Ajouter utilisateur</h5>
                            <form action="/utilisateur" method="post">                

                                <div class="mb-3">
                                    <label for="name" class="form-label">Nom:</label>
                                    <input type="text" id="Name" name="utilisateur" class="form-control" 
                                        style="<%= ValidationHelper.sysout(request.getAttribute("css_utilisateur"))%>"
                                        value="<%= ValidationHelper.sysout(request.getAttribute("def_utilisateur"))%>"
                                    />
                                </div>        
                                <div class="mb-3">
                                    <label for="name" class="form-label">Sex:</label>

                                    <input type="radio" name="sex" id="" value="1"
                                    <% 
                                    String var = ValidationHelper.sysout(request.getAttribute("def_sex")) ;
                                    if (var.equals("1"))
                                        out.println("checked"); else out.println(""); %>
                                    >
                                    <label for="homme">homme</label>

                                    <input type="radio" name="sex" id="" value="2"
                                    <% 
                                    if (var.equals("2"))
                                        out.println("checked"); else out.println(""); %>
                                    >
                                    <label for="homme">femme</label>

                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_sex")) %> </p>

                                </div>        

                                

                                <div class="mb-3">
                                    <label for="name" class="form-label">Description:</label>
                                    <textarea name="description" id="" cols="30" rows="10"
                                    style="<%= ValidationHelper.sysout(request.getAttribute("css_description"))%>"
                                    >
                                        <%= ValidationHelper.sysout(request.getAttribute("def_description"))%>
                                    </textarea>
                                </div>                                       

                                <div class="mb-3">
                                    <label for="name" class="form-label">Departement:</label>
                                    <select name="department" class="form-select" id=""
                                    style="<%= ValidationHelper.sysout(request.getAttribute("css_department"))%>"
                                    >
                                        <option value="">Choisir</option>
                                         <% Department[] depts = (Department[]) (request.getAttribute("dept"));   
                                            for (Department each : depts) { %>
                                            <option value="<%=each.getId()%>"><%=each.getDept() %></option>
                                        <%                                                
                                            }
                                        %>    
                                    </select>
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_department")) %> </p>
                                </div>                                       

                                <button type="submit" class="btn btn-primary">Add Promotion</button>
                            </form>
                            <a href="/promotions/list" class="mt-5">Back to List</a>
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

