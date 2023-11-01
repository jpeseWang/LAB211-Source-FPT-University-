
package FindAndCopyFILE.CopyFile.controller;

import model.FileData;
import repository.DataCopyRepository;
import repository.IDataCopyRepository;

public class DataCopyController {

    protected IDataCopyRepository repo;
    protected FileData data;

    public DataCopyController() {
        repo = new DataCopyRepository();
        data = new FileData();
    }

    public void run() {
        repo.dataCopy(data);
    }

}
