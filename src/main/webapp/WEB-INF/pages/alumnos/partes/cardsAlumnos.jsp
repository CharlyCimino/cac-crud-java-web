<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${listaAlumnos}" var="alumno">  
    <div class="col">
        <div class="card h-100">
            <img class="card-img-top" src="${alumno.foto}" alt="Foto de ${alumno.nombreCompleto}" />
            <div class="card-body pt-3">
                <div class="text-center">
                    <h5 class="fw-bolder">${alumno.nombreCompleto}</h5>
                </div>
            </div>
            <div class="card-footer">
                <div class="row justify-content-center">
                    <div class="col-4">
                        <a href="${pageContext.request.contextPath}/tarea.jsp" class="btn bg-info w-100"><i class="bi bi-eye"></i></a>
                    </div>
                    <div class="col-4">
                        <a href="${pageContext.request.contextPath}/app?accion=edit&id=${alumno.id}" class="btn bg-warning w-100"><i class="bi bi-pencil"></i></a>
                    </div>
                    <div class="col-4">
                        <a href="${pageContext.request.contextPath}/app?accion=remove&id=${alumno.id}" class="btn bg-danger text-light w-100"><i class="bi bi-trash3"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>


