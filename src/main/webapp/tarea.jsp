<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="No encontrado" />
</jsp:include>

<jsp:include page="WEB-INF/pages/comunes/navbar.jsp" />

<section class="py-3">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-12" >
                <h1 class="display-1">Tarea</h1>
                <p class="lead">
                    Diseñar una vista de detalle para la persona que acabas de elegir, que permita ver TODOS sus datos guardados en la BD (mail, fecha de nacimiento, edad, etc). Además, debe tener los botones para editar o borrar también desde esta vista.
                </p>
            </div>
        </div>
    </div>
</section>


<jsp:include page="WEB-INF/pages/comunes/footer.jsp"/>
<jsp:include page="WEB-INF/pages/comunes/finHTML.jsp"/>