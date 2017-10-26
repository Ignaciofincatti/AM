package pojos;
// Generated 26/10/2017 10:10:25 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Roles generated by hbm2java
 */
public class Roles  implements java.io.Serializable {


     private Integer rolCod;
     private String rolName;
     private String rolId;
     private Set<UsuRol> usuRols = new HashSet<UsuRol>(0);

    public Roles() {
    }

    public Roles(String rolName, String rolId, Set<UsuRol> usuRols) {
       this.rolName = rolName;
       this.rolId = rolId;
       this.usuRols = usuRols;
    }
   
    public Integer getRolCod() {
        return this.rolCod;
    }
    
    public void setRolCod(Integer rolCod) {
        this.rolCod = rolCod;
    }
    public String getRolName() {
        return this.rolName;
    }
    
    public void setRolName(String rolName) {
        this.rolName = rolName;
    }
    public String getRolId() {
        return this.rolId;
    }
    
    public void setRolId(String rolId) {
        this.rolId = rolId;
    }
    public Set<UsuRol> getUsuRols() {
        return this.usuRols;
    }
    
    public void setUsuRols(Set<UsuRol> usuRols) {
        this.usuRols = usuRols;
    }




}

