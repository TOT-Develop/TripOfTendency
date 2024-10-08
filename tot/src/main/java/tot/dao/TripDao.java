package tot.dao;

import java.util.List;
import java.util.Map;

import tot.domain.TripDTO;

public interface TripDao {

	// 특정 사용자의 모든 여행 목록 조회
	public abstract List<TripDTO> getTripsByMemIdWithPaging(Map<String, Object> params);

	public abstract List<TripDTO> getTripsByMemId(String memId);
	
	// 특정 여행 아이디에 대한 여행 정보 조회
	public abstract TripDTO getTripById(int tripId);

	public abstract int getTotalTripsByMemId(String memId);

	
}
