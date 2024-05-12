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
                            <h5 class="card-title fw-semibold mb-4">Ajouter interets des utilisateurs</h5>
                            <form action="" method="post">                

                                <div class="mb-3">
                                    <label for="name" class="form-label">Utilisateur:</label>
                                    <select name="utilisateur" id=""
                                    style="<%= ValidationHelper.sysout(request.getAttribute("css_utilisateur"))%>"
                                    >
                                        <option value="">Choisir</option>
                                        <% Utilisateur[] users = (Utilisateur[]) request.getAttribute("utilisateur");
                                        for(Utilisateur user : users){ %>
                                            <option value="<%=user.getId()%>"> <%= user.getUtilisateur() %></option>
                                        <%    
                                        }
                                        %>
                                    </select>
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_utilisateur")) %> </p>
                                </div>        
                                <div class="mb-3">
                                    <label for="name" class="form-label">Interets:</label>
                                    <% Interets[] interets = (Interets[]) request.getAttribute("interets") ;
                                    for(Interets interet : interets){ %>
                                    <input type="checkbox" name="interets[]" id="" value= "<%=interet.getId()%>"
                                    <%= interet.getChecked() %> >
                                    <label> <%= interet.getInterets() %>  </label>

                                    <%
                                        }
                                    %>
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_interets")) %>  </p>
                                </div>        


                                <button type="submit" class="btn btn-primary">Ajouter</button>
                            </form>
                            <a href="" class="mt-5">Back to List</a>
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

