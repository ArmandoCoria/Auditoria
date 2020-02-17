package com.veolus.auditoria;

import java.util.List;

public class StoreServicioBCI {

    private String idUser;
    private String id;
    private String Fecha;
    private String FechaInicio;
    private String Fechafin;
    private String Sitio;
    private String Sector;
    private String Proyecto;
    private String Not;
    private String Asunto;
    private String Objetivo;
    private String Antecedentes;
    //private String firmanteTec;
    private String FirmaJFSitio;
    //private String firmanteResp;
    private String FirmaJFMtto;
    //private String Desarrollo;
    private String Conclusiones;
    /* private Boolean DejarFueraEquipo ;
    private Boolean Lotto ;
    private Boolean Aceite ;
    private Boolean FiltrosAire ;
    private Boolean FiltrosAceite ;
    private Boolean Baterias ;
    private Boolean TerminalesBaterias ;
    private Boolean Refrigerante ;
    private Boolean FiltrosRefrigerante ;
    private Boolean ManguerasPrecalentador ;*/
    private Boolean AprieteTerminalesControl ;
    private Boolean DesulfatarTerminalesBaterias ;
    private Boolean FugasAceiteAnticongelante ;
    private Boolean OperacionCargadorBaterias ;
    private Boolean OperacionPrecalentadores ;
    private Boolean SistemaLlenadoComb ;
    private Boolean TensionBateriaFlotacion ;
    //private Boolean CargadorBaterias ;
    private Boolean EstoperoImpulsor ;
    private Boolean TaponRadiador ;
    private Boolean PresionAceite ;
    private Boolean TempOperacion ;
    private Boolean Bandas ;
    private Boolean Mangueras ;
    private Boolean EventosEquipo ;
    private Boolean InspeccionEquipo ;
    private Boolean InspeccionPrecalentadores ;
    private Boolean InspeccionVisualNivelAceite ;
    private Boolean RuidosAnormales ;
    private Boolean AcoplamientoSello ;
    private Boolean Fugas ;
    private Boolean DensidadElectrolito ;
    private Boolean OperacionAlternador ;
    private Boolean BombaAutomatico ;
    /*private Boolean LimpiezaEquipo ;
    private Boolean LimpiezaRadiador ;*/
    private Boolean PruebaArranque ;
    private List<String> Fotos;
    private String Recomendaciones;
    private String Observaciones;
    private String Comentarios;
    private String Correo;
    private String Numero;
    private String NivelCombustibleTanqueDia;
    private String NivelCombustibleTanquePrincipal;
    private String NivelRefrigerante;
    private String NivelAceite;
    private String NivelElectrolito;
    private String VoltBaterias3Times;
    private String PorcentajeBaterias;
    private String LecturaHorometro;
    private String TiempoArranque;

    public List<String> fotos ;
    public void setIdUser(String user) {this.idUser = user; }
    public void setId(String id) {this.id = id; }
    public void setFecha(String fecha ){ this.Fecha=fecha; }
    public void setFechaInicio(String fechaInicio ){ this.FechaInicio=fechaInicio; }
    public void setFechafin(String fechafin ){ this.Fechafin=fechafin; }
    public void setSitio(String sitio ){ this.Sitio=sitio; }
    public void setProyecto(String proyecto ){ this.Proyecto=proyecto; }
    public void setSector(String sector ){ this.Sector=sector; }
    public void setNot(String not ){ this.Not=not; }
    public void setAsunto(String asunto ){ this.Asunto=asunto; }
    public void setObjetivo(String objetivo ){ this.Objetivo=objetivo; }
    public void setAntecedentes(String antecedentes ){ this.Antecedentes=antecedentes; }
    public void setFotos(List<String> fotos ){ this.fotos=fotos; }
    //public void setDesarrollo(String desarrollo){this.Desarrollo=desarrollo; }
    public void setConclusiones(String conclusiones){this.Conclusiones=conclusiones; }
    public void setRecomendaciones(String recomendaciones){this.Recomendaciones=recomendaciones; }
    public void setComentarios(String comentarios){this.Comentarios=comentarios; }
    public void setObservaciones(String observaciones){this.Observaciones=observaciones; }
    public void setCorreo(String correo){this.Correo=correo; }
    public void setNumero(String numero){this.Numero=numero; }
    //public void setFirmanteTec(String nametec){this.firmanteTec = nametec; }
    public void setFirmaJFSitio(String firmaTec ){ this.FirmaJFSitio=firmaTec; }
   // public void setFirmanteResp(String nameresp){this.firmanteResp = nameresp; }
    public void setFirmaJFMtto(String firmaResp ){ this.FirmaJFMtto=firmaResp; }
    /*public void setDejarFueraEquipo(Boolean dejarFueraEquipo){this.DejarFueraEquipo = dejarFueraEquipo;}
    public void setLotto(Boolean lotto){this.Lotto = lotto;}
    public void setAceite(Boolean aceite){this.Aceite = aceite;}
    public void setFiltrosAire(Boolean filtrosAceite){this.FiltrosAceite = filtrosAceite;}
    public void setBaterias(Boolean baterias){this.Baterias = baterias;}
    public void setTerminalesBaterias(Boolean terminalesBaterias){this.TerminalesBaterias = terminalesBaterias;}
    public void setRefrigerante(Boolean refrigerante){this.Refrigerante=refrigerante;}
    public void setFiltrosRefrigerante(Boolean filtrosRefrigerante){this.FiltrosRefrigerante = filtrosRefrigerante;}
    public void setManguerasPrecalentador(Boolean manguerasPrecalentador){this.ManguerasPrecalentador=manguerasPrecalentador;}*/
    public void setAprieteTerminalesControl(Boolean aprieteTerminalesControl){this.AprieteTerminalesControl = aprieteTerminalesControl;}
    public void setDesulfatarTerminalesBaterias(Boolean desulfatarTerminalesBaterias){this.DesulfatarTerminalesBaterias=desulfatarTerminalesBaterias;}
    public void setTensionBateriaFlotacion(Boolean tensionBateriaFlotacion){this.TensionBateriaFlotacion=tensionBateriaFlotacion;}
    public void setEstoperoImpulsor(Boolean estoperoImpulsor){this.EstoperoImpulsor=estoperoImpulsor;}
    public void setPresionAceite(Boolean presionAceite){this.PresionAceite = presionAceite;}
    public void setOperacionCargadorBaterias(Boolean operacionCargadorBaterias){this.OperacionCargadorBaterias = operacionCargadorBaterias;}
    public void setSistemaLlenadoComb(Boolean sistemaLlenadoComb){this.SistemaLlenadoComb=sistemaLlenadoComb;}
    public void setTaponRadiador(Boolean taponRadiador){this.TaponRadiador = taponRadiador;}
    public void setBandas(Boolean bandas){this.Bandas = bandas;}
    public void setMangueras(Boolean mangueras){this.Mangueras = mangueras;}
    public void setTempOperacion(Boolean tempOperacion){this.TempOperacion = tempOperacion;}
    public void setEventosEquipo(Boolean eventosEquipo){this.EventosEquipo = eventosEquipo;}
    public void setInspeccionVisualNivelAceite(Boolean inspeccionVisualNivelAceite){this.InspeccionVisualNivelAceite=inspeccionVisualNivelAceite;}
    public void setInspeccionEquipo(Boolean inspeccionEquipo){this.InspeccionEquipo = inspeccionEquipo;}
    public void setFugasAceiteAnticongelante(Boolean fugasAceiteAnticongelante){this.FugasAceiteAnticongelante=fugasAceiteAnticongelante;}
    public void setInspeccionPrecalentadores(Boolean inspeccionPrecalentadores){this.InspeccionPrecalentadores=inspeccionPrecalentadores;}
    public void setOperacionPrecalentadores(Boolean operacionPrecalentadores){this.OperacionPrecalentadores=operacionPrecalentadores;}
    public void setAcoplamientoSello(Boolean acoplamientoSello){this.AcoplamientoSello=acoplamientoSello;}
    public void setRuidosAnormales(Boolean ruidosAnormales){this.RuidosAnormales = ruidosAnormales;}
    public void setFugas(Boolean fugas){this.Fugas = fugas;}
    public void setDensidadElectrolito(Boolean densidadElectrolito){this.DensidadElectrolito = densidadElectrolito;}
    public void setOperacionAlternador(Boolean operacionAlternador){this.OperacionAlternador = operacionAlternador;}
    public void setBombaAutomatico(Boolean bombaAutomatico){this.BombaAutomatico=bombaAutomatico;}
    /*public void setLimpiezaEquipo(Boolean limpiezaEquipo){this.LimpiezaEquipo=limpiezaEquipo;}
    public void setLimpiezaRadiador(Boolean limpiezaRadiador){this.LimpiezaRadiador = limpiezaRadiador;}*/
    public void setPruebaArranque(Boolean pruebaArranque){this.PruebaArranque = pruebaArranque;}
    public void setNivelCombustibleTanqueDia(String nivelCombustibleTanqueDia){this.NivelCombustibleTanqueDia = nivelCombustibleTanqueDia;}
    public void setNivelCombustibleTanquePrincipal(String nivelCombustibleTanquePrincipal){this.NivelCombustibleTanquePrincipal = nivelCombustibleTanquePrincipal;}
    public void setNivelRefrigerante(String nivelRefrigerante){this.NivelRefrigerante = nivelRefrigerante;}
    public void setNivelAceite(String nivelAceite){this.NivelAceite = nivelAceite;}
    public void setNivelElectrolito(String nivelElectrolito){this.NivelElectrolito = nivelElectrolito;}
    public void setVoltBaterias3Times(String voltBaterias3Times){this.VoltBaterias3Times = voltBaterias3Times;}
    public void setPorcentajeBaterias(String porcentajeBaterias){this.PorcentajeBaterias = porcentajeBaterias;}
    public void setLecturaHorometro(String lecturaHorometro){this.LecturaHorometro = lecturaHorometro;}
    public void setTiempoArranque(String tiempoArranque){this.TiempoArranque = tiempoArranque;}
}
