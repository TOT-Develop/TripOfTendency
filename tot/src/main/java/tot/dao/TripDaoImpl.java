package tot.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tot.domain.TripDTO;


@Repository
public class TripDaoImpl implements TripDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "tot.dao.TripDao";

    @Override
    public List<TripDTO> getTripsByMemId(String memId) {
        return sqlSession.selectList(NAMESPACE + ".getTripsByMemId", memId);
    }

    @Override
    public TripDTO getTripById(int tripId) {
        return sqlSession.selectOne(NAMESPACE + ".getTripById", tripId);
    }
}
