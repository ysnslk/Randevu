package com.randevu.constants;

public class RestApiList {
    /**
     * Projeler genellikle belli sunuculer ve belli portlar üzerinde çalışırlar.
     * Büyük projelerde ekipler ayrışır ve farklı ekipler farklı end pointler
     * ile istek atarlar. Bu ayrışmayı daha kontrollü yapmak için sabitleri yönetmek
     * iyi bir fikirdir.
     */

    public static final String API = "/api";

    public static final String VERSION = "/v1";

    public static final String RANDEVU = API+VERSION+"/randevu";

    public static final String SAVE ="/save";
    public static final String SAVEDTO = "savedto";

    public static final String UPDATE ="/update";
    public static final String DELETE ="/delete";
    public static final String BOSSAATLER ="/bosSaatler";
    public static final String FINDALL ="/findall";
    public static final String FINDBYID ="/findbyid";

}
