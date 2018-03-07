package redis;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Administrator on 2018/2/12.
 */
public interface IredisService {
    SortedSet<String> cacheable(int key) throws Exception;
    String cacheEvict(int key) throws Exception;
    String cachePut(int key) throws Exception;
}
