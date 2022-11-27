<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="comunes/inicioHTML.jsp"/>

<jsp:include page="comunes/inicioHead.jsp"/>
<title>Ocurrió un error</title>
<jsp:include page="comunes/finHead.jsp"/>

<jsp:include page="comunes/nav.jsp"/>

<section class="py-3">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-1" >
                <img class="card-img-top" src="assets/icono-error.png" alt="Imagen de error" />
            </div>
            <div class="col-11" >
                <h1 class="h3 text-danger">Error</h1>
                <p class="lead">Ha ocurrido un error. Te dejo el detalle...</p>
                <p class="small">Tené en cuenta que en una app real, la info se guarda en el servidor. Exponerla al cliente compremete la seguridad.</p>
            </div>
        </div>
        <div class="row align-items-center justify-content-center">
            <div class="col border border-danger rounded text-danger p-3">
                <c:forEach items="${throwablesList}" var="th">
                    <p class="p-0 m-0"><strong>Causado por: ${th.message}</strong></p>
                    <c:forEach items="${th.stackTrace}" var="line">
                        <p class="p-0 m-0"><small><c:out value="${line}" /></small></p>
                    </c:forEach>
                    <p class="p-0 m-0"><small><c:out value="${line}" /></small></p>
                </c:forEach>
            </div>
        </div>
    </div>
</section>


<jsp:include page="comunes/footer.jsp"/>
<jsp:include page="comunes/finHTML.jsp"/>


