package com.biubiu.learning.factory.ioTest;

import java.util.Map;

public class ObjectInfo {
    private String objectID;
    private Map<Integer,Long> pieceSize;

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public Map<Integer, Long> getPieceSize() {
        return pieceSize;
    }

    public void setPieceSize(Map<Integer, Long> pieceSize) {
        this.pieceSize = pieceSize;
    }
}
