package com.fh.util;

public enum Common_Enum {
    PRO_TYPES("Pro_types","分类Redis"),
    PRO_AREA("Pro_area","地区Redis"),
    PRO_BRAND("Pro_brand","品牌Redis"),
    CAR_LIST("Car_List","用户前缀"),
    ;

    private String nameEH;
    private String nameCH;

    Common_Enum(String nameEH, String nameCH){
        this.nameEH=nameEH;
        this.nameCH=nameCH;
    }
    public String getNameEH() {
        return nameEH;
    }

    public void setNameEH(String nameEH) {
        this.nameEH = nameEH;
    }

    public String getNameCH() {
        return nameCH;
    }

    public void setNameCH(String nameCH) {
        this.nameCH = nameCH;
    }
}
