package redis;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/2/12.
 */
public interface IredisService {
    Set<String> cacheable(int key) throws Exception;
    String cacheEvict(int key) throws Exception;
    String cachePut(int key) throws Exception;
}
