package net.proselyte.collectioInjection;

import org.springframework.beans.factory.annotation.Required;

import java.util.*;

public class CollectionInjection {
    List documentList;
    Set documentSet;
    Map documentMap;
    Properties documentProp;

    public List getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List documentList) {
        this.documentList = documentList;
    }

    public Set getDocumentSet() {
        return documentSet;
    }

    public void setDocumentSet(Set documentSet) {
        this.documentSet = documentSet;
    }

    public Map getDocumentMap() {
        return documentMap;
    }

    public void setDocumentMap(Map documentMap) {
        this.documentMap = documentMap;
    }

    public Properties getDocumentProp() {
        return documentProp;
    }

    public void setDocumentProp(Properties documentProp) {
        this.documentProp = documentProp;
    }
}
