

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.jugadorDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import static org.hibernate.jpa.criteria.ValueHandlerFactory.isNumeric;
import pojos.Jugadores;
import dao.SaveUpdateDao;

/**
 *
 * @author ignacio
 */
@Named(value = "jugadorBeanS")
@SessionScoped
public class JugadorBeanS implements Serializable{
    private Jugadores jconsulta;
    private Jugadores jugadorA;
    private Jugadores jugadorM;
    private boolean render;
    private  List<Jugadores>list;
    private SaveUpdateDao dao;
    private jugadorDao Jdao;

    /**
     * Creates a new instance of JugadorBeanR
     */
    public JugadorBeanS() {
        this.dao= new SaveUpdateDao();
        this.Jdao=new jugadorDao();
        this.jugadorA=new Jugadores();
        this.jugadorM=new Jugadores();
        this.jconsulta=new Jugadores();
    }
    
    public String alta(){
        String url="index.xhtml";
       list=Jdao.vreExiste(jugadorA);
        if (list.isEmpty()){
            if(dao.saveUpdate(this.jugadorA)==1){
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro el Jugador "+this.jugadorA.getJugadorApellido()+"", "");
                FacesContext.getCurrentInstance().addMessage(null, msj);
                this.jugadorA=null;
                url="jugadorS.xhtml";
            }
        }else{
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El jugador con el dni "+this.jugadorA.getJugadorDni()+" ya se encuentra registrado", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="jugadorA.xhtml";
        }
        return url;
    }
    
    
    public void buscar(){
        list=Jdao.vreExiste(jconsulta);
        if(!list.isEmpty()){
            this.setRender(true);
        }else{
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El jugador con el dni "+this.jconsulta.getJugadorDni()+" no se encuentra registrado", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            this.setRender(false);
        }
        
    }
    
    public String modificar(){
        this.jugadorM=this.list.get(0);
        this.jconsulta.setJugadorDni("");
        this.list=null;
        this.setRender(false);
        return "jugadorM.xhtml";
    }
    
    public String modif(){
        String url="";
       if(dao.saveUpdate(this.jugadorM)==1){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El jugador "+this.jugadorM.getJugadorApellido()+" se modifico", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="jugadorS.xhtml";
        }else{
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El jugador "+this.jugadorM.getJugadorApellido()+" no se pudo modificar", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="jugadorM.xhtml";
        }
       return url;
    }
    
//    public String eliminar(){
//        String url="";
//        this.jugadorM=this.list.get(0);
//        this.jconsulta.setJugadorDni("");
//        this.list=null;
//        this.setRender(false);
//        this.jugadorM.setEstado(0);
//        if(dao.saveUpdate(jugadorM)==1){
//            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El jugador "+this.jugadorM.getJugadorApellido()+" se elimino", "");
//            FacesContext.getCurrentInstance().addMessage(null, msj);
//            url="jugadorS.xhtml";
//        }else{
//            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El jugador "+this.jugadorM.getJugadorApellido()+" no se pudo eliminar", "");
//            FacesContext.getCurrentInstance().addMessage(null, msj);
//            url="jugadorM.xhtml";
//        }
//        
//        return url;
//    }
    
    
    
    
    public Jugadores getJugadorA() {
        return jugadorA;
    }

    public void setJugadorA(Jugadores jugadorA) {
        this.jugadorA = jugadorA;
    }

    public Jugadores getJugadorM() {
        return jugadorM;
    }

    public void setJugadorM(Jugadores jugadorM) {
        this.jugadorM = jugadorM;
    }
    

    
    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public List<Jugadores> getList() {
        return list;
    }

    public void setList(List<Jugadores> list) {
        this.list = list;
    }

    public Jugadores getJconsulta() {
        return jconsulta;
    }

    public void setJconsulta(Jugadores jconsulta) {
        this.jconsulta = jconsulta;
    }
    


    
    
    
    
    
}

