<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="No encontrado" />
</jsp:include>

<jsp:include page="WEB-INF/pages/comunes/navbar.jsp" />

<section class="py-3">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-6" >
                <img class="card-img-top" src="assets/travolta.gif" alt="Imagen de error" />
            </div>
            <div class="col-6" >
                <h1 class="h3 text-danger">Error 404: Recurso no encontrado</h1>
                <p class="lead">Me parece que te equivocaste de link...</p>
            </div>
        </div>
    </div>
</section>


<jsp:include page="WEB-INF/pages/comunes/footer.jsp"/>
<jsp:include page="WEB-INF/pages/comunes/finHTML.jsp"/>


