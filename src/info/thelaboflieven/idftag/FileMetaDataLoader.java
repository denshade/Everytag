/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.thelaboflieven.idftag;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lveeckha
 */
public class FileMetaDataLoader {
    public List<FileMetaData> loadData(List<String> paths)
    {
        List<FileMetaData> data = new ArrayList<>();
        paths.stream().forEach((path) -> {
            data.addAll(loadDirectory(path));
        });
        return data;
    }
    private List<FileMetaData> loadDirectory(String path) 
    {
        List<FileMetaData> data = new ArrayList<>();
        File file = new File(path);
        try{
            for (File currentFile : file.listFiles())
            {
                if (currentFile.isDirectory()) {
                    data.addAll(loadDirectory(currentFile.getAbsolutePath()));  
                } 
                FileMetaData currentMeta =  new FileMetaData();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                currentMeta.date = sdf.format(currentFile.lastModified());
                currentMeta.filename = currentFile.getName();
                currentMeta.path = currentFile.getAbsolutePath();
                currentMeta.size = currentFile.length();
                data.add(currentMeta);
            } 
        } catch (NullPointerException npe)
        {
        }
        return data;
    }
}
