package com.oz.ozHouse.merchant.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Notice;
import com.oz.ozHouse.dto.NoticeDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor //final field, Not Null field에 대해 생성자 생성
public class MerNoticeRepositoryImpl implements MerNoticeRepository{
	
	private final EntityManager em;
	
	//공지사항 6개 출력
	@Override
    public List<Notice> simpleNotice(Pageable mainNotice) {
        return em.createQuery("SELECT n FROM Notice n ORDER BY n.noticeNum DESC", Notice.class)
                 .setMaxResults(mainNotice.getPageSize())
                 .setFirstResult((int) mainNotice.getOffset())
                 .getResultList();
    }

	//공지사항 상세보기
	@Override
	public NoticeDTO detailNotice(int noticeNum) {
		TypedQuery<Notice> notice = em.createQuery("SELECT n FROM Notice n WHERE n.noticeNum = :noticeNum", Notice.class)
				.setParameter("noticeNum", noticeNum);
	    
		Notice n = notice.getSingleResult();
		NoticeDTO dto = new NoticeDTO();
		dto = dto.toDTO(n);
		return dto;
	}

	//공지사항 목록 출력
	@Override
	public List<Notice> listNotice() {
		return em.createQuery("SELECT n FROM Notice n ORDER BY n.noticeNum DESC", Notice.class)
	             .getResultList();
	}

	//공지사항 검색
	@Override
	public List<Notice> findNotice(String noticeTitle) {
		return em.createQuery("SELECT n FROM Notice n WHERE n.noticeTitle LIKE :noticeTitle", Notice.class)
        .setParameter("noticeTitle", "%" + noticeTitle + "%")
        .getResultList();
	}

	//스토어관리 홈 공지사항
	@Override
	public List<Notice> storeNotice(Pageable storeNotice) {
        return em.createQuery("SELECT n FROM Notice n ORDER BY n.noticeNum DESC", Notice.class)
                .setMaxResults(storeNotice.getPageSize())
                .setFirstResult((int) storeNotice.getOffset())
                .getResultList();
   }
}
