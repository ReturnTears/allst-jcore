package com.allst.jcore.util;

/**
 * @author Hutu
 * @since 2023-03-26 下午 08:23
 */
public class IndiClassesPo {
    private String classesId;
    private String classesName;
    private String classesLevel;
    private String parentId;
    private String parentName;

    public IndiClassesPo() {
    }

    public IndiClassesPo(String parentName, String classesName) {
        this.parentName = parentName;
        this.classesName = classesName;
    }

    public IndiClassesPo(String classesId, String classesName, String classesLevel, String parentId) {
        this.classesId = classesId;
        this.classesName = classesName;
        this.classesLevel = classesLevel;
        this.parentId = parentId;
    }

    public static IndiClassesPo of() {
        return new IndiClassesPo();
    }

    public static IndiClassesPo of(String classesId, String classesName, String classesLevel, String parentId) {
        return new IndiClassesPo(classesId, classesName, classesLevel, parentId);
    }

    public static IndiClassesPo of(String parentName, String classesName) {
        return new IndiClassesPo(parentName, classesName);
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getClassesLevel() {
        return classesLevel;
    }

    public void setClassesLevel(String classesLevel) {
        this.classesLevel = classesLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "IndiClassesPo{" + "classesId='" + classesId + '\'' +
                ", classesName='" + classesName + '\'' +
                ", classesLevel='" + classesLevel + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
