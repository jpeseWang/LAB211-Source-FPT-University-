
package FindAndCopyFILE.CopyFile.model;

public class FileData {
    private String copyFolder;
    private String dataType;
    private String path;

    public FileData() {
    }

    public FileData(String copyFolder, String dataType, String path) {
        this.copyFolder = copyFolder;
        this.dataType = dataType;
        this.path = path;
    }

    public String getCopyFolder() {
        return copyFolder;
    }

    public void setCopyFolder(String copyFolder) {
        this.copyFolder = copyFolder;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
