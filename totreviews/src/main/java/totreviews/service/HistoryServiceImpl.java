package totreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import totreviews.dao.HistoryDAO;
import totreviews.domain.HistoryVO;
import totreviews.exception.ServerException;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryDAO historyDAO;

	@Override
	public void insertTReviewHistory(HistoryVO historyVO) {
		try {
			historyDAO.insertTReviewHistory(historyVO);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 목록 가져오던 중 오류 발생", e);
		}
	}

}
