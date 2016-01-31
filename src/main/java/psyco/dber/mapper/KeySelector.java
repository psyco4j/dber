package psyco.dber.mapper;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import psyco.dber.anno.Key;
import psyco.dber.exception.DberParsingRuntimException;

import java.util.List;

/**
 * Created by lipeng on 16/1/12.
 */
public class KeySelector {

    public String customSql;
    public List<String> properties;

    public KeySelector(Key key) {
        String s = key.customSql();
        if (StringUtils.isNotBlank(s)) {
            customSql = s.trim();
            if (!customSql.startsWith("$") & !customSql.startsWith("#"))
                throw DberParsingRuntimException.build("key selector must start with $ or #");
            properties = Lists.newArrayList(customSql.substring(1).split("\\."));
        }
    }

}
