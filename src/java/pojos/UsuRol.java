package pojos;
// Generated 26/10/2017 10:10:25 by Hibernate Tools 4.3.1



/**
 * UsuRol generated by hbm2java
 */
public class UsuRol  implements java.io.Serializable {


     private Integer usrCodigo;
     private Roles roles;
     private Usuarios usuarios;

    public UsuRol() {
    }

    public UsuRol(Roles roles, Usuarios usuarios) {
       this.roles = roles;
       this.usuarios = usuarios;
    }
   
    public Integer getUsrCodigo() {
        return this.usrCodigo;
    }
    
    public void setUsrCodigo(Integer usrCodigo) {
        this.usrCodigo = usrCodigo;
    }
    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }




}


