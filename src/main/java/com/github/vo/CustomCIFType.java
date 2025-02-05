package com.github.vo;

public enum CustomCIFType {

    SOCIEDAD_ANONIMA("A", "A: Sociedad Anónima"),
    SOCIEDAD_DE_RESPONSABILIDAD_LIMITADA("B", "B: Sociedad de responsabilidad limitada"),
    SOCIEDAD_COLECTIVA( "C", "C: Sociedad colectiva"),
    SOCIEDAD_COMANDITARIA("D","D: Sociedad comanditaria"),
    COMUNIDAD_BIENES_HERENCIAS_YACENTES("E","E: Comunidad de bienes y herencias yacentes"),
    SOCIEDAD_COOPERATIVA("F","F: Sociedad cooperativa"),
    ASOCIACIONES("G","G: Asociaciones"),
    COMUNIDAD_PROPIETARIOS("H","H: Comunidad de propietarios en régimen de propiedad horizontal"),
    SOCIEDADES_CIVILES("J","J: Sociedades Civiles, con o sin personalidad jurídica"),
    FORMATO_K("K","K: Formato antiguo, en desuso"),
    FORMATO_L("L","L: Formato antiguo, en desuso"),
    FORMATO_M("M","M: Formato antiguo, en desuso"),
    ENTIDADES_EXTRANJERAS("N","N: Entidades extranjeras"),
    CORPORACION_LOCAL("P","P: Corporación local"),
    ORGANISMO_PUBLICO("Q","Q: Organismo públicos"),
    CONGREGACION_E_INSTITUCIONES_RELIGIOSAS("R","R: Congregaciones e Instituciones Religiosas"),
    ORGANOS_ADM_ESTADO_CCAA("S","S: Organos de la Administración del Estado y Comunidades Autónomas"),
    UNIONES_TEMPORALES("U","U: Uniones temporales de Empresas"),
    OTROS_TIPO("V","V: Otros tipos no definidos en el resto de claves"),
    ESTABLECIMIENTO_PERMANENTE("W","W: Establecimientos permanentes de entidades no residentes en España");

    private String letter;
    private String name;
    CustomCIFType(String letter, String name) {
        this.letter = letter;
        this.name = name;
    }

    public String getLetter(){
        return this.letter;
    }

    public String getName() {
        return this.name;
    }
}
