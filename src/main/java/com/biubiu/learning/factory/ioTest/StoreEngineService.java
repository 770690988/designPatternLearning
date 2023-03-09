package com.biubiu.learning.factory.ioTest;


import java.io.*;

public class StoreEngineService implements StoreEngine{

    private String fileRootDir = "./";

    private BucketInfo bucketInfo;//桶信息

    private ObjectInfo objectInfo;//对象信息

    private Long pieceID;//分片编号

    public StoreEngineService(long bucketID){
        setBucketInfo(bucketID);
    }

    public StoreEngineService(long bucketID, long objectID){
        setBucketInfo(bucketID);
        setObjectInfo(objectID);
    }

    public StoreEngineService(long bucketID, long objectID, long pieceID){
        setBucketInfo(bucketID);
        setObjectInfo(objectID);
        setPieceID(pieceID);
    }

    @Override
    public long partitionSize() {
        if (objectInfo != null){
            return objectInfo.getPieceSize().get(pieceID);
        }
        throw new RuntimeException("File can't be found. objectInfo is null");
    }

    @Override
    public long partitionNumber() {
        if (objectInfo != null){
            return objectInfo.getPieceSize().size();
        }
        throw new RuntimeException("File can't be found. objectInfo is null");
    }

    @Override
    public int read(long bucketID, long objectID, long pieceID, byte[] bytes) {
        if (bucketInfo == null){
            throw new RuntimeException("File can't be found. bucketInfo is null");
        }
        if (objectInfo == null){
            throw new RuntimeException("File can't be found. objectInfo is null");
        }
        if (this.pieceID == null){
            throw new RuntimeException("File can't be found. pieceID is null");
        }
        File f = new File(fileRootDir+bucketID+"/"+objectID+"/"+pieceID);
        try {
            //创建一个流对象
            InputStream in = new FileInputStream(f);
            //读取数据，并将读取的数据存储到数组中
            int len = 0;
            int temp = 0;
            while((temp = in.read()) != -1){//循环读取数据，未到达流的末尾
                bytes[len] = (byte) temp;//将有效数据存储在数组中
                len ++;
            }
            return len;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void write(long bucketID, long objectID, long pieceID, byte[] bytes, int len) {
        if (bucketInfo == null){
            setBucketInfo(bucketID);
        }
        if (objectInfo == null){
            setObjectInfo(objectID);
        }
        File f = new File(fileRootDir+bucketID+"/"+objectID+"/"+pieceID);
        if (f.exists()){
            f.delete();
        }
        try{
            f.createNewFile();
            OutputStream out = new FileOutputStream(f);
            out.write(bytes);
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            e.printStackTrace();
        }
        //存放目录项
    }

    public void setBucketInfo(long bucketID) {
        File f = new File(fileRootDir+bucketID+".obj");
        if (!f.exists()){
            bucketInfo = null;
        }
        try{
            FileInputStream fis = new FileInputStream(fileRootDir+bucketID+".obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.bucketInfo = (BucketInfo) ois.readObject();
            ois.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        objectInfo = null;
        pieceID = null;
    }

    private void readBucketInfo() {

    }

    public void setObjectInfo(long objectID) {
        File f = new File(fileRootDir+bucketInfo.getBucketID()+"/"+objectID+".obj");
        if (!f.exists()){
            objectInfo = null;
        }
        try{
            FileInputStream fis = new FileInputStream(fileRootDir+bucketInfo.getBucketID()+"/"+objectID+".obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.objectInfo = (ObjectInfo) ois.readObject();
            ois.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        pieceID = null;
    }

    public void setPieceID(long pieceID) {
        this.pieceID = pieceID;
    }

    public boolean saveBucketInfo(){
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(fileRootDir+bucketInfo.getBucketID()+".obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bucketInfo);
            oos.flush();
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveObjectInfo(){
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(fileRootDir+bucketInfo.getBucketID()+"/"+objectInfo.getObjectID()+".obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bucketInfo);
            oos.flush();
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
