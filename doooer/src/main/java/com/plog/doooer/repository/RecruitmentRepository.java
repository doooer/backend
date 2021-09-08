package com.plog.doooer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.plog.doooer.domain.RecruitmentEntity;

@Repository
public interface RecruitmentRepository extends JpaRepository<RecruitmentEntity, Long>, PagingAndSortingRepository<RecruitmentEntity, Long> {
	//조회
	//단건 조회(상세)
	RecruitmentEntity findRecruitmentById(long Id);
	//단건 조회 - 키값 조회. max(Id)하고 싶어요ㅠㅠㅠ 흐규흐규흐귷그휴그휴흐규흐휴ㅜㄷㄱ
//	@Query("SELECT MAX(ID)+1 FROM TB_RECRUITMENT")
//	long findMaxId();
	
	//다건 조회 - 작성자 검색
	List<RecruitmentEntity> findByUserId(long userId);
	//다건 조회 - 글상태 검색
//	List<RecruitmentEntity> findByRctSt(String rctSt);
//	//다건 조회 - 제목 검색
	List<RecruitmentEntity> findByTitle(String title);
//	//다건 조회 -  검색
//	public List<RecruitmentEntity> findByWriter(String writer);
//	//다건 조회 - 작성자 검색
//	public List<RecruitmentEntity> findByWriter(String writer);
//	//조회 - 기본 다건, 찜순 정렬, 필터(상태, 제목, 모집시작일, 모집마감일, 모집직군, 모집지역);
	
	//어케 저장하누... 누눈누누눈누누
}
