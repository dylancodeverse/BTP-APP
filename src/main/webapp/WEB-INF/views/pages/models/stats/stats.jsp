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
                        <h5 class="card-title fw-semibold mb-4">Statistique de vente </h5>
                        <div class="card w-100">
                            

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../../../templates/main-footer.jsp" %>
    <%@ include file="../../../templates/page-footer.jsp" %>
    <script>
        
    </script>
    
</body>
</html>                

