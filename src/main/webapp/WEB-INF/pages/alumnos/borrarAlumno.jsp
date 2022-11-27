<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="Borrar a ${alumnoABorrar.nombreCompleto}" />
</jsp:include>

<jsp:include page="../comunes/navbar.jsp" />

<section class="py-3">
    <div class="container">
        <div class="row">
            <h1 class="h3">Borrar alumno</h1>
            <p class="lead">Estás a punto de borrar a ${alumnoABorrar.nombreCompleto}</p>
        </div>        
    </div>
    <div class="container px-4 mt-3">
        <div class="row align-items-center justify-content-center">
            <div class="col-sm-7 col-md-6 col-lg-4" >
                <div class="card border p-4 rounded-3 bg-light">
                    <img class="card-img-top" src="${alumnoABorrar.foto}" alt="Foto de ${alumnoABorrar.nombreCompleto}" />
                    <div class="card-body pb-0">
                        <div class="text-center">
                            <h5 class="fw-bolder">${alumnoABorrar.nombreCompleto}</h5>
                            <p class="mb-1">${alumnoABorrar.fechaNacimiento} (${alumnoABorrar.edad} años)</p>
                            <ins>${alumnoABorrar.mail}</ins>  
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-5 col-md-6 col-lg-4">
                <form action="${pageContext.request.contextPath}/app?accion=delete&id=${alumnoABorrar.id}"
                      method="post" class="was-validated border p-2 rounded-3 bg-light">
                    <div class="row text-center">
                        <div class="col-12 mb-2">
                            <p class="lead m-0">¿Estás seguro?</p>
                        </div>
                        <div class="col-12">
                            <a href="${pageContext.request.contextPath}/app" class="btn btn-secondary">Mejor no</a>
                            <button type="submit" class="btn btn-danger">Sí, borrar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../comunes/footer.jsp"/>
<jsp:include page="../comunes/finHTML.jsp"/>