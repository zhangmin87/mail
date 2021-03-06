package redis;

import dto.StudentGradeDTO;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Administrator on 2018/2/12.
 */
public interface IredisService {
    Set<StudentGradeDTO> cacheable(int key) throws Exception;
    String cacheEvict(int key) throws Exception;
    String cachePut(int key) throws Exception;
}
