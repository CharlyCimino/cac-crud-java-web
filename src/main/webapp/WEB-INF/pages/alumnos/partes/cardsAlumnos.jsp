<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${listaAlumnos}" var="alumno">  
    <div class="col">
        <div class="card h-100">
            <!-- Foto -->
            <img class="card-img-top" src="${alumno.foto}" alt="Foto de ${alumno.nombreCompleto}" />
            <!-- Detalles -->
            <div class="card-body p-4">
                <div class="text-center">
                    <h5 class="fw-bolder">${alumno.nombreCompleto}</h5>
                    <p class="mb-1">${alumno.fechaNacimiento} (${alumno.edad} años)</p>
                    <ins>${alumno.mail}</ins> 
                </div>
            </div>
            <!-- Product actions-->
            <div class="card-footer border-top-0 bg-transparent">
                <div class="row justify-content-center">
                    <div class="col-6">
                        <a href="${pageContext.request.contextPath}/app?accion=edit&id=${alumno.id}" class="btn btn-warning btn-block w-100">Editar</a>
                    </div>
                    <div class="col-6">
                        <a href="${pageContext.request.contextPath}/app?accion=remove&id=${alumno.id}" class="btn btn-danger btn-block w-100">Borrar</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>


