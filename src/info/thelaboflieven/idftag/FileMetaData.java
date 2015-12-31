/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.thelaboflieven.idftag;

import java.io.Serializable;

/**
 *
 * @author lveeckha
 */
public class FileMetaData implements Serializable 
{
    public String filename;
    public String path;
    public long size;
    public String tags;
    public String date;
}
