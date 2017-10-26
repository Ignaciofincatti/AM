<h1>Inicio Usuario</h1>
  
<%
 String usuario = request.getUserPrincipal().getName();
 out.println("<h2>Bienvenido(a) : " + usuario + "</h2>");
  
 if(request.isUserInRole("ADMIN")){
 out.println("<a href='../admin/'>Administrador</a>");
 }
if(request.isUserInRole("ESTUDIANTE")){
 out.println("<a href='../estudiante/'>Estudiante</a>");
 }
 
%>