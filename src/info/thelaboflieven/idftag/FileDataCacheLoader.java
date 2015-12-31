/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.thelaboflieven.idftag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author lveeckha
 */
public class FileDataCacheLoader 
{
    public List<FileMetaData> load() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fos = new FileInputStream("cache.db");
        Object o;
        try (ObjectInputStream oos = new ObjectInputStream(fos)) {
            o = oos.readObject();
        }
        return (List<FileMetaData>)o;
    }
    
    public void save(final List<FileMetaData> data) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("cache.db");
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(data);
        }
    }
    
}
