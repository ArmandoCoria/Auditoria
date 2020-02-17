package com.veolus.auditoria;



import java.util.List;

public class StoreFormServPem {

    private String idUser;
    private String id;
    private String FechaActual;
    private String FechaInicio;
    private String FechaFin;
    private String Sitio;
    private String Sector;
    private String Proyecto;
    private String NumOT;
    private String Asunto;
    private String Objetivo;
    private String Antecedentes;
    //private String Desarrollo;
   /* private Boolean DejarFueraEquipo;
    private Boolean Lotto;
    private Boolean Aceite;
    private Boolean FiltrosAceite;
    private Boolean Baterias;
    private Boolean TerminalesBaterias;
    private Boolean Refrigerante;
    private Boolean FiltrosRefrigerante;
    private Boolean FiltrosAire;
    private Boolean ManguerasPrecalentador;*/
    private Boolean AprieteTerminalesControl;
    private Boolean DesulfatarTerminalesBaterias;
    private Boolean CalibracionSensorVolt;
    private Boolean EstadoBaterias;
    private Boolean FrecuenciaGeneracion;
    private Boolean OperacionCargadorBaterias;
    private Boolean SistemaLlenadoComb;
    private Boolean TaponRadiador;
    private Boolean Bandas;
    private Boolean Mangueras;
    private Boolean OperacionTermostato;
    private Boolean SimulacionFallasEnergia;
    private Boolean InspeccionVisualNivelAceite;
    private Boolean DemandaCargaPlanta;
    private Boolean FugasAceiteAnticongelante;
    private Boolean NivelRefrigerante;
    private Boolean OperacionPrecalentadores;
    private Boolean TermostatoRefrigerante;
    private Boolean RuidosAnormales;
    private Boolean Fugas;
    private Boolean DensidadElectrolito;
    private Boolean OperacionAlternador;
    private Boolean VerTerminalesBaterias;
    /*private Boolean LimpiezaEquipo;
    private Boolean LimpiezaRadiador;*/
    private Boolean PruebaArranqueCarga;
    private String Observaciones;
    private Boolean PruebaArranqueCSCarga;
    private String Observaciones1;
    private Boolean PruebaArranqueVacioCarga;
    private Boolean SimularFallasVelocidad;
    private String NivelCombustibleTanqueDia;
    private String NivelCombustibleTanquePrincipal;
    private String NivelComb;
    private String NivelAceite;
    private String PresionAceite;
    private String NivelAgua;
    private String NivelElectrolito;
    private String TempreraturaOperacion;
    private String PorcentajeCargaAntesArranque;
    private String PorcentajeCargaBateria;
    private String VoltBateriaAlArranque;
    private String VoltBateriaStandBy;
    private String VoltAlternadorArrancar;
    private String VoltAlternadorStandBy;
    private String VoltGeneracion;
    private String TiempoEnfriamiento;
    private String TiempoTransferencia;
    private String TiempoRetransferencia;
    private String LecturaHorometro;
    private String MedicionCorrienteGeneracion;
    private String TiempoArranque;
    private String TiempoArranqueCSCarga;
    private String TiempoArranqueVacioCarga;
    private String ComentariosJefeMtto;
    private String Email;
    private String NumEquipoNav;
    private List<String> Fotos;
    private String FirmaJFSitio;
    private String FirmaJFMtto;
    private String Conclusiones;
    private String Recomendaciones;


    public void setIdUser(String user) {this.idUser = user; }
    public void setId(String id) {this.id = id; }
    public void setFechaActual(String fechaActual){this.FechaActual = fechaActual;}
    public void setFechaInicio(String fechaInicio) {this.FechaInicio = fechaInicio;}
    public void setFechaFin(String fechaFin) { this.FechaFin = fechaFin;}
    public void setSitio(String sitio){this.Sitio = sitio;}
    public void setSector(String sector){this.Sector = sector;}
    public void setProyecto(String proyecto){ this.Proyecto = proyecto;}
    public void setNumOT(String numOT){this.NumOT = numOT;}
    public void setAsunto(String asunto){this.Asunto = asunto;}
    public void setObjetivo(String objetivo){this.Objetivo=objetivo;}
    public void setAntecedentes(String antecedentes){this.Antecedentes = antecedentes;}
    //public void setDesarrollo(String desarrollo){this.Desarrollo=desarrollo;}
   /* public void setDejarFueraEquipo(Boolean dejarFueraEquipo){this.DejarFueraEquipo = dejarFueraEquipo;}
    public void setLotto(Boolean lotto){this.Lotto = lotto;}
    public void setAceite(Boolean aceite){this.Aceite = aceite;}
    public void setFiltrosAceite(Boolean filtrosAceite){this.FiltrosAceite = filtrosAceite;}
    public void setBaterias(Boolean baterias){this.Baterias = baterias;}
    public void setTerminalesBaterias(Boolean terminalesBaterias){this.TerminalesBaterias = terminalesBaterias;}
    public void setRefrigerante(Boolean refrigerante){this.Refrigerante=refrigerante;}
    public void setFiltrosRefrigerante(Boolean filtrosRefrigerante){this.FiltrosRefrigerante = filtrosRefrigerante;}
    public void setFiltrosAire(Boolean filtrosAire){this.FiltrosAire = filtrosAire;}
    public void setManguerasPrecalentador(Boolean manguerasPrecalentador){this.ManguerasPrecalentador=manguerasPrecalentador;}*/
    public void setAprieteTerminalesControl(Boolean aprieteTerminalesControl){this.AprieteTerminalesControl = aprieteTerminalesControl;}
    public void setDesulfatarTerminalesBaterias(Boolean desulfatarTerminalesBaterias){this.DesulfatarTerminalesBaterias=desulfatarTerminalesBaterias;}
    public void setCalibracionSensorVolt(Boolean calibracionSensorVolt){this.CalibracionSensorVolt=calibracionSensorVolt;}
    public void setEstadoBaterias(Boolean estadoBaterias){this.EstadoBaterias=estadoBaterias;}
    public void setFrecuenciaGeneracion(Boolean frecuenciaGeneracion){this.FrecuenciaGeneracion = frecuenciaGeneracion;}
    public void setOperacionCargadorBaterias(Boolean operacionCargadorBaterias){this.OperacionCargadorBaterias = operacionCargadorBaterias;}
    public void setSistemaLlenadoComb(Boolean sistemaLlenadoComb){this.SistemaLlenadoComb=sistemaLlenadoComb;}
    public void setTaponRadiador(Boolean taponRadiador){this.TaponRadiador = taponRadiador;}
    public void setBandas(Boolean bandas){this.Bandas = bandas;}
    public void setMangueras(Boolean mangueras){this.Mangueras = mangueras;}
    public void setOperacionTermostato(Boolean operacionTermostato){this.OperacionTermostato = operacionTermostato;}
    public void setSimulacionFallasEnergia(Boolean simulacionFallasEnergia){this.SimulacionFallasEnergia = simulacionFallasEnergia;}
    public void setInspeccionVisualNivelAceite(Boolean inspeccionVisualNivelAceite){this.InspeccionVisualNivelAceite=inspeccionVisualNivelAceite;}
    public void setDemandaCargaPlanta(Boolean demandaCargaPlanta){this.DemandaCargaPlanta = demandaCargaPlanta;}
    public void setFugasAceiteAnticongelante(Boolean fugasAceiteAnticongelante){this.FugasAceiteAnticongelante=fugasAceiteAnticongelante;}
    public void setNivelRefrigerante(Boolean nivelRefrigerante){this.NivelRefrigerante=nivelRefrigerante;}
    public void setOperacionPrecalentadores(Boolean operacionPrecalentadores){this.OperacionPrecalentadores=operacionPrecalentadores;}
    public void setTermostatoRefrigerante(Boolean termostatoRefrigerante){this.TermostatoRefrigerante=termostatoRefrigerante;}
    public void setRuidosAnormales(Boolean ruidosAnormales){this.RuidosAnormales = ruidosAnormales;}
    public void setFugas(Boolean fugas){this.Fugas = fugas;}
    public void setDensidadElectrolito(Boolean densidadElectrolito){this.DensidadElectrolito = densidadElectrolito;}
    public void setOperacionAlternador(Boolean operacionAlternador){this.OperacionAlternador = operacionAlternador;}
    public void setVerTerminalesBaterias(Boolean verTerminalesBaterias){this.VerTerminalesBaterias=verTerminalesBaterias;}
    /*public void setLimpiezaEquipo(Boolean limpiezaEquipo){this.LimpiezaEquipo=limpiezaEquipo;}
    public void setLimpiezaRadiador(Boolean limpiezaRadiador){this.LimpiezaRadiador = limpiezaRadiador;}*/
    public void setPruebaArranqueCarga(Boolean pruebaArranqueCarga){this.PruebaArranqueCarga = pruebaArranqueCarga;}
    public void setObservaciones(String observaciones){this.Observaciones=observaciones;}
    public void setPruebaArranqueCSCarga(Boolean pruebaArranqueCSCarga){this.PruebaArranqueCSCarga=pruebaArranqueCSCarga;}
    public void setObservaciones1(String observaciones1){this.Observaciones1 = observaciones1;}
    public void setPruebaArranqueVacioCarga(Boolean pruebaArranqueVacioCarga){this.PruebaArranqueVacioCarga= pruebaArranqueVacioCarga;}
    public void setSimularFallasVelocidad(Boolean simularFallasVelocidad){this.SimularFallasVelocidad = simularFallasVelocidad;}
    public void setComentariosJefeMtto(String comentariosJefeMtto){this.ComentariosJefeMtto=comentariosJefeMtto;}
    public void setEmail(String email){this.Email = email;}
    public void setNumEquipoNav(String numEquipoNav){this.NumEquipoNav=numEquipoNav;}
    public void setFotos(List<String> fotos ){ this.Fotos=fotos; }
    public void setFirmaJFSitio(String firmaJFSitio){this.FirmaJFSitio=firmaJFSitio;}
    public void setFirmaJFMtto(String firmaJFMtto){this.FirmaJFMtto=firmaJFMtto;}
    public void setConclusiones(String conclusiones){this.Conclusiones=conclusiones;}
    public void setRecomendaciones(String recomendaciones){this.Recomendaciones=recomendaciones;}
    public void setNivelCombustibleTanqueDia(String nivelCombustibleTanqueDia){this.NivelCombustibleTanqueDia = nivelCombustibleTanqueDia;}
    public void setNivelCombustibleTanquePrincipal(String nivelCombustibleTanquePrincipal){this.NivelCombustibleTanquePrincipal = nivelCombustibleTanquePrincipal;}
    public void setNivelComb(String nivelComb){this.NivelComb = nivelComb;}
    public void setPresionAceite(String presionAceite){this.PresionAceite = presionAceite;}
    public void setNivelAceite(String nivelAceite){this.NivelAceite = nivelAceite;}
    public void setNivelAgua(String nivelAgua){this.NivelAgua = nivelAgua;}
    public void setNivelElectrolito(String nivelElectrolito){this.NivelElectrolito = nivelElectrolito;}
    public void setTempreraturaOperacion(String tempreraturaOperacion){this.TempreraturaOperacion = tempreraturaOperacion;}
    public void setPorcentajeCargaAntesArranque(String porcentajeCargaAntesArranque){this.PorcentajeCargaAntesArranque=porcentajeCargaAntesArranque;}
    public void setPorcentajeCargaBateria(String porcentajeCargaBateria){this.PorcentajeCargaBateria = porcentajeCargaBateria;}
    public void setVoltBateriaAlArranque(String voltBateriaAlArranque){this.VoltBateriaAlArranque = voltBateriaAlArranque;}
    public void setVoltBateriaStandBy(String voltBateriaStandBy){this.VoltBateriaStandBy = voltBateriaStandBy;}
    public void setVoltAlternadorArrancar(String voltAlternadorArrancar){this.VoltAlternadorArrancar = voltAlternadorArrancar;}
    public void setVoltAlternadorStandBy(String voltAlternadorStandBy){this.VoltAlternadorStandBy = voltAlternadorStandBy;}
    public void setVoltGeneracion(String voltGeneracion){this.VoltGeneracion = voltGeneracion;}
    public void setTiempoEnfriamiento(String tiempoEnfriamiento){this.TiempoEnfriamiento = tiempoEnfriamiento;}
    public void setTiempoTransferencia(String tiempoTransferencia){this.TiempoTransferencia = tiempoTransferencia;}
    public void setTiempoRetransferencia(String tiempoRetransferencia){this.TiempoRetransferencia = tiempoRetransferencia;}
    public void setLecturaHorometro(String lecturaHorometro){this.LecturaHorometro = lecturaHorometro;}
    public void setMedicionCorrienteGeneracion(String medicionCorrienteGeneracion){this.MedicionCorrienteGeneracion = medicionCorrienteGeneracion;}
    public void setTiempoArranque(String tiempoArranque){this.TiempoArranque = tiempoArranque;}
    public void setTiempoArranqueCSCarga(String tiempoArranqueCSCarga){this.TiempoArranqueCSCarga = tiempoArranqueCSCarga;}
    public void setTiempoArranqueVacioCarga(String tiempoArranqueVacioCarga){this.TiempoArranqueVacioCarga = tiempoArranqueVacioCarga;}

}
