package in.hocg.squirrel.provider;

import in.hocg.squirrel.builder.XmlScripts;
import in.hocg.squirrel.metadata.ColumnUtility;
import in.hocg.squirrel.metadata.struct.Column;
import in.hocg.squirrel.metadata.struct.Table;
import in.hocg.squirrel.provider.AbstractProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.MappedStatement;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by hocgin on 2019-07-18.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
public class SelectAllProvider extends AbstractProvider {
    
    public SelectAllProvider(Class<?> mapperClass, Class<?> entityClass, Method method) {
        super(mapperClass, entityClass, method);
    }
    
    @Override
    public void build(MappedStatement statement) {
        
        Table table = getTable();
        
        List<Column> columns = getColumns();
        String[] columnNames = ColumnUtility.getColumnNames(columns);
        
        String sql = XmlScripts.script(
                XmlScripts.select(table.getTableName(), columnNames)
        );
        
        setSqlSource(statement, sql);
        
        setResultMaps(statement);
        
    }
}
