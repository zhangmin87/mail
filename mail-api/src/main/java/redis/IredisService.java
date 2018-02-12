package redis;

/**
 * Created by Administrator on 2018/2/12.
 */
public interface IredisService {
    public String cacheable(int key) throws Exception;
    public String cacheEvict(int key) throws Exception;
    public String cachePut(int key) throws Exception;
}
