package pojos;
// Generated 26/10/2017 10:10:25 by Hibernate Tools 4.3.1



/**
 * JugadoresEquipos generated by hbm2java
 */
public class JugadoresEquipos  implements java.io.Serializable {


     private Integer idjugadorEquipos;
     private Equipos equipos;
     private Jugadores jugadores;

    public JugadoresEquipos() {
    }

    public JugadoresEquipos(Equipos equipos, Jugadores jugadores) {
       this.equipos = equipos;
       this.jugadores = jugadores;
    }
   
    public Integer getIdjugadorEquipos() {
        return this.idjugadorEquipos;
    }
    
    public void setIdjugadorEquipos(Integer idjugadorEquipos) {
        this.idjugadorEquipos = idjugadorEquipos;
    }
    public Equipos getEquipos() {
        return this.equipos;
    }
    
    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }
    public Jugadores getJugadores() {
        return this.jugadores;
    }
    
    public void setJugadores(Jugadores jugadores) {
        this.jugadores = jugadores;
    }




}


