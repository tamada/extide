package jp.cafebabe.extide.source;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class DataSourceBuilder {
    public DataSource build(Path target) throws IOException {
        BasicFileAttributes attributes = readAttributes(target);
        if(attributes.isDirectory())
            return new DirectoryDataSource(target);
        else if(attributes.isRegularFile())
            return buildFileDataSource(target);
        throw new IOException("unknown type of data source");
    }
    

    private BasicFileAttributes readAttributes(Path target) throws IOException {
        return target.getFileSystem()
                .provider()
                .readAttributes(target, BasicFileAttributes.class);
    }


    private DataSource buildFileDataSource(Path target) {
        if(target.endsWith(".jar") || target.endsWith(".zip"))
            return new ZipFsDataSource(target);
        return new RegularFileDataSource(target);
    }
}
