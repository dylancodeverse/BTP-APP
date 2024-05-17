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
                            <h5 class="card-title fw-semibold mb-4">Modifier finition</h5>
                            <form action="/typefinition/editVRAI/<%=request.getAttribute("id")%>" method="get">                

                                              
                                

                                <div class="mb-3">
                                    <label for="name" class="form-label">Type finition:</label>
                                    <input type="text" id="type" name="typefinition" class="form-control" 
                                        style="<%= ValidationHelper.sysout(request.getAttribute("css_typefinition"))%>"
                                        value="<%= ValidationHelper.sysout(request.getAttribute("def_typefinition"))%>"
                                    />
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_typefinition")) %> </p>
                                </div>        
                                <div class="mb-3">
                                    <label for="name" class="form-label">Elevation:</label>
                                    <input type="unite" id="idelevation" name="elevation" class="form-control" 
                                        style="<%= ValidationHelper.sysout(request.getAttribute("css_elevation"))%>"
                                        value="<%= ValidationHelper.sysout(request.getAttribute("def_elevation"))%>"
                                    />
                                    <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("err_elevation")) %> </p>
                                </div>        

                                <p style="color:red"> <%= ValidationHelper.sysout(request.getAttribute("error")) %> </p>
                                <button type="submit" class="btn btn-primary">Modifier</button>
                            </form>
                            <a href="/typefinition/typefinition" class="mt-5">Back to List</a>
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

