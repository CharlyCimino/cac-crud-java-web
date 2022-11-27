
package ar.charlycimino.cac.crud.controlador;

import ar.charlycimino.cac.crud.modelo.Alumno;
import ar.charlycimino.cac.crud.modelo.Modelo;
import ar.charlycimino.cac.crud.modelo.ModeloHC;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
@WebServlet(name = "AppServlet", urlPatterns = {"/app"})
public class AppServlet extends HttpServlet {

    private Modelo model;
    private final String URI_LIST = "listadoAlumnos.jsp";
    private final String URI_EDIT = "/WEB-INF/pages/alumnos/editarAlumno.jsp";
    private final String URI_REMOVE = "/WEB-INF/pages/alumnos/borrarAlumno.jsp";       

    @Override
    public void init() throws ServletException {
        this.model = new ModeloHC();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        switch (accion) {
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                Alumno alu = model.getAlumno(id);
                request.setAttribute("alumnoAEditar", alu);
                request.setAttribute("yaTieneFoto", !alu.getFoto().contains("no-face"));
                request.getRequestDispatcher(URI_EDIT).forward(request, response);
                break;
            case "remove":
                id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("alumnoABorrar", model.getAlumno(id));
                request.getRequestDispatcher(URI_REMOVE).forward(request, response);
                break;
            default:
                HttpSession sesionHttp = request.getSession();
                sesionHttp.setAttribute("listaAlumnos", model.getAlumnos());
                //request.getRequestDispatcher(URI_LIST).forward(request, response);
                response.sendRedirect(URI_LIST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Alumno alu;
        int id;
        String accion = request.getParameter("accion");
        String tipoModelo = request.getParameter("modelo");
        accion = accion == null ? "" : accion;
        switch (accion) {
            case "add":
                alu = new Alumno();
                cargarAlumnoSegunParams(alu, request);
                model.addAlumno(alu);
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                alu = model.getAlumno(id);
                cargarAlumnoSegunParams(alu, request);
                model.updateAlumno(alu);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                model.removeAlumno(id);
                break;
        }
        doGet(request, response);
    }

    private void cargarAlumnoSegunParams(Alumno a, HttpServletRequest request) {
        System.out.println("N " + request.getParameter("nombre"));
        System.out.println("A " + request.getParameter("apellido"));
        a.setNombre(request.getParameter("nombre"));
        a.setApellido(request.getParameter("apellido"));
        a.setMail(request.getParameter("mail"));
        a.setFechaNacimiento(request.getParameter("fechaNac"));
        a.setFoto(request.getParameter("fotoBase64"));
    }
}
