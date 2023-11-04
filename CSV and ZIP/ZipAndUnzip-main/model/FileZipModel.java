package model;

public class FileZipModel {
    private String pathSrc;
    private String pathCompress;
    private String fileZipName;

    public FileZipModel() {
    }

    public FileZipModel(String pathSrc, String pathCompress, String fileZipName) {
        this.pathSrc = pathSrc;
        this.pathCompress = pathCompress;
        this.fileZipName = fileZipName;
    }

    public String getPathSrc() {
        return pathSrc;
    }

    public void setPathSrc(String pathSrc) {
        this.pathSrc = pathSrc;
    }

    public String getPathCompress() {
        return pathCompress;
    }

    public void setPathCompress(String pathCompress) {
        this.pathCompress = pathCompress;
    }

    public String getFileZipName() {
        return fileZipName;
    }

    public void setFileZipName(String fileZipName) {
        this.fileZipName = fileZipName;
    }
    
    
}