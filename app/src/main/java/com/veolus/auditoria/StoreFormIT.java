package com.veolus.auditoria;

import java.util.ArrayList;

public class StoreFormIT {

    private String idUser;
    private String id;
    private String fecha;
    private String sitio;
    private String sector;
    private String proyecto;
    private String antecedentes;

    private Boolean revision;
    private Boolean inspeccion;
    private Boolean diagnostico;
    private Boolean mttomayor;
    private Boolean falla;
    private Boolean reparacion;

            private String direccion;
            private String desarrollo;

    private String equipo;
    private String marca;
    private String modelo;
    private String noserie;
    private String ubicacion;
    //MP
    private String mpf1; // antecedentes mp fecha mes 1
    private String mpd1; // antecedentes mp descripcion mes 1
    private String mpf2; // antecedentes mp fecha mes 2
    private String mpd2; // antecedentes mp descripcion mes 2
    private String mpf3; // antecedentes mp fecha mes 3
    private String mpd3; // antecedentes mp descripcion mes 3
    //MttoMayor
    private String mmf1; // antecedentes mtto mayor fecha mes 1
    private String mmd1; // antecedentes mtto mayor descripcion mes 1
    private String mmf2; // antecedentes mtto mayor fecha mes 2
    private String mmd2; // antecedentes mtto 2mayor descripcion mes 2
    private String mmf3; // antecedentes mtto mayor fecha mes 3
    private String mmd3; // antecedentes mtto 2mayor descripcion mes 3
    //fallas
    private String fallaOrd1; // antecedentes fallas no. OS y/u OT mes 1
    private String fallaOrdF1; // antecedentes fallas fecha mes 1
    private String fallaOrdDesc1; // antecedentes fallas descripcion mes 1
    private String fallaOrd2; // antecedentes fallas no. OS y/u OT mes 2
    private String fallaOrdF2; // antecedentes fallas fecha mes 2
    private String fallaOrdDesc2; // antecedentes fallas descripcion mes 2
    private String fallaOrd3; // antecedentes fallas no. OS y/u OT mes 3
    private String fallaOrdF3; // antecedentes fallas fecha mes 3
    private String fallaOrdDesc3; // antecedentes fallas descripcion mes 3
    //ITE
    private String ite1; // no. ite mes 1
    private String itef1; // fecha ite mes 1
    private String iteDesc1; // descripcion ite mes 1
    private String ite2; // no. ite mes 2
    private String itef2; // fecha ite mes 2
    private String iteDesc2; // descripcion ite mes 2
    private String ite3; // no. ite mes 3
    private String itef3; // fecha ite mes 3
    private String iteDesc3; // descripcion ite mes 3

    private String desarrolloDesc; //breve descripcion de lo que se realiza o ejecuta.
    private String desarrolloObserv; //observaciones o hallazgo
    private String desarrolloRepar; // reparación realizada
    private String desarrolloEstado; // estatus en que se deja el equipo

    //private ArrayList listadoFallas; // lista de fallas o daños de materiales

    private String descripcionDesa1;
    private String descripcionDesa2;
    private String descripcionDesa3;
    private String descripcionDesa4;
    private String descripcionDesa5;
    private String descripcionDesa6;
    private String descripcionDesa7;
    private String descripcionDesa8;
    private String descripcionDesa9;
    private String descripcionDesa10;
    //Imagenes
    private String fotouno; // foto uno de equipos de sitio
    private String fotodos; //foto dos de equipos de sitio
    private String fototres; //foto tres de equipos de sitio
    private String fotocuatro; // foto cuatro de equipos de sitio
    private String fotocnco; // foto cinco de equipos de sitio
    private String fotoseis; // foto seis de equipos de sitio
    private String fotosiete; //foto siete de equipos de sitio
    private String fotoocho; //foto ocho de equipos de sitio
    private String fotonueve; //foto nueve de equipos de sitio
    private String fotodiez; //foto diez de equipos de sitio

    private String conclusiones; // conclusiones de la lista de fallas o daños de materiles
    //Recomendaciones
    //private ArrayList listadorecomendaciones; // lista de fallas o daños de materiales

    private String recomendacion1;
    private String recomendacion2;
    private String recomendacion3;
    private String recomendacion4;
    private String recomendacion5;
    private String recomendacion6;
    private String recomendacion7;
    private String recomendacion8;
    private String recomendacion9;
    private String recomendacion10;

    //Firmas
    private String firmanteTec; // nombre del tecnico de sitio
    private String firmanteResp; // nombre del responsable de sitio
    private String firmaTec; // firma del tecnico de sitio
    private String firmaResp; // firma del responsable de sitio


                    private String recomendaciones; // recomendaciones de la lista de fallas o daños de materiales
                    //private int equipo; // equipos seleccionados ya en bd
                    private String otros; // colocar otros equipos que no esten en bd


    public void setIdUser(String user) {this.idUser = user; }
    public void setId(String id) {this.id = id; }
    public void setFecha(String fecha) {this.fecha = fecha;}

    public void setSitio(String sitio) {this.sitio = sitio;}
    public void setSector(String sector) {this.sector = sector;}
    public void setProyecto(String proyecto) {this.proyecto = proyecto;}

    public void setRevision(Boolean revision) {this.revision = revision;}
    public void setInspeccion(Boolean inspeccion) {this.inspeccion = inspeccion;}
    public void setDiagnostico(Boolean diagnostico) {this.diagnostico = diagnostico;}
    public void setMttomayor(Boolean mttomayor) {this.mttomayor = mttomayor;}
    public void setFalla(Boolean falla) {this.falla = falla;}
    public void setReparacion(Boolean reparacion) {this.reparacion = reparacion;}

    public void setEquipo(String equipo) {this.equipo = equipo;}
    public void setMarca(String marca) {this.marca = marca;}
    public void setModelo(String Modelo) {this.modelo = modelo;}
    public void setNoserie(String Noserie) {this.noserie = noserie; }
    public void setUbicacion(String Ubicacion) {this.ubicacion = ubicacion;}

                public void setDireccion(String direccion ){ this.direccion=direccion; }
               // public void setReparaciones(String reparacion ){ this.reparacion=reparacion; }
                public void setAntecedentes(String antecedentes ){ this.antecedentes=antecedentes; }
                public void setDesarrollo(String desarrollo ){ this.desarrollo=desarrollo; }

    //Antecedentes
    public void setMpf1(String mpf1) {this.mpf1 = mpf1;} //fecha MP1
    public void setMpd1(String mpd1) {this.mpd1 = mpd1;} //Breve MP1
    public void setMpf2(String mpf2) {this.mpf2 = mpf2;} //Fecha MP2
    public void setMpd2(String mpd2) {this.mpd2 = mpd2;} //Breve MP2
    public void setMpf3(String mpf3) {this.mpf3 = mpf3;} //Fecha MP3
    public void setMpd3(String mpd3) {this.mpd3 = mpd3;} //Breve MP3
    //Mtto Mayor MM
    public void setMmf1(String mmf1) {this.mmf1 = mmf1;}
    public void setMmd1(String mmd1) {this.mmd1 = mmd1;}
    public void setMmf2(String mmf2) {this.mmf2 = mmf2;}
    public void setMmd2(String mmd2) {this.mmd1 = mmd2;}
    public void setMmf3(String mmf3) {this.mmf3 = mmf3;}
    public void setMmd3(String mmd3) {this.mmd3 = mmd3;}
    //Fallas
    public void setFallaOrdF1(String fallaOrdF1) {this.fallaOrdF1 = fallaOrdF1;}
    public void setFallaOrd1(String fallaOrd1) {this.fallaOrd1 = fallaOrd1;}
    public void setFallaOrdDesc1(String fallaOrdDesc1) {this.fallaOrdDesc1 = fallaOrdDesc1;}
    public void setFallaOrdF2(String fallaOrdF2) {this.fallaOrdF2 = fallaOrdF2;}
    public void setFallaOrd2(String fallaOrd2) {this.fallaOrd2 = fallaOrd2;}
    public void setFallaOrdDesc2(String fallaOrdDesc2) {this.fallaOrdDesc2 = fallaOrdDesc2;}
    public void setFallaOrdF3(String fallaOrdF3) {this.fallaOrdF3 = fallaOrdF3;}
    public void setFallaOrd3(String fallaOrd3) {this.fallaOrd3 = fallaOrd3;}
    public void setFallaOrdDesc3(String fallaOrdDesc3) {this.fallaOrdDesc3 = fallaOrdDesc3;}
    //ITE
    public void setIte1(String ite1) {this.ite1 = ite1;}
    public void setItef1(String itef1) {this.itef1 = itef1;}
    public void setIteDesc1(String iteDesc1) {this.iteDesc1 = iteDesc1;}
    public void setIte2(String ite2) {this.ite2 = ite2;}
    public void setItef2(String itef2) {this.itef2 = itef2;}
    public void setIteDesc2(String iteDesc2) {this.iteDesc2 = iteDesc2;}
    public void setIte3(String ite3) {this.ite3 = ite3;}
    public void setItef3(String itef3) {this.itef3 = itef3;}
    public void setIteDesc3(String iteDesc3) {this.iteDesc3 = iteDesc3;}
    //Desarrollo
    public void setDesarrolloDesc(String desarrolloDesc) {this.desarrolloDesc = desarrolloDesc;}
    public void setDesarrolloObserv(String desarrolloObserv) {this.desarrolloObserv = desarrolloObserv;}
    public void setDesarrolloRepar(String desarrolloRepar) {this.desarrolloRepar = desarrolloRepar;}
    public void setDesarrolloEstado(String desarrolloestado) {this.desarrolloEstado = desarrolloestado;}
    //Listado de fallas
    public void etDescripcionDesa1(String descripcionDesa1) {this.descripcionDesa1 = descripcionDesa1;}
    public void etDescripcionDesa2(String descripcionDesa2) {this.descripcionDesa2 = descripcionDesa2;}
    public void etDescripcionDesa3(String descripcionDesa3) {this.descripcionDesa3 = descripcionDesa3;}
    public void etDescripcionDesa4(String descripcionDesa4) {this.descripcionDesa4 = descripcionDesa4;}
    public void etDescripcionDesa5(String descripcionDesa5) {this.descripcionDesa5 = descripcionDesa5;}
    public void etDescripcionDesa6(String descripcionDesa6) {this.descripcionDesa6 = descripcionDesa6;}
    public void etDescripcionDesa7(String descripcionDesa7) {this.descripcionDesa7 = descripcionDesa7;}
    public void etDescripcionDesa8(String descripcionDesa8) {this.descripcionDesa8 = descripcionDesa8;}
    public void etDescripcionDesa9(String descripcionDesa9) {this.descripcionDesa9 = descripcionDesa9;}
    public void etDescripcionDesa10(String descripcionDesa10) {this.descripcionDesa10 = descripcionDesa10;}
    //Imagenes
    public void setFotouno(String fotouno) {this.fotouno=fotouno;}
    public void setFotodos(String fotodos) {this.fotodos=fotodos;}
    public void setFototres(String fototres) {this.fototres=fototres;}
    public void setFotocuatro(String fotocuatro) {this.fotocuatro=fotocuatro;}
    public void setFotocnco(String fotocnco) {this.fotocnco=fotocnco;}
    public void setFotoseis(String fotoseis) {this.fotoseis=fotoseis;}
    public void setFotosiete(String fotosiete) {this.fotosiete=fotosiete;}
    public void setFotoocho(String fotoocho) {this.fotoseis=fotoocho;}
    public void setFotonuevo(String fotonuevo) {this.fotoseis=fotonueve;}
    public void setFotodiez(String fotodiez) {this.fotoseis=fotodiez;}
    //Conclusiones
    public void setConclusiones(String conclusiones ){ this.conclusiones=conclusiones; }
    //Recomendaciones
    //public void setRListadorecomendaciones(ArrayList listadorecomendaciones ){ this.listadorecomendaciones=listadorecomendaciones; }

    public void setRecomendacion1(String recomendacion1) {this.recomendacion1 = recomendacion1;}
    public void setRecomendacion2(String recomendacion2) {this.recomendacion2 = recomendacion2;}
    public void setRecomendacion3(String recomendacion3) {this.recomendacion3 = recomendacion3;}
    public void setRecomendacion4(String recomendacion4) {this.recomendacion4 = recomendacion4;}
    public void setRecomendacion5(String recomendacion5) {this.recomendacion5 = recomendacion5;}
    public void setRecomendacion6(String recomendacion6) {this.recomendacion6 = recomendacion6;}
    public void setRecomendacion7(String recomendacion7) {this.recomendacion7 = recomendacion7;}
    public void setRecomendacion8(String recomendacion8) {this.recomendacion8 = recomendacion8;}
    public void setRecomendacion9(String recomendacion9) {this.recomendacion9 = recomendacion9;}
    public void setRecomendacion10(String recomendacion10) {this.recomendacion10 = recomendacion10;}


    //public void setEquipo(int equipo ){ this.equipo=equipo; }
    //public void setOtros(String otros ){ this.otros=otros; }

    //Firmas/Nombre
    public void setFirmaTec(String firmaTec ){ this.firmaTec=firmaTec; }
    public void setFirmaResp(String firmaResp ){ this.firmaResp=firmaResp; }
    public void setFirmanteTec(String coor) {this.firmanteTec=coor;}
    public void setFirmanteResp(String jef) {this.firmanteResp=jef;}

}
