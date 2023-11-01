
package FindAndCopyFILE.CopyFile.dataAccess;

import common.Validation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import model.FileData;

public class DataCopyDao {

    private static DataCopyDao instance = null;
    private final Validation valid = new Validation();

    public static DataCopyDao Instance() {
        if (instance == null) {
            synchronized (DataCopyDao.class) {
                if (instance == null) {
                    instance = new DataCopyDao();
                }
            }
        }
        return instance;
    }

    public void dataCopy(FileData data) {
        readFileConfig(data);
        copyFile(data);
    }

    public boolean checkFileConfig(String copyFolder, String Path) {
        File f = new File(copyFolder);
        if (!f.isDirectory()) {
            System.out.println("Folder not exist");
            return false;
        }
        f = new File(Path);
        if (!f.isDirectory()) {
            if (f.mkdir()) {
                return true;
            } else {
                System.out.println("Fail to create path");
                return false;
            }
        }
        return true;
    }

    public void createFileConfig(FileData data) {
        data.setCopyFolder(valid.inputString("Copy Folder"));
        data.setDataType(valid.inputString("Data Type"));
        data.setPath(valid.inputString("Path"));
        if (!checkFileConfig(data.getCopyFolder(), data.getPath())) {
            System.out.println("System Shutdown...");
            System.exit(0);
        }
        Properties prop = new Properties();
        prop.setProperty("COPY_FOLDER", data.getCopyFolder());
        prop.setProperty("DATA_TYPE", data.getDataType());
        prop.setProperty("PATH", data.getPath());
        try {
            OutputStream output = new FileOutputStream("src\\config.properties");
            prop.store(output, null);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileConfig(FileData data) {
        try (InputStream input = new FileInputStream(("src\\config.properties"))) {
            Properties prop = new Properties();
            prop.load(input);
            data.setCopyFolder(prop.getProperty("COPY_FOLDER"));
            data.setDataType(prop.getProperty("DATA_TYPE"));
            data.setPath(prop.getProperty("PATH"));
            input.close();
        } catch (IOException e) {
            createFileConfig(data);
        }
    }

    public boolean checkPath(String[] match, String name) {
        for (String str : match) {
            if (str.isEmpty())
                continue;
            if (name.endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public void copyFile(FileData data) {
        try {
            File test = new File(data.getCopyFolder());
        } catch (NullPointerException e) {
            createFileConfig(data);
        }
        File f = new File(data.getCopyFolder());
        File[] files = f.listFiles();
        String[] str = data.getDataType().split("[^(\\.a-zA-Z)]|[\\..+\\..+]");
        for (File file : files) {
            if (file.isFile() && checkPath(str, file.getName())) {
                try {
                    File destination = new File(data.getPath(), file.getName());
                    Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}