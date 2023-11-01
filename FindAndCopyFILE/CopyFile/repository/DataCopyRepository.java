
package FindAndCopyFILE.CopyFile.repository;

import dataAccess.DataCopyDao;
import model.FileData;

public class DataCopyRepository implements IDataCopyRepository {
    @Override
    public void dataCopy(FileData data) {
        DataCopyDao.Instance().dataCopy(data);
    }
}
