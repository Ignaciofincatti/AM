package pojos;
// Generated 26/10/2017 10:10:25 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Liga generated by hbm2java
 */
public class Liga  implements java.io.Serializable {


     private Integer idLiga;
     private String ligaNom;
     private Integer ligaEstado;
     private Set<LigaEquipo> ligaEquipos = new HashSet<LigaEquipo>(0);
     private Set<LigaCate> ligaCates = new HashSet<LigaCate>(0);
     private Set<Clasificaciones> clasificacioneses = new HashSet<Clasificaciones>(0);
     private Set<Torneos> torneoses = new HashSet<Torneos>(0);
     private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

    public Liga() {
    }

    public Liga(String ligaNom, Integer ligaEstado, Set<LigaEquipo> ligaEquipos, Set<LigaCate> ligaCates, Set<Clasificaciones> clasificacioneses, Set<Torneos> torneoses, Set<Usuarios> usuarioses) {
       this.ligaNom = ligaNom;
       this.ligaEstado = ligaEstado;
       this.ligaEquipos = ligaEquipos;
       this.ligaCates = ligaCates;
       this.clasificacioneses = clasificacioneses;
       this.torneoses = torneoses;
       this.usuarioses = usuarioses;
    }
   
    public Integer getIdLiga() {
        return this.idLiga;
    }
    
    public void setIdLiga(Integer idLiga) {
        this.idLiga = idLiga;
    }
    public String getLigaNom() {
        return this.ligaNom;
    }
    
    public void setLigaNom(String ligaNom) {
        this.ligaNom = ligaNom;
    }
    public Integer getLigaEstado() {
        return this.ligaEstado;
    }
    
    public void setLigaEstado(Integer ligaEstado) {
        this.ligaEstado = ligaEstado;
    }
    public Set<LigaEquipo> getLigaEquipos() {
        return this.ligaEquipos;
    }
    
    public void setLigaEquipos(Set<LigaEquipo> ligaEquipos) {
        this.ligaEquipos = ligaEquipos;
    }
    public Set<LigaCate> getLigaCates() {
        return this.ligaCates;
    }
    
    public void setLigaCates(Set<LigaCate> ligaCates) {
        this.ligaCates = ligaCates;
    }
    public Set<Clasificaciones> getClasificacioneses() {
        return this.clasificacioneses;
    }
    
    public void setClasificacioneses(Set<Clasificaciones> clasificacioneses) {
        this.clasificacioneses = clasificacioneses;
    }
    public Set<Torneos> getTorneoses() {
        return this.torneoses;
    }
    
    public void setTorneoses(Set<Torneos> torneoses) {
        this.torneoses = torneoses;
    }
    public Set<Usuarios> getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set<Usuarios> usuarioses) {
        this.usuarioses = usuarioses;
    }




}


