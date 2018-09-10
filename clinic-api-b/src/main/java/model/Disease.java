package model;

import javax.persistence.*;

/**
 * Created by Duy on 8/6/18.
 */

@Entity
@Table(name = "disease")
public class Disease {

    @Column
    private String chapterCode;

    @Column
    private String chapterName;

    @Column
    private String groupCode;

    @Column
    private String groupName;

    @Column
    private String typeCode;

    @Column
    private String typeName;

    @Id
    @Column
    private String icd;

    @Column
    private String diseaseName;

    public String getIcd() {
        return icd;
    }

    public void setIcd(String icd) {
        this.icd = icd;
    }

//    public List<Visit> getVisits() {
//        return visits;
//    }
//
//    public void setVisits(List<Visit> visits) {
//        this.visits = visits;
//    }

    public String getChapterCode() {
        return chapterCode;
    }

    public void setChapterCode(String chapterCode) {
        this.chapterCode = chapterCode;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
}
