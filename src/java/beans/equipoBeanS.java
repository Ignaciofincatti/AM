
package beans;

import dao.equipoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import pojos.Equipos;
import dao.SaveUpdateDao;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import pojos.Categorias;
/**
 *
 * @author ignacio
 */
@Named(value = "equipoBeanS")
@SessionScoped
public class equipoBeanS implements Serializable {
    private Equipos equipoA;
    private Equipos equipoM;
    private SaveUpdateDao dao;
    private equipoDao Edao;
    private List<SelectItem> listItem;
    private Categorias cate;
    private List<Equipos>list;
    private boolean renderList;
    private boolean renderButton;

    /**
     * Creates a new instance of eqiopoBeanS
     */
    public equipoBeanS() {
        this.equipoA=new Equipos();
        this.equipoM=new Equipos();
        this.dao=new SaveUpdateDao();
        this.Edao=new equipoDao();
        this.cate=new Categorias();
        this.renderList=false;
        this.renderButton=false;
        
        
        
    }
    
    public String alta(){
        String url="";
        this.equipoA.setCategorias(cate);
        if (dao.saveUpdate(equipoA) == 1) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro el Eqiopo " + this.equipoA.getEquipoNombre() + "", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            this.equipoA.setEquipoNombre("");
            this.equipoA.setCategorias(null);
            this.equipoA.setEquipoLogo("");
            url = "index.xhtml";
        } else {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se puedo registrar el Eqiopo " + this.equipoA.getEquipoNombre() + "", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url = "equipoA.xhtml";
        }
        return url;
    }
    
    public void buscar(){
        this.equipoA.setCategorias(cate);
        String nomOrg=  this.equipoA.getEquipoNombre();
        //quito los espacios en blanco del string para poder comparar que los nombres sean iguales
        String nomEquipo= this.equipoA.getEquipoNombre().replace(" ","");
        //seteo del atributo para mandar el objeto completo
        this.list=Edao.verExiste(equipoA);
        if(!list.isEmpty()){
            this.setRenderList(true);
            this.setRenderButton(false);
        }else{
            this.setRenderList(false);
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se encontro Equipo con el nombre similar a: " + this.equipoA.getEquipoNombre() + "", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            this.setRenderButton(true);
        }
    }
    
    public void cancel(){
        this.equipoA.setEquipoNombre("");
        this.equipoA.setCategorias(null);
        this.equipoA.setEquipoLogo("");
        this.setRenderButton(false);
        this.setRenderList(false);
    }
    
    public String modificar(Equipos e){
        this.equipoM=e;
        this.equipoA.setEquipoNombre("");
        this.list=null;
        this.setRenderList(false);
        
        return "equipoM.xhtml";
    }
    
    public String update(){
        String url="";
        this.equipoM.setCategorias(cate);
        if(Edao.saveUpdate(equipoM)==1){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modifico el Equipo: "+equipoM.getEquipoNombre()+"", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="equipoS.xhtml";
        }else{
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo modificar el Equipo: "+equipoM.getEquipoNombre()+"", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="equipoM.xhtml";
        }
        return url;
    }
    
   
    
    public String eliminar(Equipos e){
        String url="";
        this.equipoM=e;
        this.equipoM.setEquipoestado(0);
        this.equipoA.setEquipoNombre("");
        this.list=null;
        if(this.Edao.saveUpdate(equipoM)==1){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino el Equipo: "+equipoM.getEquipoNombre()+"", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="equipoS.xhtml";
        }else{
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo eliminar el Equipo: "+equipoM.getEquipoNombre()+"", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="equipoM.xhtml";
        }
        this.setRenderList(false);
        return url;
    }
     
    public void equiposBajas(){
        this.list=Edao.equiposBaja(equipoA);
        this.setRenderList(true);
    }
    
    public String altaExistente(Equipos e){
        String url="";
        e.setEquipoestado(1);
        if(Edao.saveUpdate(e)==1){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se habilito el Equipo: "+e.getEquipoNombre()+"", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="equipoS.xhtml";
            
        }else{
             FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo habilitar el Equipo: "+e.getEquipoNombre()+"", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            url="equipoB.xhtml";
            
        }
        this.setRenderList(false);
        return url;
    }

    public Equipos getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipos equipoA) {
        this.equipoA = equipoA;
    }

    public Equipos getEquipoM() {
        return equipoM;
    }

    public void setEquipoM(Equipos equipoM) {
        this.equipoM = equipoM;
    }

    
    
    public Categorias getCate() {
        return cate;
    }

    public void setCate(Categorias cate) {
        this.cate = cate;
    }

    public List<SelectItem> getListItem() {
        this.listItem=new ArrayList<>();
        List<Categorias> c=Edao.categorias();
        listItem.clear();
        for(Categorias cat: c){
            String label=String.valueOf(cat.getCategoria());
            if(!label.equals("null")){
                SelectItem i=new SelectItem(cat.getIdCategorias(),label);
                listItem.add(i);
            }
        }
        return listItem;
    }

    public void setListItem(List<SelectItem> listItem) {
        this.listItem = listItem;
    }
    
    public List<Equipos> getList() {
        return list;
    }

    public void setList(List<Equipos> list) {
        this.list = list;
    }

    public boolean isRenderList() {
        return renderList;
    }

    public void setRenderList(boolean renderList) {
        this.renderList = renderList;
    }

    public boolean isRenderButton() {
        return renderButton;
    }

    public void setRenderButton(boolean renderButton) {
        this.renderButton = renderButton;
    }
    
    
    
    
}