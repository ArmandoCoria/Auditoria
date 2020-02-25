package com.veolus.auditoria;

import java.util.ArrayList;

public class StoreFormIT {

    private String idUser;
    private String id;
    private String fecha;
    private String sector;
    private String proyecto;
    private String direccion;
    private String reparacion;
    private String antecedentes;
    private String desarrollo;
    private String mpf1; // antecedentes mp fecha mes 1
    private String mpf2; // antecedentes mp fecha mes 2
    private String mpf3; // antecedentes mp fecha mes 3
    private String mpd1; // antecedentes mp descrpcion mes 1
    private String mpd2; // antecedentes mp descripcion mes 2
    private String mpd3; // antecedentes mp descripcion mes 3
    private String mmf1; // antecedentes mtto mayor fecha mes 1
    private String mmf2; // antecedentes mtto mayor fecha mes 2
    private String mmd1; // antecedentes mtto mayor descripcion mes 1
    private String mmd2; // antecedentes mtto mayor descripcion mes 2
    private String fallaOrd1; // antecedentes fallas no. OS y/u OT mes 1
    private String fallaOrd2; // antecedentes fallas no. OS y/u OT mes 2
    private String fallaOrd3; // antecedentes fallas no. OS y/u OT mes 3
    private String fallaOrdF1; // antecedentes fallas fecha mes 1
    private String fallaOrdF2; // antecedentes fallas fecha mes 2
    private String fallaOrdF3; // antecedentes fallas fecha mes 3
    private String fallaOrdDesc1; // antecedentes fallas descripcion mes 1
    private String fallaOrdDesc2; // antecedentes fallas descripcion mes 2
    private String fallaOrdDesc3; // antecedentes fallas descripcion mes 3
    private String ite1; // no. ite mes 1
    private String ite2; // no. ite mes 2
    private String ite3; // no. ite mes 3
    private String itef1; // fecha ite mes 1
    private String itef2; // fecha ite mes 2
    private String itef3; // fecha ite mes 3
    private String iteDesc1; // descripcion ite mes 1
    private String iteDesc2; // descripcion ite mes 2
    private String iteDesc3; // descripcion ite mes 3
    private String desarrolloDesc;
    private String desarrolloObserv;
    private String desarrolloRepar; // reparación realizada
    private String desarrolloStatus; // estatus en que se deja el equipo
    private ArrayList listadoFallas; // lista de fallas o daños de materiales
    private String conclusiones; // conclusiones de la lista de fallas o daños de materiles
    private String recomendaciones; // recomendaciones de la lista de fallas o daños de materiales
    private int equipo; // equipos seleccionados ya en bd
    private String otros; // colocar otros equipos que no esten en bd
    private String firmanteTec; // nombre del tecnico de sitio
    private String firmanteResp; // nombre del responsable de sitio
    private String firmaTec; // firma del tecnico de sitio
    private String firmaResp; // firma del responsable de sitio
    private String fotouno; // foto uno de equipos de sitio
    private String fotodos; //foto dos de equipos de sitio
    private String fototres; //foto tres de equipos de sitio
    private String fotocuatro; // foto cuatro de equipos de sitio
    private String fotocnco; // foto cinco de equipos de sitio
    private String fotoseis; // foto seis de equipos de sitio

    public void setIdUser(String user) {this.idUser = user; }
    public void setId(String id) {this.id = id; }
    public void setFecha(String fecha) {this.fecha = fecha;}
    public void setSector(String sector) {this.sector = sector;}
    public void setProyecto(String proyecto) {this.proyecto = proyecto;}
    public void setDireccion(String direccion ){ this.direccion=direccion; }
    public void setReparaciones(String reparacion ){ this.reparacion=reparacion; }
    public void setAntecedentes(String antecedentes ){ this.antecedentes=antecedentes; }
    public void setDesarrollo(String desarrollo ){ this.desarrollo=desarrollo; }
    public void setMpf1(String mpf1) {this.mpf1 = mpf1;}
    public void setMpf2(String mpf2) {this.mpf1 = mpf2;}
    public void setMpf3(String mpf3) {this.mpf1 = mpf3;}
    public void setMpd1(String mpd1) {this.mpd1 = mpd1;}
    public void setMpd2(String mpd2) {this.mpd2 = mpd2;}
    public void setMpd3(String mpd3) {this.mpf1 = mpd3;}
    public void setMmf1(String mmf1) {this.mmf1 = mmf1;}
    public void setMmf2(String mmf2) {this.mmf2 = mmf2;}
    public void setMmd1(String mmd1) {this.mmd1 = mmd1;}
    public void setMmd2(String mmd2) {this.mmd1 = mmd2;}
    public void setFallaOrd1(String fallaOrd1) {this.fallaOrd1 = fallaOrd1;}
    public void setFallaOrd2(String fallaOrd2) {this.fallaOrd2 = fallaOrd2;}
    public void setFallaOrd3(String fallaOrd3) {this.fallaOrd3 = fallaOrd3;}
    public void setFallaOrdF1(String fallaOrdF1) {this.fallaOrdF1 = fallaOrdF1;}
    public void setFallaOrdF2(String fallaOrdF2) {this.fallaOrdF2 = fallaOrdF2;}
    public void setFallaOrdF3(String fallaOrdF3) {this.fallaOrdF3 = fallaOrdF3;}
    public void setFallaOrdDesc1(String fallaOrdDesc1) {this.fallaOrdDesc1 = fallaOrdDesc1;}
    public void setFallaOrdDesc2(String fallaOrdDesc2) {this.fallaOrdDesc2 = fallaOrdDesc2;}
    public void setFallaOrdDesc3(String fallaOrdDesc3) {this.fallaOrdDesc3 = fallaOrdDesc3;}
    public void setIte1(String ite1) {this.ite1 = ite1;}
    public void setIte2(String ite2) {this.ite2 = ite2;}
    public void setIte3(String ite3) {this.ite3 = ite3;}
    public void setItef1(String itef1) {this.itef1 = itef1;}
    public void setItef2(String itef2) {this.itef2 = itef2;}
    public void setItef3(String itef3) {this.itef3 = itef3;}
    public void setIteDesc1(String iteDesc1) {this.iteDesc1 = iteDesc1;}
    public void setIteDesc2(String iteDesc2) {this.iteDesc2 = iteDesc2;}
    public void setIteDesc3(String iteDesc3) {this.iteDesc3 = iteDesc3;}
    public void setDesarrolloDesc(String desarrolloDesc) {this.desarrolloDesc = desarrolloDesc;}
    public void setDesarrolloObserv(String desarrolloObserv) {this.desarrolloObserv = desarrolloObserv;}
    public void setDesarrolloRepar(String desarrolloRepar) {this.desarrolloRepar = desarrolloRepar;}
    public void setDesarrolloStatus(String desarrolloStatus) {this.desarrolloStatus = desarrolloStatus;}
    public void setListadoFallas(ArrayList listadoFallas) {this.listadoFallas = listadoFallas;}
    public void setConclusiones(String conclusiones ){ this.conclusiones=conclusiones; }
    public void setRecomendaciones(String recomendaciones ){ this.recomendaciones=recomendaciones; }
    public void setEquipo(int equipo ){ this.equipo=equipo; }
    public void setOtros(String otros ){ this.otros=otros; }
    public void setFirmaTec(String firmaTec ){ this.firmaTec=firmaTec; }
    public void setFirmaResp(String firmaResp ){ this.firmaResp=firmaResp; }
    public void setFotouno(String fotouno) {this.fotouno=fotouno;}
    public void setFotodos(String fotodos) {this.fotodos=fotodos;}
    public void setFototres(String fototres) {this.fototres=fototres;}
    public void setFotocuatro(String fotocuatro) {this.fotocuatro=fotocuatro;}
    public void setFotocnco(String fotocnco) {this.fotocnco=fotocnco;}
    public void setFotoseis(String fotoseis) {this.fotoseis=fotoseis;}
    public void setFirmanteTec(String coor) {this.firmanteTec=coor;}
    public void setFirmanteResp(String jef) {this.firmanteResp=jef;}

}
