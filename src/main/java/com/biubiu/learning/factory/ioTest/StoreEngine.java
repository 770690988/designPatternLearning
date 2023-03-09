package com.biubiu.learning.factory.ioTest;

/**
 * {@link StoreEngine}被定义为数据读写引擎，能够根据给定的key，找到指定的对象数据所在的位置。
 * 然后根据index找到指定的对象数据分片，进行读写操作
 *
 * @author RealDragonking
 */
public interface StoreEngine {

    /**
     * 获取到此节点存储空间中，单个分片的大小
     *
     * @return 单个分片的大小
     */
    long partitionSize();

    /**
     * 获取到此节点存储空间中，所有分片的数量
     *
     * @return 所有分片的数量
     */
    long partitionNumber();

    /**
     * 从指定的对象分片文件中读取分片数据
     *
     * @param bucketID 存储桶ID
     * @param objectID 对象ID
     * @param pieceID 分片ID
     * @param bytes byte数组
     * @return 读取了多少字节
     */
    int read(long bucketID, long objectID, long pieceID, byte[] bytes);

    /**
     * 向指定的对象分片文件中写入分片数据
     *
     * @param bucketID 存储桶ID
     * @param objectID 对象ID
     * @param pieceID 分片ID
     * @param bytes byte数组
     * @param len 写入的字节数量
     */
    void write(long bucketID, long objectID, long pieceID, byte[] bytes, int len);

}
